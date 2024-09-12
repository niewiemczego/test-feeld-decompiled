package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import javax.net.SocketFactory;

public final class RtspMediaSource extends BaseMediaSource {
    public static final long DEFAULT_TIMEOUT_MS = 8000;
    private final boolean debugLoggingEnabled;
    private final MediaItem mediaItem;
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    private final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public long timelineDurationUs = C.TIME_UNSET;
    /* access modifiers changed from: private */
    public boolean timelineIsLive;
    /* access modifiers changed from: private */
    public boolean timelineIsPlaceholder = true;
    /* access modifiers changed from: private */
    public boolean timelineIsSeekable;
    private final Uri uri;
    private final String userAgent;

    public void maybeThrowSourceInfoRefreshError() {
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.rtsp");
    }

    public static final class Factory implements MediaSourceFactory {
        private boolean debugLoggingEnabled;
        private boolean forceUseRtpTcp;
        private SocketFactory socketFactory = SocketFactory.getDefault();
        private long timeoutMs = RtspMediaSource.DEFAULT_TIMEOUT_MS;
        private String userAgent = ExoPlayerLibraryInfo.VERSION_SLASHY;

        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public Factory setForceUseRtpTcp(boolean z) {
            this.forceUseRtpTcp = z;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setSocketFactory(SocketFactory socketFactory2) {
            this.socketFactory = socketFactory2;
            return this;
        }

        public Factory setDebugLoggingEnabled(boolean z) {
            this.debugLoggingEnabled = z;
            return this;
        }

        public Factory setTimeoutMs(long j) {
            Assertions.checkArgument(j > 0);
            this.timeoutMs = j;
            return this;
        }

        public RtspMediaSource createMediaSource(MediaItem mediaItem) {
            RtpDataChannel.Factory factory;
            Assertions.checkNotNull(mediaItem.localConfiguration);
            if (this.forceUseRtpTcp) {
                factory = new TransferRtpDataChannelFactory(this.timeoutMs);
            } else {
                factory = new UdpDataSourceRtpDataChannelFactory(this.timeoutMs);
            }
            return new RtspMediaSource(mediaItem, factory, this.userAgent, this.socketFactory, this.debugLoggingEnabled);
        }
    }

    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    RtspMediaSource(MediaItem mediaItem2, RtpDataChannel.Factory factory, String str, SocketFactory socketFactory2, boolean z) {
        this.mediaItem = mediaItem2;
        this.rtpDataChannelFactory = factory;
        this.userAgent = str;
        this.uri = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration)).uri;
        this.socketFactory = socketFactory2;
        this.debugLoggingEnabled = z;
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        notifySourceInfoRefreshed();
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new RtspMediaPeriod(allocator, this.rtpDataChannelFactory, this.uri, new RtspMediaPeriod.Listener() {
            public void onSourceInfoRefreshed(RtspSessionTiming rtspSessionTiming) {
                long unused = RtspMediaSource.this.timelineDurationUs = Util.msToUs(rtspSessionTiming.getDurationMs());
                boolean unused2 = RtspMediaSource.this.timelineIsSeekable = !rtspSessionTiming.isLive();
                boolean unused3 = RtspMediaSource.this.timelineIsLive = rtspSessionTiming.isLive();
                boolean unused4 = RtspMediaSource.this.timelineIsPlaceholder = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }

            public void onSeekingUnsupported() {
                boolean unused = RtspMediaSource.this.timelineIsSeekable = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }
        }, this.userAgent, this.socketFactory, this.debugLoggingEnabled);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).release();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifySourceInfoRefreshed() {
        /*
            r9 = this;
            com.google.android.exoplayer2.source.SinglePeriodTimeline r8 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            long r1 = r9.timelineDurationUs
            boolean r3 = r9.timelineIsSeekable
            boolean r5 = r9.timelineIsLive
            com.google.android.exoplayer2.MediaItem r7 = r9.mediaItem
            r4 = 0
            r6 = 0
            r0 = r8
            r0.<init>((long) r1, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.Object) r6, (com.google.android.exoplayer2.MediaItem) r7)
            boolean r0 = r9.timelineIsPlaceholder
            if (r0 == 0) goto L_0x001a
            com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2 r0 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$2
            r0.<init>(r9, r8)
            r8 = r0
        L_0x001a:
            r9.refreshSourceInfo(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaSource.notifySourceInfoRefreshed():void");
    }
}
