package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AFa1sSDK {
    String AFInAppEventParameterName;
    public AppsFlyerRequestListener AFInAppEventType;
    public Application AFKeystoreWrapper;
    public String AFLogger;
    private byte[] AFLogger$LogLevel;
    public String afDebugLog;
    String afErrorLog;
    public int afInfoLog;
    String afRDLog;
    private final boolean afWarnLog;
    public final Map<String, Object> valueOf;
    Map<String, Object> values;

    public abstract AFd1sSDK AFKeystoreWrapper();

    public boolean AFLogger() {
        return true;
    }

    public boolean afErrorLog() {
        return false;
    }

    public boolean afInfoLog() {
        return true;
    }

    public boolean afRDLog() {
        return true;
    }

    public AFa1sSDK() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public AFa1sSDK(String str, String str2, Boolean bool, Context context) {
        boolean z;
        this.valueOf = new HashMap();
        this.afErrorLog = str;
        this.AFLogger = str2;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = true;
        }
        this.afWarnLog = z;
        if (context != null) {
            this.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
    }

    public AFa1sSDK AFInAppEventParameterName(String str) {
        this.AFLogger = str;
        return this;
    }

    public final boolean AFInAppEventParameterName() {
        return this.afErrorLog == null && this.afDebugLog == null;
    }

    public final AFa1sSDK AFInAppEventParameterName(Map<String, ?> map) {
        synchronized (map) {
            this.valueOf.putAll(map);
        }
        return this;
    }

    public final AFa1sSDK values(String str, Object obj) {
        synchronized (this.valueOf) {
            this.valueOf.put(str, obj);
        }
        return this;
    }

    public final Map<String, Object> AFInAppEventType() {
        return this.valueOf;
    }

    public final AFa1sSDK AFKeystoreWrapper(int i) {
        this.afInfoLog = i;
        synchronized (this.valueOf) {
            if (this.valueOf.containsKey(AnalyticsEventTypeAdapter.COUNTER)) {
                this.valueOf.put(AnalyticsEventTypeAdapter.COUNTER, Integer.toString(i));
            }
            if (this.valueOf.containsKey("launch_counter")) {
                this.valueOf.put("launch_counter", Integer.toString(i));
            }
        }
        return this;
    }

    public final AFa1sSDK AFKeystoreWrapper(byte[] bArr) {
        this.AFLogger$LogLevel = bArr;
        return this;
    }

    public final byte[] values() {
        return this.AFLogger$LogLevel;
    }

    public final boolean valueOf() {
        return this.afWarnLog;
    }

    public static boolean values(double d) {
        if (d < 0.0d || d >= 1.0d) {
            return false;
        }
        if (d == 0.0d) {
            return true;
        }
        int i = (int) (1.0d / d);
        int i2 = i + 1;
        if (i2 > 0) {
            return ((int) ((Math.random() * ((double) (i2 - 1))) + 1.0d)) != i;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }
}
