package io.sentry.android.core;

import io.sentry.transport.ICurrentDateProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ANRWatchDog$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ANRWatchDog f$0;
    public final /* synthetic */ ICurrentDateProvider f$1;

    public /* synthetic */ ANRWatchDog$$ExternalSyntheticLambda0(ANRWatchDog aNRWatchDog, ICurrentDateProvider iCurrentDateProvider) {
        this.f$0 = aNRWatchDog;
        this.f$1 = iCurrentDateProvider;
    }

    public final void run() {
        this.f$0.m881lambda$new$1$iosentryandroidcoreANRWatchDog(this.f$1);
    }
}
