package com.launchdarkly.eventsource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncEventHandler$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ AsyncEventHandler f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ MessageEvent f$2;

    public /* synthetic */ AsyncEventHandler$$ExternalSyntheticLambda4(AsyncEventHandler asyncEventHandler, String str, MessageEvent messageEvent) {
        this.f$0 = asyncEventHandler;
        this.f$1 = str;
        this.f$2 = messageEvent;
    }

    public final void run() {
        this.f$0.m609lambda$onMessage$3$comlaunchdarklyeventsourceAsyncEventHandler(this.f$1, this.f$2);
    }
}
