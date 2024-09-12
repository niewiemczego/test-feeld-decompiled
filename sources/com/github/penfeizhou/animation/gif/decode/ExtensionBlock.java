package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.decode.GifParser;
import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;

public abstract class ExtensionBlock implements Block {
    public static ExtensionBlock retrieve(GifReader gifReader) throws IOException {
        byte peek = gifReader.peek();
        if (peek == -7) {
            return new GraphicControlExtension();
        }
        if (peek == 1) {
            return new PlaintTextExtension();
        }
        if (peek == -2) {
            return new CommentExtension();
        }
        if (peek == -1) {
            return new ApplicationExtension();
        }
        throw new GifParser.FormatException();
    }
}
