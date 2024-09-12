package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.facebook.login.LoginLogger;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ%\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ(\u0010K\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020NH\u0002J0\u0010O\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J*\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002J\b\u0010S\u001a\u00020QH\u0002J(\u0010T\u001a\u0002062\u0006\u0010M\u001a\u00020N2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010U\u001a\u000206H\u0000¢\u0006\u0002\bVJ%\u0010W\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010[H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u001d\u0010_\u001a\u00020`2\u0006\u0010E\u001a\u00020F2\u0006\u0010a\u001a\u00020bH\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\r\u0010 \u001a\u000206H\u0000¢\u0006\u0002\biJ\r\u0010!\u001a\u000206H\u0000¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010r\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060[H\u0002J\b\u00101\u001a\u00020(H\u0016J\u0010\u0010t\u001a\u0002062\u0006\u0010>\u001a\u00020\tH\u0002J\u0010\u0010u\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010v\u001a\u00020wH\u0016J\u001f\u0010x\u001a\u0002062\u0006\u0010@\u001a\u00020\r2\b\u0010y\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bzR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNs", "", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed", "", "isMultiplexed$okhttp", "()Z", "noCoalescedConnections", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", "source", "Lokio/BufferedSource;", "successCount", "cancel", "", "certificateSupportHost", "url", "Lokhttp3/HttpUrl;", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectFailed", "client", "Lokhttp3/OkHttpClient;", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "createTunnelRequest", "establishProtocol", "incrementSuccessCount", "incrementSuccessCount$okhttp", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "noCoalescedConnections$okhttp", "noNewExchanges$okhttp", "onSettings", "connection", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", "e", "trackFailure$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealConnection.kt */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit = 1;
    private final List<Reference<RealCall>> calls = new ArrayList();
    private final RealConnectionPool connectionPool;
    /* access modifiers changed from: private */
    public Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs = Long.MAX_VALUE;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    /* access modifiers changed from: private */
    public Socket socket;
    private BufferedSource source;
    private int successCount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealConnection.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public RealConnection(RealConnectionPool realConnectionPool, Route route2) {
        Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route2, "route");
        this.connectionPool = realConnectionPool;
        this.route = route2;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs$okhttp(long j) {
        this.idleAtNs = j;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9 A[Catch:{ IOException -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "eventListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            okhttp3.Protocol r0 = r7.protocol
            r10 = 1
            if (r0 != 0) goto L_0x0017
            r0 = r10
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0167
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r11 = new okhttp3.internal.connection.ConnectionSpecSelector
            r11.<init>(r0)
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x008d
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x007e
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r1 = r1.get()
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x0058
            goto L_0x009f
        L_0x0058:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = " not permitted by network security policy"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            java.io.IOException r2 = (java.io.IOException) r2
            r1.<init>(r2)
            throw r1
        L_0x007e:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            java.io.IOException r1 = (java.io.IOException) r1
            r0.<init>(r1)
            throw r0
        L_0x008d:
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0158
        L_0x009f:
            r12 = 0
            r13 = r12
        L_0x00a1:
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x0106 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x0106 }
            if (r0 == 0) goto L_0x00c2
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0106 }
            java.net.Socket r0 = r7.rawSocket     // Catch:{ IOException -> 0x0106 }
            if (r0 != 0) goto L_0x00bd
            goto L_0x00df
        L_0x00bd:
            r14 = r17
            r15 = r18
            goto L_0x00c9
        L_0x00c2:
            r14 = r17
            r15 = r18
            r7.connectSocket(r14, r15, r8, r9)     // Catch:{ IOException -> 0x0104 }
        L_0x00c9:
            r6 = r20
            r7.establishProtocol(r11, r6, r8, r9)     // Catch:{ IOException -> 0x0102 }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x0102 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x0102 }
            okhttp3.Route r1 = r7.route     // Catch:{ IOException -> 0x0102 }
            java.net.Proxy r1 = r1.proxy()     // Catch:{ IOException -> 0x0102 }
            okhttp3.Protocol r2 = r7.protocol     // Catch:{ IOException -> 0x0102 }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x0102 }
        L_0x00df:
            okhttp3.Route r0 = r7.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00fb
            java.net.Socket r0 = r7.rawSocket
            if (r0 == 0) goto L_0x00ec
            goto L_0x00fb
        L_0x00ec:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "Too many tunnel connections attempted: 21"
            r1.<init>(r2)
            java.io.IOException r1 = (java.io.IOException) r1
            r0.<init>(r1)
            throw r0
        L_0x00fb:
            long r0 = java.lang.System.nanoTime()
            r7.idleAtNs = r0
            return
        L_0x0102:
            r0 = move-exception
            goto L_0x010d
        L_0x0104:
            r0 = move-exception
            goto L_0x010b
        L_0x0106:
            r0 = move-exception
            r14 = r17
            r15 = r18
        L_0x010b:
            r6 = r20
        L_0x010d:
            java.net.Socket r1 = r7.socket
            if (r1 != 0) goto L_0x0112
            goto L_0x0115
        L_0x0112:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
        L_0x0115:
            java.net.Socket r1 = r7.rawSocket
            if (r1 != 0) goto L_0x011a
            goto L_0x011d
        L_0x011a:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
        L_0x011d:
            r7.socket = r12
            r7.rawSocket = r12
            r7.source = r12
            r7.sink = r12
            r7.handshake = r12
            r7.protocol = r12
            r7.http2Connection = r12
            r7.allocationLimit = r10
            okhttp3.Route r1 = r7.route
            java.net.InetSocketAddress r3 = r1.socketAddress()
            okhttp3.Route r1 = r7.route
            java.net.Proxy r4 = r1.proxy()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r13 != 0) goto L_0x014a
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            r13.<init>(r0)
            goto L_0x014d
        L_0x014a:
            r13.addConnectException(r0)
        L_0x014d:
            if (r21 == 0) goto L_0x0157
            boolean r0 = r11.connectionFailed(r0)
            if (r0 == 0) goto L_0x0157
            goto L_0x00a1
        L_0x0157:
            throw r13
        L_0x0158:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            java.io.IOException r1 = (java.io.IOException) r1
            r0.<init>(r1)
            throw r0
        L_0x0167:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    private final void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (i4 < 21) {
            i4++;
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
            } else {
                return;
            }
        }
    }

    private final void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            socket2 = address.socketFactory().createSocket();
            Intrinsics.checkNotNull(socket2);
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        socket2.setSoTimeout(i2);
        try {
            Platform.Companion.get().connectSocket(socket2, this.route.socketAddress(), i);
            try {
                this.source = Okio.buffer(Okio.source(socket2));
                this.sink = Okio.buffer(Okio.sink(socket2));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual((Object) e.getMessage(), (Object) NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException(Intrinsics.stringPlus("Failed to connect to ", this.route.socketAddress()));
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private final void startHttp2(int i) throws IOException {
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket2.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket2, this.route.address().url().host(), bufferedSource, bufferedSink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, (TaskRunner) null, 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void connectTls(okhttp3.internal.connection.ConnectionSpecSelector r11) throws java.io.IOException {
        /*
            r10 = this;
            okhttp3.Route r0 = r10.route
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0193 }
            java.net.Socket r3 = r10.rawSocket     // Catch:{ all -> 0x0193 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ all -> 0x0193 }
            java.lang.String r4 = r4.host()     // Catch:{ all -> 0x0193 }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ all -> 0x0193 }
            int r5 = r5.port()     // Catch:{ all -> 0x0193 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ all -> 0x0193 }
            if (r1 == 0) goto L_0x018b
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ all -> 0x0193 }
            okhttp3.ConnectionSpec r11 = r11.configureSecureSocket(r1)     // Catch:{ all -> 0x0188 }
            boolean r3 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0188 }
            if (r3 == 0) goto L_0x0048
            okhttp3.internal.platform.Platform$Companion r3 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0188 }
            okhttp3.internal.platform.Platform r3 = r3.get()     // Catch:{ all -> 0x0188 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = r4.host()     // Catch:{ all -> 0x0188 }
            java.util.List r5 = r0.protocols()     // Catch:{ all -> 0x0188 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ all -> 0x0188 }
        L_0x0048:
            r1.startHandshake()     // Catch:{ all -> 0x0188 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ all -> 0x0188 }
            okhttp3.Handshake$Companion r4 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = "sslSocketSession"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x0188 }
            okhttp3.Handshake r4 = r4.get(r3)     // Catch:{ all -> 0x0188 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ all -> 0x0188 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x0188 }
            okhttp3.HttpUrl r7 = r0.url()     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.host()     // Catch:{ all -> 0x0188 }
            boolean r3 = r5.verify(r7, r3)     // Catch:{ all -> 0x0188 }
            if (r3 != 0) goto L_0x010b
            java.util.List r11 = r4.peerCertificates()     // Catch:{ all -> 0x0188 }
            r3 = r11
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x0188 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0188 }
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x00e4
            r3 = 0
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x0188 }
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ all -> 0x0188 }
            javax.net.ssl.SSLPeerUnverifiedException r3 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r4.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = "\n              |Hostname "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0188 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = " not verified:\n              |    certificate: "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0188 }
            okhttp3.CertificatePinner$Companion r4 = okhttp3.CertificatePinner.Companion     // Catch:{ all -> 0x0188 }
            r5 = r11
            java.security.cert.Certificate r5 = (java.security.cert.Certificate) r5     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = r4.pin(r5)     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = "\n              |    DN: "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0188 }
            java.security.Principal r4 = r11.getSubjectDN()     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = "\n              |    subjectAltNames: "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0188 }
            okhttp3.internal.tls.OkHostnameVerifier r4 = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE     // Catch:{ all -> 0x0188 }
            java.util.List r11 = r4.allSubjectAltNames(r11)     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r11 = r0.append(r11)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "\n              "
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ all -> 0x0188 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0188 }
            java.lang.String r11 = kotlin.text.StringsKt.trimMargin$default(r11, r2, r6, r2)     // Catch:{ all -> 0x0188 }
            r3.<init>(r11)     // Catch:{ all -> 0x0188 }
            throw r3     // Catch:{ all -> 0x0188 }
        L_0x00e4:
            javax.net.ssl.SSLPeerUnverifiedException r11 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r2.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r3 = "Hostname "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0188 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = " not verified (no certificates)"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0188 }
            r11.<init>(r0)     // Catch:{ all -> 0x0188 }
            throw r11     // Catch:{ all -> 0x0188 }
        L_0x010b:
            okhttp3.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ all -> 0x0188 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0188 }
            okhttp3.Handshake r5 = new okhttp3.Handshake     // Catch:{ all -> 0x0188 }
            okhttp3.TlsVersion r6 = r4.tlsVersion()     // Catch:{ all -> 0x0188 }
            okhttp3.CipherSuite r7 = r4.cipherSuite()     // Catch:{ all -> 0x0188 }
            java.util.List r8 = r4.localCertificates()     // Catch:{ all -> 0x0188 }
            okhttp3.internal.connection.RealConnection$connectTls$1 r9 = new okhttp3.internal.connection.RealConnection$connectTls$1     // Catch:{ all -> 0x0188 }
            r9.<init>(r3, r4, r0)     // Catch:{ all -> 0x0188 }
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9     // Catch:{ all -> 0x0188 }
            r5.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x0188 }
            r10.handshake = r5     // Catch:{ all -> 0x0188 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0188 }
            okhttp3.internal.connection.RealConnection$connectTls$2 r4 = new okhttp3.internal.connection.RealConnection$connectTls$2     // Catch:{ all -> 0x0188 }
            r4.<init>(r10)     // Catch:{ all -> 0x0188 }
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x0188 }
            r3.check$okhttp(r0, r4)     // Catch:{ all -> 0x0188 }
            boolean r11 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0188 }
            if (r11 == 0) goto L_0x014f
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0188 }
            okhttp3.internal.platform.Platform r11 = r11.get()     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = r11.getSelectedProtocol(r1)     // Catch:{ all -> 0x0188 }
            goto L_0x0152
        L_0x014f:
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0188 }
        L_0x0152:
            r11 = r1
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0188 }
            r10.socket = r11     // Catch:{ all -> 0x0188 }
            r11 = r1
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0188 }
            okio.Source r11 = okio.Okio.source((java.net.Socket) r11)     // Catch:{ all -> 0x0188 }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r11)     // Catch:{ all -> 0x0188 }
            r10.source = r11     // Catch:{ all -> 0x0188 }
            r11 = r1
            java.net.Socket r11 = (java.net.Socket) r11     // Catch:{ all -> 0x0188 }
            okio.Sink r11 = okio.Okio.sink((java.net.Socket) r11)     // Catch:{ all -> 0x0188 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ all -> 0x0188 }
            r10.sink = r11     // Catch:{ all -> 0x0188 }
            if (r2 == 0) goto L_0x017a
            okhttp3.Protocol$Companion r11 = okhttp3.Protocol.Companion     // Catch:{ all -> 0x0188 }
            okhttp3.Protocol r11 = r11.get(r2)     // Catch:{ all -> 0x0188 }
            goto L_0x017c
        L_0x017a:
            okhttp3.Protocol r11 = okhttp3.Protocol.HTTP_1_1     // Catch:{ all -> 0x0188 }
        L_0x017c:
            r10.protocol = r11     // Catch:{ all -> 0x0188 }
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r11 = r11.get()
            r11.afterHandshake(r1)
            return
        L_0x0188:
            r11 = move-exception
            r2 = r1
            goto L_0x0194
        L_0x018b:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ all -> 0x0193 }
            java.lang.String r0 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            r11.<init>(r0)     // Catch:{ all -> 0x0193 }
            throw r11     // Catch:{ all -> 0x0193 }
        L_0x0193:
            r11 = move-exception
        L_0x0194:
            if (r2 == 0) goto L_0x019f
            okhttp3.internal.platform.Platform$Companion r0 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r0 = r0.get()
            r0.afterHandshake(r2)
        L_0x019f:
            if (r2 != 0) goto L_0x01a2
            goto L_0x01a7
        L_0x01a2:
            java.net.Socket r2 = (java.net.Socket) r2
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
        L_0x01a7:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private final Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec((OkHttpClient) null, this, bufferedSource, bufferedSink);
            bufferedSource.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            bufferedSink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (StringsKt.equals(AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE, Response.header$default(build, "Connection", (String) null, 2, (Object) null), true)) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException(Intrinsics.stringPlus("Unexpected response code for CONNECT: ", Integer.valueOf(build.code())));
                }
            } else if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", (RequestBody) null).header(HttpHeaders.HOST, Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", HttpHeaders.KEEP_ALIVE).header("User-Agent", Util.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    private final boolean routeMatchesAny(List<Route> list) {
        boolean z;
        Iterable<Route> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (Route route2 : iterable) {
                if (route2.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual((Object) this.route.socketAddress(), (Object) route2.socketAddress())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake2) {
        List<Certificate> peerCertificates = handshake2.peerCertificates();
        return (peerCertificates.isEmpty() ^ true) && OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) peerCertificates.get(0));
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection2);
        }
        socket2.setSoTimeout(realInterceptorChain.readTimeoutMillis());
        bufferedSource.timeout().timeout((long) realInterceptorChain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        bufferedSink.timeout().timeout((long) realInterceptorChain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull(bufferedSink);
        socket2.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealConnection$newWebSocketStreams$1(bufferedSource, bufferedSink, exchange);
    }

    public Route route() {
        return this.route;
    }

    public final void cancel() {
        Socket socket2 = this.rawSocket;
        if (socket2 != null) {
            Util.closeQuietly(socket2);
        }
    }

    public Socket socket() {
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        return socket2;
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        Intrinsics.checkNotNullParameter(http2Stream, "stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public synchronized void onSettings(Http2Connection http2Connection2, Settings settings) {
        Intrinsics.checkNotNullParameter(http2Connection2, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(OkHttpClient okHttpClient, Route route2, IOException iOException) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(route2, "failedRoute");
        Intrinsics.checkNotNullParameter(iOException, LoginLogger.EVENT_EXTRAS_FAILURE);
        if (route2.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route2.address();
            address.proxySelector().connectFailed(address.url().uri(), route2.proxy().address(), iOException);
        }
        okHttpClient.getRouteDatabase().failed(route2);
    }

    public final synchronized void trackFailure$okhttp(RealCall realCall, IOException iOException) {
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i = this.refusedStreamCount + 1;
                this.refusedStreamCount = i;
                if (i > 1) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !realCall.isCanceled()) {
                this.noNewExchanges = true;
                this.routeFailureCount++;
            }
        } else if (!isMultiplexed$okhttp() || (iOException instanceof ConnectionShutdownException)) {
            this.noNewExchanges = true;
            if (this.successCount == 0) {
                if (iOException != null) {
                    connectFailed$okhttp(realCall.getClient(), this.route, iOException);
                }
                this.routeFailureCount++;
            }
        }
    }

    public Protocol protocol() {
        Protocol protocol2 = this.protocol;
        Intrinsics.checkNotNull(protocol2);
        return protocol2;
    }

    public String toString() {
        Object cipherSuite;
        StringBuilder append = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(':').append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        Object obj = "none";
        if (!(handshake2 == null || (cipherSuite = handshake2.cipherSuite()) == null)) {
            obj = cipherSuite;
        }
        return append.append(obj).append(" protocol=").append(this.protocol).append('}').toString();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealConnection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RealConnection newTestConnection(RealConnectionPool realConnectionPool, Route route, Socket socket, long j) {
            Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(socket, "socket");
            RealConnection realConnection = new RealConnection(realConnectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(j);
            return realConnection;
        }
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        } else if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        } else {
            if (Intrinsics.areEqual((Object) address.url().host(), (Object) route().address().url().host())) {
                return true;
            }
            if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
                return false;
            }
            try {
                CertificatePinner certificatePinner = address.certificatePinner();
                Intrinsics.checkNotNull(certificatePinner);
                String host = address.url().host();
                Handshake handshake2 = handshake();
                Intrinsics.checkNotNull(handshake2);
                certificatePinner.check(host, (List<? extends Certificate>) handshake2.peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake2;
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            HttpUrl url = this.route.address().url();
            if (httpUrl.port() != url.port()) {
                return false;
            }
            if (Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host())) {
                return true;
            }
            if (this.noCoalescedConnections || (handshake2 = this.handshake) == null) {
                return false;
            }
            Intrinsics.checkNotNull(handshake2);
            if (certificateSupportHost(httpUrl, handshake2)) {
                return true;
            }
            return false;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final boolean isHealthy(boolean z) {
        long idleAtNs$okhttp;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket2 = this.rawSocket;
            Intrinsics.checkNotNull(socket2);
            Socket socket3 = this.socket;
            Intrinsics.checkNotNull(socket3);
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            if (socket2.isClosed() || socket3.isClosed() || socket3.isInputShutdown() || socket3.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection2 = this.http2Connection;
            if (http2Connection2 != null) {
                return http2Connection2.isHealthy(nanoTime);
            }
            synchronized (this) {
                idleAtNs$okhttp = nanoTime - getIdleAtNs$okhttp();
            }
            if (idleAtNs$okhttp < IDLE_CONNECTION_HEALTHY_NS || !z) {
                return true;
            }
            return Util.isHealthy(socket3, bufferedSource);
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
