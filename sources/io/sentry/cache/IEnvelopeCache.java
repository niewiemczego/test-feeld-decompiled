package io.sentry.cache;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;

public interface IEnvelopeCache extends Iterable<SentryEnvelope> {
    void discard(SentryEnvelope sentryEnvelope);

    void store(SentryEnvelope sentryEnvelope, Hint hint);

    void store(SentryEnvelope sentryEnvelope) {
        store(sentryEnvelope, new Hint());
    }
}
