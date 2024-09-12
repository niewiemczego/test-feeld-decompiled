package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

final class ListChunk implements AviChunk {
    public final ImmutableList<AviChunk> children;
    private final int type;

    public static ListChunk parseFrom(int i, ParsableByteArray parsableByteArray) {
        AviChunk aviChunk;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int limit = parsableByteArray.limit();
        int i2 = -2;
        while (parsableByteArray.bytesLeft() > 8) {
            int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
            int position = parsableByteArray.getPosition() + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(position);
            if (readLittleEndianInt == 1414744396) {
                aviChunk = parseFrom(parsableByteArray.readLittleEndianInt(), parsableByteArray);
            } else {
                aviChunk = createBox(readLittleEndianInt, i2, parsableByteArray);
            }
            if (aviChunk != null) {
                if (aviChunk.getType() == 1752331379) {
                    i2 = ((AviStreamHeaderChunk) aviChunk).getTrackType();
                }
                builder.add((Object) aviChunk);
            }
            parsableByteArray.setPosition(position);
            parsableByteArray.setLimit(limit);
        }
        return new ListChunk(i, builder.build());
    }

    private ListChunk(int i, ImmutableList<AviChunk> immutableList) {
        this.type = i;
        this.children = immutableList;
    }

    public int getType() {
        return this.type;
    }

    public <T extends AviChunk> T getChild(Class<T> cls) {
        UnmodifiableIterator<AviChunk> it = this.children.iterator();
        while (it.hasNext()) {
            T t = (AviChunk) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    private static AviChunk createBox(int i, int i2, ParsableByteArray parsableByteArray) {
        switch (i) {
            case AviExtractor.FOURCC_strf /*1718776947*/:
                return StreamFormatChunk.parseFrom(i2, parsableByteArray);
            case AviExtractor.FOURCC_avih /*1751742049*/:
                return AviMainHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strh /*1752331379*/:
                return AviStreamHeaderChunk.parseFrom(parsableByteArray);
            case AviExtractor.FOURCC_strn /*1852994675*/:
                return StreamNameChunk.parseFrom(parsableByteArray);
            default:
                return null;
        }
    }
}
