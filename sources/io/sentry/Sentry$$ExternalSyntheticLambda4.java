package io.sentry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Sentry$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ SentryOptions f$0;

    public /* synthetic */ Sentry$$ExternalSyntheticLambda4(SentryOptions sentryOptions) {
        this.f$0 = sentryOptions;
    }

    public final void run() {
        Sentry.lambda$notifyOptionsObservers$3(this.f$0);
    }
}
