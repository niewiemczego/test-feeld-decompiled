package io.sentry;

import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.protocol.SentryId;
import java.util.List;

public final class NoOpSpan implements ISpan {
    private static final NoOpSpan instance = new NoOpSpan();

    public void finish() {
    }

    public void finish(SpanStatus spanStatus) {
    }

    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
    }

    public Object getData(String str) {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public LocalMetricsAggregator getLocalMetricsAggregator() {
        return null;
    }

    public String getOperation() {
        return "";
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
        return false;
    }

    public boolean isNoOp() {
        return true;
    }

    public void setData(String str, Object obj) {
    }

    public void setDescription(String str) {
    }

    public void setMeasurement(String str, Number number) {
    }

    public void setMeasurement(String str, Number number, MeasurementUnit measurementUnit) {
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

    private NoOpSpan() {
    }

    public static NoOpSpan getInstance() {
        return instance;
    }

    public ISpan startChild(String str) {
        return getInstance();
    }

    public ISpan startChild(String str, String str2, SpanOptions spanOptions) {
        return getInstance();
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        return getInstance();
    }

    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter, SpanOptions spanOptions) {
        return getInstance();
    }

    public ISpan startChild(String str, String str2) {
        return getInstance();
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

    public SentryDate getStartDate() {
        return new SentryNanotimeDate();
    }

    public SentryDate getFinishDate() {
        return new SentryNanotimeDate();
    }
}
