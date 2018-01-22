package xxxx.mobile;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class editKPIParam {
    private String currentRadio;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    private boolean loV1_rendered = false;
    private boolean loV2_rendered = false;
    private String timeRadio = null;
    private String scopeRadioValue1 = null;
    private String scopeRadioValue2 = null;
    private String current_timeRadio; //Added by Shaswat
    private String target_type; //Added by Shaswat

    public void setScopeRadioValue1(String scopeRadioValue1) {
        String oldScopeRadioValue1 = this.scopeRadioValue1;
        this.scopeRadioValue1 = scopeRadioValue1;
        _propertyChangeSupport.firePropertyChange("scopeRadioValue1", oldScopeRadioValue1, scopeRadioValue1);
    }

    public String getScopeRadioValue1() {
        return scopeRadioValue1;
    }

    public void setScopeRadioValue2(String scopeRadioValue2) {
        String oldScopeRadioValue2 = this.scopeRadioValue2;
        this.scopeRadioValue2 = scopeRadioValue2;
        _propertyChangeSupport.firePropertyChange("scopeRadioValue2", oldScopeRadioValue2, scopeRadioValue2);
    }

    public String getScopeRadioValue2() {
        return scopeRadioValue2;
    }

    private String target;

    public editKPIParam() {
        //AdfmfJavaUtilities.setELValue("#{viewScope.cb13Color}","#70ad47");
        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.lov1_rendered}", true);
        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.lov2_rendered}", true);  
        setLoV1_rendered(false);
        setLoV2_rendered(false);
//        AdfmfJavaUtilities.setELValue("#{editKPIParam.loV1_rendered}", getLoV1_rendered());
//        AdfmfJavaUtilities.setELValue("#{editKPIParam.loV2_rendered}", getLoV2_rendered());  
        
        System.out.println ("Constructor");
    }

    public void radioCheck(ValueChangeEvent valueChangeEvent) 
    {
        // Add event code here...
        setCurrentRadio(valueChangeEvent.getNewValue().toString());
        if (getCurrentRadio().equals("Organization")) {
            setLoV1_rendered(true);
            setLoV2_rendered(false);
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV1_rendered}", getLoV1_rendered());
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV2_rendered}", getLoV2_rendered());  
                System.out.println ("lov1 : "+  getLoV1_rendered());
                System.out.println ("lov2 : "+  getLoV2_rendered());
                System.out.println("if1");
            }
        else if(getCurrentRadio().equals("Operating Unit")){
            setLoV1_rendered(false);
            setLoV2_rendered(true);
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV1_rendered}", getLoV1_rendered());
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV2_rendered}", getLoV2_rendered());  
                 System.out.println ("lov1 : "+  getLoV1_rendered());
                 System.out.println ("lov2 : "+  getLoV2_rendered());
                 System.out.println("if2");
             }
        else{
            setLoV1_rendered(false);
            setLoV2_rendered(false);
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV1_rendered}", getLoV1_rendered());
//            AdfmfJavaUtilities.setELValue("#{editKPIParam.loV2_rendered}", getLoV2_rendered());  
                 System.out.println ("lov1 : "+  getLoV1_rendered());
                 System.out.println ("lov2 : "+  getLoV2_rendered());
                 System.out.println("if3");
             }
               
        
        System.out.println ("Radio Value is" + getCurrentRadio());
        
    }

    public void setCurrentRadio(String currentRadio) {
        this.currentRadio = currentRadio;
    }

    public String getCurrentRadio() {
        return currentRadio;
    }

    public void getValueChanged(ActionEvent actionEvent) {
        // Add event code here...
      
       // AdfmfJavaUtilities.setELValue("#{viewScope.cb13Color}","5b9bd5");
        
    }

    public void setLoV1_rendered(boolean loV1_rendered) {
        boolean oldVal= this.loV1_rendered;
        this.loV1_rendered = loV1_rendered;
        _propertyChangeSupport.firePropertyChange("loV1_rendered", oldVal , this.loV1_rendered);
    }

    public boolean getLoV1_rendered() {
        return loV1_rendered;
    }

    public void setLoV2_rendered(boolean loV2_rendered) {
        boolean oldVal= this.loV2_rendered;
        this.loV2_rendered = loV2_rendered;
        _propertyChangeSupport.firePropertyChange("loV2_rendered", oldVal , this.loV2_rendered);    }

    public boolean getLoV2_rendered() {
        return loV2_rendered;
    }
    public void addPropertyChangeListener(PropertyChangeListener l) {
            _propertyChangeSupport.addPropertyChangeListener(l);
        }

        public void removePropertyChangeListener(PropertyChangeListener l) {
            _propertyChangeSupport.removePropertyChangeListener(l);
        }

    public void setTimeRadio(String timeRadio) {
        String oldTimeRadio = this.timeRadio;
        this.timeRadio = timeRadio;
        _propertyChangeSupport.firePropertyChange("timeRadio", oldTimeRadio, timeRadio);
    }

    public String getTimeRadio() {
        return timeRadio;
    }

    public void setTarget(String target) {
        String oldTarget = this.target;
        this.target = target;
        _propertyChangeSupport.firePropertyChange("target", oldTarget, target);
    }

    public String getTarget() {
        return target;
    }

//Added by Shaswat
    public void setCurrent_timeRadio(String current_timeRadio) {
        String oldCurrent_timeRadio = this.current_timeRadio;
        this.current_timeRadio = current_timeRadio;
        _propertyChangeSupport.firePropertyChange("current_timeRadio", oldCurrent_timeRadio, current_timeRadio);
    }

    public String getCurrent_timeRadio() {
        return current_timeRadio;
    }

    public void setTarget_type(String target_type) {
        String oldTarget_type = this.target_type;
        this.target_type = target_type;
        _propertyChangeSupport.firePropertyChange("target_type", oldTarget_type, target_type);
    }

    public String getTarget_type() {
        return target_type;
    }
}
