package xxxx.mobile.service;


import xxxx.mobile.utility.RestServiceUtil;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;


public class LoginService {
    public LoginService() {
        super();
    }

    public Boolean validateLogin() {
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
        return false;
    }
}