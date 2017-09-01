package xxxx.mobile;

import java.util.ArrayList;
import java.util.List;

public class LOV_values {
    private List  s_lov_values =null;
    public LOV_values() {
        super();
    }
    
    public SecondaryLOV[] getLOVvalues() {
        SecondaryLOV[] secValues = null;
        s_lov_values =new ArrayList();
        s_lov_values.add(new SecondaryLOV(1,"ORG 1") );
        s_lov_values.add(new SecondaryLOV(2,"ORG 2") );
        s_lov_values.add(new SecondaryLOV(3,"'ORG 3") );
        secValues = (SecondaryLOV[]) s_lov_values.toArray(new SecondaryLOV[s_lov_values.size()]);
        return secValues;
        
    }
}
