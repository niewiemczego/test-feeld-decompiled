package com.facebook.appevents;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ FlushReason f$0;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda2(FlushReason flushReason) {
        this.f$0 = flushReason;
    }

    public final void run() {
        AppEventQueue.m227flush$lambda2(this.f$0);
    }
}
