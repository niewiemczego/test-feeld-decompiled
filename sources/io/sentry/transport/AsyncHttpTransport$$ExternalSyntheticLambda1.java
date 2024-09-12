package io.sentry.transport;

import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$$ExternalSyntheticLambda1 implements HintUtils.SentryConsumer {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ AsyncHttpTransport$$ExternalSyntheticLambda1(boolean z) {
        this.f$0 = z;
    }

    public final void accept(Object obj) {
        ((Retryable) obj).setRetry(this.f$0);
    }
}
