package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda28 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda28(PlaybackInfo playbackInfo, int i) {
        this.f$0 = playbackInfo;
        this.f$1 = i;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f$0.timeline, this.f$1);
    }
}
