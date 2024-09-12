package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.SentryOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SystemEventsBreadcrumbsIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SystemEventsBreadcrumbsIntegration f$0;
    public final /* synthetic */ IHub f$1;
    public final /* synthetic */ SentryOptions f$2;

    public /* synthetic */ SystemEventsBreadcrumbsIntegration$$ExternalSyntheticLambda0(SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration, IHub iHub, SentryOptions sentryOptions) {
        this.f$0 = systemEventsBreadcrumbsIntegration;
        this.f$1 = iHub;
        this.f$2 = sentryOptions;
    }

    public final void run() {
        this.f$0.m904lambda$register$0$iosentryandroidcoreSystemEventsBreadcrumbsIntegration(this.f$1, this.f$2);
    }
}
