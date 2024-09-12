package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import io.sentry.protocol.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR@\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8A@@X\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", "", "()V", "SETTINGS_PATH", "", "TAG", "kotlin.jvm.PlatformType", "isEnabled", "", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", "valuesToSave", "", "savedCloudBridgeCredentials", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "enable", "", "getCAPIGSettingsFromGraphResponse", "response", "Lcom/facebook/GraphResponse;", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsCAPIManager.kt */
public final class AppEventsCAPIManager {
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static final String TAG = AppEventsCAPIManager.class.getCanonicalName();
    private static boolean isEnabled;

    private AppEventsCAPIManager() {
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z) {
        isEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[Catch:{ all -> 0x00aa }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        /*
            java.lang.Class<com.facebook.appevents.cloudbridge.AppEventsCAPIManager> r0 = com.facebook.appevents.cloudbridge.AppEventsCAPIManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00aa }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00aa }
            java.lang.String r3 = "com.facebook.sdk.CloudBridgeSavedCredentials"
            r4 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x001a
            return r2
        L_0x001a:
            com.facebook.appevents.cloudbridge.SettingsAPIFields r3 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x00aa }
            java.lang.String r3 = r3.getRawValue()     // Catch:{ all -> 0x00aa }
            java.lang.String r3 = r1.getString(r3, r2)     // Catch:{ all -> 0x00aa }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r5 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = r5.getRawValue()     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = r1.getString(r5, r2)     // Catch:{ all -> 0x00aa }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r6 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = r6.getRawValue()     // Catch:{ all -> 0x00aa }
            java.lang.String r1 = r1.getString(r6, r2)     // Catch:{ all -> 0x00aa }
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00aa }
            r7 = 1
            if (r6 == 0) goto L_0x0047
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r6 = r4
            goto L_0x0048
        L_0x0047:
            r6 = r7
        L_0x0048:
            if (r6 != 0) goto L_0x00a9
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0058
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r6 = r4
            goto L_0x0059
        L_0x0058:
            r6 = r7
        L_0x0059:
            if (r6 != 0) goto L_0x00a9
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0069
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r6 = r4
            goto L_0x006a
        L_0x0069:
            r6 = r7
        L_0x006a:
            if (r6 == 0) goto L_0x006d
            goto L_0x00a9
        L_0x006d:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00aa }
            r6.<init>()     // Catch:{ all -> 0x00aa }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00aa }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x00aa }
            r6.put(r8, r5)     // Catch:{ all -> 0x00aa }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x00aa }
            r6.put(r8, r3)     // Catch:{ all -> 0x00aa }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x00aa }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x00aa }
            r6.put(r8, r1)     // Catch:{ all -> 0x00aa }
            com.facebook.internal.Logger$Companion r8 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x00aa }
            com.facebook.LoggingBehavior r9 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ all -> 0x00aa }
            java.lang.String r10 = TAG     // Catch:{ all -> 0x00aa }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00aa }
            java.lang.String r11 = " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n "
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x00aa }
            r12[r4] = r3     // Catch:{ all -> 0x00aa }
            r12[r7] = r5     // Catch:{ all -> 0x00aa }
            r3 = 2
            r12[r3] = r1     // Catch:{ all -> 0x00aa }
            r8.log((com.facebook.LoggingBehavior) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.Object[]) r12)     // Catch:{ all -> 0x00aa }
            return r6
        L_0x00a9:
            return r2
        L_0x00aa:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsCAPIManager.getSavedCloudBridgeCredentials$facebook_core_release():java.util.Map");
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(Map<String, ? extends Object> map) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences != null) {
            if (map == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
                return;
            }
            Object obj = map.get(SettingsAPIFields.DATASETID.getRawValue());
            Object obj2 = map.get(SettingsAPIFields.URL.getRawValue());
            Object obj3 = map.get(SettingsAPIFields.ACCESSKEY.getRawValue());
            if (obj != null && obj2 != null && obj3 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(SettingsAPIFields.DATASETID.getRawValue(), obj.toString());
                edit2.putString(SettingsAPIFields.URL.getRawValue(), obj2.toString());
                edit2.putString(SettingsAPIFields.ACCESSKEY.getRawValue(), obj3.toString());
                edit2.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
            }
        }
    }

    @JvmStatic
    public static final void enable() {
        try {
            AppEventsCAPIManager$$ExternalSyntheticLambda0 appEventsCAPIManager$$ExternalSyntheticLambda0 = new AppEventsCAPIManager$$ExternalSyntheticLambda0();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphRequest graphRequest = new GraphRequest((AccessToken) null, Intrinsics.stringPlus(FacebookSdk.getApplicationId(), SETTINGS_PATH), (Bundle) null, HttpMethod.GET, appEventsCAPIManager$$ExternalSyntheticLambda0, (String) null, 32, (DefaultConstructorMarker) null);
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 != null) {
                companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", ExceptionsKt.stackTraceToString(e));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m249enable$lambda0(GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(graphResponse);
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        boolean z = false;
        if (graphResponse.getError() != null) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", graphResponse.getError().toString(), String.valueOf(graphResponse.getError().getException()));
                Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
                if (savedCloudBridgeCredentials$facebook_core_release != null) {
                    URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                    AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                    AppEventsConversionsAPITransformerWebRequests.configure(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue())), url.getProtocol() + "://" + url.getHost(), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                    isEnabled = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Logger.Companion companion2 = Logger.Companion;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String str2 = TAG;
        if (str2 != null) {
            companion2.log(loggingBehavior2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", graphResponse);
            JSONObject jSONObject = graphResponse.getJSONObject();
            try {
                Utility utility = Utility.INSTANCE;
                Object obj = jSONObject == null ? null : jSONObject.get("data");
                if (obj != null) {
                    List<String> convertJSONArrayToList = Utility.convertJSONArrayToList((JSONArray) obj);
                    Utility utility2 = Utility.INSTANCE;
                    Map<String, Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) CollectionsKt.firstOrNull(convertJSONArrayToList)));
                    String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
                    String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
                    String str5 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
                    if (str3 == null || str4 == null || str5 == null) {
                        Logger.Companion companion3 = Logger.Companion;
                        LoggingBehavior loggingBehavior3 = LoggingBehavior.APP_EVENTS;
                        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                        companion3.log(loggingBehavior3, str2, "CloudBridge Settings API response doesn't have valid data");
                        return;
                    }
                    try {
                        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests2 = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                        AppEventsConversionsAPITransformerWebRequests.configure(str4, str3, str5);
                        setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                        if (convertJSONObjectToHashMap.get(SettingsAPIFields.ENABLED.getRawValue()) != null) {
                            Object obj2 = convertJSONObjectToHashMap.get(SettingsAPIFields.ENABLED.getRawValue());
                            if (obj2 != null) {
                                z = ((Boolean) obj2).booleanValue();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        }
                        isEnabled = z;
                    } catch (MalformedURLException e) {
                        Logger.Companion companion4 = Logger.Companion;
                        LoggingBehavior loggingBehavior4 = LoggingBehavior.APP_EVENTS;
                        String str6 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str6, "TAG");
                        companion4.log(loggingBehavior4, str6, "CloudBridge Settings API response doesn't have valid url\n %s ", ExceptionsKt.stackTraceToString(e));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } catch (JSONException e2) {
                Logger.Companion companion5 = Logger.Companion;
                LoggingBehavior loggingBehavior5 = LoggingBehavior.APP_EVENTS;
                String str7 = TAG;
                Intrinsics.checkNotNullExpressionValue(str7, "TAG");
                companion5.log(loggingBehavior5, str7, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e2));
            } catch (NullPointerException e3) {
                Logger.Companion companion6 = Logger.Companion;
                LoggingBehavior loggingBehavior6 = LoggingBehavior.APP_EVENTS;
                String str8 = TAG;
                Intrinsics.checkNotNullExpressionValue(str8, "TAG");
                companion6.log(loggingBehavior6, str8, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e3));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }
}
