package xxxx.mobile;

import java.util.ArrayList;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adf.mbean.share.config.runtime.webcenter.concurrent.Global; 

import oracle.adfmf.framework.api.AdfmfJavaUtilities;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.service.ReportService;

public class ResultControl {
    private String kpiVAlue;
    private String generictemp;
    private String clickvalue = null;
    private String generic_temp_ar;
    private String generic_temp_backLog;
    private String generic_temp_ar_cust_pay;
    private String KPI_SHIP1_OUT;
    private String KPI_SHIP2_OUT;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    private boolean disCustBarRend = false;
    private boolean dispayBarRend = false;
    private String getActualValue = null;

    public ResultControl() {
        super();
    }

    ArrayList<GenericObject> genericTable1 = new ArrayList<GenericObject>();
    String Output = null;
    String Output_ar = null;
    EditKpiControl kpiobj = new EditKpiControl();
    public ArrayList<KPIObject> kpisres = new ArrayList<KPIObject>();

    public String getNextPG() {
        // Add event code here...
        System.out.println("In getNextPG");
        System.out.println("Name******************* " + AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}"));
        System.out.println("Priority******************* " + AdfmfJavaUtilities.getELValue("#{pageFlowScope.priority}"));
        String nextpg = AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}").toString();
        System.out.println("Next PG value..." + nextpg);
        return nextpg;
    }

    public void resultKPI(ActionEvent actionEvent)
    {
        // Add event code here...

        System.out.println("Inside Result Kpi");
        String report_name = null;
        String org_value = null;
        String p_requestURI = null;
        System.out.println("Name inside resultkpi******************* " +
                           AdfmfJavaUtilities.getELValue("#{pageFlowScope.priority}"));
        String priority1 = (AdfmfJavaUtilities.getELValue("#{pageFlowScope.priority}").toString());
        int priority = 0;
        if(priority1!=null) 
        {
            priority = Integer.parseInt(priority1);
            System.out.println("INside if priority val"+priority);
        }
        System.out.println("Priority..."+priority);
        System.out.println("Kpis after priority.."+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}"));
        kpisres = null;
        kpisres = (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");
        System.out.println("After kpisres"+kpisres);

        for (int i = 0; i < kpisres.size(); i++) 
        {
            int priority_val = kpisres.get(i).getPriority();
            System.out.println("INside for priority_val  ...." + priority_val);
            if (kpisres.get(i).getPriority() == priority) 
            {
                System.out.println("Inside for if");
                report_name = kpisres.get(i).getReport_name();
                System.out.println("Actual Value inside if....."+kpisres.get(i).getActual_value());
                AdfmfJavaUtilities.setELValue("#{ResultKpiBean.getActualValue}",kpisres.get(i).getActual_value());
                System.out.println("Report name value inside for " + report_name);
                org_value = kpisres.get(i).getOrg_value();
                System.out.println("Inside if org_value" + org_value);


                System.out.println("kpisres ...." + kpisres);
                // System.out.println("kpisres value........."+kpisres.get(0).getPriority());
                System.out.println("Name******************* " +
                                   AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}"));

                ReportService reportService = new ReportService();
                System.out.println("Before Call ***************");
                //String p_requestURI = "/Top_10_Suppliers_by_AP_Balances_Report/CURRENT/GLOBAL/999999/99/99";
                if ("AP_Total_Supplier_Balances_Report".equalsIgnoreCase(report_name)) {
                    System.out.println("Inside if Top 10");
                    p_requestURI =
                        "/Top_10_Suppliers_by_AP_Balances_Report/CURRENT/" + kpisres.get(i).getOrg_value() +
                        "/999999/99/99";
                    System.out.println(" p_requestURIvalue....." + p_requestURI);
                    Output = reportService.getOutputValue(p_requestURI);
                    System.out.println("After Call ***************");
                    //System.out.println(Output);
                    System.out.println("Array Call ***************");

                    //genericTable1 = reportService.getArrayListValue(Output);
                    System.out.println("Value of genericTable1 new***************" + genericTable1);
                    System.out.println("Supp AMount value in result control class " +
                                       AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.suppAmt}"));
                    //String ArrayOut=reportService.getArrayListValue(Output);
                    System.out.println("After Output Array Call ***************" + Output);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generictemp}", Output);
                    System.out.println("First VAlue" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));

                }


                //AR Section
                if ("AR_Total_Dispute_Amount_Report".equalsIgnoreCase(report_name)) {
                    //String p_requestURI_ar = "/Top_5_Customer_Dispute_Amounts_Report/GLOBAL/GLOBAL/GLOBAL/99/99";
                    String p_requestURI_ar =
                        "/Top_5_Customer_Dispute_Amounts_Report/CURRENT/" + kpisres.get(i).getBu_name() + "/" +
                        kpisres.get(i).getLe_name() + "/99/99";
                    Output_ar = reportService.getOutputValue(p_requestURI_ar);
                    this.setDisCustBarRend(true);
                    System.out.println("After Call AR***************");
                    System.out.println(Output_ar);
                    System.out.println("Array Call AR ***************");

                    //genericTable1 = reportService.getArrayListValue(Output);
                    System.out.println("AR Value of generic_temp_ar new***************" + generic_temp_ar);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}", Output_ar);
                    System.out.println("after El value");
                    System.out.println("First VAlue" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}"));
                    //ENd of AR Section
                }

                // Pending Customer
                if ("AR_Total_Pending_Amount_Report".equalsIgnoreCase(report_name)) {
                    System.out.println("Inside Total Pending Amount");
                    //String p_requestURI_ar = "Top_5_Customer_Pending_Amounts_Report/GLOBAL/GLOBAL/GLOBAL/999/999";
                    String p_requestURI_ar =
                        "Top_5_Customer_Pending_Amounts_Report/GLOBAL/" + kpisres.get(i).getBu_name() + "/" +
                        kpisres.get(i).getLe_name() + "/999/999";
                    String Output_ar_pend = reportService.getOutputValue(p_requestURI_ar);
                    this.setDispayBarRend(true);
                    System.out.println("After Call AR Pending***************");
                    System.out.println(Output_ar_pend);
                    System.out.println("Array Call AR PEnding***************");

                    //genericTable1 = reportService.getArrayListValue(Output);
                    System.out.println("Pending AR Value of generic_temp_ar new***************" +
                                       generic_temp_ar_cust_pay);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generic_temp_ar_cust_pay}",
                                                  Output_ar_pend);
                    System.out.println("Pending after El value");
                    System.out.println("Pending First VAlue" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar_cust_pay}"));
                    //ENd of AR Section
                }
                // ENd of Pending Customer

                if ("Total_po_backlog_amount".equalsIgnoreCase(report_name)) {
                    String p_requestURI_ar =
                        "/Top_Five_Supplier_backlog_poamount/" + kpisres.get(i).getBu_name() + "/999/999/999/999";
                    String Output_po = reportService.getOutputValue(p_requestURI_ar);
                    System.out.println("PO BAck LOG***************");
                    System.out.println(Output_po);
                    System.out.println("PO Back LOG ***************");

                    //genericTable1 = reportService.getArrayListValue(Output);
                    System.out.println("PO Back LOg**************" + generic_temp_backLog);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generic_temp_backLog}", Output_po);
                    System.out.println("after PO El value");
                    System.out.println("PO First VAlue" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_backLog}"));

                }
                
                if ("BookedOrder_Report".equalsIgnoreCase(report_name)) {
                    System.out.println("Inside if Booked Order");
                    p_requestURI =
                        "/BookedOrder_List_Report/" + kpisres.get(i).getOrg_value() +
                        "/99/99/99/99";
                    // req_uri = BookedOrder_List_Report/Global/99/GLOBAL/99/99
                    System.out.println(" p_requestURIvalue....." + p_requestURI);
                    Output = reportService.getOutputValue(p_requestURI);
                    System.out.println("After Call ***************");
                    System.out.println(Output);
                    System.out.println("Array Call ***************");

                    //genericTable1 = reportService.getArrayListValue(Output);
                   // System.out.println("Value of genericTable1 new***************" + genericTable1);
                   // System.out.println("Supp AMount value in result control class " +
                    //                   AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.suppAmt}"));
                    //String ArrayOut=reportService.getArrayListValue(Output);
                  //  System.out.println("After Output Array Call ***************" + Output);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.KPI_SHIP1_OUT}", Output);
                    System.out.println("Output JSON" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP1_OUT}"));

                }
                
                if ("Shipping_Backlog_Summary_Report".equalsIgnoreCase(report_name)) {
                    System.out.println("Inside if Shipping_Backlog_Summary_Report");
                    p_requestURI =
                        "/BookedOrder_List_Report/" + kpisres.get(i).getOrg_value() +
                        "/99/99/99/99";
                    // req_uri = BookedOrder_List_Report/Global/99/GLOBAL/99/99
                    System.out.println(" p_requestURIvalue....." + p_requestURI);
                    Output = reportService.getOutputValue(p_requestURI);
                    System.out.println("After Call ***************");
                    System.out.println(Output);
                    System.out.println("Array Call ***************");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.KPI_SHIP2_OUT}", Output);
                    System.out.println("Output JSON" +
                                       AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP2_OUT}"));

                }

                //break;
            }
            

        }
        System.out.println("End of Result KPI");
    }

    public ArrayList<GenericObject> getResultData() {

        System.out.println("Inside getResultdata ******* " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
        String p_jsonArray = null;
        if(AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}")!=null)
        {
          p_jsonArray = AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}").toString();
        }
        System.out.println("p_jsonArray " + p_jsonArray);
        System.out.println("Before Creating Object");
        ArrayList<GenericObject> genericTable;
        genericTable = new ArrayList<GenericObject>();
        genericTable.removeAll(genericTable);
        System.out.println("AFter creating object");
        try {
            System.out.println("Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("AFter creating json object");

            // read json array
            System.out.println("read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("record json array");

            System.out.println("Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                obj.setParam2(arrObj.getJSONObject(i).getString("PARAM2"));
                genericTable.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + genericTable);
            }

            System.out.println("Arraylist Value genericTable afetr loop " + genericTable);

        } catch (JSONException e) {
            System.out.println("Exception occureed " + e);
        }
        System.out.println("Before retrn");
        return genericTable;
    }


    public ArrayList<GenericObject> getResultData_ar() {

        System.out.println("Inside getResultData_ar Second ******* " +
                          AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}"));

        String p_requestURI_ar ="/Top_5_Customer_Dispute_Amounts_Report/CURRENT/GLOBAL/GLOBAL/99/99";
    
        String p_jsonArray =
            AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}").toString();
        System.out.println("AR p_jsonArray " + p_jsonArray);
        System.out.println("AR Before Creating Object");
        ArrayList<GenericObject> genericTable_ar;
        genericTable_ar = new ArrayList<GenericObject>();
        genericTable_ar.removeAll(genericTable_ar);
        System.out.println("AR AFter creating object");
        try {
            System.out.println("AR Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("AR AFter creating json object");

            // read json array
            System.out.println("AR read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("AR record json array");

            System.out.println("AR Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("AR Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("AR PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("AR PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                //obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                //obj.setParam3(10000);
                obj.setParam4(arrObj.getJSONObject(i).getDouble("PARAM2"));
                genericTable_ar.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + genericTable_ar);
            }

            System.out.println("Arraylist Value genericTable afetr loop " + genericTable_ar);

        } catch (JSONException e) {
            System.out.println("Exception occureed " + e);
        }
        System.out.println("Before retrn");
        return genericTable_ar;
    }

    // Pending Customer payments
   public ArrayList<GenericObject> getResultData_ar_pen_cust_pay() 
   {

        System.out.println("Inside getResultData_ar_pen_cust_pay Second ******* " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar_cust_pay}"));
        String p_jsonArray =
            AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar_cust_pay}").toString();
        System.out.println("Pending AR p_jsonArray " + p_jsonArray);
        System.out.println("Pending AR Before Creating Object");
        ArrayList<GenericObject> genericTable_ar_cust_pay;
        genericTable_ar_cust_pay = new ArrayList<GenericObject>();
        System.out.println("Pending AR AFter creating object");
        try {
            System.out.println("Pending AR Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("Pending AR AFter creating json object");

            // read json array
            System.out.println("Pending AR read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("Pending AR record json array");

            System.out.println("Pending AR Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("Pending AR Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("Pending AR PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("Pending AR PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                //obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                obj.setParam4(arrObj.getJSONObject(i).getDouble("PARAM2"));
                genericTable_ar_cust_pay.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + genericTable_ar_cust_pay);
            }

            System.out.println("Pending Arraylist Value genericTable afetr loop " + genericTable_ar_cust_pay);

        } catch (JSONException e) {
            System.out.println("Exception occureed " + e);
        }
        System.out.println("Before genericTable_ar_cust_pay");
        return genericTable_ar_cust_pay;
    }
    //

    //Start of PO back LOG
    public ArrayList<GenericObject> getResultData_backLogPO() {

       /* System.out.println("Inside getResultData_backLogPO third ******* " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_backLog}"));
        String p_jsonArray =
            AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_backLog}").toString();
        System.out.println("PO p_jsonArray " + p_jsonArray);
        System.out.println("PO Before Creating Object");
        ArrayList<GenericObject> genericTable_po;
        genericTable_po = new ArrayList<GenericObject>();
        System.out.println("PO AFter creating object");
        try {
            System.out.println("PO Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("PO AFter creating json object");

            // read json array
            System.out.println("PO read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("PO record json array");

            System.out.println("PO Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("po Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("po PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("po PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                obj.setParam2(arrObj.getJSONObject(i).getString("PARAM2"));
                //obj.setParam3(10000);
                genericTable_po.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + genericTable_po);
            }

            System.out.println("Arraylist Value genericTable afetr loop " + genericTable_po);

        } catch (JSONException e) {
            System.out.println("Exception occureed " + e);
        }
        System.out.println("PO Before retrn");
        return genericTable_po;*/
        return null;
    }
    //ENd of PO Back LOG
    
    
    //Start of Booked Order Report 
    public ArrayList<GenericObject> getResultData_BookedOrder() {

       /* System.out.println("Inside getResultData_BookedOrder ******* " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP1_OUT}"));
        String p_jsonArray =
            AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP1_OUT}").toString();
        System.out.println("KPI_SHIP1_OUT " + p_jsonArray);
       
        ArrayList<GenericObject> generic_KPI_SHIP1_OUT;
        generic_KPI_SHIP1_OUT = new ArrayList<GenericObject>();
       
        try {
            System.out.println("generic_KPI_SHIP1_OUT Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("PO AFter creating json object");

            // read json array
            System.out.println("PO read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("PO record json array");

            System.out.println("PO Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("po Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("po PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("po PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));

                obj.setParam4(arrObj.getJSONObject(i).getDouble("PARAM1"));
                obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                //obj.setParam3(10000);
                generic_KPI_SHIP1_OUT.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + generic_KPI_SHIP1_OUT);
            }

            System.out.println("Arraylist Value genericTable afetr loop " + generic_KPI_SHIP1_OUT);

        } catch (JSONException e) {
            System.out.println("Exception occurred " + e);
        }
        System.out.println("PO Before retrn");
        return generic_KPI_SHIP1_OUT;*/
        return null;
    }
    //ENd of Booked Order Report
    
    //Start of Shipping Backlog Report
    public ArrayList<GenericObject> getResultData_ShippingBacklog() {

      /*  System.out.println("Inside getResultData_BookedOrder ******* " +
                           AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP2_OUT}"));
        String p_jsonArray =
            AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.KPI_SHIP2_OUT}").toString();
        System.out.println("KPI_SHIP2_OUT " + p_jsonArray);
       
        ArrayList<GenericObject> generic_KPI_SHIP2_OUT;
        generic_KPI_SHIP2_OUT = new ArrayList<GenericObject>();
       
        try {
            System.out.println("generic_KPI_SHIP2_OUT Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);


            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("PO record json array");

            System.out.println("PO Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) {
                GenericObject obj = new GenericObject();
                System.out.println("po Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("po PAram 1 cha value " + arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("po PAram 2 cha value " + arrObj.getJSONObject(i).getString("PARAM2"));

                obj.setParam4(arrObj.getJSONObject(i).getDouble("PARAM1"));
                obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                //obj.setParam3(10000);
                generic_KPI_SHIP2_OUT.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop " + generic_KPI_SHIP2_OUT);
            }

            System.out.println("Arraylist Value genericTable afetr loop " + generic_KPI_SHIP2_OUT);

        } catch (JSONException e) {
            System.out.println("Exception occureed " + e);
        }
        System.out.println("PO Before retrn");
        return generic_KPI_SHIP2_OUT;*/
        return null;
    }
    //ENd of Booked Order Report


    public void setKpiVAlue(String kpiVAlue) {
        this.kpiVAlue = kpiVAlue;
    }

    public String getKpiVAlue() {
        return kpiVAlue;
    }

    public void setGenerictemp(String generictemp) {
        this.generictemp = generictemp;
    }

    public String getGenerictemp() {
        return generictemp;
    }

    public void setGeneric_temp_ar(String generic_temp_ar) {
        this.generic_temp_ar = generic_temp_ar;
    }

    public String getGeneric_temp_ar() {
        return generic_temp_ar;
    }


    public void setGeneric_temp_backLog(String generic_temp_backLog) {
        this.generic_temp_backLog = generic_temp_backLog;
    }

    public String getGeneric_temp_backLog() {
        return generic_temp_backLog;
    }

    public void setGeneric_temp_ar_cust_pay(String generic_temp_ar_cust_pay) {
        this.generic_temp_ar_cust_pay = generic_temp_ar_cust_pay;
    }

    public String getGeneric_temp_ar_cust_pay() {
        return generic_temp_ar_cust_pay;
    }

    public void setKPI_SHIP1_OUT(String KPI_SHIP1_OUT) {
        String oldKPI_SHIP1_OUT = this.KPI_SHIP1_OUT;
        this.KPI_SHIP1_OUT = KPI_SHIP1_OUT;
        _propertyChangeSupport.firePropertyChange("kPI_SHIP1_OUT", oldKPI_SHIP1_OUT, KPI_SHIP1_OUT);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getKPI_SHIP1_OUT() {
        return KPI_SHIP1_OUT;
    }


    public void setDisCustBarRend(boolean disCustBarRend) {
        boolean oldDisCustBarRend = this.disCustBarRend;
        this.disCustBarRend = disCustBarRend;
        _propertyChangeSupport.firePropertyChange("disCustBarRend", oldDisCustBarRend, disCustBarRend);
    }

    public boolean isDisCustBarRend() {
        return disCustBarRend;
    }

    public void setGetActualValue(String getActualValue) {
        this.getActualValue = getActualValue;
    }

    public String getGetActualValue() {
        return getActualValue;
    }

    public void setDispayBarRend(boolean dispayBarRend) {
        boolean oldDispayBarRend = this.dispayBarRend;
        this.dispayBarRend = dispayBarRend;
        _propertyChangeSupport.firePropertyChange("dispayBarRend", oldDispayBarRend, dispayBarRend);
    }

    public boolean isDispayBarRend() {
        return dispayBarRend;
    }

}
