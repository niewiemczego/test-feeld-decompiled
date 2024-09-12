package io.sentry.transport;

import io.sentry.hints.DiskFlushNotification;
import io.sentry.transport.AsyncHttpTransport;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda1 implements HintUtils.SentryConsumer {
    public final /* synthetic */ AsyncHttpTransport.EnvelopeSender f$0;

    public /* synthetic */ AsyncHttpTransport$EnvelopeSender$$ExternalSyntheticLambda1(AsyncHttpTransport.EnvelopeSender envelopeSender) {
        this.f$0 = envelopeSender;
    }

    public final void accept(Object obj) {
        this.f$0.m938lambda$flush$1$iosentrytransportAsyncHttpTransport$EnvelopeSender((DiskFlushNotification) obj);
    }
}
