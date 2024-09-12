package io.sentry;

import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import java.util.Collections;
import java.util.List;

public final class NoOpTransaction implements ITransaction {
    private static final NoOpTransaction instance = new NoOpTransaction();

    public void finish() {
    }

    public void finish(SpanStatus spanStatus) {
    }

    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
    }

    public void finish(SpanStatus spanStatus, SentryDate sentryDate, boolean z, Hint hint) {
    }

    public void forceFinish(SpanStatus spanStatus, boolean z, Hint hint) {
    }

    public Object getData(String str) {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public Span getLatestActiveSpan() {
        return null;
    }

    public LocalMetricsAggregator getLocalMetricsAggregator() {
        return null;
    }

    public String getName() {
        return "";
    }

    public String getOperation() {
        return "";
    }

    public TracesSamplingDecision getSamplingDecision() {
        return null;
    }

    public SpanStatus getStatus() {
        return null;
    }

    public String getTag(String str) {
        return null;
    }

    public Throwable getThrowable() {
        return null;
    }

    public boolean isFinished() {
        return true;
    }

    public boolean isNoOp() {
        return true;
    }

    public Boolean isProfileSampled() {
        return null;
    }

    public Boolean isSampled() {
        return null;
    }

    public void scheduleFinish() {
    }

    public void setContext(String str, Object obj) {
    }

    public void setData(String str, Object obj) {
    }

    public void setDescription(String str) {
    }

    public void setMeasurement(String str, Number number) {
    }

    public void setMeasurement(String str, Number number, MeasurementUnit measurementUnit) {
    }

    public void setName(String str) {
    }

    public void setName(String str, TransactionNameSource transactionNameSource) {
    }

    public void setOperation(String str) {
    }

    public void setStatus(SpanStatus spanStatus) {
    }

    public void setTag(String str, String str2) {
    }

    public void setThrowable(Throwable th) {
    }

    public BaggageHeader toBaggageHeader(List<String> list) {
        return null;
    }

    public boolean updateEndDate(SentryDate sentryDate) {
        return false;
    }

    private NoOpTransaction() {
    }

    public static NoOpTransaction getInstance() {
        return instance;
    }

    public TransactionNameSource getTransactionNameSource() {
        return TransactionNameSource.CUSTOM;
    }

    public ISpan startChild(String str) {
        return NoOpSpan.getInstance();
    }

    public ISpan startChild(String str, String str2, SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        return NoOpSpan.getInstance();
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter, SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    public ISpan startChild(String str, String str2) {
        return NoOpSpan.getInstance();
    }

    public List<Span> getSpans() {
        return Collections.emptyList();
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate) {
        return NoOpSpan.getInstance();
    }

    public SentryId getEventId() {
        return SentryId.EMPTY_ID;
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, false);
    }

    public TraceContext traceContext() {
        return new TraceContext(SentryId.EMPTY_ID, "");
    }

    public SpanContext getSpanContext() {
        return new SpanContext(SentryId.EMPTY_ID, SpanId.EMPTY_ID, "op", (SpanId) null, (TracesSamplingDecision) null);
    }

    public Contexts getContexts() {
        return new Contexts();
    }

    public SentryDate getStartDate() {
        return new SentryNanotimeDate();
    }

    public SentryDate getFinishDate() {
        return new SentryNanotimeDate();
    }
}
