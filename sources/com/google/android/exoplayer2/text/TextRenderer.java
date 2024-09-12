package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private long finalStreamEndPositionUs;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;
    private boolean waitingForKeyFrame;

    public String getName() {
        return TAG;
    }

    public boolean isReady() {
        return true;
    }

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.output = (TextOutput) Assertions.checkNotNull(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
        this.finalStreamEndPositionUs = C.TIME_UNSET;
    }

    public int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return RendererCapabilities.create(format.cryptoType == 0 ? 4 : 2);
        } else if (MimeTypes.isText(format.sampleMimeType)) {
            return RendererCapabilities.create(1);
        } else {
            return RendererCapabilities.create(0);
        }
    }

    public void setFinalStreamEndPositionUs(long j) {
        Assertions.checkState(isCurrentStreamFinal());
        this.finalStreamEndPositionUs = j;
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.streamFormat = formatArr[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            initDecoder();
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
            return;
        }
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).flush();
    }

    public void render(long j, long j2) {
        boolean z;
        if (isCurrentStreamFinal()) {
            long j3 = this.finalStreamEndPositionUs;
            if (j3 != C.TIME_UNSET && j >= j3) {
                releaseBuffers();
                this.outputStreamEnded = true;
            }
        }
        if (!this.outputStreamEnded) {
            if (this.nextSubtitle == null) {
                ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).setPositionUs(j);
                try {
                    this.nextSubtitle = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueOutputBuffer();
                } catch (SubtitleDecoderException e) {
                    handleDecoderError(e);
                    return;
                }
            }
            if (getState() == 2) {
                if (this.subtitle != null) {
                    long nextEventTime = getNextEventTime();
                    z = false;
                    while (nextEventTime <= j) {
                        this.nextSubtitleEventIndex++;
                        nextEventTime = getNextEventTime();
                        z = true;
                    }
                } else {
                    z = false;
                }
                SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
                if (subtitleOutputBuffer != null) {
                    if (subtitleOutputBuffer.isEndOfStream()) {
                        if (!z && getNextEventTime() == Long.MAX_VALUE) {
                            if (this.decoderReplacementState == 2) {
                                replaceDecoder();
                            } else {
                                releaseBuffers();
                                this.outputStreamEnded = true;
                            }
                        }
                    } else if (subtitleOutputBuffer.timeUs <= j) {
                        SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                        if (subtitleOutputBuffer2 != null) {
                            subtitleOutputBuffer2.release();
                        }
                        this.nextSubtitleEventIndex = subtitleOutputBuffer.getNextEventTimeIndex(j);
                        this.subtitle = subtitleOutputBuffer;
                        this.nextSubtitle = null;
                        z = true;
                    }
                }
                if (z) {
                    Assertions.checkNotNull(this.subtitle);
                    updateOutput(this.subtitle.getCues(j));
                }
                if (this.decoderReplacementState != 2) {
                    while (!this.inputStreamEnded) {
                        try {
                            SubtitleInputBuffer subtitleInputBuffer = this.nextInputBuffer;
                            if (subtitleInputBuffer == null) {
                                subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).dequeueInputBuffer();
                                if (subtitleInputBuffer != null) {
                                    this.nextInputBuffer = subtitleInputBuffer;
                                } else {
                                    return;
                                }
                            }
                            if (this.decoderReplacementState == 1) {
                                subtitleInputBuffer.setFlags(4);
                                ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                                this.nextInputBuffer = null;
                                this.decoderReplacementState = 2;
                                return;
                            }
                            int readSource = readSource(this.formatHolder, subtitleInputBuffer, 0);
                            if (readSource == -4) {
                                if (subtitleInputBuffer.isEndOfStream()) {
                                    this.inputStreamEnded = true;
                                    this.waitingForKeyFrame = false;
                                } else {
                                    Format format = this.formatHolder.format;
                                    if (format != null) {
                                        subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                                        subtitleInputBuffer.flip();
                                        this.waitingForKeyFrame &= !subtitleInputBuffer.isKeyFrame();
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.waitingForKeyFrame) {
                                    ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(subtitleInputBuffer);
                                    this.nextInputBuffer = null;
                                }
                            } else if (readSource == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e2) {
                            handleDecoderError(e2);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.streamFormat = null;
        this.finalStreamEndPositionUs = C.TIME_UNSET;
        clearOutput();
        releaseDecoder();
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        ((SubtitleDecoder) Assertions.checkNotNull(this.decoder)).release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void initDecoder() {
        this.waitingForKeyFrame = true;
        this.decoder = this.decoderFactory.createDecoder((Format) Assertions.checkNotNull(this.streamFormat));
    }

    private void replaceDecoder() {
        releaseDecoder();
        initDecoder();
    }

    private long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.subtitle);
        if (this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    private void updateOutput(List<Cue> list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    private void clearOutput() {
        updateOutput(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeUpdateOutputInternal((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    private void invokeUpdateOutputInternal(List<Cue> list) {
        this.output.onCues(list);
        this.output.onCues(new CueGroup(list));
    }

    private void handleDecoderError(SubtitleDecoderException subtitleDecoderException) {
        Log.e(TAG, "Subtitle decoding failed. streamFormat=" + this.streamFormat, subtitleDecoderException);
        clearOutput();
        replaceDecoder();
    }
}
