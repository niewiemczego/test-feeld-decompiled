package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class AFe1lSDK extends AFd1iSDK<Map<String, Object>> {
    private static final List<String> afRDLog = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    private final AFb1bSDK AFLogger$LogLevel;
    private final AFc1xSDK AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private final AFe1fSDK afErrorLogForExcManagerOnly;
    private final AFc1kSDK afWarnLog;
    private Map<String, Object> getLevel;

    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final boolean afDebugLog() {
        return false;
    }

    public final boolean values() {
        return false;
    }

    public AFe1lSDK(AFc1vSDK aFc1vSDK) {
        super(AFd1sSDK.GCDSDK, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, "GCD-FETCH");
        this.afWarnLog = aFc1vSDK.AFKeystoreWrapper();
        this.AFVersionDeclaration = aFc1vSDK.afErrorLog();
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFLogger();
        this.AFLogger$LogLevel = aFc1vSDK.AFInAppEventParameterName();
        this.AFKeystoreWrapper.add(AFd1sSDK.CONVERSION);
        this.AFKeystoreWrapper.add(AFd1sSDK.LAUNCH);
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        Map<String, Object> map = this.getLevel;
        String str = this.AppsFlyer2dXConversionCallback;
        if (map != null) {
            AFe1oSDK.valueOf(map);
        } else if (str == null || str.isEmpty()) {
            AFe1oSDK.AFInAppEventType("Unknown error");
        } else {
            AFe1oSDK.AFInAppEventType(str);
        }
    }

    public final AFc1mSDK<Map<String, Object>> AFInAppEventParameterName(String str) {
        String str2;
        String values = AFb1xSDK.values(this.AFVersionDeclaration, this.AFLogger$LogLevel.values());
        if (values != null && !values.trim().isEmpty()) {
            if (!afRDLog.contains(values.toLowerCase(Locale.getDefault()))) {
                str2 = "-".concat(String.valueOf(values));
                AFc1mSDK<Map<String, Object>> values2 = this.afWarnLog.values(str2, str);
                AFc1rSDK.AFInAppEventParameterName(new StringBuilder("[GCD-B01] URL: ").append(values2.valueOf.values()).toString());
                return values2;
            }
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", new Object[]{values}));
        }
        str2 = "";
        AFc1mSDK<Map<String, Object>> values22 = this.afWarnLog.values(str2, str);
        AFc1rSDK.AFInAppEventParameterName(new StringBuilder("[GCD-B01] URL: ").append(values22.valueOf.values()).toString());
        return values22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108, all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108, all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae A[Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108, all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fb A[Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108, all -> 0x0106 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1tSDK AFInAppEventType() throws java.lang.Exception {
        /*
            r14 = this;
            java.lang.String r0 = "af_channel"
            java.lang.String r1 = "is_first_launch"
            java.lang.String r2 = "af_siteid"
            java.lang.String r3 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.internal.AFe1kSDK r4 = r14.AFLogger
            boolean r4 = r4.valueOf()
            if (r4 != 0) goto L_0x014d
            com.appsflyer.internal.AFd1tSDK r4 = com.appsflyer.internal.AFd1tSDK.FAILURE
            r5 = 0
            r6 = r5
        L_0x0014:
            r7 = 2
            if (r6 > r7) goto L_0x014c
            r4 = 1
            if (r6 < r7) goto L_0x001c
            r7 = r4
            goto L_0x001d
        L_0x001c:
            r7 = r5
        L_0x001d:
            com.appsflyer.internal.AFe1fSDK r8 = r14.afErrorLogForExcManagerOnly
            long r9 = java.lang.System.currentTimeMillis()
            r8.getLevel = r9
            com.appsflyer.internal.AFd1tSDK r8 = super.AFInAppEventType()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.internal.AFc1aSDK<Result> r9 = r14.afInfoLog     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r9 != 0) goto L_0x002f
            goto L_0x0123
        L_0x002f:
            int r10 = r9.getStatusCode()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r11 = 403(0x193, float:5.65E-43)
            if (r10 == r11) goto L_0x003e
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 < r11) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r11 = r5
            goto L_0x003f
        L_0x003e:
            r11 = r4
        L_0x003f:
            boolean r12 = r9.isSuccessful()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r13 = 404(0x194, float:5.66E-43)
            if (r12 != 0) goto L_0x0069
            if (r10 != r13) goto L_0x004a
            goto L_0x0069
        L_0x004a:
            if (r7 != 0) goto L_0x0052
            if (r11 != 0) goto L_0x0123
            goto L_0x0052
        L_0x004f:
            r4 = r8
            goto L_0x012d
        L_0x0052:
            java.lang.String r4 = "Error connection to server: "
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r4 = r4.concat(r8)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r14.AppsFlyer2dXConversionCallback = r4     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.FAILURE     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
        L_0x0060:
            com.appsflyer.internal.AFe1fSDK r1 = r14.afErrorLogForExcManagerOnly
            r1.AFInAppEventType(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            return r0
        L_0x0069:
            java.lang.Object r8 = r9.getBody()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            int r9 = r9.getStatusCode()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r10 = "iscache"
            java.lang.Object r10 = r8.get(r10)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r9 != r13) goto L_0x0095
            java.lang.String r9 = "error_reason"
            r8.remove(r9)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r9 = "status_code"
            r8.remove(r9)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r9 = "af_status"
            java.lang.String r11 = "Organic"
            r8.put(r9, r11)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r9 = "af_message"
            java.lang.String r11 = "organic install"
            r8.put(r9, r11)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
        L_0x0095:
            if (r10 == 0) goto L_0x00a8
            boolean r9 = r10.booleanValue()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r9 != 0) goto L_0x00a8
            com.appsflyer.internal.AFc1xSDK r9 = r14.AFVersionDeclaration     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r10 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r9.AFInAppEventType((java.lang.String) r10, (long) r11)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
        L_0x00a8:
            boolean r9 = r8.containsKey(r2)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r9 == 0) goto L_0x00dc
            boolean r9 = r8.containsKey(r0)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r9 == 0) goto L_0x00cb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r9 = "[Invite] Detected App-Invite via channel: "
            r4.<init>(r9)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.Object r9 = r8.get(r0)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r4 = r4.toString()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            goto L_0x00dc
        L_0x00cb:
            java.lang.String r9 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.Object r10 = r8.get(r2)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r4[r5] = r10     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r4 = java.lang.String.format(r9, r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
        L_0x00dc:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r8.put(r1, r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r4.<init>((java.util.Map<?, ?>) r8)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r4 = r4.toString()     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.internal.AFc1xSDK r9 = r14.AFVersionDeclaration     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r10 = "attributionId"
            r9.AFKeystoreWrapper((java.lang.String) r10, (java.lang.String) r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.internal.AFc1xSDK r4 = r14.AFVersionDeclaration     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            java.lang.String r9 = "sixtyDayConversionData"
            boolean r4 = r4.AFInAppEventParameterName(r9)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            if (r4 != 0) goto L_0x0100
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            r8.put(r1, r4)     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
        L_0x0100:
            r14.getLevel = r8     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.SUCCESS     // Catch:{ AFd1oSDK -> 0x0138, Exception -> 0x0108 }
            goto L_0x0060
        L_0x0106:
            r0 = move-exception
            goto L_0x0143
        L_0x0108:
            r4 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            java.lang.String r9 = "[GCD] Error: "
            r8.<init>(r9)     // Catch:{ all -> 0x0106 }
            java.lang.String r9 = r4.getMessage()     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x0106 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0106 }
            com.appsflyer.AFLogger.afErrorLog(r8, r4)     // Catch:{ all -> 0x0106 }
            com.appsflyer.internal.AFd1tSDK r8 = com.appsflyer.internal.AFd1tSDK.FAILURE     // Catch:{ all -> 0x0106 }
            if (r7 != 0) goto L_0x0131
        L_0x0123:
            com.appsflyer.internal.AFe1fSDK r4 = r14.afErrorLogForExcManagerOnly
            r4.AFInAppEventType(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x004f
        L_0x012d:
            int r6 = r6 + 1
            goto L_0x0014
        L_0x0131:
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x0106 }
            r14.AppsFlyer2dXConversionCallback = r0     // Catch:{ all -> 0x0106 }
            throw r4     // Catch:{ all -> 0x0106 }
        L_0x0138:
            r0 = move-exception
            java.lang.String r1 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = "AppsFlyer dev key is missing"
            r14.AppsFlyer2dXConversionCallback = r1     // Catch:{ all -> 0x0106 }
            throw r0     // Catch:{ all -> 0x0106 }
        L_0x0143:
            com.appsflyer.internal.AFe1fSDK r1 = r14.afErrorLogForExcManagerOnly
            r1.AFInAppEventType(r6)
            com.appsflyer.AFLogger.afDebugLog(r3)
            throw r0
        L_0x014c:
            return r4
        L_0x014d:
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            r14.AppsFlyer2dXConversionCallback = r0
            com.appsflyer.internal.AFd1nSDK r0 = new com.appsflyer.internal.AFd1nSDK
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AFInAppEventType():com.appsflyer.internal.AFd1tSDK");
    }
}
