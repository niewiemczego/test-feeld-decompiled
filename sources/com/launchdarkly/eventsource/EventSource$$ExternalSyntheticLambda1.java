package com.launchdarkly.eventsource;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventSource$$ExternalSyntheticLambda1 implements ThreadFactory {
    public final /* synthetic */ EventSource f$0;
    public final /* synthetic */ ThreadFactory f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ AtomicLong f$3;
    public final /* synthetic */ Integer f$4;

    public /* synthetic */ EventSource$$ExternalSyntheticLambda1(EventSource eventSource, ThreadFactory threadFactory, String str, AtomicLong atomicLong, Integer num) {
        this.f$0 = eventSource;
        this.f$1 = threadFactory;
        this.f$2 = str;
        this.f$3 = atomicLong;
        this.f$4 = num;
    }

    public final Thread newThread(Runnable runnable) {
        return this.f$0.m611lambda$createThreadFactory$0$comlaunchdarklyeventsourceEventSource(this.f$1, this.f$2, this.f$3, this.f$4, runnable);
    }
}
