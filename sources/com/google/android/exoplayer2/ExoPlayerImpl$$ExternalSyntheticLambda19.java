package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda19 implements ListenerSet.Event {
    public final /* synthetic */ TrackSelectionParameters f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda19(TrackSelectionParameters trackSelectionParameters) {
        this.f$0 = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTrackSelectionParametersChanged(this.f$0);
    }
}
