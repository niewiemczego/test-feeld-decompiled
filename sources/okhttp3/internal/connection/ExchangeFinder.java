package okhttp3.internal.connection;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExchangeFinder.kt */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address2, RealCall realCall, EventListener eventListener2) {
        Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address2, "address");
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual((Object) realInterceptorChain.getRequest$okhttp().method(), (Object) ShareTarget.METHOD_GET)).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (RouteException e) {
            trackFailure(e.getLastConnectException());
            throw e;
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z3 = true;
                if (!(selection == null ? true : selection.hasNext())) {
                    RouteSelector routeSelector2 = this.routeSelector;
                    if (routeSelector2 != null) {
                        z3 = routeSelector2.hasNext();
                    }
                    if (!z3) {
                        throw new IOException("exhausted all routes");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            r14 = this;
            r1 = r14
            okhttp3.internal.connection.RealCall r0 = r1.call
            boolean r0 = r0.isCanceled()
            if (r0 != 0) goto L_0x0196
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r2 = r0.getConnection()
            r0 = 1
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0069
            monitor-enter(r2)
            boolean r5 = r2.getNoNewExchanges()     // Catch:{ all -> 0x0066 }
            if (r5 != 0) goto L_0x0030
            okhttp3.Route r5 = r2.route()     // Catch:{ all -> 0x0066 }
            okhttp3.Address r5 = r5.address()     // Catch:{ all -> 0x0066 }
            okhttp3.HttpUrl r5 = r5.url()     // Catch:{ all -> 0x0066 }
            boolean r5 = r14.sameHostAndPort(r5)     // Catch:{ all -> 0x0066 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r5 = r4
            goto L_0x0036
        L_0x0030:
            okhttp3.internal.connection.RealCall r5 = r1.call     // Catch:{ all -> 0x0066 }
            java.net.Socket r5 = r5.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x0066 }
        L_0x0036:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0066 }
            monitor-exit(r2)
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.internal.connection.RealConnection r6 = r6.getConnection()
            if (r6 == 0) goto L_0x0054
            if (r5 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            return r2
        L_0x0048:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0054:
            if (r5 != 0) goto L_0x0057
            goto L_0x005a
        L_0x0057:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r5)
        L_0x005a:
            okhttp3.EventListener r5 = r1.eventListener
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.Call r6 = (okhttp3.Call) r6
            okhttp3.Connection r2 = (okhttp3.Connection) r2
            r5.connectionReleased(r6, r2)
            goto L_0x0069
        L_0x0066:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0069:
            r1.refusedStreamCount = r3
            r1.connectionShutdownCount = r3
            r1.otherFailureCount = r3
            okhttp3.internal.connection.RealConnectionPool r2 = r1.connectionPool
            okhttp3.Address r5 = r1.address
            okhttp3.internal.connection.RealCall r6 = r1.call
            boolean r2 = r2.callAcquirePooledConnection(r5, r6, r4, r3)
            if (r2 == 0) goto L_0x0091
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            r4 = r0
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r2.connectionAcquired(r3, r4)
            return r0
        L_0x0091:
            okhttp3.Route r2 = r1.nextRouteToTry
            if (r2 == 0) goto L_0x009c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1.nextRouteToTry = r4
        L_0x009a:
            r5 = r4
            goto L_0x0108
        L_0x009c:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            if (r2 == 0) goto L_0x00b3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.hasNext()
            if (r2 == 0) goto L_0x00b3
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.Route r2 = r2.next()
            goto L_0x009a
        L_0x00b3:
            okhttp3.internal.connection.RouteSelector r2 = r1.routeSelector
            if (r2 != 0) goto L_0x00d0
            okhttp3.internal.connection.RouteSelector r2 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r5 = r1.address
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.OkHttpClient r6 = r6.getClient()
            okhttp3.internal.connection.RouteDatabase r6 = r6.getRouteDatabase()
            okhttp3.internal.connection.RealCall r7 = r1.call
            okhttp3.Call r7 = (okhttp3.Call) r7
            okhttp3.EventListener r8 = r1.eventListener
            r2.<init>(r5, r6, r7, r8)
            r1.routeSelector = r2
        L_0x00d0:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r2.next()
            r1.routeSelection = r2
            java.util.List r5 = r2.getRoutes()
            okhttp3.internal.connection.RealCall r6 = r1.call
            boolean r6 = r6.isCanceled()
            if (r6 != 0) goto L_0x018e
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            okhttp3.Address r7 = r1.address
            okhttp3.internal.connection.RealCall r8 = r1.call
            boolean r3 = r6.callAcquirePooledConnection(r7, r8, r5, r3)
            if (r3 == 0) goto L_0x0104
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            r4 = r0
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r2.connectionAcquired(r3, r4)
            return r0
        L_0x0104:
            okhttp3.Route r2 = r2.next()
        L_0x0108:
            okhttp3.internal.connection.RealConnection r3 = new okhttp3.internal.connection.RealConnection
            okhttp3.internal.connection.RealConnectionPool r6 = r1.connectionPool
            r3.<init>(r6, r2)
            okhttp3.internal.connection.RealCall r6 = r1.call
            r6.setConnectionToCancel(r3)
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ all -> 0x0187 }
            r12 = r6
            okhttp3.Call r12 = (okhttp3.Call) r12     // Catch:{ all -> 0x0187 }
            okhttp3.EventListener r13 = r1.eventListener     // Catch:{ all -> 0x0187 }
            r6 = r3
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r11 = r19
            r6.connect(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0187 }
            okhttp3.internal.connection.RealCall r6 = r1.call
            r6.setConnectionToCancel(r4)
            okhttp3.internal.connection.RealCall r4 = r1.call
            okhttp3.OkHttpClient r4 = r4.getClient()
            okhttp3.internal.connection.RouteDatabase r4 = r4.getRouteDatabase()
            okhttp3.Route r6 = r3.route()
            r4.connected(r6)
            okhttp3.internal.connection.RealConnectionPool r4 = r1.connectionPool
            okhttp3.Address r6 = r1.address
            okhttp3.internal.connection.RealCall r7 = r1.call
            boolean r0 = r4.callAcquirePooledConnection(r6, r7, r5, r0)
            if (r0 == 0) goto L_0x0169
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.nextRouteToTry = r2
            java.net.Socket r2 = r3.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r3 = r1.call
            okhttp3.Call r3 = (okhttp3.Call) r3
            r4 = r0
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r2.connectionAcquired(r3, r4)
            return r0
        L_0x0169:
            monitor-enter(r3)
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0184 }
            r0.put(r3)     // Catch:{ all -> 0x0184 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0184 }
            r0.acquireConnectionNoEvents(r3)     // Catch:{ all -> 0x0184 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0184 }
            monitor-exit(r3)
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r2 = r1.call
            okhttp3.Call r2 = (okhttp3.Call) r2
            r4 = r3
            okhttp3.Connection r4 = (okhttp3.Connection) r4
            r0.connectionAcquired(r2, r4)
            return r3
        L_0x0184:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0187:
            r0 = move-exception
            okhttp3.internal.connection.RealCall r2 = r1.call
            r2.setConnectionToCancel(r4)
            throw r0
        L_0x018e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        L_0x0196:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector2;
        boolean z = false;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            z = true;
        }
        if (!z && (routeSelector2 = this.routeSelector) != null) {
            return routeSelector2.hasNext();
        }
        return true;
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), getAddress$okhttp().url())) {
                return null;
            }
            Route route = connection.route();
            return route;
        }
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        HttpUrl url = this.address.url();
        return httpUrl.port() == url.port() && Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host());
    }
}
