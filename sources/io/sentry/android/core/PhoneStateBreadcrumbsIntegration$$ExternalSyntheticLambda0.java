package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.SentryOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PhoneStateBreadcrumbsIntegration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PhoneStateBreadcrumbsIntegration f$0;
    public final /* synthetic */ IHub f$1;
    public final /* synthetic */ SentryOptions f$2;

    public /* synthetic */ PhoneStateBreadcrumbsIntegration$$ExternalSyntheticLambda0(PhoneStateBreadcrumbsIntegration phoneStateBreadcrumbsIntegration, IHub iHub, SentryOptions sentryOptions) {
        this.f$0 = phoneStateBreadcrumbsIntegration;
        this.f$1 = iHub;
        this.f$2 = sentryOptions;
    }

    public final void run() {
        this.f$0.m901lambda$register$0$iosentryandroidcorePhoneStateBreadcrumbsIntegration(this.f$1, this.f$2);
    }
}
