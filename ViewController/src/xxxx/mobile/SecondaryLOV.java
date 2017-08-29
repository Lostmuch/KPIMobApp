package xxxx.mobile;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class SecondaryLOV {
    private String name;
    private int id;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public SecondaryLOV() {
        super();
    }
    public SecondaryLOV(int id,String name) {
        super();
        this.id = id;
        this.name = name;
        
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        _propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        _propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public int getId() {
        return id;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
