package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import com.appsflyer.PurchaseHandler;
import java.util.Map;
import org.json.JSONObject;

public final class AFd1eSDK extends AFd1lSDK {
    private final AFb1bSDK afRDLog;

    public AFd1eSDK(Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, AFc1vSDK aFc1vSDK) {
        super(AFd1sSDK.PURCHASE_VALIDATE, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, (String) null, map, purchaseValidationCallback);
        this.afRDLog = aFc1vSDK.AFInAppEventParameterName();
        this.AFKeystoreWrapper.add(AFd1sSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        String obj = new StringBuilder().append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(this.afRDLog.values.AFKeystoreWrapper.getPackageName()).toString();
        String jSONObject = new JSONObject((Map<?, ?>) AFLogger$LogLevel()).toString();
        AFc1rSDK.AFInAppEventParameterName(new StringBuilder().append(this).append(": preparing data: ").append(jSONObject).toString());
        this.afErrorLog.AFInAppEventParameterName(obj, jSONObject);
        return this.afDebugLog.AFInAppEventParameterName(AFLogger$LogLevel(), str);
    }

    public final boolean values() {
        if (this.afInfoLog == null || this.afInfoLog.getStatusCode() != 503) {
            return super.values();
        }
        return true;
    }
}
