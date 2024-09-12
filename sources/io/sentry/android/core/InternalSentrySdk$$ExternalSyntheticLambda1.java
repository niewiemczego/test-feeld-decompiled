package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ScopeCallback;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InternalSentrySdk$$ExternalSyntheticLambda1 implements ScopeCallback {
    public final /* synthetic */ AtomicReference f$0;

    public /* synthetic */ InternalSentrySdk$$ExternalSyntheticLambda1(AtomicReference atomicReference) {
        this.f$0 = atomicReference;
    }

    public final void run(IScope iScope) {
        this.f$0.set(iScope.clone());
    }
}
