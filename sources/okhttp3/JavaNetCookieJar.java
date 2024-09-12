package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokhttp3/JavaNetCookieJar;", "Lokhttp3/CookieJar;", "cookieHandler", "Ljava/net/CookieHandler;", "(Ljava/net/CookieHandler;)V", "decodeHeaderAsJavaNetCookies", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "header", "", "loadForRequest", "saveFromResponse", "", "cookies", "okhttp-urlconnection"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JavaNetCookieJar.kt */
public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler2) {
        Intrinsics.checkNotNullParameter(cookieHandler2, "cookieHandler");
        this.cookieHandler = cookieHandler2;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        Intrinsics.checkNotNullParameter(list, "cookies");
        List arrayList = new ArrayList();
        for (Cookie cookieToString : list) {
            arrayList.add(Internal.cookieToString(cookieToString, true));
        }
        try {
            this.cookieHandler.put(httpUrl.uri(), MapsKt.mapOf(TuplesKt.to(HttpHeaders.SET_COOKIE, arrayList)));
        } catch (IOException e) {
            Platform platform = Platform.Companion.get();
            HttpUrl resolve = httpUrl.resolve("/...");
            Intrinsics.checkNotNull(resolve);
            platform.log(Intrinsics.stringPlus("Saving cookies failed for ", resolve), 5, e);
        }
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        try {
            Map<String, List<String>> map = this.cookieHandler.get(httpUrl.uri(), MapsKt.emptyMap());
            List list = null;
            Intrinsics.checkNotNullExpressionValue(map, "cookieHeaders");
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                List<String> list2 = (List) next.getValue();
                if (StringsKt.equals("Cookie", str, true) || StringsKt.equals("Cookie2", str, true)) {
                    Intrinsics.checkNotNullExpressionValue(list2, "value");
                    if (!list2.isEmpty()) {
                        for (String str2 : list2) {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            Intrinsics.checkNotNullExpressionValue(str2, "header");
                            list.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                        }
                    }
                }
            }
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(list);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n      Collections.unmo…fiableList(cookies)\n    }");
            return unmodifiableList;
        } catch (IOException e) {
            Platform platform = Platform.Companion.get();
            HttpUrl resolve = httpUrl.resolve("/...");
            Intrinsics.checkNotNull(resolve);
            platform.log(Intrinsics.stringPlus("Loading cookies failed for ", resolve), 5, e);
            return CollectionsKt.emptyList();
        }
    }

    private final List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        List<Cookie> arrayList = new ArrayList<>();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, ";,", i, length);
            int delimiterOffset2 = Util.delimiterOffset(str, '=', i, delimiterOffset);
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            if (!StringsKt.startsWith$default(trimSubstring, "$", false, 2, (Object) null)) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (StringsKt.startsWith$default(trimSubstring2, "\"", false, 2, (Object) null) && StringsKt.endsWith$default(trimSubstring2, "\"", false, 2, (Object) null)) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(trimSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }
}
