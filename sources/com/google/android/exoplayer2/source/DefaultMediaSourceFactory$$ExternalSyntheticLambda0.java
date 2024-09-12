package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultMediaSourceFactory$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public final /* synthetic */ Format f$0;

    public /* synthetic */ DefaultMediaSourceFactory$$ExternalSyntheticLambda0(Format format) {
        this.f$0 = format;
    }

    public final Extractor[] createExtractors() {
        return DefaultMediaSourceFactory.lambda$createMediaSource$0(this.f$0);
    }
}
