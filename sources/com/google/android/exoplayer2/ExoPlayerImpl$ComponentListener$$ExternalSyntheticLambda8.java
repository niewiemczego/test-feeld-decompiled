package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8 implements ListenerSet.Event {
    public final /* synthetic */ VideoSize f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8(VideoSize videoSize) {
        this.f$0 = videoSize;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVideoSizeChanged(this.f$0);
    }
}
