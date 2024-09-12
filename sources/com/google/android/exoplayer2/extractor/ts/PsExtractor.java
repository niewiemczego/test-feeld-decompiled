package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.common.base.Ascii;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class PsExtractor implements Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final ExtractorsFactory FACTORY = new PsExtractor$$ExternalSyntheticLambda0();
    private static final long MAX_SEARCH_LENGTH = 1048576;
    private static final long MAX_SEARCH_LENGTH_AFTER_AUDIO_AND_VIDEO_FOUND = 8192;
    private static final int MAX_STREAM_ID_PLUS_ONE = 256;
    static final int MPEG_PROGRAM_END_CODE = 441;
    static final int PACKET_START_CODE_PREFIX = 1;
    static final int PACK_START_CODE = 442;
    public static final int PRIVATE_STREAM_1 = 189;
    static final int SYSTEM_HEADER_START_CODE = 443;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;
    private final PsDurationReader durationReader;
    private boolean foundAllTracks;
    private boolean foundAudioTrack;
    private boolean foundVideoTrack;
    private boolean hasOutputSeekMap;
    private long lastTrackPosition;
    private ExtractorOutput output;
    private PsBinarySearchSeeker psBinarySearchSeeker;
    private final ParsableByteArray psPacketBuffer;
    private final SparseArray<PesReader> psPayloadReaders;
    private final TimestampAdjuster timestampAdjuster;

    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new PsExtractor()};
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster2) {
        this.timestampAdjuster = timestampAdjuster2;
        this.psPacketBuffer = new ParsableByteArray(4096);
        this.psPayloadReaders = new SparseArray<>();
        this.durationReader = new PsDurationReader();
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (PACK_START_CODE != (((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << Ascii.DLE) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public void seek(long j, long j2) {
        boolean z = true;
        boolean z2 = this.timestampAdjuster.getTimestampOffsetUs() == C.TIME_UNSET;
        if (!z2) {
            long firstSampleTimestampUs = this.timestampAdjuster.getFirstSampleTimestampUs();
            if (firstSampleTimestampUs == C.TIME_UNSET || firstSampleTimestampUs == 0 || firstSampleTimestampUs == j2) {
                z = false;
            }
            z2 = z;
        }
        if (z2) {
            this.timestampAdjuster.reset(j2);
        }
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.psBinarySearchSeeker;
        if (psBinarySearchSeeker2 != null) {
            psBinarySearchSeeker2.setSeekTargetUs(j2);
        }
        for (int i = 0; i < this.psPayloadReaders.size(); i++) {
            this.psPayloadReaders.valueAt(i).seek();
        }
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.output);
        long length = extractorInput.getLength();
        int i = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if ((i != 0) && !this.durationReader.isDurationReadFinished()) {
            return this.durationReader.readDuration(extractorInput, positionHolder);
        }
        maybeOutputSeekMap(length);
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.psBinarySearchSeeker;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.isSeeking()) {
            return this.psBinarySearchSeeker.handlePendingSeek(extractorInput, positionHolder);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = i != 0 ? length - extractorInput.getPeekPosition() : -1;
        if ((peekPosition != -1 && peekPosition < 4) || !extractorInput.peekFully(this.psPacketBuffer.getData(), 0, 4, true)) {
            return -1;
        }
        this.psPacketBuffer.setPosition(0);
        int readInt = this.psPacketBuffer.readInt();
        if (readInt == MPEG_PROGRAM_END_CODE) {
            return -1;
        }
        if (readInt == PACK_START_CODE) {
            extractorInput.peekFully(this.psPacketBuffer.getData(), 0, 10);
            this.psPacketBuffer.setPosition(9);
            extractorInput.skipFully((this.psPacketBuffer.readUnsignedByte() & 7) + 14);
            return 0;
        } else if (readInt == SYSTEM_HEADER_START_CODE) {
            extractorInput.peekFully(this.psPacketBuffer.getData(), 0, 2);
            this.psPacketBuffer.setPosition(0);
            extractorInput.skipFully(this.psPacketBuffer.readUnsignedShort() + 6);
            return 0;
        } else if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        } else {
            int i2 = readInt & 255;
            PesReader pesReader = this.psPayloadReaders.get(i2);
            if (!this.foundAllTracks) {
                if (pesReader == null) {
                    ElementaryStreamReader elementaryStreamReader = null;
                    if (i2 == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.foundAudioTrack = true;
                        this.lastTrackPosition = extractorInput.getPosition();
                    } else if ((i2 & 224) == 192) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.foundAudioTrack = true;
                        this.lastTrackPosition = extractorInput.getPosition();
                    } else if ((i2 & VIDEO_STREAM_MASK) == 224) {
                        elementaryStreamReader = new H262Reader();
                        this.foundVideoTrack = true;
                        this.lastTrackPosition = extractorInput.getPosition();
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.createTracks(this.output, new TsPayloadReader.TrackIdGenerator(i2, 256));
                        pesReader = new PesReader(elementaryStreamReader, this.timestampAdjuster);
                        this.psPayloadReaders.put(i2, pesReader);
                    }
                }
                if (extractorInput.getPosition() > ((!this.foundAudioTrack || !this.foundVideoTrack) ? 1048576 : this.lastTrackPosition + 8192)) {
                    this.foundAllTracks = true;
                    this.output.endTracks();
                }
            }
            extractorInput.peekFully(this.psPacketBuffer.getData(), 0, 2);
            this.psPacketBuffer.setPosition(0);
            int readUnsignedShort = this.psPacketBuffer.readUnsignedShort() + 6;
            if (pesReader == null) {
                extractorInput.skipFully(readUnsignedShort);
            } else {
                this.psPacketBuffer.reset(readUnsignedShort);
                extractorInput.readFully(this.psPacketBuffer.getData(), 0, readUnsignedShort);
                this.psPacketBuffer.setPosition(6);
                pesReader.consume(this.psPacketBuffer);
                ParsableByteArray parsableByteArray = this.psPacketBuffer;
                parsableByteArray.setLimit(parsableByteArray.capacity());
            }
            return 0;
        }
    }

    @RequiresNonNull({"output"})
    private void maybeOutputSeekMap(long j) {
        if (!this.hasOutputSeekMap) {
            this.hasOutputSeekMap = true;
            if (this.durationReader.getDurationUs() != C.TIME_UNSET) {
                PsBinarySearchSeeker psBinarySearchSeeker2 = new PsBinarySearchSeeker(this.durationReader.getScrTimestampAdjuster(), this.durationReader.getDurationUs(), j);
                this.psBinarySearchSeeker = psBinarySearchSeeker2;
                this.output.seekMap(psBinarySearchSeeker2.getSeekMap());
                return;
            }
            this.output.seekMap(new SeekMap.Unseekable(this.durationReader.getDurationUs()));
        }
    }

    private static final class PesReader {
        private static final int PES_SCRATCH_SIZE = 64;
        private boolean dtsFlag;
        private int extendedHeaderLength;
        private final ElementaryStreamReader pesPayloadReader;
        private final ParsableBitArray pesScratch = new ParsableBitArray(new byte[64]);
        private boolean ptsFlag;
        private boolean seenFirstDts;
        private long timeUs;
        private final TimestampAdjuster timestampAdjuster;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster2) {
            this.pesPayloadReader = elementaryStreamReader;
            this.timestampAdjuster = timestampAdjuster2;
        }

        public void seek() {
            this.seenFirstDts = false;
            this.pesPayloadReader.seek();
        }

        public void consume(ParsableByteArray parsableByteArray) throws ParserException {
            parsableByteArray.readBytes(this.pesScratch.data, 0, 3);
            this.pesScratch.setPosition(0);
            parseHeader();
            parsableByteArray.readBytes(this.pesScratch.data, 0, this.extendedHeaderLength);
            this.pesScratch.setPosition(0);
            parseHeaderExtension();
            this.pesPayloadReader.packetStarted(this.timeUs, 4);
            this.pesPayloadReader.consume(parsableByteArray);
            this.pesPayloadReader.packetFinished();
        }

        private void parseHeader() {
            this.pesScratch.skipBits(8);
            this.ptsFlag = this.pesScratch.readBit();
            this.dtsFlag = this.pesScratch.readBit();
            this.pesScratch.skipBits(6);
            this.extendedHeaderLength = this.pesScratch.readBits(8);
        }

        private void parseHeaderExtension() {
            this.timeUs = 0;
            if (this.ptsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                long readBits = (((long) this.pesScratch.readBits(3)) << 30) | ((long) (this.pesScratch.readBits(15) << 15)) | ((long) this.pesScratch.readBits(15));
                this.pesScratch.skipBits(1);
                if (!this.seenFirstDts && this.dtsFlag) {
                    this.pesScratch.skipBits(4);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.pesScratch.skipBits(1);
                    this.timestampAdjuster.adjustTsTimestamp((((long) this.pesScratch.readBits(3)) << 30) | ((long) (this.pesScratch.readBits(15) << 15)) | ((long) this.pesScratch.readBits(15)));
                    this.seenFirstDts = true;
                }
                this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits);
            }
        }
    }
}
