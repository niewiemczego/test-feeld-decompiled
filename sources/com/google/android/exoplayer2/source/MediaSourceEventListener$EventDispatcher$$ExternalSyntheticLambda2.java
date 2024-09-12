package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f$0;
    public final /* synthetic */ MediaSourceEventListener f$1;
    public final /* synthetic */ LoadEventInfo f$2;
    public final /* synthetic */ MediaLoadData f$3;
    public final /* synthetic */ IOException f$4;
    public final /* synthetic */ boolean f$5;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.f$0 = eventDispatcher;
        this.f$1 = mediaSourceEventListener;
        this.f$2 = loadEventInfo;
        this.f$3 = mediaLoadData;
        this.f$4 = iOException;
        this.f$5 = z;
    }

    public final void run() {
        this.f$0.m508lambda$loadError$3$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
