package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class AbstractAdaptiveCountingMemoryCache<K, V> implements CountingMemoryCache<K, V> {
    static final int DEFAULT_ADAPTIVE_RATE_PROMIL = 10;
    static final int DEFAULT_LFU_FRACTION_PROMIL = 500;
    static final int MAX_FRACTION_PROMIL = 900;
    static final int MIN_FRACTION_PROMIL = 100;
    private static final String TAG = "AbstractArcCountingMemoryCache";
    static final int TOTAL_PROMIL = 1000;
    final int mAdaptiveRatePromil;
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;
    private final int mFrequentlyUsedThreshold;
    final int mGhostListMaxSize;
    int mLFUFractionPromil;
    private long mLastCacheParamsCheck = SystemClock.uptimeMillis();
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mLeastFrequentlyUsedExclusiveEntries;
    final AbstractAdaptiveCountingMemoryCache<K, V>.IntMapArrayList<K> mLeastFrequentlyUsedKeysGhostList;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mMostFrequentlyUsedExclusiveEntries;
    final ArrayList<K> mMostFrequentlyUsedKeysGhostList;
    private final ValueDescriptor<V> mValueDescriptor;

    enum ArrayListType {
        LFU,
        MFU
    }

    /* access modifiers changed from: protected */
    public abstract void logIllegalAdaptiveRate();

    /* access modifiers changed from: protected */
    public abstract void logIllegalLfuFraction();

    public AbstractAdaptiveCountingMemoryCache(Supplier<MemoryCacheParams> supplier, MemoryCache.CacheTrimStrategy cacheTrimStrategy, ValueDescriptor<V> valueDescriptor, int i, int i2, int i3, int i4) {
        FLog.d(TAG, "Create Adaptive Replacement Cache");
        this.mValueDescriptor = valueDescriptor;
        this.mLeastFrequentlyUsedExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mMostFrequentlyUsedExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mFrequentlyUsedThreshold = i2;
        this.mGhostListMaxSize = i3;
        this.mLeastFrequentlyUsedKeysGhostList = new IntMapArrayList<>(i3);
        this.mMostFrequentlyUsedKeysGhostList = new ArrayList<>(i3);
        if (i4 < 100 || i4 > MAX_FRACTION_PROMIL) {
            this.mLFUFractionPromil = 500;
            logIllegalLfuFraction();
        } else {
            this.mLFUFractionPromil = i4;
        }
        if (i <= 0 || i >= 1000) {
            this.mAdaptiveRatePromil = 10;
            logIllegalAdaptiveRate();
            return;
        }
        this.mAdaptiveRatePromil = i;
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
        return cache(k, closeableReference, (CountingMemoryCache.EntryStateObserver) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.common.references.CloseableReference<V> cache(K r7, com.facebook.common.references.CloseableReference<V> r8, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> r9) {
        /*
            r6 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r7)
            com.facebook.common.internal.Preconditions.checkNotNull(r8)
            r6.maybeUpdateCacheParams()
            monitor-enter(r6)
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r0 = r6.mLeastFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r0.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r0 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r0     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r1 = r6.mMostFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r1 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r1     // Catch:{ all -> 0x006a }
            r2 = 0
            if (r0 == 0) goto L_0x0022
            if (r1 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = r2
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            com.facebook.common.internal.Preconditions.checkState(r3)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r3 = r6.mCachedEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r3 = r3.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r3 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r3     // Catch:{ all -> 0x006a }
            r4 = 0
            if (r3 == 0) goto L_0x0039
            r6.makeOrphan(r3)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference r3 = r6.referenceToClose(r3)     // Catch:{ all -> 0x006a }
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            java.lang.Object r5 = r8.get()     // Catch:{ all -> 0x006a }
            boolean r5 = r6.canCacheNewValue(r5)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x005f
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r8 = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.of(r7, r8, r9)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache<K, V>$IntMapArrayList<K> r9 = r6.mLeastFrequentlyUsedKeysGhostList     // Catch:{ all -> 0x006a }
            java.lang.Integer r9 = r9.getValue(r7)     // Catch:{ all -> 0x006a }
            if (r9 == 0) goto L_0x0054
            int r2 = r9.intValue()     // Catch:{ all -> 0x006a }
        L_0x0054:
            r8.accessCount = r2     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r9 = r6.mCachedEntries     // Catch:{ all -> 0x006a }
            r9.put(r7, r8)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference r4 = r6.newClientReference(r8)     // Catch:{ all -> 0x006a }
        L_0x005f:
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r3)
            r6.maybeNotifyExclusiveEntryRemoval(r0, r1)
            r6.maybeEvictEntries()
            return r4
        L_0x006a:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.cache(java.lang.Object, com.facebook.common.references.CloseableReference, com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver):com.facebook.common.references.CloseableReference");
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
        CountingMemoryCache.Entry remove2;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            remove2 = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            CountingMemoryCache.Entry entry = this.mCachedEntries.get(k);
            if (entry != null) {
                closeableReference = newClientReference(entry);
            } else {
                maybeUpdateCacheFraction(k);
                closeableReference = null;
            }
        }
        maybeNotifyExclusiveEntryRemoval(remove, remove2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReference;
    }

    public void probe(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            CountingMemoryCache.Entry remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            if (remove == null) {
                remove = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            }
            if (remove != null) {
                increaseAccessCount(remove);
                maybeAddToExclusives(remove);
            }
        }
    }

    private synchronized void maybeUpdateCacheFraction(K k) {
        if (this.mLeastFrequentlyUsedKeysGhostList.contains(k)) {
            int i = this.mLFUFractionPromil;
            int i2 = this.mAdaptiveRatePromil;
            if (i + i2 <= MAX_FRACTION_PROMIL) {
                this.mLFUFractionPromil = i + i2;
            }
            this.mLeastFrequentlyUsedKeysGhostList.increaseValueIfExists(k);
        } else if (this.mLFUFractionPromil - this.mAdaptiveRatePromil >= 100 && this.mMostFrequentlyUsedKeysGhostList.contains(k)) {
            this.mLFUFractionPromil -= this.mAdaptiveRatePromil;
        }
    }

    private synchronized CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> entry) {
        increaseCounters(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            public void release(V v) {
                AbstractAdaptiveCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private synchronized void addElementToGhostList(K k, int i, ArrayListType arrayListType) {
        if (arrayListType == ArrayListType.LFU) {
            this.mLeastFrequentlyUsedKeysGhostList.addPair(k, Integer.valueOf(i));
        } else {
            if (this.mMostFrequentlyUsedKeysGhostList.size() == this.mGhostListMaxSize) {
                this.mMostFrequentlyUsedKeysGhostList.remove(0);
            }
            this.mMostFrequentlyUsedKeysGhostList.add(k);
        }
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
        if (entry.accessCount > this.mFrequentlyUsedThreshold) {
            this.mMostFrequentlyUsedExclusiveEntries.put(entry.key, entry);
        } else {
            this.mLeastFrequentlyUsedExclusiveEntries.put(entry.key, entry);
        }
        return true;
    }

    @Nullable
    public CloseableReference<V> reuse(K k) {
        CountingMemoryCache.Entry remove;
        boolean z;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            if (remove == null) {
                remove = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            }
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
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll3;
        synchronized (this) {
            removeAll = this.mLeastFrequentlyUsedExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mMostFrequentlyUsedExclusiveEntries.removeAll(predicate);
            removeAll3 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll3);
        }
        maybeClose(removeAll3);
        maybeNotifyExclusiveEntriesRemoval(removeAll, removeAll2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll3.size();
    }

    public void clear() {
        ArrayList<CountingMemoryCache.Entry<K, V>> clear;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear2;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear3;
        synchronized (this) {
            clear = this.mLeastFrequentlyUsedExclusiveEntries.clear();
            clear2 = this.mMostFrequentlyUsedExclusiveEntries.clear();
            clear3 = this.mCachedEntries.clear();
            makeOrphans(clear3);
        }
        maybeClose(clear3);
        maybeNotifyExclusiveEntriesRemoval(clear, clear2);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries;
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries2;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            int sizeInBytes = ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes();
            int i = 0;
            int max = Math.max(0, sizeInBytes);
            int sizeInBytes2 = this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
            int max2 = Math.max(0, max - sizeInBytes2);
            if (max > sizeInBytes2) {
                max = sizeInBytes2;
                i = max2;
            }
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, i, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            trimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, max, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        }
        maybeClose(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
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

    public void maybeEvictEntries() {
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries;
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries2;
        synchronized (this) {
            int min = Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount());
            int min2 = Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes());
            int i = this.mLFUFractionPromil;
            int i2 = (int) ((((long) min) * ((long) i)) / 1000);
            int i3 = (int) ((((long) min2) * ((long) i)) / 1000);
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(i2, i3, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            trimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(min - i2, min2 - i3, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        }
        maybeClose(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
    }

    @Nullable
    private synchronized ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2, CountingLruMap<K, CountingMemoryCache.Entry<K, V>> countingLruMap, ArrayListType arrayListType) {
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (countingLruMap.getCount() <= max && countingLruMap.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (countingLruMap.getCount() <= max && countingLruMap.getSizeInBytes() <= max2) {
                return arrayList;
            }
            Object checkNotNull = Preconditions.checkNotNull(countingLruMap.getFirstKey());
            addElementToGhostList(checkNotNull, ((CountingMemoryCache.Entry) Preconditions.checkNotNull(countingLruMap.get(checkNotNull))).accessCount, arrayListType);
            countingLruMap.remove(checkNotNull);
            arrayList.add(this.mCachedEntries.remove(checkNotNull));
        }
    }

    private void maybeClose(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, @Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeClose(arrayList);
        maybeClose(arrayList2);
    }

    private void maybeClose(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntriesRemoval(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, @Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeNotifyExclusiveEntryRemoval(arrayList);
        maybeNotifyExclusiveEntryRemoval(arrayList2);
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable CountingMemoryCache.Entry<K, V> entry, @Nullable CountingMemoryCache.Entry<K, V> entry2) {
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeNotifyExclusiveEntryRemoval(entry2);
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

    private synchronized void makeOrphans(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, @Nullable ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        makeOrphans(arrayList);
        makeOrphans(arrayList2);
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

    private synchronized void increaseCounters(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
        increaseAccessCount(entry);
    }

    private synchronized void increaseAccessCount(CountingMemoryCache.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.accessCount++;
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
        return (this.mCachedEntries.getCount() - this.mLeastFrequentlyUsedExclusiveEntries.getCount()) - this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return (this.mCachedEntries.getSizeInBytes() - this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes()) - this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getCount() + this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes() + this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public String reportData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("exclusive_entries_count", getEvictionQueueCount()).toString();
    }

    class IntMapArrayList<E> {
        private final ArrayList<E> mFirstList;
        private final int mMaxCapacity;
        private final ArrayList<Integer> mSecondList;

        public IntMapArrayList(int i) {
            this.mFirstList = new ArrayList<>(i);
            this.mSecondList = new ArrayList<>(i);
            this.mMaxCapacity = i;
        }

        public void addPair(E e, Integer num) {
            if (this.mFirstList.size() == this.mMaxCapacity) {
                this.mFirstList.remove(0);
                this.mSecondList.remove(0);
            }
            this.mFirstList.add(e);
            this.mSecondList.add(num);
        }

        public void increaseValueIfExists(E e) {
            int indexOf = this.mFirstList.indexOf(e);
            if (indexOf >= 0) {
                Integer valueOf = Integer.valueOf(this.mSecondList.get(indexOf).intValue() + 1);
                int i = this.mMaxCapacity;
                if (indexOf == i - 1) {
                    this.mSecondList.set(i - 1, valueOf);
                    return;
                }
                this.mFirstList.remove(indexOf);
                this.mSecondList.remove(indexOf);
                this.mFirstList.add(e);
                this.mSecondList.add(valueOf);
            }
        }

        @Nullable
        public Integer getValue(E e) {
            int indexOf = this.mFirstList.indexOf(e);
            if (indexOf < 0) {
                return null;
            }
            return this.mSecondList.get(indexOf);
        }

        public boolean contains(E e) {
            return this.mFirstList.contains(e);
        }

        public int size() {
            return this.mFirstList.size();
        }
    }

    public CountingLruMap getCachedEntries() {
        return this.mCachedEntries;
    }

    public Map<Bitmap, Object> getOtherEntries() {
        return Collections.emptyMap();
    }
}
