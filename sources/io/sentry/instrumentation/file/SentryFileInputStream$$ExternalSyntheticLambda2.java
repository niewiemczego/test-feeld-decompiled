package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileInputStream$$ExternalSyntheticLambda2 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileInputStream f$0;
    public final /* synthetic */ byte[] f$1;

    public /* synthetic */ SentryFileInputStream$$ExternalSyntheticLambda2(SentryFileInputStream sentryFileInputStream, byte[] bArr) {
        this.f$0 = sentryFileInputStream;
        this.f$1 = bArr;
    }

    public final Object call() {
        return this.f$0.m926lambda$read$1$iosentryinstrumentationfileSentryFileInputStream(this.f$1);
    }
}
