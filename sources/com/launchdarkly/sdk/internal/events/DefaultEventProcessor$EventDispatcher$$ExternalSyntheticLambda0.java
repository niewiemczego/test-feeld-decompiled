package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.internal.events.DefaultEventProcessor;
import java.lang.Thread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ DefaultEventProcessor.EventDispatcher f$0;

    public /* synthetic */ DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda0(DefaultEventProcessor.EventDispatcher eventDispatcher) {
        this.f$0 = eventDispatcher;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        this.f$0.onUncaughtException(thread, th);
    }
}
