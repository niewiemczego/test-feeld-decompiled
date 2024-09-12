package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CeaDecoder$$ExternalSyntheticLambda0 implements DecoderOutputBuffer.Owner {
    public final /* synthetic */ CeaDecoder f$0;

    public /* synthetic */ CeaDecoder$$ExternalSyntheticLambda0(CeaDecoder ceaDecoder) {
        this.f$0 = ceaDecoder;
    }

    public final void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
        this.f$0.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
    }
}
