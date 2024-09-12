package io.sentry.android.core;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import com.google.android.exoplayer2.C;
import io.sentry.CpuCollectionData;
import io.sentry.ILogger;
import io.sentry.IPerformanceSnapshotCollector;
import io.sentry.PerformanceCollectionData;
import io.sentry.SentryLevel;
import io.sentry.util.FileUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public final class AndroidCpuCollector implements IPerformanceSnapshotCollector {
    private final long NANOSECOND_PER_SECOND = C.NANOS_PER_SECOND;
    private final BuildInfoProvider buildInfoProvider;
    private long clockSpeedHz = 1;
    private boolean isEnabled = false;
    private long lastCpuNanos = 0;
    private long lastRealtimeNanos = 0;
    private final ILogger logger;
    private double nanosecondsPerClockTick = (1.0E9d / ((double) 1));
    private final Pattern newLinePattern = Pattern.compile("[\n\t\r ]");
    private long numCores = 1;
    private final File selfStat = new File("/proc/self/stat");

    public AndroidCpuCollector(ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "BuildInfoProvider is required.");
    }

    public void setup() {
        if (this.buildInfoProvider.getSdkInfoVersion() < 21) {
            this.isEnabled = false;
            return;
        }
        this.isEnabled = true;
        this.clockSpeedHz = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.numCores = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.nanosecondsPerClockTick = 1.0E9d / ((double) this.clockSpeedHz);
        this.lastCpuNanos = readTotalCpuNanos();
    }

    public void collect(PerformanceCollectionData performanceCollectionData) {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 21 && this.isEnabled) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j = elapsedRealtimeNanos - this.lastRealtimeNanos;
            this.lastRealtimeNanos = elapsedRealtimeNanos;
            long readTotalCpuNanos = readTotalCpuNanos();
            this.lastCpuNanos = readTotalCpuNanos;
            performanceCollectionData.addCpuData(new CpuCollectionData(System.currentTimeMillis(), ((((double) (readTotalCpuNanos - this.lastCpuNanos)) / ((double) j)) / ((double) this.numCores)) * 100.0d));
        }
    }

    private long readTotalCpuNanos() {
        String str;
        try {
            str = FileUtils.readText(this.selfStat);
        } catch (IOException e) {
            this.isEnabled = false;
            this.logger.log(SentryLevel.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", (Throwable) e);
            str = null;
        }
        if (str != null) {
            String[] split = this.newLinePattern.split(str.trim());
            try {
                long parseLong = Long.parseLong(split[13]);
                long parseLong2 = Long.parseLong(split[14]);
                return (long) (((double) (parseLong + parseLong2 + Long.parseLong(split[15]) + Long.parseLong(split[16]))) * this.nanosecondsPerClockTick);
            } catch (NumberFormatException e2) {
                this.logger.log(SentryLevel.ERROR, "Error parsing /proc/self/stat file.", (Throwable) e2);
            }
        }
        return 0;
    }
}
