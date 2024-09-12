package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import java.io.IOException;

class FDATChunk extends Chunk {
    static final int ID = Chunk.fourCCToInt("fdAT");
    int sequence_number;

    FDATChunk() {
    }

    /* access modifiers changed from: package-private */
    public void innerParse(APNGReader aPNGReader) throws IOException {
        this.sequence_number = aPNGReader.readInt();
    }
}
