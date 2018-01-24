package xxxx.MobilityApp;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.adfmf.util.Utility;

public class DBAdapter 
{
    public DBAdapter() 
    {
        super();
    }
    public ResultSet executeQuery(String query) 
    {
        ResultSet result = null;
          Connection conn = null;
          Statement stmt = null;
        System.out.println("Inside execute QUery");
        System.out.println("Query Value...."+query);
        try 
        {
          System.out.println("Inside try");
          conn = DBConnectionFactory.getConnection();
          stmt = conn.createStatement();
          result = stmt.executeQuery(query);
          System.out.println("Result value........."+result);  
           //conn.commit();
       } catch (Exception ex) 
        {
            System.out.println("Inside catch");
          Utility.ApplicationLogger.severe(ex.getMessage());
          ex.printStackTrace();
          throw new RuntimeException(ex);

        } finally 
        {
          System.out.println("Inside finally");
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
         DBConnectionFactory.commitConnection();
         DBConnectionFactory.closeConnection();
        }

        return result;
      }
    
    public boolean executeUpdate(String query) {
        boolean success = false;

        try {
          Connection conn = DBConnectionFactory.getConnection();
          Statement stmt = conn.createStatement();
          int rowCount = stmt.executeUpdate(query);

          if (rowCount > 0) 
          {
            success = true;
            System.out.println("row updated/inserted");
            Utility.ApplicationLogger.severe("RowCount=" + rowCount + ", Query=" + query);
              conn.commit();
          }

        } catch (Exception e) {
          Utility.ApplicationLogger.severe(e.getMessage());
          e.printStackTrace();
          throw new RuntimeException(e);

        } finally {
          DBConnectionFactory.closeConnection();
        }

        return success;
      }
}
