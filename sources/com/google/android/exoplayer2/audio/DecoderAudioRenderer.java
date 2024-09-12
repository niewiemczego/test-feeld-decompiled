package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;

public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "DecoderAudioRenderer";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private T decoder;
    private DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private int encoderDelay;
    private int encoderPadding;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private boolean experimentalKeepAudioTrackOnSeek;
    private boolean firstStreamSampleRead;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private SimpleDecoderOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private DrmSession sourceDrmSession;

    /* access modifiers changed from: protected */
    public abstract T createDecoder(Format format, CryptoConfig cryptoConfig) throws DecoderException;

    public MediaClock getMediaClock() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract Format getOutputFormat(T t);

    /* access modifiers changed from: protected */
    public abstract int supportsFormatInternal(Format format);

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioCapabilities) null, audioProcessorArr);
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioSink) new DefaultAudioSink.Builder().setAudioCapabilities((AudioCapabilities) MoreObjects.firstNonNull(audioCapabilities, AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES)).setAudioProcessors(audioProcessorArr).build());
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        super(1);
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink2;
        audioSink2.setListener(new AudioSinkListener());
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.experimentalKeepAudioTrackOnSeek = z;
    }

    public final int supportsFormat(Format format) {
        int i = 0;
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        int supportsFormatInternal = supportsFormatInternal(format);
        if (supportsFormatInternal <= 2) {
            return RendererCapabilities.create(supportsFormatInternal);
        }
        if (Util.SDK_INT >= 21) {
            i = 32;
        }
        return RendererCapabilities.create(supportsFormatInternal, 8, i);
    }

    /* access modifiers changed from: protected */
    public final boolean sinkSupportsFormat(Format format) {
        return this.audioSink.supportsFormat(format);
    }

    /* access modifiers changed from: protected */
    public final int getSinkFormatSupport(Format format) {
        return this.audioSink.getFormatSupport(format);
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
            } catch (AudioSink.WriteException e) {
                throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        } else {
            if (this.inputFormat == null) {
                FormatHolder formatHolder = getFormatHolder();
                this.flagsOnlyBuffer.clear();
                int readSource = readSource(formatHolder, this.flagsOnlyBuffer, 2);
                if (readSource == -5) {
                    onInputFormatChanged(formatHolder);
                } else if (readSource == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    try {
                        processEndOfStream();
                        return;
                    } catch (AudioSink.WriteException e2) {
                        throw createRendererException(e2, (Format) null, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                    }
                } else {
                    return;
                }
            }
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer()) {
                    }
                    while (feedInputBuffer()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (DecoderException e3) {
                    Log.e(TAG, "Audio codec error", e3);
                    this.eventDispatcher.audioCodecError(e3);
                    throw createRendererException(e3, this.inputFormat, PlaybackException.ERROR_CODE_DECODING_FAILED);
                } catch (AudioSink.ConfigurationException e4) {
                    throw createRendererException(e4, e4.format, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                } catch (AudioSink.InitializationException e5) {
                    throw createRendererException(e5, e5.format, e5.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                } catch (AudioSink.WriteException e6) {
                    throw createRendererException(e6, e6.format, e6.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    private boolean drainOutputBuffer() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.outputBuffer == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.decoder.dequeueOutputBuffer();
            this.outputBuffer = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            if (simpleDecoderOutputBuffer.skippedOutputBufferCount > 0) {
                this.decoderCounters.skippedOutputBufferCount += this.outputBuffer.skippedOutputBufferCount;
                this.audioSink.handleDiscontinuity();
            }
            if (this.outputBuffer.isFirstSample()) {
                this.audioSink.handleDiscontinuity();
            }
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                try {
                    processEndOfStream();
                } catch (AudioSink.WriteException e) {
                    throw createRendererException(e, e.format, e.isRecoverable, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
                }
            }
            return false;
        }
        if (this.audioTrackNeedsConfigure) {
            this.audioSink.configure(getOutputFormat(this.decoder).buildUpon().setEncoderDelay(this.encoderDelay).setEncoderPadding(this.encoderPadding).build(), 0, (int[]) null);
            this.audioTrackNeedsConfigure = false;
        }
        if (!this.audioSink.handleBuffer(this.outputBuffer.data, this.outputBuffer.timeUs, 1)) {
            return false;
        }
        this.decoderCounters.renderedOutputBufferCount++;
        this.outputBuffer.release();
        this.outputBuffer = null;
        return true;
    }

    private boolean feedInputBuffer() throws DecoderException, ExoPlaybackException {
        T t = this.decoder;
        if (t == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t.dequeueInputBuffer();
            this.inputBuffer = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.inputBuffer, 0);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        } else if (readSource != -4) {
            if (readSource == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        } else {
            if (!this.firstStreamSampleRead) {
                this.firstStreamSampleRead = true;
                this.inputBuffer.addFlag(C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            this.inputBuffer.flip();
            this.inputBuffer.format = this.inputFormat;
            onQueueInputBuffer(this.inputBuffer);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.decoderReceivedBuffers = true;
            this.decoderCounters.queuedInputBufferCount++;
            this.inputBuffer = null;
            return true;
        }
    }

    private void processEndOfStream() throws AudioSink.WriteException {
        this.outputStreamEnded = true;
        this.audioSink.playToEndOfStream();
    }

    private void flushDecoder() throws ExoPlaybackException {
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.outputBuffer;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    public boolean isEnded() {
        return this.outputStreamEnded && this.audioSink.isEnded();
    }

    public boolean isReady() {
        return this.audioSink.hasPendingData() || (this.inputFormat != null && (isSourceReady() || this.outputBuffer != null));
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
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        DecoderCounters decoderCounters2 = new DecoderCounters();
        this.decoderCounters = decoderCounters2;
        this.eventDispatcher.enabled(decoderCounters2);
        if (getConfiguration().tunneling) {
            this.audioSink.enableTunnelingV21();
        } else {
            this.audioSink.disableTunneling();
        }
        this.audioSink.setPlayerId(getPlayerId());
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        if (this.experimentalKeepAudioTrackOnSeek) {
            this.audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.audioSink.flush();
        }
        this.currentPositionUs = j;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            flushDecoder();
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        this.audioSink.play();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = true;
        try {
            setSourceDrmSession((DrmSession) null);
            releaseDecoder();
            this.audioSink.reset();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j, j2);
        this.firstStreamSampleRead = false;
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.audioSink.setAudioAttributes((AudioAttributes) obj);
        } else if (i == 6) {
            this.audioSink.setAuxEffectInfo((AuxEffectInfo) obj);
        } else if (i == 9) {
            this.audioSink.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
        } else if (i != 10) {
            super.handleMessage(i, obj);
        } else {
            this.audioSink.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        if (this.decoder == null) {
            setDecoderDrmSession(this.sourceDrmSession);
            CryptoConfig cryptoConfig = null;
            DrmSession drmSession = this.decoderDrmSession;
            if (drmSession == null || (cryptoConfig = drmSession.getCryptoConfig()) != null || this.decoderDrmSession.getError() != null) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    TraceUtil.beginSection("createAudioDecoder");
                    this.decoder = createDecoder(this.inputFormat, cryptoConfig);
                    TraceUtil.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.decoderCounters.decoderInitCount++;
                } catch (DecoderException e) {
                    Log.e(TAG, "Audio codec error", e);
                    this.eventDispatcher.audioCodecError(e);
                    throw createRendererException(e, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
                } catch (OutOfMemoryError e2) {
                    throw createRendererException(e2, this.inputFormat, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
                }
            }
        }
    }

    private void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        if (this.decoder != null) {
            this.decoderCounters.decoderReleaseCount++;
            this.decoder.release();
            this.eventDispatcher.decoderReleased(this.decoder.getName());
            this.decoder = null;
        }
        setDecoderDrmSession((DrmSession) null);
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void setDecoderDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluation;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        setSourceDrmSession(formatHolder.drmSession);
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
        T t = this.decoder;
        if (t == null) {
            maybeInitDecoder();
            this.eventDispatcher.inputFormatChanged(this.inputFormat, (DecoderReuseEvaluation) null);
            return;
        }
        if (this.sourceDrmSession != this.decoderDrmSession) {
            decoderReuseEvaluation = new DecoderReuseEvaluation(this.decoder.getName(), format2, format, 0, 128);
        } else {
            decoderReuseEvaluation = canReuseDecoder(t.getName(), format2, format);
        }
        if (decoderReuseEvaluation.result == 0) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            }
        }
        this.eventDispatcher.inputFormatChanged(this.inputFormat, decoderReuseEvaluation);
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

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void onPositionDiscontinuity() {
            DecoderAudioRenderer.this.onPositionDiscontinuity();
        }

        public void onPositionAdvancing(long j) {
            DecoderAudioRenderer.this.eventDispatcher.positionAdvancing(j);
        }

        public void onUnderrun(int i, long j, long j2) {
            DecoderAudioRenderer.this.eventDispatcher.underrun(i, j, j2);
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
            DecoderAudioRenderer.this.eventDispatcher.skipSilenceEnabledChanged(z);
        }

        public void onAudioSinkError(Exception exc) {
            Log.e(DecoderAudioRenderer.TAG, "Audio sink error", exc);
            DecoderAudioRenderer.this.eventDispatcher.audioSinkError(exc);
        }
    }
}
