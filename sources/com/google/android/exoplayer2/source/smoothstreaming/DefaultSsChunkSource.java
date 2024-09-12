package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource implements SsChunkSource {
    private final ChunkExtractor[] chunkExtractors;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private ExoTrackSelection trackSelection;

    public void onChunkLoadCompleted(Chunk chunk) {
    }

    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, TransferListener transferListener) {
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, exoTrackSelection, createDataSource);
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i, ExoTrackSelection exoTrackSelection, DataSource dataSource2) {
        SsManifest ssManifest2 = ssManifest;
        int i2 = i;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest2;
        this.streamElementIndex = i2;
        this.trackSelection = exoTrackSelection2;
        this.dataSource = dataSource2;
        SsManifest.StreamElement streamElement = ssManifest2.streamElements[i2];
        this.chunkExtractors = new ChunkExtractor[exoTrackSelection.length()];
        int i3 = 0;
        while (i3 < this.chunkExtractors.length) {
            int indexInTrackGroup = exoTrackSelection2.getIndexInTrackGroup(i3);
            Format format = streamElement.formats[indexInTrackGroup];
            int i4 = i3;
            Track track = r7;
            Track track2 = new Track(indexInTrackGroup, streamElement.type, streamElement.timescale, C.TIME_UNSET, ssManifest2.durationUs, format, 0, format.drmInitData != null ? ((SsManifest.ProtectionElement) Assertions.checkNotNull(ssManifest2.protectionElement)).trackEncryptionBoxes : null, streamElement.type == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.chunkExtractors[i4] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, (TimestampAdjuster) null, track), streamElement.type, format);
            i3 = i4 + 1;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return seekParameters.resolveSeekPositionUs(j, startTimeUs, (startTimeUs >= j || chunkIndex >= streamElement.chunkCount + -1) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[this.streamElementIndex];
        if (i == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i;
        } else {
            int i2 = i - 1;
            long startTimeUs = streamElement2.getStartTimeUs(0);
            if (streamElement.getStartTimeUs(i2) + streamElement.getChunkDurationUs(i2) <= startTimeUs) {
                this.currentManifestChunkOffset += i;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs);
            }
        }
        this.manifest = ssManifest;
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j, list);
    }

    public boolean shouldCancelLoad(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j, chunk, list);
    }

    public final void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i;
        long j3 = j2;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            if (list.isEmpty()) {
                i = streamElement.getChunkIndex(j3);
                List<? extends MediaChunk> list2 = list;
            } else {
                i = (int) (((MediaChunk) list.get(list.size() - 1)).getNextChunkIndex() - ((long) this.currentManifestChunkOffset));
                if (i < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (i >= streamElement.chunkCount) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            long j4 = j3 - j;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j);
            int length = this.trackSelection.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            for (int i2 = 0; i2 < length; i2++) {
                mediaChunkIteratorArr[i2] = new StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i2), i);
            }
            this.trackSelection.updateSelectedTrack(j, j4, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            long startTimeUs = streamElement.getStartTimeUs(i);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(i);
            if (!list.isEmpty()) {
                j3 = C.TIME_UNSET;
            }
            long j5 = j3;
            int i3 = i + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            ChunkExtractor chunkExtractor = this.chunkExtractors[selectedIndex];
            Uri buildRequestUri = streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), i);
            chunkHolder2.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, buildRequestUri, i3, startTimeUs, chunkDurationUs, j5, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), chunkExtractor);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(TrackSelectionUtil.createFallbackOptions(this.trackSelection), loadErrorInfo);
        if (z && fallbackSelectionFor != null && fallbackSelectionFor.type == 2) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            if (exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs)) {
                return true;
            }
        }
        return false;
    }

    public void release() {
        for (ChunkExtractor release : this.chunkExtractors) {
            release.release();
        }
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource2, Uri uri, int i, long j, long j2, long j3, int i2, Object obj, ChunkExtractor chunkExtractor) {
        DataSource dataSource3 = dataSource2;
        long j4 = j2;
        long j5 = j3;
        int i3 = i2;
        Object obj2 = obj;
        DataSpec dataSpec = r0;
        DataSpec dataSpec2 = new DataSpec(uri);
        return new ContainerMediaChunk(dataSource3, dataSpec, format, i3, obj2, j, j4, j5, C.TIME_UNSET, (long) i, 1, j, chunkExtractor);
    }

    private long resolveTimeToLiveEdgeUs(long j) {
        if (!this.manifest.isLive) {
            return C.TIME_UNSET;
        }
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int i = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i) + streamElement.getChunkDurationUs(i)) - j;
    }

    private static final class StreamElementIterator extends BaseMediaChunkIterator {
        private final SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(SsManifest.StreamElement streamElement2, int i, int i2) {
            super((long) i2, (long) (streamElement2.chunkCount - 1));
            this.streamElement = streamElement2;
            this.trackIndex = i;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            return new DataSpec(this.streamElement.buildRequestUri(this.trackIndex, (int) getCurrentIndex()));
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.streamElement.getStartTimeUs((int) getCurrentIndex());
        }

        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.streamElement.getChunkDurationUs((int) getCurrentIndex());
        }
    }
}
