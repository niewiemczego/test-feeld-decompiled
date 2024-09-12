package io.sentry.react;

import io.sentry.Hint;
import io.sentry.SentryEvent;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda8 implements SentryOptions.BeforeSendCallback {
    public final /* synthetic */ RNSentryModuleImpl f$0;
    public final /* synthetic */ SentryAndroidOptions f$1;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda8(RNSentryModuleImpl rNSentryModuleImpl, SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = rNSentryModuleImpl;
        this.f$1 = sentryAndroidOptions;
    }

    public final SentryEvent execute(SentryEvent sentryEvent, Hint hint) {
        return this.f$0.m933lambda$initNativeSdk$1$iosentryreactRNSentryModuleImpl(this.f$1, sentryEvent, hint);
    }
}
