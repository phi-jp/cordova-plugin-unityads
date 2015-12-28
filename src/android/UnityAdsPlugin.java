/*
 *
 */


package jp.phi.cordova.plugin.unityads;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.unity3d.ads.android.IUnityAdsListener;
import com.unity3d.ads.android.UnityAds;
import com.unity3d.ads.android.view.UnityAdsFullscreenActivity;

public class UnityAdsPlugin extends CordovaPlugin implements IUnityAdsListener {

    protected String gameId;
    protected boolean isTest;
    private CallbackContext callbackContext;

    public UnityAdsPlugin() {

    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    private void init(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        final String gameId = args.getString(0);
        final Boolean isTest = args.getBoolean(1);

        this.gameId = gameId;
        this.isTest = isTest;
        this.callbackContext = callbackContext;

        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                _init();
            }
        });
    }

    private void _init() {
        String name = cordova.getActivity().getPackageName();
        UnityAds.init(cordova.getActivity(), this.gameId, this);
        UnityAds.setDebugMode(true);
        UnityAds.setTestMode(true);
        // UnityAds.setTestMode(this.isTest);
//        UnityAds.setDebugMode(false);
    }

    private void showAds(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        UnityAds.setZone("rewardedVideoZone");
        if(UnityAds.canShow() && UnityAds.canShowAds()) {
            UnityAds.show();
        }
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            init(action, args, callbackContext);
            return true;
        } else if (action.equals("showAds")){
            showAds(action, args, callbackContext);
            return true;
        }

        // method not found
        return false;
    }

    @Override
    /**
     * 動画在庫がある場合のコールバック
     */
    public void onFetchCompleted() {
        PluginResult pr = new PluginResult(PluginResult.Status.OK, "adsvideoloaded");
        pr.setKeepCallback(true);
        this.callbackContext.sendPluginResult(pr);
    }

    @Override
    /**
     * 動画在庫がない場合のコールバック
     */
    public void onFetchFailed() {

    }

    @Override
    /**
     * UnityAdsが閉じられたコールバック
     */
    public void onHide() {
        PluginResult pr = new PluginResult(PluginResult.Status.OK, "adsvideohide");
        pr.setKeepCallback(true);
        this.callbackContext.sendPluginResult(pr);
    }

    @Override
    /**
     * UnityAdsが表示されたコールバック
     */
    public void onShow() {
    }

    @Override
    /**
     * 動画の再生開始コールバック
     */
    public void onVideoStarted() {
    }

    @Override
    /**
     * 動画の再生完了コールバック
     * @param key インセンティブキー
     * @param skip スキップしたか
     */
    public void onVideoCompleted(String key, boolean skip) {
    }

}
