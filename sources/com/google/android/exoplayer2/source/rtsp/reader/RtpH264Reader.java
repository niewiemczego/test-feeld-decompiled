package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class RtpH264Reader implements RtpPayloadReader {
    private static final int FU_PAYLOAD_OFFSET = 2;
    private static final long MEDIA_CLOCK_FREQUENCY = 90000;
    private static final int NAL_UNIT_TYPE_IDR = 5;
    private static final int RTP_PACKET_TYPE_FU_A = 28;
    private static final int RTP_PACKET_TYPE_STAP_A = 24;
    private static final String TAG = "RtpH264Reader";
    private int bufferFlags;
    private long firstReceivedTimestamp;
    private int fragmentedSampleSizeBytes;
    private final ParsableByteArray fuScratchBuffer;
    private final ParsableByteArray nalStartCodeArray = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    private static int getBufferFlagsFromNalType(int i) {
        return i == 5 ? 1 : 0;
    }

    public void onReceivingFirstPacket(long j, int i) {
    }

    public RtpH264Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
        this.fuScratchBuffer = new ParsableByteArray();
        this.firstReceivedTimestamp = C.TIME_UNSET;
        this.previousSequenceNumber = -1;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        ((TrackOutput) Util.castNonNull(track)).format(this.payloadFormat.format);
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) throws ParserException {
        int i2 = i;
        try {
            byte b = parsableByteArray.getData()[0] & Ascii.US;
            Assertions.checkStateNotNull(this.trackOutput);
            if (b > 0 && b < 24) {
                processSingleNalUnitPacket(parsableByteArray);
            } else if (b == 24) {
                processSingleTimeAggregationPacket(parsableByteArray);
            } else if (b == 28) {
                processFragmentationUnitPacket(parsableByteArray, i2);
            } else {
                throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", new Object[]{Integer.valueOf(b)}), (Throwable) null);
            }
            if (z) {
                if (this.firstReceivedTimestamp == C.TIME_UNSET) {
                    this.firstReceivedTimestamp = j;
                } else {
                    long j2 = j;
                }
                this.trackOutput.sampleMetadata(toSampleUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp), this.bufferFlags, this.fragmentedSampleSizeBytes, 0, (TrackOutput.CryptoData) null);
                this.fragmentedSampleSizeBytes = 0;
            }
            this.previousSequenceNumber = i2;
        } catch (IndexOutOfBoundsException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.fragmentedSampleSizeBytes = 0;
        this.startTimeOffsetUs = j2;
    }

    @RequiresNonNull({"trackOutput"})
    private void processSingleNalUnitPacket(ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        this.fragmentedSampleSizeBytes += writeStartCode();
        this.trackOutput.sampleData(parsableByteArray, bytesLeft);
        this.fragmentedSampleSizeBytes += bytesLeft;
        this.bufferFlags = getBufferFlagsFromNalType(parsableByteArray.getData()[0] & Ascii.US);
    }

    @RequiresNonNull({"trackOutput"})
    private void processSingleTimeAggregationPacket(ParsableByteArray parsableByteArray) {
        parsableByteArray.readUnsignedByte();
        while (parsableByteArray.bytesLeft() > 4) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            this.fragmentedSampleSizeBytes += writeStartCode();
            this.trackOutput.sampleData(parsableByteArray, readUnsignedShort);
            this.fragmentedSampleSizeBytes += readUnsignedShort;
        }
        this.bufferFlags = 0;
    }

    @RequiresNonNull({"trackOutput"})
    private void processFragmentationUnitPacket(ParsableByteArray parsableByteArray, int i) {
        byte b = parsableByteArray.getData()[0];
        byte b2 = parsableByteArray.getData()[1];
        byte b3 = (b & 224) | (b2 & Ascii.US);
        boolean z = (b2 & 128) > 0;
        boolean z2 = (b2 & SignedBytes.MAX_POWER_OF_TWO) > 0;
        if (z) {
            this.fragmentedSampleSizeBytes += writeStartCode();
            parsableByteArray.getData()[1] = (byte) b3;
            this.fuScratchBuffer.reset(parsableByteArray.getData());
            this.fuScratchBuffer.setPosition(1);
        } else {
            int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
            if (i != nextSequenceNumber) {
                Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
                return;
            } else {
                this.fuScratchBuffer.reset(parsableByteArray.getData());
                this.fuScratchBuffer.setPosition(2);
            }
        }
        int bytesLeft = this.fuScratchBuffer.bytesLeft();
        this.trackOutput.sampleData(this.fuScratchBuffer, bytesLeft);
        this.fragmentedSampleSizeBytes += bytesLeft;
        if (z2) {
            this.bufferFlags = getBufferFlagsFromNalType(b3 & Ascii.US);
        }
    }

    private int writeStartCode() {
        this.nalStartCodeArray.setPosition(0);
        int bytesLeft = this.nalStartCodeArray.bytesLeft();
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(this.nalStartCodeArray, bytesLeft);
        return bytesLeft;
    }

    private static long toSampleUs(long j, long j2, long j3) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000, MEDIA_CLOCK_FREQUENCY);
    }
}
