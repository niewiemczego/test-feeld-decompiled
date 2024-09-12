package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    /* access modifiers changed from: private */
    public static final Format ICY_FORMAT = new Format.Builder().setId("icy").setSampleMimeType(MimeTypes.APPLICATION_ICY).build();
    /* access modifiers changed from: private */
    public static final Map<String, String> ICY_METADATA_HEADERS = createIcyMetadataHeaders();
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    /* access modifiers changed from: private */
    public final long continueLoadingCheckIntervalBytes;
    /* access modifiers changed from: private */
    public final String customCacheKey;
    private final DataSource dataSource;
    private int dataType;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private long durationUs;
    private int enabledTrackCount;
    private int extractedSamplesCountAtStartOfLoad;
    /* access modifiers changed from: private */
    public final Handler handler;
    private boolean haveAudioVideoTracks;
    /* access modifiers changed from: private */
    public IcyHeaders icyHeaders;
    private boolean isLengthKnown;
    private boolean isLive;
    private long lastSeekPositionUs;
    private final Listener listener;
    private final ConditionVariable loadCondition;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("ProgressiveMediaPeriod");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private boolean notifyDiscontinuity;
    /* access modifiers changed from: private */
    public final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private boolean released;
    private TrackId[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private TrackState trackState;
    private final Uri uri;

    interface Listener {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    public void reevaluateBuffer(long j) {
    }

    public ProgressiveMediaPeriod(Uri uri2, DataSource dataSource2, ProgressiveMediaExtractor progressiveMediaExtractor2, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener2, Allocator allocator2, String str, int i) {
        this.uri = uri2;
        this.dataSource = dataSource2;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.listener = listener2;
        this.allocator = allocator2;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = (long) i;
        this.progressiveMediaExtractor = progressiveMediaExtractor2;
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new ProgressiveMediaPeriod$$ExternalSyntheticLambda0(this);
        this.onContinueLoadingRequestedRunnable = new ProgressiveMediaPeriod$$ExternalSyntheticLambda1(this);
        this.handler = Util.createHandlerForCurrentLooper();
        this.sampleQueueTrackIds = new TrackId[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.dataType = 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-exoplayer2-source-ProgressiveMediaPeriod  reason: not valid java name */
    public /* synthetic */ void m511lambda$new$0$comgoogleandroidexoplayer2sourceProgressiveMediaPeriod() {
        if (!this.released) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public void release() {
        if (this.prepared) {
            for (SampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.callback = null;
        this.released = true;
    }

    public void onLoaderReleased() {
        for (SampleQueue release : this.sampleQueues) {
            release.release();
        }
        this.progressiveMediaExtractor.release();
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.loadCondition.open();
        startLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public TrackGroupArray getTrackGroups() {
        assertPrepared();
        return this.trackState.tracks;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ExoTrackSelection exoTrackSelection;
        assertPrepared();
        TrackGroupArray trackGroupArray = this.trackState.tracks;
        boolean[] zArr3 = this.trackState.trackEnabledStates;
        int i = this.enabledTrackCount;
        int i2 = 0;
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i3];
            if (sampleStreamImpl != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                int access$000 = sampleStreamImpl.track;
                Assertions.checkState(zArr3[access$000]);
                this.enabledTrackCount--;
                zArr3[access$000] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.seenFirstTrackSelection ? j != 0 : i == 0;
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            if (sampleStreamArr[i4] == null && (exoTrackSelection = exoTrackSelectionArr[i4]) != null) {
                Assertions.checkState(exoTrackSelection.length() == 1);
                Assertions.checkState(exoTrackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[indexOf]);
                this.enabledTrackCount++;
                zArr3[indexOf] = true;
                sampleStreamArr[i4] = new SampleStreamImpl(indexOf);
                zArr2[i4] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    z = !sampleQueue.seekTo(j, true) && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j;
    }

    public void discardBuffer(long j, boolean z) {
        assertPrepared();
        if (!isPendingReset()) {
            boolean[] zArr = this.trackState.trackEnabledStates;
            int length = this.sampleQueues.length;
            for (int i = 0; i < length; i++) {
                this.sampleQueues[i].discardTo(j, z, zArr[i]);
            }
        }
    }

    public boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.hasFatalError() || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public boolean isLoading() {
        return this.loader.isLoading() && this.loadCondition.isOpen();
    }

    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    public long readDiscontinuity() {
        if (!this.notifyDiscontinuity) {
            return C.TIME_UNSET;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return C.TIME_UNSET;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    public long getBufferedPositionUs() {
        long j;
        assertPrepared();
        if (this.loadingFinished || this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length = this.sampleQueues.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.trackState.trackIsAudioVideoFlags[i] && this.trackState.trackEnabledStates[i] && !this.sampleQueues[i].isLastSampleQueued()) {
                    j = Math.min(j, this.sampleQueues[i].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = getLargestQueuedTimestampUs(false);
        }
        return j == Long.MIN_VALUE ? this.lastSeekPositionUs : j;
    }

    public long seekToUs(long j) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (!this.seekMap.isSeekable()) {
            j = 0;
        }
        int i = 0;
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = j;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j;
            return j;
        } else if (this.dataType != 7 && seekInsideBufferUs(zArr, j)) {
            return j;
        } else {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i < length) {
                    sampleQueueArr[i].discardToEnd();
                    i++;
                }
                this.loader.cancelLoading();
            } else {
                this.loader.clearFatalError();
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i < length2) {
                    sampleQueueArr2[i].reset();
                    i++;
                }
            }
            return j;
        }
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        assertPrepared();
        if (!this.seekMap.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j);
        return seekParameters.resolveSeekPositionUs(j, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    /* access modifiers changed from: package-private */
    public boolean isReady(int i) {
        return !suppressRead() && this.sampleQueues[i].isReady(this.loadingFinished);
    }

    /* access modifiers changed from: package-private */
    public void maybeThrowError(int i) throws IOException {
        this.sampleQueues[i].maybeThrowError();
        maybeThrowError();
    }

    /* access modifiers changed from: package-private */
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }

    /* access modifiers changed from: package-private */
    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(i);
        int read = this.sampleQueues[i].read(formatHolder, decoderInputBuffer, i2, this.loadingFinished);
        if (read == -3) {
            maybeStartDeferredRetry(i);
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public int skipData(int i, long j) {
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(i);
        SampleQueue sampleQueue = this.sampleQueues[i];
        int skipCount = sampleQueue.getSkipCount(j, this.loadingFinished);
        sampleQueue.skip(skipCount);
        if (skipCount == 0) {
            maybeStartDeferredRetry(i);
        }
        return skipCount;
    }

    private void maybeNotifyDownstreamFormat(int i) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackNotifiedDownstreamFormats;
        if (!zArr[i]) {
            Format format = this.trackState.tracks.get(i).getFormat(0);
            this.mediaSourceEventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, (Object) null, this.lastSeekPositionUs);
            zArr[i] = true;
        }
    }

    private void maybeStartDeferredRetry(int i) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[i]) {
            if (!this.sampleQueues[i].isReady(false)) {
                this.pendingResetPositionUs = 0;
                this.pendingDeferredRetry = false;
                this.notifyDiscontinuity = true;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j, long j2) {
        SeekMap seekMap2;
        if (this.durationUs == C.TIME_UNSET && (seekMap2 = this.seekMap) != null) {
            boolean isSeekable = seekMap2.isSeekable();
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs(true);
            long j3 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : largestQueuedTimestampUs + 10000;
            this.durationUs = j3;
            this.listener.onSourceInfoRefreshed(j3, isSeekable, this.isLive);
        }
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        this.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
        this.loadingFinished = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        this.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
        if (!z) {
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            if (this.enabledTrackCount > 0) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    public Loader.LoadErrorAction onLoadError(ExtractingLoadable extractingLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2;
        boolean z;
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, access$100.getBytesRead());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, (Format) null, 0, (Object) null, Util.usToMs(extractingLoadable.seekTimeUs), Util.usToMs(this.durationUs)), iOException, i));
        if (retryDelayMsFor == C.TIME_UNSET) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
            ExtractingLoadable extractingLoadable3 = extractingLoadable;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
                extractingLoadable2 = extractingLoadable;
                z = true;
            } else {
                z = false;
                extractingLoadable2 = extractingLoadable;
            }
            if (configureRetry(extractingLoadable2, extractedSamplesCount)) {
                loadErrorAction = Loader.createRetryAction(z, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY;
            }
        }
        boolean z2 = !loadErrorAction.isRetry();
        this.mediaSourceEventDispatcher.loadError(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, iOException, z2);
        if (z2) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        }
        return loadErrorAction;
    }

    public TrackOutput track(int i, int i2) {
        return prepareTrackOutput(new TrackId(i, false));
    }

    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void seekMap(SeekMap seekMap2) {
        this.handler.post(new ProgressiveMediaPeriod$$ExternalSyntheticLambda3(this, seekMap2));
    }

    /* access modifiers changed from: package-private */
    public TrackOutput icyTrack() {
        return prepareTrackOutput(new TrackId(0, true));
    }

    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    /* access modifiers changed from: private */
    public void onLengthKnown() {
        this.handler.post(new ProgressiveMediaPeriod$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onLengthKnown$2$com-google-android-exoplayer2-source-ProgressiveMediaPeriod  reason: not valid java name */
    public /* synthetic */ void m512lambda$onLengthKnown$2$comgoogleandroidexoplayer2sourceProgressiveMediaPeriod() {
        this.isLengthKnown = true;
    }

    private TrackOutput prepareTrackOutput(TrackId trackId) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (trackId.equals(this.sampleQueueTrackIds[i])) {
                return this.sampleQueues[i];
            }
        }
        SampleQueue createWithDrm = SampleQueue.createWithDrm(this.allocator, this.drmSessionManager, this.drmEventDispatcher);
        createWithDrm.setUpstreamFormatChangeListener(this);
        int i2 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.sampleQueueTrackIds, i2);
        trackIdArr[length] = trackId;
        this.sampleQueueTrackIds = (TrackId[]) Util.castNonNullTypeArray(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i2);
        sampleQueueArr[length] = createWithDrm;
        this.sampleQueues = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return createWithDrm;
    }

    /* access modifiers changed from: private */
    /* renamed from: setSeekMap */
    public void m513lambda$seekMap$1$comgoogleandroidexoplayer2sourceProgressiveMediaPeriod(SeekMap seekMap2) {
        this.seekMap = this.icyHeaders == null ? seekMap2 : new SeekMap.Unseekable(C.TIME_UNSET);
        this.durationUs = seekMap2.getDurationUs();
        int i = 1;
        boolean z = !this.isLengthKnown && seekMap2.getDurationUs() == C.TIME_UNSET;
        this.isLive = z;
        if (z) {
            i = 7;
        }
        this.dataType = i;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap2.isSeekable(), this.isLive);
        if (!this.prepared) {
            maybeFinishPrepare();
        }
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Metadata metadata;
        if (!this.released && !this.prepared && this.sampleQueuesBuilt && this.seekMap != null) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            int length = sampleQueueArr.length;
            int i = 0;
            while (i < length) {
                if (sampleQueueArr[i].getUpstreamFormat() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.loadCondition.close();
            int length2 = this.sampleQueues.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                Format format = (Format) Assertions.checkNotNull(this.sampleQueues[i2].getUpstreamFormat());
                String str = format.sampleMimeType;
                boolean isAudio = MimeTypes.isAudio(str);
                boolean z = isAudio || MimeTypes.isVideo(str);
                zArr[i2] = z;
                this.haveAudioVideoTracks = z | this.haveAudioVideoTracks;
                IcyHeaders icyHeaders2 = this.icyHeaders;
                if (icyHeaders2 != null) {
                    if (isAudio || this.sampleQueueTrackIds[i2].isIcyTrack) {
                        Metadata metadata2 = format.metadata;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders2);
                        } else {
                            metadata = metadata2.copyWithAppendedEntries(icyHeaders2);
                        }
                        format = format.buildUpon().setMetadata(metadata).build();
                    }
                    if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders2.bitrate != -1) {
                        format = format.buildUpon().setAverageBitrate(icyHeaders2.bitrate).build();
                    }
                }
                trackGroupArr[i2] = new TrackGroup(Integer.toString(i2), format.copyWithCryptoType(this.drmSessionManager.getCryptoType(format)));
            }
            this.trackState = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            this.prepared = true;
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.progressiveMediaExtractor, this, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j = this.durationUs;
            if (j == C.TIME_UNSET || this.pendingResetPositionUs <= j) {
                extractingLoadable.setLoadPosition(((SeekMap) Assertions.checkNotNull(this.seekMap)).getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                for (SampleQueue startTimeUs : this.sampleQueues) {
                    startTimeUs.setStartTimeUs(this.pendingResetPositionUs);
                }
                this.pendingResetPositionUs = C.TIME_UNSET;
            } else {
                this.loadingFinished = true;
                this.pendingResetPositionUs = C.TIME_UNSET;
                return;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.mediaSourceEventDispatcher.loadStarted(new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, this.loader.startLoading(extractingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType))), 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i) {
        SeekMap seekMap2;
        if (this.isLengthKnown || !((seekMap2 = this.seekMap) == null || seekMap2.getDurationUs() == C.TIME_UNSET)) {
            this.extractedSamplesCountAtStartOfLoad = i;
            return true;
        }
        if (!this.prepared || suppressRead()) {
            this.notifyDiscontinuity = this.prepared;
            this.lastSeekPositionUs = 0;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            extractingLoadable.setLoadPosition(0, 0);
            return true;
        }
        this.pendingDeferredRetry = true;
        return false;
    }

    private boolean seekInsideBufferUs(boolean[] zArr, long j) {
        int length = this.sampleQueues.length;
        for (int i = 0; i < length; i++) {
            if (!this.sampleQueues[i].seekTo(j, false) && (zArr[i] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    private int getExtractedSamplesCount() {
        int i = 0;
        for (SampleQueue writeIndex : this.sampleQueues) {
            i += writeIndex.getWriteIndex();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public long getLargestQueuedTimestampUs(boolean z) {
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.sampleQueues.length; i++) {
            if (z || ((TrackState) Assertions.checkNotNull(this.trackState)).trackEnabledStates[i]) {
                j = Math.max(j, this.sampleQueues[i].getLargestQueuedTimestampUs());
            }
        }
        return j;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != C.TIME_UNSET;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void assertPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackState);
        Assertions.checkNotNull(this.seekMap);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */
        public final int track;

        public SampleStreamImpl(int i) {
            this.track = i;
        }

        public boolean isReady() {
            return ProgressiveMediaPeriod.this.isReady(this.track);
        }

        public void maybeThrowError() throws IOException {
            ProgressiveMediaPeriod.this.maybeThrowError(this.track);
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            return ProgressiveMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, i);
        }

        public int skipData(long j) {
            return ProgressiveMediaPeriod.this.skipData(this.track, j);
        }
    }

    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        /* access modifiers changed from: private */
        public final StatsDataSource dataSource;
        /* access modifiers changed from: private */
        public DataSpec dataSpec = buildDataSpec(0);
        private final ExtractorOutput extractorOutput;
        private TrackOutput icyTrackOutput;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        /* access modifiers changed from: private */
        public final long loadTaskId = LoadEventInfo.getNewId();
        private boolean pendingExtractorSeek = true;
        private final PositionHolder positionHolder = new PositionHolder();
        private final ProgressiveMediaExtractor progressiveMediaExtractor;
        /* access modifiers changed from: private */
        public long seekTimeUs;
        private boolean seenIcyMetadata;
        private final Uri uri;

        public ExtractingLoadable(Uri uri2, DataSource dataSource2, ProgressiveMediaExtractor progressiveMediaExtractor2, ExtractorOutput extractorOutput2, ConditionVariable conditionVariable) {
            this.uri = uri2;
            this.dataSource = new StatsDataSource(dataSource2);
            this.progressiveMediaExtractor = progressiveMediaExtractor2;
            this.extractorOutput = extractorOutput2;
            this.loadCondition = conditionVariable;
        }

        public void cancelLoad() {
            this.loadCanceled = true;
        }

        public void load() throws IOException {
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                try {
                    long j = this.positionHolder.position;
                    DataSpec buildDataSpec = buildDataSpec(j);
                    this.dataSpec = buildDataSpec;
                    long open = this.dataSource.open(buildDataSpec);
                    if (open != -1) {
                        open += j;
                        ProgressiveMediaPeriod.this.onLengthKnown();
                    }
                    long j2 = open;
                    IcyHeaders unused = ProgressiveMediaPeriod.this.icyHeaders = IcyHeaders.parse(this.dataSource.getResponseHeaders());
                    DataReader dataReader = this.dataSource;
                    if (!(ProgressiveMediaPeriod.this.icyHeaders == null || ProgressiveMediaPeriod.this.icyHeaders.metadataInterval == -1)) {
                        dataReader = new IcyDataSource(this.dataSource, ProgressiveMediaPeriod.this.icyHeaders.metadataInterval, this);
                        TrackOutput icyTrack = ProgressiveMediaPeriod.this.icyTrack();
                        this.icyTrackOutput = icyTrack;
                        icyTrack.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    long j3 = j;
                    this.progressiveMediaExtractor.init(dataReader, this.uri, this.dataSource.getResponseHeaders(), j, j2, this.extractorOutput);
                    if (ProgressiveMediaPeriod.this.icyHeaders != null) {
                        this.progressiveMediaExtractor.disableSeekingOnMp3Streams();
                    }
                    if (this.pendingExtractorSeek) {
                        this.progressiveMediaExtractor.seek(j3, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    while (true) {
                        long j4 = j3;
                        while (i == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            i = this.progressiveMediaExtractor.read(this.positionHolder);
                            j3 = this.progressiveMediaExtractor.getCurrentInputPosition();
                            if (j3 > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + j4) {
                                this.loadCondition.close();
                                ProgressiveMediaPeriod.this.handler.post(ProgressiveMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    DataSourceUtil.closeQuietly(this.dataSource);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i == 1 || this.progressiveMediaExtractor.getCurrentInputPosition() == -1)) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    DataSourceUtil.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        public void onIcyMetadata(ParsableByteArray parsableByteArray) {
            long j;
            if (!this.seenIcyMetadata) {
                j = this.seekTimeUs;
            } else {
                j = Math.max(ProgressiveMediaPeriod.this.getLargestQueuedTimestampUs(true), this.seekTimeUs);
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.icyTrackOutput);
            trackOutput.sampleData(parsableByteArray, bytesLeft);
            trackOutput.sampleMetadata(j, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
            this.seenIcyMetadata = true;
        }

        private DataSpec buildDataSpec(long j) {
            return new DataSpec.Builder().setUri(this.uri).setPosition(j).setKey(ProgressiveMediaPeriod.this.customCacheKey).setFlags(6).setHttpRequestHeaders(ProgressiveMediaPeriod.ICY_METADATA_HEADERS).build();
        }

        /* access modifiers changed from: private */
        public void setLoadPosition(long j, long j2) {
            this.positionHolder.position = j;
            this.seekTimeUs = j2;
            this.pendingExtractorSeek = true;
            this.seenIcyMetadata = false;
        }
    }

    private static final class TrackState {
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.tracks = trackGroupArray;
            this.trackIsAudioVideoFlags = zArr;
            this.trackEnabledStates = new boolean[trackGroupArray.length];
            this.trackNotifiedDownstreamFormats = new boolean[trackGroupArray.length];
        }
    }

    private static final class TrackId {
        public final int id;
        public final boolean isIcyTrack;

        public TrackId(int i, boolean z) {
            this.id = i;
            this.isIcyTrack = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            if (this.id == trackId.id && this.isIcyTrack == trackId.isIcyTrack) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.id * 31) + (this.isIcyTrack ? 1 : 0);
        }
    }

    private static Map<String, String> createIcyMetadataHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return Collections.unmodifiableMap(hashMap);
    }
}
