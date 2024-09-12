package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentJoinDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import io.sentry.protocol.Request;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0004'()*B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"H\u0014J\u001a\u0010#\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u001a\u0010$\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020&H\u0014R.\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u00160\u0011R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "payload", "requestID", "", "tournamentID", "canShow", "", "content", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "registerCallbackImpl", "", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "callback", "Lcom/facebook/FacebookCallback;", "show", "showImpl", "mode", "", "ChromeCustomTabHandler", "Companion", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentJoinDialog.kt */
public final class TournamentJoinDialog extends FacebookDialogBase<String, Result> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.TournamentJoinDialog.toRequestCode();
    private static final String JOIN_TOURNAMENT_ACCESS_TOKEN_KEY = "access_token";
    private static final String JOIN_TOURNAMENT_ACTION = "com.facebook.games.gaming_services.DEEPLINK";
    private static final String JOIN_TOURNAMENT_CONTENT_TYPE = "text/plain";
    private static final String JOIN_TOURNAMENT_DIALOG = "join_tournament";
    private static final String JOIN_TOURNAMENT_ERROR_MESSAGE_KEY = "error_message";
    /* access modifiers changed from: private */
    public String payload;
    private Number requestID;
    /* access modifiers changed from: private */
    public String tournamentID;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "JOIN_TOURNAMENT_ACCESS_TOKEN_KEY", "", "JOIN_TOURNAMENT_ACTION", "JOIN_TOURNAMENT_CONTENT_TYPE", "JOIN_TOURNAMENT_DIALOG", "JOIN_TOURNAMENT_ERROR_MESSAGE_KEY", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentJoinDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    private TournamentJoinDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    public final void show(String str, String str2) {
        this.tournamentID = str;
        this.payload = str2;
        super.showImpl(str, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public void showImpl(String str, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "mode");
        if (!CloudGameLoginHandler.isRunningInCloud()) {
            super.showImpl(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManagerImpl, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        callbackManagerImpl.registerCallback(getRequestCode(), new TournamentJoinDialog$$ExternalSyntheticLambda0(this, new TournamentJoinDialog$registerCallbackImpl$resultProcessor$1(facebookCallback)));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallbackImpl$lambda-0  reason: not valid java name */
    public static final boolean m319registerCallbackImpl$lambda0(TournamentJoinDialog tournamentJoinDialog, ResultProcessor resultProcessor, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(tournamentJoinDialog, "this$0");
        Intrinsics.checkNotNullParameter(resultProcessor, "$resultProcessor");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        return ShareInternalUtility.handleActivityResult(tournamentJoinDialog.getRequestCode(), i, intent, resultProcessor);
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<String, Result>.ModeHandler> getOrderedModeHandlers() {
        return CollectionsKt.listOf(new FacebookAppHandler(this), new ChromeCustomTabHandler(this));
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", "requestID", "getRequestID", "setRequestID", "tournamentID", "getTournamentID", "setTournamentID", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentJoinDialog.kt */
    public static final class Result {
        private String payload;
        private String requestID;
        private String tournamentID;

        public Result(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "results");
            if (bundle.getString("request") != null) {
                this.requestID = bundle.getString("request");
            }
            this.tournamentID = bundle.getString(SDKConstants.PARAM_TOURNAMENTS_ID);
            this.payload = bundle.getString("payload");
        }

        public final String getRequestID() {
            return this.requestID;
        }

        public final void setRequestID(String str) {
            this.requestID = str;
        }

        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setTournamentID(String str) {
            this.tournamentID = str;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }
    }

    public boolean canShow(String str) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return false;
        }
        if (new FacebookAppHandler(this).canShow(str, true)) {
            return true;
        }
        return new ChromeCustomTabHandler(this).canShow(str, true);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentJoinDialog.kt */
    private final class FacebookAppHandler extends FacebookDialogBase<String, Result>.ModeHandler {
        final /* synthetic */ TournamentJoinDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FacebookAppHandler(TournamentJoinDialog tournamentJoinDialog) {
            super(tournamentJoinDialog);
            Intrinsics.checkNotNullParameter(tournamentJoinDialog, "this$0");
            this.this$0 = tournamentJoinDialog;
        }

        public boolean canShow(String str, boolean z) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "FacebookSdk.getApplicationContext().packageManager");
            Intent intent = new Intent(TournamentJoinDialog.JOIN_TOURNAMENT_ACTION);
            intent.setType("text/plain");
            return intent.resolveActivity(packageManager) != null;
        }

        public AppCall createAppCall(String str) {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Intent intent = new Intent(TournamentJoinDialog.JOIN_TOURNAMENT_ACTION);
            intent.setType("text/plain");
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to present TournamentJoinDialog with an invalid access token");
            } else if (currentAccessToken.getGraphDomain() == null || Intrinsics.areEqual((Object) FacebookSdk.GAMING, (Object) currentAccessToken.getGraphDomain())) {
                Bundle bundle$facebook_gamingservices_release = TournamentJoinDialogURIBuilder.INSTANCE.bundle$facebook_gamingservices_release(currentAccessToken.getApplicationId(), this.this$0.tournamentID, this.this$0.payload);
                NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.PROTOCOL_VERSION_20210906, bundle$facebook_gamingservices_release);
                createBaseAppCall.setRequestIntent(intent);
                return createBaseAppCall;
            } else {
                throw new FacebookException("Attempted to present TournamentJoinDialog while user is not gaming logged in");
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$ChromeCustomTabHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentJoinDialog.kt */
    private final class ChromeCustomTabHandler extends FacebookDialogBase<String, Result>.ModeHandler {
        final /* synthetic */ TournamentJoinDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChromeCustomTabHandler(TournamentJoinDialog tournamentJoinDialog) {
            super(tournamentJoinDialog);
            Intrinsics.checkNotNullParameter(tournamentJoinDialog, "this$0");
            this.this$0 = tournamentJoinDialog;
        }

        public boolean canShow(String str, boolean z) {
            CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
            return CustomTabUtils.getChromePackage() != null;
        }

        public AppCall createAppCall(String str) {
            String str2;
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            String str3 = null;
            if (currentAccessToken == null) {
                str2 = null;
            } else {
                str2 = currentAccessToken.getApplicationId();
            }
            if (str2 == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                str2 = FacebookSdk.getApplicationId();
            }
            bundle.putString("app_id", str2);
            bundle.putString("payload", bundle2.toString());
            if (currentAccessToken != null) {
                currentAccessToken.getToken();
            }
            if (currentAccessToken != null) {
                str3 = currentAccessToken.getToken();
            }
            bundle.putString("access_token", str3);
            CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, TournamentJoinDialog.JOIN_TOURNAMENT_DIALOG, bundle);
            return createBaseAppCall;
        }
    }
}
