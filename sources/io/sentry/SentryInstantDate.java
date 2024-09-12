package io.sentry;

import java.time.Instant;

public final class SentryInstantDate extends SentryDate {
    private final Instant date;

    public SentryInstantDate() {
        this(Instant.now());
    }

    public SentryInstantDate(Instant instant) {
        this.date = instant;
    }

    public long nanoTimestamp() {
        return DateUtils.secondsToNanos(this.date.getEpochSecond()) + ((long) this.date.getNano());
    }
}
