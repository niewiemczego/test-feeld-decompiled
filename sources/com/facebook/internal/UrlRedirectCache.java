package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", "tag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", "uri", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: UrlRedirectCache.kt */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    private UrlRedirectCache() {
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = Intrinsics.stringPlus(simpleName, "_Redirect");
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    @JvmStatic
    public static final Uri getRedirectedUri(Uri uri) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(uri2);
        try {
            FileLruCache cache = getCache();
            InputStream inputStream = cache.get(uri2, redirectContentTag);
            inputStreamReader = null;
            boolean z = false;
            while (true) {
                if (inputStream == null) {
                    break;
                }
                z = true;
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                } catch (IOException e) {
                    e = e;
                    try {
                        Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
                        Utility utility = Utility.INSTANCE;
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader3 = inputStreamReader;
                    }
                }
                try {
                    char[] cArr = new char[128];
                    StringBuilder sb = new StringBuilder();
                    for (int read = inputStreamReader2.read(cArr, 0, 128); read > 0; read = inputStreamReader2.read(cArr, 0, 128)) {
                        sb.append(cArr, 0, read);
                    }
                    Utility utility2 = Utility.INSTANCE;
                    Utility.closeQuietly(inputStreamReader2);
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "urlBuilder.toString()");
                    if (!hashSet.contains(sb2)) {
                        hashSet.add(sb2);
                        inputStreamReader = inputStreamReader2;
                        String str = sb2;
                        inputStream = cache.get(sb2, redirectContentTag);
                        uri2 = str;
                    } else if (Intrinsics.areEqual((Object) sb2, (Object) uri2)) {
                        inputStreamReader = inputStreamReader2;
                    } else {
                        Logger.Companion.log(LoggingBehavior.CACHE, 6, tag, "A loop detected in UrlRedirectCache");
                        Utility utility3 = Utility.INSTANCE;
                        Utility.closeQuietly(inputStreamReader2);
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStreamReader = inputStreamReader2;
                    Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
                    Utility utility4 = Utility.INSTANCE;
                    Utility.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader3 = inputStreamReader2;
                    Utility utility5 = Utility.INSTANCE;
                    Utility.closeQuietly(inputStreamReader3);
                    throw th;
                }
            }
            if (z) {
                Uri parse = Uri.parse(uri2);
                Utility utility6 = Utility.INSTANCE;
                Utility.closeQuietly(inputStreamReader);
                return parse;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
            Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
            Utility utility42 = Utility.INSTANCE;
            Utility.closeQuietly(inputStreamReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            Utility utility52 = Utility.INSTANCE;
            Utility.closeQuietly(inputStreamReader3);
            throw th;
        }
        Utility utility422 = Utility.INSTANCE;
        Utility.closeQuietly(inputStreamReader);
        return null;
    }

    @JvmStatic
    public static final void cacheUriRedirect(Uri uri, Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                FileLruCache cache = getCache();
                String uri3 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "fromUri.toString()");
                outputStream = cache.openPutStream(uri3, redirectContentTag);
                String uri4 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toUri.toString()");
                byte[] bytes = uri4.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
            } catch (IOException e) {
                Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
            } catch (Throwable th) {
                Utility utility = Utility.INSTANCE;
                Utility.closeQuietly(outputStream);
                throw th;
            }
            Utility utility2 = Utility.INSTANCE;
            Utility.closeQuietly(outputStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, tag, Intrinsics.stringPlus("clearCache failed ", e.getMessage()));
        }
    }
}
