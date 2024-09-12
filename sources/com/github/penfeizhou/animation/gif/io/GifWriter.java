package com.github.penfeizhou.animation.gif.io;

import androidx.work.Data;
import com.github.penfeizhou.animation.io.Writer;
import java.nio.IntBuffer;

public class GifWriter implements Writer {
    protected IntBuffer intBuffer;

    public void close() {
    }

    public void putByte(byte b) {
    }

    public void putBytes(byte[] bArr) {
    }

    public byte[] toByteArray() {
        return null;
    }

    public GifWriter() {
        reset(Data.MAX_DATA_BYTES);
    }

    public int position() {
        return this.intBuffer.position();
    }

    public void skip(int i) {
        this.intBuffer.position(i + position());
    }

    public void reset(int i) {
        IntBuffer intBuffer2 = this.intBuffer;
        if (intBuffer2 == null || i > intBuffer2.capacity()) {
            this.intBuffer = IntBuffer.allocate(i);
        }
        this.intBuffer.clear();
        this.intBuffer.limit(i);
        this.intBuffer.position(0);
    }

    public int[] asIntArray() {
        return this.intBuffer.array();
    }

    public IntBuffer asBuffer() {
        return this.intBuffer;
    }
}
