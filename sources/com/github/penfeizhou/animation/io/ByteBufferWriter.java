package com.github.penfeizhou.animation.io;

import androidx.work.Data;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferWriter implements Writer {
    protected ByteBuffer byteBuffer;

    public void close() {
    }

    public ByteBufferWriter() {
        reset(Data.MAX_DATA_BYTES);
    }

    public void putByte(byte b) {
        this.byteBuffer.put(b);
    }

    public void putBytes(byte[] bArr) {
        this.byteBuffer.put(bArr);
    }

    public int position() {
        return this.byteBuffer.position();
    }

    public void skip(int i) {
        this.byteBuffer.position(i + position());
    }

    public byte[] toByteArray() {
        return this.byteBuffer.array();
    }

    public void reset(int i) {
        ByteBuffer byteBuffer2 = this.byteBuffer;
        if (byteBuffer2 == null || i > byteBuffer2.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i);
            this.byteBuffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.byteBuffer.clear();
    }
}
