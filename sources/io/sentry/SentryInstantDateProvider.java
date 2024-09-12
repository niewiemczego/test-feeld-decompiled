package io.sentry;

public final class SentryInstantDateProvider implements SentryDateProvider {
    public SentryDate now() {
        return new SentryInstantDate();
    }
}
