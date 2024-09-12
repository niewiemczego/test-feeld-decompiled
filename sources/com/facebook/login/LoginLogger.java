package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import io.sentry.SentryEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\\\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u001c\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010'\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginLogger;", "", "context", "Landroid/content/Context;", "applicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "facebookVersion", "logger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "logAuthorizationMethodComplete", "", "authId", "method", "result", "errorMessage", "errorCode", "loggingExtras", "", "eventName", "logAuthorizationMethodNotTried", "logAuthorizationMethodStart", "logCompleteLogin", "loginRequestId", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "exception", "Ljava/lang/Exception;", "logHeartbeatEvent", "logLoginStatusError", "loggerRef", "logLoginStatusFailure", "logLoginStatusStart", "logLoginStatusSuccess", "logStartLogin", "pendingLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "logUnexpectedError", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginLogger.kt */
public final class LoginLogger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    public static final String EVENT_EXTRAS_FAILURE = "failure";
    public static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    public static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    public static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    public static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    public static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    public static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    public static final String EVENT_EXTRAS_TARGET_APP = "target_app";
    public static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    public static final String EVENT_NAME_FOA_LOGIN_COMPLETE = "foa_mobile_login_complete";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE = "foa_mobile_login_method_complete";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED = "foa_mobile_login_method_not_tried";
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_START = "foa_mobile_login_method_start";
    public static final String EVENT_NAME_FOA_LOGIN_START = "foa_mobile_login_start";
    public static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    public static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    public static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    public static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    public static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    public static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    public static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    public static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    public static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    public static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    public static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    public static final String EVENT_PARAM_EXTRAS = "6_extras";
    public static final String EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED = "foa_skipped";
    public static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    public static final String EVENT_PARAM_METHOD = "3_method";
    public static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    private final String applicationId;
    private String facebookVersion;
    private final InternalAppEventsLogger logger;

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodComplete$default(this, str, str2, str3, str4, str5, map, (String) null, 64, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodNotTried(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodNotTried$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logAuthorizationMethodStart(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logAuthorizationMethodStart$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(map, "loggingExtras");
                logCompleteLogin$default(this, str, map, code, map2, exc, (String) null, 32, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logStartLogin(LoginClient.Request request) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(request, "pendingLoginRequest");
                logStartLogin$default(this, request, (String) null, 2, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logUnexpectedError(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logUnexpectedError$default(this, str, str2, (String) null, 4, (Object) null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "applicationId");
        this.applicationId = str;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.applicationId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static /* synthetic */ void logStartLogin$default(LoginLogger loginLogger, LoginClient.Request request, String str, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 2) != 0) {
                str = EVENT_NAME_LOGIN_START;
            }
            try {
                loginLogger.logStartLogin(request, str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:4|5|6|7|(1:9)|10|(1:12)|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logStartLogin(com.facebook.login.LoginClient.Request r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "pendingLoginRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x0087 }
            com.facebook.login.LoginLogger$Companion r0 = Companion     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r6.getAuthId()     // Catch:{ all -> 0x0087 }
            android.os.Bundle r0 = r0.newAuthorizationLoggingBundle(r1)     // Catch:{ all -> 0x0087 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0081 }
            r1.<init>()     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = "login_behavior"
            com.facebook.login.LoginBehavior r3 = r6.getLoginBehavior()     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = "request_code"
            com.facebook.login.LoginClient$Companion r3 = com.facebook.login.LoginClient.Companion     // Catch:{ JSONException -> 0x0081 }
            int r3 = r3.getLoginRequestCode()     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (int) r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = "permissions"
            java.lang.String r3 = ","
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0081 }
            java.util.Set r4 = r6.getPermissions()     // Catch:{ JSONException -> 0x0081 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r3 = android.text.TextUtils.join(r3, r4)     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = "default_audience"
            com.facebook.login.DefaultAudience r3 = r6.getDefaultAudience()     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = "isReauthorize"
            boolean r3 = r6.isRerequest()     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (boolean) r3)     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r2 = r5.facebookVersion     // Catch:{ JSONException -> 0x0081 }
            if (r2 == 0) goto L_0x0065
            java.lang.String r3 = "facebookVersion"
            r1.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x0081 }
        L_0x0065:
            com.facebook.login.LoginTargetApp r2 = r6.getLoginTargetApp()     // Catch:{ JSONException -> 0x0081 }
            if (r2 == 0) goto L_0x0078
            java.lang.String r2 = "target_app"
            com.facebook.login.LoginTargetApp r6 = r6.getLoginTargetApp()     // Catch:{ JSONException -> 0x0081 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x0081 }
            r1.put((java.lang.String) r2, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x0081 }
        L_0x0078:
            java.lang.String r6 = "6_extras"
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0081 }
            r0.putString(r6, r1)     // Catch:{ JSONException -> 0x0081 }
        L_0x0081:
            com.facebook.appevents.InternalAppEventsLogger r6 = r5.logger     // Catch:{ all -> 0x0087 }
            r6.logEventImplicitly(r7, r0)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginLogger.logStartLogin(com.facebook.login.LoginClient$Request, java.lang.String):void");
    }

    public static /* synthetic */ void logCompleteLogin$default(LoginLogger loginLogger, String str, Map map, LoginClient.Result.Code code, Map map2, Exception exc, String str2, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 32) != 0) {
                str2 = EVENT_NAME_LOGIN_COMPLETE;
            }
            try {
                loginLogger.logCompleteLogin(str, map, code, map2, exc, str2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc, String str2) {
        String str3;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(map, "loggingExtras");
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                if (code != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
                }
                JSONObject jSONObject = null;
                if (exc == null) {
                    str3 = null;
                } else {
                    str3 = exc.getMessage();
                }
                if (str3 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
                }
                if (!map.isEmpty()) {
                    jSONObject = new JSONObject((Map<?, ?>) map);
                }
                if (map2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    try {
                        for (Map.Entry next : map2.entrySet()) {
                            String str4 = (String) next.getKey();
                            String str5 = (String) next.getValue();
                            if (str4 != null) {
                                jSONObject.put(str4, (Object) str5);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONObject != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
                }
                this.logger.logEventImplicitly(str2, access$newAuthorizationLoggingBundle);
                if (code == LoginClient.Result.Code.SUCCESS) {
                    logHeartbeatEvent(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void logHeartbeatEvent(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                worker.schedule(new LoginLogger$$ExternalSyntheticLambda0(this, Companion.newAuthorizationLoggingBundle(str)), 5, TimeUnit.SECONDS);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: logHeartbeatEvent$lambda-0  reason: not valid java name */
    public static final void m389logHeartbeatEvent$lambda0(LoginLogger loginLogger, Bundle bundle) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(loginLogger, "this$0");
                Intrinsics.checkNotNullParameter(bundle, "$bundle");
                loginLogger.logger.logEventImplicitly(EVENT_NAME_LOGIN_HEARTBEAT, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static /* synthetic */ void logAuthorizationMethodStart$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = EVENT_NAME_LOGIN_METHOD_START;
            }
            try {
                loginLogger.logAuthorizationMethodStart(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logAuthorizationMethodStart(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static /* synthetic */ void logAuthorizationMethodComplete$default(LoginLogger loginLogger, String str, String str2, String str3, String str4, String str5, Map map, String str6, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                loginLogger.logAuthorizationMethodComplete(str, str2, str3, str4, str5, map, (i & 64) != 0 ? EVENT_NAME_LOGIN_METHOD_COMPLETE : str6);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                if (str3 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
                }
                if (str4 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
                }
                if (str5 != null) {
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
                }
                if (map != null && (!map.isEmpty())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry next : map.entrySet()) {
                        if (((String) next.getKey()) != null) {
                            linkedHashMap.put(next.getKey(), next.getValue());
                        }
                    }
                    access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject((Map<?, ?>) linkedHashMap).toString());
                }
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str6, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static /* synthetic */ void logAuthorizationMethodNotTried$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = EVENT_NAME_LOGIN_METHOD_NOT_TRIED;
            }
            try {
                loginLogger.logAuthorizationMethodNotTried(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logAuthorizationMethodNotTried(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
                this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusStart(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, Companion.newAuthorizationLoggingBundle(str));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusSuccess(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusFailure(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusError(String str, Exception exc) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(exc, SentryEvent.JsonKeys.EXCEPTION);
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static /* synthetic */ void logUnexpectedError$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        Class<LoginLogger> cls = LoginLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            try {
                loginLogger.logUnexpectedError(str, str2, str3);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logUnexpectedError(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle("");
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
                access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
                this.logger.logEventImplicitly(str, access$newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n **\u0004\u0018\u00010)0)X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/login/LoginLogger$Companion;", "", "()V", "EVENT_EXTRAS_DEFAULT_AUDIENCE", "", "EVENT_EXTRAS_FACEBOOK_VERSION", "EVENT_EXTRAS_FAILURE", "EVENT_EXTRAS_IS_REAUTHORIZE", "EVENT_EXTRAS_LOGIN_BEHAVIOR", "EVENT_EXTRAS_MISSING_INTERNET_PERMISSION", "EVENT_EXTRAS_NEW_PERMISSIONS", "EVENT_EXTRAS_NOT_TRIED", "EVENT_EXTRAS_PERMISSIONS", "EVENT_EXTRAS_REQUEST_CODE", "EVENT_EXTRAS_TARGET_APP", "EVENT_EXTRAS_TRY_LOGIN_ACTIVITY", "EVENT_NAME_FOA_LOGIN_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_FOA_LOGIN_METHOD_START", "EVENT_NAME_FOA_LOGIN_START", "EVENT_NAME_LOGIN_COMPLETE", "EVENT_NAME_LOGIN_HEARTBEAT", "EVENT_NAME_LOGIN_METHOD_COMPLETE", "EVENT_NAME_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_LOGIN_METHOD_START", "EVENT_NAME_LOGIN_START", "EVENT_NAME_LOGIN_STATUS_COMPLETE", "EVENT_NAME_LOGIN_STATUS_START", "EVENT_PARAM_AUTH_LOGGER_ID", "EVENT_PARAM_CHALLENGE", "EVENT_PARAM_ERROR_CODE", "EVENT_PARAM_ERROR_MESSAGE", "EVENT_PARAM_EXTRAS", "EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED", "EVENT_PARAM_LOGIN_RESULT", "EVENT_PARAM_METHOD", "EVENT_PARAM_METHOD_RESULT_SKIPPED", "EVENT_PARAM_TIMESTAMP", "FACEBOOK_PACKAGE_NAME", "worker", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "newAuthorizationLoggingBundle", "Landroid/os/Bundle;", "authLoggerId", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginLogger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Bundle newAuthorizationLoggingBundle(String str) {
            Bundle bundle = new Bundle();
            bundle.putLong(LoginLogger.EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(LoginLogger.EVENT_PARAM_METHOD, "");
            bundle.putString(LoginLogger.EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_EXTRAS, "");
            return bundle;
        }
    }
}
