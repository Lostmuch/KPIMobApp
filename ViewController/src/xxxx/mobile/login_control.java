package xxxx.mobile;

import java.sql.ResultSet;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

import xxxx.MobilityApp.DBAdapter;

import xxxx.mobile.service.LoginService;


public class login_control {

    private boolean validated = false;

    public login_control() {
    }

    public void rememberMeChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //        AdfmfJavaUtilities.setELValue("#{pageFlowScope.rememberMe}", valueChangeEvent.getNewValue());         // commented by Rohit
        //        Added by Rohit A
        System.out.println("login_control:rememberMeChanged: Start");
        System.out.println("valueChangeEvent.getNewValue(): " + valueChangeEvent.getNewValue());
        AdfmfJavaUtilities.setELValue("#{applicationScope.rememberMe}", valueChangeEvent.getNewValue());
        System.out.println("login_control:rememberMe: " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.rememberMe}"));
        System.out.println("login_control:rememberMeChanged: End");
    }

    public void usernameChanged(ValueChangeEvent valueChangeEvent) {
        AdfmfJavaUtilities.setELValue("#{applicationScope.usercheck}", "Yes");
        //        AdfmfJavaUtilities.setELValue("#{pageFlowScope.username}", valueChangeEvent.getNewValue());               // commented by Rohit
        AdfmfJavaUtilities.setELValue("#{applicationScope.username}", valueChangeEvent.getNewValue());
    }

    public void passwordChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{applicationScope.pwdcheck}", "Yes");
        //        AdfmfJavaUtilities.setELValue("#{pageFlowScope.password}", valueChangeEvent.getNewValue());               // commented by Rohit
        AdfmfJavaUtilities.setELValue("#{applicationScope.password}", valueChangeEvent.getNewValue());
    }

    public void loginButtonClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("loginButtonClick start");
        String usercheck = AdfmfJavaUtilities.getELValue("#{applicationScope.usercheck}").toString();
        String pwdcheck = AdfmfJavaUtilities.getELValue("#{applicationScope.pwdcheck}").toString();
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "");
        System.out.println("usercheck:" + usercheck);
        System.out.println("pwdcheck:" + pwdcheck);
        this.validated = false;
        if (usercheck.equals("Yes") && pwdcheck.equals("Yes")) {

            // commented by Rohit
            //            String userName = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
            //            String password = AdfmfJavaUtilities.getELValue("#{pageFlowScope.password}").toString();
            //Added by Rohit
            String userName = AdfmfJavaUtilities.getELValue("#{applicationScope.username}").toString();
            String password = AdfmfJavaUtilities.getELValue("#{applicationScope.password}").toString();

            System.out.println("username:" + userName);
            System.out.println("password:" + password);

            LoginService loginservice = new LoginService();
            //if (userName.equals("admin") && password.equals("password")) {
            if (loginservice.validateLogin()) {
                System.out.println("valid:");
                this.validated = true;

            } else if (!userName.equals("") && !password.equals("")) {
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Invalid Credentials Provided.");
            } else if (password.equals("") && userName.equals(""))
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
            else if (userName.equals(""))
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username");
            else if (password.equals(""))
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Password");

        } else if (usercheck.equals("No") && pwdcheck.equals("No")) {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
        } else if (usercheck.equals("No")) {

            //String password = AdfmfJavaUtilities.getELValue("#{pageFlowScope.password}").toString(); // commented by Rohit
            String password =
                AdfmfJavaUtilities.getELValue("#{applicationScope.password}").toString(); // Changed the pageFlowScope >> applicationScope
            if (!password.equals(""))
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username");
            else
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
        } else if (pwdcheck.equals("No")) {
            //String userName = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString(); // commented by Rohit
            String userName =
                AdfmfJavaUtilities.getELValue("#{applicationScope.username}").toString(); //// Changed the pageFlowScope >> applicationScope

            if (!userName.equals("")) {
                System.out.println("Inside username if condition");
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Password");
            } else {
                System.out.println("Inside username else condition");
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
            }
        }

        //        Adding by Rohit - calling below method to insert user credentials on Login button click
        System.out.println("login_control:Calling populateLoginInfo");
        populateLoginInfo();
        System.out.println("login_control: After Calling populateLoginInfo");

        System.out.println("LoginIn_buttonClick end........." +
                           AdfmfJavaUtilities.getELValue("#{pageFlowScope.loginMessage}"));
        // AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "");
    }

    public String loginNav() {
        // Add event code here...
        System.out.println("login Page Navigation start");
        String pageNav;

        if (this.validated) {

            pageNav = "showHome";
            System.out.println("validated true");
        } else {
            pageNav = null;
        }
        System.out.println("landingNavigation end");
        return pageNav;
    }

    //Added by Rohit Agrawal for Inserting new record into Login_Info table.
    public void populateLoginInfo() {
        System.out.println("login_control: populateLoginInfo Start");

        DBAdapter db1 = new DBAdapter();
        String strUsername = null;
        String strPassword = null;
        Boolean blnRemCredentials = false;
        String strRemCred = "N";
        String strRemCredentials = null;
        int count = 0;
        String strQueryStmt = null;
        strUsername = AdfmfJavaUtilities.getELValue("#{applicationScope.username}").toString();
        System.out.println("strUsername: " + strUsername);
        strPassword = AdfmfJavaUtilities.getELValue("#{applicationScope.password}").toString();
        System.out.println("strPassword: " + strPassword);
        blnRemCredentials = (Boolean) AdfmfJavaUtilities.getELValue("#{applicationScope.rememberMe}");
        System.out.println("blnRemCredentials: " + blnRemCredentials);

        if (blnRemCredentials != null && blnRemCredentials) {
            strRemCred = "Y";
        } else {
            strRemCred = "N";
        }
        System.out.println("strRemCred: " + strRemCred);

        try {
            System.out.println("Inside try");
            ResultSet rs =
                db1.executeQuery("SELECT USER_NAME,PASSWORD,REM_CREDENTIALS FROM LOGIN_INFO WHERE USER_NAME='" +
                                 strUsername + "' AND PASSWORD='" + strPassword + "'");
            System.out.println("After resultset............." + rs);


            while (rs.next()) {
                count = count + 1;

                strRemCredentials = rs.getString("REM_CREDENTIALS");
                System.out.println("strRemCredentials: " + strRemCredentials);
            }
            System.out.println("count: " + count);
            if (count > 0) {
                if (strRemCredentials != null && !strRemCredentials.equals(strRemCred)) {
                    System.out.println("login_control.Data Exists");
                    strQueryStmt =
                        "UPDATE LOGIN_INFO SET USER_NAME= '" + strUsername + "' , PASSWORD='" + strPassword +
                        "' , REM_CREDENTIALS='" + strRemCred + "'";
                    db1.executeUpdate(strQueryStmt);
                }
            } else {
                System.out.println("Before Insert query");
                strQueryStmt = "Delete from LOGIN_INFO";
                db1.executeUpdate(strQueryStmt);
                strQueryStmt =
                    "INSERT INTO LOGIN_INFO (USER_NAME,PASSWORD,REM_CREDENTIALS) VALUES ('" + strUsername + "','" +
                    strPassword + "','" + strRemCred + "')";
                db1.executeUpdate(strQueryStmt);
            }


        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

        System.out.println("login_control: populateLoginInfo end");
    }
}
