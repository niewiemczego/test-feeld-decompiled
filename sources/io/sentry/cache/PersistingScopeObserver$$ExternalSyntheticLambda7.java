package io.sentry.cache;

import io.sentry.SpanContext;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ SpanContext f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda7(PersistingScopeObserver persistingScopeObserver, SpanContext spanContext) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = spanContext;
    }

    public final void run() {
        this.f$0.m922lambda$setTrace$8$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
