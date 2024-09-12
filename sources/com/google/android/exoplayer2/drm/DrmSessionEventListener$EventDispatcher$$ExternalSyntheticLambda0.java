package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f$0;
    public final /* synthetic */ DrmSessionEventListener f$1;

    public /* synthetic */ DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda0(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f$0 = eventDispatcher;
        this.f$1 = drmSessionEventListener;
    }

    public final void run() {
        this.f$0.m487lambda$drmSessionReleased$5$comgoogleandroidexoplayer2drmDrmSessionEventListener$EventDispatcher(this.f$1);
    }
}
