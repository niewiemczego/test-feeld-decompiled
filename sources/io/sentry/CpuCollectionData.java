package io.sentry;

public final class CpuCollectionData {
    final double cpuUsagePercentage;
    final long timestampMillis;

    public CpuCollectionData(long j, double d) {
        this.timestampMillis = j;
        this.cpuUsagePercentage = d;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public double getCpuUsagePercentage() {
        return this.cpuUsagePercentage;
    }
}
