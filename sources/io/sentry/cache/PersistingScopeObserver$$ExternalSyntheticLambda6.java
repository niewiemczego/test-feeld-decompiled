package io.sentry.cache;

import io.sentry.protocol.Request;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ Request f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda6(PersistingScopeObserver persistingScopeObserver, Request request) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = request;
    }

    public final void run() {
        this.f$0.m920lambda$setRequest$4$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
