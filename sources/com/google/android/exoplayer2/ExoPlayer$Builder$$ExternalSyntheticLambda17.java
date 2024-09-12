package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda17 implements Supplier {
    public final /* synthetic */ MediaSource.Factory f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda17(MediaSource.Factory factory) {
        this.f$0 = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setMediaSourceFactory$17(this.f$0);
    }
}
