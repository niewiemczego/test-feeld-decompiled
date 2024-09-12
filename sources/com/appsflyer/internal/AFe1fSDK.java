package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class AFe1fSDK {
    public final AFc1xSDK AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public long AFKeystoreWrapper = 0;
    public long AFLogger = 0;
    public long AFLogger$LogLevel;
    public final long[] afDebugLog = new long[2];
    public long afErrorLog = 0;
    public final long[] afInfoLog = new long[2];
    public final long[] afRDLog = new long[2];
    public long getLevel = 0;
    public final Map<String, Object> valueOf;
    public final Map<String, Object> values;

    public AFe1fSDK(AFc1xSDK aFc1xSDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.values = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.valueOf = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.AFInAppEventType = concurrentHashMap3;
        this.AFInAppEventParameterName = aFc1xSDK;
        concurrentHashMap.putAll(valueOf("first_launch"));
        concurrentHashMap2.putAll(valueOf("ddl"));
        concurrentHashMap3.putAll(valueOf("gcd"));
        this.AFLogger$LogLevel = aFc1xSDK.AFKeystoreWrapper("prev_session_dur", 0);
    }

    public final void AFInAppEventType() {
        this.AFLogger = System.currentTimeMillis();
        if (AFInAppEventParameterName()) {
            long j = this.AFKeystoreWrapper;
            if (j != 0) {
                this.values.put("init_to_fg", Long.valueOf(this.AFLogger - j));
                this.AFInAppEventParameterName.AFKeystoreWrapper("first_launch", new JSONObject((Map<?, ?>) this.values).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void values(AFe1gSDK aFe1gSDK) {
        if (AFInAppEventParameterName()) {
            this.values.put("start_with", aFe1gSDK.toString());
            this.AFInAppEventParameterName.AFKeystoreWrapper("first_launch", new JSONObject((Map<?, ?>) this.values).toString());
        }
    }

    public final void AFInAppEventParameterName(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.afErrorLog = currentTimeMillis;
        if (i == 1) {
            long j = this.AFLogger;
            if (j != 0) {
                this.values.put("from_fg", Long.valueOf(currentTimeMillis - j));
                this.AFInAppEventParameterName.AFKeystoreWrapper("first_launch", new JSONObject((Map<?, ?>) this.values).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: fg ts is missing");
        }
    }

    public final void AFInAppEventParameterName(DeepLinkResult deepLinkResult, long j) {
        this.valueOf.put("status", deepLinkResult.getStatus().toString());
        this.valueOf.put("timeout_value", Long.valueOf(j));
        this.AFInAppEventParameterName.AFKeystoreWrapper("ddl", new JSONObject((Map<?, ?>) this.valueOf).toString());
    }

    public final void AFInAppEventType(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.getLevel;
        if (j != 0) {
            this.AFInAppEventType.put("net", Long.valueOf(currentTimeMillis - j));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.AFInAppEventType.put("retries", Integer.valueOf(i));
        this.AFInAppEventParameterName.AFKeystoreWrapper("gcd", new JSONObject((Map<?, ?>) this.AFInAppEventType).toString());
    }

    private Map<String, Object> valueOf(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String AFInAppEventType2 = this.AFInAppEventParameterName.AFInAppEventType(str, (String) null);
        if (AFInAppEventType2 == null) {
            return emptyMap;
        }
        try {
            return AFa1oSDK.AFInAppEventType(new JSONObject(AFInAppEventType2));
        } catch (Exception e) {
            AFLogger.afErrorLog("Error while parsing cached json data", e, true);
            return emptyMap;
        }
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName.AFKeystoreWrapper("appsFlyerCount", 0) == 0;
    }
}
