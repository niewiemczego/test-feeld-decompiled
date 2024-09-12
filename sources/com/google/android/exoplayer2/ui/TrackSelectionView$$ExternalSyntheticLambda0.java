package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.ui.TrackSelectionView;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackSelectionView$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ TrackSelectionView$$ExternalSyntheticLambda0(Comparator comparator) {
        this.f$0 = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f$0.compare(((TrackSelectionView.TrackInfo) obj).getFormat(), ((TrackSelectionView.TrackInfo) obj2).getFormat());
    }
}
