package bo.app;

import com.braze.support.BrazeLogger;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class z5 extends SSLSocketFactory {
    public static final a b = new a((DefaultConstructorMarker) null);
    private SSLSocketFactory a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list) {
            super(0);
            this.b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Enabling SSL protocols: " + this.b;
        }
    }

    public z5() {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
        this.a = socketFactory;
    }

    private final Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ArrayList arrayList = new ArrayList();
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] supportedProtocols = sSLSocket.getSupportedProtocols();
            Intrinsics.checkNotNullExpressionValue(supportedProtocols, "socket.supportedProtocols");
            for (String str : supportedProtocols) {
                if (!Intrinsics.areEqual((Object) str, (Object) "SSLv3")) {
                    Intrinsics.checkNotNullExpressionValue(str, "protocol");
                    arrayList.add(str);
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(arrayList), 2, (Object) null);
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[0]));
        }
        return socket;
    }

    public Socket createSocket() {
        Socket createSocket = this.a.createSocket();
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket()");
        return a(createSocket);
    }

    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.a.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, "internalSSLSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.a.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "internalSSLSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(str, "host");
        Socket createSocket = this.a.createSocket(socket, str, i, z);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory…t, host, port, autoClose)");
        return a(createSocket);
    }

    public Socket createSocket(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "host");
        Socket createSocket = this.a.createSocket(str, i);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(inetAddress, "localHost");
        Socket createSocket = this.a.createSocket(str, i, inetAddress, i2);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory…rt, localHost, localPort)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        Intrinsics.checkNotNullParameter(inetAddress, "host");
        Socket createSocket = this.a.createSocket(inetAddress, i);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Intrinsics.checkNotNullParameter(inetAddress, "address");
        Intrinsics.checkNotNullParameter(inetAddress2, "localAddress");
        Socket createSocket = this.a.createSocket(inetAddress, i, inetAddress2, i2);
        Intrinsics.checkNotNullExpressionValue(createSocket, "internalSSLSocketFactory… localAddress, localPort)");
        return a(createSocket);
    }
}
