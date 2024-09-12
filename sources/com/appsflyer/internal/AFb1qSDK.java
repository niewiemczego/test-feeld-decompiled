package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFc1qSDK;
import com.appsflyer.internal.AFf1jSDK;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.sentry.protocol.OperatingSystem;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1qSDK extends AFe1aSDK {
    public static long afErrorLogForExcManagerOnly = 0;
    private static String afWarnLog = "https://%sdlsdk.%s/v1.0/android/";
    private final List<AFf1jSDK> AFVersionDeclaration = new ArrayList();
    private final AFf1kSDK AppsFlyer2dXConversionCallback;
    private final CountDownLatch getLevel = new CountDownLatch(1);
    private final ExecutorService init;
    private final AFe1kSDK onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private int onConversionDataSuccess;
    private boolean onDeepLinkingNative;
    private final AFe1fSDK onInstallConversionDataLoadedNative;
    private final AFb1bSDK onInstallConversionFailureNative;
    private final AFb1sSDK onResponseErrorNative;
    private int onResponseNative;

    public AFb1qSDK(Context context, AFc1vSDK aFc1vSDK) {
        super((String) null, afWarnLog, Boolean.FALSE, Boolean.TRUE, (Boolean) null, context);
        this.onInstallConversionDataLoadedNative = aFc1vSDK.AFLogger();
        this.onInstallConversionFailureNative = aFc1vSDK.AFInAppEventParameterName();
        this.onAppOpenAttributionNative = aFc1vSDK.afWarnLog();
        this.AppsFlyer2dXConversionCallback = aFc1vSDK.getLevel();
        this.init = aFc1vSDK.AFInAppEventType();
        this.onResponseErrorNative = aFc1vSDK.AFVersionDeclaration();
    }

    public final DeepLinkResult afDebugLog() {
        DeepLinkResult.Error error;
        AFLogger.afDebugLog("[DDL] start");
        FutureTask futureTask = new FutureTask(new Callable<DeepLinkResult>() {
            public final /* synthetic */ Object call() throws Exception {
                Application AFKeystoreWrapper = AFb1qSDK.this.AFKeystoreWrapper;
                AFb1qSDK.AFInAppEventType(AFb1qSDK.this);
                AFb1qSDK.this.afErrorLogForExcManagerOnly();
                return AFb1qSDK.valueOf(AFb1qSDK.this, AFKeystoreWrapper);
            }
        });
        this.init.execute(futureTask);
        try {
            DeepLinkResult deepLinkResult = (DeepLinkResult) futureTask.get(afErrorLogForExcManagerOnly, TimeUnit.MILLISECONDS);
            this.onInstallConversionDataLoadedNative.AFInAppEventParameterName(deepLinkResult, afErrorLogForExcManagerOnly);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult);
            return deepLinkResult;
        } catch (InterruptedException | ExecutionException e) {
            AFLogger.afErrorLog("[DDL] Error occurred", e, true);
            if (e.getCause() instanceof IOException) {
                error = DeepLinkResult.Error.NETWORK;
            } else {
                error = DeepLinkResult.Error.UNEXPECTED;
            }
            DeepLinkResult deepLinkResult2 = new DeepLinkResult((DeepLink) null, error);
            this.onInstallConversionDataLoadedNative.AFInAppEventParameterName(deepLinkResult2, afErrorLogForExcManagerOnly);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult2);
            return deepLinkResult2;
        } catch (TimeoutException e2) {
            AFLogger.afErrorLogForExcManagerOnly("[DDL] Timeout", e2);
            AFLogger.afDebugLog(new StringBuilder("[DDL] Timeout, didn't manage to find deferred deep link after ").append(this.onAttributionFailureNative).append(" attempt(s) within ").append(afErrorLogForExcManagerOnly).append(" milliseconds").toString());
            DeepLinkResult deepLinkResult3 = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.TIMEOUT);
            this.onInstallConversionDataLoadedNative.AFInAppEventParameterName(deepLinkResult3, afErrorLogForExcManagerOnly);
            AFb1oSDK.AFInAppEventParameterName(deepLinkResult3);
            return deepLinkResult3;
        }
    }

    private boolean afWarnLog() {
        int i;
        List list = (List) this.valueOf.get("referrers");
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i >= this.onConversionDataSuccess || this.valueOf.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void afErrorLogForExcManagerOnly() {
        String[] strArr;
        boolean z = true;
        this.onAttributionFailureNative++;
        AFLogger.afDebugLog(new StringBuilder("[DDL] Preparing request ").append(this.onAttributionFailureNative).toString());
        if (this.onAttributionFailureNative == 1) {
            AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
            Map<String, Object> map = this.valueOf;
            if (this.onInstallConversionFailureNative.AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0) != 0) {
                z = false;
            }
            map.put("is_first", Boolean.valueOf(z));
            this.valueOf.put(AdaptyPaywallTypeAdapterFactory.LANG, new StringBuilder().append(Locale.getDefault().getLanguage()).append("-").append(Locale.getDefault().getCountry()).toString());
            this.valueOf.put(OperatingSystem.TYPE, Build.VERSION.RELEASE);
            this.valueOf.put("type", Build.MODEL);
            this.valueOf.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(this.onInstallConversionFailureNative.values.AFKeystoreWrapper)));
            AFa1eSDK aFa1eSDK = AFInAppEventType.AFLogger;
            if (!(aFa1eSDK == null || (strArr = aFa1eSDK.AFKeystoreWrapper) == null)) {
                this.valueOf.put("sharing_filter", strArr);
            }
            Map<String, Object> values = values(AFa1bSDK.AFInAppEventType(this.onInstallConversionFailureNative.values.AFKeystoreWrapper, new HashMap()));
            Map<String, Object> values2 = values(AFa1bSDK.AFInAppEventParameterName(this.onInstallConversionFailureNative.values.AFKeystoreWrapper));
            if (values != null) {
                this.valueOf.put("gaid", values);
            }
            if (values2 != null) {
                this.valueOf.put("oaid", values2);
            }
        }
        Map<String, Object> map2 = this.valueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        map2.put("timestamp", simpleDateFormat.format(new Date(currentTimeMillis)));
        this.valueOf.put("request_count", Integer.valueOf(this.onAttributionFailureNative));
        ArrayList arrayList = new ArrayList();
        for (AFf1jSDK AFKeystoreWrapper : this.AFVersionDeclaration) {
            Map<String, String> AFKeystoreWrapper2 = AFKeystoreWrapper(AFKeystoreWrapper);
            if (AFKeystoreWrapper2 != null) {
                arrayList.add(AFKeystoreWrapper2);
            }
        }
        if (!arrayList.isEmpty()) {
            this.valueOf.put("referrers", arrayList);
        }
        AFInAppEventParameterName(onAppOpenAttributionNative());
    }

    private String onAppOpenAttributionNative() {
        String str = this.onAppOpenAttributionNative.AFInAppEventType;
        String packageName = this.onInstallConversionFailureNative.values.AFKeystoreWrapper.getPackageName();
        String values = this.onInstallConversionFailureNative.values();
        return Uri.parse(String.format(afWarnLog, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).buildUpon().appendPath(new StringBuilder().append(packageName).append((values == null || values.trim().isEmpty()) ? "" : "-".concat(String.valueOf(values))).toString()).appendQueryParameter("af_sig", AFb1ySDK.values(new StringBuilder().append(this.valueOf.get("timestamp")).append(str).toString(), str)).appendQueryParameter("sdk_version", AFb1xSDK.AFKeystoreWrapper).build().toString();
    }

    /* renamed from: com.appsflyer.internal.AFb1qSDK$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] values;

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
                values = r0
                com.appsflyer.internal.AFf1jSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1jSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1qSDK.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void AFInAppEventParameterName(AFf1jSDK aFf1jSDK) {
        if (valueOf(aFf1jSDK)) {
            this.AFVersionDeclaration.add(aFf1jSDK);
            this.getLevel.countDown();
            AFLogger.afDebugLog(new StringBuilder("[DDL] Added non-organic ").append(aFf1jSDK.getClass().getSimpleName()).toString());
            return;
        }
        int i = this.onResponseNative + 1;
        this.onResponseNative = i;
        if (i == this.onConversionDataSuccess) {
            this.getLevel.countDown();
        }
    }

    private static boolean valueOf(AFf1jSDK aFf1jSDK) {
        Long l = (Long) aFf1jSDK.AFInAppEventType.get("click_ts");
        if (l != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    public final AFd1sSDK AFKeystoreWrapper() {
        return AFd1sSDK.DLSDK;
    }

    private Map<String, Object> values(final AFc1qSDK.AFa1vSDK aFa1vSDK) {
        Boolean bool;
        boolean z = false;
        if (!(aFa1vSDK == null || aFa1vSDK.AFInAppEventParameterName == null || ((bool = aFa1vSDK.AFInAppEventType) != null && bool.booleanValue()))) {
            z = true;
        }
        if (z) {
            return new HashMap<String, Object>() {
                {
                    put("type", "unhashed");
                    put("value", aFa1vSDK.AFInAppEventParameterName);
                }
            };
        }
        return null;
    }

    private static Map<String, String> AFKeystoreWrapper(AFf1jSDK aFf1jSDK) {
        if (aFf1jSDK.AFKeystoreWrapper != AFf1jSDK.AFa1wSDK.FINISHED) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = (String) aFf1jSDK.AFInAppEventType.get("referrer");
        if (str == null) {
            return null;
        }
        hashMap.put("source", (String) aFf1jSDK.AFInAppEventType.get("source"));
        hashMap.put("value", str);
        return hashMap;
    }

    static /* synthetic */ void AFInAppEventType(AFb1qSDK aFb1qSDK) {
        ArrayList<AFf1jSDK> arrayList = new ArrayList<>();
        for (AFf1jSDK aFf1jSDK : aFb1qSDK.AppsFlyer2dXConversionCallback.AFInAppEventParameterName()) {
            if (!(aFf1jSDK == null || aFf1jSDK.AFKeystoreWrapper == AFf1jSDK.AFa1wSDK.NOT_STARTED)) {
                arrayList.add(aFf1jSDK);
            }
        }
        aFb1qSDK.onConversionDataSuccess = arrayList.size();
        for (final AFf1jSDK aFf1jSDK2 : arrayList) {
            int i = AnonymousClass1.values[aFf1jSDK2.AFKeystoreWrapper.ordinal()];
            if (i == 1) {
                AFLogger.afDebugLog(new StringBuilder("[DDL] ").append(aFf1jSDK2.AFInAppEventType.get("source")).append(" referrer collected earlier").toString());
                aFb1qSDK.AFInAppEventParameterName(aFf1jSDK2);
            } else if (i == 2) {
                aFf1jSDK2.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        AFLogger.afDebugLog(new StringBuilder("[DDL] ").append(aFf1jSDK2.AFInAppEventType.get("source")).append(" referrer collected via observer").toString());
                        AFb1qSDK.this.AFInAppEventParameterName((AFf1jSDK) observable);
                    }
                });
            }
        }
    }

    static /* synthetic */ DeepLinkResult valueOf(AFb1qSDK aFb1qSDK, Context context) throws IOException, JSONException, InterruptedException {
        DeepLink deepLink;
        while (true) {
            AFe1fSDK aFe1fSDK = aFb1qSDK.onInstallConversionDataLoadedNative;
            int i = aFb1qSDK.onAttributionFailureNative;
            if (i <= 0 || i > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - start", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i))));
            } else {
                int i2 = i - 1;
                aFe1fSDK.afRDLog[i2] = System.currentTimeMillis();
                if (i2 == 0) {
                    if (aFe1fSDK.AFLogger != 0) {
                        aFe1fSDK.valueOf.put("from_fg", Long.valueOf(aFe1fSDK.afRDLog[i2] - aFe1fSDK.AFLogger));
                        aFe1fSDK.AFInAppEventParameterName.AFKeystoreWrapper("ddl", new JSONObject((Map<?, ?>) aFe1fSDK.valueOf).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                }
            }
            HttpURLConnection AFInAppEventParameterName = new AFa1rSDK(aFb1qSDK, aFb1qSDK.onResponseErrorNative).AFInAppEventParameterName(aFb1qSDK.onAppOpenAttributionNative.AFInAppEventType);
            AFe1fSDK aFe1fSDK2 = aFb1qSDK.onInstallConversionDataLoadedNative;
            int i3 = aFb1qSDK.onAttributionFailureNative;
            if (i3 <= 0 || i3 > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - end", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i3))));
            } else {
                int i4 = i3 - 1;
                aFe1fSDK2.afInfoLog[i4] = System.currentTimeMillis();
                if (aFe1fSDK2.afRDLog[i4] != 0) {
                    aFe1fSDK2.afDebugLog[i4] = aFe1fSDK2.afInfoLog[i4] - aFe1fSDK2.afRDLog[i4];
                    aFe1fSDK2.valueOf.put("net", aFe1fSDK2.afDebugLog);
                    aFe1fSDK2.AFInAppEventParameterName.AFKeystoreWrapper("ddl", new JSONObject((Map<?, ?>) aFe1fSDK2.valueOf).toString());
                } else {
                    AFLogger.afInfoLog(new StringBuilder("Metrics: ddlStart[").append(i4).append("] ts is missing").toString());
                }
            }
            if (AFInAppEventParameterName.getResponseCode() == 200) {
                JSONObject jSONObject = new JSONObject(AFb1xSDK.valueOf(AFInAppEventParameterName));
                aFb1qSDK.onDeepLinkingNative = jSONObject.optBoolean("is_second_ping", true);
                if (!jSONObject.optBoolean("found")) {
                    deepLink = null;
                } else {
                    deepLink = DeepLink.values(jSONObject.optJSONObject("click_event"));
                    deepLink.AFInAppEventType.put("is_deferred", true);
                }
                if (deepLink != null) {
                    return new DeepLinkResult(deepLink, (DeepLinkResult.Error) null);
                }
                if (aFb1qSDK.onAttributionFailureNative <= 1 && aFb1qSDK.afWarnLog() && aFb1qSDK.onDeepLinkingNative) {
                    AFLogger.afDebugLog("[DDL] Waiting for referrers...");
                    aFb1qSDK.getLevel.await();
                    AFe1fSDK aFe1fSDK3 = aFb1qSDK.onInstallConversionDataLoadedNative;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aFe1fSDK3.afInfoLog[0] != 0) {
                        aFe1fSDK3.valueOf.put("rfr_wait", Long.valueOf(currentTimeMillis - aFe1fSDK3.afInfoLog[0]));
                        aFe1fSDK3.AFInAppEventParameterName.AFKeystoreWrapper("ddl", new JSONObject((Map<?, ?>) aFe1fSDK3.valueOf).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: ddlEnd[0] ts is missing");
                    }
                    if (aFb1qSDK.onResponseNative == aFb1qSDK.onConversionDataSuccess) {
                        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
                    }
                    aFb1qSDK.afErrorLogForExcManagerOnly();
                }
            } else {
                AFLogger.afDebugLog(new StringBuilder("[DDL] Error occurred. Server response code = ").append(AFInAppEventParameterName.getResponseCode()).toString());
                return new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.HTTP_STATUS_CODE);
            }
        }
        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
    }
}
