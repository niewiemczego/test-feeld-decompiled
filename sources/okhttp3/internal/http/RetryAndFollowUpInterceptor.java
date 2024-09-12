package okhttp3.internal.http;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RetryAndFollowUpInterceptor.kt */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        this.client = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List emptyList = CollectionsKt.emptyList();
        Response response = null;
        boolean z = true;
        int i = 0;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z);
            try {
                if (!call$okhttp.isCanceled()) {
                    Response proceed = realInterceptorChain.proceed(request$okhttp);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                    }
                    response = proceed;
                    Exchange interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                    Request followUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                    if (followUpRequest == null) {
                        if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                            call$okhttp.timeoutEarlyExit();
                        }
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RequestBody body = followUpRequest.body();
                    if (body == null || !body.isOneShot()) {
                        ResponseBody body2 = response.body();
                        if (body2 != null) {
                            Util.closeQuietly((Closeable) body2);
                        }
                        i++;
                        if (i <= 20) {
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                            request$okhttp = followUpRequest;
                            z = true;
                        } else {
                            throw new ProtocolException(Intrinsics.stringPlus("Too many follow-up requests: ", Integer.valueOf(i)));
                        }
                    } else {
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (RouteException e) {
                if (recover(e.getLastConnectException(), call$okhttp, request$okhttp, false)) {
                    emptyList = CollectionsKt.plus(emptyList, e.getFirstConnectException());
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z = false;
                } else {
                    throw Util.withSuppressed(e.getFirstConnectException(), emptyList);
                }
            } catch (IOException e2) {
                if (recover(e2, call$okhttp, request$okhttp, !(e2 instanceof ConnectionShutdownException))) {
                    emptyList = CollectionsKt.plus(emptyList, e2);
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z = false;
                } else {
                    throw Util.withSuppressed(e2, emptyList);
                }
            } catch (Throwable th) {
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                throw th;
            }
        }
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z) && realCall.retryAfterFailure()) {
            return true;
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r7.getConnection$okhttp();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.Request followUpRequest(okhttp3.Response r6, okhttp3.internal.connection.Exchange r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0010
        L_0x0005:
            okhttp3.internal.connection.RealConnection r1 = r7.getConnection$okhttp()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            okhttp3.Route r1 = r1.route()
        L_0x0010:
            int r2 = r6.code()
            okhttp3.Request r3 = r6.request()
            java.lang.String r3 = r3.method()
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x00e0
            r4 = 308(0x134, float:4.32E-43)
            if (r2 == r4) goto L_0x00e0
            r4 = 401(0x191, float:5.62E-43)
            if (r2 == r4) goto L_0x00d5
            r4 = 421(0x1a5, float:5.9E-43)
            if (r2 == r4) goto L_0x00ae
            r7 = 503(0x1f7, float:7.05E-43)
            if (r2 == r7) goto L_0x0092
            r7 = 407(0x197, float:5.7E-43)
            if (r2 == r7) goto L_0x0070
            r7 = 408(0x198, float:5.72E-43)
            if (r2 == r7) goto L_0x003c
            switch(r2) {
                case 300: goto L_0x00e0;
                case 301: goto L_0x00e0;
                case 302: goto L_0x00e0;
                case 303: goto L_0x00e0;
                default: goto L_0x003b;
            }
        L_0x003b:
            return r0
        L_0x003c:
            okhttp3.OkHttpClient r1 = r5.client
            boolean r1 = r1.retryOnConnectionFailure()
            if (r1 != 0) goto L_0x0045
            return r0
        L_0x0045:
            okhttp3.Request r1 = r6.request()
            okhttp3.RequestBody r1 = r1.body()
            if (r1 == 0) goto L_0x0056
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x0056
            return r0
        L_0x0056:
            okhttp3.Response r1 = r6.priorResponse()
            if (r1 == 0) goto L_0x0063
            int r1 = r1.code()
            if (r1 != r7) goto L_0x0063
            return r0
        L_0x0063:
            r7 = 0
            int r7 = r5.retryAfter(r6, r7)
            if (r7 <= 0) goto L_0x006b
            return r0
        L_0x006b:
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x0070:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.net.Proxy r7 = r1.proxy()
            java.net.Proxy$Type r7 = r7.type()
            java.net.Proxy$Type r0 = java.net.Proxy.Type.HTTP
            if (r7 != r0) goto L_0x008a
            okhttp3.OkHttpClient r7 = r5.client
            okhttp3.Authenticator r7 = r7.proxyAuthenticator()
            okhttp3.Request r6 = r7.authenticate(r1, r6)
            return r6
        L_0x008a:
            java.net.ProtocolException r6 = new java.net.ProtocolException
            java.lang.String r7 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r6.<init>(r7)
            throw r6
        L_0x0092:
            okhttp3.Response r1 = r6.priorResponse()
            if (r1 == 0) goto L_0x009f
            int r1 = r1.code()
            if (r1 != r7) goto L_0x009f
            return r0
        L_0x009f:
            r7 = 2147483647(0x7fffffff, float:NaN)
            int r7 = r5.retryAfter(r6, r7)
            if (r7 != 0) goto L_0x00ad
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x00ad:
            return r0
        L_0x00ae:
            okhttp3.Request r1 = r6.request()
            okhttp3.RequestBody r1 = r1.body()
            if (r1 == 0) goto L_0x00bf
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x00bf
            return r0
        L_0x00bf:
            if (r7 == 0) goto L_0x00d4
            boolean r1 = r7.isCoalescedConnection$okhttp()
            if (r1 != 0) goto L_0x00c8
            goto L_0x00d4
        L_0x00c8:
            okhttp3.internal.connection.RealConnection r7 = r7.getConnection$okhttp()
            r7.noCoalescedConnections$okhttp()
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x00d4:
            return r0
        L_0x00d5:
            okhttp3.OkHttpClient r7 = r5.client
            okhttp3.Authenticator r7 = r7.authenticator()
            okhttp3.Request r6 = r7.authenticate(r1, r6)
            return r6
        L_0x00e0:
            okhttp3.Request r6 = r5.buildRedirectRequest(r6, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.followUpRequest(okhttp3.Response, okhttp3.internal.connection.Exchange):okhttp3.Request");
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", (String) null, 2, (Object) null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual((Object) resolve.scheme(), (Object) response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            boolean z = HttpMethod.INSTANCE.redirectsWithBody(str) || code == 308 || code == 307;
            if (!HttpMethod.INSTANCE.redirectsToGet(str) || code == 308 || code == 307) {
                if (z) {
                    requestBody = response.request().body();
                }
                newBuilder.method(str, requestBody);
            } else {
                newBuilder.method(ShareTarget.METHOD_GET, (RequestBody) null);
            }
            if (!z) {
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final int retryAfter(Response response, int i) {
        String header$default = Response.header$default(response, HttpHeaders.RETRY_AFTER, (String) null, 2, (Object) null);
        if (header$default == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(header$default)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RetryAndFollowUpInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
