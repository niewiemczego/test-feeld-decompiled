package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final BaseUrlExclusionList baseUrlExclusionList;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    protected final RepresentationHolder[] representationHolders;
    private ExoTrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final ChunkExtractor.Factory chunkExtractorFactory;
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(DataSource.Factory factory, int i) {
            this(BundledChunkExtractor.FACTORY, factory, i);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i) {
            this.chunkExtractorFactory = factory;
            this.dataSourceFactory = factory2;
            this.maxSegmentsPerLoad = i;
        }

        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, long j, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(this.chunkExtractorFactory, loaderErrorThrower, dashManifest, baseUrlExclusionList, i, iArr, exoTrackSelection, i2, createDataSource, j, this.maxSegmentsPerLoad, z, list, playerTrackEmsgHandler, playerId);
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList2, int i, int[] iArr, ExoTrackSelection exoTrackSelection, int i2, DataSource dataSource2, long j, int i3, boolean z, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2, PlayerId playerId) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList3 = baseUrlExclusionList2;
        int i4 = i;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest2;
        this.baseUrlExclusionList = baseUrlExclusionList3;
        this.adaptationSetIndices = iArr;
        this.trackSelection = exoTrackSelection2;
        this.trackType = i2;
        this.dataSource = dataSource2;
        this.periodIndex = i4;
        this.elapsedRealtimeOffsetMs = j;
        this.maxSegmentsPerLoad = i3;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        long periodDurationUs = dashManifest2.getPeriodDurationUs(i4);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[exoTrackSelection.length()];
        int i5 = 0;
        while (i5 < this.representationHolders.length) {
            Representation representation = representations.get(exoTrackSelection2.getIndexInTrackGroup(i5));
            BaseUrl selectBaseUrl = baseUrlExclusionList3.selectBaseUrl(representation.baseUrls);
            RepresentationHolder[] representationHolderArr = this.representationHolders;
            if (selectBaseUrl == null) {
                selectBaseUrl = (BaseUrl) representation.baseUrls.get(0);
            }
            int i6 = i5;
            representationHolderArr[i6] = new RepresentationHolder(periodDurationUs, representation, selectBaseUrl, factory.createProgressiveMediaExtractor(i2, representation.format, z, list, playerTrackEmsgHandler2, playerId), 0, representation.getIndex());
            i5 = i6 + 1;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = j;
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j2);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                long segmentCount = representationHolder.getSegmentCount();
                return seekParameters.resolveSeekPositionUs(j, segmentStartTimeUs, (segmentStartTimeUs >= j2 || (segmentCount != -1 && segmentNum >= (representationHolder.getFirstSegmentNum() + segmentCount) - 1)) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j2;
    }

    public void updateManifest(DashManifest dashManifest, int i) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            ArrayList<Representation> representations = getRepresentations();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i2] = representationHolderArr[i2].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i2)));
            }
        } catch (BehindLiveWindowException e) {
            this.fatalError = e;
        }
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

    public void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk;
        long j3;
        MediaChunkIterator[] mediaChunkIteratorArr;
        int i;
        int i2;
        long j4;
        long j5 = j;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            long j6 = j2 - j5;
            long msToUs = Util.msToUs(this.manifest.availabilityStartTimeMs) + Util.msToUs(this.manifest.getPeriod(this.periodIndex).startMs) + j2;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
            if (playerTrackEmsgHandler2 == null || !playerTrackEmsgHandler2.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                long msToUs2 = Util.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs));
                long nowPeriodTimeUs = getNowPeriodTimeUs(msToUs2);
                if (list.isEmpty()) {
                    List<? extends MediaChunk> list2 = list;
                    mediaChunk = null;
                } else {
                    mediaChunk = (MediaChunk) list.get(list.size() - 1);
                }
                int length = this.trackSelection.length();
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
                int i3 = 0;
                while (i3 < length) {
                    RepresentationHolder representationHolder = this.representationHolders[i3];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i3] = MediaChunkIterator.EMPTY;
                        i2 = i3;
                        i = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j3 = j6;
                        j4 = msToUs2;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(msToUs2);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(msToUs2);
                        i2 = i3;
                        i = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j3 = j6;
                        j4 = msToUs2;
                        long segmentNum = getSegmentNum(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (segmentNum < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i2] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i2] = new RepresentationSegmentIterator(updateSelectedBaseUrl(i2), segmentNum, lastAvailableSegmentNum, nowPeriodTimeUs);
                        }
                    }
                    i3 = i2 + 1;
                    List<? extends MediaChunk> list3 = list;
                    msToUs2 = j4;
                    length = i;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    j6 = j3;
                }
                long j7 = j6;
                long j8 = msToUs2;
                this.trackSelection.updateSelectedTrack(j, j7, getAvailableLiveDurationUs(j8, j5), list, mediaChunkIteratorArr2);
                RepresentationHolder updateSelectedBaseUrl = updateSelectedBaseUrl(this.trackSelection.getSelectedIndex());
                if (updateSelectedBaseUrl.chunkExtractor != null) {
                    Representation representation = updateSelectedBaseUrl.representation;
                    RangedUri initializationUri = updateSelectedBaseUrl.chunkExtractor.getSampleFormats() == null ? representation.getInitializationUri() : null;
                    RangedUri indexUri = updateSelectedBaseUrl.segmentIndex == null ? representation.getIndexUri() : null;
                    if (!(initializationUri == null && indexUri == null)) {
                        chunkHolder2.chunk = newInitializationChunk(updateSelectedBaseUrl, this.dataSource, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initializationUri, indexUri);
                        return;
                    }
                }
                long access$000 = updateSelectedBaseUrl.periodDurationUs;
                long j9 = C.TIME_UNSET;
                int i4 = (access$000 > C.TIME_UNSET ? 1 : (access$000 == C.TIME_UNSET ? 0 : -1));
                boolean z = i4 != 0;
                if (updateSelectedBaseUrl.getSegmentCount() == 0) {
                    chunkHolder2.endOfStream = z;
                    return;
                }
                long firstAvailableSegmentNum2 = updateSelectedBaseUrl.getFirstAvailableSegmentNum(j8);
                long lastAvailableSegmentNum2 = updateSelectedBaseUrl.getLastAvailableSegmentNum(j8);
                long segmentNum2 = getSegmentNum(updateSelectedBaseUrl, mediaChunk, j2, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
                if (segmentNum2 < firstAvailableSegmentNum2) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
                int i5 = (segmentNum2 > lastAvailableSegmentNum2 ? 1 : (segmentNum2 == lastAvailableSegmentNum2 ? 0 : -1));
                if (i5 > 0 || (this.missingLastSegment && i5 >= 0)) {
                    chunkHolder2.endOfStream = z;
                } else if (!z || updateSelectedBaseUrl.getSegmentStartTimeUs(segmentNum2) < access$000) {
                    int min = (int) Math.min((long) this.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
                    if (i4 != 0) {
                        while (min > 1 && updateSelectedBaseUrl.getSegmentStartTimeUs((((long) min) + segmentNum2) - 1) >= access$000) {
                            min--;
                        }
                    }
                    int i6 = min;
                    if (list.isEmpty()) {
                        j9 = j2;
                    }
                    chunkHolder2.chunk = newMediaChunk(updateSelectedBaseUrl, this.dataSource, this.trackType, this.trackSelection.getSelectedFormat(), this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), segmentNum2, i6, j9, nowPeriodTimeUs);
                } else {
                    chunkHolder2.endOfStream = true;
                }
            }
        }
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        ChunkIndex chunkIndex;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.chunkExtractor.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null) {
            playerTrackEmsgHandler2.onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null && playerTrackEmsgHandler2.onChunkLoadError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (loadErrorInfo.exception instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) loadErrorInfo.exception).responseCode == 404) {
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
            long segmentCount = representationHolder.getSegmentCount();
            if (!(segmentCount == -1 || segmentCount == 0)) {
                if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                    this.missingLastSegment = true;
                    return true;
                }
            }
        }
        RepresentationHolder representationHolder2 = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder2.representation.baseUrls);
        if (selectBaseUrl != null && !representationHolder2.selectedBaseUrl.equals(selectBaseUrl)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions = createFallbackOptions(this.trackSelection, representationHolder2.representation.baseUrls);
        if ((!createFallbackOptions.isFallbackAvailable(2) && !createFallbackOptions.isFallbackAvailable(1)) || (fallbackSelectionFor = loadErrorHandlingPolicy.getFallbackSelectionFor(createFallbackOptions, loadErrorInfo)) == null || !createFallbackOptions.isFallbackAvailable(fallbackSelectionFor.type)) {
            return false;
        }
        if (fallbackSelectionFor.type == 2) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            return exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), fallbackSelectionFor.exclusionDurationMs);
        } else if (fallbackSelectionFor.type != 1) {
            return false;
        } else {
            this.baseUrlExclusionList.exclude(representationHolder2.selectedBaseUrl, fallbackSelectionFor.exclusionDurationMs);
            return true;
        }
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            ChunkExtractor chunkExtractor = representationHolder.chunkExtractor;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions createFallbackOptions(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (exoTrackSelection.isBlacklisted(i2, elapsedRealtime)) {
                i++;
            }
        }
        int priorityCount = BaseUrlExclusionList.getPriorityCount(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(priorityCount, priorityCount - this.baseUrlExclusionList.getPriorityCountAfterExclusion(list), length, i);
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j, long j2, long j3) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j), j2, j3);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    private long getAvailableLiveDurationUs(long j, long j2) {
        if (!this.manifest.dynamic) {
            return C.TIME_UNSET;
        }
        return Math.max(0, Math.min(getNowPeriodTimeUs(j), this.representationHolders[0].getSegmentEndTimeUs(this.representationHolders[0].getLastAvailableSegmentNum(j))) - j2);
    }

    private long getNowPeriodTimeUs(long j) {
        if (this.manifest.availabilityStartTimeMs == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return j - Util.msToUs(this.manifest.availabilityStartTimeMs + this.manifest.getPeriod(this.periodIndex).startMs);
    }

    /* access modifiers changed from: protected */
    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        RepresentationHolder representationHolder2 = representationHolder;
        RangedUri rangedUri3 = rangedUri;
        Representation representation = representationHolder2.representation;
        if (rangedUri3 != null) {
            RangedUri attemptMerge = rangedUri3.attemptMerge(rangedUri2, representationHolder2.selectedBaseUrl.url);
            if (attemptMerge != null) {
                rangedUri3 = attemptMerge;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        return new InitializationChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, rangedUri3, 0), format, i, obj, representationHolder2.chunkExtractor);
    }

    /* access modifiers changed from: protected */
    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i, Format format, int i2, Object obj, long j, int i3, long j2, long j3) {
        RepresentationHolder representationHolder2 = representationHolder;
        long j4 = j;
        long j5 = j3;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j4);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j4);
        int i4 = 0;
        if (representationHolder2.chunkExtractor == null) {
            long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs(j4);
            if (!representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j4, j5)) {
                i4 = 8;
            }
            return new SingleSampleMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i4), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j, i, format);
        }
        int i5 = 1;
        int i6 = i3;
        int i7 = 1;
        while (i5 < i6) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder2.getSegmentUrl(((long) i5) + j4), representationHolder2.selectedBaseUrl.url);
            if (attemptMerge == null) {
                break;
            }
            i7++;
            i5++;
            segmentUrl = attemptMerge;
        }
        long j6 = (((long) i7) + j4) - 1;
        long segmentEndTimeUs2 = representationHolder2.getSegmentEndTimeUs(j6);
        long access$000 = representationHolder.periodDurationUs;
        long j7 = (access$000 == C.TIME_UNSET || access$000 > segmentEndTimeUs2) ? -9223372036854775807L : access$000;
        if (!representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j6, j5)) {
            i4 = 8;
        }
        return new ContainerMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, representationHolder2.selectedBaseUrl.url, segmentUrl, i4), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs2, j2, j7, j, i7, -representation.presentationTimeOffsetUs, representationHolder2.chunkExtractor);
    }

    private RepresentationHolder updateSelectedBaseUrl(int i) {
        RepresentationHolder representationHolder = this.representationHolders[i];
        BaseUrl selectBaseUrl = this.baseUrlExclusionList.selectBaseUrl(representationHolder.representation.baseUrls);
        if (selectBaseUrl == null || selectBaseUrl.equals(representationHolder.selectedBaseUrl)) {
            return representationHolder;
        }
        RepresentationHolder copyWithNewSelectedBaseUrl = representationHolder.copyWithNewSelectedBaseUrl(selectBaseUrl);
        this.representationHolders[i] = copyWithNewSelectedBaseUrl;
        return copyWithNewSelectedBaseUrl;
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final long nowPeriodTimeUs;
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j, long j2, long j3) {
            super(j, j2);
            this.representationHolder = representationHolder2;
            this.nowPeriodTimeUs = j3;
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            long currentIndex = getCurrentIndex();
            return DashUtil.buildDataSpec(this.representationHolder.representation, this.representationHolder.selectedBaseUrl.url, this.representationHolder.getSegmentUrl(currentIndex), this.representationHolder.isSegmentAvailableAtFullNetworkSpeed(currentIndex, this.nowPeriodTimeUs) ? 0 : 8);
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }
    }

    protected static final class RepresentationHolder {
        final ChunkExtractor chunkExtractor;
        /* access modifiers changed from: private */
        public final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;
        public final BaseUrl selectedBaseUrl;

        RepresentationHolder(long j, Representation representation2, BaseUrl baseUrl, ChunkExtractor chunkExtractor2, long j2, DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j;
            this.representation = representation2;
            this.selectedBaseUrl = baseUrl;
            this.segmentNumShift = j2;
            this.chunkExtractor = chunkExtractor2;
            this.segmentIndex = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewRepresentation(long j, Representation representation2) throws BehindLiveWindowException {
            long segmentNum;
            long segmentNum2;
            long j2 = j;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
            } else {
                long segmentCount = index.getSegmentCount(j2);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, index2);
                }
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j3 = (segmentCount + firstSegmentNum) - 1;
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                DashSegmentIndex dashSegmentIndex = index;
                long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                long j4 = firstSegmentNum;
                long j5 = this.segmentNumShift;
                int i = ((index.getTimeUs(j3) + index.getDurationUs(j3, j2)) > timeUs2 ? 1 : ((index.getTimeUs(j3) + index.getDurationUs(j3, j2)) == timeUs2 ? 0 : -1));
                if (i == 0) {
                    segmentNum = j3 + 1;
                } else if (i < 0) {
                    throw new BehindLiveWindowException();
                } else if (timeUs2 < timeUs) {
                    segmentNum2 = j5 - (index2.getSegmentNum(timeUs, j2) - j4);
                    return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
                } else {
                    segmentNum = dashSegmentIndex.getSegmentNum(timeUs2, j2);
                }
                segmentNum2 = j5 + (segmentNum - firstSegmentNum2);
                return new RepresentationHolder(j, representation2, this.selectedBaseUrl, this.chunkExtractor, segmentNum2, index2);
            }
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.selectedBaseUrl, this.chunkExtractor, this.segmentNumShift, dashSegmentIndex);
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder copyWithNewSelectedBaseUrl(BaseUrl baseUrl) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, baseUrl, this.chunkExtractor, this.segmentNumShift, this.segmentIndex);
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public long getFirstAvailableSegmentNum(long j) {
            return this.segmentIndex.getFirstAvailableSegmentNum(this.periodDurationUs, j) + this.segmentNumShift;
        }

        public long getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.segmentNumShift);
        }

        public long getSegmentEndTimeUs(long j) {
            return getSegmentStartTimeUs(j) + this.segmentIndex.getDurationUs(j - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.periodDurationUs) + this.segmentNumShift;
        }

        public RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.segmentNumShift);
        }

        public long getLastAvailableSegmentNum(long j) {
            return (getFirstAvailableSegmentNum(j) + this.segmentIndex.getAvailableSegmentCount(this.periodDurationUs, j)) - 1;
        }

        public boolean isSegmentAvailableAtFullNetworkSpeed(long j, long j2) {
            if (!this.segmentIndex.isExplicit() && j2 != C.TIME_UNSET && getSegmentEndTimeUs(j) > j2) {
                return false;
            }
            return true;
        }
    }
}
