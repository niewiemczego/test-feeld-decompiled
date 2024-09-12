package io.sentry;

import io.sentry.metrics.EncodedMetrics;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ EncodedMetrics f$0;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda3(EncodedMetrics encodedMetrics) {
        this.f$0 = encodedMetrics;
    }

    public final Object call() {
        return this.f$0.encodeToStatsd();
    }
}
