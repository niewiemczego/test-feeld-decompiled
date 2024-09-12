package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    public int getSelectedIndex() {
        return 0;
    }

    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2) {
        this(trackGroup, i, i2, 0, (Object) null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2, int i3, Object obj) {
        super(trackGroup, new int[]{i}, i2);
        this.reason = i3;
        this.data = obj;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public Object getSelectionData() {
        return this.data;
    }
}
