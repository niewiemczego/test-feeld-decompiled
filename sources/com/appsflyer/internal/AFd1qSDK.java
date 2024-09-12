package com.appsflyer.internal;

import android.net.TrafficStats;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AFd1qSDK<Result> implements Comparable<AFd1qSDK<?>>, Callable<AFd1tSDK> {
    private static final AtomicInteger afErrorLog = new AtomicInteger();
    public volatile int AFInAppEventParameterName;
    public AFd1tSDK AFInAppEventType;
    public final Set<AFd1sSDK> AFKeystoreWrapper = new HashSet();
    private final String AFLogger;
    private Throwable afDebugLog;
    private final int afInfoLog;
    private long afRDLog;
    private boolean afWarnLog;
    public final Set<AFd1sSDK> valueOf;
    public final AFd1sSDK values;

    /* access modifiers changed from: protected */
    public abstract long AFInAppEventParameterName();

    /* access modifiers changed from: protected */
    public abstract AFd1tSDK AFInAppEventType() throws Exception;

    /* access modifiers changed from: protected */
    public void AFKeystoreWrapper() {
    }

    /* access modifiers changed from: protected */
    public void valueOf(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean values();

    public AFd1qSDK(AFd1sSDK aFd1sSDK, AFd1sSDK[] aFd1sSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.valueOf = hashSet;
        int incrementAndGet = afErrorLog.incrementAndGet();
        this.afInfoLog = incrementAndGet;
        this.afWarnLog = false;
        this.AFInAppEventParameterName = 0;
        this.values = aFd1sSDK;
        Collections.addAll(hashSet, aFd1sSDKArr);
        if (str != null) {
            this.AFLogger = str;
        } else {
            this.AFLogger = String.valueOf(incrementAndGet);
        }
    }

    public void valueOf() {
        this.afWarnLog = true;
    }

    /* access modifiers changed from: protected */
    public final boolean afErrorLog() {
        return this.afWarnLog;
    }

    /* renamed from: afInfoLog */
    public final AFd1tSDK call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        this.AFInAppEventType = null;
        this.afDebugLog = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.AFInAppEventParameterName++;
        try {
            AFd1tSDK AFInAppEventType2 = AFInAppEventType();
            this.AFInAppEventType = AFInAppEventType2;
            this.afRDLog = System.currentTimeMillis() - currentTimeMillis;
            AFKeystoreWrapper();
            return AFInAppEventType2;
        } catch (Throwable th) {
            this.afRDLog = System.currentTimeMillis() - currentTimeMillis;
            AFKeystoreWrapper();
            throw th;
        }
    }

    public final Throwable afRDLog() {
        return this.afDebugLog;
    }

    /* renamed from: AFInAppEventType */
    public final int compareTo(AFd1qSDK<?> aFd1qSDK) {
        int i = this.values.onInstallConversionDataLoadedNative - aFd1qSDK.values.onInstallConversionDataLoadedNative;
        if (i != 0) {
            return i;
        }
        if (this.AFLogger.equals(aFd1qSDK.AFLogger)) {
            return 0;
        }
        return this.afInfoLog - aFd1qSDK.afInfoLog;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFd1qSDK aFd1qSDK = (AFd1qSDK) obj;
        if (this.values != aFd1qSDK.values) {
            return false;
        }
        return this.AFLogger.equals(aFd1qSDK.AFLogger);
    }

    public final int hashCode() {
        return (this.values.hashCode() * 31) + this.AFLogger.hashCode();
    }

    public String toString() {
        String obj = new StringBuilder().append(this.values).append("-").append(this.AFLogger).toString();
        return !String.valueOf(this.afInfoLog).equals(this.AFLogger) ? new StringBuilder().append(obj).append("-").append(this.afInfoLog).toString() : obj;
    }
}
