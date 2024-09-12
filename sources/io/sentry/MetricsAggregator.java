package io.sentry;

import io.sentry.MeasurementUnit;
import io.sentry.SentryOptions;
import io.sentry.metrics.EncodedMetrics;
import io.sentry.metrics.IMetricsClient;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.metrics.Metric;
import io.sentry.metrics.MetricType;
import io.sentry.metrics.MetricsHelper;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;

public final class MetricsAggregator implements IMetricsAggregator, Runnable, Closeable {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final SentryOptions.BeforeEmitMetricCallback beforeEmitCallback;
    private final NavigableMap<Long, Map<String, Metric>> buckets;
    private final IMetricsClient client;
    private final SentryDateProvider dateProvider;
    private volatile ISentryExecutorService executorService;
    private volatile boolean flushScheduled;
    private volatile boolean isClosed;
    private final ILogger logger;
    private final int maxWeight;
    private final AtomicInteger totalBucketsWeight;

    public MetricsAggregator(SentryOptions sentryOptions, IMetricsClient iMetricsClient) {
        this(iMetricsClient, sentryOptions.getLogger(), sentryOptions.getDateProvider(), 100000, sentryOptions.getBeforeEmitMetricCallback(), NoOpSentryExecutorService.getInstance());
    }

    public MetricsAggregator(IMetricsClient iMetricsClient, ILogger iLogger, SentryDateProvider sentryDateProvider, int i, SentryOptions.BeforeEmitMetricCallback beforeEmitMetricCallback, ISentryExecutorService iSentryExecutorService) {
        this.isClosed = false;
        this.flushScheduled = false;
        this.buckets = new ConcurrentSkipListMap();
        this.totalBucketsWeight = new AtomicInteger();
        this.client = iMetricsClient;
        this.logger = iLogger;
        this.dateProvider = sentryDateProvider;
        this.maxWeight = i;
        this.beforeEmitCallback = beforeEmitMetricCallback;
        this.executorService = iSentryExecutorService;
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
        add(MetricType.Counter, str, d, measurementUnit, map, j, localMetricsAggregator);
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
        add(MetricType.Gauge, str, d, measurementUnit, map, j, localMetricsAggregator);
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
        add(MetricType.Distribution, str, d, measurementUnit, map, j, localMetricsAggregator);
    }

    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
        add(MetricType.Set, str, (double) i, measurementUnit, map, j, localMetricsAggregator);
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
        String str3 = str2;
        byte[] bytes = str2.getBytes(UTF8);
        CRC32 crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        add(MetricType.Set, str, (double) ((int) crc32.getValue()), measurementUnit, map, j, localMetricsAggregator);
    }

    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map, LocalMetricsAggregator localMetricsAggregator) {
        long nowMillis = nowMillis();
        long nanoTime = System.nanoTime();
        try {
            runnable.run();
        } finally {
            double convertNanosTo = MetricsHelper.convertNanosTo(duration, System.nanoTime() - nanoTime);
            add(MetricType.Distribution, str, convertNanosTo, duration, map, nowMillis, localMetricsAggregator);
        }
    }

    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r2v30, types: [io.sentry.metrics.CounterMetric] */
    /* JADX WARNING: type inference failed for: r2v31, types: [io.sentry.metrics.GaugeMetric] */
    /* JADX WARNING: type inference failed for: r2v32, types: [io.sentry.metrics.DistributionMetric] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void add(io.sentry.metrics.MetricType r18, java.lang.String r19, double r20, io.sentry.MeasurementUnit r22, java.util.Map<java.lang.String, java.lang.String> r23, long r24, io.sentry.metrics.LocalMetricsAggregator r26) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            r9 = r20
            r11 = r22
            r12 = r23
            boolean r2 = r1.isClosed
            if (r2 == 0) goto L_0x0011
            return
        L_0x0011:
            io.sentry.SentryOptions$BeforeEmitMetricCallback r2 = r1.beforeEmitCallback
            if (r2 == 0) goto L_0x001c
            boolean r2 = r2.execute(r8, r12)
            if (r2 != 0) goto L_0x001c
            return
        L_0x001c:
            long r2 = io.sentry.metrics.MetricsHelper.getTimeBucketKey(r24)
            java.util.Map r13 = r1.getOrAddTimeBucket(r2)
            java.lang.String r14 = io.sentry.metrics.MetricsHelper.getMetricBucketKey(r0, r8, r11, r12)
            monitor-enter(r13)
            java.lang.Object r2 = r13.get(r14)     // Catch:{ all -> 0x0108 }
            io.sentry.metrics.Metric r2 = (io.sentry.metrics.Metric) r2     // Catch:{ all -> 0x0108 }
            r15 = 1
            if (r2 == 0) goto L_0x0040
            int r3 = r2.getWeight()     // Catch:{ all -> 0x0108 }
            r2.add(r9)     // Catch:{ all -> 0x0108 }
            int r2 = r2.getWeight()     // Catch:{ all -> 0x0108 }
            int r2 = r2 - r3
            goto L_0x00b4
        L_0x0040:
            int[] r2 = io.sentry.MetricsAggregator.AnonymousClass1.$SwitchMap$io$sentry$metrics$MetricType     // Catch:{ all -> 0x0108 }
            int r3 = r18.ordinal()     // Catch:{ all -> 0x0108 }
            r2 = r2[r3]     // Catch:{ all -> 0x0108 }
            if (r2 == r15) goto L_0x009b
            r3 = 2
            if (r2 == r3) goto L_0x008b
            r3 = 3
            if (r2 == r3) goto L_0x007b
            r3 = 4
            if (r2 != r3) goto L_0x005e
            io.sentry.metrics.SetMetric r2 = new io.sentry.metrics.SetMetric     // Catch:{ all -> 0x0108 }
            r2.<init>(r8, r11, r12)     // Catch:{ all -> 0x0108 }
            int r3 = (int) r9     // Catch:{ all -> 0x0108 }
            double r3 = (double) r3     // Catch:{ all -> 0x0108 }
            r2.add(r3)     // Catch:{ all -> 0x0108 }
            goto L_0x00ac
        L_0x005e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r3.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "Unknown MetricType: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = r18.name()     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0108 }
            r2.<init>(r0)     // Catch:{ all -> 0x0108 }
            throw r2     // Catch:{ all -> 0x0108 }
        L_0x007b:
            io.sentry.metrics.DistributionMetric r16 = new io.sentry.metrics.DistributionMetric     // Catch:{ all -> 0x0108 }
            r2 = r16
            r3 = r19
            r4 = r20
            r6 = r22
            r7 = r23
            r2.<init>(r3, r4, r6, r7)     // Catch:{ all -> 0x0108 }
            goto L_0x00aa
        L_0x008b:
            io.sentry.metrics.GaugeMetric r16 = new io.sentry.metrics.GaugeMetric     // Catch:{ all -> 0x0108 }
            r2 = r16
            r3 = r19
            r4 = r20
            r6 = r22
            r7 = r23
            r2.<init>(r3, r4, r6, r7)     // Catch:{ all -> 0x0108 }
            goto L_0x00aa
        L_0x009b:
            io.sentry.metrics.CounterMetric r16 = new io.sentry.metrics.CounterMetric     // Catch:{ all -> 0x0108 }
            r2 = r16
            r3 = r19
            r4 = r20
            r6 = r22
            r7 = r23
            r2.<init>(r3, r4, r6, r7)     // Catch:{ all -> 0x0108 }
        L_0x00aa:
            r2 = r16
        L_0x00ac:
            int r3 = r2.getWeight()     // Catch:{ all -> 0x0108 }
            r13.put(r14, r2)     // Catch:{ all -> 0x0108 }
            r2 = r3
        L_0x00b4:
            java.util.concurrent.atomic.AtomicInteger r3 = r1.totalBucketsWeight     // Catch:{ all -> 0x0108 }
            r3.addAndGet(r2)     // Catch:{ all -> 0x0108 }
            monitor-exit(r13)     // Catch:{ all -> 0x0108 }
            if (r26 == 0) goto L_0x00d4
            io.sentry.metrics.MetricType r3 = io.sentry.metrics.MetricType.Set
            if (r0 != r3) goto L_0x00c3
            double r2 = (double) r2
            r6 = r2
            goto L_0x00c4
        L_0x00c3:
            r6 = r9
        L_0x00c4:
            r2 = r26
            r3 = r14
            r4 = r18
            r5 = r19
            r8 = r22
            r9 = r23
            r10 = r24
            r2.add(r3, r4, r5, r6, r8, r9, r10)
        L_0x00d4:
            boolean r0 = r17.isOverWeight()
            boolean r2 = r1.isClosed
            if (r2 != 0) goto L_0x0107
            if (r0 != 0) goto L_0x00e2
            boolean r2 = r1.flushScheduled
            if (r2 != 0) goto L_0x0107
        L_0x00e2:
            monitor-enter(r17)
            boolean r2 = r1.isClosed     // Catch:{ all -> 0x0104 }
            if (r2 != 0) goto L_0x0102
            io.sentry.ISentryExecutorService r2 = r1.executorService     // Catch:{ all -> 0x0104 }
            boolean r2 = r2 instanceof io.sentry.NoOpSentryExecutorService     // Catch:{ all -> 0x0104 }
            if (r2 == 0) goto L_0x00f4
            io.sentry.SentryExecutorService r2 = new io.sentry.SentryExecutorService     // Catch:{ all -> 0x0104 }
            r2.<init>()     // Catch:{ all -> 0x0104 }
            r1.executorService = r2     // Catch:{ all -> 0x0104 }
        L_0x00f4:
            r1.flushScheduled = r15     // Catch:{ all -> 0x0104 }
            if (r0 == 0) goto L_0x00fb
            r2 = 0
            goto L_0x00fd
        L_0x00fb:
            r2 = 5000(0x1388, double:2.4703E-320)
        L_0x00fd:
            io.sentry.ISentryExecutorService r0 = r1.executorService     // Catch:{ all -> 0x0104 }
            r0.schedule(r1, r2)     // Catch:{ all -> 0x0104 }
        L_0x0102:
            monitor-exit(r17)     // Catch:{ all -> 0x0104 }
            goto L_0x0107
        L_0x0104:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0104 }
            throw r0
        L_0x0107:
            return
        L_0x0108:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0108 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.MetricsAggregator.add(io.sentry.metrics.MetricType, java.lang.String, double, io.sentry.MeasurementUnit, java.util.Map, long, io.sentry.metrics.LocalMetricsAggregator):void");
    }

    /* renamed from: io.sentry.MetricsAggregator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$metrics$MetricType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.sentry.metrics.MetricType[] r0 = io.sentry.metrics.MetricType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$metrics$MetricType = r0
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Counter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Gauge     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Distribution     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Set     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.MetricsAggregator.AnonymousClass1.<clinit>():void");
        }
    }

    public void flush(boolean z) {
        if (!z && isOverWeight()) {
            this.logger.log(SentryLevel.INFO, "Metrics: total weight exceeded, flushing all buckets", new Object[0]);
            z = true;
        }
        Set<Long> flushableBuckets = getFlushableBuckets(z);
        if (flushableBuckets.isEmpty()) {
            this.logger.log(SentryLevel.DEBUG, "Metrics: nothing to flush", new Object[0]);
            return;
        }
        this.logger.log(SentryLevel.DEBUG, "Metrics: flushing " + flushableBuckets.size() + " buckets", new Object[0]);
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Long longValue : flushableBuckets) {
            long longValue2 = longValue.longValue();
            Map map = (Map) this.buckets.remove(Long.valueOf(longValue2));
            if (map != null) {
                synchronized (map) {
                    this.totalBucketsWeight.addAndGet(-getBucketWeight(map));
                    i += map.size();
                    hashMap.put(Long.valueOf(longValue2), map);
                }
            }
        }
        if (i == 0) {
            this.logger.log(SentryLevel.DEBUG, "Metrics: only empty buckets found", new Object[0]);
            return;
        }
        this.logger.log(SentryLevel.DEBUG, "Metrics: capturing metrics", new Object[0]);
        this.client.captureMetrics(new EncodedMetrics(hashMap));
    }

    private boolean isOverWeight() {
        return this.buckets.size() + this.totalBucketsWeight.get() >= this.maxWeight;
    }

    private static int getBucketWeight(Map<String, Metric> map) {
        int i = 0;
        for (Metric weight : map.values()) {
            i += weight.getWeight();
        }
        return i;
    }

    private Set<Long> getFlushableBuckets(boolean z) {
        if (z) {
            return this.buckets.keySet();
        }
        return this.buckets.headMap(Long.valueOf(MetricsHelper.getTimeBucketKey(MetricsHelper.getCutoffTimestampMs(nowMillis()))), true).keySet();
    }

    private Map<String, Metric> getOrAddTimeBucket(long j) {
        Map<String, Metric> map = (Map) this.buckets.get(Long.valueOf(j));
        if (map == null) {
            synchronized (this.buckets) {
                map = (Map) this.buckets.get(Long.valueOf(j));
                if (map == null) {
                    map = new HashMap<>();
                    this.buckets.put(Long.valueOf(j), map);
                }
            }
        }
        return map;
    }

    public void close() throws IOException {
        synchronized (this) {
            this.isClosed = true;
            this.executorService.close(0);
        }
        flush(true);
    }

    public void run() {
        flush(false);
        synchronized (this) {
            if (!this.isClosed) {
                this.executorService.schedule(this, 5000);
            }
        }
    }

    private long nowMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.dateProvider.now().nanoTimestamp());
    }
}
