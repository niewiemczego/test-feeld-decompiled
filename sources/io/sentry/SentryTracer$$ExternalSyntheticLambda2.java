package io.sentry;

import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryTracer$$ExternalSyntheticLambda2 implements Scope.IWithTransaction {
    public final /* synthetic */ SentryTracer f$0;
    public final /* synthetic */ IScope f$1;

    public /* synthetic */ SentryTracer$$ExternalSyntheticLambda2(SentryTracer sentryTracer, IScope iScope) {
        this.f$0 = sentryTracer;
        this.f$1 = iScope;
    }

    public final void accept(ITransaction iTransaction) {
        this.f$0.m878lambda$finish$0$iosentrySentryTracer(this.f$1, iTransaction);
    }
}
