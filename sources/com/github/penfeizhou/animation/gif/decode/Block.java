package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;

public interface Block {
    void receive(GifReader gifReader) throws IOException;

    int size();
}
