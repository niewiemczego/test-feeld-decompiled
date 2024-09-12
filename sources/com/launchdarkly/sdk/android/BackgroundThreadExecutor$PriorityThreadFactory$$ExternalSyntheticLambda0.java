package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.android.BackgroundThreadExecutor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BackgroundThreadExecutor$PriorityThreadFactory$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BackgroundThreadExecutor.PriorityThreadFactory f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ BackgroundThreadExecutor$PriorityThreadFactory$$ExternalSyntheticLambda0(BackgroundThreadExecutor.PriorityThreadFactory priorityThreadFactory, Runnable runnable) {
        this.f$0 = priorityThreadFactory;
        this.f$1 = runnable;
    }

    public final void run() {
        this.f$0.m447lambda$newThread$0$comlaunchdarklysdkandroidBackgroundThreadExecutor$PriorityThreadFactory(this.f$1);
    }
}
