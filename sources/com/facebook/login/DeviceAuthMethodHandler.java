package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J~\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001a2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/facebook/login/DeviceAuthMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "createDeviceAuthDialog", "Lcom/facebook/login/DeviceAuthDialog;", "describeContents", "", "onCancel", "", "onError", "ex", "Ljava/lang/Exception;", "onSuccess", "accessToken", "applicationId", "userId", "permissions", "", "declinedPermissions", "expiredPermissions", "accessTokenSource", "Lcom/facebook/AccessTokenSource;", "expirationTime", "Ljava/util/Date;", "lastRefreshTime", "dataAccessExpirationTime", "showDialog", "request", "Lcom/facebook/login/LoginClient$Request;", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceAuthMethodHandler.kt */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new DeviceAuthMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    private final String nameForLogging = "device_auth";

    @JvmStatic
    public static final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor backgroundExecutor2;
        synchronized (DeviceAuthMethodHandler.class) {
            backgroundExecutor2 = Companion.getBackgroundExecutor();
        }
        return backgroundExecutor2;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        showDialog(request);
        return 1;
    }

    private final void showDialog(LoginClient.Request request) {
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity != null && !activity.isFinishing()) {
            DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
            createDeviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
            createDeviceAuthDialog.startLogin(request);
        }
    }

    /* access modifiers changed from: protected */
    public DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    public void onCancel() {
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createCancelResult(getLoginClient().getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE));
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), (String) null, exc.getMessage(), (String) null, 8, (Object) null));
    }

    public void onSuccess(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, SDKConstants.PARAM_ACCESS_TOKEN);
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "applicationId");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "userId");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createTokenResult(getLoginClient().getPendingRequest(), new AccessToken(str4, str5, str6, collection, collection2, collection3, accessTokenSource, date, date2, date3, (String) null, 1024, (DefaultConstructorMarker) null)));
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/login/DeviceAuthMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/DeviceAuthMethodHandler;", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getBackgroundExecutor", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceAuthMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
            ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp;
            if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            access$getBackgroundExecutor$cp = DeviceAuthMethodHandler.backgroundExecutor;
            if (access$getBackgroundExecutor$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundExecutor");
                throw null;
            }
            return access$getBackgroundExecutor$cp;
        }
    }
}
