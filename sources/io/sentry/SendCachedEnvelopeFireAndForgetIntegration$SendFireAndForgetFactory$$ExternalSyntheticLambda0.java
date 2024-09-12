package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$$ExternalSyntheticLambda0 implements SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget {
    public final /* synthetic */ ILogger f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ DirectoryProcessor f$2;
    public final /* synthetic */ File f$3;

    public /* synthetic */ SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$$ExternalSyntheticLambda0(ILogger iLogger, String str, DirectoryProcessor directoryProcessor, File file) {
        this.f$0 = iLogger;
        this.f$1 = str;
        this.f$2 = directoryProcessor;
        this.f$3 = file;
    }

    public final void send() {
        SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.lambda$processDir$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
