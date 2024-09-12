package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import java.io.Closeable;
import java.io.IOException;

public interface ITransport extends Closeable {
    void close(boolean z) throws IOException;

    void flush(long j);

    RateLimiter getRateLimiter();

    boolean isHealthy() {
        return true;
    }

    void send(SentryEnvelope sentryEnvelope, Hint hint) throws IOException;

    void send(SentryEnvelope sentryEnvelope) throws IOException {
        send(sentryEnvelope, new Hint());
    }
}
