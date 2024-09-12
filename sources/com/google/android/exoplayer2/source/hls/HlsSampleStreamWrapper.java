package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final Set<Integer> MAPPABLE_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_FATAL = -2;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_NON_FATAL = -3;
    public static final int SAMPLE_QUEUE_INDEX_PENDING = -1;
    private static final String TAG = "HlsSampleStreamWrapper";
    private final Allocator allocator;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final Handler handler;
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList<HlsSampleStream> hlsSampleStreams;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private Chunk loadingChunk;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final ArrayList<HlsMediaChunk> mediaChunks;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private final Runnable onTracksEndedRunnable;
    private Set<TrackGroup> optionalTrackGroups;
    private final Map<String, DrmInitData> overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List<HlsMediaChunk> readOnlyMediaChunks;
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType;
    private boolean[] sampleQueueIsAudioVideoFlags;
    private Set<Integer> sampleQueueMappingDoneByType;
    private int[] sampleQueueTrackIds = new int[0];
    private HlsSampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates;
    private boolean seenFirstTrackSelection;
    private HlsMediaChunk sourceChunk;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private final String uid;
    private Format upstreamTrackFormat;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri uri);

        void onPrepared();
    }

    private static int getTrackTypeScore(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public void seekMap(SeekMap seekMap) {
    }

    public HlsSampleStreamWrapper(String str, int i, Callback callback2, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator2, long j, Format format, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i2) {
        this.uid = str;
        this.trackType = i;
        this.callback = callback2;
        this.chunkSource = hlsChunkSource;
        this.overridingDrmInitData = map;
        this.allocator = allocator2;
        this.muxedAudioFormat = format;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.metadataType = i2;
        Set<Integer> set = MAPPABLE_TYPES;
        this.sampleQueueMappingDoneByType = new HashSet(set.size());
        this.sampleQueueIndicesByType = new SparseIntArray(set.size());
        this.sampleQueues = new HlsSampleQueue[0];
        this.sampleQueueIsAudioVideoFlags = new boolean[0];
        this.sampleQueuesEnabledStates = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        this.hlsSampleStreams = new ArrayList<>();
        this.maybeFinishPrepareRunnable = new HlsSampleStreamWrapper$$ExternalSyntheticLambda1(this);
        this.onTracksEndedRunnable = new HlsSampleStreamWrapper$$ExternalSyntheticLambda2(this);
        this.handler = Util.createHandlerForCurrentLooper();
        this.lastSeekPositionUs = j;
        this.pendingResetPositionUs = j;
    }

    public void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    public void prepareWithMultivariantPlaylistInfo(TrackGroup[] trackGroupArr, int i, int... iArr) {
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        this.optionalTrackGroups = new HashSet();
        for (int i2 : iArr) {
            this.optionalTrackGroups.add(this.trackGroups.get(i2));
        }
        this.primaryTrackGroupIndex = i;
        Handler handler2 = this.handler;
        Callback callback2 = this.callback;
        Objects.requireNonNull(callback2);
        handler2.post(new HlsSampleStreamWrapper$$ExternalSyntheticLambda0(callback2));
        setIsPrepared();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public TrackGroupArray getTrackGroups() {
        assertIsPrepared();
        return this.trackGroups;
    }

    public int getPrimaryTrackGroupIndex() {
        return this.primaryTrackGroupIndex;
    }

    public int bindSampleQueueToSampleStream(int i) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i2 = this.trackGroupToSampleQueueIndex[i];
        if (i2 != -1) {
            boolean[] zArr = this.sampleQueuesEnabledStates;
            if (zArr[i2]) {
                return -2;
            }
            zArr[i2] = true;
            return i2;
        } else if (this.optionalTrackGroups.contains(this.trackGroups.get(i))) {
            return -3;
        } else {
            return -2;
        }
    }

    public void unbindSampleQueue(int i) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i2 = this.trackGroupToSampleQueueIndex[i];
        Assertions.checkState(this.sampleQueuesEnabledStates[i2]);
        this.sampleQueuesEnabledStates[i2] = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.assertIsPrepared()
            int r3 = r0.enabledTrackGroupCount
            r14 = 0
            r4 = r14
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = (com.google.android.exoplayer2.source.hls.HlsSampleStream) r5
            if (r5 == 0) goto L_0x002c
            r7 = r1[r4]
            if (r7 == 0) goto L_0x0022
            boolean r7 = r21[r4]
            if (r7 != 0) goto L_0x002c
        L_0x0022:
            int r7 = r0.enabledTrackGroupCount
            int r7 = r7 - r15
            r0.enabledTrackGroupCount = r7
            r5.unbindSampleQueue()
            r2[r4] = r6
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002f:
            if (r26 != 0) goto L_0x0041
            boolean r4 = r0.seenFirstTrackSelection
            if (r4 == 0) goto L_0x0038
            if (r3 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r3 = r0.lastSeekPositionUs
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = r14
            goto L_0x0042
        L_0x0041:
            r3 = r15
        L_0x0042:
            com.google.android.exoplayer2.source.hls.HlsChunkSource r4 = r0.chunkSource
            com.google.android.exoplayer2.trackselection.ExoTrackSelection r4 = r4.getTrackSelection()
            r16 = r3
            r11 = r4
            r3 = r14
        L_0x004c:
            int r5 = r1.length
            if (r3 >= r5) goto L_0x00a2
            r5 = r1[r3]
            if (r5 != 0) goto L_0x0054
            goto L_0x009f
        L_0x0054:
            com.google.android.exoplayer2.source.TrackGroupArray r7 = r0.trackGroups
            com.google.android.exoplayer2.source.TrackGroup r8 = r5.getTrackGroup()
            int r7 = r7.indexOf(r8)
            int r8 = r0.primaryTrackGroupIndex
            if (r7 != r8) goto L_0x0068
            com.google.android.exoplayer2.source.hls.HlsChunkSource r8 = r0.chunkSource
            r8.setTrackSelection(r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x009f
            int r5 = r0.enabledTrackGroupCount
            int r5 = r5 + r15
            r0.enabledTrackGroupCount = r5
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = new com.google.android.exoplayer2.source.hls.HlsSampleStream
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r8 = r0.trackGroupToSampleQueueIndex
            if (r8 == 0) goto L_0x009f
            r8 = r5
            com.google.android.exoplayer2.source.hls.HlsSampleStream r8 = (com.google.android.exoplayer2.source.hls.HlsSampleStream) r8
            r5.bindSampleQueue()
            if (r16 != 0) goto L_0x009f
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r5 = r0.sampleQueues
            int[] r8 = r0.trackGroupToSampleQueueIndex
            r7 = r8[r7]
            r5 = r5[r7]
            boolean r7 = r5.seekTo(r12, r15)
            if (r7 != 0) goto L_0x009c
            int r5 = r5.getReadIndex()
            if (r5 == 0) goto L_0x009c
            r5 = r15
            goto L_0x009d
        L_0x009c:
            r5 = r14
        L_0x009d:
            r16 = r5
        L_0x009f:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x00a2:
            int r1 = r0.enabledTrackGroupCount
            if (r1 != 0) goto L_0x00d9
            com.google.android.exoplayer2.source.hls.HlsChunkSource r1 = r0.chunkSource
            r1.reset()
            r0.downstreamTrackFormat = r6
            r0.pendingResetUpstreamFormats = r15
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.mediaChunks
            r1.clear()
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            boolean r1 = r1.isLoading()
            if (r1 == 0) goto L_0x00d4
            boolean r1 = r0.sampleQueuesBuilt
            if (r1 == 0) goto L_0x00cd
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r1 = r0.sampleQueues
            int r3 = r1.length
        L_0x00c3:
            if (r14 >= r3) goto L_0x00cd
            r4 = r1[r14]
            r4.discardToEnd()
            int r14 = r14 + 1
            goto L_0x00c3
        L_0x00cd:
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            r1.cancelLoading()
            goto L_0x013f
        L_0x00d4:
            r19.resetSampleQueues()
            goto L_0x013f
        L_0x00d9:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.mediaChunks
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x012c
            boolean r1 = com.google.android.exoplayer2.util.Util.areEqual(r11, r4)
            if (r1 != 0) goto L_0x012c
            boolean r1 = r0.seenFirstTrackSelection
            if (r1 != 0) goto L_0x0123
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f2
            long r3 = -r12
        L_0x00f2:
            r6 = r3
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r1 = r19.getLastMediaChunk()
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.chunkSource
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] r17 = r3.createMediaChunkIterators(r1, r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r10 = r0.readOnlyMediaChunks
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.updateSelectedTrack(r4, r6, r8, r10, r11)
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.chunkSource
            com.google.android.exoplayer2.source.TrackGroup r3 = r3.getTrackGroup()
            com.google.android.exoplayer2.Format r1 = r1.trackFormat
            int r1 = r3.indexOf(r1)
            int r3 = r18.getSelectedIndexInTrackGroup()
            if (r3 == r1) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r1 = r14
            goto L_0x0124
        L_0x0123:
            r1 = r15
        L_0x0124:
            if (r1 == 0) goto L_0x012c
            r0.pendingResetUpstreamFormats = r15
            r1 = r15
            r16 = r1
            goto L_0x012e
        L_0x012c:
            r1 = r26
        L_0x012e:
            if (r16 == 0) goto L_0x013f
            r0.seekToUs(r12, r1)
        L_0x0133:
            int r1 = r2.length
            if (r14 >= r1) goto L_0x013f
            r1 = r2[r14]
            if (r1 == 0) goto L_0x013c
            r23[r14] = r15
        L_0x013c:
            int r14 = r14 + 1
            goto L_0x0133
        L_0x013f:
            r0.updateSampleStreams(r2)
            r0.seenFirstTrackSelection = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void discardBuffer(long j, boolean z) {
        if (this.sampleQueuesBuilt && !isPendingReset()) {
            int length = this.sampleQueues.length;
            for (int i = 0; i < length; i++) {
                this.sampleQueues[i].discardTo(j, z, this.sampleQueuesEnabledStates[i]);
            }
        }
    }

    public boolean seekToUs(long j, boolean z) {
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return true;
        }
        if (this.sampleQueuesBuilt && !z && seekInsideBufferUs(j)) {
            return false;
        }
        this.pendingResetPositionUs = j;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            if (this.sampleQueuesBuilt) {
                for (HlsSampleQueue discardToEnd : this.sampleQueues) {
                    discardToEnd.discardToEnd();
                }
            }
            this.loader.cancelLoading();
        } else {
            this.loader.clearFatalError();
            resetSampleQueues();
        }
        return true;
    }

    public void onPlaylistUpdated() {
        if (!this.mediaChunks.isEmpty()) {
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.getLast(this.mediaChunks);
            int chunkPublicationState = this.chunkSource.getChunkPublicationState(hlsMediaChunk);
            if (chunkPublicationState == 1) {
                hlsMediaChunk.publish();
            } else if (chunkPublicationState == 2 && !this.loadingFinished && this.loader.isLoading()) {
                this.loader.cancelLoading();
            }
        }
    }

    public void release() {
        if (this.prepared) {
            for (HlsSampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    public void onLoaderReleased() {
        for (HlsSampleQueue release : this.sampleQueues) {
            release.release();
        }
    }

    public void setIsTimestampMaster(boolean z) {
        this.chunkSource.setIsTimestampMaster(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r6 = r4.loadErrorHandlingPolicy.getFallbackSelectionFor(com.google.android.exoplayer2.trackselection.TrackSelectionUtil.createFallbackOptions(r4.chunkSource.getTrackSelection()), r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPlaylistError(android.net.Uri r5, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.exoplayer2.source.hls.HlsChunkSource r0 = r4.chunkSource
            boolean r0 = r0.obtainsChunksForPlaylist(r5)
            r1 = 1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 != 0) goto L_0x002b
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r7 = r4.loadErrorHandlingPolicy
            com.google.android.exoplayer2.source.hls.HlsChunkSource r0 = r4.chunkSource
            com.google.android.exoplayer2.trackselection.ExoTrackSelection r0 = r0.getTrackSelection()
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$FallbackOptions r0 = com.google.android.exoplayer2.trackselection.TrackSelectionUtil.createFallbackOptions(r0)
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$FallbackSelection r6 = r7.getFallbackSelectionFor(r0, r6)
            if (r6 == 0) goto L_0x002b
            int r7 = r6.type
            r0 = 2
            if (r7 != r0) goto L_0x002b
            long r6 = r6.exclusionDurationMs
            goto L_0x002c
        L_0x002b:
            r6 = r2
        L_0x002c:
            com.google.android.exoplayer2.source.hls.HlsChunkSource r0 = r4.chunkSource
            boolean r5 = r0.onPlaylistError(r5, r6)
            if (r5 == 0) goto L_0x0039
            int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.onPlaylistError(android.net.Uri, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo, boolean):boolean");
    }

    public boolean isVideoSampleStream() {
        return this.primarySampleQueueType == 2;
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j, seekParameters);
    }

    public boolean isReady(int i) {
        return !isPendingReset() && this.sampleQueues[i].isReady(this.loadingFinished);
    }

    public void maybeThrowError(int i) throws IOException {
        maybeThrowError();
        this.sampleQueues[i].maybeThrowError();
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        Format format;
        if (isPendingReset()) {
            return -3;
        }
        int i3 = 0;
        if (!this.mediaChunks.isEmpty()) {
            int i4 = 0;
            while (i4 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i4))) {
                i4++;
            }
            Util.removeRange(this.mediaChunks, 0, i4);
            HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            Format format2 = hlsMediaChunk.trackFormat;
            if (!format2.equals(this.downstreamTrackFormat)) {
                this.mediaSourceEventDispatcher.downstreamFormatChanged(this.trackType, format2, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format2;
        }
        if (!this.mediaChunks.isEmpty() && !this.mediaChunks.get(0).isPublished()) {
            return -3;
        }
        int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, i2, this.loadingFinished);
        if (read == -5) {
            Format format3 = (Format) Assertions.checkNotNull(formatHolder.format);
            if (i == this.primarySampleQueueIndex) {
                int peekSourceId = this.sampleQueues[i].peekSourceId();
                while (i3 < this.mediaChunks.size() && this.mediaChunks.get(i3).uid != peekSourceId) {
                    i3++;
                }
                if (i3 < this.mediaChunks.size()) {
                    format = this.mediaChunks.get(i3).trackFormat;
                } else {
                    format = (Format) Assertions.checkNotNull(this.upstreamTrackFormat);
                }
                format3 = format3.withManifestFormatInfo(format);
            }
            formatHolder.format = format3;
        }
        return read;
    }

    public int skipData(int i, long j) {
        if (isPendingReset()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.sampleQueues[i];
        int skipCount = hlsSampleQueue.getSkipCount(j, this.loadingFinished);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.getLast(this.mediaChunks, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.isPublished()) {
            skipCount = Math.min(skipCount, hlsMediaChunk.getFirstSampleIndex(i) - hlsSampleQueue.getReadIndex());
        }
        hlsSampleQueue.skip(skipCount);
        return skipCount;
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j = this.lastSeekPositionUs;
        HlsMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j = Math.max(j, lastMediaChunk.endTimeUs);
        }
        if (this.sampleQueuesBuilt) {
            for (HlsSampleQueue largestQueuedTimestampUs : this.sampleQueues) {
                j = Math.max(j, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
            }
        }
        return j;
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    public boolean continueLoading(long j) {
        long j2;
        List<HlsMediaChunk> list;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        if (isPendingReset()) {
            list = Collections.emptyList();
            j2 = this.pendingResetPositionUs;
            for (HlsSampleQueue startTimeUs : this.sampleQueues) {
                startTimeUs.setStartTimeUs(this.pendingResetPositionUs);
            }
        } else {
            list = this.readOnlyMediaChunks;
            HlsMediaChunk lastMediaChunk = getLastMediaChunk();
            if (lastMediaChunk.isLoadCompleted()) {
                j2 = lastMediaChunk.endTimeUs;
            } else {
                j2 = Math.max(this.lastSeekPositionUs, lastMediaChunk.startTimeUs);
            }
        }
        List<HlsMediaChunk> list2 = list;
        long j3 = j2;
        this.nextChunkHolder.clear();
        this.chunkSource.getNextChunk(j, j3, list2, this.prepared || !list2.isEmpty(), this.nextChunkHolder);
        boolean z = this.nextChunkHolder.endOfStream;
        Chunk chunk = this.nextChunkHolder.chunk;
        Uri uri = this.nextChunkHolder.playlistUrl;
        if (z) {
            this.pendingResetPositionUs = C.TIME_UNSET;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.callback.onPlaylistRefreshRequired(uri);
            }
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                initMediaChunkLoad((HlsMediaChunk) chunk);
            }
            this.loadingChunk = chunk;
            this.mediaSourceEventDispatcher.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
            return true;
        }
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public void reevaluateBuffer(long j) {
        if (!this.loader.hasFatalError() && !isPendingReset()) {
            if (this.loader.isLoading()) {
                Assertions.checkNotNull(this.loadingChunk);
                if (this.chunkSource.shouldCancelLoad(j, this.loadingChunk, this.readOnlyMediaChunks)) {
                    this.loader.cancelLoading();
                    return;
                }
                return;
            }
            int size = this.readOnlyMediaChunks.size();
            while (size > 0 && this.chunkSource.getChunkPublicationState(this.readOnlyMediaChunks.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.readOnlyMediaChunks.size()) {
                discardUpstream(size);
            }
            int preferredQueueSize = this.chunkSource.getPreferredQueueSize(j, this.readOnlyMediaChunks);
            if (preferredQueueSize < this.mediaChunks.size()) {
                discardUpstream(preferredQueueSize);
            }
        }
    }

    public void onLoadCompleted(Chunk chunk, long j, long j2) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCanceled(Chunk chunk, long j, long j2, boolean z) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        if (!z) {
            if (isPendingReset() || this.enabledTrackGroupCount == 0) {
                resetSampleQueues();
            }
            if (this.enabledTrackGroupCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public Loader.LoadErrorAction onLoadError(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        int i2;
        Chunk chunk2 = chunk;
        IOException iOException2 = iOException;
        boolean isMediaChunk = isMediaChunk(chunk);
        if (isMediaChunk && !((HlsMediaChunk) chunk2).isPublished() && (iOException2 instanceof HttpDataSource.InvalidResponseCodeException) && ((i2 = ((HttpDataSource.InvalidResponseCodeException) iOException2).responseCode) == 410 || i2 == 404)) {
            return Loader.RETRY;
        }
        long bytesLoaded = chunk.bytesLoaded();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, bytesLoaded);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, Util.usToMs(chunk2.startTimeUs), Util.usToMs(chunk2.endTimeUs)), iOException2, i);
        LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = this.loadErrorHandlingPolicy.getFallbackSelectionFor(TrackSelectionUtil.createFallbackOptions(this.chunkSource.getTrackSelection()), loadErrorInfo);
        boolean z = false;
        boolean maybeExcludeTrack = (fallbackSelectionFor == null || fallbackSelectionFor.type != 2) ? false : this.chunkSource.maybeExcludeTrack(chunk2, fallbackSelectionFor.exclusionDurationMs);
        if (maybeExcludeTrack) {
            if (isMediaChunk && bytesLoaded == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z = true;
                }
                Assertions.checkState(z);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                } else {
                    ((HlsMediaChunk) Iterables.getLast(this.mediaChunks)).invalidateExtractor();
                }
            }
            loadErrorAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
            if (retryDelayMsFor != C.TIME_UNSET) {
                loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY_FATAL;
            }
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z2 = !loadErrorAction2.isRetry();
        this.mediaSourceEventDispatcher.loadError(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, iOException, z2);
        if (z2) {
            this.loadingChunk = null;
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        }
        if (maybeExcludeTrack) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction2;
    }

    private void initMediaChunkLoad(HlsMediaChunk hlsMediaChunk) {
        this.sourceChunk = hlsMediaChunk;
        this.upstreamTrackFormat = hlsMediaChunk.trackFormat;
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.mediaChunks.add(hlsMediaChunk);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (HlsSampleQueue writeIndex : this.sampleQueues) {
            builder.add((Object) Integer.valueOf(writeIndex.getWriteIndex()));
        }
        hlsMediaChunk.init(this, builder.build());
        for (HlsSampleQueue hlsSampleQueue : this.sampleQueues) {
            hlsSampleQueue.setSourceChunk(hlsMediaChunk);
            if (hlsMediaChunk.shouldSpliceIn) {
                hlsSampleQueue.splice();
            }
        }
    }

    private void discardUpstream(int i) {
        Assertions.checkState(!this.loader.isLoading());
        while (true) {
            if (i >= this.mediaChunks.size()) {
                i = -1;
                break;
            } else if (canDiscardUpstreamMediaChunksFromIndex(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            long j = getLastMediaChunk().endTimeUs;
            HlsMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(i);
            if (this.mediaChunks.isEmpty()) {
                this.pendingResetPositionUs = this.lastSeekPositionUs;
            } else {
                ((HlsMediaChunk) Iterables.getLast(this.mediaChunks)).invalidateExtractor();
            }
            this.loadingFinished = false;
            this.mediaSourceEventDispatcher.upstreamDiscarded(this.primarySampleQueueType, discardUpstreamMediaChunksFromIndex.startTimeUs, j);
        }
    }

    public TrackOutput track(int i, int i2) {
        TrackOutput trackOutput;
        if (!MAPPABLE_TYPES.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.sampleQueues;
                if (i3 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.sampleQueueTrackIds[i3] == i) {
                    trackOutput = trackOutputArr[i3];
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            trackOutput = getMappedTrackOutput(i, i2);
        }
        if (trackOutput == null) {
            if (this.tracksEnded) {
                return createFakeTrackOutput(i, i2);
            }
            trackOutput = createSampleQueue(i, i2);
        }
        if (i2 != 5) {
            return trackOutput;
        }
        if (this.emsgUnwrappingTrackOutput == null) {
            this.emsgUnwrappingTrackOutput = new EmsgUnwrappingTrackOutput(trackOutput, this.metadataType);
        }
        return this.emsgUnwrappingTrackOutput;
    }

    private TrackOutput getMappedTrackOutput(int i, int i2) {
        Assertions.checkArgument(MAPPABLE_TYPES.contains(Integer.valueOf(i2)));
        int i3 = this.sampleQueueIndicesByType.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.sampleQueueMappingDoneByType.add(Integer.valueOf(i2))) {
            this.sampleQueueTrackIds[i3] = i;
        }
        if (this.sampleQueueTrackIds[i3] == i) {
            return this.sampleQueues[i3];
        }
        return createFakeTrackOutput(i, i2);
    }

    private SampleQueue createSampleQueue(int i, int i2) {
        int length = this.sampleQueues.length;
        boolean z = true;
        if (!(i2 == 1 || i2 == 2)) {
            z = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.allocator, this.drmSessionManager, this.drmEventDispatcher, this.overridingDrmInitData);
        hlsSampleQueue.setStartTimeUs(this.lastSeekPositionUs);
        if (z) {
            hlsSampleQueue.setDrmInitData(this.drmInitData);
        }
        hlsSampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        HlsMediaChunk hlsMediaChunk = this.sourceChunk;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.setSourceChunk(hlsMediaChunk);
        }
        hlsSampleQueue.setUpstreamFormatChangeListener(this);
        int i3 = length + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i3);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length] = i;
        this.sampleQueues = (HlsSampleQueue[]) Util.nullSafeArrayAppend(this.sampleQueues, hlsSampleQueue);
        boolean[] copyOf2 = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i3);
        this.sampleQueueIsAudioVideoFlags = copyOf2;
        copyOf2[length] = z;
        this.haveAudioVideoSampleQueues |= z;
        this.sampleQueueMappingDoneByType.add(Integer.valueOf(i2));
        this.sampleQueueIndicesByType.append(i2, length);
        if (getTrackTypeScore(i2) > getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = length;
            this.primarySampleQueueType = i2;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i3);
        return hlsSampleQueue;
    }

    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            for (HlsSampleQueue sampleOffsetUs2 : this.sampleQueues) {
                sampleOffsetUs2.setSampleOffsetUs(j);
            }
        }
    }

    public void setDrmInitData(DrmInitData drmInitData2) {
        if (!Util.areEqual(this.drmInitData, drmInitData2)) {
            this.drmInitData = drmInitData2;
            int i = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i < hlsSampleQueueArr.length) {
                    if (this.sampleQueueIsAudioVideoFlags[i]) {
                        hlsSampleQueueArr[i].setDrmInitData(drmInitData2);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void updateSampleStreams(SampleStream[] sampleStreamArr) {
        this.hlsSampleStreams.clear();
        for (HlsSampleStream hlsSampleStream : sampleStreamArr) {
            if (hlsSampleStream != null) {
                this.hlsSampleStreams.add(hlsSampleStream);
            }
        }
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.uid;
        int length = this.sampleQueues.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.sampleQueuesEnabledStates[i2] && this.sampleQueues[i2].peekSourceId() == i) {
                return false;
            }
        }
        return true;
    }

    private boolean canDiscardUpstreamMediaChunksFromIndex(int i) {
        for (int i2 = i; i2 < this.mediaChunks.size(); i2++) {
            if (this.mediaChunks.get(i2).shouldSpliceIn) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(i);
        for (int i3 = 0; i3 < this.sampleQueues.length; i3++) {
            if (this.sampleQueues[i3].getReadIndex() > hlsMediaChunk.getFirstSampleIndex(i3)) {
                return false;
            }
        }
        return true;
    }

    private HlsMediaChunk discardUpstreamMediaChunksFromIndex(int i) {
        HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(i);
        ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.sampleQueues.length; i2++) {
            this.sampleQueues[i2].discardUpstreamSamples(hlsMediaChunk.getFirstSampleIndex(i2));
        }
        return hlsMediaChunk;
    }

    private void resetSampleQueues() {
        for (HlsSampleQueue reset : this.sampleQueues) {
            reset.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    /* access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
            int length = hlsSampleQueueArr.length;
            int i = 0;
            while (i < length) {
                if (hlsSampleQueueArr[i].getUpstreamFormat() != null) {
                    i++;
                } else {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracksFromSampleStreams();
            setIsPrepared();
            this.callback.onPrepared();
        }
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void mapSampleQueuesToMatchTrackGroups() {
        int i = this.trackGroups.length;
        int[] iArr = new int[i];
        this.trackGroupToSampleQueueIndex = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i3 >= hlsSampleQueueArr.length) {
                    break;
                } else if (formatsMatch((Format) Assertions.checkStateNotNull(hlsSampleQueueArr[i3].getUpstreamFormat()), this.trackGroups.get(i2).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i2] = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        Iterator<HlsSampleStream> it = this.hlsSampleStreams.iterator();
        while (it.hasNext()) {
            it.next().bindSampleQueue();
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void buildTracksFromSampleStreams() {
        Format format;
        Format format2;
        int length = this.sampleQueues.length;
        boolean z = false;
        int i = -2;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = 2;
            if (i3 >= length) {
                break;
            }
            String str = ((Format) Assertions.checkStateNotNull(this.sampleQueues[i3].getUpstreamFormat())).sampleMimeType;
            if (!MimeTypes.isVideo(str)) {
                if (MimeTypes.isAudio(str)) {
                    i4 = 1;
                } else {
                    i4 = MimeTypes.isText(str) ? 3 : -2;
                }
            }
            if (getTrackTypeScore(i4) > getTrackTypeScore(i)) {
                i2 = i3;
                i = i4;
            } else if (i4 == i && i2 != -1) {
                i2 = -1;
            }
            i3++;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i5 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.trackGroupToSampleQueueIndex[i6] = i6;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        int i7 = 0;
        while (i7 < length) {
            Format format3 = (Format) Assertions.checkStateNotNull(this.sampleQueues[i7].getUpstreamFormat());
            if (i7 == i2) {
                Format[] formatArr = new Format[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    Format format4 = trackGroup.getFormat(i8);
                    if (i == 1 && (format2 = this.muxedAudioFormat) != null) {
                        format4 = format4.withManifestFormatInfo(format2);
                    }
                    if (i5 == 1) {
                        format = format3.withManifestFormatInfo(format4);
                    } else {
                        format = deriveFormat(format4, format3, true);
                    }
                    formatArr[i8] = format;
                }
                trackGroupArr[i7] = new TrackGroup(this.uid, formatArr);
                this.primaryTrackGroupIndex = i7;
            } else {
                trackGroupArr[i7] = new TrackGroup(this.uid + ":muxed:" + (i7 < i2 ? i7 : i7 - 1), deriveFormat((i != 2 || !MimeTypes.isAudio(format3.sampleMimeType)) ? null : this.muxedAudioFormat, format3, false));
            }
            i7++;
        }
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        if (this.optionalTrackGroups == null) {
            z = true;
        }
        Assertions.checkState(z);
        this.optionalTrackGroups = Collections.emptySet();
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] trackGroupArr) {
        for (int i = 0; i < trackGroupArr.length; i++) {
            TrackGroup trackGroup = trackGroupArr[i];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i2 = 0; i2 < trackGroup.length; i2++) {
                Format format = trackGroup.getFormat(i2);
                formatArr[i2] = format.copyWithCryptoType(this.drmSessionManager.getCryptoType(format));
            }
            trackGroupArr[i] = new TrackGroup(trackGroup.id, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private HlsMediaChunk getLastMediaChunk() {
        ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != C.TIME_UNSET;
    }

    private boolean seekInsideBufferUs(long j) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (!this.sampleQueues[i].seekTo(j, false) && (this.sampleQueueIsAudioVideoFlags[i] || !this.haveAudioVideoSampleQueues)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void setIsPrepared() {
        this.prepared = true;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    private static Format deriveFormat(Format format, Format format2, boolean z) {
        String str;
        String str2;
        if (format == null) {
            return format2;
        }
        int trackType2 = MimeTypes.getTrackType(format2.sampleMimeType);
        if (Util.getCodecCountOfType(format.codecs, trackType2) == 1) {
            str2 = Util.getCodecsOfType(format.codecs, trackType2);
            str = MimeTypes.getMediaMimeType(str2);
        } else {
            str2 = MimeTypes.getCodecsCorrespondingToMimeType(format.codecs, format2.sampleMimeType);
            str = format2.sampleMimeType;
        }
        Format.Builder codecs = format2.buildUpon().setId(format.id).setLabel(format.label).setLanguage(format.language).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).setAverageBitrate(z ? format.averageBitrate : -1).setPeakBitrate(z ? format.peakBitrate : -1).setCodecs(str2);
        if (trackType2 == 2) {
            codecs.setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate);
        }
        if (str != null) {
            codecs.setSampleMimeType(str);
        }
        if (format.channelCount != -1 && trackType2 == 1) {
            codecs.setChannelCount(format.channelCount);
        }
        if (format.metadata != null) {
            Metadata metadata = format.metadata;
            if (format2.metadata != null) {
                metadata = format2.metadata.copyWithAppendedEntriesFrom(metadata);
            }
            codecs.setMetadata(metadata);
        }
        return codecs.build();
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private static boolean formatsMatch(Format format, Format format2) {
        String str = format.sampleMimeType;
        String str2 = format2.sampleMimeType;
        int trackType2 = MimeTypes.getTrackType(str);
        if (trackType2 != 3) {
            if (trackType2 == MimeTypes.getTrackType(str2)) {
                return true;
            }
            return false;
        } else if (!Util.areEqual(str, str2)) {
            return false;
        } else {
            if ((MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) && format.accessibilityChannel != format2.accessibilityChannel) {
                return false;
            }
            return true;
        }
    }

    private static DummyTrackOutput createFakeTrackOutput(int i, int i2) {
        Log.w(TAG, "Unmapped track with id " + i + " of type " + i2);
        return new DummyTrackOutput();
    }

    private static final class HlsSampleQueue extends SampleQueue {
        private DrmInitData drmInitData;
        private final Map<String, DrmInitData> overridingDrmInitData;

        private HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.overridingDrmInitData = map;
        }

        public void setSourceChunk(HlsMediaChunk hlsMediaChunk) {
            sourceId(hlsMediaChunk.uid);
        }

        public void setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            invalidateUpstreamFormatAdjustment();
        }

        public Format getAdjustedUpstreamFormat(Format format) {
            DrmInitData drmInitData2;
            DrmInitData drmInitData3 = this.drmInitData;
            if (drmInitData3 == null) {
                drmInitData3 = format.drmInitData;
            }
            if (!(drmInitData3 == null || (drmInitData2 = this.overridingDrmInitData.get(drmInitData3.schemeType)) == null)) {
                drmInitData3 = drmInitData2;
            }
            Metadata adjustedMetadata = getAdjustedMetadata(format.metadata);
            if (!(drmInitData3 == format.drmInitData && adjustedMetadata == format.metadata)) {
                format = format.buildUpon().setDrmInitData(drmInitData3).setMetadata(adjustedMetadata).build();
            }
            return super.getAdjustedUpstreamFormat(format);
        }

        private Metadata getAdjustedMetadata(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof PrivFrame) && HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(length - 1)];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }

        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            super.sampleMetadata(j, i, i2, i3, cryptoData);
        }
    }

    private static class EmsgUnwrappingTrackOutput implements TrackOutput {
        private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();
        private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_ID3).build();
        private byte[] buffer;
        private int bufferPosition;
        private final TrackOutput delegate;
        private final Format delegateFormat;
        private final EventMessageDecoder emsgDecoder = new EventMessageDecoder();
        private Format format;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i) {
            this.delegate = trackOutput;
            if (i == 1) {
                this.delegateFormat = ID3_FORMAT;
            } else if (i == 3) {
                this.delegateFormat = EMSG_FORMAT;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: " + i);
            }
            this.buffer = new byte[0];
            this.bufferPosition = 0;
        }

        public void format(Format format2) {
            this.format = format2;
            this.delegate.format(this.delegateFormat);
        }

        public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            ensureBufferCapacity(this.bufferPosition + i);
            int read = dataReader.read(this.buffer, this.bufferPosition, i);
            if (read != -1) {
                this.bufferPosition += read;
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
            ensureBufferCapacity(this.bufferPosition + i);
            parsableByteArray.readBytes(this.buffer, this.bufferPosition, i);
            this.bufferPosition += i;
        }

        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            Assertions.checkNotNull(this.format);
            ParsableByteArray sampleAndTrimBuffer = getSampleAndTrimBuffer(i2, i3);
            if (!Util.areEqual(this.format.sampleMimeType, this.delegateFormat.sampleMimeType)) {
                if (MimeTypes.APPLICATION_EMSG.equals(this.format.sampleMimeType)) {
                    EventMessage decode = this.emsgDecoder.decode(sampleAndTrimBuffer);
                    if (!emsgContainsExpectedWrappedFormat(decode)) {
                        Log.w(HlsSampleStreamWrapper.TAG, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.delegateFormat.sampleMimeType, decode.getWrappedMetadataFormat()}));
                        return;
                    }
                    sampleAndTrimBuffer = new ParsableByteArray((byte[]) Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                } else {
                    Log.w(HlsSampleStreamWrapper.TAG, "Ignoring sample for unsupported format: " + this.format.sampleMimeType);
                    return;
                }
            }
            int bytesLeft = sampleAndTrimBuffer.bytesLeft();
            this.delegate.sampleData(sampleAndTrimBuffer, bytesLeft);
            this.delegate.sampleMetadata(j, i, bytesLeft, i3, cryptoData);
        }

        private boolean emsgContainsExpectedWrappedFormat(EventMessage eventMessage) {
            Format wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && Util.areEqual(this.delegateFormat.sampleMimeType, wrappedMetadataFormat.sampleMimeType);
        }

        private void ensureBufferCapacity(int i) {
            byte[] bArr = this.buffer;
            if (bArr.length < i) {
                this.buffer = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        private ParsableByteArray getSampleAndTrimBuffer(int i, int i2) {
            int i3 = this.bufferPosition - i2;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.buffer, i3 - i, i3));
            byte[] bArr = this.buffer;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.bufferPosition = i2;
            return parsableByteArray;
        }
    }
}
