package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.transport.AsyncHttpTransport;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda4 implements HintUtils.SentryHintFallback {
    public final /* synthetic */ AsyncHttpTransport.EnvelopeSender f$0;
    public final /* synthetic */ SentryEnvelope f$1;

    public /* synthetic */ AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda4(AsyncHttpTransport.EnvelopeSender envelopeSender, SentryEnvelope sentryEnvelope) {
        this.f$0 = envelopeSender;
        this.f$1 = sentryEnvelope;
    }

    public final void accept(Object obj, Class cls) {
        this.f$0.m940lambda$flush$4$iosentrytransportAsyncHttpTransport$EnvelopeSender(this.f$1, obj, cls);
    }
}
