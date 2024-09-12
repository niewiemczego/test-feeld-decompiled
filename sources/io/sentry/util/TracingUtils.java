package io.sentry.util;

import io.sentry.Baggage;
import io.sentry.BaggageHeader;
import io.sentry.IHub;
import io.sentry.IScope;
import io.sentry.ISpan;
import io.sentry.PropagationContext;
import io.sentry.SentryOptions;
import io.sentry.SentryTraceHeader;
import java.util.List;

public final class TracingUtils {
    public static void startNewTrace(IHub iHub) {
        iHub.configureScope(new TracingUtils$$ExternalSyntheticLambda1());
    }

    public static TracingHeaders traceIfAllowed(IHub iHub, String str, List<String> list, ISpan iSpan) {
        SentryOptions options = iHub.getOptions();
        if (!options.isTraceSampling() || !shouldAttachTracingHeaders(str, options)) {
            return null;
        }
        return trace(iHub, list, iSpan);
    }

    public static TracingHeaders trace(IHub iHub, List<String> list, ISpan iSpan) {
        SentryOptions options = iHub.getOptions();
        if (iSpan != null && !iSpan.isNoOp()) {
            return new TracingHeaders(iSpan.toSentryTrace(), iSpan.toBaggageHeader(list));
        }
        PropagationContextHolder propagationContextHolder = new PropagationContextHolder();
        iHub.configureScope(new TracingUtils$$ExternalSyntheticLambda3(propagationContextHolder, options));
        if (propagationContextHolder.propagationContext == null) {
            return null;
        }
        PropagationContext access$100 = propagationContextHolder.propagationContext;
        Baggage baggage = access$100.getBaggage();
        return new TracingHeaders(new SentryTraceHeader(access$100.getTraceId(), access$100.getSpanId(), (Boolean) null), baggage != null ? BaggageHeader.fromBaggageAndOutgoingHeader(baggage, list) : null);
    }

    public static PropagationContext maybeUpdateBaggage(IScope iScope, SentryOptions sentryOptions) {
        return iScope.withPropagationContext(new TracingUtils$$ExternalSyntheticLambda2(sentryOptions, iScope));
    }

    static /* synthetic */ void lambda$maybeUpdateBaggage$3(SentryOptions sentryOptions, IScope iScope, PropagationContext propagationContext) {
        Baggage baggage = propagationContext.getBaggage();
        if (baggage == null) {
            baggage = new Baggage(sentryOptions.getLogger());
            propagationContext.setBaggage(baggage);
        }
        if (baggage.isMutable()) {
            baggage.setValuesFromScope(iScope, sentryOptions);
            baggage.freeze();
        }
    }

    private static boolean shouldAttachTracingHeaders(String str, SentryOptions sentryOptions) {
        return PropagationTargetsUtils.contain(sentryOptions.getTracePropagationTargets(), str);
    }

    private static final class PropagationContextHolder {
        /* access modifiers changed from: private */
        public PropagationContext propagationContext;

        private PropagationContextHolder() {
            this.propagationContext = null;
        }
    }

    public static final class TracingHeaders {
        private final BaggageHeader baggageHeader;
        private final SentryTraceHeader sentryTraceHeader;

        public TracingHeaders(SentryTraceHeader sentryTraceHeader2, BaggageHeader baggageHeader2) {
            this.sentryTraceHeader = sentryTraceHeader2;
            this.baggageHeader = baggageHeader2;
        }

        public SentryTraceHeader getSentryTraceHeader() {
            return this.sentryTraceHeader;
        }

        public BaggageHeader getBaggageHeader() {
            return this.baggageHeader;
        }
    }
}
