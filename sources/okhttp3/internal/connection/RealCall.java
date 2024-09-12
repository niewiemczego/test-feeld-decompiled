package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import io.sentry.ProfilingTraceData;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u00002\u00020\u0001:\u0002deB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u000fJ!\u00103\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u00106\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u00020\u0000H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0016J\u0016\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0007J\b\u0010E\u001a\u00020FH\u0016J\u0015\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u0007H\u0000¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020FH\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020NH\u0000¢\u0006\u0002\bOJ\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J;\u0010R\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u00106\u001a\u0002H4H\u0000¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u000f\u0010\\\u001a\u0004\u0018\u00010]H\u0000¢\u0006\u0002\b^J\b\u0010C\u001a\u00020\u0005H\u0016J\u0006\u0010_\u001a\u00020\u0007J\b\u0010-\u001a\u00020`H\u0016J\u0006\u00100\u001a\u000202J!\u0010a\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010b\u001a\u0002H4H\u0002¢\u0006\u0002\u00107J\b\u0010c\u001a\u00020ZH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0004¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "connection", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "expectMoreExchanges", "getForWebSocket", "()Z", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getOriginalRequest", "()Lokhttp3/Request;", "requestBodyOpen", "responseBodyOpen", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callDone", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealCall.kt */
public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed = new AtomicBoolean();
    private boolean expectMoreExchanges = true;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(request, "originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        RealCall$timeout$1 realCall$timeout$1 = new RealCall$timeout$1(this);
        realCall$timeout$1.timeout((long) getClient().callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = realCall$timeout$1;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public Request request() {
        return this.originalRequest;
    }

    public void cancel() {
        if (!this.canceled) {
            this.canceled = true;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                exchange2.cancel();
            }
            RealConnection realConnection = this.connectionToCancel;
            if (realConnection != null) {
                realConnection.cancel();
            }
            this.eventListener.canceled(this);
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            this.timeout.enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public void enqueue(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "responseCallback");
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        List arrayList = new ArrayList();
        Collection collection = arrayList;
        CollectionsKt.addAll(collection, this.client.interceptors());
        collection.add(new RetryAndFollowUpInterceptor(this.client));
        collection.add(new BridgeInterceptor(this.client.cookieJar()));
        collection.add(new CacheInterceptor(this.client.cache()));
        collection.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt.addAll(collection, this.client.networkInterceptors());
        }
        collection.add(new CallServerInterceptor(this.forWebSocket));
        try {
            Response proceed = new RealInterceptorChain(this, arrayList, 0, (Exchange) null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!isCanceled()) {
                noMoreExchanges$okhttp((IOException) null);
                return proceed;
            }
            Util.closeQuietly((Closeable) proceed);
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
            if (noMoreExchanges$okhttp == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
            throw noMoreExchanges$okhttp;
        } catch (Throwable th) {
            if (1 == 0) {
                noMoreExchanges$okhttp((IOException) null);
            }
            throw th;
        }
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.interceptorScopedExchange == null) {
            synchronized (this) {
                if (!(!this.responseBodyOpen)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.requestBodyOpen) {
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.requestBodyOpen) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder2);
        Exchange exchange2 = new Exchange(this, this.eventListener, exchangeFinder2, exchangeFinder2.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange2;
        this.exchange = exchange2;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
            Unit unit2 = Unit.INSTANCE;
        }
        if (!this.canceled) {
            return exchange2;
        }
        throw new IOException("Canceled");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[Catch:{ all -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            okhttp3.internal.connection.Exchange r0 = r1.exchange
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r2 != 0) goto L_0x000e
            return r5
        L_0x000e:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L_0x0019
            boolean r0 = r1.requestBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001f
            goto L_0x0019
        L_0x0017:
            r2 = move-exception
            goto L_0x005a
        L_0x0019:
            if (r4 == 0) goto L_0x0041
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0041
        L_0x001f:
            if (r3 == 0) goto L_0x0023
            r1.requestBodyOpen = r2     // Catch:{ all -> 0x0017 }
        L_0x0023:
            if (r4 == 0) goto L_0x0027
            r1.responseBodyOpen = r2     // Catch:{ all -> 0x0017 }
        L_0x0027:
            boolean r3 = r1.requestBodyOpen     // Catch:{ all -> 0x0017 }
            r4 = 1
            if (r3 != 0) goto L_0x0032
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0032
            r0 = r4
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.expectMoreExchanges     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            r2 = r4
        L_0x003e:
            r3 = r2
            r2 = r0
            goto L_0x0042
        L_0x0041:
            r3 = r2
        L_0x0042:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0052
            r2 = 0
            r1.exchange = r2
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            if (r2 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r2.incrementSuccessCount$okhttp()
        L_0x0052:
            if (r3 == 0) goto L_0x0059
            java.io.IOException r2 = r1.callDone(r5)
            return r2
        L_0x0059:
            return r5
        L_0x005a:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            return callDone(iOException);
        }
        return iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            Iterator<Reference<RealCall>> it = calls.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().get(), (Object) this)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                z = true;
            }
            if (z) {
                calls.remove(i);
                this.connection = null;
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(realConnection)) {
                        return realConnection.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return e;
        }
        E interruptedIOException = new InterruptedIOException(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
        if (e != null) {
            interruptedIOException.initCause((Throwable) e);
        }
        return (IOException) interruptedIOException;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange2;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z && (exchange2 = this.exchange) != null) {
            exchange2.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    private final Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder2);
        return exchangeFinder2.retryAfterFailure();
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl$okhttp();
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealCall.kt */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            Intrinsics.checkNotNullParameter(realCall, "this$0");
            Intrinsics.checkNotNullParameter(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            Intrinsics.checkNotNullParameter(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock(dispatcher)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[Catch:{ all -> 0x0061, all -> 0x00a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[Catch:{ all -> 0x0061, all -> 0x00a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0080 A[Catch:{ all -> 0x0061, all -> 0x00a1 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                okhttp3.internal.connection.RealCall r0 = r8.this$0
                java.lang.String r0 = r0.redactedUrl$okhttp()
                java.lang.String r1 = "OkHttp "
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
                okhttp3.internal.connection.RealCall r1 = r8.this$0
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                java.lang.String r3 = r2.getName()
                r2.setName(r0)
                r0 = 0
                okhttp3.internal.connection.RealCall$timeout$1 r4 = r1.timeout     // Catch:{ all -> 0x00a1 }
                r4.enter()     // Catch:{ all -> 0x00a1 }
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain$okhttp()     // Catch:{ IOException -> 0x0063, all -> 0x003e }
                r4 = 1
                okhttp3.Callback r5 = r8.responseCallback     // Catch:{ IOException -> 0x003c, all -> 0x003a }
                r6 = r1
                okhttp3.Call r6 = (okhttp3.Call) r6     // Catch:{ IOException -> 0x003c, all -> 0x003a }
                r5.onResponse(r6, r0)     // Catch:{ IOException -> 0x003c, all -> 0x003a }
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00a1 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00a1 }
            L_0x0036:
                r0.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r8)     // Catch:{ all -> 0x00a1 }
                goto L_0x0091
            L_0x003a:
                r0 = move-exception
                goto L_0x0042
            L_0x003c:
                r0 = move-exception
                goto L_0x0067
            L_0x003e:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x0042:
                r1.cancel()     // Catch:{ all -> 0x0061 }
                if (r4 != 0) goto L_0x0060
                java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0061 }
                java.lang.String r5 = "canceled due to "
                java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r0)     // Catch:{ all -> 0x0061 }
                r4.<init>(r5)     // Catch:{ all -> 0x0061 }
                r5 = r4
                java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x0061 }
                kotlin.ExceptionsKt.addSuppressed(r5, r0)     // Catch:{ all -> 0x0061 }
                okhttp3.Callback r5 = r8.responseCallback     // Catch:{ all -> 0x0061 }
                r6 = r1
                okhttp3.Call r6 = (okhttp3.Call) r6     // Catch:{ all -> 0x0061 }
                r5.onFailure(r6, r4)     // Catch:{ all -> 0x0061 }
            L_0x0060:
                throw r0     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r0 = move-exception
                goto L_0x0095
            L_0x0063:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x0067:
                if (r4 == 0) goto L_0x0080
                okhttp3.internal.platform.Platform$Companion r4 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0061 }
                okhttp3.internal.platform.Platform r4 = r4.get()     // Catch:{ all -> 0x0061 }
                java.lang.String r5 = "Callback failure for "
                java.lang.String r6 = r1.toLoggableString()     // Catch:{ all -> 0x0061 }
                java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r6)     // Catch:{ all -> 0x0061 }
                r6 = 4
                java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0061 }
                r4.log(r5, r6, r0)     // Catch:{ all -> 0x0061 }
                goto L_0x0088
            L_0x0080:
                okhttp3.Callback r4 = r8.responseCallback     // Catch:{ all -> 0x0061 }
                r5 = r1
                okhttp3.Call r5 = (okhttp3.Call) r5     // Catch:{ all -> 0x0061 }
                r4.onFailure(r5, r0)     // Catch:{ all -> 0x0061 }
            L_0x0088:
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00a1 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00a1 }
                goto L_0x0036
            L_0x0091:
                r2.setName(r3)
                return
            L_0x0095:
                okhttp3.OkHttpClient r1 = r1.getClient()     // Catch:{ all -> 0x00a1 }
                okhttp3.Dispatcher r1 = r1.dispatcher()     // Catch:{ all -> 0x00a1 }
                r1.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r8)     // Catch:{ all -> 0x00a1 }
                throw r0     // Catch:{ all -> 0x00a1 }
            L_0x00a1:
                r0 = move-exception
                r2.setName(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.AsyncCall.run():void");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RealCall.kt */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            Intrinsics.checkNotNullParameter(realCall, "referent");
            this.callStackTrace = obj;
        }
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection == null) {
                this.connection = realConnection;
                realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    private final <E extends IOException> E callDone(E e) {
        Socket releaseConnectionNoEvents$okhttp;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                if (!Util.assertionsEnabled || !Thread.holdsLock(realConnection)) {
                    synchronized (realConnection) {
                        releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
                    }
                    if (this.connection == null) {
                        if (releaseConnectionNoEvents$okhttp != null) {
                            Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                        }
                        this.eventListener.connectionReleased(this, realConnection);
                    } else {
                        if (!(releaseConnectionNoEvents$okhttp == null)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
                }
            }
            E timeoutExit = timeoutExit(e);
            if (e != null) {
                Intrinsics.checkNotNull(timeoutExit);
                this.eventListener.callFailed(this, timeoutExit);
            } else {
                this.eventListener.callEnd(this);
            }
            return timeoutExit;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
