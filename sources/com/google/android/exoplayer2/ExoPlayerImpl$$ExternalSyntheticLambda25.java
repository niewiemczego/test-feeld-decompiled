package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda25 implements ListenerSet.Event {
    public final /* synthetic */ int f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda25(int i) {
        this.f$0 = i;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAudioSessionIdChanged(this.f$0);
    }
}