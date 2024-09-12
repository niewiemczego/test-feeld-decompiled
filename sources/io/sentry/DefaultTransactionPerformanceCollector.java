package io.sentry;

import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DefaultTransactionPerformanceCollector implements TransactionPerformanceCollector {
    private static final long TRANSACTION_COLLECTION_INTERVAL_MILLIS = 100;
    private static final long TRANSACTION_COLLECTION_TIMEOUT_MILLIS = 30000;
    private final List<IPerformanceContinuousCollector> continuousCollectors;
    private final boolean hasNoCollectors;
    private final AtomicBoolean isStarted;
    /* access modifiers changed from: private */
    public long lastCollectionTimestamp;
    private final SentryOptions options;
    /* access modifiers changed from: private */
    public final Map<String, List<PerformanceCollectionData>> performanceDataMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final List<IPerformanceSnapshotCollector> snapshotCollectors;
    private volatile Timer timer = null;
    private final Object timerLock = new Object();

    public DefaultTransactionPerformanceCollector(SentryOptions sentryOptions) {
        boolean z = false;
        this.isStarted = new AtomicBoolean(false);
        this.lastCollectionTimestamp = 0;
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "The options object is required.");
        this.snapshotCollectors = new ArrayList();
        this.continuousCollectors = new ArrayList();
        for (IPerformanceCollector next : sentryOptions.getPerformanceCollectors()) {
            if (next instanceof IPerformanceSnapshotCollector) {
                this.snapshotCollectors.add((IPerformanceSnapshotCollector) next);
            }
            if (next instanceof IPerformanceContinuousCollector) {
                this.continuousCollectors.add((IPerformanceContinuousCollector) next);
            }
        }
        if (this.snapshotCollectors.isEmpty() && this.continuousCollectors.isEmpty()) {
            z = true;
        }
        this.hasNoCollectors = z;
    }

    public void start(ITransaction iTransaction) {
        if (this.hasNoCollectors) {
            this.options.getLogger().log(SentryLevel.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        for (IPerformanceContinuousCollector onSpanStarted : this.continuousCollectors) {
            onSpanStarted.onSpanStarted(iTransaction);
        }
        if (!this.performanceDataMap.containsKey(iTransaction.getEventId().toString())) {
            this.performanceDataMap.put(iTransaction.getEventId().toString(), new ArrayList());
            try {
                this.options.getExecutorService().schedule(new DefaultTransactionPerformanceCollector$$ExternalSyntheticLambda0(this, iTransaction), 30000);
            } catch (RejectedExecutionException e) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", (Throwable) e);
            }
        }
        if (!this.isStarted.getAndSet(true)) {
            synchronized (this.timerLock) {
                if (this.timer == null) {
                    this.timer = new Timer(true);
                }
                this.timer.schedule(new TimerTask() {
                    public void run() {
                        for (IPerformanceSnapshotCollector upVar : DefaultTransactionPerformanceCollector.this.snapshotCollectors) {
                            upVar.setup();
                        }
                    }
                }, 0);
                this.timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - DefaultTransactionPerformanceCollector.this.lastCollectionTimestamp >= 10) {
                            long unused = DefaultTransactionPerformanceCollector.this.lastCollectionTimestamp = currentTimeMillis;
                            PerformanceCollectionData performanceCollectionData = new PerformanceCollectionData();
                            for (IPerformanceSnapshotCollector collect : DefaultTransactionPerformanceCollector.this.snapshotCollectors) {
                                collect.collect(performanceCollectionData);
                            }
                            for (List add : DefaultTransactionPerformanceCollector.this.performanceDataMap.values()) {
                                add.add(performanceCollectionData);
                            }
                        }
                    }
                }, TRANSACTION_COLLECTION_INTERVAL_MILLIS, TRANSACTION_COLLECTION_INTERVAL_MILLIS);
            }
        }
    }

    public void onSpanStarted(ISpan iSpan) {
        for (IPerformanceContinuousCollector onSpanStarted : this.continuousCollectors) {
            onSpanStarted.onSpanStarted(iSpan);
        }
    }

    public void onSpanFinished(ISpan iSpan) {
        for (IPerformanceContinuousCollector onSpanFinished : this.continuousCollectors) {
            onSpanFinished.onSpanFinished(iSpan);
        }
    }

    /* renamed from: stop */
    public List<PerformanceCollectionData> m866lambda$start$0$iosentryDefaultTransactionPerformanceCollector(ITransaction iTransaction) {
        this.options.getLogger().log(SentryLevel.DEBUG, "stop collecting performance info for transactions %s (%s)", iTransaction.getName(), iTransaction.getSpanContext().getTraceId().toString());
        List<PerformanceCollectionData> remove = this.performanceDataMap.remove(iTransaction.getEventId().toString());
        for (IPerformanceContinuousCollector onSpanFinished : this.continuousCollectors) {
            onSpanFinished.onSpanFinished(iTransaction);
        }
        if (this.performanceDataMap.isEmpty()) {
            close();
        }
        return remove;
    }

    public void close() {
        this.options.getLogger().log(SentryLevel.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        this.performanceDataMap.clear();
        for (IPerformanceContinuousCollector clear : this.continuousCollectors) {
            clear.clear();
        }
        if (this.isStarted.getAndSet(false)) {
            synchronized (this.timerLock) {
                if (this.timer != null) {
                    this.timer.cancel();
                    this.timer = null;
                }
            }
        }
    }
}
