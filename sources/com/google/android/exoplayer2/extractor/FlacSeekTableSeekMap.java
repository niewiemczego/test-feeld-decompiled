package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class FlacSeekTableSeekMap implements SeekMap {
    private final long firstFrameOffset;
    private final FlacStreamMetadata flacStreamMetadata;

    public boolean isSeekable() {
        return true;
    }

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata2, long j) {
        this.flacStreamMetadata = flacStreamMetadata2;
        this.firstFrameOffset = j;
    }

    public long getDurationUs() {
        return this.flacStreamMetadata.getDurationUs();
    }

    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2;
        Assertions.checkStateNotNull(this.flacStreamMetadata.seekTable);
        long[] jArr = this.flacStreamMetadata.seekTable.pointSampleNumbers;
        long[] jArr2 = this.flacStreamMetadata.seekTable.pointOffsets;
        int binarySearchFloor = Util.binarySearchFloor(jArr, this.flacStreamMetadata.getSampleNumber(j), true, false);
        long j3 = 0;
        if (binarySearchFloor == -1) {
            j2 = 0;
        } else {
            j2 = jArr[binarySearchFloor];
        }
        if (binarySearchFloor != -1) {
            j3 = jArr2[binarySearchFloor];
        }
        SeekPoint seekPoint = getSeekPoint(j2, j3);
        if (seekPoint.timeUs == j || binarySearchFloor == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, getSeekPoint(jArr[i], jArr2[i]));
    }

    private SeekPoint getSeekPoint(long j, long j2) {
        return new SeekPoint((j * 1000000) / ((long) this.flacStreamMetadata.sampleRate), this.firstFrameOffset + j2);
    }
}
