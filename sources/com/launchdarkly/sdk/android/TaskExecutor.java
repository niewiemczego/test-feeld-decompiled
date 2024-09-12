package com.launchdarkly.sdk.android;

import java.io.Closeable;
import java.util.concurrent.ScheduledFuture;

interface TaskExecutor extends Closeable {
    void executeOnMainThread(Runnable runnable);

    ScheduledFuture<?> scheduleTask(Runnable runnable, long j);

    ScheduledFuture<?> startRepeatingTask(Runnable runnable, long j, long j2);
}
