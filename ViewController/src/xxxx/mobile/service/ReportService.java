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

    public ArrayList<GenericObject> getArrayListValue(String p_jsonArray) {

        // Create JsonReader from Json.
        // JsonReader reader = Json.createReader(p_jsonArray);
        // Get the JsonObject structure from JsonReader.
        //  JsonObject empObj = reader.readObject();
        //  reader.close();
        // read string data
        ArrayList<GenericObject> genericTable;
        genericTable = new ArrayList<GenericObject>();

        try {
            JSONObject jsonObj = new JSONObject(p_jsonArray);

            // read json array
            System.out.println("in getArrayString");

            JSONArray arrObj = jsonObj.getJSONArray("record");


            System.out.println("Record Size :" + arrObj.length());
            int i;
            for (i = 0; i <= arrObj.length(); i++) {
                System.out.println("Value at " + i + " is :" + arrObj.getString(i));
                String temp_val = arrObj.getString(i);
                JSONObject temp_jsonObj = new JSONObject(temp_val);
                String temp_json_val;
                genericTable.add(i, new GenericObject());

                int temp_len = temp_jsonObj.length();
                for (int j = 0; j < temp_len; j++) {
                    String temp_name = "PARAM" + j;
                    temp_json_val = temp_jsonObj.getString(temp_name);
                    if (temp_name.equals("PARAM1")) {
                        genericTable.get(i).setParam1(temp_json_val);
                    } else

                    if (temp_name.equals("PARAM2")) {
                        genericTable.get(i).setParam2(temp_json_val);
                    } else

                    if (temp_name.equals("PARAM3")) {
                        genericTable.get(i).setParam3(temp_json_val);
                    } else

                    if (temp_name.equals("PARAM4")) {
                        genericTable.get(i).setParam4(temp_json_val);
                    } else

                    if (temp_name.equals("PARAM5")) {
                        genericTable.get(i).setParam5(temp_json_val);
                    } else {
                        System.out.println("not found");
                    }

                }

            }


        } catch (JSONException e) {
            System.out.println("Exception occureed");
        }
        return genericTable;

    }
}
