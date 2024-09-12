package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaItem$ClippingConfiguration$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(bundle.getLong(MediaItem.ClippingConfiguration.keyForField(0), 0)).setEndPositionMs(bundle.getLong(MediaItem.ClippingConfiguration.keyForField(1), Long.MIN_VALUE)).setRelativeToLiveWindow(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(2), false)).setRelativeToDefaultPosition(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(3), false)).setStartsAtKeyFrame(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(4), false)).buildClippingProperties();
    }
}
