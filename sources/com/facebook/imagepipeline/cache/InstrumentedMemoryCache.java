package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {
    private final MemoryCache<K, V> mDelegate;
    private final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.mDelegate = memoryCache;
        this.mTracker = memoryCacheTracker;
    }

    @Nullable
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.mDelegate.get(k);
        if (closeableReference == null) {
            this.mTracker.onCacheMiss(k);
        } else {
            this.mTracker.onCacheHit(k);
        }
        return closeableReference;
    }

    public void probe(K k) {
        this.mDelegate.probe(k);
    }

    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        this.mTracker.onCachePut(k);
        return this.mDelegate.cache(k, closeableReference);
    }

    public int removeAll(Predicate<K> predicate) {
        return this.mDelegate.removeAll(predicate);
    }

    public boolean contains(Predicate<K> predicate) {
        return this.mDelegate.contains(predicate);
    }

    public boolean contains(K k) {
        return this.mDelegate.contains(k);
    }

    public int getCount() {
        return this.mDelegate.getCount();
    }

    public int getSizeInBytes() {
        return this.mDelegate.getSizeInBytes();
    }

    public void trim(MemoryTrimType memoryTrimType) {
        this.mDelegate.trim(memoryTrimType);
    }

    @Nullable
    public String getDebugData() {
        return this.mDelegate.getDebugData();
    }
}
