package io.sentry.transport;

import io.sentry.hints.SubmissionResult;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RateLimiter$$ExternalSyntheticLambda0 implements HintUtils.SentryConsumer {
    public final void accept(Object obj) {
        ((SubmissionResult) obj).setResult(false);
    }
}
