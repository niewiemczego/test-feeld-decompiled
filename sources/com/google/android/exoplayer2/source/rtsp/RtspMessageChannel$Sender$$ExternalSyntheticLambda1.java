package com.google.android.exoplayer2.source.rtsp;

import android.os.HandlerThread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RtspMessageChannel$Sender$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ HandlerThread f$0;

    public /* synthetic */ RtspMessageChannel$Sender$$ExternalSyntheticLambda1(HandlerThread handlerThread) {
        this.f$0 = handlerThread;
    }

    public final void run() {
        boolean unused = this.f$0.quit();
    }
}
