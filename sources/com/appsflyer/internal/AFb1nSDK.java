package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import expo.modules.kotlin.activityresult.DataPersistorKt;
import io.sentry.protocol.MetricSummary;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1nSDK {
    public final long AFInAppEventParameterName;
    public final int AFKeystoreWrapper;
    public final int valueOf;
    public final String values;

    public AFb1nSDK() {
    }

    static JSONObject AFInAppEventParameterName(String str) {
        JSONObject AFInAppEventParameterName2 = AFa1oSDK.AFInAppEventParameterName(str);
        if (AFInAppEventParameterName2 != null) {
            try {
                boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                boolean optBoolean = AFInAppEventParameterName2.optBoolean("monitor", false);
                AFb1sSDK AFVersionDeclaration = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration();
                if (!optBoolean || z) {
                    AFVersionDeclaration.values();
                    AFVersionDeclaration.valueOf();
                } else {
                    AFVersionDeclaration.AFKeystoreWrapper();
                }
                if (AFInAppEventParameterName2.has("ol_id")) {
                    String optString = AFInAppEventParameterName2.optString("ol_scheme", (String) null);
                    String optString2 = AFInAppEventParameterName2.optString("ol_domain", (String) null);
                    String optString3 = AFInAppEventParameterName2.optString("ol_ver", (String) null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                    }
                }
            } catch (Throwable th) {
                AFLogger.afErrorLogForExcManagerOnly(new StringBuilder("Error in handleResponse: ").append(th.getMessage()).toString(), th);
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values();
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().valueOf();
            }
        }
        return AFInAppEventParameterName2;
    }

    public AFb1nSDK(String str, int i, int i2, long j) {
        this.values = str;
        this.valueOf = i;
        this.AFKeystoreWrapper = i2;
        this.AFInAppEventParameterName = j;
    }

    public final String values() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", (Object) this.values);
            jSONObject.put(MetricSummary.JsonKeys.MIN, this.valueOf);
            jSONObject.put(DataPersistorKt.EXPIRE_KEY, this.AFKeystoreWrapper);
            jSONObject.put("ttl", this.AFInAppEventParameterName);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int hashCode() {
        String str = this.values;
        return ((((((str != null ? str.hashCode() : 0) * 31) + this.valueOf) * 31) + this.AFKeystoreWrapper) * 31) + ((int) this.AFInAppEventParameterName);
    }
}
