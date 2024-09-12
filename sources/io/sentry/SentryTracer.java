package io.sentry;

import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.User;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SentryTracer implements ITransaction {
    private final Baggage baggage;
    private final List<Span> children;
    private final Contexts contexts;
    private volatile TimerTask deadlineTimeoutTask;
    private final SentryId eventId;
    private FinishStatus finishStatus;
    private final IHub hub;
    private volatile TimerTask idleTimeoutTask;
    private final Instrumenter instrumenter;
    private final AtomicBoolean isDeadlineTimerRunning;
    private final AtomicBoolean isIdleFinishTimerRunning;
    private String name;
    private final Span root;
    private volatile Timer timer;
    private final Object timerLock;
    private TransactionNameSource transactionNameSource;
    private final TransactionOptions transactionOptions;
    private final TransactionPerformanceCollector transactionPerformanceCollector;

    public boolean isNoOp() {
        return false;
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub) {
        this(transactionContext, iHub, new TransactionOptions(), (TransactionPerformanceCollector) null);
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub, TransactionOptions transactionOptions2) {
        this(transactionContext, iHub, transactionOptions2, (TransactionPerformanceCollector) null);
    }

    SentryTracer(TransactionContext transactionContext, IHub iHub, TransactionOptions transactionOptions2, TransactionPerformanceCollector transactionPerformanceCollector2) {
        this.eventId = new SentryId();
        this.children = new CopyOnWriteArrayList();
        this.finishStatus = FinishStatus.NOT_FINISHED;
        this.timer = null;
        this.timerLock = new Object();
        this.isIdleFinishTimerRunning = new AtomicBoolean(false);
        this.isDeadlineTimerRunning = new AtomicBoolean(false);
        this.contexts = new Contexts();
        Objects.requireNonNull(transactionContext, "context is required");
        Objects.requireNonNull(iHub, "hub is required");
        this.root = new Span(transactionContext, this, iHub, transactionOptions2.getStartTimestamp(), (SpanOptions) transactionOptions2);
        this.name = transactionContext.getName();
        this.instrumenter = transactionContext.getInstrumenter();
        this.hub = iHub;
        this.transactionPerformanceCollector = transactionPerformanceCollector2;
        this.transactionNameSource = transactionContext.getTransactionNameSource();
        this.transactionOptions = transactionOptions2;
        if (transactionContext.getBaggage() != null) {
            this.baggage = transactionContext.getBaggage();
        } else {
            this.baggage = new Baggage(iHub.getOptions().getLogger());
        }
        if (transactionPerformanceCollector2 != null && Boolean.TRUE.equals(isProfileSampled())) {
            transactionPerformanceCollector2.start(this);
        }
        if (transactionOptions2.getIdleTimeout() != null || transactionOptions2.getDeadlineTimeout() != null) {
            this.timer = new Timer(true);
            scheduleDeadlineTimeout();
            scheduleFinish();
        }
    }

    public void scheduleFinish() {
        Long idleTimeout;
        synchronized (this.timerLock) {
            if (!(this.timer == null || (idleTimeout = this.transactionOptions.getIdleTimeout()) == null)) {
                cancelIdleTimer();
                this.isIdleFinishTimerRunning.set(true);
                this.idleTimeoutTask = new TimerTask() {
                    public void run() {
                        SentryTracer.this.onIdleTimeoutReached();
                    }
                };
                try {
                    this.timer.schedule(this.idleTimeoutTask, idleTimeout.longValue());
                } catch (Throwable th) {
                    this.hub.getOptions().getLogger().log(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                    onIdleTimeoutReached();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onIdleTimeoutReached() {
        SpanStatus status = getStatus();
        if (status == null) {
            status = SpanStatus.OK;
        }
        finish(status);
        this.isIdleFinishTimerRunning.set(false);
    }

    /* access modifiers changed from: private */
    public void onDeadlineTimeoutReached() {
        SpanStatus status = getStatus();
        if (status == null) {
            status = SpanStatus.DEADLINE_EXCEEDED;
        }
        forceFinish(status, this.transactionOptions.getIdleTimeout() != null, (Hint) null);
        this.isDeadlineTimerRunning.set(false);
    }

    public void forceFinish(SpanStatus spanStatus, boolean z, Hint hint) {
        if (!isFinished()) {
            SentryDate now = this.hub.getOptions().getDateProvider().now();
            List<Span> list = this.children;
            ListIterator<Span> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                Span previous = listIterator.previous();
                previous.setSpanFinishedCallback((SpanFinishedCallback) null);
                previous.finish(spanStatus, now);
            }
            finish(spanStatus, now, z, hint);
        }
    }

    public void finish(SpanStatus spanStatus, SentryDate sentryDate, boolean z, Hint hint) {
        SpanStatus spanStatus2;
        SentryDate finishDate = this.root.getFinishDate();
        if (sentryDate == null) {
            sentryDate = finishDate;
        }
        if (sentryDate == null) {
            sentryDate = this.hub.getOptions().getDateProvider().now();
        }
        for (Span next : this.children) {
            if (next.getOptions().isIdle()) {
                if (spanStatus != null) {
                    spanStatus2 = spanStatus;
                } else {
                    spanStatus2 = getSpanContext().status;
                }
                next.finish(spanStatus2, sentryDate);
            }
        }
        this.finishStatus = FinishStatus.finishing(spanStatus);
        if (this.root.isFinished()) {
            return;
        }
        if (!this.transactionOptions.isWaitForChildren() || hasAllChildrenFinished()) {
            TransactionPerformanceCollector transactionPerformanceCollector2 = this.transactionPerformanceCollector;
            List<PerformanceCollectionData> stop = transactionPerformanceCollector2 != null ? transactionPerformanceCollector2.stop(this) : null;
            ProfilingTraceData onTransactionFinish = (!Boolean.TRUE.equals(isSampled()) || !Boolean.TRUE.equals(isProfileSampled())) ? null : this.hub.getOptions().getTransactionProfiler().onTransactionFinish(this, stop, this.hub.getOptions());
            if (stop != null) {
                stop.clear();
            }
            this.root.finish(this.finishStatus.spanStatus, sentryDate);
            this.hub.configureScope(new SentryTracer$$ExternalSyntheticLambda0(this));
            SentryTransaction sentryTransaction = new SentryTransaction(this);
            TransactionFinishedCallback transactionFinishedCallback = this.transactionOptions.getTransactionFinishedCallback();
            if (transactionFinishedCallback != null) {
                transactionFinishedCallback.execute(this);
            }
            if (this.timer != null) {
                synchronized (this.timerLock) {
                    if (this.timer != null) {
                        cancelIdleTimer();
                        cancelDeadlineTimer();
                        this.timer.cancel();
                        this.timer = null;
                    }
                }
            }
            if (!z || !this.children.isEmpty() || this.transactionOptions.getIdleTimeout() == null) {
                sentryTransaction.getMeasurements().putAll(this.root.getMeasurements());
                this.hub.captureTransaction(sentryTransaction, traceContext(), hint, onTransactionFinish);
                return;
            }
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "Dropping idle transaction %s because it has no child spans", this.name);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$finish$1$io-sentry-SentryTracer  reason: not valid java name */
    public /* synthetic */ void m879lambda$finish$1$iosentrySentryTracer(IScope iScope) {
        iScope.withTransaction(new SentryTracer$$ExternalSyntheticLambda2(this, iScope));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$finish$0$io-sentry-SentryTracer  reason: not valid java name */
    public /* synthetic */ void m878lambda$finish$0$iosentrySentryTracer(IScope iScope, ITransaction iTransaction) {
        if (iTransaction == this) {
            iScope.clearTransaction();
        }
    }

    private void cancelIdleTimer() {
        synchronized (this.timerLock) {
            if (this.idleTimeoutTask != null) {
                this.idleTimeoutTask.cancel();
                this.isIdleFinishTimerRunning.set(false);
                this.idleTimeoutTask = null;
            }
        }
    }

    private void scheduleDeadlineTimeout() {
        Long deadlineTimeout = this.transactionOptions.getDeadlineTimeout();
        if (deadlineTimeout != null) {
            synchronized (this.timerLock) {
                if (this.timer != null) {
                    cancelDeadlineTimer();
                    this.isDeadlineTimerRunning.set(true);
                    this.deadlineTimeoutTask = new TimerTask() {
                        public void run() {
                            SentryTracer.this.onDeadlineTimeoutReached();
                        }
                    };
                    try {
                        this.timer.schedule(this.deadlineTimeoutTask, deadlineTimeout.longValue());
                    } catch (Throwable th) {
                        this.hub.getOptions().getLogger().log(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                        onDeadlineTimeoutReached();
                    }
                }
            }
        }
    }

    private void cancelDeadlineTimer() {
        synchronized (this.timerLock) {
            if (this.deadlineTimeoutTask != null) {
                this.deadlineTimeoutTask.cancel();
                this.isDeadlineTimerRunning.set(false);
                this.deadlineTimeoutTask = null;
            }
        }
    }

    public List<Span> getChildren() {
        return this.children;
    }

    public SentryDate getStartDate() {
        return this.root.getStartDate();
    }

    public SentryDate getFinishDate() {
        return this.root.getFinishDate();
    }

    /* access modifiers changed from: package-private */
    public ISpan startChild(SpanId spanId, String str, String str2) {
        return startChild(spanId, str, str2, new SpanOptions());
    }

    /* access modifiers changed from: package-private */
    public ISpan startChild(SpanId spanId, String str, String str2, SpanOptions spanOptions) {
        return createChild(spanId, str, str2, spanOptions);
    }

    /* access modifiers changed from: package-private */
    public ISpan startChild(SpanId spanId, String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2) {
        return createChild(spanId, str, str2, sentryDate, instrumenter2, new SpanOptions());
    }

    /* access modifiers changed from: package-private */
    public ISpan startChild(SpanId spanId, String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2, SpanOptions spanOptions) {
        return createChild(spanId, str, str2, sentryDate, instrumenter2, spanOptions);
    }

    private ISpan createChild(SpanId spanId, String str, String str2, SpanOptions spanOptions) {
        return createChild(spanId, str, str2, (SentryDate) null, Instrumenter.SENTRY, spanOptions);
    }

    private ISpan createChild(SpanId spanId, String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2, SpanOptions spanOptions) {
        String str3;
        if (this.root.isFinished()) {
            return NoOpSpan.getInstance();
        }
        if (!this.instrumenter.equals(instrumenter2)) {
            return NoOpSpan.getInstance();
        }
        if (this.children.size() < this.hub.getOptions().getMaxSpans()) {
            Objects.requireNonNull(spanId, "parentSpanId is required");
            Objects.requireNonNull(str, "operation is required");
            cancelIdleTimer();
            Span span = new Span(this.root.getTraceId(), spanId, this, str, this.hub, sentryDate, spanOptions, new SentryTracer$$ExternalSyntheticLambda1(this));
            span.setDescription(str2);
            span.setData(SpanDataConvention.THREAD_ID, String.valueOf(Thread.currentThread().getId()));
            if (this.hub.getOptions().getMainThreadChecker().isMainThread()) {
                str3 = SentryThread.JsonKeys.MAIN;
            } else {
                str3 = Thread.currentThread().getName();
            }
            span.setData(SpanDataConvention.THREAD_NAME, str3);
            this.children.add(span);
            TransactionPerformanceCollector transactionPerformanceCollector2 = this.transactionPerformanceCollector;
            if (transactionPerformanceCollector2 != null) {
                transactionPerformanceCollector2.onSpanStarted(span);
            }
            return span;
        }
        this.hub.getOptions().getLogger().log(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return NoOpSpan.getInstance();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createChild$2$io-sentry-SentryTracer  reason: not valid java name */
    public /* synthetic */ void m877lambda$createChild$2$iosentrySentryTracer(Span span) {
        TransactionPerformanceCollector transactionPerformanceCollector2 = this.transactionPerformanceCollector;
        if (transactionPerformanceCollector2 != null) {
            transactionPerformanceCollector2.onSpanFinished(span);
        }
        FinishStatus finishStatus2 = this.finishStatus;
        if (this.transactionOptions.getIdleTimeout() != null) {
            if (!this.transactionOptions.isWaitForChildren() || hasAllChildrenFinished()) {
                scheduleFinish();
            }
        } else if (finishStatus2.isFinishing) {
            finish(finishStatus2.spanStatus);
        }
    }

    public ISpan startChild(String str) {
        String str2 = null;
        return startChild(str, (String) null);
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2) {
        return startChild(str, str2, sentryDate, instrumenter2, new SpanOptions());
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2, SpanOptions spanOptions) {
        return createChild(str, str2, sentryDate, instrumenter2, spanOptions);
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate) {
        return createChild(str, str2, sentryDate, Instrumenter.SENTRY, new SpanOptions());
    }

    public ISpan startChild(String str, String str2) {
        return startChild(str, str2, (SentryDate) null, Instrumenter.SENTRY, new SpanOptions());
    }

    public ISpan startChild(String str, String str2, SpanOptions spanOptions) {
        return createChild(str, str2, (SentryDate) null, Instrumenter.SENTRY, spanOptions);
    }

    private ISpan createChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter2, SpanOptions spanOptions) {
        if (this.root.isFinished()) {
            return NoOpSpan.getInstance();
        }
        if (!this.instrumenter.equals(instrumenter2)) {
            return NoOpSpan.getInstance();
        }
        if (this.children.size() < this.hub.getOptions().getMaxSpans()) {
            return this.root.startChild(str, str2, sentryDate, instrumenter2, spanOptions);
        }
        this.hub.getOptions().getLogger().log(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return NoOpSpan.getInstance();
    }

    public SentryTraceHeader toSentryTrace() {
        return this.root.toSentryTrace();
    }

    public void finish() {
        finish(getStatus());
    }

    public void finish(SpanStatus spanStatus) {
        finish(spanStatus, (SentryDate) null);
    }

    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
        finish(spanStatus, sentryDate, true, (Hint) null);
    }

    public TraceContext traceContext() {
        if (!this.hub.getOptions().isTraceSampling()) {
            return null;
        }
        updateBaggageValues();
        return this.baggage.toTraceContext();
    }

    private void updateBaggageValues() {
        synchronized (this) {
            if (this.baggage.isMutable()) {
                AtomicReference atomicReference = new AtomicReference();
                this.hub.configureScope(new SentryTracer$$ExternalSyntheticLambda3(atomicReference));
                this.baggage.setValuesFromTransaction(this, (User) atomicReference.get(), this.hub.getOptions(), getSamplingDecision());
                this.baggage.freeze();
            }
        }
    }

    public BaggageHeader toBaggageHeader(List<String> list) {
        if (!this.hub.getOptions().isTraceSampling()) {
            return null;
        }
        updateBaggageValues();
        return BaggageHeader.fromBaggageAndOutgoingHeader(this.baggage, list);
    }

    private boolean hasAllChildrenFinished() {
        ArrayList<Span> arrayList = new ArrayList<>(this.children);
        if (arrayList.isEmpty()) {
            return true;
        }
        for (Span isFinished : arrayList) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public void setOperation(String str) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Operation %s cannot be set", str);
            return;
        }
        this.root.setOperation(str);
    }

    public String getOperation() {
        return this.root.getOperation();
    }

    public void setDescription(String str) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
            return;
        }
        this.root.setDescription(str);
    }

    public String getDescription() {
        return this.root.getDescription();
    }

    public void setStatus(SpanStatus spanStatus) {
        String str;
        if (this.root.isFinished()) {
            ILogger logger = this.hub.getOptions().getLogger();
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            Object[] objArr = new Object[1];
            if (spanStatus == null) {
                str = "null";
            } else {
                str = spanStatus.name();
            }
            objArr[0] = str;
            logger.log(sentryLevel, "The transaction is already finished. Status %s cannot be set", objArr);
            return;
        }
        this.root.setStatus(spanStatus);
    }

    public SpanStatus getStatus() {
        return this.root.getStatus();
    }

    public void setThrowable(Throwable th) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Throwable cannot be set", new Object[0]);
        } else {
            this.root.setThrowable(th);
        }
    }

    public Throwable getThrowable() {
        return this.root.getThrowable();
    }

    public SpanContext getSpanContext() {
        return this.root.getSpanContext();
    }

    public void setTag(String str, String str2) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Tag %s cannot be set", str);
            return;
        }
        this.root.setTag(str, str2);
    }

    public String getTag(String str) {
        return this.root.getTag(str);
    }

    public boolean isFinished() {
        return this.root.isFinished();
    }

    public void setData(String str, Object obj) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
            return;
        }
        this.root.setData(str, obj);
    }

    public Object getData(String str) {
        return this.root.getData(str);
    }

    public void setMeasurementFromChild(String str, Number number) {
        if (!this.root.getMeasurements().containsKey(str)) {
            setMeasurement(str, number);
        }
    }

    public void setMeasurementFromChild(String str, Number number, MeasurementUnit measurementUnit) {
        if (!this.root.getMeasurements().containsKey(str)) {
            setMeasurement(str, number, measurementUnit);
        }
    }

    public void setMeasurement(String str, Number number) {
        this.root.setMeasurement(str, number);
    }

    public void setMeasurement(String str, Number number, MeasurementUnit measurementUnit) {
        this.root.setMeasurement(str, number, measurementUnit);
    }

    public Map<String, Object> getData() {
        return this.root.getData();
    }

    public Boolean isSampled() {
        return this.root.isSampled();
    }

    public Boolean isProfileSampled() {
        return this.root.isProfileSampled();
    }

    public TracesSamplingDecision getSamplingDecision() {
        return this.root.getSamplingDecision();
    }

    public void setName(String str) {
        setName(str, TransactionNameSource.CUSTOM);
    }

    public void setName(String str, TransactionNameSource transactionNameSource2) {
        if (this.root.isFinished()) {
            this.hub.getOptions().getLogger().log(SentryLevel.DEBUG, "The transaction is already finished. Name %s cannot be set", str);
            return;
        }
        this.name = str;
        this.transactionNameSource = transactionNameSource2;
    }

    public String getName() {
        return this.name;
    }

    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    public List<Span> getSpans() {
        return this.children;
    }

    public Span getLatestActiveSpan() {
        ArrayList arrayList = new ArrayList(this.children);
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((Span) arrayList.get(size)).isFinished()) {
                return (Span) arrayList.get(size);
            }
        }
        return null;
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    /* access modifiers changed from: package-private */
    public Span getRoot() {
        return this.root;
    }

    /* access modifiers changed from: package-private */
    public TimerTask getIdleTimeoutTask() {
        return this.idleTimeoutTask;
    }

    /* access modifiers changed from: package-private */
    public TimerTask getDeadlineTimeoutTask() {
        return this.deadlineTimeoutTask;
    }

    /* access modifiers changed from: package-private */
    public Timer getTimer() {
        return this.timer;
    }

    /* access modifiers changed from: package-private */
    public AtomicBoolean isFinishTimerRunning() {
        return this.isIdleFinishTimerRunning;
    }

    /* access modifiers changed from: package-private */
    public AtomicBoolean isDeadlineTimerRunning() {
        return this.isDeadlineTimerRunning;
    }

    public void setContext(String str, Object obj) {
        this.contexts.put(str, obj);
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public boolean updateEndDate(SentryDate sentryDate) {
        return this.root.updateEndDate(sentryDate);
    }

    public LocalMetricsAggregator getLocalMetricsAggregator() {
        return this.root.getLocalMetricsAggregator();
    }

    private static final class FinishStatus {
        static final FinishStatus NOT_FINISHED = notFinished();
        /* access modifiers changed from: private */
        public final boolean isFinishing;
        /* access modifiers changed from: private */
        public final SpanStatus spanStatus;

        static FinishStatus finishing(SpanStatus spanStatus2) {
            return new FinishStatus(true, spanStatus2);
        }

        private static FinishStatus notFinished() {
            return new FinishStatus(false, (SpanStatus) null);
        }

        private FinishStatus(boolean z, SpanStatus spanStatus2) {
            this.isFinishing = z;
            this.spanStatus = spanStatus2;
        }
    }
}
