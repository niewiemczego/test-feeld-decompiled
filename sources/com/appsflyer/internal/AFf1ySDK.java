package com.appsflyer.internal;

import android.content.Context;

public abstract class AFf1ySDK extends AFe1aSDK {
    public final boolean AFLogger() {
        return false;
    }

    public final boolean afInfoLog() {
        return false;
    }

    public final boolean afRDLog() {
        return false;
    }

    AFf1ySDK() {
        this((String) null, (Boolean) null, (Context) null);
    }

    AFf1ySDK(String str, Boolean bool, Context context) {
        super(str, (String) null, Boolean.FALSE, (Boolean) null, bool, context);
    }
}
