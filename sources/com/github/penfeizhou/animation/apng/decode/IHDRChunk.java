package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import java.io.IOException;

class IHDRChunk extends Chunk {
    static final int ID = Chunk.fourCCToInt("IHDR");
    byte[] data = new byte[5];
    int height;
    int width;

    IHDRChunk() {
    }

    /* access modifiers changed from: package-private */
    public void innerParse(APNGReader aPNGReader) throws IOException {
        this.width = aPNGReader.readInt();
        this.height = aPNGReader.readInt();
        byte[] bArr = this.data;
        aPNGReader.read(bArr, 0, bArr.length);
    }
}
