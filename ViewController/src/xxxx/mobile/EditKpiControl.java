package xxxx.mobile;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Comparator;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import xxxx.MobilityApp.DBAdapter;
import xxxx.MobilityApp.DBAdapter;

import xxxx.mobile.service.SubmitService;

public class EditKpiControl {
    private String chnopa = "EditKPIorg";
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    private String ChnPOopa = "EditKPIorg";
    private String chnBPAopa = "EditKPIorg";
    private String chnInvopa = "EditKPIorg";
    private String chnInvntopa = "EditKPIorg";
    private String chnInvSalesopa = "EditKPIorg";
    private String chnStkopa = "EditKPIorg";
    private String chnObsoleteopa = "EditKPIorg";
    private String chnYTDValueOpa = "EditKPIorg";
    private String chnSuppOpa = "EditKPIorg";
    private String chnship2Opa = "EditKPIorg";


    private boolean invkiprend = false;
    private boolean openPORend = false;

    private final String KPI_PROC1 = "PO BackLog";
    private final String KPI_PROC2 = "Open PO";
    private final String KPI_PROC3 = "Expiring BPA";
    private final String KPI_PROC4 = "Invoice Pending";

    private final String KPI_INV1 = "Inventory T/O";
    private final String KPI_INV2 = "Inventory To Sales Ratio";
    private final String KPI_INV3 = "Stock out";
    private final String KPI_INV4 = "Obsolete Inventory";

    private final String KPI_SHIP1 = "Orders booked";
    private final String KPI_SHIP2 = "Backlog Summary";

    private final String KPI_AP1 = "Top 10 Outstanding Suppliers";

    private final String KPI_AR1 = "Disputed Customer Payments";
    private final String KPI_AR2 = "Pending Customer Payments";

    private String kpIText = "abc";

    private boolean apTimeRadio = false;
    private String suppAmt = null;
    private String custAmt = null;

    private boolean proBackLogrend;

    //  private boolean timerend;

    private boolean allTimePara = true;
    private boolean current_timeRadio = false;
    private boolean orgScoperend;
    private boolean buChoice = false;
    private boolean leChoice = false;
    private boolean targettyperend = false;
    private boolean targetValuerend = false;

    private boolean payablesrend;
    private boolean recrend;


    String image_name;
    String button_label;
    private boolean resultDisCusRend = false;
    private boolean resultPenCusRend = false;
    private boolean resultPOBacLogRend = false;
    private boolean resultAPSupprend = false;
    private boolean resultKPIShip1rend = false;
    private boolean resultKPINetProfitrend = false;

  public void setResultKPINetProfitrend(boolean resultKPINetProfitrend)
  {
    boolean oldResultKPINetProfitrend = this.resultKPINetProfitrend;
    this.resultKPINetProfitrend = resultKPINetProfitrend;
    _propertyChangeSupport.firePropertyChange("resultKPINetProfitrend", oldResultKPINetProfitrend,
                                              resultKPINetProfitrend);
  }

  public boolean isResultKPINetProfitrend()
  {
    return resultKPINetProfitrend;
  }


  public void setButton_label(String button_label) {
        this.button_label = button_label;
    }

    public String getButton_label() {
        return button_label;
    }

    private String chnYTDOpa = "EditKPIorg";
    ArrayList<String> imgArr = new ArrayList<String>();
    public ArrayList<KPIObject> kpis = new ArrayList<KPIObject>();

    public ArrayList<KPIObject> kpis_target = new ArrayList<KPIObject>();
    public ArrayList<KPIObject> kpis_button = new ArrayList<KPIObject>();
    public ArrayList<KPIObject> kpistemp = new ArrayList<KPIObject>();
    ArrayList<KPIObject> a = new ArrayList<KPIObject>();
    ArrayList<KPIObject> b = new ArrayList<KPIObject>();

    private String kpi_inv1;
    private String inv1_ac;
    private String inv1_t;
    private String inv1_diff;
    private String abc = null;
    private String chnpoBackLogOpa = "EditKPIorg";

    private String chnDisCustOpa = "EditKPIorg";
    private String chnpendCustpayOpa = "EditKPIorg";


    public void setCurrent_timeRadio(boolean current_timeRadio) {
        boolean oldCurrent_timeRadio = this.current_timeRadio;
        this.current_timeRadio = current_timeRadio;
        _propertyChangeSupport.firePropertyChange("current_timeRadio", oldCurrent_timeRadio, current_timeRadio);
    }

    public boolean isCurrent_timeRadio() {
        return current_timeRadio;
    }


    public void setBuChoice(boolean buChoice) {
        boolean oldBuChoice = this.buChoice;
        this.buChoice = buChoice;
        _propertyChangeSupport.firePropertyChange("buChoice", oldBuChoice, buChoice);
    }

    public boolean isBuChoice() {
        return buChoice;
    }

    public void setLeChoice(boolean leChoice) {
        boolean oldLeChoice = this.leChoice;
        this.leChoice = leChoice;
        _propertyChangeSupport.firePropertyChange("leChoice", oldLeChoice, leChoice);
    }

    public boolean isLeChoice() {
        return leChoice;
    }

    public void setImage_name(String image_name) {
        String oldImage_name = this.image_name;
        this.image_name = image_name;
        _propertyChangeSupport.firePropertyChange("image_name", oldImage_name, image_name);
    }

    public String getImage_name() {
        return image_name;
    }


    public void setChnpendCustpayOpa(String chnpendCustpayOpa) {
        String oldChnpendCustpayOpa = this.chnpendCustpayOpa;
        this.chnpendCustpayOpa = chnpendCustpayOpa;
        _propertyChangeSupport.firePropertyChange("chnpendCustpayOpa", oldChnpendCustpayOpa, chnpendCustpayOpa);
    }

    public String getChnpendCustpayOpa() {
        return chnpendCustpayOpa;
    }

    public void setChnpoBackLogOpa(String chnpoBackLogOpa) {
        String oldChnpoBackLogOpa = this.chnpoBackLogOpa;
        this.chnpoBackLogOpa = chnpoBackLogOpa;
        _propertyChangeSupport.firePropertyChange("chnpoBackLogOpa", oldChnpoBackLogOpa, chnpoBackLogOpa);
    }

    public String getChnpoBackLogOpa() {
        return chnpoBackLogOpa;
    }


    public void setChnDisCustOpa(String chnDisCustOpa) {
        String oldChnDisCustOpa = this.chnDisCustOpa;
        this.chnDisCustOpa = chnDisCustOpa;
        _propertyChangeSupport.firePropertyChange("chnDisCustOpa", oldChnDisCustOpa, chnDisCustOpa);
    }

    public String getChnDisCustOpa() {
        return chnDisCustOpa;
    }


    public void setChnSuppOpa(String chnSuppOpa) {
        String oldChnSuppOpa = this.chnSuppOpa;
        this.chnSuppOpa = chnSuppOpa;
        _propertyChangeSupport.firePropertyChange("chnSuppOpa", oldChnSuppOpa, chnSuppOpa);
    }

    public String getChnSuppOpa() {
        return chnSuppOpa;
    }

    public void setChnYTDValueOpa(String chnYTDValueOpa) {
        String oldChnYTDValueOpa = this.chnYTDValueOpa;
        this.chnYTDValueOpa = chnYTDValueOpa;
        _propertyChangeSupport.firePropertyChange("chnYTDValueOpa", oldChnYTDValueOpa, chnYTDValueOpa);
    }

    public String getChnYTDValueOpa() {
        return chnYTDValueOpa;
    }


    public void setA(ArrayList<KPIObject> a) {
        ArrayList<KPIObject> oldA = this.a;
        this.a = a;
        _propertyChangeSupport.firePropertyChange("a", oldA, a);
    }

    public ArrayList<KPIObject> getA() {
        return a;
    }


    public void setAbc(String abc) {
        String oldAbc = this.abc;
        this.abc = abc;
        _propertyChangeSupport.firePropertyChange("abc", oldAbc, abc);
    }

    public String getAbc() {
        return abc;
    }

    public void setImgArr(ArrayList<String> imgArr) {
        ArrayList<String> oldImgArr = this.imgArr;
        this.imgArr = imgArr;
        _propertyChangeSupport.firePropertyChange("imgArr", oldImgArr, imgArr);
    }

    public ArrayList<String> getImgArr() {
        return imgArr;
    }

    public void setKpis(ArrayList<KPIObject> kpis) {
        ArrayList<KPIObject> oldKpis = this.kpis;
        this.kpis = kpis;
        _propertyChangeSupport.firePropertyChange("kpis", oldKpis, kpis);
    }

    public ArrayList<KPIObject> getKpis() {
        return kpis;
    }

    public void setKpistemp(ArrayList<KPIObject> kpistemp) {
        ArrayList<KPIObject> oldKpistemp = this.kpistemp;
        this.kpistemp = kpistemp;
        _propertyChangeSupport.firePropertyChange("kpistemp", oldKpistemp, kpistemp);
    }

    public ArrayList<KPIObject> getKpistemp() {
        return kpistemp;
    }


    public void setKpis_button(ArrayList<KPIObject> kpis_button) {
        ArrayList<KPIObject> oldKpis_button = this.kpis_button;
        this.kpis_button = kpis_button;
        _propertyChangeSupport.firePropertyChange("kpis_button", oldKpis_button, kpis_button);
    }

    public ArrayList<KPIObject> getKpis_button() {
        return kpis_button;
    }


    public EditKpiControl() {
    }
    

    public String changePendCustPayOpacity() {
        // Add event code here...
        System.out.println("Inside changePendCustPayOpacity");
        if (this.chnpendCustpayOpa.equals("EditKPIorg")) {
            this.setChnpendCustpayOpa("EditKPIopct");
            imgArr.add(KPI_AR2);
        } else {
            this.setChnpendCustpayOpa("EditKPIorg");
            imgArr.remove(KPI_AR2);
        }
        // Add event code here...
        return null;
    }
    
    public String changeShip2Opacity() {
        // Add event code here...
        System.out.println("Inside changePendCustPayOpacity");
        if (this.chnship2Opa.equals("EditKPIorg")) {
            this.setChnship2Opa("EditKPIopct");
            imgArr.add(KPI_AR2);
        } else {
            this.setChnship2Opa("EditKPIorg");
            imgArr.remove(KPI_AR2);
        }
        // Add event code here...
        return null;
    }

    public String changePendingOpacity() {

        if (this.chnopa.equals("EditKPIorg")) {
            this.setChnopa("EditKPIopct");
            imgArr.add(KPI_PROC1);
        } else {
            this.setChnopa("EditKPIorg");
            imgArr.remove(KPI_PROC1);
        }
        // Add event code here...
        return null;
    }

    public String changePoOpacity() {

        if (this.ChnPOopa.equals("EditKPIorg")) {
            this.setChnPOopa("EditKPIopct");
            imgArr.add(KPI_PROC2);
        } else {
            this.setChnPOopa("EditKPIorg");
            imgArr.remove(KPI_PROC2);
        }
        // Add event code here...
        return null;
    }

    public void setChnPOopa(String ChnPOopa) {
        String oldChnPOopa = this.ChnPOopa;
        this.ChnPOopa = ChnPOopa;
        _propertyChangeSupport.firePropertyChange("chnPOopa", oldChnPOopa, ChnPOopa);
    }

    public String getChnPOopa() {
        return ChnPOopa;
    }


    public String changeBpaOpacity() {

        if (this.chnBPAopa.equals("EditKPIorg")) {
            this.setChnBPAopa("EditKPIopct");
            imgArr.add(KPI_PROC3);
        } else {
            this.setChnBPAopa("EditKPIorg");
            imgArr.remove(KPI_PROC3);
        }
        // Add event code here...
        return null;
    }


    public String changeInvPenOpacity() {

        if (this.chnInvopa.equals("EditKPIorg")) {
            this.setChnInvopa("EditKPIopct");
            imgArr.add(KPI_PROC4);
        } else {
            this.setChnInvopa("EditKPIorg");
            imgArr.remove(KPI_PROC4);
        }
        // Add event code here...
        return null;
    }

    public void setChnBPAopa(String chnBPAopa) {
        String oldChnBPAopa = this.chnBPAopa;
        this.chnBPAopa = chnBPAopa;
        _propertyChangeSupport.firePropertyChange("chnBPAopa", oldChnBPAopa, chnBPAopa);
    }

    public String getChnBPAopa() {
        return chnBPAopa;
    }

    public void setChnInvopa(String chnInvopa) {
        String oldChnInvopa = this.chnInvopa;
        this.chnInvopa = chnInvopa;
        _propertyChangeSupport.firePropertyChange("chnInvopa", oldChnInvopa, chnInvopa);
    }

    public String getChnInvopa() {
        return chnInvopa;
    }

    public void setChnopa(String chnopa)

    {
        String oldChnopa = this.chnopa;
        this.chnopa = chnopa;
        _propertyChangeSupport.firePropertyChange("chnopa", oldChnopa, chnopa);
    }

    public String getChnopa() {
        return chnopa;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }


    public String changeInventOpacity() {
        // Add event code here...
        if (this.chnInvntopa.equals("EditKPIorg")) {
            this.setChnInvntopa("EditKPIopct");
            imgArr.add(KPI_INV1);
        } else {
            this.setChnInvntopa("EditKPIorg");
            imgArr.remove(KPI_INV1);
        }
        return null;
    }

    public void setChnInvntopa(String chnInvntopa) {
        String oldChnInvntopa = this.chnInvntopa;
        this.chnInvntopa = chnInvntopa;
        _propertyChangeSupport.firePropertyChange("chnInvntopa", oldChnInvntopa, chnInvntopa);
    }

    public String getChnInvntopa() {
        return chnInvntopa;
    }

    public String chnInvSalesOpacity() {
        // Add event code here...
        if (this.chnInvSalesopa.equals("EditKPIorg")) {
            this.setChnInvSalesopa("EditKPIopct");
            imgArr.add(KPI_INV2);
        } else {
            this.setChnInvSalesopa("EditKPIorg");
            imgArr.remove(KPI_INV2);
        }
        return null;
    }

    public void setChnInvSalesopa(String chnInvSalesopa) {
        String oldChnInvSalesopa = this.chnInvSalesopa;
        this.chnInvSalesopa = chnInvSalesopa;
        _propertyChangeSupport.firePropertyChange("chnInvSalesopa", oldChnInvSalesopa, chnInvSalesopa);
    }

    public String getChnInvSalesopa() {
        return chnInvSalesopa;
    }


    public String changeStkOpacity() {
        // Add event code here...
        if (this.chnStkopa.equals("EditKPIorg")) {
            this.setChnStkopa("EditKPIopct");
            imgArr.add(KPI_INV3);
        } else {
            this.setChnStkopa("EditKPIorg");
            imgArr.remove(KPI_INV3);
        }
        return null;
    }

    public void setChnStkopa(String chnStkopa) {
        String oldChnStkopa = this.chnStkopa;
        this.chnStkopa = chnStkopa;
        _propertyChangeSupport.firePropertyChange("chnStkopa", oldChnStkopa, chnStkopa);
    }

    public String getChnStkopa() {
        return chnStkopa;
    }


    public String changeObsoloteOpacity() {
        // Add event code here...
        if (this.chnObsoleteopa.equals("EditKPIorg")) {
            this.setChnObsoleteopa("EditKPIopct");
            imgArr.add(KPI_INV4);
        } else {
            this.setChnObsoleteopa("EditKPIorg");
            imgArr.remove(KPI_INV4);
        }
        return null;
    }

    public String changeOrdersYTDOpacity() {

        System.out.println("Inside changeOrdersYTDOpacity");
        if (this.chnYTDOpa.equals("EditKPIorg")) {
            this.setChnYTDOpa("EditKPIopct");
            imgArr.add(KPI_SHIP1);
        } else {
            this.setChnYTDOpa("EditKPIorg");
            imgArr.remove(KPI_SHIP1);
        }
        // Add event code here...
        return null;
    }

    //KPI_SHIP2
    public String changeYTDValueOpacity() {

        System.out.println("Inside changeYTDValueOpacity");
        if (this.chnYTDValueOpa.equals("EditKPIorg")) {
            this.setChnYTDValueOpa("EditKPIopct");
            imgArr.add(KPI_SHIP2);
        } else {
            this.setChnYTDValueOpa("EditKPIorg");
            imgArr.remove(KPI_SHIP2);
        }
        // Add event code here...
        return null;
    }

    public String changeOutSuppOpacity() {
        // Add event code here...
        System.out.println("Inside changeOutSuppOpacity");
        if (this.chnSuppOpa.equals("EditKPIorg")) {
            this.setChnSuppOpa("EditKPIopct");
            imgArr.add(KPI_AP1);
        } else {
            this.setChnSuppOpa("EditKPIorg");
            imgArr.remove(KPI_AP1);
        }
        // Add event code here...
        return null;
    }

    public String changeDisCustOpacity() {
        // Add event code here...
        System.out.println("Inside changeDisCust");
        if (this.chnDisCustOpa.equals("EditKPIorg")) {
            this.setChnDisCustOpa("EditKPIopct");
            imgArr.add(KPI_AR1);
        } else {
            this.setChnDisCustOpa("EditKPIorg");
            imgArr.remove(KPI_AR1);
        }
        // Add event code here...
        return null;
    }

    public String changepoBackLogOpacity() {
        // Add event code here...
        System.out.println("Inside changepoBackLogOpacity");
        if (this.chnpoBackLogOpa.equals("EditKPIorg")) {
            this.setChnpoBackLogOpa("EditKPIopct");
            imgArr.add(KPI_PROC1);
        } else {
            this.setChnpoBackLogOpa("EditKPIorg");
            imgArr.remove(KPI_PROC1);
        }
        // Add event code here...
        return null;
    }

    public void setChnObsoleteopa(String chnObsoleteopa) {
        String oldChnObsoleteopa = this.chnObsoleteopa;
        this.chnObsoleteopa = chnObsoleteopa;
        _propertyChangeSupport.firePropertyChange("chnObsoleteopa", oldChnObsoleteopa, chnObsoleteopa);
    }

    public String getChnObsoleteopa() {
        return chnObsoleteopa;
    }

    public void setChnYTDOpa(String chnYTDOpa) {
        String oldchnYTDOpa = this.chnYTDOpa;
        this.chnYTDOpa = chnYTDOpa;
        _propertyChangeSupport.firePropertyChange("chnYTDOpa", oldchnYTDOpa, chnYTDOpa);
    }

    public String getChnYTDOpa() {
        return chnYTDOpa;
    }


    public void setInvkiprend(boolean invkiprend) {
        //this.invkiprend = invkiprend;

        boolean oldinvkiprend = this.invkiprend;
        this.invkiprend = invkiprend;
        _propertyChangeSupport.firePropertyChange("invkiprend", oldinvkiprend, invkiprend);
    }

    public boolean getInvkiprend() {
        return invkiprend;
    }

    public void setOpenPORend(boolean openPORend) {
        //  this.openPORend = openPORend;
        boolean oldopenPORend = this.openPORend;
        this.openPORend = openPORend;
        _propertyChangeSupport.firePropertyChange("openPORend", oldopenPORend, openPORend);
    }

    public boolean getOpenPORend() {
        return openPORend;
    }


    public void onSubmit(ActionEvent actionEvent) {
        // Add event code here...

        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.kpis}", kpis);
        System.out.println("ABC value :" + kpis);
        System.out.println("Image Array Value***************************************** " + imgArr);
        kpis.removeAll(kpis);
        kpistemp.removeAll(kpistemp);
        for (String kpi : imgArr) {
            KPIObject obj = new KPIObject();
            editKPIParam paramobj = new editKPIParam(); //Added by Shaswat
            switch (kpi) {
            case KPI_PROC1:
                System.out.println("****************Inside KPI PROC1");
                obj.setName(KPI_PROC1);
                obj.setType("Procurement");
                obj.setResult_layout("table");
                obj.setResult_flag("B");
                obj.setReport_name("Total_po_backlog_amount");
                obj.setPage_name("showPOBackLog");
                obj.setPriority(14);
                obj.setShowTimeRadio(false);
                obj.setShowCurrent(false);
                obj.setShowOrgRadio(false);
                obj.setShowTargetType(false);
                obj.setShowTargetValue(false);
                obj.setShowBUChoice(true);
                obj.setShowLEChoice(false);
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_PROC2:
                System.out.println("*******************Inside KPI PROC2");
                obj.setName(KPI_PROC2);
                obj.setType("Procurement");
                obj.setPriority(2);
                obj.setReport_name("ShippedOrder_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_PROC3:

                obj.setName(KPI_PROC3);
                obj.setType("Procurement");
                obj.setPriority(3);
                obj.setReport_name("ShippedOrder_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_PROC4:
                obj.setName(KPI_PROC4);
                obj.setType("Procurement");
                obj.setPriority(4);
                obj.setReport_name("ShippedOrder_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_INV1:
                obj.setName(KPI_INV1);
                obj.setType("Inventory");
                obj.setPriority(5);
                obj.setReport_name("AverageInventory_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_INV2:

                obj.setName(KPI_INV2);
                obj.setType("Inventory");
                obj.setPriority(6);
                obj.setReport_name("ShippedOrder_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_INV3:
                obj.setName(KPI_INV3);
                obj.setType("Inventory");
                obj.setPriority(7);
                obj.setReport_name("StockOutRate_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_INV4:

                obj.setName(KPI_INV4);
                obj.setType("Inventory");
                obj.setPriority(8);
                obj.setReport_name("ShippedOrder_Report");
                obj.setDefParam(paramobj);//Added by Shaswat
                break;
            case KPI_SHIP1:

                obj.setName(KPI_SHIP1);
                obj.setType("Shipping");
                obj.setPriority(9);
                obj.setReport_name("BookedOrder_Report");
                obj.setResult_flag("A");
                obj.setResult_layout("table");
                obj.setPage_name("showBookedOrder");
                obj.setShowTimeRadio(true);
                obj.setShowCurrent(false);
                obj.setShowOrgRadio(true);
                obj.setShowTargetType(true);
                obj.setShowTargetValue(true);
                obj.setShowBUChoice(false);
                obj.setShowLEChoice(false);
                //Added by Shaswat
                System.out.println("Defaulting...");
                paramobj.setTimeRadio("YTD");
                paramobj.setCurrentRadio("GLOBAL");
                paramobj.setTarget("10");
                paramobj.setTarget_type("Value");
                obj.setDefParam(paramobj);
                break;
            case KPI_SHIP2:

                obj.setName(KPI_SHIP2);
                obj.setType("Shipping");
                obj.setPriority(10);
                obj.setReport_name("Shipping_Backlog_Summary_Report");
                obj.setResult_flag("A");
                obj.setResult_layout("table");
                obj.setPage_name("showBacklogSummary");
                obj.setShowTimeRadio(false);
                obj.setShowCurrent(true);
                obj.setShowOrgRadio(true);
                obj.setShowTargetType(true);
                obj.setShowTargetValue(true);
                obj.setShowBUChoice(false);
                obj.setShowLEChoice(false);
                obj.setDefParam(paramobj);//Added by Shaswat
                break;

            case KPI_AP1:

                obj.setName(KPI_AP1);
                obj.setType("Account Payables");
                obj.setPriority(11);
                obj.setReport_name("AP_Total_Supplier_Balances_Report");
                obj.setResult_flag("B");
                obj.setResult_layout("table");
                obj.setPage_name("showAPResultPG");
                obj.setShowTimeRadio(false);
                obj.setShowCurrent(true);
                obj.setShowOrgRadio(true);
                obj.setShowTargetType(false);
                obj.setShowTargetValue(false);
                obj.setShowBUChoice(false);
                obj.setShowLEChoice(false);
                //Added by Shaswat
                System.out.println("Defaulting...");
                paramobj.setCurrentRadio("GLOBAL");
                paramobj.setCurrent_timeRadio("APCurrent");
                obj.setDefParam(paramobj);
                break;


            case KPI_AR1:

                obj.setName(KPI_AR1);
                obj.setType("Account Receivables");
                obj.setPriority(12);
                obj.setReport_name("AR_Total_Dispute_Amount_Report");
                obj.setResult_flag("B");
                obj.setResult_layout("graph");
                obj.setPage_name("showARResultPG");
                obj.setShowTimeRadio(false);
                obj.setShowCurrent(true);
                obj.setShowOrgRadio(false);
                obj.setShowTargetType(false);
                obj.setShowTargetValue(false);
                obj.setShowBUChoice(true);
                obj.setShowLEChoice(true);
                //Added by Shaswat
                System.out.println("Defaulting...");
                paramobj.setCurrent_timeRadio("APCurrent");
                obj.setDefParam(paramobj);
                break;

            case KPI_AR2:

                obj.setName(KPI_AR2);
                obj.setType("Account Receivables");
                obj.setPriority(13);
                obj.setReport_name("AR_Total_Pending_Amount_Report");
                obj.setResult_flag("B");
                obj.setResult_layout("graph");
                obj.setPage_name("showPendingPG");
                obj.setShowTimeRadio(false);
                obj.setShowCurrent(true);
                obj.setShowOrgRadio(false);
                obj.setShowTargetType(false);
                obj.setShowTargetValue(false);
                obj.setShowBUChoice(true);
                obj.setShowLEChoice(true);
                //Added by Shaswat
                System.out.println("Defaulting...");
                paramobj.setCurrent_timeRadio("APCurrent");
                obj.setDefParam(paramobj);
                break;

            }


            kpis.add(obj);
            kpis.sort(new Comparator<KPIObject>() {
                @Override
                public int compare(KPIObject object, KPIObject object2) {

                    return new Integer(object.getPriority()).compareTo(object2.getPriority());
                }
            });

          
        }
        kpistemp.addAll(kpis);
        if (kpistemp.size() == 1) {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.button_label}", "Submit");

        } else if (kpistemp.size() > 1)  {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.button_label}", "Next KPI");

        }
        System.out.println("Data in Temp Array**** " + kpistemp);
        System.out.println("No of Items Items in the Array list*************** " + kpis.size());
        //System.out.println(kpis);
        String name = kpistemp.get(0).getName();//kpistemp.get(0).getType().concat("-").concat(kpistemp.get(0).getName());

        /*
         *
         *

        if ("Account Payables".equalsIgnoreCase(kpistemp.get(0).getType()) ||
            "Account Receivables".equalsIgnoreCase(kpistemp.get(0).getType())) {
            System.out.println("inside payables");
            this.setApTimeRadio(true);
            this.setAllTimePara(false);
            this.setTargettyperend(false);
            this.setOrgScoperend(true);
            this.setTargetValuerend(false);
            this.setTimerend(true);
        } else {
            System.out.println("not payables");
            this.setApTimeRadio(false);
            this.setAllTimePara(true);
            this.setTargettyperend(true);
            this.setOrgScoperend(true);
            this.setTargetValuerend(true);
            this.setTimerend(true);
        }
        //setProBackLogrend
        if ("Procurement".equalsIgnoreCase(kpistemp.get(0).getType())) {
            System.out.println("inside Procurement");
            this.setApTimeRadio(false);
            this.setAllTimePara(false);
            this.setTargettyperend(false);
            this.setTargetValuerend(false);
            this.setOrgScoperend(false);
            this.setProBackLogrend(true);
            this.setTimerend(false);
        }
        */
        this.setAllTimePara(kpistemp.get(0).getShowTimeRadio());
        this.setCurrent_timeRadio(kpistemp.get(0).getShowCurrent());
        this.setOrgScoperend(kpistemp.get(0).getShowOrgRadio());
        this.setTargettyperend(kpistemp.get(0).getShowTargetType());
        this.setTargetValuerend(kpistemp.get(0).getShowTargetValue());
        this.setLeChoice(kpistemp.get(0).getShowLEChoice());
        this.setBuChoice(kpistemp.get(0).getShowBUChoice());
        //Added by Shaswat
        System.out.println("Defaulting...");
        //System.out.println(kpistemp.get(0).getDefParam().getCurrentRadio());
        AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.timeRadio}",kpistemp.get(0).getDefParam().getTimeRadio());
        AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.currentRadio}", kpistemp.get(0).getDefParam().getCurrentRadio());
        AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.current_timeRadio}", kpistemp.get(0).getDefParam().getCurrent_timeRadio());
        AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.target}", kpistemp.get(0).getDefParam().getTarget());
        AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.target_type}", kpistemp.get(0).getDefParam().getTarget_type());

        // this.setTimerend(true);

        System.out.println("Name value " + name);
        this.setKpIText(name);
        
        if("PO BackLog".equals(name))
        {
            System.out.println("Inside DELLHITECT"+kpistemp.get(0).getName());
            AdfmfJavaUtilities.setELValue("#{applicationScope.po_back}", "DELHITECH_US_BUSINESS_UNIT");
        }
        else 
        {
           System.out.println("Inside else DELLHITECT");
            AdfmfJavaUtilities.setELValue("#{applicationScope.po_back}", "GLOBAL");    
        }

    }


    public String nextKpiPG() {
        // Add event code here...
        //http://ussltcsnl3432.solutions.glbsnet.com:7004/GetBICloud-ReportsData-context-root/resources/SCCloudReportService/result/AP_Total_Supplier_Balances_Report/CURRENT/GLOBAL/999/999/999
        System.out.println("Inside nextKpiPG page ");
        String currrentKpiname = kpistemp.get(0).getName();
        System.out.println("currrentKpiname ..."+currrentKpiname);
        
        System.out.println("currrentKpiname value *** " + currrentKpiname);
        System.out.println("Size of Kpi list ****** " + kpis.size());
        int indexKpi = -1;
        for (int i = 0; i < kpis.size(); i++) {
            System.out.println("Inside for");
            if (currrentKpiname.equalsIgnoreCase(kpis.get(i).getName())) {

                System.out.println("Value if i *** " + i);
                indexKpi = i;
                System.out.println("Value of indexKpi** " + indexKpi);
                break;
            }
        }


        //int indexKpi = kpis.indexOf(currrentKpiname);
        System.out.println("Index value ----------- " + indexKpi);
        if (AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.timeRadio}") != null) {
            Object time = (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.timeRadio}");
            System.out.println("Value of timme radio button*** " + time);
            kpis.get(indexKpi).setTime(time.toString());
            System.out.println("Value after setting ***********" + kpis.get(indexKpi).getTime());
        }

        System.out.println("Value of Organization Scope Radio button**********  " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}"));
        if (AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}") != null) {
            Object org = (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}");
            System.out.println("Value of Scope radio button*** " + org);
            kpis.get(indexKpi).setOrg_scope(org.toString());
            System.out.println("Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());

            if ((AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}")).equals("GLOBAL")) {
                System.out.println("Inside GLOBAL if");
                kpis.get(indexKpi).setOrg_value("GLOBAL");
                kpis.get(indexKpi).setOrg_scope("GLOBAL");
                System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());
            } else {
                if ((AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}")).equals("Operating Unit")) {
                    kpis.get(indexKpi).setOrg_scope("Operating Unit");
                    Object org_val2 =
                        (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.scopeRadioValue2}");
                    //"#{bindings.businessunitLovs.inputValue}"
                    Object ou_value = (Object) AdfmfJavaUtilities.getELValue("#{bindings.businessunitLovs.inputValue}");
                    System.out.println("Value of OU LOV*** " + org_val2);
                    System.out.println("New Operating Unit Value ...***..Fectched**" + ou_value);
                    if (ou_value != null) {
                        kpis.get(indexKpi).setOrg_value(ou_value.toString());
                    }
                    //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue2}", null);
                    System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getOrg_value());
                } else {
                    kpis.get(indexKpi).setOrg_scope("Organization");
                    Object org_val1 =
                        (Object) AdfmfJavaUtilities.getELValue("#{bindings.invOrgLOV.inputValue}");
                    System.out.println("Value of Organization LOV*** " + org_val1);
                    if (org_val1 != null)
                        kpis.get(indexKpi).setOrg_value(org_val1.toString());
                    //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue1}", null);
                    System.out.println("Else Value after setting ***********" + kpis.get(indexKpi).getOrg_value());
                }
            }
            //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.currentRadio}",null);
        }


        if (AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.target}") != null) {
            Object target = (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.target}");
            System.out.println("Value of target radio button*** " + target);
            kpis.get(indexKpi).setTarget_value(target.toString());
            System.out.println("Value after setting ***********" + kpis.get(indexKpi).getTarget_value());
            AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.target}", null);
        }

        if ("KPI_PROC1".equalsIgnoreCase(kpistemp.get(0).getName())) {

            System.out.println("Inside Proc Buss Lov");
            Object bu_value_backlog = (Object) AdfmfJavaUtilities.getELValue("#{bindings.businessunitLovs.inputValue}");
            System.out.println("bu_value_backlog value " + bu_value_backlog);
            if (bu_value_backlog != null) {
                kpis.get(indexKpi).setOrg_value(bu_value_backlog.toString());
            }

        }
        
        if (kpis.get(indexKpi).getShowBUChoice()) {
                   Object bu_value = (Object) AdfmfJavaUtilities.getELValue("#{bindings.businessunitLovs.inputValue}");
                   System.out.println("Value of BU Choice*** " + bu_value);
                   System.out.println("New Business Unit Value ...***..Fectched**" + bu_value);
                   if (bu_value != null) {
                    //   kpis.get(indexKpi).setOrg_value(bu_value.toString());
                       kpis.get(indexKpi).setBu_name(bu_value.toString());
                   }
                   //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue2}", null);
                   System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getBu_name());
               }
        
        if (kpis.get(indexKpi).getShowLEChoice()) {
                   Object le_value = (Object) AdfmfJavaUtilities.getELValue("#{bindings.legalEntityLOV.inputValue}");
                   System.out.println("Value of LE Choice*** " + le_value);
                   System.out.println("New Business Unit Value ...***..Fectched**" + le_value);
                   if (le_value != null) {
                   // kpis.get(indexKpi).setLe_name(le_name);
                       kpis.get(indexKpi).setLe_name(le_value.toString());
                   }
                   //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue2}", null);
                   System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getLe_name());
               }
        
        
        System.out.println("Main Array Value******* " + kpis);

        kpistemp.remove(0);
        String requestURI = null;
        String actual_value = null;
        
        if (kpistemp.isEmpty()) {
            SubmitService ss = new SubmitService();
            System.out.println("List is Empty");
            Float value_difference;
            String ap_total_supp = null;
            String ar_total_dis_amt = null;
            String po_total_amt = null;
            String pend_cust_pay = null;
            for (int i = 0; i < kpis.size(); i++) {
                System.out.println("Inside for List Empty");
                System.out.println("Value of KPI Name** " + kpis.get(i).getName());
                System.out.println("Value of result flag..." + kpis.get(i).getResult_flag());
                //Addedby maitri
                //String requestURI = "/ShippedOrder_Report/YTD/Global/9999999";
                if ("A".equalsIgnoreCase(kpis.get(i).getResult_flag())) {
                    requestURI =
                        "/" + kpis.get(i).getReport_name() + "/" + kpis.get(i).getTime() + "/" +
                        kpis.get(i).getOrg_value() + "/999999";
                    actual_value = null;
                    actual_value = ss.getOutputValue(requestURI);

                    kpis.get(i).setActual_value(actual_value);
                    System.out.println("Actual value set in KPI object :" + kpis.get(i).getActual_value());

                    value_difference =
                        Float.parseFloat(kpis.get(i).getActual_value()) -
                        Float.parseFloat(kpis.get(i).getTarget_value());

                    kpis.get(i).setValue_difference(Float.toString(value_difference));
                    if (value_difference >= 0) {
                        image_name = "/resources/images/upTriangle.png";
                    } else {
                        image_name = "/resources/images/downTriangle.png";
                    }
                    kpis.get(i).setImage_icon(image_name);

                    System.out.println("Actual value** " + kpis.get(i).getActual_value());
                    System.out.println("Value Difference** " + kpis.get(i).getValue_difference());
                    //end if changes by maitri
                }
           // Check this code -Maitri
              //  if ("B".equalsIgnoreCase(kpis.get(i).getResult_flag())) {

                if ("AP_Total_Supplier_Balances_Report".equalsIgnoreCase(kpis.get(i).getReport_name())) 
                {
                    System.out.println("AP_Total_Supplier_Balances_Report");
                    String org_scpe = kpis.get(i).getOrg_scope();
                    System.out.println("ORG Scope Value ..." + org_scpe);
                    //requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "CURRENT"  + "/" + "GLOBAL"  + "/" + "999";
                    requestURI =
                        "/" + kpis.get(i).getReport_name() + "/" + "CURRENT" + "/" + kpis.get(i).getOrg_value() + "/" +
                        "999";
                
                    actual_value = ss.getOutputValue(requestURI);
                    kpis.get(i).setActual_value(actual_value);
                    kpis_button.add(kpis.get(i));
                    System.out.println("kpis_button value ........" + kpis_button);
                    //kpis_button.get(i).setReport_name(kpis.get(i).getReport_name());
                    //kpis_button.get(i).setType(kpis.get(i).getType());
                    System.out.println("Amount value " + actual_value);
                    suppAmt = actual_value + "M$";
                    System.out.println("suppAmt value new********" + suppAmt);
                    ap_total_supp = "y";
                    ///this.setSuppAmt(suppAmt);
                    this.setPayablesrend(true);
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.suppAmt}",suppAmt);

                    /*requestURI =
                        "/" + kpis.get(i).getReport_name() + "/" + kpis.get(i).getTime() + "/" +
                        kpis.get(i).getOrg_value() + "/999999";*/
                } else {
                    System.out.println("Inside else AP_Total_Supplier_Balances_Report");
                    if ("y".equalsIgnoreCase(ap_total_supp)) {
                        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.suppAmt}",suppAmt);
                        System.out.println("Inside Y");
                        ///this.setSuppAmt(suppAmt);
                        this.setPayablesrend(true);
                    } else {
                        System.out.println("Inside not y");
                        //String chnsuppAmt = "set";
                        //this.setSuppAmt(suppAmt);
                        this.setPayablesrend(false);
                    }
                }

                if ("AR_Total_Dispute_Amount_Report".equalsIgnoreCase(kpis.get(i).getReport_name())) {
                    System.out.println("AR_Total_Dispute_Amount_Report");
                    System.out.println("Inside Toatl Disputes.");
                    //requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "GLOBAL"  + "/" + "GLOBAL"  + "/" + "999";
                    //requestURI = "/AR_Total_Dispute_Amount_Report/CURRENT/GLOBAL/GLOBAL";
                    requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "CURRENT"  + "/" + kpis.get(i).getBu_name()  + "/" + kpis.get(i).getLe_name();
                    actual_value = ss.getOutputValue(requestURI);

                    kpis.get(i).setActual_value(actual_value);
                    kpis_button.add(kpis.get(i));
                    System.out.println("AR kpis_button value *****........" + kpis_button);
                    System.out.println("Amount value " + actual_value);
                    custAmt = actual_value;
                    System.out.println("custAmt value ********" + custAmt);
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.custAmt}",custAmt);
                    System.out.println("NEW *** custAmt value ********" + custAmt);
                    ar_total_dis_amt = "y";
                    //this.setCustAmt(custAmt);
                    //this.setRecrend(true);
                    this.setPayablesrend(true);
                }

                else {
                    if ("y".equalsIgnoreCase(ar_total_dis_amt)) {
                        //this.setCustAmt(custAmt);
                        //this.setRecrend(true);
                        this.setPayablesrend(true);
                    } else {
                        //this.setRecrend(false);
                        this.setPayablesrend(false);
                    }

                }

                //Pending Customer payments
                if ("AR_Total_Pending_Amount_Report".equalsIgnoreCase(kpis.get(i).getReport_name())) {
                    System.out.println("AR_Total_Pending_Amount_Report");

                    //requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "GLOBAL"  + "/" + "GLOBAL"  + "/" + "999";
                   // requestURI = "/AR_Total_Pending_Amount_Report/CURRENT/GLOBAL/GLOBAL";
                    requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "CURRENT"  + "/" + kpis.get(i).getBu_name()  + "/" + kpis.get(i).getLe_name();
                    actual_value = ss.getOutputValue(requestURI);

                    kpis.get(i).setActual_value(actual_value);
                    kpis_button.add(kpis.get(i));
                    System.out.println("AR_Total_Pending_Amount_Report kpis_button value *****........" + kpis_button);
                    System.out.println("Pending Amount value " + actual_value);
                    custAmt = actual_value;
                    System.out.println("custAmt value ********" + custAmt);
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.custAmt}",custAmt);
                    System.out.println("NEW *** custAmt value ********" + custAmt);
                    pend_cust_pay = "y";
                    //this.setCustAmt(custAmt);
                    //this.setRecrend(true);
                    this.setPayablesrend(true);
                }

                else {
                    if ("y".equalsIgnoreCase(pend_cust_pay)) {
                        //this.setCustAmt(custAmt);
                        //this.setRecrend(true);
                        this.setPayablesrend(true);
                    } else {
                        //this.setRecrend(false);
                        this.setPayablesrend(false);
                    }

                }
                //End of pending Customer

                if ("Total_po_backlog_amount".equalsIgnoreCase(kpis.get(i).getReport_name())) {

                    String org_val = kpis.get(i).getBu_name();
                    System.out.println("Inside total po backlog........." + org_val);
                    //requestURI = "/Total_po_backlog_amount/DELHITECH_US_BUSINESS_UNIT/GLOBAL/999";
                    requestURI =  "/" + kpis.get(i).getReport_name() + "/" + kpis.get(i).getBu_name()  + "/" + "999" + "/" + "999";
                    String po_backlog = ss.getOutputValue(requestURI);
                    System.out.println("po_backlog value" + po_backlog);

                    kpis.get(i).setActual_value(po_backlog);
                    kpis_button.add(kpis.get(i));
                    System.out.println("PO Backlog kpis_button value *****........" + kpis_button);
                    System.out.println("Amount value " + po_backlog);
                    custAmt = po_backlog;
                    System.out.println("custAmt value ********" + custAmt);
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.custAmt}",custAmt);
                    System.out.println("NEW *** custAmt value ********" + custAmt);
                    po_total_amt = "y";
                    //this.setCustAmt(custAmt);
                    this.setPayablesrend(true);
                    this.setRecrend(true);
                }


            }


            System.out.println("EDIT CONTROL KPIS Size in " + kpis.size());
            System.out.println("KPIS " + kpis);
            System.out.println("suppAmt *** value " + suppAmt);
            boolean distcust_flag = false;
            boolean pendCust_flag = false;
            boolean pobacklog_flag = false;
            boolean apsupp_flag = false;
           boolean kpiship1_flag = false;

            for (int i = 0; i < kpis.size(); i++) 
            {
                System.out.println("Inside for");
                System.out.println("Value of KPI Name** " + kpis.get(i).getName());
                System.out.println("Value of Time Name** " + kpis.get(i).getTime());
                System.out.println("Value of Org Name** " + kpis.get(i).getOrg_scope());
                System.out.println("Value of Target Name** " + kpis.get(i).getTarget_value());
                
                
                if(12 == (kpis.get(i).getPriority())) 
                {
                    System.out.println("Inside this.setResultDisCusRend(true);");
                    this.setResultDisCusRend(true);
                    distcust_flag = true;
                }
                else 
                {
                    if(!distcust_flag)
                    {
                    System.out.println("Inside else this.setResultDisCusRend(true);");
                    this.setResultDisCusRend(false);
                    }
                }
                
                if(13 == (kpis.get(i).getPriority())) 
                {
                    System.out.println("Inside this.setResultPenCusRend(true);");
                    this.setResultPenCusRend(true);
                    pendCust_flag = true;
                }
                else 
                {
                    if(!pendCust_flag)
                    {
                        System.out.println("Inside else this.setResultPenCusRend(true);");
                        this.setResultPenCusRend(false);
                   }
                }
                if(14 == (kpis.get(i).getPriority())) 
                {
                    System.out.println("Inside this.setResultPOBacLogRend(true);");
                    this.setResultPOBacLogRend(true);
                    pobacklog_flag = true;
                }
                else 
                {
                    if(!pobacklog_flag)
                    {
                        System.out.println("Inside else this.setResultPOBacLogRend(true);");
                        this.setResultPOBacLogRend(false);
                    }
                }
                
                if(11 == (kpis.get(i).getPriority())) 
                {
                    System.out.println("Inside this.setResultAPSupprend(true);");
                    this.setResultAPSupprend(true);
                    apsupp_flag = true;
                }
                else 
                {
                    if(!apsupp_flag)
                    {
                        System.out.println("Inside else this.setResultAPSupprend(true);");
                        this.setResultAPSupprend(false);
                    }    
                }
              
              if(9 == (kpis.get(i).getPriority())) 
              {
                  this.setResultKPIShip1rend(true);
                  kpiship1_flag = true;
              }
              else 
              {
                  if(!kpiship1_flag)
                  {
                      this.setResultKPIShip1rend(false);
                  }    
              }

            }
            //Added by Hardik Shah for Inserting new record
            DBAdapter db1 = new DBAdapter();
            System.out.println("Before Insert query");
            String username = null;
            username = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
            System.out.println("username........"+username);
            if(!"".equals(AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}")))
            {//AdfmfJavaUtilities.getELValue("#{applicationScope.LoginBean.userName}")
             username = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();//AdfmfJavaUtilities.getELValue("#{applicationScope.LoginBean.userName}").toString();   
             System.out.println("username inside EDITKpi Control.."+username);
             
            } 
            System.out.println("kpis.size....."+kpis.size());
            for(int i = 0;i<kpis.size();i++)
            {
                System.out.println("kpis Report name ..."+kpis.get(i).getReport_name());
                try {
                    System.out.println("Inside try kpis");
                   ResultSet rs = db1.executeQuery("SELECT USER_NAME,ORG_VALUE,PRIORITY,REPORT_NAME,BU_NAME,LEGAL_ENITY FROM Login_Details WHERE USER_NAME = '"+username+"'");
                   System.out.println("After resultset............."+rs);
                   System.out.println("Inside Try...");
                   boolean rs1 = db1.executeUpdate("INSERT INTO Login_Details (USER_NAME,REPORT_NAME,ORG_VALUE,BU_NAME,LEGAL_ENITY,PRIORITY) VALUES ('"+username+"','"+kpis.get(i).getReport_name()+"','"+kpis.get(i).getOrg_value()+"','"+kpis.get(i).getBu_name()+"','"+kpis.get(i).getLe_name()+"',"+kpis.get(i).getPriority()+")");
                   
               } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
               
            //CREATE TABLE Login_Details (USER_NAME VARCHAR2(2000),REPORT_NAME VARCHAR2(2000),ORG_VALUE VARCHAR2(2000),BU_NAME VARCHAR2(2000),LEGAL_ENITY VARCHAR2(2000),PRIORITY NUMBER);
            }
            System.out.println("After Insert query");
            ResultControl rc = new ResultControl();
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.priority}","21");
            System.out.println("Priority value...");
            rc.resultDefaultKpi(); 
            return "*showResPG";
        } else {
            System.out.println("list is not empty");
            //fetching the button name
            if (kpistemp.size() == 1) {
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.button_label}", "Submit");

            } else {
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.button_label}", "Next KPI");

            }
            String name = kpistemp.get(0).getName();//kpistemp.get(0).getType().concat("-").concat(kpistemp.get(0).getName());
            /*
            if ("Account Payables".equalsIgnoreCase(kpistemp.get(0).getType()) ||
                "Account Receivables".equalsIgnoreCase(kpistemp.get(0).getType())) //
            {
                System.out.println("inside payables nextKPI ******************************");
                this.setApTimeRadio(true);
                this.setAllTimePara(false);
                this.setTargettyperend(false);
                this.setProBackLogrend(false);
                this.setOrgScoperend(true);
                this.setTargetValuerend(false);
                this.setTimerend(true);

            }
            if ("Procurement".equalsIgnoreCase(kpistemp.get(0).getType())) {
                System.out.println("inside Procurement *************************");
                this.setApTimeRadio(false);
                this.setAllTimePara(false);
                this.setTargettyperend(false);
                this.setTargetValuerend(false);
                this.setOrgScoperend(false);
                this.setProBackLogrend(true);
                this.setTimerend(false);
            }
*/
            this.setAllTimePara(kpistemp.get(0).getShowTimeRadio());
            this.setCurrent_timeRadio(kpistemp.get(0).getShowCurrent());
            this.setOrgScoperend(kpistemp.get(0).getShowOrgRadio());
            this.setTargettyperend(kpistemp.get(0).getShowTargetType());
            this.setTargetValuerend(kpistemp.get(0).getShowTargetValue());
            this.setLeChoice(kpistemp.get(0).getShowLEChoice());
            this.setBuChoice(kpistemp.get(0).getShowBUChoice());
            //Added by Shaswat
            System.out.println("Defaulting...");
           System.out.println(kpistemp.get(0).getDefParam().getCurrentRadio());
            AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.timeRadio}",kpistemp.get(0).getDefParam().getTimeRadio());
           AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.currentRadio}", kpistemp.get(0).getDefParam().getCurrentRadio());
           AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.current_timeRadio}", kpistemp.get(0).getDefParam().getCurrent_timeRadio());
           AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.target}", kpistemp.get(0).getDefParam().getTarget());
           AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.target_type}", kpistemp.get(0).getDefParam().getTarget_type());
           
            if("PO BackLog".equals(name))
            {
                System.out.println("Inside DELLHITECT"+kpistemp.get(0).getName());
                AdfmfJavaUtilities.setELValue("#{applicationScope.po_back}", "DELHITECH_US_BUSINESS_UNIT");
            }
            else 
            {
               System.out.println("Inside else DELLHITECT");
                AdfmfJavaUtilities.setELValue("#{applicationScope.po_back}", "GLOBAL");    
            }
           
            System.out.println("Name value Inside nextKpiPG****** " + name);
            this.setKpIText(name);
            return "*proc_back";
        }

    }


    public void setKpIText(String kpIText) {

        String oldKpIText = this.kpIText;
        this.kpIText = kpIText;
        _propertyChangeSupport.firePropertyChange("kpIText", oldKpIText, kpIText);
    }

    public String getKpIText() {
        return kpIText;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport _propertyChangeSupport) {
        this._propertyChangeSupport = _propertyChangeSupport;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return _propertyChangeSupport;
    }

    public void setKpi_inv1(String kpi_inv1) {
        this.kpi_inv1 = kpi_inv1;
    }

    public String getKpi_inv1() {
        return kpi_inv1;
    }

    public void setInv1_ac(String inv1_ac) {
        this.inv1_ac = inv1_ac;
    }

    public String getInv1_ac() {
        return inv1_ac;
    }

    public void setInv1_t(String inv1_t) {
        this.inv1_t = inv1_t;
    }

    public String getInv1_t() {
        return inv1_t;
    }

    public void setInv1_diff(String inv1_diff) {
        this.inv1_diff = inv1_diff;
    }

    public String getInv1_diff() {
        return inv1_diff;
    }


    public KPIObject[] getAddedKPIS() {
        System.out.println("Inside addedkpis method");
        KPIObject[] addedKpis = null;
        System.out.println("KPI Size :" + kpis.size());
        addedKpis = (KPIObject[]) kpis.toArray(new KPIObject[kpis.size()]);
        System.out.println("In getAddedKPIS abc:" + AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.abc}"));
        a = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("Array List value " + a);
        addedKpis = a.toArray(new KPIObject[a.size()]);


        System.out.println("AddedKPI Size :" + addedKpis.length);
        System.out.println("In getAddedKPIS kpis:" + AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}"));
        return addedKpis;
    }

    public KPIObject[] getAddedKPIS_button() {
        System.out.println("Inside _button method");
        KPIObject[] addedKpis_button = null;
        ArrayList<KPIObject> added_butt = new ArrayList<KPIObject>();
        // added_butt.removeAll(kpis_button);
        //a = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("Added Button value...." +
                           AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}"));
        added_butt = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}");
        //addedKpis_button = (ArrayList<KPIObject>) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}");
        addedKpis_button = added_butt.toArray(new KPIObject[added_butt.size()]);
        System.out.println("addedKpis_button ............." + addedKpis_button);
        return addedKpis_button;
    }

    //Added by Maitri
    public KPIObject[] getAddedKPIS_dashboard() {
        System.out.println("Inside _dasboard method");
        KPIObject[] addedKpis_dashboard = null;
        // ArrayList a = new ArrayList();
        ArrayList<KPIObject> b_temp = new ArrayList<KPIObject>();

        System.out.println("KPI Size in dashboard DC:" + kpis.size());
        // addedKpis_dashboard = (KPIObject[]) kpis.toArray(new KPIObject[kpis.size()]);

        b = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("Array List value " + b);

        //addedKpis =  (KPIObject[])AdfmfJavaUtilities.getELValue(kpis);
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).getResult_flag().equals("A")) {
                b_temp.add(b.get(i));
            }
        }
        addedKpis_dashboard = b_temp.toArray(new KPIObject[b_temp.size()]);


        System.out.println("AddedKPI_dashboard Size :" + addedKpis_dashboard.length);


        System.out.println("Length of final dashboard array " + addedKpis_dashboard.length);
        return addedKpis_dashboard;
    }
    // End of Maitri


    public void setApTimeRadio(boolean apTimeRadio) {
        boolean oldApTimeRadio = this.apTimeRadio;
        this.apTimeRadio = apTimeRadio;
        _propertyChangeSupport.firePropertyChange("apTimeRadio", oldApTimeRadio, apTimeRadio);
    }

    public void setAllTimePara(boolean allTimePara) {
        boolean oldAllTimePara = this.allTimePara;
        this.allTimePara = allTimePara;
        _propertyChangeSupport.firePropertyChange("allTimePara", oldAllTimePara, allTimePara);
    }

    public boolean isAllTimePara() {
        return allTimePara;
    }

    public boolean isApTimeRadio() {
        return apTimeRadio;
    }


    public void setSuppAmt(String suppAmt) {
        String oldSuppAmt = this.suppAmt;
        this.suppAmt = suppAmt;
        System.out.println("inside method value " + suppAmt);
        System.out.println("this value.." + this.suppAmt);
        _propertyChangeSupport.firePropertyChange("suppAmt", oldSuppAmt, suppAmt);
    }


    public String getSuppAmt() {
        return suppAmt;
    }

    public void setCustAmt(String custAmt) {
        String oldCustAmt = this.custAmt;
        this.custAmt = custAmt;
        _propertyChangeSupport.firePropertyChange("custAmt", oldCustAmt, custAmt);
    }

    public String getCustAmt() {
        return custAmt;
    }

    public void setTargettyperend(boolean targettyperend) {
        boolean oldTargettyperend = this.targettyperend;
        this.targettyperend = targettyperend;
        _propertyChangeSupport.firePropertyChange("targettyperend", oldTargettyperend, targettyperend);
    }

    public boolean isTargettyperend() {
        return targettyperend;
    }


    public void setTargetValuerend(boolean targetValuerend) {
        boolean oldTargetValuerend = this.targetValuerend;
        this.targetValuerend = targetValuerend;
        _propertyChangeSupport.firePropertyChange("targetValuerend", oldTargetValuerend, targetValuerend);
    }

    public boolean isTargetValuerend() {
        return targetValuerend;
    }


    public void setPayablesrend(boolean payablesrend) {
        boolean oldPayablesrend = this.payablesrend;
        this.payablesrend = payablesrend;
        _propertyChangeSupport.firePropertyChange("payablesrend", oldPayablesrend, payablesrend);
    }

    public boolean isPayablesrend() {
        return payablesrend;
    }

    public void setRecrend(boolean recrend) {
        boolean oldRecrend = this.recrend;
        this.recrend = recrend;
        _propertyChangeSupport.firePropertyChange("recrend", oldRecrend, recrend);
    }

    public boolean isRecrend() {
        return recrend;
    }


    public void setProBackLogrend(boolean proBackLogrend) {
        boolean oldProBackLogrend = this.proBackLogrend;
        this.proBackLogrend = proBackLogrend;
        _propertyChangeSupport.firePropertyChange("proBackLogrend", oldProBackLogrend, proBackLogrend);
    }

    public boolean isProBackLogrend() {
        return proBackLogrend;
    }


    public void setOrgScoperend(boolean orgScoperend) {
        boolean oldOrgScoperend = this.orgScoperend;
        this.orgScoperend = orgScoperend;
        _propertyChangeSupport.firePropertyChange("orgScoperend", oldOrgScoperend, orgScoperend);
    }

    public boolean isOrgScoperend() {
        return orgScoperend;
    }


    public void setChnship2Opa(String chnship2Opa) {
        String oldChnship2Opa = this.chnship2Opa;
        this.chnship2Opa = chnship2Opa;
        _propertyChangeSupport.firePropertyChange("chnship2Opa", oldChnship2Opa, chnship2Opa);
    }

    public String getChnship2Opa() {
        return chnship2Opa;
    }


    public void setResultDisCusRend(boolean resultDisCusRend) {
        boolean oldResultDisCusRend = this.resultDisCusRend;
        this.resultDisCusRend = resultDisCusRend;
        _propertyChangeSupport.firePropertyChange("resultDisCusRend", oldResultDisCusRend, resultDisCusRend);
    }

    public boolean isResultDisCusRend() {
        return resultDisCusRend;
    }


    public void setResultPenCusRend(boolean resultPenCusRend) {
        boolean oldResultPenCusRend = this.resultPenCusRend;
        this.resultPenCusRend = resultPenCusRend;
        _propertyChangeSupport.firePropertyChange("resultPenCusRend", oldResultPenCusRend, resultPenCusRend);
    }

    public boolean isResultPenCusRend() {
        return resultPenCusRend;
    }


    public void setResultPOBacLogRend(boolean resultPOBacLogRend) {
        boolean oldResultPOBacLogRend = this.resultPOBacLogRend;
        this.resultPOBacLogRend = resultPOBacLogRend;
        _propertyChangeSupport.firePropertyChange("resultPOBacLogRend", oldResultPOBacLogRend, resultPOBacLogRend);
    }

    public boolean isResultPOBacLogRend() {
        return resultPOBacLogRend;
    }


    public void setResultAPSupprend(boolean resultAPSupprend) 
    {
        boolean oldResultAPSupprend = this.resultAPSupprend;
        this.resultAPSupprend = resultAPSupprend;
        _propertyChangeSupport.firePropertyChange("resultAPSupprend", oldResultAPSupprend, resultAPSupprend);
    }

    public boolean isResultAPSupprend() {
        return resultAPSupprend;
    }

  public void setResultKPIShip1rend(boolean resultKPIShip1rend)
  {
    boolean oldResultKPIShip1rend = this.resultKPIShip1rend;
    this.resultKPIShip1rend = resultKPIShip1rend;
    _propertyChangeSupport.firePropertyChange("resultKPIShip1rend", oldResultKPIShip1rend, resultKPIShip1rend);
  }

  public boolean isResultKPIShip1rend()
  {
    return resultKPIShip1rend;
  }
}
