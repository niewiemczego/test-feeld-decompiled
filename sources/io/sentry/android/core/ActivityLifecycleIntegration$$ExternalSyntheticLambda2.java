package io.sentry.android.core;

import io.sentry.ISpan;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ActivityLifecycleIntegration f$0;
    public final /* synthetic */ ISpan f$1;
    public final /* synthetic */ ISpan f$2;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda2(ActivityLifecycleIntegration activityLifecycleIntegration, ISpan iSpan, ISpan iSpan2) {
        this.f$0 = activityLifecycleIntegration;
        this.f$1 = iSpan;
        this.f$2 = iSpan2;
    }

    public final void run() {
        this.f$0.m890lambda$onActivityResumed$9$iosentryandroidcoreActivityLifecycleIntegration(this.f$1, this.f$2);
    }
}
