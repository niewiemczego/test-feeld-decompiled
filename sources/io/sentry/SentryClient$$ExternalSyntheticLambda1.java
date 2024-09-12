package io.sentry;

import io.sentry.Scope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryClient$$ExternalSyntheticLambda1 implements Scope.IWithSession {
    public final /* synthetic */ SentryClient f$0;
    public final /* synthetic */ SentryEvent f$1;
    public final /* synthetic */ Hint f$2;

    public /* synthetic */ SentryClient$$ExternalSyntheticLambda1(SentryClient sentryClient, SentryEvent sentryEvent, Hint hint) {
        this.f$0 = sentryClient;
        this.f$1 = sentryEvent;
        this.f$2 = hint;
    }

    public final void accept(Session session) {
        this.f$0.m876lambda$updateSessionData$1$iosentrySentryClient(this.f$1, this.f$2, session);
    }
}
