package io.sentry.backpressure;

import io.sentry.IHub;
import io.sentry.ISentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;

public final class BackpressureMonitor implements IBackpressureMonitor, Runnable {
    private static final int CHECK_INTERVAL_IN_MS = 10000;
    private static final int INITIAL_CHECK_DELAY_IN_MS = 500;
    static final int MAX_DOWNSAMPLE_FACTOR = 10;
    private int downsampleFactor = 0;
    private final IHub hub;
    private final SentryOptions sentryOptions;

    public BackpressureMonitor(SentryOptions sentryOptions2, IHub iHub) {
        this.sentryOptions = sentryOptions2;
        this.hub = iHub;
    }

    public void start() {
        reschedule(500);
    }

    public void run() {
        checkHealth();
        reschedule(10000);
    }

    public int getDownsampleFactor() {
        return this.downsampleFactor;
    }

    /* access modifiers changed from: package-private */
    public void checkHealth() {
        if (isHealthy()) {
            if (this.downsampleFactor > 0) {
                this.sentryOptions.getLogger().log(SentryLevel.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.downsampleFactor = 0;
            return;
        }
        int i = this.downsampleFactor;
        if (i < 10) {
            this.downsampleFactor = i + 1;
            this.sentryOptions.getLogger().log(SentryLevel.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.downsampleFactor));
        }
    }

    private void reschedule(int i) {
        ISentryExecutorService executorService = this.sentryOptions.getExecutorService();
        if (!executorService.isClosed()) {
            executorService.schedule(this, (long) i);
        }
    }

    private boolean isHealthy() {
        return this.hub.isHealthy();
    }
}
