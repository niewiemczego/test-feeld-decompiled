package io.sentry.transport;

import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda5 implements HintUtils.SentryConsumer {
    public final void accept(Object obj) {
        ((Retryable) obj).setRetry(true);
    }
}
