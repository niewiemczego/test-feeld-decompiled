package io.sentry.android.core;

import io.sentry.ITransaction;
import io.sentry.TransactionFinishedCallback;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda4 implements TransactionFinishedCallback {
    public final /* synthetic */ ActivityLifecycleIntegration f$0;
    public final /* synthetic */ WeakReference f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda4(ActivityLifecycleIntegration activityLifecycleIntegration, WeakReference weakReference, String str) {
        this.f$0 = activityLifecycleIntegration;
        this.f$1 = weakReference;
        this.f$2 = str;
    }

    public final void execute(ITransaction iTransaction) {
        this.f$0.m891lambda$startTracing$0$iosentryandroidcoreActivityLifecycleIntegration(this.f$1, this.f$2, iTransaction);
    }
}
