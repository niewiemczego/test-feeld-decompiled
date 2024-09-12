package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileOutputStream$$ExternalSyntheticLambda2 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileOutputStream f$0;
    public final /* synthetic */ byte[] f$1;

    public /* synthetic */ SentryFileOutputStream$$ExternalSyntheticLambda2(SentryFileOutputStream sentryFileOutputStream, byte[] bArr) {
        this.f$0 = sentryFileOutputStream;
        this.f$1 = bArr;
    }

    public final Object call() {
        return this.f$0.m930lambda$write$1$iosentryinstrumentationfileSentryFileOutputStream(this.f$1);
    }
}
