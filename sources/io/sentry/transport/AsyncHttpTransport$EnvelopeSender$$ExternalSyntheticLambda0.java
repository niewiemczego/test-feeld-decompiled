package io.sentry.transport;

import io.sentry.hints.SubmissionResult;
import io.sentry.transport.AsyncHttpTransport;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda0 implements HintUtils.SentryConsumer {
    public final /* synthetic */ AsyncHttpTransport.EnvelopeSender f$0;
    public final /* synthetic */ TransportResult f$1;

    public /* synthetic */ AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda0(AsyncHttpTransport.EnvelopeSender envelopeSender, TransportResult transportResult) {
        this.f$0 = envelopeSender;
        this.f$1 = transportResult;
    }

    public final void accept(Object obj) {
        this.f$0.m942lambda$run$0$iosentrytransportAsyncHttpTransport$EnvelopeSender(this.f$1, (SubmissionResult) obj);
    }
}
