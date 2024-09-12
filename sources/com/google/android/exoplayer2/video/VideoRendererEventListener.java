package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public interface VideoRendererEventListener {
    void onDroppedFrames(int i, long j) {
    }

    void onRenderedFirstFrame(Object obj, long j) {
    }

    void onVideoCodecError(Exception exc) {
    }

    void onVideoDecoderInitialized(String str, long j, long j2) {
    }

    void onVideoDecoderReleased(String str) {
    }

    void onVideoDisabled(DecoderCounters decoderCounters) {
    }

    void onVideoEnabled(DecoderCounters decoderCounters) {
    }

    void onVideoFrameProcessingOffset(long j, int i) {
    }

    @Deprecated
    void onVideoInputFormatChanged(Format format) {
    }

    void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    void onVideoSizeChanged(VideoSize videoSize) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler2, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler2) : null;
            this.listener = videoRendererEventListener;
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$enabled$0$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m552lambda$enabled$0$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        public void decoderInitialized(String str, long j, long j2) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9(this, str, j, j2));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$decoderInitialized$1$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m548lambda$decoderInitialized$1$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(String str, long j, long j2) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5(this, format, decoderReuseEvaluation));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$inputFormatChanged$2$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m553lambda$inputFormatChanged$2$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void droppedFrames(int i, long j) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda8(this, i, j));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$droppedFrames$3$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m551lambda$droppedFrames$3$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(int i, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(i, j);
        }

        public void reportVideoFrameProcessingOffset(long j, int i) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda4(this, j, i));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$reportVideoFrameProcessingOffset$4$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m555lambda$reportVideoFrameProcessingOffset$4$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(long j, int i) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(j, i);
        }

        public void videoSizeChanged(VideoSize videoSize) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda3(this, videoSize));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$videoSizeChanged$5$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m557lambda$videoSizeChanged$5$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(videoSize);
        }

        public void renderedFirstFrame(Object obj) {
            if (this.handler != null) {
                this.handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$renderedFirstFrame$6$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m554lambda$renderedFirstFrame$6$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(Object obj, long j) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(obj, j);
        }

        public void decoderReleased(String str) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(this, str));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$decoderReleased$7$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m549lambda$decoderReleased$7$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(String str) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderReleased(str);
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(this, decoderCounters));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$disabled$8$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m550lambda$disabled$8$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
        }

        public void videoCodecError(Exception exc) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda6(this, exc));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$videoCodecError$9$com-google-android-exoplayer2-video-VideoRendererEventListener$EventDispatcher  reason: not valid java name */
        public /* synthetic */ void m556lambda$videoCodecError$9$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(Exception exc) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoCodecError(exc);
        }
    }
}
