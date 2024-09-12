package io.sentry;

import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnvelopeSender$$ExternalSyntheticLambda1 implements HintUtils.SentryConsumer {
    public final /* synthetic */ EnvelopeSender f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ EnvelopeSender$$ExternalSyntheticLambda1(EnvelopeSender envelopeSender, File file) {
        this.f$0 = envelopeSender;
        this.f$1 = file;
    }

    public final void accept(Object obj) {
        this.f$0.m870lambda$processFile$2$iosentryEnvelopeSender(this.f$1, (Retryable) obj);
    }
}
