package io.sentry;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda6 implements Callable {
    public final /* synthetic */ Attachment f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ ISerializer f$2;
    public final /* synthetic */ ILogger f$3;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda6(Attachment attachment, long j, ISerializer iSerializer, ILogger iLogger) {
        this.f$0 = attachment;
        this.f$1 = j;
        this.f$2 = iSerializer;
        this.f$3 = iLogger;
    }

    public final Object call() {
        return SentryEnvelopeItem.lambda$fromAttachment$15(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
