package io.sentry;

import io.sentry.protocol.SentryTransaction;

public interface EventProcessor {
    SentryEvent process(SentryEvent sentryEvent, Hint hint) {
        return sentryEvent;
    }

    SentryTransaction process(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
