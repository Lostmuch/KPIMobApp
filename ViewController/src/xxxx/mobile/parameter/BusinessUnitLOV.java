package xxxx.mobile.parameter;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class BusinessUnitLOV {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    private String name;
    public BusinessUnitLOV() {
        super();
    }
    
    public BusinessUnitLOV(String name) {
        super();
        this.name =name;
    }
    

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        _propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
