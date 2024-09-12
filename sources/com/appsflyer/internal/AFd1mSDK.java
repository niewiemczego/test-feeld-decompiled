package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.Map;

public final class AFd1mSDK extends AFd1lSDK {
    public AFd1mSDK(Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, AFc1vSDK aFc1vSDK) {
        super(AFd1sSDK.ARS_VALIDATE, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, (String) null, map, purchaseValidationCallback);
        this.AFKeystoreWrapper.add(AFd1sSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        return this.afDebugLog.valueOf(AFLogger$LogLevel(), str);
    }
}
