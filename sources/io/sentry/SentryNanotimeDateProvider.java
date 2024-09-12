package io.sentry;

public final class SentryNanotimeDateProvider implements SentryDateProvider {
    public SentryDate now() {
        return new SentryNanotimeDate();
    }
}
