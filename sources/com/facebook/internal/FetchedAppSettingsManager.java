package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002BCB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%H\u0007J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004H\u0002J\u0014\u00104\u001a\u0004\u0018\u00010\"2\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u00105\u001a\u00020/H\u0007J\u001d\u00106\u001a\u00020\"2\u0006\u00103\u001a\u00020\u00042\u0006\u00107\u001a\u000202H\u0000¢\u0006\u0002\b8J*\u00109\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0!0:2\b\u0010<\u001a\u0004\u0018\u000102H\u0002J\b\u0010=\u001a\u00020/H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u00103\u001a\u00020\u00042\u0006\u0010?\u001a\u00020'H\u0007J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020'H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010*0*0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", "", "()V", "APPLICATION_FIELDS", "", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTINGS_PREFS_STORE", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_AAM_RULE", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_FIELDS", "", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "SDK_UPDATE_MESSAGE", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SUGGESTED_EVENTS_SETTING", "TAG", "kotlin.jvm.PlatformType", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "fetchedAppSettings", "", "Lcom/facebook/internal/FetchedAppSettings;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "isUnityInit", "", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "printedSDKUpdatedMessage", "unityEventBindings", "Lorg/json/JSONArray;", "getAppSettingsAsync", "", "callback", "getAppSettingsQueryResponse", "Lorg/json/JSONObject;", "applicationId", "getAppSettingsWithoutQuery", "loadAppSettingsAsync", "parseAppSettingsFromJSON", "settingsJSON", "parseAppSettingsFromJSON$facebook_core_release", "parseDialogConfigurations", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigResponse", "pollCallbacks", "queryAppSettings", "forceRequery", "setIsUnityInit", "flag", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FetchedAppSettingsManager.kt */
public final class FetchedAppSettingsManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final List<String> APP_SETTING_FIELDS = CollectionsKt.listOf(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING);
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String TAG = "FetchedAppSettingsManager";
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    private static boolean isUnityInit;
    private static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    private static boolean printedSDKUpdatedMessage;
    private static JSONArray unityEventBindings;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FetchedAppSettingsManager.kt */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FetchedAppSettingsManager.kt */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    private FetchedAppSettingsManager() {
    }

    @JvmStatic
    public static final void loadAppSettingsAsync() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        } else {
            AtomicReference<FetchAppSettingState> atomicReference = loadingState;
            if (!(LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
                INSTANCE.pollCallbacks();
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new FetchedAppSettingsManager$$ExternalSyntheticLambda0(applicationContext, format, applicationId));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppSettingsAsync$lambda-0  reason: not valid java name */
    public static final void m332loadAppSettingsAsync$lambda0(Context context, String str, String str2) {
        FetchAppSettingState fetchAppSettingState;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$settingsKey");
        Intrinsics.checkNotNullParameter(str2, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings fetchedAppSettings2 = null;
        String string = sharedPreferences.getString(str, (String) null);
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(Utility.LOG_TAG, (Exception) e);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    fetchedAppSettings2 = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str2, jSONObject);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(str2);
        if (appSettingsQueryResponse != null) {
            fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str2, appSettingsQueryResponse);
            sharedPreferences.edit().putString(str, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings2 != null) {
            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
                Log.w(TAG, sdkUpdateMessage);
            }
        }
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.queryAppGateKeepers(str2, true);
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        AutomaticAnalyticsLogger.logActivateAppEvent();
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        if (fetchedAppSettings.containsKey(str2)) {
            fetchAppSettingState = FetchAppSettingState.SUCCESS;
        } else {
            fetchAppSettingState = FetchAppSettingState.ERROR;
        }
        atomicReference.set(fetchAppSettingState);
        fetchedAppSettingsManager.pollCallbacks();
    }

    @JvmStatic
    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    @JvmStatic
    public static final void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        Intrinsics.checkNotNullParameter(fetchedAppSettingsCallback, "callback");
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void pollCallbacks() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState> r0 = loadingState     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState) r0     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED     // Catch:{ all -> 0x0061 }
            if (r1 == r0) goto L_0x005f
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.LOADING     // Catch:{ all -> 0x0061 }
            if (r1 != r0) goto L_0x0012
            goto L_0x005f
        L_0x0012:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x0061 }
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r2 = fetchedAppSettings     // Catch:{ all -> 0x0061 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettings r1 = (com.facebook.internal.FetchedAppSettings) r1     // Catch:{ all -> 0x0061 }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0061 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0061 }
            r2.<init>(r3)     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r3 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR     // Catch:{ all -> 0x0061 }
            if (r3 != r0) goto L_0x0046
        L_0x002d:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0061 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r1 != 0) goto L_0x0044
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$$ExternalSyntheticLambda1 r1 = new com.facebook.internal.FetchedAppSettingsManager$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0061 }
            r1.<init>(r0)     // Catch:{ all -> 0x0061 }
            r2.post(r1)     // Catch:{ all -> 0x0061 }
            goto L_0x002d
        L_0x0044:
            monitor-exit(r4)
            return
        L_0x0046:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0061 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r3 != 0) goto L_0x005d
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0061 }
            com.facebook.internal.FetchedAppSettingsManager$$ExternalSyntheticLambda2 r3 = new com.facebook.internal.FetchedAppSettingsManager$$ExternalSyntheticLambda2     // Catch:{ all -> 0x0061 }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x0061 }
            r2.post(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x0046
        L_0x005d:
            monitor-exit(r4)
            return
        L_0x005f:
            monitor-exit(r4)
            return
        L_0x0061:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.pollCallbacks():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m333pollCallbacks$lambda1(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        fetchedAppSettingsCallback.onError();
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-2  reason: not valid java name */
    public static final void m334pollCallbacks$lambda2(FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings2) {
        fetchedAppSettingsCallback.onSuccess(fetchedAppSettings2);
    }

    @JvmStatic
    public static final FetchedAppSettings queryAppSettings(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        if (!z) {
            Map<String, FetchedAppSettings> map = fetchedAppSettings;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str, appSettingsQueryResponse);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (Intrinsics.areEqual((Object) str, (Object) FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(jSONObject2, "settingsJSON");
        FacebookRequestErrorClassification createFromJSON = FacebookRequestErrorClassification.Companion.createFromJSON(jSONObject2.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES));
        if (createFromJSON == null) {
            createFromJSON = FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = createFromJSON;
        int optInt = jSONObject2.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & 16384) != 0;
        JSONArray optJSONArray = jSONObject2.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray;
        if (optJSONArray != null) {
            InternalSettings internalSettings = InternalSettings.INSTANCE;
            if (InternalSettings.isUnityApp()) {
                UnityReflection unityReflection = UnityReflection.INSTANCE;
                UnityReflection.sendEventMapping(optJSONArray == null ? null : optJSONArray.toString());
            }
        }
        boolean optBoolean = jSONObject2.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = jSONObject2.optString(APP_SETTING_NUX_CONTENT, "");
        String str2 = optString;
        Intrinsics.checkNotNullExpressionValue(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = jSONObject2.optBoolean(APP_SETTING_NUX_ENABLED, false);
        Constants constants = Constants.INSTANCE;
        int optInt2 = jSONObject2.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.Companion.parseOptions(jSONObject2.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(jSONObject2.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = jSONObject2.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = jSONObject2.optString(SMART_LOGIN_MENU_ICON_URL);
        String str3 = optString3;
        FetchedAppSettings fetchedAppSettings2 = r3;
        Intrinsics.checkNotNullExpressionValue(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = jSONObject2.optString(SDK_UPDATE_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings3 = new FetchedAppSettings(optBoolean, str2, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z, facebookRequestErrorClassification, optString2, str3, z2, z3, optJSONArray, optString4, z4, z5, jSONObject2.optString(APP_SETTING_APP_EVENTS_AAM_RULE), jSONObject2.optString(SUGGESTED_EVENTS_SETTING), jSONObject2.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD));
        FetchedAppSettings fetchedAppSettings4 = fetchedAppSettings2;
        fetchedAppSettings.put(str, fetchedAppSettings4);
        return fetchedAppSettings4;
    }

    @JvmStatic
    public static final void setIsUnityInit(boolean z) {
        isUnityInit = z;
        if (unityEventBindings != null && z) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            UnityReflection.sendEventMapping(String.valueOf(unityEventBindings));
        }
    }

    private final JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        List arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, App.TYPE, (GraphRequest.Callback) null);
        newGraphPathRequest.setForceApplicationRequest(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "dialogConfigData.optJSONObject(i)");
                    FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(optJSONObject);
                    if (parseDialogConfig != null) {
                        String dialogName = parseDialogConfig.getDialogName();
                        Map map = (Map) hashMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(dialogName, map);
                        }
                        map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        return hashMap;
    }
}
