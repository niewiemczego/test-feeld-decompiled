package io.sentry.android.core.internal.gestures;

import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryGestureListener$$ExternalSyntheticLambda3 implements Scope.IWithTransaction {
    public final /* synthetic */ SentryGestureListener f$0;
    public final /* synthetic */ IScope f$1;

    public /* synthetic */ SentryGestureListener$$ExternalSyntheticLambda3(SentryGestureListener sentryGestureListener, IScope iScope) {
        this.f$0 = sentryGestureListener;
        this.f$1 = iScope;
    }

    public final void accept(ITransaction iTransaction) {
        this.f$0.m908lambda$clearScope$2$iosentryandroidcoreinternalgesturesSentryGestureListener(this.f$1, iTransaction);
    }
}
