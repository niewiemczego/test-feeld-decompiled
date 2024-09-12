package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileInputStream$$ExternalSyntheticLambda0 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileInputStream f$0;
    public final /* synthetic */ AtomicInteger f$1;

    public /* synthetic */ SentryFileInputStream$$ExternalSyntheticLambda0(SentryFileInputStream sentryFileInputStream, AtomicInteger atomicInteger) {
        this.f$0 = sentryFileInputStream;
        this.f$1 = atomicInteger;
    }

    public final Object call() {
        return this.f$0.m925lambda$read$0$iosentryinstrumentationfileSentryFileInputStream(this.f$1);
    }
}
