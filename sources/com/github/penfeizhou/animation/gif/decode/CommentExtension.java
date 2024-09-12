package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentExtension extends ExtensionBlock {
    private List<DataSubBlock> dataSubBlocks = new ArrayList();

    public int size() {
        return 0;
    }

    public void receive(GifReader gifReader) throws IOException {
        while (true) {
            DataSubBlock retrieve = DataSubBlock.retrieve(gifReader);
            if (!retrieve.isTerminal()) {
                this.dataSubBlocks.add(retrieve);
            } else {
                return;
            }
        }
    }
}
