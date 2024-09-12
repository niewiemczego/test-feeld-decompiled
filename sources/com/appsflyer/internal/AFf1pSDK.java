package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;

public abstract class AFf1pSDK extends AFf1jSDK {
    public AFf1pSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    protected static boolean AFKeystoreWrapper(Context context) {
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper(AFb1xSDK.valueOf(context), false) <= 0) {
            return true;
        }
        AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
        return false;
    }
}
