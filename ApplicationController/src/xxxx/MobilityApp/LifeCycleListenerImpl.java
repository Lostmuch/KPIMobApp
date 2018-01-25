package xxxx.MobilityApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.adfmf.application.LifeCycleListener;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.util.Utility;


/**
 * The application life cycle listener provides the basic structure for developers needing
 * to include their own functionality during the different stages of the application life
 * cycle.  Please note that there is <b>no user</b> associated with any of the following
 * methods.
 *
 * Common examples of functionality that might be added:
 *
 * start:
 *   1. determine if the application has updates
 *   2. determine if there already exists a local application database image
 *   3. setup any one time state for the application
 *
 * activate:
 *   1. read any application cache stores and re-populate state (if needed)
 *   2. establish/re-establish any database connections and cursors
 *   3. process any pending web-service requests
 *   4. obtain any required resources
 *
 * deactivate:
 *   1. write any restorable state to an application cache store
 *   2. close any database cursors and connections
 *   3. defer any pending web-service requests
 *   4. release held resources
 *
 * stop:
 *   1. logoff any remote services
 *
 * NOTE:
 * 1. In order for the system to recognize an application life cycle listener
 *    it must be registered in the maf-application.xml file.
 * 2. Application assemblers must implement this interface if they would like to
 *    receive notification of application start, hibernation, and application resume.
 *    If a secure web service is needed, you will need to do this from your 'default'
 *    feature where you will have an associated user.
 *
 * @see oracle.adfmf.application.LifeCycleListener
 */
public class LifeCycleListenerImpl implements LifeCycleListener {
    public LifeCycleListenerImpl() {

    }

    /**
     * The start method will be called at the start of the application.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     */
    public void start() {
        // Add code here...
        System.out.println("Lifecycle start");
        AdfmfJavaUtilities.setELValue("#{applicationScope.usercheck}", "No");
        AdfmfJavaUtilities.setELValue("#{applicationScope.pwdcheck}", "No");
        //    Added by Rohit -start
        AdfmfJavaUtilities.setELValue("#{applicationScope.rememberMe}", false);
        System.out.println("LifeCycleListenerImpl:rememberMe: " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.rememberMe}"));
        //    Added by Rohit -End
        // Add code here...
        try {
            initializeDatabaseFromScript();
        } catch (Exception e) {
            Utility.ApplicationLogger.severe(e.getMessage());
            throw new RuntimeException(e);
        }

        //  Adding by Rohit - calling below method to default user credentials
        System.out.println("LifeCycleListenerImpl: before calling defaultCredentials");
        defaultCredentials();
        System.out.println("LifeCycleListenerImpl: after calling defaultCredentials");
    }

    private void initializeDatabaseFromScript() throws Exception {
        InputStream scriptStream = null;
        Connection conn = null;

        try {
            // ApplicationDirectory returns the private read-write sandbox area
            // of the mobile device's file system that this application can access.
            // This is where the database is created
            String docRoot = AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.ApplicationDirectory);
            String dbName = docRoot + "/MobilityApp.db";

            // Verify whether or not the database exists.
            // If it does, then it has already been initialized
            // and no furher actions are required
            File dbFile = new File(dbName);
            if (dbFile.exists())
                return;

            // If the database does not exist, a new database is automatically
            // created when the SQLite JDBC connection is created
            conn = new SQLite.JDBCDataSource("jdbc:sqlite:" + docRoot + "/MobilityApp.db").getConnection();

            // To improve performance, the statements are executed
            // one at a time in the context of a single transaction
            conn.setAutoCommit(false);

            // Since the SQL script has been packaged as a resource within
            // the application, the getResourceAsStream method is used
            scriptStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/Logindb.sql");
            BufferedReader scriptReader = new BufferedReader(new InputStreamReader(scriptStream));
            String nextLine;
            StringBuffer nextStatement = new StringBuffer();

            // The while loop iterates over all the lines in the SQL script,
            // assembling them into valid SQL statements and executing them as
            // a terminating semicolon is encountered
            Statement stmt = conn.createStatement();
            while ((nextLine = scriptReader.readLine()) != null) {
                // Skipping blank lines, comments, and COMMIT statements
                if (nextLine.startsWith("REM") || nextLine.startsWith("COMMIT") || nextLine.length() < 1) {
                    continue;
                }

                nextStatement.append(nextLine);

                if (nextLine.endsWith(";")) {
                    stmt.execute(nextStatement.toString());
                    nextStatement = new StringBuffer();
                }
            }


        } finally {
            if (conn != null) {
                conn.commit();
                conn.close();
            }
        }
    }


    /**
     * The stop method will be called at the termination of the application.
     *
     * NOTE:
     * 1. Depending on how the application is being shutdown, this method may
     *    or may not be called. For example, if a user kills the Application from
     *    the iOS multitask UI then stop will not be called.  Because of this, each
     *    feature should save off their state in the deactivate handler.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     */
    public void stop() {
        // Add code here...
    }

    /**
     * The activate method will be called when the application is started (post
     * the start method) and when an application is resumed by the operating
     * system.  If the application supports checkpointing, this is a place where
     * the application should read the checkpoint information and resume the process.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     * 4. Once an application is activated, the visible feature's activate lifecycle
     *    method will be executed (if configured) post this method being called.
     */
    public void activate() {
        // Add code here...
    }

    /**
     * The deactivate method will be called as part of the application shutdown
     * process or when the application is being deactivated/hibernated by the
     * operating system.  This is the place where application developers would
     * write application checkpoint information in either a database or a "device
     * only" file so if the application is terminated while in the background
     * the application can resume the process when the application is reactivated.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     * 4. When an application is being deactivated, the visible feature's
     *    deactivate lifecycle method will be executed (if configured) prior to
     *    this method being called.
     */
    public void deactivate() {
        // Add code here...
    }

    //  Added by Rohit Agrawal for default the user credentials if checkbox is marked.
    private void defaultCredentials() {
        System.out.println("LifeCycleListenerImpl: defaultCredentials start");
        // Add event code here...
        String strUsername = null;
        String strPassword = null;
        String strRemCredentials = null;
        int count = 0;
        DBAdapter db1 = new DBAdapter();
        System.out.println("LifeCycleListenerImpl:After creating Object");
        try {
            System.out.println("LifeCycleListenerImpl:inside try1");
            ResultSet rs = null;
            try {
                System.out.println("LifeCycleListenerImpl:inside try2");
                rs = db1.executeQuery("SELECT USER_NAME,PASSWORD,REM_CREDENTIALS FROM LOGIN_INFO");
                System.out.println("LifeCycleListenerImpl:After resultset: " + rs);
            } catch (Exception e) {
                System.out.println("LifeCycleListenerImpl.Exception: " + e);
            }

            while (rs.next()) {
                count = count + 1;
                System.out.println("LifeCycleListenerImpl.count: " + count);
                strUsername = rs.getString("USER_NAME");
                System.out.println("LifeCycleListenerImpl.strUsername: " + strUsername);
                strPassword = rs.getString("PASSWORD");
                System.out.println("LifeCycleListenerImpl.strPassword: " + strPassword);
                strRemCredentials = rs.getString("REM_CREDENTIALS");
                System.out.println("LifeCycleListenerImpl.strRemCredentials: " + strRemCredentials);
            }
            if (count > 0) {
                System.out.println("LifeCycleListenerImpl.Data Exists");
                if (strRemCredentials != null && !strRemCredentials.equals("") && strRemCredentials.equals("Y")) {
                    System.out.println("LifeCycleListenerImpl.Inside If ");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.usercheck}", "Yes");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.pwdcheck}", "Yes");
                    System.out.println("username:" + AdfmfJavaUtilities.getELValue("#{applicationScope.username}"));
                    System.out.println("password:" + AdfmfJavaUtilities.getELValue("#{applicationScope.password}"));
                    System.out.println("rememberMe:" + AdfmfJavaUtilities.getELValue("#{applicationScope.rememberMe}"));

                    AdfmfJavaUtilities.setELValue("#{applicationScope.username}", strUsername);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.password}", strPassword);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.rememberMe}", true);
                } else {
                    System.out.println("LifeCycleListenerImpl.Inside else ");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.usercheck}", "No");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.pwdcheck}", "No");
                    System.out.println("username:" + AdfmfJavaUtilities.getELValue("#{applicationScope.username}"));
                    System.out.println("password:" + AdfmfJavaUtilities.getELValue("#{applicationScope.password}"));
                    System.out.println("rememberMe:" + AdfmfJavaUtilities.getELValue("#{applicationScope.rememberMe}"));

                    AdfmfJavaUtilities.setELValue("#{applicationScope.username}", "");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.password}", "");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.rememberMe}", false);
                }
            }

        } catch (SQLException e) {
            System.out.println("Exception ..." + e);
        }
        System.out.println("LifeCycleListenerImpl: defaultCredentials end");
        return;
    }
}
