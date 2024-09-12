package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ActivityLifecycleIntegration$$ExternalSyntheticLambda7 implements ScopeCallback {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ActivityLifecycleIntegration$$ExternalSyntheticLambda7(String str) {
        this.f$0 = str;
    }

    public final void run(IScope iScope) {
        iScope.setScreen(this.f$0);
    }
}
