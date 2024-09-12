package io.sentry.android.core.internal.gestures;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryGestureListener$$ExternalSyntheticLambda2 implements ScopeCallback {
    public final /* synthetic */ SentryGestureListener f$0;
    public final /* synthetic */ ITransaction f$1;

    public /* synthetic */ SentryGestureListener$$ExternalSyntheticLambda2(SentryGestureListener sentryGestureListener, ITransaction iTransaction) {
        this.f$0 = sentryGestureListener;
        this.f$1 = iTransaction;
    }

    public final void run(IScope iScope) {
        this.f$0.m909lambda$startTracing$0$iosentryandroidcoreinternalgesturesSentryGestureListener(this.f$1, iScope);
    }
}
