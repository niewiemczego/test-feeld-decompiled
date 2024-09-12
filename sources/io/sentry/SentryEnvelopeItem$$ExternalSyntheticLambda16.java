package io.sentry;

import io.sentry.SentryEnvelopeItem;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda16 implements Callable {
    public final /* synthetic */ SentryEnvelopeItem.CachedItem f$0;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda16(SentryEnvelopeItem.CachedItem cachedItem) {
        this.f$0 = cachedItem;
    }

    public final Object call() {
        return this.f$0.getBytes();
    }
}
