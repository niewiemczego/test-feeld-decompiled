package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.SentryOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnvelopeFileObserverIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ EnvelopeFileObserverIntegration f$0;
    public final /* synthetic */ IHub f$1;
    public final /* synthetic */ SentryOptions f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ EnvelopeFileObserverIntegration$$ExternalSyntheticLambda0(EnvelopeFileObserverIntegration envelopeFileObserverIntegration, IHub iHub, SentryOptions sentryOptions, String str) {
        this.f$0 = envelopeFileObserverIntegration;
        this.f$1 = iHub;
        this.f$2 = sentryOptions;
        this.f$3 = str;
    }

    public final void run() {
        this.f$0.m899lambda$register$0$iosentryandroidcoreEnvelopeFileObserverIntegration(this.f$1, this.f$2, this.f$3);
    }
}
