package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.utils.ErrorCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LifecycleAwareRequestRunner$$ExternalSyntheticLambda0 implements ErrorCallback {
    public final /* synthetic */ LifecycleAwareRequestRunner f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ LifecycleAwareRequestRunner$$ExternalSyntheticLambda0(LifecycleAwareRequestRunner lifecycleAwareRequestRunner, long j) {
        this.f$0 = lifecycleAwareRequestRunner;
        this.f$1 = j;
    }

    public final void onResult(AdaptyError adaptyError) {
        LifecycleAwareRequestRunner.handleAppOpenedEvent$lambda$0(this.f$0, this.f$1, adaptyError);
    }
}
