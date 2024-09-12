package com.appsflyer.internal;

import android.app.Application;

public final class AFb1fSDK {
    public static Application values;
    public long AFInAppEventParameterName;
    public String AFInAppEventType;
    public long AFKeystoreWrapper;
    public Throwable AFLogger;
    public AFf1uSDK afDebugLog;
    public String afErrorLog;
    public int afInfoLog;
    public String valueOf;

    public AFb1fSDK() {
    }

    public AFb1fSDK(String str, String str2, long j, long j2, int i, AFf1uSDK aFf1uSDK, String str3, Throwable th) {
        this.AFInAppEventType = str;
        this.valueOf = str2;
        this.AFKeystoreWrapper = j;
        this.AFInAppEventParameterName = j2;
        this.afInfoLog = i;
        this.afDebugLog = aFf1uSDK;
        this.afErrorLog = str3;
        this.AFLogger = th;
    }
}
