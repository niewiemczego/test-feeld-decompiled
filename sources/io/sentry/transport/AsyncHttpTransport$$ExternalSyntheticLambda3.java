package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.cache.IEnvelopeCache;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncHttpTransport$$ExternalSyntheticLambda3 implements RejectedExecutionHandler {
    public final /* synthetic */ IEnvelopeCache f$0;
    public final /* synthetic */ ILogger f$1;

    public /* synthetic */ AsyncHttpTransport$$ExternalSyntheticLambda3(IEnvelopeCache iEnvelopeCache, ILogger iLogger) {
        this.f$0 = iEnvelopeCache;
        this.f$1 = iLogger;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        AsyncHttpTransport.lambda$initExecutor$1(this.f$0, this.f$1, runnable, threadPoolExecutor);
    }
}
