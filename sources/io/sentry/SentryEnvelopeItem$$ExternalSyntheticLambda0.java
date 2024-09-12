package io.sentry;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ ISerializer f$0;
    public final /* synthetic */ SentryBaseEvent f$1;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda0(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent) {
        this.f$0 = iSerializer;
        this.f$1 = sentryBaseEvent;
    }

    public final Object call() {
        return SentryEnvelopeItem.lambda$fromEvent$3(this.f$0, this.f$1);
    }
}
