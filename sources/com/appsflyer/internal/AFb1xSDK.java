package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.amplitude.reactnative.AndroidContextProvider;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1hSDK;
import com.appsflyer.internal.AFa1rSDK;
import com.appsflyer.internal.AFb1gSDK;
import com.appsflyer.internal.AFc1qSDK;
import com.appsflyer.internal.AFc1zSDK;
import com.appsflyer.internal.AFe1zSDK;
import com.appsflyer.internal.AFf1jSDK;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.squareup.moshi.Json;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1xSDK extends AppsFlyerLib {
    static final String AFInAppEventParameterName = "235";
    static AppsFlyerInAppPurchaseValidatorListener AFInAppEventType = null;
    public static final String AFKeystoreWrapper;
    private static AFb1xSDK afDebugLog = new AFb1xSDK();
    private static String afErrorLog = "https://%sstats.%s/stats";
    private static int onAppOpenAttribution = 0;
    private static int onAttributionFailure = 1;
    private static int onResponse;
    public static volatile AppsFlyerConversionListener valueOf;
    public static final String values;
    public AFa1eSDK AFLogger;
    private long AFLogger$LogLevel = -1;
    private boolean AFVersionDeclaration = false;
    private boolean AppsFlyer2dXConversionCallback;
    private String afErrorLogForExcManagerOnly;
    String afInfoLog;
    private long afRDLog = -1;
    private long afWarnLog = TimeUnit.SECONDS.toMillis(5);
    private Map<Long, String> getLevel;
    private Application init;
    private boolean onAppOpenAttributionNative = false;
    private Map<String, Object> onAttributionFailureNative;
    private final AFc1uSDK onConversionDataFail;
    private AFb1eSDK onConversionDataSuccess;
    private final Executor onDeepLinking = Executors.newSingleThreadExecutor();
    private boolean onDeepLinkingNative = false;
    private boolean onInstallConversionDataLoadedNative;
    private final AFb1uSDK onInstallConversionFailureNative = new AFb1uSDK();
    private SharedPreferences onResponseErrorNative;
    private String onResponseNative;

    static void AFInAppEventParameterName() {
        onAppOpenAttribution = 183;
    }

    static /* synthetic */ void AFInAppEventParameterName(AFb1xSDK aFb1xSDK) {
        int i = onResponse + 31;
        onAttributionFailure = i % 128;
        boolean z = i % 2 == 0;
        aFb1xSDK.afDebugLog();
        if (!z) {
            int i2 = onResponse + 21;
            onAttributionFailure = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    static /* synthetic */ AFc1uSDK AFKeystoreWrapper(AFb1xSDK aFb1xSDK) {
        int i = onResponse;
        int i2 = i + 21;
        onAttributionFailure = i2 % 128;
        char c = i2 % 2 == 0 ? '2' : 19;
        AFc1uSDK aFc1uSDK = aFb1xSDK.onConversionDataFail;
        if (c == 19) {
            int i3 = i + 109;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
            return aFc1uSDK;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    static /* synthetic */ void AFKeystoreWrapper(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK) {
        int i = onAttributionFailure + 75;
        onResponse = i % 128;
        boolean z = i % 2 == 0;
        aFb1xSDK.AFInAppEventParameterName(aFa1sSDK);
        if (!z) {
            int i2 = 44 / 0;
        }
        int i3 = onAttributionFailure + 111;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? 'F' : '\"') != '\"') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    static /* synthetic */ boolean AFKeystoreWrapper(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, SharedPreferences sharedPreferences) {
        int i = onResponse + 37;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean AFInAppEventParameterName2 = aFb1xSDK.AFInAppEventParameterName(aFa1sSDK, sharedPreferences);
        int i3 = onResponse + 107;
        onAttributionFailure = i3 % 128;
        if (i3 % 2 != 0) {
            return AFInAppEventParameterName2;
        }
        int i4 = 62 / 0;
        return AFInAppEventParameterName2;
    }

    static /* synthetic */ Application valueOf(AFb1xSDK aFb1xSDK) {
        int i = onResponse + 29;
        int i2 = i % 128;
        onAttributionFailure = i2;
        char c = '%';
        char c2 = i % 2 == 0 ? '%' : IOUtils.DIR_SEPARATOR_UNIX;
        Application application = aFb1xSDK.init;
        if (c2 != '%') {
            int i3 = i2 + 61;
            onResponse = i3 % 128;
            if (i3 % 2 != 0) {
                c = 25;
            }
            if (c != 25) {
                return application;
            }
            throw null;
        }
        throw null;
    }

    static /* synthetic */ void valueOf(ScheduledExecutorService scheduledExecutorService, Runnable runnable, TimeUnit timeUnit) {
        int i = onAttributionFailure + 25;
        onResponse = i % 128;
        if (i % 2 != 0) {
        }
        AFInAppEventParameterName(scheduledExecutorService, runnable, 0, timeUnit);
        int i2 = onAttributionFailure + 71;
        onResponse = i2 % 128;
        if ((i2 % 2 != 0 ? '@' : '`') == '@') {
            int i3 = 76 / 0;
        }
    }

    static /* synthetic */ long values(AFb1xSDK aFb1xSDK, long j) {
        int i = onAttributionFailure;
        int i2 = i + 83;
        onResponse = i2 % 128;
        int i3 = i2 % 2;
        aFb1xSDK.AFLogger$LogLevel = j;
        int i4 = i + 79;
        onResponse = i4 % 128;
        int i5 = i4 % 2;
        return j;
    }

    static /* synthetic */ Map values(AFb1xSDK aFb1xSDK) {
        int i = onAttributionFailure + 11;
        int i2 = i % 128;
        onResponse = i2;
        int i3 = i % 2;
        Map<String, Object> map = aFb1xSDK.onAttributionFailureNative;
        int i4 = i2 + 71;
        onAttributionFailure = i4 % 128;
        int i5 = i4 % 2;
        return map;
    }

    static /* synthetic */ boolean values(AFb1xSDK aFb1xSDK, boolean z) {
        int i = onResponse + 121;
        int i2 = i % 128;
        onAttributionFailure = i2;
        int i3 = i % 2;
        aFb1xSDK.onAppOpenAttributionNative = z;
        int i4 = i2 + 89;
        onResponse = i4 % 128;
        if (i4 % 2 == 0) {
            return z;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [java.lang.Throwable, com.appsflyer.AppsFlyerInAppPurchaseValidatorListener, com.appsflyer.AppsFlyerConversionListener, java.lang.Object] */
    static {
        AFInAppEventParameterName();
        boolean z = true;
        Object[] objArr = new Object[1];
        AFKeystoreWrapper(1 - (Process.myTid() >> 22), Json.UNSET_NAME, TextUtils.lastIndexOf("", '0') + 230, 1 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), false, objArr);
        String substring = "6.10.3".substring(0, "6.10.3".lastIndexOf(((String) objArr[0]).intern()));
        AFKeystoreWrapper = substring;
        values = new StringBuilder().append(substring).append("/androidevent?buildnumber=6.10.3&app_id=").toString();
        ? r2 = 0;
        AFInAppEventType = r2;
        valueOf = r2;
        int i = onAttributionFailure + 71;
        onResponse = i % 128;
        if (i % 2 == 0) {
            z = false;
        }
        if (z) {
            super.hashCode();
            throw r2;
        }
    }

    public final AFc1vSDK AFKeystoreWrapper() {
        int i = onResponse;
        int i2 = i + 119;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        AFc1uSDK aFc1uSDK = this.onConversionDataFail;
        int i4 = i + 27;
        onAttributionFailure = i4 % 128;
        int i5 = i4 % 2;
        return aFc1uSDK;
    }

    public final void AFInAppEventType(Context context) {
        AFc1uSDK aFc1uSDK = this.onConversionDataFail;
        if (context != null) {
            int i = onAttributionFailure + 75;
            onResponse = i % 128;
            int i2 = i % 2;
            AFc1wSDK aFc1wSDK = aFc1uSDK.AFKeystoreWrapper;
            if ((context != null ? '9' : 'G') == '9') {
                int i3 = onResponse + 55;
                onAttributionFailure = i3 % 128;
                int i4 = i3 % 2;
                aFc1wSDK.AFKeystoreWrapper = context.getApplicationContext();
            }
        }
    }

    public AFb1xSDK() {
        AFVersionDeclaration.init();
        this.onConversionDataFail = new AFc1uSDK();
        AFd1pSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
        afDebugLog2.valueOf.add(new AFa1zSDK(this, (byte) 0));
    }

    public static AFb1xSDK AFInAppEventType() {
        int i = onResponse;
        int i2 = i + 89;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        AFb1xSDK aFb1xSDK = afDebugLog;
        int i4 = i + 81;
        onAttributionFailure = i4 % 128;
        if (!(i4 % 2 == 0)) {
            return aFb1xSDK;
        }
        int i5 = 35 / 0;
        return aFb1xSDK;
    }

    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        if (!(uri == null)) {
            int i = onResponse + 113;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            if (!uri.toString().isEmpty()) {
                if (context == null) {
                    AFb1oSDK.values(new StringBuilder("Context is \"").append(context).append("\"").toString(), DeepLinkResult.Error.NETWORK);
                    return;
                }
                AFKeystoreWrapper().onAppOpenAttributionNative();
                AFa1tSDK.AFKeystoreWrapper(context, new HashMap(), Uri.parse(uri.toString()));
                int i3 = onResponse + 39;
                onAttributionFailure = i3 % 128;
                if ((i3 % 2 == 0 ? '?' : 6) == '?') {
                    Throwable th = null;
                    super.hashCode();
                    throw th;
                }
                return;
            }
        }
        AFb1oSDK.values(new StringBuilder("Link is \"").append(uri).append("\"").toString(), DeepLinkResult.Error.NETWORK);
    }

    @Deprecated
    public final void setSharingFilter(String... strArr) {
        int i = onAttributionFailure + 107;
        onResponse = i % 128;
        int i2 = i % 2;
        setSharingFilterForPartners(strArr);
        int i3 = onResponse + 77;
        onAttributionFailure = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 13 / 0;
        }
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i = onAttributionFailure + 21;
        onResponse = i % 128;
        int i2 = i % 2;
        setSharingFilterForPartners("all");
        int i3 = onResponse + 119;
        onAttributionFailure = i3 % 128;
        if (i3 % 2 == 0) {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    public final void setSharingFilterForPartners(String... strArr) {
        this.AFLogger = new AFa1eSDK(strArr);
        int i = onResponse + 71;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        int i = onResponse + 85;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? 21 : '0') == '0') {
            AFa1tSDK onAppOpenAttributionNative2 = AFKeystoreWrapper().onAppOpenAttributionNative();
            onAppOpenAttributionNative2.AFInAppEventParameterName = str;
            onAppOpenAttributionNative2.valueOf = map;
            int i2 = onResponse + 59;
            onAttributionFailure = i2 % 128;
            if ((i2 % 2 == 0 ? 18 : '_') == 18) {
                throw null;
            }
            return;
        }
        AFa1tSDK onAppOpenAttributionNative3 = AFKeystoreWrapper().onAppOpenAttributionNative();
        onAppOpenAttributionNative3.AFInAppEventParameterName = str;
        onAppOpenAttributionNative3.valueOf = map;
        throw null;
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        int i = onAttributionFailure + 89;
        onResponse = i % 128;
        if ((i % 2 != 0 ? '8' : 24) == 24) {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
            int i2 = onAttributionFailure + 53;
            onResponse = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j) {
        int i = onResponse + 55;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().onAppOpenAttributionNative().values = deepLinkListener;
        AFb1qSDK.afErrorLogForExcManagerOnly = j;
        int i3 = onAttributionFailure + 41;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void performOnDeepLinking(Intent intent, Context context) {
        int i = onAttributionFailure + 105;
        int i2 = i % 128;
        onResponse = i2;
        int i3 = i % 2;
        if (intent == null) {
            int i4 = i2 + 65;
            onAttributionFailure = i4 % 128;
            int i5 = i4 % 2;
            AFb1oSDK.values("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
            int i6 = onAttributionFailure + 99;
            onResponse = i6 % 128;
            if ((i6 % 2 != 0 ? '4' : 7) != 7) {
                Throwable th = null;
                super.hashCode();
                throw th;
            }
            return;
        }
        if ((context == null ? ' ' : '6') != ' ') {
            Context applicationContext = context.getApplicationContext();
            AFInAppEventType(applicationContext);
            AFKeystoreWrapper().AFInAppEventType().execute(new AFb1xSDK$$ExternalSyntheticLambda0(this, applicationContext, intent));
            return;
        }
        AFb1oSDK.values("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        List list;
        List<List<String>> list2;
        int i = onAttributionFailure + 7;
        onResponse = i % 128;
        if (i % 2 != 0) {
            list = Arrays.asList(strArr);
            list2 = AFKeystoreWrapper().onAppOpenAttributionNative().afRDLog;
            int i2 = 11 / 0;
            if ((!list2.contains(list) ? '?' : 8) != '?') {
                return;
            }
        } else {
            list = Arrays.asList(strArr);
            list2 = AFKeystoreWrapper().onAppOpenAttributionNative().afRDLog;
            if ((!list2.contains(list) ? ']' : '@') != ']') {
                return;
            }
        }
        list2.add(list);
        int i3 = onResponse + 101;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setPartnerData(String str, Map<String, Object> map) {
        String str2;
        if (this.onConversionDataSuccess == null) {
            this.onConversionDataSuccess = new AFb1eSDK();
        }
        AFb1eSDK aFb1eSDK = this.onConversionDataSuccess;
        if ((str != null ? ':' : 24) != 24) {
            int i = onAttributionFailure + 53;
            onResponse = i % 128;
            int i2 = i % 2;
            if (!str.isEmpty()) {
                if ((map != null ? '>' : '@') == '>') {
                    if (!(map.isEmpty())) {
                        AFLogger.afDebugLog(new StringBuilder("Setting partner data for ").append(str).append(": ").append(map).toString());
                        int length = new JSONObject((Map<?, ?>) map).toString().length();
                        if (length > 1000) {
                            AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                            HashMap hashMap = new HashMap();
                            hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                            aFb1eSDK.AFInAppEventType.put(str, hashMap);
                            int i3 = onResponse + 33;
                            onAttributionFailure = i3 % 128;
                            int i4 = i3 % 2;
                            return;
                        }
                        aFb1eSDK.AFKeystoreWrapper.put(str, map);
                        aFb1eSDK.AFInAppEventType.remove(str);
                        return;
                    }
                }
                if (aFb1eSDK.AFKeystoreWrapper.remove(str) == null) {
                    str2 = "Partner data is missing or `null`";
                } else {
                    str2 = "Cleared partner data for ".concat(String.valueOf(str));
                }
                AFLogger.afWarnLog(str2);
                return;
            }
        }
        AFLogger.afWarnLog("Partner ID is missing or `null`");
    }

    public final void setDisableAdvertisingIdentifiers(boolean z) {
        int i = onAttributionFailure + 49;
        onResponse = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z)));
        boolean z2 = false;
        if ((!z ? '9' : 21) == '9') {
            int i3 = onAttributionFailure + 119;
            int i4 = i3 % 128;
            onResponse = i4;
            if (i3 % 2 != 0 ? false : true) {
                z2 = true;
            }
            int i5 = i4 + 5;
            onAttributionFailure = i5 % 128;
            int i6 = i5 % 2;
        }
        AFa1bSDK.AFInAppEventType = Boolean.valueOf(z2);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
        int i7 = onResponse + 35;
        onAttributionFailure = i7 % 128;
        if ((i7 % 2 == 0 ? '9' : 'L') == '9') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    public final void setDisableNetworkData(boolean z) {
        int i = onResponse + 17;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? 'R' : 30) == 30) {
            AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z)));
            AFInAppEventParameterName(AppsFlyerProperties.DISABLE_NETWORK_DATA, z);
            int i2 = onAttributionFailure + 11;
            onResponse = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z)));
        AFInAppEventParameterName(AppsFlyerProperties.DISABLE_NETWORK_DATA, z);
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final void AFKeystoreWrapper(Context context, Intent intent) {
        int i = onAttributionFailure + 69;
        onResponse = i % 128;
        int i2 = i % 2;
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            int i3 = onAttributionFailure + 117;
            onResponse = i3 % 128;
            if ((i3 % 2 != 0 ? 15 : ' ') != 15) {
                values(intent.getStringExtra("appsflyer_preinstall"));
            } else {
                values(intent.getStringExtra("appsflyer_preinstall"));
                Throwable th = null;
                super.hashCode();
                throw th;
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra = intent.getStringExtra("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra)));
        if (stringExtra != null) {
            values(context).AFKeystoreWrapper("referrer", stringExtra);
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            instance.set("AF_REFERRER", stringExtra);
            instance.valueOf = stringExtra;
            if (AppsFlyerProperties.getInstance().AFKeystoreWrapper()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                values(context, AFe1iSDK.onReceive);
                valueOf(context, stringExtra);
            }
        }
    }

    private static void values(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                    i++;
                    int i2 = onResponse + 73;
                    onAttributionFailure = i2 % 128;
                    int i3 = i2 % 2;
                }
                int i4 = onResponse + 119;
                onAttributionFailure = i4 % 128;
                int i5 = i4 % 2;
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext()) {
                int i6 = onResponse + 81;
                onAttributionFailure = i6 % 128;
                int i7 = i6 % 2;
                if (str != null) {
                    break loop2;
                }
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i8 = 0;
                    while (true) {
                        if (i8 < jSONArray2.length() ? true : true) {
                            int i9 = onResponse + 17;
                            onAttributionFailure = i9 % 128;
                            int i10 = i9 % 2;
                            if (jSONArray2.getLong(i8) != ((Long) arrayList.get(0)).longValue()) {
                                if ((jSONArray2.getLong(i8) != ((Long) arrayList.get(1)).longValue() ? '@' : 31) == 31) {
                                    break;
                                }
                                int i11 = onAttributionFailure + 75;
                                onResponse = i11 % 128;
                                int i12 = i11 % 2;
                                if (jSONArray2.getLong(i8) == ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                    break;
                                }
                                i8++;
                                str = next;
                            } else {
                                break;
                            }
                        } else {
                            continue;
                            break;
                        }
                    }
                } catch (JSONException e2) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e2);
                }
            }
            break loop2;
        }
        if (str != null) {
            int i13 = onResponse + 113;
            onAttributionFailure = i13 % 128;
            int i14 = i13 % 2;
            jSONObject.remove(str);
        }
    }

    public final void AFInAppEventType(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        int i = onAttributionFailure + 91;
        onResponse = i % 128;
        if (i % 2 == 0) {
            AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String string = valueOf(context).getString("extraReferrers", (String) null);
                if (string == null) {
                    jSONObject = new JSONObject();
                    jSONArray = new JSONArray();
                    int i2 = onResponse + 51;
                    onAttributionFailure = i2 % 128;
                    int i3 = i2 % 2;
                } else {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2.has(str)) {
                        jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                    } else {
                        jSONArray2 = new JSONArray();
                    }
                    JSONObject jSONObject3 = jSONObject2;
                    jSONArray = jSONArray2;
                    jSONObject = jSONObject3;
                }
                if (!(((long) jSONArray.length()) >= 5)) {
                    int i4 = onResponse + 3;
                    onAttributionFailure = i4 % 128;
                    int i5 = i4 % 2;
                    jSONArray.put(currentTimeMillis);
                }
                if ((((long) jSONObject.length()) >= 4 ? '6' : Typography.greater) == '6') {
                    values(jSONObject);
                }
                jSONObject.put(str, (Object) jSONArray.toString());
                values(context).AFKeystoreWrapper("extraReferrers", jSONObject.toString());
                int i6 = onResponse + 37;
                onAttributionFailure = i6 % 128;
                int i7 = i6 % 2;
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e);
            } catch (Throwable th) {
                AFLogger.afErrorLog(new StringBuilder("Couldn't save referrer - ").append(str).append(": ").toString(), th);
            }
        } else {
            AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
            System.currentTimeMillis();
            valueOf(context).getString("extraReferrers", (String) null);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r1 != true) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (r1 != true) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stop(boolean r4, android.content.Context r5) {
        /*
            r3 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 89
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0032
            r3.AFInAppEventType((android.content.Context) r5)
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1kSDK r0 = r0.afWarnLog()
            r0.AFKeystoreWrapper = r4
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1zSDK r0 = r0.AFLogger$LogLevel()
            r0.values()
            r0 = 48
            int r0 = r0 / r1
            if (r4 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            if (r1 == r2) goto L_0x0059
            goto L_0x0050
        L_0x0030:
            r4 = move-exception
            throw r4
        L_0x0032:
            r3.AFInAppEventType((android.content.Context) r5)
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1kSDK r0 = r0.afWarnLog()
            r0.AFKeystoreWrapper = r4
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1zSDK r0 = r0.AFLogger$LogLevel()
            r0.values()
            if (r4 == 0) goto L_0x004d
            r1 = r2
        L_0x004d:
            if (r1 == r2) goto L_0x0050
            goto L_0x0059
        L_0x0050:
            com.appsflyer.internal.AFc1xSDK r4 = r3.values((android.content.Context) r5)
            java.lang.String r5 = "is_stop_tracking_used"
            r4.AFInAppEventType((java.lang.String) r5, (boolean) r2)
        L_0x0059:
            int r4 = onAttributionFailure
            int r4 = r4 + 93
            int r5 = r4 % 128
            onResponse = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0066
            return
        L_0x0066:
            r4 = 0
            throw r4     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.stop(boolean, android.content.Context):void");
    }

    public final String getSdkVersion() {
        int i = onAttributionFailure + 35;
        onResponse = i % 128;
        int i2 = i % 2;
        AFc1vSDK AFKeystoreWrapper2 = AFKeystoreWrapper();
        AFKeystoreWrapper2.AFVersionDeclaration().values("getSdkVersion", new String[0]);
        AFKeystoreWrapper2.AFInAppEventParameterName();
        String AFKeystoreWrapper3 = AFb1bSDK.AFKeystoreWrapper();
        int i3 = onResponse + 29;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 3 : 'X') != 3) {
            return AFKeystoreWrapper3;
        }
        throw null;
    }

    public final void onPause(Context context) {
        int i = onAttributionFailure + 55;
        onResponse = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().onResponseNative().AFKeystoreWrapper(context);
        int i3 = onResponse + 29;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 'a' : 'Z') != 'Z') {
            throw null;
        }
    }

    public final void updateServerUninstallToken(Context context, String str) {
        AFInAppEventType(context);
        AFe1mSDK aFe1mSDK = new AFe1mSDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.afWarnLog("[register] Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.afInfoLog("[register] Firebase Refreshed Token = ".concat(String.valueOf(str)));
        AFb1tSDK valueOf2 = aFe1mSDK.valueOf();
        if (valueOf2 == null || !str.equals(valueOf2.AFKeystoreWrapper)) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = valueOf2 == null || currentTimeMillis - valueOf2.valueOf > TimeUnit.SECONDS.toMillis(2);
            AFb1tSDK aFb1tSDK = new AFb1tSDK(str, currentTimeMillis, !z);
            aFe1mSDK.AFKeystoreWrapper.AFKeystoreWrapper("afUninstallToken", aFb1tSDK.AFKeystoreWrapper);
            aFe1mSDK.AFKeystoreWrapper.AFInAppEventType("afUninstallToken_received_time", aFb1tSDK.valueOf);
            aFe1mSDK.AFKeystoreWrapper.AFInAppEventType("afUninstallToken_queued", aFb1tSDK.AFInAppEventParameterName());
            if (z) {
                AFe1mSDK.AFKeystoreWrapper(str);
            }
        }
    }

    public final void setDebugLog(boolean z) {
        AFLogger.LogLevel logLevel;
        int i = onAttributionFailure + 21;
        onResponse = i % 128;
        int i2 = i % 2;
        if ((z ? '\"' : 'N') != '\"') {
            logLevel = AFLogger.LogLevel.NONE;
        } else {
            logLevel = AFLogger.LogLevel.DEBUG;
            int i3 = onResponse + 119;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
        }
        setLogLevel(logLevel);
    }

    public final void setOaidData(String str) {
        int i = onResponse + 97;
        onAttributionFailure = i % 128;
        boolean z = true;
        if (i % 2 == 0) {
            AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
            String[] strArr = new String[0];
            strArr[0] = str;
            AFVersionDeclaration2.values("setOaidData", strArr);
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("setOaidData", str);
        }
        AFa1bSDK.values = str;
        int i2 = onResponse + 105;
        onAttributionFailure = i2 % 128;
        if (i2 % 2 != 0) {
            z = false;
        }
        if (z) {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    public final void setAndroidIdData(String str) {
        int i = onResponse + 35;
        onAttributionFailure = i % 128;
        if (!(i % 2 != 0)) {
            AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
            String[] strArr = new String[1];
            strArr[1] = str;
            AFVersionDeclaration2.values("setAndroidIdData", strArr);
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("setAndroidIdData", str);
        }
        this.afInfoLog = str;
        int i2 = onAttributionFailure + 121;
        onResponse = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 24 : 14) == 24) {
            int i3 = 43 / 0;
        }
    }

    private static void valueOf(String str, String str2) {
        int i = onResponse + 87;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AppsFlyerProperties.getInstance().set(str, str2);
        int i3 = onResponse + 33;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 'V' : 0) != 0) {
            throw null;
        }
    }

    private static void AFInAppEventParameterName(String str, boolean z) {
        int i = onResponse + 101;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AppsFlyerProperties.getInstance().set(str, z);
        int i3 = onResponse + 41;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 'Z' : '8') != '8') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    private static String AFInAppEventType(String str) {
        int i = onAttributionFailure + 99;
        onResponse = i % 128;
        int i2 = i % 2;
        String string = AppsFlyerProperties.getInstance().getString(str);
        int i3 = onResponse + 85;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? '8' : '%') != '8') {
            return string;
        }
        int i4 = 66 / 0;
        return string;
    }

    private static boolean AFKeystoreWrapper(String str, boolean z) {
        int i = onAttributionFailure + 31;
        onResponse = i % 128;
        if (!(i % 2 != 0)) {
            return AppsFlyerProperties.getInstance().getBoolean(str, z);
        }
        AppsFlyerProperties.getInstance().getBoolean(str, z);
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final boolean values() {
        boolean z = false;
        if (!(!AFKeystoreWrapper(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false))) {
            int i = onAttributionFailure + 97;
            onResponse = i % 128;
            if (i % 2 != 0) {
                valueOf();
                throw null;
            } else if (valueOf() == null) {
                int i2 = onAttributionFailure + 1;
                onResponse = i2 % 128;
                if (i2 % 2 != 0) {
                    z = true;
                }
                return !z;
            }
        }
        return false;
    }

    public final void waitForCustomerUserId(boolean z) {
        int i = onAttributionFailure + 123;
        onResponse = i % 128;
        if (i % 2 != 0) {
        }
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AFInAppEventParameterName(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public final void setCustomerIdAndLogSession(String str, Context context) {
        int i = onResponse + 35;
        onAttributionFailure = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 94 / 0;
            if ((context != null ? 24 : '(') == '(') {
                return;
            }
        } else if (context == null) {
            return;
        }
        if (values()) {
            setCustomerUserId(str);
            AFLogger.afInfoLog(new StringBuilder("CustomerUserId set: ").append(str).append(" - Initializing AppsFlyer Tacking").toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
            values(context, AFe1iSDK.setCustomerIdAndLogSession);
            String str2 = AFKeystoreWrapper().afWarnLog().AFInAppEventType;
            if (referrer == null) {
                int i3 = onAttributionFailure + 61;
                onResponse = i3 % 128;
                if (i3 % 2 == 0) {
                    referrer = "";
                } else {
                    throw null;
                }
            }
            String str3 = referrer;
            if (context instanceof Activity) {
                int i4 = onAttributionFailure + 85;
                onResponse = i4 % 128;
                if (!(i4 % 2 == 0)) {
                    ((Activity) context).getIntent();
                    int i5 = 95 / 0;
                } else {
                    ((Activity) context).getIntent();
                }
            }
            AFInAppEventParameterName(context, (String) null, (Map<String, Object>) null, str3, (String) null);
            return;
        }
        setCustomerUserId(str);
        AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public final String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (!(string != null)) {
            String values2 = values(context, "AF_STORE");
            if ((values2 != null ? 18 : '-') != '-') {
                return values2;
            }
            AFLogger.afInfoLog("No out-of-store value set");
            int i = onResponse + 119;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            return null;
        }
        int i3 = onAttributionFailure + 125;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
        return string;
    }

    public final void setOutOfStore(String str) {
        if ((str != null ? '*' : 'J') != 'J') {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            boolean z = true;
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            int i = onResponse + 109;
            onAttributionFailure = i % 128;
            if (i % 2 == 0) {
                z = false;
            }
            if (!z) {
                throw null;
            }
            return;
        }
        AFLogger.valueOf("Cannot set setOutOfStore with null");
        int i2 = onResponse + 103;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r1 != '.') goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        if ((!r9.equals(com.appsflyer.AppsFlyerProperties.getInstance().getString(com.appsflyer.AppsFlyerProperties.ONELINK_ID)) ? 'B' : '4') != 'B') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        if (r3 != true) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_DOMAIN);
        com.appsflyer.AppsFlyerProperties.getInstance().remove("onelinkVersion");
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_SCHEME);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        valueOf(com.appsflyer.AppsFlyerProperties.ONELINK_ID, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        if (r9 != null) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInviteOneLink(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = onAttributionFailure
            r1 = 3
            int r0 = r0 + r1
            int r2 = r0 % 128
            onResponse = r2
            int r0 = r0 % 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            java.lang.String r4 = "setAppInviteOneLink = "
            java.lang.String r5 = "setAppInviteOneLink"
            java.lang.String r6 = "oneLinkSlug"
            if (r0 == r2) goto L_0x0036
            com.appsflyer.internal.AFc1vSDK r0 = r8.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.AFVersionDeclaration()
            java.lang.String[] r1 = new java.lang.String[r3]
            r1[r3] = r9
            r0.values((java.lang.String) r5, (java.lang.String[]) r1)
            java.lang.String r0 = java.lang.String.valueOf(r9)
            java.lang.String r0 = r4.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            if (r9 == 0) goto L_0x0097
            goto L_0x0058
        L_0x0036:
            com.appsflyer.internal.AFc1vSDK r0 = r8.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.AFVersionDeclaration()
            java.lang.String[] r7 = new java.lang.String[r2]
            r7[r3] = r9
            r0.values((java.lang.String) r5, (java.lang.String[]) r7)
            java.lang.String r0 = java.lang.String.valueOf(r9)
            java.lang.String r0 = r4.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            r0 = 46
            if (r9 == 0) goto L_0x0055
            r1 = r0
        L_0x0055:
            if (r1 == r0) goto L_0x0058
            goto L_0x0097
        L_0x0058:
            int r0 = onAttributionFailure
            int r0 = r0 + 73
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0066
            r0 = r2
            goto L_0x0067
        L_0x0066:
            r0 = r3
        L_0x0067:
            if (r0 == 0) goto L_0x0085
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r6)
            boolean r0 = r9.equals(r0)
            r1 = 84
            int r1 = r1 / r3
            r1 = 66
            if (r0 != 0) goto L_0x007e
            r0 = r1
            goto L_0x0080
        L_0x007e:
            r0 = 52
        L_0x0080:
            if (r0 == r1) goto L_0x0097
            goto L_0x00b2
        L_0x0083:
            r9 = move-exception
            throw r9
        L_0x0085:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r6)
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0094
            r3 = r2
        L_0x0094:
            if (r3 == r2) goto L_0x0097
            goto L_0x00b2
        L_0x0097:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkDomain"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkVersion"
            r0.remove(r1)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "onelinkScheme"
            r0.remove(r1)
        L_0x00b2:
            valueOf((java.lang.String) r6, (java.lang.String) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.setAppInviteOneLink(java.lang.String):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        int i = onResponse + 85;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        if (map != null) {
            AFKeystoreWrapper().AFVersionDeclaration().values("setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject((Map<?, ?>) map).toString());
        }
        int i3 = onResponse + 29;
        onAttributionFailure = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 50 / 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "pid"
            r2 = 62
            if (r17 == 0) goto L_0x000b
            r3 = 37
            goto L_0x000c
        L_0x000b:
            r3 = r2
        L_0x000c:
            r4 = 1
            r5 = 0
            java.lang.String r6 = "sendPushNotificationData"
            r7 = 0
            r8 = 2
            if (r3 == r2) goto L_0x0063
            int r2 = onResponse
            int r2 = r2 + 51
            int r3 = r2 % 128
            onAttributionFailure = r3
            int r2 = r2 % r8
            r3 = 42
            if (r2 != 0) goto L_0x0023
            r2 = r3
            goto L_0x0025
        L_0x0023:
            r2 = 35
        L_0x0025:
            if (r2 == r3) goto L_0x005a
            android.content.Intent r2 = r17.getIntent()
            if (r2 == 0) goto L_0x0063
            com.appsflyer.internal.AFc1vSDK r2 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r2 = r2.AFVersionDeclaration()
            java.lang.String[] r3 = new java.lang.String[r8]
            java.lang.String r9 = r17.getLocalClassName()
            r3[r5] = r9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r9 = "activity_intent_"
            r5.<init>(r9)
            android.content.Intent r9 = r17.getIntent()
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            r3[r4] = r5
            r2.values((java.lang.String) r6, (java.lang.String[]) r3)
            goto L_0x00a0
        L_0x005a:
            r17.getIntent()
            super.hashCode()     // Catch:{ all -> 0x0061 }
            throw r7     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r0 = move-exception
            throw r0
        L_0x0063:
            if (r17 == 0) goto L_0x008f
            int r2 = onResponse
            int r2 = r2 + 65
            int r3 = r2 % 128
            onAttributionFailure = r3
            int r2 = r2 % r8
            com.appsflyer.internal.AFc1vSDK r2 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r2 = r2.AFVersionDeclaration()
            java.lang.String[] r3 = new java.lang.String[r8]
            java.lang.String r9 = r17.getLocalClassName()
            r3[r5] = r9
            java.lang.String r5 = "activity_intent_null"
            r3[r4] = r5
            r2.values((java.lang.String) r6, (java.lang.String[]) r3)
            int r2 = onResponse
            int r2 = r2 + 39
            int r3 = r2 % 128
            onAttributionFailure = r3
            int r2 = r2 % r8
            goto L_0x00a0
        L_0x008f:
            com.appsflyer.internal.AFc1vSDK r2 = r16.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r2 = r2.AFVersionDeclaration()
            java.lang.String r3 = "activity_null"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r2.values((java.lang.String) r6, (java.lang.String[]) r3)
        L_0x00a0:
            java.lang.String r2 = values((android.app.Activity) r17)
            r1.afErrorLogForExcManagerOnly = r2
            r3 = 96
            if (r2 == 0) goto L_0x00ad
            r2 = 78
            goto L_0x00ae
        L_0x00ad:
            r2 = r3
        L_0x00ae:
            if (r2 == r3) goto L_0x01f2
            long r2 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.getLevel
            java.lang.String r5 = ")"
            if (r4 != 0) goto L_0x00c9
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.getLevel = r0
            r11 = r2
            goto L_0x01b3
        L_0x00c9:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0197 }
            java.lang.String r6 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r9 = r4.getLong(r6, r9)     // Catch:{ all -> 0x0197 }
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.getLevel     // Catch:{ all -> 0x0197 }
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0197 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0197 }
            r11 = r2
        L_0x00e1:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0195 }
            if (r6 == 0) goto L_0x01b3
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0195 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0195 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0195 }
            java.lang.String r14 = r1.afErrorLogForExcManagerOnly     // Catch:{ all -> 0x0195 }
            r13.<init>((java.lang.String) r14)     // Catch:{ all -> 0x0195 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0195 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.getLevel     // Catch:{ all -> 0x0195 }
            java.lang.Object r15 = r15.get(r6)     // Catch:{ all -> 0x0195 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0195 }
            r14.<init>((java.lang.String) r15)     // Catch:{ all -> 0x0195 }
            java.lang.Object r15 = r13.opt(r0)     // Catch:{ all -> 0x0195 }
            java.lang.Object r7 = r14.opt(r0)     // Catch:{ all -> 0x0195 }
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0195 }
            if (r7 == 0) goto L_0x016e
            int r7 = onResponse
            int r7 = r7 + 103
            int r15 = r7 % 128
            onAttributionFailure = r15
            int r7 = r7 % r8
            java.lang.String r15 = "c"
            if (r7 == 0) goto L_0x015e
            java.lang.Object r7 = r13.opt(r15)     // Catch:{ all -> 0x0195 }
            java.lang.Object r15 = r14.opt(r15)     // Catch:{ all -> 0x0195 }
            boolean r7 = r7.equals(r15)     // Catch:{ all -> 0x0195 }
            if (r7 == 0) goto L_0x016e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0195 }
            java.lang.String r4 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r4)     // Catch:{ all -> 0x0195 }
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch:{ all -> 0x0195 }
            java.lang.String r4 = ", new: "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0195 }
            java.lang.StringBuilder r0 = r0.append(r13)     // Catch:{ all -> 0x0195 }
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ all -> 0x0195 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0195 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0195 }
            r0 = 0
            r1.afErrorLogForExcManagerOnly = r0     // Catch:{ all -> 0x0195 }
            int r0 = onAttributionFailure
            int r0 = r0 + 79
            int r2 = r0 % 128
            onResponse = r2
            int r0 = r0 % r8
            if (r0 != 0) goto L_0x0159
            return
        L_0x0159:
            r0 = 0
            throw r0     // Catch:{ all -> 0x015b }
        L_0x015b:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x015e:
            java.lang.Object r0 = r13.opt(r15)     // Catch:{ all -> 0x0195 }
            java.lang.Object r4 = r14.opt(r15)     // Catch:{ all -> 0x0195 }
            r0.equals(r4)     // Catch:{ all -> 0x0195 }
            r7 = 0
            super.hashCode()     // Catch:{ all -> 0x0195 }
            throw r7     // Catch:{ all -> 0x0195 }
        L_0x016e:
            r7 = 0
            long r13 = r6.longValue()     // Catch:{ all -> 0x0195 }
            long r13 = r2 - r13
            int r13 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x017e
            java.util.Map<java.lang.Long, java.lang.String> r13 = r1.getLevel     // Catch:{ all -> 0x0195 }
            r13.remove(r6)     // Catch:{ all -> 0x0195 }
        L_0x017e:
            long r13 = r6.longValue()     // Catch:{ all -> 0x0195 }
            int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r13 > 0) goto L_0x00e1
            int r13 = onAttributionFailure
            int r13 = r13 + 7
            int r14 = r13 % 128
            onResponse = r14
            int r13 = r13 % r8
            long r11 = r6.longValue()     // Catch:{ all -> 0x0195 }
            goto L_0x00e1
        L_0x0195:
            r0 = move-exception
            goto L_0x0199
        L_0x0197:
            r0 = move-exception
            r11 = r2
        L_0x0199:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Error while handling push notification measurement: "
            r4.<init>(r6)
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afErrorLog(r4, r0)
        L_0x01b3:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = "pushPayloadHistorySize"
            int r0 = r0.getInt(r4, r8)
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.getLevel
            int r4 = r4.size()
            if (r4 != r0) goto L_0x01e4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r4)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getLevel
            java.lang.Long r4 = java.lang.Long.valueOf(r11)
            r0.remove(r4)
        L_0x01e4:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getLevel
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = r1.afErrorLogForExcManagerOnly
            r0.put(r2, r3)
            r16.start(r17)
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setUserEmails(String... strArr) {
        int i = onAttributionFailure + 119;
        onResponse = i % 128;
        if (!(i % 2 != 0 ? true : true)) {
            AFKeystoreWrapper().AFVersionDeclaration().values("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            int i2 = onResponse + 37;
            onAttributionFailure = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        AFKeystoreWrapper().AFVersionDeclaration().values("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        throw null;
    }

    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        AFKeystoreWrapper().AFVersionDeclaration().values("setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        int i = 0;
        int i2 = onResponse + 69;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        Throwable th = null;
        Object obj = th;
        while (true) {
            if ((i < length ? 5 : 'M') != 5) {
                hashMap.put(obj, arrayList2);
                AppsFlyerProperties.getInstance().setUserEmails(new JSONObject((Map<?, ?>) hashMap).toString());
                return;
            }
            int i4 = onAttributionFailure + 109;
            onResponse = i4 % 128;
            if (i4 % 2 == 0) {
                String str = strArr[i];
                if (AnonymousClass10.values[emailsCryptType.ordinal()] != 2) {
                    arrayList2.add(AFb1ySDK.AFKeystoreWrapper(str));
                    obj = "sha256_el_arr";
                } else {
                    arrayList2.add(str);
                    int i5 = onResponse + 15;
                    onAttributionFailure = i5 % 128;
                    int i6 = i5 % 2;
                    obj = "plain_el_arr";
                }
                i++;
            } else {
                String str2 = strArr[i];
                int i7 = AnonymousClass10.values[emailsCryptType.ordinal()];
                super.hashCode();
                throw th;
            }
        }
    }

    /* renamed from: com.appsflyer.internal.AFb1xSDK$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] values;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                values = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = values     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AnonymousClass10.<clinit>():void");
        }
    }

    public final void setCollectAndroidID(boolean z) {
        int i = onResponse + 107;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? ']' : '?') != ']') {
            AFKeystoreWrapper().AFVersionDeclaration().values("setCollectAndroidID", String.valueOf(z));
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("setCollectAndroidID", String.valueOf(z));
        }
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public final void setCollectIMEI(boolean z) {
        int i = onResponse + 81;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean z2 = false;
        AFKeystoreWrapper().AFVersionDeclaration().values("setCollectIMEI", String.valueOf(z));
        valueOf(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        valueOf(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
        int i3 = onAttributionFailure + 93;
        onResponse = i3 % 128;
        if (i3 % 2 != 0) {
            z2 = true;
        }
        if (z2) {
            throw null;
        }
    }

    @Deprecated
    public final void setCollectOaid(boolean z) {
        int i = onAttributionFailure + 47;
        onResponse = i % 128;
        if ((i % 2 != 0 ? 30 : '*') != '*') {
            AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z);
            AFVersionDeclaration2.values("setCollectOaid", strArr);
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("setCollectOaid", String.valueOf(z));
        }
        valueOf(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
        int i2 = onAttributionFailure + 101;
        onResponse = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        int i = onAttributionFailure + 71;
        onResponse = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        AFa1tSDK.AFInAppEventType.clear();
        AFa1tSDK.AFInAppEventType.addAll(Arrays.asList(strArr));
        int i3 = onResponse + 71;
        onAttributionFailure = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 40 / 0;
        }
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        int i = onResponse + 113;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFa1tSDK.AFKeystoreWrapper = strArr;
        int i3 = onResponse + 1;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : 'O') != 'O') {
            int i4 = 99 / 0;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventType(AFe1xSDK aFe1xSDK) {
        int i = onAttributionFailure + 55;
        onResponse = i % 128;
        int i2 = i % 2;
        if ((aFe1xSDK == AFe1xSDK.SUCCESS ? (char) 6 : 3) == 6) {
            int i3 = onResponse + 91;
            onAttributionFailure = i3 % 128;
            if ((i3 % 2 == 0 ? '8' : 28) == 28) {
                AFKeystoreWrapper().onDeepLinkingNative().valueOf();
            } else {
                AFKeystoreWrapper().onDeepLinkingNative().valueOf();
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r9.onInstallConversionDataLoadedNative = true;
        AFKeystoreWrapper().afWarnLog().AFInAppEventType = r10;
        com.appsflyer.internal.AFc1rSDK.values(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r12 == null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r9.init = (android.app.Application) r12.getApplicationContext();
        AFInAppEventType(r12);
        AFKeystoreWrapper().AFLogger().AFKeystoreWrapper = java.lang.System.currentTimeMillis();
        AFKeystoreWrapper().onDeepLinkingNative().AFKeystoreWrapper();
        AFKeystoreWrapper().afRDLog().AFInAppEventParameterName((com.appsflyer.internal.AFe1ySDK) new com.appsflyer.internal.AFb1xSDK$$ExternalSyntheticLambda1(r9));
        r12 = AFKeystoreWrapper().getLevel();
        r3 = new com.appsflyer.internal.AFf1mSDK(new com.appsflyer.internal.AFb1xSDK.AnonymousClass3(r9));
        r4 = new com.appsflyer.internal.AFb1xSDK.AnonymousClass2(r9);
        r12.AFKeystoreWrapper(r3);
        r12.AFKeystoreWrapper(new com.appsflyer.internal.AFf1hSDK(r4));
        r12.AFKeystoreWrapper(new com.appsflyer.internal.AFf1nSDK(r4, AFKeystoreWrapper()));
        r12.AFKeystoreWrapper(new com.appsflyer.internal.AFf1iSDK(r4, AFKeystoreWrapper()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a0, code lost:
        if (afInfoLog() != false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a2, code lost:
        r3 = r9.init;
        r5 = AFKeystoreWrapper();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ac, code lost:
        if (android.os.Build.VERSION.SDK_INT < 19) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ae, code lost:
        r3 = r3.getPackageManager().queryIntentContentProviders(new android.content.Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00bd, code lost:
        if (r3 == null) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c3, code lost:
        if (r3.isEmpty() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c7, code lost:
        r6 = new java.util.ArrayList();
        r3 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d4, code lost:
        if (r3.hasNext() == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d6, code lost:
        r7 = onResponse + 67;
        onAttributionFailure = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00df, code lost:
        if ((r7 % 2) != 0) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e1, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e3, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e4, code lost:
        if (r7 == true) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e6, code lost:
        r7 = r3.next().providerInfo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ee, code lost:
        if (r7 == null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f0, code lost:
        r6.add(new com.appsflyer.internal.AFf1lSDK(r7, r4, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f9, code lost:
        com.appsflyer.AFLogger.afWarnLog("[Preinstall]: com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ff, code lost:
        r10 = r3.next().providerInfo;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010b, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0112, code lost:
        if (r6.isEmpty() != false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0114, code lost:
        r12.AFInAppEventParameterName.addAll(r6);
        com.appsflyer.AFLogger.afDebugLog(new java.lang.StringBuilder("[Preinstall]: Detected ").append(r6.size()).append(" valid preinstall provider(s)").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0136, code lost:
        r3 = onResponse + 109;
        onAttributionFailure = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013f, code lost:
        r12 = r12.AFInAppEventParameterName();
        r3 = r12.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0145, code lost:
        if (r4 >= r3) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0147, code lost:
        r12[r4].values(r9.init);
        r4 = r4 + 1;
        r5 = onAttributionFailure + 21;
        onResponse = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015a, code lost:
        r9.onConversionDataFail.afWarnLog().AFInAppEventType();
        com.appsflyer.internal.AFb1fSDK.values = r9.init;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0168, code lost:
        com.appsflyer.AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016d, code lost:
        r12 = AFKeystoreWrapper().AFVersionDeclaration();
        r3 = new java.lang.String[2];
        r3[0] = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
        if (r11 != null) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017b, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x017d, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017e, code lost:
        if (r10 == false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0180, code lost:
        r10 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0183, code lost:
        r10 = "conversionDataListener";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0185, code lost:
        r3[1] = r10;
        r12.values(io.sentry.Session.JsonKeys.INIT, r3);
        com.appsflyer.AFLogger.AFInAppEventType(java.lang.String.format("Initializing AppsFlyer SDK: (v%s.%s)", new java.lang.Object[]{"6.10.3", AFInAppEventParameterName}));
        valueOf = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a1, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r9.onInstallConversionDataLoadedNative != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r9.onInstallConversionDataLoadedNative != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.AppsFlyerLib init(java.lang.String r10, com.appsflyer.AppsFlyerConversionListener r11, android.content.Context r12) {
        /*
            r9 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 15
            int r1 = r0 % 128
            onResponse = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            boolean r0 = r9.onInstallConversionDataLoadedNative
            r3 = 94
            int r3 = r3 / r2
            if (r0 == 0) goto L_0x001c
            goto L_0x001b
        L_0x0015:
            r10 = move-exception
            throw r10
        L_0x0017:
            boolean r0 = r9.onInstallConversionDataLoadedNative
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            return r9
        L_0x001c:
            r0 = 1
            r9.onInstallConversionDataLoadedNative = r0
            com.appsflyer.internal.AFc1vSDK r3 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1kSDK r3 = r3.afWarnLog()
            r3.AFInAppEventType = r10
            com.appsflyer.internal.AFc1rSDK.values(r10)
            if (r12 == 0) goto L_0x0168
            android.content.Context r3 = r12.getApplicationContext()
            android.app.Application r3 = (android.app.Application) r3
            r9.init = r3
            r9.AFInAppEventType((android.content.Context) r12)
            com.appsflyer.internal.AFc1vSDK r12 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1fSDK r12 = r12.AFLogger()
            long r3 = java.lang.System.currentTimeMillis()
            r12.AFKeystoreWrapper = r3
            com.appsflyer.internal.AFc1vSDK r12 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFc1nSDK r12 = r12.onDeepLinkingNative()
            r12.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1xSDK$$ExternalSyntheticLambda1 r12 = new com.appsflyer.internal.AFb1xSDK$$ExternalSyntheticLambda1
            r12.<init>(r9)
            com.appsflyer.internal.AFc1vSDK r3 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1rSDK r3 = r3.afRDLog()
            r3.AFInAppEventParameterName((com.appsflyer.internal.AFe1ySDK) r12)
            com.appsflyer.internal.AFc1vSDK r12 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFf1kSDK r12 = r12.getLevel()
            com.appsflyer.internal.AFf1mSDK r3 = new com.appsflyer.internal.AFf1mSDK
            com.appsflyer.internal.AFb1xSDK$3 r4 = new com.appsflyer.internal.AFb1xSDK$3
            r4.<init>()
            r3.<init>(r4)
            com.appsflyer.internal.AFb1xSDK$2 r4 = new com.appsflyer.internal.AFb1xSDK$2
            r4.<init>(r3)
            r12.AFKeystoreWrapper(r3)
            com.appsflyer.internal.AFf1hSDK r3 = new com.appsflyer.internal.AFf1hSDK
            r3.<init>(r4)
            r12.AFKeystoreWrapper(r3)
            com.appsflyer.internal.AFf1nSDK r3 = new com.appsflyer.internal.AFf1nSDK
            com.appsflyer.internal.AFc1vSDK r5 = r9.AFKeystoreWrapper()
            r3.<init>(r4, r5)
            r12.AFKeystoreWrapper(r3)
            com.appsflyer.internal.AFf1iSDK r3 = new com.appsflyer.internal.AFf1iSDK
            com.appsflyer.internal.AFc1vSDK r5 = r9.AFKeystoreWrapper()
            r3.<init>(r4, r5)
            r12.AFKeystoreWrapper(r3)
            boolean r3 = r9.afInfoLog()
            if (r3 != 0) goto L_0x013f
            android.app.Application r3 = r9.init
            com.appsflyer.internal.AFc1vSDK r5 = r9.AFKeystoreWrapper()
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 19
            if (r6 < r7) goto L_0x013f
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "com.appsflyer.referrer.INSTALL_PROVIDER"
            r6.<init>(r7)
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            java.util.List r3 = r3.queryIntentContentProviders(r6, r2)
            if (r3 == 0) goto L_0x0136
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x00c7
            goto L_0x0136
        L_0x00c7:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x00d0:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x010e
            int r7 = onResponse
            int r7 = r7 + 67
            int r8 = r7 % 128
            onAttributionFailure = r8
            int r7 = r7 % r1
            if (r7 != 0) goto L_0x00e3
            r7 = r0
            goto L_0x00e4
        L_0x00e3:
            r7 = r2
        L_0x00e4:
            if (r7 == r0) goto L_0x00ff
            java.lang.Object r7 = r3.next()
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            android.content.pm.ProviderInfo r7 = r7.providerInfo
            if (r7 == 0) goto L_0x00f9
            com.appsflyer.internal.AFf1lSDK r8 = new com.appsflyer.internal.AFf1lSDK
            r8.<init>(r7, r4, r5)
            r6.add(r8)
            goto L_0x00d0
        L_0x00f9:
            java.lang.String r7 = "[Preinstall]: com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component"
            com.appsflyer.AFLogger.afWarnLog(r7)
            goto L_0x00d0
        L_0x00ff:
            java.lang.Object r10 = r3.next()
            android.content.pm.ResolveInfo r10 = (android.content.pm.ResolveInfo) r10
            android.content.pm.ProviderInfo r10 = r10.providerInfo
            r10 = 0
            super.hashCode()     // Catch:{ all -> 0x010c }
            throw r10     // Catch:{ all -> 0x010c }
        L_0x010c:
            r10 = move-exception
            throw r10
        L_0x010e:
            boolean r3 = r6.isEmpty()
            if (r3 != 0) goto L_0x013f
            java.util.List<com.appsflyer.internal.AFf1jSDK> r3 = r12.AFInAppEventParameterName
            r3.addAll(r6)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "[Preinstall]: Detected "
            r3.<init>(r4)
            int r4 = r6.size()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = " valid preinstall provider(s)"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.afDebugLog(r3)
            goto L_0x013f
        L_0x0136:
            int r3 = onResponse
            int r3 = r3 + 109
            int r4 = r3 % 128
            onAttributionFailure = r4
            int r3 = r3 % r1
        L_0x013f:
            com.appsflyer.internal.AFf1jSDK[] r12 = r12.AFInAppEventParameterName()
            int r3 = r12.length
            r4 = r2
        L_0x0145:
            if (r4 >= r3) goto L_0x015a
            r5 = r12[r4]
            android.app.Application r6 = r9.init
            r5.values(r6)
            int r4 = r4 + 1
            int r5 = onAttributionFailure
            int r5 = r5 + 21
            int r6 = r5 % 128
            onResponse = r6
            int r5 = r5 % r1
            goto L_0x0145
        L_0x015a:
            com.appsflyer.internal.AFc1uSDK r12 = r9.onConversionDataFail
            com.appsflyer.internal.AFe1kSDK r12 = r12.afWarnLog()
            r12.AFInAppEventType()
            android.app.Application r12 = r9.init
            com.appsflyer.internal.AFb1fSDK.values = r12
            goto L_0x016d
        L_0x0168:
            java.lang.String r12 = "context is null, Google Install Referrer will be not initialized"
            com.appsflyer.AFLogger.afWarnLog(r12)
        L_0x016d:
            com.appsflyer.internal.AFc1vSDK r12 = r9.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r12 = r12.AFVersionDeclaration()
            java.lang.String[] r3 = new java.lang.String[r1]
            r3[r2] = r10
            if (r11 != 0) goto L_0x017d
            r10 = r0
            goto L_0x017e
        L_0x017d:
            r10 = r2
        L_0x017e:
            if (r10 == 0) goto L_0x0183
            java.lang.String r10 = "null"
            goto L_0x0185
        L_0x0183:
            java.lang.String r10 = "conversionDataListener"
        L_0x0185:
            r3[r0] = r10
            java.lang.String r10 = "init"
            r12.values((java.lang.String) r10, (java.lang.String[]) r3)
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r12 = "6.10.3"
            r10[r2] = r12
            java.lang.String r12 = AFInAppEventParameterName
            r10[r0] = r12
            java.lang.String r12 = "Initializing AppsFlyer SDK: (v%s.%s)"
            java.lang.String r10 = java.lang.String.format(r12, r10)
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r10)
            valueOf = r11
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.init(java.lang.String, com.appsflyer.AppsFlyerConversionListener, android.content.Context):com.appsflyer.AppsFlyerLib");
    }

    private boolean afInfoLog() {
        int i = onResponse + 25;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean AFInAppEventType2 = AFKeystoreWrapper().AFInAppEventParameterName().AFInAppEventType("AF_PREINSTALL_DISABLED");
        int i3 = onResponse + 77;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
        return AFInAppEventType2;
    }

    private void AFLogger(Context context) {
        this.onAttributionFailureNative = new HashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        AnonymousClass5 r2 = new AFa1rSDK.AFa1vSDK() {
            public final void values(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(String.valueOf(str)));
                    AFb1xSDK.values(AFb1xSDK.this).put("link", str);
                    if (str2 != null) {
                        AFb1xSDK.values(AFb1xSDK.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(ShareConstants.PROMO_CODE, str3);
                        hashMap.put(ShareConstants.DEEPLINK_CONTEXT, hashMap2);
                        AFb1xSDK.values(AFb1xSDK.this).put("extras", hashMap);
                    }
                } else {
                    AFb1xSDK.values(AFb1xSDK.this).put("link", "");
                }
                AFb1xSDK.values(AFb1xSDK.this).put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }

            public final void AFInAppEventType(String str) {
                AFb1xSDK.values(AFb1xSDK.this).put("error", str);
            }
        };
        try {
            Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler(cls, r2) {
                private /* synthetic */ AFa1vSDK AFInAppEventParameterName;
                private /* synthetic */ Class AFInAppEventType;

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.AFa1rSDK.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFa1rSDK.1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if ((TextUtils.isEmpty(string) ? 'V' : 22) != 'V') {
                method.invoke((Object) null, new Object[]{context, string, newProxyInstance});
                int i = onResponse + 79;
                onAttributionFailure = i % 128;
                int i2 = i % 2;
                return;
            }
            int i3 = onAttributionFailure + 105;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
            r2.AFInAppEventType("Facebook app id not defined in resources");
        } catch (NoSuchMethodException e) {
            AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e);
            r2.AFInAppEventType(e.toString());
        } catch (InvocationTargetException e2) {
            AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e2);
            r2.AFInAppEventType(e2.toString());
        } catch (ClassNotFoundException e3) {
            AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e3);
            r2.AFInAppEventType(e3.toString());
        } catch (IllegalAccessException e4) {
            AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e4);
            r2.AFInAppEventType(e4.toString());
        }
    }

    public final void enableFacebookDeferredApplinks(boolean z) {
        int i = onResponse;
        int i2 = i + 1;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        this.onDeepLinkingNative = z;
        int i4 = i + 25;
        onAttributionFailure = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    public final void start(Context context) {
        int i = onResponse + 19;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        ? r0 = 0;
        start(context, r0);
        int i3 = onAttributionFailure + 95;
        onResponse = i3 % 128;
        if (!(i3 % 2 == 0)) {
            super.hashCode();
            throw r0;
        }
    }

    public final void start(Context context, String str) {
        int i = onResponse + 99;
        onAttributionFailure = i % 128;
        char c = i % 2 == 0 ? '0' : 'N';
        start(context, str, (AppsFlyerRequestListener) null);
        if (c == '0') {
            int i2 = 44 / 0;
        }
    }

    public final void start(Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i = onAttributionFailure + 103;
        onResponse = i % 128;
        int i2 = i % 2;
        if (!AFKeystoreWrapper().onResponseNative().AFKeystoreWrapper()) {
            boolean z = false;
            if (!this.onInstallConversionDataLoadedNative) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str == null) {
                    if (appsFlyerRequestListener != null) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
                        return;
                    }
                    return;
                }
            }
            AFInAppEventType(context);
            final AFe1fSDK AFLogger2 = AFKeystoreWrapper().AFLogger();
            AFLogger2.values(AFa1oSDK.AFKeystoreWrapper(context));
            this.init = (Application) context.getApplicationContext();
            AFKeystoreWrapper().AFVersionDeclaration().values("start", str);
            String str2 = AFInAppEventParameterName;
            AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.10.3", str2}));
            AFLogger.afInfoLog(new StringBuilder("Build Number: ").append(str2).toString());
            AppsFlyerProperties.getInstance().loadProperties(this.init.getApplicationContext());
            if ((!TextUtils.isEmpty(str) ? 22 : ':') != ':') {
                AFKeystoreWrapper().afWarnLog().AFInAppEventType = str;
                AFc1rSDK.values(str);
                int i3 = onResponse + 31;
                onAttributionFailure = i3 % 128;
                int i4 = i3 % 2;
            } else {
                if ((TextUtils.isEmpty(AFKeystoreWrapper().afWarnLog().AFInAppEventType) ? (char) 30 : 5) != 5) {
                    int i5 = onResponse + 1;
                    onAttributionFailure = i5 % 128;
                    int i6 = i5 % 2;
                    AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                    if (appsFlyerRequestListener == null) {
                        z = true;
                    }
                    if (!z) {
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
                        return;
                    }
                    return;
                }
            }
            AFKeystoreWrapper().afRDLog().AFInAppEventParameterName((AFe1ySDK) null);
            afDebugLog();
            afInfoLog(this.init.getBaseContext());
            if (this.onDeepLinkingNative) {
                AFLogger(this.init.getApplicationContext());
                int i7 = onAttributionFailure + 105;
                onResponse = i7 % 128;
                int i8 = i7 % 2;
            }
            AFc1uSDK aFc1uSDK = this.onConversionDataFail;
            if (aFc1uSDK.AFInAppEventType == null) {
                aFc1uSDK.AFInAppEventType = new AFb1dSDK(aFc1uSDK.valueOf(), aFc1uSDK.onAppOpenAttributionNative());
            }
            aFc1uSDK.AFInAppEventType.AFKeystoreWrapper(context, new AFb1gSDK.AFa1zSDK() {
                public final void AFInAppEventType(Activity activity) {
                    AFLogger2.AFInAppEventType();
                    AFb1xSDK.this.AFKeystoreWrapper().afRDLog().AFInAppEventParameterName((AFe1ySDK) null);
                    AFb1xSDK.AFInAppEventParameterName(AFb1xSDK.this);
                    int AFKeystoreWrapper2 = AFb1xSDK.this.AFKeystoreWrapper(AFb1xSDK.valueOf((Context) activity), false);
                    AFLogger.afInfoLog("onBecameForeground");
                    if (AFKeystoreWrapper2 < 2) {
                        AFa1dSDK AFInAppEventType = AFa1dSDK.AFInAppEventType((Context) activity);
                        AFInAppEventType.AFInAppEventType.post(AFInAppEventType.afRDLog);
                        AFInAppEventType.AFInAppEventType.post(AFInAppEventType.values);
                    }
                    AFf1vSDK aFf1vSDK = new AFf1vSDK();
                    AFb1xSDK.this.AFKeystoreWrapper().onAppOpenAttributionNative().AFInAppEventType(aFf1vSDK.AFInAppEventType(), activity.getIntent(), activity.getApplication());
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    if (activity != null) {
                        aFf1vSDK.AFKeystoreWrapper = (Application) activity.getApplicationContext();
                    }
                    aFf1vSDK.AFInAppEventType = appsFlyerRequestListener;
                    aFb1xSDK.AFInAppEventType((AFa1sSDK) aFf1vSDK, activity);
                }

                public final void AFInAppEventType(Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    AFe1fSDK aFe1fSDK = AFLogger2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aFe1fSDK.AFLogger != 0) {
                        long j = currentTimeMillis - aFe1fSDK.AFLogger;
                        if (j > 0 && j < 1000) {
                            j = 1000;
                        }
                        aFe1fSDK.AFLogger$LogLevel = TimeUnit.MILLISECONDS.toSeconds(j);
                        aFe1fSDK.AFInAppEventParameterName.AFInAppEventType("prev_session_dur", aFe1fSDK.AFLogger$LogLevel);
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AFb1xSDK.this.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(context));
                    AFb1xSDK.this.AFKeystoreWrapper().onDeepLinkingNative().AFInAppEventType();
                    AFb1sSDK AFVersionDeclaration = AFb1xSDK.this.AFKeystoreWrapper().AFVersionDeclaration();
                    if (AFVersionDeclaration.afInfoLog()) {
                        AFVersionDeclaration.valueOf();
                        if (context != null && !AppsFlyerLib.getInstance().isStopped()) {
                            AFVersionDeclaration.values(context.getPackageName(), context.getPackageManager(), AFb1xSDK.this.AFKeystoreWrapper());
                        }
                        AFVersionDeclaration.AFInAppEventParameterName();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFa1dSDK.AFInAppEventType(context).AFInAppEventParameterName();
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (((r5.getPackageManager().getPackageInfo(r5.getPackageName(), 0).applicationInfo.flags & 32768) != 0) != false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void afInfoLog(android.content.Context r5) {
        /*
            int r0 = onAttributionFailure
            int r0 = r0 + 19
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 32768(0x8000, float:4.5918E-41)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x002d
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0085 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r3)     // Catch:{ Exception -> 0x0085 }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ Exception -> 0x0085 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x0085 }
            r0 = r0 ^ r1
            r1 = 47
            if (r0 == 0) goto L_0x0029
            r0 = 50
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == r1) goto L_0x0071
            goto L_0x0045
        L_0x002d:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0085 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r3)     // Catch:{ Exception -> 0x0085 }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ Exception -> 0x0085 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x0085 }
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0042
            r0 = r2
            goto L_0x0043
        L_0x0042:
            r0 = r3
        L_0x0043:
            if (r0 == 0) goto L_0x0071
        L_0x0045:
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r1 = "appsflyer_backup_rules"
            java.lang.String r4 = "xml"
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x0085 }
            int r5 = r0.getIdentifier(r1, r4, r5)     // Catch:{ Exception -> 0x0085 }
            if (r5 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r3 = r2
        L_0x0059:
            if (r3 == 0) goto L_0x006b
            java.lang.String r5 = "'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules"
            com.appsflyer.AFLogger.valueOf(r5)     // Catch:{ Exception -> 0x0085 }
            int r5 = onResponse
            int r5 = r5 + 113
            int r0 = r5 % 128
            onAttributionFailure = r0
            int r5 = r5 % 2
            goto L_0x0071
        L_0x006b:
            java.lang.String r5 = "appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data"
            com.appsflyer.AFLogger.afInfoLog(r5, r2)     // Catch:{ Exception -> 0x0085 }
            return
        L_0x0071:
            int r5 = onResponse
            int r5 = r5 + 73
            int r0 = r5 % 128
            onAttributionFailure = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x007e
            return
        L_0x007e:
            r5 = 0
            super.hashCode()     // Catch:{ all -> 0x0083 }
            throw r5     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r5 = move-exception
            throw r5
        L_0x0085:
            r5 = move-exception
            java.lang.String r0 = "checkBackupRules Exception"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "checkBackupRules Exception: "
            java.lang.String r5 = r0.concat(r5)
            com.appsflyer.AFLogger.afRDLog(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.afInfoLog(android.content.Context):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private static void afErrorLog(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00bd
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r1 = 1
            boolean r0 = AFKeystoreWrapper((java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "OS SDK is="
            r0.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "; use KeyStore"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r2 = r0.AFKeystoreWrapper()
            if (r2 != 0) goto L_0x0058
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.AFb1wSDK.AFInAppEventParameterName((java.lang.ref.WeakReference<android.content.Context>) r1)
            r0.values = r4
            r4 = 0
            r0.valueOf = r4
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.AFInAppEventType(r4)
            goto L_0x00a3
        L_0x0058:
            java.lang.String r4 = r0.AFInAppEventParameterName()
            java.lang.Object r2 = r0.AFInAppEventType
            monitor-enter(r2)
            int r3 = r0.valueOf     // Catch:{ all -> 0x00ba }
            int r3 = r3 + r1
            r0.valueOf = r3     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ all -> 0x00ba }
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x00ba }
            java.lang.Object r1 = r0.AFInAppEventType     // Catch:{ KeyStoreException -> 0x007e }
            monitor-enter(r1)     // Catch:{ KeyStoreException -> 0x007e }
            java.security.KeyStore r3 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x007b }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x007b }
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            goto L_0x009b
        L_0x007b:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ KeyStoreException -> 0x007e }
            throw r4     // Catch:{ KeyStoreException -> 0x007e }
        L_0x007e:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = "Exception "
            r1.<init>(r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = " occurred"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            com.appsflyer.AFLogger.afErrorLog(r1, r4)     // Catch:{ all -> 0x00ba }
        L_0x009b:
            monitor-exit(r2)     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r0.AFInAppEventParameterName()
            r0.AFInAppEventType(r4)
        L_0x00a3:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.values()
            valueOf((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.AFInAppEventType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            valueOf((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00ba:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x00bd:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.afErrorLog(android.content.Context):void");
    }

    public static String valueOf() {
        int i = onAttributionFailure + 107;
        onResponse = i % 128;
        int i2 = i % 2;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_USER_ID);
        int i3 = onAttributionFailure + 125;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
        return AFInAppEventType2;
    }

    public final void setCustomerUserId(String str) {
        int i = onAttributionFailure + 79;
        onResponse = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().AFVersionDeclaration().values("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        valueOf(AppsFlyerProperties.APP_USER_ID, str);
        AFInAppEventParameterName(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        int i3 = onAttributionFailure + 103;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? '.' : 'C') == '.') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    public final void setPhoneNumber(String str) {
        int i = onResponse + 55;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        this.onResponseNative = AFb1ySDK.AFKeystoreWrapper(str);
        int i3 = onAttributionFailure + 121;
        onResponse = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 38 / 0;
        }
    }

    private static String AFLogger() {
        int i = onResponse + 25;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_ID);
        int i3 = onResponse + 113;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
        return AFInAppEventType2;
    }

    public final void setAppId(String str) {
        int i = onResponse + 61;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().AFVersionDeclaration().values("setAppId", str);
        valueOf(AppsFlyerProperties.APP_ID, str);
        int i3 = onAttributionFailure + 55;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setExtension(String str) {
        int i = onAttributionFailure + 77;
        onResponse = i % 128;
        if ((i % 2 != 0 ? 3 : 'Z') != 3) {
            AFKeystoreWrapper().AFVersionDeclaration().values("setExtension", str);
        } else {
            AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
            String[] strArr = new String[0];
            strArr[1] = str;
            AFVersionDeclaration2.values("setExtension", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
        int i2 = onResponse + 35;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void setIsUpdate(boolean z) {
        int i = onResponse + 89;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean z2 = true;
        AFKeystoreWrapper().AFVersionDeclaration().values("setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
        int i3 = onResponse + 99;
        onAttributionFailure = i3 % 128;
        if (i3 % 2 == 0) {
            z2 = false;
        }
        if (!z2) {
            throw null;
        }
    }

    public final void setCurrencyCode(String str) {
        int i = onAttributionFailure + 35;
        onResponse = i % 128;
        if ((i % 2 != 0 ? 'A' : '/') != '/') {
            AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
            String[] strArr = new String[1];
            strArr[1] = str;
            AFVersionDeclaration2.values("setCurrencyCode", strArr);
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("setCurrencyCode", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        int i2 = onAttributionFailure + 17;
        onResponse = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void logLocation(Context context, double d, double d2) {
        AFKeystoreWrapper().AFVersionDeclaration().values("logLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        AFKeystoreWrapper(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
        int i = onAttributionFailure + 37;
        onResponse = i % 128;
        if (!(i % 2 == 0)) {
            int i2 = 59 / 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void AFInAppEventParameterName(WeakReference<Context> weakReference) {
        int i = onResponse + 103;
        onAttributionFailure = i % 128;
        if (i % 2 == 0) {
            weakReference.get();
            throw null;
        } else if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences valueOf2 = valueOf(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(valueOf2);
            long j = AFKeystoreWrapper().AFLogger().AFLogger$LogLevel;
            HashMap hashMap = new HashMap();
            String str = AFKeystoreWrapper().afWarnLog().AFInAppEventType;
            char c = 'I';
            if ((str == null ? 'I' : 23) != 'I') {
                String AFInAppEventType2 = AFInAppEventType("KSAppsFlyerId");
                if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false) ? '@' : IOUtils.DIR_SEPARATOR_UNIX) == '@') {
                    hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                AFc1qSDK.AFa1vSDK values2 = AFa1bSDK.values(weakReference.get().getContentResolver());
                if (values2 != null) {
                    int i2 = onResponse + 65;
                    onAttributionFailure = i2 % 128;
                    int i3 = i2 % 2;
                    hashMap.put("amazon_aid", values2.AFInAppEventParameterName);
                    hashMap.put("amazon_aid_limit", String.valueOf(values2.AFInAppEventType));
                    int i4 = onResponse + 51;
                    onAttributionFailure = i4 % 128;
                    int i5 = i4 % 2;
                }
                String string = AppsFlyerProperties.getInstance().getString("advertiserId");
                if ((string != null ? 'L' : '<') != '<') {
                    hashMap.put("advertiserId", string);
                }
                hashMap.put("app_id", weakReference.get().getPackageName());
                hashMap.put("devkey", str);
                hashMap.put("uid", AFb1wSDK.AFInAppEventParameterName(weakReference));
                hashMap.put("time_in_app", String.valueOf(j));
                hashMap.put("statType", "user_closed_app");
                hashMap.put("platform", AndroidContextProvider.PLATFORM);
                hashMap.put("launch_counter", Integer.toString(AFKeystoreWrapper(valueOf2, false)));
                hashMap.put("channel", AFInAppEventParameterName(weakReference.get()));
                if (AFInAppEventType2 == null) {
                    c = '<';
                }
                if (c == '<') {
                    AFInAppEventType2 = "";
                }
                hashMap.put("originalAppsflyerId", AFInAppEventType2);
                if (this.onAppOpenAttributionNative) {
                    AFf1xSDK aFf1xSDK = new AFf1xSDK();
                    aFf1xSDK.AFLogger$LogLevel = isStopped();
                    AFd1cSDK aFd1cSDK = new AFd1cSDK((AFf1xSDK) aFf1xSDK.AFKeystoreWrapper(AFKeystoreWrapper().AFInAppEventParameterName().AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0)).AFInAppEventParameterName((Map<String, ?>) hashMap).AFInAppEventParameterName(String.format(afErrorLog, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventType().getHostName()})), AFKeystoreWrapper());
                    AFd1pSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
                    afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFd1cSDK) {
                        private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                        /*  JADX ERROR: Method generation error
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            */
                        /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            */
                        public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    });
                    return;
                }
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
                return;
            }
            AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.Throwable, java.util.Map, java.lang.Object, java.lang.String] */
    public final void logSession(Context context) {
        int i = onResponse + 15;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().AFVersionDeclaration().values("logSession", new String[0]);
        AFKeystoreWrapper().AFVersionDeclaration().AFInAppEventType();
        values(context, AFe1iSDK.logSession);
        ? r0 = 0;
        AFKeystoreWrapper(context, (String) r0, (Map<String, Object>) r0);
        int i3 = onAttributionFailure + 43;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? 9 : 'V') == 9) {
            super.hashCode();
            throw r0;
        }
    }

    private void values(Context context, AFe1iSDK aFe1iSDK) {
        AFInAppEventType(context);
        AFe1fSDK AFLogger2 = AFKeystoreWrapper().AFLogger();
        AFe1gSDK AFKeystoreWrapper2 = AFa1oSDK.AFKeystoreWrapper(context);
        boolean z = true;
        if (AFLogger2.AFInAppEventParameterName()) {
            int i = onResponse + 53;
            onAttributionFailure = i % 128;
            if (!(i % 2 == 0)) {
                AFLogger2.values.put("api_name", aFe1iSDK.toString());
                AFLogger2.values(AFKeystoreWrapper2);
            } else {
                AFLogger2.values.put("api_name", aFe1iSDK.toString());
                AFLogger2.values(AFKeystoreWrapper2);
                int i2 = 49 / 0;
            }
        }
        AFLogger2.AFInAppEventType();
        int i3 = onAttributionFailure + 79;
        onResponse = i3 % 128;
        if (i3 % 2 == 0) {
            z = false;
        }
        if (z) {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        Activity activity;
        AFInAppEventType(context);
        AFe1dSDK aFe1dSDK = new AFe1dSDK();
        boolean z = false;
        if (!(context == null)) {
            aFe1dSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
            int i = onResponse + 57;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
        }
        int AFKeystoreWrapper2 = AFKeystoreWrapper(valueOf(context));
        aFe1dSDK.AFInAppEventType().put("ad_network", map);
        aFe1dSDK.AFInAppEventType().put("adrevenue_counter", Integer.valueOf(AFKeystoreWrapper2));
        if (!(context instanceof Activity)) {
            z = true;
        }
        if (!z) {
            int i3 = onAttributionFailure + 13;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
            activity = (Activity) context;
        } else {
            activity = null;
            int i5 = onResponse + 49;
            onAttributionFailure = i5 % 128;
            int i6 = i5 % 2;
        }
        AFInAppEventType((AFa1sSDK) aFe1dSDK, activity);
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i = onResponse + 59;
        onAttributionFailure = i % 128;
        char c = i % 2 == 0 ? '5' : ';';
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
        if (c == ';') {
            int i2 = onAttributionFailure + 71;
            onResponse = i2 % 128;
            if ((i2 % 2 != 0 ? 'O' : 26) == 'O') {
                throw null;
            }
            return;
        }
        throw null;
    }

    private void AFKeystoreWrapper(Context context, String str, Map<String, Object> map) {
        AFf1wSDK aFf1wSDK = new AFf1wSDK();
        if ((context != null ? 11 : '@') != '@') {
            int i = onResponse + 79;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            aFf1wSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        aFf1wSDK.afErrorLog = str;
        aFf1wSDK.values = map;
        AFInAppEventType((AFa1sSDK) aFf1wSDK, !(context instanceof Activity) ? null : (Activity) context);
        int i3 = onResponse + 109;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
    }

    /* access modifiers changed from: package-private */
    public final void AFInAppEventType(AFa1sSDK aFa1sSDK, Activity activity) {
        Uri AFInAppEventType2;
        int i = onAttributionFailure + 49;
        onResponse = i % 128;
        int i2 = i % 2;
        Application application = aFa1sSDK.AFKeystoreWrapper;
        String str = "";
        String obj = (!(activity != null ? true : true) || activity.getIntent() == null || (AFInAppEventType2 = AFb1lSDK.AFInAppEventType(activity)) == null) ? str : AFInAppEventType2.toString();
        boolean z = true;
        if (AFKeystoreWrapper().afWarnLog().AFInAppEventType == null) {
            int i3 = onResponse + 31;
            onAttributionFailure = i3 % 128;
            if (i3 % 2 != 0) {
                AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
                AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK.AFInAppEventType;
                if (appsFlyerRequestListener == null) {
                    z = false;
                }
                if (z) {
                    appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
                    return;
                }
                return;
            }
            AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            AppsFlyerRequestListener appsFlyerRequestListener2 = aFa1sSDK.AFInAppEventType;
            Throwable th = null;
            super.hashCode();
            throw th;
        }
        String referrer = AppsFlyerProperties.getInstance().getReferrer(application);
        if (referrer != null) {
            z = false;
        }
        if (z) {
            int i4 = onAttributionFailure + 57;
            onResponse = i4 % 128;
            int i5 = i4 % 2;
        } else {
            str = referrer;
        }
        aFa1sSDK.afRDLog = str;
        aFa1sSDK.AFInAppEventParameterName = obj;
        values(aFa1sSDK);
    }

    public final void anonymizeUser(boolean z) {
        int i = onAttributionFailure + 121;
        onResponse = i % 128;
        if (i % 2 == 0) {
            AFKeystoreWrapper().AFVersionDeclaration().values("anonymizeUser", String.valueOf(z));
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("anonymizeUser", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = onResponse + 31;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFKeystoreWrapper().AFVersionDeclaration().values("registerConversionListener", new String[0]);
        values(appsFlyerConversionListener);
        int i3 = onAttributionFailure + 91;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? 'S' : '!') != '!') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    private static void values(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = onResponse + 23;
        onAttributionFailure = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 76 / 0;
            if (appsFlyerConversionListener == null) {
                return;
            }
        } else if (appsFlyerConversionListener == null) {
            return;
        }
        valueOf = appsFlyerConversionListener;
        int i3 = onAttributionFailure + 37;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void unregisterConversionListener() {
        int i = onAttributionFailure + 27;
        onResponse = i % 128;
        if (i % 2 == 0) {
            AFKeystoreWrapper().AFVersionDeclaration().values("unregisterConversionListener", new String[0]);
        } else {
            AFKeystoreWrapper().AFVersionDeclaration().values("unregisterConversionListener", new String[0]);
        }
        valueOf = null;
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        boolean z = false;
        AFKeystoreWrapper().AFVersionDeclaration().values("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            z = true;
        }
        if (!z) {
            int i = onResponse + 17;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            AFLogger.afDebugLog("registerValidatorListener null listener");
            return;
        }
        AFInAppEventType = appsFlyerInAppPurchaseValidatorListener;
        int i3 = onResponse + 99;
        onAttributionFailure = i3 % 128;
        if ((i3 % 2 == 0 ? 'R' : '1') != '1') {
            throw null;
        }
    }

    public static String AFKeystoreWrapper(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        int i = onResponse + 27;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r7.trim().isEmpty() != false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r7.trim().isEmpty() != false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(android.content.Context r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8, java.lang.String r9, java.lang.String r10) {
        /*
            r5 = this;
            int r0 = onResponse
            int r1 = r0 + 59
            int r2 = r1 % 128
            onAttributionFailure = r2
            r2 = 2
            int r1 = r1 % r2
            r1 = 7
            if (r7 == 0) goto L_0x000f
            r3 = r1
            goto L_0x0010
        L_0x000f:
            r3 = r2
        L_0x0010:
            r4 = 52
            if (r3 == r1) goto L_0x0015
            goto L_0x0037
        L_0x0015:
            int r0 = r0 + 111
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % r2
            if (r0 != 0) goto L_0x002d
            java.lang.String r0 = r7.trim()
            boolean r0 = r0.isEmpty()
            int r1 = r4 / 0
            if (r0 == 0) goto L_0x003d
            goto L_0x0037
        L_0x002b:
            r6 = move-exception
            throw r6
        L_0x002d:
            java.lang.String r0 = r7.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x003d
        L_0x0037:
            com.appsflyer.internal.AFf1vSDK r0 = new com.appsflyer.internal.AFf1vSDK
            r0.<init>()
            goto L_0x0042
        L_0x003d:
            com.appsflyer.internal.AFf1wSDK r0 = new com.appsflyer.internal.AFf1wSDK
            r0.<init>()
        L_0x0042:
            if (r6 == 0) goto L_0x0046
            r1 = r4
            goto L_0x0048
        L_0x0046:
            r1 = 81
        L_0x0048:
            if (r1 == r4) goto L_0x004b
            goto L_0x0053
        L_0x004b:
            android.content.Context r6 = r6.getApplicationContext()
            android.app.Application r6 = (android.app.Application) r6
            r0.AFKeystoreWrapper = r6
        L_0x0053:
            r0.afErrorLog = r7
            r0.values = r8
            r0.afRDLog = r9
            r0.AFInAppEventParameterName = r10
            r5.values((com.appsflyer.internal.AFa1sSDK) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    private void values(AFa1sSDK aFa1sSDK) {
        int i = onResponse + 15;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean z = false;
        boolean z2 = aFa1sSDK.afErrorLog == null;
        if (!(values())) {
            Throwable th = null;
            if ((z2 ? 27 : '$') == 27) {
                int i3 = onAttributionFailure + 93;
                onResponse = i3 % 128;
                int i4 = i3 % 2;
                if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true) ? '\\' : 'D') != '\\') {
                    AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
                } else if (afErrorLog()) {
                    int i5 = onAttributionFailure + 43;
                    onResponse = i5 % 128;
                    if ((i5 % 2 != 0 ? 30 : '%') == '%') {
                        AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK.AFInAppEventType;
                        if (appsFlyerRequestListener != null) {
                            appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, AFb1aSDK.AFInAppEventType);
                        }
                        int i6 = onResponse + 45;
                        onAttributionFailure = i6 % 128;
                        if (i6 % 2 != 0) {
                            z = true;
                        }
                        if (!z) {
                            super.hashCode();
                            throw th;
                        }
                        return;
                    }
                    AppsFlyerRequestListener appsFlyerRequestListener2 = aFa1sSDK.AFInAppEventType;
                    super.hashCode();
                    throw th;
                }
                this.afRDLog = System.currentTimeMillis();
            }
            AFInAppEventParameterName(AFKeystoreWrapper().values(), new AFa1vSDK(this, aFa1sSDK, (byte) 0), 0, TimeUnit.MILLISECONDS);
            int i7 = onResponse + 119;
            onAttributionFailure = i7 % 128;
            if (i7 % 2 == 0) {
                throw th;
            }
            return;
        }
        int i8 = onResponse + 43;
        onAttributionFailure = i8 % 128;
        int i9 = i8 % 2;
        AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
    }

    private boolean afErrorLog() {
        if (this.afRDLog > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.afRDLog;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            String AFKeystoreWrapper2 = AFKeystoreWrapper(simpleDateFormat, this.afRDLog);
            String AFKeystoreWrapper3 = AFKeystoreWrapper(simpleDateFormat, this.AFLogger$LogLevel);
            if (currentTimeMillis < this.afWarnLog) {
                int i = onResponse + 5;
                onAttributionFailure = i % 128;
                if (i % 2 != 0) {
                    if ((!isStopped() ? 26 : Typography.quote) == 26) {
                        int i2 = onAttributionFailure + 51;
                        onResponse = i2 % 128;
                        int i3 = i2 % 2;
                        AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{AFKeystoreWrapper2, AFKeystoreWrapper3, Long.valueOf(currentTimeMillis), Long.valueOf(this.afWarnLog)}));
                        return true;
                    }
                } else {
                    isStopped();
                    throw null;
                }
            }
            if ((!isStopped() ? 4 : 'W') == 4) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{AFKeystoreWrapper2, AFKeystoreWrapper3, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    private void valueOf(Context context, String str) {
        AFe1bSDK aFe1bSDK = new AFe1bSDK();
        if (context != null) {
            aFe1bSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
            int i = onResponse + 65;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
        }
        AFa1sSDK AFKeystoreWrapper2 = aFe1bSDK.AFKeystoreWrapper(AFKeystoreWrapper().AFInAppEventParameterName().AFInAppEventType.AFKeystoreWrapper("appsFlyerCount", 0));
        AFKeystoreWrapper2.afRDLog = str;
        if (str != null) {
            int i3 = onResponse + 31;
            onAttributionFailure = i3 % 128;
            char c = i3 % 2 == 0 ? '<' : 'a';
            int length = str.length();
            if (c != '<') {
                if ((length > 5 ? '9' : '2') != '9') {
                    return;
                }
            } else {
                if ((length > 2 ? 19 : ';') != 19) {
                    return;
                }
            }
            if (AFInAppEventParameterName(AFKeystoreWrapper2, valueOf(context))) {
                AFInAppEventParameterName(AFKeystoreWrapper().values(), new AFa1vSDK(this, AFKeystoreWrapper2, (byte) 0), 5, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AFInAppEventParameterName(com.appsflyer.internal.AFa1sSDK r7, android.content.SharedPreferences r8) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.AFKeystoreWrapper((android.content.SharedPreferences) r8, (boolean) r0)
            r2 = 1
            if (r1 != r2) goto L_0x002c
            int r3 = onAttributionFailure
            int r4 = r3 + 13
            int r5 = r4 % 128
            onResponse = r5
            int r4 = r4 % 2
            boolean r7 = r7 instanceof com.appsflyer.internal.AFe1cSDK
            if (r7 != 0) goto L_0x0018
            r7 = r0
            goto L_0x0019
        L_0x0018:
            r7 = r2
        L_0x0019:
            if (r7 == r2) goto L_0x002c
            int r3 = r3 + r2
            int r7 = r3 % 128
            onResponse = r7
            int r3 = r3 % 2
            int r7 = r7 + 29
            int r3 = r7 % 128
            onAttributionFailure = r3
            int r7 = r7 % 2
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r0
        L_0x002d:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r8 = r8.getBoolean(r3, r0)
            if (r8 != 0) goto L_0x003f
            if (r1 != r2) goto L_0x0039
            r8 = r0
            goto L_0x003a
        L_0x0039:
            r8 = r2
        L_0x003a:
            if (r8 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r8 = r2
            goto L_0x0040
        L_0x003f:
            r8 = r0
        L_0x0040:
            if (r8 != 0) goto L_0x0046
            if (r7 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(com.appsflyer.internal.AFa1sSDK, android.content.SharedPreferences):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFInAppEventParameterName(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 119
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x001b
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L_0x003e
            goto L_0x0025
        L_0x001b:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L_0x003e
        L_0x0025:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 == 0) goto L_0x0032
            goto L_0x003e
        L_0x0032:
            int r0 = onAttributionFailure
            int r0 = r0 + 21
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r0 = r3
            goto L_0x003f
        L_0x003e:
            r0 = r2
        L_0x003f:
            if (r0 != 0) goto L_0x00c3
            int r0 = onAttributionFailure
            int r0 = r0 + 3
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            java.lang.String r0 = "advertiserId"
            java.lang.Object r0 = r5.get(r0)
            if (r0 == 0) goto L_0x00c3
            int r0 = onResponse
            int r0 = r0 + 25
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            java.lang.String r0 = r4.afInfoLog     // Catch:{ Exception -> 0x00bd }
            boolean r0 = com.appsflyer.internal.AFb1pSDK.valueOf(r0)     // Catch:{ Exception -> 0x00bd }
            r1 = 83
            if (r0 == 0) goto L_0x006a
            r0 = 67
            goto L_0x006b
        L_0x006a:
            r0 = r1
        L_0x006b:
            if (r0 == r1) goto L_0x009f
            java.lang.String r0 = "android_id"
            java.lang.Object r0 = r5.remove(r0)     // Catch:{ Exception -> 0x00bd }
            if (r0 == 0) goto L_0x009f
            int r0 = onAttributionFailure
            int r0 = r0 + 11
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r3 = r2
        L_0x0083:
            java.lang.String r0 = "validateGaidAndIMEI :: removing: android_id"
            if (r3 != r2) goto L_0x0095
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Exception -> 0x00bd }
            int r0 = onAttributionFailure
            int r0 = r0 + 9
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            goto L_0x009f
        L_0x0095:
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Exception -> 0x00bd }
            r5 = 0
            super.hashCode()     // Catch:{ all -> 0x009d }
            throw r5     // Catch:{ all -> 0x009d }
        L_0x009d:
            r5 = move-exception
            throw r5
        L_0x009f:
            com.appsflyer.internal.AFc1vSDK r0 = r4.AFKeystoreWrapper()     // Catch:{ Exception -> 0x00bd }
            com.appsflyer.internal.AFe1kSDK r0 = r0.afWarnLog()     // Catch:{ Exception -> 0x00bd }
            java.lang.String r0 = r0.valueOf     // Catch:{ Exception -> 0x00bd }
            boolean r0 = com.appsflyer.internal.AFb1pSDK.valueOf(r0)     // Catch:{ Exception -> 0x00bd }
            if (r0 == 0) goto L_0x00bc
            java.lang.String r0 = "imei"
            java.lang.Object r5 = r5.remove(r0)     // Catch:{ Exception -> 0x00bd }
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = "validateGaidAndIMEI :: removing: imei"
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ Exception -> 0x00bd }
        L_0x00bc:
            return
        L_0x00bd:
            r5 = move-exception
            java.lang.String r0 = "failed to remove IMEI or AndroidID key from params; "
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(java.util.Map):void");
    }

    private boolean afRDLog() {
        int i = onResponse + 55;
        int i2 = i % 128;
        onAttributionFailure = i2;
        int i3 = i % 2;
        Map<String, Object> map = this.onAttributionFailureNative;
        if (map != null) {
            int i4 = i2 + 67;
            onResponse = i4 % 128;
            boolean z = i4 % 2 == 0;
            boolean isEmpty = map.isEmpty();
            if (z) {
                if ((!isEmpty ? '(' : ':') != '(') {
                    return false;
                }
            } else {
                int i5 = 74 / 0;
                if (!isEmpty) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    private void values(Map<String, Object> map, boolean z) {
        map.put("platformextension", this.onInstallConversionFailureNative.AFKeystoreWrapper());
        if ((z ? 'I' : 27) != 27) {
            int i = onAttributionFailure + 125;
            onResponse = i % 128;
            if (!(i % 2 != 0)) {
                map.put("platform_extension_v2", AFKeystoreWrapper().init().AFInAppEventType());
            } else {
                map.put("platform_extension_v2", AFKeystoreWrapper().init().AFInAppEventType());
                int i2 = 79 / 0;
            }
            int i3 = onResponse + 113;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    public static Map<String, Object> valueOf(Map<String, Object> map) {
        int i = onResponse + 97;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        if ((map.containsKey(Mechanism.JsonKeys.META) ? '=' : 'N') != 'N') {
            Map<String, Object> map2 = (Map) map.get(Mechanism.JsonKeys.META);
            int i3 = onAttributionFailure + 103;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
            return map2;
        }
        HashMap hashMap = new HashMap();
        map.put(Mechanism.JsonKeys.META, hashMap);
        return hashMap;
    }

    private static boolean AFInAppEventParameterName(SharedPreferences sharedPreferences) {
        int i = onResponse + 65;
        onAttributionFailure = i % 128;
        char c = i % 2 == 0 ? ',' : 26;
        String string = sharedPreferences.getString("sentSuccessfully", (String) null);
        if (c == 26) {
            return Boolean.parseBoolean(string);
        }
        Boolean.parseBoolean(string);
        throw null;
    }

    private static void valueOf(Context context, Map<String, Object> map) {
        String str;
        int i = onResponse + 121;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null ? true : true) {
            int i3 = onResponse + 65;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 0) {
                str = "p";
            } else if (rotation == 1) {
                str = "l";
            } else if (rotation == 2) {
                str = "pr";
            } else if (rotation != 3) {
                str = "";
            } else {
                int i5 = onAttributionFailure + 117;
                onResponse = i5 % 128;
                int i6 = i5 % 2;
                str = "lr";
            }
            map.put("sc_o", str);
        }
    }

    private void valueOf(Context context, boolean z, Map<String, Object> map, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", AFInAppEventParameterName("ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", AFInAppEventParameterName("ro.product.cpu.abi2"));
        hashMap.put(DebugImage.JsonKeys.ARCH, AFInAppEventParameterName("os.arch"));
        hashMap.put("build_display_id", AFInAppEventParameterName("ro.build.display.id"));
        boolean z2 = true;
        if ((z ? '=' : '_') == '=') {
            AFInAppEventType(context, (Map<String, Object>) hashMap);
            if (i <= 2) {
                int i2 = onAttributionFailure + 47;
                onResponse = i2 % 128;
                int i3 = i2 % 2;
                hashMap.putAll(AFa1dSDK.AFInAppEventType(context).values());
            }
        }
        hashMap.put("dim", AFc1lSDK.values(context));
        map.put("deviceData", hashMap);
        int i4 = onAttributionFailure + 125;
        onResponse = i4 % 128;
        if (i4 % 2 == 0) {
            z2 = false;
        }
        if (z2) {
            throw null;
        }
    }

    public final void AFKeystoreWrapper(Context context, Map<String, ? super String> map) {
        int i = onResponse + 121;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean z = false;
        boolean AFKeystoreWrapper2 = AFKeystoreWrapper(AppsFlyerProperties.DISABLE_NETWORK_DATA, false);
        AFa1hSDK.AFa1zSDK valueOf2 = AFKeystoreWrapper().onInstallConversionFailureNative().valueOf(context);
        map.put("network", valueOf2.AFInAppEventType);
        if (!AFKeystoreWrapper2 && valueOf2.AFInAppEventParameterName != null) {
            int i3 = onAttributionFailure + 13;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
            map.put("operator", valueOf2.AFInAppEventParameterName);
        }
        if (!(AFKeystoreWrapper2)) {
            int i5 = onResponse + 53;
            onAttributionFailure = i5 % 128;
            int i6 = i5 % 2;
            if ((valueOf2.AFKeystoreWrapper != null ? (char) 6 : 17) == 6) {
                map.put("carrier", valueOf2.AFKeystoreWrapper);
            }
        }
        int i7 = onAttributionFailure + 29;
        onResponse = i7 % 128;
        if (i7 % 2 == 0) {
            z = true;
        }
        if (!z) {
            throw null;
        }
    }

    private void AFInAppEventType(Context context, Map<String, Object> map) {
        int i = onResponse + 47;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFc1zSDK.AFa1vSDK AFInAppEventType2 = AFKeystoreWrapper().AppsFlyer2dXConversionCallback().AFInAppEventType(context);
        map.put("btl", Float.toString(AFInAppEventType2.valueOf));
        if (AFInAppEventType2.values != null) {
            int i3 = onResponse + 115;
            onAttributionFailure = i3 % 128;
            if (i3 % 2 == 0) {
                map.put("btch", AFInAppEventType2.values);
                int i4 = 56 / 0;
            } else {
                map.put("btch", AFInAppEventType2.values);
            }
        }
        int i5 = onResponse + 101;
        onAttributionFailure = i5 % 128;
        if (!(i5 % 2 != 0)) {
            int i6 = 64 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFInAppEventType(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            int r0 = onResponse
            int r0 = r0 + 57
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            java.lang.String r1 = "onelinkVersion"
            java.lang.String r2 = "oneLinkSlug"
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x002a
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r2)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = r2.getString(r1)
            r2 = 49
            int r2 = r2 / r4
            if (r0 == 0) goto L_0x005c
            goto L_0x003c
        L_0x0028:
            r6 = move-exception
            throw r6
        L_0x002a:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r0.getString(r2)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = r2.getString(r1)
            if (r0 == 0) goto L_0x005c
        L_0x003c:
            int r2 = onResponse
            int r2 = r2 + 69
            int r5 = r2 % 128
            onAttributionFailure = r5
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x004a
            r2 = r3
            goto L_0x004b
        L_0x004a:
            r2 = r4
        L_0x004b:
            java.lang.String r5 = "onelink_id"
            if (r2 == r3) goto L_0x0053
            r6.put(r5, r0)
            goto L_0x005c
        L_0x0053:
            r6.put(r5, r0)
            r0 = 71
            int r0 = r0 / r4
            goto L_0x005c
        L_0x005a:
            r6 = move-exception
            throw r6
        L_0x005c:
            if (r1 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = r4
        L_0x0060:
            if (r3 == 0) goto L_0x0071
            int r0 = onResponse
            int r0 = r0 + 5
            int r2 = r0 % 128
            onAttributionFailure = r2
            int r0 = r0 % 2
            java.lang.String r0 = "onelink_ver"
            r6.put(r0, r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(java.util.Map):void");
    }

    private static String values(Activity activity) {
        String str = null;
        if (activity != null) {
            int i = onAttributionFailure + 105;
            onResponse = i % 128;
            int i2 = i % 2;
            Intent intent = activity.getIntent();
            if (intent != null) {
                int i3 = onAttributionFailure + 23;
                onResponse = i3 % 128;
                if (i3 % 2 == 0) {
                    try {
                        Bundle extras = intent.getExtras();
                        if (!((extras != null ? '-' : 'X') == 'X' || (str = extras.getString("af")) == null)) {
                            int i4 = onResponse + 51;
                            onAttributionFailure = i4 % 128;
                            if (i4 % 2 == 0) {
                                AFLogger.afInfoLog("Push Notification received af payload = ".concat(String.valueOf(str)));
                                extras.remove("af");
                                activity.setIntent(intent.putExtras(extras));
                                int i5 = 41 / 0;
                            } else {
                                AFLogger.afInfoLog("Push Notification received af payload = ".concat(String.valueOf(str)));
                                extras.remove("af");
                                activity.setIntent(intent.putExtras(extras));
                            }
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                } else {
                    intent.getExtras();
                    throw null;
                }
            }
        }
        int i6 = onResponse + 79;
        onAttributionFailure = i6 % 128;
        if (i6 % 2 != 0) {
            return str;
        }
        int i7 = 43 / 0;
        return str;
    }

    private int AFKeystoreWrapper(SharedPreferences sharedPreferences) {
        int i = onResponse + 61;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        int AFInAppEventType2 = AFInAppEventType(sharedPreferences, "appsFlyerAdRevenueCount", true);
        int i3 = onResponse + 103;
        onAttributionFailure = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return AFInAppEventType2;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    public final void valueOf(Context context, Map<String, Object> map, Uri uri) {
        AFInAppEventType(context);
        if (!map.containsKey("af_deeplink")) {
            int i = onResponse + 73;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            String AFKeystoreWrapper2 = AFKeystoreWrapper(uri.toString());
            AFa1tSDK onAppOpenAttributionNative2 = AFKeystoreWrapper().onAppOpenAttributionNative();
            if ((onAppOpenAttributionNative2.AFInAppEventParameterName != null) && onAppOpenAttributionNative2.valueOf != null) {
                if ((AFKeystoreWrapper2.contains(onAppOpenAttributionNative2.AFInAppEventParameterName) ? 13 : '1') == 13) {
                    Uri.Builder buildUpon = Uri.parse(AFKeystoreWrapper2).buildUpon();
                    Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                    Iterator<Map.Entry<String, String>> it = onAppOpenAttributionNative2.valueOf.entrySet().iterator();
                    int i3 = onResponse + 11;
                    onAttributionFailure = i3 % 128;
                    int i4 = i3 % 2;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry next = it.next();
                        buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                        buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    }
                    AFKeystoreWrapper2 = buildUpon.build().toString();
                    map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
                }
            }
            map.put("af_deeplink", AFKeystoreWrapper2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        AFe1zSDK aFe1zSDK = new AFe1zSDK(AFKeystoreWrapper(), UUID.randomUUID(), uri);
        if (aFe1zSDK.AFLogger$LogLevel()) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        AFa1cSDK.values(context, hashMap, uri);
        if (aFe1zSDK.afWarnLog()) {
            aFe1zSDK.afRDLog = values((Map<String, String>) hashMap);
            AFd1pSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFe1zSDK) {
                private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            int i5 = onResponse + 95;
            onAttributionFailure = i5 % 128;
            int i6 = i5 % 2;
            return;
        }
        AFb1oSDK.valueOf(hashMap);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private static String AFKeystoreWrapper(String str) {
        ? r0 = 0;
        if (str == null) {
            return r0;
        }
        if (str.matches("fb\\d*?://authorize.*")) {
            int i = onAttributionFailure + 99;
            onResponse = i % 128;
            if ((i % 2 != 0 ? (char) 12 : 17) == 12) {
                str.contains("access_token");
                super.hashCode();
                throw r0;
            } else if (str.contains("access_token")) {
                String valueOf2 = valueOf(str);
                if (valueOf2.length() == 0) {
                    int i2 = onResponse + 23;
                    onAttributionFailure = i2 % 128;
                    if (i2 % 2 != 0) {
                        return str;
                    }
                    super.hashCode();
                    throw r0;
                }
                ArrayList arrayList = new ArrayList();
                if (valueOf2.contains("&")) {
                    arrayList = new ArrayList(Arrays.asList(valueOf2.split("&")));
                    int i3 = onResponse + 45;
                    onAttributionFailure = i3 % 128;
                    int i4 = i3 % 2;
                } else {
                    arrayList.add(valueOf2);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (true) {
                    if ((it.hasNext() ? 10 : ':') != 10) {
                        return str.replace(valueOf2, sb.toString());
                    }
                    String str2 = (String) it.next();
                    if (str2.contains("access_token")) {
                        it.remove();
                    } else {
                        if ((sb.length() != 0 ? '5' : ',') != ',') {
                            sb.append("&");
                        } else if (!str2.startsWith("?")) {
                            sb.append("?");
                        }
                        sb.append(str2);
                    }
                }
            }
        }
        return str;
    }

    private static String valueOf(String str) {
        int i = onResponse + 65;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        int indexOf = str.indexOf(63);
        if (!(indexOf == -1)) {
            return str.substring(indexOf);
        }
        int i3 = onAttributionFailure;
        int i4 = i3 + 121;
        onResponse = i4 % 128;
        int i5 = i4 % 2;
        int i6 = i3 + 69;
        onResponse = i6 % 128;
        int i7 = i6 % 2;
        return "";
    }

    private AFe1zSDK.AFa1zSDK values(final Map<String, String> map) {
        AnonymousClass1 r0 = new AFe1zSDK.AFa1zSDK() {
            public final void AFInAppEventType(Map<String, String> map) {
                for (String next : map.keySet()) {
                    map.put(next, map.get(next));
                }
                AFb1oSDK.valueOf(map);
            }

            public final void AFKeystoreWrapper(String str) {
                AFb1oSDK.values(str, DeepLinkResult.Error.NETWORK);
            }
        };
        int i = onResponse + 65;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? 'J' : 'L') != 'J') {
            return r0;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private static void AFKeystoreWrapper(Context context, Map<String, Object> map, String str) {
        int i = onResponse + 49;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        SharedPreferences valueOf2 = valueOf(context);
        SharedPreferences.Editor edit = valueOf2.edit();
        try {
            String string = valueOf2.getString("prev_event_name", (String) null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prev_event_timestamp", valueOf2.getLong("prev_event_timestamp", -1));
                jSONObject.put("prev_event_name", (Object) string);
                map.put("prev_event", jSONObject);
                int i3 = onAttributionFailure + 105;
                onResponse = i3 % 128;
                int i4 = i3 % 2;
            }
            edit.putString("prev_event_name", str).putLong("prev_event_timestamp", System.currentTimeMillis()).apply();
        } catch (Exception e) {
            AFLogger.afErrorLog("Error while processing previous event.", e);
        }
    }

    public static boolean AFKeystoreWrapper(Context context) {
        int i = onAttributionFailure + 41;
        onResponse = i % 128;
        if (i % 2 == 0) {
            try {
                if (!(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0 ? true : true)) {
                    return true;
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
            }
            try {
                context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                int i2 = onResponse + 97;
                onAttributionFailure = i2 % 128;
                if (i2 % 2 != 0) {
                    return true;
                }
                int i3 = 2 / 0;
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e);
                return false;
            }
        } else {
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            Throwable th2 = null;
            super.hashCode();
            throw th2;
        }
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void values(android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "use cached AndroidId: "
            int r1 = onResponse
            int r1 = r1 + 71
            int r2 = r1 % 128
            onAttributionFailure = r2
            int r1 = r1 % 2
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "deviceTrackingDisabled"
            r3 = 0
            boolean r4 = r1.getBoolean(r2, r3)
            r5 = 14
            if (r4 == 0) goto L_0x001d
            r4 = r5
            goto L_0x001f
        L_0x001d:
            r4 = 24
        L_0x001f:
            if (r4 == r5) goto L_0x0147
            com.appsflyer.internal.AFc1vSDK r2 = r10.AFKeystoreWrapper()
            com.appsflyer.internal.AFc1xSDK r2 = r2.afErrorLog()
            com.appsflyer.internal.AFc1vSDK r4 = r10.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1kSDK r4 = r4.afWarnLog()
            java.lang.String r4 = r4.AFKeystoreWrapper(r2)
            boolean r5 = com.appsflyer.internal.AFb1pSDK.valueOf(r4)
            if (r5 != 0) goto L_0x0055
            int r5 = onResponse
            int r5 = r5 + 13
            int r6 = r5 % 128
            onAttributionFailure = r6
            int r5 = r5 % 2
            java.lang.String r6 = "imei"
            if (r5 != 0) goto L_0x0052
            r12.put(r6, r4)
            r4 = 17
            int r4 = r4 / r3
            goto L_0x0055
        L_0x0050:
            r11 = move-exception
            throw r11
        L_0x0052:
            r12.put(r6, r4)
        L_0x0055:
            java.lang.String r4 = "collectAndroidId"
            boolean r1 = r1.getBoolean(r4, r3)
            java.lang.String r4 = "androidIdCached"
            r5 = 0
            java.lang.String r6 = r2.AFInAppEventType((java.lang.String) r4, (java.lang.String) r5)
            r7 = 1
            if (r1 == 0) goto L_0x0067
            r1 = r7
            goto L_0x0068
        L_0x0067:
            r1 = r3
        L_0x0068:
            java.lang.String r8 = "android_id"
            if (r1 == 0) goto L_0x00d1
            java.lang.String r1 = r10.afInfoLog
            boolean r1 = com.appsflyer.internal.AFb1pSDK.valueOf(r1)
            if (r1 == 0) goto L_0x00d1
            boolean r1 = afDebugLog((android.content.Context) r11)
            if (r1 == 0) goto L_0x00ed
            int r1 = onResponse
            int r1 = r1 + 55
            int r9 = r1 % 128
            onAttributionFailure = r9
            int r1 = r1 % 2
            android.content.ContentResolver r1 = r11.getContentResolver()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r8)     // Catch:{ Exception -> 0x00ae }
            if (r1 == 0) goto L_0x0090
            r9 = r7
            goto L_0x0091
        L_0x0090:
            r9 = r3
        L_0x0091:
            if (r9 == 0) goto L_0x0094
            goto L_0x00ee
        L_0x0094:
            if (r6 == 0) goto L_0x00ac
            int r1 = onResponse
            int r1 = r1 + 19
            int r9 = r1 % 128
            onAttributionFailure = r9
            int r1 = r1 % 2
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = r0.concat(r1)     // Catch:{ Exception -> 0x00ae }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ Exception -> 0x00ae }
            goto L_0x00cf
        L_0x00ac:
            r6 = r5
            goto L_0x00cf
        L_0x00ae:
            r1 = move-exception
            if (r6 == 0) goto L_0x00c7
            java.lang.String r9 = java.lang.String.valueOf(r6)
            java.lang.String r0 = r0.concat(r9)
            com.appsflyer.AFLogger.afDebugLog(r0)
            int r0 = onResponse
            int r0 = r0 + 119
            int r9 = r0 % 128
            onAttributionFailure = r9
            int r0 = r0 % 2
            goto L_0x00c8
        L_0x00c7:
            r6 = r5
        L_0x00c8:
            java.lang.String r0 = r1.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
        L_0x00cf:
            r1 = r6
            goto L_0x00ee
        L_0x00d1:
            java.lang.String r1 = r10.afInfoLog
            if (r1 == 0) goto L_0x00ed
            int r0 = onAttributionFailure
            int r0 = r0 + 9
            int r6 = r0 % 128
            onResponse = r6
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x00ea
            int r6 = r6 + 87
            int r0 = r6 % 128
            onAttributionFailure = r0
            int r6 = r6 % 2
            goto L_0x00ee
        L_0x00ea:
            throw r5     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r11 = move-exception
            throw r11
        L_0x00ed:
            r1 = r5
        L_0x00ee:
            r0 = 90
            if (r1 == 0) goto L_0x00f4
            r6 = r0
            goto L_0x00f6
        L_0x00f4:
            r6 = 32
        L_0x00f6:
            if (r6 == r0) goto L_0x00fe
            java.lang.String r0 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r0)
            goto L_0x0113
        L_0x00fe:
            int r0 = onResponse
            int r0 = r0 + 89
            int r6 = r0 % 128
            onAttributionFailure = r6
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x010b
            r3 = r7
        L_0x010b:
            if (r3 != 0) goto L_0x013b
            r2.AFKeystoreWrapper((java.lang.String) r4, (java.lang.String) r1)
            r12.put(r8, r1)
        L_0x0113:
            com.appsflyer.internal.AFc1qSDK$AFa1vSDK r11 = com.appsflyer.internal.AFa1bSDK.AFInAppEventParameterName(r11)
            if (r11 == 0) goto L_0x013a
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Boolean r1 = r11.AFKeystoreWrapper
            java.lang.String r2 = "isManual"
            r0.put(r2, r1)
            java.lang.String r1 = r11.AFInAppEventParameterName
            java.lang.String r2 = "val"
            r0.put(r2, r1)
            java.lang.Boolean r11 = r11.AFInAppEventType
            if (r11 == 0) goto L_0x0135
            java.lang.String r1 = "isLat"
            r0.put(r1, r11)
        L_0x0135:
            java.lang.String r11 = "oaid"
            r12.put(r11, r0)
        L_0x013a:
            return
        L_0x013b:
            r2.AFKeystoreWrapper((java.lang.String) r4, (java.lang.String) r1)
            r12.put(r8, r1)
            super.hashCode()     // Catch:{ all -> 0x0145 }
            throw r5     // Catch:{ all -> 0x0145 }
        L_0x0145:
            r11 = move-exception
            throw r11
        L_0x0147:
            java.lang.String r11 = "true"
            r12.put(r2, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(android.content.Context, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (AFKeystoreWrapper(r4) == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        if ((AFKeystoreWrapper(r4)) != true) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean afDebugLog(android.content.Context r4) {
        /*
            int r0 = onResponse
            int r0 = r0 + 85
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x001b
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 != 0) goto L_0x0034
            goto L_0x0025
        L_0x001b:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L_0x0034
        L_0x0025:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r0 = r3
            goto L_0x003f
        L_0x0034:
            int r0 = onResponse
            int r0 = r0 + 45
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            r0 = r2
        L_0x003f:
            if (r0 != 0) goto L_0x0080
            int r0 = onAttributionFailure
            int r0 = r0 + r2
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 32
            if (r0 == 0) goto L_0x0050
            r0 = r1
            goto L_0x0052
        L_0x0050:
            r0 = 26
        L_0x0052:
            if (r0 == r1) goto L_0x005b
            boolean r4 = AFKeystoreWrapper((android.content.Context) r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x0080
        L_0x005b:
            boolean r4 = AFKeystoreWrapper((android.content.Context) r4)
            r0 = 13
            int r0 = r0 / r3
            if (r4 != 0) goto L_0x0066
            r4 = r3
            goto L_0x0067
        L_0x0066:
            r4 = r2
        L_0x0067:
            if (r4 == r2) goto L_0x006a
            goto L_0x0080
        L_0x006a:
            int r4 = onResponse
            int r4 = r4 + 21
            int r0 = r4 % 128
            onAttributionFailure = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0077
            return r3
        L_0x0077:
            r4 = 0
            super.hashCode()     // Catch:{ all -> 0x007c }
            throw r4     // Catch:{ all -> 0x007c }
        L_0x007c:
            r4 = move-exception
            throw r4
        L_0x007e:
            r4 = move-exception
            throw r4
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.afDebugLog(android.content.Context):boolean");
    }

    private static boolean afRDLog(Context context) {
        int i = onResponse + 89;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? IOUtils.DIR_SEPARATOR_UNIX : 20) == 20) {
            if (valueOf(context).contains("appsFlyerCount")) {
                return false;
            }
            int i2 = onResponse + 71;
            onAttributionFailure = i2 % 128;
            int i3 = i2 % 2;
            return true;
        }
        valueOf(context).contains("appsFlyerCount");
        throw null;
    }

    private String AFLogger$LogLevel(Context context) {
        int i = onAttributionFailure + 43;
        onResponse = i % 128;
        int i2 = i % 2;
        SharedPreferences valueOf2 = valueOf(context);
        String str = null;
        if ((valueOf2.contains("INSTALL_STORE") ? '4' : 'V') != 'V') {
            String string = valueOf2.getString("INSTALL_STORE", (String) null);
            int i3 = onResponse + 111;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
            return string;
        }
        if ((afRDLog(context) ? 'L' : '_') != '_') {
            str = getLevel(context);
        }
        values(context).AFKeystoreWrapper("INSTALL_STORE", str);
        return str;
    }

    private String getLevel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            int i = onAttributionFailure + 89;
            onResponse = i % 128;
            if ((i % 2 != 0 ? 'K' : '9') != 'K') {
                return string;
            }
            int i2 = 10 / 0;
            return string;
        }
        String values2 = values(context, "AF_STORE");
        int i3 = onAttributionFailure + 19;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? '-' : '1') == '1') {
            return values2;
        }
        int i4 = 69 / 0;
        return values2;
    }

    private static String AFInAppEventParameterName(String str) {
        Object invoke;
        int i = onAttributionFailure + 17;
        onResponse = i % 128;
        String str2 = null;
        if ((i % 2 != 0 ? '4' : '5') != '5') {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Class[] clsArr = new Class[1];
                clsArr[1] = String.class;
                Method method = cls.getMethod("get", clsArr);
                Object[] objArr = new Object[0];
                objArr[1] = str;
                invoke = method.invoke((Object) null, objArr);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        } else {
            invoke = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        }
        str2 = (String) invoke;
        int i2 = onResponse + 49;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        return str2;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private String values(Context context, String str) {
        int i = onAttributionFailure + 23;
        int i2 = i % 128;
        onResponse = i2;
        int i3 = i % 2;
        if (context != null) {
            AFInAppEventType(context);
            String valueOf2 = AFKeystoreWrapper().AFInAppEventParameterName().valueOf(str);
            int i4 = onAttributionFailure + 65;
            onResponse = i4 % 128;
            int i5 = i4 % 2;
            return valueOf2;
        }
        int i6 = i2 + 117;
        int i7 = i6 % 128;
        onAttributionFailure = i7;
        char c = i6 % 2 == 0 ? 20 : Typography.amp;
        ? r1 = 0;
        if (c != 20) {
            int i8 = i7 + 37;
            onResponse = i8 % 128;
            int i9 = i8 % 2;
            return r1;
        }
        super.hashCode();
        throw r1;
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("pid", (Object) str);
                int i = onAttributionFailure + 19;
                onResponse = i % 128;
                int i2 = i % 2;
            } catch (JSONException e) {
                AFLogger.afErrorLog(e.getMessage(), e);
            }
        }
        boolean z = false;
        if (!(str2 == null)) {
            jSONObject.put("c", (Object) str2);
        }
        if (str3 == null) {
            z = true;
        }
        if (!z) {
            jSONObject.put("af_siteid", (Object) str3);
            int i3 = onAttributionFailure + 39;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
        }
        if (jSONObject.has("pid")) {
            int i5 = onResponse + 103;
            onAttributionFailure = i5 % 128;
            int i6 = i5 % 2;
            valueOf("preInstallName", jSONObject.toString());
            int i7 = onResponse + 19;
            onAttributionFailure = i7 % 128;
            int i8 = i7 % 2;
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    private static void values(String str) {
        try {
            if (!(new JSONObject(str).has("pid"))) {
                AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                int i = onResponse + 121;
                onAttributionFailure = i % 128;
                int i2 = i % 2;
                return;
            }
            int i3 = onAttributionFailure + 103;
            onResponse = i3 % 128;
            if ((i3 % 2 != 0 ? 'J' : ',') == ',') {
                valueOf("preInstallName", str);
            } else {
                valueOf("preInstallName", str);
                throw null;
            }
        } catch (JSONException e) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
        }
    }

    private String afWarnLog(Context context) {
        File afDebugLog2 = afDebugLog(AFInAppEventParameterName("ro.appsflyer.preinstall.path"));
        if (AFInAppEventType(afDebugLog2)) {
            afDebugLog2 = afDebugLog(values(context, "AF_PRE_INSTALL_PATH"));
        }
        if (AFInAppEventType(afDebugLog2)) {
            afDebugLog2 = afDebugLog("/data/local/tmp/pre_install.appsflyer");
        }
        if ((AFInAppEventType(afDebugLog2) ? '7' : 31) == '7') {
            int i = onResponse + 49;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            afDebugLog2 = afDebugLog("/etc/pre_install.appsflyer");
        }
        if (!AFInAppEventType(afDebugLog2)) {
            return AFInAppEventType(afDebugLog2, context.getPackageName());
        }
        int i3 = onAttributionFailure + 103;
        onResponse = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0059 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[SYNTHETIC, Splitter:B:26:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0089 A[SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0042=Splitter:B:23:0x0042, B:32:0x0059=Splitter:B:32:0x0059} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventType(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x0058, all -> 0x0040 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0058, all -> 0x0040 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0058, all -> 0x0040 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0058, all -> 0x0040 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x0059, all -> 0x003e }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x0059, all -> 0x003e }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x0059, all -> 0x003e }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            int r5 = onResponse
            r0 = 29
            int r5 = r5 + r0
            int r1 = r5 % 128
            onAttributionFailure = r1
            int r5 = r5 % 2
            r1 = 20
            if (r5 != 0) goto L_0x0034
            r5 = r1
            goto L_0x0036
        L_0x0034:
            r5 = 62
        L_0x0036:
            if (r5 == r1) goto L_0x0039
            return r4
        L_0x0039:
            int r0 = r0 / 0
            return r4
        L_0x003c:
            r4 = move-exception
            throw r4
        L_0x003e:
            r4 = move-exception
            goto L_0x0042
        L_0x0040:
            r4 = move-exception
            r2 = r0
        L_0x0042:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ all -> 0x004f }
            goto L_0x0074
        L_0x004f:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x0074
        L_0x0058:
            r2 = r0
        L_0x0059:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ all -> 0x004f }
        L_0x0074:
            int r4 = onAttributionFailure
            int r4 = r4 + 11
            int r5 = r4 % 128
            onResponse = r5
            int r4 = r4 % 2
            r5 = 71
            if (r4 == 0) goto L_0x0085
            r4 = 49
            goto L_0x0086
        L_0x0085:
            r4 = r5
        L_0x0086:
            if (r4 != r5) goto L_0x0089
            return r0
        L_0x0089:
            super.hashCode()     // Catch:{ all -> 0x008d }
            throw r0     // Catch:{ all -> 0x008d }
        L_0x008d:
            r4 = move-exception
            throw r4
        L_0x008f:
            r4 = move-exception
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ all -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x009e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(java.io.File, java.lang.String):java.lang.String");
    }

    private static boolean AFInAppEventType(File file) {
        int i = onAttributionFailure + 69;
        onResponse = i % 128;
        if (i % 2 == 0) {
            if (file != null) {
                if (file.exists()) {
                    int i2 = onAttributionFailure + 93;
                    onResponse = i2 % 128;
                    int i3 = i2 % 2;
                    return false;
                }
            }
            return true;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private static File afDebugLog(String str) {
        int i = onAttributionFailure + 93;
        int i2 = i % 128;
        onResponse = i2;
        int i3 = i % 2;
        if ((str != null ? '9' : 16) != '9') {
            return null;
        }
        int i4 = i2 + 107;
        onAttributionFailure = i4 % 128;
        int i5 = i4 % 2;
        try {
            if (str.trim().length() <= 0) {
                return null;
            }
            File file = new File(str.trim());
            int i6 = onAttributionFailure + 7;
            onResponse = i6 % 128;
            if (i6 % 2 == 0) {
                return file;
            }
            int i7 = 71 / 0;
            return file;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private String AFVersionDeclaration(Context context) {
        String str;
        SharedPreferences valueOf2 = valueOf(context);
        String AFInAppEventType2 = AFInAppEventType("preInstallName");
        if ((AFInAppEventType2 != null ? (char) 28 : 9) != 9) {
            return AFInAppEventType2;
        }
        ? r5 = 0;
        if ((valueOf2.contains("preInstallName") ? 21 : '?') != '?') {
            str = valueOf2.getString("preInstallName", r5);
        } else {
            if ((afRDLog(context) ? 'D' : 18) == 'D') {
                int i = onAttributionFailure + 107;
                onResponse = i % 128;
                int i2 = i % 2;
                AFInAppEventType2 = afWarnLog(context);
                if (AFInAppEventType2 == null) {
                    AFInAppEventType2 = values(context, "AF_PRE_INSTALL_NAME");
                } else {
                    int i3 = onResponse + 19;
                    onAttributionFailure = i3 % 128;
                    if ((i3 % 2 == 0 ? '=' : '2') == '=') {
                        super.hashCode();
                        throw r5;
                    }
                }
            }
            if (AFInAppEventType2 != null) {
                values(context).AFKeystoreWrapper("preInstallName", AFInAppEventType2);
            }
            str = AFInAppEventType2;
        }
        if (str != null) {
            valueOf("preInstallName", str);
        }
        return str;
    }

    @Deprecated
    public final String AFInAppEventParameterName(Context context) {
        int i = onAttributionFailure + 97;
        onResponse = i % 128;
        int i2 = i % 2;
        AFInAppEventType(context);
        String values2 = AFKeystoreWrapper().AFInAppEventParameterName().values();
        int i3 = onResponse + 125;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
        return values2;
    }

    public final boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                int i = onAttributionFailure + 111;
                onResponse = i % 128;
                int i2 = i % 2;
                return true;
            }
            int i3 = onAttributionFailure + 105;
            onResponse = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e);
        }
    }

    public static String values(AFc1xSDK aFc1xSDK, String str) {
        String AFInAppEventType2 = aFc1xSDK.AFInAppEventType("CACHED_CHANNEL", (String) null);
        if ((AFInAppEventType2 != null ? (char) 11 : 23) != 23) {
            int i = onAttributionFailure;
            int i2 = i + 95;
            onResponse = i2 % 128;
            int i3 = i2 % 2;
            int i4 = i + 59;
            onResponse = i4 % 128;
            int i5 = i4 % 2;
            return AFInAppEventType2;
        }
        aFc1xSDK.AFKeystoreWrapper("CACHED_CHANNEL", str);
        return str;
    }

    private String AFKeystoreWrapper(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        int i = onResponse + 27;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        String string = valueOf(context).getString("appsFlyerFirstInstall", (String) null);
        if ((string == null ? '(' : 'Y') != 'Y') {
            if (afRDLog(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                int i3 = onAttributionFailure + 51;
                onResponse = i3 % 128;
                int i4 = i3 % 2;
                str = "";
            }
            string = str;
            values(context).AFKeystoreWrapper("appsFlyerFirstInstall", string);
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public final String getAttributionId(Context context) {
        try {
            String AFKeystoreWrapper2 = new AFa1aSDK(context, AFKeystoreWrapper()).AFKeystoreWrapper();
            int i = onAttributionFailure + 13;
            onResponse = i % 128;
            if ((i % 2 != 0 ? '_' : 23) != '_') {
                return AFKeystoreWrapper2;
            }
            int i2 = 25 / 0;
            return AFKeystoreWrapper2;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public static synchronized SharedPreferences valueOf(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (AFb1xSDK.class) {
            int i = onResponse + 71;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            if ((AFInAppEventType().onResponseErrorNative == null ? 'T' : 'S') != 'S') {
                AFInAppEventType().onResponseErrorNative = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                int i3 = onResponse + 83;
                onAttributionFailure = i3 % 128;
                if (i3 % 2 == 0) {
                }
            }
            sharedPreferences = AFInAppEventType().onResponseErrorNative;
        }
        return sharedPreferences;
    }

    public final AFc1xSDK values(Context context) {
        int i = onResponse + 29;
        onAttributionFailure = i % 128;
        if (!(i % 2 == 0)) {
            AFInAppEventType(context);
            return AFKeystoreWrapper().afErrorLog();
        }
        AFInAppEventType(context);
        AFKeystoreWrapper().afErrorLog();
        throw null;
    }

    public final int AFKeystoreWrapper(SharedPreferences sharedPreferences, boolean z) {
        int i = onResponse + 47;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? '0' : 'B') != '0') {
            int AFInAppEventType2 = AFInAppEventType(sharedPreferences, "appsFlyerCount", z);
            int i2 = onAttributionFailure + 1;
            onResponse = i2 % 128;
            int i3 = i2 % 2;
            return AFInAppEventType2;
        }
        AFInAppEventType(sharedPreferences, "appsFlyerCount", z);
        throw null;
    }

    private int values(SharedPreferences sharedPreferences, boolean z) {
        int i = onResponse + 65;
        onAttributionFailure = i % 128;
        if (i % 2 != 0) {
            int AFInAppEventType2 = AFInAppEventType(sharedPreferences, "appsFlyerInAppEventCount", z);
            int i2 = onResponse + 95;
            onAttributionFailure = i2 % 128;
            int i3 = i2 % 2;
            return AFInAppEventType2;
        }
        AFInAppEventType(sharedPreferences, "appsFlyerInAppEventCount", z);
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if ((r7 ? (char) 23 : 3) != 3) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r7 != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFInAppEventType(android.content.SharedPreferences r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            int r0 = onResponse
            int r0 = r0 + 123
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            r1 = 13
            if (r0 != 0) goto L_0x0011
            r0 = 17
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            r2 = 0
            r3 = 3
            if (r0 == r1) goto L_0x0023
            int r0 = r5.getInt(r6, r2)
            if (r7 == 0) goto L_0x001f
            r7 = 23
            goto L_0x0020
        L_0x001f:
            r7 = r3
        L_0x0020:
            if (r7 == r3) goto L_0x003f
            goto L_0x0029
        L_0x0023:
            int r0 = r5.getInt(r6, r2)
            if (r7 == 0) goto L_0x003f
        L_0x0029:
            int r0 = r0 + 1
            android.content.SharedPreferences$Editor r5 = r5.edit()
            android.content.SharedPreferences$Editor r5 = r5.putInt(r6, r0)
            r5.apply()
            int r5 = onResponse
            int r5 = r5 + r3
            int r6 = r5 % 128
            onAttributionFailure = r6
            int r5 = r5 % 2
        L_0x003f:
            com.appsflyer.internal.AFc1vSDK r5 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r5 = r5.AFVersionDeclaration()
            boolean r5 = r5.afInfoLog()
            r6 = 34
            if (r5 == 0) goto L_0x0052
            r5 = 49
            goto L_0x0053
        L_0x0052:
            r5 = r6
        L_0x0053:
            if (r5 == r6) goto L_0x0078
            int r5 = onAttributionFailure
            int r5 = r5 + 117
            int r6 = r5 % 128
            onResponse = r6
            int r5 = r5 % 2
            com.appsflyer.internal.AFc1vSDK r5 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r5 = r5.AFVersionDeclaration()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            r5.AFInAppEventParameterName(r6)
            int r5 = onAttributionFailure
            int r5 = r5 + 119
            int r6 = r5 % 128
            onResponse = r6
            int r5 = r5 % 2
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(android.content.SharedPreferences, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r11 = onResponse + 65;
        onAttributionFailure = r11 % 128;
        r11 = r11 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        if ((r6 > 1) != true) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        if (r6 > 0) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long afErrorLogForExcManagerOnly(android.content.Context r11) {
        /*
            r10 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 91
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "AppsFlyerTimePassedSincePrevLaunch"
            if (r0 == 0) goto L_0x002f
            android.content.SharedPreferences r0 = valueOf((android.content.Context) r11)
            r4 = 1
            long r6 = r0.getLong(r3, r4)
            long r8 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1xSDK r11 = r10.values((android.content.Context) r11)
            r11.AFInAppEventType((java.lang.String) r3, (long) r8)
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x002b
            r11 = r2
            goto L_0x002c
        L_0x002b:
            r11 = r1
        L_0x002c:
            if (r11 == r2) goto L_0x0048
            goto L_0x005f
        L_0x002f:
            android.content.SharedPreferences r0 = valueOf((android.content.Context) r11)
            r4 = 0
            long r6 = r0.getLong(r3, r4)
            long r8 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1xSDK r11 = r10.values((android.content.Context) r11)
            r11.AFInAppEventType((java.lang.String) r3, (long) r8)
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x005f
        L_0x0048:
            long r8 = r8 - r6
            int r11 = onAttributionFailure
            int r11 = r11 + 99
            int r0 = r11 % 128
            onResponse = r0
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r1 = r2
        L_0x0057:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r1 == r2) goto L_0x005d
            long r8 = r8 + r3
            return r8
        L_0x005d:
            long r8 = r8 / r3
            return r8
        L_0x005f:
            r0 = -1
            int r11 = onResponse
            int r11 = r11 + 65
            int r2 = r11 % 128
            onAttributionFailure = r2
            int r11 = r11 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.afErrorLogForExcManagerOnly(android.content.Context):long");
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String str6;
        Context context2 = context;
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str7;
        strArr[3] = str8;
        strArr[4] = str9;
        if (map == null) {
            str6 = "";
        } else {
            str6 = map.toString();
        }
        strArr[5] = str6;
        AFVersionDeclaration2.values("validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            AFLogger.afInfoLog(new StringBuilder("Validate in app called with parameters: ").append(str7).append(" ").append(str8).append(" ").append(str9).toString());
        }
        if (str == null || str8 == null || str2 == null || str9 == null || str7 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFInAppEventType;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        new Thread(new AFa1fSDK(context.getApplicationContext(), AFKeystoreWrapper().afWarnLog().AFInAppEventType, str, str2, str3, str4, str5, map, context2 instanceof Activity ? ((Activity) context2).getIntent() : null)).start();
    }

    private static void AFInAppEventParameterName(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        int i = onResponse + 91;
        onAttributionFailure = i % 128;
        if ((i % 2 == 0 ? 'C' : 'H') != 'C') {
            try {
                scheduledExecutorService.schedule(runnable, j, timeUnit);
            } catch (RejectedExecutionException e) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e);
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
            }
        } else {
            scheduledExecutorService.schedule(runnable, j, timeUnit);
            Throwable th2 = null;
            super.hashCode();
            throw th2;
        }
    }

    @Deprecated
    public final boolean isStopped() {
        int i = onAttributionFailure + 25;
        onResponse = i % 128;
        int i2 = i % 2;
        boolean valueOf2 = AFKeystoreWrapper().afWarnLog().valueOf();
        int i3 = onResponse + 59;
        onAttributionFailure = i3 % 128;
        int i4 = i3 % 2;
        return valueOf2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        if ((r6) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6 A[SYNTHETIC, Splitter:B:47:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ae A[Catch:{ all -> 0x00aa }] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String valueOf(java.net.HttpURLConnection r12) {
        /*
            java.lang.String r0 = "readServerResponse error"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.InputStream r3 = r12.getErrorStream()     // Catch:{ all -> 0x0088 }
            if (r3 != 0) goto L_0x001c
            java.io.InputStream r3 = r12.getInputStream()     // Catch:{ all -> 0x0088 }
            int r4 = onAttributionFailure
            int r4 = r4 + 57
            int r5 = r4 % 128
            onResponse = r5
            int r4 = r4 % 2
        L_0x001c:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0088 }
            r4.<init>(r3)     // Catch:{ all -> 0x0088 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0086 }
            r3.<init>(r4)     // Catch:{ all -> 0x0086 }
            r2 = 1
            r5 = 0
            r6 = r5
        L_0x0029:
            java.lang.String r7 = r3.readLine()     // Catch:{ all -> 0x0081 }
            r8 = 21
            if (r7 == 0) goto L_0x0034
            r9 = 18
            goto L_0x0035
        L_0x0034:
            r9 = r8
        L_0x0035:
            if (r9 == r8) goto L_0x0070
            int r9 = onResponse
            int r9 = r9 + 79
            int r10 = r9 % 128
            onAttributionFailure = r10
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x0045
            r9 = r2
            goto L_0x0046
        L_0x0045:
            r9 = r5
        L_0x0046:
            if (r9 == 0) goto L_0x004e
            r9 = 59
            int r9 = r9 / r5
            if (r6 == 0) goto L_0x005c
            goto L_0x0055
        L_0x004e:
            if (r6 == 0) goto L_0x0052
            r6 = r2
            goto L_0x0053
        L_0x0052:
            r6 = r5
        L_0x0053:
            if (r6 == 0) goto L_0x005c
        L_0x0055:
            r6 = 10
            java.lang.Character r6 = java.lang.Character.valueOf(r6)     // Catch:{ all -> 0x0081 }
            goto L_0x005e
        L_0x005c:
            java.lang.String r6 = ""
        L_0x005e:
            java.lang.StringBuilder r6 = r1.append(r6)     // Catch:{ all -> 0x0081 }
            r6.append(r7)     // Catch:{ all -> 0x0081 }
            int r6 = onAttributionFailure
            int r6 = r6 + r8
            int r7 = r6 % 128
            onResponse = r7
            int r6 = r6 % 2
            r6 = r2
            goto L_0x0029
        L_0x0070:
            r3.close()     // Catch:{ all -> 0x00aa }
            r4.close()     // Catch:{ all -> 0x00aa }
            int r12 = onResponse
            int r12 = r12 + 113
            int r0 = r12 % 128
            onAttributionFailure = r0
            int r12 = r12 % 2
            goto L_0x00b5
        L_0x0081:
            r2 = move-exception
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x008a
        L_0x0086:
            r3 = move-exception
            goto L_0x008a
        L_0x0088:
            r3 = move-exception
            r4 = r2
        L_0x008a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = "Could not read connection response from: "
            r5.<init>(r6)     // Catch:{ all -> 0x00e4 }
            java.net.URL r12 = r12.getURL()     // Catch:{ all -> 0x00e4 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r12 = r5.append(r12)     // Catch:{ all -> 0x00e4 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00e4 }
            com.appsflyer.AFLogger.afErrorLog(r12, r3)     // Catch:{ all -> 0x00e4 }
            if (r2 == 0) goto L_0x00ac
            r2.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00ac
        L_0x00aa:
            r12 = move-exception
            goto L_0x00b2
        L_0x00ac:
            if (r4 == 0) goto L_0x00b5
            r4.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00b5
        L_0x00b2:
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r12)
        L_0x00b5:
            java.lang.String r12 = r1.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00bf }
            r0.<init>((java.lang.String) r12)     // Catch:{ JSONException -> 0x00bf }
            return r12
        L_0x00bf:
            r0 = move-exception
            java.lang.String r1 = "error while parsing readServerResponse"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put((java.lang.String) r1, (java.lang.Object) r12)     // Catch:{ JSONException -> 0x00d4 }
            java.lang.String r12 = r0.toString()     // Catch:{ JSONException -> 0x00d4 }
            return r12
        L_0x00d4:
            r12 = move-exception
            java.lang.String r0 = "RESPONSE_NOT_JSON error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r12 = r12.toString()
            return r12
        L_0x00e4:
            r12 = move-exception
            if (r2 == 0) goto L_0x00ed
            r2.close()     // Catch:{ all -> 0x00eb }
            goto L_0x00ed
        L_0x00eb:
            r1 = move-exception
            goto L_0x00fc
        L_0x00ed:
            r1 = 27
            if (r4 == 0) goto L_0x00f3
            r2 = r1
            goto L_0x00f5
        L_0x00f3:
            r2 = 85
        L_0x00f5:
            if (r2 == r1) goto L_0x00f8
            goto L_0x00ff
        L_0x00f8:
            r4.close()     // Catch:{ all -> 0x00eb }
            goto L_0x00ff
        L_0x00fc:
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x00ff:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.valueOf(java.net.HttpURLConnection):java.lang.String");
    }

    private static boolean onInstallConversionFailureNative(Context context) {
        ConnectivityManager connectivityManager;
        int i;
        Network[] networkArr;
        if ((context != null ? '6' : 1) != 1) {
            int i2 = onResponse + 69;
            onAttributionFailure = i2 % 128;
            int i3 = i2 % 2;
            if (Build.VERSION.SDK_INT >= 23) {
                int i4 = onAttributionFailure + 59;
                onResponse = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    try {
                        connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        networkArr = connectivityManager.getAllNetworks();
                        i = networkArr.length;
                    } catch (Exception e) {
                        AFLogger.afErrorLog("Failed collecting ivc data", e);
                    }
                } else {
                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    networkArr = connectivityManager.getAllNetworks();
                    i = networkArr.length;
                }
                for (int i5 = 0; i5 < i; i5++) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(networkArr[i5]);
                    if ((networkCapabilities.hasTransport(4) ? '=' : 21) != 21) {
                        if (!networkCapabilities.hasCapability(15)) {
                            int i6 = onAttributionFailure + 27;
                            onResponse = i6 % 128;
                            int i7 = i6 % 2;
                            return true;
                        }
                    }
                }
                return false;
            } else if (Build.VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (true) {
                        if ((it.hasNext() ? 21 : CharUtils.CR) != 21) {
                            return arrayList.contains("tun0");
                        }
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        com.appsflyer.AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (com.appsflyer.internal.AFb1pSDK.AFKeystoreWrapper(r4) == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (com.appsflyer.internal.AFb1pSDK.AFKeystoreWrapper(r4) == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setHost(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 65
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0019
            boolean r0 = com.appsflyer.internal.AFb1pSDK.AFKeystoreWrapper(r4)
            r1 = 62
            int r1 = r1 / 0
            if (r0 != 0) goto L_0x005e
            goto L_0x001f
        L_0x0017:
            r3 = move-exception
            throw r3
        L_0x0019:
            boolean r0 = com.appsflyer.internal.AFb1pSDK.AFKeystoreWrapper(r4)
            if (r0 != 0) goto L_0x005e
        L_0x001f:
            if (r3 == 0) goto L_0x004f
            int r0 = onAttributionFailure
            int r0 = r0 + 103
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 16
            if (r0 == 0) goto L_0x0032
            r0 = 68
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 == r1) goto L_0x0040
            java.lang.String r3 = r3.trim()
            r0 = 63
            int r0 = r0 / 0
            goto L_0x0044
        L_0x003e:
            r3 = move-exception
            throw r3
        L_0x0040:
            java.lang.String r3 = r3.trim()
        L_0x0044:
            int r0 = onResponse
            int r0 = r0 + 77
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            goto L_0x0051
        L_0x004f:
            java.lang.String r3 = ""
        L_0x0051:
            com.appsflyer.internal.AFd1zSDK r0 = new com.appsflyer.internal.AFd1zSDK
            java.lang.String r4 = r4.trim()
            r0.<init>(r3, r4)
            com.appsflyer.internal.AFd1xSDK.values(r0)
            return
        L_0x005e:
            java.lang.String r3 = "hostname was empty or null - call for setHost is skipped"
            com.appsflyer.AFLogger.afWarnLog(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.setHost(java.lang.String, java.lang.String):void");
    }

    public final String getHostName() {
        int i = onAttributionFailure + 5;
        onResponse = i % 128;
        int i2 = i % 2;
        String AFInAppEventParameterName2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative().AFInAppEventParameterName();
        int i3 = onAttributionFailure + 111;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? 3 : '_') != 3) {
            return AFInAppEventParameterName2;
        }
        throw null;
    }

    public final String getHostPrefix() {
        int i = onResponse + 99;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        String values2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative().values();
        int i3 = onAttributionFailure + 77;
        onResponse = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return values2;
        }
        throw null;
    }

    public final void setMinTimeBetweenSessions(int i) {
        int i2 = onResponse + 91;
        onAttributionFailure = i2 % 128;
        int i3 = i2 % 2;
        this.afWarnLog = TimeUnit.SECONDS.toMillis((long) i);
        int i4 = onResponse + 3;
        onAttributionFailure = i4 % 128;
        if ((i4 % 2 == 0 ? 'K' : ' ') == 'K') {
            int i5 = 42 / 0;
        }
    }

    private AFf1jSDK[] AFVersionDeclaration() {
        int i = onResponse + 87;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        AFf1jSDK[] AFInAppEventParameterName2 = AFKeystoreWrapper().getLevel().AFInAppEventParameterName();
        int i3 = onAttributionFailure + 7;
        onResponse = i3 % 128;
        if ((i3 % 2 != 0 ? 20 : '4') != 20) {
            return AFInAppEventParameterName2;
        }
        int i4 = 28 / 0;
        return AFInAppEventParameterName2;
    }

    class AFa1vSDK implements Runnable {
        private final AFa1sSDK valueOf;

        /* synthetic */ AFa1vSDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b) {
            this(aFa1sSDK);
        }

        private AFa1vSDK(AFa1sSDK aFa1sSDK) {
            this.valueOf = aFa1sSDK;
        }

        public final void run() {
            AFb1xSDK.AFKeystoreWrapper(AFb1xSDK.this, this.valueOf);
        }
    }

    class AFa1ySDK implements Runnable {
        private final AFa1sSDK AFInAppEventType;

        /* synthetic */ AFa1ySDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b) {
            this(aFa1sSDK);
        }

        private AFa1ySDK(AFa1sSDK aFa1sSDK) {
            this.AFInAppEventType = aFa1sSDK;
        }

        public final void run() {
            AFd1dSDK aFd1dSDK;
            if (this.AFInAppEventType.AFInAppEventParameterName()) {
                AFd1dSDK aFd1dSDK2 = new AFd1dSDK(this.AFInAppEventType, AFb1xSDK.this.AFKeystoreWrapper());
                aFd1dSDK2.afWarnLog = AFb1xSDK.values(AFb1xSDK.this);
                aFd1dSDK = aFd1dSDK2;
            } else {
                aFd1dSDK = new AFd1cSDK(this.AFInAppEventType, AFb1xSDK.this.AFKeystoreWrapper());
            }
            AFd1pSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
            afDebugLog.AFKeystoreWrapper.execute(new Runnable(aFd1dSDK) {
                private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
    }

    public final void setPluginInfo(PluginInfo pluginInfo) {
        int i = onAttributionFailure + 77;
        onResponse = i % 128;
        if (i % 2 == 0) {
            Objects.requireNonNull(pluginInfo);
            AFKeystoreWrapper().init().AFKeystoreWrapper(pluginInfo);
            return;
        }
        Objects.requireNonNull(pluginInfo);
        AFKeystoreWrapper().init().AFKeystoreWrapper(pluginInfo);
        throw null;
    }

    class AFa1zSDK implements AFd1wSDK {
        public final void AFInAppEventType(AFd1qSDK<?> aFd1qSDK) {
        }

        private AFa1zSDK() {
        }

        /* synthetic */ AFa1zSDK(AFb1xSDK aFb1xSDK, byte b) {
            this();
        }

        public final void AFInAppEventParameterName(AFd1qSDK<?> aFd1qSDK) {
            if (aFd1qSDK instanceof AFd1dSDK) {
                AFb1xSDK.this.AFKeystoreWrapper().AFLogger().AFInAppEventParameterName(((AFd1cSDK) aFd1qSDK).afRDLog.afInfoLog);
            }
        }

        public final void valueOf(AFd1qSDK<?> aFd1qSDK, AFd1tSDK aFd1tSDK) {
            JSONObject AFInAppEventParameterName2;
            AFb1tSDK valueOf;
            if (aFd1qSDK instanceof AFd1cSDK) {
                AFd1cSDK aFd1cSDK = (AFd1cSDK) aFd1qSDK;
                boolean z = aFd1qSDK instanceof AFd1dSDK;
                if (z && AFInAppEventType()) {
                    AFd1dSDK aFd1dSDK = (AFd1dSDK) aFd1qSDK;
                    boolean z2 = true;
                    if (!(aFd1dSDK.AFInAppEventType == AFd1tSDK.SUCCESS || aFd1dSDK.AFInAppEventParameterName == 1)) {
                        z2 = false;
                    }
                    if (z2) {
                        AFe1hSDK aFe1hSDK = new AFe1hSDK(aFd1dSDK, AFb1xSDK.this.AFKeystoreWrapper().afErrorLog());
                        AFd1pSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                        afDebugLog.AFKeystoreWrapper.execute(new Runnable(aFe1hSDK) {
                            private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                            /*  JADX ERROR: Method generation error
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                */
                            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                */
                            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        });
                    }
                }
                if (aFd1tSDK == AFd1tSDK.SUCCESS) {
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    aFb1xSDK.values((Context) AFb1xSDK.valueOf(aFb1xSDK)).AFKeystoreWrapper("sentSuccessfully", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    if (!(aFd1qSDK instanceof AFd1bSDK) && (valueOf = new AFe1mSDK(AFb1xSDK.valueOf(AFb1xSDK.this)).valueOf()) != null && valueOf.AFInAppEventParameterName()) {
                        String str = valueOf.AFKeystoreWrapper;
                        AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFe1mSDK.AFKeystoreWrapper(str);
                    }
                    AFc1aSDK<Result> aFc1aSDK = aFd1cSDK.afInfoLog;
                    if (!(aFc1aSDK == null || (AFInAppEventParameterName2 = AFb1nSDK.AFInAppEventParameterName((String) aFc1aSDK.getBody())) == null)) {
                        AFb1xSDK.values(AFb1xSDK.this, AFInAppEventParameterName2.optBoolean("send_background", false));
                    }
                    if (z) {
                        AFb1xSDK.values(AFb1xSDK.this, System.currentTimeMillis());
                    }
                }
            } else if ((aFd1qSDK instanceof AFe1hSDK) && aFd1tSDK != AFd1tSDK.SUCCESS) {
                AFe1lSDK aFe1lSDK = new AFe1lSDK(AFb1xSDK.this.AFKeystoreWrapper());
                AFd1pSDK afDebugLog2 = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFe1lSDK) {
                    private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        */
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        */
                    public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                });
            }
        }

        private static boolean AFInAppEventType() {
            return AFb1xSDK.valueOf != null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r3.AFKeystoreWrapper(r4, r5, com.android.billingclient.api.BillingClient.FeatureType.SUBSCRIPTIONS) != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r3.AFKeystoreWrapper(r4, r5, com.android.billingclient.api.BillingClient.FeatureType.SUBSCRIPTIONS) != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPurchaseData(android.content.Context r3, java.util.Map<java.lang.String, java.lang.Object> r4, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r5) {
        /*
            r2 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 53
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x000e
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            java.lang.String r1 = "subscriptions"
            if (r0 == 0) goto L_0x0029
            r2.AFInAppEventType((android.content.Context) r3)
            com.appsflyer.internal.AFc1vSDK r3 = r2.AFKeystoreWrapper()
            com.appsflyer.PurchaseHandler r3 = r3.afInfoLog()
            java.lang.String[] r0 = new java.lang.String[]{r1}
            boolean r0 = r3.AFKeystoreWrapper(r4, r5, r0)
            if (r0 == 0) goto L_0x0051
            goto L_0x003e
        L_0x0029:
            r2.AFInAppEventType((android.content.Context) r3)
            com.appsflyer.internal.AFc1vSDK r3 = r2.AFKeystoreWrapper()
            com.appsflyer.PurchaseHandler r3 = r3.afInfoLog()
            java.lang.String[] r0 = new java.lang.String[]{r1}
            boolean r0 = r3.AFKeystoreWrapper(r4, r5, r0)
            if (r0 == 0) goto L_0x0051
        L_0x003e:
            com.appsflyer.internal.AFd1mSDK r0 = new com.appsflyer.internal.AFd1mSDK
            com.appsflyer.internal.AFc1vSDK r1 = r3.valueOf
            r0.<init>(r4, r5, r1)
            com.appsflyer.internal.AFd1pSDK r3 = r3.values
            java.util.concurrent.Executor r4 = r3.AFKeystoreWrapper
            com.appsflyer.internal.AFd1pSDK$5 r5 = new com.appsflyer.internal.AFd1pSDK$5
            r5.<init>(r0)
            r4.execute(r5)
        L_0x0051:
            int r3 = onAttributionFailure
            int r3 = r3 + 41
            int r4 = r3 % 128
            onResponse = r4
            int r3 = r3 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.sendPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r4.AFKeystoreWrapper(r5, r6, r1) != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r4.AFKeystoreWrapper(r5, r6, "purchases") != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendInAppPurchaseData(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r6) {
        /*
            r3 = this;
            int r0 = onAttributionFailure
            int r0 = r0 + 87
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            r1 = 28
            if (r0 == 0) goto L_0x0011
            r0 = 50
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            java.lang.String r2 = "purchases"
            if (r0 == r1) goto L_0x002d
            r3.AFInAppEventType((android.content.Context) r4)
            com.appsflyer.internal.AFc1vSDK r4 = r3.AFKeystoreWrapper()
            com.appsflyer.PurchaseHandler r4 = r4.afInfoLog()
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            r1[r0] = r2
            boolean r0 = r4.AFKeystoreWrapper(r5, r6, r1)
            if (r0 == 0) goto L_0x0055
            goto L_0x0042
        L_0x002d:
            r3.AFInAppEventType((android.content.Context) r4)
            com.appsflyer.internal.AFc1vSDK r4 = r3.AFKeystoreWrapper()
            com.appsflyer.PurchaseHandler r4 = r4.afInfoLog()
            java.lang.String[] r0 = new java.lang.String[]{r2}
            boolean r0 = r4.AFKeystoreWrapper(r5, r6, r0)
            if (r0 == 0) goto L_0x0055
        L_0x0042:
            com.appsflyer.internal.AFd1eSDK r0 = new com.appsflyer.internal.AFd1eSDK
            com.appsflyer.internal.AFc1vSDK r1 = r4.valueOf
            r0.<init>(r5, r6, r1)
            com.appsflyer.internal.AFd1pSDK r4 = r4.values
            java.util.concurrent.Executor r5 = r4.AFKeystoreWrapper
            com.appsflyer.internal.AFd1pSDK$5 r6 = new com.appsflyer.internal.AFd1pSDK$5
            r6.<init>(r0)
            r5.execute(r6)
        L_0x0055:
            int r4 = onAttributionFailure
            int r4 = r4 + 73
            int r5 = r4 % 128
            onResponse = r5
            int r4 = r4 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.sendInAppPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    public final void setImeiData(String str) {
        int i = onResponse + 15;
        onAttributionFailure = i % 128;
        int i2 = i % 2;
        boolean z = true;
        AFKeystoreWrapper().AFVersionDeclaration().values("setImeiData", str);
        AFKeystoreWrapper().afWarnLog().valueOf = str;
        int i3 = onResponse + 113;
        onAttributionFailure = i3 % 128;
        if (i3 % 2 != 0) {
            z = false;
        }
        if (z) {
            int i4 = 63 / 0;
        }
    }

    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap;
        Activity activity = null;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        AFInAppEventType(context);
        AFf1wSDK aFf1wSDK = new AFf1wSDK();
        if (context != null) {
            aFf1wSDK.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
        aFf1wSDK.afErrorLog = str;
        aFf1wSDK.AFInAppEventType = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put(ViewHierarchyNode.JsonKeys.X, Float.valueOf(motionEvent.getX()));
                hashMap3.put(ViewHierarchyNode.JsonKeys.Y, Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.valueOf("Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFf1wSDK.AFInAppEventParameterName((Map<String, ?>) singletonMap);
        }
        aFf1wSDK.values = hashMap;
        AFb1sSDK AFVersionDeclaration2 = AFKeystoreWrapper().AFVersionDeclaration();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject((Map<?, ?>) aFf1wSDK.values == null ? new HashMap() : aFf1wSDK.values).toString();
        AFVersionDeclaration2.values("logEvent", strArr);
        if (str == null) {
            values(context, AFe1iSDK.logEvent);
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        AFInAppEventType((AFa1sSDK) aFf1wSDK, activity);
    }

    private void AFInAppEventParameterName(AFa1sSDK aFa1sSDK) {
        String str;
        long j;
        AFa1sSDK aFa1sSDK2 = aFa1sSDK;
        Application application = aFa1sSDK2.AFKeystoreWrapper;
        if (application == null) {
            int i = onResponse + 33;
            onAttributionFailure = i % 128;
            int i2 = i % 2;
            AFLogger.afDebugLog("sendWithEvent - got null context. skipping event/launch.");
            return;
        }
        SharedPreferences valueOf2 = valueOf((Context) application);
        AppsFlyerProperties.getInstance().saveProperties(valueOf2);
        if (!AFKeystoreWrapper().afWarnLog().valueOf()) {
            AFLogger.afInfoLog(new StringBuilder("sendWithEvent from activity: ").append(application.getClass().getName()).toString());
        }
        boolean AFInAppEventParameterName2 = aFa1sSDK.AFInAppEventParameterName();
        Map<String, Object> AFInAppEventType2 = AFInAppEventType(aFa1sSDK);
        String str2 = (String) AFInAppEventType2.get("appsflyerKey");
        String str3 = null;
        int i3 = 0;
        if (str2 != null) {
            int i4 = onAttributionFailure + 49;
            onResponse = i4 % 128;
            if (i4 % 2 != 0) {
                str2.length();
                try {
                    throw null;
                } catch (Throwable th) {
                    throw th;
                }
            } else if (str2.length() != 0) {
                if (!(isStopped())) {
                    int i5 = onAttributionFailure + 107;
                    onResponse = i5 % 128;
                    if (i5 % 2 == 0) {
                        AFLogger.afInfoLog("AppsFlyerLib.sendWithEvent");
                    } else {
                        AFLogger.afInfoLog("AppsFlyerLib.sendWithEvent");
                        try {
                            throw null;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                int AFKeystoreWrapper2 = AFKeystoreWrapper(valueOf2, false);
                AFf1gSDK aFf1gSDK = new AFf1gSDK(this.onConversionDataFail);
                String str4 = "";
                Intrinsics.checkNotNullParameter(aFa1sSDK2, str4);
                boolean AFInAppEventParameterName3 = aFa1sSDK.AFInAppEventParameterName();
                boolean z = aFa1sSDK2 instanceof AFe1dSDK;
                boolean z2 = aFa1sSDK2 instanceof AFe1bSDK;
                if ((aFa1sSDK2 instanceof AFe1cSDK) || z2) {
                    str = AFf1gSDK.afRDLog;
                    if (str == null) {
                        str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.AFInAppEventType);
                    }
                } else {
                    if (z) {
                        str = AFf1gSDK.AFLogger;
                        if (str == null) {
                            int i6 = onResponse + 53;
                            onAttributionFailure = i6 % 128;
                            if (!(i6 % 2 == 0 ? true : true)) {
                                str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.AFKeystoreWrapper);
                            } else {
                                str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.AFKeystoreWrapper);
                                try {
                                    int i7 = 2 / 0;
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                        }
                    } else if (!AFInAppEventParameterName3) {
                        str = AFf1gSDK.getLevel;
                        if (!(str == null ? true : true)) {
                            str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.afErrorLog);
                        }
                    } else if (AFKeystoreWrapper2 < 2) {
                        str = AFf1gSDK.afDebugLog;
                        if (str == null) {
                            int i8 = onAttributionFailure + 103;
                            onResponse = i8 % 128;
                            int i9 = i8 % 2;
                            str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.values);
                        }
                    } else {
                        str = AFf1gSDK.afWarnLog;
                        if (str == null) {
                            str = aFf1gSDK.AFInAppEventParameterName.AFInAppEventType(AFf1gSDK.afInfoLog);
                        }
                    }
                }
                StringBuilder append = new StringBuilder().append(AFf1gSDK.AFKeystoreWrapper(new StringBuilder().append(str).append(aFf1gSDK.valueOf.AFInAppEventParameterName().values.AFKeystoreWrapper.getPackageName()).toString(), z));
                String values2 = aFf1gSDK.valueOf.AFInAppEventParameterName().values();
                if (values2 != null) {
                    str3 = "&channel=".concat(String.valueOf(values2));
                } else {
                    int i10 = onAttributionFailure + 87;
                    onResponse = i10 % 128;
                    int i11 = i10 % 2;
                }
                if (str3 == null ? true : true) {
                    str4 = str3;
                }
                String obj = append.append(str4).toString();
                AFInAppEventParameterName(AFInAppEventType2);
                AFa1ySDK aFa1ySDK = new AFa1ySDK(this, aFa1sSDK2.AFInAppEventParameterName(obj).AFInAppEventParameterName((Map<String, ?>) AFInAppEventType2).AFKeystoreWrapper(AFKeystoreWrapper2), (byte) 0);
                if (AFInAppEventParameterName2) {
                    AFf1jSDK[] AFVersionDeclaration2 = AFVersionDeclaration();
                    int length = AFVersionDeclaration2.length;
                    int i12 = 0;
                    while (i3 < length) {
                        AFf1jSDK aFf1jSDK = AFVersionDeclaration2[i3];
                        if (aFf1jSDK.AFKeystoreWrapper == AFf1jSDK.AFa1wSDK.STARTED) {
                            AFLogger.afDebugLog(new StringBuilder("Failed to get ").append(aFf1jSDK.valueOf).append(" referrer, wait ...").toString());
                            i12 = 1;
                        }
                        i3++;
                    }
                    if (!this.onDeepLinkingNative || afRDLog()) {
                        i3 = i12;
                    } else {
                        AFLogger.afDebugLog("fetching Facebook deferred AppLink data, wait ...");
                        i3 = 1;
                    }
                    if (AFKeystoreWrapper().afWarnLog().values()) {
                        i3 = 1;
                    }
                }
                ScheduledExecutorService values3 = AFKeystoreWrapper().values();
                if (i3 != 0) {
                    int i13 = onAttributionFailure + 97;
                    onResponse = i13 % 128;
                    int i14 = i13 % 2;
                    j = 500;
                } else {
                    j = 0;
                }
                AFInAppEventParameterName(values3, aFa1ySDK, j, TimeUnit.MILLISECONDS);
                return;
            }
        }
        AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
        AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK2.AFInAppEventType;
        if (appsFlyerRequestListener != null) {
            int i15 = onAttributionFailure + 55;
            onResponse = i15 % 128;
            if (i15 % 2 != 0) {
                appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
                try {
                    int i16 = 95 / 0;
                } catch (Throwable th4) {
                    throw th4;
                }
            } else {
                appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
            }
        }
        int i17 = onResponse + 79;
        onAttributionFailure = i17 % 128;
        if (i17 % 2 == 0) {
            try {
                throw null;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: android.content.SharedPreferences} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v26, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v30, resolved type: android.content.SharedPreferences} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v33, resolved type: android.content.SharedPreferences} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v38, resolved type: int} */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* JADX WARNING: type inference failed for: r25v16, types: [java.math.BigDecimal, java.lang.Number] */
    /* JADX WARNING: type inference failed for: r31v23 */
    /* JADX WARNING: type inference failed for: r31v24 */
    /* JADX WARNING: type inference failed for: r31v31 */
    /* JADX WARNING: type inference failed for: r31v32 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x044b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x044c, code lost:
        r7 = r0;
        r9 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0450, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        com.appsflyer.AFLogger.afErrorLog(r21, r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03ae A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03bb A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03c1 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03d4 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03e4 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03f6 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0421 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x043c A[SYNTHETIC, Splitter:B:167:0x043c] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0450 A[ExcHandler: all (r0v21 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:167:0x043c] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0469 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x047c A[Catch:{ Exception -> 0x0482 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x051f A[Catch:{ all -> 0x05d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x05ff A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0608 A[Catch:{ Exception -> 0x0133, all -> 0x0b47 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x063b A[SYNTHETIC, Splitter:B:252:0x063b] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x09a0 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x09ae A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x09c6 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x09d2 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0a08 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0a0a A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0a27 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0a29 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0a65 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0ae3 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0af2 A[Catch:{ all -> 0x0b45 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType(com.appsflyer.internal.AFa1sSDK r37) {
        /*
            r36 = this;
            r1 = r36
            r2 = r37
            java.lang.String r3 = "af_deeplink"
            java.lang.String r4 = "advertiserId"
            java.lang.String r5 = "versionCode"
            java.lang.String r6 = "Exception while collecting facebook's attribution ID. "
            java.lang.String r7 = "appid"
            java.lang.String r8 = "sdkExtension"
            java.lang.String r9 = "extraReferrers"
            java.lang.String r10 = "yyyy-MM-dd_HHmmssZ"
            android.app.Application r11 = r2.AFKeystoreWrapper
            com.appsflyer.internal.AFc1vSDK r12 = r36.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1kSDK r12 = r12.afWarnLog()
            java.lang.String r12 = r12.AFInAppEventType
            java.lang.String r13 = r2.afErrorLog
            org.json.JSONObject r14 = new org.json.JSONObject
            java.util.Map<java.lang.String, java.lang.Object> r15 = r2.values
            if (r15 != 0) goto L_0x002e
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            goto L_0x0030
        L_0x002e:
            java.util.Map<java.lang.String, java.lang.Object> r15 = r2.values
        L_0x0030:
            r14.<init>((java.util.Map<?, ?>) r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = r2.afRDLog
            r16 = r4
            android.content.SharedPreferences r4 = valueOf((android.content.Context) r11)
            r17 = r3
            boolean r3 = r37.AFInAppEventParameterName()
            r18 = r5
            java.lang.String r5 = r2.AFInAppEventParameterName
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.valueOf
            com.appsflyer.internal.AFa1bSDK.AFInAppEventType(r11, r2)
            java.lang.Boolean r19 = com.appsflyer.internal.AFa1bSDK.AFInAppEventType
            if (r19 == 0) goto L_0x006a
            boolean r19 = r19.booleanValue()
            if (r19 != 0) goto L_0x006a
            r19 = r5
            java.util.Map r5 = valueOf((java.util.Map<java.lang.String, java.lang.Object>) r2)
            r20 = r10
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r21 = r6
            java.lang.String r6 = "ad_ids_disabled"
            r5.put(r6, r10)
            goto L_0x0070
        L_0x006a:
            r19 = r5
            r21 = r6
            r20 = r10
        L_0x0070:
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            long r5 = r5.getTime()
            r10 = r7
            r22 = r8
            r7 = 0
            int r23 = android.widget.ExpandableListView.getPackedPositionType(r7)
            r7 = 5
            int r26 = r23 + 5
            int r8 = android.os.Process.myTid()
            int r8 = r8 >> 22
            int r8 = r8 + 289
            long r27 = android.os.SystemClock.elapsedRealtime()
            r23 = 0
            int r27 = (r27 > r23 ? 1 : (r27 == r23 ? 0 : -1))
            int r29 = 13 - r27
            r30 = 1
            r7 = 1
            r23 = r10
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.String r27 = "￿\n￵￼￷\u0006\u0003￷\n\t￻\u0003"
            r28 = r8
            r31 = r10
            AFKeystoreWrapper(r26, r27, r28, r29, r30, r31)
            r8 = 0
            r10 = r10[r8]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r10 = r10.intern()
            java.lang.String r7 = java.lang.Long.toString(r5)
            r2.put(r10, r7)
            java.lang.String r5 = com.appsflyer.internal.AFa1ySDK.AFKeystoreWrapper(r11, r5)
            if (r5 == 0) goto L_0x00c2
            java.lang.String r6 = "cksm_v1"
            r2.put(r6, r5)
        L_0x00c2:
            boolean r5 = r36.isStopped()     // Catch:{ all -> 0x0b47 }
            if (r5 != 0) goto L_0x00e1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = "******* sendTrackingWithEvent: "
            r5.<init>(r6)     // Catch:{ all -> 0x0b47 }
            if (r3 == 0) goto L_0x00d4
            java.lang.String r6 = "Launch"
            goto L_0x00d5
        L_0x00d4:
            r6 = r13
        L_0x00d5:
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ all -> 0x0b47 }
            goto L_0x00e6
        L_0x00e1:
            java.lang.String r5 = "Reporting has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ all -> 0x0b47 }
        L_0x00e6:
            com.appsflyer.internal.AFc1vSDK r5 = r36.AFKeystoreWrapper()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFb1zSDK r5 = r5.AFLogger$LogLevel()     // Catch:{ all -> 0x0b47 }
            r5.AFKeystoreWrapper()     // Catch:{ all -> 0x0b47 }
            android.content.pm.PackageManager r5 = r11.getPackageManager()     // Catch:{ Exception -> 0x0133 }
            java.lang.String r6 = r11.getPackageName()     // Catch:{ Exception -> 0x0133 }
            r7 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x0133 }
            java.lang.String[] r5 = r5.requestedPermissions     // Catch:{ Exception -> 0x0133 }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r6 = "android.permission.INTERNET"
            boolean r6 = r5.contains(r6)     // Catch:{ Exception -> 0x0133 }
            if (r6 != 0) goto L_0x0112
            java.lang.String r6 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Exception -> 0x0133 }
        L_0x0112:
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = r5.contains(r6)     // Catch:{ Exception -> 0x0133 }
            if (r6 != 0) goto L_0x011f
            java.lang.String r6 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ Exception -> 0x0133 }
        L_0x011f:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0133 }
            r7 = 32
            if (r6 <= r7) goto L_0x013a
            java.lang.String r6 = "com.google.android.gms.permission.AD_ID"
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x0133 }
            if (r5 != 0) goto L_0x013a
            java.lang.String r5 = "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ Exception -> 0x0133 }
            goto L_0x013a
        L_0x0133:
            r0 = move-exception
            r5 = r0
            java.lang.String r6 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch:{ all -> 0x0b47 }
        L_0x013a:
            java.lang.String r5 = "af_events_api"
            int r6 = android.view.KeyEvent.getDeadChar(r8, r8)     // Catch:{ all -> 0x0b47 }
            r7 = 1
            int r27 = r6 + 1
            java.lang.String r28 = "\u0000"
            int r6 = android.view.ViewConfiguration.getKeyRepeatTimeout()     // Catch:{ all -> 0x0b47 }
            int r6 = r6 >> 16
            int r6 = 232 - r6
            int r10 = android.graphics.Color.blue(r8)     // Catch:{ all -> 0x0b47 }
            int r30 = r10 + 1
            r31 = 0
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ all -> 0x0b47 }
            r29 = r6
            r32 = r10
            AFKeystoreWrapper(r27, r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0b47 }
            r6 = r10[r8]     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = r6.intern()     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            int r5 = android.view.ViewConfiguration.getMaximumFlingVelocity()     // Catch:{ all -> 0x0b47 }
            int r5 = r5 >> 16
            r6 = 5
            int r27 = r5 + 5
            java.lang.String r28 = "�\u0007￺\u000b￻"
            int r5 = android.view.View.combineMeasuredStates(r8, r8)     // Catch:{ all -> 0x0b47 }
            int r5 = 286 - r5
            int r7 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch:{ all -> 0x0b47 }
            int r7 = r7 >> 16
            int r30 = 5 - r7
            r31 = 1
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0b47 }
            r29 = r5
            r32 = r7
            AFKeystoreWrapper(r27, r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0b47 }
            r5 = r7[r8]     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = r5.intern()     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "device"
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "product"
            java.lang.String r6 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "sdk"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "model"
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "deviceType"
            java.lang.String r6 = android.os.Build.TYPE     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
            valueOf((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFb1hSDK r6 = new com.appsflyer.internal.AFb1hSDK     // Catch:{ all -> 0x0b47 }
            r6.<init>(r11)     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFc1vSDK r7 = r36.AFKeystoreWrapper()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFe1fSDK r7 = r7.AFLogger()     // Catch:{ all -> 0x0b47 }
            if (r3 == 0) goto L_0x02cf
            boolean r28 = afRDLog(r11)     // Catch:{ all -> 0x0b47 }
            if (r28 == 0) goto L_0x0232
            boolean r28 = r5.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0b47 }
            if (r28 != 0) goto L_0x01fb
            com.appsflyer.internal.AFc1vSDK r28 = r36.AFKeystoreWrapper()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFc1zSDK r8 = r28.AppsFlyer2dXConversionCallback()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFc1zSDK$AFa1vSDK r8 = r8.AFInAppEventType(r11)     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = "batteryLevel"
            float r8 = r8.valueOf     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0b47 }
            r2.put(r10, r8)     // Catch:{ all -> 0x0b47 }
        L_0x01fb:
            afErrorLog(r11)     // Catch:{ all -> 0x0b47 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b47 }
            r10 = 23
            if (r8 < r10) goto L_0x020d
            java.lang.Class<android.app.UiModeManager> r8 = android.app.UiModeManager.class
            java.lang.Object r8 = r11.getSystemService(r8)     // Catch:{ all -> 0x0b47 }
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8     // Catch:{ all -> 0x0b47 }
            goto L_0x0215
        L_0x020d:
            java.lang.String r8 = "uimode"
            java.lang.Object r8 = r11.getSystemService(r8)     // Catch:{ all -> 0x0b47 }
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8     // Catch:{ all -> 0x0b47 }
        L_0x0215:
            if (r8 == 0) goto L_0x0225
            int r8 = r8.getCurrentModeType()     // Catch:{ all -> 0x0b47 }
            r10 = 4
            if (r8 != r10) goto L_0x0225
            java.lang.String r8 = "tv"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0b47 }
        L_0x0225:
            boolean r8 = com.appsflyer.internal.AFe1jSDK.valueOf(r11)     // Catch:{ all -> 0x0b47 }
            if (r8 == 0) goto L_0x0232
            java.lang.String r8 = "inst_app"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0b47 }
        L_0x0232:
            java.lang.String r8 = "timepassedsincelastlaunch"
            long r30 = r1.afErrorLogForExcManagerOnly(r11)     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = java.lang.Long.toString(r30)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0b47 }
            AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b47 }
            AFInAppEventType((java.util.Map<java.lang.String, java.lang.Object>) r2, (com.appsflyer.internal.AFe1fSDK) r7)     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = r1.onResponseNative     // Catch:{ all -> 0x0b47 }
            if (r8 == 0) goto L_0x024e
            java.lang.String r10 = "phone"
            r2.put(r10, r8)     // Catch:{ all -> 0x0b47 }
        L_0x024e:
            boolean r8 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = "referrer"
            if (r8 != 0) goto L_0x0259
            r2.put(r10, r15)     // Catch:{ all -> 0x0b47 }
        L_0x0259:
            r8 = 0
            java.lang.String r15 = r4.getString(r9, r8)     // Catch:{ all -> 0x0b47 }
            if (r15 == 0) goto L_0x0263
            r2.put(r9, r15)     // Catch:{ all -> 0x0b47 }
        L_0x0263:
            java.lang.String r8 = r5.getReferrer(r11)     // Catch:{ all -> 0x0b47 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0b47 }
            if (r9 != 0) goto L_0x0276
            java.lang.Object r9 = r2.get(r10)     // Catch:{ all -> 0x0b47 }
            if (r9 != 0) goto L_0x0276
            r2.put(r10, r8)     // Catch:{ all -> 0x0b47 }
        L_0x0276:
            long r7 = r7.AFLogger$LogLevel     // Catch:{ all -> 0x0b47 }
            r9 = 0
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r15 == 0) goto L_0x0287
            java.lang.String r9 = "prev_session_dur"
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0b47 }
            r2.put(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0287:
            android.app.Application r7 = com.appsflyer.internal.AFb1fSDK.values     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = "exception_number"
            if (r7 != 0) goto L_0x0290
            r9 = -1
            goto L_0x029c
        L_0x0290:
            android.app.Application r7 = com.appsflyer.internal.AFb1fSDK.values     // Catch:{ all -> 0x0b47 }
            android.content.SharedPreferences r7 = valueOf((android.content.Context) r7)     // Catch:{ all -> 0x0b47 }
            r9 = 0
            long r9 = r7.getLong(r8, r9)     // Catch:{ all -> 0x0b47 }
        L_0x029c:
            java.lang.Long r7 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFb1eSDK r7 = r1.onConversionDataSuccess     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x02d2
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.AFKeystoreWrapper     // Catch:{ all -> 0x0b47 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0b47 }
            java.lang.String r9 = "partner_data"
            if (r8 != 0) goto L_0x02b6
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.AFKeystoreWrapper     // Catch:{ all -> 0x0b47 }
            r2.put(r9, r8)     // Catch:{ all -> 0x0b47 }
        L_0x02b6:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r7.AFInAppEventType     // Catch:{ all -> 0x0b47 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0b47 }
            if (r8 != 0) goto L_0x02d2
            java.util.Map r8 = valueOf((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b47 }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r7.AFInAppEventType     // Catch:{ all -> 0x0b47 }
            r8.put(r9, r10)     // Catch:{ all -> 0x0b47 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0b47 }
            r8.<init>()     // Catch:{ all -> 0x0b47 }
            r7.AFInAppEventType = r8     // Catch:{ all -> 0x0b47 }
            goto L_0x02d2
        L_0x02cf:
            AFKeystoreWrapper((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2, (java.lang.String) r13)     // Catch:{ all -> 0x0b47 }
        L_0x02d2:
            java.lang.String r7 = "KSAppsFlyerId"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = "KSAppsFlyerRICounter"
            java.lang.String r8 = AFInAppEventType((java.lang.String) r8)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x02f6
            if (r8 == 0) goto L_0x02f6
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0b47 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0b47 }
            if (r9 <= 0) goto L_0x02f6
            java.lang.String r9 = "reinstallCounter"
            r2.put(r9, r8)     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = "originalAppsflyerId"
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x02f6:
            java.lang.String r7 = "additionalCustomData"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x0303
            java.lang.String r8 = "customData"
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0303:
            android.content.pm.PackageManager r7 = r11.getPackageManager()     // Catch:{ Exception -> 0x0317 }
            java.lang.String r8 = r11.getPackageName()     // Catch:{ Exception -> 0x0317 }
            java.lang.String r7 = r7.getInstallerPackageName(r8)     // Catch:{ Exception -> 0x0317 }
            if (r7 == 0) goto L_0x031e
            java.lang.String r8 = "installer_package"
            r2.put(r8, r7)     // Catch:{ Exception -> 0x0317 }
            goto L_0x031e
        L_0x0317:
            r0 = move-exception
            r7 = r0
            java.lang.String r8 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x031e:
            r7 = r22
            java.lang.String r8 = r5.getString(r7)     // Catch:{ all -> 0x0b47 }
            if (r8 == 0) goto L_0x032f
            int r9 = r8.length()     // Catch:{ all -> 0x0b47 }
            if (r9 <= 0) goto L_0x032f
            r2.put(r7, r8)     // Catch:{ all -> 0x0b47 }
        L_0x032f:
            java.lang.String r7 = r1.AFInAppEventParameterName((android.content.Context) r11)     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFc1xSDK r8 = r1.values((android.content.Context) r11)     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = values((com.appsflyer.internal.AFc1xSDK) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            if (r8 == 0) goto L_0x0343
            boolean r9 = r8.equals(r7)     // Catch:{ all -> 0x0b47 }
            if (r9 == 0) goto L_0x0347
        L_0x0343:
            if (r8 != 0) goto L_0x034c
            if (r7 == 0) goto L_0x034c
        L_0x0347:
            java.lang.String r8 = "af_latestchannel"
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x034c:
            java.lang.String r7 = r1.AFLogger$LogLevel(r11)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x035f
            java.lang.String r8 = "af_installstore"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x035f:
            java.lang.String r7 = r1.AFVersionDeclaration(r11)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x0372
            java.lang.String r8 = "af_preinstall_name"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0372:
            java.lang.String r7 = r1.getLevel(r11)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x0385
            java.lang.String r8 = "af_currentstore"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0385:
            java.lang.String r7 = "appsflyerKey"
            if (r12 == 0) goto L_0x0393
            int r8 = r12.length()     // Catch:{ all -> 0x0b47 }
            if (r8 <= 0) goto L_0x0393
            r2.put(r7, r12)     // Catch:{ all -> 0x0b47 }
            goto L_0x03a8
        L_0x0393:
            com.appsflyer.internal.AFc1vSDK r8 = r36.AFKeystoreWrapper()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.internal.AFe1kSDK r8 = r8.afWarnLog()     // Catch:{ all -> 0x0b47 }
            java.lang.String r8 = r8.AFInAppEventType     // Catch:{ all -> 0x0b47 }
            if (r8 == 0) goto L_0x0b38
            int r9 = r8.length()     // Catch:{ all -> 0x0b47 }
            if (r9 <= 0) goto L_0x0b38
            r2.put(r7, r8)     // Catch:{ all -> 0x0b47 }
        L_0x03a8:
            java.lang.String r7 = valueOf()     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x03b3
            java.lang.String r8 = "appUserId"
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x03b3:
            java.lang.String r7 = "userEmails"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x03c1
            java.lang.String r8 = "user_emails"
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
            goto L_0x03d2
        L_0x03c1:
            java.lang.String r7 = "userEmail"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x03d2
            java.lang.String r8 = "sha1_el"
            java.lang.String r7 = com.appsflyer.internal.AFb1ySDK.values(r7)     // Catch:{ all -> 0x0b47 }
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x03d2:
            if (r13 == 0) goto L_0x03de
            java.lang.String r7 = "eventName"
            r2.put(r7, r13)     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = "eventValue"
            r2.put(r7, r14)     // Catch:{ all -> 0x0b47 }
        L_0x03de:
            java.lang.String r7 = AFLogger()     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x03ed
            java.lang.String r7 = AFInAppEventType((java.lang.String) r23)     // Catch:{ all -> 0x0b47 }
            r8 = r23
            r2.put(r8, r7)     // Catch:{ all -> 0x0b47 }
        L_0x03ed:
            java.lang.String r7 = "currencyCode"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            r8 = 3
            if (r7 == 0) goto L_0x0419
            int r9 = r7.length()     // Catch:{ all -> 0x0b47 }
            if (r9 == r8) goto L_0x0414
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = "WARNING: currency code should be 3 characters!!! '"
            r9.<init>(r10)     // Catch:{ all -> 0x0b47 }
            java.lang.StringBuilder r9 = r9.append(r7)     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = "' is not a legal value."
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x0b47 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ all -> 0x0b47 }
        L_0x0414:
            java.lang.String r9 = "currency"
            r2.put(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0419:
            java.lang.String r7 = "IS_UPDATE"
            java.lang.String r7 = AFInAppEventType((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x0426
            java.lang.String r9 = "isUpdate"
            r2.put(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0426:
            boolean r7 = r1.isPreInstalledApp(r11)     // Catch:{ all -> 0x0b47 }
            java.lang.String r9 = "af_preinstalled"
            java.lang.String r7 = java.lang.Boolean.toString(r7)     // Catch:{ all -> 0x0b47 }
            r2.put(r9, r7)     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = "collectFacebookAttrId"
            r9 = 1
            boolean r7 = r5.getBoolean(r7, r9)     // Catch:{ all -> 0x0b47 }
            if (r7 == 0) goto L_0x046e
            android.content.pm.PackageManager r7 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0459, all -> 0x0450 }
            java.lang.String r9 = "com.facebook.katana"
            r10 = 0
            r7.getApplicationInfo(r9, r10)     // Catch:{ NameNotFoundException -> 0x044b, all -> 0x0450 }
            java.lang.String r7 = r1.getAttributionId(r11)     // Catch:{ NameNotFoundException -> 0x044b, all -> 0x0450 }
            goto L_0x0467
        L_0x044b:
            r0 = move-exception
            r7 = r0
            r9 = r21
            goto L_0x045d
        L_0x0450:
            r0 = move-exception
            r7 = r0
            r9 = r21
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x0457:
            r7 = 0
            goto L_0x0467
        L_0x0459:
            r0 = move-exception
            r9 = r21
            r7 = r0
        L_0x045d:
            java.lang.String r10 = "com.facebook.katana not found"
            r12 = 1
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r10, r7, r12)     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ all -> 0x0b47 }
            goto L_0x0457
        L_0x0467:
            if (r7 == 0) goto L_0x046e
            java.lang.String r9 = "fb"
            r2.put(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x046e:
            r1.values((android.content.Context) r11, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b47 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0482 }
            r7.<init>(r11)     // Catch:{ Exception -> 0x0482 }
            java.lang.String r7 = com.appsflyer.internal.AFb1wSDK.AFInAppEventParameterName((java.lang.ref.WeakReference<android.content.Context>) r7)     // Catch:{ Exception -> 0x0482 }
            if (r7 == 0) goto L_0x049a
            java.lang.String r9 = "uid"
            r2.put(r9, r7)     // Catch:{ Exception -> 0x0482 }
            goto L_0x049a
        L_0x0482:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = "ERROR: could not get uid "
            r9.<init>(r10)     // Catch:{ all -> 0x0b47 }
            java.lang.String r10 = r7.getMessage()     // Catch:{ all -> 0x0b47 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x0b47 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x049a:
            java.lang.String r7 = "lang"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04a8 }
            java.lang.String r9 = r9.getDisplayLanguage()     // Catch:{ Exception -> 0x04a8 }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x04a8 }
            goto L_0x04af
        L_0x04a8:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x04af:
            java.lang.String r7 = "lang_code"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04bd }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ Exception -> 0x04bd }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x04bd }
            goto L_0x04c4
        L_0x04bd:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x04c4:
            java.lang.String r7 = "country"
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x04d2 }
            java.lang.String r9 = r9.getCountry()     // Catch:{ Exception -> 0x04d2 }
            r2.put(r7, r9)     // Catch:{ Exception -> 0x04d2 }
            goto L_0x04d9
        L_0x04d2:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r9, r7)     // Catch:{ all -> 0x0b47 }
        L_0x04d9:
            r1.values((java.util.Map<java.lang.String, java.lang.Object>) r2, (boolean) r3)     // Catch:{ all -> 0x0b47 }
            r1.AFKeystoreWrapper((android.content.Context) r11, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0b47 }
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0b47 }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0b47 }
            r10 = r20
            r7.<init>(r10, r9)     // Catch:{ all -> 0x0b47 }
            android.content.pm.PackageManager r9 = r11.getPackageManager()     // Catch:{ Exception -> 0x0501 }
            java.lang.String r12 = r11.getPackageName()     // Catch:{ Exception -> 0x0501 }
            r14 = 0
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r12, r14)     // Catch:{ Exception -> 0x0501 }
            long r14 = r9.firstInstallTime     // Catch:{ Exception -> 0x0501 }
            java.lang.String r9 = "installDate"
            java.lang.String r12 = AFKeystoreWrapper((java.text.SimpleDateFormat) r7, (long) r14)     // Catch:{ Exception -> 0x0501 }
            r2.put(r9, r12)     // Catch:{ Exception -> 0x0501 }
            goto L_0x0508
        L_0x0501:
            r0 = move-exception
            r9 = r0
            java.lang.String r12 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r12, r9)     // Catch:{ all -> 0x0b47 }
        L_0x0508:
            android.content.pm.PackageManager r9 = r11.getPackageManager()     // Catch:{ all -> 0x05d5 }
            java.lang.String r12 = r11.getPackageName()     // Catch:{ all -> 0x05d5 }
            r14 = 0
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r12, r14)     // Catch:{ all -> 0x05d5 }
            r12 = r18
            int r15 = r4.getInt(r12, r14)     // Catch:{ all -> 0x05d5 }
            int r14 = r9.versionCode     // Catch:{ all -> 0x05d5 }
            if (r14 <= r15) goto L_0x0528
            com.appsflyer.internal.AFc1xSDK r14 = r1.values((android.content.Context) r11)     // Catch:{ all -> 0x05d5 }
            int r15 = r9.versionCode     // Catch:{ all -> 0x05d5 }
            r14.valueOf(r12, r15)     // Catch:{ all -> 0x05d5 }
        L_0x0528:
            com.appsflyer.internal.AFc1vSDK r12 = r36.AFKeystoreWrapper()     // Catch:{ all -> 0x05d5 }
            com.appsflyer.internal.AFb1bSDK r12 = r12.AFInAppEventParameterName()     // Catch:{ all -> 0x05d5 }
            java.lang.String r14 = "app_version_code"
            int r15 = r9.versionCode     // Catch:{ all -> 0x05d5 }
            java.lang.String r15 = java.lang.Integer.toString(r15)     // Catch:{ all -> 0x05d5 }
            r2.put(r14, r15)     // Catch:{ all -> 0x05d5 }
            java.lang.String r14 = "app_version_name"
            com.appsflyer.internal.AFc1wSDK r15 = r12.values     // Catch:{ all -> 0x05d5 }
            android.content.Context r15 = r15.AFKeystoreWrapper     // Catch:{ all -> 0x05d5 }
            com.appsflyer.internal.AFc1wSDK r8 = r12.values     // Catch:{ all -> 0x05d5 }
            android.content.Context r8 = r8.AFKeystoreWrapper     // Catch:{ all -> 0x05d5 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ all -> 0x05d5 }
            java.lang.String r8 = com.appsflyer.internal.AFa1cSDK.AFInAppEventParameterName(r15, r8)     // Catch:{ all -> 0x05d5 }
            r2.put(r14, r8)     // Catch:{ all -> 0x05d5 }
            java.lang.String r8 = "targetSDKver"
            com.appsflyer.internal.AFc1wSDK r12 = r12.values     // Catch:{ all -> 0x05d5 }
            android.content.Context r12 = r12.AFKeystoreWrapper     // Catch:{ all -> 0x05d5 }
            android.content.pm.ApplicationInfo r12 = r12.getApplicationInfo()     // Catch:{ all -> 0x05d5 }
            int r12 = r12.targetSdkVersion     // Catch:{ all -> 0x05d5 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x05d5 }
            r2.put(r8, r12)     // Catch:{ all -> 0x05d5 }
            long r14 = r9.firstInstallTime     // Catch:{ all -> 0x05d5 }
            long r8 = r9.lastUpdateTime     // Catch:{ all -> 0x05d5 }
            java.lang.String r12 = "date1"
            r20 = r6
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x05d1 }
            r21 = r5
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x05cf }
            r6.<init>(r10, r5)     // Catch:{ all -> 0x05cf }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x05cf }
            r5.<init>(r14)     // Catch:{ all -> 0x05cf }
            java.lang.String r5 = r6.format(r5)     // Catch:{ all -> 0x05cf }
            r2.put(r12, r5)     // Catch:{ all -> 0x05cf }
            java.lang.String r5 = "date2"
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x05cf }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ all -> 0x05cf }
            r6.<init>(r10, r12)     // Catch:{ all -> 0x05cf }
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x05cf }
            r10.<init>(r8)     // Catch:{ all -> 0x05cf }
            java.lang.String r6 = r6.format(r10)     // Catch:{ all -> 0x05cf }
            r2.put(r5, r6)     // Catch:{ all -> 0x05cf }
            java.lang.String r5 = r1.AFKeystoreWrapper((java.text.SimpleDateFormat) r7, (android.content.Context) r11)     // Catch:{ all -> 0x05cf }
            int r6 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch:{ all -> 0x05cf }
            int r6 = r6 >> 16
            int r30 = 12 - r6
            java.lang.String r31 = "￞\u0002�\b\u000f￻￦\u000e\r\f\u0003\u0000￿\u000e￻"
            java.lang.String r6 = ""
            r7 = 48
            r8 = 0
            int r6 = android.text.TextUtils.indexOf(r6, r7, r8)     // Catch:{ all -> 0x05cf }
            int r6 = 284 - r6
            int r7 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch:{ all -> 0x05cf }
            int r7 = r7 >> 8
            int r33 = r7 + 15
            r34 = 1
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x05cf }
            r32 = r6
            r35 = r8
            AFKeystoreWrapper(r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x05cf }
            r6 = 0
            r7 = r8[r6]     // Catch:{ all -> 0x05cf }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x05cf }
            java.lang.String r6 = r7.intern()     // Catch:{ all -> 0x05cf }
            r2.put(r6, r5)     // Catch:{ all -> 0x05cf }
            goto L_0x05e1
        L_0x05cf:
            r0 = move-exception
            goto L_0x05da
        L_0x05d1:
            r0 = move-exception
            r21 = r5
            goto L_0x05da
        L_0x05d5:
            r0 = move-exception
            r21 = r5
            r20 = r6
        L_0x05da:
            r5 = r0
            java.lang.String r6 = "Exception while collecting app version data "
            r7 = 1
            com.appsflyer.AFLogger.afErrorLog(r6, r5, r7)     // Catch:{ all -> 0x0b47 }
        L_0x05e1:
            boolean r5 = com.appsflyer.internal.AFe1mSDK.AFKeystoreWrapper((android.content.Context) r11)     // Catch:{ all -> 0x0b47 }
            r1.AppsFlyer2dXConversionCallback = r5     // Catch:{ all -> 0x0b47 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = "didConfigureTokenRefreshService="
            r5.<init>(r6)     // Catch:{ all -> 0x0b47 }
            boolean r6 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0b47 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0b47 }
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ all -> 0x0b47 }
            boolean r5 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0b47 }
            if (r5 != 0) goto L_0x0606
            java.lang.String r5 = "tokenRefreshConfigured"
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
        L_0x0606:
            if (r3 == 0) goto L_0x0639
            java.lang.String r5 = r1.afErrorLogForExcManagerOnly     // Catch:{ all -> 0x0b47 }
            if (r5 == 0) goto L_0x062f
            r5 = r17
            java.lang.Object r6 = r2.get(r5)     // Catch:{ all -> 0x0b47 }
            if (r6 == 0) goto L_0x061a
            java.lang.String r5 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ all -> 0x0b47 }
            goto L_0x062f
        L_0x061a:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = r1.afErrorLogForExcManagerOnly     // Catch:{ all -> 0x0b47 }
            r6.<init>((java.lang.String) r7)     // Catch:{ all -> 0x0b47 }
            java.lang.String r7 = "isPush"
            java.lang.String r8 = "true"
            r6.put((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0b47 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0b47 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
        L_0x062f:
            r5 = 0
            r1.afErrorLogForExcManagerOnly = r5     // Catch:{ all -> 0x0b47 }
            java.lang.String r5 = "open_referrer"
            r6 = r19
            r2.put(r5, r6)     // Catch:{ all -> 0x0b47 }
        L_0x0639:
            if (r3 != 0) goto L_0x09a0
            com.appsflyer.internal.AFa1dSDK r5 = com.appsflyer.internal.AFa1dSDK.AFInAppEventType((android.content.Context) r11)     // Catch:{ Exception -> 0x097a }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x097a }
            r6.<init>()     // Catch:{ Exception -> 0x097a }
            java.util.List r5 = r5.AFKeystoreWrapper()     // Catch:{ Exception -> 0x097a }
            boolean r7 = r5.isEmpty()     // Catch:{ Exception -> 0x097a }
            if (r7 != 0) goto L_0x095f
            com.appsflyer.internal.AFa1uSDK r7 = new com.appsflyer.internal.AFa1uSDK     // Catch:{ Exception -> 0x097a }
            r7.<init>()     // Catch:{ Exception -> 0x097a }
            java.lang.String r7 = "n"
            java.lang.String r8 = "v"
            java.lang.String r9 = "er"
            java.lang.String r10 = "uk"
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x097a }
            r12.<init>()     // Catch:{ Exception -> 0x097a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x097a }
        L_0x0664:
            boolean r14 = r5.hasNext()     // Catch:{ Exception -> 0x097a }
            if (r14 == 0) goto L_0x094d
            java.lang.Object r14 = r5.next()     // Catch:{ Exception -> 0x097a }
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x097a }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x097a }
            r15.<init>()     // Catch:{ Exception -> 0x097a }
            r17 = r5
            java.lang.String r5 = "sVS"
            java.lang.Object r5 = r14.get(r5)     // Catch:{ Exception -> 0x097a }
            r19 = r13
            if (r5 == 0) goto L_0x0683
            r5 = 1
            goto L_0x0684
        L_0x0683:
            r5 = 0
        L_0x0684:
            java.lang.String r13 = "sVE"
            java.lang.Object r13 = r14.get(r13)     // Catch:{ Exception -> 0x0945 }
            if (r13 == 0) goto L_0x068e
            r13 = 1
            goto L_0x068f
        L_0x068e:
            r13 = 0
        L_0x068f:
            if (r5 == 0) goto L_0x0696
            if (r13 == 0) goto L_0x0696
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r5 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.ALL     // Catch:{ Exception -> 0x069b }
            goto L_0x06a7
        L_0x0696:
            if (r5 == 0) goto L_0x06a5
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r5 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.FIRST     // Catch:{ Exception -> 0x069b }
            goto L_0x06a7
        L_0x069b:
            r0 = move-exception
            r1 = r0
            r30 = r3
            r31 = r4
            r25 = r11
            goto L_0x0984
        L_0x06a5:
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r5 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.NONE     // Catch:{ Exception -> 0x0945 }
        L_0x06a7:
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r13 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.NONE     // Catch:{ Exception -> 0x0945 }
            if (r5 == r13) goto L_0x0932
            java.lang.String r13 = "sT"
            java.lang.Object r13 = r14.get(r13)     // Catch:{ Exception -> 0x0945 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ Exception -> 0x0945 }
            java.lang.String r1 = "sN"
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Exception -> 0x0945 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0945 }
            if (r1 == 0) goto L_0x06c1
            r15.put(r7, r1)     // Catch:{ all -> 0x0975 }
            goto L_0x06c4
        L_0x06c1:
            r15.put(r7, r10)     // Catch:{ Exception -> 0x0945 }
        L_0x06c4:
            com.appsflyer.internal.AFa1uSDK$AFa1wSDK[] r1 = com.appsflyer.internal.AFa1uSDK.AFa1wSDK.values()     // Catch:{ Exception -> 0x0945 }
            int r22 = r13.intValue()     // Catch:{ Exception -> 0x0945 }
            r1 = r1[r22]     // Catch:{ Exception -> 0x0945 }
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0945 }
            r23 = r10
            java.lang.String r10 = "sVS"
            java.lang.Object r10 = r14.get(r10)     // Catch:{ Exception -> 0x0945 }
            java.util.List r10 = com.appsflyer.internal.AFa1uSDK.AFInAppEventParameterName(r10)     // Catch:{ Exception -> 0x0945 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0945 }
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r10 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.ALL     // Catch:{ Exception -> 0x0945 }
            if (r5 != r10) goto L_0x06f2
            java.lang.String r10 = "sVE"
            java.lang.Object r10 = r14.get(r10)     // Catch:{ all -> 0x0975 }
            java.util.List r10 = com.appsflyer.internal.AFa1uSDK.AFInAppEventParameterName(r10)     // Catch:{ all -> 0x0975 }
            r7.addAll(r10)     // Catch:{ all -> 0x0975 }
        L_0x06f2:
            com.appsflyer.internal.AFa1uSDK$AFa1wSDK r10 = com.appsflyer.internal.AFa1uSDK.AFa1wSDK.MAGNETOMETER     // Catch:{ Exception -> 0x0945 }
            java.lang.String r14 = "##.#"
            if (r1 != r10) goto L_0x07f6
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0945 }
            r1.<init>()     // Catch:{ Exception -> 0x0945 }
            r10 = 0
            java.lang.Object r25 = r7.get(r10)     // Catch:{ Exception -> 0x0945 }
            java.math.BigDecimal r25 = (java.math.BigDecimal) r25     // Catch:{ Exception -> 0x0945 }
            r10 = 1
            java.lang.Object r29 = r7.get(r10)     // Catch:{ Exception -> 0x0945 }
            java.math.BigDecimal r29 = (java.math.BigDecimal) r29     // Catch:{ Exception -> 0x0945 }
            r30 = r3
            r10 = r4
            double r3 = r25.doubleValue()     // Catch:{ Exception -> 0x07f1 }
            r31 = r10
            r25 = r11
            double r10 = r29.doubleValue()     // Catch:{ Exception -> 0x0973 }
            double r3 = java.lang.Math.atan2(r10, r3)     // Catch:{ Exception -> 0x0973 }
            r10 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r3 = r3 * r10
            java.math.BigDecimal r3 = java.math.BigDecimal.valueOf(r3)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r4 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r4.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r10 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r4.setRoundingMode(r10)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r4 = r4.format(r3)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r4)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r4 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r1.add(r4)     // Catch:{ Exception -> 0x0973 }
            r4 = 2
            java.lang.Object r10 = r7.get(r4)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r4 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r4.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r11 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r4.setRoundingMode(r11)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r4 = r4.format(r10)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r4)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r4 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r1.add(r4)     // Catch:{ Exception -> 0x0973 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0973 }
            r4.<init>()     // Catch:{ Exception -> 0x0973 }
            int r10 = r7.size()     // Catch:{ Exception -> 0x0973 }
            r11 = 5
            if (r10 <= r11) goto L_0x07de
            r10 = 3
            java.lang.Object r11 = r7.get(r10)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11     // Catch:{ Exception -> 0x0973 }
            r10 = 4
            java.lang.Object r29 = r7.get(r10)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r29 = (java.math.BigDecimal) r29     // Catch:{ Exception -> 0x0973 }
            double r10 = r11.doubleValue()     // Catch:{ Exception -> 0x0973 }
            r33 = r5
            r32 = r6
            double r5 = r29.doubleValue()     // Catch:{ Exception -> 0x0973 }
            double r5 = java.lang.Math.atan2(r5, r10)     // Catch:{ Exception -> 0x0973 }
            r10 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r5 = r5 * r10
            java.math.BigDecimal r5 = java.math.BigDecimal.valueOf(r5)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r3 = r5.subtract(r3)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r5.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r6 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r5.setRoundingMode(r6)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r3 = r5.format(r3)     // Catch:{ Exception -> 0x0973 }
            double r5 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r3 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0973 }
            r4.add(r3)     // Catch:{ Exception -> 0x0973 }
            r3 = 5
            java.lang.Object r5 = r7.get(r3)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r5 = (java.math.BigDecimal) r5     // Catch:{ Exception -> 0x0973 }
            r3 = 2
            java.lang.Object r3 = r7.get(r3)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r3 = (java.math.BigDecimal) r3     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r3 = r5.subtract(r3)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r5.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r6 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r5.setRoundingMode(r6)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r3 = r5.format(r3)     // Catch:{ Exception -> 0x0973 }
            double r5 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r3 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0973 }
            r4.add(r3)     // Catch:{ Exception -> 0x0973 }
            goto L_0x07e2
        L_0x07de:
            r33 = r5
            r32 = r6
        L_0x07e2:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0973 }
            r3.<init>()     // Catch:{ Exception -> 0x0973 }
            r3.add(r1)     // Catch:{ Exception -> 0x0973 }
            r3.add(r4)     // Catch:{ Exception -> 0x0973 }
            r4 = 4
            r5 = 5
            goto L_0x0901
        L_0x07f1:
            r0 = move-exception
            r31 = r10
            goto L_0x094a
        L_0x07f6:
            r30 = r3
            r31 = r4
            r33 = r5
            r32 = r6
            r25 = r11
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0973 }
            r1.<init>()     // Catch:{ Exception -> 0x0973 }
            int r3 = r7.size()     // Catch:{ Exception -> 0x0973 }
            r4 = 5
            if (r3 <= r4) goto L_0x088e
            r3 = 3
            java.lang.Object r4 = r7.get(r3)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r4 = (java.math.BigDecimal) r4     // Catch:{ Exception -> 0x0973 }
            r5 = 0
            java.lang.Object r6 = r7.get(r5)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r4 = r4.subtract(r6)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r5 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r5.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r6 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r5.setRoundingMode(r6)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ Exception -> 0x0973 }
            double r4 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r4)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0973 }
            r1.add(r4)     // Catch:{ Exception -> 0x0973 }
            r4 = 4
            java.lang.Object r5 = r7.get(r4)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r5 = (java.math.BigDecimal) r5     // Catch:{ Exception -> 0x0973 }
            r6 = 1
            java.lang.Object r10 = r7.get(r6)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r5 = r5.subtract(r10)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r6 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r6.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r10 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r6.setRoundingMode(r10)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r5 = r6.format(r5)     // Catch:{ Exception -> 0x0973 }
            double r5 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r5)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0973 }
            r1.add(r5)     // Catch:{ Exception -> 0x0973 }
            r5 = 5
            java.lang.Object r6 = r7.get(r5)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r6 = (java.math.BigDecimal) r6     // Catch:{ Exception -> 0x0973 }
            r10 = 2
            java.lang.Object r11 = r7.get(r10)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r6 = r6.subtract(r11)     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r10 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r10.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r11 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r10.setRoundingMode(r11)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r6 = r10.format(r6)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r6)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r6 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r1.add(r6)     // Catch:{ Exception -> 0x0973 }
            goto L_0x0891
        L_0x088e:
            r5 = r4
            r3 = 3
            r4 = 4
        L_0x0891:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0973 }
            r6.<init>()     // Catch:{ Exception -> 0x0973 }
            r10 = 0
            java.lang.Object r11 = r7.get(r10)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r11 = (java.math.BigDecimal) r11     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r10 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r10.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r3 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r10.setRoundingMode(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r3 = r10.format(r11)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r3 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r6.add(r3)     // Catch:{ Exception -> 0x0973 }
            r3 = 1
            java.lang.Object r10 = r7.get(r3)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r3.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r11 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r3.setRoundingMode(r11)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r3 = r3.format(r10)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r3 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r6.add(r3)     // Catch:{ Exception -> 0x0973 }
            r3 = 2
            java.lang.Object r3 = r7.get(r3)     // Catch:{ Exception -> 0x0973 }
            java.math.BigDecimal r3 = (java.math.BigDecimal) r3     // Catch:{ Exception -> 0x0973 }
            java.text.DecimalFormat r7 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0973 }
            r7.<init>(r14)     // Catch:{ Exception -> 0x0973 }
            java.math.RoundingMode r10 = java.math.RoundingMode.DOWN     // Catch:{ Exception -> 0x0973 }
            r7.setRoundingMode(r10)     // Catch:{ Exception -> 0x0973 }
            java.lang.String r3 = r7.format(r3)     // Catch:{ Exception -> 0x0973 }
            double r10 = com.appsflyer.internal.AFc1qSDK.AFa1vSDK.AFInAppEventParameterName(r3)     // Catch:{ Exception -> 0x0973 }
            java.lang.Double r3 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x0973 }
            r6.add(r3)     // Catch:{ Exception -> 0x0973 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0973 }
            r3.<init>()     // Catch:{ Exception -> 0x0973 }
            r3.add(r6)     // Catch:{ Exception -> 0x0973 }
            r3.add(r1)     // Catch:{ Exception -> 0x0973 }
        L_0x0901:
            r15.put(r8, r3)     // Catch:{ Exception -> 0x0973 }
            com.appsflyer.internal.AFa1uSDK$AFa1xSDK[] r1 = com.appsflyer.internal.AFa1uSDK.AFa1xSDK.values()     // Catch:{ Exception -> 0x0973 }
            int r3 = r13.intValue()     // Catch:{ Exception -> 0x0973 }
            r1 = r1[r3]     // Catch:{ Exception -> 0x0973 }
            java.lang.String r1 = r1.values     // Catch:{ Exception -> 0x0973 }
            r12.put(r1, r15)     // Catch:{ Exception -> 0x0973 }
            com.appsflyer.internal.AFa1uSDK$AFa1ySDK r1 = com.appsflyer.internal.AFa1uSDK.AFa1ySDK.FIRST     // Catch:{ Exception -> 0x0973 }
            r3 = r33
            if (r3 != r1) goto L_0x091e
            java.lang.String r1 = "no_svs"
            r12.put(r9, r1)     // Catch:{ Exception -> 0x0973 }
        L_0x091e:
            r1 = r36
            r5 = r17
            r13 = r19
            r7 = r22
            r10 = r23
            r11 = r25
            r3 = r30
            r4 = r31
            r6 = r32
            goto L_0x0664
        L_0x0932:
            r30 = r3
            r31 = r4
            r32 = r6
            r25 = r11
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x0973 }
            r12.<init>()     // Catch:{ Exception -> 0x0973 }
            java.lang.String r1 = "na"
            r12.put(r9, r1)     // Catch:{ Exception -> 0x0973 }
            goto L_0x0957
        L_0x0945:
            r0 = move-exception
            r30 = r3
            r31 = r4
        L_0x094a:
            r25 = r11
            goto L_0x0983
        L_0x094d:
            r30 = r3
            r31 = r4
            r32 = r6
            r25 = r11
            r19 = r13
        L_0x0957:
            java.lang.String r1 = "sensors"
            r3 = r32
            r3.put(r1, r12)     // Catch:{ Exception -> 0x0973 }
            goto L_0x096f
        L_0x095f:
            r30 = r3
            r31 = r4
            r3 = r6
            r25 = r11
            r19 = r13
            java.lang.String r1 = "sensors"
            java.lang.String r4 = "na"
            r3.put(r1, r4)     // Catch:{ Exception -> 0x0973 }
        L_0x096f:
            r2.putAll(r3)     // Catch:{ Exception -> 0x0973 }
            goto L_0x09a8
        L_0x0973:
            r0 = move-exception
            goto L_0x0983
        L_0x0975:
            r0 = move-exception
            r3 = r36
            goto L_0x0b49
        L_0x097a:
            r0 = move-exception
            r30 = r3
            r31 = r4
            r25 = r11
            r19 = r13
        L_0x0983:
            r1 = r0
        L_0x0984:
            java.lang.String r3 = "error while getting sensors data"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r1)     // Catch:{  }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r4 = "Unexpected exception from AFSensorManager: "
            r3.<init>(r4)     // Catch:{  }
            java.lang.String r1 = r1.getMessage()     // Catch:{  }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{  }
            java.lang.String r1 = r1.toString()     // Catch:{  }
            com.appsflyer.AFLogger.afRDLog(r1)     // Catch:{  }
            goto L_0x09a8
        L_0x09a0:
            r30 = r3
            r31 = r4
            r25 = r11
            r19 = r13
        L_0x09a8:
            java.lang.String r1 = AFInAppEventType((java.lang.String) r16)     // Catch:{  }
            if (r1 != 0) goto L_0x09c6
            r1 = r25
            com.appsflyer.internal.AFa1bSDK.AFInAppEventType(r1, r2)     // Catch:{  }
            java.lang.String r3 = "GAID_retry"
            java.lang.String r4 = AFInAppEventType((java.lang.String) r16)     // Catch:{  }
            if (r4 == 0) goto L_0x09bd
            r4 = 1
            goto L_0x09be
        L_0x09bd:
            r4 = 0
        L_0x09be:
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{  }
            r2.put(r3, r4)     // Catch:{  }
            goto L_0x09c8
        L_0x09c6:
            r1 = r25
        L_0x09c8:
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch:{  }
            com.appsflyer.internal.AFc1qSDK$AFa1vSDK r3 = com.appsflyer.internal.AFa1bSDK.values((android.content.ContentResolver) r3)     // Catch:{  }
            if (r3 == 0) goto L_0x09e4
            java.lang.String r4 = "amazon_aid"
            java.lang.String r5 = r3.AFInAppEventParameterName     // Catch:{  }
            r2.put(r4, r5)     // Catch:{  }
            java.lang.String r4 = "amazon_aid_limit"
            java.lang.Boolean r3 = r3.AFInAppEventType     // Catch:{  }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{  }
            r2.put(r4, r3)     // Catch:{  }
        L_0x09e4:
            boolean r3 = com.appsflyer.internal.AFe1mSDK.AFKeystoreWrapper((android.content.SharedPreferences) r31)     // Catch:{  }
            java.lang.String r4 = "registeredUninstall"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{  }
            r2.put(r4, r3)     // Catch:{  }
            r3 = r36
            r5 = r30
            r4 = r31
            int r6 = r3.AFKeystoreWrapper((android.content.SharedPreferences) r4, (boolean) r5)     // Catch:{ all -> 0x0b45 }
            java.lang.String r7 = "counter"
            java.lang.String r8 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0b45 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0b45 }
            java.lang.String r7 = "iaecounter"
            if (r19 == 0) goto L_0x0a0a
            r8 = 1
            goto L_0x0a0b
        L_0x0a0a:
            r8 = 0
        L_0x0a0b:
            int r8 = r3.values((android.content.SharedPreferences) r4, (boolean) r8)     // Catch:{ all -> 0x0b45 }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0b45 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0b45 }
            if (r5 == 0) goto L_0x0a1f
            r7 = 1
            if (r6 != r7) goto L_0x0a1f
            r8 = r21
            r8.values = r7     // Catch:{ all -> 0x0b45 }
        L_0x0a1f:
            java.lang.String r7 = "isFirstCall"
            boolean r8 = AFInAppEventParameterName((android.content.SharedPreferences) r4)     // Catch:{ all -> 0x0b45 }
            if (r8 != 0) goto L_0x0a29
            r8 = 1
            goto L_0x0a2a
        L_0x0a29:
            r8 = 0
        L_0x0a2a:
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ all -> 0x0b45 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0b45 }
            r3.valueOf(r1, r5, r2, r6)     // Catch:{ all -> 0x0b45 }
            com.appsflyer.internal.AFb1ySDK r5 = new com.appsflyer.internal.AFb1ySDK     // Catch:{ all -> 0x0b45 }
            r5.<init>()     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b45 }
            java.lang.String r6 = "af_v"
            r2.put(r6, r5)     // Catch:{ all -> 0x0b45 }
            com.appsflyer.internal.AFb1ySDK r5 = new com.appsflyer.internal.AFb1ySDK     // Catch:{ all -> 0x0b45 }
            r5.<init>()     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = com.appsflyer.internal.AFb1ySDK.AFInAppEventParameterName((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0b45 }
            java.lang.String r6 = "af_v2"
            r2.put(r6, r5)     // Catch:{ all -> 0x0b45 }
            boolean r5 = onInstallConversionFailureNative(r1)     // Catch:{ all -> 0x0b45 }
            java.lang.String r6 = "ivc"
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0b45 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = "is_stop_tracking_used"
            boolean r5 = r4.contains(r5)     // Catch:{ all -> 0x0b45 }
            if (r5 == 0) goto L_0x0a75
            java.lang.String r5 = "istu"
            java.lang.String r6 = "is_stop_tracking_used"
            r7 = 0
            boolean r4 = r4.getBoolean(r6, r7)     // Catch:{ all -> 0x0b45 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0b45 }
            r2.put(r5, r4)     // Catch:{ all -> 0x0b45 }
        L_0x0a75:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0b45 }
            r4.<init>()     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = "mcc"
            android.content.res.Resources r6 = r1.getResources()     // Catch:{ all -> 0x0b45 }
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch:{ all -> 0x0b45 }
            int r6 = r6.mcc     // Catch:{ all -> 0x0b45 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b45 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = "mnc"
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x0b45 }
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ all -> 0x0b45 }
            int r1 = r1.mnc     // Catch:{ all -> 0x0b45 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0b45 }
            r4.put(r5, r1)     // Catch:{ all -> 0x0b45 }
            java.lang.String r1 = "cell"
            r2.put(r1, r4)     // Catch:{ all -> 0x0b45 }
            java.lang.String r1 = "sig"
            r4 = r20
            android.app.Application r5 = r4.AFInAppEventType     // Catch:{ all -> 0x0b45 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x0b45 }
            android.app.Application r4 = r4.AFInAppEventType     // Catch:{ all -> 0x0b45 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0b45 }
            java.lang.String r4 = com.appsflyer.internal.AFa1cSDK.values((android.content.pm.PackageManager) r5, (java.lang.String) r4)     // Catch:{ all -> 0x0b45 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0b45 }
            java.lang.String r1 = "last_boot_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0b45 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0b45 }
            long r4 = r4 - r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0b45 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0b45 }
            java.lang.String r1 = "disk"
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ all -> 0x0b45 }
            java.io.File r5 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0b45 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0b45 }
            r4.<init>(r5)     // Catch:{ all -> 0x0b45 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b45 }
            r6 = 18
            if (r5 < r6) goto L_0x0af2
            long r5 = r4.getBlockSizeLong()     // Catch:{ all -> 0x0b45 }
            long r7 = r4.getAvailableBlocksLong()     // Catch:{ all -> 0x0b45 }
            long r7 = r7 * r5
            long r9 = r4.getBlockCountLong()     // Catch:{ all -> 0x0b45 }
            long r9 = r9 * r5
            goto L_0x0b02
        L_0x0af2:
            int r5 = r4.getBlockSize()     // Catch:{ all -> 0x0b45 }
            int r6 = r4.getAvailableBlocks()     // Catch:{ all -> 0x0b45 }
            int r6 = r6 * r5
            long r7 = (long) r6     // Catch:{ all -> 0x0b45 }
            int r4 = r4.getBlockCount()     // Catch:{ all -> 0x0b45 }
            int r4 = r4 * r5
            long r9 = (long) r4     // Catch:{ all -> 0x0b45 }
        L_0x0b02:
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r4 = java.lang.Math.pow(r4, r11)     // Catch:{ all -> 0x0b45 }
            double r6 = (double) r7     // Catch:{ all -> 0x0b45 }
            double r6 = r6 / r4
            long r6 = (long) r6     // Catch:{ all -> 0x0b45 }
            double r8 = (double) r9     // Catch:{ all -> 0x0b45 }
            double r8 = r8 / r4
            long r4 = (long) r8     // Catch:{ all -> 0x0b45 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b45 }
            r8.<init>()     // Catch:{ all -> 0x0b45 }
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch:{ all -> 0x0b45 }
            java.lang.String r7 = "/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0b45 }
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch:{ all -> 0x0b45 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0b45 }
            r2.put(r1, r4)     // Catch:{ all -> 0x0b45 }
            com.appsflyer.internal.AFa1eSDK r1 = r3.AFLogger     // Catch:{ all -> 0x0b45 }
            if (r1 == 0) goto L_0x0b52
            java.lang.String[] r1 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0b45 }
            if (r1 == 0) goto L_0x0b52
            java.lang.String r4 = "sharing_filter"
            r2.put(r4, r1)     // Catch:{ all -> 0x0b45 }
            goto L_0x0b52
        L_0x0b38:
            r3 = r1
            java.lang.String r1 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x0b45 }
            java.lang.String r1 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x0b45 }
            r1 = 0
            return r1
        L_0x0b45:
            r0 = move-exception
            goto L_0x0b49
        L_0x0b47:
            r0 = move-exception
            r3 = r1
        L_0x0b49:
            r1 = r0
            java.lang.String r4 = r1.getLocalizedMessage()
            r5 = 1
            com.appsflyer.AFLogger.afErrorLog(r4, r1, r5)
        L_0x0b52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK):java.util.Map");
    }

    private static void AFInAppEventType(Map<String, Object> map, AFe1fSDK aFe1fSDK) {
        HashMap hashMap = new HashMap(aFe1fSDK.AFInAppEventType);
        aFe1fSDK.AFInAppEventType.clear();
        aFe1fSDK.AFInAppEventParameterName.valueOf("gcd");
        if ((!hashMap.isEmpty() ? '%' : 'S') == '%') {
            int i = onAttributionFailure + 49;
            onResponse = i % 128;
            int i2 = i % 2;
            valueOf(map).put("gcd", hashMap);
            int i3 = onResponse + 47;
            onAttributionFailure = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private void afDebugLog() {
        int i = onAttributionFailure + 95;
        onResponse = i % 128;
        int i2 = i % 2;
        if (!AFd1hSDK.AFLogger()) {
            AFc1vSDK AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFd1pSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(new AFd1hSDK(AFKeystoreWrapper2)) {
                private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    */
                public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFd1pSDK.5.run():void, dex: classes2.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFd1pSDK.5.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            int i3 = onResponse + 31;
            onAttributionFailure = i3 % 128;
            if ((i3 % 2 == 0 ? 28 : '>') != '>') {
                Throwable th = null;
                super.hashCode();
                throw th;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if ((r5 == null ? 30 : ')') != 30) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r5 == null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        AFInAppEventType(r5);
        r5 = com.appsflyer.internal.AFb1wSDK.AFInAppEventParameterName((java.lang.ref.WeakReference<android.content.Context>) new java.lang.ref.WeakReference(AFKeystoreWrapper().AFInAppEventParameterName().values.AFKeystoreWrapper));
        r0 = onAttributionFailure + 115;
        onResponse = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        if ((r0 % 2) != 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAppsFlyerUID(android.content.Context r5) {
        /*
            r4 = this;
            int r0 = onResponse
            int r0 = r0 + 119
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L_0x000f
            r0 = r1
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            java.lang.String r2 = "getAppsFlyerUID"
            r3 = 0
            if (r0 == 0) goto L_0x002d
            com.appsflyer.internal.AFc1vSDK r0 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.AFVersionDeclaration()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.values((java.lang.String) r2, (java.lang.String[]) r1)
            r0 = 30
            if (r5 != 0) goto L_0x0028
            r1 = r0
            goto L_0x002a
        L_0x0028:
            r1 = 41
        L_0x002a:
            if (r1 == r0) goto L_0x003c
            goto L_0x004f
        L_0x002d:
            com.appsflyer.internal.AFc1vSDK r0 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.AFVersionDeclaration()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.values((java.lang.String) r2, (java.lang.String[]) r1)
            if (r5 != 0) goto L_0x004f
        L_0x003c:
            int r5 = onAttributionFailure
            int r5 = r5 + 97
            int r0 = r5 % 128
            onResponse = r0
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0049
            return r3
        L_0x0049:
            super.hashCode()     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x004d:
            r5 = move-exception
            throw r5
        L_0x004f:
            r4.AFInAppEventType((android.content.Context) r5)
            com.appsflyer.internal.AFc1vSDK r5 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1bSDK r5 = r5.AFInAppEventParameterName()
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            com.appsflyer.internal.AFc1wSDK r5 = r5.values
            android.content.Context r5 = r5.AFKeystoreWrapper
            r0.<init>(r5)
            java.lang.String r5 = com.appsflyer.internal.AFb1wSDK.AFInAppEventParameterName((java.lang.ref.WeakReference<android.content.Context>) r0)
            int r0 = onAttributionFailure
            int r0 = r0 + 115
            int r1 = r0 % 128
            onResponse = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0074
            return r5
        L_0x0074:
            throw r3     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.getAppsFlyerUID(android.content.Context):java.lang.String");
    }

    public final void setLogLevel(AFLogger.LogLevel logLevel) {
        int i = onAttributionFailure + 89;
        onResponse = i % 128;
        int i2 = i % 2;
        boolean z = false;
        AFKeystoreWrapper().AFVersionDeclaration().values("log", String.valueOf(logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
        int i3 = onAttributionFailure + 73;
        onResponse = i3 % 128;
        if (i3 % 2 != 0) {
            z = true;
        }
        if (z) {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Throwable, java.lang.Object, com.appsflyer.deeplink.DeepLinkResult$Error] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void AFInAppEventParameterName(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            int r0 = onResponse
            int r0 = r0 + 91
            int r1 = r0 % 128
            onAttributionFailure = r1
            int r0 = r0 % 2
            r6.AFInAppEventType((android.content.Context) r7)
            com.appsflyer.internal.AFc1vSDK r0 = r6.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1tSDK r0 = r0.onAppOpenAttributionNative()
            com.appsflyer.internal.AFc1vSDK r1 = r6.AFKeystoreWrapper()
            com.appsflyer.internal.AFc1xSDK r1 = r1.afErrorLog()
            android.net.Uri r2 = com.appsflyer.internal.AFa1tSDK.values(r8)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = r2.toString()
            boolean r2 = r2.isEmpty()
            r5 = 39
            if (r2 != 0) goto L_0x0034
            r2 = 29
            goto L_0x0035
        L_0x0034:
            r2 = r5
        L_0x0035:
            if (r2 == r5) goto L_0x0039
            r2 = r3
            goto L_0x003a
        L_0x0039:
            r2 = r4
        L_0x003a:
            java.lang.String r5 = "ddl_sent"
            boolean r1 = r1.AFInAppEventParameterName(r5)
            r5 = 37
            if (r1 == 0) goto L_0x0047
            r1 = 51
            goto L_0x0048
        L_0x0047:
            r1 = r5
        L_0x0048:
            if (r1 == r5) goto L_0x0069
            int r1 = onResponse
            int r1 = r1 + 111
            int r5 = r1 % 128
            onAttributionFailure = r5
            int r1 = r1 % 2
            r5 = 0
            if (r1 == 0) goto L_0x0063
            if (r2 != 0) goto L_0x005a
            r3 = r4
        L_0x005a:
            if (r3 == 0) goto L_0x005d
            goto L_0x0069
        L_0x005d:
            java.lang.String r7 = "No direct deep link"
            com.appsflyer.internal.AFb1oSDK.values(r7, r5)
            return
        L_0x0063:
            super.hashCode()     // Catch:{ all -> 0x0067 }
            throw r5     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r7 = move-exception
            throw r7
        L_0x0069:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.AFInAppEventType(r1, r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName(android.content.Context, android.content.Intent):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFKeystoreWrapper(int r6, java.lang.String r7, int r8, int r9, boolean r10, java.lang.Object[] r11) {
        /*
            if (r7 == 0) goto L_0x0006
            char[] r7 = r7.toCharArray()
        L_0x0006:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.AFg1mSDK.valueOf
            monitor-enter(r0)
            char[] r1 = new char[r9]     // Catch:{ all -> 0x0075 }
            r2 = 0
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r2     // Catch:{ all -> 0x0075 }
        L_0x0010:
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            if (r3 >= r9) goto L_0x0033
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            char r3 = r7[r3]     // Catch:{ all -> 0x0075 }
            com.appsflyer.internal.AFg1mSDK.AFInAppEventType = r3     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r4 = com.appsflyer.internal.AFg1mSDK.AFInAppEventType     // Catch:{ all -> 0x0075 }
            int r4 = r4 + r8
            char r4 = (char) r4     // Catch:{ all -> 0x0075 }
            r1[r3] = r4     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            char r4 = r1[r3]     // Catch:{ all -> 0x0075 }
            int r5 = onAppOpenAttribution     // Catch:{ all -> 0x0075 }
            int r4 = r4 - r5
            char r4 = (char) r4     // Catch:{ all -> 0x0075 }
            r1[r3] = r4     // Catch:{ all -> 0x0075 }
            int r3 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r3 = r3 + 1
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r3     // Catch:{ all -> 0x0075 }
            goto L_0x0010
        L_0x0033:
            if (r6 <= 0) goto L_0x004e
            com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper = r6     // Catch:{ all -> 0x0075 }
            char[] r6 = new char[r9]     // Catch:{ all -> 0x0075 }
            java.lang.System.arraycopy(r1, r2, r6, r2, r9)     // Catch:{ all -> 0x0075 }
            int r7 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r7 = r9 - r7
            int r8 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            java.lang.System.arraycopy(r6, r2, r1, r7, r8)     // Catch:{ all -> 0x0075 }
            int r7 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r8 = com.appsflyer.internal.AFg1mSDK.AFKeystoreWrapper     // Catch:{ all -> 0x0075 }
            int r8 = r9 - r8
            java.lang.System.arraycopy(r6, r7, r1, r2, r8)     // Catch:{ all -> 0x0075 }
        L_0x004e:
            if (r10 == 0) goto L_0x006c
            char[] r6 = new char[r9]     // Catch:{ all -> 0x0075 }
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r2     // Catch:{ all -> 0x0075 }
        L_0x0054:
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            if (r7 >= r9) goto L_0x006b
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r8 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r8 = r9 - r8
            int r8 = r8 + -1
            char r8 = r1[r8]     // Catch:{ all -> 0x0075 }
            r6[r7] = r8     // Catch:{ all -> 0x0075 }
            int r7 = com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName     // Catch:{ all -> 0x0075 }
            int r7 = r7 + 1
            com.appsflyer.internal.AFg1mSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x0075 }
            goto L_0x0054
        L_0x006b:
            r1 = r6
        L_0x006c:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0075 }
            r6.<init>(r1)     // Catch:{ all -> 0x0075 }
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            r11[r2] = r6
            return
        L_0x0075:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(int, java.lang.String, int, int, boolean, java.lang.Object[]):void");
    }
}
