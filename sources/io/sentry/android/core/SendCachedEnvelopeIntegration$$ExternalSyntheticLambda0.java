package io.sentry.android.core;

import io.sentry.IHub;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendCachedEnvelopeIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SendCachedEnvelopeIntegration f$0;
    public final /* synthetic */ SentryAndroidOptions f$1;
    public final /* synthetic */ IHub f$2;

    public /* synthetic */ SendCachedEnvelopeIntegration$$ExternalSyntheticLambda0(SendCachedEnvelopeIntegration sendCachedEnvelopeIntegration, SentryAndroidOptions sentryAndroidOptions, IHub iHub) {
        this.f$0 = sendCachedEnvelopeIntegration;
        this.f$1 = sentryAndroidOptions;
        this.f$2 = iHub;
    }

    public final void run() {
        this.f$0.m902lambda$sendCachedEnvelopes$0$iosentryandroidcoreSendCachedEnvelopeIntegration(this.f$1, this.f$2);
    }
}
