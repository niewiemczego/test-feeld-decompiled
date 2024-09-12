package io.sentry.android.core.internal.gestures;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryGestureListener$$ExternalSyntheticLambda0 implements Scope.IWithTransaction {
    public final /* synthetic */ SentryGestureListener f$0;
    public final /* synthetic */ IScope f$1;
    public final /* synthetic */ ITransaction f$2;

    public /* synthetic */ SentryGestureListener$$ExternalSyntheticLambda0(SentryGestureListener sentryGestureListener, IScope iScope, ITransaction iTransaction) {
        this.f$0 = sentryGestureListener;
        this.f$1 = iScope;
        this.f$2 = iTransaction;
    }

    public final void accept(ITransaction iTransaction) {
        this.f$0.m907lambda$applyScope$3$iosentryandroidcoreinternalgesturesSentryGestureListener(this.f$1, this.f$2, iTransaction);
    }
}
