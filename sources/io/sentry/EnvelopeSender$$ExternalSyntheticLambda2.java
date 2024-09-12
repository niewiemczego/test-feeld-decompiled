package io.sentry;

import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnvelopeSender$$ExternalSyntheticLambda2 implements HintUtils.SentryConsumer {
    public final /* synthetic */ EnvelopeSender f$0;
    public final /* synthetic */ Throwable f$1;
    public final /* synthetic */ File f$2;

    public /* synthetic */ EnvelopeSender$$ExternalSyntheticLambda2(EnvelopeSender envelopeSender, Throwable th, File file) {
        this.f$0 = envelopeSender;
        this.f$1 = th;
        this.f$2 = file;
    }

    public final void accept(Object obj) {
        this.f$0.m869lambda$processFile$1$iosentryEnvelopeSender(this.f$1, this.f$2, (Retryable) obj);
    }
}
