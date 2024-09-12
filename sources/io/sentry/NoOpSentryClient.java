package io.sentry;

import io.sentry.metrics.NoopMetricsAggregator;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

final class NoOpSentryClient implements ISentryClient {
    private static final NoOpSentryClient instance = new NoOpSentryClient();

    public void captureSession(Session session, Hint hint) {
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
    }

    public void close() {
    }

    public void close(boolean z) {
    }

    public void flush(long j) {
    }

    public RateLimiter getRateLimiter() {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    private NoOpSentryClient() {
    }

    public static NoOpSentryClient getInstance() {
        return instance;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, IScope iScope, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, IScope iScope, Hint hint, ProfilingTraceData profilingTraceData) {
        return SentryId.EMPTY_ID;
    }

    public SentryId captureCheckIn(CheckIn checkIn, IScope iScope, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    public IMetricsAggregator getMetricsAggregator() {
        return NoopMetricsAggregator.getInstance();
    }
}
