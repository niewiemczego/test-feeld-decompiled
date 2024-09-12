package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private static final String TAG = "SingleSampleMediaPeriod";
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    final Loader loader = new Loader(TAG);
    boolean loadingFinished;
    byte[] sampleData;
    int sampleSize;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    private final TrackGroupArray tracks;
    private final TransferListener transferListener;
    final boolean treatLoadErrorsAsEndOfStream;

    public void discardBuffer(long j, boolean z) {
    }

    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    public void maybeThrowPrepareError() {
    }

    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    public void reevaluateBuffer(long j) {
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec2, DataSource.Factory factory, TransferListener transferListener2, Format format2, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, boolean z) {
        this.dataSpec = dataSpec2;
        this.dataSourceFactory = factory;
        this.transferListener = transferListener2;
        this.format = format2;
        this.durationUs = j;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tracks = new TrackGroupArray(new TrackGroup(format2));
    }

    public void release() {
        this.loader.release();
    }

    public void prepare(MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                this.sampleStreams.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    public boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        DataSource createDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener2 = this.transferListener;
        if (transferListener2 != null) {
            createDataSource.addTransferListener(transferListener2);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.dataSpec, createDataSource);
        this.eventDispatcher.loadStarted(new LoadEventInfo(sourceLoadable.loadTaskId, this.dataSpec, this.loader.startLoading(sourceLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1))), 1, -1, this.format, 0, (Object) null, 0, this.durationUs);
        return true;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0;
    }

    public long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0;
    }

    public long seekToUs(long j) {
        for (int i = 0; i < this.sampleStreams.size(); i++) {
            this.sampleStreams.get(i).reset();
        }
        return j;
    }

    public void onLoadCompleted(SourceLoadable sourceLoadable, long j, long j2) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.sampleSize = (int) sourceLoadable.dataSource.getBytesRead();
        this.sampleData = (byte[]) Assertions.checkNotNull(sourceLoadable.sampleData);
        this.loadingFinished = true;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, (long) this.sampleSize);
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        this.eventDispatcher.loadCompleted(loadEventInfo, 1, -1, this.format, 0, (Object) null, 0, this.durationUs);
    }

    public void onLoadCanceled(SourceLoadable sourceLoadable, long j, long j2, boolean z) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        this.eventDispatcher.loadCanceled(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, 0, this.durationUs);
    }

    public Loader.LoadErrorAction onLoadError(SourceLoadable sourceLoadable, long j, long j2, IOException iOException, int i) {
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        IOException iOException2 = iOException;
        int i2 = i;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j, j2, access$100.getBytesRead());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.format, 0, (Object) null, 0, Util.usToMs(this.durationUs)), iOException2, i2));
        int i3 = (retryDelayMsFor > C.TIME_UNSET ? 1 : (retryDelayMsFor == C.TIME_UNSET ? 0 : -1));
        boolean z = i3 == 0 || i2 >= this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
        if (this.treatLoadErrorsAsEndOfStream && z) {
            Log.w(TAG, "Loading failed, treating as end-of-stream.", iOException2);
            this.loadingFinished = true;
            loadErrorAction = Loader.DONT_RETRY;
        } else if (i3 != 0) {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        } else {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z2 = !loadErrorAction2.isRetry();
        this.eventDispatcher.loadError(loadEventInfo, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, iOException, z2);
        if (z2) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        }
        return loadErrorAction2;
    }

    private final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean notifiedDownstreamFormat;
        private int streamState;

        private SampleStreamImpl() {
        }

        public void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        public boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public void maybeThrowError() throws IOException {
            if (!SingleSampleMediaPeriod.this.treatLoadErrorsAsEndOfStream) {
                SingleSampleMediaPeriod.this.loader.maybeThrowError();
            }
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            maybeNotifyDownstreamFormat();
            if (SingleSampleMediaPeriod.this.loadingFinished && SingleSampleMediaPeriod.this.sampleData == null) {
                this.streamState = 2;
            }
            int i2 = this.streamState;
            if (i2 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if ((i & 2) != 0 || i2 == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else if (!SingleSampleMediaPeriod.this.loadingFinished) {
                return -3;
            } else {
                Assertions.checkNotNull(SingleSampleMediaPeriod.this.sampleData);
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.timeUs = 0;
                if ((i & 4) == 0) {
                    decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                    decoderInputBuffer.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
                }
                if ((i & 1) == 0) {
                    this.streamState = 2;
                }
                return -4;
            }
        }

        public int skipData(long j) {
            maybeNotifyDownstreamFormat();
            if (j <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            return 1;
        }

        private void maybeNotifyDownstreamFormat() {
            if (!this.notifiedDownstreamFormat) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, (Object) null, 0);
                this.notifiedDownstreamFormat = true;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {
        /* access modifiers changed from: private */
        public final StatsDataSource dataSource;
        public final DataSpec dataSpec;
        public final long loadTaskId = LoadEventInfo.getNewId();
        /* access modifiers changed from: private */
        public byte[] sampleData;

        public void cancelLoad() {
        }

        public SourceLoadable(DataSpec dataSpec2, DataSource dataSource2) {
            this.dataSpec = dataSpec2;
            this.dataSource = new StatsDataSource(dataSource2);
        }

        public void load() throws IOException {
            this.dataSource.resetBytesRead();
            try {
                this.dataSource.open(this.dataSpec);
                int i = 0;
                while (i != -1) {
                    int bytesRead = (int) this.dataSource.getBytesRead();
                    byte[] bArr = this.sampleData;
                    if (bArr == null) {
                        this.sampleData = new byte[1024];
                    } else if (bytesRead == bArr.length) {
                        this.sampleData = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.dataSource;
                    byte[] bArr2 = this.sampleData;
                    i = statsDataSource.read(bArr2, bytesRead, bArr2.length - bytesRead);
                }
            } finally {
                DataSourceUtil.closeQuietly(this.dataSource);
            }
        }
    }
}
