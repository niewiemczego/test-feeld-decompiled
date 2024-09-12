package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "cancel", "", "complete", "request", "Lcom/facebook/login/LoginClient$Request;", "result", "Landroid/os/Bundle;", "describeContents", "", "getTokenCompleted", "onComplete", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GetTokenLoginMethodHandler.kt */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new GetTokenLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private GetTokenClient getTokenClient;
    private final String nameForLogging = "get_token";

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public void cancel() {
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.cancel();
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
            this.getTokenClient = null;
        }
    }

    public int tryAuthorize(LoginClient.Request request) {
        Context context;
        Intrinsics.checkNotNullParameter(request, "request");
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            context = FacebookSdk.getApplicationContext();
        } else {
            context = activity;
        }
        GetTokenClient getTokenClient2 = new GetTokenClient(context, request);
        this.getTokenClient = getTokenClient2;
        if (Intrinsics.areEqual((Object) Boolean.valueOf(getTokenClient2.start()), (Object) false)) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        GetTokenLoginMethodHandler$$ExternalSyntheticLambda0 getTokenLoginMethodHandler$$ExternalSyntheticLambda0 = new GetTokenLoginMethodHandler$$ExternalSyntheticLambda0(this, request);
        GetTokenClient getTokenClient3 = this.getTokenClient;
        if (getTokenClient3 == null) {
            return 1;
        }
        getTokenClient3.setCompletedListener(getTokenLoginMethodHandler$$ExternalSyntheticLambda0);
        return 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: tryAuthorize$lambda-1  reason: not valid java name */
    public static final void m385tryAuthorize$lambda1(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(getTokenLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        getTokenLoginMethodHandler.getTokenCompleted(request, bundle);
    }

    public final void getTokenCompleted(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            List emptyList = stringArrayList == null ? CollectionsKt.emptyList() : stringArrayList;
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = SetsKt.emptySet();
            }
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (permissions.contains("openid")) {
                CharSequence charSequence = string;
                if (charSequence == null || charSequence.length() == 0) {
                    getLoginClient().tryNextHandler();
                    return;
                }
            }
            if (emptyList.containsAll(permissions)) {
                complete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String next : permissions) {
                if (!emptyList.contains(next)) {
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(LoginClient.Request request, Bundle bundle) {
        LoginClient.Result result;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "result");
        try {
            result = LoginClient.Result.Companion.createCompositeTokenResult(request, LoginMethodHandler.Companion.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), LoginMethodHandler.Companion.createAuthenticationTokenFromNativeLogin(bundle, request.getNonce()));
        } catch (FacebookException e) {
            result = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), (String) null, e.getMessage(), (String) null, 8, (Object) null);
        }
        getLoginClient().completeAndValidate(result);
    }

    public final void complete(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "result");
        CharSequence string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.length() == 0) {
            getLoginClient().notifyBackgroundProcessingStart();
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            if (string2 != null) {
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(string2, new GetTokenLoginMethodHandler$complete$1(bundle, this, request));
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        onComplete(request, bundle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/GetTokenLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GetTokenLoginMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
