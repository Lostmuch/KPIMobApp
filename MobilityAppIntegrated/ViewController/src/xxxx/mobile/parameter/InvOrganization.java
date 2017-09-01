package xxxx.mobile.parameter;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class InvOrganization {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public InvOrganization() {
        super();
    }
    
    public InvOrganization(String invOrg_name) {
        super();
        this.invOrg_name = invOrg_name;
    }
    private String invOrg_name;

    public void setInvOrg_name(String invOrg_name) {
        String oldInvOrg_name = this.invOrg_name;
        this.invOrg_name = invOrg_name;
        _propertyChangeSupport.firePropertyChange("invOrg_name", oldInvOrg_name, invOrg_name);
    }

    public String getInvOrg_name() {
        return invOrg_name;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
