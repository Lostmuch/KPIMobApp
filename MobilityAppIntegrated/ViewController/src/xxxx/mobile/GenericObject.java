package xxxx.mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class GenericObject {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public GenericObject() {
        super();
    }
    String param1;
    String param2;
    int  param3;
    String param4;
    String param5;

        public void setParam1(String param1) {
        String oldParam1 = this.param1;
        this.param1 = param1;
        _propertyChangeSupport.firePropertyChange("param1", oldParam1, param1);
    }

    public String getParam1() {
        return param1;
    }

    public void setParam2(String param2) {
        String oldParam2 = this.param2;
        this.param2 = param2;
        _propertyChangeSupport.firePropertyChange("param2", oldParam2, param2);
    }

    public String getParam2() {
        return param2;
    }



    public void setParam4(String param4) {
        String oldParam4 = this.param4;
        this.param4 = param4;
        _propertyChangeSupport.firePropertyChange("param4", oldParam4, param4);
    }

    public String getParam4() {
        return param4;
    }

    public void setParam5(String param5) {
        String oldParam5 = this.param5;
        this.param5 = param5;
        _propertyChangeSupport.firePropertyChange("param5", oldParam5, param5);
    }

    public String getParam5() {
        return param5;
    }


    public void setParam3(int param3) {
        int oldParam3 = this.param3;
        this.param3 = param3;
        _propertyChangeSupport.firePropertyChange("param3", oldParam3, param3);
    }

    public int getParam3() {
        return param3;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
