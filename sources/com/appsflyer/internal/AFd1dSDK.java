package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.iid.InstanceID;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class AFd1dSDK extends AFd1cSDK {
    private final AFc1xSDK AFLogger$LogLevel;
    private final AppsFlyerProperties AppsFlyer2dXConversionCallback = AppsFlyerProperties.getInstance();
    private final AFe1fSDK afErrorLogForExcManagerOnly;
    public Map<String, Object> afWarnLog;
    private final AFf1kSDK getLevel;
    private final AFb1rSDK onAppOpenAttributionNative;

    public AFd1dSDK(AFa1sSDK aFa1sSDK, AFc1vSDK aFc1vSDK) {
        super(aFa1sSDK, aFc1vSDK);
        this.getLevel = aFc1vSDK.getLevel();
        this.AFLogger$LogLevel = aFc1vSDK.afErrorLog();
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFLogger();
        this.onAppOpenAttributionNative = aFc1vSDK.afRDLog();
        this.AFKeystoreWrapper.add(AFd1sSDK.RESOLVE_ESP);
        this.AFKeystoreWrapper.add(AFd1sSDK.DLSDK);
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        AFe1fSDK aFe1fSDK = this.afErrorLogForExcManagerOnly;
        int i = this.afRDLog.afInfoLog;
        long currentTimeMillis = System.currentTimeMillis();
        if (i != 1) {
            return;
        }
        if (aFe1fSDK.afErrorLog != 0) {
            aFe1fSDK.values.put("net", Long.valueOf(currentTimeMillis - aFe1fSDK.afErrorLog));
            aFe1fSDK.AFInAppEventParameterName.AFKeystoreWrapper("first_launch", new JSONObject((Map<?, ?>) aFe1fSDK.values).toString());
            return;
        }
        AFLogger.afInfoLog("Metrics: launch start ts is missing");
    }

    /* access modifiers changed from: protected */
    public final void valueOf(AFa1sSDK aFa1sSDK) {
        super.valueOf(aFa1sSDK);
        int i = aFa1sSDK.afInfoLog;
        this.afErrorLogForExcManagerOnly.AFInAppEventParameterName(i);
        Map map = (Map) aFa1sSDK.AFInAppEventType().get(Mechanism.JsonKeys.META);
        if (map == null) {
            map = new HashMap();
            aFa1sSDK.AFInAppEventType().put(Mechanism.JsonKeys.META, map);
        }
        AFb1fSDK values = this.onAppOpenAttributionNative.values();
        if (values != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", values.valueOf);
            if (values.AFInAppEventType != null) {
                hashMap.put("c_ver", values.AFInAppEventType);
            }
            if (values.AFKeystoreWrapper > 0) {
                hashMap.put("latency", Long.valueOf(values.AFKeystoreWrapper));
            }
            if (values.AFInAppEventParameterName > 0) {
                hashMap.put("delay", Long.valueOf(values.AFInAppEventParameterName));
            }
            if (values.afInfoLog > 0) {
                hashMap.put("res_code", Integer.valueOf(values.afInfoLog));
            }
            if (values.AFLogger != null) {
                hashMap.put("error", new StringBuilder().append(values.AFLogger.getClass().getSimpleName()).append(": ").append(values.AFLogger.getMessage()).toString());
            }
            if (values.afDebugLog != null) {
                hashMap.put("sig", values.afDebugLog.toString());
            }
            if (values.afErrorLog != null) {
                hashMap.put("cdn_cache_status", values.afErrorLog);
            }
            map.put("rc", hashMap);
        }
        if (i == 1) {
            if (this.AppsFlyer2dXConversionCallback.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFa1sSDK.AFInAppEventType().put("wait_cid", Boolean.toString(true));
            }
            HashMap hashMap2 = new HashMap(this.afErrorLogForExcManagerOnly.valueOf);
            this.afErrorLogForExcManagerOnly.AFInAppEventParameterName.valueOf("ddl");
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.afErrorLogForExcManagerOnly.values);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
        } else if (i == 2) {
            HashMap hashMap4 = new HashMap(this.afErrorLogForExcManagerOnly.values);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            this.afErrorLogForExcManagerOnly.AFInAppEventParameterName.valueOf("first_launch");
        }
        if (map.isEmpty()) {
            aFa1sSDK.AFInAppEventType().remove(Mechanism.JsonKeys.META);
        }
        if (i <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFf1jSDK aFf1jSDK : this.getLevel.AFInAppEventParameterName()) {
                boolean z = aFf1jSDK instanceof AFf1mSDK;
                int i2 = AnonymousClass3.AFInAppEventParameterName[aFf1jSDK.AFKeystoreWrapper.ordinal()];
                if (i2 == 1) {
                    if (z) {
                        aFa1sSDK.values("rfr", ((AFf1mSDK) aFf1jSDK).AFInAppEventParameterName);
                        this.AFLogger$LogLevel.AFInAppEventType(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFf1jSDK.AFInAppEventType);
                } else if (i2 == 2 && i == 2 && !z) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFf1jSDK.valueOf);
                    hashMap5.put(Response.TYPE, InstanceID.ERROR_TIMEOUT);
                    hashMap5.put("type", aFf1jSDK.afInfoLog);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFa1sSDK.values("referrers", arrayList);
            }
            Map<String, Object> map2 = this.afWarnLog;
            if (map2 != null) {
                aFa1sSDK.values("fb_ddl", map2);
            }
        }
    }

    /* renamed from: com.appsflyer.internal.AFd1dSDK$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] AFInAppEventParameterName;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.internal.AFf1jSDK$AFa1wSDK[] r0 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                AFInAppEventParameterName = r0
                com.appsflyer.internal.AFf1jSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFInAppEventParameterName     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1jSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1dSDK.AnonymousClass3.<clinit>():void");
        }
    }
}
