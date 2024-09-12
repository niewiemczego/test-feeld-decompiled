package com.launchdarkly.sdk.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.launchdarkly.logging.LDLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class AndroidTaskExecutor implements TaskExecutor {
    private final Application application;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final Handler handler;
    private final LDLogger logger;

    AndroidTaskExecutor(Application application2, LDLogger lDLogger) {
        this.application = application2;
        this.handler = new Handler(Looper.getMainLooper());
        this.logger = lDLogger;
    }

    public void executeOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callActionWithErrorHandling(runnable);
        } else {
            this.handler.post(wrapActionWithErrorHandling(runnable));
        }
    }

    public ScheduledFuture<?> scheduleTask(Runnable runnable, long j) {
        return this.executor.schedule(wrapActionWithErrorHandling(runnable), j, TimeUnit.MILLISECONDS);
    }

    public ScheduledFuture<?> startRepeatingTask(Runnable runnable, long j, long j2) {
        return this.executor.scheduleAtFixedRate(wrapActionWithErrorHandling(runnable), j, j2, TimeUnit.MILLISECONDS);
    }

    public void close() {
        this.executor.shutdownNow();
    }

    private Runnable wrapActionWithErrorHandling(final Runnable runnable) {
        return new Runnable() {
            public void run() {
                AndroidTaskExecutor.this.callActionWithErrorHandling(runnable);
            }
        };
    }

    /* access modifiers changed from: private */
    public void callActionWithErrorHandling(Runnable runnable) {
        if (runnable != null) {
            try {
                runnable.run();
            } catch (RuntimeException e) {
                LDUtil.logExceptionAtErrorLevel(this.logger, e, "Unexpected exception from asynchronous task", new Object[0]);
            }
        }
    }
}
