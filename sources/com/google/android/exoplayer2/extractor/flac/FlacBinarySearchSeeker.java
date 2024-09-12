package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import java.io.IOException;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlacBinarySearchSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata r17, int r18, long r19, long r21) {
        /*
            r16 = this;
            r0 = r17
            java.util.Objects.requireNonNull(r17)
            com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$$ExternalSyntheticLambda0 r1 = new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$$ExternalSyntheticLambda0
            r1.<init>(r0)
            com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker r2 = new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.getDurationUs()
            long r7 = r0.totalSamples
            long r13 = r17.getApproxBytesPerFrame()
            int r0 = r0.minFrameSize
            r5 = 6
            int r15 = java.lang.Math.max(r5, r0)
            r5 = 0
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, long, long):void");
    }

    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final FlacStreamMetadata flacStreamMetadata;
        private final int frameStartMarker;
        private final FlacFrameReader.SampleNumberHolder sampleNumberHolder;

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata2, int i) {
            this.flacStreamMetadata = flacStreamMetadata2;
            this.frameStartMarker = i;
            this.sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
        }

        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long findNextFrame = findNextFrame(extractorInput);
            long peekPosition = extractorInput.getPeekPosition();
            extractorInput.advancePeekPosition(Math.max(6, this.flacStreamMetadata.minFrameSize));
            long findNextFrame2 = findNextFrame(extractorInput);
            long peekPosition2 = extractorInput.getPeekPosition();
            if (findNextFrame <= j && findNextFrame2 > j) {
                return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
            }
            if (findNextFrame2 <= j) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(findNextFrame2, peekPosition2);
            }
            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(findNextFrame, position);
        }

        private long findNextFrame(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.getPeekPosition() < extractorInput.getLength() - 6 && !FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                extractorInput.advancePeekPosition(1);
            }
            if (extractorInput.getPeekPosition() < extractorInput.getLength() - 6) {
                return this.sampleNumberHolder.sampleNumber;
            }
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return this.flacStreamMetadata.totalSamples;
        }
    }
}
