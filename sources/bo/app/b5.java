package bo.app;

import android.net.Uri;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

public final class b5 {
    private final String a;
    private final Uri b;
    private final URL c;

    public b5(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.b = uri;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        this.a = uri2;
        this.c = new URL(uri2);
    }

    public final Uri a() {
        return this.b;
    }

    public final URL b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    public b5(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(urlString)");
        this.b = parse;
        this.a = str;
        this.c = new URL(str);
    }
}
