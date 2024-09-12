package com.launchdarkly.sdk.internal.http;

import java.net.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

public final class HttpProperties {
    private static final int DEFAULT_TIMEOUT = 10000;
    private final long connectTimeoutMillis;
    private final Map<String, String> defaultHeaders;
    private final HeadersTransformer headersTransformer;
    private final Proxy proxy;
    private final Authenticator proxyAuth;
    private final OkHttpClient sharedHttpClient;
    private final SocketFactory socketFactory;
    private final long socketTimeoutMillis;
    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager trustManager;

    public HttpProperties(long j, Map<String, String> map, HeadersTransformer headersTransformer2, Proxy proxy2, Authenticator authenticator, SocketFactory socketFactory2, long j2, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        Map<String, String> map2 = map;
        long j3 = 10000;
        this.connectTimeoutMillis = j <= 0 ? 10000 : j;
        this.defaultHeaders = map2 == null ? Collections.emptyMap() : new HashMap<>(map);
        this.headersTransformer = headersTransformer2;
        this.proxy = proxy2;
        this.proxyAuth = authenticator;
        this.sharedHttpClient = null;
        this.socketFactory = socketFactory2;
        this.socketTimeoutMillis = j2 > 0 ? j2 : j3;
        this.sslSocketFactory = sSLSocketFactory;
        this.trustManager = x509TrustManager;
    }

    public HttpProperties(OkHttpClient okHttpClient, Map<String, String> map, HeadersTransformer headersTransformer2) {
        this.defaultHeaders = map == null ? Collections.emptyMap() : new HashMap<>(map);
        this.headersTransformer = headersTransformer2;
        this.sharedHttpClient = okHttpClient;
        this.connectTimeoutMillis = 10000;
        this.proxy = null;
        this.proxyAuth = null;
        this.socketFactory = null;
        this.socketTimeoutMillis = 10000;
        this.sslSocketFactory = null;
        this.trustManager = null;
    }

    public static HttpProperties defaults() {
        return new HttpProperties(0, (Map<String, String>) null, (HeadersTransformer) null, (Proxy) null, (Authenticator) null, (SocketFactory) null, 0, (SSLSocketFactory) null, (X509TrustManager) null);
    }

    public Iterable<Map.Entry<String, String>> getDefaultHeaders() {
        return this.defaultHeaders.entrySet();
    }

    public Iterable<Map.Entry<String, String>> getTransformedDefaultHeaders() {
        if (this.headersTransformer == null) {
            return this.defaultHeaders.entrySet();
        }
        HashMap hashMap = new HashMap(this.defaultHeaders);
        this.headersTransformer.updateHeaders(hashMap);
        return hashMap.entrySet();
    }

    public HeadersTransformer getHeadersTransformer() {
        return this.headersTransformer;
    }

    public OkHttpClient getSharedHttpClient() {
        return this.sharedHttpClient;
    }

    public void applyToHttpClientBuilder(OkHttpClient.Builder builder) {
        builder.connectionPool(new ConnectionPool(5, 5, TimeUnit.SECONDS));
        long j = this.connectTimeoutMillis;
        if (j > 0) {
            builder.connectTimeout(j, TimeUnit.MILLISECONDS);
        }
        long j2 = this.socketTimeoutMillis;
        if (j2 > 0) {
            builder.readTimeout(j2, TimeUnit.MILLISECONDS).writeTimeout(this.socketTimeoutMillis, TimeUnit.MILLISECONDS);
        }
        builder.retryOnConnectionFailure(false);
        SocketFactory socketFactory2 = this.socketFactory;
        if (socketFactory2 != null) {
            builder.socketFactory(socketFactory2);
        }
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        if (sSLSocketFactory != null) {
            builder.sslSocketFactory(sSLSocketFactory, this.trustManager);
        }
        Proxy proxy2 = this.proxy;
        if (proxy2 != null) {
            builder.proxy(proxy2);
            Authenticator authenticator = this.proxyAuth;
            if (authenticator != null) {
                builder.proxyAuthenticator(authenticator);
            }
        }
    }

    public OkHttpClient.Builder toHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        applyToHttpClientBuilder(builder);
        return builder;
    }

    public Headers.Builder toHeadersBuilder() {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry next : getTransformedDefaultHeaders()) {
            builder.add((String) next.getKey(), (String) next.getValue());
        }
        return builder;
    }

    public static void shutdownHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient.dispatcher() != null) {
            okHttpClient.dispatcher().cancelAll();
            if (okHttpClient.dispatcher().executorService() != null) {
                okHttpClient.dispatcher().executorService().shutdown();
            }
        }
        if (okHttpClient.connectionPool() != null) {
            okHttpClient.connectionPool().evictAll();
        }
        if (okHttpClient.cache() != null) {
            try {
                okHttpClient.cache().close();
            } catch (Exception unused) {
            }
        }
    }
}
