package io.sentry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendCachedEnvelopeFireAndForgetIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SendCachedEnvelopeFireAndForgetIntegration f$0;
    public final /* synthetic */ SentryOptions f$1;
    public final /* synthetic */ IHub f$2;

    public /* synthetic */ SendCachedEnvelopeFireAndForgetIntegration$$ExternalSyntheticLambda0(SendCachedEnvelopeFireAndForgetIntegration sendCachedEnvelopeFireAndForgetIntegration, SentryOptions sentryOptions, IHub iHub) {
        this.f$0 = sendCachedEnvelopeFireAndForgetIntegration;
        this.f$1 = sentryOptions;
        this.f$2 = iHub;
    }

    public final void run() {
        this.f$0.m875lambda$sendCachedEnvelopes$0$iosentrySendCachedEnvelopeFireAndForgetIntegration(this.f$1, this.f$2);
    }
}
