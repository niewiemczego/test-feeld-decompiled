package com.launchdarkly.sdk.android;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BackgroundThreadExecutor {
    private final ThreadFactory threadFactory = new PriorityThreadFactory(10);

    BackgroundThreadExecutor() {
    }

    /* access modifiers changed from: package-private */
    public ExecutorService newFixedThreadPool(int i) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), this.threadFactory);
    }

    private static class PriorityThreadFactory implements ThreadFactory {
        private final int threadPriority;

        PriorityThreadFactory(int i) {
            this.threadPriority = i;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(new BackgroundThreadExecutor$PriorityThreadFactory$$ExternalSyntheticLambda0(this, runnable));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$newThread$0$com-launchdarkly-sdk-android-BackgroundThreadExecutor$PriorityThreadFactory  reason: not valid java name */
        public /* synthetic */ void m447lambda$newThread$0$comlaunchdarklysdkandroidBackgroundThreadExecutor$PriorityThreadFactory(Runnable runnable) {
            try {
                Process.setThreadPriority(this.threadPriority);
            } catch (Throwable unused) {
            }
            runnable.run();
        }
    }
}
