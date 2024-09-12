package io.sentry.android.core;

import android.app.Activity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityFramesTracker$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ActivityFramesTracker f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ ActivityFramesTracker$$ExternalSyntheticLambda1(ActivityFramesTracker activityFramesTracker, Activity activity) {
        this.f$0 = activityFramesTracker;
        this.f$1 = activity;
    }

    public final void run() {
        this.f$0.m884lambda$setMetrics$1$iosentryandroidcoreActivityFramesTracker(this.f$1);
    }
}
