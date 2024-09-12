package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class BufferedDiskCache {
    /* access modifiers changed from: private */
    public static final Class<?> TAG = BufferedDiskCache.class;
    /* access modifiers changed from: private */
    public final FileCache mFileCache;
    /* access modifiers changed from: private */
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    /* access modifiers changed from: private */
    public final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    /* access modifiers changed from: private */
    public final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.mStagingArea.containsKey(cacheKey) || this.mFileCache.hasKeySync(cacheKey);
    }

    public Task<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return Task.forResult(true);
        }
        return containsAsync(cacheKey);
    }

    private Task<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync");
            return Task.call(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        Boolean valueOf = Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        return valueOf;
                    } catch (Throwable th) {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        throw th;
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                return foundPinnedImage(cacheKey, encodedImage);
            }
            Task<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return async;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Task<Void> probe(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe");
            return Task.call(new Callable<Void>() {
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        BufferedDiskCache.this.mFileCache.probe(cacheKey);
                        return null;
                    } finally {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache probe for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public void addKeyForAsyncProbing(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mFileCache.probe(cacheKey);
    }

    /* access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, "Found image for %s in staging area", (Object) cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", (Object) cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
        try {
            return this.mFileCache.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private Task<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            return Task.call(new Callable<EncodedImage>() {
                @Nullable
                public EncodedImage call() throws Exception {
                    CloseableReference of;
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        if (!atomicBoolean.get()) {
                            EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                            if (encodedImage != null) {
                                FLog.v((Class<?>) BufferedDiskCache.TAG, "Found image for %s in staging area", (Object) cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                            } else {
                                FLog.v((Class<?>) BufferedDiskCache.TAG, "Did not find image for %s in staging area", (Object) cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
                                try {
                                    PooledByteBuffer access$500 = BufferedDiskCache.this.readFromDiskCache(cacheKey);
                                    if (access$500 == null) {
                                        FrescoInstrumenter.onEndWork(onBeginWork);
                                        return null;
                                    }
                                    of = CloseableReference.of(access$500);
                                    EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) of);
                                    CloseableReference.closeSafely((CloseableReference<?>) of);
                                    encodedImage = encodedImage2;
                                } catch (Exception unused) {
                                    FrescoInstrumenter.onEndWork(onBeginWork);
                                    return null;
                                } catch (Throwable th) {
                                    CloseableReference.closeSafely((CloseableReference<?>) of);
                                    throw th;
                                }
                            }
                            if (Thread.interrupted()) {
                                FLog.v((Class<?>) BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                                if (encodedImage != null) {
                                    encodedImage.close();
                                }
                                throw new InterruptedException();
                            }
                            FrescoInstrumenter.onEndWork(onBeginWork);
                            return encodedImage;
                        }
                        throw new CancellationException();
                    } catch (Throwable th2) {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        throw th2;
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        final EncodedImage cloneOrNull;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(Boolean.valueOf(EncodedImage.isValid(encodedImage)));
            this.mStagingArea.put(cacheKey, encodedImage);
            cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
            this.mWriteExecutor.execute(new Runnable() {
                public void run() {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                        EncodedImage.closeSafely(cloneOrNull);
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    } catch (Throwable th) {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                        EncodedImage.closeSafely(cloneOrNull);
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        throw th;
                    }
                }
            });
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
            this.mStagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(cloneOrNull);
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public Task<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
            return Task.call(new Callable<Void>() {
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                        BufferedDiskCache.this.mFileCache.remove(cacheKey);
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        return null;
                    } catch (Throwable th) {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        throw th;
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            return Task.call(new Callable<Void>() {
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, (String) null);
                    try {
                        BufferedDiskCache.this.mStagingArea.clearAll();
                        BufferedDiskCache.this.mFileCache.clearAll();
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        return null;
                    } catch (Throwable th) {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                        throw th;
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, (Throwable) e, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    public long getSize() {
        return this.mFileCache.getSize();
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, "Found image for %s in staging area", (Object) cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return Task.forResult(encodedImage);
    }

    /* access modifiers changed from: private */
    @Nullable
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        InputStream openStream;
        try {
            Class<?> cls = TAG;
            FLog.v(cls, "Disk cache read for %s", (Object) cacheKey.getUriString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.v(cls, "Disk cache miss for %s", (Object) cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss(cacheKey);
                return null;
            }
            FLog.v(cls, "Found entry in disk cache for %s", (Object) cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            openStream = resource.openStream();
            PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
            openStream.close();
            FLog.v(cls, "Successful read from disk cache for %s", (Object) cacheKey.getUriString());
            return newByteBuffer;
        } catch (IOException e) {
            FLog.w(TAG, (Throwable) e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail(cacheKey);
            throw e;
        } catch (Throwable th) {
            openStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        Class<?> cls = TAG;
        FLog.v(cls, "About to write to disk-cache for key %s", (Object) cacheKey.getUriString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() {
                public void write(OutputStream outputStream) throws IOException {
                    InputStream inputStream = encodedImage.getInputStream();
                    Preconditions.checkNotNull(inputStream);
                    BufferedDiskCache.this.mPooledByteStreams.copy(inputStream, outputStream);
                }
            });
            this.mImageCacheStatsTracker.onDiskCachePut(cacheKey);
            FLog.v(cls, "Successful disk-cache write for key %s", (Object) cacheKey.getUriString());
        } catch (IOException e) {
            FLog.w(TAG, (Throwable) e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }
}
