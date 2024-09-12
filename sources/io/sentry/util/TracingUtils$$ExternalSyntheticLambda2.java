package io.sentry.util;

import io.sentry.IScope;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.SentryOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TracingUtils$$ExternalSyntheticLambda2 implements Scope.IWithPropagationContext {
    public final /* synthetic */ SentryOptions f$0;
    public final /* synthetic */ IScope f$1;

    public /* synthetic */ TracingUtils$$ExternalSyntheticLambda2(SentryOptions sentryOptions, IScope iScope) {
        this.f$0 = sentryOptions;
        this.f$1 = iScope;
    }

    public final void accept(PropagationContext propagationContext) {
        TracingUtils.lambda$maybeUpdateBaggage$3(this.f$0, this.f$1, propagationContext);
    }
}
