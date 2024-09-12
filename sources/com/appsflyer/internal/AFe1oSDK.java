package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class AFe1oSDK {
    public String AFInAppEventParameterName;
    public final WeakReference<Context> valueOf;

    public AFe1oSDK() {
    }

    static void valueOf(Map<String, Object> map) {
        if (AFb1xSDK.valueOf != null) {
            AFLogger.afDebugLog(new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n").append(map.toString()).toString());
            AFb1xSDK.valueOf.onConversionDataSuccess(map);
        }
    }

    static void AFInAppEventType(String str) {
        if (AFb1xSDK.valueOf != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            AFb1xSDK.valueOf.onConversionDataFail(str);
        }
    }

    public AFe1oSDK(Context context) {
        this.valueOf = new WeakReference<>(context);
    }
}
