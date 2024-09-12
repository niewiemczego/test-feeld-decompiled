package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public class SubtitleExtractor implements Extractor {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int STATE_CREATED = 0;
    private static final int STATE_EXTRACTING = 2;
    private static final int STATE_FINISHED = 4;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 5;
    private static final int STATE_SEEKING = 3;
    private int bytesRead;
    private final CueEncoder cueEncoder = new CueEncoder();
    private ExtractorOutput extractorOutput;
    private final Format format;
    private final List<ParsableByteArray> samples;
    private long seekTimeUs;
    private int state;
    private final ParsableByteArray subtitleData = new ParsableByteArray();
    private final SubtitleDecoder subtitleDecoder;
    private final List<Long> timestamps;
    private TrackOutput trackOutput;

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return true;
    }

    public SubtitleExtractor(SubtitleDecoder subtitleDecoder2, Format format2) {
        this.subtitleDecoder = subtitleDecoder2;
        this.format = format2.buildUpon().setSampleMimeType(MimeTypes.TEXT_EXOPLAYER_CUES).setCodecs(format2.sampleMimeType).build();
        this.timestamps = new ArrayList();
        this.samples = new ArrayList();
        this.state = 0;
        this.seekTimeUs = C.TIME_UNSET;
    }

    public void init(ExtractorOutput extractorOutput2) {
        Assertions.checkState(this.state == 0);
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 3);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new IndexSeekMap(new long[]{0}, new long[]{0}, C.TIME_UNSET));
        this.trackOutput.format(this.format);
        this.state = 1;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i = this.state;
        Assertions.checkState((i == 0 || i == 5) ? false : true);
        if (this.state == 1) {
            this.subtitleData.reset(extractorInput.getLength() != -1 ? Ints.checkedCast(extractorInput.getLength()) : 1024);
            this.bytesRead = 0;
            this.state = 2;
        }
        if (this.state == 2 && readFromInput(extractorInput)) {
            decode();
            writeToOutput();
            this.state = 4;
        }
        if (this.state == 3 && skipInput(extractorInput)) {
            writeToOutput();
            this.state = 4;
        }
        if (this.state == 4) {
            return -1;
        }
        return 0;
    }

    public void seek(long j, long j2) {
        int i = this.state;
        Assertions.checkState((i == 0 || i == 5) ? false : true);
        this.seekTimeUs = j2;
        if (this.state == 2) {
            this.state = 1;
        }
        if (this.state == 4) {
            this.state = 3;
        }
    }

    public void release() {
        if (this.state != 5) {
            this.subtitleDecoder.release();
            this.state = 5;
        }
    }

    private boolean skipInput(ExtractorInput extractorInput) throws IOException {
        return extractorInput.skip((extractorInput.getLength() > -1 ? 1 : (extractorInput.getLength() == -1 ? 0 : -1)) != 0 ? Ints.checkedCast(extractorInput.getLength()) : 1024) == -1;
    }

    private boolean readFromInput(ExtractorInput extractorInput) throws IOException {
        int capacity = this.subtitleData.capacity();
        int i = this.bytesRead;
        if (capacity == i) {
            this.subtitleData.ensureCapacity(i + 1024);
        }
        int read = extractorInput.read(this.subtitleData.getData(), this.bytesRead, this.subtitleData.capacity() - this.bytesRead);
        if (read != -1) {
            this.bytesRead += read;
        }
        long length = extractorInput.getLength();
        return (length != -1 && ((long) this.bytesRead) == length) || read == -1;
    }

    private void decode() throws IOException {
        try {
            SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) this.subtitleDecoder.dequeueInputBuffer();
            while (subtitleInputBuffer == null) {
                Thread.sleep(5);
                subtitleInputBuffer = (SubtitleInputBuffer) this.subtitleDecoder.dequeueInputBuffer();
            }
            subtitleInputBuffer.ensureSpaceForWrite(this.bytesRead);
            subtitleInputBuffer.data.put(this.subtitleData.getData(), 0, this.bytesRead);
            subtitleInputBuffer.data.limit(this.bytesRead);
            this.subtitleDecoder.queueInputBuffer(subtitleInputBuffer);
            SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) this.subtitleDecoder.dequeueOutputBuffer();
            while (subtitleOutputBuffer == null) {
                Thread.sleep(5);
                subtitleOutputBuffer = (SubtitleOutputBuffer) this.subtitleDecoder.dequeueOutputBuffer();
            }
            for (int i = 0; i < subtitleOutputBuffer.getEventTimeCount(); i++) {
                byte[] encode = this.cueEncoder.encode(subtitleOutputBuffer.getCues(subtitleOutputBuffer.getEventTime(i)));
                this.timestamps.add(Long.valueOf(subtitleOutputBuffer.getEventTime(i)));
                this.samples.add(new ParsableByteArray(encode));
            }
            subtitleOutputBuffer.release();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        }
    }

    private void writeToOutput() {
        int i;
        Assertions.checkStateNotNull(this.trackOutput);
        Assertions.checkState(this.timestamps.size() == this.samples.size());
        long j = this.seekTimeUs;
        if (j == C.TIME_UNSET) {
            i = 0;
        } else {
            i = Util.binarySearchFloor(this.timestamps, Long.valueOf(j), true, true);
        }
        while (i < this.samples.size()) {
            ParsableByteArray parsableByteArray = this.samples.get(i);
            parsableByteArray.setPosition(0);
            int length = parsableByteArray.getData().length;
            this.trackOutput.sampleData(parsableByteArray, length);
            this.trackOutput.sampleMetadata(this.timestamps.get(i).longValue(), 1, length, 0, (TrackOutput.CryptoData) null);
            i++;
        }
    }
}
