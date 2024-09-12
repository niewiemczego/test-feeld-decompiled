package io.sentry;

import io.sentry.exception.InvalidSentryTraceHeaderException;
import io.sentry.protocol.SentryId;
import java.util.Arrays;
import java.util.List;

public final class PropagationContext {
    private Baggage baggage;
    private SpanId parentSpanId;
    private Boolean sampled;
    private SpanId spanId;
    private SentryId traceId;

    public static PropagationContext fromHeaders(ILogger iLogger, String str, String str2) {
        return fromHeaders(iLogger, str, (List<String>) Arrays.asList(new String[]{str2}));
    }

    public static PropagationContext fromHeaders(ILogger iLogger, String str, List<String> list) {
        if (str == null) {
            return new PropagationContext();
        }
        try {
            return fromHeaders(new SentryTraceHeader(str), Baggage.fromHeader(list, iLogger), (SpanId) null);
        } catch (InvalidSentryTraceHeaderException e) {
            iLogger.log(SentryLevel.DEBUG, e, "Failed to parse Sentry trace header: %s", e.getMessage());
            return new PropagationContext();
        }
    }

    public static PropagationContext fromHeaders(SentryTraceHeader sentryTraceHeader, Baggage baggage2, SpanId spanId2) {
        if (spanId2 == null) {
            spanId2 = new SpanId();
        }
        return new PropagationContext(sentryTraceHeader.getTraceId(), spanId2, sentryTraceHeader.getSpanId(), baggage2, sentryTraceHeader.isSampled());
    }

    public PropagationContext() {
        this(new SentryId(), new SpanId(), (SpanId) null, (Baggage) null, (Boolean) null);
    }

    public PropagationContext(PropagationContext propagationContext) {
        this(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), cloneBaggage(propagationContext.getBaggage()), propagationContext.isSampled());
    }

    private static Baggage cloneBaggage(Baggage baggage2) {
        if (baggage2 != null) {
            return new Baggage(baggage2);
        }
        return null;
    }

    public PropagationContext(SentryId sentryId, SpanId spanId2, SpanId spanId3, Baggage baggage2, Boolean bool) {
        this.traceId = sentryId;
        this.spanId = spanId2;
        this.parentSpanId = spanId3;
        this.baggage = baggage2;
        this.sampled = bool;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public void setTraceId(SentryId sentryId) {
        this.traceId = sentryId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public void setSpanId(SpanId spanId2) {
        this.spanId = spanId2;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public void setParentSpanId(SpanId spanId2) {
        this.parentSpanId = spanId2;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public void setBaggage(Baggage baggage2) {
        this.baggage = baggage2;
    }

    public Boolean isSampled() {
        return this.sampled;
    }

    public void setSampled(Boolean bool) {
        this.sampled = bool;
    }

    public TraceContext traceContext() {
        Baggage baggage2 = this.baggage;
        if (baggage2 != null) {
            return baggage2.toTraceContext();
        }
        return null;
    }
}
