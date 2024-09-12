package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda9 implements Scope.IWithTransaction {
    public final /* synthetic */ ActivityLifecycleIntegration f$0;
    public final /* synthetic */ IScope f$1;
    public final /* synthetic */ ITransaction f$2;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda9(ActivityLifecycleIntegration activityLifecycleIntegration, IScope iScope, ITransaction iTransaction) {
        this.f$0 = activityLifecycleIntegration;
        this.f$1 = iScope;
        this.f$2 = iTransaction;
    }

    public final void accept(ITransaction iTransaction) {
        this.f$0.m886lambda$applyScope$3$iosentryandroidcoreActivityLifecycleIntegration(this.f$1, this.f$2, iTransaction);
    }
}
