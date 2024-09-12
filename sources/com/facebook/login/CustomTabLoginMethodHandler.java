package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "chromePackage", "", "getChromePackage", "()Ljava/lang/String;", "currentPackage", "developerDefinedRedirectURI", "getDeveloperDefinedRedirectURI", "expectedChallenge", "nameForLogging", "getNameForLogging", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "validRedirectURI", "describeContents", "", "getRedirectUrl", "getSSODevice", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCustomTabComplete", "", "url", "request", "Lcom/facebook/login/LoginClient$Request;", "putChallengeParam", "param", "Lorg/json/JSONObject;", "tryAuthorize", "validateChallengeParam", "values", "Landroid/os/Bundle;", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabLoginMethodHandler.kt */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new CustomTabLoginMethodHandler$Companion$CREATOR$1();
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch;
    private String currentPackage;
    private String expectedChallenge;
    private final String nameForLogging = "custom_tab";
    private final AccessTokenSource tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
    private String validRedirectURI;

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        Utility utility = Utility.INSTANCE;
        this.expectedChallenge = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    private final String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    /* access modifiers changed from: protected */
    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        if (getRedirectUrl().length() == 0) {
            return 0;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            addExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, "1");
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(InstagramCustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            } else {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(CustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            }
        }
        FragmentActivity activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, OAUTH_DIALOG);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.getLoginTargetApp().toString());
        Fragment fragment = loginClient.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    private final String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        String chromePackage = CustomTabUtils.getChromePackage();
        this.currentPackage = chromePackage;
        return chromePackage;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.onActivityResult(i, i2, intent);
        }
        if (i != 1) {
            return super.onActivityResult(i, i2, intent);
        }
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            return false;
        }
        String str = null;
        if (i2 == -1) {
            if (intent != null) {
                str = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL);
            }
            onCustomTabComplete(str, pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, (Bundle) null, new FacebookOperationCanceledException());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCustomTabComplete(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00df
            java.lang.String r0 = "fbconnect://cct."
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r7, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = super.getRedirectUrl()
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r7, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x00df
        L_0x0017:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = com.facebook.internal.Utility.parseUrlQueryString(r0)
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = com.facebook.internal.Utility.parseUrlQueryString(r7)
            r0.putAll(r7)
            boolean r7 = r6.validateChallengeParam(r0)
            if (r7 != 0) goto L_0x0043
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>((java.lang.String) r0)
            super.onComplete(r8, r3, r7)
            return
        L_0x0043:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L_0x0051
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L_0x0051:
            java.lang.String r1 = "error_msg"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L_0x005f
            java.lang.String r1 = "error_message"
            java.lang.String r1 = r0.getString(r1)
        L_0x005f:
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = "error_description"
            java.lang.String r1 = r0.getString(r1)
        L_0x0067:
            java.lang.String r2 = "error_code"
            java.lang.String r2 = r0.getString(r2)
            r4 = -1
            if (r2 != 0) goto L_0x0071
            goto L_0x0076
        L_0x0071:
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
            r2 = r4
        L_0x0077:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
            if (r5 == 0) goto L_0x00a4
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r1)
            if (r5 == 0) goto L_0x00a4
            if (r2 != r4) goto L_0x00a4
            java.lang.String r7 = "access_token"
            boolean r7 = r0.containsKey(r7)
            if (r7 == 0) goto L_0x0095
            super.onComplete(r8, r0, r3)
            return
        L_0x0095:
            com.facebook.FacebookSdk r7 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r7 = com.facebook.FacebookSdk.getExecutor()
            com.facebook.login.CustomTabLoginMethodHandler$$ExternalSyntheticLambda0 r1 = new com.facebook.login.CustomTabLoginMethodHandler$$ExternalSyntheticLambda0
            r1.<init>(r6, r8, r0)
            r7.execute(r1)
            goto L_0x00df
        L_0x00a4:
            if (r7 == 0) goto L_0x00c1
            java.lang.String r0 = "access_denied"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x00b6
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00c1
        L_0x00b6:
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            com.facebook.FacebookException r7 = (com.facebook.FacebookException) r7
            super.onComplete(r8, r3, r7)
            goto L_0x00df
        L_0x00c1:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r2 != r0) goto L_0x00d0
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            com.facebook.FacebookException r7 = (com.facebook.FacebookException) r7
            super.onComplete(r8, r3, r7)
            goto L_0x00df
        L_0x00d0:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r2, r7, r1)
            com.facebook.FacebookServiceException r7 = new com.facebook.FacebookServiceException
            r7.<init>(r0, r1)
            com.facebook.FacebookException r7 = (com.facebook.FacebookException) r7
            super.onComplete(r8, r3, r7)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.onCustomTabComplete(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCustomTabComplete$lambda-0  reason: not valid java name */
    public static final void m375onCustomTabComplete$lambda0(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(customTabLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$values");
        try {
            customTabLoginMethodHandler.onComplete(request, customTabLoginMethodHandler.processCodeExchange(request, bundle), (FacebookException) null);
        } catch (FacebookException e) {
            customTabLoginMethodHandler.onComplete(request, (Bundle) null, e);
        }
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
        jSONObject.put(LoginLogger.EVENT_PARAM_CHALLENGE, (Object) this.expectedChallenge);
    }

    private final boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return Intrinsics.areEqual((Object) new JSONObject(string).getString(LoginLogger.EVENT_PARAM_CHALLENGE), (Object) this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.expectedChallenge = parcel.readString();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "CHALLENGE_LENGTH", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/CustomTabLoginMethodHandler;", "CUSTOM_TAB_REQUEST_CODE", "OAUTH_DIALOG", "", "calledThroughLoggedOutAppSwitch", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CustomTabLoginMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
