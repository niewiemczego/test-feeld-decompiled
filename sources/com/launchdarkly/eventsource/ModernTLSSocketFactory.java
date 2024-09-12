package com.launchdarkly.eventsource;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class ModernTLSSocketFactory extends SSLSocketFactory {
    private static final String TLS_1 = "TLSv1";
    private static final String TLS_1_1 = "TLSv1.1";
    private static final String TLS_1_2 = "TLSv1.2";
    private SSLSocketFactory defaultSocketFactory;

    ModernTLSSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.defaultSocketFactory = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.defaultSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.defaultSocketFactory.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return setModernTlsVersionsOnSocket(this.defaultSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    static Socket setModernTlsVersionsOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            List asList = Arrays.asList(sSLSocket.getSupportedProtocols());
            ArrayList arrayList = new ArrayList();
            if (asList.contains(TLS_1_2)) {
                arrayList.add(TLS_1_2);
            }
            if (asList.contains(TLS_1_1)) {
                arrayList.add(TLS_1_1);
            }
            if (asList.contains(TLS_1)) {
                arrayList.add(TLS_1);
            }
            if (arrayList.size() > 0) {
                sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }
        return socket;
    }
}
