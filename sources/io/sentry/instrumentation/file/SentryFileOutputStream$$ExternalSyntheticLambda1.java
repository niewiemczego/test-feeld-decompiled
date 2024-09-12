package io.sentry.instrumentation.file;

import io.sentry.instrumentation.file.FileIOSpanManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFileOutputStream$$ExternalSyntheticLambda1 implements FileIOSpanManager.FileIOCallable {
    public final /* synthetic */ SentryFileOutputStream f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SentryFileOutputStream$$ExternalSyntheticLambda1(SentryFileOutputStream sentryFileOutputStream, int i) {
        this.f$0 = sentryFileOutputStream;
        this.f$1 = i;
    }

    public final Object call() {
        return this.f$0.m929lambda$write$0$iosentryinstrumentationfileSentryFileOutputStream(this.f$1);
    }
}
