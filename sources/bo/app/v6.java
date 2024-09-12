package bo.app;

import com.braze.support.BrazeLogger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class v6 {
    public static final v6 a = new v6();
    private static z5 b;

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception initializing static TLS socket factory.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception setting TLS socket factory on url connection.";
        }
    }

    static {
        try {
            b = new z5();
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) a.b);
        }
    }

    private v6() {
    }

    public final HttpURLConnection a(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        URLConnection openConnection = url.openConnection();
        if (Intrinsics.areEqual((Object) url.getProtocol(), (Object) "https")) {
            try {
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                z5 z5Var = b;
                if (z5Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socketFactory");
                    z5Var = null;
                }
                httpsURLConnection.setSSLSocketFactory(z5Var);
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
            }
        }
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        return (HttpURLConnection) openConnection;
    }
}
