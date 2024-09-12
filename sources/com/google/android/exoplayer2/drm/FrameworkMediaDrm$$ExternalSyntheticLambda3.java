package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FrameworkMediaDrm$$ExternalSyntheticLambda3 implements MediaDrm.OnKeyStatusChangeListener {
    public final /* synthetic */ FrameworkMediaDrm f$0;
    public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener f$1;

    public /* synthetic */ FrameworkMediaDrm$$ExternalSyntheticLambda3(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        this.f$0 = frameworkMediaDrm;
        this.f$1 = onKeyStatusChangeListener;
    }

    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        this.f$0.m490lambda$setOnKeyStatusChangeListener$2$comgoogleandroidexoplayer2drmFrameworkMediaDrm(this.f$1, mediaDrm, bArr, list, z);
    }
}
