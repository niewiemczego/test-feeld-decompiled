package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaItem$RequestMetadata$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return new MediaItem.RequestMetadata.Builder().setMediaUri((Uri) bundle.getParcelable(MediaItem.RequestMetadata.keyForField(0))).setSearchQuery(bundle.getString(MediaItem.RequestMetadata.keyForField(1))).setExtras(bundle.getBundle(MediaItem.RequestMetadata.keyForField(2))).build();
    }
}
