package io.sentry.util;

import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HintUtils$$ExternalSyntheticLambda1 implements HintUtils.SentryHintFallback {
    public final /* synthetic */ HintUtils.SentryNullableConsumer f$0;

    public /* synthetic */ HintUtils$$ExternalSyntheticLambda1(HintUtils.SentryNullableConsumer sentryNullableConsumer) {
        this.f$0 = sentryNullableConsumer;
    }

    public final void accept(Object obj, Class cls) {
        this.f$0.accept(obj);
    }
}
