package xxxx.mobile.service;
import java.util.ArrayList;

import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.parameter.BusinessUnitLOV;
import xxxx.mobile.parameter.Businessunit;
import xxxx.mobile.utility.RestServiceUtil;


public class BusinessunitService {
    public BusinessunitService() {
        super();
    }

    private final static BusinessunitService buservice = new BusinessunitService();
    private Businessunit businessunits = new Businessunit();

    public Businessunit getBusinessunits() {
        System.out.println("INSIDE GETBU");
        final String connectionName = "RestMultiOutput";
        final String requestURI = "Operating_Unit_Report/999/999/999999/99/99";
        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        //System.out.println("Value of Operating Unit ....."+jsonArrayAsString);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            System.out.println("After Creating JSON Array");
            JSONArray buArray = jsonObject.getJSONArray("record");
            System.out.println("After Record $$");
            ArrayList<BusinessUnitLOV> BusinessUnitList = new ArrayList<BusinessUnitLOV>();
            int bsize = buArray.length();
            
            System.out.println("ASSIGNING DEFAULT");
            String dvalue = "Select Business Unit";
            BusinessUnitLOV dobject = new BusinessUnitLOV(dvalue);
            BusinessUnitList.add(dobject);
            
            System.out.println("ENTERING BULOOP");
            for (int i = 0; i < bsize; i++) {
               // System.out.println("LOOP:" + i);
                JSONObject temp = buArray.getJSONObject(i);
                String name = null;
                if (temp.getString("PARAM1") != null)
                    name = temp.getString("PARAM1");
                BusinessUnitLOV businessunitLOV = new BusinessUnitLOV(name);
                BusinessUnitList.add(businessunitLOV);
            }
            System.out.println("EXIT LOOP");

            System.out.println("ASSIGNING");
            businessunits.setBusinessunitLovs(BusinessUnitList.toArray(new BusinessUnitLOV[BusinessUnitList.size()]));
            System.out.println("END!!!!!");

        } catch (JSONException jsone) {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        return businessunits;
    }
    public static synchronized BusinessunitService getInstance() {
        return buservice;
    }
}
