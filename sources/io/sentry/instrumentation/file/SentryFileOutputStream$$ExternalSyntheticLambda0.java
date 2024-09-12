package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileOutputStream$$ExternalSyntheticLambda0 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileOutputStream f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ SentryFileOutputStream$$ExternalSyntheticLambda0(SentryFileOutputStream sentryFileOutputStream, byte[] bArr, int i, int i2) {
        this.f$0 = sentryFileOutputStream;
        this.f$1 = bArr;
        this.f$2 = i;
        this.f$3 = i2;
    }

    public final Object call() {
        return this.f$0.m931lambda$write$2$iosentryinstrumentationfileSentryFileOutputStream(this.f$1, this.f$2, this.f$3);
    }
}
