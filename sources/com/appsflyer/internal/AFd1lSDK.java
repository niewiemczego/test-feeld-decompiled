package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import com.amplitude.reactnative.AndroidContextProvider;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFc1qSDK;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AFd1lSDK extends AFd1iSDK<String> {
    private final Map<String, Object> AFVersionDeclaration;
    private final AFc1xSDK afErrorLogForExcManagerOnly;
    private final AFb1bSDK afRDLog;
    private final PurchaseHandler.PurchaseValidationCallback afWarnLog;

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return true;
    }

    public AFd1lSDK(AFd1sSDK aFd1sSDK, AFd1sSDK[] aFd1sSDKArr, AFc1vSDK aFc1vSDK, String str, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        super(aFd1sSDK, aFd1sSDKArr, aFc1vSDK, str);
        String str2;
        String str3;
        AFb1bSDK AFInAppEventParameterName = aFc1vSDK.AFInAppEventParameterName();
        this.afRDLog = AFInAppEventParameterName;
        AFc1xSDK afErrorLog = aFc1vSDK.afErrorLog();
        this.afErrorLogForExcManagerOnly = afErrorLog;
        HashMap hashMap = new HashMap(new HashMap(map));
        hashMap.put("app_id", AFInAppEventParameterName.values.AFKeystoreWrapper.getPackageName());
        String valueOf = AFb1bSDK.valueOf();
        if (valueOf != null) {
            hashMap.put("cuid", valueOf);
        }
        hashMap.put("app_version_name", AFa1cSDK.AFInAppEventParameterName(AFInAppEventParameterName.values.AFKeystoreWrapper, AFInAppEventParameterName.values.AFKeystoreWrapper.getPackageName()));
        HashMap hashMap2 = new HashMap();
        AFc1qSDK.AFa1vSDK AFInAppEventType = AFa1bSDK.AFInAppEventType(AFInAppEventParameterName.values.AFKeystoreWrapper, new HashMap());
        String str4 = null;
        if (AFInAppEventType != null) {
            str2 = AFInAppEventType.AFInAppEventParameterName;
        } else {
            str2 = null;
        }
        if (!AFb1pSDK.valueOf(str2)) {
            hashMap2.put(AndroidContextProvider.SETTING_ADVERTISING_ID, str2);
        }
        AFc1qSDK.AFa1vSDK values = AFa1bSDK.values(AFInAppEventParameterName.values.AFKeystoreWrapper.getContentResolver());
        if (values != null) {
            str3 = values.AFInAppEventParameterName;
        } else {
            str3 = null;
        }
        if (!AFb1pSDK.valueOf(str3)) {
            hashMap2.put("oaid", str3);
        }
        AFc1qSDK.AFa1vSDK values2 = AFa1bSDK.values(AFInAppEventParameterName.values.AFKeystoreWrapper.getContentResolver());
        str4 = values2 != null ? values2.AFInAppEventParameterName : str4;
        if (!AFb1pSDK.valueOf(str4)) {
            hashMap2.put("amazon_aid", str4);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String AFKeystoreWrapper = this.AFLogger.AFKeystoreWrapper(afErrorLog);
            if (!AFb1pSDK.valueOf(AFKeystoreWrapper)) {
                hashMap2.put("imei", AFKeystoreWrapper);
            }
        }
        hashMap2.put("appsflyer_id", AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(AFInAppEventParameterName.values.AFKeystoreWrapper)));
        hashMap2.put("os_version", new StringBuilder().append(Build.VERSION.SDK_INT).toString());
        hashMap2.put("sdk_version", AFb1xSDK.AFKeystoreWrapper);
        hashMap.put("device_data", hashMap2);
        this.AFVersionDeclaration = hashMap;
        this.afWarnLog = purchaseValidationCallback;
    }

    public final void AFKeystoreWrapper() {
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback;
        PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback2;
        super.AFKeystoreWrapper();
        Throwable afRDLog2 = afRDLog();
        if (!(afRDLog2 == null || (purchaseValidationCallback2 = this.afWarnLog) == null)) {
            purchaseValidationCallback2.onFailure(afRDLog2);
        }
        AFc1aSDK<Result> aFc1aSDK = this.afInfoLog;
        if (aFc1aSDK != null && (purchaseValidationCallback = this.afWarnLog) != null) {
            purchaseValidationCallback.onResponse(aFc1aSDK);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> AFLogger$LogLevel() {
        return this.AFVersionDeclaration;
    }
}
