package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedMemoryCacheFactory {
    public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, final ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerEncodedMemoryCache(memoryCache);
        return new InstrumentedMemoryCache<>(memoryCache, new MemoryCacheTracker<CacheKey>() {
            public void onCacheHit(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
            }

            public void onCacheMiss(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheMiss(cacheKey);
            }

            public void onCachePut(CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCachePut(cacheKey);
            }
        });
    }
}
