package io.sentry.util;

import io.sentry.IScope;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TracingUtils$$ExternalSyntheticLambda1 implements ScopeCallback {
    public final void run(IScope iScope) {
        iScope.withPropagationContext(new TracingUtils$$ExternalSyntheticLambda0(iScope));
    }
}
