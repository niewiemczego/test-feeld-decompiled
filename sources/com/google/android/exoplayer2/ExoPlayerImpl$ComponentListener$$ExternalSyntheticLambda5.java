package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda5 implements ListenerSet.Event {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda5(int i, boolean z) {
        this.f$0 = i;
        this.f$1 = z;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f$0, this.f$1);
    }
}
