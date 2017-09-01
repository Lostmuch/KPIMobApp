package xxxx.mobile.service;


import java.util.ArrayList;

import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.json.JSONArray;


import xxxx.mobile.GenericObject;

import xxxx.mobile.utility.RestServiceUtil;

public class ReportService {
    public ReportService() {
        super();
    }

    public String getOutputValue(String p_requestURI) {
        System.out.println("INSIDE getOutputValue");
        final String connectionName = "RestMultiOutput";

        //String requestURI = "/Session_Check_Report/" + username + "/" + password + "/9999999";
        //String requestURI = "/ShippedOrder_Report/YTD/Global/9999999";
        /*
     * http://192.168.73.2:7101/test_rp_102-FusionReportsIntegration-context-root/resources/SCCloudReportService/result/Top_10_Suppliers_by_AP_Balances_Report/GLOBAL/YTD/999999/99/99*/
        String requestURI = p_requestURI;
        System.out.println("Report URI : " + requestURI);
        String OutputValue = "";

        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        System.out.println("jsonArrayAsString : " + jsonArrayAsString);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            System.out.println("IN TRY");
            if (jsonObject.toString().equals("{}")) {
                System.out.println("No data found in rpeort");
                OutputValue = "0";
            } else //if (jsonObject.has("PARAM1"))
            {
                System.out.println("ENTERING IF");
                OutputValue = jsonObject.getString("record");
                System.out.println("OutputValue :" + OutputValue);
            }
            System.out.println("json value fetched");
            /*
        if (jsonObject.getString("PARAM1") != null) {
            System.out.println("ENTERING IF");
            OutputValue = jsonObject.getString("PARAM1");
            System.out.println("OutputValue "+OutputValue);
        }
    */

            try {
                JSONObject jsonObj = new JSONObject(jsonArrayAsString);

                // read json array
                System.out.println("in getArrayString");

                JSONArray arrObj = jsonObj.getJSONArray("record");

                System.out.println("Record Size :" + arrObj.length());
                int i;
                for (i = 0; i < arrObj.length(); i++) {
                    System.out.println("Value at " + i + " is :" + arrObj.getString(i));
                }

            } catch (JSONException e) {
                System.out.println("Exception occured :");
            }
        } catch (JSONException jsone) {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        return jsonArrayAsString;
    }

    public ArrayList<GenericObject> getArrayListValue(String p_jsonArray) 
    {

        // Create JsonReader from Json.
        // JsonReader reader = Json.createReader(p_jsonArray);
        // Get the JsonObject structure from JsonReader.
        //  JsonObject empObj = reader.readObject();
        //  reader.close();
        // read string data
        ArrayList<GenericObject> genericTable;
        genericTable = new ArrayList<GenericObject>();
        
        

        try 
        {
            JSONObject jsonObj = new JSONObject(p_jsonArray);

            // read json array
            System.out.println("in getArrayString");

            JSONArray arrObj = jsonObj.getJSONArray("record");


            System.out.println("Record Size :" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) 
            {
                GenericObject obj =new GenericObject();
                System.out.println("Value for postion i " + i + " is :" + arrObj.getString(i));
                //String temp_val = arrObj.getString(i);
                System.out.println("PAram 1 cha value "+arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("PAram 2 cha value "+arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                genericTable.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop "+genericTable);
            }
           
            System.out.println("Arraylist Value genericTable afetr loop "+genericTable);
            
        } catch (JSONException e) 
        {
            System.out.println("Exception occureed");
        }
        System.out.println("Before retrn");
        return genericTable;

    }
}
