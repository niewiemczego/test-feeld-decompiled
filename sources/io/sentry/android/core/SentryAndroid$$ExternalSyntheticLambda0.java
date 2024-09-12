package io.sentry.android.core;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.Sentry;
import io.sentry.SentryOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryAndroid$$ExternalSyntheticLambda0 implements Sentry.OptionsConfiguration {
    public final /* synthetic */ ILogger f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Sentry.OptionsConfiguration f$2;

    public /* synthetic */ SentryAndroid$$ExternalSyntheticLambda0(ILogger iLogger, Context context, Sentry.OptionsConfiguration optionsConfiguration) {
        this.f$0 = iLogger;
        this.f$1 = context;
        this.f$2 = optionsConfiguration;
    }

    public final void configure(SentryOptions sentryOptions) {
        SentryAndroid.lambda$init$1(this.f$0, this.f$1, this.f$2, (SentryAndroidOptions) sentryOptions);
    }
}
