package io.sentry;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryWrapper$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ IHub f$0;
    public final /* synthetic */ Callable f$1;

    public /* synthetic */ SentryWrapper$$ExternalSyntheticLambda1(IHub iHub, Callable callable) {
        this.f$0 = iHub;
        this.f$1 = callable;
    }

    public final Object call() {
        return SentryWrapper.lambda$wrapCallable$0(this.f$0, this.f$1);
    }
}
