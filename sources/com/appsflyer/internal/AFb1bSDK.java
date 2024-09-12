package com.appsflyer.internal;

import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class AFb1bSDK {
    private static String AFInAppEventParameterName = "235";
    public final AFc1xSDK AFInAppEventType;
    private Bundle valueOf = null;
    public final AFc1wSDK values;

    public AFb1bSDK(AFc1wSDK aFc1wSDK, AFc1xSDK aFc1xSDK) {
        this.values = aFc1wSDK;
        this.AFInAppEventType = aFc1xSDK;
    }

    public static String valueOf() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public final String valueOf(String str) {
        Object obj;
        try {
            if (this.valueOf == null) {
                this.valueOf = this.values.AFKeystoreWrapper.getPackageManager().getApplicationInfo(this.values.AFKeystoreWrapper.getPackageName(), 128).metaData;
            }
            Bundle bundle = this.valueOf;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Could not load manifest metadata!").append(th.getMessage()).toString(), th);
            return null;
        }
    }

    public final boolean AFInAppEventType(String str) {
        String valueOf2 = valueOf(str);
        if (valueOf2 != null) {
            return Boolean.parseBoolean(valueOf2);
        }
        return false;
    }

    public static String AFKeystoreWrapper() {
        return new StringBuilder("version: 6.10.3 (build ").append(AFInAppEventParameterName).append(")").toString();
    }

    public final String values() {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = valueOf("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }
}
