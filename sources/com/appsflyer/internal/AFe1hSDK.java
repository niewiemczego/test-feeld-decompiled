package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;

public final class AFe1hSDK extends AFd1qSDK<Void> {
    private final AFc1aSDK<String> afDebugLog;
    private final Throwable afErrorLog;
    private final AFc1xSDK afRDLog;

    public final long AFInAppEventParameterName() {
        return 1000;
    }

    public final boolean values() {
        return false;
    }

    public AFe1hSDK(AFd1dSDK aFd1dSDK, AFc1xSDK aFc1xSDK) {
        super(AFd1sSDK.GCDSDK, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, "GCD-CHECK");
        this.afErrorLog = aFd1dSDK.afRDLog();
        this.afDebugLog = aFd1dSDK.afInfoLog;
        this.afRDLog = aFc1xSDK;
    }

    public final AFd1tSDK AFInAppEventType() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.afRDLog.AFKeystoreWrapper("appsFlyerCount", 0))));
        long AFKeystoreWrapper = this.afRDLog.AFKeystoreWrapper("appsflyerConversionDataCacheExpiration", 0);
        if (AFKeystoreWrapper != 0 && System.currentTimeMillis() - AFKeystoreWrapper > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.afRDLog.AFInAppEventType("sixtyDayConversionData", true);
            this.afRDLog.AFKeystoreWrapper("attributionId", (String) null);
            this.afRDLog.AFInAppEventType("appsflyerConversionDataCacheExpiration", 0);
        }
        Map<String, Object> AFLogger = AFLogger();
        if (AFLogger != null) {
            try {
                if (!AFLogger.containsKey("is_first_launch")) {
                    AFLogger.put("is_first_launch", Boolean.FALSE);
                }
                AFe1oSDK.valueOf(AFLogger);
            } catch (Exception e) {
                AFLogger.afErrorLog(new StringBuilder("[GCD] Error executing conversion data callback: ").append(e.getLocalizedMessage()).toString(), e);
            }
            return AFd1tSDK.SUCCESS;
        }
        try {
            if (this.afErrorLog != null) {
                AFe1oSDK.AFInAppEventType(new StringBuilder("Launch exception: ").append(this.afErrorLog.getMessage()).toString());
                return AFd1tSDK.SUCCESS;
            }
            AFc1aSDK<String> aFc1aSDK = this.afDebugLog;
            if (aFc1aSDK != null && !aFc1aSDK.isSuccessful()) {
                AFe1oSDK.AFInAppEventType(new StringBuilder("Launch status code: ").append(this.afDebugLog.getStatusCode()).toString());
                return AFd1tSDK.SUCCESS;
            }
            return AFd1tSDK.FAILURE;
        } catch (Exception e2) {
            AFLogger.afErrorLog(new StringBuilder("[GCD] Error executing conversion data callback: ").append(e2.getLocalizedMessage()).toString(), e2);
        }
    }

    private Map<String, Object> AFLogger() {
        String AFInAppEventType = this.afRDLog.AFInAppEventType("attributionId", (String) null);
        if (AFInAppEventType == null) {
            return null;
        }
        try {
            new AFc1dSDK();
            return AFc1dSDK.AFKeystoreWrapper(AFInAppEventType);
        } catch (JSONException e) {
            AFLogger.afErrorLog(new StringBuilder("[GCD] Failed to parse GCD response: ").append(e.getMessage()).toString(), e);
            return null;
        }
    }
}
