package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "shouldKeepTrackOfMultipleIntents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KatanaProxyLoginMethodHandler.kt */
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new KatanaProxyLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String nameForLogging = "katana_proxy_auth";

    public int describeContents() {
        return 0;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int tryAuthorize(com.facebook.login.LoginClient.Request r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.String r1 = "request"
            r2 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            com.facebook.login.LoginBehavior r1 = r24.getLoginBehavior()
            boolean r3 = com.facebook.FacebookSdk.ignoreAppSwitchToLoggedOut
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0023
            com.facebook.internal.CustomTabUtils r3 = com.facebook.internal.CustomTabUtils.INSTANCE
            java.lang.String r3 = com.facebook.internal.CustomTabUtils.getChromePackage()
            if (r3 == 0) goto L_0x0023
            boolean r1 = r1.allowsCustomTabAuth()
            if (r1 == 0) goto L_0x0023
            r15 = r4
            goto L_0x0024
        L_0x0023:
            r15 = r5
        L_0x0024:
            com.facebook.login.LoginClient$Companion r1 = com.facebook.login.LoginClient.Companion
            java.lang.String r1 = r1.getE2E()
            com.facebook.internal.NativeProtocol r3 = com.facebook.internal.NativeProtocol.INSTANCE
            com.facebook.login.LoginClient r3 = r23.getLoginClient()
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            r6 = r3
            android.content.Context r6 = (android.content.Context) r6
            java.lang.String r7 = r24.getApplicationId()
            java.util.Set r3 = r24.getPermissions()
            r8 = r3
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r10 = r24.isRerequest()
            boolean r11 = r24.hasPublishPermission()
            com.facebook.login.DefaultAudience r3 = r24.getDefaultAudience()
            if (r3 != 0) goto L_0x0052
            com.facebook.login.DefaultAudience r3 = com.facebook.login.DefaultAudience.NONE
        L_0x0052:
            r12 = r3
            java.lang.String r3 = r24.getAuthId()
            java.lang.String r13 = r0.getClientState(r3)
            java.lang.String r14 = r24.getAuthType()
            java.lang.String r16 = r24.getMessengerPageId()
            boolean r17 = r24.getResetMessengerState()
            boolean r18 = r24.isFamilyLogin()
            boolean r19 = r24.shouldSkipAccountDeduplication()
            java.lang.String r20 = r24.getNonce()
            java.lang.String r21 = r24.getCodeChallenge()
            com.facebook.login.CodeChallengeMethod r2 = r24.getCodeChallengeMethod()
            if (r2 != 0) goto L_0x007f
            r2 = 0
            goto L_0x0083
        L_0x007f:
            java.lang.String r2 = r2.name()
        L_0x0083:
            r22 = r2
            r9 = r1
            java.util.List r2 = com.facebook.internal.NativeProtocol.createProxyAuthIntents(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r3 = "e2e"
            r0.addLoggingExtra(r3, r1)
            java.util.Iterator r1 = r2.iterator()
            r2 = r5
        L_0x0094:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ae
            int r2 = r2 + r4
            java.lang.Object r3 = r1.next()
            android.content.Intent r3 = (android.content.Intent) r3
            com.facebook.login.LoginClient$Companion r6 = com.facebook.login.LoginClient.Companion
            int r6 = r6.getLoginRequestCode()
            boolean r3 = r0.tryIntent(r3, r6)
            if (r3 == 0) goto L_0x0094
            return r2
        L_0x00ae:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.KatanaProxyLoginMethodHandler.tryAuthorize(com.facebook.login.LoginClient$Request):int");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "source");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: KatanaProxyLoginMethodHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
