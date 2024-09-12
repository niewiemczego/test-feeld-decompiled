package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import io.sentry.protocol.SentryThread;
import java.nio.ByteBuffer;
import java.util.List;

public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private static final String TAG = "MediaCodecAudioRenderer";
    private static final String VIVO_BITS_PER_SAMPLE_KEY = "v-bits-per-sample";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioSinkNeedsReset;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private final Context context;
    private long currentPositionUs;
    private Format decryptOnlyCodecFormat;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private boolean experimentalKeepAudioTrackOnSeek;
    /* access modifiers changed from: private */
    public Renderer.WakeupListener wakeupListener;

    public MediaClock getMediaClock() {
        return this;
    }

    public String getName() {
        return TAG;
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, (Handler) null, (AudioRendererEventListener) null);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        this(context2, mediaCodecSelector, handler, audioRendererEventListener, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES, new AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context2, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink.Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).build());
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink2);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink2);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        super(1, factory, mediaCodecSelector, z, 44100.0f);
        this.context = context2.getApplicationContext();
        this.audioSink = audioSink2;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink2.setListener(new AudioSinkListener());
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.experimentalKeepAudioTrackOnSeek = z;
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        int i2 = Util.SDK_INT >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = format.cryptoType != 0;
        boolean supportsFormatDrm = supportsFormatDrm(format);
        int i3 = 8;
        int i4 = 4;
        if (supportsFormatDrm && this.audioSink.supportsFormat(format) && (!z3 || MediaCodecUtil.getDecryptOnlyDecoderInfo() != null)) {
            return RendererCapabilities.create(4, 8, i2);
        }
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) && !this.audioSink.supportsFormat(format)) {
            return RendererCapabilities.create(1);
        }
        if (!this.audioSink.supportsFormat(Util.getPcmFormat(2, format.channelCount, format.sampleRate))) {
            return RendererCapabilities.create(1);
        }
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, this.audioSink);
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!supportsFormatDrm) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            int i5 = 1;
            while (true) {
                if (i5 >= decoderInfos.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i5);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z = false;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
                i5++;
            }
        }
        z = true;
        z2 = isFormatSupported;
        if (!z2) {
            i4 = 3;
        }
        if (z2 && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i3 = 16;
        }
        int i6 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        if (z) {
            i = 128;
        }
        return RendererCapabilities.create(i4, i3, i2, i6, i);
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(mediaCodecSelector, format, z, this.audioSink), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z, AudioSink audioSink2) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo decryptOnlyDecoderInfo;
        String str = format.sampleMimeType;
        if (str == null) {
            return ImmutableList.of();
        }
        if (audioSink2.supportsFormat(format) && (decryptOnlyDecoderInfo = MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null) {
            return ImmutableList.of(decryptOnlyDecoderInfo);
        }
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(str, z, false);
        String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType == null) {
            return ImmutableList.copyOf(decoderInfos);
        }
        return ImmutableList.builder().addAll((Iterable) decoderInfos).addAll((Iterable) mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z, false)).build();
    }

    /* access modifiers changed from: protected */
    public boolean shouldUseBypass(Format format) {
        return this.audioSink.supportsFormat(format);
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        this.codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
        MediaFormat mediaFormat = getMediaFormat(format, mediaCodecInfo.codecMimeType, this.codecMaxInputSize, f);
        this.decryptOnlyCodecFormat = MimeTypes.AUDIO_RAW.equals(mediaCodecInfo.mimeType) && !MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) ? format : null;
        return MediaCodecAdapter.Configuration.createForAudioDecoding(mediaCodecInfo, mediaFormat, format, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        if (getCodecMaxInputSize(mediaCodecInfo, format2) > this.codecMaxInputSize) {
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
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        int i = -1;
        for (Format format2 : formatArr) {
            int i2 = format2.sampleRate;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * ((float) i);
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    /* access modifiers changed from: protected */
    public void onCodecError(Exception exc) {
        Log.e(TAG, "Audio codec error", exc);
        this.eventDispatcher.audioCodecError(exc);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        Format format2 = this.decryptOnlyCodecFormat;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (getCodec() != null) {
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                i = format.pcmEncoding;
            } else if (Util.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.containsKey(VIVO_BITS_PER_SAMPLE_KEY) ? Util.getPcmEncoding(mediaFormat.getInteger(VIVO_BITS_PER_SAMPLE_KEY)) : 2;
            } else {
                i = mediaFormat.getInteger("pcm-encoding");
            }
            Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setPcmEncoding(i).setEncoderDelay(format.encoderDelay).setEncoderPadding(format.encoderPadding).setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).build();
            if (this.codecNeedsDiscardChannelsWorkaround && build.channelCount == 6 && format.channelCount < 6) {
                iArr = new int[format.channelCount];
                for (int i2 = 0; i2 < format.channelCount; i2++) {
                    iArr[i2] = i2;
                }
            }
            format = build;
        }
        try {
            this.audioSink.configure(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, e.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        this.eventDispatcher.enabled(this.decoderCounters);
        if (getConfiguration().tunneling) {
            this.audioSink.enableTunnelingV21();
        } else {
            this.audioSink.disableTunneling();
        }
        this.audioSink.setPlayerId(getPlayerId());
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.experimentalKeepAudioTrackOnSeek) {
            this.audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.audioSink.flush();
        }
        this.currentPositionUs = j;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.audioSinkNeedsReset = true;
        try {
            this.audioSink.flush();
            try {
                super.onDisabled();
            } finally {
                this.eventDispatcher.disabled(this.decoderCounters);
            }
        } catch (Throwable th) {
            super.onDisabled();
            throw th;
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.audioSinkNeedsReset) {
                this.audioSinkNeedsReset = false;
                this.audioSink.reset();
            }
        }
    }

    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.audioSink.setPlaybackParameters(playbackParameters);
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.audioSink.handleDiscontinuity();
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        Assertions.checkNotNull(byteBuffer);
        if (this.decryptOnlyCodecFormat != null && (i2 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.checkNotNull(mediaCodecAdapter)).releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.skippedOutputBufferCount += i3;
            this.audioSink.handleDiscontinuity();
            return true;
        } else {
            try {
                if (!this.audioSink.handleBuffer(byteBuffer, j3, i3)) {
                    return false;
                }
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.releaseOutputBuffer(i, false);
                }
                this.decoderCounters.renderedOutputBufferCount += i3;
                return true;
            } catch (AudioSink.InitializationException e) {
                throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (AudioSink.WriteException e2) {
                throw createRendererException(e2, format, e2.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) obj);
        } else if (i != 6) {
            switch (i) {
                case 9:
                    this.audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.audioSink.setAudioSessionId(((Integer) obj).intValue());
                    return;
                case 11:
                    this.wakeupListener = (Renderer.WakeupListener) obj;
                    return;
                default:
                    super.handleMessage(i, obj);
                    return;
            }
        } else {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
        }
    }

    /* access modifiers changed from: protected */
    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize2 = getCodecMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return codecMaxInputSize2;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                codecMaxInputSize2 = Math.max(codecMaxInputSize2, getCodecMaxInputSize(mediaCodecInfo, format2));
            }
        }
        return codecMaxInputSize2;
    }

    private int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.name) || Util.SDK_INT >= 24 || (Util.SDK_INT == 23 && Util.isTv(this.context))) {
            return format.maxInputSize;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(SentryThread.JsonKeys.PRIORITY, 0);
            if (f != -1.0f && !deviceDoesntSupportOperatingRate()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (Util.SDK_INT <= 28 && MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (Util.SDK_INT >= 24 && this.audioSink.getFormatSupport(Util.getPcmFormat(4, format.channelCount, format.sampleRate)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (Util.SDK_INT >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    private void updateCurrentPosition() {
        long currentPositionUs2 = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs2 != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs2 = Math.max(this.currentPositionUs, currentPositionUs2);
            }
            this.currentPositionUs = currentPositionUs2;
            this.allowPositionDiscontinuity = false;
        }
    }

    private static boolean deviceDoesntSupportOperatingRate() {
        return Util.SDK_INT == 23 && ("ZTE B2017G".equals(Util.MODEL) || "AXON 7 mini".equals(Util.MODEL));
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String str) {
        return Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("herolte") || Util.DEVICE.startsWith("heroqlte"));
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onPositionDiscontinuity();
        }

        public void onPositionAdvancing(long j) {
            MediaCodecAudioRenderer.this.eventDispatcher.positionAdvancing(j);
        }

        public void onUnderrun(int i, long j, long j2) {
            MediaCodecAudioRenderer.this.eventDispatcher.underrun(i, j, j2);
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
            MediaCodecAudioRenderer.this.eventDispatcher.skipSilenceEnabledChanged(z);
        }

        public void onOffloadBufferEmptying() {
            if (MediaCodecAudioRenderer.this.wakeupListener != null) {
                MediaCodecAudioRenderer.this.wakeupListener.onWakeup();
            }
        }

        public void onOffloadBufferFull() {
            if (MediaCodecAudioRenderer.this.wakeupListener != null) {
                MediaCodecAudioRenderer.this.wakeupListener.onSleep();
            }
        }

        public void onAudioSinkError(Exception exc) {
            Log.e(MediaCodecAudioRenderer.TAG, "Audio sink error", exc);
            MediaCodecAudioRenderer.this.eventDispatcher.audioSinkError(exc);
        }
    }
}
