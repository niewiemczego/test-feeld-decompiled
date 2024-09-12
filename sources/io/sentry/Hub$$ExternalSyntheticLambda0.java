package io.sentry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Hub$$ExternalSyntheticLambda0 implements ScopeCallback {
    public final /* synthetic */ PropagationContext f$0;

    public /* synthetic */ Hub$$ExternalSyntheticLambda0(PropagationContext propagationContext) {
        this.f$0 = propagationContext;
    }

    public final void run(IScope iScope) {
        iScope.setPropagationContext(this.f$0);
    }
}
