package zendesk.faye.internal;

import com.braze.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.sentry.clientreport.DiscardedEvent;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONObject;
import zendesk.faye.BayeuxMessage;
import zendesk.faye.ConnectMessage;
import zendesk.faye.DisconnectMessage;
import zendesk.faye.FayeClient;
import zendesk.faye.FayeClientError;
import zendesk.faye.FayeClientListener;
import zendesk.faye.PublishMessage;
import zendesk.faye.SubscribeMessage;
import zendesk.faye.UnsubscribeMessage;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 92\u00020\u0001:\u00029:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u000208H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lzendesk/faye/internal/DefaultFayeClient;", "Lzendesk/faye/FayeClient;", "serverUrl", "", "webSocket", "Lzendesk/faye/internal/OkHttpWebSocket;", "(Ljava/lang/String;Lzendesk/faye/internal/OkHttpWebSocket;)V", "connectMessage", "Lzendesk/faye/ConnectMessage;", "fayeClientId", "isConnected", "", "keepConnectionAlive", "getKeepConnectionAlive", "()Z", "setKeepConnectionAlive", "(Z)V", "listeners", "", "Lzendesk/faye/FayeClientListener;", "getListeners$zendesk_faye_faye", "()Ljava/util/Set;", "okHttpWebSocketListener", "Lzendesk/faye/internal/DefaultFayeClient$OkHttpWebSocketListener;", "getOkHttpWebSocketListener$zendesk_faye_faye", "()Lzendesk/faye/internal/DefaultFayeClient$OkHttpWebSocketListener;", "addListener", "", "listener", "disconnect", "disconnectMessage", "Lzendesk/faye/DisconnectMessage;", "handleChannelMessage", "channel", "fayeMessage", "Lorg/json/JSONObject;", "handleConnectMessage", "success", "handleDisconnectMessage", "handleHandshakeMessage", "handleSubscribeMessage", "handleUnsubscribeMessage", "parseFayeMessage", "message", "publish", "publishMessage", "Lzendesk/faye/PublishMessage;", "removeListener", "send", "bayeuxMessage", "Lzendesk/faye/BayeuxMessage;", "subscribeTo", "subscribeMessage", "Lzendesk/faye/SubscribeMessage;", "unsubscribeFrom", "unsubscribeMessage", "Lzendesk/faye/UnsubscribeMessage;", "Companion", "OkHttpWebSocketListener", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultFayeClient.kt */
public final class DefaultFayeClient implements FayeClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "DefaultFayeClient";
    /* access modifiers changed from: private */
    public ConnectMessage connectMessage;
    private String fayeClientId;
    /* access modifiers changed from: private */
    public boolean isConnected;
    private boolean keepConnectionAlive = true;
    private final Set<FayeClientListener> listeners = new HashSet();
    private final OkHttpWebSocketListener okHttpWebSocketListener = new OkHttpWebSocketListener();
    private final String serverUrl;
    /* access modifiers changed from: private */
    public final OkHttpWebSocket webSocket;

    public DefaultFayeClient(String str, OkHttpWebSocket okHttpWebSocket) {
        Intrinsics.checkNotNullParameter(str, "serverUrl");
        Intrinsics.checkNotNullParameter(okHttpWebSocket, "webSocket");
        this.serverUrl = str;
        this.webSocket = okHttpWebSocket;
    }

    public final OkHttpWebSocketListener getOkHttpWebSocketListener$zendesk_faye_faye() {
        return this.okHttpWebSocketListener;
    }

    public final Set<FayeClientListener> getListeners$zendesk_faye_faye() {
        return this.listeners;
    }

    public boolean getKeepConnectionAlive() {
        return this.keepConnectionAlive;
    }

    public void setKeepConnectionAlive(boolean z) {
        this.keepConnectionAlive = z;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, d2 = {"Lzendesk/faye/internal/DefaultFayeClient$OkHttpWebSocketListener;", "Lokhttp3/WebSocketListener;", "(Lzendesk/faye/internal/DefaultFayeClient;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "text", "onOpen", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFayeClient.kt */
    public final class OkHttpWebSocketListener extends WebSocketListener {
        public OkHttpWebSocketListener() {
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(response, io.sentry.protocol.Response.TYPE);
            ConnectMessage access$getConnectMessage$p = DefaultFayeClient.this.connectMessage;
            if (access$getConnectMessage$p != null) {
                DefaultFayeClient.this.webSocket.send(Bayeux.INSTANCE.handshake(access$getConnectMessage$p.getSupportedConnectionTypes(), access$getConnectMessage$p.getHandshakeOptionalFields()));
                return;
            }
            Logger.w(DefaultFayeClient.LOG_TAG, "onOpen called but connectMessage was null, closing the socket", new Object[0]);
            DefaultFayeClient.this.webSocket.disconnect();
        }

        public void onMessage(WebSocket webSocket, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, "text");
            Logger.d(DefaultFayeClient.LOG_TAG, "Message received: " + str, new Object[0]);
            DefaultFayeClient.this.parseFayeMessage(str);
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(str, DiscardedEvent.JsonKeys.REASON);
            DefaultFayeClient.this.isConnected = false;
            DefaultFayeClient.this.webSocket.resetSocket();
            for (FayeClientListener onDisconnectedFromServer : DefaultFayeClient.this.getListeners$zendesk_faye_faye()) {
                onDisconnectedFromServer.onDisconnectedFromServer();
            }
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(th, Constants.BRAZE_PUSH_TITLE_KEY);
            DefaultFayeClient.this.isConnected = false;
            DefaultFayeClient.this.webSocket.resetSocket();
            for (FayeClientListener next : DefaultFayeClient.this.getListeners$zendesk_faye_faye()) {
                next.onDisconnectedFromServer();
                next.onClientError(FayeClientError.CLIENT_TRANSPORT_ERROR, th);
            }
        }
    }

    public void addListener(FayeClientListener fayeClientListener) {
        Intrinsics.checkNotNullParameter(fayeClientListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(fayeClientListener);
    }

    public void removeListener(FayeClientListener fayeClientListener) {
        Intrinsics.checkNotNullParameter(fayeClientListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(fayeClientListener);
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void send(BayeuxMessage bayeuxMessage) {
        Intrinsics.checkNotNullParameter(bayeuxMessage, "bayeuxMessage");
        if (bayeuxMessage instanceof ConnectMessage) {
            if (this.webSocket.connectTo(this.serverUrl, this.okHttpWebSocketListener)) {
                this.connectMessage = (ConnectMessage) bayeuxMessage;
            }
        } else if (bayeuxMessage instanceof DisconnectMessage) {
            disconnect((DisconnectMessage) bayeuxMessage);
        } else if (bayeuxMessage instanceof SubscribeMessage) {
            subscribeTo((SubscribeMessage) bayeuxMessage);
        } else if (bayeuxMessage instanceof UnsubscribeMessage) {
            unsubscribeFrom((UnsubscribeMessage) bayeuxMessage);
        } else if (bayeuxMessage instanceof PublishMessage) {
            publish((PublishMessage) bayeuxMessage);
        }
    }

    private final void disconnect(DisconnectMessage disconnectMessage) {
        String str = this.fayeClientId;
        if (str != null) {
            this.webSocket.send(Bayeux.INSTANCE.disconnect(str, disconnectMessage.getOptionalFields()));
        }
        this.webSocket.disconnect();
        this.isConnected = false;
    }

    private final void subscribeTo(SubscribeMessage subscribeMessage) {
        String str = this.fayeClientId;
        if (!this.isConnected || str == null) {
            for (FayeClientListener onClientError : this.listeners) {
                onClientError.onClientError(FayeClientError.CLIENT_NOT_CONNECTED_ERROR, (Throwable) null);
            }
            return;
        }
        this.webSocket.send(Bayeux.INSTANCE.subscribe(str, subscribeMessage.getChannel(), subscribeMessage.getOptionalFields()));
    }

    private final void unsubscribeFrom(UnsubscribeMessage unsubscribeMessage) {
        String str = this.fayeClientId;
        if (!this.isConnected || str == null) {
            for (FayeClientListener onClientError : this.listeners) {
                onClientError.onClientError(FayeClientError.CLIENT_NOT_CONNECTED_ERROR, (Throwable) null);
            }
            return;
        }
        this.webSocket.send(Bayeux.INSTANCE.unsubscribe(str, unsubscribeMessage.getChannel(), unsubscribeMessage.getOptionalFields()));
    }

    private final void publish(PublishMessage publishMessage) {
        if (!this.isConnected) {
            for (FayeClientListener onClientError : this.listeners) {
                onClientError.onClientError(FayeClientError.CLIENT_NOT_CONNECTED_ERROR, (Throwable) null);
            }
            return;
        }
        String publish = Bayeux.INSTANCE.publish(publishMessage.getChannel(), publishMessage.getMessage(), this.fayeClientId, publishMessage.getOptionalFields());
        Logger.d(LOG_TAG, "Publishing to channel " + publishMessage.getChannel() + ", message: " + publishMessage.getMessage(), new Object[0]);
        this.webSocket.send(publish);
        for (FayeClientListener onMessagePublished : this.listeners) {
            onMessagePublished.onMessagePublished(publishMessage.getChannel(), publishMessage.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseFayeMessage(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0073 }
            r1.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x0073 }
            int r8 = r1.length()
        L_0x000a:
            if (r0 >= r8) goto L_0x0072
            org.json.JSONObject r2 = r1.optJSONObject(r0)
            if (r2 != 0) goto L_0x0013
            goto L_0x006f
        L_0x0013:
            java.lang.String r3 = "channel"
            java.lang.String r4 = r2.optString(r3)
            java.lang.String r5 = "successful"
            boolean r5 = r2.optBoolean(r5)
            if (r4 == 0) goto L_0x0069
            int r6 = r4.hashCode()
            switch(r6) {
                case -1992173988: goto L_0x005d;
                case -1839038474: goto L_0x0050;
                case -1548011601: goto L_0x0043;
                case -114481009: goto L_0x0036;
                case 1006455511: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0069
        L_0x0029:
            java.lang.String r6 = "/meta/disconnect"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0032
            goto L_0x0069
        L_0x0032:
            r7.handleDisconnectMessage(r5)
            goto L_0x006f
        L_0x0036:
            java.lang.String r6 = "/meta/connect"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x003f
            goto L_0x0069
        L_0x003f:
            r7.handleConnectMessage(r5)
            goto L_0x006f
        L_0x0043:
            java.lang.String r6 = "/meta/subscribe"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x004c
            goto L_0x0069
        L_0x004c:
            r7.handleSubscribeMessage(r2, r5)
            goto L_0x006f
        L_0x0050:
            java.lang.String r6 = "/meta/unsubscribe"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0059
            goto L_0x0069
        L_0x0059:
            r7.handleUnsubscribeMessage(r2, r5)
            goto L_0x006f
        L_0x005d:
            java.lang.String r6 = "/meta/handshake"
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0069
            r7.handleHandshakeMessage(r2, r5)
            goto L_0x006f
        L_0x0069:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            r7.handleChannelMessage(r4, r2)
        L_0x006f:
            int r0 = r0 + 1
            goto L_0x000a
        L_0x0072:
            return
        L_0x0073:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "parseFayeMessage failed to parse message: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "DefaultFayeClient"
            zendesk.logger.Logger.w(r1, r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.faye.internal.DefaultFayeClient.parseFayeMessage(java.lang.String):void");
    }

    private final void handleHandshakeMessage(JSONObject jSONObject, boolean z) {
        String optString = jSONObject.optString(Bayeux.KEY_CLIENT_ID);
        ConnectMessage connectMessage2 = this.connectMessage;
        if (!z || optString == null || connectMessage2 == null) {
            this.webSocket.disconnect();
            return;
        }
        this.isConnected = z;
        this.fayeClientId = optString;
        this.webSocket.send(Bayeux.INSTANCE.connect(optString, connectMessage2.getConnectOptionalFields()));
        for (FayeClientListener onConnectedToServer : this.listeners) {
            onConnectedToServer.onConnectedToServer();
        }
    }

    private final void handleConnectMessage(boolean z) {
        String str = this.fayeClientId;
        ConnectMessage connectMessage2 = this.connectMessage;
        if (!z || connectMessage2 == null || str == null) {
            this.webSocket.disconnect();
            for (FayeClientListener onDisconnectedFromServer : this.listeners) {
                onDisconnectedFromServer.onDisconnectedFromServer();
            }
        } else if (getKeepConnectionAlive()) {
            this.webSocket.send(Bayeux.INSTANCE.connect(str, connectMessage2.getConnectOptionalFields()));
        }
    }

    private final void handleDisconnectMessage(boolean z) {
        if (z) {
            this.isConnected = false;
            this.webSocket.disconnect();
            for (FayeClientListener onDisconnectedFromServer : this.listeners) {
                onDisconnectedFromServer.onDisconnectedFromServer();
            }
            return;
        }
        Logger.w(LOG_TAG, "handleDisconnectMessage called, but success was " + z, new Object[0]);
    }

    private final void handleSubscribeMessage(JSONObject jSONObject, boolean z) {
        if (z) {
            for (FayeClientListener onSubscribedToChannel : this.listeners) {
                String optString = jSONObject.optString(Bayeux.KEY_SUBSCRIPTION);
                Intrinsics.checkNotNullExpressionValue(optString, "fayeMessage.optString(Bayeux.KEY_SUBSCRIPTION)");
                onSubscribedToChannel.onSubscribedToChannel(optString);
            }
            return;
        }
        Logger.w(LOG_TAG, "handleSubscribeMessage called, but success was " + z, new Object[0]);
    }

    private final void handleUnsubscribeMessage(JSONObject jSONObject, boolean z) {
        if (z) {
            for (FayeClientListener onUnsubscribedFromChannel : this.listeners) {
                String optString = jSONObject.optString(Bayeux.KEY_SUBSCRIPTION);
                Intrinsics.checkNotNullExpressionValue(optString, "fayeMessage.optString(Bayeux.KEY_SUBSCRIPTION)");
                onUnsubscribedFromChannel.onUnsubscribedFromChannel(optString);
            }
            return;
        }
        Logger.w(LOG_TAG, "handleUnsubscribeMessage called, but success was " + z, new Object[0]);
    }

    private final void handleChannelMessage(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            for (FayeClientListener onMessageReceived : this.listeners) {
                String jSONObject2 = optJSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
                onMessageReceived.onMessageReceived(str, jSONObject2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/faye/internal/DefaultFayeClient$Companion;", "", "()V", "LOG_TAG", "", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFayeClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
