package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f$0;
    public final /* synthetic */ DrmSessionEventListener f$1;
    public final /* synthetic */ Exception f$2;

    public /* synthetic */ DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda1(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.f$0 = eventDispatcher;
        this.f$1 = drmSessionEventListener;
        this.f$2 = exc;
    }

    public final void run() {
        this.f$0.m486lambda$drmSessionManagerError$2$comgoogleandroidexoplayer2drmDrmSessionEventListener$EventDispatcher(this.f$1, this.f$2);
    }
}
