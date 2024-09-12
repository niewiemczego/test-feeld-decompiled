package io.sentry;

import io.sentry.metrics.MetricsApi;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.transport.RateLimiter;
import java.util.List;

public final class HubAdapter implements IHub {
    private static final HubAdapter INSTANCE = new HubAdapter();

    private HubAdapter() {
    }

    public static HubAdapter getInstance() {
        return INSTANCE;
    }

    public boolean isEnabled() {
        return Sentry.isEnabled();
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return Sentry.captureEvent(sentryEvent, hint);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint, ScopeCallback scopeCallback) {
        return Sentry.captureEvent(sentryEvent, hint, scopeCallback);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return Sentry.captureMessage(str, sentryLevel);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel, ScopeCallback scopeCallback) {
        return Sentry.captureMessage(str, sentryLevel, scopeCallback);
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        return Sentry.getCurrentHub().captureEnvelope(sentryEnvelope, hint);
    }

    public SentryId captureException(Throwable th, Hint hint) {
        return Sentry.captureException(th, hint);
    }

    public SentryId captureException(Throwable th, Hint hint, ScopeCallback scopeCallback) {
        return Sentry.captureException(th, hint, scopeCallback);
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Sentry.captureUserFeedback(userFeedback);
    }

    public void startSession() {
        Sentry.startSession();
    }

    public void endSession() {
        Sentry.endSession();
    }

    public void close(boolean z) {
        Sentry.close();
    }

    public void close() {
        Sentry.close();
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
        Sentry.addBreadcrumb(breadcrumb, hint);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new Hint());
    }

    public void setLevel(SentryLevel sentryLevel) {
        Sentry.setLevel(sentryLevel);
    }

    public void setTransaction(String str) {
        Sentry.setTransaction(str);
    }

    public void setUser(User user) {
        Sentry.setUser(user);
    }

    public void setFingerprint(List<String> list) {
        Sentry.setFingerprint(list);
    }

    public void clearBreadcrumbs() {
        Sentry.clearBreadcrumbs();
    }

    public void setTag(String str, String str2) {
        Sentry.setTag(str, str2);
    }

    public void removeTag(String str) {
        Sentry.removeTag(str);
    }

    public void setExtra(String str, String str2) {
        Sentry.setExtra(str, str2);
    }

    public void removeExtra(String str) {
        Sentry.removeExtra(str);
    }

    public SentryId getLastEventId() {
        return Sentry.getLastEventId();
    }

    public void pushScope() {
        Sentry.pushScope();
    }

    public void popScope() {
        Sentry.popScope();
    }

    public void withScope(ScopeCallback scopeCallback) {
        Sentry.withScope(scopeCallback);
    }

    public void configureScope(ScopeCallback scopeCallback) {
        Sentry.configureScope(scopeCallback);
    }

    public void bindClient(ISentryClient iSentryClient) {
        Sentry.bindClient(iSentryClient);
    }

    public boolean isHealthy() {
        return Sentry.isHealthy();
    }

    public void flush(long j) {
        Sentry.flush(j);
    }

    public IHub clone() {
        return Sentry.getCurrentHub().clone();
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        return Sentry.getCurrentHub().captureTransaction(sentryTransaction, traceContext, hint, profilingTraceData);
    }

    public ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return Sentry.startTransaction(transactionContext, transactionOptions);
    }

    @Deprecated
    public SentryTraceHeader traceHeaders() {
        return Sentry.traceHeaders();
    }

    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
        Sentry.getCurrentHub().setSpanContext(th, iSpan, str);
    }

    public ISpan getSpan() {
        return Sentry.getCurrentHub().getSpan();
    }

    public ITransaction getTransaction() {
        return Sentry.getCurrentHub().getTransaction();
    }

    public SentryOptions getOptions() {
        return Sentry.getCurrentHub().getOptions();
    }

    public Boolean isCrashedLastRun() {
        return Sentry.isCrashedLastRun();
    }

    public void reportFullyDisplayed() {
        Sentry.reportFullyDisplayed();
    }

    public TransactionContext continueTrace(String str, List<String> list) {
        return Sentry.continueTrace(str, list);
    }

    public SentryTraceHeader getTraceparent() {
        return Sentry.getTraceparent();
    }

    public BaggageHeader getBaggage() {
        return Sentry.getBaggage();
    }

    public SentryId captureCheckIn(CheckIn checkIn) {
        return Sentry.captureCheckIn(checkIn);
    }

    public RateLimiter getRateLimiter() {
        return Sentry.getCurrentHub().getRateLimiter();
    }

    public MetricsApi metrics() {
        return Sentry.getCurrentHub().metrics();
    }
}
