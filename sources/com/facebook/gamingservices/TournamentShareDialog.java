package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.webkit.internal.AssetHelper;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import io.sentry.protocol.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 /2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0004./01B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010 \u001a\u00020!H\u0014J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030'H\u0014J\u0016\u0010(\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010(\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0002J\u001a\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020-H\u0014R.\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u00160\u0011R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "score", "", "getScore", "()Ljava/lang/Number;", "setScore", "(Ljava/lang/Number;)V", "tournament", "Lcom/facebook/gamingservices/Tournament;", "getTournament", "()Lcom/facebook/gamingservices/Tournament;", "setTournament", "(Lcom/facebook/gamingservices/Tournament;)V", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "registerCallbackImpl", "", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "callback", "Lcom/facebook/FacebookCallback;", "show", "newTournamentConfig", "showImpl", "content", "mode", "", "AppSwitchHandler", "Companion", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TournamentShareDialog.kt */
public final class TournamentShareDialog extends FacebookDialogBase<TournamentConfig, Result> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int defaultRequestCode = CallbackManagerImpl.RequestCodeOffset.TournamentShareDialog.toRequestCode();
    private Number score;
    private Tournament tournament;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$Companion;", "", "()V", "defaultRequestCode", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentShareDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Number getScore() {
        return this.score;
    }

    public final void setScore(Number number) {
        this.score = number;
    }

    public final Tournament getTournament() {
        return this.tournament;
    }

    public final void setTournament(Tournament tournament2) {
        this.tournament = tournament2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(Activity activity) {
        super(activity, defaultRequestCode);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TournamentShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, Request.JsonKeys.FRAGMENT);
    }

    private TournamentShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, defaultRequestCode);
    }

    public final void show(Number number, TournamentConfig tournamentConfig) {
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(tournamentConfig, "newTournamentConfig");
        this.score = number;
        showImpl(tournamentConfig, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    public final void show(Number number, Tournament tournament2) {
        Intrinsics.checkNotNullParameter(number, "score");
        Intrinsics.checkNotNullParameter(tournament2, "tournament");
        this.score = number;
        this.tournament = tournament2;
        showImpl((TournamentConfig) null, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public void showImpl(TournamentConfig tournamentConfig, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "mode");
        if (!CloudGameLoginHandler.isRunningInCloud()) {
            super.showImpl(tournamentConfig, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManagerImpl, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        callbackManagerImpl.registerCallback(getRequestCode(), new TournamentShareDialog$$ExternalSyntheticLambda0(this, new TournamentShareDialog$registerCallbackImpl$resultProcessor$1(facebookCallback)));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallbackImpl$lambda-0  reason: not valid java name */
    public static final boolean m321registerCallbackImpl$lambda0(TournamentShareDialog tournamentShareDialog, ResultProcessor resultProcessor, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(tournamentShareDialog, "this$0");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        return ShareInternalUtility.handleActivityResult(tournamentShareDialog.getRequestCode(), i, intent, resultProcessor);
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<TournamentConfig, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler(this));
        arrayList.add(new AppSwitchHandler(this));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "requestID", "", "getRequestID", "()Ljava/lang/String;", "setRequestID", "(Ljava/lang/String;)V", "tournamentID", "getTournamentID", "setTournamentID", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentShareDialog.kt */
    public static final class Result {
        private String requestID;
        private String tournamentID;

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

        public Result(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "results");
            if (bundle.getString("request") != null) {
                this.requestID = bundle.getString("request");
            }
            this.tournamentID = bundle.getString(SDKConstants.PARAM_TOURNAMENTS_ID);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "(Lcom/facebook/gamingservices/TournamentShareDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentShareDialog.kt */
    private final class FacebookAppHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        final /* synthetic */ TournamentShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FacebookAppHandler(TournamentShareDialog tournamentShareDialog) {
            super(tournamentShareDialog);
            Intrinsics.checkNotNullParameter(tournamentShareDialog, "this$0");
            this.this$0 = tournamentShareDialog;
        }

        public boolean canShow(TournamentConfig tournamentConfig, boolean z) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getApplicationContext().packageManager");
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            return intent.resolveActivity(packageManager) != null;
        }

        public AppCall createAppCall(TournamentConfig tournamentConfig) {
            Bundle bundle;
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            } else if (currentAccessToken.getGraphDomain() == null || Intrinsics.areEqual((Object) FacebookSdk.GAMING, (Object) currentAccessToken.getGraphDomain())) {
                String applicationId = currentAccessToken.getApplicationId();
                Number score = this.this$0.getScore();
                if (score != null) {
                    if (tournamentConfig != null) {
                        bundle = TournamentShareDialogURIBuilder.INSTANCE.bundleForCreating$facebook_gamingservices_release(tournamentConfig, score, applicationId);
                    } else {
                        Tournament tournament = this.this$0.getTournament();
                        if (tournament == null) {
                            bundle = null;
                        } else {
                            bundle = TournamentShareDialogURIBuilder.INSTANCE.bundleForUpdating$facebook_gamingservices_release(tournament.identifier, score, applicationId);
                        }
                    }
                    NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                    NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.PROTOCOL_VERSION_20210906, bundle);
                    createBaseAppCall.setRequestIntent(intent);
                    return createBaseAppCall;
                }
                throw new FacebookException("Attempted to share tournament without a score");
            } else {
                throw new FacebookException("Attempted to share tournament while user is not gaming logged in");
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentShareDialog$AppSwitchHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/TournamentConfig;", "Lcom/facebook/gamingservices/TournamentShareDialog$Result;", "(Lcom/facebook/gamingservices/TournamentShareDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TournamentShareDialog.kt */
    private final class AppSwitchHandler extends FacebookDialogBase<TournamentConfig, Result>.ModeHandler {
        final /* synthetic */ TournamentShareDialog this$0;

        public boolean canShow(TournamentConfig tournamentConfig, boolean z) {
            return true;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppSwitchHandler(TournamentShareDialog tournamentShareDialog) {
            super(tournamentShareDialog);
            Intrinsics.checkNotNullParameter(tournamentShareDialog, "this$0");
            this.this$0 = tournamentShareDialog;
        }

        public AppCall createAppCall(TournamentConfig tournamentConfig) {
            Uri uri;
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to share tournament with an invalid access token");
            } else if (currentAccessToken.getGraphDomain() == null || Intrinsics.areEqual((Object) FacebookSdk.GAMING, (Object) currentAccessToken.getGraphDomain())) {
                Number score = this.this$0.getScore();
                if (score != null) {
                    if (tournamentConfig != null) {
                        uri = TournamentShareDialogURIBuilder.INSTANCE.uriForCreating$facebook_gamingservices_release(tournamentConfig, score, currentAccessToken.getApplicationId());
                    } else {
                        Tournament tournament = this.this$0.getTournament();
                        if (tournament == null) {
                            uri = null;
                        } else {
                            uri = TournamentShareDialogURIBuilder.INSTANCE.uriForUpdating$facebook_gamingservices_release(tournament.identifier, score, currentAccessToken.getApplicationId());
                        }
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    TournamentShareDialog tournamentShareDialog = this.this$0;
                    tournamentShareDialog.startActivityForResult(intent, tournamentShareDialog.getRequestCode());
                    return createBaseAppCall;
                }
                throw new FacebookException("Attempted to share tournament without a score");
            } else {
                throw new FacebookException("Attempted to share tournament without without gaming login");
            }
        }
    }
}
