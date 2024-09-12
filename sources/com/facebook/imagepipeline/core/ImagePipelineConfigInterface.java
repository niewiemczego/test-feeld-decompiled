package com.facebook.imagepipeline.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Set;
import javax.annotation.Nullable;

public interface ImagePipelineConfigInterface {
    @Nullable
    MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride();

    Bitmap.Config getBitmapConfig();

    @Nullable
    CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver();

    BitmapMemoryCacheFactory getBitmapMemoryCacheFactory();

    Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier();

    MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy();

    CacheKeyFactory getCacheKeyFactory();

    @Nullable
    CallerContextVerifier getCallerContextVerifier();

    CloseableReferenceLeakTracker getCloseableReferenceLeakTracker();

    Context getContext();

    @Nullable
    MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride();

    Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier();

    @Nullable
    SerialExecutorService getExecutorServiceForAnimatedImages();

    ExecutorSupplier getExecutorSupplier();

    ImagePipelineExperiments getExperiments();

    FileCacheFactory getFileCacheFactory();

    ImageCacheStatsTracker getImageCacheStatsTracker();

    @Nullable
    ImageDecoder getImageDecoder();

    @Nullable
    ImageDecoderConfig getImageDecoderConfig();

    @Nullable
    ImageTranscoderFactory getImageTranscoderFactory();

    @Nullable
    Integer getImageTranscoderType();

    Supplier<Boolean> getIsPrefetchEnabledSupplier();

    DiskCacheConfig getMainDiskCacheConfig();

    int getMemoryChunkType();

    MemoryTrimmableRegistry getMemoryTrimmableRegistry();

    NetworkFetcher getNetworkFetcher();

    @Nullable
    PlatformBitmapFactory getPlatformBitmapFactory();

    PoolFactory getPoolFactory();

    ProgressiveJpegConfig getProgressiveJpegConfig();

    Set<RequestListener2> getRequestListener2s();

    Set<RequestListener> getRequestListeners();

    DiskCacheConfig getSmallImageDiskCacheConfig();

    boolean isDiskCacheEnabled();

    boolean isDownsampleEnabled();

    boolean isResizeAndRotateEnabledForNetwork();
}
