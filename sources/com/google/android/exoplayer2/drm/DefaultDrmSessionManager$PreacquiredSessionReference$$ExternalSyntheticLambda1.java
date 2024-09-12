package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultDrmSessionManager$PreacquiredSessionReference$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f$0;
    public final /* synthetic */ Format f$1;

    public /* synthetic */ DefaultDrmSessionManager$PreacquiredSessionReference$$ExternalSyntheticLambda1(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f$0 = preacquiredSessionReference;
        this.f$1 = format;
    }

    public final void run() {
        this.f$0.m480lambda$acquire$0$comgoogleandroidexoplayer2drmDefaultDrmSessionManager$PreacquiredSessionReference(this.f$1);
    }
}
