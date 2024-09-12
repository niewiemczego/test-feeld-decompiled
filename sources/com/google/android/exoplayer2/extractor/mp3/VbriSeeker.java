package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    public boolean isSeekable() {
        return true;
    }

    public static VbriSeeker create(long j, long j2, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i;
        long j3 = j;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i2 = header2.sampleRate;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp((long) readInt, 1000000 * ((long) (i2 >= 32000 ? 1152 : 576)), (long) i2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j4 = j2 + ((long) header2.frameSize);
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i3 = 0;
        long j5 = j2;
        while (i3 < readUnsignedShort) {
            int i4 = readUnsignedShort2;
            jArr[i3] = (((long) i3) * scaleLargeTimestamp) / ((long) readUnsignedShort);
            long j6 = j4;
            jArr2[i3] = Math.max(j5, j6);
            if (readUnsignedShort3 == 1) {
                i = parsableByteArray.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                i = parsableByteArray.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                i = parsableByteArray.readUnsignedInt24();
            } else if (readUnsignedShort3 != 4) {
                return null;
            } else {
                i = parsableByteArray.readUnsignedIntToInt();
            }
            long j7 = (long) i;
            int i5 = i4;
            j5 += j7 * ((long) i5);
            i3++;
            jArr = jArr;
            readUnsignedShort2 = i5;
            j4 = j6;
        }
        long[] jArr3 = jArr;
        if (!(j3 == -1 || j3 == j5)) {
            Log.w(TAG, "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new VbriSeeker(jArr3, jArr2, scaleLargeTimestamp, j5);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j, long j2) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
        this.dataEndPosition = j2;
    }

    public SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i], this.positions[i]));
    }

    public long getTimeUs(long j) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)];
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }
}
