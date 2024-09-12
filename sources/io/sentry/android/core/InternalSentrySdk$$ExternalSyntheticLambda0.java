package io.sentry.android.core;

import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.Session;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InternalSentrySdk$$ExternalSyntheticLambda0 implements ScopeCallback {
    public final /* synthetic */ Session.State f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ AtomicReference f$2;
    public final /* synthetic */ SentryOptions f$3;

    public /* synthetic */ InternalSentrySdk$$ExternalSyntheticLambda0(Session.State state, boolean z, AtomicReference atomicReference, SentryOptions sentryOptions) {
        this.f$0 = state;
        this.f$1 = z;
        this.f$2 = atomicReference;
        this.f$3 = sentryOptions;
    }

    public final void run(IScope iScope) {
        InternalSentrySdk.lambda$updateSession$1(this.f$0, this.f$1, this.f$2, this.f$3, iScope);
    }
}
