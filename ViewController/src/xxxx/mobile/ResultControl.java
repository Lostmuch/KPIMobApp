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
    public ResultControl() {
        super();
    }
    
    ArrayList<GenericObject> genericTable1 = new ArrayList<GenericObject>();
    String Output = null;
	public void resultKpi(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Inside REsult Kpi");
		System.out.println("Name******************* "+actionEvent.getClass().getName());
          ReportService reportService =new ReportService();
           System.out.println("Before Call ***************");
           String p_requestURI = "/Top_10_Suppliers_by_AP_Balances_Report/GLOBAL/CURRENT/999999/99/99";
           Output = reportService.getOutputValue(p_requestURI);
           System.out.println("After Call ***************");
           System.out.println(Output);
           System.out.println("Array Call ***************");
           
         //  genericTable1 = reportService.getArrayListValue(Output);
                  System.out.println("Value of genericTable1 new***************"+genericTable1);
          System.out.println("Supp AMount value in result control class "+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.suppAmt}")); 
           //String ArrayOut=reportService.getArrayListValue(Output);
           System.out.println("After Output Array Call ***************"+Output);
        AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generictemp}", Output);
        System.out.println("First VAlue"+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
    }
    
    public void resultAgingKpi() {
        // Add event code here...
        System.out.println("Inside REsult Aging Kpi");
          ReportService reportService =new ReportService();
           System.out.println("Before Call ***************");
           String p_requestURI = "/AP_Aging_Buckets_Amounts_Report/GLOBAL/CURRENT/999/999/999";
           Output = reportService.getOutputValue(p_requestURI);
           System.out.println("After Call ***************");
           System.out.println(Output);
           System.out.println("Array Call ***************");
           System.out.println("Value of genericTable1 new***************"+genericTable1);
          System.out.println("Supp AMount value in result control class "+AdfmfJavaUtilities.getELValue("#{pageFlowScope.toggleBean.suppAmt}")); 
           //String ArrayOut=reportService.getArrayListValue(Output);
           System.out.println("After Output Array Call ***************"+Output);
        AdfmfJavaUtilities.setELValue("#{applicationScope.ResultKpiBean.generictemp}", Output);
        System.out.println("First VAlue"+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
      }
   public ArrayList<GenericObject> getResultData() 
   {
    System.out.println("Inside getResultdata Second ******* "+AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}"));
        String p_jsonArray = AdfmfJavaUtilities.getELValue("#{applicationScope.ResultKpiBean.generictemp}").toString();
        System.out.println("p_jsonArray "+p_jsonArray);
//        System.out.println("genericTable1 size "+genericTable1);
//        GenericObject[] output = null;
//        GenericObject obj1 = new GenericObject();
//        obj1.setParam1("hellow");
//        genericTable1.add(obj1);
//        System.out.println("###Generic table value "+genericTable1);
//        output = (GenericObject[]) genericTable1.toArray(new GenericObject[genericTable1.size()]);
//        System.out.println("Output value of generic object "+output);
//        return output;   


        System.out.println("Before Creating Object");
        
        ArrayList<GenericObject> genericTable;
        genericTable = new ArrayList<GenericObject>();
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
                //String temp_val = arrObj.getString(i);
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
}
