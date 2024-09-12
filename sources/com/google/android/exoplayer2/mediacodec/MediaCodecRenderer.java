package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.FrameworkCryptoConfig;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    private static final int DRAIN_ACTION_FLUSH = 1;
    private static final int DRAIN_ACTION_FLUSH_AND_UPDATE_DRM_SESSION = 2;
    private static final int DRAIN_ACTION_NONE = 0;
    private static final int DRAIN_ACTION_REINITIALIZE = 3;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int DRAIN_STATE_WAIT_END_OF_STREAM = 2;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final String TAG = "MediaCodecRenderer";
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque<MediaCodecInfo> availableCodecInfos;
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(0);
    private final BatchBuffer bypassBatchBuffer;
    private boolean bypassDrainAndReinitialize;
    private boolean bypassEnabled;
    private final DecoderInputBuffer bypassSampleBuffer = new DecoderInputBuffer(2);
    private boolean bypassSampleBufferPending;
    private C2Mp3TimestampTracker c2Mp3TimestampTracker;
    private MediaCodecAdapter codec;
    private int codecAdaptationWorkaroundMode;
    private final MediaCodecAdapter.Factory codecAdapterFactory;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private Format codecInputFormat;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private MediaFormat codecOutputMediaFormat;
    private boolean codecOutputMediaFormatChanged;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private float currentPlaybackSpeed;
    private final ArrayList<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private final boolean enableDecoderFallback;
    private final TimedValueQueue<Format> formatQueue;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private final DecoderInputBuffer noDataBuffer = DecoderInputBuffer.newNoDataInstance();
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private long outputStreamStartPositionUs;
    private boolean pendingOutputEndOfStream;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamStartPositionsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private ExoPlaybackException pendingPlaybackException;
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private DrmSession sourceDrmSession;
    private float targetPlaybackSpeed;
    private boolean waitingForFirstSampleInFormat;

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        return CODEC_OPERATING_RATE_UNSET;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector2, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public abstract MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto2, float f);

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onCodecError(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void onCodecReleased(String str) {
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldReinitCodec() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldUseBypass(Format format) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector2, Format format) throws MediaCodecUtil.DecoderQueryException;

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, th, format.sampleMimeType, z, (MediaCodecInfo) null, buildCustomDiagnosticInfo(i), (DecoderInitializationException) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, Throwable th, boolean z, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.name + ", " + format, th, format.sampleMimeType, z, mediaCodecInfo, Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null, (DecoderInitializationException) null);
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3, DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        /* access modifiers changed from: private */
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector2, boolean z, float f) {
        super(i);
        this.codecAdapterFactory = factory;
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector2);
        this.enableDecoderFallback = z;
        this.assumedMinimumCodecOperatingRate = f;
        BatchBuffer batchBuffer = new BatchBuffer();
        this.bypassBatchBuffer = batchBuffer;
        this.formatQueue = new TimedValueQueue<>();
        this.decodeOnlyPresentationTimestamps = new ArrayList<>();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.currentPlaybackSpeed = 1.0f;
        this.targetPlaybackSpeed = 1.0f;
        this.renderTimeLimitMs = C.TIME_UNSET;
        this.pendingOutputStreamStartPositionsUs = new long[10];
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamStartPositionUs = C.TIME_UNSET;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        batchBuffer.ensureSpaceForWrite(0);
        batchBuffer.data.order(ByteOrder.nativeOrder());
        this.codecOperatingRate = CODEC_OPERATING_RATE_UNSET;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecReconfigurationState = 0;
        this.inputIndex = -1;
        this.outputIndex = -1;
        this.codecHotswapDeadlineMs = C.TIME_UNSET;
        this.largestQueuedPresentationTimeUs = C.TIME_UNSET;
        this.lastBufferInStreamPresentationTimeUs = C.TIME_UNSET;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
    }

    public void setRenderTimeLimitMs(long j) {
        this.renderTimeLimitMs = j;
    }

    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    /* access modifiers changed from: protected */
    public final void maybeInitCodecOrBypass() throws ExoPlaybackException {
        Format format;
        if (this.codec == null && !this.bypassEnabled && (format = this.inputFormat) != null) {
            if (this.sourceDrmSession != null || !shouldUseBypass(format)) {
                setCodecDrmSession(this.sourceDrmSession);
                String str = this.inputFormat.sampleMimeType;
                DrmSession drmSession = this.codecDrmSession;
                if (drmSession != null) {
                    if (this.mediaCrypto == null) {
                        FrameworkCryptoConfig frameworkCryptoConfig = getFrameworkCryptoConfig(drmSession);
                        if (frameworkCryptoConfig != null) {
                            try {
                                this.mediaCrypto = new MediaCrypto(frameworkCryptoConfig.uuid, frameworkCryptoConfig.sessionId);
                                this.mediaCryptoRequiresSecureDecoder = !frameworkCryptoConfig.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
                            } catch (MediaCryptoException e) {
                                throw createRendererException(e, this.inputFormat, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
                            }
                        } else if (this.codecDrmSession.getError() == null) {
                            return;
                        }
                    }
                    if (FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                        int state = this.codecDrmSession.getState();
                        if (state == 1) {
                            DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.checkNotNull(this.codecDrmSession.getError());
                            throw createRendererException(drmSessionException, this.inputFormat, drmSessionException.errorCode);
                        } else if (state != 4) {
                            return;
                        }
                    }
                }
                try {
                    maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
                } catch (DecoderInitializationException e2) {
                    throw createRendererException(e2, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
                }
            } else {
                initBypass(this.inputFormat);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.pendingPlaybackException = exoPlaybackException;
    }

    /* access modifiers changed from: protected */
    public final void updateOutputFormatForTime(long j) throws ExoPlaybackException {
        boolean z;
        Format pollFloor = this.formatQueue.pollFloor(j);
        if (pollFloor == null && this.codecOutputMediaFormatChanged) {
            pollFloor = this.formatQueue.pollFirst();
        }
        if (pollFloor != null) {
            this.outputFormat = pollFloor;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.codecOutputMediaFormatChanged && this.outputFormat != null)) {
            onOutputFormatChanged(this.outputFormat, this.codecOutputMediaFormat);
            this.codecOutputMediaFormatChanged = false;
        }
    }

    /* access modifiers changed from: protected */
    public final MediaCodecAdapter getCodec() {
        return this.codec;
    }

    /* access modifiers changed from: protected */
    public final MediaFormat getCodecOutputMediaFormat() {
        return this.codecOutputMediaFormat;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
        boolean z = true;
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            if (this.outputStreamStartPositionUs != C.TIME_UNSET) {
                z = false;
            }
            Assertions.checkState(z);
            this.outputStreamStartPositionUs = j;
            this.outputStreamOffsetUs = j2;
            return;
        }
        int i = this.pendingOutputStreamOffsetCount;
        if (i == this.pendingOutputStreamOffsetsUs.length) {
            Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
        } else {
            this.pendingOutputStreamOffsetCount = i + 1;
        }
        long[] jArr = this.pendingOutputStreamStartPositionsUs;
        int i2 = this.pendingOutputStreamOffsetCount;
        jArr[i2 - 1] = j;
        this.pendingOutputStreamOffsetsUs[i2 - 1] = j2;
        this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.largestQueuedPresentationTimeUs;
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        if (this.bypassEnabled) {
            this.bypassBatchBuffer.clear();
            this.bypassSampleBuffer.clear();
            this.bypassSampleBufferPending = false;
        } else {
            flushOrReinitializeCodec();
        }
        if (this.formatQueue.size() > 0) {
            this.waitingForFirstSampleInFormat = true;
        }
        this.formatQueue.clear();
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.outputStreamStartPositionUs = this.pendingOutputStreamStartPositionsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
    }

    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        this.currentPlaybackSpeed = f;
        this.targetPlaybackSpeed = f2;
        updateCodecOperatingRate(this.codecInputFormat);
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.inputFormat = null;
        this.outputStreamStartPositionUs = C.TIME_UNSET;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.pendingOutputStreamOffsetCount = 0;
        flushOrReleaseCodec();
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            disableBypass();
            releaseCodec();
        } finally {
            setSourceDrmSession((DrmSession) null);
        }
    }

    private void disableBypass() {
        this.bypassDrainAndReinitialize = false;
        this.bypassBatchBuffer.clear();
        this.bypassSampleBuffer.clear();
        this.bypassSampleBufferPending = false;
        this.bypassEnabled = false;
    }

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.decoderCounters.decoderReleaseCount++;
                onCodecReleased(this.codecInfo.name);
            }
            this.codec = null;
            try {
                MediaCrypto mediaCrypto2 = this.mediaCrypto;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
            } finally {
                this.mediaCrypto = null;
                setCodecDrmSession((DrmSession) null);
                resetCodecStateForRelease();
            }
        } catch (Throwable th) {
            this.codec = null;
            MediaCrypto mediaCrypto3 = this.mediaCrypto;
            if (mediaCrypto3 != null) {
                mediaCrypto3.release();
            }
            throw th;
        } finally {
            this.mediaCrypto = null;
            setCodecDrmSession((DrmSession) null);
            resetCodecStateForRelease();
        }
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        boolean z = false;
        if (this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            processEndOfStream();
        }
        ExoPlaybackException exoPlaybackException = this.pendingPlaybackException;
        if (exoPlaybackException == null) {
            try {
                if (this.outputStreamEnded) {
                    renderToEndOfStream();
                } else if (this.inputFormat != null || readSourceOmittingSampleData(2)) {
                    maybeInitCodecOrBypass();
                    if (this.bypassEnabled) {
                        TraceUtil.beginSection("bypassRender");
                        while (bypassRender(j, j2)) {
                        }
                        TraceUtil.endSection();
                    } else if (this.codec != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        TraceUtil.beginSection("drainAndFeed");
                        while (drainOutputBuffer(j, j2) && shouldContinueRendering(elapsedRealtime)) {
                        }
                        while (feedInputBuffer() && shouldContinueRendering(elapsedRealtime)) {
                        }
                        TraceUtil.endSection();
                    } else {
                        this.decoderCounters.skippedInputBufferCount += skipSource(j);
                        readSourceOmittingSampleData(1);
                    }
                    this.decoderCounters.ensureUpdated();
                }
            } catch (IllegalStateException e) {
                if (isMediaCodecException(e)) {
                    onCodecError(e);
                    if (Util.SDK_INT >= 21 && isRecoverableMediaCodecExceptionV21(e)) {
                        z = true;
                    }
                    if (z) {
                        releaseCodec();
                    }
                    throw createRendererException(createDecoderException(e, getCodecInfo()), this.inputFormat, z, PlaybackException.ERROR_CODE_DECODING_FAILED);
                }
                throw e;
            }
        } else {
            this.pendingPlaybackException = null;
            throw exoPlaybackException;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return flushOrReleaseCodec;
    }

    /* access modifiers changed from: protected */
    public boolean flushOrReleaseCodec() {
        if (this.codec == null) {
            return false;
        }
        int i = this.codecDrainAction;
        if (i == 3 || this.codecNeedsFlushWorkaround || ((this.codecNeedsSosFlushWorkaround && !this.codecHasOutputMediaFormat) || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos))) {
            releaseCodec();
            return true;
        }
        if (i == 2) {
            Assertions.checkState(Util.SDK_INT >= 23);
            if (Util.SDK_INT >= 23) {
                try {
                    updateDrmSessionV23();
                } catch (ExoPlaybackException e) {
                    Log.w(TAG, "Failed to update the DRM session, releasing the codec instead.", e);
                    releaseCodec();
                    return true;
                }
            }
        }
        flushCodec();
        return false;
    }

    private void flushCodec() {
        try {
            this.codec.flush();
        } finally {
            resetCodecStateForFlush();
        }
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        resetInputBuffer();
        resetOutputBuffer();
        this.codecHotswapDeadlineMs = C.TIME_UNSET;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = C.TIME_UNSET;
        this.lastBufferInStreamPresentationTimeUs = C.TIME_UNSET;
        C2Mp3TimestampTracker c2Mp3TimestampTracker2 = this.c2Mp3TimestampTracker;
        if (c2Mp3TimestampTracker2 != null) {
            c2Mp3TimestampTracker2.reset();
        }
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecReconfigurationState = this.codecReconfigured ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.pendingPlaybackException = null;
        this.c2Mp3TimestampTracker = null;
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecInputFormat = null;
        this.codecOutputMediaFormat = null;
        this.codecOutputMediaFormatChanged = false;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = CODEC_OPERATING_RATE_UNSET;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsEosOutputExceptionWorkaround = false;
        this.codecNeedsEosBufferTimestampWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        this.mediaCryptoRequiresSecureDecoder = false;
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    private boolean readSourceOmittingSampleData(int i) throws ExoPlaybackException {
        FormatHolder formatHolder = getFormatHolder();
        this.noDataBuffer.clear();
        int readSource = readSource(formatHolder, this.noDataBuffer, i | 4);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4 || !this.noDataBuffer.isEndOfStream()) {
            return false;
        } else {
            this.inputStreamEnded = true;
            processEndOfStream();
            return false;
        }
    }

    private void maybeInitCodecWithFallback(MediaCrypto mediaCrypto2, boolean z) throws DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                List<MediaCodecInfo> availableCodecInfos2 = getAvailableCodecInfos(z);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.availableCodecInfos = arrayDeque;
                if (this.enableDecoderFallback) {
                    arrayDeque.addAll(availableCodecInfos2);
                } else if (!availableCodecInfos2.isEmpty()) {
                    this.availableCodecInfos.add(availableCodecInfos2.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.inputFormat, (Throwable) e, z, -49998);
            }
        }
        if (!this.availableCodecInfos.isEmpty()) {
            MediaCodecInfo peekFirst = this.availableCodecInfos.peekFirst();
            while (this.codec == null) {
                MediaCodecInfo peekFirst2 = this.availableCodecInfos.peekFirst();
                if (shouldInitCodec(peekFirst2)) {
                    try {
                        initCodec(peekFirst2, mediaCrypto2);
                    } catch (Exception e2) {
                        if (peekFirst2 == peekFirst) {
                            Log.w(TAG, "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50);
                            initCodec(peekFirst2, mediaCrypto2);
                        } else {
                            throw e2;
                        }
                    } catch (Exception e3) {
                        Log.w(TAG, "Failed to initialize decoder: " + peekFirst2, e3);
                        this.availableCodecInfos.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.inputFormat, (Throwable) e3, z, peekFirst2);
                        onCodecError(decoderInitializationException);
                        DecoderInitializationException decoderInitializationException2 = this.preferredDecoderInitializationException;
                        if (decoderInitializationException2 == null) {
                            this.preferredDecoderInitializationException = decoderInitializationException;
                        } else {
                            this.preferredDecoderInitializationException = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                        }
                        if (this.availableCodecInfos.isEmpty()) {
                            throw this.preferredDecoderInitializationException;
                        }
                    }
                } else {
                    return;
                }
            }
            this.availableCodecInfos = null;
            return;
        }
        throw new DecoderInitializationException(this.inputFormat, (Throwable) null, z, -49999);
    }

    private List<MediaCodecInfo> getAvailableCodecInfos(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if (!decoderInfos.isEmpty()) {
                Log.w(TAG, "Drm session requires secure decoder for " + this.inputFormat.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    private void initBypass(Format format) {
        disableBypass();
        String str = format.sampleMimeType;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.bypassBatchBuffer.setMaxSampleCount(32);
        } else {
            this.bypassBatchBuffer.setMaxSampleCount(1);
        }
        this.bypassEnabled = true;
    }

    /* JADX INFO: finally extract failed */
    private void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto2) throws Exception {
        float f;
        String str = mediaCodecInfo.name;
        int i = Util.SDK_INT;
        float f2 = CODEC_OPERATING_RATE_UNSET;
        if (i < 23) {
            f = -1.0f;
        } else {
            f = getCodecOperatingRateV23(this.targetPlaybackSpeed, this.inputFormat, getStreamFormats());
        }
        if (f > this.assumedMinimumCodecOperatingRate) {
            f2 = f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodecAdapter.Configuration mediaCodecConfiguration = getMediaCodecConfiguration(mediaCodecInfo, this.inputFormat, mediaCrypto2, f2);
        if (Util.SDK_INT >= 31) {
            Api31.setLogSessionIdToMediaCodecFormat(mediaCodecConfiguration, getPlayerId());
        }
        try {
            TraceUtil.beginSection("createCodec:" + str);
            this.codec = this.codecAdapterFactory.createAdapter(mediaCodecConfiguration);
            TraceUtil.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.codecInfo = mediaCodecInfo;
            this.codecOperatingRate = f2;
            this.codecInputFormat = this.inputFormat;
            this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str);
            this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str, this.codecInputFormat);
            this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str);
            this.codecNeedsSosFlushWorkaround = codecNeedsSosFlushWorkaround(str);
            this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str);
            this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str);
            this.codecNeedsEosBufferTimestampWorkaround = codecNeedsEosBufferTimestampWorkaround(str);
            this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str, this.codecInputFormat);
            boolean z = false;
            this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(mediaCodecInfo) || getCodecNeedsEosPropagation();
            if (this.codec.needsReconfiguration()) {
                this.codecReconfigured = true;
                this.codecReconfigurationState = 1;
                if (this.codecAdaptationWorkaroundMode != 0) {
                    z = true;
                }
                this.codecNeedsAdaptationWorkaroundBuffer = z;
            }
            if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                this.c2Mp3TimestampTracker = new C2Mp3TimestampTracker();
            }
            if (getState() == 2) {
                this.codecHotswapDeadlineMs = SystemClock.elapsedRealtime() + 1000;
            }
            this.decoderCounters.decoderInitCount++;
            onCodecInitialized(str, mediaCodecConfiguration, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            TraceUtil.endSection();
            throw th;
        }
    }

    private boolean shouldContinueRendering(long j) {
        return this.renderTimeLimitMs == C.TIME_UNSET || SystemClock.elapsedRealtime() - j < this.renderTimeLimitMs;
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void setCodecDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.codecDrmSession, drmSession);
        this.codecDrmSession = drmSession;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int i;
        if (this.codec == null || (i = this.codecDrainState) == 2 || this.inputStreamEnded) {
            return false;
        }
        if (i == 0 && shouldReinitCodec()) {
            drainAndReinitializeCodec();
        }
        if (this.inputIndex < 0) {
            int dequeueInputBufferIndex = this.codec.dequeueInputBufferIndex();
            this.inputIndex = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            this.buffer.data = this.codec.getInputBuffer(dequeueInputBufferIndex);
            this.buffer.clear();
        }
        if (this.codecDrainState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                resetInputBuffer();
            }
            this.codecDrainState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            ByteBuffer byteBuffer = this.buffer.data;
            byte[] bArr = ADAPTATION_WORKAROUND_BUFFER;
            byteBuffer.put(bArr);
            this.codec.queueInputBuffer(this.inputIndex, 0, bArr.length, 0, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        } else {
            if (this.codecReconfigurationState == 1) {
                for (int i2 = 0; i2 < this.codecInputFormat.initializationData.size(); i2++) {
                    this.buffer.data.put(this.codecInputFormat.initializationData.get(i2));
                }
                this.codecReconfigurationState = 2;
            }
            int position = this.buffer.data.position();
            FormatHolder formatHolder = getFormatHolder();
            try {
                int readSource = readSource(formatHolder, this.buffer, 0);
                if (hasReadStreamToEnd()) {
                    this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
                }
                if (readSource == -3) {
                    return false;
                }
                if (readSource == -5) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    onInputFormatChanged(formatHolder);
                    return true;
                } else if (this.buffer.isEndOfStream()) {
                    if (this.codecReconfigurationState == 2) {
                        this.buffer.clear();
                        this.codecReconfigurationState = 1;
                    }
                    this.inputStreamEnded = true;
                    if (!this.codecReceivedBuffers) {
                        processEndOfStream();
                        return false;
                    }
                    try {
                        if (!this.codecNeedsEosPropagation) {
                            this.codecReceivedEos = true;
                            this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                            resetInputBuffer();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw createRendererException(e, this.inputFormat, Util.getErrorCodeForMediaDrmErrorCode(e.getErrorCode()));
                    }
                } else if (this.codecReceivedBuffers || this.buffer.isKeyFrame()) {
                    boolean isEncrypted = this.buffer.isEncrypted();
                    if (isEncrypted) {
                        this.buffer.cryptoInfo.increaseClearDataFirstSubSampleBy(position);
                    }
                    if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                        NalUnitUtil.discardToSps(this.buffer.data);
                        if (this.buffer.data.position() == 0) {
                            return true;
                        }
                        this.codecNeedsDiscardToSpsWorkaround = false;
                    }
                    long j = this.buffer.timeUs;
                    C2Mp3TimestampTracker c2Mp3TimestampTracker2 = this.c2Mp3TimestampTracker;
                    if (c2Mp3TimestampTracker2 != null) {
                        j = c2Mp3TimestampTracker2.updateAndGetPresentationTimeUs(this.inputFormat, this.buffer);
                        this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, this.c2Mp3TimestampTracker.getLastOutputBufferPresentationTimeUs(this.inputFormat));
                    }
                    long j2 = j;
                    if (this.buffer.isDecodeOnly()) {
                        this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j2));
                    }
                    if (this.waitingForFirstSampleInFormat) {
                        this.formatQueue.add(j2, this.inputFormat);
                        this.waitingForFirstSampleInFormat = false;
                    }
                    this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j2);
                    this.buffer.flip();
                    if (this.buffer.hasSupplementalData()) {
                        handleInputBufferSupplementalData(this.buffer);
                    }
                    onQueueInputBuffer(this.buffer);
                    if (isEncrypted) {
                        try {
                            this.codec.queueSecureInputBuffer(this.inputIndex, 0, this.buffer.cryptoInfo, j2, 0);
                        } catch (MediaCodec.CryptoException e2) {
                            throw createRendererException(e2, this.inputFormat, Util.getErrorCodeForMediaDrmErrorCode(e2.getErrorCode()));
                        }
                    } else {
                        this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j2, 0);
                    }
                    resetInputBuffer();
                    this.codecReceivedBuffers = true;
                    this.codecReconfigurationState = 0;
                    this.decoderCounters.queuedInputBufferCount++;
                    return true;
                } else {
                    this.buffer.clear();
                    if (this.codecReconfigurationState == 2) {
                        this.codecReconfigurationState = 1;
                    }
                    return true;
                }
            } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
                onCodecError(e3);
                readSourceOmittingSampleData(0);
                flushCodec();
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (drainAndUpdateCodecDrmSessionV23() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
        if (drainAndUpdateCodecDrmSessionV23() == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ea A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.decoder.DecoderReuseEvaluation onInputFormatChanged(com.google.android.exoplayer2.FormatHolder r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r11 = this;
            r0 = 1
            r11.waitingForFirstSampleInFormat = r0
            com.google.android.exoplayer2.Format r1 = r12.format
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            r5 = r1
            com.google.android.exoplayer2.Format r5 = (com.google.android.exoplayer2.Format) r5
            java.lang.String r1 = r5.sampleMimeType
            if (r1 == 0) goto L_0x00eb
            com.google.android.exoplayer2.drm.DrmSession r12 = r12.drmSession
            r11.setSourceDrmSession(r12)
            r11.inputFormat = r5
            boolean r12 = r11.bypassEnabled
            r1 = 0
            if (r12 == 0) goto L_0x001f
            r11.bypassDrainAndReinitialize = r0
            return r1
        L_0x001f:
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r12 = r11.codec
            if (r12 != 0) goto L_0x0029
            r11.availableCodecInfos = r1
            r11.maybeInitCodecOrBypass()
            return r1
        L_0x0029:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r1 = r11.codecInfo
            com.google.android.exoplayer2.Format r4 = r11.codecInputFormat
            com.google.android.exoplayer2.drm.DrmSession r2 = r11.codecDrmSession
            com.google.android.exoplayer2.drm.DrmSession r3 = r11.sourceDrmSession
            boolean r2 = r11.drmNeedsCodecReinitialization(r1, r5, r2, r3)
            if (r2 == 0) goto L_0x0046
            r11.drainAndReinitializeCodec()
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r12 = new com.google.android.exoplayer2.decoder.DecoderReuseEvaluation
            java.lang.String r3 = r1.name
            r6 = 0
            r7 = 128(0x80, float:1.794E-43)
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x0046:
            com.google.android.exoplayer2.drm.DrmSession r2 = r11.sourceDrmSession
            com.google.android.exoplayer2.drm.DrmSession r3 = r11.codecDrmSession
            r6 = 0
            if (r2 == r3) goto L_0x004f
            r2 = r0
            goto L_0x0050
        L_0x004f:
            r2 = r6
        L_0x0050:
            if (r2 == 0) goto L_0x005b
            int r3 = com.google.android.exoplayer2.util.Util.SDK_INT
            r7 = 23
            if (r3 < r7) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r3 = r6
            goto L_0x005c
        L_0x005b:
            r3 = r0
        L_0x005c:
            com.google.android.exoplayer2.util.Assertions.checkState(r3)
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r3 = r11.canReuseCodec(r1, r4, r5)
            int r7 = r3.result
            r8 = 3
            r9 = 16
            r10 = 2
            if (r7 == 0) goto L_0x00d0
            if (r7 == r0) goto L_0x00b5
            if (r7 == r10) goto L_0x0089
            if (r7 != r8) goto L_0x0083
            boolean r0 = r11.updateCodecOperatingRate(r5)
            if (r0 != 0) goto L_0x0078
            goto L_0x00bb
        L_0x0078:
            r11.codecInputFormat = r5
            if (r2 == 0) goto L_0x00d3
            boolean r0 = r11.drainAndUpdateCodecDrmSessionV23()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00ce
        L_0x0083:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x0089:
            boolean r7 = r11.updateCodecOperatingRate(r5)
            if (r7 != 0) goto L_0x0090
            goto L_0x00bb
        L_0x0090:
            r11.codecReconfigured = r0
            r11.codecReconfigurationState = r0
            int r7 = r11.codecAdaptationWorkaroundMode
            if (r7 == r10) goto L_0x00a8
            if (r7 != r0) goto L_0x00a7
            int r7 = r5.width
            int r9 = r4.width
            if (r7 != r9) goto L_0x00a7
            int r7 = r5.height
            int r9 = r4.height
            if (r7 != r9) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r0 = r6
        L_0x00a8:
            r11.codecNeedsAdaptationWorkaroundBuffer = r0
            r11.codecInputFormat = r5
            if (r2 == 0) goto L_0x00d3
            boolean r0 = r11.drainAndUpdateCodecDrmSessionV23()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00ce
        L_0x00b5:
            boolean r0 = r11.updateCodecOperatingRate(r5)
            if (r0 != 0) goto L_0x00bd
        L_0x00bb:
            r7 = r9
            goto L_0x00d4
        L_0x00bd:
            r11.codecInputFormat = r5
            if (r2 == 0) goto L_0x00c8
            boolean r0 = r11.drainAndUpdateCodecDrmSessionV23()
            if (r0 != 0) goto L_0x00d3
            goto L_0x00ce
        L_0x00c8:
            boolean r0 = r11.drainAndFlushCodec()
            if (r0 != 0) goto L_0x00d3
        L_0x00ce:
            r7 = r10
            goto L_0x00d4
        L_0x00d0:
            r11.drainAndReinitializeCodec()
        L_0x00d3:
            r7 = r6
        L_0x00d4:
            int r0 = r3.result
            if (r0 == 0) goto L_0x00ea
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r11.codec
            if (r0 != r12) goto L_0x00e0
            int r12 = r11.codecDrainAction
            if (r12 != r8) goto L_0x00ea
        L_0x00e0:
            com.google.android.exoplayer2.decoder.DecoderReuseEvaluation r12 = new com.google.android.exoplayer2.decoder.DecoderReuseEvaluation
            java.lang.String r3 = r1.name
            r6 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x00ea:
            return r3
        L_0x00eb:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.exoplayer2.ExoPlaybackException r12 = r11.createRendererException(r12, r5, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.google.android.exoplayer2.FormatHolder):com.google.android.exoplayer2.decoder.DecoderReuseEvaluation");
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i != 0 && j >= this.pendingOutputStreamSwitchTimesUs[0]) {
                long[] jArr = this.pendingOutputStreamStartPositionsUs;
                this.outputStreamStartPositionUs = jArr[0];
                this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[0];
                int i2 = i - 1;
                this.pendingOutputStreamOffsetCount = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.pendingOutputStreamOffsetsUs;
                System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
                long[] jArr3 = this.pendingOutputStreamSwitchTimesUs;
                System.arraycopy(jArr3, 1, jArr3, 0, this.pendingOutputStreamOffsetCount);
                onProcessedStreamChange();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, 0, 1);
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return this.inputFormat != null && (isSourceReady() || hasOutputBuffer() || (this.codecHotswapDeadlineMs != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs));
    }

    /* access modifiers changed from: protected */
    public float getPlaybackSpeed() {
        return this.currentPlaybackSpeed;
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRate() {
        return this.codecOperatingRate;
    }

    /* access modifiers changed from: protected */
    public final boolean updateCodecOperatingRate() throws ExoPlaybackException {
        return updateCodecOperatingRate(this.codecInputFormat);
    }

    private boolean updateCodecOperatingRate(Format format) throws ExoPlaybackException {
        if (!(Util.SDK_INT < 23 || this.codec == null || this.codecDrainAction == 3 || getState() == 0)) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.targetPlaybackSpeed, format, getStreamFormats());
            float f = this.codecOperatingRate;
            if (f == codecOperatingRateV23) {
                return true;
            }
            if (codecOperatingRateV23 == CODEC_OPERATING_RATE_UNSET) {
                drainAndReinitializeCodec();
                return false;
            } else if (f == CODEC_OPERATING_RATE_UNSET && codecOperatingRateV23 <= this.assumedMinimumCodecOperatingRate) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", codecOperatingRateV23);
                this.codec.setParameters(bundle);
                this.codecOperatingRate = codecOperatingRateV23;
            }
        }
        return true;
    }

    private boolean drainAndFlushCodec() {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            if (this.codecNeedsFlushWorkaround || this.codecNeedsEosFlushWorkaround) {
                this.codecDrainAction = 3;
                return false;
            }
            this.codecDrainAction = 1;
        }
        return true;
    }

    private boolean drainAndUpdateCodecDrmSessionV23() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            if (this.codecNeedsFlushWorkaround || this.codecNeedsEosFlushWorkaround) {
                this.codecDrainAction = 3;
                return false;
            }
            this.codecDrainAction = 2;
        } else {
            updateDrmSessionV23();
        }
        return true;
    }

    private void drainAndReinitializeCodec() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
            return;
        }
        reinitializeCodec();
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drainOutputBuffer(long r20, long r22) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r19 = this;
            r15 = r19
            boolean r0 = r19.hasOutputBuffer()
            r16 = 1
            r14 = 0
            if (r0 != 0) goto L_0x00ce
            boolean r0 = r15.codecNeedsEosOutputExceptionWorkaround
            if (r0 == 0) goto L_0x0027
            boolean r0 = r15.codecReceivedEos
            if (r0 == 0) goto L_0x0027
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r15.codec     // Catch:{ IllegalStateException -> 0x001c }
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo     // Catch:{ IllegalStateException -> 0x001c }
            int r0 = r0.dequeueOutputBufferIndex(r1)     // Catch:{ IllegalStateException -> 0x001c }
            goto L_0x002f
        L_0x001c:
            r19.processEndOfStream()
            boolean r0 = r15.outputStreamEnded
            if (r0 == 0) goto L_0x0026
            r19.releaseCodec()
        L_0x0026:
            return r14
        L_0x0027:
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r0 = r15.codec
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo
            int r0 = r0.dequeueOutputBufferIndex(r1)
        L_0x002f:
            if (r0 >= 0) goto L_0x0049
            r1 = -2
            if (r0 != r1) goto L_0x0038
            r19.processOutputMediaFormatChanged()
            return r16
        L_0x0038:
            boolean r0 = r15.codecNeedsEosPropagation
            if (r0 == 0) goto L_0x0048
            boolean r0 = r15.inputStreamEnded
            if (r0 != 0) goto L_0x0045
            int r0 = r15.codecDrainState
            r1 = 2
            if (r0 != r1) goto L_0x0048
        L_0x0045:
            r19.processEndOfStream()
        L_0x0048:
            return r14
        L_0x0049:
            boolean r1 = r15.shouldSkipAdaptationWorkaroundOutputBuffer
            if (r1 == 0) goto L_0x0055
            r15.shouldSkipAdaptationWorkaroundOutputBuffer = r14
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r15.codec
            r1.releaseOutputBuffer((int) r0, (boolean) r14)
            return r16
        L_0x0055:
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo
            int r1 = r1.size
            if (r1 != 0) goto L_0x0067
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0067
            r19.processEndOfStream()
            return r14
        L_0x0067:
            r15.outputIndex = r0
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r15.codec
            java.nio.ByteBuffer r0 = r1.getOutputBuffer(r0)
            r15.outputBuffer = r0
            if (r0 == 0) goto L_0x0088
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.outputBuffer
            android.media.MediaCodec$BufferInfo r1 = r15.outputBufferInfo
            int r1 = r1.offset
            android.media.MediaCodec$BufferInfo r2 = r15.outputBufferInfo
            int r2 = r2.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x0088:
            boolean r0 = r15.codecNeedsEosBufferTimestampWorkaround
            if (r0 == 0) goto L_0x00ad
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            long r0 = r0.presentationTimeUs
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x00ad
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x00ad
            long r0 = r15.largestQueuedPresentationTimeUs
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00ad
            android.media.MediaCodec$BufferInfo r2 = r15.outputBufferInfo
            r2.presentationTimeUs = r0
        L_0x00ad:
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            long r0 = r0.presentationTimeUs
            boolean r0 = r15.isDecodeOnlyBuffer(r0)
            r15.isDecodeOnlyOutputBuffer = r0
            long r0 = r15.lastBufferInStreamPresentationTimeUs
            android.media.MediaCodec$BufferInfo r2 = r15.outputBufferInfo
            long r2 = r2.presentationTimeUs
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x00c4
            r0 = r16
            goto L_0x00c5
        L_0x00c4:
            r0 = r14
        L_0x00c5:
            r15.isLastOutputBuffer = r0
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            long r0 = r0.presentationTimeUs
            r15.updateOutputFormatForTime(r0)
        L_0x00ce:
            boolean r0 = r15.codecNeedsEosOutputExceptionWorkaround
            if (r0 == 0) goto L_0x0109
            boolean r0 = r15.codecReceivedEos
            if (r0 == 0) goto L_0x0109
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r5 = r15.codec     // Catch:{ IllegalStateException -> 0x00fc }
            java.nio.ByteBuffer r6 = r15.outputBuffer     // Catch:{ IllegalStateException -> 0x00fc }
            int r7 = r15.outputIndex     // Catch:{ IllegalStateException -> 0x00fc }
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo     // Catch:{ IllegalStateException -> 0x00fc }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x00fc }
            r9 = 1
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo     // Catch:{ IllegalStateException -> 0x00fc }
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00fc }
            boolean r12 = r15.isDecodeOnlyOutputBuffer     // Catch:{ IllegalStateException -> 0x00fc }
            boolean r13 = r15.isLastOutputBuffer     // Catch:{ IllegalStateException -> 0x00fc }
            com.google.android.exoplayer2.Format r3 = r15.outputFormat     // Catch:{ IllegalStateException -> 0x00fc }
            r0 = r19
            r1 = r20
            r17 = r3
            r3 = r22
            r18 = r14
            r14 = r17
            boolean r0 = r0.processOutputBuffer(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x00fe }
            goto L_0x012a
        L_0x00fc:
            r18 = r14
        L_0x00fe:
            r19.processEndOfStream()
            boolean r0 = r15.outputStreamEnded
            if (r0 == 0) goto L_0x0108
            r19.releaseCodec()
        L_0x0108:
            return r18
        L_0x0109:
            r18 = r14
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r5 = r15.codec
            java.nio.ByteBuffer r6 = r15.outputBuffer
            int r7 = r15.outputIndex
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            int r8 = r0.flags
            r9 = 1
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            long r10 = r0.presentationTimeUs
            boolean r12 = r15.isDecodeOnlyOutputBuffer
            boolean r13 = r15.isLastOutputBuffer
            com.google.android.exoplayer2.Format r14 = r15.outputFormat
            r0 = r19
            r1 = r20
            r3 = r22
            boolean r0 = r0.processOutputBuffer(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x012a:
            if (r0 == 0) goto L_0x0149
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            long r0 = r0.presentationTimeUs
            r15.onProcessedOutputBuffer(r0)
            android.media.MediaCodec$BufferInfo r0 = r15.outputBufferInfo
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x013e
            r14 = r16
            goto L_0x0140
        L_0x013e:
            r14 = r18
        L_0x0140:
            r19.resetOutputBuffer()
            if (r14 != 0) goto L_0x0146
            return r16
        L_0x0146:
            r19.processEndOfStream()
        L_0x0149:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.drainOutputBuffer(long, long):boolean");
    }

    private void processOutputMediaFormatChanged() {
        this.codecHasOutputMediaFormat = true;
        MediaFormat outputFormat2 = this.codec.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat2.getInteger("width") == 32 && outputFormat2.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat2.setInteger("channel-count", 1);
        }
        this.codecOutputMediaFormat = outputFormat2;
        this.codecOutputMediaFormatChanged = true;
    }

    private void processEndOfStream() throws ExoPlaybackException {
        int i = this.codecDrainAction;
        if (i == 1) {
            flushCodec();
        } else if (i == 2) {
            flushCodec();
            updateDrmSessionV23();
        } else if (i != 3) {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        } else {
            reinitializeCodec();
        }
    }

    /* access modifiers changed from: protected */
    public final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    /* access modifiers changed from: protected */
    public final long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    protected static boolean supportsFormatDrm(Format format) {
        return format.cryptoType == 0 || format.cryptoType == 2;
    }

    private boolean drmNeedsCodecReinitialization(MediaCodecInfo mediaCodecInfo, Format format, DrmSession drmSession, DrmSession drmSession2) throws ExoPlaybackException {
        FrameworkCryptoConfig frameworkCryptoConfig;
        boolean z;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || Util.SDK_INT < 23 || C.PLAYREADY_UUID.equals(drmSession.getSchemeUuid()) || C.PLAYREADY_UUID.equals(drmSession2.getSchemeUuid()) || (frameworkCryptoConfig = getFrameworkCryptoConfig(drmSession2)) == null) {
            return true;
        }
        if (frameworkCryptoConfig.forceAllowInsecureDecoderComponents) {
            z = false;
        } else {
            z = drmSession2.requiresSecureDecoder(format.sampleMimeType);
        }
        return !mediaCodecInfo.secure && z;
    }

    private void reinitializeCodec() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodecOrBypass();
    }

    private boolean isDecodeOnlyBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private void updateDrmSessionV23() throws ExoPlaybackException {
        try {
            this.mediaCrypto.setMediaDrmSession(getFrameworkCryptoConfig(this.sourceDrmSession).sessionId);
            setCodecDrmSession(this.sourceDrmSession);
            this.codecDrainState = 0;
            this.codecDrainAction = 0;
        } catch (MediaCryptoException e) {
            throw createRendererException(e, this.inputFormat, PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR);
        }
    }

    private FrameworkCryptoConfig getFrameworkCryptoConfig(DrmSession drmSession) throws ExoPlaybackException {
        CryptoConfig cryptoConfig = drmSession.getCryptoConfig();
        if (cryptoConfig == null || (cryptoConfig instanceof FrameworkCryptoConfig)) {
            return (FrameworkCryptoConfig) cryptoConfig;
        }
        throw createRendererException(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + cryptoConfig), this.inputFormat, PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED);
    }

    private boolean bypassRender(long j, long j2) throws ExoPlaybackException {
        boolean z;
        Assertions.checkState(!this.outputStreamEnded);
        if (this.bypassBatchBuffer.hasSamples()) {
            if (!processOutputBuffer(j, j2, (MediaCodecAdapter) null, this.bypassBatchBuffer.data, this.outputIndex, 0, this.bypassBatchBuffer.getSampleCount(), this.bypassBatchBuffer.getFirstSampleTimeUs(), this.bypassBatchBuffer.isDecodeOnly(), this.bypassBatchBuffer.isEndOfStream(), this.outputFormat)) {
                return false;
            }
            onProcessedOutputBuffer(this.bypassBatchBuffer.getLastSampleTimeUs());
            this.bypassBatchBuffer.clear();
            z = false;
        } else {
            z = false;
        }
        if (this.inputStreamEnded) {
            this.outputStreamEnded = true;
            return z;
        }
        if (this.bypassSampleBufferPending) {
            Assertions.checkState(this.bypassBatchBuffer.append(this.bypassSampleBuffer));
            this.bypassSampleBufferPending = z;
        }
        if (this.bypassDrainAndReinitialize) {
            if (this.bypassBatchBuffer.hasSamples()) {
                return true;
            }
            disableBypass();
            this.bypassDrainAndReinitialize = z;
            maybeInitCodecOrBypass();
            if (!this.bypassEnabled) {
                return z;
            }
        }
        bypassRead();
        if (this.bypassBatchBuffer.hasSamples()) {
            this.bypassBatchBuffer.flip();
        }
        if (this.bypassBatchBuffer.hasSamples() || this.inputStreamEnded || this.bypassDrainAndReinitialize) {
            return true;
        }
        return z;
    }

    private void bypassRead() throws ExoPlaybackException {
        Assertions.checkState(!this.inputStreamEnded);
        FormatHolder formatHolder = getFormatHolder();
        this.bypassSampleBuffer.clear();
        do {
            this.bypassSampleBuffer.clear();
            int readSource = readSource(formatHolder, this.bypassSampleBuffer, 0);
            if (readSource == -5) {
                onInputFormatChanged(formatHolder);
                return;
            } else if (readSource != -4) {
                if (readSource != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else if (this.bypassSampleBuffer.isEndOfStream()) {
                this.inputStreamEnded = true;
                return;
            } else {
                if (this.waitingForFirstSampleInFormat) {
                    Format format = (Format) Assertions.checkNotNull(this.inputFormat);
                    this.outputFormat = format;
                    onOutputFormatChanged(format, (MediaFormat) null);
                    this.waitingForFirstSampleInFormat = false;
                }
                this.bypassSampleBuffer.flip();
            }
        } while (this.bypassBatchBuffer.append(this.bypassSampleBuffer));
        this.bypassSampleBufferPending = true;
    }

    private static boolean isMediaCodecException(IllegalStateException illegalStateException) {
        if (Util.SDK_INT >= 21 && isMediaCodecExceptionV21(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
            return false;
        }
        return true;
    }

    private static boolean isMediaCodecExceptionV21(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean isRecoverableMediaCodecExceptionV21(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int codecAdaptationWorkaroundMode(String str) {
        if (Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (Util.SDK_INT >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsSosFlushWorkaround(String str) {
        return Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        return (Util.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (Util.SDK_INT <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((Util.SDK_INT <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo.secure));
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        return (Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (Util.SDK_INT <= 19 && (("hb2000".equals(Util.DEVICE) || "stvm8".equals(Util.DEVICE)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(String str) {
        return Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("baffin") || Util.DEVICE.startsWith("grand") || Util.DEVICE.startsWith("fortuna") || Util.DEVICE.startsWith("gprimelte") || Util.DEVICE.startsWith("j2y18lte") || Util.DEVICE.startsWith("ms01"));
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        if (Util.SDK_INT > 18 || format.channelCount != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private static final class Api31 {
        private Api31() {
        }

        public static void setLogSessionIdToMediaCodecFormat(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId logSessionId = playerId.getLogSessionId();
            if (!logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                configuration.mediaFormat.setString("log-session-id", logSessionId.getStringId());
            }
        }
    }
}
