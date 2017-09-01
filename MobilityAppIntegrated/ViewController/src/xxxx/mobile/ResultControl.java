package xxxx.mobile;

import java.util.ArrayList;

import oracle.adfmf.amx.event.ActionEvent;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;

import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import xxxx.mobile.service.ReportService;

public class ResultControl {
    private String kpiVAlue;
    private String generictemp;
    private String clickvalue =null;
    private String generic_temp_ar;

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
        System.out.println("Name******************* "+AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}"));
        String nextpg = AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}").toString();
        System.out.println("Next PG value");
        return nextpg;
    }
    
    public void resultKpi(ActionEvent actionEvent) 
    {
        // Add event code here...
        
             System.out.println("Inside REsult Kpi");
             kpisres = null;
             kpisres =  (ArrayList) AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.kpis}");;
             
             for(int i=0;i<kpisres.size();i++) 
             {
                    String reportname = kpisres.get(i).getReport_name();
                 System.out.println("Report NAme ...."+reportname);
             }
             
             System.out.println("kpisres ...."+kpisres);
            // System.out.println("kpisres value........."+kpisres.get(0).getPriority());
             System.out.println("Name******************* "+AdfmfJavaUtilities.getELValue("#{pageFlowScope.button_click}"));
           
             ReportService reportService =new ReportService();
           System.out.println("Before Call ***************");
           String p_requestURI = "/Top_10_Suppliers_by_AP_Balances_Report/CURRENT/GLOBAL/999999/99/99";
           Output = reportService.getOutputValue(p_requestURI);
           System.out.println("After Call ***************");
           System.out.println(Output);
           System.out.println("Array Call ***************");
           
           //genericTable1 = reportService.getArrayListValue(Output);
           System.out.println("Value of genericTable1 new***************"+genericTable1);
          System.out.println("Supp AMount value in result control class "+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.suppAmt}")); 
           //String ArrayOut=reportService.getArrayListValue(Output);
           System.out.println("After Output Array Call ***************"+Output);
        AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generictemp}", Output);
        System.out.println("First VAlue"+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
        
        
        //AR Section
        String p_requestURI_ar = "/Top_5_Customer_Dispute_Amounts_Report/GLOBAL/GLOBAL/GLOBAL/99/99";
        Output_ar = reportService.getOutputValue(p_requestURI_ar);
        System.out.println("After Call AR***************");
        System.out.println(Output_ar);
        System.out.println("Array Call AR ***************");
        
        //genericTable1 = reportService.getArrayListValue(Output);
        System.out.println("AR Value of generic_temp_ar new***************"+generic_temp_ar);
        AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}", Output_ar);
        System.out.println("after El value");
        System.out.println("First VAlue"+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}"));
        //ENd of AR Section
       }
    
    public ArrayList<GenericObject> getResultData() 
    {

        System.out.println("Inside getResultdata Second ******* "+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
        String p_jsonArray = AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}").toString();
        System.out.println("p_jsonArray "+p_jsonArray);
        System.out.println("Before Creating Object");
        ArrayList<GenericObject> genericTable;
        genericTable = new ArrayList<GenericObject>();
        genericTable.removeAll(genericTable);
        System.out.println("AFter creating object");
         try 
        {
            System.out.println("Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("AFter creating json object");

            // read json array
            System.out.println("read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("record json array");

            System.out.println("Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) 
            {
                GenericObject obj =new GenericObject();
                System.out.println("Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("PAram 1 cha value "+arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("PAram 2 cha value "+arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                obj.setParam2(arrObj.getJSONObject(i).getString("PARAM2"));
                genericTable.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop "+genericTable);
            }
           
            System.out.println("Arraylist Value genericTable afetr loop "+genericTable);
            
        } catch (JSONException e) 
        {
            System.out.println("Exception occureed "+e);
        }
        System.out.println("Before retrn");
        return genericTable;
    }
    
    public ArrayList<GenericObject> getResultData_ar() 
    {

        System.out.println("Inside getResultdata Second ******* "+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
        String p_jsonArray = AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generic_temp_ar}").toString();
        System.out.println("AR p_jsonArray "+p_jsonArray);
        System.out.println("AR Before Creating Object");
        ArrayList<GenericObject> genericTable_ar;
        genericTable_ar = new ArrayList<GenericObject>();
        genericTable_ar.removeAll(genericTable_ar);
        System.out.println("AR AFter creating object");
         try 
        {
            System.out.println("AR Inside Try");
            JSONObject jsonObj = new JSONObject(p_jsonArray);
            System.out.println("AR AFter creating json object");

            // read json array
            System.out.println("AR read json array");

            JSONArray arrObj = jsonObj.getJSONArray("record");
            System.out.println("AR record json array");

            System.out.println("AR Record Size json:" + arrObj.length());
            int i;
            for (i = 0; i < arrObj.length(); i++) 
            {
                GenericObject obj =new GenericObject();
                System.out.println("AR Value for postion i " + i + " is :" + arrObj.getString(i));
                System.out.println("AR PAram 1 cha value "+arrObj.getJSONObject(i).getString("PARAM1"));
                System.out.println("AR PAram 2 cha value "+arrObj.getJSONObject(i).getString("PARAM2"));
                obj.setParam1(arrObj.getJSONObject(i).getString("PARAM1"));
                //obj.setParam3(arrObj.getJSONObject(i).getInt("PARAM2"));
                obj.setParam3(10000);
                genericTable_ar.add(obj);
                System.out.println("Arraylist Value genericTable inside for loop "+genericTable_ar);
            }
           
            System.out.println("Arraylist Value genericTable afetr loop "+genericTable_ar);
            
        } catch (JSONException e) 
        {
            System.out.println("Exception occureed "+e);
        }
        System.out.println("Before retrn");
        return genericTable_ar;
    }

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

   
}
