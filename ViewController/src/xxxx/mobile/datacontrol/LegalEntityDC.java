package xxxx.mobile.datacontrol;

import xxxx.mobile.parameter.LegalEntityLOV;
import xxxx.mobile.service.LegalEntityService;

public class LegalEntityDC {
    public LegalEntityDC() {
        super();
    }
    
        
    private final  LegalEntityService le_service = LegalEntityService.getInstance();
    public LegalEntityLOV getLegalEntity() {
      //  return businessunitLOV.getBusinessunits();
       return le_service.getLegalEntity();
    }
}
