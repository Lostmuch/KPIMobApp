package xxxx.mobile.service;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.utility.RestServiceUtil;

public class SubmitService {
    public SubmitService() {
        super();
    }
    //public String getOutputValue(String p_requestURI) {
        public String getOutputValue(String p_requestURI) {
        System.out.println("INSIDE getOutputValue");
        final String connectionName = "ResultWS";
        
        //String requestURI = "/Session_Check_Report/" + username + "/" + password + "/9999999";
        //String requestURI = "/ShippedOrder_Report/YTD/Global/9999999";
        String requestURI = p_requestURI;
        System.out.println("Report URI : " + requestURI);
        String OutputValue ="" ;

        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        System.out.println("jsonArrayAsString : "+jsonArrayAsString);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            System.out.println("IN TRY");
            if (jsonObject.toString().equals("{}")) {
                  System.out.println("No data found in rpeort");
                OutputValue = "0";
            }
            else //if (jsonObject.has("PARAM1"))
            {
                System.out.println("ENTERING IF");
                OutputValue = jsonObject.getString("PARAM1");
                System.out.println("OutputValue "+OutputValue);
            }
            System.out.println("json value fetched");
            /*
            if (jsonObject.getString("PARAM1") != null) {
                System.out.println("ENTERING IF");
                OutputValue = jsonObject.getString("PARAM1");
                System.out.println("OutputValue "+OutputValue);
            }
*/
        } catch (JSONException jsone) {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        return OutputValue;
    }
}
