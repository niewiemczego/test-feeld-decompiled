package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0014J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010 \u001a\u00020!H\u0016J\"\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0014J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020!H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020+H&J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020$H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "methodLoggingExtras", "", "", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "nameForLogging", "getNameForLogging", "()Ljava/lang/String;", "addLoggingExtra", "", "key", "value", "", "cancel", "getClientState", "authId", "getRedirectUrl", "logWebLoginCompleted", "e2e", "needsInternetPermission", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "processCodeExchange", "Landroid/os/Bundle;", "request", "Lcom/facebook/login/LoginClient$Request;", "values", "putChallengeParam", "param", "Lorg/json/JSONObject;", "shouldKeepTrackOfMultipleIntents", "tryAuthorize", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginMethodHandler.kt */
public abstract class LoginMethodHandler implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    private Map<String, String> methodLoggingExtras;

    @JvmStatic
    public static final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    @JvmStatic
    public static final AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    @JvmStatic
    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    @JvmStatic
    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    @JvmStatic
    public static final String getUserIDFromSignedRequest(String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    public void cancel() {
    }

    public abstract String getNameForLogging();

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    public final void setMethodLoggingExtras(Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    public final void setLoginClient(LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "<set-?>");
        this.loginClient = loginClient2;
    }

    public LoginMethodHandler(LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "loginClient");
        setLoginClient(loginClient2);
    }

    protected LoginMethodHandler(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        Utility utility = Utility.INSTANCE;
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(parcel);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : MapsKt.toMutableMap(readStringMapFromParcel);
    }

    /* access modifiers changed from: protected */
    public String getRedirectUrl() {
        StringBuilder append = new StringBuilder().append("fb");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return append.append(FacebookSdk.getApplicationId()).append("://authorize/").toString();
    }

    /* access modifiers changed from: protected */
    public String getClientState(String str) {
        Intrinsics.checkNotNullParameter(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, (Object) str);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, (Object) getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", Intrinsics.stringPlus("Error creating client state json: ", e.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            String put = map.put(str, obj == null ? null : obj.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void logWebLoginCompleted(String str) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        String applicationId = pendingRequest == null ? null : pendingRequest.getApplicationId();
        if (applicationId == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            applicationId = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, (Double) null, bundle);
    }

    /* access modifiers changed from: protected */
    public Bundle processCodeExchange(LoginClient.Request request, Bundle bundle) throws FacebookException {
        GraphRequest graphRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "values");
        String string = bundle.getString("code");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                graphRequest = null;
            } else {
                PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
                String redirectUrl = getRedirectUrl();
                String codeVerifier = request.getCodeVerifier();
                if (codeVerifier == null) {
                    codeVerifier = "";
                }
                graphRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            }
            if (graphRequest != null) {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                FacebookRequestError error = executeAndWait.getError();
                if (error == null) {
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject != null) {
                            Utility utility2 = Utility.INSTANCE;
                            if (!Utility.isNullOrEmpty(str)) {
                                bundle.putString("access_token", str);
                                if (jSONObject.has("id_token")) {
                                    bundle.putString("id_token", jSONObject.getString("id_token"));
                                }
                                return bundle;
                            }
                        }
                        throw new FacebookException("No access token found from result");
                    } catch (JSONException e) {
                        throw new FacebookException(Intrinsics.stringPlus("Fail to process code exchange response: ", e.getMessage()));
                    }
                } else {
                    throw new FacebookServiceException(error, error.getErrorMessage());
                }
            } else {
                throw new FacebookException("Failed to create code exchange request");
            }
        } else {
            throw new FacebookException("No code param found from the request");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", "", "()V", "NO_SIGNED_REQUEST_ERROR_MESSAGE", "", "NO_USER_ID_ERROR_MESSAGE", "USER_CANCELED_LOG_IN_ERROR_MESSAGE", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "createAccessTokenFromWebBundle", "requestedPermissions", "", "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string != null) {
                boolean z = true;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e) {
                            throw new FacebookException(e.getMessage());
                        }
                    }
                }
            }
            AuthenticationToken authenticationToken = null;
            return null;
        }

        @JvmStatic
        public final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
            String string;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility2 = Utility.INSTANCE;
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (string2 != null) {
                boolean z = true;
                if (!(string2.length() == 0) && (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) != null) {
                    if (string.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        return new AccessToken(string2, str, string, stringArrayList, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        @JvmStatic
        public final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                boolean z = true;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e) {
                            throw new FacebookException(e.getMessage(), (Throwable) e);
                        }
                    }
                }
            }
            AuthenticationToken authenticationToken = null;
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x010f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0110  */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.AccessToken createAccessTokenFromWebBundle(java.util.Collection<java.lang.String> r20, android.os.Bundle r21, com.facebook.AccessTokenSource r22, java.lang.String r23) throws com.facebook.FacebookException {
            /*
                r19 = this;
                r0 = r21
                java.lang.String r1 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.lang.String r1 = "applicationId"
                r4 = r23
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r1 = new java.util.Date
                r1.<init>()
                java.lang.String r2 = "expires_in"
                java.util.Date r10 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r2, r1)
                java.lang.String r1 = "access_token"
                java.lang.String r3 = r0.getString(r1)
                r1 = 0
                if (r3 != 0) goto L_0x0025
                return r1
            L_0x0025:
                com.facebook.internal.Utility r2 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r2 = new java.util.Date
                r5 = 0
                r2.<init>(r5)
                java.lang.String r5 = "data_access_expiration_time"
                java.util.Date r12 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r5, r2)
                java.lang.String r2 = "granted_scopes"
                java.lang.String r2 = r0.getString(r2)
                java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.lang.String r6 = ","
                r7 = 1
                r8 = 0
                if (r2 == 0) goto L_0x007e
                r13 = r2
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                int r2 = r13.length()
                if (r2 <= 0) goto L_0x004d
                r2 = r7
                goto L_0x004e
            L_0x004d:
                r2 = r8
            L_0x004e:
                if (r2 == 0) goto L_0x007e
                java.lang.String[] r14 = new java.lang.String[]{r6}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r2 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.String[] r9 = new java.lang.String[r8]
                java.lang.Object[] r2 = r2.toArray(r9)
                if (r2 == 0) goto L_0x0078
                java.lang.String[] r2 = (java.lang.String[]) r2
                int r9 = r2.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r9)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt.arrayListOf(r2)
                java.util.Collection r2 = (java.util.Collection) r2
                r9 = r2
                goto L_0x0080
            L_0x0078:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x007e:
                r9 = r20
            L_0x0080:
                java.lang.String r2 = "denied_scopes"
                java.lang.String r2 = r0.getString(r2)
                if (r2 == 0) goto L_0x00c3
                r13 = r2
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                int r2 = r13.length()
                if (r2 <= 0) goto L_0x0093
                r2 = r7
                goto L_0x0094
            L_0x0093:
                r2 = r8
            L_0x0094:
                if (r2 == 0) goto L_0x00c3
                java.lang.String[] r14 = new java.lang.String[]{r6}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r2 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.String[] r11 = new java.lang.String[r8]
                java.lang.Object[] r2 = r2.toArray(r11)
                if (r2 == 0) goto L_0x00bd
                java.lang.String[] r2 = (java.lang.String[]) r2
                int r11 = r2.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r11)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt.arrayListOf(r2)
                java.util.List r2 = (java.util.List) r2
                goto L_0x00c4
            L_0x00bd:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x00c3:
                r2 = r1
            L_0x00c4:
                java.lang.String r11 = "expired_scopes"
                java.lang.String r11 = r0.getString(r11)
                if (r11 == 0) goto L_0x0106
                r13 = r11
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                int r11 = r13.length()
                if (r11 <= 0) goto L_0x00d6
                goto L_0x00d7
            L_0x00d6:
                r7 = r8
            L_0x00d7:
                if (r7 == 0) goto L_0x0106
                java.lang.String[] r14 = new java.lang.String[]{r6}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r6 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r6 = (java.util.Collection) r6
                java.lang.String[] r7 = new java.lang.String[r8]
                java.lang.Object[] r6 = r6.toArray(r7)
                if (r6 == 0) goto L_0x0100
                java.lang.String[] r6 = (java.lang.String[]) r6
                int r5 = r6.length
                java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r5)
                java.util.ArrayList r5 = kotlin.collections.CollectionsKt.arrayListOf(r5)
                java.util.List r5 = (java.util.List) r5
                goto L_0x0107
            L_0x0100:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r5)
                throw r0
            L_0x0106:
                r5 = r1
            L_0x0107:
                com.facebook.internal.Utility r6 = com.facebook.internal.Utility.INSTANCE
                boolean r6 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r3)
                if (r6 == 0) goto L_0x0110
                return r1
            L_0x0110:
                java.lang.String r1 = "graph_domain"
                java.lang.String r13 = r0.getString(r1)
                java.lang.String r1 = "signed_request"
                java.lang.String r0 = r0.getString(r1)
                r1 = r19
                java.lang.String r0 = r1.getUserIDFromSignedRequest(r0)
                com.facebook.AccessToken r14 = new com.facebook.AccessToken
                r7 = r2
                java.util.Collection r7 = (java.util.Collection) r7
                r8 = r5
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Date r11 = new java.util.Date
                r11.<init>()
                r2 = r14
                r4 = r23
                r5 = r0
                r6 = r9
                r9 = r22
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.Companion.createAccessTokenFromWebBundle(java.util.Collection, android.os.Bundle, com.facebook.AccessTokenSource, java.lang.String):com.facebook.AccessToken");
        }

        @JvmStatic
        public final String getUserIDFromSignedRequest(String str) throws FacebookException {
            if (str != null) {
                if (!(str.length() == 0)) {
                    try {
                        Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                byte[] decode = Base64.decode(strArr[1], 0);
                                Intrinsics.checkNotNullExpressionValue(decode, "data");
                                String string = new JSONObject(new String(decode, Charsets.UTF_8)).getString("user_id");
                                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"user_id\")");
                                return string;
                            }
                            throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                }
            }
            throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
        }
    }
}
