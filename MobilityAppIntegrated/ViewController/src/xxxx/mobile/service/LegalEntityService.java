package xxxx.mobile.service;

import java.util.ArrayList;

import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.parameter.BusinessUnitLOV;
import xxxx.mobile.parameter.Businessunit;
import xxxx.mobile.parameter.LegalEntity;
import xxxx.mobile.parameter.LegalEntityLOV;
import xxxx.mobile.utility.RestServiceUtil;

public class LegalEntityService {
    public LegalEntityService() {
        super();
    }
    private final static LegalEntityService leservice = new LegalEntityService();
    private LegalEntityLOV legal_entity = new LegalEntityLOV();

    public LegalEntityLOV getLegalEntity() {
        System.out.println("INSIDE GET LEGAL ENTITY");
        final String connectionName = "RestMultiOutput";
        final String requestURI = "Legal_Entity_Report/999/999/999999/99/99";
        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            JSONArray buArray = jsonObject.getJSONArray("record");
            ArrayList<LegalEntity> LegalEntityList = new ArrayList<LegalEntity>();
            int bsize = buArray.length();
            
            System.out.println("ASSIGNING DEFAULT");
            String dvalue = "Select Legal Entity";
            LegalEntity dobject = new LegalEntity(dvalue);
            LegalEntityList.add(dobject);
            
            System.out.println("ENTERING LELOOP");
            for (int i = 0; i < bsize; i++) {
                System.out.println("LOOP:" + i);
                JSONObject temp = buArray.getJSONObject(i);
                String name = null;
                if (temp.getString("PARAM1") != null)
                    name = temp.getString("PARAM1");
                LegalEntity le = new LegalEntity(name);
                LegalEntityList.add(le);
            }
            System.out.println("EXIT LOOP");

            System.out.println("ASSIGNING");
           // legal_entity.setBusinessunitLovs(BusinessUnitList.toArray(new BusinessUnitLOV[BusinessUnitList.size()]));
            legal_entity.setLegalEntityLOV(LegalEntityList.toArray(new LegalEntity[LegalEntityList.size()]));
            System.out.println("END!!!!!");

        } catch (JSONException jsone) {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        return legal_entity;
    }
    public static synchronized LegalEntityService getInstance() {
        return leservice;
    }
}
