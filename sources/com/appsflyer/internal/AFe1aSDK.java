package com.appsflyer.internal;

import android.content.Context;

public abstract class AFe1aSDK extends AFa1sSDK {
    public boolean AFLogger$LogLevel;
    private final boolean afWarnLog;
    private final boolean getLevel;

    AFe1aSDK() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1aSDK(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.afWarnLog = bool != null ? bool.booleanValue() : true;
        this.getLevel = bool2 != null ? bool2.booleanValue() : z;
    }

    public final boolean AFLogger$LogLevel() {
        return this.AFLogger$LogLevel;
    }

    public final boolean AFVersionDeclaration() {
        return this.afWarnLog;
    }

    public final boolean getLevel() {
        return this.getLevel;
    }
}
