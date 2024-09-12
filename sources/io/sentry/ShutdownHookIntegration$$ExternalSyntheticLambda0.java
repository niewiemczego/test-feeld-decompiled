package io.sentry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShutdownHookIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IHub f$0;
    public final /* synthetic */ SentryOptions f$1;

    public /* synthetic */ ShutdownHookIntegration$$ExternalSyntheticLambda0(IHub iHub, SentryOptions sentryOptions) {
        this.f$0 = iHub;
        this.f$1 = sentryOptions;
    }

    public final void run() {
        this.f$0.flush(this.f$1.getFlushTimeoutMillis());
    }
}
