package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.SignedBytes;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class RtpH265Reader implements RtpPayloadReader {
    private static final int FU_PAYLOAD_OFFSET = 3;
    private static final long MEDIA_CLOCK_FREQUENCY = 90000;
    private static final int NAL_IDR_N_LP = 20;
    private static final int NAL_IDR_W_RADL = 19;
    private static final int RTP_PACKET_TYPE_AP = 48;
    private static final int RTP_PACKET_TYPE_FU = 49;
    private static final String TAG = "RtpH265Reader";
    private int bufferFlags;
    private long firstReceivedTimestamp;
    private int fragmentedSampleSizeBytes;
    private final ParsableByteArray fuScratchBuffer = new ParsableByteArray();
    private final ParsableByteArray nalStartCodeArray = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    private static int getBufferFlagsFromNalType(int i) {
        return (i == 19 || i == 20) ? 1 : 0;
    }

    public void onReceivingFirstPacket(long j, int i) {
    }

    public RtpH265Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
        this.firstReceivedTimestamp = C.TIME_UNSET;
        this.previousSequenceNumber = -1;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) throws ParserException {
        int i2 = i;
        if (parsableByteArray.getData().length != 0) {
            int i3 = (parsableByteArray.getData()[0] >> 1) & 63;
            Assertions.checkStateNotNull(this.trackOutput);
            if (i3 >= 0 && i3 < 48) {
                processSingleNalUnitPacket(parsableByteArray);
            } else if (i3 == 48) {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            } else if (i3 == 49) {
                processFragmentationUnitPacket(parsableByteArray, i2);
            } else {
                throw ParserException.createForMalformedManifest(String.format("RTP H265 payload type [%d] not supported.", new Object[]{Integer.valueOf(i3)}), (Throwable) null);
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
            return;
        }
        throw ParserException.createForMalformedManifest("Empty RTP data packet.", (Throwable) null);
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
        this.bufferFlags = getBufferFlagsFromNalType((parsableByteArray.getData()[0] >> 1) & 63);
    }

    @RequiresNonNull({"trackOutput"})
    private void processFragmentationUnitPacket(ParsableByteArray parsableByteArray, int i) throws ParserException {
        if (parsableByteArray.getData().length >= 3) {
            byte b = parsableByteArray.getData()[1] & 7;
            byte b2 = parsableByteArray.getData()[2];
            byte b3 = b2 & Utf8.REPLACEMENT_BYTE;
            boolean z = (b2 & 128) > 0;
            boolean z2 = (b2 & SignedBytes.MAX_POWER_OF_TWO) > 0;
            if (z) {
                this.fragmentedSampleSizeBytes += writeStartCode();
                parsableByteArray.getData()[1] = (byte) ((b3 << 1) & 127);
                parsableByteArray.getData()[2] = (byte) b;
                this.fuScratchBuffer.reset(parsableByteArray.getData());
                this.fuScratchBuffer.setPosition(1);
            } else {
                int i2 = (this.previousSequenceNumber + 1) % 65535;
                if (i != i2) {
                    Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i2), Integer.valueOf(i)));
                    return;
                } else {
                    this.fuScratchBuffer.reset(parsableByteArray.getData());
                    this.fuScratchBuffer.setPosition(3);
                }
            }
            int bytesLeft = this.fuScratchBuffer.bytesLeft();
            this.trackOutput.sampleData(this.fuScratchBuffer, bytesLeft);
            this.fragmentedSampleSizeBytes += bytesLeft;
            if (z2) {
                this.bufferFlags = getBufferFlagsFromNalType(b3);
                return;
            }
            return;
        }
        throw ParserException.createForMalformedManifest("Malformed FU header.", (Throwable) null);
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
