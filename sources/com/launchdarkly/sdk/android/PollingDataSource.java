package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;

final class PollingDataSource implements DataSource {
    private final LDContext currentContext;
    private final AtomicReference<ScheduledFuture<?>> currentPollTask = new AtomicReference<>();
    private final DataSourceUpdateSink dataSourceUpdateSink;
    private final FeatureFetcher fetcher;
    final int initialDelayMillis;
    private final LDLogger logger;
    private final PlatformState platformState;
    final int pollIntervalMillis;
    private final TaskExecutor taskExecutor;

    PollingDataSource(LDContext lDContext, DataSourceUpdateSink dataSourceUpdateSink2, int i, int i2, FeatureFetcher featureFetcher, PlatformState platformState2, TaskExecutor taskExecutor2, LDLogger lDLogger) {
        this.currentContext = lDContext;
        this.dataSourceUpdateSink = dataSourceUpdateSink2;
        this.initialDelayMillis = i;
        this.pollIntervalMillis = i2;
        this.fetcher = featureFetcher;
        this.platformState = platformState2;
        this.taskExecutor = taskExecutor2;
        this.logger = lDLogger;
    }

    public void start(final Callback<Boolean> callback) {
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                PollingDataSource.this.triggerPoll(callback);
            }
        };
        this.logger.debug("Scheduling polling task with interval of {}ms, starting after {}ms", Integer.valueOf(this.pollIntervalMillis), Integer.valueOf(this.initialDelayMillis));
        this.currentPollTask.set(this.taskExecutor.startRepeatingTask(r1, (long) this.initialDelayMillis, (long) this.pollIntervalMillis));
    }

    public void stop(Callback<Void> callback) {
        ScheduledFuture andSet = this.currentPollTask.getAndSet((Object) null);
        if (andSet != null) {
            andSet.cancel(true);
        }
        callback.onSuccess(null);
    }

    /* access modifiers changed from: private */
    public void triggerPoll(Callback<Boolean> callback) {
        ConnectivityManager.fetchAndSetData(this.fetcher, this.currentContext, this.dataSourceUpdateSink, callback, this.logger);
    }
}
