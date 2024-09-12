package coil.network;

import androidx.webkit.ProxyConfig;
import coil.util.Time;
import coil.util.Utils;
import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcoil/network/CacheStrategy;", "", "networkRequest", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "getCacheResponse", "()Lcoil/network/CacheResponse;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CacheStrategy.kt */
public final class CacheStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CacheResponse cacheResponse;
    private final Request networkRequest;

    public /* synthetic */ CacheStrategy(Request request, CacheResponse cacheResponse2, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, cacheResponse2);
    }

    private CacheStrategy(Request request, CacheResponse cacheResponse2) {
        this.networkRequest = request;
        this.cacheResponse = cacheResponse2;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/network/CacheStrategy$Factory;", "", "request", "Lokhttp3/Request;", "cacheResponse", "Lcoil/network/CacheResponse;", "(Lokhttp3/Request;Lcoil/network/CacheResponse;)V", "ageSeconds", "", "etag", "", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "receivedResponseMillis", "", "sentRequestMillis", "servedDate", "servedDateString", "cacheResponseAge", "compute", "Lcoil/network/CacheStrategy;", "computeFreshnessLifetime", "hasConditions", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CacheStrategy.kt */
    public static final class Factory {
        private int ageSeconds = -1;
        private final CacheResponse cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(Request request2, CacheResponse cacheResponse2) {
            this.request = request2;
            this.cacheResponse = cacheResponse2;
            if (cacheResponse2 != null) {
                this.sentRequestMillis = cacheResponse2.getSentRequestAtMillis();
                this.receivedResponseMillis = cacheResponse2.getReceivedResponseAtMillis();
                Headers responseHeaders = cacheResponse2.getResponseHeaders();
                int size = responseHeaders.size();
                for (int i = 0; i < size; i++) {
                    String name = responseHeaders.name(i);
                    if (StringsKt.equals(name, "Date", true)) {
                        this.servedDate = responseHeaders.getDate("Date");
                        this.servedDateString = responseHeaders.value(i);
                    } else if (StringsKt.equals(name, "Expires", true)) {
                        this.expires = responseHeaders.getDate("Expires");
                    } else if (StringsKt.equals(name, HttpHeaders.LAST_MODIFIED, true)) {
                        this.lastModified = responseHeaders.getDate(HttpHeaders.LAST_MODIFIED);
                        this.lastModifiedString = responseHeaders.value(i);
                    } else if (StringsKt.equals(name, HttpHeaders.ETAG, true)) {
                        this.etag = responseHeaders.value(i);
                    } else if (StringsKt.equals(name, HttpHeaders.AGE, true)) {
                        this.ageSeconds = Utils.toNonNegativeInt(responseHeaders.value(i), -1);
                    }
                }
            }
        }

        public final CacheStrategy compute() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            if (this.request.isHttps() && !this.cacheResponse.isTls()) {
                return new CacheStrategy(this.request, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            CacheControl cacheControl = this.cacheResponse.getCacheControl();
            if (!CacheStrategy.Companion.isCacheable(this.request, this.cacheResponse)) {
                return new CacheStrategy(this.request, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            CacheControl cacheControl2 = this.request.cacheControl();
            if (cacheControl2.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, (CacheResponse) null, (DefaultConstructorMarker) null);
            }
            long cacheResponseAge = cacheResponseAge();
            long computeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl2.maxAgeSeconds() != -1) {
                computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis((long) cacheControl2.maxAgeSeconds()));
            }
            long j = 0;
            long millis = cacheControl2.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis((long) cacheControl2.minFreshSeconds()) : 0;
            if (!cacheControl.mustRevalidate() && cacheControl2.maxStaleSeconds() != -1) {
                j = TimeUnit.SECONDS.toMillis((long) cacheControl2.maxStaleSeconds());
            }
            if (!cacheControl.noCache() && cacheResponseAge + millis < computeFreshnessLifetime + j) {
                return new CacheStrategy((Request) null, this.cacheResponse, (DefaultConstructorMarker) null);
            }
            String str = this.etag;
            String str2 = HttpHeaders.IF_MODIFIED_SINCE;
            if (str != null) {
                Intrinsics.checkNotNull(str);
                str2 = HttpHeaders.IF_NONE_MATCH;
            } else if (this.lastModified != null) {
                str = this.lastModifiedString;
                Intrinsics.checkNotNull(str);
            } else if (this.servedDate == null) {
                return new CacheStrategy(this.request, (CacheResponse) null, (DefaultConstructorMarker) null);
            } else {
                str = this.servedDateString;
                Intrinsics.checkNotNull(str);
            }
            return new CacheStrategy(this.request.newBuilder().addHeader(str2, str).build(), this.cacheResponse, (DefaultConstructorMarker) null);
        }

        private final long computeFreshnessLifetime() {
            CacheResponse cacheResponse2 = this.cacheResponse;
            Intrinsics.checkNotNull(cacheResponse2);
            CacheControl cacheControl = cacheResponse2.getCacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long) cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.lastModified == null || this.request.url().query() != null) {
                return 0;
            } else {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                Intrinsics.checkNotNull(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / ((long) 10);
                }
                return 0;
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long j = 0;
            if (date != null) {
                j = Math.max(0, this.receivedResponseMillis - date.getTime());
            }
            if (this.ageSeconds != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.ageSeconds));
            }
            return j + (this.receivedResponseMillis - this.sentRequestMillis) + (Time.INSTANCE.currentMillis() - this.receivedResponseMillis);
        }

        private final boolean hasConditions(Request request2) {
            return (request2.header(HttpHeaders.IF_MODIFIED_SINCE) == null && request2.header(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcoil/network/CacheStrategy$Companion;", "", "()V", "combineHeaders", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isCacheable", "", "request", "Lokhttp3/Request;", "response", "Lcoil/network/CacheResponse;", "Lokhttp3/Response;", "isContentSpecificHeader", "name", "", "isEndToEnd", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CacheStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(Request request, Response response) {
            return !request.cacheControl().noStore() && !response.cacheControl().noStore() && !Intrinsics.areEqual((Object) response.headers().get(HttpHeaders.VARY), (Object) ProxyConfig.MATCH_ALL_SCHEMES);
        }

        public final boolean isCacheable(Request request, CacheResponse cacheResponse) {
            return !request.cacheControl().noStore() && !cacheResponse.getCacheControl().noStore() && !Intrinsics.areEqual((Object) cacheResponse.getResponseHeaders().get(HttpHeaders.VARY), (Object) ProxyConfig.MATCH_ALL_SCHEMES);
        }

        public final Headers combineHeaders(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if ((!StringsKt.equals(HttpHeaders.WARNING, name, true) || !StringsKt.startsWith$default(value, "1", false, 2, (Object) null)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.add(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.add(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isEndToEnd(String str) {
            if (StringsKt.equals("Connection", str, true) || StringsKt.equals(HttpHeaders.KEEP_ALIVE, str, true) || StringsKt.equals("Proxy-Authenticate", str, true) || StringsKt.equals(HttpHeaders.PROXY_AUTHORIZATION, str, true) || StringsKt.equals(HttpHeaders.TE, str, true) || StringsKt.equals("Trailers", str, true) || StringsKt.equals(HttpHeaders.TRANSFER_ENCODING, str, true) || StringsKt.equals(HttpHeaders.UPGRADE, str, true)) {
                return false;
            }
            return true;
        }

        private final boolean isContentSpecificHeader(String str) {
            if (StringsKt.equals("Content-Length", str, true) || StringsKt.equals("Content-Encoding", str, true) || StringsKt.equals("Content-Type", str, true)) {
                return true;
            }
            return false;
        }
    }
}
