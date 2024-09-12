package io.invertase.firebase.common;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TaskExecutorService$$ExternalSyntheticLambda0 implements RejectedExecutionHandler {
    public final /* synthetic */ TaskExecutorService f$0;

    public /* synthetic */ TaskExecutorService$$ExternalSyntheticLambda0(TaskExecutorService taskExecutorService) {
        this.f$0 = taskExecutorService;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        this.f$0.m859lambda$new$0$ioinvertasefirebasecommonTaskExecutorService(runnable, threadPoolExecutor);
    }
}
