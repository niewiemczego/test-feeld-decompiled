package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FrameworkMediaDrm$$ExternalSyntheticLambda1 implements MediaDrm.OnEventListener {
    public final /* synthetic */ FrameworkMediaDrm f$0;
    public final /* synthetic */ ExoMediaDrm.OnEventListener f$1;

    public /* synthetic */ FrameworkMediaDrm$$ExternalSyntheticLambda1(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f$0 = frameworkMediaDrm;
        this.f$1 = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        this.f$0.m488lambda$setOnEventListener$1$comgoogleandroidexoplayer2drmFrameworkMediaDrm(this.f$1, mediaDrm, bArr, i, i2, bArr2);
    }
}
