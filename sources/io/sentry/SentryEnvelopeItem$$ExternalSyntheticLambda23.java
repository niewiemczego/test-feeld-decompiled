package io.sentry;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda23 implements Callable {
    public final /* synthetic */ ISerializer f$0;
    public final /* synthetic */ Session f$1;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda23(ISerializer iSerializer, Session session) {
        this.f$0 = iSerializer;
        this.f$1 = session;
    }

    public final Object call() {
        return SentryEnvelopeItem.lambda$fromSession$0(this.f$0, this.f$1);
    }
}
