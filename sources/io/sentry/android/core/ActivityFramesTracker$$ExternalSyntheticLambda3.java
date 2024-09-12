package io.sentry.android.core;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityFramesTracker$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ActivityFramesTracker f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ActivityFramesTracker$$ExternalSyntheticLambda3(ActivityFramesTracker activityFramesTracker, Runnable runnable, String str) {
        this.f$0 = activityFramesTracker;
        this.f$1 = runnable;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.m883lambda$runSafelyOnUiThread$3$iosentryandroidcoreActivityFramesTracker(this.f$1, this.f$2);
    }
}
