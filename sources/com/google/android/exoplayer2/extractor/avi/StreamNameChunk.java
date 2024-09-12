package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class StreamNameChunk implements AviChunk {
    public final String name;

    public int getType() {
        return AviExtractor.FOURCC_strn;
    }

    public static StreamNameChunk parseFrom(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.readString(parsableByteArray.bytesLeft()));
    }

    private StreamNameChunk(String str) {
        this.name = str;
    }
}
