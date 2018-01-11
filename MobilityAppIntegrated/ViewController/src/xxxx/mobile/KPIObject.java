package xxxx.mobile;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class KPIObject implements Comparable<KPIObject>{
    private int priority;
    private String name;
    private String type;
    private String time;
    private String org_scope;
    private String org_value;
    private String target_type;
    private String target_value;
    private String actual_value;
    private String report_name;
    private String value_difference;
    private String notification_req;
    private String image_icon ;

    private String result_flag;
    private String result_layout;
    
    private Boolean showTimeRadio;
    private Boolean showCurrent;
    private Boolean showOrgRadio;
    private Boolean showTargetType;
    private Boolean showTargetValue;
    private Boolean showBUChoice;
    private Boolean showLEChoice;
    private Boolean showStartDate;
    private Boolean showEndDate;
    //private date  StartDate;
    
    
    private String bu_name;
    private String le_name;

    public void setShowTimeRadio(Boolean showTimeRadio) {
        this.showTimeRadio = showTimeRadio;
    }

    public Boolean getShowTimeRadio() {
        return showTimeRadio;
    }

    public void setShowCurrent(Boolean showCurrent) {
        this.showCurrent = showCurrent;
    }

    public Boolean getShowCurrent() {
        return showCurrent;
    }

    public void setShowOrgRadio(Boolean showOrgRadio) {
        this.showOrgRadio = showOrgRadio;
    }

    public Boolean getShowOrgRadio() {
        return showOrgRadio;
    }

    public void setShowTargetType(Boolean showTargetType) {
        this.showTargetType = showTargetType;
    }

    public Boolean getShowTargetType() {
        return showTargetType;
    }

    public void setShowTargetValue(Boolean showTargetValue) {
        this.showTargetValue = showTargetValue;
    }

    public Boolean getShowTargetValue() {
        return showTargetValue;
    }

    public void setShowBUChoice(Boolean showBUChoice) {
        this.showBUChoice = showBUChoice;
    }

    public Boolean getShowBUChoice() {
        return showBUChoice;
    }

    public void setShowLEChoice(Boolean showLEChoice) {
        this.showLEChoice = showLEChoice;
    }

    public Boolean getShowLEChoice() {
        return showLEChoice;
    }

    public void setBu_name(String bu_name) {
        this.bu_name = bu_name;
    }

    public String getBu_name() {
        return bu_name;
    }

    public void setLe_name(String le_name) {
        this.le_name = le_name;
    }

    public String getLe_name() {
        return le_name;
    }


    public void setResult_layout(String result_layout) {
        String oldResult_layout = this.result_layout;
        this.result_layout = result_layout;
        _propertyChangeSupport.firePropertyChange("result_layout", oldResult_layout, result_layout);
    }

    public String getResult_layout() {
        return result_layout;
    }

    public void setPage_name(String page_name) {
        String oldPage_name = this.page_name;
        this.page_name = page_name;
        _propertyChangeSupport.firePropertyChange("page_name", oldPage_name, page_name);
    }

    public String getPage_name() {
        return page_name;
    }
    private String page_name; 

    public void setResult_flag(String result_flag) {
        String oldResult_flag = this.result_flag;
        this.result_flag = result_flag;
        _propertyChangeSupport.firePropertyChange("result_flag", oldResult_flag, result_flag);
    }

    public String getResult_flag() {
        return result_flag;
    }
/*
    public void setSupplier_name(String supplier_name) {
        String oldSupplier_name = this.supplier_name;
        this.supplier_name = supplier_name;
        _propertyChangeSupport.firePropertyChange("supplier_name", oldSupplier_name, supplier_name);
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupp_amt(int supp_amt) {
        int oldSupp_amt = this.supp_amt;
        this.supp_amt = supp_amt;
        _propertyChangeSupport.firePropertyChange("supp_amt", oldSupp_amt, supp_amt);
    }

    public int getSupp_amt() {
        return supp_amt;
    }
*/

    public void setImage_icon(String image_icon) {
        String oldImage_icon = this.image_icon;
        this.image_icon = image_icon;
        _propertyChangeSupport.firePropertyChange("image_icon", oldImage_icon, image_icon);
    }

    public String getImage_icon() {
        return image_icon;
    }
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    

    public KPIObject() 
    {
        super();
    }

    public void setPriority(int priority) {
        int oldPriority = this.priority;
        this.priority = priority;
        _propertyChangeSupport.firePropertyChange("priority", oldPriority, priority);
    }

    public int getPriority() {
        return priority;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport _propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this._propertyChangeSupport;
        this._propertyChangeSupport = _propertyChangeSupport;
        _propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                  _propertyChangeSupport);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return _propertyChangeSupport;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        _propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        _propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public String getType() {
        return type;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        _propertyChangeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getTime() {
        return time;
    }

    public void setOrg_scope(String org_scope) {
        String oldOrg_scope = this.org_scope;
        this.org_scope = org_scope;
        _propertyChangeSupport.firePropertyChange("org_scope", oldOrg_scope, org_scope);
    }

    public String getOrg_scope() {
        return org_scope;
    }

    public void setOrg_value(String org_value) {
        String oldOrg_value = this.org_value;
        this.org_value = org_value;
        _propertyChangeSupport.firePropertyChange("org_value", oldOrg_value, org_value);
    }

    public String getOrg_value() {
        return org_value;
    }

    public void setTarget_type(String target_type) {
        String oldTarget_type = this.target_type;
        this.target_type = target_type;
        _propertyChangeSupport.firePropertyChange("target_type", oldTarget_type, target_type);
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_value(String target_value) {
        String oldTarget_value = this.target_value;
        this.target_value = target_value;
        _propertyChangeSupport.firePropertyChange("target_value", oldTarget_value, target_value);
    }

    public String getTarget_value() {
        return target_value;
    }

    public void setNotification_req(String notification_req) {
        String oldNotification_req = this.notification_req;
        this.notification_req = notification_req;
        _propertyChangeSupport.firePropertyChange("notification_req", oldNotification_req, notification_req);
    }

    public String getNotification_req() {
        return notification_req;
    }


    public void setActual_value(String actual_value) {
        String oldActual_value = this.actual_value;
        this.actual_value = actual_value;
        _propertyChangeSupport.firePropertyChange("actual_value", oldActual_value, actual_value);
    }

    public String getActual_value() {
        return actual_value;
    }

    public void setReport_name(String report_name) {
        String oldReport_name = this.report_name;
        this.report_name = report_name;
        _propertyChangeSupport.firePropertyChange("report_name", oldReport_name, report_name);
    }

    public String getReport_name() {
        return report_name;
    }

    public void setValue_difference(String value_difference) {
        String oldValue_difference = this.value_difference;
        this.value_difference = value_difference;
        _propertyChangeSupport.firePropertyChange("value_difference", oldValue_difference, value_difference);
    }

    public String getValue_difference() {
        return value_difference;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    @Override
    public int compareTo(KPIObject kPIObject) {
        
        return new Integer(this.priority).compareTo(kPIObject.getPriority());
    }

    @Override
    public String toString() {
        
        return "NamePriorityType-"+name+priority+type +" "+report_name +" "+target_value +" "+actual_value +" "+ value_difference+" "+ org_scope+" "+org_value +" "+time;
    }

    public void setShowStartDate(Boolean showStartDate) {
        Boolean oldShowStartDate = this.showStartDate;
        this.showStartDate = showStartDate;
        _propertyChangeSupport.firePropertyChange("showStartDate", oldShowStartDate, showStartDate);
    }

    public Boolean getShowStartDate() {
        return showStartDate;
    }

    public void setShowEndDate(Boolean showEndDate) {
        Boolean oldShowEndDate = this.showEndDate;
        this.showEndDate = showEndDate;
        _propertyChangeSupport.firePropertyChange("showEndDate", oldShowEndDate, showEndDate);
    }

    public Boolean getShowEndDate() {
        return showEndDate;
    }
    
    //Added by Shaswat
    private editKPIParam defParam;

    public void setDefParam(editKPIParam defParam) {
        editKPIParam oldDefParam = this.defParam;
        this.defParam = defParam;
        _propertyChangeSupport.firePropertyChange("defParam", oldDefParam, defParam);
    }

    public editKPIParam getDefParam() {
        return defParam;
    }
}
