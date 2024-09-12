package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class MemoryPooledByteBuffer implements PooledByteBuffer {
    CloseableReference<MemoryChunk> mBufRef;
    private final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        Preconditions.checkNotNull(closeableReference);
        Preconditions.checkArgument(Boolean.valueOf(i >= 0 && i <= closeableReference.get().getSize()));
        this.mBufRef = closeableReference.clone();
        this.mSize = i;
    }

    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    public synchronized byte read(int i) {
        ensureValid();
        boolean z = true;
        Preconditions.checkArgument(Boolean.valueOf(i >= 0));
        if (i >= this.mSize) {
            z = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z));
        return this.mBufRef.get().read(i);
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        Preconditions.checkArgument(Boolean.valueOf(i + i3 <= this.mSize));
        return this.mBufRef.get().read(i, bArr, i2, i3);
    }

    public synchronized long getNativePtr() throws UnsupportedOperationException {
        ensureValid();
        return this.mBufRef.get().getNativePtr();
    }

    @Nullable
    public synchronized ByteBuffer getByteBuffer() {
        return this.mBufRef.get().getByteBuffer();
    }

    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    public synchronized void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mBufRef);
        this.mBufRef = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void ensureValid() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    /* access modifiers changed from: package-private */
    public CloseableReference<MemoryChunk> getCloseableReference() {
        return this.mBufRef;
    }
}
