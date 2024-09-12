package io.sentry;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda17 implements Callable {
    public final /* synthetic */ ISerializer f$0;
    public final /* synthetic */ CheckIn f$1;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda17(ISerializer iSerializer, CheckIn checkIn) {
        this.f$0 = iSerializer;
        this.f$1 = checkIn;
    }

    public final Object call() {
        return SentryEnvelopeItem.lambda$fromCheckIn$9(this.f$0, this.f$1);
    }
}
