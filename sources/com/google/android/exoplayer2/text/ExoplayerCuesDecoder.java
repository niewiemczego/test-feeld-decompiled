package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class ExoplayerCuesDecoder implements SubtitleDecoder {
    private static final int INPUT_BUFFER_AVAILABLE = 0;
    private static final int INPUT_BUFFER_DEQUEUED = 1;
    private static final int INPUT_BUFFER_QUEUED = 2;
    private static final int OUTPUT_BUFFERS_COUNT = 2;
    private final Deque<SubtitleOutputBuffer> availableOutputBuffers = new ArrayDeque();
    private final CueDecoder cueDecoder = new CueDecoder();
    private final SubtitleInputBuffer inputBuffer = new SubtitleInputBuffer();
    private int inputBufferState;
    private boolean released;

    public String getName() {
        return "ExoplayerCuesDecoder";
    }

    public void setPositionUs(long j) {
    }

    public ExoplayerCuesDecoder() {
        for (int i = 0; i < 2; i++) {
            this.availableOutputBuffers.addFirst(new SubtitleOutputBuffer() {
                public void release() {
                    ExoplayerCuesDecoder.this.releaseOutputBuffer(this);
                }
            });
        }
        this.inputBufferState = 0;
    }

    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(!this.released);
        if (this.inputBufferState != 0) {
            return null;
        }
        this.inputBufferState = 1;
        return this.inputBuffer;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        boolean z = true;
        Assertions.checkState(!this.released);
        Assertions.checkState(this.inputBufferState == 1);
        if (this.inputBuffer != subtitleInputBuffer) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.inputBufferState = 2;
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(!this.released);
        if (this.inputBufferState != 2 || this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer removeFirst = this.availableOutputBuffers.removeFirst();
        if (this.inputBuffer.isEndOfStream()) {
            removeFirst.addFlag(4);
        } else {
            SingleEventSubtitle singleEventSubtitle = new SingleEventSubtitle(this.inputBuffer.timeUs, this.cueDecoder.decode(((ByteBuffer) Assertions.checkNotNull(this.inputBuffer.data)).array()));
            removeFirst.setContent(this.inputBuffer.timeUs, singleEventSubtitle, 0);
        }
        this.inputBuffer.clear();
        this.inputBufferState = 0;
        return removeFirst;
    }

    public void flush() {
        Assertions.checkState(!this.released);
        this.inputBuffer.clear();
        this.inputBufferState = 0;
    }

    public void release() {
        this.released = true;
    }

    /* access modifiers changed from: private */
    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        Assertions.checkState(this.availableOutputBuffers.size() < 2);
        Assertions.checkArgument(!this.availableOutputBuffers.contains(subtitleOutputBuffer));
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.addFirst(subtitleOutputBuffer);
    }

    private static final class SingleEventSubtitle implements Subtitle {
        private final ImmutableList<Cue> cues;
        private final long timeUs;

        public int getEventTimeCount() {
            return 1;
        }

        public SingleEventSubtitle(long j, ImmutableList<Cue> immutableList) {
            this.timeUs = j;
            this.cues = immutableList;
        }

        public int getNextEventTimeIndex(long j) {
            return this.timeUs > j ? 0 : -1;
        }

        public long getEventTime(int i) {
            Assertions.checkArgument(i == 0);
            return this.timeUs;
        }

        public List<Cue> getCues(long j) {
            return j >= this.timeUs ? this.cues : ImmutableList.of();
        }
    }
}
