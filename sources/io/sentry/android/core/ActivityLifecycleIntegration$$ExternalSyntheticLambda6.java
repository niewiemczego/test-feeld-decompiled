package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda6 implements ScopeCallback {
    public final /* synthetic */ ActivityLifecycleIntegration f$0;
    public final /* synthetic */ ITransaction f$1;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda6(ActivityLifecycleIntegration activityLifecycleIntegration, ITransaction iTransaction) {
        this.f$0 = activityLifecycleIntegration;
        this.f$1 = iTransaction;
    }

    public final void run(IScope iScope) {
        this.f$0.m893lambda$startTracing$2$iosentryandroidcoreActivityLifecycleIntegration(this.f$1, iScope);
    }
}
