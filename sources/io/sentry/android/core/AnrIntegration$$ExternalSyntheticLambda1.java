package io.sentry.android.core;

import io.sentry.IHub;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnrIntegration$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AnrIntegration f$0;
    public final /* synthetic */ IHub f$1;
    public final /* synthetic */ SentryAndroidOptions f$2;

    public /* synthetic */ AnrIntegration$$ExternalSyntheticLambda1(AnrIntegration anrIntegration, IHub iHub, SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = anrIntegration;
        this.f$1 = iHub;
        this.f$2 = sentryAndroidOptions;
    }

    public final void run() {
        this.f$0.m895lambda$register$0$iosentryandroidcoreAnrIntegration(this.f$1, this.f$2);
    }
}
