package xxxx.mobile.service;

import java.util.ArrayList;

import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.parameter.BusinessUnitLOV;
import xxxx.mobile.parameter.InvOrganization;
import xxxx.mobile.parameter.InvOrganizationLOV;
import xxxx.mobile.parameter.LegalEntity;
import xxxx.mobile.utility.RestServiceUtil;

public class InvOrganizationService {
    public InvOrganizationService() {
        super();
    }
    private final static InvOrganizationService invOrgService = new InvOrganizationService();
    private InvOrganizationLOV invOrgLOVs = new InvOrganizationLOV();

    public InvOrganizationLOV getInvOrgLOVs() {
        System.out.println("INSIDE GETBU");
        final String connectionName = "RestMultiOutput";
        final String requestURI = "INV_Organizations_LOV_Report/999/999/999999/99/99";
        RestServiceUtil restServiceUtil = new RestServiceUtil(connectionName);
        String jsonArrayAsString = restServiceUtil.invokeGet(requestURI, null);
        System.out.println("ENTERING TRY");
        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            JSONArray buArray = jsonObject.getJSONArray("record");
            ArrayList<InvOrganization> InvOrgList = new ArrayList<InvOrganization>();
            int bsize = buArray.length();
            
            System.out.println("ASSIGNING DEFAULT");
            String dvalue = "Select Inv Organization Unit";
            InvOrganization dobject = new InvOrganization(dvalue);
            InvOrgList.add(dobject);
            
            System.out.println("ENTERING BULOOP");
            for (int i = 0; i < bsize; i++) {
                System.out.println("LOOP:" + i);
                JSONObject temp = buArray.getJSONObject(i);
                String name = null;
                if (temp.getString("PARAM1") != null)
                    name = temp.getString("PARAM1");
                InvOrganization invOrg = new InvOrganization(name);
                InvOrgList.add(invOrg);
            }
            System.out.println("EXIT LOOP");

            System.out.println("ASSIGNING");
         //   businessunits.setBusinessunitLovs(BusinessUnitList.toArray(new BusinessUnitLOV[BusinessUnitList.size()]));
        //    legal_entity.setLegalEntityLOV(LegalEntityList.toArray(new LegalEntity[LegalEntityList.size()]));
            invOrgLOVs.setInvOrgLOV(InvOrgList.toArray(new InvOrganization[InvOrgList.size()]));
            System.out.println("END!!!!!");

        } catch (JSONException jsone) {
            System.out.println("INSIDE EXCEPTION 1");
            jsone.printStackTrace();
        } catch (Exception e) {
            System.out.println("INSIDE EXCEPTION 2");
            e.getMessage();
        }
        return invOrgLOVs;
    }
    public static synchronized InvOrganizationService getInstance() {
        return invOrgService;
    }
}
