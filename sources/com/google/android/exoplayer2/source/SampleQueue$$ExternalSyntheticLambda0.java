package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SampleQueue$$ExternalSyntheticLambda0 implements Consumer {
    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
    }
}
