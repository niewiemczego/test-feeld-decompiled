package io.sentry.android.core;

import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.SentryNanotimeDateProvider;

public final class SentryAndroidDateProvider implements SentryDateProvider {
    private SentryDateProvider dateProvider = new SentryNanotimeDateProvider();

    public SentryDate now() {
        return this.dateProvider.now();
    }
}
