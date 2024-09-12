package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import java.nio.ByteBuffer;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private PlaceholderSurface placeholderSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public String getName() {
        return TAG;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        Handler handler2 = handler;
        VideoRendererEventListener videoRendererEventListener2 = videoRendererEventListener;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        boolean z2 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z2, false);
        if (z2 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            int i2 = 1;
            while (true) {
                if (i2 >= decoderInfos.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i2);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z = false;
                    isFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
                i2++;
            }
        }
        z = true;
        int i3 = isFormatSupported ? 4 : 3;
        int i4 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i5 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z2, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.create(i3, i4, i, i5, i6);
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.of();
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, z2);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf(decoderInfos);
        }
        return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, z2)).build();
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState(!z3 || this.tunnelingAudioSessionId != 0);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = C.TIME_UNSET;
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
    }

    public boolean isReady() {
        PlaceholderSurface placeholderSurface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((placeholderSurface2 = this.placeholderSurface) != null && this.surface == placeholderSurface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i != 5) {
            super.handleMessage(i, obj);
        } else {
            this.frameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOutput(java.lang.Object r5) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r4.getCodecInfo()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.shouldUsePlaceholderSurface(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.context
            boolean r0 = r0.secure
            com.google.android.exoplayer2.video.PlaceholderSurface r5 = com.google.android.exoplayer2.video.PlaceholderSurface.newInstanceV17(r5, r0)
            r4.placeholderSurface = r5
        L_0x0026:
            android.view.Surface r0 = r4.surface
            if (r0 == r5) goto L_0x006e
            r4.surface = r5
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper r0 = r4.frameReleaseHelper
            r0.onSurfaceChanged(r5)
            r0 = 0
            r4.haveReportedFirstFrameRenderedForCurrentSurface = r0
            int r0 = r4.getState()
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r4.getCodec()
            if (r1 == 0) goto L_0x0054
            int r2 = com.google.android.exoplayer2.util.Util.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x004e
            if (r5 == 0) goto L_0x004e
            boolean r2 = r4.codecNeedsSetOutputSurfaceWorkaround
            if (r2 != 0) goto L_0x004e
            r4.setOutputSurfaceV23(r1, r5)
            goto L_0x0054
        L_0x004e:
            r4.releaseCodec()
            r4.maybeInitCodecOrBypass()
        L_0x0054:
            if (r5 == 0) goto L_0x0067
            com.google.android.exoplayer2.video.PlaceholderSurface r1 = r4.placeholderSurface
            if (r5 == r1) goto L_0x0067
            r4.maybeRenotifyVideoSizeChanged()
            r4.clearRenderedFirstFrame()
            r5 = 2
            if (r0 != r5) goto L_0x007a
            r4.setJoiningDeadlineMs()
            goto L_0x007a
        L_0x0067:
            r4.clearReportedVideoSize()
            r4.clearRenderedFirstFrame()
            goto L_0x007a
        L_0x006e:
            if (r5 == 0) goto L_0x007a
            com.google.android.exoplayer2.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r5 == r0) goto L_0x007a
            r4.maybeRenotifyVideoSizeChanged()
            r4.maybeRenotifyRenderedFirstFrame()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.setOutput(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (!(placeholderSurface2 == null || placeholderSurface2.secure == mediaCodecInfo.secure)) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.surface == null) {
            if (shouldUsePlaceholderSurface(mediaCodecInfo)) {
                if (this.placeholderSurface == null) {
                    this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.placeholderSurface;
            } else {
                throw new IllegalStateException();
            }
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, this.surface, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        if (format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height) {
            i2 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i2 |= 64;
        }
        int i3 = i2;
        String str = mediaCodecInfo.name;
        if (i3 != 0) {
            i = 0;
        } else {
            i = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i, i3);
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.frameReleaseHelper.onPlaybackSpeed(f);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r3.equals(com.google.android.exoplayer2.util.MimeTypes.VIDEO_AV1) == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r10, com.google.android.exoplayer2.Format r11) {
        /*
            int r0 = r11.width
            int r1 = r11.height
            r2 = -1
            if (r0 == r2) goto L_0x00d2
            if (r1 != r2) goto L_0x000b
            goto L_0x00d2
        L_0x000b:
            java.lang.String r3 = r11.sampleMimeType
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r11 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(r11)
            if (r11 == 0) goto L_0x0033
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0031
            if (r11 == r7) goto L_0x0031
            if (r11 != r8) goto L_0x0033
        L_0x0031:
            r3 = r5
            goto L_0x0034
        L_0x0033:
            r3 = r6
        L_0x0034:
            r3.hashCode()
            int r11 = r3.hashCode()
            r4 = 4
            r9 = 3
            switch(r11) {
                case -1664118616: goto L_0x007e;
                case -1662735862: goto L_0x0075;
                case -1662541442: goto L_0x006c;
                case 1187890754: goto L_0x0061;
                case 1331836730: goto L_0x0058;
                case 1599127256: goto L_0x004d;
                case 1599127257: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            r7 = r2
            goto L_0x0088
        L_0x0042:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x004b
            goto L_0x0040
        L_0x004b:
            r7 = 6
            goto L_0x0088
        L_0x004d:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x0056
            goto L_0x0040
        L_0x0056:
            r7 = 5
            goto L_0x0088
        L_0x0058:
            boolean r11 = r3.equals(r5)
            if (r11 != 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            r7 = r4
            goto L_0x0088
        L_0x0061:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x006a
            goto L_0x0040
        L_0x006a:
            r7 = r9
            goto L_0x0088
        L_0x006c:
            boolean r11 = r3.equals(r6)
            if (r11 != 0) goto L_0x0073
            goto L_0x0040
        L_0x0073:
            r7 = r8
            goto L_0x0088
        L_0x0075:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x0088
            goto L_0x0040
        L_0x007e:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x0087
            goto L_0x0040
        L_0x0087:
            r7 = 0
        L_0x0088:
            switch(r7) {
                case 0: goto L_0x00cb;
                case 1: goto L_0x00cb;
                case 2: goto L_0x00c8;
                case 3: goto L_0x00cb;
                case 4: goto L_0x008c;
                case 5: goto L_0x00cb;
                case 6: goto L_0x00c8;
                default: goto L_0x008b;
            }
        L_0x008b:
            return r2
        L_0x008c:
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00c7
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r3 = "Amazon"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b9
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r3 = "KFSOWI"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00c7
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b9
            boolean r10 = r10.secure
            if (r10 == 0) goto L_0x00b9
            goto L_0x00c7
        L_0x00b9:
            r10 = 16
            int r11 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r10)
            int r0 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r1, (int) r10)
            int r11 = r11 * r0
            int r11 = r11 * r10
            int r11 = r11 * r10
            goto L_0x00cd
        L_0x00c7:
            return r2
        L_0x00c8:
            int r11 = r0 * r1
            goto L_0x00ce
        L_0x00cb:
            int r11 = r0 * r1
        L_0x00cd:
            r4 = r8
        L_0x00ce:
            int r11 = r11 * r9
            int r4 = r4 * r8
            int r11 = r11 / r4
            return r11
        L_0x00d2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, com.google.android.exoplayer2.Format):int");
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
    }

    /* access modifiers changed from: protected */
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    /* access modifiers changed from: protected */
    public void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int i;
        int i2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            this.currentWidth = format.width;
            this.currentHeight = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                i = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            this.currentWidth = i;
            if (z) {
                i2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            this.currentHeight = i2;
        }
        this.currentPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        if (Util.SDK_INT < 21) {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        } else if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
            int i3 = this.currentWidth;
            this.currentWidth = this.currentHeight;
            this.currentHeight = i3;
            this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
        }
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
    }

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4 && b3 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4;
        boolean z3;
        long j5 = j;
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i4 = i;
        long j6 = j3;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j5;
        }
        if (j6 != this.lastBufferPresentationTimeUs) {
            this.frameReleaseHelper.onNextFrame(j6);
            this.lastBufferPresentationTimeUs = j6;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j7 = j6 - outputStreamOffsetUs;
        if (!z || z2) {
            double playbackSpeed = (double) getPlaybackSpeed();
            boolean z4 = getState() == 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j8 = (long) (((double) (j6 - j5)) / playbackSpeed);
            if (z4) {
                j8 -= elapsedRealtime - j2;
            }
            if (this.surface != this.placeholderSurface) {
                long j9 = elapsedRealtime - this.lastRenderRealtimeUs;
                if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z4 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                    j4 = j9;
                    z3 = false;
                } else {
                    z3 = true;
                    j4 = j9;
                }
                if (this.joiningDeadlineMs == C.TIME_UNSET && j5 >= outputStreamOffsetUs && (z3 || (z4 && shouldForceRenderOutputBuffer(j8, j4)))) {
                    long nanoTime = System.nanoTime();
                    notifyFrameMetadataListener(j7, nanoTime, format);
                    if (Util.SDK_INT >= 21) {
                        renderOutputBufferV21(mediaCodecAdapter, i, j7, nanoTime);
                    } else {
                        renderOutputBuffer(mediaCodecAdapter2, i4, j7);
                    }
                    updateVideoFrameProcessingOffsetCounters(j8);
                    return true;
                }
                if (z4 && j5 != this.initialPositionUs) {
                    long nanoTime2 = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((j8 * 1000) + nanoTime2);
                    long j10 = (adjustReleaseTime - nanoTime2) / 1000;
                    long j11 = j10;
                    boolean z5 = this.joiningDeadlineMs != C.TIME_UNSET;
                    if (shouldDropBuffersToKeyframe(j10, j2, z2) && maybeDropBuffersToKeyframe(j5, z5)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(j11, j2, z2)) {
                        if (z5) {
                            skipOutputBuffer(mediaCodecAdapter2, i4, j7);
                        } else {
                            dropOutputBuffer(mediaCodecAdapter2, i4, j7);
                        }
                        updateVideoFrameProcessingOffsetCounters(j11);
                        return true;
                    }
                    long j12 = j11;
                    if (Util.SDK_INT >= 21) {
                        if (j12 < 50000) {
                            notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                            renderOutputBufferV21(mediaCodecAdapter, i, j7, adjustReleaseTime);
                            updateVideoFrameProcessingOffsetCounters(j12);
                            return true;
                        }
                    } else if (j12 < 30000) {
                        if (j12 > 11000) {
                            try {
                                Thread.sleep((j12 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        notifyFrameMetadataListener(j7, adjustReleaseTime, format);
                        renderOutputBuffer(mediaCodecAdapter2, i4, j7);
                        updateVideoFrameProcessingOffsetCounters(j12);
                        return true;
                    }
                }
                return false;
            } else if (!isBufferLate(j8)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodecAdapter2, i4, j7);
                updateVideoFrameProcessingOffsetCounters(j8);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodecAdapter2, i4, j7);
            return true;
        }
    }

    private void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            this.decoderCounters.skippedInputBufferCount += skipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 > 0 && this.droppedFrames >= i4) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context));
    }

    private void releasePlaceholderSurface() {
        Surface surface2 = this.surface;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (surface2 == placeholderSurface2) {
            this.surface = null;
        }
        placeholderSurface2.release();
        this.placeholderSurface = null;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : C.TIME_UNSET;
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            VideoSize videoSize = this.reportedVideoSize;
            if (videoSize == null || videoSize.width != this.currentWidth || this.reportedVideoSize.height != this.currentHeight || this.reportedVideoSize.unappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedVideoSize.pixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                VideoSize videoSize2 = new VideoSize(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedVideoSize = videoSize2;
                this.eventDispatcher.videoSizeChanged(videoSize2);
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    /* access modifiers changed from: protected */
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface2) {
        mediaCodecAdapter.setOutputSurface(surface2);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(SentryThread.JsonKeys.PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i + ViewHierarchyNode.JsonKeys.X + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i).setHeight(i2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + i + ViewHierarchyNode.JsonKeys.X + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.surface);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* access modifiers changed from: protected */
    public Surface getSurface() {
        return this.surface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x07d6, code lost:
        if (r0.equals("PGN528") == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:0x0844, code lost:
        if (r0.equals("AFTN") == false) goto L_0x083c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:473:0x0860, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 28
            r7 = 2
            r8 = -1
            r9 = 0
            r10 = 1
            if (r0 > r6) goto L_0x007a
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r11 = r0.hashCode()
            switch(r11) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r0 = r8
            goto L_0x0075
        L_0x001e:
            java.lang.String r11 = "machuca"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r0 = r1
            goto L_0x0075
        L_0x0029:
            java.lang.String r11 = "once"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r0 = r2
            goto L_0x0075
        L_0x0034:
            java.lang.String r11 = "magnolia"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r0 = r3
            goto L_0x0075
        L_0x003f:
            java.lang.String r11 = "aquaman"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r0 = r4
            goto L_0x0075
        L_0x004a:
            java.lang.String r11 = "oneday"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r0 = r5
            goto L_0x0075
        L_0x0055:
            java.lang.String r11 = "dangalUHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r0 = r7
            goto L_0x0075
        L_0x0060:
            java.lang.String r11 = "dangalFHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r0 = r10
            goto L_0x0075
        L_0x006b:
            java.lang.String r11 = "dangal"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r0 = r9
        L_0x0075:
            switch(r0) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r10
        L_0x007a:
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r11 = 27
            if (r0 > r11) goto L_0x008b
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r12 = "HWEML"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x008b
            return r10
        L_0x008b:
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r12 = 26
            if (r0 > r12) goto L_0x0861
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r13 = r0.hashCode()
            switch(r13) {
                case -2144781245: goto L_0x0822;
                case -2144781185: goto L_0x0816;
                case -2144781160: goto L_0x080a;
                case -2097309513: goto L_0x07fe;
                case -2022874474: goto L_0x07f2;
                case -1978993182: goto L_0x07e6;
                case -1978990237: goto L_0x07da;
                case -1936688988: goto L_0x07d0;
                case -1936688066: goto L_0x07c2;
                case -1936688065: goto L_0x07b4;
                case -1931988508: goto L_0x07a6;
                case -1885099851: goto L_0x0798;
                case -1696512866: goto L_0x078a;
                case -1680025915: goto L_0x077c;
                case -1615810839: goto L_0x076e;
                case -1600724499: goto L_0x0760;
                case -1554255044: goto L_0x0752;
                case -1481772737: goto L_0x0744;
                case -1481772730: goto L_0x0736;
                case -1481772729: goto L_0x0728;
                case -1320080169: goto L_0x071a;
                case -1217592143: goto L_0x070c;
                case -1180384755: goto L_0x06fe;
                case -1139198265: goto L_0x06f0;
                case -1052835013: goto L_0x06e2;
                case -993250464: goto L_0x06d4;
                case -993250458: goto L_0x06c7;
                case -965403638: goto L_0x06ba;
                case -958336948: goto L_0x06ad;
                case -879245230: goto L_0x069f;
                case -842500323: goto L_0x0691;
                case -821392978: goto L_0x0683;
                case -797483286: goto L_0x0675;
                case -794946968: goto L_0x0666;
                case -788334647: goto L_0x0657;
                case -782144577: goto L_0x0649;
                case -575125681: goto L_0x063b;
                case -521118391: goto L_0x062d;
                case -430914369: goto L_0x061f;
                case -290434366: goto L_0x0611;
                case -282781963: goto L_0x0603;
                case -277133239: goto L_0x05f5;
                case -173639913: goto L_0x05e7;
                case -56598463: goto L_0x05d8;
                case 2126: goto L_0x05ca;
                case 2564: goto L_0x05bc;
                case 2715: goto L_0x05ae;
                case 2719: goto L_0x05a0;
                case 3091: goto L_0x0592;
                case 3483: goto L_0x0584;
                case 73405: goto L_0x0576;
                case 75537: goto L_0x0568;
                case 75739: goto L_0x055a;
                case 76779: goto L_0x054c;
                case 78669: goto L_0x053e;
                case 79305: goto L_0x0530;
                case 80618: goto L_0x0522;
                case 88274: goto L_0x0514;
                case 98846: goto L_0x0506;
                case 98848: goto L_0x04f8;
                case 99329: goto L_0x04ea;
                case 101481: goto L_0x04dc;
                case 1513190: goto L_0x04ce;
                case 1514184: goto L_0x04c0;
                case 1514185: goto L_0x04b2;
                case 2133089: goto L_0x04a4;
                case 2133091: goto L_0x0496;
                case 2133120: goto L_0x0488;
                case 2133151: goto L_0x047a;
                case 2133182: goto L_0x046c;
                case 2133184: goto L_0x045e;
                case 2436959: goto L_0x0450;
                case 2463773: goto L_0x0442;
                case 2464648: goto L_0x0434;
                case 2689555: goto L_0x0426;
                case 3154429: goto L_0x0418;
                case 3284551: goto L_0x040a;
                case 3351335: goto L_0x03fc;
                case 3386211: goto L_0x03ee;
                case 41325051: goto L_0x03e0;
                case 51349633: goto L_0x03d2;
                case 51350594: goto L_0x03c4;
                case 55178625: goto L_0x03b6;
                case 61542055: goto L_0x03a8;
                case 65355429: goto L_0x039a;
                case 66214468: goto L_0x038c;
                case 66214470: goto L_0x037e;
                case 66214473: goto L_0x0370;
                case 66215429: goto L_0x0362;
                case 66215431: goto L_0x0354;
                case 66215433: goto L_0x0346;
                case 66216390: goto L_0x0338;
                case 76402249: goto L_0x032a;
                case 76404105: goto L_0x031c;
                case 76404911: goto L_0x030e;
                case 80963634: goto L_0x0300;
                case 82882791: goto L_0x02f2;
                case 98715550: goto L_0x02e4;
                case 101370885: goto L_0x02d6;
                case 102844228: goto L_0x02c8;
                case 165221241: goto L_0x02ba;
                case 182191441: goto L_0x02ac;
                case 245388979: goto L_0x029e;
                case 287431619: goto L_0x0290;
                case 307593612: goto L_0x0282;
                case 308517133: goto L_0x0274;
                case 316215098: goto L_0x0266;
                case 316215116: goto L_0x0258;
                case 316246811: goto L_0x024a;
                case 316246818: goto L_0x023c;
                case 407160593: goto L_0x022e;
                case 507412548: goto L_0x0220;
                case 793982701: goto L_0x0212;
                case 794038622: goto L_0x0204;
                case 794040393: goto L_0x01f6;
                case 835649806: goto L_0x01e8;
                case 917340916: goto L_0x01da;
                case 958008161: goto L_0x01cc;
                case 1060579533: goto L_0x01be;
                case 1150207623: goto L_0x01b0;
                case 1176899427: goto L_0x01a2;
                case 1280332038: goto L_0x0194;
                case 1306947716: goto L_0x0186;
                case 1349174697: goto L_0x0178;
                case 1522194893: goto L_0x0169;
                case 1691543273: goto L_0x015b;
                case 1691544261: goto L_0x014d;
                case 1709443163: goto L_0x013f;
                case 1865889110: goto L_0x0131;
                case 1906253259: goto L_0x0123;
                case 1977196784: goto L_0x0115;
                case 2006372676: goto L_0x0108;
                case 2019281702: goto L_0x00fb;
                case 2029784656: goto L_0x00ee;
                case 2030379515: goto L_0x00e1;
                case 2033393791: goto L_0x00d4;
                case 2047190025: goto L_0x00c7;
                case 2047252157: goto L_0x00ba;
                case 2048319463: goto L_0x00ad;
                case 2048855701: goto L_0x00a0;
                default: goto L_0x009d;
            }
        L_0x009d:
            r1 = r8
            goto L_0x082d
        L_0x00a0:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a9
            goto L_0x009d
        L_0x00a9:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x082d
        L_0x00ad:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b6
            goto L_0x009d
        L_0x00b6:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x082d
        L_0x00ba:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c3
            goto L_0x009d
        L_0x00c3:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x082d
        L_0x00c7:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d0
            goto L_0x009d
        L_0x00d0:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x082d
        L_0x00d4:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00dd
            goto L_0x009d
        L_0x00dd:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x082d
        L_0x00e1:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ea
            goto L_0x009d
        L_0x00ea:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x082d
        L_0x00ee:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f7
            goto L_0x009d
        L_0x00f7:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x082d
        L_0x00fb:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0104
            goto L_0x009d
        L_0x0104:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x082d
        L_0x0108:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0111
            goto L_0x009d
        L_0x0111:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x082d
        L_0x0115:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011f
            goto L_0x009d
        L_0x011f:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x082d
        L_0x0123:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012d
            goto L_0x009d
        L_0x012d:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x082d
        L_0x0131:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013b
            goto L_0x009d
        L_0x013b:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x082d
        L_0x013f:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0149
            goto L_0x009d
        L_0x0149:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x082d
        L_0x014d:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0157
            goto L_0x009d
        L_0x0157:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x082d
        L_0x015b:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0165
            goto L_0x009d
        L_0x0165:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x082d
        L_0x0169:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0174
            goto L_0x009d
        L_0x0174:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x082d
        L_0x0178:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0182
            goto L_0x009d
        L_0x0182:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x082d
        L_0x0186:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0190
            goto L_0x009d
        L_0x0190:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x082d
        L_0x0194:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x019e
            goto L_0x009d
        L_0x019e:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x082d
        L_0x01a2:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ac
            goto L_0x009d
        L_0x01ac:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x082d
        L_0x01b0:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ba
            goto L_0x009d
        L_0x01ba:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x082d
        L_0x01be:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c8
            goto L_0x009d
        L_0x01c8:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x082d
        L_0x01cc:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d6
            goto L_0x009d
        L_0x01d6:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x082d
        L_0x01da:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e4
            goto L_0x009d
        L_0x01e4:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x082d
        L_0x01e8:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f2
            goto L_0x009d
        L_0x01f2:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x082d
        L_0x01f6:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0200
            goto L_0x009d
        L_0x0200:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x082d
        L_0x0204:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x020e
            goto L_0x009d
        L_0x020e:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x082d
        L_0x0212:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x021c
            goto L_0x009d
        L_0x021c:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x082d
        L_0x0220:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022a
            goto L_0x009d
        L_0x022a:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x082d
        L_0x022e:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0238
            goto L_0x009d
        L_0x0238:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x082d
        L_0x023c:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0246
            goto L_0x009d
        L_0x0246:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x082d
        L_0x024a:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0254
            goto L_0x009d
        L_0x0254:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x082d
        L_0x0258:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0262
            goto L_0x009d
        L_0x0262:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x082d
        L_0x0266:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0270
            goto L_0x009d
        L_0x0270:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x082d
        L_0x0274:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x027e
            goto L_0x009d
        L_0x027e:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x082d
        L_0x0282:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028c
            goto L_0x009d
        L_0x028c:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x082d
        L_0x0290:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029a
            goto L_0x009d
        L_0x029a:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x082d
        L_0x029e:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02a8
            goto L_0x009d
        L_0x02a8:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x082d
        L_0x02ac:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b6
            goto L_0x009d
        L_0x02b6:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x082d
        L_0x02ba:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c4
            goto L_0x009d
        L_0x02c4:
            r1 = 100
            goto L_0x082d
        L_0x02c8:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d2
            goto L_0x009d
        L_0x02d2:
            r1 = 99
            goto L_0x082d
        L_0x02d6:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e0
            goto L_0x009d
        L_0x02e0:
            r1 = 98
            goto L_0x082d
        L_0x02e4:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ee
            goto L_0x009d
        L_0x02ee:
            r1 = 97
            goto L_0x082d
        L_0x02f2:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02fc
            goto L_0x009d
        L_0x02fc:
            r1 = 96
            goto L_0x082d
        L_0x0300:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030a
            goto L_0x009d
        L_0x030a:
            r1 = 95
            goto L_0x082d
        L_0x030e:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0318
            goto L_0x009d
        L_0x0318:
            r1 = 94
            goto L_0x082d
        L_0x031c:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0326
            goto L_0x009d
        L_0x0326:
            r1 = 93
            goto L_0x082d
        L_0x032a:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0334
            goto L_0x009d
        L_0x0334:
            r1 = 92
            goto L_0x082d
        L_0x0338:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0342
            goto L_0x009d
        L_0x0342:
            r1 = 91
            goto L_0x082d
        L_0x0346:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0350
            goto L_0x009d
        L_0x0350:
            r1 = 90
            goto L_0x082d
        L_0x0354:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x035e
            goto L_0x009d
        L_0x035e:
            r1 = 89
            goto L_0x082d
        L_0x0362:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x036c
            goto L_0x009d
        L_0x036c:
            r1 = 88
            goto L_0x082d
        L_0x0370:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037a
            goto L_0x009d
        L_0x037a:
            r1 = 87
            goto L_0x082d
        L_0x037e:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0388
            goto L_0x009d
        L_0x0388:
            r1 = 86
            goto L_0x082d
        L_0x038c:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0396
            goto L_0x009d
        L_0x0396:
            r1 = 85
            goto L_0x082d
        L_0x039a:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a4
            goto L_0x009d
        L_0x03a4:
            r1 = 84
            goto L_0x082d
        L_0x03a8:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b2
            goto L_0x009d
        L_0x03b2:
            r1 = 83
            goto L_0x082d
        L_0x03b6:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c0
            goto L_0x009d
        L_0x03c0:
            r1 = 82
            goto L_0x082d
        L_0x03c4:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ce
            goto L_0x009d
        L_0x03ce:
            r1 = 81
            goto L_0x082d
        L_0x03d2:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03dc
            goto L_0x009d
        L_0x03dc:
            r1 = 80
            goto L_0x082d
        L_0x03e0:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ea
            goto L_0x009d
        L_0x03ea:
            r1 = 79
            goto L_0x082d
        L_0x03ee:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03f8
            goto L_0x009d
        L_0x03f8:
            r1 = 78
            goto L_0x082d
        L_0x03fc:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0406
            goto L_0x009d
        L_0x0406:
            r1 = 77
            goto L_0x082d
        L_0x040a:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0414
            goto L_0x009d
        L_0x0414:
            r1 = 76
            goto L_0x082d
        L_0x0418:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0422
            goto L_0x009d
        L_0x0422:
            r1 = 75
            goto L_0x082d
        L_0x0426:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0430
            goto L_0x009d
        L_0x0430:
            r1 = 74
            goto L_0x082d
        L_0x0434:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x043e
            goto L_0x009d
        L_0x043e:
            r1 = 73
            goto L_0x082d
        L_0x0442:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x044c
            goto L_0x009d
        L_0x044c:
            r1 = 72
            goto L_0x082d
        L_0x0450:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045a
            goto L_0x009d
        L_0x045a:
            r1 = 71
            goto L_0x082d
        L_0x045e:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0468
            goto L_0x009d
        L_0x0468:
            r1 = 70
            goto L_0x082d
        L_0x046c:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0476
            goto L_0x009d
        L_0x0476:
            r1 = 69
            goto L_0x082d
        L_0x047a:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0484
            goto L_0x009d
        L_0x0484:
            r1 = 68
            goto L_0x082d
        L_0x0488:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0492
            goto L_0x009d
        L_0x0492:
            r1 = 67
            goto L_0x082d
        L_0x0496:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a0
            goto L_0x009d
        L_0x04a0:
            r1 = 66
            goto L_0x082d
        L_0x04a4:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ae
            goto L_0x009d
        L_0x04ae:
            r1 = 65
            goto L_0x082d
        L_0x04b2:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04bc
            goto L_0x009d
        L_0x04bc:
            r1 = 64
            goto L_0x082d
        L_0x04c0:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ca
            goto L_0x009d
        L_0x04ca:
            r1 = 63
            goto L_0x082d
        L_0x04ce:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04d8
            goto L_0x009d
        L_0x04d8:
            r1 = 62
            goto L_0x082d
        L_0x04dc:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e6
            goto L_0x009d
        L_0x04e6:
            r1 = 61
            goto L_0x082d
        L_0x04ea:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f4
            goto L_0x009d
        L_0x04f4:
            r1 = 60
            goto L_0x082d
        L_0x04f8:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0502
            goto L_0x009d
        L_0x0502:
            r1 = 59
            goto L_0x082d
        L_0x0506:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0510
            goto L_0x009d
        L_0x0510:
            r1 = 58
            goto L_0x082d
        L_0x0514:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x051e
            goto L_0x009d
        L_0x051e:
            r1 = 57
            goto L_0x082d
        L_0x0522:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x052c
            goto L_0x009d
        L_0x052c:
            r1 = 56
            goto L_0x082d
        L_0x0530:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053a
            goto L_0x009d
        L_0x053a:
            r1 = 55
            goto L_0x082d
        L_0x053e:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0548
            goto L_0x009d
        L_0x0548:
            r1 = 54
            goto L_0x082d
        L_0x054c:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0556
            goto L_0x009d
        L_0x0556:
            r1 = 53
            goto L_0x082d
        L_0x055a:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0564
            goto L_0x009d
        L_0x0564:
            r1 = 52
            goto L_0x082d
        L_0x0568:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0572
            goto L_0x009d
        L_0x0572:
            r1 = 51
            goto L_0x082d
        L_0x0576:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0580
            goto L_0x009d
        L_0x0580:
            r1 = 50
            goto L_0x082d
        L_0x0584:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x058e
            goto L_0x009d
        L_0x058e:
            r1 = 49
            goto L_0x082d
        L_0x0592:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x059c
            goto L_0x009d
        L_0x059c:
            r1 = 48
            goto L_0x082d
        L_0x05a0:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05aa
            goto L_0x009d
        L_0x05aa:
            r1 = 47
            goto L_0x082d
        L_0x05ae:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05b8
            goto L_0x009d
        L_0x05b8:
            r1 = 46
            goto L_0x082d
        L_0x05bc:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c6
            goto L_0x009d
        L_0x05c6:
            r1 = 45
            goto L_0x082d
        L_0x05ca:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d4
            goto L_0x009d
        L_0x05d4:
            r1 = 44
            goto L_0x082d
        L_0x05d8:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e3
            goto L_0x009d
        L_0x05e3:
            r1 = 43
            goto L_0x082d
        L_0x05e7:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f1
            goto L_0x009d
        L_0x05f1:
            r1 = 42
            goto L_0x082d
        L_0x05f5:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ff
            goto L_0x009d
        L_0x05ff:
            r1 = 41
            goto L_0x082d
        L_0x0603:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060d
            goto L_0x009d
        L_0x060d:
            r1 = 40
            goto L_0x082d
        L_0x0611:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061b
            goto L_0x009d
        L_0x061b:
            r1 = 39
            goto L_0x082d
        L_0x061f:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0629
            goto L_0x009d
        L_0x0629:
            r1 = 38
            goto L_0x082d
        L_0x062d:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0637
            goto L_0x009d
        L_0x0637:
            r1 = 37
            goto L_0x082d
        L_0x063b:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0645
            goto L_0x009d
        L_0x0645:
            r1 = 36
            goto L_0x082d
        L_0x0649:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0653
            goto L_0x009d
        L_0x0653:
            r1 = 35
            goto L_0x082d
        L_0x0657:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0662
            goto L_0x009d
        L_0x0662:
            r1 = 34
            goto L_0x082d
        L_0x0666:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0671
            goto L_0x009d
        L_0x0671:
            r1 = 33
            goto L_0x082d
        L_0x0675:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067f
            goto L_0x009d
        L_0x067f:
            r1 = 32
            goto L_0x082d
        L_0x0683:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068d
            goto L_0x009d
        L_0x068d:
            r1 = 31
            goto L_0x082d
        L_0x0691:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069b
            goto L_0x009d
        L_0x069b:
            r1 = 30
            goto L_0x082d
        L_0x069f:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a9
            goto L_0x009d
        L_0x06a9:
            r1 = 29
            goto L_0x082d
        L_0x06ad:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b7
            goto L_0x009d
        L_0x06b7:
            r1 = r6
            goto L_0x082d
        L_0x06ba:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c4
            goto L_0x009d
        L_0x06c4:
            r1 = r11
            goto L_0x082d
        L_0x06c7:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d1
            goto L_0x009d
        L_0x06d1:
            r1 = r12
            goto L_0x082d
        L_0x06d4:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06de
            goto L_0x009d
        L_0x06de:
            r1 = 25
            goto L_0x082d
        L_0x06e2:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ec
            goto L_0x009d
        L_0x06ec:
            r1 = 24
            goto L_0x082d
        L_0x06f0:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fa
            goto L_0x009d
        L_0x06fa:
            r1 = 23
            goto L_0x082d
        L_0x06fe:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0708
            goto L_0x009d
        L_0x0708:
            r1 = 22
            goto L_0x082d
        L_0x070c:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0716
            goto L_0x009d
        L_0x0716:
            r1 = 21
            goto L_0x082d
        L_0x071a:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0724
            goto L_0x009d
        L_0x0724:
            r1 = 20
            goto L_0x082d
        L_0x0728:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0732
            goto L_0x009d
        L_0x0732:
            r1 = 19
            goto L_0x082d
        L_0x0736:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0740
            goto L_0x009d
        L_0x0740:
            r1 = 18
            goto L_0x082d
        L_0x0744:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x074e
            goto L_0x009d
        L_0x074e:
            r1 = 17
            goto L_0x082d
        L_0x0752:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075c
            goto L_0x009d
        L_0x075c:
            r1 = 16
            goto L_0x082d
        L_0x0760:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076a
            goto L_0x009d
        L_0x076a:
            r1 = 15
            goto L_0x082d
        L_0x076e:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0778
            goto L_0x009d
        L_0x0778:
            r1 = 14
            goto L_0x082d
        L_0x077c:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0786
            goto L_0x009d
        L_0x0786:
            r1 = 13
            goto L_0x082d
        L_0x078a:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0794
            goto L_0x009d
        L_0x0794:
            r1 = 12
            goto L_0x082d
        L_0x0798:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a2
            goto L_0x009d
        L_0x07a2:
            r1 = 11
            goto L_0x082d
        L_0x07a6:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b0
            goto L_0x009d
        L_0x07b0:
            r1 = 10
            goto L_0x082d
        L_0x07b4:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07be
            goto L_0x009d
        L_0x07be:
            r1 = 9
            goto L_0x082d
        L_0x07c2:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cc
            goto L_0x009d
        L_0x07cc:
            r1 = 8
            goto L_0x082d
        L_0x07d0:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x082d
            goto L_0x009d
        L_0x07da:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e4
            goto L_0x009d
        L_0x07e4:
            r1 = r2
            goto L_0x082d
        L_0x07e6:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f0
            goto L_0x009d
        L_0x07f0:
            r1 = r3
            goto L_0x082d
        L_0x07f2:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07fc
            goto L_0x009d
        L_0x07fc:
            r1 = r4
            goto L_0x082d
        L_0x07fe:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0808
            goto L_0x009d
        L_0x0808:
            r1 = r5
            goto L_0x082d
        L_0x080a:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0814
            goto L_0x009d
        L_0x0814:
            r1 = r7
            goto L_0x082d
        L_0x0816:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0820
            goto L_0x009d
        L_0x0820:
            r1 = r10
            goto L_0x082d
        L_0x0822:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x082c
            goto L_0x009d
        L_0x082c:
            r1 = r9
        L_0x082d:
            switch(r1) {
                case 0: goto L_0x0860;
                case 1: goto L_0x0860;
                case 2: goto L_0x0860;
                case 3: goto L_0x0860;
                case 4: goto L_0x0860;
                case 5: goto L_0x0860;
                case 6: goto L_0x0860;
                case 7: goto L_0x0860;
                case 8: goto L_0x0860;
                case 9: goto L_0x0860;
                case 10: goto L_0x0860;
                case 11: goto L_0x0860;
                case 12: goto L_0x0860;
                case 13: goto L_0x0860;
                case 14: goto L_0x0860;
                case 15: goto L_0x0860;
                case 16: goto L_0x0860;
                case 17: goto L_0x0860;
                case 18: goto L_0x0860;
                case 19: goto L_0x0860;
                case 20: goto L_0x0860;
                case 21: goto L_0x0860;
                case 22: goto L_0x0860;
                case 23: goto L_0x0860;
                case 24: goto L_0x0860;
                case 25: goto L_0x0860;
                case 26: goto L_0x0860;
                case 27: goto L_0x0860;
                case 28: goto L_0x0860;
                case 29: goto L_0x0860;
                case 30: goto L_0x0860;
                case 31: goto L_0x0860;
                case 32: goto L_0x0860;
                case 33: goto L_0x0860;
                case 34: goto L_0x0860;
                case 35: goto L_0x0860;
                case 36: goto L_0x0860;
                case 37: goto L_0x0860;
                case 38: goto L_0x0860;
                case 39: goto L_0x0860;
                case 40: goto L_0x0860;
                case 41: goto L_0x0860;
                case 42: goto L_0x0860;
                case 43: goto L_0x0860;
                case 44: goto L_0x0860;
                case 45: goto L_0x0860;
                case 46: goto L_0x0860;
                case 47: goto L_0x0860;
                case 48: goto L_0x0860;
                case 49: goto L_0x0860;
                case 50: goto L_0x0860;
                case 51: goto L_0x0860;
                case 52: goto L_0x0860;
                case 53: goto L_0x0860;
                case 54: goto L_0x0860;
                case 55: goto L_0x0860;
                case 56: goto L_0x0860;
                case 57: goto L_0x0860;
                case 58: goto L_0x0860;
                case 59: goto L_0x0860;
                case 60: goto L_0x0860;
                case 61: goto L_0x0860;
                case 62: goto L_0x0860;
                case 63: goto L_0x0860;
                case 64: goto L_0x0860;
                case 65: goto L_0x0860;
                case 66: goto L_0x0860;
                case 67: goto L_0x0860;
                case 68: goto L_0x0860;
                case 69: goto L_0x0860;
                case 70: goto L_0x0860;
                case 71: goto L_0x0860;
                case 72: goto L_0x0860;
                case 73: goto L_0x0860;
                case 74: goto L_0x0860;
                case 75: goto L_0x0860;
                case 76: goto L_0x0860;
                case 77: goto L_0x0860;
                case 78: goto L_0x0860;
                case 79: goto L_0x0860;
                case 80: goto L_0x0860;
                case 81: goto L_0x0860;
                case 82: goto L_0x0860;
                case 83: goto L_0x0860;
                case 84: goto L_0x0860;
                case 85: goto L_0x0860;
                case 86: goto L_0x0860;
                case 87: goto L_0x0860;
                case 88: goto L_0x0860;
                case 89: goto L_0x0860;
                case 90: goto L_0x0860;
                case 91: goto L_0x0860;
                case 92: goto L_0x0860;
                case 93: goto L_0x0860;
                case 94: goto L_0x0860;
                case 95: goto L_0x0860;
                case 96: goto L_0x0860;
                case 97: goto L_0x0860;
                case 98: goto L_0x0860;
                case 99: goto L_0x0860;
                case 100: goto L_0x0860;
                case 101: goto L_0x0860;
                case 102: goto L_0x0860;
                case 103: goto L_0x0860;
                case 104: goto L_0x0860;
                case 105: goto L_0x0860;
                case 106: goto L_0x0860;
                case 107: goto L_0x0860;
                case 108: goto L_0x0860;
                case 109: goto L_0x0860;
                case 110: goto L_0x0860;
                case 111: goto L_0x0860;
                case 112: goto L_0x0860;
                case 113: goto L_0x0860;
                case 114: goto L_0x0860;
                case 115: goto L_0x0860;
                case 116: goto L_0x0860;
                case 117: goto L_0x0860;
                case 118: goto L_0x0860;
                case 119: goto L_0x0860;
                case 120: goto L_0x0860;
                case 121: goto L_0x0860;
                case 122: goto L_0x0860;
                case 123: goto L_0x0860;
                case 124: goto L_0x0860;
                case 125: goto L_0x0860;
                case 126: goto L_0x0860;
                case 127: goto L_0x0860;
                case 128: goto L_0x0860;
                case 129: goto L_0x0860;
                case 130: goto L_0x0860;
                case 131: goto L_0x0860;
                case 132: goto L_0x0860;
                case 133: goto L_0x0860;
                case 134: goto L_0x0860;
                case 135: goto L_0x0860;
                case 136: goto L_0x0860;
                case 137: goto L_0x0860;
                case 138: goto L_0x0860;
                case 139: goto L_0x0860;
                default: goto L_0x0830;
            }
        L_0x0830:
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.MODEL
            r0.hashCode()
            int r1 = r0.hashCode()
            switch(r1) {
                case -594534941: goto L_0x0852;
                case 2006354: goto L_0x0847;
                case 2006367: goto L_0x083e;
                default: goto L_0x083c;
            }
        L_0x083c:
            r7 = r8
            goto L_0x085c
        L_0x083e:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x085c
            goto L_0x083c
        L_0x0847:
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0850
            goto L_0x083c
        L_0x0850:
            r7 = r10
            goto L_0x085c
        L_0x0852:
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x085b
            goto L_0x083c
        L_0x085b:
            r7 = r9
        L_0x085c:
            switch(r7) {
                case 0: goto L_0x0860;
                case 1: goto L_0x0860;
                case 2: goto L_0x0860;
                default: goto L_0x085f;
            }
        L_0x085f:
            goto L_0x0861
        L_0x0860:
            return r10
        L_0x0861:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                if (j == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
                } catch (ExoPlaybackException e) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
                }
            }
        }
    }
}
