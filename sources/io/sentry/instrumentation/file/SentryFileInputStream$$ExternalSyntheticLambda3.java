package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileInputStream$$ExternalSyntheticLambda3 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileInputStream f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ SentryFileInputStream$$ExternalSyntheticLambda3(SentryFileInputStream sentryFileInputStream, long j) {
        this.f$0 = sentryFileInputStream;
        this.f$1 = j;
    }

    public final Object call() {
        return this.f$0.m928lambda$skip$3$iosentryinstrumentationfileSentryFileInputStream(this.f$1);
    }
}
