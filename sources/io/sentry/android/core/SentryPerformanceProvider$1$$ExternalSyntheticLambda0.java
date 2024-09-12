package io.sentry.android.core;

import io.sentry.android.core.SentryPerformanceProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryPerformanceProvider$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SentryPerformanceProvider.AnonymousClass1 f$0;
    public final /* synthetic */ AtomicBoolean f$1;

    public /* synthetic */ SentryPerformanceProvider$1$$ExternalSyntheticLambda0(SentryPerformanceProvider.AnonymousClass1 r1, AtomicBoolean atomicBoolean) {
        this.f$0 = r1;
        this.f$1 = atomicBoolean;
    }

    public final void run() {
        this.f$0.m903lambda$onActivityStarted$0$iosentryandroidcoreSentryPerformanceProvider$1(this.f$1);
    }
}
