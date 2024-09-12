package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.source.rtsp.RtspClient;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

final class RtspMediaPeriod implements MediaPeriod {
    private static final int PORT_BINDING_MAX_RETRY_COUNT = 3;
    /* access modifiers changed from: private */
    public final Allocator allocator;
    private MediaPeriod.Callback callback;
    /* access modifiers changed from: private */
    public final Handler handler = Util.createHandlerForCurrentLooper();
    /* access modifiers changed from: private */
    public final InternalListener internalListener;
    /* access modifiers changed from: private */
    public boolean isUsingRtpTcp;
    /* access modifiers changed from: private */
    public final Listener listener;
    private boolean loadingFinished;
    /* access modifiers changed from: private */
    public boolean notifyDiscontinuity;
    /* access modifiers changed from: private */
    public long pendingSeekPositionUs;
    /* access modifiers changed from: private */
    public long pendingSeekPositionUsForTcpRetry;
    /* access modifiers changed from: private */
    public RtspMediaSource.RtspPlaybackException playbackException;
    private int portBindingRetryCount;
    /* access modifiers changed from: private */
    public IOException preparationError;
    /* access modifiers changed from: private */
    public boolean prepared;
    private boolean released;
    /* access modifiers changed from: private */
    public long requestedSeekPositionUs;
    /* access modifiers changed from: private */
    public final RtpDataChannel.Factory rtpDataChannelFactory;
    /* access modifiers changed from: private */
    public final RtspClient rtspClient;
    /* access modifiers changed from: private */
    public final List<RtspLoaderWrapper> rtspLoaderWrappers;
    /* access modifiers changed from: private */
    public final List<RtpLoadInfo> selectedLoadInfos;
    private ImmutableList<TrackGroup> trackGroups;
    private boolean trackSelected;

    interface Listener {
        void onSeekingUnsupported() {
        }

        void onSourceInfoRefreshed(RtspSessionTiming rtspSessionTiming);
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    public void reevaluateBuffer(long j) {
    }

    static /* synthetic */ int access$1008(RtspMediaPeriod rtspMediaPeriod) {
        int i = rtspMediaPeriod.portBindingRetryCount;
        rtspMediaPeriod.portBindingRetryCount = i + 1;
        return i;
    }

    public RtspMediaPeriod(Allocator allocator2, RtpDataChannel.Factory factory, Uri uri, Listener listener2, String str, SocketFactory socketFactory, boolean z) {
        this.allocator = allocator2;
        this.rtpDataChannelFactory = factory;
        this.listener = listener2;
        InternalListener internalListener2 = new InternalListener();
        this.internalListener = internalListener2;
        this.rtspClient = new RtspClient(internalListener2, internalListener2, str, uri, socketFactory, z);
        this.rtspLoaderWrappers = new ArrayList();
        this.selectedLoadInfos = new ArrayList();
        this.pendingSeekPositionUs = C.TIME_UNSET;
        this.requestedSeekPositionUs = C.TIME_UNSET;
        this.pendingSeekPositionUsForTcpRetry = C.TIME_UNSET;
    }

    public void release() {
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            this.rtspLoaderWrappers.get(i).release();
        }
        Util.closeQuietly(this.rtspClient);
        this.released = true;
    }

    public void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        try {
            this.rtspClient.start();
        } catch (IOException e) {
            this.preparationError = e;
            Util.closeQuietly(this.rtspClient);
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        IOException iOException = this.preparationError;
        if (iOException != null) {
            throw iOException;
        }
    }

    public TrackGroupArray getTrackGroups() {
        Assertions.checkState(this.prepared);
        return new TrackGroupArray((TrackGroup[]) ((ImmutableList) Assertions.checkNotNull(this.trackGroups)).toArray(new TrackGroup[0]));
    }

    public ImmutableList<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return ImmutableList.of();
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                sampleStreamArr[i] = null;
            }
        }
        this.selectedLoadInfos.clear();
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                TrackGroup trackGroup = exoTrackSelection.getTrackGroup();
                int indexOf = ((ImmutableList) Assertions.checkNotNull(this.trackGroups)).indexOf(trackGroup);
                this.selectedLoadInfos.add(((RtspLoaderWrapper) Assertions.checkNotNull(this.rtspLoaderWrappers.get(indexOf))).loadInfo);
                if (this.trackGroups.contains(trackGroup) && sampleStreamArr[i2] == null) {
                    sampleStreamArr[i2] = new SampleStreamImpl(indexOf);
                    zArr2[i2] = true;
                }
            }
        }
        for (int i3 = 0; i3 < this.rtspLoaderWrappers.size(); i3++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.rtspLoaderWrappers.get(i3);
            if (!this.selectedLoadInfos.contains(rtspLoaderWrapper.loadInfo)) {
                rtspLoaderWrapper.cancelLoad();
            }
        }
        this.trackSelected = true;
        maybeSetupTracks();
        return j;
    }

    public void discardBuffer(long j, boolean z) {
        if (!isSeekPending()) {
            for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
                RtspLoaderWrapper rtspLoaderWrapper = this.rtspLoaderWrappers.get(i);
                if (!rtspLoaderWrapper.canceled) {
                    rtspLoaderWrapper.sampleQueue.discardTo(j, z, true);
                }
            }
        }
    }

    public long readDiscontinuity() {
        if (!this.notifyDiscontinuity) {
            return C.TIME_UNSET;
        }
        this.notifyDiscontinuity = false;
        return 0;
    }

    public long seekToUs(long j) {
        if (getBufferedPositionUs() != 0 || this.isUsingRtpTcp) {
            discardBuffer(j, false);
            this.requestedSeekPositionUs = j;
            if (isSeekPending()) {
                int state = this.rtspClient.getState();
                if (state == 1) {
                    return j;
                }
                if (state == 2) {
                    this.pendingSeekPositionUs = j;
                    this.rtspClient.seekToUs(j);
                    return j;
                }
                throw new IllegalStateException();
            } else if (seekInsideBufferUs(j)) {
                return j;
            } else {
                this.pendingSeekPositionUs = j;
                this.rtspClient.seekToUs(j);
                for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
                    this.rtspLoaderWrappers.get(i).seekTo(j);
                }
                return j;
            }
        } else {
            this.pendingSeekPositionUsForTcpRetry = j;
            return j;
        }
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished || this.rtspLoaderWrappers.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j = this.requestedSeekPositionUs;
        if (j != C.TIME_UNSET) {
            return j;
        }
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.rtspLoaderWrappers.get(i);
            if (!rtspLoaderWrapper.canceled) {
                j2 = Math.min(j2, rtspLoaderWrapper.getBufferedPositionUs());
                z = false;
            }
        }
        if (z || j2 == Long.MIN_VALUE) {
            return 0;
        }
        return j2;
    }

    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    public boolean continueLoading(long j) {
        return isLoading();
    }

    public boolean isLoading() {
        return !this.loadingFinished;
    }

    /* access modifiers changed from: package-private */
    public boolean isReady(int i) {
        return !suppressRead() && this.rtspLoaderWrappers.get(i).isSampleQueueReady();
    }

    /* access modifiers changed from: package-private */
    public int readData(int i, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (suppressRead()) {
            return -3;
        }
        return this.rtspLoaderWrappers.get(i).read(formatHolder, decoderInputBuffer, i2);
    }

    /* access modifiers changed from: package-private */
    public int skipData(int i, long j) {
        if (suppressRead()) {
            return -3;
        }
        return this.rtspLoaderWrappers.get(i).skipData(j);
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity;
    }

    /* access modifiers changed from: private */
    public RtpDataLoadable getLoadableByTrackUri(Uri uri) {
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            if (!this.rtspLoaderWrappers.get(i).canceled) {
                RtpLoadInfo rtpLoadInfo = this.rtspLoaderWrappers.get(i).loadInfo;
                if (rtpLoadInfo.getTrackUri().equals(uri)) {
                    return rtpLoadInfo.loadable;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean isSeekPending() {
        return this.pendingSeekPositionUs != C.TIME_UNSET;
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && !this.prepared) {
            int i = 0;
            while (i < this.rtspLoaderWrappers.size()) {
                if (this.rtspLoaderWrappers.get(i).sampleQueue.getUpstreamFormat() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.prepared = true;
            this.trackGroups = buildTrackGroups(ImmutableList.copyOf(this.rtspLoaderWrappers));
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    private boolean seekInsideBufferUs(long j) {
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            if (!this.rtspLoaderWrappers.get(i).sampleQueue.seekTo(j, false)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void maybeSetupTracks() {
        boolean z = true;
        for (int i = 0; i < this.selectedLoadInfos.size(); i++) {
            z &= this.selectedLoadInfos.get(i).isTransportReady();
        }
        if (z && this.trackSelected) {
            this.rtspClient.setupSelectedTracks(this.selectedLoadInfos);
        }
    }

    /* access modifiers changed from: private */
    public void updateLoadingFinished() {
        this.loadingFinished = true;
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            this.loadingFinished &= this.rtspLoaderWrappers.get(i).canceled;
        }
    }

    private static ImmutableList<TrackGroup> buildTrackGroups(ImmutableList<RtspLoaderWrapper> immutableList) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < immutableList.size(); i++) {
            builder.add((Object) new TrackGroup(Integer.toString(i), (Format) Assertions.checkNotNull(((RtspLoaderWrapper) immutableList.get(i)).sampleQueue.getUpstreamFormat())));
        }
        return builder.build();
    }

    private final class InternalListener implements ExtractorOutput, Loader.Callback<RtpDataLoadable>, SampleQueue.UpstreamFormatChangedListener, RtspClient.SessionInfoListener, RtspClient.PlaybackEventListener {
        public void onLoadCanceled(RtpDataLoadable rtpDataLoadable, long j, long j2, boolean z) {
        }

        public void seekMap(SeekMap seekMap) {
        }

        private InternalListener() {
        }

        public TrackOutput track(int i, int i2) {
            return ((RtspLoaderWrapper) Assertions.checkNotNull((RtspLoaderWrapper) RtspMediaPeriod.this.rtspLoaderWrappers.get(i))).sampleQueue;
        }

        public void endTracks() {
            RtspMediaPeriod.this.handler.post(new RtspMediaPeriod$InternalListener$$ExternalSyntheticLambda1(RtspMediaPeriod.this));
        }

        public void onLoadCompleted(RtpDataLoadable rtpDataLoadable, long j, long j2) {
            if (RtspMediaPeriod.this.getBufferedPositionUs() != 0) {
                for (int i = 0; i < RtspMediaPeriod.this.rtspLoaderWrappers.size(); i++) {
                    RtspLoaderWrapper rtspLoaderWrapper = (RtspLoaderWrapper) RtspMediaPeriod.this.rtspLoaderWrappers.get(i);
                    if (rtspLoaderWrapper.loadInfo.loadable == rtpDataLoadable) {
                        rtspLoaderWrapper.cancelLoad();
                        return;
                    }
                }
            } else if (!RtspMediaPeriod.this.isUsingRtpTcp) {
                RtspMediaPeriod.this.retryWithRtpTcp();
                boolean unused = RtspMediaPeriod.this.isUsingRtpTcp = true;
            }
        }

        public Loader.LoadErrorAction onLoadError(RtpDataLoadable rtpDataLoadable, long j, long j2, IOException iOException, int i) {
            if (!RtspMediaPeriod.this.prepared) {
                IOException unused = RtspMediaPeriod.this.preparationError = iOException;
            } else if (!(iOException.getCause() instanceof BindException)) {
                RtspMediaSource.RtspPlaybackException unused2 = RtspMediaPeriod.this.playbackException = new RtspMediaSource.RtspPlaybackException(rtpDataLoadable.rtspMediaTrack.uri.toString(), iOException);
            } else if (RtspMediaPeriod.access$1008(RtspMediaPeriod.this) < 3) {
                return Loader.RETRY;
            }
            return Loader.DONT_RETRY;
        }

        public void onUpstreamFormatChanged(Format format) {
            RtspMediaPeriod.this.handler.post(new RtspMediaPeriod$InternalListener$$ExternalSyntheticLambda0(RtspMediaPeriod.this));
        }

        public void onRtspSetupCompleted() {
            RtspMediaPeriod.this.rtspClient.startPlayback(0);
        }

        public void onPlaybackStarted(long j, ImmutableList<RtspTrackTiming> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i = 0; i < immutableList.size(); i++) {
                arrayList.add((String) Assertions.checkNotNull(((RtspTrackTiming) immutableList.get(i)).uri.getPath()));
            }
            for (int i2 = 0; i2 < RtspMediaPeriod.this.selectedLoadInfos.size(); i2++) {
                if (!arrayList.contains(((RtpLoadInfo) RtspMediaPeriod.this.selectedLoadInfos.get(i2)).getTrackUri().getPath())) {
                    RtspMediaPeriod.this.listener.onSeekingUnsupported();
                    if (RtspMediaPeriod.this.isSeekPending()) {
                        boolean unused = RtspMediaPeriod.this.notifyDiscontinuity = true;
                        long unused2 = RtspMediaPeriod.this.pendingSeekPositionUs = C.TIME_UNSET;
                        long unused3 = RtspMediaPeriod.this.requestedSeekPositionUs = C.TIME_UNSET;
                        long unused4 = RtspMediaPeriod.this.pendingSeekPositionUsForTcpRetry = C.TIME_UNSET;
                    }
                }
            }
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                RtspTrackTiming rtspTrackTiming = (RtspTrackTiming) immutableList.get(i3);
                RtpDataLoadable access$2000 = RtspMediaPeriod.this.getLoadableByTrackUri(rtspTrackTiming.uri);
                if (access$2000 != null) {
                    access$2000.setTimestamp(rtspTrackTiming.rtpTimestamp);
                    access$2000.setSequenceNumber(rtspTrackTiming.sequenceNumber);
                    if (RtspMediaPeriod.this.isSeekPending() && RtspMediaPeriod.this.pendingSeekPositionUs == RtspMediaPeriod.this.requestedSeekPositionUs) {
                        access$2000.seekToUs(j, rtspTrackTiming.rtpTimestamp);
                    }
                }
            }
            if (RtspMediaPeriod.this.isSeekPending()) {
                if (RtspMediaPeriod.this.pendingSeekPositionUs == RtspMediaPeriod.this.requestedSeekPositionUs) {
                    long unused5 = RtspMediaPeriod.this.pendingSeekPositionUs = C.TIME_UNSET;
                    long unused6 = RtspMediaPeriod.this.requestedSeekPositionUs = C.TIME_UNSET;
                    return;
                }
                long unused7 = RtspMediaPeriod.this.pendingSeekPositionUs = C.TIME_UNSET;
                RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                rtspMediaPeriod.seekToUs(rtspMediaPeriod.requestedSeekPositionUs);
            } else if (RtspMediaPeriod.this.pendingSeekPositionUsForTcpRetry != C.TIME_UNSET) {
                RtspMediaPeriod rtspMediaPeriod2 = RtspMediaPeriod.this;
                rtspMediaPeriod2.seekToUs(rtspMediaPeriod2.pendingSeekPositionUsForTcpRetry);
                long unused8 = RtspMediaPeriod.this.pendingSeekPositionUsForTcpRetry = C.TIME_UNSET;
            }
        }

        public void onPlaybackError(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            RtspMediaSource.RtspPlaybackException unused = RtspMediaPeriod.this.playbackException = rtspPlaybackException;
        }

        public void onSessionTimelineUpdated(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList) {
            for (int i = 0; i < immutableList.size(); i++) {
                RtspMediaPeriod rtspMediaPeriod = RtspMediaPeriod.this;
                RtspLoaderWrapper rtspLoaderWrapper = new RtspLoaderWrapper((RtspMediaTrack) immutableList.get(i), i, rtspMediaPeriod.rtpDataChannelFactory);
                RtspMediaPeriod.this.rtspLoaderWrappers.add(rtspLoaderWrapper);
                rtspLoaderWrapper.startLoading();
            }
            RtspMediaPeriod.this.listener.onSourceInfoRefreshed(rtspSessionTiming);
        }

        public void onSessionTimelineRequestFailed(String str, Throwable th) {
            IOException unused = RtspMediaPeriod.this.preparationError = th == null ? new IOException(str) : new IOException(str, th);
        }
    }

    /* access modifiers changed from: private */
    public void retryWithRtpTcp() {
        this.rtspClient.retryWithRtpTcp();
        RtpDataChannel.Factory createFallbackDataChannelFactory = this.rtpDataChannelFactory.createFallbackDataChannelFactory();
        if (createFallbackDataChannelFactory == null) {
            this.playbackException = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.rtspLoaderWrappers.size());
        ArrayList arrayList2 = new ArrayList(this.selectedLoadInfos.size());
        for (int i = 0; i < this.rtspLoaderWrappers.size(); i++) {
            RtspLoaderWrapper rtspLoaderWrapper = this.rtspLoaderWrappers.get(i);
            if (!rtspLoaderWrapper.canceled) {
                RtspLoaderWrapper rtspLoaderWrapper2 = new RtspLoaderWrapper(rtspLoaderWrapper.loadInfo.mediaTrack, i, createFallbackDataChannelFactory);
                arrayList.add(rtspLoaderWrapper2);
                rtspLoaderWrapper2.startLoading();
                if (this.selectedLoadInfos.contains(rtspLoaderWrapper.loadInfo)) {
                    arrayList2.add(rtspLoaderWrapper2.loadInfo);
                }
            } else {
                arrayList.add(rtspLoaderWrapper);
            }
        }
        ImmutableList<RtspLoaderWrapper> copyOf = ImmutableList.copyOf(this.rtspLoaderWrappers);
        this.rtspLoaderWrappers.clear();
        this.rtspLoaderWrappers.addAll(arrayList);
        this.selectedLoadInfos.clear();
        this.selectedLoadInfos.addAll(arrayList2);
        for (int i2 = 0; i2 < copyOf.size(); i2++) {
            ((RtspLoaderWrapper) copyOf.get(i2)).cancelLoad();
        }
    }

    private final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int i) {
            this.track = i;
        }

        public boolean isReady() {
            return RtspMediaPeriod.this.isReady(this.track);
        }

        public void maybeThrowError() throws RtspMediaSource.RtspPlaybackException {
            if (RtspMediaPeriod.this.playbackException != null) {
                throw RtspMediaPeriod.this.playbackException;
            }
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            return RtspMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, i);
        }

        public int skipData(long j) {
            return RtspMediaPeriod.this.skipData(this.track, j);
        }
    }

    private final class RtspLoaderWrapper {
        /* access modifiers changed from: private */
        public boolean canceled;
        public final RtpLoadInfo loadInfo;
        private final Loader loader;
        private boolean released;
        /* access modifiers changed from: private */
        public final SampleQueue sampleQueue;

        public RtspLoaderWrapper(RtspMediaTrack rtspMediaTrack, int i, RtpDataChannel.Factory factory) {
            this.loadInfo = new RtpLoadInfo(rtspMediaTrack, i, factory);
            this.loader = new Loader("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper " + i);
            SampleQueue createWithoutDrm = SampleQueue.createWithoutDrm(RtspMediaPeriod.this.allocator);
            this.sampleQueue = createWithoutDrm;
            createWithoutDrm.setUpstreamFormatChangeListener(RtspMediaPeriod.this.internalListener);
        }

        public long getBufferedPositionUs() {
            return this.sampleQueue.getLargestQueuedTimestampUs();
        }

        public void startLoading() {
            this.loader.startLoading(this.loadInfo.loadable, RtspMediaPeriod.this.internalListener, 0);
        }

        public boolean isSampleQueueReady() {
            return this.sampleQueue.isReady(this.canceled);
        }

        public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            return this.sampleQueue.read(formatHolder, decoderInputBuffer, i, this.canceled);
        }

        public int skipData(long j) {
            int skipCount = this.sampleQueue.getSkipCount(j, this.canceled);
            this.sampleQueue.skip(skipCount);
            return skipCount;
        }

        public void cancelLoad() {
            if (!this.canceled) {
                this.loadInfo.loadable.cancelLoad();
                this.canceled = true;
                RtspMediaPeriod.this.updateLoadingFinished();
            }
        }

        public void seekTo(long j) {
            if (!this.canceled) {
                this.loadInfo.loadable.resetForSeek();
                this.sampleQueue.reset();
                this.sampleQueue.setStartTimeUs(j);
            }
        }

        public void release() {
            if (!this.released) {
                this.loader.release();
                this.sampleQueue.release();
                this.released = true;
            }
        }
    }

    final class RtpLoadInfo {
        /* access modifiers changed from: private */
        public final RtpDataLoadable loadable;
        public final RtspMediaTrack mediaTrack;
        private String transport;

        public RtpLoadInfo(RtspMediaTrack rtspMediaTrack, int i, RtpDataChannel.Factory factory) {
            this.mediaTrack = rtspMediaTrack;
            this.loadable = new RtpDataLoadable(i, rtspMediaTrack, new RtspMediaPeriod$RtpLoadInfo$$ExternalSyntheticLambda0(this), RtspMediaPeriod.this.internalListener, factory);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$com-google-android-exoplayer2-source-rtsp-RtspMediaPeriod$RtpLoadInfo  reason: not valid java name */
        public /* synthetic */ void m525lambda$new$0$comgoogleandroidexoplayer2sourcertspRtspMediaPeriod$RtpLoadInfo(String str, RtpDataChannel rtpDataChannel) {
            this.transport = str;
            RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener = rtpDataChannel.getInterleavedBinaryDataListener();
            if (interleavedBinaryDataListener != null) {
                RtspMediaPeriod.this.rtspClient.registerInterleavedDataChannel(rtpDataChannel.getLocalPort(), interleavedBinaryDataListener);
                boolean unused = RtspMediaPeriod.this.isUsingRtpTcp = true;
            }
            RtspMediaPeriod.this.maybeSetupTracks();
        }

        public boolean isTransportReady() {
            return this.transport != null;
        }

        public String getTransport() {
            Assertions.checkStateNotNull(this.transport);
            return this.transport;
        }

        public Uri getTrackUri() {
            return this.loadable.rtspMediaTrack.uri;
        }
    }
}
