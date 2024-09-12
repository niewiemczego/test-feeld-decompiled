package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.android.core.ANRWatchDog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnrIntegration$$ExternalSyntheticLambda0 implements ANRWatchDog.ANRListener {
    public final /* synthetic */ AnrIntegration f$0;
    public final /* synthetic */ IHub f$1;
    public final /* synthetic */ SentryAndroidOptions f$2;

    public /* synthetic */ AnrIntegration$$ExternalSyntheticLambda0(AnrIntegration anrIntegration, IHub iHub, SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = anrIntegration;
        this.f$1 = iHub;
        this.f$2 = sentryAndroidOptions;
    }

    public final void onAppNotResponding(ApplicationNotResponding applicationNotResponding) {
        this.f$0.m896lambda$startAnrWatchdog$1$iosentryandroidcoreAnrIntegration(this.f$1, this.f$2, applicationNotResponding);
    }
}
