package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class DiskStorageCache implements FileCache, DiskTrimmable {
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    public static final int START_OF_VERSIONING = 1;
    private static final Class<?> TAG = DiskStorageCache.class;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLastUpdateTime;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final CacheStats mCacheStats;
    private final Clock mClock;
    /* access modifiers changed from: private */
    public final CountDownLatch mCountDownLatch;
    private final long mDefaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    /* access modifiers changed from: private */
    public boolean mIndexReady;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final long mLowDiskSpaceCacheSizeLimit;
    final Set<String> mResourceIndex;
    private final StatFsHelper mStatFsHelper;
    private final DiskStorage mStorage;

    static class CacheStats {
        private long mCount = -1;
        private boolean mInitialized = false;
        private long mSize = -1;

        CacheStats() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = -1;
            this.mSize = -1;
        }

        public synchronized void set(long j, long j2) {
            this.mCount = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.mCount;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry, Executor executor, boolean z) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        this.mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheSizeLastUpdateTime = -1;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mCacheStats = new CacheStats();
        this.mClock = SystemClock.get();
        this.mIndexPopulateAtStartupEnabled = z;
        this.mResourceIndex = new HashSet();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        if (z) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() {
                public void run() {
                    synchronized (DiskStorageCache.this.mLock) {
                        boolean unused = DiskStorageCache.this.maybeUpdateFileCacheSize();
                    }
                    boolean unused2 = DiskStorageCache.this.mIndexReady = true;
                    DiskStorageCache.this.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return this.mStorage.getDumpInfo();
    }

    public boolean isEnabled() {
        return this.mStorage.isEnabled();
    }

    /* access modifiers changed from: protected */
    public void awaitIndex() {
        try {
            this.mCountDownLatch.await();
        } catch (InterruptedException unused) {
            FLog.e(TAG, "Memory Index is not ready yet. ");
        }
    }

    public boolean isIndexReady() {
        return this.mIndexReady || !this.mIndexPopulateAtStartupEnabled;
    }

    @Nullable
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        try {
            synchronized (this.mLock) {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                int i = 0;
                String str = null;
                binaryResource = null;
                while (true) {
                    if (i >= resourceIds.size()) {
                        break;
                    }
                    str = resourceIds.get(i);
                    cacheKey2.setResourceId(str);
                    binaryResource = this.mStorage.getResource(str, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                    i++;
                }
                if (binaryResource == null) {
                    this.mCacheEventListener.onMiss(cacheKey2);
                    this.mResourceIndex.remove(str);
                } else {
                    Preconditions.checkNotNull(str);
                    this.mCacheEventListener.onHit(cacheKey2);
                    this.mResourceIndex.add(str);
                }
            }
            cacheKey2.recycle();
            return binaryResource;
        } catch (IOException e) {
            try {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
                cacheKey2.setException(e);
                this.mCacheEventListener.onReadException(cacheKey2);
                return null;
            } finally {
                cacheKey2.recycle();
            }
        }
    }

    public boolean probe(CacheKey cacheKey) {
        String str;
        IOException e;
        String str2 = null;
        try {
            synchronized (this.mLock) {
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    int i = 0;
                    while (i < resourceIds.size()) {
                        String str3 = resourceIds.get(i);
                        try {
                            if (this.mStorage.touch(str3, cacheKey)) {
                                this.mResourceIndex.add(str3);
                                return true;
                            }
                            i++;
                            str2 = str3;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                throw th;
                            } catch (IOException e2) {
                                e = e2;
                            }
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    str = str2;
                    th = th2;
                    throw th;
                }
            }
        } catch (IOException e3) {
            str = null;
            e = e3;
            SettableCacheEvent exception = SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str).setException(e);
            this.mCacheEventListener.onReadException(exception);
            exception.recycle();
            return false;
        }
    }

    private DiskStorage.Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        maybeEvictFilesInCacheDir();
        return this.mStorage.insert(str, cacheKey);
    }

    private BinaryResource endInsert(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource commit;
        synchronized (this.mLock) {
            commit = inserter.commit(cacheKey);
            this.mResourceIndex.add(str);
            this.mCacheStats.increment(commit.size(), 1);
        }
        return commit;
    }

    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String firstResourceId;
        DiskStorage.Inserter startInsert;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        this.mCacheEventListener.onWriteAttempt(cacheKey2);
        synchronized (this.mLock) {
            firstResourceId = CacheKeyUtil.getFirstResourceId(cacheKey);
        }
        cacheKey2.setResourceId(firstResourceId);
        try {
            startInsert = startInsert(firstResourceId, cacheKey);
            startInsert.writeData(writerCallback, cacheKey);
            BinaryResource endInsert = endInsert(startInsert, cacheKey, firstResourceId);
            cacheKey2.setItemSize(endInsert.size()).setCacheSize(this.mCacheStats.getSize());
            this.mCacheEventListener.onWriteSuccess(cacheKey2);
            if (!startInsert.cleanUp()) {
                FLog.e(TAG, "Failed to delete temp file");
            }
            cacheKey2.recycle();
            return endInsert;
        } catch (IOException e) {
            try {
                cacheKey2.setException(e);
                this.mCacheEventListener.onWriteException(cacheKey2);
                FLog.e(TAG, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            } catch (Throwable th) {
                cacheKey2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            if (!startInsert.cleanUp()) {
                FLog.e(TAG, "Failed to delete temp file");
            }
            throw th2;
        }
    }

    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);
            }
        }
    }

    public long clearOldEntries(long j) {
        long j2;
        long j3;
        synchronized (this.mLock) {
            try {
                long now = this.mClock.now();
                Collection<DiskStorage.Entry> entries = this.mStorage.getEntries();
                long size = this.mCacheStats.getSize();
                int i = 0;
                long j4 = 0;
                j2 = 0;
                for (DiskStorage.Entry next : entries) {
                    try {
                        long j5 = now;
                        long max = Math.max(1, Math.abs(now - next.getTimestamp()));
                        if (max >= j) {
                            long remove = this.mStorage.remove(next);
                            this.mResourceIndex.remove(next.getId());
                            if (remove > 0) {
                                i++;
                                j4 += remove;
                                SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(next.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(remove).setCacheSize(size - j4);
                                this.mCacheEventListener.onEviction(cacheSize);
                                cacheSize.recycle();
                            }
                        } else {
                            j2 = Math.max(j2, max);
                        }
                        now = j5;
                    } catch (IOException e) {
                        e = e;
                        j3 = j2;
                        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                        j2 = j3;
                        return j2;
                    }
                }
                this.mStorage.purgeUnexpectedResources();
                if (i > 0) {
                    maybeUpdateFileCacheSize();
                    this.mCacheStats.increment(-j4, (long) (-i));
                }
            } catch (IOException e2) {
                e = e2;
                j3 = 0;
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                j2 = j3;
                return j2;
            }
        }
        return j2;
    }

    private void maybeEvictFilesInCacheDir() throws IOException {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            long j = this.mCacheSizeLimit;
            if (size > j) {
                evictAboveSize((j * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    private void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2 = j;
        try {
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize();
            long j3 = size - j2;
            int i = 0;
            long j4 = 0;
            for (DiskStorage.Entry next : sortedEntries) {
                if (j4 > j3) {
                    break;
                }
                long remove = this.mStorage.remove(next);
                this.mResourceIndex.remove(next.getId());
                if (remove > 0) {
                    i++;
                    j4 += remove;
                    SettableCacheEvent cacheLimit = SettableCacheEvent.obtain().setResourceId(next.getId()).setEvictionReason(evictionReason).setItemSize(remove).setCacheSize(size - j4).setCacheLimit(j2);
                    this.mCacheEventListener.onEviction(cacheLimit);
                    cacheLimit.recycle();
                } else {
                    CacheEventListener.EvictionReason evictionReason2 = evictionReason;
                }
            }
            this.mCacheStats.increment(-j4, (long) (-i));
            this.mStorage.purgeUnexpectedResources();
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        long now = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry next : collection) {
            if (next.getTimestamp() > now) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void updateFileCacheSizeLimit() {
        if (this.mStatFsHelper.testLowDiskSpace(this.mStorage.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }

    public long getSize() {
        return this.mCacheStats.getSize();
    }

    public long getCount() {
        return this.mCacheStats.getCount();
    }

    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorage.clearAll();
                this.mResourceIndex.clear();
                this.mCacheEventListener.onCleared();
            } catch (IOException | NullPointerException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);
            }
            this.mCacheStats.reset();
        }
    }

    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.mLock) {
            List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToMinimum() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mLock
            monitor-enter(r0)
            r8.maybeUpdateFileCacheSize()     // Catch:{ all -> 0x0033 }
            com.facebook.cache.disk.DiskStorageCache$CacheStats r1 = r8.mCacheStats     // Catch:{ all -> 0x0033 }
            long r1 = r1.getSize()     // Catch:{ all -> 0x0033 }
            long r3 = r8.mCacheSizeLimitMinimum     // Catch:{ all -> 0x0033 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0031
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0031
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            goto L_0x0031
        L_0x001d:
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = (double) r3     // Catch:{ all -> 0x0033 }
            double r1 = (double) r1     // Catch:{ all -> 0x0033 }
            double r3 = r3 / r1
            double r5 = r5 - r3
            r1 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x002f
            r8.trimBy(r5)     // Catch:{ all -> 0x0033 }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DiskStorageCache.trimToMinimum():void");
    }

    public void trimToNothing() {
        clearAll();
    }

    private void trimBy(double d) {
        synchronized (this.mLock) {
            try {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                evictAboveSize(size - ((long) (d * ((double) size))), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean maybeUpdateFileCacheSize() {
        long now = this.mClock.now();
        if (this.mCacheStats.isInitialized()) {
            long j = this.mCacheSizeLastUpdateTime;
            if (j != -1 && now - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                return false;
            }
        }
        return maybeUpdateFileCacheSizeAndIndex();
    }

    private boolean maybeUpdateFileCacheSizeAndIndex() {
        Set<String> set;
        long j;
        long now = this.mClock.now();
        long j2 = FUTURE_TIMESTAMP_THRESHOLD_MS + now;
        if (!this.mIndexPopulateAtStartupEnabled || !this.mResourceIndex.isEmpty()) {
            set = this.mIndexPopulateAtStartupEnabled ? new HashSet<>() : null;
        } else {
            set = this.mResourceIndex;
        }
        try {
            long j3 = 0;
            long j4 = -1;
            int i = 0;
            boolean z = false;
            int i2 = 0;
            int i3 = 0;
            for (DiskStorage.Entry next : this.mStorage.getEntries()) {
                i2++;
                j3 += next.getSize();
                if (next.getTimestamp() > j2) {
                    i3++;
                    i = (int) (((long) i) + next.getSize());
                    j = j2;
                    j4 = Math.max(next.getTimestamp() - now, j4);
                    z = true;
                } else {
                    j = j2;
                    if (this.mIndexPopulateAtStartupEnabled) {
                        Preconditions.checkNotNull(set);
                        set.add(next.getId());
                    }
                }
                j2 = j;
            }
            if (z) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i3 + " files , with a total size of " + i + " bytes, and a maximum time delta of " + j4 + "ms", (Throwable) null);
            }
            long j5 = (long) i2;
            if (!(this.mCacheStats.getCount() == j5 && this.mCacheStats.getSize() == j3)) {
                if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != set) {
                    Preconditions.checkNotNull(set);
                    this.mResourceIndex.clear();
                    this.mResourceIndex.addAll(set);
                }
                this.mCacheStats.set(j3, j5);
            }
            this.mCacheSizeLastUpdateTime = now;
            return true;
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}
