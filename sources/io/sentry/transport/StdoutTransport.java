package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.util.Objects;
import java.io.IOException;
import java.io.OutputStream;

public final class StdoutTransport implements ITransport {
    private final ISerializer serializer;

    public void close() {
    }

    public void close(boolean z) {
    }

    public RateLimiter getRateLimiter() {
        return null;
    }

    public StdoutTransport(ISerializer iSerializer) {
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required");
    }

    public void send(SentryEnvelope sentryEnvelope, Hint hint) throws IOException {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required");
        try {
            this.serializer.serialize(sentryEnvelope, (OutputStream) System.out);
        } catch (Throwable unused) {
        }
    }

    public void flush(long j) {
        System.out.println("Flushing");
    }
}
