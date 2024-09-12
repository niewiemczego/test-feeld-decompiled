package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class AFa1fSDK implements Runnable {
    private static String AFInAppEventParameterName = new StringBuilder("https://%svalidate.%s/api/v").append(AFb1xSDK.AFKeystoreWrapper).append("/androidevent?buildnumber=6.10.3&app_id=").toString();
    private static String AFInAppEventType = "https://%ssdk-services.%s/validate-android-signature";
    private String AFKeystoreWrapper;
    /* access modifiers changed from: private */
    public String AFLogger;
    private String afDebugLog;
    /* access modifiers changed from: private */
    public String afErrorLog;
    private String afInfoLog;
    /* access modifiers changed from: private */
    public String afRDLog;
    private Map<String, String> afWarnLog;
    private WeakReference<Context> valueOf;
    private final Intent values;

    AFa1fSDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.valueOf = new WeakReference<>(context);
        this.AFKeystoreWrapper = str;
        this.afInfoLog = str2;
        this.afRDLog = str4;
        this.afErrorLog = str5;
        this.AFLogger = str6;
        this.afWarnLog = map;
        this.afDebugLog = str3;
        this.values = intent;
    }

    public final void run() {
        String str = this.AFKeystoreWrapper;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            try {
                Context context = this.valueOf.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.afInfoLog);
                    hashMap.put("sig-data", this.afRDLog);
                    hashMap.put("signature", this.afDebugLog);
                    HashMap hashMap2 = new HashMap(hashMap);
                    Map<String, String> map = this.afWarnLog;
                    String obj = new StringBuilder().append(String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(context.getPackageName()).toString();
                    String string = AFb1xSDK.valueOf(context).getString("referrer", "");
                    AFf1sSDK aFf1sSDK = new AFf1sSDK(context);
                    aFf1sSDK.afRDLog = string;
                    AFf1sSDK aFf1sSDK2 = aFf1sSDK;
                    AFb1xSDK AFInAppEventType2 = AFb1xSDK.AFInAppEventType();
                    Map<String, Object> AFInAppEventType3 = AFInAppEventType2.AFInAppEventType((AFa1sSDK) aFf1sSDK);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.PRICE, this.afErrorLog);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.CURRENCY, this.AFLogger);
                    AFInAppEventType3.put("receipt_data", hashMap2);
                    if (map != null) {
                        AFInAppEventType3.put("extra_prms", map);
                    }
                    AFInAppEventType3.putAll(AFInAppEventType2.AFKeystoreWrapper().afWarnLog().AFInAppEventParameterName());
                    values(context, (AFf1sSDK) aFf1sSDK.AFInAppEventParameterName((Map<String, ?>) AFInAppEventType3).AFInAppEventParameterName(obj));
                    hashMap.put("dev_key", this.AFKeystoreWrapper);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
                    if (string2 != null) {
                        hashMap.put("advertiserId", string2);
                    }
                    AFf1zSDK aFf1zSDK = (AFf1zSDK) new AFf1zSDK().AFInAppEventParameterName((Map<String, ?>) hashMap).AFInAppEventParameterName(String.format(AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
                    final AFd1cSDK values2 = values(context, aFf1zSDK);
                    aFf1zSDK.AFInAppEventType = new AppsFlyerRequestListener() {
                        public final void onSuccess() {
                            try {
                                JSONObject jSONObject = new JSONObject((String) values2.afInfoLog.getBody());
                                AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                                AFa1fSDK.AFInAppEventParameterName(jSONObject.optBoolean("result"), AFa1fSDK.this.afRDLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.AFLogger, jSONObject.toString());
                            } catch (Exception e) {
                                AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e)), e);
                                AFa1fSDK.AFInAppEventParameterName(false, AFa1fSDK.this.afRDLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.AFLogger, e.getMessage());
                            }
                        }

                        public final void onError(int i, String str) {
                            AFc1aSDK<Result> aFc1aSDK;
                            if (i == RequestError.RESPONSE_CODE_FAILURE && (aFc1aSDK = values2.afInfoLog) != null) {
                                str = aFc1aSDK.toString();
                            }
                            AFa1fSDK.AFInAppEventParameterName(false, AFa1fSDK.this.afRDLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.AFLogger, str);
                        }
                    };
                }
            } catch (Throwable th) {
                if (AFb1xSDK.AFInAppEventType != null) {
                    AFLogger.afErrorLog("Failed Validate request + ex", th);
                    AFInAppEventParameterName(false, this.afRDLog, this.afErrorLog, this.AFLogger, th.getMessage());
                }
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
    }

    private static AFd1cSDK values(Context context, AFf1ySDK aFf1ySDK) {
        AFb1xSDK.AFInAppEventType().AFInAppEventType(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        aFf1ySDK.AFKeystoreWrapper(AFKeystoreWrapper2.AFInAppEventParameterName().AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0));
        AFd1cSDK aFd1cSDK = new AFd1cSDK(aFf1ySDK, AFKeystoreWrapper2);
        AFd1pSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
        afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1cSDK) {
            private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

            {
                this.AFInAppEventParameterName = r2;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r0 = r0.afDebugLog
                    monitor-enter(r0)
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.Set<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                    if (r1 == 0) goto L_0x0027
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                    java.lang.String r2 = "QUEUE: tried to add already running task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                    return
                L_0x0027:
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                    if (r1 != 0) goto L_0x0181
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                    if (r1 == 0) goto L_0x0041
                    goto L_0x0181
                L_0x0041:
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    java.util.Set<com.appsflyer.internal.AFd1sSDK> r3 = r2.AFKeystoreWrapper     // Catch:{ all -> 0x0197 }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0197 }
                L_0x004b:
                    boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0197 }
                    if (r4 == 0) goto L_0x0065
                    java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1sSDK r4 = (com.appsflyer.internal.AFd1sSDK) r4     // Catch:{ all -> 0x0197 }
                    java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0197 }
                    if (r5 == 0) goto L_0x004b
                    java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r2.valueOf     // Catch:{ all -> 0x0197 }
                    r5.add(r4)     // Catch:{ all -> 0x0197 }
                    goto L_0x004b
                L_0x0065:
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.AFInAppEventType((com.appsflyer.internal.AFd1qSDK<?>) r2)     // Catch:{ all -> 0x0197 }
                    if (r1 == 0) goto L_0x007a
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                    goto L_0x009f
                L_0x007a:
                    com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                    if (r1 == 0) goto L_0x009f
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                    java.lang.String r3 = "QUEUE: new task was blocked: "
                    r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    r2.valueOf()     // Catch:{ all -> 0x0197 }
                L_0x009f:
                    if (r1 == 0) goto L_0x00b4
                    com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1pSDK r3 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r3 = r3.afInfoLog     // Catch:{ all -> 0x0197 }
                    r2.addAll(r3)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                    java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afInfoLog     // Catch:{ all -> 0x0197 }
                    r2.clear()     // Catch:{ all -> 0x0197 }
                    goto L_0x00c8
                L_0x00b4:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                    java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                    r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                L_0x00c8:
                    monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                    if (r1 == 0) goto L_0x016c
                    com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                    java.util.Set<com.appsflyer.internal.AFd1sSDK> r0 = r0.AFInAppEventParameterName
                    com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                    com.appsflyer.internal.AFd1sSDK r1 = r1.values
                    r0.add(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: new task added: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afDebugLog(r0)
                    com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                    java.util.List<com.appsflyer.internal.AFd1wSDK> r0 = r0.valueOf
                    java.util.Iterator r0 = r0.iterator()
                L_0x00f2:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x00ff
                    java.lang.Object r1 = r0.next()
                    com.appsflyer.internal.AFd1wSDK r1 = (com.appsflyer.internal.AFd1wSDK) r1
                    goto L_0x00f2
                L_0x00ff:
                    com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                    java.util.concurrent.ExecutorService r1 = r0.AFInAppEventType
                    r1.submit(r0)
                    com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r0.afDebugLog
                    monitor-enter(r1)
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                    int r2 = r2.size()     // Catch:{ all -> 0x0169 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                    int r3 = r3.size()     // Catch:{ all -> 0x0169 }
                    int r2 = r2 + r3
                    int r2 = r2 + -40
                L_0x011a:
                    if (r2 <= 0) goto L_0x0167
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0169 }
                    r4 = 1
                    if (r3 != 0) goto L_0x0127
                    r3 = r4
                    goto L_0x0128
                L_0x0127:
                    r3 = 0
                L_0x0128:
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r5 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                    boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0169 }
                    r4 = r4 ^ r5
                    if (r4 == 0) goto L_0x0155
                    if (r3 == 0) goto L_0x0155
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                    java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0169 }
                    com.appsflyer.internal.AFd1qSDK r3 = (com.appsflyer.internal.AFd1qSDK) r3     // Catch:{ all -> 0x0169 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r4 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                    java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0169 }
                    com.appsflyer.internal.AFd1qSDK r4 = (com.appsflyer.internal.AFd1qSDK) r4     // Catch:{ all -> 0x0169 }
                    int r3 = r3.AFInAppEventType(r4)     // Catch:{ all -> 0x0169 }
                    if (r3 <= 0) goto L_0x014f
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                    r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                    goto L_0x0164
                L_0x014f:
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                    r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                    goto L_0x0164
                L_0x0155:
                    if (r4 == 0) goto L_0x015d
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                    r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                    goto L_0x0164
                L_0x015d:
                    if (r3 == 0) goto L_0x0164
                    java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                    r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                L_0x0164:
                    int r2 = r2 + -1
                    goto L_0x011a
                L_0x0167:
                    monitor-exit(r1)     // Catch:{ all -> 0x0169 }
                    return
                L_0x0169:
                    r0 = move-exception
                    monitor-exit(r1)
                    throw r0
                L_0x016c:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: tried to add already pending task: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afWarnLog(r0)
                    return
                L_0x0181:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                    java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                    com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                    java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                    return
                L_0x0197:
                    r1 = move-exception
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1pSDK.AnonymousClass5.run():void");
            }
        });
        return aFd1cSDK;
    }

    /* access modifiers changed from: private */
    public static void AFInAppEventParameterName(boolean z, String str, String str2, String str3, String str4) {
        if (AFb1xSDK.AFInAppEventType != null) {
            AFLogger.afDebugLog(new StringBuilder("Validate callback parameters: ").append(str).append(" ").append(str2).append(" ").append(str3).toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFb1xSDK.AFInAppEventType.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFb1xSDK.AFInAppEventType;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
