package io.sentry.android.core;

final class SentryFrameMetrics {
    private int frozenFrameCount;
    private long frozenFrameDelayNanos;
    private int normalFrameCount;
    private int slowFrameCount;
    private long slowFrameDelayNanos;
    private long totalDurationNanos;

    public SentryFrameMetrics() {
    }

    public SentryFrameMetrics(int i, int i2, long j, int i3, long j2, long j3) {
        this.normalFrameCount = i;
        this.slowFrameCount = i2;
        this.slowFrameDelayNanos = j;
        this.frozenFrameCount = i3;
        this.frozenFrameDelayNanos = j2;
        this.totalDurationNanos = j3;
    }

    public void addFrame(long j, long j2, boolean z, boolean z2) {
        this.totalDurationNanos += j;
        if (z2) {
            this.frozenFrameDelayNanos += j2;
            this.frozenFrameCount++;
        } else if (z) {
            this.slowFrameDelayNanos += j2;
            this.slowFrameCount++;
        } else {
            this.normalFrameCount++;
        }
    }

    public int getNormalFrameCount() {
        return this.normalFrameCount;
    }

    public int getSlowFrameCount() {
        return this.slowFrameCount;
    }

    public int getFrozenFrameCount() {
        return this.frozenFrameCount;
    }

    public long getSlowFrameDelayNanos() {
        return this.slowFrameDelayNanos;
    }

    public long getFrozenFrameDelayNanos() {
        return this.frozenFrameDelayNanos;
    }

    public int getTotalFrameCount() {
        return this.normalFrameCount + this.slowFrameCount + this.frozenFrameCount;
    }

    public long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public void clear() {
        this.normalFrameCount = 0;
        this.slowFrameCount = 0;
        this.slowFrameDelayNanos = 0;
        this.frozenFrameCount = 0;
        this.frozenFrameDelayNanos = 0;
        this.totalDurationNanos = 0;
    }

    public SentryFrameMetrics duplicate() {
        return new SentryFrameMetrics(this.normalFrameCount, this.slowFrameCount, this.slowFrameDelayNanos, this.frozenFrameCount, this.frozenFrameDelayNanos, this.totalDurationNanos);
    }

    public SentryFrameMetrics diffTo(SentryFrameMetrics sentryFrameMetrics) {
        return new SentryFrameMetrics(this.normalFrameCount - sentryFrameMetrics.normalFrameCount, this.slowFrameCount - sentryFrameMetrics.slowFrameCount, this.slowFrameDelayNanos - sentryFrameMetrics.slowFrameDelayNanos, this.frozenFrameCount - sentryFrameMetrics.frozenFrameCount, this.frozenFrameDelayNanos - sentryFrameMetrics.frozenFrameDelayNanos, this.totalDurationNanos - sentryFrameMetrics.totalDurationNanos);
    }

    public boolean containsValidData() {
        return this.normalFrameCount >= 0 && this.slowFrameCount >= 0 && this.slowFrameDelayNanos >= 0 && this.frozenFrameCount >= 0 && this.frozenFrameDelayNanos >= 0 && this.totalDurationNanos >= 0;
    }
}
