package io.sentry.util;

import io.sentry.IScope;
import io.sentry.PropagationContext;
import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TracingUtils$$ExternalSyntheticLambda0 implements Scope.IWithPropagationContext {
    public final /* synthetic */ IScope f$0;

    public /* synthetic */ TracingUtils$$ExternalSyntheticLambda0(IScope iScope) {
        this.f$0 = iScope;
    }

    public final void accept(PropagationContext propagationContext) {
        this.f$0.setPropagationContext(new PropagationContext());
    }
}
