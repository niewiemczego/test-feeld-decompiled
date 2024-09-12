package io.sentry;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import io.sentry.SentryOptions;
import io.sentry.util.Platform;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPOutputStream;

public final class SpotlightIntegration implements Integration, SentryOptions.BeforeEnvelopeCallback, Closeable {
    private ISentryExecutorService executorService = NoOpSentryExecutorService.getInstance();
    private ILogger logger = NoOpLogger.getInstance();
    private SentryOptions options;

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.options = sentryOptions;
        this.logger = sentryOptions.getLogger();
        if (sentryOptions.getBeforeEnvelopeCallback() != null || !sentryOptions.isEnableSpotlight()) {
            this.logger.log(SentryLevel.DEBUG, "SpotlightIntegration is not enabled. BeforeEnvelopeCallback is already set or spotlight is not enabled.", new Object[0]);
            return;
        }
        this.executorService = new SentryExecutorService();
        sentryOptions.setBeforeEnvelopeCallback(this);
        this.logger.log(SentryLevel.DEBUG, "SpotlightIntegration enabled.", new Object[0]);
    }

    public void execute(SentryEnvelope sentryEnvelope, Hint hint) {
        try {
            this.executorService.submit((Runnable) new SpotlightIntegration$$ExternalSyntheticLambda0(this, sentryEnvelope));
        } catch (RejectedExecutionException e) {
            this.logger.log(SentryLevel.WARNING, "Spotlight envelope submission rejected.", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendEnvelope */
    public void m880lambda$execute$0$iosentrySpotlightIntegration(SentryEnvelope sentryEnvelope) {
        GZIPOutputStream gZIPOutputStream;
        try {
            if (this.options != null) {
                HttpURLConnection createConnection = createConnection(getSpotlightConnectionUrl());
                try {
                    OutputStream outputStream = createConnection.getOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                        this.options.getSerializer().serialize(sentryEnvelope, (OutputStream) gZIPOutputStream);
                        gZIPOutputStream.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        int responseCode = createConnection.getResponseCode();
                        this.logger.log(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(responseCode));
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        this.logger.log(SentryLevel.ERROR, "An exception occurred while submitting the envelope to the Sentry server.", th2);
                        int responseCode2 = createConnection.getResponseCode();
                        this.logger.log(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(responseCode2));
                    } catch (Throwable th3) {
                        int responseCode3 = createConnection.getResponseCode();
                        this.logger.log(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(responseCode3));
                        closeAndDisconnect(createConnection);
                        throw th3;
                    }
                }
                closeAndDisconnect(createConnection);
                return;
            }
            throw new IllegalArgumentException("SentryOptions are required to send envelopes.");
            throw th;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "An exception occurred while creating the connection to spotlight.", (Throwable) e);
        }
    }

    public String getSpotlightConnectionUrl() {
        SentryOptions sentryOptions = this.options;
        if (sentryOptions == null || sentryOptions.getSpotlightConnectionUrl() == null) {
            return Platform.isAndroid() ? "http://10.0.2.2:8969/stream" : "http://localhost:8969/stream";
        }
        return this.options.getSpotlightConnectionUrl();
    }

    private HttpURLConnection createConnection(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setReadTimeout(1000);
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Connection", AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE);
        httpURLConnection.connect();
        return httpURLConnection;
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

    public void close() throws IOException {
        this.executorService.close(0);
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null && sentryOptions.getBeforeEnvelopeCallback() == this) {
            this.options.setBeforeEnvelopeCallback((SentryOptions.BeforeEnvelopeCallback) null);
        }
    }
}
