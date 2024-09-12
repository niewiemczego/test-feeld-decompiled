package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public abstract class AFf1jSDK extends Observable {
    public final Map<String, Object> AFInAppEventType = new HashMap();
    public AFa1wSDK AFKeystoreWrapper = AFa1wSDK.NOT_STARTED;
    long AFLogger;
    public final String afInfoLog;
    public final String valueOf;
    final Runnable values;

    public enum AFa1wSDK {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public abstract void values(Context context);

    public AFf1jSDK(String str, String str2, Runnable runnable) {
        this.values = runnable;
        this.valueOf = str2;
        this.afInfoLog = str;
    }

    public final void values() {
        this.AFInAppEventType.put("source", this.valueOf);
        this.AFInAppEventType.put("type", this.afInfoLog);
        this.AFInAppEventType.put("latency", Long.valueOf(System.currentTimeMillis() - this.AFLogger));
        this.AFKeystoreWrapper = AFa1wSDK.FINISHED;
        setChanged();
        notifyObservers();
    }
}
