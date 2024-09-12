package com.appsflyer;

import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.share.LinkGenerator;
import com.facebook.login.LoginLogger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, DeepLinkListener, LinkGenerator.ResponseListener {
    public native void onAppOpenAttributionNative(Object obj);

    public native void onAttributionFailureNative(Object obj);

    public native void onDeepLinkingNative(DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public native void onResponseErrorNative(String str);

    public native void onResponseNative(String str);

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onConversionDataFail(String str) {
        valueOf("onAttributionFailure", str);
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public void onAttributionFailure(String str) {
        valueOf("onInstallConversionFailure", str);
    }

    public void onDeepLinking(DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    private void valueOf(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", (Object) LoginLogger.EVENT_EXTRAS_FAILURE);
            jSONObject.put("data", (Object) str2);
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c = 1;
            }
            if (c == 0) {
                onInstallConversionFailureNative(jSONObject);
            } else if (c == 1) {
                onAttributionFailureNative(jSONObject);
            }
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("2dx error", e);
            e.printStackTrace();
        }
    }

    public void onResponse(String str) {
        onResponseNative(str);
    }

    public void onResponseError(String str) {
        onResponseErrorNative(str);
    }
}
