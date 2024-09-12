package io.sentry;

import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OutboxSender$$ExternalSyntheticLambda0 implements HintUtils.SentryConsumer {
    public final /* synthetic */ OutboxSender f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ OutboxSender$$ExternalSyntheticLambda0(OutboxSender outboxSender, File file) {
        this.f$0 = outboxSender;
        this.f$1 = file;
    }

    public final void accept(Object obj) {
        this.f$0.m874lambda$processFile$0$iosentryOutboxSender(this.f$1, (Retryable) obj);
    }
}
