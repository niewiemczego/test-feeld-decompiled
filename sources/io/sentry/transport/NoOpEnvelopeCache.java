package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import io.sentry.cache.IEnvelopeCache;
import java.util.Collections;
import java.util.Iterator;

public final class NoOpEnvelopeCache implements IEnvelopeCache {
    private static final NoOpEnvelopeCache instance = new NoOpEnvelopeCache();

    public void discard(SentryEnvelope sentryEnvelope) {
    }

    public void store(SentryEnvelope sentryEnvelope, Hint hint) {
    }

    public static NoOpEnvelopeCache getInstance() {
        return instance;
    }

    public Iterator<SentryEnvelope> iterator() {
        return Collections.emptyIterator();
    }
}
