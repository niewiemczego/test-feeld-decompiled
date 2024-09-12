package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import javax.annotation.Nullable;

public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    @Nullable
    private CloseableReference<MemoryChunk> mBufRef;
    private int mCount;
    private final MemoryChunkPool mPool;

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.getMinBufferSize());
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        MemoryChunkPool memoryChunkPool2 = (MemoryChunkPool) Preconditions.checkNotNull(memoryChunkPool);
        this.mPool = memoryChunkPool2;
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(memoryChunkPool2.get(i), memoryChunkPool2);
    }

    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer((CloseableReference) Preconditions.checkNotNull(this.mBufRef), this.mCount);
    }

    public int size() {
        return this.mCount;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        ensureValid();
        realloc(this.mCount + i2);
        ((MemoryChunk) ((CloseableReference) Preconditions.checkNotNull(this.mBufRef)).get()).write(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }

    public void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    /* access modifiers changed from: package-private */
    public void realloc(int i) {
        ensureValid();
        Preconditions.checkNotNull(this.mBufRef);
        if (i > this.mBufRef.get().getSize()) {
            MemoryChunk memoryChunk = (MemoryChunk) this.mPool.get(i);
            Preconditions.checkNotNull(this.mBufRef);
            this.mBufRef.get().copy(0, memoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(memoryChunk, this.mPool);
        }
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
