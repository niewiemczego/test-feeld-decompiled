package io.sentry;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryTracer$$ExternalSyntheticLambda3 implements ScopeCallback {
    public final /* synthetic */ AtomicReference f$0;

    public /* synthetic */ SentryTracer$$ExternalSyntheticLambda3(AtomicReference atomicReference) {
        this.f$0 = atomicReference;
    }

    public final void run(IScope iScope) {
        this.f$0.set(iScope.getUser());
    }
}
