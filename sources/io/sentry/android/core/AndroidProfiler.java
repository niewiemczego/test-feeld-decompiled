package io.sentry.android.core;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.CpuCollectionData;
import io.sentry.ILogger;
import io.sentry.ISentryExecutorService;
import io.sentry.MemoryCollectionData;
import io.sentry.PerformanceCollectionData;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.util.Objects;
import java.io.File;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class AndroidProfiler {
    private static final int BUFFER_SIZE_BYTES = 3000000;
    private static final int PROFILING_TIMEOUT_MILLIS = 30000;
    private final BuildInfoProvider buildInfoProvider;
    private final ISentryExecutorService executorService;
    private final SentryFrameMetricsCollector frameMetricsCollector;
    private String frameMetricsCollectorId;
    /* access modifiers changed from: private */
    public final ArrayDeque<ProfileMeasurementValue> frozenFrameRenderMeasurements = new ArrayDeque<>();
    private final int intervalUs;
    private boolean isRunning = false;
    private final ILogger logger;
    private final Map<String, ProfileMeasurement> measurementsMap = new HashMap();
    /* access modifiers changed from: private */
    public long profileStartNanos = 0;
    private Future<?> scheduledFinish = null;
    /* access modifiers changed from: private */
    public final ArrayDeque<ProfileMeasurementValue> screenFrameRateMeasurements = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public final ArrayDeque<ProfileMeasurementValue> slowFrameRenderMeasurements = new ArrayDeque<>();
    private volatile ProfileEndData timedOutProfilingData = null;
    private File traceFile = null;
    private final File traceFilesDir;

    public static class ProfileStartData {
        public final long startCpuMillis;
        public final long startNanos;

        public ProfileStartData(long j, long j2) {
            this.startNanos = j;
            this.startCpuMillis = j2;
        }
    }

    public static class ProfileEndData {
        public final boolean didTimeout;
        public final long endCpuMillis;
        public final long endNanos;
        public final Map<String, ProfileMeasurement> measurementsMap;
        public final File traceFile;

        public ProfileEndData(long j, long j2, boolean z, File file, Map<String, ProfileMeasurement> map) {
            this.endNanos = j;
            this.traceFile = file;
            this.endCpuMillis = j2;
            this.measurementsMap = map;
            this.didTimeout = z;
        }
    }

    public AndroidProfiler(String str, int i, SentryFrameMetricsCollector sentryFrameMetricsCollector, ISentryExecutorService iSentryExecutorService, ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        this.traceFilesDir = new File((String) Objects.requireNonNull(str, "TracesFilesDirPath is required"));
        this.intervalUs = i;
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required");
        this.executorService = (ISentryExecutorService) Objects.requireNonNull(iSentryExecutorService, "ExecutorService is required.");
        this.frameMetricsCollector = (SentryFrameMetricsCollector) Objects.requireNonNull(sentryFrameMetricsCollector, "SentryFrameMetricsCollector is required");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "The BuildInfoProvider is required.");
    }

    public synchronized ProfileStartData start() {
        if (this.intervalUs == 0) {
            this.logger.log(SentryLevel.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(this.intervalUs));
            return null;
        } else if (this.isRunning) {
            this.logger.log(SentryLevel.WARNING, "Profiling has already started...", new Object[0]);
            return null;
        } else if (this.buildInfoProvider.getSdkInfoVersion() < 21) {
            return null;
        } else {
            this.traceFile = new File(this.traceFilesDir, UUID.randomUUID() + ".trace");
            this.measurementsMap.clear();
            this.screenFrameRateMeasurements.clear();
            this.slowFrameRenderMeasurements.clear();
            this.frozenFrameRenderMeasurements.clear();
            this.frameMetricsCollectorId = this.frameMetricsCollector.startCollection(new SentryFrameMetricsCollector.FrameMetricsCollectorListener() {
                float lastRefreshRate = 0.0f;

                public void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
                    long nanoTime = ((j2 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - AndroidProfiler.this.profileStartNanos;
                    if (nanoTime >= 0) {
                        if (z2) {
                            AndroidProfiler.this.frozenFrameRenderMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(nanoTime), Long.valueOf(j3)));
                        } else if (z) {
                            AndroidProfiler.this.slowFrameRenderMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(nanoTime), Long.valueOf(j3)));
                        }
                        if (f != this.lastRefreshRate) {
                            this.lastRefreshRate = f;
                            AndroidProfiler.this.screenFrameRateMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(nanoTime), Float.valueOf(f)));
                        }
                    }
                }
            });
            try {
                this.scheduledFinish = this.executorService.schedule(new AndroidProfiler$$ExternalSyntheticLambda0(this), 30000);
            } catch (RejectedExecutionException e) {
                this.logger.log(SentryLevel.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", (Throwable) e);
            }
            this.profileStartNanos = SystemClock.elapsedRealtimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            try {
                Debug.startMethodTracingSampling(this.traceFile.getPath(), BUFFER_SIZE_BYTES, this.intervalUs);
                this.isRunning = true;
                return new ProfileStartData(this.profileStartNanos, elapsedCpuTime);
            } catch (Throwable th) {
                endAndCollect(false, (List<PerformanceCollectionData>) null);
                this.logger.log(SentryLevel.ERROR, "Unable to start a profile: ", th);
                this.isRunning = false;
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$io-sentry-android-core-AndroidProfiler  reason: not valid java name */
    public /* synthetic */ void m894lambda$start$0$iosentryandroidcoreAndroidProfiler() {
        this.timedOutProfilingData = endAndCollect(true, (List<PerformanceCollectionData>) null);
    }

    public synchronized ProfileEndData endAndCollect(boolean z, List<PerformanceCollectionData> list) {
        if (this.timedOutProfilingData != null) {
            return this.timedOutProfilingData;
        } else if (!this.isRunning) {
            this.logger.log(SentryLevel.WARNING, "Profiler not running", new Object[0]);
            return null;
        } else if (this.buildInfoProvider.getSdkInfoVersion() < 21) {
            return null;
        } else {
            try {
                Debug.stopMethodTracing();
            } catch (Throwable th) {
                this.isRunning = false;
                throw th;
            }
            this.isRunning = false;
            this.frameMetricsCollector.stopCollection(this.frameMetricsCollectorId);
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            if (this.traceFile == null) {
                this.logger.log(SentryLevel.ERROR, "Trace file does not exists", new Object[0]);
                return null;
            }
            if (!this.slowFrameRenderMeasurements.isEmpty()) {
                this.measurementsMap.put(ProfileMeasurement.ID_SLOW_FRAME_RENDERS, new ProfileMeasurement(ProfileMeasurement.UNIT_NANOSECONDS, this.slowFrameRenderMeasurements));
            }
            if (!this.frozenFrameRenderMeasurements.isEmpty()) {
                this.measurementsMap.put(ProfileMeasurement.ID_FROZEN_FRAME_RENDERS, new ProfileMeasurement(ProfileMeasurement.UNIT_NANOSECONDS, this.frozenFrameRenderMeasurements));
            }
            if (!this.screenFrameRateMeasurements.isEmpty()) {
                this.measurementsMap.put(ProfileMeasurement.ID_SCREEN_FRAME_RATES, new ProfileMeasurement(ProfileMeasurement.UNIT_HZ, this.screenFrameRateMeasurements));
            }
            putPerformanceCollectionDataInMeasurements(list);
            Future<?> future = this.scheduledFinish;
            if (future != null) {
                future.cancel(true);
                this.scheduledFinish = null;
            }
            return new ProfileEndData(elapsedRealtimeNanos, elapsedCpuTime, z, this.traceFile, this.measurementsMap);
        }
    }

    public synchronized void close() {
        Future<?> future = this.scheduledFinish;
        if (future != null) {
            future.cancel(true);
            this.scheduledFinish = null;
        }
        if (this.isRunning) {
            endAndCollect(true, (List<PerformanceCollectionData>) null);
        }
    }

    private void putPerformanceCollectionDataInMeasurements(List<PerformanceCollectionData> list) {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 21) {
            long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.profileStartNanos) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            if (list != null) {
                ArrayDeque arrayDeque = new ArrayDeque(list.size());
                ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
                ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
                synchronized (list) {
                    for (PerformanceCollectionData next : list) {
                        CpuCollectionData cpuData = next.getCpuData();
                        MemoryCollectionData memoryData = next.getMemoryData();
                        if (cpuData != null) {
                            arrayDeque3.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(cpuData.getTimestampMillis()) + elapsedRealtimeNanos), Double.valueOf(cpuData.getCpuUsagePercentage())));
                        }
                        if (memoryData != null && memoryData.getUsedHeapMemory() > -1) {
                            arrayDeque.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(memoryData.getTimestampMillis()) + elapsedRealtimeNanos), Long.valueOf(memoryData.getUsedHeapMemory())));
                        }
                        if (memoryData != null && memoryData.getUsedNativeMemory() > -1) {
                            arrayDeque2.add(new ProfileMeasurementValue(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(memoryData.getTimestampMillis()) + elapsedRealtimeNanos), Long.valueOf(memoryData.getUsedNativeMemory())));
                        }
                    }
                }
                if (!arrayDeque3.isEmpty()) {
                    this.measurementsMap.put(ProfileMeasurement.ID_CPU_USAGE, new ProfileMeasurement(ProfileMeasurement.UNIT_PERCENT, arrayDeque3));
                }
                if (!arrayDeque.isEmpty()) {
                    this.measurementsMap.put(ProfileMeasurement.ID_MEMORY_FOOTPRINT, new ProfileMeasurement(ProfileMeasurement.UNIT_BYTES, arrayDeque));
                }
                if (!arrayDeque2.isEmpty()) {
                    this.measurementsMap.put(ProfileMeasurement.ID_MEMORY_NATIVE_FOOTPRINT, new ProfileMeasurement(ProfileMeasurement.UNIT_BYTES, arrayDeque2));
                }
            }
        }
    }
}
