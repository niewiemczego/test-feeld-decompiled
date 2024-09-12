package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;

public class ApplicationExtension extends ExtensionBlock {
    public String identifier;
    public int loopCount = -1;

    public int size() {
        return 0;
    }

    public void receive(GifReader gifReader) throws IOException {
        byte peek = gifReader.peek();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < peek; i++) {
            sb.append((char) gifReader.peek());
        }
        String sb2 = sb.toString();
        this.identifier = sb2;
        if ("NETSCAPE2.0".equals(sb2)) {
            if ((gifReader.peek() & 255) == 3 && (gifReader.peek() & 255) == 1) {
                this.loopCount = gifReader.readUInt16();
            }
            do {
            } while (!DataSubBlock.retrieve(gifReader).isTerminal());
            return;
        }
        do {
        } while (!DataSubBlock.retrieve(gifReader).isTerminal());
    }
}
