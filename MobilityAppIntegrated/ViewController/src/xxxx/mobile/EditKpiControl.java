package xxxx.mobile;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.Comparator;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.service.ReportService;
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
    
    private boolean apTimeRadio = false;
    private String suppAmt = null;
    private String custAmt = null;
    private boolean targettyperend = false;
    private boolean targetValuerend = false;
    private boolean payablesrend;
    private boolean recrend;


    public void setChnDisCustOpa(String chnDisCustOpa) {
        String oldChnDisCustOpa = this.chnDisCustOpa;
        this.chnDisCustOpa = chnDisCustOpa;
        _propertyChangeSupport.firePropertyChange("chnDisCustOpa", oldChnDisCustOpa, chnDisCustOpa);
    }

    public String getChnDisCustOpa() {
        return chnDisCustOpa;
    }
    private boolean allTimePara = true;
    private String chnDisCustOpa = "EditKPIorg";



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
    String image_name;

    private String chnYTDOpa = "EditKPIorg";
    ArrayList<String> imgArr = new ArrayList<String>();
    public ArrayList<KPIObject> kpis = new ArrayList<KPIObject>();

    public ArrayList<KPIObject> kpis_target = new ArrayList<KPIObject>();
    public ArrayList<KPIObject> kpis_button = new ArrayList<KPIObject>();
    public ArrayList<KPIObject> kpistemp = new ArrayList<KPIObject>();
    ArrayList<KPIObject> a = new ArrayList<KPIObject>();

    public void setA(ArrayList<KPIObject> a) {
        ArrayList<KPIObject> oldA = this.a;
        this.a = a;
        _propertyChangeSupport.firePropertyChange("a", oldA, a);
    }

    public ArrayList<KPIObject> getA() {
        return a;
    }

    private String kpi_inv1;
    private String inv1_ac;
    private String inv1_t;
    private String inv1_diff;
    private String abc = null;

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
    private boolean invkiprend = false;
    private boolean openPORend = false;

    private final String KPI_PROC1 = "Pending PR";
    private final String KPI_PROC2 = "Open PO";
    private final String KPI_PROC3 = "Expiring BPA";
    private final String KPI_PROC4 = "Invoice Pending";

    private final String KPI_INV1 = "Inventory T/O";
    private final String KPI_INV2 = "Inventory To Sales Ratio";
    private final String KPI_INV3 = "Stock out";
    private final String KPI_INV4 = "Obsolete Inventory";

    private final String KPI_SHIP1 = "Orders booked";
    private final String KPI_SHIP2 = "Value of shipment";
    
    private final String KPI_AP1 = "Top 10 Outstanding Suppliers";
    
    private final String KPI_AR1 = "Disputed Customer Payments";
    
    private String kpIText = "abc";


    public EditKpiControl() {
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
       public String changeYTDValueOpacity() 
       {

           System.out.println("Inside changeYTDValueOpacity");
           if (this.chnYTDValueOpa.equals("EditKPIorg")) 
           {
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
        if (this.chnSuppOpa.equals("EditKPIorg")) 
        {
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
        if (this.chnDisCustOpa.equals("EditKPIorg")) 
        {
            this.setChnDisCustOpa("EditKPIopct");
            imgArr.add(KPI_AR1);
        } else {
            this.setChnDisCustOpa("EditKPIorg");
            imgArr.remove(KPI_AR1);
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


    public String nextKpiPG() 
    {
        // Add event code here...
        //http://ussltcsnl3432.solutions.glbsnet.com:7004/GetBICloud-ReportsData-context-root/resources/SCCloudReportService/result/AP_Total_Supplier_Balances_Report/CURRENT/GLOBAL/999/999/999 
        System.out.println("Inside nextKpiPG page ");
        String currrentKpiname = kpistemp.get(0).getName();
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
        if (AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}") != null) 
        {
            Object org = (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}");
            System.out.println("Value of Scope radio button*** " + org);
            kpis.get(indexKpi).setOrg_scope(org.toString());
            System.out.println("Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());

            if ((AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}")).equals("Global"))
            {
                System.out.println("Inside GLOBAL if");
                kpis.get(indexKpi).setOrg_value("GLOBAL");
                System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());
            }
            else
            {    
            if ((AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.currentRadio}")).equals("Operating Unit")) 
            {
                Object org_val2 =
                    (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.scopeRadioValue2}");
                //"#{bindings.businessunitLovs.inputValue}" 
                Object ou_value = (Object)AdfmfJavaUtilities.getELValue("#{bindings.businessunitLovs.inputValue}");
                System.out.println("Value of OU LOV*** " + org_val2);
                System.out.println("New Operating Unit Value ...***..Fectched**"+ou_value);
                if(ou_value!=null)
                {
                    kpis.get(indexKpi).setOrg_value(ou_value.toString());
                }
                //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue2}", null);
                System.out.println("Operating Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());
            } 
            else 
            {
                Object org_val1 =
                    (Object) AdfmfJavaUtilities.getELValue("#{applicationScope.editKPIParam.scopeRadioValue1}");
                System.out.println("Value of Organization LOV*** " + org_val1);
                if(org_val1!=null)
                kpis.get(indexKpi).setOrg_value(org_val1.toString());
                //AdfmfJavaUtilities.setELValue("#{applicationScope.editKPIParam.scopeRadioValue1}", null);
                System.out.println("Else Value after setting ***********" + kpis.get(indexKpi).getOrg_scope());
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
        System.out.println("Main Array Value******* " + kpis);

        for (int i = 0; i < kpis.size(); i++) 
        {
            System.out.println("Inside for");
            System.out.println("Value of KPI Name** " + kpis.get(i).getName());
            System.out.println("Value of Time Name** " + kpis.get(i).getTime());
            System.out.println("Value of Org Name** " + kpis.get(i).getOrg_scope());
            System.out.println("Value of Target Name** " + kpis.get(i).getTarget_value());

        }


        kpistemp.remove(0);
        String requestURI = null;
        String actual_value = null;
        if (kpistemp.isEmpty()) 
        {
            SubmitService ss = new SubmitService();
            System.out.println("List is Empty");
            Float value_difference;
            String ap_total_supp = null;
            String ar_total_dis_amt = null;
            for (int i = 0; i < kpis.size(); i++) 
            {
                System.out.println("Inside for List Empty");
                System.out.println("Value of KPI Name** " + kpis.get(i).getName());
                //Addedby maitri
                //String requestURI = "/ShippedOrder_Report/YTD/Global/9999999";
                
                if("AP_Total_Supplier_Balances_Report".equalsIgnoreCase(kpis.get(i).getReport_name())) 
                {
                    System.out.println("AP_Total_Supplier_Balances_Report");
                    String org_scpe = kpis.get(i).getOrg_scope(); 
                    System.out.println("ORG Scope Value ..."+org_scpe);
                    //requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "CURRENT"  + "/" + "GLOBAL"  + "/" + "999";
                    requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "CURRENT"  + "/" + kpis.get(i).getOrg_scope() + "/" + "999";
                    actual_value = ss.getOutputValue(requestURI);
                     kpis.get(i).setActual_value(actual_value);
                     kpis_button.add(kpis.get(i));
                     System.out.println("kpis_button value ........"+kpis_button);
                     //kpis_button.get(i).setReport_name(kpis.get(i).getReport_name());
                     //kpis_button.get(i).setType(kpis.get(i).getType());
                    System.out.println("Amount value "+actual_value);
                    suppAmt = actual_value + "M$";
                    System.out.println("suppAmt value new********"+suppAmt);
                    ap_total_supp = "y";
                    this.setSuppAmt(suppAmt);
                    this.setPayablesrend(true);
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.suppAmt}",suppAmt);
                    
                    /*requestURI =
                        "/" + kpis.get(i).getReport_name() + "/" + kpis.get(i).getTime() + "/" +
                        kpis.get(i).getOrg_value() + "/999999";*/
                 }
                else 
                {
                    if("y".equalsIgnoreCase(ap_total_supp)) 
                    {
                        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.suppAmt}",suppAmt);
                        System.out.println("Inside Y");
                        this.setSuppAmt(suppAmt);
                        this.setPayablesrend(true);
                    }
                    else 
                    {
                        System.out.println("Inside not y");
                        //String chnsuppAmt = "set";
                        //this.setSuppAmt(suppAmt);
                        this.setPayablesrend(false);
                    }
                }
                
              if("AR_Total_Dispute_Amount_Report".equalsIgnoreCase(kpis.get(i).getReport_name())) 
                    {
                        System.out.println("AR_Total_Dispute_Amount_Report");
                        System.out.println("Inside Toatl Disputes.");
                        //requestURI =  "/" + kpis.get(i).getReport_name() + "/" + "GLOBAL"  + "/" + "GLOBAL"  + "/" + "999";
                        requestURI = "/AR_Total_Dispute_Amount_Report/CURRENT/GLOBAL/GLOBAL";
                        actual_value = ss.getOutputValue(requestURI);
                       
                        kpis.get(i).setActual_value(actual_value);
                        kpis_button.add(kpis.get(i));
                        System.out.println("AR kpis_button value *****........"+kpis_button);
                        System.out.println("Amount value "+actual_value);
                        custAmt = actual_value;
                        System.out.println("custAmt value ********"+custAmt);
                        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.custAmt}",custAmt);
                        System.out.println("NEW *** custAmt value ********"+custAmt);
                        ar_total_dis_amt = "y";
                        //this.setCustAmt(custAmt);
                        this.setRecrend(true);
                    }
                    
                    else
                    {
                      if("y".equalsIgnoreCase(ar_total_dis_amt)) 
                      {
                          this.setCustAmt(custAmt);
                          this.setRecrend(true);
                      }
                      else 
                      {
                         this.setRecrend(false);
                      }
                   
                    }
            }
            
            System.out.println("KPIS Size in " + kpis.size());
            System.out.println("KPIS " + kpis);
            System.out.println("suppAmt *** value "+suppAmt);

            return "*showResPG";
        } 
        else {
            System.out.println("list is not empty");
            String name = kpistemp.get(0).getName().concat("-").concat(kpistemp.get(0).getType());
            if("Account Payables".equalsIgnoreCase(kpistemp.get(0).getType()) || "Account Receivables".equalsIgnoreCase(kpistemp.get(0).getType()))//

            {
                System.out.println("inside payables nextKPI");
                this.setApTimeRadio(true);
                this.setAllTimePara(false);
                this.setTargettyperend(false);
                this.setTargetValuerend(false);
            }
            else 
            {
                System.out.println("else not payables nextKPI");
                this.setApTimeRadio(false);
                this.setAllTimePara(true);
                this.setTargettyperend(true);
                this.setTargetValuerend(true);
            }
            System.out.println("Name value Inside nextKpiPG****** " + name);
            this.setKpIText(name);
            return "*proc_back";
        }

    }

    public void onSubmit(ActionEvent actionEvent) {
        // Add event code here...

        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.toggleBean.kpis}", kpis);
        System.out.println("ABC value :" + kpis);
        System.out.println("Image Array Value***************************************** " + imgArr);
        kpis.removeAll(kpis);
        kpistemp.removeAll(kpistemp);
        for (String kpi : imgArr) 
        {
            KPIObject obj = new KPIObject();
            switch (kpi) {
            case KPI_PROC1:
                System.out.println("****************Inside KPI PROC1");
                obj.setName(KPI_PROC1);
                obj.setType("Procurement");
                obj.setReport_name("ShippedOrder_Report");
                obj.setResult_flag("A");
                obj.setPriority(1);
                break;
            case KPI_PROC2:
                System.out.println("*******************Inside KPI PROC2");
                obj.setName(KPI_PROC2);
                obj.setType("Procurement");
                obj.setPriority(2);
                obj.setReport_name("ShippedOrder_Report");
                break;
            case KPI_PROC3:

                obj.setName(KPI_PROC3);
                obj.setType("Procurement");
                obj.setPriority(3);
                obj.setReport_name("ShippedOrder_Report");
                break;
            case KPI_PROC4:
                obj.setName(KPI_PROC4);
                obj.setType("Procurement");
                obj.setPriority(4);
                obj.setReport_name("ShippedOrder_Report");
                break;
            case KPI_INV1:
                obj.setName(KPI_INV1);
                obj.setType("Inventory");
                obj.setPriority(5);
                obj.setReport_name("AverageInventory_Report");
                break;
            case KPI_INV2:

                obj.setName(KPI_INV2);
                obj.setType("Inventory");
                obj.setPriority(6);
                obj.setReport_name("ShippedOrder_Report");
                break;
            case KPI_INV3:
                obj.setName(KPI_INV3);
                obj.setType("Inventory");
                obj.setPriority(7);
                obj.setReport_name("StockOutRate_Report");
                break;
            case KPI_INV4:

                obj.setName(KPI_INV4);
                obj.setType("Inventory");
                obj.setPriority(8);
                obj.setReport_name("ShippedOrder_Report");
                break;
            case KPI_SHIP1:

                obj.setName(KPI_SHIP1);
                obj.setType("Shipping");
                obj.setPriority(9);
                obj.setReport_name("BookedOrder_Report");
                break;
            case KPI_SHIP2:

                obj.setName(KPI_SHIP2);
                obj.setType("Shipping");
                obj.setPriority(10);
                obj.setReport_name("ShippedOrder_Report");
                break;
            
                case KPI_AP1:

                    obj.setName(KPI_AP1);
                    obj.setType("Account Payables");
                    obj.setPriority(11);
                    obj.setReport_name("AP_Total_Supplier_Balances_Report");
                    obj.setResult_flag("B");
                    obj.setResult_layout("table");
                    obj.setPage_name("showAPResultPG");
                    break;
            
                
                case KPI_AR1:

                    obj.setName(KPI_AR1);
                    obj.setType("Account Receivables");
                    obj.setPriority(12);
                    obj.setReport_name("AR_Total_Dispute_Amount_Report");
                    obj.setResult_flag("B");
                    obj.setResult_layout("graph");
                    obj.setPage_name("showARResultPG");
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
        System.out.println("Data in Temp Array**** " + kpistemp);
        System.out.println("No of Items Items in the Array list*************** " + kpis.size());
        //System.out.println(kpis);
        String name = kpistemp.get(0).getType().concat("-").concat(kpistemp.get(0).getName());
        
        if("Account Payables".equalsIgnoreCase(kpistemp.get(0).getType()) || "Account Receivables".equalsIgnoreCase(kpistemp.get(0).getType()))
        {
            System.out.println("inside payables");
            this.setApTimeRadio(true);
            this.setAllTimePara(false);
            this.setTargettyperend(false);
            this.setTargetValuerend(false);
        }
        else 
        {
            System.out.println("not payables");
            this.setApTimeRadio(false);
            this.setAllTimePara(true);
            this.setTargettyperend(true);
            this.setTargetValuerend(true);
        }
        System.out.println("Name value " + name);
        this.setKpIText(name);

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
        KPIObject[] addedKpis = null;
        // ArrayList a = new ArrayList();
        
        System.out.println("KPI Size :" + kpis.size());
        addedKpis = (KPIObject[]) kpis.toArray(new KPIObject[kpis.size()]);
        System.out.println("In getAddedKPIS abc:" + AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.abc}"));
        a = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("Array List value " + a);
        //addedKpis =  (KPIObject[])AdfmfJavaUtilities.getELValue(kpis);
        addedKpis = a.toArray(new KPIObject[a.size()]);


        System.out.println("AddedKPI Size :" + addedKpis.length);
        System.out.println("In getAddedKPIS kpis:" + AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}"));
        return addedKpis;
    }
    
    public KPIObject[] getAddedKPIS_button() 
    {
        KPIObject[] addedKpis_button = null; 
        ArrayList<KPIObject> added_butt = new ArrayList<KPIObject>();
        //a = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("Added Button value...."+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}"));
        added_butt = (ArrayList)AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}");
        //addedKpis_button = (ArrayList<KPIObject>) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis_button}");
        addedKpis_button = added_butt.toArray(new KPIObject[added_butt.size()]);
        System.out.println("addedKpis_button ............."+addedKpis_button);
        return addedKpis_button;
    }
    
    
    public  KPIObject[] getCustomerDispuetdPayment()
    {
        KPIObject obj = new KPIObject();
        KPIObject obj1 = new KPIObject();
        obj.setSupplier_name("Customer1");
        obj.setSupp_amt(10000);
        obj1.setSupplier_name("Customer2");
        obj1.setSupp_amt(11000);
        ArrayList<KPIObject> SupplierList = new ArrayList<KPIObject>();
          SupplierList.add(obj);
          SupplierList.add(obj1);
        KPIObject[] addedKpis = null;
        // ArrayList a = new ArrayList();

        System.out.println("KPI Size :" + kpis.size());
        addedKpis = (KPIObject[]) kpis.toArray(new KPIObject[kpis.size()]);
        
        
        addedKpis = SupplierList.toArray(new KPIObject[a.size()]);
        //  SupplierList = addedKpis;
        System.out.println("addeKpis value......."+addedKpis);
        
        return addedKpis;
        
    }
    
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
        System.out.println("inside method value "+suppAmt);
        System.out.println("this value.."+this.suppAmt);
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

}
