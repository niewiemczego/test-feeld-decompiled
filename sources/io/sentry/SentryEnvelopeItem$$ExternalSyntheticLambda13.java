package io.sentry;

import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryEnvelopeItem$$ExternalSyntheticLambda13 implements Callable {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ ProfilingTraceData f$2;
    public final /* synthetic */ ISerializer f$3;

    public /* synthetic */ SentryEnvelopeItem$$ExternalSyntheticLambda13(File file, long j, ProfilingTraceData profilingTraceData, ISerializer iSerializer) {
        this.f$0 = file;
        this.f$1 = j;
        this.f$2 = profilingTraceData;
        this.f$3 = iSerializer;
    }

    public final Object call() {
        return SentryEnvelopeItem.lambda$fromProfilingTrace$18(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
