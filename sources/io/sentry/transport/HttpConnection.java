package io.sentry.transport;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.google.common.net.HttpHeaders;
import io.sentry.RequestDetails;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

final class HttpConnection {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final SentryOptions options;
    private final Proxy proxy;
    private final RateLimiter rateLimiter;
    private final RequestDetails requestDetails;

    private boolean isSuccessfulResponseCode(int i) {
        return i == 200;
    }

    public HttpConnection(SentryOptions sentryOptions, RequestDetails requestDetails2, RateLimiter rateLimiter2) {
        this(sentryOptions, requestDetails2, AuthenticatorWrapper.getInstance(), rateLimiter2);
    }

    HttpConnection(SentryOptions sentryOptions, RequestDetails requestDetails2, AuthenticatorWrapper authenticatorWrapper, RateLimiter rateLimiter2) {
        this.requestDetails = requestDetails2;
        this.options = sentryOptions;
        this.rateLimiter = rateLimiter2;
        Proxy resolveProxy = resolveProxy(sentryOptions.getProxy());
        this.proxy = resolveProxy;
        if (resolveProxy != null && sentryOptions.getProxy() != null) {
            String user = sentryOptions.getProxy().getUser();
            String pass = sentryOptions.getProxy().getPass();
            if (user != null && pass != null) {
                authenticatorWrapper.setDefault(new ProxyAuthenticator(user, pass));
            }
        }
    }

    private Proxy resolveProxy(SentryOptions.Proxy proxy2) {
        Proxy.Type type;
        if (proxy2 != null) {
            String port = proxy2.getPort();
            String host = proxy2.getHost();
            if (!(port == null || host == null)) {
                try {
                    if (proxy2.getType() != null) {
                        type = proxy2.getType();
                    } else {
                        type = Proxy.Type.HTTP;
                    }
                    return new Proxy(type, new InetSocketAddress(host, Integer.parseInt(port)));
                } catch (NumberFormatException e) {
                    this.options.getLogger().log(SentryLevel.ERROR, e, "Failed to parse Sentry Proxy port: " + proxy2.getPort() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection open() throws IOException {
        URLConnection uRLConnection;
        if (this.proxy == null) {
            uRLConnection = this.requestDetails.getUrl().openConnection();
        } else {
            uRLConnection = this.requestDetails.getUrl().openConnection(this.proxy);
        }
        return (HttpURLConnection) uRLConnection;
    }

    private HttpURLConnection createConnection() throws IOException {
        HttpURLConnection open = open();
        for (Map.Entry next : this.requestDetails.getHeaders().entrySet()) {
            open.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        open.setRequestMethod(ShareTarget.METHOD_POST);
        open.setDoOutput(true);
        open.setRequestProperty("Content-Encoding", "gzip");
        open.setRequestProperty("Content-Type", "application/x-sentry-envelope");
        open.setRequestProperty("Accept", "application/json");
        open.setRequestProperty("Connection", AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE);
        open.setConnectTimeout(this.options.getConnectionTimeoutMillis());
        open.setReadTimeout(this.options.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = this.options.getSslSocketFactory();
        if ((open instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) open).setSSLSocketFactory(sslSocketFactory);
        }
        open.connect();
        return open;
    }

    public TransportResult send(SentryEnvelope sentryEnvelope) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection createConnection = createConnection();
        try {
            OutputStream outputStream = createConnection.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.options.getSerializer().serialize(sentryEnvelope, (OutputStream) gZIPOutputStream);
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            try {
                this.options.getLogger().log(SentryLevel.ERROR, th2, "An exception occurred while submitting the envelope to the Sentry server.", new Object[0]);
            } catch (Throwable th3) {
                readAndLog(createConnection);
                throw th3;
            }
        }
        return readAndLog(createConnection);
        throw th;
    }

    /* JADX INFO: finally extract failed */
    private TransportResult readAndLog(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            updateRetryAfterLimits(httpURLConnection, responseCode);
            if (!isSuccessfulResponseCode(responseCode)) {
                this.options.getLogger().log(SentryLevel.ERROR, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (this.options.isDebug()) {
                    String errorMessageFromStream = getErrorMessageFromStream(httpURLConnection);
                    this.options.getLogger().log(SentryLevel.ERROR, "%s", errorMessageFromStream);
                }
                TransportResult error = TransportResult.error(responseCode);
                closeAndDisconnect(httpURLConnection);
                return error;
            }
            this.options.getLogger().log(SentryLevel.DEBUG, "Envelope sent successfully.", new Object[0]);
            TransportResult success = TransportResult.success();
            closeAndDisconnect(httpURLConnection);
            return success;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, e, "Error reading and logging the response stream", new Object[0]);
            closeAndDisconnect(httpURLConnection);
            return TransportResult.error();
        } catch (Throwable th) {
            closeAndDisconnect(httpURLConnection);
            throw th;
        }
    }

    public void updateRetryAfterLimits(HttpURLConnection httpURLConnection, int i) {
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.RETRY_AFTER);
        this.rateLimiter.updateRetryAfterLimits(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i);
    }

    private void closeAndDisconnect(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private String getErrorMessageFromStream(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!z) {
                        sb.append("\n");
                    }
                    sb.append(readLine);
                    z = false;
                }
                String sb2 = sb.toString();
                bufferedReader.close();
                if (errorStream != null) {
                    errorStream.close();
                }
                return sb2;
            } catch (Throwable th) {
                if (errorStream != null) {
                    errorStream.close();
                }
                throw th;
            }
            throw th;
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public Proxy getProxy() {
        return this.proxy;
    }
}
