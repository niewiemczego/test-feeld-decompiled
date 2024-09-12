package io.sentry.cache;

import io.sentry.protocol.Contexts;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ Contexts f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda8(PersistingScopeObserver persistingScopeObserver, Contexts contexts) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = contexts;
    }

    public final void run() {
        this.f$0.m916lambda$setContexts$9$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
