package io.sentry.cache;

import io.sentry.protocol.User;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ User f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda9(PersistingScopeObserver persistingScopeObserver, User user) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = user;
    }

    public final void run() {
        this.f$0.m924lambda$setUser$0$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
