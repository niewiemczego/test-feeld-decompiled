package io.sentry.android.core;

import android.app.Activity;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class ActivityFramesTracker {
    private final Map<SentryId, Map<String, MeasurementValue>> activityMeasurements;
    private final Map<Activity, FrameCounts> frameCountAtStartSnapshots;
    private FrameMetricsAggregator frameMetricsAggregator;
    private final MainLooperHandler handler;
    private final SentryAndroidOptions options;

    public ActivityFramesTracker(LoadClass loadClass, SentryAndroidOptions sentryAndroidOptions, MainLooperHandler mainLooperHandler) {
        this.frameMetricsAggregator = null;
        this.activityMeasurements = new ConcurrentHashMap();
        this.frameCountAtStartSnapshots = new WeakHashMap();
        if (loadClass.isClassAvailable("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger())) {
            this.frameMetricsAggregator = new FrameMetricsAggregator();
        }
        this.options = sentryAndroidOptions;
        this.handler = mainLooperHandler;
    }

    public ActivityFramesTracker(LoadClass loadClass, SentryAndroidOptions sentryAndroidOptions) {
        this(loadClass, sentryAndroidOptions, new MainLooperHandler());
    }

    ActivityFramesTracker(LoadClass loadClass, SentryAndroidOptions sentryAndroidOptions, MainLooperHandler mainLooperHandler, FrameMetricsAggregator frameMetricsAggregator2) {
        this(loadClass, sentryAndroidOptions, mainLooperHandler);
        this.frameMetricsAggregator = frameMetricsAggregator2;
    }

    public boolean isFrameMetricsAggregatorAvailable() {
        return this.frameMetricsAggregator != null && this.options.isEnableFramesTracking() && !this.options.isEnablePerformanceV2();
    }

    public synchronized void addActivity(Activity activity) {
        if (isFrameMetricsAggregatorAvailable()) {
            runSafelyOnUiThread(new ActivityFramesTracker$$ExternalSyntheticLambda0(this, activity), "FrameMetricsAggregator.add");
            snapshotFrameCountsAtStart(activity);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$addActivity$0$io-sentry-android-core-ActivityFramesTracker  reason: not valid java name */
    public /* synthetic */ void m882lambda$addActivity$0$iosentryandroidcoreActivityFramesTracker(Activity activity) {
        this.frameMetricsAggregator.add(activity);
    }

    private void snapshotFrameCountsAtStart(Activity activity) {
        FrameCounts calculateCurrentFrameCounts = calculateCurrentFrameCounts();
        if (calculateCurrentFrameCounts != null) {
            this.frameCountAtStartSnapshots.put(activity, calculateCurrentFrameCounts);
        }
    }

    private FrameCounts calculateCurrentFrameCounts() {
        FrameMetricsAggregator frameMetricsAggregator2;
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        if (!isFrameMetricsAggregatorAvailable() || (frameMetricsAggregator2 = this.frameMetricsAggregator) == null) {
            return null;
        }
        SparseIntArray[] metrics = frameMetricsAggregator2.getMetrics();
        int i3 = 0;
        if (metrics == null || metrics.length <= 0 || (sparseIntArray = metrics[0]) == null) {
            i2 = 0;
            i = 0;
        } else {
            int i4 = 0;
            i2 = 0;
            i = 0;
            while (i3 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i3);
                int valueAt = sparseIntArray.valueAt(i3);
                i4 += valueAt;
                if (keyAt > 700) {
                    i += valueAt;
                } else if (keyAt > 16) {
                    i2 += valueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        return new FrameCounts(i3, i2, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setMetrics(android.app.Activity r5, io.sentry.protocol.SentryId r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.isFrameMetricsAggregatorAvailable()     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            io.sentry.android.core.ActivityFramesTracker$$ExternalSyntheticLambda1 r0 = new io.sentry.android.core.ActivityFramesTracker$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0075 }
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0075 }
            r1 = 0
            r4.runSafelyOnUiThread(r0, r1)     // Catch:{ all -> 0x0075 }
            io.sentry.android.core.ActivityFramesTracker$FrameCounts r5 = r4.diffFrameCountsAtEnd(r5)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x0073
            int r0 = r5.totalFrames     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            int r0 = r5.slowFrames     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            int r0 = r5.frozenFrames     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            goto L_0x0073
        L_0x002b:
            io.sentry.protocol.MeasurementValue r0 = new io.sentry.protocol.MeasurementValue     // Catch:{ all -> 0x0075 }
            int r1 = r5.totalFrames     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "none"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0075 }
            io.sentry.protocol.MeasurementValue r1 = new io.sentry.protocol.MeasurementValue     // Catch:{ all -> 0x0075 }
            int r2 = r5.slowFrames     // Catch:{ all -> 0x0075 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "none"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0075 }
            io.sentry.protocol.MeasurementValue r2 = new io.sentry.protocol.MeasurementValue     // Catch:{ all -> 0x0075 }
            int r5 = r5.frozenFrames     // Catch:{ all -> 0x0075 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "none"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x0075 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0075 }
            r5.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "frames_total"
            r5.put(r3, r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "frames_slow"
            r5.put(r0, r1)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "frames_frozen"
            r5.put(r0, r2)     // Catch:{ all -> 0x0075 }
            java.util.Map<io.sentry.protocol.SentryId, java.util.Map<java.lang.String, io.sentry.protocol.MeasurementValue>> r0 = r4.activityMeasurements     // Catch:{ all -> 0x0075 }
            r0.put(r6, r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0073:
            monitor-exit(r4)
            return
        L_0x0075:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.ActivityFramesTracker.setMetrics(android.app.Activity, io.sentry.protocol.SentryId):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setMetrics$1$io-sentry-android-core-ActivityFramesTracker  reason: not valid java name */
    public /* synthetic */ void m884lambda$setMetrics$1$iosentryandroidcoreActivityFramesTracker(Activity activity) {
        this.frameMetricsAggregator.remove(activity);
    }

    private FrameCounts diffFrameCountsAtEnd(Activity activity) {
        FrameCounts calculateCurrentFrameCounts;
        FrameCounts remove = this.frameCountAtStartSnapshots.remove(activity);
        if (remove == null || (calculateCurrentFrameCounts = calculateCurrentFrameCounts()) == null) {
            return null;
        }
        return new FrameCounts(calculateCurrentFrameCounts.totalFrames - remove.totalFrames, calculateCurrentFrameCounts.slowFrames - remove.slowFrames, calculateCurrentFrameCounts.frozenFrames - remove.frozenFrames);
    }

    public synchronized Map<String, MeasurementValue> takeMetrics(SentryId sentryId) {
        if (!isFrameMetricsAggregatorAvailable()) {
            return null;
        }
        Map<String, MeasurementValue> map = this.activityMeasurements.get(sentryId);
        this.activityMeasurements.remove(sentryId);
        return map;
    }

    public synchronized void stop() {
        if (isFrameMetricsAggregatorAvailable()) {
            runSafelyOnUiThread(new ActivityFramesTracker$$ExternalSyntheticLambda2(this), "FrameMetricsAggregator.stop");
            this.frameMetricsAggregator.reset();
        }
        this.activityMeasurements.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$stop$2$io-sentry-android-core-ActivityFramesTracker  reason: not valid java name */
    public /* synthetic */ void m885lambda$stop$2$iosentryandroidcoreActivityFramesTracker() {
        this.frameMetricsAggregator.stop();
    }

    private void runSafelyOnUiThread(Runnable runnable, String str) {
        try {
            if (AndroidMainThreadChecker.getInstance().isMainThread()) {
                runnable.run();
            } else {
                this.handler.post(new ActivityFramesTracker$$ExternalSyntheticLambda3(this, runnable, str));
            }
        } catch (Throwable unused) {
            if (str != null) {
                this.options.getLogger().log(SentryLevel.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$runSafelyOnUiThread$3$io-sentry-android-core-ActivityFramesTracker  reason: not valid java name */
    public /* synthetic */ void m883lambda$runSafelyOnUiThread$3$iosentryandroidcoreActivityFramesTracker(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable unused) {
            if (str != null) {
                this.options.getLogger().log(SentryLevel.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    private static final class FrameCounts {
        /* access modifiers changed from: private */
        public final int frozenFrames;
        /* access modifiers changed from: private */
        public final int slowFrames;
        /* access modifiers changed from: private */
        public final int totalFrames;

        private FrameCounts(int i, int i2, int i3) {
            this.totalFrames = i;
            this.slowFrames = i2;
            this.frozenFrames = i3;
        }
    }
}
