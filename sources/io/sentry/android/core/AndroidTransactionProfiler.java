package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import io.sentry.HubAdapter;
import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.ISentryExecutorService;
import io.sentry.ITransaction;
import io.sentry.ITransactionProfiler;
import io.sentry.PerformanceCollectionData;
import io.sentry.ProfilingTraceData;
import io.sentry.ProfilingTransactionData;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.util.Objects;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class AndroidTransactionProfiler implements ITransactionProfiler {
    private final BuildInfoProvider buildInfoProvider;
    private final Context context;
    private ProfilingTransactionData currentProfilingTransactionData;
    private final ISentryExecutorService executorService;
    private final SentryFrameMetricsCollector frameMetricsCollector;
    private boolean isInitialized;
    private final boolean isProfilingEnabled;
    private final ILogger logger;
    private long profileStartCpuMillis;
    private long profileStartNanos;
    private AndroidProfiler profiler;
    private final String profilingTracesDirPath;
    private final int profilingTracesHz;
    private int transactionsCounter;

    @Deprecated
    public AndroidTransactionProfiler(Context context2, SentryAndroidOptions sentryAndroidOptions, BuildInfoProvider buildInfoProvider2, SentryFrameMetricsCollector sentryFrameMetricsCollector, IHub iHub) {
        this(context2, sentryAndroidOptions, buildInfoProvider2, sentryFrameMetricsCollector);
    }

    public AndroidTransactionProfiler(Context context2, SentryAndroidOptions sentryAndroidOptions, BuildInfoProvider buildInfoProvider2, SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this(context2, buildInfoProvider2, sentryFrameMetricsCollector, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.isProfilingEnabled(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService());
    }

    public AndroidTransactionProfiler(Context context2, BuildInfoProvider buildInfoProvider2, SentryFrameMetricsCollector sentryFrameMetricsCollector, ILogger iLogger, String str, boolean z, int i, ISentryExecutorService iSentryExecutorService) {
        this.isInitialized = false;
        this.transactionsCounter = 0;
        this.profiler = null;
        this.context = (Context) Objects.requireNonNull(context2, "The application context is required");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "ILogger is required");
        this.frameMetricsCollector = (SentryFrameMetricsCollector) Objects.requireNonNull(sentryFrameMetricsCollector, "SentryFrameMetricsCollector is required");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "The BuildInfoProvider is required.");
        this.profilingTracesDirPath = str;
        this.isProfilingEnabled = z;
        this.profilingTracesHz = i;
        this.executorService = (ISentryExecutorService) Objects.requireNonNull(iSentryExecutorService, "The ISentryExecutorService is required.");
    }

    private void init() {
        if (!this.isInitialized) {
            this.isInitialized = true;
            if (!this.isProfilingEnabled) {
                this.logger.log(SentryLevel.INFO, "Profiling is disabled in options.", new Object[0]);
            } else if (this.profilingTracesDirPath == null) {
                this.logger.log(SentryLevel.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            } else if (this.profilingTracesHz <= 0) {
                this.logger.log(SentryLevel.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(this.profilingTracesHz));
            } else {
                this.profiler = new AndroidProfiler(this.profilingTracesDirPath, ((int) TimeUnit.SECONDS.toMicros(1)) / this.profilingTracesHz, this.frameMetricsCollector, this.executorService, this.logger, this.buildInfoProvider);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r4 = this;
            monitor-enter(r4)
            io.sentry.android.core.BuildInfoProvider r0 = r4.buildInfoProvider     // Catch:{ all -> 0x003d }
            int r0 = r0.getSdkInfoVersion()     // Catch:{ all -> 0x003d }
            r1 = 21
            if (r0 >= r1) goto L_0x000d
            monitor-exit(r4)
            return
        L_0x000d:
            r4.init()     // Catch:{ all -> 0x003d }
            int r0 = r4.transactionsCounter     // Catch:{ all -> 0x003d }
            r1 = 1
            int r0 = r0 + r1
            r4.transactionsCounter = r0     // Catch:{ all -> 0x003d }
            r2 = 0
            if (r0 != r1) goto L_0x002b
            boolean r0 = r4.onFirstStart()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x002b
            io.sentry.ILogger r0 = r4.logger     // Catch:{ all -> 0x003d }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "Profiler started."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x003d }
            r0.log((io.sentry.SentryLevel) r1, (java.lang.String) r3, (java.lang.Object[]) r2)     // Catch:{ all -> 0x003d }
            goto L_0x003b
        L_0x002b:
            int r0 = r4.transactionsCounter     // Catch:{ all -> 0x003d }
            int r0 = r0 - r1
            r4.transactionsCounter = r0     // Catch:{ all -> 0x003d }
            io.sentry.ILogger r0 = r4.logger     // Catch:{ all -> 0x003d }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "A profile is already running. This profile will be ignored."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x003d }
            r0.log((io.sentry.SentryLevel) r1, (java.lang.String) r3, (java.lang.Object[]) r2)     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r4)
            return
        L_0x003d:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidTransactionProfiler.start():void");
    }

    private boolean onFirstStart() {
        AndroidProfiler.ProfileStartData start;
        AndroidProfiler androidProfiler = this.profiler;
        if (androidProfiler == null || (start = androidProfiler.start()) == null) {
            return false;
        }
        this.profileStartNanos = start.startNanos;
        this.profileStartCpuMillis = start.startCpuMillis;
        return true;
    }

    public synchronized void bindTransaction(ITransaction iTransaction) {
        if (this.transactionsCounter > 0 && this.currentProfilingTransactionData == null) {
            this.currentProfilingTransactionData = new ProfilingTransactionData(iTransaction, Long.valueOf(this.profileStartNanos), Long.valueOf(this.profileStartCpuMillis));
        }
    }

    public synchronized ProfilingTraceData onTransactionFinish(ITransaction iTransaction, List<PerformanceCollectionData> list, SentryOptions sentryOptions) {
        return onTransactionFinish(iTransaction.getName(), iTransaction.getEventId().toString(), iTransaction.getSpanContext().getTraceId().toString(), false, list, sentryOptions);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized io.sentry.ProfilingTraceData onTransactionFinish(java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, java.util.List<io.sentry.PerformanceCollectionData> r28, io.sentry.SentryOptions r29) {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            io.sentry.android.core.AndroidProfiler r0 = r1.profiler     // Catch:{ all -> 0x014c }
            r2 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r23)
            return r2
        L_0x000a:
            io.sentry.android.core.BuildInfoProvider r0 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            int r0 = r0.getSdkInfoVersion()     // Catch:{ all -> 0x014c }
            r3 = 21
            if (r0 >= r3) goto L_0x0016
            monitor-exit(r23)
            return r2
        L_0x0016:
            io.sentry.ProfilingTransactionData r0 = r1.currentProfilingTransactionData     // Catch:{ all -> 0x014c }
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x013b
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x014c }
            r6 = r25
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x014c }
            if (r0 != 0) goto L_0x002b
            goto L_0x013b
        L_0x002b:
            int r0 = r1.transactionsCounter     // Catch:{ all -> 0x014c }
            if (r0 <= 0) goto L_0x0032
            int r0 = r0 - r4
            r1.transactionsCounter = r0     // Catch:{ all -> 0x014c }
        L_0x0032:
            io.sentry.ILogger r0 = r1.logger     // Catch:{ all -> 0x014c }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x014c }
            java.lang.String r8 = "Transaction %s (%s) finished."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x014c }
            r3[r5] = r24     // Catch:{ all -> 0x014c }
            r3[r4] = r26     // Catch:{ all -> 0x014c }
            r0.log((io.sentry.SentryLevel) r7, (java.lang.String) r8, (java.lang.Object[]) r3)     // Catch:{ all -> 0x014c }
            int r0 = r1.transactionsCounter     // Catch:{ all -> 0x014c }
            if (r0 == 0) goto L_0x006a
            io.sentry.ProfilingTransactionData r0 = r1.currentProfilingTransactionData     // Catch:{ all -> 0x014c }
            if (r0 == 0) goto L_0x0068
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ all -> 0x014c }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x014c }
            long r4 = r1.profileStartNanos     // Catch:{ all -> 0x014c }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x014c }
            long r5 = android.os.Process.getElapsedCpuTime()     // Catch:{ all -> 0x014c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x014c }
            long r6 = r1.profileStartCpuMillis     // Catch:{ all -> 0x014c }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x014c }
            r0.notifyFinish(r3, r4, r5, r6)     // Catch:{ all -> 0x014c }
        L_0x0068:
            monitor-exit(r23)
            return r2
        L_0x006a:
            io.sentry.android.core.AndroidProfiler r0 = r1.profiler     // Catch:{ all -> 0x014c }
            r3 = r28
            io.sentry.android.core.AndroidProfiler$ProfileEndData r0 = r0.endAndCollect(r5, r3)     // Catch:{ all -> 0x014c }
            if (r0 != 0) goto L_0x0076
            monitor-exit(r23)
            return r2
        L_0x0076:
            long r7 = r0.endNanos     // Catch:{ all -> 0x014c }
            long r9 = r1.profileStartNanos     // Catch:{ all -> 0x014c }
            long r7 = r7 - r9
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x014c }
            r9.<init>(r4)     // Catch:{ all -> 0x014c }
            io.sentry.ProfilingTransactionData r3 = r1.currentProfilingTransactionData     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x0087
            r9.add(r3)     // Catch:{ all -> 0x014c }
        L_0x0087:
            r1.currentProfilingTransactionData = r2     // Catch:{ all -> 0x014c }
            r1.transactionsCounter = r5     // Catch:{ all -> 0x014c }
            java.lang.String r2 = "0"
            android.app.ActivityManager$MemoryInfo r3 = r23.getMemInfo()     // Catch:{ all -> 0x014c }
            if (r3 == 0) goto L_0x0099
            long r2 = r3.totalMem     // Catch:{ all -> 0x014c }
            java.lang.String r2 = java.lang.Long.toString(r2)     // Catch:{ all -> 0x014c }
        L_0x0099:
            r16 = r2
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ all -> 0x014c }
            java.util.Iterator r3 = r9.iterator()     // Catch:{ all -> 0x014c }
        L_0x00a1:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x014c }
            if (r4 == 0) goto L_0x00c9
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x014c }
            io.sentry.ProfilingTransactionData r4 = (io.sentry.ProfilingTransactionData) r4     // Catch:{ all -> 0x014c }
            long r10 = r0.endNanos     // Catch:{ all -> 0x014c }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x014c }
            long r11 = r1.profileStartNanos     // Catch:{ all -> 0x014c }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x014c }
            long r12 = r0.endCpuMillis     // Catch:{ all -> 0x014c }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x014c }
            long r13 = r1.profileStartCpuMillis     // Catch:{ all -> 0x014c }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x014c }
            r4.notifyFinish(r10, r11, r12, r13)     // Catch:{ all -> 0x014c }
            goto L_0x00a1
        L_0x00c9:
            io.sentry.ProfilingTraceData r22 = new io.sentry.ProfilingTraceData     // Catch:{ all -> 0x014c }
            java.io.File r3 = r0.traceFile     // Catch:{ all -> 0x014c }
            java.lang.String r8 = java.lang.Long.toString(r7)     // Catch:{ all -> 0x014c }
            io.sentry.android.core.BuildInfoProvider r4 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            int r10 = r4.getSdkInfoVersion()     // Catch:{ all -> 0x014c }
            if (r2 == 0) goto L_0x00df
            int r4 = r2.length     // Catch:{ all -> 0x014c }
            if (r4 <= 0) goto L_0x00df
            r2 = r2[r5]     // Catch:{ all -> 0x014c }
            goto L_0x00e1
        L_0x00df:
            java.lang.String r2 = ""
        L_0x00e1:
            r11 = r2
            io.sentry.android.core.AndroidTransactionProfiler$$ExternalSyntheticLambda0 r12 = new io.sentry.android.core.AndroidTransactionProfiler$$ExternalSyntheticLambda0     // Catch:{ all -> 0x014c }
            r12.<init>()     // Catch:{ all -> 0x014c }
            io.sentry.android.core.BuildInfoProvider r2 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            java.lang.String r13 = r2.getManufacturer()     // Catch:{ all -> 0x014c }
            io.sentry.android.core.BuildInfoProvider r2 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            java.lang.String r14 = r2.getModel()     // Catch:{ all -> 0x014c }
            io.sentry.android.core.BuildInfoProvider r2 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            java.lang.String r15 = r2.getVersionRelease()     // Catch:{ all -> 0x014c }
            io.sentry.android.core.BuildInfoProvider r2 = r1.buildInfoProvider     // Catch:{ all -> 0x014c }
            java.lang.Boolean r17 = r2.isEmulator()     // Catch:{ all -> 0x014c }
            java.lang.String r18 = r29.getProguardUuid()     // Catch:{ all -> 0x014c }
            java.lang.String r19 = r29.getRelease()     // Catch:{ all -> 0x014c }
            java.lang.String r20 = r29.getEnvironment()     // Catch:{ all -> 0x014c }
            boolean r2 = r0.didTimeout     // Catch:{ all -> 0x014c }
            if (r2 != 0) goto L_0x0115
            if (r27 == 0) goto L_0x0112
            goto L_0x0115
        L_0x0112:
            java.lang.String r2 = "normal"
            goto L_0x0117
        L_0x0115:
            java.lang.String r2 = "timeout"
        L_0x0117:
            r21 = r2
            java.util.Map<java.lang.String, io.sentry.profilemeasurements.ProfileMeasurement> r0 = r0.measurementsMap     // Catch:{ all -> 0x014c }
            r2 = r22
            r4 = r9
            r5 = r24
            r6 = r25
            r7 = r26
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x014c }
            monitor-exit(r23)
            return r22
        L_0x013b:
            io.sentry.ILogger r0 = r1.logger     // Catch:{ all -> 0x014c }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x014c }
            java.lang.String r7 = "Transaction %s (%s) finished, but was not currently being profiled. Skipping"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x014c }
            r3[r5] = r24     // Catch:{ all -> 0x014c }
            r3[r4] = r26     // Catch:{ all -> 0x014c }
            r0.log((io.sentry.SentryLevel) r6, (java.lang.String) r7, (java.lang.Object[]) r3)     // Catch:{ all -> 0x014c }
            monitor-exit(r23)
            return r2
        L_0x014c:
            r0 = move-exception
            monitor-exit(r23)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidTransactionProfiler.onTransactionFinish(java.lang.String, java.lang.String, java.lang.String, boolean, java.util.List, io.sentry.SentryOptions):io.sentry.ProfilingTraceData");
    }

    public boolean isRunning() {
        return this.transactionsCounter != 0;
    }

    public void close() {
        ProfilingTransactionData profilingTransactionData = this.currentProfilingTransactionData;
        if (profilingTransactionData != null) {
            onTransactionFinish(profilingTransactionData.getName(), this.currentProfilingTransactionData.getId(), this.currentProfilingTransactionData.getTraceId(), true, (List<PerformanceCollectionData>) null, HubAdapter.getInstance().getOptions());
        } else {
            int i = this.transactionsCounter;
            if (i != 0) {
                this.transactionsCounter = i - 1;
            }
        }
        AndroidProfiler androidProfiler = this.profiler;
        if (androidProfiler != null) {
            androidProfiler.close();
        }
    }

    private ActivityManager.MemoryInfo getMemInfo() {
        try {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.logger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int getTransactionsCounter() {
        return this.transactionsCounter;
    }
}
