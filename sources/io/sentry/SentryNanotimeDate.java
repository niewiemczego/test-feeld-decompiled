package io.sentry;

import java.util.Date;

public final class SentryNanotimeDate extends SentryDate {
    private final Date date;
    private final long nanos;

    public SentryNanotimeDate() {
        this(DateUtils.getCurrentDateTime(), System.nanoTime());
    }

    public SentryNanotimeDate(Date date2, long j) {
        this.date = date2;
        this.nanos = j;
    }

    public long diff(SentryDate sentryDate) {
        if (sentryDate instanceof SentryNanotimeDate) {
            return this.nanos - ((SentryNanotimeDate) sentryDate).nanos;
        }
        return super.diff(sentryDate);
    }

    public long nanoTimestamp() {
        return DateUtils.dateToNanos(this.date);
    }

    public long laterDateNanosTimestampByDiff(SentryDate sentryDate) {
        if (sentryDate == null || !(sentryDate instanceof SentryNanotimeDate)) {
            return super.laterDateNanosTimestampByDiff(sentryDate);
        }
        SentryNanotimeDate sentryNanotimeDate = (SentryNanotimeDate) sentryDate;
        if (compareTo(sentryDate) < 0) {
            return nanotimeDiff(this, sentryNanotimeDate);
        }
        return nanotimeDiff(sentryNanotimeDate, this);
    }

    public int compareTo(SentryDate sentryDate) {
        if (!(sentryDate instanceof SentryNanotimeDate)) {
            return super.compareTo(sentryDate);
        }
        SentryNanotimeDate sentryNanotimeDate = (SentryNanotimeDate) sentryDate;
        long time = this.date.getTime();
        long time2 = sentryNanotimeDate.date.getTime();
        if (time == time2) {
            return Long.valueOf(this.nanos).compareTo(Long.valueOf(sentryNanotimeDate.nanos));
        }
        return Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    private long nanotimeDiff(SentryNanotimeDate sentryNanotimeDate, SentryNanotimeDate sentryNanotimeDate2) {
        return sentryNanotimeDate.nanoTimestamp() + (sentryNanotimeDate2.nanos - sentryNanotimeDate.nanos);
    }
}
