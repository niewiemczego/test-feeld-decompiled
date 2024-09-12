package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFa1ySDK;
import io.sentry.protocol.Mechanism;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public class AFd1cSDK extends AFd1iSDK<String> {
    private static final AFd1sSDK[] AFLogger$LogLevel = {AFd1sSDK.DLSDK, AFd1sSDK.ONELINK, AFd1sSDK.MONITORSDK, AFd1sSDK.REGISTER};
    protected final AFc1xSDK AFVersionDeclaration;
    private final AFb1rSDK afErrorLogForExcManagerOnly;
    public final AFa1sSDK afRDLog;
    private final AFb1bSDK afWarnLog;
    private final AFd1xSDK getLevel;

    /* access modifiers changed from: protected */
    public boolean afDebugLog() {
        return true;
    }

    public AFd1cSDK(AFa1sSDK aFa1sSDK, AFc1vSDK aFc1vSDK) {
        this(aFa1sSDK, aFc1vSDK, (String) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFd1cSDK(AFa1sSDK aFa1sSDK, AFc1vSDK aFc1vSDK, String str) {
        super(aFa1sSDK.AFKeystoreWrapper(), new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, str);
        int i = 0;
        this.afRDLog = aFa1sSDK;
        this.getLevel = aFc1vSDK.onInstallConversionDataLoadedNative();
        this.AFVersionDeclaration = aFc1vSDK.afErrorLog();
        this.afErrorLogForExcManagerOnly = aFc1vSDK.afRDLog();
        this.afWarnLog = aFc1vSDK.AFInAppEventParameterName();
        AFd1sSDK[] aFd1sSDKArr = AFLogger$LogLevel;
        int length = aFd1sSDKArr.length;
        while (i < length) {
            if (this.values != aFd1sSDKArr[i]) {
                i++;
            } else {
                return;
            }
        }
        int i2 = this.afRDLog.afInfoLog;
        AFd1sSDK aFd1sSDK = this.values;
        if (i2 > 0) {
            this.AFKeystoreWrapper.add(AFd1sSDK.CONVERSION);
        } else if (aFd1sSDK != AFd1sSDK.CONVERSION) {
            this.valueOf.add(AFd1sSDK.CONVERSION);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae A[SYNTHETIC, Splitter:B:28:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b4 A[Catch:{ NullPointerException -> 0x00bd, all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1mSDK<java.lang.String> AFInAppEventParameterName(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "JSON toString of eventParams map returns null"
            java.lang.String r3 = "*Non-printing character*"
            java.lang.String r4 = "\\p{C}"
            java.lang.String r5 = "Unexpected error"
            java.lang.String r6 = ""
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            r1.valueOf(r0)
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.util.Map r0 = r0.AFInAppEventType()
            java.lang.String r7 = "meta"
            boolean r0 = r0.containsKey(r7)
            if (r0 == 0) goto L_0x003c
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.appsflyer.internal.AFb1rSDK r0 = r1.afErrorLogForExcManagerOnly     // Catch:{ NullPointerException -> 0x002d }
            com.appsflyer.internal.AFe1tSDK r0 = r0.AFKeystoreWrapper     // Catch:{ NullPointerException -> 0x002d }
            com.appsflyer.internal.AFb1lSDK r0 = r0.values     // Catch:{ NullPointerException -> 0x002d }
            com.appsflyer.internal.AFb1pSDK r0 = r0.AFInAppEventParameterName     // Catch:{ NullPointerException -> 0x002d }
            com.appsflyer.internal.AFb1oSDK r0 = r0.AFInAppEventParameterName     // Catch:{ NullPointerException -> 0x002d }
            double r8 = r0.AFInAppEventParameterName     // Catch:{ NullPointerException -> 0x002d }
        L_0x002d:
            boolean r0 = com.appsflyer.internal.AFa1sSDK.values(r8)
            if (r0 == 0) goto L_0x003c
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.util.Map r0 = r0.AFInAppEventType()
            r0.remove(r7)
        L_0x003c:
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.lang.String r7 = r0.AFLogger
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.util.Map r8 = r0.AFInAppEventType()
            r9 = 0
            r10 = 1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x006c, all -> 0x0064 }
            r0.<init>((java.util.Map<?, ?>) r8)     // Catch:{ NullPointerException -> 0x006c, all -> 0x0064 }
            java.lang.String r11 = r0.toString()     // Catch:{ NullPointerException -> 0x006c, all -> 0x0064 }
            if (r11 == 0) goto L_0x0059
            java.lang.String r0 = r11.replaceAll(r4, r3)     // Catch:{ NullPointerException -> 0x0062, all -> 0x005f }
            goto L_0x00d5
        L_0x0059:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x0062, all -> 0x005f }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x0062, all -> 0x005f }
            throw r0     // Catch:{ NullPointerException -> 0x0062, all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            r9 = r11
            goto L_0x0065
        L_0x0062:
            r0 = move-exception
            goto L_0x006e
        L_0x0064:
            r0 = move-exception
        L_0x0065:
            com.appsflyer.AFLogger.afErrorLog(r5, r0, r10)
            r0 = r6
            r11 = r9
            goto L_0x00d5
        L_0x006c:
            r0 = move-exception
            r11 = r9
        L_0x006e:
            java.lang.String r12 = "JSONObject return null String object. Trying to create AFJsonObject."
            com.appsflyer.AFLogger.afErrorLog(r12, r0, r10)
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ all -> 0x00c0 }
            r12 = 0
            r0[r12] = r8     // Catch:{ all -> 0x00c0 }
            r8 = 48062(0xbbbe, float:6.7349E-41)
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c0 }
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r13 = r13 + r8
            char r8 = (char) r13     // Catch:{ all -> 0x00c0 }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c0 }
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r13 = r13 + 36
            int r14 = android.text.TextUtils.getTrimmedLength(r6)     // Catch:{ all -> 0x00c0 }
            int r14 = r14 + 73
            java.lang.Object r8 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r8, r13, r14)     // Catch:{ all -> 0x00c0 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x00c0 }
            java.lang.String r13 = "AFInAppEventType"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x00c0 }
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            r14[r12] = r15     // Catch:{ all -> 0x00c0 }
            java.lang.reflect.Method r8 = r8.getMethod(r13, r14)     // Catch:{ all -> 0x00c0 }
            java.lang.Object r0 = r8.invoke(r9, r0)     // Catch:{ all -> 0x00c0 }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00c0 }
            if (r8 == 0) goto L_0x00b4
            java.lang.String r0 = r8.replaceAll(r4, r3)     // Catch:{ NullPointerException -> 0x00bd, all -> 0x00ba }
            r11 = r8
            goto L_0x00d5
        L_0x00b4:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x00bd, all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x00bd, all -> 0x00ba }
            throw r0     // Catch:{ NullPointerException -> 0x00bd, all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            r11 = r8
            goto L_0x00ca
        L_0x00bd:
            r0 = move-exception
            r11 = r8
            goto L_0x00cf
        L_0x00c0:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ NullPointerException -> 0x00ce, all -> 0x00c9 }
            if (r2 == 0) goto L_0x00c8
            throw r2     // Catch:{ NullPointerException -> 0x00ce, all -> 0x00c9 }
        L_0x00c8:
            throw r0     // Catch:{ NullPointerException -> 0x00ce, all -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
        L_0x00ca:
            com.appsflyer.AFLogger.afErrorLog(r5, r0, r10)
            goto L_0x00d4
        L_0x00ce:
            r0 = move-exception
        L_0x00cf:
            java.lang.String r2 = "AFJsonObject return null String object."
            com.appsflyer.AFLogger.afErrorLog(r2, r0, r10)
        L_0x00d4:
            r0 = r6
        L_0x00d5:
            if (r11 != 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r6 = r11
        L_0x00d9:
            boolean r2 = r0.equals(r6)
            if (r2 != 0) goto L_0x00e5
            java.lang.String r2 = "Payload contains non-printing characters"
            com.appsflyer.AFLogger.afWarnLog(r2)
            goto L_0x00e6
        L_0x00e5:
            r0 = r6
        L_0x00e6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = ": preparing data: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.appsflyer.internal.AFc1rSDK.AFInAppEventParameterName((java.lang.String) r2)
            com.appsflyer.internal.AFb1sSDK r2 = r1.afErrorLog
            r2.AFInAppEventParameterName(r7, r0)
            com.appsflyer.internal.AFc1kSDK r0 = r1.afDebugLog
            com.appsflyer.internal.AFa1sSDK r2 = r1.afRDLog
            r3 = r18
            com.appsflyer.internal.AFc1mSDK r0 = r0.AFInAppEventType(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1cSDK.AFInAppEventParameterName(java.lang.String):com.appsflyer.internal.AFc1mSDK");
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return this.afRDLog.AFInAppEventType;
    }

    /* access modifiers changed from: protected */
    public void valueOf(AFa1sSDK aFa1sSDK) {
        AFd1vSDK aFd1vSDK;
        if (aFa1sSDK.afRDLog()) {
            aFa1sSDK.AFInAppEventParameterName((Map<String, ?>) new AFa1ySDK.AFa1xSDK(aFa1sSDK.AFInAppEventType(), this.AFLogger.values.AFKeystoreWrapper));
        }
        if (aFa1sSDK.afInfoLog()) {
            aFa1sSDK.AFInAppEventParameterName((Map<String, ?>) this.AFLogger.AFInAppEventParameterName());
        }
        Set<AFd1sSDK> set = this.valueOf;
        boolean z = true;
        boolean z2 = set.contains(AFd1sSDK.LAUNCH) || set.contains(AFd1sSDK.CONVERSION);
        if (afErrorLog() && z2) {
            aFa1sSDK.AFKeystoreWrapper(this.AFVersionDeclaration.AFKeystoreWrapper("appsFlyerCount", 0));
        }
        try {
            if (aFa1sSDK.AFInAppEventType().containsKey("appsflyerKey") && aFa1sSDK.afRDLog()) {
                new AFb1ySDK();
                aFa1sSDK.values("af_v", AFb1ySDK.AFKeystoreWrapper(aFa1sSDK.AFInAppEventType()));
                new AFb1ySDK();
                aFa1sSDK.values("af_v2", AFb1ySDK.AFInAppEventParameterName(aFa1sSDK.AFInAppEventType()));
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("QUEUE: failed to update the event, is missing DevKey? Error: ".concat(String.valueOf(th)), th);
        }
        if (aFa1sSDK.afErrorLog()) {
            Map<String, Object> AFInAppEventParameterName = AFInAppEventParameterName(aFa1sSDK);
            AFd1xSDK aFd1xSDK = this.getLevel;
            String AFInAppEventParameterName2 = aFd1xSDK.AFInAppEventParameterName();
            String values = aFd1xSDK.values();
            if (AFd1xSDK.valueOf()) {
                aFd1vSDK = AFd1vSDK.DEFAULT;
            } else {
                aFd1vSDK = AFd1vSDK.API;
            }
            AFd1uSDK aFd1uSDK = new AFd1uSDK(AFInAppEventParameterName2, values, aFd1vSDK);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", (Object) aFd1uSDK.AFInAppEventParameterName);
            if (aFd1uSDK.valueOf != AFd1vSDK.DEFAULT) {
                jSONObject.put("method", (Object) aFd1uSDK.valueOf.valueOf);
            }
            CharSequence charSequence = aFd1uSDK.AFKeystoreWrapper;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                z = false;
            }
            if (!z) {
                jSONObject.put("prefix", (Object) aFd1uSDK.AFKeystoreWrapper);
            }
            AFInAppEventParameterName.put("host", jSONObject);
        }
        if (this.afWarnLog.AFInAppEventType("AF_PREINSTALL_DISABLED")) {
            AFInAppEventParameterName(aFa1sSDK).put("preinstall_disabled", Boolean.TRUE);
        }
    }

    private static Map<String, Object> AFInAppEventParameterName(AFa1sSDK aFa1sSDK) {
        Map<String, Object> map = (Map) aFa1sSDK.AFInAppEventType().get(Mechanism.JsonKeys.META);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        aFa1sSDK.AFInAppEventType().put(Mechanism.JsonKeys.META, hashMap);
        return hashMap;
    }
}
