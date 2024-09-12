package coil.network;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006$"}, d2 = {"Lcoil/network/CacheResponse;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "cacheControl", "Lokhttp3/CacheControl;", "getCacheControl", "()Lokhttp3/CacheControl;", "cacheControl$delegate", "Lkotlin/Lazy;", "contentType", "Lokhttp3/MediaType;", "getContentType", "()Lokhttp3/MediaType;", "contentType$delegate", "isTls", "", "()Z", "receivedResponseAtMillis", "", "getReceivedResponseAtMillis", "()J", "responseHeaders", "Lokhttp3/Headers;", "getResponseHeaders", "()Lokhttp3/Headers;", "sentRequestAtMillis", "getSentRequestAtMillis", "writeTo", "", "sink", "Lokio/BufferedSink;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CacheResponse.kt */
public final class CacheResponse {
    private final Lazy cacheControl$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CacheResponse$cacheControl$2(this));
    private final Lazy contentType$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CacheResponse$contentType$2(this));
    private final boolean isTls;
    private final long receivedResponseAtMillis;
    private final Headers responseHeaders;
    private final long sentRequestAtMillis;

    public final CacheControl getCacheControl() {
        return (CacheControl) this.cacheControl$delegate.getValue();
    }

    public final MediaType getContentType() {
        return (MediaType) this.contentType$delegate.getValue();
    }

    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public CacheResponse(BufferedSource bufferedSource) {
        this.sentRequestAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.receivedResponseAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.isTls = Integer.parseInt(bufferedSource.readUtf8LineStrict()) > 0;
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        Headers.Builder builder = new Headers.Builder();
        for (int i = 0; i < parseInt; i++) {
            builder.add(bufferedSource.readUtf8LineStrict());
        }
        this.responseHeaders = builder.build();
    }

    public CacheResponse(Response response) {
        this.sentRequestAtMillis = response.sentRequestAtMillis();
        this.receivedResponseAtMillis = response.receivedResponseAtMillis();
        this.isTls = response.handshake() != null;
        this.responseHeaders = response.headers();
    }

    public final void writeTo(BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong(this.sentRequestAtMillis).writeByte(10);
        bufferedSink.writeDecimalLong(this.receivedResponseAtMillis).writeByte(10);
        bufferedSink.writeDecimalLong(this.isTls ? 1 : 0).writeByte(10);
        bufferedSink.writeDecimalLong((long) this.responseHeaders.size()).writeByte(10);
        int size = this.responseHeaders.size();
        for (int i = 0; i < size; i++) {
            bufferedSink.writeUtf8(this.responseHeaders.name(i)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i)).writeByte(10);
        }
    }
}
