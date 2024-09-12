package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        long readUint;
        int i;
        long length = extractorInput.getLength();
        int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        long j = 1024;
        if (i2 != 0 && length <= 1024) {
            j = length;
        }
        int i3 = (int) j;
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i4 = this.peekLength + 1;
            this.peekLength = i4;
            if (i4 == i3) {
                return false;
            }
            extractorInput.peekFully(this.scratch.getData(), 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & -256) | ((long) (this.scratch.getData()[0] & 255));
        }
        long readUint2 = readUint(extractorInput);
        long j2 = (long) this.peekLength;
        if (readUint2 == Long.MIN_VALUE) {
            return false;
        }
        if (i2 != 0 && j2 + readUint2 >= length) {
            return false;
        }
        while (true) {
            int i5 = this.peekLength;
            long j3 = j2 + readUint2;
            if (((long) i5) < j3) {
                if (readUint(extractorInput) != Long.MIN_VALUE && readUint >= 0 && readUint <= 2147483647L) {
                    if (i != 0) {
                        int readUint3 = (int) (readUint = readUint(extractorInput));
                        extractorInput.advancePeekPosition(readUint3);
                        this.peekLength += readUint3;
                    }
                }
            } else if (((long) i5) == j3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private long readUint(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.peekFully(this.scratch.getData(), 0, 1);
        byte b = this.scratch.getData()[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (~i2);
        extractorInput.peekFully(this.scratch.getData(), 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.scratch.getData()[i] & 255) + (i4 << 8);
        }
        this.peekLength += i3 + 1;
        return (long) i4;
    }
}
