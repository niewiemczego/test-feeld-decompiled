package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Tracks$Group$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return TrackGroup.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle.getBundle(Tracks.Group.keyForField(0))));
    }
}
