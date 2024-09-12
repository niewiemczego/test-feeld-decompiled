package io.sentry.android.core;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidOptionsInitializer$$ExternalSyntheticLambda2 implements SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath {
    public final /* synthetic */ SentryAndroidOptions f$0;

    public /* synthetic */ AndroidOptionsInitializer$$ExternalSyntheticLambda2(SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = sentryAndroidOptions;
    }

    public final String getDirPath() {
        return this.f$0.getOutboxPath();
    }
}
