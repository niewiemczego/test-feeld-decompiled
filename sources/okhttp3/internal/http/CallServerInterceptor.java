package okhttp3.internal.http;

import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CallServerInterceptor.kt */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Response.Builder builder;
        Response response;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        Intrinsics.checkNotNull(exchange$okhttp);
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        Long l = null;
        if (!HttpMethod.permitsRequestBody(request$okhttp.method()) || body == null) {
            exchange$okhttp.noRequestBody();
            builder = null;
            z = true;
        } else {
            if (StringsKt.equals("100-continue", request$okhttp.header(HttpHeaders.EXPECT), true)) {
                exchange$okhttp.flushRequest();
                builder = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z = false;
            } else {
                builder = null;
                z = true;
            }
            if (builder != null) {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            } else if (body.isDuplex()) {
                exchange$okhttp.flushRequest();
                body.writeTo(Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, true)));
            } else {
                BufferedSink buffer = Okio.buffer(exchange$okhttp.createRequestBody(request$okhttp, false));
                body.writeTo(buffer);
                buffer.close();
            }
        }
        if (body == null || !body.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (builder == null) {
            builder = exchange$okhttp.readResponseHeaders(false);
            Intrinsics.checkNotNull(builder);
            if (z) {
                exchange$okhttp.responseHeadersStart();
                z = false;
            }
        }
        Response build = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            if (z) {
                exchange$okhttp.responseHeadersStart();
            }
            build = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange$okhttp.responseHeadersEnd(build);
        if (!this.forWebSocket || code != 101) {
            response = build.newBuilder().body(exchange$okhttp.openResponseBody(build)).build();
        } else {
            response = build.newBuilder().body(Util.EMPTY_RESPONSE).build();
        }
        if (StringsKt.equals(AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE, response.request().header("Connection"), true) || StringsKt.equals(AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE, Response.header$default(response, "Connection", (String) null, 2, (Object) null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (code == 204 || code == 205) {
            ResponseBody body2 = response.body();
            if ((body2 == null ? -1 : body2.contentLength()) > 0) {
                StringBuilder append = new StringBuilder().append("HTTP ").append(code).append(" had non-zero Content-Length: ");
                ResponseBody body3 = response.body();
                if (body3 != null) {
                    l = Long.valueOf(body3.contentLength());
                }
                throw new ProtocolException(append.append(l).toString());
            }
        }
        return response;
    }
}
