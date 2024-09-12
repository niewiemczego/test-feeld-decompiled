package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cache.ResponseCacheKeys;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.internal.utils.ID;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/adapty/internal/data/cloud/Request;", "", "baseUrl", "", "(Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "body", "currentDataWhenSent", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "headers", "", "Lcom/adapty/internal/data/cloud/Request$Header;", "<set-?>", "Lcom/adapty/internal/data/cloud/Request$Method;", "method", "getMethod", "()Lcom/adapty/internal/data/cloud/Request$Method;", "setMethod", "(Lcom/adapty/internal/data/cloud/Request$Method;)V", "responseCacheKeys", "Lcom/adapty/internal/data/cache/ResponseCacheKeys;", "systemLog", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "url", "getUrl", "setUrl", "Builder", "CurrentDataWhenSent", "Header", "Method", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Request.kt */
public final class Request {
    private final String baseUrl;
    public /* synthetic */ String body = "";
    public /* synthetic */ CurrentDataWhenSent currentDataWhenSent;
    public /* synthetic */ Set<Header> headers;
    public Method method;
    public /* synthetic */ ResponseCacheKeys responseCacheKeys;
    public /* synthetic */ AnalyticsEvent.BackendAPIRequestData systemLog;
    public String url;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/data/cloud/Request$Method;", "", "(Ljava/lang/String;I)V", "GET", "POST", "PATCH", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Request.kt */
    public enum Method {
        GET,
        POST,
        PATCH
    }

    public Request(String str) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        this.baseUrl = str;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ Method getMethod() {
        Method method2 = this.method;
        if (method2 != null) {
            return method2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("method");
        return null;
    }

    public final /* synthetic */ void setMethod(Method method2) {
        Intrinsics.checkNotNullParameter(method2, "<set-?>");
        this.method = method2;
    }

    public final /* synthetic */ String getUrl() {
        String str = this.url;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    public final /* synthetic */ void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0016J\u0006\u0010\u001f\u001a\u00020\u0003J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00160\u0015j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0016`\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/adapty/internal/data/cloud/Request$Builder;", "", "baseRequest", "Lcom/adapty/internal/data/cloud/Request;", "(Lcom/adapty/internal/data/cloud/Request;)V", "body", "", "currentDataWhenSent", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "endPoint", "headers", "", "Lcom/adapty/internal/data/cloud/Request$Header;", "<set-?>", "Lcom/adapty/internal/data/cloud/Request$Method;", "method", "getMethod", "()Lcom/adapty/internal/data/cloud/Request$Method;", "setMethod", "(Lcom/adapty/internal/data/cloud/Request$Method;)V", "queryParams", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "responseCacheKeys", "Lcom/adapty/internal/data/cache/ResponseCacheKeys;", "systemLog", "Lcom/adapty/internal/data/models/AnalyticsEvent$BackendAPIRequestData;", "addQueryParam", "", "param", "build", "queryDelimiter", "index", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Request.kt */
    public static final class Builder {
        private final Request baseRequest;
        public /* synthetic */ String body;
        public /* synthetic */ CurrentDataWhenSent currentDataWhenSent;
        public /* synthetic */ String endPoint;
        public /* synthetic */ Set<Header> headers;
        public Method method;
        private final ArrayList<Pair<String, String>> queryParams;
        public /* synthetic */ ResponseCacheKeys responseCacheKeys;
        public /* synthetic */ AnalyticsEvent.BackendAPIRequestData systemLog;

        public Builder() {
            this((Request) null, 1, (DefaultConstructorMarker) null);
        }

        private final String queryDelimiter(int i) {
            return i == 0 ? "?" : "&";
        }

        public Builder(Request request) {
            Intrinsics.checkNotNullParameter(request, "baseRequest");
            this.baseRequest = request;
            this.headers = new LinkedHashSet();
            this.queryParams = new ArrayList<>();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(Request request, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Request("https://api.adapty.io/api/v1/sdk/") : request);
        }

        public final /* synthetic */ Method getMethod() {
            Method method2 = this.method;
            if (method2 != null) {
                return method2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("method");
            return null;
        }

        public final /* synthetic */ void setMethod(Method method2) {
            Intrinsics.checkNotNullParameter(method2, "<set-?>");
            this.method = method2;
        }

        public final /* synthetic */ void addQueryParam(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "param");
            this.queryParams.add(pair);
        }

        public final /* synthetic */ Request build() {
            Request request = this.baseRequest;
            request.setMethod(getMethod());
            StringBuilder sb = new StringBuilder(request.getBaseUrl());
            String str = this.endPoint;
            if (str != null) {
                sb.append(str);
            }
            int i = 0;
            for (Object next : this.queryParams) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) next;
                sb.append(queryDelimiter(i));
                sb.append((String) pair.component1());
                sb.append("=");
                sb.append((String) pair.component2());
                i = i2;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(baseUrl).a…\n            }.toString()");
            request.setUrl(sb2);
            String str2 = this.body;
            if (str2 == null) {
                str2 = "";
            }
            request.body = str2;
            request.headers = this.headers;
            request.responseCacheKeys = this.responseCacheKeys;
            request.currentDataWhenSent = this.currentDataWhenSent;
            request.systemLog = this.systemLog;
            return request;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/cloud/Request$Header;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Request.kt */
    public static final class Header {
        private final String key;
        private final String value;

        public Header(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.key = str;
            this.value = str2;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB(\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "", "profileId", "Lcom/adapty/internal/utils/ID;", "", "customerUserId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCustomerUserId", "()Ljava/lang/String;", "getProfileId", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Request.kt */
    public static final class CurrentDataWhenSent {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String customerUserId;
        private final String profileId;

        public /* synthetic */ CurrentDataWhenSent(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private CurrentDataWhenSent(String str, String str2) {
            this.profileId = str;
            this.customerUserId = str2;
        }

        public final String getProfileId() {
            return this.profileId;
        }

        public final String getCustomerUserId() {
            return this.customerUserId;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/cloud/Request$CurrentDataWhenSent;", "profileId", "", "customerUserId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: Request.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CurrentDataWhenSent create(String str) {
                Intrinsics.checkNotNullParameter(str, "profileId");
                return new CurrentDataWhenSent(ID.m92constructorimpl(str), ID.Companion.m98getUNSPECIFIEDsonumTQ(), (DefaultConstructorMarker) null);
            }

            public final CurrentDataWhenSent create(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "profileId");
                return new CurrentDataWhenSent(ID.m92constructorimpl(str), ID.m92constructorimpl(str2), (DefaultConstructorMarker) null);
            }
        }
    }
}
