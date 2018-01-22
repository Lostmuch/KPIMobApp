package xxxx.mobile.service;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import xxxx.mobile.utility.RestServiceUtil;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.MobilityApp.DBAdapter;

import xxxx.mobile.EditKpiControl;
import xxxx.mobile.KPIObject;
import xxxx.mobile.ResultControl;

public class LoginService{
    ArrayList<KPIObject> kpis = new ArrayList<KPIObject>();
    SubmitService ss = new SubmitService();
    EditKpiControl ec = new EditKpiControl();
    private String userName;


    public LoginService() {
        super();
    }

    public Boolean validateLogin() 
    {
        /*
        System.out.println("INSIDE validateLogin");
        final String connectionName = "ResultWS";
        String username = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
        String password = AdfmfJavaUtilities.getELValue("#{pageFlowScope.password}").toString();
        String requestURI = "/Session_Check_Report/" + username + "/" + password + "/9999999";
        System.out.println("loginuri:" + requestURI);
        String authenticate = "";

        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        System.out.println("jsonArrayAsString : "+jsonArrayAsString);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            System.out.println("IN TRY");
            if (jsonObject.getString("PARAM1") != null) {
                System.out.println("ENTERING IF");
                authenticate = jsonObject.getString("PARAM1");
                System.out.println("Authenticate"+authenticate);
            }
        } catch (JSONException jsone) 
        {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        if (authenticate.equals("1"))
        return true;
        else 
        return false;*/
        return true;
    }

    public ResultSet checkUserExists(String username) 
    {
        DBAdapter db1 = new DBAdapter();
        System.out.println("After creating Object");
        ResultSet rs = null;
           try {
                   System.out.println("username inside try.."+username);
                   rs = db1.executeQuery("SELECT USER_NAME,ORG_VALUE,PRIORITY,REPORT_NAME,BU_NAME,LEGAL_ENITY FROM Login_Details WHERE USER_NAME = '"+username+"'");
                   System.out.println("After resultset............."+rs);
                   System.out.println("Inside Try...");
           }
           catch(Exception e) 
           {
               System.out.println("Exception ..."+e);   
           }
           return rs;
    }
    
    public void getAPSupplierDetails(ResultSet rs) 
    {
        KPIObject obj = new KPIObject();
        
        String requestURI = null;
        String actual_value = null;
        try
        {
        obj.setPriority(rs.getInt("PRIORITY"));
        obj.setOrg_value(rs.getString("ORG_VALUE"));
        obj.setReport_name(rs.getString("REPORT_NAME"));
        
           requestURI =
               "/" + rs.getString("REPORT_NAME") + "/" + "CURRENT" + "/" + rs.getString("ORG_VALUE") + "/" +
               "999";
           
           actual_value = ss.getOutputValue(requestURI);
           System.out.println("Actual Value ...................actual_value."+actual_value);
        
        obj.setActual_value(actual_value);
        kpis.add(obj);
        
        }catch(Exception e) 
        {
            System.out.println("Exception e");
        }
        
        
        System.out.println("After Creating EC Object");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.resultAPSupprend}", "true");
        ec.setResultAPSupprend(true);
        System.out.println("Value AP Rend............"+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.resultAPSupprend}"));
        
    }
    
    public void getARDisputeDetails(ResultSet rs)
    {
        try
        {
            System.out.println("Inside getARDispute deatils");
            KPIObject obj = new KPIObject();
            String actual_value = null;
            obj.setPriority(rs.getInt("PRIORITY"));
            obj.setOrg_value(rs.getString("ORG_VALUE"));
            obj.setReport_name(rs.getString("REPORT_NAME"));
            obj.setBu_name(rs.getString("BU_NAME"));
            obj.setLe_name(rs.getString("LEGAL_ENITY"));
            String requestURI =  "/" + rs.getString("REPORT_NAME") + "/" + "CURRENT"  + "/" + rs.getString("BU_NAME")  + "/" + rs.getString("LEGAL_ENITY");
            actual_value = ss.getOutputValue(requestURI);

            System.out.println("IN AR Actual Value ...................actual_value."+actual_value);
            
            obj.setActual_value(actual_value);
            kpis.add(obj);
            System.out.println("After Creating EC Object");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.resultDisCusRend}", "true");
            ec.setPayablesrend(true);
            System.out.println("Value AP Rend............"+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.resultDisCusRend}"));
        }catch(Exception e) 
        {
            System.out.println("Exception..."+e);
        }
    }
    
    //Total Pending Amount Report
    public void getPendAmtReport(ResultSet rs)
    {
        try
        {
            System.out.println("Inside getPendAmtReport deatils");
            KPIObject obj = new KPIObject();
            String actual_value = null;
            obj.setPriority(rs.getInt("PRIORITY"));
            obj.setOrg_value(rs.getString("ORG_VALUE"));
            obj.setReport_name(rs.getString("REPORT_NAME"));
            obj.setBu_name(rs.getString("BU_NAME"));
            obj.setLe_name(rs.getString("LEGAL_ENITY"));
            String requestURI =  "/" + rs.getString("REPORT_NAME") + "/" + "CURRENT"  + "/" + rs.getString("BU_NAME")  + "/" + rs.getString("LEGAL_ENITY");
            actual_value = ss.getOutputValue(requestURI);

            System.out.println("IN getPendAmtReport Actual Value ...................getPendAmtReport."+actual_value);
            
            obj.setActual_value(actual_value);
            kpis.add(obj);
            System.out.println("After Creating EC Object getPendAmtReport");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.resultPenCusRend}", "true");
            ec.setResultPenCusRend(true);
            System.out.println("getPendAmtReport Value AP Rend............"+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.resultPenCusRend}"));
        }catch(Exception e) 
        {
            System.out.println("Exception..."+e);
        }
    }
    
    //Total_po_backlog_amount
    public void getPOBackLog(ResultSet rs)
    {
        try
        {
            System.out.println("Inside getPOBackLog deatils");
            KPIObject obj = new KPIObject();
            String actual_value = null;
            obj.setPriority(rs.getInt("PRIORITY"));
            obj.setOrg_value(rs.getString("ORG_VALUE"));
            obj.setReport_name(rs.getString("REPORT_NAME"));
            obj.setBu_name(rs.getString("BU_NAME"));
            obj.setLe_name(rs.getString("LEGAL_ENITY"));
            String requestURI =  "/" + rs.getString("REPORT_NAME") + "/" + rs.getString("BU_NAME")  + "/" + "999" + "/" + "999";
            actual_value = ss.getOutputValue(requestURI);
            System.out.println("IN getPOBackLog Actual Value ...................getPOBackLog."+actual_value);
            obj.setActual_value(actual_value);
            kpis.add(obj);
            System.out.println("After Creating EC Object getPOBackLog");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.resultPOBacLogRend}", "true");
            ec.setResultPOBacLogRend(true);
            System.out.println("getPOBackLog Value AP Rend............"+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.resultPOBacLogRend}"));
        }catch(Exception e) 
        {
            System.out.println("Exception..."+e);
        }
    }
    
    public String getLoginCount() 
    {
        // Add event code here...
        String username = null;
        int count = 0;
        System.out.println("Inside getLoginCount");
        System.out.println("Value username .."+AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}"));
        System.out.println("Value of username......"+AdfmfJavaUtilities.getELValue("#{applicationScope.LoginBean.userName}"));
        if(AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}")!=null)
        {
            
            username = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
            System.out.println("INside if..."+username);
        }   
        
         System.out.println("AFter Username");
         DBAdapter db1 = new DBAdapter();
         System.out.println("After creating Object");
            try {
                    System.out.println("username inside try.."+username);
                   // ResultSet rs = db1.executeQuery("SELECT USER_NAME,ORG_VALUE,PRIORITY,REPORT_NAME FROM Login_Details WHERE USER_NAME = '"+username+"'");
                    ResultSet rs = checkUserExists(username);
                    System.out.println("After resultset............."+rs);
                    System.out.println("Inside Try...");
                    String requestURI = null;
                    String actual_value = null;
                    while (rs.next()) 
                    {
                        count = count + 1;
                        System.out.println("Data Exists");
                        String org_value = rs.getString("ORG_VALUE");
                        System.out.println("ORG VALUE NEW.."+org_value);
                        int pri_val = rs.getInt("PRIORITY");//PRIORITY
                        System.out.println("pri_val..."+pri_val);
                        SubmitService ss = new SubmitService();
                        if("AP_Total_Supplier_Balances_Report".equalsIgnoreCase(rs.getString("REPORT_NAME")))
                        {
                            System.out.println("Inside  AP_Total_Supplier_Balances_Report");
                            getAPSupplierDetails(rs);
                       }
                        if ("AR_Total_Dispute_Amount_Report".equalsIgnoreCase(rs.getString("REPORT_NAME"))) 
                        {
                            System.out.println("Inside  AR_Total_Dispute_Amount_Report");
                            getARDisputeDetails(rs);
                            
                        }
                       if ("AR_Total_Pending_Amount_Report".equalsIgnoreCase(rs.getString("REPORT_NAME"))) 
                       {
                           System.out.println("Inside  AR_Total_Pending_Amount_Report");
                           getPendAmtReport(rs);
                      }
                       if ("Total_po_backlog_amount".equalsIgnoreCase(rs.getString("REPORT_NAME"))) 
                       {
                           System.out.println("Inside  Total_po_backlog_amount");
                           getPendAmtReport(rs);
                       }
                       
                       
                        
                   }   
                 if(count > 0)
                 {
                     AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.kpis}", kpis);
                     System.out.println("Kpis new values**********.........."+kpis);
                     //AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}")
                     //AdfmfJavaUtilities.setELValue("#{applicationScope.LoginBean.userName}", userName);   
                     return "callResult";
                 }
                        
                    
             } catch (SQLException e) 
        {
             System.out.println("Exception ..."+e);   
        } 
        ResultControl rc = new ResultControl();
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.priority}","99");
        System.out.println("Priority value...");
        rc.resultDefaultKpi(); 

        return "callResult";
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
