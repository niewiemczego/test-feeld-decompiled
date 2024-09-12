package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int position = parsableByteArray.getPosition();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt >>> 16;
        if (j != ((long) i)) {
            return false;
        }
        boolean z = (j & 1) == 1;
        int i2 = (int) ((readUnsignedInt >> 12) & 15);
        int i3 = (int) ((readUnsignedInt >> 8) & 15);
        int i4 = (int) ((readUnsignedInt >> 4) & 15);
        int i5 = (int) ((readUnsignedInt >> 1) & 7);
        boolean z2 = (readUnsignedInt & 1) == 1;
        if (!checkChannelAssignment(i4, flacStreamMetadata2) || !checkBitsPerSample(i5, flacStreamMetadata2) || z2 || !checkAndReadFirstSampleNumber(parsableByteArray2, flacStreamMetadata2, z, sampleNumberHolder) || !checkAndReadBlockSizeSamples(parsableByteArray2, flacStreamMetadata2, i2) || !checkAndReadSampleRate(parsableByteArray2, flacStreamMetadata2, i3) || !checkAndReadCrc(parsableByteArray2, position)) {
            return false;
        }
        return true;
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) throws IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.resetPeekPosition();
        boolean z = true;
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        extractorInput.advancePeekPosition(2);
        int i = z ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 0, i));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, z, sampleNumberHolder)) {
            return sampleNumberHolder.sampleNumber;
        }
        throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean checkChannelAssignment(int i, FlacStreamMetadata flacStreamMetadata) {
        if (i <= 7) {
            return i == flacStreamMetadata.channels - 1;
        }
        if (i > 10 || flacStreamMetadata.channels != 2) {
            return false;
        }
        return true;
    }

    private static boolean checkBitsPerSample(int i, FlacStreamMetadata flacStreamMetadata) {
        return i == 0 || i == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z, SampleNumberHolder sampleNumberHolder) {
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                readUtf8EncodedLong *= (long) flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int readFrameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        return readFrameBlockSizeSamplesFromKey != -1 && readFrameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int i2 = flacStreamMetadata.sampleRate;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            if (i == flacStreamMetadata.sampleRateLookupKey) {
                return true;
            }
            return false;
        } else if (i == 12) {
            if (parsableByteArray.readUnsignedByte() * 1000 == i2) {
                return true;
            }
            return false;
        } else if (i > 14) {
            return false;
        } else {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (i == 14) {
                readUnsignedShort *= 10;
            }
            if (readUnsignedShort == i2) {
                return true;
            }
            return false;
        }
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray, int i) {
        return parsableByteArray.readUnsignedByte() == Util.crc8(parsableByteArray.getData(), i, parsableByteArray.getPosition() - 1, 0);
    }

    private FlacFrameReader() {
    }
}
