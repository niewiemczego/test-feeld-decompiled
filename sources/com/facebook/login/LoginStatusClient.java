package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/login/LoginStatusClient;", "Lcom/facebook/internal/PlatformServiceClient;", "context", "Landroid/content/Context;", "applicationId", "", "loggerRef", "graphApiVersion", "toastDurationMs", "", "nonce", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "populateRequestBundle", "", "data", "Landroid/os/Bundle;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginStatusClient.kt */
public final class LoginStatusClient extends PlatformServiceClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_TOAST_DURATION_MS = 5000;
    private final String graphApiVersion;
    private final String loggerRef;
    private final long toastDurationMs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginStatusClient(Context context, String str, String str2, String str3, long j, String str4) {
        super(context, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20170411, str, str4);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Intrinsics.checkNotNullParameter(str2, "loggerRef");
        Intrinsics.checkNotNullParameter(str3, "graphApiVersion");
        this.loggerRef = str2;
        this.graphApiVersion = str3;
        this.toastDurationMs = j;
    }

    /* access modifiers changed from: protected */
    public void populateRequestBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        bundle.putString(NativeProtocol.EXTRA_LOGGER_REF, this.loggerRef);
        bundle.putString(NativeProtocol.EXTRA_GRAPH_API_VERSION, this.graphApiVersion);
        bundle.putLong(NativeProtocol.EXTRA_TOAST_DURATION_MS, this.toastDurationMs);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginStatusClient$Companion;", "", "()V", "DEFAULT_TOAST_DURATION_MS", "", "newInstance", "Lcom/facebook/login/LoginStatusClient;", "context", "Landroid/content/Context;", "applicationId", "", "loggerRef", "graphApiVersion", "toastDurationMs", "nonce", "newInstance$facebook_common_release", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginStatusClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginStatusClient newInstance$facebook_common_release(Context context, String str, String str2, String str3, long j, String str4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(str2, "loggerRef");
            Intrinsics.checkNotNullParameter(str3, "graphApiVersion");
            return new LoginStatusClient(context, str, str2, str3, j, str4);
        }
    }
}
