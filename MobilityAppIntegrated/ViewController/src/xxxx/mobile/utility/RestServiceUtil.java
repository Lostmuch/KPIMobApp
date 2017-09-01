package xxxx.mobile.utility;

import java.io.IOException;

import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.framework.exception.AdfInvocationException;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;

public class RestServiceUtil 
{
    private String connectionName;

    public RestServiceUtil(String connectionName) {
        super();
        this.connectionName = connectionName;
        System.out.println("CONN NAME SET : "+connectionName);
    }

    public String invokeCreate(String requestURI, Object postData) {
        return invokeRestService(RestServiceAdapter.REQUEST_TYPE_PUT, requestURI, postData);
    }

    public String invokeUpdate(String requestURI, Object postData) {
        return invokeRestService(RestServiceAdapter.REQUEST_TYPE_POST, requestURI, postData);
    }

    public String invokeDelete(String requestURI) {
        return invokeRestService(RestServiceAdapter.REQUEST_TYPE_DELETE, requestURI, null);
    }

    public String invokeGet(String requestURI, Object postData) {
        return invokeRestService(RestServiceAdapter.REQUEST_TYPE_GET, requestURI, postData);
    }

    /**
     * Method that handles the boilerplate code for obtaining and configuring a service adapter instance.
     * @param httpMethod GET, POST, PUT, DELETE
     * @param requestURI the URI to appends to the base REST URL. URIs are expected to start with "/"
     * @return
     */
    private String invokeRestService(String requestType, String requestURI, Object postData) {
        System.out.println("INSIDE INVOKEFIND");
        String newrequestURI = convertString2URLFormat(requestURI);
        System.out.println("newrequestURI" + newrequestURI);
        RestServiceAdapter restServiceAdapter = RestServiceAdapterFactory.newFactory().createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        System.out.println("CONN NAME" + connectionName);
        restServiceAdapter.setConnectionName(connectionName);
        System.out.println("CONN SET");
        restServiceAdapter.setRequestMethod(requestType);
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        System.out.println("STAGE1 COMPLETE");
        System.out.println("newrequestURI value" +newrequestURI);
        restServiceAdapter.setRequestURI(newrequestURI);
        restServiceAdapter.setRetryLimit(0);

        String response = "";
        String postDataStr = "";
        System.out.println("Entering try before post data");
        try {
            if (postData != null) {
                System.out.println("In try if post data is not null "+ postData);
                JSONObject jsonObj = (JSONObject) JSONBeanSerializationHelper.toJSON(postData);
                removeNullsAndTypeFromJSON(jsonObj);
                postDataStr = jsonObj.toString();
            }
            System.out.println("Fetching response :"+postDataStr);
            response = (String) restServiceAdapter.send(postDataStr);
            System.out.println("Response fetched");
        } catch (AdfInvocationException ex) {
            if (AdfInvocationException.CATEGORY_WEBSERVICE.compareTo(ex.getErrorCategory()) == 0) {
                throw new RuntimeException("Error with the server. Please try later.");
            }
        } 
        catch (Exception e) {
            System.out.println("INVOKEFIND EXCEPTION");
            //throw new AdfException(e.getLocalizedMessage(), AdfException.ERROR);
            response = null;
        }

        return response;
    }

    private void removeNullsAndTypeFromJSON(JSONObject jsonObj) throws JSONException {
        jsonObj.remove(".type");

        for (int i = 0; i < jsonObj.length(); i++) {
            String key = jsonObj.names().getString(i);
            if (JSONBeanSerializationHelper.isObjectNull(jsonObj.get(key))) {
                jsonObj.remove(key);
                i--;
            }
        }
    }

    public static String convertString2URLFormat(String strInput) {
        String strOutput = "";
        for (int i = 0; i < strInput.length(); i++) {
            char c = strInput.charAt(i);
            if (32 == (int) c) {
                strOutput = strOutput + "%20";
            } else {
                strOutput = strOutput + c;
            }
        }
        return strOutput;
    }
}
