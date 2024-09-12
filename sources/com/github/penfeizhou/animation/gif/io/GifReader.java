package com.github.penfeizhou.animation.gif.io;

import com.github.penfeizhou.animation.io.FilterReader;
import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;

public class GifReader extends FilterReader {
    private static ThreadLocal<byte[]> __intBytes = new ThreadLocal<>();

    private static byte[] ensureBytes() {
        byte[] bArr = __intBytes.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        __intBytes.set(bArr2);
        return bArr2;
    }

    public GifReader(Reader reader) {
        super(reader);
    }

    public int readUInt16() throws IOException {
        byte[] ensureBytes = ensureBytes();
        read(ensureBytes, 0, 2);
        return ((ensureBytes[1] & 255) << 8) | (ensureBytes[0] & 255);
    }
}
