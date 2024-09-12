package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.Objects;

public final class TransactionContext extends SpanContext {
    private static final String DEFAULT_NAME = "<unlabeled transaction>";
    private static final TransactionNameSource DEFAULT_NAME_SOURCE = TransactionNameSource.CUSTOM;
    private static final String DEFAULT_OPERATION = "default";
    private Baggage baggage;
    private Instrumenter instrumenter;
    private boolean isForNextAppStart;
    private String name;
    private TracesSamplingDecision parentSamplingDecision;
    private TransactionNameSource transactionNameSource;

    @Deprecated
    public static TransactionContext fromSentryTrace(String str, String str2, SentryTraceHeader sentryTraceHeader) {
        TracesSamplingDecision tracesSamplingDecision;
        Boolean isSampled = sentryTraceHeader.isSampled();
        if (isSampled == null) {
            tracesSamplingDecision = null;
        } else {
            tracesSamplingDecision = new TracesSamplingDecision(isSampled);
        }
        TransactionContext transactionContext = new TransactionContext(sentryTraceHeader.getTraceId(), new SpanId(), sentryTraceHeader.getSpanId(), tracesSamplingDecision, (Baggage) null);
        transactionContext.setName(str);
        transactionContext.setTransactionNameSource(TransactionNameSource.CUSTOM);
        transactionContext.setOperation(str2);
        return transactionContext;
    }

    public static TransactionContext fromPropagationContext(PropagationContext propagationContext) {
        TracesSamplingDecision tracesSamplingDecision;
        TracesSamplingDecision tracesSamplingDecision2;
        Boolean isSampled = propagationContext.isSampled();
        if (isSampled == null) {
            tracesSamplingDecision = null;
        } else {
            tracesSamplingDecision = new TracesSamplingDecision(isSampled);
        }
        Baggage baggage2 = propagationContext.getBaggage();
        if (baggage2 != null) {
            baggage2.freeze();
            Double sampleRateDouble = baggage2.getSampleRateDouble();
            Boolean valueOf = Boolean.valueOf(isSampled != null ? isSampled.booleanValue() : false);
            if (sampleRateDouble != null) {
                tracesSamplingDecision2 = new TracesSamplingDecision(valueOf, sampleRateDouble);
                return new TransactionContext(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), tracesSamplingDecision2, baggage2);
            }
            tracesSamplingDecision = new TracesSamplingDecision(valueOf);
        }
        tracesSamplingDecision2 = tracesSamplingDecision;
        return new TransactionContext(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), tracesSamplingDecision2, baggage2);
    }

    public TransactionContext(String str, String str2) {
        this(str, str2, (TracesSamplingDecision) null);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource2, String str2) {
        this(str, transactionNameSource2, str2, (TracesSamplingDecision) null);
    }

    public TransactionContext(String str, String str2, TracesSamplingDecision tracesSamplingDecision) {
        this(str, TransactionNameSource.CUSTOM, str2, tracesSamplingDecision);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource2, String str2, TracesSamplingDecision tracesSamplingDecision) {
        super(str2);
        this.instrumenter = Instrumenter.SENTRY;
        this.isForNextAppStart = false;
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.transactionNameSource = transactionNameSource2;
        setSamplingDecision(tracesSamplingDecision);
    }

    public TransactionContext(SentryId sentryId, SpanId spanId, SpanId spanId2, TracesSamplingDecision tracesSamplingDecision, Baggage baggage2) {
        super(sentryId, spanId, "default", spanId2, (TracesSamplingDecision) null);
        this.instrumenter = Instrumenter.SENTRY;
        this.isForNextAppStart = false;
        this.name = DEFAULT_NAME;
        this.parentSamplingDecision = tracesSamplingDecision;
        this.transactionNameSource = DEFAULT_NAME_SOURCE;
        this.baggage = baggage2;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getParentSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.parentSamplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    public TracesSamplingDecision getParentSamplingDecision() {
        return this.parentSamplingDecision;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public void setParentSampled(Boolean bool) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        }
    }

    public void setParentSampled(Boolean bool, Boolean bool2) {
        if (bool == null) {
            this.parentSamplingDecision = null;
        } else if (bool2 == null) {
            this.parentSamplingDecision = new TracesSamplingDecision(bool);
        } else {
            this.parentSamplingDecision = new TracesSamplingDecision(bool, (Double) null, bool2, (Double) null);
        }
    }

    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public void setInstrumenter(Instrumenter instrumenter2) {
        this.instrumenter = instrumenter2;
    }

    public void setName(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required");
    }

    public void setTransactionNameSource(TransactionNameSource transactionNameSource2) {
        this.transactionNameSource = transactionNameSource2;
    }

    public void setForNextAppStart(boolean z) {
        this.isForNextAppStart = z;
    }

    public boolean isForNextAppStart() {
        return this.isForNextAppStart;
    }
}
