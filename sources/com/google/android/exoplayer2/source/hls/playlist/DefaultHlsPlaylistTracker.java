package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    public static final HlsPlaylistTracker.Factory FACTORY = new DefaultHlsPlaylistTracker$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public final HlsDataSourceFactory dataSourceFactory;
    /* access modifiers changed from: private */
    public MediaSourceEventListener.EventDispatcher eventDispatcher;
    private Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> listeners;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    /* access modifiers changed from: private */
    public HlsMultivariantPlaylist multivariantPlaylist;
    /* access modifiers changed from: private */
    public final HashMap<Uri, MediaPlaylistBundle> playlistBundles;
    /* access modifiers changed from: private */
    public final HlsPlaylistParserFactory playlistParserFactory;
    /* access modifiers changed from: private */
    public Handler playlistRefreshHandler;
    /* access modifiers changed from: private */
    public final double playlistStuckTargetDurationCoefficient;
    /* access modifiers changed from: private */
    public HlsMediaPlaylist primaryMediaPlaylistSnapshot;
    /* access modifiers changed from: private */
    public Uri primaryMediaPlaylistUrl;
    private HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener;

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy2, hlsPlaylistParserFactory, 3.5d);
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d) {
        this.dataSourceFactory = hlsDataSourceFactory;
        this.playlistParserFactory = hlsPlaylistParserFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playlistStuckTargetDurationCoefficient = d;
        this.listeners = new CopyOnWriteArrayList<>();
        this.playlistBundles = new HashMap<>();
        this.initialStartTimeUs = C.TIME_UNSET;
    }

    public void start(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher2, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener2) {
        this.playlistRefreshHandler = Util.createHandlerForCurrentLooper();
        this.eventDispatcher = eventDispatcher2;
        this.primaryPlaylistListener = primaryPlaylistListener2;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.dataSourceFactory.createDataSource(4), uri, 4, this.playlistParserFactory.createPlaylistParser());
        Assertions.checkState(this.initialPlaylistLoader == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.initialPlaylistLoader = loader;
        eventDispatcher2.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, loader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    public void stop() {
        this.primaryMediaPlaylistUrl = null;
        this.primaryMediaPlaylistSnapshot = null;
        this.multivariantPlaylist = null;
        this.initialStartTimeUs = C.TIME_UNSET;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        for (MediaPlaylistBundle release : this.playlistBundles.values()) {
            release.release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages((Object) null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }

    public void addListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.checkNotNull(playlistEventListener);
        this.listeners.add(playlistEventListener);
    }

    public void removeListener(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.listeners.remove(playlistEventListener);
    }

    public HlsMultivariantPlaylist getMultivariantPlaylist() {
        return this.multivariantPlaylist;
    }

    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri, boolean z) {
        HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(uri).getPlaylistSnapshot();
        if (playlistSnapshot != null && z) {
            maybeSetPrimaryUrl(uri);
        }
        return playlistSnapshot;
    }

    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    public boolean isSnapshotValid(Uri uri) {
        return this.playlistBundles.get(uri).isSnapshotValid();
    }

    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        Loader loader = this.initialPlaylistLoader;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.primaryMediaPlaylistUrl;
        if (uri != null) {
            maybeThrowPlaylistRefreshError(uri);
        }
    }

    public void maybeThrowPlaylistRefreshError(Uri uri) throws IOException {
        this.playlistBundles.get(uri).maybeThrowPlaylistRefreshError();
    }

    public void refreshPlaylist(Uri uri) {
        this.playlistBundles.get(uri).loadPlaylist();
    }

    public boolean isLive() {
        return this.isLive;
    }

    public boolean excludeMediaPlaylist(Uri uri, long j) {
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(uri);
        if (mediaPlaylistBundle != null) {
            return !mediaPlaylistBundle.excludePlaylist(j);
        }
        return false;
    }

    public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
        HlsMultivariantPlaylist hlsMultivariantPlaylist;
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        HlsPlaylist result = parsingLoadable.getResult();
        boolean z = result instanceof HlsMediaPlaylist;
        if (z) {
            hlsMultivariantPlaylist = HlsMultivariantPlaylist.createSingleVariantMultivariantPlaylist(result.baseUri);
        } else {
            hlsMultivariantPlaylist = (HlsMultivariantPlaylist) result;
        }
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.primaryMediaPlaylistUrl = hlsMultivariantPlaylist.variants.get(0).url;
        this.listeners.add(new FirstPrimaryMediaPlaylistListener());
        createBundles(hlsMultivariantPlaylist.mediaPlaylistUrls);
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryMediaPlaylistUrl);
        if (z) {
            mediaPlaylistBundle.processLoadedPlaylist((HlsMediaPlaylist) result, loadEventInfo);
        } else {
            mediaPlaylistBundle.loadPlaylist();
        }
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.eventDispatcher.loadCompleted(loadEventInfo, 4);
    }

    public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.eventDispatcher.loadCanceled(loadEventInfo, 4);
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException, int i) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i));
        boolean z = retryDelayMsFor == C.TIME_UNSET;
        this.eventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, z);
        if (z) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }
        if (z) {
            return Loader.DONT_RETRY_FATAL;
        }
        return Loader.createRetryAction(false, retryDelayMsFor);
    }

    /* access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        List<HlsMultivariantPlaylist.Variant> list = this.multivariantPlaylist.variants;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) Assertions.checkNotNull(this.playlistBundles.get(list.get(i).url));
            if (elapsedRealtime > mediaPlaylistBundle.excludeUntilMs) {
                Uri access$400 = mediaPlaylistBundle.playlistUrl;
                this.primaryMediaPlaylistUrl = access$400;
                mediaPlaylistBundle.loadPlaylistInternal(getRequestUriForPrimaryChange(access$400));
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(Uri uri) {
        if (!uri.equals(this.primaryMediaPlaylistUrl) && isVariantUrl(uri)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
                this.primaryMediaPlaylistUrl = uri;
                MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(uri);
                HlsMediaPlaylist access$600 = mediaPlaylistBundle.playlistSnapshot;
                if (access$600 == null || !access$600.hasEndTag) {
                    mediaPlaylistBundle.loadPlaylistInternal(getRequestUriForPrimaryChange(uri));
                    return;
                }
                this.primaryMediaPlaylistSnapshot = access$600;
                this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(access$600);
            }
        }
    }

    private Uri getRequestUriForPrimaryChange(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.serverControl.canBlockReload || (renditionReport = this.primaryMediaPlaylistSnapshot.renditionReports.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.lastMediaSequence));
        if (renditionReport.lastPartIndex != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(renditionReport.lastPartIndex));
        }
        return buildUpon.build();
    }

    private boolean isVariantUrl(Uri uri) {
        List<HlsMultivariantPlaylist.Variant> list = this.multivariantPlaylist.variants;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).url)) {
                return true;
            }
        }
        return false;
    }

    private void createBundles(List<Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.playlistBundles.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    /* access modifiers changed from: private */
    public void onPlaylistUpdated(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.primaryMediaPlaylistUrl)) {
            if (this.primaryMediaPlaylistSnapshot == null) {
                this.isLive = !hlsMediaPlaylist.hasEndTag;
                this.initialStartTimeUs = hlsMediaPlaylist.startTimeUs;
            }
            this.primaryMediaPlaylistSnapshot = hlsMediaPlaylist;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaylistChanged();
        }
    }

    /* access modifiers changed from: private */
    public boolean notifyPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it = this.listeners.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !it.next().onPlaylistError(uri, loadErrorInfo, z);
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (!hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.hasEndTag ? hlsMediaPlaylist.copyWithEndTag() : hlsMediaPlaylist;
        }
        return hlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2));
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.hasProgramDateTime) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        long j = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.startTimeUs : 0;
        if (hlsMediaPlaylist == null) {
            return j;
        }
        int size = hlsMediaPlaylist.segments.size();
        HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (firstOldOverlappingSegment != null) {
            return hlsMediaPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
        }
        return ((long) size) == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence ? hlsMediaPlaylist.getEndTimeUs() : j;
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        HlsMediaPlaylist.Segment firstOldOverlappingSegment;
        if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        int i = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.discontinuitySequence : 0;
        return (hlsMediaPlaylist == null || (firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i : (hlsMediaPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
    }

    private static HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    private final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        private static final String BLOCK_MSN_PARAM = "_HLS_msn";
        private static final String BLOCK_PART_PARAM = "_HLS_part";
        private static final String SKIP_PARAM = "_HLS_skip";
        private long earliestNextLoadTimeMs;
        /* access modifiers changed from: private */
        public long excludeUntilMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final DataSource mediaPlaylistDataSource;
        private final Loader mediaPlaylistLoader = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        private IOException playlistError;
        /* access modifiers changed from: private */
        public HlsMediaPlaylist playlistSnapshot;
        /* access modifiers changed from: private */
        public final Uri playlistUrl;

        public MediaPlaylistBundle(Uri uri) {
            this.playlistUrl = uri;
            this.mediaPlaylistDataSource = DefaultHlsPlaylistTracker.this.dataSourceFactory.createDataSource(4);
        }

        public HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            if (this.playlistSnapshot == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000, Util.usToMs(this.playlistSnapshot.durationUs));
            if (this.playlistSnapshot.hasEndTag || this.playlistSnapshot.playlistType == 2 || this.playlistSnapshot.playlistType == 1 || this.lastSnapshotLoadMs + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void loadPlaylist() {
            loadPlaylistInternal(this.playlistUrl);
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            this.mediaPlaylistLoader.maybeThrowError();
            IOException iOException = this.playlistError;
            if (iOException != null) {
                throw iOException;
            }
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        public void onLoadCompleted(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            HlsPlaylist result = parsingLoadable.getResult();
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            if (result instanceof HlsMediaPlaylist) {
                processLoadedPlaylist((HlsMediaPlaylist) result, loadEventInfo);
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadCompleted(loadEventInfo, 4);
            } else {
                this.playlistError = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", (Throwable) null);
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(loadEventInfo, 4, this.playlistError, true);
            }
            DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }

        public void onLoadCanceled(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, boolean z) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadCanceled(loadEventInfo, 4);
        }

        public Loader.LoadErrorAction onLoadError(ParsingLoadable<HlsPlaylist> parsingLoadable, long j, long j2, IOException iOException, int i) {
            Loader.LoadErrorAction loadErrorAction;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            IOException iOException2 = iOException;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
            boolean z = iOException2 instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((parsingLoadable.getUri().getQueryParameter(BLOCK_MSN_PARAM) != null) || z) {
                int i2 = Integer.MAX_VALUE;
                if (iOException2 instanceof HttpDataSource.InvalidResponseCodeException) {
                    i2 = ((HttpDataSource.InvalidResponseCodeException) iOException2).responseCode;
                }
                if (z || i2 == 400 || i2 == 503) {
                    this.earliestNextLoadTimeMs = SystemClock.elapsedRealtime();
                    loadPlaylist();
                    ((MediaSourceEventListener.EventDispatcher) Util.castNonNull(DefaultHlsPlaylistTracker.this.eventDispatcher)).loadError(loadEventInfo, parsingLoadable2.type, iOException2, true);
                    return Loader.DONT_RETRY;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i);
            if (DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, loadErrorInfo, false)) {
                long retryDelayMsFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
                if (retryDelayMsFor != C.TIME_UNSET) {
                    loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
                } else {
                    loadErrorAction = Loader.DONT_RETRY_FATAL;
                }
            } else {
                loadErrorAction = Loader.DONT_RETRY;
            }
            boolean isRetry = true ^ loadErrorAction.isRetry();
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, isRetry);
            if (isRetry) {
                DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
            }
            return loadErrorAction;
        }

        /* access modifiers changed from: private */
        public void loadPlaylistInternal(Uri uri) {
            this.excludeUntilMs = 0;
            if (!this.loadPending && !this.mediaPlaylistLoader.isLoading() && !this.mediaPlaylistLoader.hasFatalError()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.earliestNextLoadTimeMs) {
                    this.loadPending = true;
                    DefaultHlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(new DefaultHlsPlaylistTracker$MediaPlaylistBundle$$ExternalSyntheticLambda0(this, uri), this.earliestNextLoadTimeMs - elapsedRealtime);
                    return;
                }
                loadPlaylistImmediately(uri);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$loadPlaylistInternal$0$com-google-android-exoplayer2-source-hls-playlist-DefaultHlsPlaylistTracker$MediaPlaylistBundle  reason: not valid java name */
        public /* synthetic */ void m522lambda$loadPlaylistInternal$0$comgoogleandroidexoplayer2sourcehlsplaylistDefaultHlsPlaylistTracker$MediaPlaylistBundle(Uri uri) {
            this.loadPending = false;
            loadPlaylistImmediately(uri);
        }

        private void loadPlaylistImmediately(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.mediaPlaylistDataSource, uri, 4, DefaultHlsPlaylistTracker.this.playlistParserFactory.createPlaylistParser(DefaultHlsPlaylistTracker.this.multivariantPlaylist, this.playlistSnapshot));
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.mediaPlaylistLoader.startLoading(parsingLoadable, this, DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
        }

        /* access modifiers changed from: private */
        public void processLoadedPlaylist(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            boolean z;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = elapsedRealtime;
            HlsMediaPlaylist access$1400 = DefaultHlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.playlistSnapshot = access$1400;
            boolean z2 = false;
            IOException iOException = null;
            if (access$1400 != hlsMediaPlaylist2) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = elapsedRealtime;
                DefaultHlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, access$1400);
            } else if (!access$1400.hasEndTag) {
                if (hlsMediaPlaylist.mediaSequence + ((long) hlsMediaPlaylist.segments.size()) < this.playlistSnapshot.mediaSequence) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.playlistUrl);
                    z = true;
                } else {
                    if (((double) (elapsedRealtime - this.lastSnapshotChangeMs)) > ((double) Util.usToMs(this.playlistSnapshot.targetDurationUs)) * DefaultHlsPlaylistTracker.this.playlistStuckTargetDurationCoefficient) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.playlistUrl);
                    }
                    z = false;
                }
                if (iOException != null) {
                    this.playlistError = iOException;
                    boolean unused = DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1), z);
                }
            }
            long j = 0;
            if (!this.playlistSnapshot.serverControl.canBlockReload) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
                if (hlsMediaPlaylist3 != hlsMediaPlaylist2) {
                    j = hlsMediaPlaylist3.targetDurationUs;
                } else {
                    j = hlsMediaPlaylist3.targetDurationUs / 2;
                }
            }
            this.earliestNextLoadTimeMs = elapsedRealtime + Util.usToMs(j);
            if (this.playlistSnapshot.partTargetDurationUs != C.TIME_UNSET || this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl)) {
                z2 = true;
            }
            if (z2 && !this.playlistSnapshot.hasEndTag) {
                loadPlaylistInternal(getMediaPlaylistUriForReload());
            }
        }

        private Uri getMediaPlaylistUriForReload() {
            HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
            if (hlsMediaPlaylist == null || (hlsMediaPlaylist.serverControl.skipUntilUs == C.TIME_UNSET && !this.playlistSnapshot.serverControl.canBlockReload)) {
                return this.playlistUrl;
            }
            Uri.Builder buildUpon = this.playlistUrl.buildUpon();
            if (this.playlistSnapshot.serverControl.canBlockReload) {
                buildUpon.appendQueryParameter(BLOCK_MSN_PARAM, String.valueOf(this.playlistSnapshot.mediaSequence + ((long) this.playlistSnapshot.segments.size())));
                if (this.playlistSnapshot.partTargetDurationUs != C.TIME_UNSET) {
                    List<HlsMediaPlaylist.Part> list = this.playlistSnapshot.trailingParts;
                    int size = list.size();
                    if (!list.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.getLast(list)).isPreload) {
                        size--;
                    }
                    buildUpon.appendQueryParameter(BLOCK_PART_PARAM, String.valueOf(size));
                }
            }
            if (this.playlistSnapshot.serverControl.skipUntilUs != C.TIME_UNSET) {
                buildUpon.appendQueryParameter(SKIP_PARAM, this.playlistSnapshot.serverControl.canSkipDateRanges ? "v2" : "YES");
            }
            return buildUpon.build();
        }

        /* access modifiers changed from: private */
        public boolean excludePlaylist(long j) {
            this.excludeUntilMs = SystemClock.elapsedRealtime() + j;
            return this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) && !DefaultHlsPlaylistTracker.this.maybeSelectNewPrimaryUrl();
        }
    }

    private class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        public void onPlaylistChanged() {
            DefaultHlsPlaylistTracker.this.listeners.remove(this);
        }

        public boolean onPlaylistError(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.primaryMediaPlaylistSnapshot == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.castNonNull(DefaultHlsPlaylistTracker.this.multivariantPlaylist)).variants;
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.playlistBundles.get(list.get(i2).url);
                    if (mediaPlaylistBundle2 != null && elapsedRealtime < mediaPlaylistBundle2.excludeUntilMs) {
                        i++;
                    }
                }
                LoadErrorHandlingPolicy.FallbackSelection fallbackSelectionFor = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getFallbackSelectionFor(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.this.multivariantPlaylist.variants.size(), i), loadErrorInfo);
                if (!(fallbackSelectionFor == null || fallbackSelectionFor.type != 2 || (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.playlistBundles.get(uri)) == null)) {
                    boolean unused = mediaPlaylistBundle.excludePlaylist(fallbackSelectionFor.exclusionDurationMs);
                }
            }
            return false;
        }
    }
}
