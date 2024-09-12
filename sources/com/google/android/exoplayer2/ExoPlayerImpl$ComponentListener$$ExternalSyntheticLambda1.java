package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda1 implements ListenerSet.Event {
    public final /* synthetic */ Metadata f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda1(Metadata metadata) {
        this.f$0 = metadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMetadata(this.f$0);
    }
}
