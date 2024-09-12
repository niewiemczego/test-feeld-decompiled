package com.appsflyer.internal;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AFc1uSDK$$ExternalSyntheticLambda0 implements RejectedExecutionHandler {
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AFc1uSDK.valueOf(runnable, threadPoolExecutor);
    }
}
