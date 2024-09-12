package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda0 implements Scope.IWithTransaction {
    public final /* synthetic */ ITransaction f$0;
    public final /* synthetic */ IScope f$1;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda0(ITransaction iTransaction, IScope iScope) {
        this.f$0 = iTransaction;
        this.f$1 = iScope;
    }

    public final void accept(ITransaction iTransaction) {
        ActivityLifecycleIntegration.lambda$clearScope$4(this.f$0, this.f$1, iTransaction);
    }
}
