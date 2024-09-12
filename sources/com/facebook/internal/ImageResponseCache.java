package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/ImageResponseCache;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "imageCache", "Lcom/facebook/internal/FileLruCache;", "clearCache", "", "getCache", "getCachedImageStream", "Ljava/io/InputStream;", "uri", "Landroid/net/Uri;", "interceptAndCacheImageStream", "connection", "Ljava/net/HttpURLConnection;", "isCDNURL", "", "BufferedHttpInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageResponseCache.kt */
public final class ImageResponseCache {
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();
    private static final String TAG = "ImageResponseCache";
    private static FileLruCache imageCache;

    private ImageResponseCache() {
    }

    public final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            if (imageCache == null) {
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                imageCache = new FileLruCache(str, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
            if (fileLruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageCache");
                throw null;
            }
        }
        return fileLruCache;
    }

    @JvmStatic
    public static final InputStream getCachedImageStream(Uri uri) {
        if (uri == null || !INSTANCE.isCDNURL(uri)) {
            return null;
        }
        try {
            FileLruCache cache = getCache();
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            return FileLruCache.get$default(cache, uri2, (String) null, 2, (Object) null);
        } catch (IOException e) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            companion.log(loggingBehavior, 5, str, e.toString());
            return null;
        }
    }

    @JvmStatic
    public static final InputStream interceptAndCacheImageStream(HttpURLConnection httpURLConnection) throws IOException {
        Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            if (!INSTANCE.isCDNURL(parse)) {
                return inputStream;
            }
            FileLruCache cache = getCache();
            String uri = parse.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            return cache.interceptAndPut(uri, new BufferedHttpInputStream(inputStream, httpURLConnection));
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private final boolean isCDNURL(Uri uri) {
        String host;
        if (uri == null || (host = uri.getHost()) == null || (!Intrinsics.areEqual((Object) host, (Object) "fbcdn.net") && !StringsKt.endsWith$default(host, ".fbcdn.net", false, 2, (Object) null) && (!StringsKt.startsWith$default(host, "fbcdn", false, 2, (Object) null) || !StringsKt.endsWith$default(host, ".akamaihd.net", false, 2, (Object) null)))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            companion.log(loggingBehavior, 5, str, Intrinsics.stringPlus("clearCache failed ", e.getMessage()));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/facebook/internal/ImageResponseCache$BufferedHttpInputStream;", "Ljava/io/BufferedInputStream;", "stream", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "setConnection", "(Ljava/net/HttpURLConnection;)V", "close", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageResponseCache.kt */
    private static final class BufferedHttpInputStream extends BufferedInputStream {
        private HttpURLConnection connection;

        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            Intrinsics.checkNotNullParameter(httpURLConnection, "connection");
            this.connection = httpURLConnection;
        }

        public void close() throws IOException {
            super.close();
            Utility utility = Utility.INSTANCE;
            Utility.disconnectQuietly(this.connection);
        }
    }
}
