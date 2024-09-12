package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_HEIGHT_TO_DISCARD = 719;
    public static final int DEFAULT_MAX_WIDTH_TO_DISCARD = 1279;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000;
    private static final String TAG = "AdaptiveTrackSelection";
    private final ImmutableList<AdaptationCheckpoint> adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxHeightToDiscard;
    private final int maxWidthToDiscard;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    /* access modifiers changed from: protected */
    public boolean canSelectFormat(Format format, int i, long j) {
        return ((long) i) <= j;
    }

    public Object getSelectionData() {
        return null;
    }

    public static class Factory implements ExoTrackSelection.Factory {
        private final float bandwidthFraction;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxHeightToDiscard;
        private final int maxWidthToDiscard;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public Factory(int i, int i2, int i3, float f) {
            this(i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, int i4, int i5, float f) {
            this(i, i2, i3, i4, i5, f, 0.75f, Clock.DEFAULT);
        }

        public Factory(int i, int i2, int i3, float f, float f2, Clock clock2) {
            this(i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, f2, clock2);
        }

        public Factory(int i, int i2, int i3, int i4, int i5, float f, float f2, Clock clock2) {
            this.minDurationForQualityIncreaseMs = i;
            this.maxDurationForQualityDecreaseMs = i2;
            this.minDurationToRetainAfterDiscardMs = i3;
            this.maxWidthToDiscard = i4;
            this.maxHeightToDiscard = i5;
            this.bandwidthFraction = f;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
            this.clock = clock2;
        }

        public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            ExoTrackSelection exoTrackSelection;
            ExoTrackSelection.Definition[] definitionArr2 = definitionArr;
            ImmutableList access$000 = AdaptiveTrackSelection.getAdaptationCheckpoints(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr2.length];
            for (int i = 0; i < definitionArr2.length; i++) {
                ExoTrackSelection.Definition definition = definitionArr2[i];
                if (!(definition == null || definition.tracks.length == 0)) {
                    if (definition.tracks.length == 1) {
                        exoTrackSelection = new FixedTrackSelection(definition.group, definition.tracks[0], definition.type);
                    } else {
                        exoTrackSelection = createAdaptiveTrackSelection(definition.group, definition.tracks, definition.type, bandwidthMeter, (ImmutableList) access$000.get(i));
                    }
                    exoTrackSelectionArr[i] = exoTrackSelection;
                }
            }
            return exoTrackSelectionArr;
        }

        /* access modifiers changed from: protected */
        public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i, bandwidthMeter, (long) this.minDurationForQualityIncreaseMs, (long) this.maxDurationForQualityDecreaseMs, (long) this.minDurationToRetainAfterDiscardMs, this.maxWidthToDiscard, this.maxHeightToDiscard, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, immutableList, this.clock);
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter2) {
        this(trackGroup, iArr, 0, bandwidthMeter2, 10000, 25000, 25000, DEFAULT_MAX_WIDTH_TO_DISCARD, DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, ImmutableList.of(), Clock.DEFAULT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter2, long j, long j2, long j3, int i2, int i3, float f, float f2, List<AdaptationCheckpoint> list, Clock clock2) {
        super(trackGroup, iArr, i);
        BandwidthMeter bandwidthMeter3;
        long j4;
        if (j3 < j) {
            Log.w(TAG, "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter3 = bandwidthMeter2;
            j4 = j;
        } else {
            bandwidthMeter3 = bandwidthMeter2;
            j4 = j3;
        }
        this.bandwidthMeter = bandwidthMeter3;
        this.minDurationForQualityIncreaseUs = j * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j4 * 1000;
        this.maxWidthToDiscard = i2;
        this.maxHeightToDiscard = i3;
        this.bandwidthFraction = f;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
        this.adaptationCheckpoints = ImmutableList.copyOf(list);
        this.clock = clock2;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = C.TIME_UNSET;
    }

    public void enable() {
        this.lastBufferEvaluationMs = C.TIME_UNSET;
        this.lastBufferEvaluationMediaChunk = null;
    }

    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
    }

    public void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        long nextChunkDurationUs = getNextChunkDurationUs(mediaChunkIteratorArr, list);
        int i = this.reason;
        if (i == 0) {
            this.reason = 1;
            this.selectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
            return;
        }
        int i2 = this.selectedIndex;
        int indexOf = list.isEmpty() ? -1 : indexOf(((MediaChunk) Iterables.getLast(list)).trackFormat);
        if (indexOf != -1) {
            i = ((MediaChunk) Iterables.getLast(list)).trackSelectionReason;
            i2 = indexOf;
        }
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime, nextChunkDurationUs);
        if (!isBlacklisted(i2, elapsedRealtime)) {
            Format format = getFormat(i2);
            Format format2 = getFormat(determineIdealSelectedIndex);
            long minDurationForQualityIncreaseUs2 = minDurationForQualityIncreaseUs(j3, nextChunkDurationUs);
            if ((format2.bitrate > format.bitrate && j2 < minDurationForQualityIncreaseUs2) || (format2.bitrate < format.bitrate && j2 >= this.maxDurationForQualityDecreaseUs)) {
                determineIdealSelectedIndex = i2;
            }
        }
        if (determineIdealSelectedIndex != i2) {
            i = 3;
        }
        this.reason = i;
        this.selectedIndex = determineIdealSelectedIndex;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public int evaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        if (!shouldEvaluateQueueSize(elapsedRealtime, list)) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        this.lastBufferEvaluationMediaChunk = list.isEmpty() ? null : (MediaChunk) Iterables.getLast(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(((MediaChunk) list.get(size - 1)).startTimeUs - j, this.playbackSpeed);
        long minDurationToRetainAfterDiscardUs2 = getMinDurationToRetainAfterDiscardUs();
        if (playoutDurationForMediaDuration < minDurationToRetainAfterDiscardUs2) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime, getLastChunkDurationUs(list)));
        for (int i = 0; i < size; i++) {
            MediaChunk mediaChunk = (MediaChunk) list.get(i);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j, this.playbackSpeed) >= minDurationToRetainAfterDiscardUs2 && format2.bitrate < format.bitrate && format2.height != -1 && format2.height <= this.maxHeightToDiscard && format2.width != -1 && format2.width <= this.maxWidthToDiscard && format2.height < format.height) {
                return i;
            }
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public boolean shouldEvaluateQueueSize(long j, List<? extends MediaChunk> list) {
        long j2 = this.lastBufferEvaluationMs;
        return j2 == C.TIME_UNSET || j - j2 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.getLast(list)).equals(this.lastBufferEvaluationMediaChunk));
    }

    /* access modifiers changed from: protected */
    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    private int determineIdealSelectedIndex(long j, long j2) {
        long allocatedBandwidth = getAllocatedBandwidth(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !isBlacklisted(i2, j)) {
                Format format = getFormat(i2);
                if (canSelectFormat(format, format.bitrate, allocatedBandwidth)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long minDurationForQualityIncreaseUs(long j, long j2) {
        if (j == C.TIME_UNSET) {
            return this.minDurationForQualityIncreaseUs;
        }
        if (j2 != C.TIME_UNSET) {
            j -= j2;
        }
        return Math.min((long) (((float) j) * this.bufferedFractionToLiveEdgeForQualityIncrease), this.minDurationForQualityIncreaseUs);
    }

    private long getNextChunkDurationUs(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i = this.selectedIndex;
        if (i >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i].next()) {
            for (MediaChunkIterator mediaChunkIterator : mediaChunkIteratorArr) {
                if (mediaChunkIterator.next()) {
                    return mediaChunkIterator.getChunkEndTimeUs() - mediaChunkIterator.getChunkStartTimeUs();
                }
            }
            return getLastChunkDurationUs(list);
        }
        MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.selectedIndex];
        return mediaChunkIterator2.getChunkEndTimeUs() - mediaChunkIterator2.getChunkStartTimeUs();
    }

    private long getLastChunkDurationUs(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.getLast(list);
        if (mediaChunk.startTimeUs == C.TIME_UNSET || mediaChunk.endTimeUs == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return mediaChunk.endTimeUs - mediaChunk.startTimeUs;
    }

    private long getAllocatedBandwidth(long j) {
        long totalAllocatableBandwidth = getTotalAllocatableBandwidth(j);
        if (this.adaptationCheckpoints.isEmpty()) {
            return totalAllocatableBandwidth;
        }
        int i = 1;
        while (i < this.adaptationCheckpoints.size() - 1 && ((AdaptationCheckpoint) this.adaptationCheckpoints.get(i)).totalBandwidth < totalAllocatableBandwidth) {
            i++;
        }
        AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) this.adaptationCheckpoints.get(i - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = (AdaptationCheckpoint) this.adaptationCheckpoints.get(i);
        return adaptationCheckpoint.allocatedBandwidth + ((long) ((((float) (totalAllocatableBandwidth - adaptationCheckpoint.totalBandwidth)) / ((float) (adaptationCheckpoint2.totalBandwidth - adaptationCheckpoint.totalBandwidth))) * ((float) (adaptationCheckpoint2.allocatedBandwidth - adaptationCheckpoint.allocatedBandwidth))));
    }

    private long getTotalAllocatableBandwidth(long j) {
        long bitrateEstimate = (long) (((float) this.bandwidthMeter.getBitrateEstimate()) * this.bandwidthFraction);
        long timeToFirstByteEstimateUs = this.bandwidthMeter.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == C.TIME_UNSET || j == C.TIME_UNSET) {
            return (long) (((float) bitrateEstimate) / this.playbackSpeed);
        }
        float f = (float) j;
        return (long) ((((float) bitrateEstimate) * Math.max((f / this.playbackSpeed) - ((float) timeToFirstByteEstimateUs), 0.0f)) / f);
    }

    /* access modifiers changed from: private */
    public static ImmutableList<ImmutableList<AdaptationCheckpoint>> getAdaptationCheckpoints(ExoTrackSelection.Definition[] definitionArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.tracks.length <= 1) {
                arrayList.add((Object) null);
            } else {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.add((Object) new AdaptationCheckpoint(0, 0));
                arrayList.add(builder);
            }
        }
        long[][] sortedTrackBitrates = getSortedTrackBitrates(definitionArr);
        int[] iArr = new int[sortedTrackBitrates.length];
        long[] jArr = new long[sortedTrackBitrates.length];
        for (int i = 0; i < sortedTrackBitrates.length; i++) {
            long[] jArr2 = sortedTrackBitrates[i];
            jArr[i] = jArr2.length == 0 ? 0 : jArr2[0];
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList<Integer> switchOrder = getSwitchOrder(sortedTrackBitrates);
        for (int i2 = 0; i2 < switchOrder.size(); i2++) {
            int intValue = ((Integer) switchOrder.get(i2)).intValue();
            int i3 = iArr[intValue] + 1;
            iArr[intValue] = i3;
            jArr[intValue] = sortedTrackBitrates[intValue][i3];
            addCheckpoint(arrayList, jArr);
        }
        for (int i4 = 0; i4 < definitionArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        addCheckpoint(arrayList, jArr);
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ImmutableList.Builder builder3 = (ImmutableList.Builder) arrayList.get(i5);
            builder2.add((Object) builder3 == null ? ImmutableList.of() : builder3.build());
        }
        return builder2.build();
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i = 0; i < definitionArr.length; i++) {
            ExoTrackSelection.Definition definition = definitionArr[i];
            if (definition == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[definition.tracks.length];
                for (int i2 = 0; i2 < definition.tracks.length; i2++) {
                    jArr[i][i2] = (long) definition.group.getFormat(definition.tracks[i2]).bitrate;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static ImmutableList<Integer> getSwitchOrder(long[][] jArr) {
        double d;
        long[][] jArr2 = jArr;
        ListMultimap<K, V> build = MultimapBuilder.treeKeys().arrayListValues().build();
        for (int i = 0; i < jArr2.length; i++) {
            long[] jArr3 = jArr2[i];
            if (jArr3.length > 1) {
                int length = jArr3.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr4 = jArr2[i];
                    double d2 = 0.0d;
                    if (i2 >= jArr4.length) {
                        break;
                    }
                    long j = jArr4[i2];
                    if (j != -1) {
                        d2 = Math.log((double) j);
                    }
                    dArr[i2] = d2;
                    i2++;
                }
                int i3 = length - 1;
                double d3 = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d4 = dArr[i4];
                    i4++;
                    double d5 = (d4 + dArr[i4]) * 0.5d;
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = (d5 - dArr[0]) / d3;
                    }
                    build.put(Double.valueOf(d), Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf(build.values());
    }

    private static void addCheckpoint(List<ImmutableList.Builder<AdaptationCheckpoint>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList.Builder builder = list.get(i);
            if (builder != null) {
                builder.add((Object) new AdaptationCheckpoint(j, jArr[i]));
            }
        }
    }

    public static final class AdaptationCheckpoint {
        public final long allocatedBandwidth;
        public final long totalBandwidth;

        public AdaptationCheckpoint(long j, long j2) {
            this.totalBandwidth = j;
            this.allocatedBandwidth = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            if (this.totalBandwidth == adaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptationCheckpoint.allocatedBandwidth) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
        }
    }
}
