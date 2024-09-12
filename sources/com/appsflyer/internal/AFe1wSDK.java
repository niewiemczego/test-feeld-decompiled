package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

public final class AFe1wSDK extends AFd1qSDK<AFe1xSDK> {
    public AFe1xSDK AFLogger = null;
    private final String AFLogger$LogLevel;
    private final AFe1rSDK AFVersionDeclaration;
    private final AFb1bSDK afDebugLog;
    public AFb1fSDK afErrorLog;
    private final AFe1kSDK afErrorLogForExcManagerOnly;
    private final AFe1uSDK afInfoLog;
    public final AFe1ySDK afRDLog;
    private final AFe1tSDK afWarnLog;
    private final AFc1kSDK getLevel;

    public final long AFInAppEventParameterName() {
        return 1500;
    }

    public final boolean values() {
        return false;
    }

    public AFe1wSDK(AFe1uSDK aFe1uSDK, AFb1bSDK aFb1bSDK, AFe1kSDK aFe1kSDK, AFe1tSDK aFe1tSDK, AFc1kSDK aFc1kSDK, AFe1rSDK aFe1rSDK, String str, AFe1ySDK aFe1ySDK) {
        super(AFd1sSDK.RC_CDN, new AFd1sSDK[0], "UpdateRemoteConfiguration");
        this.afInfoLog = aFe1uSDK;
        this.afDebugLog = aFb1bSDK;
        this.afErrorLogForExcManagerOnly = aFe1kSDK;
        this.afWarnLog = aFe1tSDK;
        this.getLevel = aFc1kSDK;
        this.AFVersionDeclaration = aFe1rSDK;
        this.AFLogger$LogLevel = str;
        this.afRDLog = aFe1ySDK;
    }

    public final AFd1tSDK AFInAppEventType() throws Exception {
        try {
            AFe1xSDK afDebugLog2 = afDebugLog();
            this.AFLogger = afDebugLog2;
            if (afDebugLog2 == AFe1xSDK.FAILURE) {
                return AFd1tSDK.FAILURE;
            }
            return AFd1tSDK.SUCCESS;
        } catch (InterruptedIOException | InterruptedException e) {
            AFLogger.afErrorLogForExcManagerOnly("RC update config failed", e);
            this.AFLogger = AFe1xSDK.FAILURE;
            return AFd1tSDK.TIMEOUT;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055 A[SYNTHETIC, Splitter:B:12:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.AFe1xSDK afDebugLog() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            r16 = this;
            r10 = r16
            java.lang.String r0 = " seconds"
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = r10.AFLogger$LogLevel
            com.appsflyer.internal.AFe1kSDK r2 = r10.afErrorLogForExcManagerOnly
            java.lang.String r2 = r2.AFInAppEventType
            r3 = 2
            java.lang.String r4 = "CFG: Dev key is not set, SDK is not started."
            r11 = 1
            r13 = 0
            if (r2 == 0) goto L_0x0047
            java.lang.String r5 = r2.trim()
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0020
            goto L_0x0047
        L_0x0020:
            if (r1 != 0) goto L_0x0028
            java.lang.String r1 = "CFG: Can't create CDN token, domain or version is not provided."
            com.appsflyer.AFLogger.afWarnLog(r1)
            goto L_0x004a
        L_0x0028:
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.String r6 = "appsflyersdk.com"
            r5[r13] = r6
            r5[r11] = r1
            com.appsflyer.internal.AFb1bSDK r1 = r10.afDebugLog
            com.appsflyer.internal.AFc1wSDK r1 = r1.values
            android.content.Context r1 = r1.AFKeystoreWrapper
            java.lang.String r1 = r1.getPackageName()
            r5[r3] = r1
            java.lang.String r1 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper((java.lang.String[]) r5)
            java.lang.String r1 = com.appsflyer.internal.AFb1ySDK.values(r1, r2)
            r14 = r1
            goto L_0x004b
        L_0x0047:
            com.appsflyer.AFLogger.afWarnLog(r4)
        L_0x004a:
            r14 = 0
        L_0x004b:
            if (r14 != 0) goto L_0x0055
            java.lang.String r0 = "CFG: can't create CDN token, skipping fetch config"
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE
            return r0
        L_0x0055:
            com.appsflyer.internal.AFe1rSDK r1 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            boolean r1 = r1.valueOf()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            if (r1 == 0) goto L_0x0158
            java.lang.String r1 = "CFG: Cached config is expired, updating..."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1rSDK r1 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            boolean r1 = r1.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1rSDK r2 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            boolean r2 = r2.values()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFc1kSDK r5 = r10.getLevel     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r6 = 1500(0x5dc, float:2.102E-42)
            com.appsflyer.internal.AFc1mSDK r1 = r5.AFInAppEventType(r1, r2, r14, r6)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFc1aSDK r15 = r1.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            boolean r1 = r15.isSuccessful()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            if (r1 == 0) goto L_0x0135
            java.lang.Object r1 = r15.getBody()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFb1lSDK r1 = (com.appsflyer.internal.AFb1lSDK) r1     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r2 = "x-amz-meta-af-auth-v1"
            java.lang.String r2 = r15.valueOf(r2)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r5 = "CF-Cache-Status"
            java.lang.String r6 = r15.valueOf(r5)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1kSDK r5 = r10.afErrorLogForExcManagerOnly     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r5 = r5.AFInAppEventType     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            if (r5 == 0) goto L_0x012f
            java.lang.String r7 = r5.trim()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            int r7 = r7.length()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            if (r7 != 0) goto L_0x00a4
            goto L_0x012f
        L_0x00a4:
            com.appsflyer.internal.AFe1uSDK r4 = r10.afInfoLog     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1qSDK r2 = r4.AFInAppEventType(r1, r2, r14, r5)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            boolean r4 = r2.values()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            if (r4 == 0) goto L_0x011d
            com.appsflyer.internal.AFe1rSDK r4 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            long r4 = r4.AFInAppEventParameterName()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r12 = "CFG: using max-age fallback: "
            r7.<init>(r12)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.AFLogger.afRDLog(r7)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1tSDK r7 = r10.afWarnLog     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r13 = r1.values     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.nio.charset.Charset r3 = com.appsflyer.internal.AFe1tSDK.valueOf     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            byte[] r3 = r13.getBytes(r3)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r13 = 2
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r13)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFc1xSDK r13 = r7.AFKeystoreWrapper     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r10 = "af_remote_config"
            r13.AFKeystoreWrapper((java.lang.String) r10, (java.lang.String) r3)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFc1xSDK r3 = r7.AFKeystoreWrapper     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r10 = "af_rc_timestamp"
            r3.AFInAppEventType((java.lang.String) r10, (long) r11)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFc1xSDK r3 = r7.AFKeystoreWrapper     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r10 = "af_rc_max_age"
            r3.AFInAppEventType((java.lang.String) r10, (long) r4)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r7.values = r1     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r7.AFInAppEventType = r11     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r7.AFInAppEventParameterName = r4     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r3 = "CFG: Config successfully updated, timeToLive: "
            r1.<init>(r3)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFf1uSDK r5 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.SUCCESS     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            return r0
        L_0x011d:
            com.appsflyer.internal.AFf1uSDK r5 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r0 = "CFG: fetched config is not valid (MITM?) refuse to use it."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            return r0
        L_0x012f:
            com.appsflyer.AFLogger.afWarnLog(r4)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            return r0
        L_0x0135:
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r1 = "CFG: failed to fetch remote config from CDN with status code: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            int r1 = r15.getStatusCode()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            return r0
        L_0x0158:
            java.lang.String r0 = "CFG: active config is valid, skipping fetch"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.USE_CACHED     // Catch:{ IOException -> 0x0198, all -> 0x0160 }
            return r0
        L_0x0160:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to update remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            r5 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r8 = r10
            r9 = r0
            r1.valueOf(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.InterruptedException
            if (r1 != 0) goto L_0x0191
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE
            return r0
        L_0x0191:
            java.lang.Throwable r0 = r0.getCause()
            java.lang.InterruptedException r0 = (java.lang.InterruptedException) r0
            throw r0
        L_0x0198:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to fetch remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            boolean r1 = r0 instanceof com.appsflyer.internal.components.network.http.exceptions.ParsingException
            if (r1 == 0) goto L_0x01be
            r1 = r0
            com.appsflyer.internal.components.network.http.exceptions.ParsingException r1 = (com.appsflyer.internal.components.network.http.exceptions.ParsingException) r1
            com.appsflyer.internal.AFc1aSDK r1 = r1.getRawResponse()
            r5 = r1
            goto L_0x01bf
        L_0x01be:
            r5 = 0
        L_0x01bf:
            r6 = 0
            r7 = 0
            r10 = 0
            r1 = r16
            r2 = r14
            r3 = r8
            r8 = r10
            r9 = r0
            r1.valueOf(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.InterruptedIOException
            if (r1 != 0) goto L_0x01d6
            com.appsflyer.internal.AFe1xSDK r0 = com.appsflyer.internal.AFe1xSDK.FAILURE
            return r0
        L_0x01d6:
            java.lang.Throwable r0 = r0.getCause()
            java.io.InterruptedIOException r0 = (java.io.InterruptedIOException) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1wSDK.afDebugLog():com.appsflyer.internal.AFe1xSDK");
    }

    private void values(String str, long j, AFf1uSDK aFf1uSDK, String str2, AFc1aSDK<AFb1lSDK> aFc1aSDK) {
        valueOf(str, j, aFc1aSDK, aFc1aSDK != null ? aFc1aSDK.getBody() : null, aFf1uSDK, str2 != null ? str2 : null, (Throwable) null);
    }

    private void valueOf(String str, long j, AFc1aSDK<?> aFc1aSDK, AFb1lSDK aFb1lSDK, AFf1uSDK aFf1uSDK, String str2, Throwable th) {
        long j2;
        int i;
        Throwable th2;
        long j3;
        String str3;
        AFc1aSDK<?> aFc1aSDK2 = aFc1aSDK;
        AFb1lSDK aFb1lSDK2 = aFb1lSDK;
        Throwable th3 = th;
        if (aFc1aSDK2 != null) {
            j2 = aFc1aSDK2.AFInAppEventParameterName.AFInAppEventType;
            i = aFc1aSDK.getStatusCode();
        } else {
            j2 = 0;
            i = 0;
        }
        int i2 = i;
        if (th3 instanceof HttpException) {
            th2 = th.getCause();
            j3 = ((HttpException) th3).getMetrics().AFInAppEventType;
        } else {
            th2 = th3;
            j3 = j2;
        }
        if (aFb1lSDK2 != null) {
            str3 = aFb1lSDK2.valueOf;
        } else {
            str3 = null;
        }
        this.afErrorLog = new AFb1fSDK(str3, str, j3, System.currentTimeMillis() - j, i2, aFf1uSDK, str2, th2);
    }
}
