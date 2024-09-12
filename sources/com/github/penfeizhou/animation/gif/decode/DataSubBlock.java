package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;

public class DataSubBlock implements Block {
    public static final DataSubBlock sBlockTerminal = new DataSubBlock(0);
    private final int blockSize;
    private int offset;

    public DataSubBlock(int i) {
        this.blockSize = i;
    }

    public static DataSubBlock retrieve(GifReader gifReader) throws IOException {
        byte peek = gifReader.peek() & 255;
        if (peek == 0) {
            return sBlockTerminal;
        }
        DataSubBlock dataSubBlock = new DataSubBlock(peek);
        dataSubBlock.offset = gifReader.position();
        dataSubBlock.receive(gifReader);
        return dataSubBlock;
    }

    public void receive(GifReader gifReader) throws IOException {
        gifReader.skip((long) this.blockSize);
    }

    public int size() {
        return this.blockSize + 1;
    }

    public boolean isTerminal() {
        return this == sBlockTerminal;
    }
}
