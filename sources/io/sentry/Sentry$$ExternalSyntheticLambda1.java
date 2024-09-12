package io.sentry;

import io.sentry.Sentry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Sentry$$ExternalSyntheticLambda1 implements Sentry.OptionsConfiguration {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Sentry$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    public final void configure(SentryOptions sentryOptions) {
        sentryOptions.setDsn(this.f$0);
    }
}
