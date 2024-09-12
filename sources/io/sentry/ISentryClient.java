package io.sentry;

import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

public interface ISentryClient {
    SentryId captureCheckIn(CheckIn checkIn, IScope iScope, Hint hint);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint);

    SentryId captureEvent(SentryEvent sentryEvent, IScope iScope, Hint hint);

    void captureSession(Session session, Hint hint);

    SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, IScope iScope, Hint hint, ProfilingTraceData profilingTraceData);

    void captureUserFeedback(UserFeedback userFeedback);

    void close();

    void close(boolean z);

    void flush(long j);

    IMetricsAggregator getMetricsAggregator();

    RateLimiter getRateLimiter();

    boolean isEnabled();

    boolean isHealthy() {
        return true;
    }

    SentryId captureEvent(SentryEvent sentryEvent) {
        return captureEvent(sentryEvent, (IScope) null, (Hint) null);
    }

    SentryId captureEvent(SentryEvent sentryEvent, IScope iScope) {
        return captureEvent(sentryEvent, iScope, (Hint) null);
    }

    SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return captureEvent(sentryEvent, (IScope) null, hint);
    }

    SentryId captureMessage(String str, SentryLevel sentryLevel, IScope iScope) {
        SentryEvent sentryEvent = new SentryEvent();
        Message message = new Message();
        message.setFormatted(str);
        sentryEvent.setMessage(message);
        sentryEvent.setLevel(sentryLevel);
        return captureEvent(sentryEvent, iScope);
    }

    SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return captureMessage(str, sentryLevel, (IScope) null);
    }

    SentryId captureException(Throwable th) {
        return captureException(th, (IScope) null, (Hint) null);
    }

    SentryId captureException(Throwable th, IScope iScope, Hint hint) {
        return captureEvent(new SentryEvent(th), iScope, hint);
    }

    SentryId captureException(Throwable th, Hint hint) {
        return captureException(th, (IScope) null, hint);
    }

    SentryId captureException(Throwable th, IScope iScope) {
        return captureException(th, iScope, (Hint) null);
    }

    void captureSession(Session session) {
        captureSession(session, (Hint) null);
    }

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return captureEnvelope(sentryEnvelope, (Hint) null);
    }

    SentryId captureTransaction(SentryTransaction sentryTransaction, IScope iScope, Hint hint) {
        return captureTransaction(sentryTransaction, (TraceContext) null, iScope, hint);
    }

    SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, IScope iScope, Hint hint) {
        return captureTransaction(sentryTransaction, traceContext, iScope, hint, (ProfilingTraceData) null);
    }

    SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext) {
        return captureTransaction(sentryTransaction, traceContext, (IScope) null, (Hint) null);
    }

    SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return captureTransaction(sentryTransaction, (TraceContext) null, (IScope) null, (Hint) null);
    }
}
