package xxxx.mobile.datacontrol;

import xxxx.mobile.parameter.InvOrganizationLOV;
import xxxx.mobile.service.InvOrganizationService;

public class InvOrganizationDC {
    public InvOrganizationDC() {
        super();
    }
    
    private final  InvOrganizationService invOrgLov = InvOrganizationService.getInstance();
    public InvOrganizationLOV getInvOrgLov() {
        return invOrgLov.getInvOrgLOVs();
    }
}
