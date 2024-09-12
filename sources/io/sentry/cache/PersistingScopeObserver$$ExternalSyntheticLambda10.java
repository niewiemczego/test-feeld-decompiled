package io.sentry.cache;

import java.util.Collection;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ Collection f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda10(PersistingScopeObserver persistingScopeObserver, Collection collection) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = collection;
    }

    public final void run() {
        this.f$0.m915lambda$setBreadcrumbs$1$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
