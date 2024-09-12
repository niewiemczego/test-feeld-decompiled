package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

public class AshmemMemoryChunkPool extends MemoryChunkPool {
    public AshmemMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    public AshmemMemoryChunk alloc(int i) {
        return new AshmemMemoryChunk(i);
    }
}
