/*
 *
 */


package jp.phi.cordova.plugin.unityads;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.unity3d.ads.android.UnityAds;

public class UnityAdsPlugin extends CordovaPlugin {

    protected String gameId;
    protected boolean isTest;

    public UnityAdsPlugin() {

    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    private void init(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        UnityAds.setTestMode(isTest);
    }

    private void showAdd(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        UnityAds.setTestMode(isTest);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            init(action, args, callbackContext);
            return true;
        }
        else if (action.equals("showAdd")){
            showAdd(action, args, callbackContext);
            return true;
        }

        // method not found
        return false;
    }

}