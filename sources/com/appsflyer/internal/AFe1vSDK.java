package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public final class AFe1vSDK extends AFd1iSDK<String> {
    private final Map<String, Object> afRDLog;

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return true;
    }

    public AFe1vSDK(Map<String, Object> map, AFc1vSDK aFc1vSDK) {
        super(AFd1sSDK.MONITORSDK, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, String.valueOf(map.hashCode()));
        this.afRDLog = new HashMap(map);
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        return this.afDebugLog.AFInAppEventParameterName(this.afRDLog);
    }
}
