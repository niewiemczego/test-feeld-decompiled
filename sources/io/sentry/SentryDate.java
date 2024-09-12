package io.sentry;

public abstract class SentryDate implements Comparable<SentryDate> {
    public abstract long nanoTimestamp();

    public long laterDateNanosTimestampByDiff(SentryDate sentryDate) {
        if (sentryDate == null || compareTo(sentryDate) >= 0) {
            return nanoTimestamp();
        }
        return sentryDate.nanoTimestamp();
    }

    public long diff(SentryDate sentryDate) {
        return nanoTimestamp() - sentryDate.nanoTimestamp();
    }

    public final boolean isBefore(SentryDate sentryDate) {
        return diff(sentryDate) < 0;
    }

    public final boolean isAfter(SentryDate sentryDate) {
        return diff(sentryDate) > 0;
    }

    public int compareTo(SentryDate sentryDate) {
        return Long.valueOf(nanoTimestamp()).compareTo(Long.valueOf(sentryDate.nanoTimestamp()));
    }
}
