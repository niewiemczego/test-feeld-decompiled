package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda6 implements ListenerSet.Event {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Player.PositionInfo f$1;
    public final /* synthetic */ Player.PositionInfo f$2;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f$0 = i;
        this.f$1 = positionInfo;
        this.f$2 = positionInfo2;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$13(this.f$0, this.f$1, this.f$2, (Player.Listener) obj);
    }
}
