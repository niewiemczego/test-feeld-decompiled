package okhttp3.internal.ws;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealWebSocket.kt */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    /* access modifiers changed from: private */
    public WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    /* access modifiers changed from: private */
    public final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private long minimumDeflateSize;
    /* access modifiers changed from: private */
    public String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j, WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(request, "originalRequest");
        Intrinsics.checkNotNullParameter(webSocketListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(random2, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random2;
        this.pingIntervalMillis = j;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.areEqual((Object) ShareTarget.METHOD_GET, (Object) request.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            Unit unit = Unit.INSTANCE;
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, (Object) null).base64();
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Request must be GET: ", request.method()).toString());
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public Request request() {
        return this.originalRequest;
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public void cancel() {
        Call call2 = this.call;
        Intrinsics.checkNotNull(call2);
        call2.cancel();
    }

    public final void connect(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        if (this.originalRequest.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (Response) null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header("Connection", HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        Call realCall = new RealCall(build, build2, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new RealWebSocket$connect$1(this, build2));
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null || new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return true;
        }
        return false;
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.checkNotNullParameter(response, io.sentry.protocol.Response.TYPE);
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", (String) null, 2, (Object) null);
            if (StringsKt.equals(HttpHeaders.UPGRADE, header$default, true)) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, (String) null, 2, (Object) null);
                if (StringsKt.equals("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, (String) null, 2, (Object) null);
                    String base64 = ByteString.Companion.encodeUtf8(Intrinsics.stringPlus(this.key, WebSocketProtocol.ACCEPT_MAGIC)).sha1().base64();
                    if (!Intrinsics.areEqual((Object) base64, (Object) header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(streams2, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            this.name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams2.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask(this);
            if (this.pingIntervalMillis != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$lambda3$$inlined$schedule$1(Intrinsics.stringPlus(str, " ping"), this, nanos), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams2.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, (Response) null);
            return false;
        }
    }

    public final void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public void onReadMessage(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "text");
        this.listener.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.listener.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ all -> 0x0029 }
            boolean r0 = r1.failed     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0017
            goto L_0x0027
        L_0x0017:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0029 }
            r0.add(r2)     // Catch:{ all -> 0x0029 }
            r1.runWriter()     // Catch:{ all -> 0x0029 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0029 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [okhttp3.internal.ws.WebSocketWriter, okhttp3.internal.ws.WebSocketReader, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReadClose(int r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            r1 = 0
            r2 = -1
            if (r6 == r2) goto L_0x000c
            r3 = r0
            goto L_0x000d
        L_0x000c:
            r3 = r1
        L_0x000d:
            if (r3 == 0) goto L_0x0095
            monitor-enter(r5)
            int r3 = r5.receivedCloseCode     // Catch:{ all -> 0x0092 }
            if (r3 != r2) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0086
            r5.receivedCloseCode = r6     // Catch:{ all -> 0x0092 }
            r5.receivedCloseReason = r7     // Catch:{ all -> 0x0092 }
            boolean r0 = r5.enqueuedClose     // Catch:{ all -> 0x0092 }
            r1 = 0
            if (r0 == 0) goto L_0x003c
            java.util.ArrayDeque<java.lang.Object> r0 = r5.messageAndCloseQueue     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x003c
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r5.streams     // Catch:{ all -> 0x0092 }
            r5.streams = r1     // Catch:{ all -> 0x0092 }
            okhttp3.internal.ws.WebSocketReader r2 = r5.reader     // Catch:{ all -> 0x0092 }
            r5.reader = r1     // Catch:{ all -> 0x0092 }
            okhttp3.internal.ws.WebSocketWriter r3 = r5.writer     // Catch:{ all -> 0x0092 }
            r5.writer = r1     // Catch:{ all -> 0x0092 }
            okhttp3.internal.concurrent.TaskQueue r1 = r5.taskQueue     // Catch:{ all -> 0x0092 }
            r1.shutdown()     // Catch:{ all -> 0x0092 }
            r1 = r0
            goto L_0x003e
        L_0x003c:
            r2 = r1
            r3 = r2
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0092 }
            monitor-exit(r5)
            okhttp3.WebSocketListener r0 = r5.listener     // Catch:{ all -> 0x006c }
            r4 = r5
            okhttp3.WebSocket r4 = (okhttp3.WebSocket) r4     // Catch:{ all -> 0x006c }
            r0.onClosing(r4, r6, r7)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0053
            okhttp3.WebSocketListener r0 = r5.listener     // Catch:{ all -> 0x006c }
            r4 = r5
            okhttp3.WebSocket r4 = (okhttp3.WebSocket) r4     // Catch:{ all -> 0x006c }
            r0.onClosed(r4, r6, r7)     // Catch:{ all -> 0x006c }
        L_0x0053:
            if (r1 != 0) goto L_0x0056
            goto L_0x005b
        L_0x0056:
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x005b:
            if (r2 != 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0063:
            if (r3 != 0) goto L_0x0066
            goto L_0x006b
        L_0x0066:
            java.io.Closeable r3 = (java.io.Closeable) r3
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x006b:
            return
        L_0x006c:
            r6 = move-exception
            if (r1 != 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x0075:
            if (r2 != 0) goto L_0x0078
            goto L_0x007d
        L_0x0078:
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x007d:
            if (r3 != 0) goto L_0x0080
            goto L_0x0085
        L_0x0080:
            java.io.Closeable r3 = (java.io.Closeable) r3
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0085:
            throw r6
        L_0x0086:
            java.lang.String r6 = "already closed"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0092 }
            r7.<init>(r6)     // Catch:{ all -> 0x0092 }
            throw r7     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0095:
            java.lang.String r6 = "Failed requirement."
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadClose(int, java.lang.String):void");
    }

    public boolean send(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return send(ByteString.Companion.encodeUtf8(str), 1);
    }

    public boolean send(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return send(byteString, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }

    public final synchronized boolean pong(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public boolean close(int i, String str) {
        return close(i, str, 60000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r8, java.lang.String r9, long r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x004e }
            r0.validateCloseCode(r8)     // Catch:{ all -> 0x004e }
            r0 = 0
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0032
            okio.ByteString$Companion r0 = okio.ByteString.Companion     // Catch:{ all -> 0x004e }
            okio.ByteString r0 = r0.encodeUtf8(r9)     // Catch:{ all -> 0x004e }
            int r3 = r0.size()     // Catch:{ all -> 0x004e }
            long r3 = (long) r3     // Catch:{ all -> 0x004e }
            r5 = 123(0x7b, double:6.1E-322)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x001e
            r3 = r2
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x0032
        L_0x0022:
            java.lang.String r8 = "reason.size() > 123: "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r9)     // Catch:{ all -> 0x004e }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x004e }
            r9.<init>(r8)     // Catch:{ all -> 0x004e }
            throw r9     // Catch:{ all -> 0x004e }
        L_0x0032:
            boolean r9 = r7.failed     // Catch:{ all -> 0x004e }
            if (r9 != 0) goto L_0x004c
            boolean r9 = r7.enqueuedClose     // Catch:{ all -> 0x004e }
            if (r9 == 0) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            r7.enqueuedClose = r2     // Catch:{ all -> 0x004e }
            java.util.ArrayDeque<java.lang.Object> r9 = r7.messageAndCloseQueue     // Catch:{ all -> 0x004e }
            okhttp3.internal.ws.RealWebSocket$Close r1 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x004e }
            r1.<init>(r8, r0, r10)     // Catch:{ all -> 0x004e }
            r9.add(r1)     // Catch:{ all -> 0x004e }
            r7.runWriter()     // Catch:{ all -> 0x004e }
            monitor-exit(r7)
            return r2
        L_0x004c:
            monitor-exit(r7)
            return r1
        L_0x004e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (r2 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        if ((r5 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        r5 = (okhttp3.internal.ws.RealWebSocket.Message) r5;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writeMessageFrame(r5.getFormatOpcode(), r5.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0090, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r13.queueSize -= (long) r5.getData().size();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a8, code lost:
        if ((r5 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00aa, code lost:
        r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.writeClose(r5.getCode(), r5.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
        if (r1 == null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bc, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        r13.listener.onClosed(r13, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c7, code lost:
        if (r1 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ca, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cf, code lost:
        if (r8 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        if (r9 != null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00da, code lost:
        okhttp3.internal.Util.closeQuietly(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00df, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e5, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
        if (r1 != null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ea, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ef, code lost:
        if (r8 != null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f2, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f7, code lost:
        if (r9 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        okhttp3.internal.Util.closeQuietly(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ff, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.failed     // Catch:{ all -> 0x0100 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r13)
            return r1
        L_0x0008:
            okhttp3.internal.ws.WebSocketWriter r0 = r13.writer     // Catch:{ all -> 0x0100 }
            java.util.ArrayDeque<okio.ByteString> r2 = r13.pongQueue     // Catch:{ all -> 0x0100 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0100 }
            r3 = 1
            r4 = -1
            r5 = 0
            if (r2 != 0) goto L_0x006a
            java.util.ArrayDeque<java.lang.Object> r6 = r13.messageAndCloseQueue     // Catch:{ all -> 0x0100 }
            java.lang.Object r6 = r6.poll()     // Catch:{ all -> 0x0100 }
            boolean r7 = r6 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x0100 }
            if (r7 == 0) goto L_0x0060
            int r1 = r13.receivedCloseCode     // Catch:{ all -> 0x0100 }
            java.lang.String r7 = r13.receivedCloseReason     // Catch:{ all -> 0x0100 }
            if (r1 == r4) goto L_0x003b
            okhttp3.internal.ws.RealWebSocket$Streams r4 = r13.streams     // Catch:{ all -> 0x0100 }
            r13.streams = r5     // Catch:{ all -> 0x0100 }
            okhttp3.internal.ws.WebSocketReader r8 = r13.reader     // Catch:{ all -> 0x0100 }
            r13.reader = r5     // Catch:{ all -> 0x0100 }
            okhttp3.internal.ws.WebSocketWriter r9 = r13.writer     // Catch:{ all -> 0x0100 }
            r13.writer = r5     // Catch:{ all -> 0x0100 }
            okhttp3.internal.concurrent.TaskQueue r5 = r13.taskQueue     // Catch:{ all -> 0x0100 }
            r5.shutdown()     // Catch:{ all -> 0x0100 }
            r5 = r6
            r12 = r4
            r4 = r1
            r1 = r12
            goto L_0x006e
        L_0x003b:
            r4 = r6
            okhttp3.internal.ws.RealWebSocket$Close r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x0100 }
            long r8 = r4.getCancelAfterCloseMillis()     // Catch:{ all -> 0x0100 }
            okhttp3.internal.concurrent.TaskQueue r4 = r13.taskQueue     // Catch:{ all -> 0x0100 }
            java.lang.String r10 = r13.name     // Catch:{ all -> 0x0100 }
            java.lang.String r11 = " cancel"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r11)     // Catch:{ all -> 0x0100 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0100 }
            long r8 = r11.toNanos(r8)     // Catch:{ all -> 0x0100 }
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1 r11 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1     // Catch:{ all -> 0x0100 }
            r11.<init>(r10, r3, r13)     // Catch:{ all -> 0x0100 }
            okhttp3.internal.concurrent.Task r11 = (okhttp3.internal.concurrent.Task) r11     // Catch:{ all -> 0x0100 }
            r4.schedule(r11, r8)     // Catch:{ all -> 0x0100 }
            r4 = r1
            r1 = r5
            r8 = r1
            goto L_0x0067
        L_0x0060:
            if (r6 != 0) goto L_0x0064
            monitor-exit(r13)
            return r1
        L_0x0064:
            r1 = r5
            r7 = r1
            r8 = r7
        L_0x0067:
            r9 = r8
            r5 = r6
            goto L_0x006e
        L_0x006a:
            r1 = r5
            r7 = r1
            r8 = r7
            r9 = r8
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0100 }
            monitor-exit(r13)
            if (r2 == 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00e6 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00e6 }
            r0.writePong(r2)     // Catch:{ all -> 0x00e6 }
            goto L_0x00c7
        L_0x007c:
            boolean r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00a6
            okhttp3.internal.ws.RealWebSocket$Message r5 = (okhttp3.internal.ws.RealWebSocket.Message) r5     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00e6 }
            int r2 = r5.getFormatOpcode()     // Catch:{ all -> 0x00e6 }
            okio.ByteString r4 = r5.getData()     // Catch:{ all -> 0x00e6 }
            r0.writeMessageFrame(r2, r4)     // Catch:{ all -> 0x00e6 }
            monitor-enter(r13)     // Catch:{ all -> 0x00e6 }
            long r6 = r13.queueSize     // Catch:{ all -> 0x00a3 }
            okio.ByteString r0 = r5.getData()     // Catch:{ all -> 0x00a3 }
            int r0 = r0.size()     // Catch:{ all -> 0x00a3 }
            long r4 = (long) r0     // Catch:{ all -> 0x00a3 }
            long r6 = r6 - r4
            r13.queueSize = r6     // Catch:{ all -> 0x00a3 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a3 }
            monitor-exit(r13)     // Catch:{ all -> 0x00e6 }
            goto L_0x00c7
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00e6 }
            throw r0     // Catch:{ all -> 0x00e6 }
        L_0x00a6:
            boolean r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00e0
            okhttp3.internal.ws.RealWebSocket$Close r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00e6 }
            int r2 = r5.getCode()     // Catch:{ all -> 0x00e6 }
            okio.ByteString r5 = r5.getReason()     // Catch:{ all -> 0x00e6 }
            r0.writeClose(r2, r5)     // Catch:{ all -> 0x00e6 }
            if (r1 == 0) goto L_0x00c7
            okhttp3.WebSocketListener r0 = r13.listener     // Catch:{ all -> 0x00e6 }
            r2 = r13
            okhttp3.WebSocket r2 = (okhttp3.WebSocket) r2     // Catch:{ all -> 0x00e6 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x00e6 }
            r0.onClosed(r2, r4, r7)     // Catch:{ all -> 0x00e6 }
        L_0x00c7:
            if (r1 != 0) goto L_0x00ca
            goto L_0x00cf
        L_0x00ca:
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x00cf:
            if (r8 != 0) goto L_0x00d2
            goto L_0x00d7
        L_0x00d2:
            java.io.Closeable r8 = (java.io.Closeable) r8
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00d7:
            if (r9 != 0) goto L_0x00da
            goto L_0x00df
        L_0x00da:
            java.io.Closeable r9 = (java.io.Closeable) r9
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00df:
            return r3
        L_0x00e0:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00e6 }
            r0.<init>()     // Catch:{ all -> 0x00e6 }
            throw r0     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r0 = move-exception
            if (r1 != 0) goto L_0x00ea
            goto L_0x00ef
        L_0x00ea:
            java.io.Closeable r1 = (java.io.Closeable) r1
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x00ef:
            if (r8 != 0) goto L_0x00f2
            goto L_0x00f7
        L_0x00f2:
            java.io.Closeable r8 = (java.io.Closeable) r8
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00f7:
            if (r9 != 0) goto L_0x00fa
            goto L_0x00ff
        L_0x00fa:
            java.io.Closeable r9 = (java.io.Closeable) r9
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00ff:
            throw r0
        L_0x0100:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        if (r1 == -1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.writePing(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0062 }
            r2 = -1
            if (r1 == 0) goto L_0x0015
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0062 }
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0062 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0062 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0062 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            monitor-exit(r7)
            r3 = 0
            if (r1 == r2) goto L_0x0055
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            java.lang.StringBuilder r2 = r2.append(r5)
            long r5 = r7.pingIntervalMillis
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = "ms (after "
            java.lang.StringBuilder r2 = r2.append(r5)
            int r1 = r1 - r4
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " successful ping/pongs)"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Exception r0 = (java.lang.Exception) r0
            r7.failWebSocket(r0, r3)
            return
        L_0x0055:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x005b }
            r0.writePing(r1)     // Catch:{ IOException -> 0x005b }
            goto L_0x0061
        L_0x005b:
            r0 = move-exception
            java.lang.Exception r0 = (java.lang.Exception) r0
            r7.failWebSocket(r0, r3)
        L_0x0061:
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r5.listener.onFailure(r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r0 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r2 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r3 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r6, okhttp3.Response r7) {
        /*
            r5 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            monitor-enter(r5)
            boolean r0 = r5.failed     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r0 = 1
            r5.failed = r0     // Catch:{ all -> 0x0061 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r5.streams     // Catch:{ all -> 0x0061 }
            r1 = 0
            r5.streams = r1     // Catch:{ all -> 0x0061 }
            okhttp3.internal.ws.WebSocketReader r2 = r5.reader     // Catch:{ all -> 0x0061 }
            r5.reader = r1     // Catch:{ all -> 0x0061 }
            okhttp3.internal.ws.WebSocketWriter r3 = r5.writer     // Catch:{ all -> 0x0061 }
            r5.writer = r1     // Catch:{ all -> 0x0061 }
            okhttp3.internal.concurrent.TaskQueue r1 = r5.taskQueue     // Catch:{ all -> 0x0061 }
            r1.shutdown()     // Catch:{ all -> 0x0061 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            okhttp3.WebSocketListener r1 = r5.listener     // Catch:{ all -> 0x0047 }
            r4 = r5
            okhttp3.WebSocket r4 = (okhttp3.WebSocket) r4     // Catch:{ all -> 0x0047 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0047 }
            r1.onFailure(r4, r6, r7)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0031
            goto L_0x0036
        L_0x0031:
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x0036:
            if (r2 != 0) goto L_0x0039
            goto L_0x003e
        L_0x0039:
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x003e:
            if (r3 != 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            java.io.Closeable r3 = (java.io.Closeable) r3
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0046:
            return
        L_0x0047:
            r6 = move-exception
            if (r0 != 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x0050:
            if (r2 != 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            java.io.Closeable r2 = (java.io.Closeable) r2
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0058:
            if (r3 != 0) goto L_0x005b
            goto L_0x0060
        L_0x005b:
            java.io.Closeable r3 = (java.io.Closeable) r3
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0060:
            throw r6
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealWebSocket.kt */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i, ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "data");
            this.formatOpcode = i;
            this.data = byteString;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealWebSocket.kt */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealWebSocket.kt */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Intrinsics.checkNotNullParameter(bufferedSink, "sink");
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealWebSocket.kt */
    private final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket realWebSocket) {
            super(Intrinsics.stringPlus(realWebSocket.name, " writer"), false, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(realWebSocket, "this$0");
            this.this$0 = realWebSocket;
        }

        public long runOnce() {
            try {
                if (this.this$0.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e) {
                this.this$0.failWebSocket(e, (Response) null);
                return -1;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealWebSocket.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, (Object) null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }
}
