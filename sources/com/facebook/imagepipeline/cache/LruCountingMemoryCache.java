package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

public class LruCountingMemoryCache<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V>, HasDebugData {
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;
    @Nullable
    private final CountingMemoryCache.EntryStateObserver<K> mEntryStateObserver;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mExclusiveEntries;
    private long mLastCacheParamsCheck;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    private final ValueDescriptor<V> mValueDescriptor;

    public LruCountingMemoryCache(ValueDescriptor<V> valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier, @Nullable CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mEntryStateObserver = entryStateObserver;
    }

    private ValueDescriptor<CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<CountingMemoryCache.Entry<K, V>>() {
            public int getSizeInBytes(CountingMemoryCache.Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, this.mEntryStateObserver);
    }

    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        CountingMemoryCache.Entry remove;
        CloseableReference<V> closeableReference2;
        CloseableReference closeableReference3;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            CountingMemoryCache.Entry remove2 = this.mCachedEntries.remove(k);
            closeableReference2 = null;
            if (remove2 != null) {
                makeOrphan(remove2);
                closeableReference3 = referenceToClose(remove2);
            } else {
                closeableReference3 = null;
            }
            if (canCacheNewValue(closeableReference.get())) {
                CountingMemoryCache.Entry<K, V> of = CountingMemoryCache.Entry.of(k, closeableReference, entryStateObserver);
                this.mCachedEntries.put(k, of);
                closeableReference2 = newClientReference(of);
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeEvictEntries();
        return closeableReference2;
    }

    private synchronized boolean canCacheNewValue(V v) {
        boolean z;
        int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
        z = true;
        if (sizeInBytes > this.mMemoryCacheParams.maxCacheEntrySize || getInUseCount() > this.mMemoryCacheParams.maxCacheEntries - 1 || getInUseSizeInBytes() > this.mMemoryCacheParams.maxCacheSize - sizeInBytes) {
            z = false;
        }
        return z;
    }

    @Nullable
    public CloseableReference<V> get(K k) {
        CountingMemoryCache.Entry remove;
        CloseableReference<V> newClientReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            CountingMemoryCache.Entry entry = this.mCachedEntries.get(k);
            newClientReference = entry != null ? newClientReference(entry) : null;
        }
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return newClientReference;
    }

    public void probe(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            CountingMemoryCache.Entry remove = this.mExclusiveEntries.remove(k);
            if (remove != null) {
                this.mExclusiveEntries.put(k, remove);
            }
        }
    }

    private synchronized CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> entry) {
        increaseClientCount(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            public void release(V v) {
                LruCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    /* access modifiers changed from: private */
    public void releaseClientReference(CountingMemoryCache.Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference<V> referenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            maybeAddToExclusives = maybeAddToExclusives(entry);
            referenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) referenceToClose);
        if (!maybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(CountingMemoryCache.Entry<K, V> entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    @Nullable
    public CloseableReference<V> reuse(K k) {
        CountingMemoryCache.Entry remove;
        boolean z;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k);
            z = true;
            boolean z2 = false;
            if (remove != null) {
                CountingMemoryCache.Entry remove2 = this.mCachedEntries.remove(k);
                Preconditions.checkNotNull(remove2);
                if (remove2.clientCount == 0) {
                    z2 = true;
                }
                Preconditions.checkState(z2);
                closeableReference = remove2.valueRef;
            } else {
                closeableReference = null;
                z = false;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(remove);
        }
        return closeableReference;
    }

    public int removeAll(Predicate<K> predicate) {
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll;
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll2;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll2);
        }
        maybeClose(removeAll2);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll2.size();
    }

    public void clear() {
        ArrayList<CountingMemoryCache.Entry<K, V>> clear;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear2;
        synchronized (this) {
            clear = this.mExclusiveEntries.clear();
            clear2 = this.mCachedEntries.clear();
            makeOrphans(clear2);
        }
        maybeClose(clear2);
        maybeNotifyExclusiveEntryRemoval(clear);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList trimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
        }
    }

    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    public CountingLruMap<K, CountingMemoryCache.Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    public Map<Bitmap, Object> getOtherEntries() {
        return this.mOtherEntries;
    }

    public void maybeEvictEntries() {
        ArrayList trimExclusivelyOwnedEntries;
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
    }

    @Nullable
    private synchronized ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return arrayList;
            }
            K firstKey = this.mExclusiveEntries.getFirstKey();
            if (firstKey != null) {
                this.mExclusiveEntries.remove(firstKey);
                arrayList.add(this.mCachedEntries.remove(firstKey));
            } else {
                throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", new Object[]{Integer.valueOf(this.mExclusiveEntries.getCount()), Integer.valueOf(this.mExclusiveEntries.getSizeInBytes())}));
            }
        }
    }

    private void maybeClose(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable CountingMemoryCache.Entry<K, V> entry) {
        if (entry != null && entry.observer != null) {
            entry.observer.onExclusivityChanged(entry.key, false);
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable CountingMemoryCache.Entry<K, V> entry) {
        if (entry != null && entry.observer != null) {
            entry.observer.onExclusivityChanged(entry.key, true);
        }
    }

    private synchronized void makeOrphans(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    private synchronized void makeOrphan(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.isOrphan = true;
    }

    private synchronized void increaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
    }

    private synchronized void decreaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    @Nullable
    private synchronized CloseableReference<V> referenceToClose(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        return (!entry.isOrphan || entry.clientCount != 0) ? null : entry.valueRef;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }

    @Nullable
    public synchronized String getDebugData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
    }
}
