package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.sentry.FullyDisplayedReporter;
import io.sentry.IHub;
import io.sentry.IScope;
import io.sentry.ISpan;
import io.sentry.ITransaction;
import io.sentry.Instrumenter;
import io.sentry.Integration;
import io.sentry.MeasurementUnit;
import io.sentry.NoOpTransaction;
import io.sentry.SentryDate;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import io.sentry.TracesSamplingDecision;
import io.sentry.TransactionContext;
import io.sentry.TransactionOptions;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import io.sentry.util.TracingUtils;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class ActivityLifecycleIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {
    static final String APP_START_COLD = "app.start.cold";
    static final String APP_START_WARM = "app.start.warm";
    private static final String TRACE_ORIGIN = "auto.ui.activity";
    static final String TTFD_OP = "ui.load.full_display";
    static final long TTFD_TIMEOUT_MILLIS = 30000;
    static final String TTID_OP = "ui.load.initial_display";
    static final String UI_LOAD_OP = "ui.load";
    private final WeakHashMap<Activity, ITransaction> activitiesWithOngoingTransactions = new WeakHashMap<>();
    private final ActivityFramesTracker activityFramesTracker;
    private ISpan appStartSpan;
    private final Application application;
    private final BuildInfoProvider buildInfoProvider;
    private boolean firstActivityCreated = false;
    private FullyDisplayedReporter fullyDisplayedReporter = null;
    private IHub hub;
    private boolean isAllActivityCallbacksAvailable;
    private SentryDate lastPausedTime = AndroidDateUtils.getCurrentSentryDateTime();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private SentryAndroidOptions options;
    private boolean performanceEnabled = false;
    private boolean timeToFullDisplaySpanEnabled = false;
    private Future<?> ttfdAutoCloseFuture = null;
    private final WeakHashMap<Activity, ISpan> ttfdSpanMap = new WeakHashMap<>();
    private final WeakHashMap<Activity, ISpan> ttidSpanMap = new WeakHashMap<>();

    private String getAppStartDesc(boolean z) {
        return z ? "Cold Start" : "Warm Start";
    }

    private String getAppStartOp(boolean z) {
        return z ? APP_START_COLD : APP_START_WARM;
    }

    public void onActivityPostResumed(Activity activity) {
    }

    public ActivityLifecycleIntegration(Application application2, BuildInfoProvider buildInfoProvider2, ActivityFramesTracker activityFramesTracker2) {
        this.application = (Application) Objects.requireNonNull(application2, "Application is required");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "BuildInfoProvider is required");
        this.activityFramesTracker = (ActivityFramesTracker) Objects.requireNonNull(activityFramesTracker2, "ActivityFramesTracker is required");
        if (buildInfoProvider2.getSdkInfoVersion() >= 29) {
            this.isAllActivityCallbacksAvailable = true;
        }
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.performanceEnabled = isPerformanceEnabled(this.options);
        this.fullyDisplayedReporter = this.options.getFullyDisplayedReporter();
        this.timeToFullDisplaySpanEnabled = this.options.isEnableTimeToFullDisplayTracing();
        this.application.registerActivityLifecycleCallbacks(this);
        this.options.getLogger().log(SentryLevel.DEBUG, "ActivityLifecycleIntegration installed.", new Object[0]);
        IntegrationUtils.addIntegrationToSdkVersion(getClass());
    }

    private boolean isPerformanceEnabled(SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    public void close() throws IOException {
        this.application.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.activityFramesTracker.stop();
    }

    private String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private void stopPreviousTransactions() {
        for (Map.Entry next : this.activitiesWithOngoingTransactions.entrySet()) {
            finishTransaction((ITransaction) next.getValue(), this.ttidSpanMap.get(next.getKey()), this.ttfdSpanMap.get(next.getKey()));
        }
    }

    private void startTracing(Activity activity) {
        Boolean bool;
        SentryDate sentryDate;
        SentryDate sentryDate2;
        WeakReference weakReference = new WeakReference(activity);
        if (this.hub != null && !isRunningTransactionOrTrace(activity)) {
            if (!this.performanceEnabled) {
                this.activitiesWithOngoingTransactions.put(activity, NoOpTransaction.getInstance());
                TracingUtils.startNewTrace(this.hub);
                return;
            }
            stopPreviousTransactions();
            String activityName = getActivityName(activity);
            TimeSpan appStartTimeSpanWithFallback = AppStartMetrics.getInstance().getAppStartTimeSpanWithFallback(this.options);
            boolean z = false;
            TracesSamplingDecision tracesSamplingDecision = null;
            if (!ContextUtils.isForegroundImportance() || !appStartTimeSpanWithFallback.hasStarted()) {
                sentryDate = null;
                bool = null;
            } else {
                sentryDate = appStartTimeSpanWithFallback.getStartTimestamp();
                bool = Boolean.valueOf(AppStartMetrics.getInstance().getAppStartType() == AppStartMetrics.AppStartType.COLD);
            }
            TransactionOptions transactionOptions = new TransactionOptions();
            transactionOptions.setDeadlineTimeout(30000L);
            if (this.options.isEnableActivityLifecycleTracingAutoFinish()) {
                transactionOptions.setIdleTimeout(this.options.getIdleTimeout());
                transactionOptions.setTrimEnd(true);
            }
            transactionOptions.setWaitForChildren(true);
            transactionOptions.setTransactionFinishedCallback(new ActivityLifecycleIntegration$$ExternalSyntheticLambda4(this, weakReference, activityName));
            if (this.firstActivityCreated || sentryDate == null || bool == null) {
                sentryDate2 = this.lastPausedTime;
            } else {
                TracesSamplingDecision appStartSamplingDecision = AppStartMetrics.getInstance().getAppStartSamplingDecision();
                AppStartMetrics.getInstance().setAppStartSamplingDecision((TracesSamplingDecision) null);
                tracesSamplingDecision = appStartSamplingDecision;
                sentryDate2 = sentryDate;
            }
            transactionOptions.setStartTimestamp(sentryDate2);
            if (tracesSamplingDecision != null) {
                z = true;
            }
            transactionOptions.setAppStartTransaction(z);
            ITransaction startTransaction = this.hub.startTransaction(new TransactionContext(activityName, TransactionNameSource.COMPONENT, UI_LOAD_OP, tracesSamplingDecision), transactionOptions);
            setSpanOrigin(startTransaction);
            if (!(this.firstActivityCreated || sentryDate == null || bool == null)) {
                ISpan startChild = startTransaction.startChild(getAppStartOp(bool.booleanValue()), getAppStartDesc(bool.booleanValue()), sentryDate, Instrumenter.SENTRY);
                this.appStartSpan = startChild;
                setSpanOrigin(startChild);
                finishAppStartSpan();
            }
            ISpan startChild2 = startTransaction.startChild(TTID_OP, getTtidDesc(activityName), sentryDate2, Instrumenter.SENTRY);
            this.ttidSpanMap.put(activity, startChild2);
            setSpanOrigin(startChild2);
            if (!(!this.timeToFullDisplaySpanEnabled || this.fullyDisplayedReporter == null || this.options == null)) {
                ISpan startChild3 = startTransaction.startChild(TTFD_OP, getTtfdDesc(activityName), sentryDate2, Instrumenter.SENTRY);
                setSpanOrigin(startChild3);
                try {
                    this.ttfdSpanMap.put(activity, startChild3);
                    this.ttfdAutoCloseFuture = this.options.getExecutorService().schedule(new ActivityLifecycleIntegration$$ExternalSyntheticLambda5(this, startChild3, startChild2), 30000);
                } catch (RejectedExecutionException e) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", (Throwable) e);
                }
            }
            this.hub.configureScope(new ActivityLifecycleIntegration$$ExternalSyntheticLambda6(this, startTransaction));
            this.activitiesWithOngoingTransactions.put(activity, startTransaction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$startTracing$0$io-sentry-android-core-ActivityLifecycleIntegration  reason: not valid java name */
    public /* synthetic */ void m891lambda$startTracing$0$iosentryandroidcoreActivityLifecycleIntegration(WeakReference weakReference, String str, ITransaction iTransaction) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            this.activityFramesTracker.setMetrics(activity, iTransaction.getEventId());
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
        }
    }

    private void setSpanOrigin(ISpan iSpan) {
        if (iSpan != null) {
            iSpan.getSpanContext().setOrigin(TRACE_ORIGIN);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: applyScope */
    public void m893lambda$startTracing$2$iosentryandroidcoreActivityLifecycleIntegration(IScope iScope, ITransaction iTransaction) {
        iScope.withTransaction(new ActivityLifecycleIntegration$$ExternalSyntheticLambda9(this, iScope, iTransaction));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$applyScope$3$io-sentry-android-core-ActivityLifecycleIntegration  reason: not valid java name */
    public /* synthetic */ void m886lambda$applyScope$3$iosentryandroidcoreActivityLifecycleIntegration(IScope iScope, ITransaction iTransaction, ITransaction iTransaction2) {
        if (iTransaction2 == null) {
            iScope.setTransaction(iTransaction);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction.getName());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: clearScope */
    public void m887lambda$finishTransaction$5$iosentryandroidcoreActivityLifecycleIntegration(IScope iScope, ITransaction iTransaction) {
        iScope.withTransaction(new ActivityLifecycleIntegration$$ExternalSyntheticLambda0(iTransaction, iScope));
    }

    static /* synthetic */ void lambda$clearScope$4(ITransaction iTransaction, IScope iScope, ITransaction iTransaction2) {
        if (iTransaction2 == iTransaction) {
            iScope.clearTransaction();
        }
    }

    private boolean isRunningTransactionOrTrace(Activity activity) {
        return this.activitiesWithOngoingTransactions.containsKey(activity);
    }

    private void stopTracing(Activity activity, boolean z) {
        if (this.performanceEnabled && z) {
            finishTransaction(this.activitiesWithOngoingTransactions.get(activity), (ISpan) null, (ISpan) null);
        }
    }

    private void finishTransaction(ITransaction iTransaction, ISpan iSpan, ISpan iSpan2) {
        if (iTransaction != null && !iTransaction.isFinished()) {
            finishSpan(iSpan, SpanStatus.DEADLINE_EXCEEDED);
            m892lambda$startTracing$1$iosentryandroidcoreActivityLifecycleIntegration(iSpan2, iSpan);
            cancelTtfdAutoClose();
            SpanStatus status = iTransaction.getStatus();
            if (status == null) {
                status = SpanStatus.OK;
            }
            iTransaction.finish(status);
            IHub iHub = this.hub;
            if (iHub != null) {
                iHub.configureScope(new ActivityLifecycleIntegration$$ExternalSyntheticLambda3(this, iTransaction));
            }
        }
    }

    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        setColdStart(bundle);
        if (this.hub != null) {
            this.hub.configureScope(new ActivityLifecycleIntegration$$ExternalSyntheticLambda7(ClassUtil.getClassName(activity)));
        }
        startTracing(activity);
        ISpan iSpan = this.ttfdSpanMap.get(activity);
        this.firstActivityCreated = true;
        FullyDisplayedReporter fullyDisplayedReporter2 = this.fullyDisplayedReporter;
        if (fullyDisplayedReporter2 != null) {
            fullyDisplayedReporter2.registerFullyDrawnListener(new ActivityLifecycleIntegration$$ExternalSyntheticLambda8(this, iSpan));
        }
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (this.performanceEnabled) {
            this.activityFramesTracker.addActivity(activity);
        }
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.performanceEnabled) {
            ISpan iSpan = this.ttidSpanMap.get(activity);
            ISpan iSpan2 = this.ttfdSpanMap.get(activity);
            View findViewById = activity.findViewById(16908290);
            if (findViewById != null) {
                FirstDrawDoneListener.registerForNextDraw(findViewById, (Runnable) new ActivityLifecycleIntegration$$ExternalSyntheticLambda1(this, iSpan2, iSpan), this.buildInfoProvider);
            } else {
                this.mainHandler.post(new ActivityLifecycleIntegration$$ExternalSyntheticLambda2(this, iSpan2, iSpan));
            }
        }
    }

    public void onActivityPrePaused(Activity activity) {
        if (this.isAllActivityCallbacksAvailable) {
            this.firstActivityCreated = true;
            IHub iHub = this.hub;
            if (iHub == null) {
                this.lastPausedTime = AndroidDateUtils.getCurrentSentryDateTime();
            } else {
                this.lastPausedTime = iHub.getOptions().getDateProvider().now();
            }
        }
    }

    public synchronized void onActivityPaused(Activity activity) {
        if (!this.isAllActivityCallbacksAvailable) {
            this.firstActivityCreated = true;
            IHub iHub = this.hub;
            if (iHub == null) {
                this.lastPausedTime = AndroidDateUtils.getCurrentSentryDateTime();
            } else {
                this.lastPausedTime = iHub.getOptions().getDateProvider().now();
            }
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
    }

    public synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public synchronized void onActivityDestroyed(Activity activity) {
        if (this.performanceEnabled) {
            finishSpan(this.appStartSpan, SpanStatus.CANCELLED);
            ISpan iSpan = this.ttidSpanMap.get(activity);
            finishSpan(iSpan, SpanStatus.DEADLINE_EXCEEDED);
            m892lambda$startTracing$1$iosentryandroidcoreActivityLifecycleIntegration(this.ttfdSpanMap.get(activity), iSpan);
            cancelTtfdAutoClose();
            stopTracing(activity, true);
            this.appStartSpan = null;
            this.ttidSpanMap.remove(activity);
            this.ttfdSpanMap.remove(activity);
        }
        this.activitiesWithOngoingTransactions.remove(activity);
    }

    private void finishSpan(ISpan iSpan) {
        if (iSpan != null && !iSpan.isFinished()) {
            iSpan.finish();
        }
    }

    private void finishSpan(ISpan iSpan, SentryDate sentryDate) {
        finishSpan(iSpan, sentryDate, (SpanStatus) null);
    }

    private void finishSpan(ISpan iSpan, SentryDate sentryDate, SpanStatus spanStatus) {
        if (iSpan != null && !iSpan.isFinished()) {
            if (spanStatus == null) {
                spanStatus = iSpan.getStatus() != null ? iSpan.getStatus() : SpanStatus.OK;
            }
            iSpan.finish(spanStatus, sentryDate);
        }
    }

    private void finishSpan(ISpan iSpan, SpanStatus spanStatus) {
        if (iSpan != null && !iSpan.isFinished()) {
            iSpan.finish(spanStatus);
        }
    }

    private void cancelTtfdAutoClose() {
        Future<?> future = this.ttfdAutoCloseFuture;
        if (future != null) {
            future.cancel(false);
            this.ttfdAutoCloseFuture = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onFirstFrameDrawn */
    public void m890lambda$onActivityResumed$9$iosentryandroidcoreActivityLifecycleIntegration(ISpan iSpan, ISpan iSpan2) {
        AppStartMetrics instance = AppStartMetrics.getInstance();
        TimeSpan appStartTimeSpan = instance.getAppStartTimeSpan();
        TimeSpan sdkInitTimeSpan = instance.getSdkInitTimeSpan();
        if (appStartTimeSpan.hasStarted() && appStartTimeSpan.hasNotStopped()) {
            appStartTimeSpan.stop();
        }
        if (sdkInitTimeSpan.hasStarted() && sdkInitTimeSpan.hasNotStopped()) {
            sdkInitTimeSpan.stop();
        }
        finishAppStartSpan();
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions == null || iSpan2 == null) {
            finishSpan(iSpan2);
            return;
        }
        SentryDate now = sentryAndroidOptions.getDateProvider().now();
        long millis = TimeUnit.NANOSECONDS.toMillis(now.diff(iSpan2.getStartDate()));
        iSpan2.setMeasurement(MeasurementValue.KEY_TIME_TO_INITIAL_DISPLAY, Long.valueOf(millis), MeasurementUnit.Duration.MILLISECOND);
        if (iSpan != null && iSpan.isFinished()) {
            iSpan.updateEndDate(now);
            iSpan2.setMeasurement(MeasurementValue.KEY_TIME_TO_FULL_DISPLAY, Long.valueOf(millis), MeasurementUnit.Duration.MILLISECOND);
        }
        finishSpan(iSpan2, now);
    }

    /* access modifiers changed from: private */
    /* renamed from: onFullFrameDrawn */
    public void m888lambda$onActivityCreated$7$iosentryandroidcoreActivityLifecycleIntegration(ISpan iSpan) {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions == null || iSpan == null) {
            finishSpan(iSpan);
        } else {
            SentryDate now = sentryAndroidOptions.getDateProvider().now();
            iSpan.setMeasurement(MeasurementValue.KEY_TIME_TO_FULL_DISPLAY, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(now.diff(iSpan.getStartDate()))), MeasurementUnit.Duration.MILLISECOND);
            finishSpan(iSpan, now);
        }
        cancelTtfdAutoClose();
    }

    /* access modifiers changed from: private */
    /* renamed from: finishExceededTtfdSpan */
    public void m892lambda$startTracing$1$iosentryandroidcoreActivityLifecycleIntegration(ISpan iSpan, ISpan iSpan2) {
        if (iSpan != null && !iSpan.isFinished()) {
            iSpan.setDescription(getExceededTtfdDesc(iSpan));
            SentryDate finishDate = iSpan2 != null ? iSpan2.getFinishDate() : null;
            if (finishDate == null) {
                finishDate = iSpan.getStartDate();
            }
            finishSpan(iSpan, finishDate, SpanStatus.DEADLINE_EXCEEDED);
        }
    }

    /* access modifiers changed from: package-private */
    public WeakHashMap<Activity, ITransaction> getActivitiesWithOngoingTransactions() {
        return this.activitiesWithOngoingTransactions;
    }

    /* access modifiers changed from: package-private */
    public ActivityFramesTracker getActivityFramesTracker() {
        return this.activityFramesTracker;
    }

    /* access modifiers changed from: package-private */
    public ISpan getAppStartSpan() {
        return this.appStartSpan;
    }

    /* access modifiers changed from: package-private */
    public WeakHashMap<Activity, ISpan> getTtidSpanMap() {
        return this.ttidSpanMap;
    }

    /* access modifiers changed from: package-private */
    public WeakHashMap<Activity, ISpan> getTtfdSpanMap() {
        return this.ttfdSpanMap;
    }

    private void setColdStart(Bundle bundle) {
        SentryAndroidOptions sentryAndroidOptions;
        AppStartMetrics.AppStartType appStartType;
        if (!this.firstActivityCreated && (sentryAndroidOptions = this.options) != null && !sentryAndroidOptions.isEnablePerformanceV2()) {
            AppStartMetrics instance = AppStartMetrics.getInstance();
            if (bundle == null) {
                appStartType = AppStartMetrics.AppStartType.COLD;
            } else {
                appStartType = AppStartMetrics.AppStartType.WARM;
            }
            instance.setAppStartType(appStartType);
        }
    }

    private String getTtidDesc(String str) {
        return str + " initial display";
    }

    private String getTtfdDesc(String str) {
        return str + " full display";
    }

    private String getExceededTtfdDesc(ISpan iSpan) {
        String description = iSpan.getDescription();
        if (description == null || !description.endsWith(" - Deadline Exceeded")) {
            return iSpan.getDescription() + " - Deadline Exceeded";
        }
        return description;
    }

    private void finishAppStartSpan() {
        SentryDate projectedStopTimestamp = AppStartMetrics.getInstance().getAppStartTimeSpanWithFallback(this.options).getProjectedStopTimestamp();
        if (this.performanceEnabled && projectedStopTimestamp != null) {
            finishSpan(this.appStartSpan, projectedStopTimestamp);
        }
    }
}
