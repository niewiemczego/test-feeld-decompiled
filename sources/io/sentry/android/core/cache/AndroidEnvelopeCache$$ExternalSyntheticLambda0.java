package io.sentry.android.core.cache;

import io.sentry.android.core.AnrV2Integration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidEnvelopeCache$$ExternalSyntheticLambda0 implements HintUtils.SentryConsumer {
    public final /* synthetic */ AndroidEnvelopeCache f$0;
    public final /* synthetic */ SentryAndroidOptions f$1;

    public /* synthetic */ AndroidEnvelopeCache$$ExternalSyntheticLambda0(AndroidEnvelopeCache androidEnvelopeCache, SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = androidEnvelopeCache;
        this.f$1 = sentryAndroidOptions;
    }

    public final void accept(Object obj) {
        this.f$0.m906lambda$store$0$iosentryandroidcorecacheAndroidEnvelopeCache(this.f$1, (AnrV2Integration.AnrV2Hint) obj);
    }
}
