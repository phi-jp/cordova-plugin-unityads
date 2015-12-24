/*
 *
 */


package jp.phi.cordova.plugin.unityads;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import com.unity3d.ads.android.UnityAds;

public class UnityAds extends CordovaPlugin {

    public UnityAds() {

    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
}