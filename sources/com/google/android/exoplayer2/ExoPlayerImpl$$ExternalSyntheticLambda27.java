package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda27 implements ListenerSet.Event {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda27(boolean z) {
        this.f$0 = z;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f$0);
    }
}
