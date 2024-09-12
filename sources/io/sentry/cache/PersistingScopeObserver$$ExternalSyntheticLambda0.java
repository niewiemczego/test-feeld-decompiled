package io.sentry.cache;

import io.sentry.SentryLevel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PersistingScopeObserver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PersistingScopeObserver f$0;
    public final /* synthetic */ SentryLevel f$1;

    public /* synthetic */ PersistingScopeObserver$$ExternalSyntheticLambda0(PersistingScopeObserver persistingScopeObserver, SentryLevel sentryLevel) {
        this.f$0 = persistingScopeObserver;
        this.f$1 = sentryLevel;
    }

    public final void run() {
        this.f$0.m919lambda$setLevel$6$iosentrycachePersistingScopeObserver(this.f$1);
    }
}
