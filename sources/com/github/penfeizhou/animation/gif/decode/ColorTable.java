package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import com.google.common.base.Ascii;
import java.io.IOException;

public class ColorTable implements Block {
    private int[] colorTable;

    public ColorTable(int i) {
        this.colorTable = new int[i];
    }

    public void receive(GifReader gifReader) throws IOException {
        for (int i = 0; i < this.colorTable.length; i++) {
            byte peek = gifReader.peek();
            byte peek2 = gifReader.peek();
            int i2 = (peek2 & 255) << 8;
            byte b = peek & 255;
            this.colorTable[i] = b | i2 | ((gifReader.peek() & 255) << Ascii.DLE) | -16777216;
        }
    }

    public int[] getColorTable() {
        return this.colorTable;
    }

    public int size() {
        return this.colorTable.length * 3;
    }
}
