package com.facebook.imagepipeline.memory;

import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    private static final String TAG = "AshmemMemoryChunk";
    @Nullable
    private ByteBuffer mByteBuffer;
    private final long mId;
    @Nullable
    private SharedMemory mSharedMemory;

    public AshmemMemoryChunk(int i) {
        Preconditions.checkArgument(Boolean.valueOf(i > 0));
        try {
            SharedMemory create = SharedMemory.create(TAG, i);
            this.mSharedMemory = create;
            this.mByteBuffer = create.mapReadWrite();
            this.mId = (long) System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    public AshmemMemoryChunk() {
        this.mSharedMemory = null;
        this.mByteBuffer = null;
        this.mId = (long) System.identityHashCode(this);
    }

    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory.unmap(this.mByteBuffer);
            this.mSharedMemory.close();
            this.mByteBuffer = null;
            this.mSharedMemory = null;
        }
    }

    public synchronized boolean isClosed() {
        return this.mByteBuffer == null || this.mSharedMemory == null;
    }

    public int getSize() {
        Preconditions.checkState(!isClosed());
        return this.mSharedMemory.getSize();
    }

    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, getSize());
        MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, getSize());
        this.mByteBuffer.position(i);
        this.mByteBuffer.put(bArr, i2, adjustByteCount);
        return adjustByteCount;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, getSize());
        MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, getSize());
        this.mByteBuffer.position(i);
        this.mByteBuffer.get(bArr, i2, adjustByteCount);
        return adjustByteCount;
    }

    public synchronized byte read(int i) {
        boolean z = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(Boolean.valueOf(i >= 0));
        if (i >= getSize()) {
            z = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z));
        return this.mByteBuffer.get(i);
    }

    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    @Nullable
    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public long getUniqueId() {
        return this.mId;
    }

    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Log.w(TAG, "Copying from AshmemMemoryChunk " + Long.toHexString(getUniqueId()) + " to AshmemMemoryChunk " + Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ");
            Preconditions.checkArgument(false);
        }
        if (memoryChunk.getUniqueId() < getUniqueId()) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    doCopy(i, memoryChunk, i2, i3);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (memoryChunk) {
                doCopy(i, memoryChunk, i2, i3);
            }
        }
    }

    private void doCopy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof AshmemMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, getSize());
            this.mByteBuffer.position(i);
            memoryChunk.getByteBuffer().position(i2);
            byte[] bArr = new byte[i3];
            this.mByteBuffer.get(bArr, 0, i3);
            memoryChunk.getByteBuffer().put(bArr, 0, i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }
}
