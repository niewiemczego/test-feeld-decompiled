package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final class MetadataRetriever {
    private MetadataRetriever() {
    }

    public static ListenableFuture<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem) {
        return retrieveMetadata(context, mediaItem, Clock.DEFAULT);
    }

    public static ListenableFuture<TrackGroupArray> retrieveMetadata(MediaSource.Factory factory, MediaItem mediaItem) {
        return retrieveMetadata(factory, mediaItem, Clock.DEFAULT);
    }

    static ListenableFuture<TrackGroupArray> retrieveMetadata(Context context, MediaItem mediaItem, Clock clock) {
        return retrieveMetadata((MediaSource.Factory) new DefaultMediaSourceFactory(context, (ExtractorsFactory) new DefaultExtractorsFactory().setMp4ExtractorFlags(6)), mediaItem, clock);
    }

    private static ListenableFuture<TrackGroupArray> retrieveMetadata(MediaSource.Factory factory, MediaItem mediaItem, Clock clock) {
        return new MetadataRetrieverInternal(factory, clock).retrieveMetadata(mediaItem);
    }

    private static final class MetadataRetrieverInternal {
        private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
        private static final int MESSAGE_CONTINUE_LOADING = 2;
        private static final int MESSAGE_PREPARE_SOURCE = 0;
        private static final int MESSAGE_RELEASE = 3;
        /* access modifiers changed from: private */
        public final MediaSource.Factory mediaSourceFactory;
        /* access modifiers changed from: private */
        public final HandlerWrapper mediaSourceHandler;
        /* access modifiers changed from: private */
        public final HandlerThread mediaSourceThread;
        /* access modifiers changed from: private */
        public final SettableFuture<TrackGroupArray> trackGroupsFuture = SettableFuture.create();

        public MetadataRetrieverInternal(MediaSource.Factory factory, Clock clock) {
            this.mediaSourceFactory = factory;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
            this.mediaSourceThread = handlerThread;
            handlerThread.start();
            this.mediaSourceHandler = clock.createHandler(handlerThread.getLooper(), new MediaSourceHandlerCallback());
        }

        public ListenableFuture<TrackGroupArray> retrieveMetadata(MediaItem mediaItem) {
            this.mediaSourceHandler.obtainMessage(0, mediaItem).sendToTarget();
            return this.trackGroupsFuture;
        }

        private final class MediaSourceHandlerCallback implements Handler.Callback {
            private static final int ERROR_POLL_INTERVAL_MS = 100;
            /* access modifiers changed from: private */
            public MediaPeriod mediaPeriod;
            private MediaSource mediaSource;
            private final MediaSourceCaller mediaSourceCaller = new MediaSourceCaller();

            public MediaSourceHandlerCallback() {
            }

            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    MediaSource createMediaSource = MetadataRetrieverInternal.this.mediaSourceFactory.createMediaSource((MediaItem) message.obj);
                    this.mediaSource = createMediaSource;
                    createMediaSource.prepareSource(this.mediaSourceCaller, (TransferListener) null, PlayerId.UNSET);
                    MetadataRetrieverInternal.this.mediaSourceHandler.sendEmptyMessage(1);
                    return true;
                } else if (i == 1) {
                    try {
                        MediaPeriod mediaPeriod2 = this.mediaPeriod;
                        if (mediaPeriod2 == null) {
                            ((MediaSource) Assertions.checkNotNull(this.mediaSource)).maybeThrowSourceInfoRefreshError();
                        } else {
                            mediaPeriod2.maybeThrowPrepareError();
                        }
                        MetadataRetrieverInternal.this.mediaSourceHandler.sendEmptyMessageDelayed(1, 100);
                    } catch (Exception e) {
                        MetadataRetrieverInternal.this.trackGroupsFuture.setException(e);
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(3).sendToTarget();
                    }
                    return true;
                } else if (i == 2) {
                    ((MediaPeriod) Assertions.checkNotNull(this.mediaPeriod)).continueLoading(0);
                    return true;
                } else if (i != 3) {
                    return false;
                } else {
                    if (this.mediaPeriod != null) {
                        ((MediaSource) Assertions.checkNotNull(this.mediaSource)).releasePeriod(this.mediaPeriod);
                    }
                    ((MediaSource) Assertions.checkNotNull(this.mediaSource)).releaseSource(this.mediaSourceCaller);
                    MetadataRetrieverInternal.this.mediaSourceHandler.removeCallbacksAndMessages((Object) null);
                    MetadataRetrieverInternal.this.mediaSourceThread.quit();
                    return true;
                }
            }

            private final class MediaSourceCaller implements MediaSource.MediaSourceCaller {
                private final Allocator allocator = new DefaultAllocator(true, 65536);
                private final MediaPeriodCallback mediaPeriodCallback = new MediaPeriodCallback();
                private boolean mediaPeriodCreated;

                public MediaSourceCaller() {
                }

                public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                    if (!this.mediaPeriodCreated) {
                        this.mediaPeriodCreated = true;
                        MediaPeriod unused = MediaSourceHandlerCallback.this.mediaPeriod = mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0)), this.allocator, 0);
                        MediaSourceHandlerCallback.this.mediaPeriod.prepare(this.mediaPeriodCallback, 0);
                    }
                }

                private final class MediaPeriodCallback implements MediaPeriod.Callback {
                    private MediaPeriodCallback() {
                    }

                    public void onPrepared(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.trackGroupsFuture.set(mediaPeriod.getTrackGroups());
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(3).sendToTarget();
                    }

                    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.mediaSourceHandler.obtainMessage(2).sendToTarget();
                    }
                }
            }
        }
    }
}
