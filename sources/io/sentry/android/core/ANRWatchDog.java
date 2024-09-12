package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.transport.ICurrentDateProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class ANRWatchDog extends Thread {
    private final ANRListener anrListener;
    private final Context context;
    private volatile long lastKnownActiveUiTimestampMs;
    private final ILogger logger;
    private long pollingIntervalMs;
    private final boolean reportInDebug;
    private final AtomicBoolean reported;
    private final Runnable ticker;
    private final ICurrentDateProvider timeProvider;
    private final long timeoutIntervalMillis;
    private final MainLooperHandler uiHandler;

    public interface ANRListener {
        void onAppNotResponding(ApplicationNotResponding applicationNotResponding);
    }

    ANRWatchDog(long j, boolean z, ANRListener aNRListener, ILogger iLogger, Context context2) {
        this(new ANRWatchDog$$ExternalSyntheticLambda1(), j, 500, z, aNRListener, iLogger, new MainLooperHandler(), context2);
    }

    ANRWatchDog(ICurrentDateProvider iCurrentDateProvider, long j, long j2, boolean z, ANRListener aNRListener, ILogger iLogger, MainLooperHandler mainLooperHandler, Context context2) {
        super("|ANR-WatchDog|");
        this.lastKnownActiveUiTimestampMs = 0;
        this.reported = new AtomicBoolean(false);
        this.timeProvider = iCurrentDateProvider;
        this.timeoutIntervalMillis = j;
        this.pollingIntervalMs = j2;
        this.reportInDebug = z;
        this.anrListener = aNRListener;
        this.logger = iLogger;
        this.uiHandler = mainLooperHandler;
        this.context = context2;
        this.ticker = new ANRWatchDog$$ExternalSyntheticLambda0(this, iCurrentDateProvider);
        if (j < this.pollingIntervalMs * 2) {
            throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", new Object[]{Long.valueOf(this.pollingIntervalMs * 2)}));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$io-sentry-android-core-ANRWatchDog  reason: not valid java name */
    public /* synthetic */ void m881lambda$new$1$iosentryandroidcoreANRWatchDog(ICurrentDateProvider iCurrentDateProvider) {
        this.lastKnownActiveUiTimestampMs = iCurrentDateProvider.getCurrentTimeMillis();
        this.reported.set(false);
    }

    public void run() {
        this.ticker.run();
        while (!isInterrupted()) {
            this.uiHandler.post(this.ticker);
            try {
                Thread.sleep(this.pollingIntervalMs);
                if (this.timeProvider.getCurrentTimeMillis() - this.lastKnownActiveUiTimestampMs > this.timeoutIntervalMillis) {
                    if (!this.reportInDebug && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        this.logger.log(SentryLevel.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.reported.set(true);
                    } else if (isProcessNotResponding() && this.reported.compareAndSet(false, true)) {
                        this.anrListener.onAppNotResponding(new ApplicationNotResponding("Application Not Responding for at least " + this.timeoutIntervalMillis + " ms.", this.uiHandler.getThread()));
                    }
                }
            } catch (InterruptedException e) {
                try {
                    Thread.currentThread().interrupt();
                    this.logger.log(SentryLevel.WARNING, "Interrupted: %s", e.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.logger.log(SentryLevel.WARNING, "Failed to interrupt due to SecurityException: %s", e.getMessage());
                    return;
                }
            }
        }
    }

    private boolean isProcessNotResponding() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.ProcessErrorStateInfo> list = null;
        try {
            list = activityManager.getProcessesInErrorState();
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.condition == 2) {
                return true;
            }
        }
        return false;
    }
}
