package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import java.io.IOException;

class FCTLChunk extends Chunk {
    static final int APNG_BLEND_OP_OVER = 1;
    static final int APNG_BLEND_OP_SOURCE = 0;
    static final int APNG_DISPOSE_OP_BACKGROUND = 1;
    static final int APNG_DISPOSE_OP_NON = 0;
    static final int APNG_DISPOSE_OP_PREVIOUS = 2;
    static final int ID = Chunk.fourCCToInt("fcTL");
    byte blend_op;
    short delay_den;
    short delay_num;
    byte dispose_op;
    int height;
    int sequence_number;
    int width;
    int x_offset;
    int y_offset;

    FCTLChunk() {
    }

    /* access modifiers changed from: package-private */
    public void innerParse(APNGReader aPNGReader) throws IOException {
        this.sequence_number = aPNGReader.readInt();
        this.width = aPNGReader.readInt();
        this.height = aPNGReader.readInt();
        this.x_offset = aPNGReader.readInt();
        this.y_offset = aPNGReader.readInt();
        this.delay_num = aPNGReader.readShort();
        this.delay_den = aPNGReader.readShort();
        this.dispose_op = aPNGReader.peek();
        this.blend_op = aPNGReader.peek();
    }
}
