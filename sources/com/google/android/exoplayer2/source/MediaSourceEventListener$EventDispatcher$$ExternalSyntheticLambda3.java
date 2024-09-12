package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaSourceEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f$0;
    public final /* synthetic */ MediaSourceEventListener f$1;
    public final /* synthetic */ LoadEventInfo f$2;
    public final /* synthetic */ MediaLoadData f$3;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f$0 = eventDispatcher;
        this.f$1 = mediaSourceEventListener;
        this.f$2 = loadEventInfo;
        this.f$3 = mediaLoadData;
    }

    public final void run() {
        this.f$0.m507lambda$loadCompleted$1$comgoogleandroidexoplayer2sourceMediaSourceEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
    }
}
