package io.sentry.react;

import com.facebook.react.bridge.ReadableMap;
import io.sentry.Sentry;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda0 implements Sentry.OptionsConfiguration {
    public final /* synthetic */ RNSentryModuleImpl f$0;
    public final /* synthetic */ ReadableMap f$1;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda0(RNSentryModuleImpl rNSentryModuleImpl, ReadableMap readableMap) {
        this.f$0 = rNSentryModuleImpl;
        this.f$1 = readableMap;
    }

    public final void configure(SentryOptions sentryOptions) {
        this.f$0.m934lambda$initNativeSdk$2$iosentryreactRNSentryModuleImpl(this.f$1, (SentryAndroidOptions) sentryOptions);
    }
}
