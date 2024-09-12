package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\r\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0015\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0001¢\u0006\u0002\b!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CodelessManager.kt */
public final class CodelessManager {
    public static final CodelessManager INSTANCE = new CodelessManager();
    private static String deviceSessionID;
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);
    private static volatile boolean isCheckingSession;
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static SensorManager sensorManager;
    private static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    private final boolean isDebugOnEmulator() {
        CrashShieldHandler.isObjectCrashing(this);
        return false;
    }

    private CodelessManager() {
    }

    @JvmStatic
    public static final void onActivityResumed(Activity activity) {
        Boolean bool;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().add(activity);
                    Context applicationContext = activity.getApplicationContext();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String applicationId = FacebookSdk.getApplicationId();
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                    if (appSettingsWithoutQuery == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(appSettingsWithoutQuery.getCodelessEventsEnabled());
                    }
                    if (Intrinsics.areEqual((Object) bool, (Object) true) || INSTANCE.isDebugOnEmulator()) {
                        SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                        if (sensorManager2 != null) {
                            sensorManager = sensorManager2;
                            Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
                            ViewIndexer viewIndexer2 = new ViewIndexer(activity);
                            viewIndexer = viewIndexer2;
                            ViewIndexingTrigger viewIndexingTrigger2 = viewIndexingTrigger;
                            viewIndexingTrigger2.setOnShakeListener(new CodelessManager$$ExternalSyntheticLambda1(appSettingsWithoutQuery, applicationId));
                            sensorManager2.registerListener(viewIndexingTrigger2, defaultSensor, 2);
                            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                                viewIndexer2.schedule();
                            }
                        } else {
                            return;
                        }
                    }
                    CodelessManager codelessManager = INSTANCE;
                    if (codelessManager.isDebugOnEmulator() && !isAppIndexingEnabled.get()) {
                        codelessManager.checkCodelessSession(applicationId);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    public static final void m255onActivityResumed$lambda0(FetchedAppSettings fetchedAppSettings, String str) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$appId");
                boolean z = true;
                boolean z2 = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (!FacebookSdk.getCodelessSetupEnabled()) {
                    z = false;
                }
                if (z2 && z) {
                    INSTANCE.checkCodelessSession(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void onActivityPaused(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().remove(activity);
                    ViewIndexer viewIndexer2 = viewIndexer;
                    if (viewIndexer2 != null) {
                        viewIndexer2.unschedule();
                    }
                    SensorManager sensorManager2 = sensorManager;
                    if (sensorManager2 != null) {
                        sensorManager2.unregisterListener(viewIndexingTrigger);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void onActivityDestroyed(Activity activity) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                CodelessMatcher.Companion.getInstance().destroy(activity);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void enable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(true);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void disable() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isCodelessEnabled.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void checkCodelessSession(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isCheckingSession) {
                    isCheckingSession = true;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new CodelessManager$$ExternalSyntheticLambda0(str));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkCodelessSession$lambda-1  reason: not valid java name */
    public static final void m254checkCodelessSession$lambda1(String str) {
        String str2;
        String str3 = "0";
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) Build.MODEL != null ? Build.MODEL : "");
                if (attributionIdentifiers == null) {
                    str2 = null;
                } else {
                    str2 = attributionIdentifiers.getAndroidAdvertiserId();
                }
                if (str2 != null) {
                    jSONArray.put((Object) attributionIdentifiers.getAndroidAdvertiserId());
                } else {
                    jSONArray.put((Object) "");
                }
                jSONArray.put((Object) str3);
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                if (AppEventUtility.isEmulator()) {
                    str3 = "1";
                }
                jSONArray.put((Object) str3);
                Utility utility = Utility.INSTANCE;
                Locale currentLocale = Utility.getCurrentLocale();
                jSONArray.put((Object) currentLocale.getLanguage() + '_' + currentLocale.getCountry());
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "extInfoArray.toString()");
                bundle.putString(Constants.DEVICE_SESSION_ID, getCurrentDeviceSessionID$facebook_core_release());
                bundle.putString(Constants.EXTINFO, jSONArray2);
                GraphRequest.Companion companion = GraphRequest.Companion;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                boolean z = true;
                String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                JSONObject jSONObject = companion.newPostRequestWithBundle((AccessToken) null, format, bundle, (GraphRequest.Callback) null).executeAndWait().getJSONObject();
                AtomicBoolean atomicBoolean = isAppIndexingEnabled;
                if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                    z = false;
                }
                atomicBoolean.set(z);
                if (!atomicBoolean.get()) {
                    deviceSessionID = null;
                } else {
                    ViewIndexer viewIndexer2 = viewIndexer;
                    if (viewIndexer2 != null) {
                        viewIndexer2.schedule();
                    }
                }
                isCheckingSession = false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final void updateAppIndexing$facebook_core_release(boolean z) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isAppIndexingEnabled.set(z);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
