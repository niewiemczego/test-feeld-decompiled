package com.launchdarkly.eventsource;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.net.HttpHeaders;
import com.launchdarkly.eventsource.ConnectionErrorHandler;
import com.launchdarkly.logging.LDLogger;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EventSource implements Closeable {
    public static final long DEFAULT_BACKOFF_RESET_THRESHOLD_MILLIS = 60000;
    public static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000;
    public static final long DEFAULT_MAX_RECONNECT_TIME_MILLIS = 30000;
    public static final int DEFAULT_READ_BUFFER_SIZE = 1000;
    public static final long DEFAULT_READ_TIMEOUT_MILLIS = 5000;
    public static final long DEFAULT_RECONNECT_TIME_MILLIS = 1000;
    public static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 5000;
    private static final Headers defaultHeaders = new Headers.Builder().add("Accept", "text/event-stream").add("Cache-Control", "no-cache").build();
    final long backoffResetThresholdMillis;
    private final RequestBody body;
    private volatile Call call;
    private final OkHttpClient client;
    private final ConnectionErrorHandler connectionErrorHandler;
    private final ExecutorService eventExecutor;
    final Set<String> expectFields;
    final AsyncEventHandler handler;
    private final Headers headers;
    private final SecureRandom jitter = new SecureRandom();
    private volatile String lastEventId;
    final LDLogger logger;
    final long maxReconnectTimeMillis;
    private final String method;
    private final String name;
    final int readBufferSize;
    private final AtomicReference<ReadyState> readyState;
    volatile long reconnectTimeMillis;
    private final RequestTransformer requestTransformer;
    final boolean streamEventData;
    private final ExecutorService streamExecutor;
    private volatile HttpUrl url;

    public interface RequestTransformer {
        Request transformRequest(Request request);
    }

    EventSource(Builder builder) {
        this.name = builder.name == null ? "" : builder.name;
        LDLogger none = builder.logger == null ? LDLogger.none() : builder.logger;
        this.logger = none;
        this.url = builder.url;
        this.headers = addDefaultHeaders(builder.headers);
        this.method = builder.method;
        this.body = builder.body;
        this.requestTransformer = builder.requestTransformer;
        this.lastEventId = builder.lastEventId;
        this.reconnectTimeMillis = builder.reconnectTimeMillis;
        this.maxReconnectTimeMillis = builder.maxReconnectTimeMillis;
        this.backoffResetThresholdMillis = builder.backoffResetThresholdMillis;
        this.streamEventData = builder.streamEventData;
        this.expectFields = builder.expectFields;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(createThreadFactory("okhttp-eventsource-events", builder.threadPriority));
        this.eventExecutor = newSingleThreadExecutor;
        this.streamExecutor = Executors.newSingleThreadExecutor(createThreadFactory("okhttp-eventsource-stream", builder.threadPriority));
        this.handler = new AsyncEventHandler(newSingleThreadExecutor, builder.handler, none, builder.maxEventTasksInFlight > 0 ? new Semaphore(builder.maxEventTasksInFlight) : null);
        this.connectionErrorHandler = builder.connectionErrorHandler == null ? ConnectionErrorHandler.DEFAULT : builder.connectionErrorHandler;
        this.readBufferSize = builder.readBufferSize;
        this.readyState = new AtomicReference<>(ReadyState.RAW);
        this.client = builder.clientBuilder.build();
    }

    private ThreadFactory createThreadFactory(String str, Integer num) {
        return new EventSource$$ExternalSyntheticLambda1(this, Executors.defaultThreadFactory(), str, new AtomicLong(0), num);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createThreadFactory$0$com-launchdarkly-eventsource-EventSource  reason: not valid java name */
    public /* synthetic */ Thread m611lambda$createThreadFactory$0$comlaunchdarklyeventsourceEventSource(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Integer num, Runnable runnable) {
        Thread newThread = threadFactory.newThread(runnable);
        newThread.setName(String.format(Locale.ROOT, "%s-[%s]-%d", new Object[]{str, this.name, Long.valueOf(atomicLong.getAndIncrement())}));
        newThread.setDaemon(true);
        if (num != null) {
            newThread.setPriority(num.intValue());
        }
        return newThread;
    }

    public void start() {
        if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.RAW, ReadyState.CONNECTING)) {
            this.logger.info("Start method called on this already-started EventSource object. Doing nothing");
            return;
        }
        this.logger.debug("readyState change: {} -> {}", ReadyState.RAW, ReadyState.CONNECTING);
        this.logger.info("Starting EventSource client using URI: {}", (Object) this.url);
        this.streamExecutor.execute(new EventSource$$ExternalSyntheticLambda2(this));
    }

    static /* synthetic */ ReadyState lambda$restart$1(ReadyState readyState2) {
        return readyState2 == ReadyState.OPEN ? ReadyState.CLOSED : readyState2;
    }

    public void restart() {
        ReadyState andUpdate = this.readyState.getAndUpdate(new EventSource$$ExternalSyntheticLambda0());
        if (andUpdate == ReadyState.OPEN) {
            closeCurrentStream(andUpdate);
        } else if (andUpdate == ReadyState.RAW) {
            start();
        }
    }

    public ReadyState getState() {
        return this.readyState.get();
    }

    public void close() {
        ReadyState andSet = this.readyState.getAndSet(ReadyState.SHUTDOWN);
        this.logger.debug("readyState change: {} -> {}", andSet, ReadyState.SHUTDOWN);
        if (andSet != ReadyState.SHUTDOWN) {
            closeCurrentStream(andSet);
            this.eventExecutor.shutdown();
            this.streamExecutor.shutdown();
            if (this.client.connectionPool() != null) {
                this.client.connectionPool().evictAll();
            }
            if (this.client.dispatcher() != null) {
                this.client.dispatcher().cancelAll();
                if (this.client.dispatcher().executorService() != null) {
                    this.client.dispatcher().executorService().shutdownNow();
                }
            }
        }
    }

    public boolean awaitClosed(long j, TimeUnit timeUnit) throws InterruptedException {
        long millisFromTimeUnit = millisFromTimeUnit(j, timeUnit);
        long currentTimeMillis = System.currentTimeMillis() + millisFromTimeUnit;
        if (!this.eventExecutor.awaitTermination(millisFromTimeUnit, TimeUnit.MILLISECONDS)) {
            return false;
        }
        if (!this.streamExecutor.awaitTermination(Math.max(0, currentTimeMillis - System.currentTimeMillis()), TimeUnit.MILLISECONDS)) {
            return false;
        }
        if (this.client.dispatcher().executorService() == null) {
            return true;
        }
        if (!this.client.dispatcher().executorService().awaitTermination(Math.max(0, currentTimeMillis - System.currentTimeMillis()), TimeUnit.MILLISECONDS)) {
            return false;
        }
        return true;
    }

    private void closeCurrentStream(ReadyState readyState2) {
        if (readyState2 == ReadyState.OPEN) {
            this.handler.onClosed();
        }
        if (this.call != null) {
            this.call.cancel();
            this.logger.debug("call cancelled");
        }
    }

    /* access modifiers changed from: package-private */
    public Request buildRequest() {
        Request.Builder method2 = new Request.Builder().headers(this.headers).url(this.url).method(this.method, this.body);
        if (this.lastEventId != null && !this.lastEventId.isEmpty()) {
            method2.addHeader(HttpHeaders.LAST_EVENT_ID, this.lastEventId);
        }
        Request build = method2.build();
        RequestTransformer requestTransformer2 = this.requestTransformer;
        return requestTransformer2 == null ? build : requestTransformer2.transformRequest(build);
    }

    /* access modifiers changed from: private */
    public void run() {
        AtomicLong atomicLong = new AtomicLong();
        int i = 0;
        while (!Thread.currentThread().isInterrupted() && this.readyState.get() != ReadyState.SHUTDOWN) {
            try {
                if (i == 0) {
                    i++;
                } else {
                    i = maybeReconnectDelay(i, atomicLong.get());
                }
                newConnectionAttempt(atomicLong);
            } catch (RejectedExecutionException e) {
                this.call = null;
                this.logger.debug("Rejected execution exception ignored: {}", (Object) e);
                return;
            }
        }
    }

    private int maybeReconnectDelay(int i, long j) {
        if (this.reconnectTimeMillis <= 0) {
            return i;
        }
        if (j > 0 && System.currentTimeMillis() - j >= this.backoffResetThresholdMillis) {
            i = 1;
        }
        try {
            long backoffWithJitterMillis = backoffWithJitterMillis(i);
            this.logger.info("Waiting {} milliseconds before reconnecting...", (Object) Long.valueOf(backoffWithJitterMillis));
            Thread.sleep(backoffWithJitterMillis);
        } catch (InterruptedException unused) {
        }
        return i + 1;
    }

    private void newConnectionAttempt(AtomicLong atomicLong) {
        Response execute;
        ConnectionErrorHandler.Action action = ConnectionErrorHandler.Action.PROCEED;
        this.logger.debug("readyState change: {} -> {}", this.readyState.getAndSet(ReadyState.CONNECTING), ReadyState.CONNECTING);
        atomicLong.set(0);
        this.call = this.client.newCall(buildRequest());
        try {
            execute = this.call.execute();
            if (execute.isSuccessful()) {
                atomicLong.set(System.currentTimeMillis());
                handleSuccessfulResponse(execute);
                ReadyState readyState2 = this.readyState.get();
                if (!(readyState2 == ReadyState.SHUTDOWN || readyState2 == ReadyState.CLOSED)) {
                    this.logger.warn("Connection unexpectedly closed");
                    action = this.connectionErrorHandler.onConnectionError(new EOFException());
                }
            } else {
                this.logger.debug("Unsuccessful response: {}", (Object) execute);
                action = dispatchError(new UnsuccessfulResponseException(execute.code()));
            }
            if (execute != null) {
                execute.close();
            }
            if (action != ConnectionErrorHandler.Action.SHUTDOWN) {
                boolean m = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.OPEN, ReadyState.CLOSED);
                boolean m2 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.CONNECTING, ReadyState.CLOSED);
                if (!m) {
                    if (!m2) {
                        return;
                    }
                    this.logger.debug("readyState change: {} -> {}", ReadyState.CONNECTING, ReadyState.CLOSED);
                    return;
                }
                this.logger.debug("readyState change: {} -> {}", ReadyState.OPEN, ReadyState.CLOSED);
                this.handler.onClosed();
                return;
            }
        } catch (IOException e) {
            try {
                ReadyState readyState3 = this.readyState.get();
                if (!(readyState3 == ReadyState.SHUTDOWN || readyState3 == ReadyState.CLOSED)) {
                    this.logger.debug("Connection problem: {}", (Object) e);
                    action = dispatchError(e);
                }
                if (action != ConnectionErrorHandler.Action.SHUTDOWN) {
                    boolean m3 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.OPEN, ReadyState.CLOSED);
                    boolean m4 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.CONNECTING, ReadyState.CLOSED);
                    if (!m3) {
                        if (!m4) {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                if (action != ConnectionErrorHandler.Action.SHUTDOWN) {
                    boolean m5 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.OPEN, ReadyState.CLOSED);
                    boolean m6 = LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.readyState, ReadyState.CONNECTING, ReadyState.CLOSED);
                    if (m5) {
                        this.logger.debug("readyState change: {} -> {}", ReadyState.OPEN, ReadyState.CLOSED);
                        this.handler.onClosed();
                    } else if (m6) {
                        this.logger.debug("readyState change: {} -> {}", ReadyState.CONNECTING, ReadyState.CLOSED);
                    }
                } else {
                    this.logger.info("Connection has been explicitly shut down by error handler");
                    close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        this.logger.info("Connection has been explicitly shut down by error handler");
        close();
        return;
        throw th;
    }

    private void handleSuccessfulResponse(Response response) throws IOException {
        AnonymousClass1 r4 = new ConnectionHandler() {
            public void setReconnectTimeMillis(long j) {
                EventSource.this.setReconnectTimeMillis(j);
            }

            public void setLastEventId(String str) {
                EventSource.this.setLastEventId(str);
            }
        };
        ReadyState andSet = this.readyState.getAndSet(ReadyState.OPEN);
        if (andSet != ReadyState.CONNECTING) {
            this.logger.warn("Unexpected readyState change: " + andSet + " -> " + ReadyState.OPEN);
        } else {
            this.logger.debug("readyState change: {} -> {}", andSet, ReadyState.OPEN);
        }
        this.logger.info("Connected to EventSource stream.");
        this.handler.onOpen();
        EventParser eventParser = new EventParser(response.body().byteStream(), this.url.uri(), this.handler, r4, this.readBufferSize, this.streamEventData, this.expectFields, this.logger);
        while (!Thread.currentThread().isInterrupted() && !eventParser.isEof()) {
            eventParser.processStream();
        }
    }

    private ConnectionErrorHandler.Action dispatchError(Throwable th) {
        ConnectionErrorHandler.Action onConnectionError = this.connectionErrorHandler.onConnectionError(th);
        if (onConnectionError != ConnectionErrorHandler.Action.SHUTDOWN) {
            this.handler.onError(th);
        }
        return onConnectionError;
    }

    /* access modifiers changed from: package-private */
    public long backoffWithJitterMillis(int i) {
        long min = Math.min(this.maxReconnectTimeMillis, this.reconnectTimeMillis * ((long) Helpers.pow2(i)));
        int i2 = min > 2147483647L ? Integer.MAX_VALUE : (int) min;
        return (long) ((i2 / 2) + (this.jitter.nextInt(i2) / 2));
    }

    private static Headers addDefaultHeaders(Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        for (String next : defaultHeaders.names()) {
            if (!headers2.names().contains(next)) {
                for (String add : defaultHeaders.values(next)) {
                    builder.add(next, add);
                }
            }
        }
        for (String next2 : headers2.names()) {
            for (String add2 : headers2.values(next2)) {
                builder.add(next2, add2);
            }
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public void setReconnectTimeMillis(long j) {
        this.reconnectTimeMillis = j;
    }

    /* access modifiers changed from: private */
    public void setLastEventId(String str) {
        this.lastEventId = str;
    }

    public String getLastEventId() {
        return this.lastEventId;
    }

    public HttpUrl getHttpUrl() {
        return this.url;
    }

    public URI getUri() {
        return this.url.uri();
    }

    /* access modifiers changed from: private */
    public static long millisFromTimeUnit(long j, TimeUnit timeUnit) {
        return timeUnitOrDefault(timeUnit).toMillis(j);
    }

    /* access modifiers changed from: private */
    public static TimeUnit timeUnitOrDefault(TimeUnit timeUnit) {
        return timeUnit == null ? TimeUnit.MILLISECONDS : timeUnit;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public long backoffResetThresholdMillis;
        /* access modifiers changed from: private */
        public RequestBody body;
        /* access modifiers changed from: private */
        public OkHttpClient.Builder clientBuilder;
        /* access modifiers changed from: private */
        public ConnectionErrorHandler connectionErrorHandler;
        /* access modifiers changed from: private */
        public Set<String> expectFields;
        /* access modifiers changed from: private */
        public final EventHandler handler;
        /* access modifiers changed from: private */
        public Headers headers;
        /* access modifiers changed from: private */
        public String lastEventId;
        /* access modifiers changed from: private */
        public LDLogger logger;
        /* access modifiers changed from: private */
        public int maxEventTasksInFlight;
        /* access modifiers changed from: private */
        public long maxReconnectTimeMillis;
        /* access modifiers changed from: private */
        public String method;
        /* access modifiers changed from: private */
        public String name;
        private Proxy proxy;
        private Authenticator proxyAuthenticator;
        /* access modifiers changed from: private */
        public int readBufferSize;
        /* access modifiers changed from: private */
        public long reconnectTimeMillis;
        /* access modifiers changed from: private */
        public RequestTransformer requestTransformer;
        /* access modifiers changed from: private */
        public boolean streamEventData;
        /* access modifiers changed from: private */
        public Integer threadPriority;
        /* access modifiers changed from: private */
        public final HttpUrl url;

        public interface ClientConfigurer {
            void configure(OkHttpClient.Builder builder);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(EventHandler eventHandler, URI uri) {
            this(eventHandler, uri == null ? null : HttpUrl.get(uri));
        }

        public Builder(EventHandler eventHandler, HttpUrl httpUrl) {
            this.reconnectTimeMillis = 1000;
            this.maxReconnectTimeMillis = 30000;
            this.backoffResetThresholdMillis = 60000;
            this.connectionErrorHandler = ConnectionErrorHandler.DEFAULT;
            this.threadPriority = null;
            this.headers = Headers.of(new String[0]);
            this.proxyAuthenticator = null;
            this.method = ShareTarget.METHOD_GET;
            this.requestTransformer = null;
            this.body = null;
            this.readBufferSize = 1000;
            this.logger = null;
            this.maxEventTasksInFlight = 0;
            this.expectFields = null;
            if (eventHandler == null) {
                throw new IllegalArgumentException("handler must not be null");
            } else if (httpUrl != null) {
                this.url = httpUrl;
                this.handler = eventHandler;
                this.clientBuilder = createInitialClientBuilder();
            } else {
                throw new IllegalArgumentException("URI/URL must not be null");
            }
        }

        private static OkHttpClient.Builder createInitialClientBuilder() {
            OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 1, TimeUnit.SECONDS)).connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000, TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true);
            try {
                retryOnConnectionFailure.sslSocketFactory(new ModernTLSSocketFactory(), defaultTrustManager());
            } catch (GeneralSecurityException unused) {
            }
            return retryOnConnectionFailure;
        }

        public Builder method(String str) {
            this.method = (str == null || str.length() <= 0) ? ShareTarget.METHOD_GET : str.toUpperCase();
            return this;
        }

        public Builder body(RequestBody requestBody) {
            this.body = requestBody;
            return this;
        }

        public Builder requestTransformer(RequestTransformer requestTransformer2) {
            this.requestTransformer = requestTransformer2;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder lastEventId(String str) {
            this.lastEventId = str;
            return this;
        }

        public Builder reconnectTime(long j, TimeUnit timeUnit) {
            this.reconnectTimeMillis = EventSource.millisFromTimeUnit(j, timeUnit);
            return this;
        }

        public Builder maxReconnectTime(long j, TimeUnit timeUnit) {
            this.maxReconnectTimeMillis = EventSource.millisFromTimeUnit(j, timeUnit);
            return this;
        }

        public Builder backoffResetThreshold(long j, TimeUnit timeUnit) {
            this.backoffResetThresholdMillis = EventSource.millisFromTimeUnit(j, timeUnit);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2;
            return this;
        }

        public Builder client(OkHttpClient okHttpClient) {
            this.clientBuilder = okHttpClient.newBuilder();
            return this;
        }

        public Builder proxy(String str, int i) {
            this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
            return this;
        }

        public Builder proxy(Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.clientBuilder.connectTimeout(j, EventSource.timeUnitOrDefault(timeUnit));
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.clientBuilder.writeTimeout(j, EventSource.timeUnitOrDefault(timeUnit));
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.clientBuilder.readTimeout(j, EventSource.timeUnitOrDefault(timeUnit));
            return this;
        }

        public Builder connectionErrorHandler(ConnectionErrorHandler connectionErrorHandler2) {
            this.connectionErrorHandler = connectionErrorHandler2;
            return this;
        }

        public Builder threadPriority(Integer num) {
            this.threadPriority = num;
            return this;
        }

        public Builder clientBuilderActions(ClientConfigurer clientConfigurer) {
            clientConfigurer.configure(this.clientBuilder);
            return this;
        }

        public Builder readBufferSize(int i) {
            if (i > 0) {
                this.readBufferSize = i;
                return this;
            }
            throw new IllegalArgumentException("readBufferSize must be greater than zero");
        }

        public Builder logger(LDLogger lDLogger) {
            this.logger = lDLogger;
            return this;
        }

        public Builder maxEventTasksInFlight(int i) {
            this.maxEventTasksInFlight = i;
            return this;
        }

        public Builder streamEventData(boolean z) {
            this.streamEventData = z;
            return this;
        }

        public Builder expectFields(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                this.expectFields = null;
            } else {
                this.expectFields = new HashSet();
                for (String str : strArr) {
                    if (str != null) {
                        this.expectFields.add(str);
                    }
                }
            }
            return this;
        }

        public EventSource build() {
            Proxy proxy2 = this.proxy;
            if (proxy2 != null) {
                this.clientBuilder.proxy(proxy2);
            }
            Authenticator authenticator = this.proxyAuthenticator;
            if (authenticator != null) {
                this.clientBuilder.proxyAuthenticator(authenticator);
            }
            return new EventSource(this);
        }

        /* access modifiers changed from: protected */
        public OkHttpClient.Builder getClientBuilder() {
            return this.clientBuilder;
        }

        private static X509TrustManager defaultTrustManager() throws GeneralSecurityException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = null;
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
    }
}
