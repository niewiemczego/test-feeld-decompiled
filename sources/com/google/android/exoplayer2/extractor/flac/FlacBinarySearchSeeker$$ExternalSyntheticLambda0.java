package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FlacBinarySearchSeeker$$ExternalSyntheticLambda0 implements BinarySearchSeeker.SeekTimestampConverter {
    public final /* synthetic */ FlacStreamMetadata f$0;

    public /* synthetic */ FlacBinarySearchSeeker$$ExternalSyntheticLambda0(FlacStreamMetadata flacStreamMetadata) {
        this.f$0 = flacStreamMetadata;
    }

    public final long timeUsToTargetTime(long j) {
        return this.f$0.getSampleNumber(j);
    }
}
