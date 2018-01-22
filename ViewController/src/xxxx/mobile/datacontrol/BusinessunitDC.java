package xxxx.mobile.datacontrol;

import xxxx.mobile.parameter.Businessunit;
import xxxx.mobile.service.BusinessunitService;


public class BusinessunitDC {
    public BusinessunitDC() {
        super();
    }
    
    private final  BusinessunitService businessunitLOV = BusinessunitService.getInstance();
    public Businessunit getBusinessunitLOV() {
        return businessunitLOV.getBusinessunits();
    }
}
