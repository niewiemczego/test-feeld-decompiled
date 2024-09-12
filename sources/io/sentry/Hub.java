package io.sentry;

import io.sentry.Scope;
import io.sentry.Stack;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.metrics.MetricsApi;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.transport.RateLimiter;
import io.sentry.util.ExceptionUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.Pair;
import io.sentry.util.TracingUtils;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class Hub implements IHub, MetricsApi.IMetricsInterface {
    private volatile boolean isEnabled;
    private volatile SentryId lastEventId;
    private final MetricsApi metricsApi;
    private final SentryOptions options;
    private final Stack stack;
    private final Map<Throwable, Pair<WeakReference<ISpan>, String>> throwableToSpan;
    private final TracesSampler tracesSampler;
    private final TransactionPerformanceCollector transactionPerformanceCollector;

    public Hub(SentryOptions sentryOptions) {
        this(sentryOptions, createRootStackItem(sentryOptions));
    }

    private Hub(SentryOptions sentryOptions, Stack stack2) {
        this.throwableToSpan = Collections.synchronizedMap(new WeakHashMap());
        validateOptions(sentryOptions);
        this.options = sentryOptions;
        this.tracesSampler = new TracesSampler(sentryOptions);
        this.stack = stack2;
        this.lastEventId = SentryId.EMPTY_ID;
        this.transactionPerformanceCollector = sentryOptions.getTransactionPerformanceCollector();
        this.isEnabled = true;
        this.metricsApi = new MetricsApi(this);
    }

    private Hub(SentryOptions sentryOptions, Stack.StackItem stackItem) {
        this(sentryOptions, new Stack(sentryOptions.getLogger(), stackItem));
    }

    private static void validateOptions(SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
        }
    }

    private static Stack.StackItem createRootStackItem(SentryOptions sentryOptions) {
        validateOptions(sentryOptions);
        return new Stack.StackItem(sentryOptions, new SentryClient(sentryOptions), new Scope(sentryOptions));
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return captureEventInternal(sentryEvent, hint, (ScopeCallback) null);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint, ScopeCallback scopeCallback) {
        return captureEventInternal(sentryEvent, hint, scopeCallback);
    }

    private SentryId captureEventInternal(SentryEvent sentryEvent, Hint hint, ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryId;
        } else if (sentryEvent == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return sentryId;
        } else {
            try {
                assignTraceContext(sentryEvent);
                Stack.StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureEvent(sentryEvent, buildLocalScope(peek.getScope(), scopeCallback), hint);
                this.lastEventId = sentryId;
                return sentryId;
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing event with id: " + sentryEvent.getEventId(), th);
                return sentryId;
            }
        }
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return captureMessageInternal(str, sentryLevel, (ScopeCallback) null);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel, ScopeCallback scopeCallback) {
        return captureMessageInternal(str, sentryLevel, scopeCallback);
    }

    private SentryId captureMessageInternal(String str, SentryLevel sentryLevel, ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureMessage' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureMessage called with null parameter.", new Object[0]);
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureMessage(str, sentryLevel, buildLocalScope(peek.getScope(), scopeCallback));
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing message: " + str, th);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            SentryId captureEnvelope = this.stack.peek().getClient().captureEnvelope(sentryEnvelope, hint);
            if (captureEnvelope != null) {
                return captureEnvelope;
            }
            return sentryId;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing envelope.", th);
            return sentryId;
        }
    }

    public SentryId captureException(Throwable th, Hint hint) {
        return captureExceptionInternal(th, hint, (ScopeCallback) null);
    }

    public SentryId captureException(Throwable th, Hint hint, ScopeCallback scopeCallback) {
        return captureExceptionInternal(th, hint, scopeCallback);
    }

    private SentryId captureExceptionInternal(Throwable th, Hint hint, ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                SentryEvent sentryEvent = new SentryEvent(th);
                assignTraceContext(sentryEvent);
                sentryId = peek.getClient().captureEvent(sentryEvent, buildLocalScope(peek.getScope(), scopeCallback), hint);
            } catch (Throwable th2) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    private void assignTraceContext(SentryEvent sentryEvent) {
        Pair pair;
        ISpan iSpan;
        if (this.options.isTracingEnabled() && sentryEvent.getThrowable() != null && (pair = this.throwableToSpan.get(ExceptionUtils.findRootCause(sentryEvent.getThrowable()))) != null) {
            WeakReference weakReference = (WeakReference) pair.getFirst();
            if (!(sentryEvent.getContexts().getTrace() != null || weakReference == null || (iSpan = (ISpan) weakReference.get()) == null)) {
                sentryEvent.getContexts().setTrace(iSpan.getSpanContext());
            }
            String str = (String) pair.getSecond();
            if (sentryEvent.getTransaction() == null && str != null) {
                sentryEvent.setTransaction(str);
            }
        }
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureUserFeedback' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().captureUserFeedback(userFeedback);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing captureUserFeedback: " + userFeedback.toString(), th);
        }
    }

    public void startSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        Scope.SessionPair startSession = peek.getScope().startSession();
        if (startSession != null) {
            if (startSession.getPrevious() != null) {
                peek.getClient().captureSession(startSession.getPrevious(), HintUtils.createWithTypeCheckHint(new SessionEndHint()));
            }
            peek.getClient().captureSession(startSession.getCurrent(), HintUtils.createWithTypeCheckHint(new SessionStartHint()));
            return;
        }
        this.options.getLogger().log(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
    }

    public void endSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        Session endSession = peek.getScope().endSession();
        if (endSession != null) {
            peek.getClient().captureSession(endSession, HintUtils.createWithTypeCheckHint(new SessionEndHint()));
        }
    }

    public void close() {
        close(false);
    }

    public void close(boolean z) {
        Integration next;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            Iterator<Integration> it = this.options.getIntegrations().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next instanceof Closeable) {
                    ((Closeable) next).close();
                }
            }
            configureScope(new Hub$$ExternalSyntheticLambda2());
            this.options.getTransactionProfiler().close();
            this.options.getTransactionPerformanceCollector().close();
            ISentryExecutorService executorService = this.options.getExecutorService();
            if (z) {
                executorService.submit((Runnable) new Hub$$ExternalSyntheticLambda3(this, executorService));
            } else {
                executorService.close(this.options.getShutdownTimeoutMillis());
            }
            this.stack.peek().getClient().close(z);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the integration {}.", next, e);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error while closing the Hub.", th);
        }
        this.isEnabled = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$close$1$io-sentry-Hub  reason: not valid java name */
    public /* synthetic */ void m872lambda$close$1$iosentryHub(ISentryExecutorService iSentryExecutorService) {
        iSentryExecutorService.close(this.options.getShutdownTimeoutMillis());
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().addBreadcrumb(breadcrumb, hint);
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new Hint());
    }

    public void setLevel(SentryLevel sentryLevel) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setLevel' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setLevel(sentryLevel);
        }
    }

    public void setTransaction(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTransaction' call is a no-op.", new Object[0]);
        } else if (str != null) {
            this.stack.peek().getScope().setTransaction(str);
        } else {
            this.options.getLogger().log(SentryLevel.WARNING, "Transaction cannot be null", new Object[0]);
        }
    }

    public void setUser(User user) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setUser(user);
        }
    }

    public void setFingerprint(List<String> list) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setFingerprint' call is a no-op.", new Object[0]);
        } else if (list == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setFingerprint called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setFingerprint(list);
        }
    }

    public void clearBreadcrumbs() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().clearBreadcrumbs();
        }
    }

    public void setTag(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setTag(str, str2);
        }
    }

    public void removeTag(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "removeTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeTag(str);
        }
    }

    public void setExtra(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "setExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setExtra(str, str2);
        }
    }

    public void removeExtra(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, "removeExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeExtra(str);
        }
    }

    public SentryId getLastEventId() {
        return this.lastEventId;
    }

    public void pushScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'pushScope' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        this.stack.push(new Stack.StackItem(this.options, peek.getClient(), peek.getScope().clone()));
    }

    public SentryOptions getOptions() {
        return this.stack.peek().getOptions();
    }

    public Boolean isCrashedLastRun() {
        return SentryCrashLastRunState.getInstance().isCrashedLastRun(this.options.getCacheDirPath(), !this.options.isEnableAutoSessionTracking());
    }

    public void reportFullyDisplayed() {
        if (this.options.isEnableTimeToFullDisplayTracing()) {
            this.options.getFullyDisplayedReporter().reportFullyDrawn();
        }
    }

    public void popScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'popScope' call is a no-op.", new Object[0]);
        } else {
            this.stack.pop();
        }
    }

    public void withScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            try {
                scopeCallback.run(NoOpScope.getInstance());
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'withScope' callback.", th);
            }
        } else {
            pushScope();
            try {
                scopeCallback.run(this.stack.peek().getScope());
            } catch (Throwable th2) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'withScope' callback.", th2);
            }
            popScope();
        }
    }

    public void configureScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.stack.peek().getScope());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    public void bindClient(ISentryClient iSentryClient) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'bindClient' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem peek = this.stack.peek();
        if (iSentryClient != null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "New client bound to scope.", new Object[0]);
            peek.setClient(iSentryClient);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "NoOp client bound to scope.", new Object[0]);
        peek.setClient(NoOpSentryClient.getInstance());
    }

    public boolean isHealthy() {
        return this.stack.peek().getClient().isHealthy();
    }

    public void flush(long j) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().flush(j);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    public IHub clone() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        return new Hub(this.options, new Stack(this.stack));
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        Objects.requireNonNull(sentryTransaction, "transaction is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        } else if (!sentryTransaction.isFinished()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", sentryTransaction.getEventId());
            return sentryId;
        } else if (!Boolean.TRUE.equals(Boolean.valueOf(sentryTransaction.isSampled()))) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", sentryTransaction.getEventId());
            if (this.options.getBackpressureMonitor().getDownsampleFactor() > 0) {
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BACKPRESSURE, DataCategory.Transaction);
                return sentryId;
            }
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.SAMPLE_RATE, DataCategory.Transaction);
            return sentryId;
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                return peek.getClient().captureTransaction(sentryTransaction, traceContext, peek.getScope(), hint, profilingTraceData);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing transaction with id: " + sentryTransaction.getEventId(), th);
                return sentryId;
            }
        }
    }

    public ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return createTransaction(transactionContext, transactionOptions);
    }

    private ITransaction createTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        ITransaction iTransaction;
        Objects.requireNonNull(transactionContext, "transactionContext is required");
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransaction = NoOpTransaction.getInstance();
        } else if (!this.options.getInstrumenter().equals(transactionContext.getInstrumenter())) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", transactionContext.getInstrumenter(), this.options.getInstrumenter());
            iTransaction = NoOpTransaction.getInstance();
        } else if (!this.options.isTracingEnabled()) {
            this.options.getLogger().log(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransaction = NoOpTransaction.getInstance();
        } else {
            TracesSamplingDecision sample = this.tracesSampler.sample(new SamplingContext(transactionContext, transactionOptions.getCustomSamplingContext()));
            transactionContext.setSamplingDecision(sample);
            SentryTracer sentryTracer = new SentryTracer(transactionContext, this, transactionOptions, this.transactionPerformanceCollector);
            if (sample.getSampled().booleanValue() && sample.getProfileSampled().booleanValue()) {
                ITransactionProfiler transactionProfiler = this.options.getTransactionProfiler();
                if (!transactionProfiler.isRunning()) {
                    transactionProfiler.start();
                    transactionProfiler.bindTransaction(sentryTracer);
                } else if (transactionOptions.isAppStartTransaction()) {
                    transactionProfiler.bindTransaction(sentryTracer);
                }
            }
            iTransaction = sentryTracer;
        }
        if (transactionOptions.isBindToScope()) {
            configureScope(new Hub$$ExternalSyntheticLambda1(iTransaction));
        }
        return iTransaction;
    }

    @Deprecated
    public SentryTraceHeader traceHeaders() {
        return getTraceparent();
    }

    public ISpan getSpan() {
        if (isEnabled()) {
            return this.stack.peek().getScope().getSpan();
        }
        this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getSpan' call is a no-op.", new Object[0]);
        return null;
    }

    public ITransaction getTransaction() {
        if (isEnabled()) {
            return this.stack.peek().getScope().getTransaction();
        }
        this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
        return null;
    }

    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
        Objects.requireNonNull(th, "throwable is required");
        Objects.requireNonNull(iSpan, "span is required");
        Objects.requireNonNull(str, "transactionName is required");
        Throwable findRootCause = ExceptionUtils.findRootCause(th);
        if (!this.throwableToSpan.containsKey(findRootCause)) {
            this.throwableToSpan.put(findRootCause, new Pair(new WeakReference(iSpan), str));
        }
    }

    /* access modifiers changed from: package-private */
    public SpanContext getSpanContext(Throwable th) {
        WeakReference weakReference;
        ISpan iSpan;
        Objects.requireNonNull(th, "throwable is required");
        Pair pair = this.throwableToSpan.get(ExceptionUtils.findRootCause(th));
        if (pair == null || (weakReference = (WeakReference) pair.getFirst()) == null || (iSpan = (ISpan) weakReference.get()) == null) {
            return null;
        }
        return iSpan.getSpanContext();
    }

    private IScope buildLocalScope(IScope iScope, ScopeCallback scopeCallback) {
        if (scopeCallback != null) {
            try {
                IScope clone = iScope.clone();
                scopeCallback.run(clone);
                return clone;
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return iScope;
    }

    public TransactionContext continueTrace(String str, List<String> list) {
        PropagationContext fromHeaders = PropagationContext.fromHeaders(getOptions().getLogger(), str, list);
        configureScope(new Hub$$ExternalSyntheticLambda0(fromHeaders));
        if (this.options.isTracingEnabled()) {
            return TransactionContext.fromPropagationContext(fromHeaders);
        }
        return null;
    }

    public SentryTraceHeader getTraceparent() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getTraceparent' call is a no-op.", new Object[0]);
        } else {
            TracingUtils.TracingHeaders trace = TracingUtils.trace(this, (List<String>) null, getSpan());
            if (trace != null) {
                return trace.getSentryTraceHeader();
            }
        }
        return null;
    }

    public BaggageHeader getBaggage() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getBaggage' call is a no-op.", new Object[0]);
        } else {
            TracingUtils.TracingHeaders trace = TracingUtils.trace(this, (List<String>) null, getSpan());
            if (trace != null) {
                return trace.getBaggageHeader();
            }
        }
        return null;
    }

    public SentryId captureCheckIn(CheckIn checkIn) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureCheckIn' call is a no-op.", new Object[0]);
        } else {
            try {
                Stack.StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureCheckIn(checkIn, peek.getScope(), (Hint) null);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Error while capturing check-in for slug", th);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public RateLimiter getRateLimiter() {
        return this.stack.peek().getClient().getRateLimiter();
    }

    public MetricsApi metrics() {
        return this.metricsApi;
    }

    public IMetricsAggregator getMetricsAggregator() {
        return this.stack.peek().getClient().getMetricsAggregator();
    }

    public Map<String, String> getDefaultTagsForMetrics() {
        if (!this.options.isEnableDefaultTagsForMetrics()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String release = this.options.getRelease();
        if (release != null) {
            hashMap.put("release", release);
        }
        String environment = this.options.getEnvironment();
        if (environment != null) {
            hashMap.put("environment", environment);
        }
        String transactionName = this.stack.peek().getScope().getTransactionName();
        if (transactionName != null) {
            hashMap.put("transaction", transactionName);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public ISpan startSpanForMetric(String str, String str2) {
        ISpan span = getSpan();
        if (span != null) {
            return span.startChild(str, str2);
        }
        return null;
    }

    public LocalMetricsAggregator getLocalMetricsAggregator() {
        ISpan span;
        if (this.options.isEnableSpanLocalMetricAggregation() && (span = getSpan()) != null) {
            return span.getLocalMetricsAggregator();
        }
        return null;
    }
}
