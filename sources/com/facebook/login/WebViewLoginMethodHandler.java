package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001dH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "e2e", "", "getE2e", "()Ljava/lang/String;", "setE2e", "(Ljava/lang/String;)V", "loginDialog", "Lcom/facebook/internal/WebDialog;", "getLoginDialog", "()Lcom/facebook/internal/WebDialog;", "setLoginDialog", "(Lcom/facebook/internal/WebDialog;)V", "nameForLogging", "getNameForLogging", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "cancel", "", "describeContents", "", "needsInternetPermission", "", "onWebDialogComplete", "request", "Lcom/facebook/login/LoginClient$Request;", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "tryAuthorize", "writeToParcel", "dest", "flags", "AuthDialogBuilder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebViewLoginMethodHandler.kt */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new WebViewLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OAUTH_DIALOG = "oauth";
    private String e2e;
    private WebDialog loginDialog;
    private final String nameForLogging = "web_view";
    private final AccessTokenSource tokenSource = AccessTokenSource.WEB_VIEW;

    public int describeContents() {
        return 0;
    }

    public boolean needsInternetPermission() {
        return true;
    }

    public final WebDialog getLoginDialog() {
        return this.loginDialog;
    }

    public final void setLoginDialog(WebDialog webDialog) {
        this.loginDialog = webDialog;
    }

    public final String getE2e() {
        return this.e2e;
    }

    public final void setE2e(String str) {
        this.e2e = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle parameters = getParameters(request);
        WebViewLoginMethodHandler$tryAuthorize$listener$1 webViewLoginMethodHandler$tryAuthorize$listener$1 = new WebViewLoginMethodHandler$tryAuthorize$listener$1(this, request);
        String e2e2 = LoginClient.Companion.getE2E();
        this.e2e = e2e2;
        addLoggingExtra("e2e", e2e2);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        Utility utility = Utility.INSTANCE;
        Context context = activity;
        boolean isChromeOS = Utility.isChromeOS(context);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, context, request.getApplicationId(), parameters);
        String str = this.e2e;
        if (str != null) {
            this.loginDialog = authDialogBuilder.setE2E(str).setIsChromeOS(isChromeOS).setAuthType(request.getAuthType()).setLoginBehavior(request.getLoginBehavior()).setLoginTargetApp(request.getLoginTargetApp()).setFamilyLogin(request.isFamilyLogin()).setShouldSkipDedupe(request.shouldSkipAccountDeduplication()).setOnCompleteListener(webViewLoginMethodHandler$tryAuthorize$listener$1).build();
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.setInnerDialog(this.loginDialog);
            facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
            return 1;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onComplete(request, bundle, facebookException);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\f\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\u001c\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0005J\u0012\u0010\u001d\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u001e\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0012J\u0012\u0010 \u001a\u00060\u0000R\u00020\u001b2\u0006\u0010!\u001a\u00020\u0012J\u0012\u0010\"\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010#\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010$\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010%\u001a\u00020\u0012R\u001a\u0010\t\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "Lcom/facebook/internal/WebDialog$Builder;", "context", "Landroid/content/Context;", "applicationId", "", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/login/WebViewLoginMethodHandler;Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "authType", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "e2e", "getE2e", "setE2e", "isFamilyLogin", "", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "redirect_uri", "shouldSkipDedupe", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "build", "Lcom/facebook/internal/WebDialog;", "Lcom/facebook/login/WebViewLoginMethodHandler;", "setE2E", "setFamilyLogin", "setIsChromeOS", "isChromeOS", "setIsRerequest", "isRerequest", "setLoginBehavior", "setLoginTargetApp", "setShouldSkipDedupe", "shouldSkip", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebViewLoginMethodHandler.kt */
    public final class AuthDialogBuilder extends WebDialog.Builder {
        public String authType;
        public String e2e;
        private boolean isFamilyLogin;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private String redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;
        private boolean shouldSkipDedupe;
        private LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;
        final /* synthetic */ WebViewLoginMethodHandler this$0;

        public final AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        public final String getE2e() {
            String str = this.e2e;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("e2e");
            throw null;
        }

        public final void setE2e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e2e = str;
        }

        public final String getAuthType() {
            String str = this.authType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("authType");
            throw null;
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m398setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthDialogBuilder(WebViewLoginMethodHandler webViewLoginMethodHandler, Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            Intrinsics.checkNotNullParameter(webViewLoginMethodHandler, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(bundle, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
            this.this$0 = webViewLoginMethodHandler;
        }

        public final AuthDialogBuilder setE2E(String str) {
            Intrinsics.checkNotNullParameter(str, "e2e");
            setE2e(str);
            return this;
        }

        public final AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public final AuthDialogBuilder setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "authType");
            setAuthType(str);
            return this;
        }

        public final AuthDialogBuilder setLoginBehavior(LoginBehavior loginBehavior2) {
            Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
            this.loginBehavior = loginBehavior2;
            return this;
        }

        public final AuthDialogBuilder setLoginTargetApp(LoginTargetApp loginTargetApp) {
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            this.targetApp = loginTargetApp;
            return this;
        }

        public final AuthDialogBuilder setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
            return this;
        }

        public final AuthDialogBuilder setShouldSkipDedupe(boolean z) {
            this.shouldSkipDedupe = z;
            return this;
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            if (parameters != null) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
                parameters.putString("client_id", getApplicationId());
                parameters.putString("e2e", getE2e());
                parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.targetApp == LoginTargetApp.INSTAGRAM ? ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES : ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
                parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, getAuthType());
                parameters.putString("login_behavior", this.loginBehavior.name());
                if (this.isFamilyLogin) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_FX_APP, this.targetApp.toString());
                }
                if (this.shouldSkipDedupe) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                WebDialog.Companion companion = WebDialog.Companion;
                Context context = getContext();
                if (context != null) {
                    return companion.newInstance(context, "oauth", parameters, getTheme(), this.targetApp, getListener());
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/WebViewLoginMethodHandler;", "OAUTH_DIALOG", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebViewLoginMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
        this.e2e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }
}
