package xxxx.mobile.parameter;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class LegalEntity {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public LegalEntity() {
        super();
    }
    
    public LegalEntity(String name) {
        super();
        this.name = name;
    }
    
    private String name;

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
