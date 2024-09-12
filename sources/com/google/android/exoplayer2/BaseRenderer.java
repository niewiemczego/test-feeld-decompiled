package com.google.android.exoplayer2;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private final FormatHolder formatHolder = new FormatHolder();
    private int index;
    private long lastResetPositionUs;
    private PlayerId playerId;
    private long readingPositionUs = Long.MIN_VALUE;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private boolean throwRendererExceptionIsExecuting;
    private final int trackType;

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j, long j2) throws ExoPlaybackException {
    }

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public BaseRenderer(int i) {
        this.trackType = i;
    }

    public final int getTrackType() {
        return this.trackType;
    }

    public final void init(int i, PlayerId playerId2) {
        this.index = i;
        this.playerId = playerId2;
    }

    public final int getState() {
        return this.state;
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        boolean z3 = z;
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z, z2);
        replaceStream(formatArr, sampleStream, j2, j3);
        long j4 = j;
        resetPosition(j, z);
    }

    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        if (this.readingPositionUs == Long.MIN_VALUE) {
            this.readingPositionUs = j;
        }
        this.streamFormats = formatArr;
        this.streamOffsetUs = j2;
        onStreamChanged(formatArr, j, j2);
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    public final long getReadingPositionUs() {
        return this.readingPositionUs;
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public final void maybeThrowStreamError() throws IOException {
        ((SampleStream) Assertions.checkNotNull(this.stream)).maybeThrowError();
    }

    public final void resetPosition(long j) throws ExoPlaybackException {
        resetPosition(j, false);
    }

    private void resetPosition(long j, boolean z) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.lastResetPositionUs = j;
        this.readingPositionUs = j;
        onPositionReset(j, z);
    }

    public final void stop() {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        Assertions.checkState(z);
        this.formatHolder.clear();
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void reset() {
        Assertions.checkState(this.state == 0);
        this.formatHolder.clear();
        onReset();
    }

    /* access modifiers changed from: protected */
    public final long getLastResetPositionUs() {
        return this.lastResetPositionUs;
    }

    /* access modifiers changed from: protected */
    public final FormatHolder getFormatHolder() {
        this.formatHolder.clear();
        return this.formatHolder;
    }

    /* access modifiers changed from: protected */
    public final Format[] getStreamFormats() {
        return (Format[]) Assertions.checkNotNull(this.streamFormats);
    }

    /* access modifiers changed from: protected */
    public final RendererConfiguration getConfiguration() {
        return (RendererConfiguration) Assertions.checkNotNull(this.configuration);
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final PlayerId getPlayerId() {
        return (PlayerId) Assertions.checkNotNull(this.playerId);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException createRendererException(Throwable th, Format format, int i) {
        return createRendererException(th, format, false, i);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException createRendererException(Throwable th, Format format, boolean z, int i) {
        int i2;
        if (format != null && !this.throwRendererExceptionIsExecuting) {
            this.throwRendererExceptionIsExecuting = true;
            try {
                i2 = RendererCapabilities.getFormatSupport(supportsFormat(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.throwRendererExceptionIsExecuting = false;
            }
            return ExoPlaybackException.createForRenderer(th, getName(), getIndex(), format, i2, z, i);
        }
        i2 = 4;
        return ExoPlaybackException.createForRenderer(th, getName(), getIndex(), format, i2, z, i);
    }

    /* access modifiers changed from: protected */
    public final int readSource(FormatHolder formatHolder2, DecoderInputBuffer decoderInputBuffer, int i) {
        int readData = ((SampleStream) Assertions.checkNotNull(this.stream)).readData(formatHolder2, decoderInputBuffer, i);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.readingPositionUs = Long.MIN_VALUE;
                if (this.streamIsFinal) {
                    return -4;
                }
                return -3;
            }
            decoderInputBuffer.timeUs += this.streamOffsetUs;
            this.readingPositionUs = Math.max(this.readingPositionUs, decoderInputBuffer.timeUs);
        } else if (readData == -5) {
            Format format = (Format) Assertions.checkNotNull(formatHolder2.format);
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder2.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.streamOffsetUs).build();
            }
        }
        return readData;
    }

    /* access modifiers changed from: protected */
    public int skipSource(long j) {
        return ((SampleStream) Assertions.checkNotNull(this.stream)).skipData(j - this.streamOffsetUs);
    }

    /* access modifiers changed from: protected */
    public final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.streamIsFinal : ((SampleStream) Assertions.checkNotNull(this.stream)).isReady();
    }
}
