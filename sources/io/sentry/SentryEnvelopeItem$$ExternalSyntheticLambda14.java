package io.sentry;

import io.sentry.SentryEnvelopeItem;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda14 implements Callable {
    public final /* synthetic */ SentryEnvelopeItem.CachedItem f$0;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda14(SentryEnvelopeItem.CachedItem cachedItem) {
        this.f$0 = cachedItem;
    }

    public final Object call() {
        return Integer.valueOf(this.f$0.getBytes().length);
    }
}
