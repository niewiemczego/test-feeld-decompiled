package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda3 implements ScopeCallback {
    public final /* synthetic */ ActivityLifecycleIntegration f$0;
    public final /* synthetic */ ITransaction f$1;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda3(ActivityLifecycleIntegration activityLifecycleIntegration, ITransaction iTransaction) {
        this.f$0 = activityLifecycleIntegration;
        this.f$1 = iTransaction;
    }

    public final void run(IScope iScope) {
        this.f$0.m887lambda$finishTransaction$5$iosentryandroidcoreActivityLifecycleIntegration(this.f$1, iScope);
    }
}
