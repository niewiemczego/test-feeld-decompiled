package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;

public final class AFb1hSDK {
    public final Application AFInAppEventType;

    public AFb1hSDK(Context context) {
        this.AFInAppEventType = (Application) context.getApplicationContext();
    }
}
