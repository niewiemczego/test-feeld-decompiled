package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.DateUtils;
import io.sentry.SentryDate;
import io.sentry.SentryLongDate;

public class TimeSpan implements Comparable<TimeSpan> {
    private String description;
    private long startUnixTimeMs;
    private long startUptimeMs;
    private long stopUptimeMs;

    public void start() {
        this.startUptimeMs = SystemClock.uptimeMillis();
        this.startUnixTimeMs = System.currentTimeMillis();
    }

    public void setStartedAt(long j) {
        this.startUptimeMs = j;
        this.startUnixTimeMs = System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.startUptimeMs);
    }

    public void stop() {
        this.stopUptimeMs = SystemClock.uptimeMillis();
    }

    public void setStoppedAt(long j) {
        this.stopUptimeMs = j;
    }

    public boolean hasStarted() {
        return this.startUptimeMs != 0;
    }

    public boolean hasNotStarted() {
        return this.startUptimeMs == 0;
    }

    public boolean hasStopped() {
        return this.stopUptimeMs != 0;
    }

    public boolean hasNotStopped() {
        return this.stopUptimeMs == 0;
    }

    public long getStartUptimeMs() {
        return this.startUptimeMs;
    }

    public long getStartTimestampMs() {
        return this.startUnixTimeMs;
    }

    public SentryDate getStartTimestamp() {
        if (hasStarted()) {
            return new SentryLongDate(DateUtils.millisToNanos(getStartTimestampMs()));
        }
        return null;
    }

    public double getStartTimestampSecs() {
        return DateUtils.millisToSeconds((double) this.startUnixTimeMs);
    }

    public long getProjectedStopTimestampMs() {
        if (hasStarted()) {
            return this.startUnixTimeMs + getDurationMs();
        }
        return 0;
    }

    public double getProjectedStopTimestampSecs() {
        return DateUtils.millisToSeconds((double) getProjectedStopTimestampMs());
    }

    public SentryDate getProjectedStopTimestamp() {
        if (hasStopped()) {
            return new SentryLongDate(DateUtils.millisToNanos(getProjectedStopTimestampMs()));
        }
        return null;
    }

    public long getDurationMs() {
        if (hasStopped()) {
            return this.stopUptimeMs - this.startUptimeMs;
        }
        return 0;
    }

    public void setStartUnixTimeMs(long j) {
        this.startUnixTimeMs = j;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void reset() {
        this.description = null;
        this.startUptimeMs = 0;
        this.stopUptimeMs = 0;
        this.startUnixTimeMs = 0;
    }

    public int compareTo(TimeSpan timeSpan) {
        return Long.compare(this.startUnixTimeMs, timeSpan.startUnixTimeMs);
    }
}
