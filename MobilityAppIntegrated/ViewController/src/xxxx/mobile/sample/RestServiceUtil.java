package xxxx.mobile.sample;

import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.framework.exception.AdfInvocationException;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;

public class RestServiceUtil {
    private String connectionName;

    public RestServiceUtil(String connectionName) {
        super();
        this.connectionName = connectionName;
        System.out.println("CONN NAME SET");
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

    public String invokeFind(String requestURI, Object postData) {
        return invokeRestService(RestServiceAdapter.REQUEST_TYPE_GET, requestURI, postData);
    }

         private String invokeRestService(String requestType, String requestURI, Object postData) {
        System.out.println("INSIDE INVOKEFIND");
        RestServiceAdapter restServiceAdapter = RestServiceAdapterFactory.newFactory().createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        System.out.println("CONN NAME"+connectionName);
        restServiceAdapter.setConnectionName(connectionName);
        System.out.println("CONN SET");
        restServiceAdapter.setRequestMethod(requestType);
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        System.out.println("STAGE1 COMPLETE");
        restServiceAdapter.setRequestURI(requestURI);
        restServiceAdapter.setRetryLimit(0);

        String response = "";
        String postDataStr = "";

        try {
            if (postData != null) {
                JSONObject jsonObj = (JSONObject) JSONBeanSerializationHelper.toJSON(postData);
                removeNullsAndTypeFromJSON(jsonObj);
                postDataStr = jsonObj.toString();
            }

            response = (String)restServiceAdapter.send(postDataStr);

        } catch (AdfInvocationException ex) {
            if (AdfInvocationException.CATEGORY_WEBSERVICE.compareTo(ex.getErrorCategory()) == 0) {
                throw new RuntimeException("Error with the server. Please try later.");
            }
        } catch (Exception e) {
            System.out.println("INVOKEFIND EXCEPTION");
            throw new AdfException(e.getLocalizedMessage(), AdfException.ERROR);
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
}
