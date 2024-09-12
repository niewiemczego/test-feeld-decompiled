package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaintTextExtension extends ExtensionBlock {
    private List<DataSubBlock> plainTextData = new ArrayList();

    public int size() {
        return 0;
    }

    public void receive(GifReader gifReader) throws IOException {
        gifReader.peek();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.peek();
        gifReader.peek();
        gifReader.peek();
        gifReader.peek();
        while (true) {
            DataSubBlock retrieve = DataSubBlock.retrieve(gifReader);
            if (!retrieve.isTerminal()) {
                this.plainTextData.add(retrieve);
            } else {
                return;
            }
        }
    }
}
