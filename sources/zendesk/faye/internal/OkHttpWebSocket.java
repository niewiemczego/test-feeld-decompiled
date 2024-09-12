package zendesk.faye.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/faye/internal/OkHttpWebSocket;", "", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "socket", "Lokhttp3/WebSocket;", "connectTo", "", "url", "", "listener", "Lokhttp3/WebSocketListener;", "disconnect", "resetSocket", "", "send", "message", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpWebSocket.kt */
public final class OkHttpWebSocket {
    private static final int CLOSE_CODE_NORMAL = 1000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "OkHttpWebSocket";
    private final OkHttpClient client;
    private WebSocket socket;

    public OkHttpWebSocket(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        this.client = okHttpClient;
    }

    public final boolean connectTo(String str, WebSocketListener webSocketListener) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.socket != null) {
            Logger.w(LOG_TAG, "connectTo was called but socket was not null", new Object[0]);
            return false;
        }
        this.socket = this.client.newWebSocket(new Request.Builder().url(str).build(), webSocketListener);
        return true;
    }

    public final boolean disconnect() {
        WebSocket webSocket = this.socket;
        boolean z = false;
        if (webSocket != null) {
            z = webSocket.close(1000, (String) null);
        } else {
            Logger.w(LOG_TAG, "disconnect was called but socket was null", new Object[0]);
        }
        if (z) {
            resetSocket();
        }
        return z;
    }

    public final boolean send(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        WebSocket webSocket = this.socket;
        if (webSocket != null) {
            return webSocket.send(str);
        }
        Logger.w(LOG_TAG, "send was called but socket was null", new Object[0]);
        return false;
    }

    public final void resetSocket() {
        this.socket = null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/faye/internal/OkHttpWebSocket$Companion;", "", "()V", "CLOSE_CODE_NORMAL", "", "LOG_TAG", "", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OkHttpWebSocket.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
