package com.google.android.exoplayer2.source;

import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final HashMap<TrackGroup, TrackGroup> childTrackGroupByMergedTrackGroup = new HashMap<>();
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    private final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
        this.enabledPeriods = new MediaPeriod[0];
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            if (jArr[i] != 0) {
                this.periods[i] = new TimeOffsetMediaPeriod(mediaPeriodArr[i], jArr[i]);
            }
        }
    }

    public MediaPeriod getChildPeriod(int i) {
        MediaPeriod mediaPeriod = this.periods[i];
        return mediaPeriod instanceof TimeOffsetMediaPeriod ? ((TimeOffsetMediaPeriod) mediaPeriod).mediaPeriod : mediaPeriod;
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j);
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        Integer num;
        int i;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        int i2 = 0;
        while (true) {
            num = 0;
            if (i2 >= exoTrackSelectionArr2.length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr2[i2];
            if (sampleStream != null) {
                num = this.streamPeriodIndices.get(sampleStream);
            }
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i2];
            if (exoTrackSelection != null) {
                TrackGroup trackGroup = (TrackGroup) Assertions.checkNotNull(this.childTrackGroupByMergedTrackGroup.get(exoTrackSelection.getTrackGroup()));
                int i3 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i3 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i3].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
        this.streamPeriodIndices.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.periods.length) {
            for (int i5 = 0; i5 < exoTrackSelectionArr2.length; i5++) {
                sampleStreamArr4[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : num;
                if (iArr2[i5] == i4) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.checkNotNull(exoTrackSelectionArr2[i5]);
                    exoTrackSelectionArr3[i5] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.checkNotNull(this.childTrackGroupByMergedTrackGroup.get(exoTrackSelection2.getTrackGroup())));
                } else {
                    exoTrackSelectionArr3[i5] = num;
                }
            }
            int i6 = i4;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            long selectTracks = this.periods[i4].selectTracks(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < exoTrackSelectionArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    sampleStreamArr3[i7] = sampleStreamArr4[i7];
                    this.streamPeriodIndices.put((SampleStream) Assertions.checkNotNull(sampleStreamArr4[i7]), Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (sampleStreamArr4[i7] != null) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.periods[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            num = null;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        MediaPeriod[] mediaPeriodArr2 = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[0]);
        this.enabledPeriods = mediaPeriodArr2;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(mediaPeriodArr2);
        return j2;
    }

    public void discardBuffer(long j, boolean z) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j, z);
        }
    }

    public void reevaluateBuffer(long j) {
        this.compositeSequenceableLoader.reevaluateBuffer(j);
    }

    public boolean continueLoading(long j) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i = 0; i < size; i++) {
            this.childrenPendingPreparation.get(i).continueLoading(j);
        }
        return false;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public long readDiscontinuity() {
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                if (j == C.TIME_UNSET) {
                    MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
                    int length = mediaPeriodArr.length;
                    int i = 0;
                    while (i < length) {
                        MediaPeriod mediaPeriod2 = mediaPeriodArr[i];
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = readDiscontinuity;
                } else if (readDiscontinuity != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == C.TIME_UNSET || mediaPeriod.seekToUs(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long seekToUs(long j) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) == seekToUs) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.periods[0]).getAdjustedSeekPositionUs(j, seekParameters);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                MediaPeriod[] mediaPeriodArr = this.periods;
                if (i2 < mediaPeriodArr.length) {
                    TrackGroupArray trackGroups3 = mediaPeriodArr[i2].getTrackGroups();
                    int i4 = trackGroups3.length;
                    int i5 = 0;
                    while (i5 < i4) {
                        TrackGroup trackGroup = trackGroups3.get(i5);
                        TrackGroup copyWithId = trackGroup.copyWithId(i2 + CertificateUtil.DELIMITER + trackGroup.id);
                        this.childTrackGroupByMergedTrackGroup.put(copyWithId, trackGroup);
                        trackGroupArr[i3] = copyWithId;
                        i5++;
                        i3++;
                    }
                    i2++;
                } else {
                    this.trackGroups = new TrackGroupArray(trackGroupArr);
                    ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
                    return;
                }
            }
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    private static final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private MediaPeriod.Callback callback;
        /* access modifiers changed from: private */
        public final MediaPeriod mediaPeriod;
        private final long timeOffsetUs;

        public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod2, long j) {
            this.mediaPeriod = mediaPeriod2;
            this.timeOffsetUs = j;
        }

        public void prepare(MediaPeriod.Callback callback2, long j) {
            this.callback = callback2;
            this.mediaPeriod.prepare(this, j - this.timeOffsetUs);
        }

        public void maybeThrowPrepareError() throws IOException {
            this.mediaPeriod.maybeThrowPrepareError();
        }

        public TrackGroupArray getTrackGroups() {
            return this.mediaPeriod.getTrackGroups();
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.mediaPeriod.getStreamKeys(list);
        }

        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
            int i = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i >= sampleStreamArr2.length) {
                    break;
                }
                TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr2[i];
                if (timeOffsetSampleStream != null) {
                    sampleStream = timeOffsetSampleStream.getChildStream();
                }
                sampleStreamArr3[i] = sampleStream;
                i++;
            }
            long selectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, j - this.timeOffsetUs);
            for (int i2 = 0; i2 < sampleStreamArr2.length; i2++) {
                SampleStream sampleStream2 = sampleStreamArr3[i2];
                if (sampleStream2 == null) {
                    sampleStreamArr2[i2] = null;
                } else {
                    SampleStream sampleStream3 = sampleStreamArr2[i2];
                    if (sampleStream3 == null || ((TimeOffsetSampleStream) sampleStream3).getChildStream() != sampleStream2) {
                        sampleStreamArr2[i2] = new TimeOffsetSampleStream(sampleStream2, this.timeOffsetUs);
                    }
                }
            }
            return selectTracks + this.timeOffsetUs;
        }

        public void discardBuffer(long j, boolean z) {
            this.mediaPeriod.discardBuffer(j - this.timeOffsetUs, z);
        }

        public long readDiscontinuity() {
            long readDiscontinuity = this.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return this.timeOffsetUs + readDiscontinuity;
        }

        public long seekToUs(long j) {
            return this.mediaPeriod.seekToUs(j - this.timeOffsetUs) + this.timeOffsetUs;
        }

        public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return this.mediaPeriod.getAdjustedSeekPositionUs(j - this.timeOffsetUs, seekParameters) + this.timeOffsetUs;
        }

        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.timeOffsetUs + bufferedPositionUs;
        }

        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.timeOffsetUs + nextLoadPositionUs;
        }

        public boolean continueLoading(long j) {
            return this.mediaPeriod.continueLoading(j - this.timeOffsetUs);
        }

        public boolean isLoading() {
            return this.mediaPeriod.isLoading();
        }

        public void reevaluateBuffer(long j) {
            this.mediaPeriod.reevaluateBuffer(j - this.timeOffsetUs);
        }

        public void onPrepared(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    private static final class TimeOffsetSampleStream implements SampleStream {
        private final SampleStream sampleStream;
        private final long timeOffsetUs;

        public TimeOffsetSampleStream(SampleStream sampleStream2, long j) {
            this.sampleStream = sampleStream2;
            this.timeOffsetUs = j;
        }

        public SampleStream getChildStream() {
            return this.sampleStream;
        }

        public boolean isReady() {
            return this.sampleStream.isReady();
        }

        public void maybeThrowError() throws IOException {
            this.sampleStream.maybeThrowError();
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            int readData = this.sampleStream.readData(formatHolder, decoderInputBuffer, i);
            if (readData == -4) {
                decoderInputBuffer.timeUs = Math.max(0, decoderInputBuffer.timeUs + this.timeOffsetUs);
            }
            return readData;
        }

        public int skipData(long j) {
            return this.sampleStream.skipData(j - this.timeOffsetUs);
        }
    }

    private static final class ForwardingTrackSelection implements ExoTrackSelection {
        private final TrackGroup trackGroup;
        private final ExoTrackSelection trackSelection;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup2) {
            this.trackSelection = exoTrackSelection;
            this.trackGroup = trackGroup2;
        }

        public int getType() {
            return this.trackSelection.getType();
        }

        public TrackGroup getTrackGroup() {
            return this.trackGroup;
        }

        public int length() {
            return this.trackSelection.length();
        }

        public Format getFormat(int i) {
            return this.trackSelection.getFormat(i);
        }

        public int getIndexInTrackGroup(int i) {
            return this.trackSelection.getIndexInTrackGroup(i);
        }

        public int indexOf(Format format) {
            return this.trackSelection.indexOf(format);
        }

        public int indexOf(int i) {
            return this.trackSelection.indexOf(i);
        }

        public void enable() {
            this.trackSelection.enable();
        }

        public void disable() {
            this.trackSelection.disable();
        }

        public Format getSelectedFormat() {
            return this.trackSelection.getSelectedFormat();
        }

        public int getSelectedIndexInTrackGroup() {
            return this.trackSelection.getSelectedIndexInTrackGroup();
        }

        public int getSelectedIndex() {
            return this.trackSelection.getSelectedIndex();
        }

        public int getSelectionReason() {
            return this.trackSelection.getSelectionReason();
        }

        public Object getSelectionData() {
            return this.trackSelection.getSelectionData();
        }

        public void onPlaybackSpeed(float f) {
            this.trackSelection.onPlaybackSpeed(f);
        }

        public void onDiscontinuity() {
            this.trackSelection.onDiscontinuity();
        }

        public void onRebuffer() {
            this.trackSelection.onRebuffer();
        }

        public void onPlayWhenReadyChanged(boolean z) {
            this.trackSelection.onPlayWhenReadyChanged(z);
        }

        public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.trackSelection.updateSelectedTrack(j, j2, j3, list, mediaChunkIteratorArr);
        }

        public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
            return this.trackSelection.evaluateQueueSize(j, list);
        }

        public boolean shouldCancelChunkLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
            return this.trackSelection.shouldCancelChunkLoad(j, chunk, list);
        }

        public boolean blacklist(int i, long j) {
            return this.trackSelection.blacklist(i, j);
        }

        public boolean isBlacklisted(int i, long j) {
            return this.trackSelection.isBlacklisted(i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            if (!this.trackSelection.equals(forwardingTrackSelection.trackSelection) || !this.trackGroup.equals(forwardingTrackSelection.trackGroup)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((527 + this.trackGroup.hashCode()) * 31) + this.trackSelection.hashCode();
        }
    }
}
