package io.sentry.util;

import io.sentry.IScope;
import io.sentry.PropagationContext;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.util.TracingUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TracingUtils$$ExternalSyntheticLambda3 implements ScopeCallback {
    public final /* synthetic */ TracingUtils.PropagationContextHolder f$0;
    public final /* synthetic */ SentryOptions f$1;

    public /* synthetic */ TracingUtils$$ExternalSyntheticLambda3(TracingUtils.PropagationContextHolder propagationContextHolder, SentryOptions sentryOptions) {
        this.f$0 = propagationContextHolder;
        this.f$1 = sentryOptions;
    }

    public final void run(IScope iScope) {
        PropagationContext unused = this.f$0.propagationContext = TracingUtils.maybeUpdateBaggage(iScope, this.f$1);
    }
}
