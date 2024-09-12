package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda0 implements DefaultTrackSelector.TrackInfo.Factory {
    public final /* synthetic */ DefaultTrackSelector.Parameters f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda0(DefaultTrackSelector.Parameters parameters, String str) {
        this.f$0 = parameters;
        this.f$1 = str;
    }

    public final List create(int i, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.TextTrackInfo.createForTrackGroup(i, trackGroup, this.f$0, iArr, this.f$1);
    }
}
