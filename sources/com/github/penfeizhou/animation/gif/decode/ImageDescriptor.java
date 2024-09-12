package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;

public class ImageDescriptor implements Block {
    private byte flag;
    public int frameHeight;
    public int frameWidth;
    public int frameX;
    public int frameY;
    public int imageDataOffset;
    public ColorTable localColorTable;
    public int lzwMinimumCodeSize;

    public int size() {
        return 0;
    }

    public void receive(GifReader gifReader) throws IOException {
        this.frameX = gifReader.readUInt16();
        this.frameY = gifReader.readUInt16();
        this.frameWidth = gifReader.readUInt16();
        this.frameHeight = gifReader.readUInt16();
        this.flag = gifReader.peek();
        if (localColorTableFlag()) {
            ColorTable colorTable = new ColorTable(localColorTableSize());
            this.localColorTable = colorTable;
            colorTable.receive(gifReader);
        }
        this.lzwMinimumCodeSize = gifReader.peek() & 255;
        this.imageDataOffset = gifReader.position();
        while (true) {
            byte peek = gifReader.peek();
            if (peek != 0) {
                gifReader.skip((long) (peek & 255));
            } else {
                return;
            }
        }
    }

    public boolean localColorTableFlag() {
        return (this.flag & 128) == 128;
    }

    public boolean interlaceFlag() {
        return (this.flag & SignedBytes.MAX_POWER_OF_TWO) == 64;
    }

    public boolean sortFlag() {
        return (this.flag & 32) == 32;
    }

    public int localColorTableSize() {
        return 2 << (this.flag & Ascii.SI);
    }
}
