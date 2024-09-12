package io.sentry.android.core;

import io.sentry.android.core.cache.AndroidEnvelopeCache;
import io.sentry.util.LazyEvaluator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidOptionsInitializer$$ExternalSyntheticLambda0 implements LazyEvaluator.Evaluator {
    public final /* synthetic */ SentryAndroidOptions f$0;

    public /* synthetic */ AndroidOptionsInitializer$$ExternalSyntheticLambda0(SentryAndroidOptions sentryAndroidOptions) {
        this.f$0 = sentryAndroidOptions;
    }

    public final Object evaluate() {
        return Boolean.valueOf(AndroidEnvelopeCache.hasStartupCrashMarker(this.f$0));
    }
}
