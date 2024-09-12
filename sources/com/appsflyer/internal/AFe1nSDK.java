package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;

public final class AFe1nSDK extends AFa1sSDK {
    public final boolean afRDLog() {
        return false;
    }

    public AFe1nSDK(Context context) {
        super("Register", new StringBuilder().append(String.format(AFe1mSDK.values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(context.getPackageName()).toString(), Boolean.FALSE, context);
    }

    public final AFd1sSDK AFKeystoreWrapper() {
        return AFd1sSDK.REGISTER;
    }
}
