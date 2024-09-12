package io.sentry.android.core;

import io.sentry.IPerformanceContinuousCollector;
import io.sentry.ISpan;
import io.sentry.NoOpSpan;
import io.sentry.NoOpTransaction;
import io.sentry.SentryDate;
import io.sentry.SentryNanotimeDate;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

public class SpanFrameMetricsCollector implements IPerformanceContinuousCollector, SentryFrameMetricsCollector.FrameMetricsCollectorListener {
    private static final int MAX_FRAMES_COUNT = 3600;
    private static final long ONE_SECOND_NANOS = TimeUnit.SECONDS.toNanos(1);
    private static final SentryNanotimeDate UNIX_START_DATE = new SentryNanotimeDate(new Date(0), 0);
    private final boolean enabled;
    private final SentryFrameMetricsCollector frameMetricsCollector;
    private final ConcurrentSkipListSet<Frame> frames = new ConcurrentSkipListSet<>();
    private long lastKnownFrameDurationNanos = 16666666;
    private volatile String listenerId;
    private final Object lock = new Object();
    private final SortedSet<ISpan> runningSpans = new TreeSet(new SpanFrameMetricsCollector$$ExternalSyntheticLambda0());

    static /* synthetic */ int lambda$new$0(ISpan iSpan, ISpan iSpan2) {
        int compareTo = iSpan.getStartDate().compareTo(iSpan2.getStartDate());
        if (compareTo != 0) {
            return compareTo;
        }
        return iSpan.getSpanContext().getSpanId().toString().compareTo(iSpan2.getSpanContext().getSpanId().toString());
    }

    public SpanFrameMetricsCollector(SentryAndroidOptions sentryAndroidOptions, SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this.frameMetricsCollector = sentryFrameMetricsCollector;
        this.enabled = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    public void onSpanStarted(ISpan iSpan) {
        if (this.enabled && !(iSpan instanceof NoOpSpan) && !(iSpan instanceof NoOpTransaction)) {
            synchronized (this.lock) {
                this.runningSpans.add(iSpan);
                if (this.listenerId == null) {
                    this.listenerId = this.frameMetricsCollector.startCollection(this);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
        captureFrameMetrics(r6);
        r6 = r5.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        if (r5.runningSpans.isEmpty() == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        r5.frames.headSet(new io.sentry.android.core.SpanFrameMetricsCollector.Frame(realNanos(r5.runningSpans.first().getStartDate()))).clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSpanFinished(io.sentry.ISpan r6) {
        /*
            r5 = this;
            boolean r0 = r5.enabled
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r6 instanceof io.sentry.NoOpSpan
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            boolean r0 = r6 instanceof io.sentry.NoOpTransaction
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            java.util.SortedSet<io.sentry.ISpan> r1 = r5.runningSpans     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            r5.captureFrameMetrics(r6)
            java.lang.Object r6 = r5.lock
            monitor-enter(r6)
            java.util.SortedSet<io.sentry.ISpan> r0 = r5.runningSpans     // Catch:{ all -> 0x004f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x002f
            r5.clear()     // Catch:{ all -> 0x004f }
            goto L_0x004d
        L_0x002f:
            java.util.SortedSet<io.sentry.ISpan> r0 = r5.runningSpans     // Catch:{ all -> 0x004f }
            java.lang.Object r0 = r0.first()     // Catch:{ all -> 0x004f }
            io.sentry.ISpan r0 = (io.sentry.ISpan) r0     // Catch:{ all -> 0x004f }
            java.util.concurrent.ConcurrentSkipListSet<io.sentry.android.core.SpanFrameMetricsCollector$Frame> r1 = r5.frames     // Catch:{ all -> 0x004f }
            io.sentry.android.core.SpanFrameMetricsCollector$Frame r2 = new io.sentry.android.core.SpanFrameMetricsCollector$Frame     // Catch:{ all -> 0x004f }
            io.sentry.SentryDate r0 = r0.getStartDate()     // Catch:{ all -> 0x004f }
            long r3 = realNanos(r0)     // Catch:{ all -> 0x004f }
            r2.<init>(r3)     // Catch:{ all -> 0x004f }
            java.util.NavigableSet r0 = r1.headSet(r2)     // Catch:{ all -> 0x004f }
            r0.clear()     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r6)     // Catch:{ all -> 0x004f }
            return
        L_0x004f:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004f }
            throw r0
        L_0x0052:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.SpanFrameMetricsCollector.onSpanFinished(io.sentry.ISpan):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0183, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void captureFrameMetrics(io.sentry.ISpan r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            java.util.SortedSet<io.sentry.ISpan> r3 = r1.runningSpans     // Catch:{ all -> 0x0188 }
            boolean r3 = r3.remove(r0)     // Catch:{ all -> 0x0188 }
            if (r3 != 0) goto L_0x0011
            monitor-exit(r2)     // Catch:{ all -> 0x0188 }
            return
        L_0x0011:
            io.sentry.SentryDate r3 = r20.getFinishDate()     // Catch:{ all -> 0x0188 }
            if (r3 != 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x0188 }
            return
        L_0x0019:
            long r7 = realNanos(r3)     // Catch:{ all -> 0x0188 }
            io.sentry.android.core.SentryFrameMetrics r3 = new io.sentry.android.core.SentryFrameMetrics     // Catch:{ all -> 0x0188 }
            r3.<init>()     // Catch:{ all -> 0x0188 }
            io.sentry.SentryDate r4 = r20.getStartDate()     // Catch:{ all -> 0x0188 }
            long r4 = realNanos(r4)     // Catch:{ all -> 0x0188 }
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x0030
            monitor-exit(r2)     // Catch:{ all -> 0x0188 }
            return
        L_0x0030:
            long r14 = r7 - r4
            long r9 = r1.lastKnownFrameDurationNanos     // Catch:{ all -> 0x0188 }
            java.util.concurrent.ConcurrentSkipListSet<io.sentry.android.core.SpanFrameMetricsCollector$Frame> r6 = r1.frames     // Catch:{ all -> 0x0188 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0188 }
            if (r6 != 0) goto L_0x00f9
            java.util.concurrent.ConcurrentSkipListSet<io.sentry.android.core.SpanFrameMetricsCollector$Frame> r6 = r1.frames     // Catch:{ all -> 0x0184 }
            io.sentry.android.core.SpanFrameMetricsCollector$Frame r11 = new io.sentry.android.core.SpanFrameMetricsCollector$Frame     // Catch:{ all -> 0x0184 }
            r11.<init>(r4)     // Catch:{ all -> 0x0184 }
            java.util.NavigableSet r6 = r6.tailSet(r11)     // Catch:{ all -> 0x0184 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0184 }
        L_0x004b:
            boolean r11 = r6.hasNext()     // Catch:{ all -> 0x0184 }
            if (r11 == 0) goto L_0x00f9
            java.lang.Object r11 = r6.next()     // Catch:{ all -> 0x0184 }
            r16 = r11
            io.sentry.android.core.SpanFrameMetricsCollector$Frame r16 = (io.sentry.android.core.SpanFrameMetricsCollector.Frame) r16     // Catch:{ all -> 0x0184 }
            long r11 = r16.startNanos     // Catch:{ all -> 0x0184 }
            int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x0063
            goto L_0x00f9
        L_0x0063:
            long r9 = r16.startNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x008d
            long r9 = r16.endNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x008d
            long r10 = r16.durationNanos     // Catch:{ all -> 0x0184 }
            long r12 = r16.delayNanos     // Catch:{ all -> 0x0184 }
            boolean r17 = r16.isSlow     // Catch:{ all -> 0x0184 }
            boolean r18 = r16.isFrozen     // Catch:{ all -> 0x0184 }
            r9 = r3
            r0 = r14
            r14 = r17
            r15 = r18
            r9.addFrame(r10, r12, r14, r15)     // Catch:{ all -> 0x0184 }
            goto L_0x00ee
        L_0x008d:
            r0 = r14
            long r9 = r16.startNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x009e
            long r9 = r16.endNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00ae
        L_0x009e:
            long r9 = r16.startNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ee
            long r9 = r16.endNanos     // Catch:{ all -> 0x0184 }
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00ee
        L_0x00ae:
            long r9 = r16.startNanos     // Catch:{ all -> 0x0184 }
            long r9 = r4 - r9
            r11 = 0
            long r9 = java.lang.Math.max(r11, r9)     // Catch:{ all -> 0x0184 }
            long r13 = r16.expectedDurationNanos     // Catch:{ all -> 0x0184 }
            long r9 = r9 - r13
            long r9 = java.lang.Math.max(r11, r9)     // Catch:{ all -> 0x0184 }
            long r11 = r16.delayNanos     // Catch:{ all -> 0x0184 }
            long r11 = r11 - r9
            long r12 = java.lang.Math.min(r11, r0)     // Catch:{ all -> 0x0184 }
            long r9 = r16.startNanos     // Catch:{ all -> 0x0184 }
            long r9 = java.lang.Math.max(r4, r9)     // Catch:{ all -> 0x0184 }
            long r14 = r16.endNanos     // Catch:{ all -> 0x0184 }
            long r14 = java.lang.Math.min(r7, r14)     // Catch:{ all -> 0x0184 }
            long r10 = r14 - r9
            long r14 = r16.expectedDurationNanos     // Catch:{ all -> 0x0184 }
            boolean r14 = io.sentry.android.core.internal.util.SentryFrameMetricsCollector.isSlow(r10, r14)     // Catch:{ all -> 0x0184 }
            boolean r15 = io.sentry.android.core.internal.util.SentryFrameMetricsCollector.isFrozen(r10)     // Catch:{ all -> 0x0184 }
            r9 = r3
            r9.addFrame(r10, r12, r14, r15)     // Catch:{ all -> 0x0184 }
        L_0x00ee:
            long r9 = r16.expectedDurationNanos     // Catch:{ all -> 0x0184 }
            r14 = r0
            r1 = r19
            r0 = r20
            goto L_0x004b
        L_0x00f9:
            r0 = r14
            r11 = r9
            int r13 = r3.getTotalFrameCount()     // Catch:{ all -> 0x0184 }
            r14 = r0
            r1 = r19
            io.sentry.android.core.internal.util.SentryFrameMetricsCollector r0 = r1.frameMetricsCollector     // Catch:{ all -> 0x0188 }
            long r9 = r0.getLastKnownFrameStartTimeNanos()     // Catch:{ all -> 0x0188 }
            r4 = r3
            r5 = r11
            int r0 = addPendingFrameDelay(r4, r5, r7, r9)     // Catch:{ all -> 0x0188 }
            int r13 = r13 + r0
            int r0 = interpolateFrameCount(r3, r11, r14)     // Catch:{ all -> 0x0188 }
            int r13 = r13 + r0
            long r4 = r3.getSlowFrameDelayNanos()     // Catch:{ all -> 0x0188 }
            long r6 = r3.getFrozenFrameDelayNanos()     // Catch:{ all -> 0x0188 }
            long r4 = r4 + r6
            double r4 = (double) r4     // Catch:{ all -> 0x0188 }
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r4 = r4 / r6
            java.lang.String r0 = "frames.total"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0188 }
            r7 = r20
            r7.setData(r0, r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames.slow"
            int r6 = r3.getSlowFrameCount()     // Catch:{ all -> 0x0188 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0188 }
            r7.setData(r0, r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames.frozen"
            int r6 = r3.getFrozenFrameCount()     // Catch:{ all -> 0x0188 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0188 }
            r7.setData(r0, r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames.delay"
            java.lang.Double r6 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x0188 }
            r7.setData(r0, r6)     // Catch:{ all -> 0x0188 }
            boolean r0 = r7 instanceof io.sentry.ITransaction     // Catch:{ all -> 0x0188 }
            if (r0 == 0) goto L_0x0182
            java.lang.String r0 = "frames_total"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0188 }
            r7.setMeasurement(r0, r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames_slow"
            int r6 = r3.getSlowFrameCount()     // Catch:{ all -> 0x0188 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0188 }
            r7.setMeasurement(r0, r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames_frozen"
            int r3 = r3.getFrozenFrameCount()     // Catch:{ all -> 0x0188 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0188 }
            r7.setMeasurement(r0, r3)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = "frames_delay"
            java.lang.Double r3 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x0188 }
            r7.setMeasurement(r0, r3)     // Catch:{ all -> 0x0188 }
        L_0x0182:
            monitor-exit(r2)     // Catch:{ all -> 0x0188 }
            return
        L_0x0184:
            r0 = move-exception
            r1 = r19
            goto L_0x0189
        L_0x0188:
            r0 = move-exception
        L_0x0189:
            monitor-exit(r2)     // Catch:{ all -> 0x0188 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.SpanFrameMetricsCollector.captureFrameMetrics(io.sentry.ISpan):void");
    }

    public void clear() {
        synchronized (this.lock) {
            if (this.listenerId != null) {
                this.frameMetricsCollector.stopCollection(this.listenerId);
                this.listenerId = null;
            }
            this.frames.clear();
            this.runningSpans.clear();
        }
    }

    public void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        if (this.frames.size() <= MAX_FRAMES_COUNT) {
            long j5 = (long) (((double) ONE_SECOND_NANOS) / ((double) f));
            this.lastKnownFrameDurationNanos = j5;
            this.frames.add(new Frame(j, j2, j3, j4, z, z2, j5));
        }
    }

    private static int interpolateFrameCount(SentryFrameMetrics sentryFrameMetrics, long j, long j2) {
        long totalDurationNanos = j2 - sentryFrameMetrics.getTotalDurationNanos();
        if (totalDurationNanos > 0) {
            return (int) (totalDurationNanos / j);
        }
        return 0;
    }

    private static int addPendingFrameDelay(SentryFrameMetrics sentryFrameMetrics, long j, long j2, long j3) {
        long max = Math.max(0, j2 - j3);
        if (!SentryFrameMetricsCollector.isSlow(max, j)) {
            return 0;
        }
        SentryFrameMetrics sentryFrameMetrics2 = sentryFrameMetrics;
        sentryFrameMetrics2.addFrame(max, Math.max(0, max - j), true, SentryFrameMetricsCollector.isFrozen(max));
        return 1;
    }

    private static long realNanos(SentryDate sentryDate) {
        return sentryDate.diff(UNIX_START_DATE);
    }

    private static class Frame implements Comparable<Frame> {
        /* access modifiers changed from: private */
        public final long delayNanos;
        /* access modifiers changed from: private */
        public final long durationNanos;
        /* access modifiers changed from: private */
        public final long endNanos;
        /* access modifiers changed from: private */
        public final long expectedDurationNanos;
        /* access modifiers changed from: private */
        public final boolean isFrozen;
        /* access modifiers changed from: private */
        public final boolean isSlow;
        /* access modifiers changed from: private */
        public final long startNanos;

        Frame(long j) {
            this(j, j, 0, 0, false, false, 0);
        }

        Frame(long j, long j2, long j3, long j4, boolean z, boolean z2, long j5) {
            this.startNanos = j;
            this.endNanos = j2;
            this.durationNanos = j3;
            this.delayNanos = j4;
            this.isSlow = z;
            this.isFrozen = z2;
            this.expectedDurationNanos = j5;
        }

        public int compareTo(Frame frame) {
            return Long.compare(this.endNanos, frame.endNanos);
        }
    }
}
