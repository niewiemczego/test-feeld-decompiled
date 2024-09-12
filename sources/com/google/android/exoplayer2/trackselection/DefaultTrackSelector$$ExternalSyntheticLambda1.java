package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda1 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.TextTrackInfo.compareSelections((List) obj, (List) obj2);
    }
}
