package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4 implements ListenerSet.Event {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(boolean z) {
        this.f$0 = z;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f$0);
    }
}
