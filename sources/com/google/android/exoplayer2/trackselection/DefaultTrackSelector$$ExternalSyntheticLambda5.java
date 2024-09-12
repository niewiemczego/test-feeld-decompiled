package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda5 implements DefaultTrackSelector.TrackInfo.Factory {
    public final /* synthetic */ DefaultTrackSelector.Parameters f$0;
    public final /* synthetic */ int[] f$1;

    public /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda5(DefaultTrackSelector.Parameters parameters, int[] iArr) {
        this.f$0 = parameters;
        this.f$1 = iArr;
    }

    public final List create(int i, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.VideoTrackInfo.createForTrackGroup(i, trackGroup, this.f$0, iArr, this.f$1[i]);
    }
}
