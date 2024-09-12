package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    TrackGroupArray getTrackGroups();

    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    void reevaluateBuffer(long j);

    long seekToUs(long j);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return Collections.emptyList();
    }
}
