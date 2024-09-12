package io.sentry;

import io.sentry.hints.Resettable;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutboxSender$$ExternalSyntheticLambda1 implements HintUtils.SentryConsumer {
    public final void accept(Object obj) {
        ((Resettable) obj).reset();
    }
}
