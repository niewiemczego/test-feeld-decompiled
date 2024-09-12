package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public final class EmptySampleStream implements SampleStream {
    public boolean isReady() {
        return true;
    }

    public void maybeThrowError() {
    }

    public int skipData(long j) {
        return 0;
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
