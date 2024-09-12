package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class ImagePipelineConfig implements ImagePipelineConfigInterface {
    private static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    @Nullable
    private final MemoryCache<CacheKey, CloseableImage> mBitmapCache;
    private final Bitmap.Config mBitmapConfig;
    @Nullable
    private final CountingMemoryCache.EntryStateObserver<CacheKey> mBitmapMemoryCacheEntryStateObserver;
    private final BitmapMemoryCacheFactory mBitmapMemoryCacheFactory;
    private final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    private final MemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    private final CacheKeyFactory mCacheKeyFactory;
    @Nullable
    private final CallerContextVerifier mCallerContextVerifier;
    private final CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
    private final Context mContext;
    private final boolean mDiskCacheEnabled;
    private final boolean mDownsampleEnabled;
    @Nullable
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    private final ExecutorSupplier mExecutorSupplier;
    private final FileCacheFactory mFileCacheFactory;
    private final int mHttpNetworkTimeout;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    @Nullable
    private final ImageDecoder mImageDecoder;
    @Nullable
    private final ImageDecoderConfig mImageDecoderConfig;
    private final ImagePipelineExperiments mImagePipelineExperiments;
    @Nullable
    private final ImageTranscoderFactory mImageTranscoderFactory;
    @Nullable
    private final Integer mImageTranscoderType;
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final DiskCacheConfig mMainDiskCacheConfig;
    private final int mMemoryChunkType;
    private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private final NetworkFetcher mNetworkFetcher;
    @Nullable
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final PoolFactory mPoolFactory;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final Set<RequestListener2> mRequestListener2s;
    private final Set<RequestListener> mRequestListeners;
    private final boolean mResizeAndRotateEnabledForNetwork;
    @Nullable
    private final SerialExecutorService mSerialExecutorServiceForAnimatedImages;
    private final DiskCacheConfig mSmallImageDiskCacheConfig;

    private ImagePipelineConfig(Builder builder) {
        Supplier<MemoryCacheParams> supplier;
        MemoryCache.CacheTrimStrategy cacheTrimStrategy;
        CacheKeyFactory cacheKeyFactory;
        FileCacheFactory fileCacheFactory;
        Supplier<MemoryCacheParams> supplier2;
        ImageCacheStatsTracker imageCacheStatsTracker;
        Supplier<Boolean> supplier3;
        DiskCacheConfig diskCacheConfig;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        int i;
        NetworkFetcher networkFetcher;
        PoolFactory poolFactory;
        ProgressiveJpegConfig progressiveJpegConfig;
        Set<RequestListener> set;
        Set<RequestListener2> set2;
        ExecutorSupplier executorSupplier;
        BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineExperiments build = builder.mExperimentsBuilder.build();
        this.mImagePipelineExperiments = build;
        if (builder.mBitmapMemoryCacheParamsSupplier == null) {
            supplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) Preconditions.checkNotNull(builder.mContext.getSystemService("activity")));
        } else {
            supplier = builder.mBitmapMemoryCacheParamsSupplier;
        }
        this.mBitmapMemoryCacheParamsSupplier = supplier;
        if (builder.mBitmapMemoryCacheTrimStrategy == null) {
            cacheTrimStrategy = new BitmapMemoryCacheTrimStrategy();
        } else {
            cacheTrimStrategy = builder.mBitmapMemoryCacheTrimStrategy;
        }
        this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
        this.mBitmapMemoryCacheEntryStateObserver = builder.mBitmapMemoryCacheEntryStateObserver;
        this.mBitmapConfig = builder.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : builder.mBitmapConfig;
        if (builder.mCacheKeyFactory == null) {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
        } else {
            cacheKeyFactory = builder.mCacheKeyFactory;
        }
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mContext = (Context) Preconditions.checkNotNull(builder.mContext);
        if (builder.mFileCacheFactory == null) {
            fileCacheFactory = new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory());
        } else {
            fileCacheFactory = builder.mFileCacheFactory;
        }
        this.mFileCacheFactory = fileCacheFactory;
        this.mDownsampleEnabled = builder.mDownsampleEnabled;
        if (builder.mEncodedMemoryCacheParamsSupplier == null) {
            supplier2 = new DefaultEncodedMemoryCacheParamsSupplier();
        } else {
            supplier2 = builder.mEncodedMemoryCacheParamsSupplier;
        }
        this.mEncodedMemoryCacheParamsSupplier = supplier2;
        if (builder.mImageCacheStatsTracker == null) {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
        } else {
            imageCacheStatsTracker = builder.mImageCacheStatsTracker;
        }
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mImageDecoder = builder.mImageDecoder;
        this.mImageTranscoderFactory = getImageTranscoderFactory(builder);
        this.mImageTranscoderType = builder.mImageTranscoderType;
        if (builder.mIsPrefetchEnabledSupplier == null) {
            supplier3 = new Supplier<Boolean>() {
                public Boolean get() {
                    return true;
                }
            };
        } else {
            supplier3 = builder.mIsPrefetchEnabledSupplier;
        }
        this.mIsPrefetchEnabledSupplier = supplier3;
        if (builder.mMainDiskCacheConfig == null) {
            diskCacheConfig = getDefaultMainDiskCacheConfig(builder.mContext);
        } else {
            diskCacheConfig = builder.mMainDiskCacheConfig;
        }
        this.mMainDiskCacheConfig = diskCacheConfig;
        if (builder.mMemoryTrimmableRegistry == null) {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        } else {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        this.mMemoryChunkType = getMemoryChunkType(builder, build);
        if (builder.mHttpConnectionTimeout < 0) {
            i = 30000;
        } else {
            i = builder.mHttpConnectionTimeout;
        }
        this.mHttpNetworkTimeout = i;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
        }
        if (builder.mNetworkFetcher == null) {
            networkFetcher = new HttpUrlConnectionNetworkFetcher(i);
        } else {
            networkFetcher = builder.mNetworkFetcher;
        }
        this.mNetworkFetcher = networkFetcher;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mPlatformBitmapFactory = builder.mPlatformBitmapFactory;
        if (builder.mPoolFactory == null) {
            poolFactory = new PoolFactory(PoolConfig.newBuilder().build());
        } else {
            poolFactory = builder.mPoolFactory;
        }
        this.mPoolFactory = poolFactory;
        if (builder.mProgressiveJpegConfig == null) {
            progressiveJpegConfig = new SimpleProgressiveJpegConfig();
        } else {
            progressiveJpegConfig = builder.mProgressiveJpegConfig;
        }
        this.mProgressiveJpegConfig = progressiveJpegConfig;
        if (builder.mRequestListeners == null) {
            set = new HashSet<>();
        } else {
            set = builder.mRequestListeners;
        }
        this.mRequestListeners = set;
        if (builder.mRequestListener2s == null) {
            set2 = new HashSet<>();
        } else {
            set2 = builder.mRequestListener2s;
        }
        this.mRequestListener2s = set2;
        this.mResizeAndRotateEnabledForNetwork = builder.mResizeAndRotateEnabledForNetwork;
        this.mSmallImageDiskCacheConfig = builder.mSmallImageDiskCacheConfig != null ? builder.mSmallImageDiskCacheConfig : diskCacheConfig;
        this.mImageDecoderConfig = builder.mImageDecoderConfig;
        int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        if (builder.mExecutorSupplier == null) {
            executorSupplier = new DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads);
        } else {
            executorSupplier = builder.mExecutorSupplier;
        }
        this.mExecutorSupplier = executorSupplier;
        this.mDiskCacheEnabled = builder.mDiskCacheEnabled;
        this.mCallerContextVerifier = builder.mCallerContextVerifier;
        this.mCloseableReferenceLeakTracker = builder.mCloseableReferenceLeakTracker;
        this.mBitmapCache = builder.mBitmapMemoryCache;
        if (builder.mBitmapMemoryCacheFactory == null) {
            bitmapMemoryCacheFactory = new CountingLruBitmapMemoryCacheFactory();
        } else {
            bitmapMemoryCacheFactory = builder.mBitmapMemoryCacheFactory;
        }
        this.mBitmapMemoryCacheFactory = bitmapMemoryCacheFactory;
        this.mEncodedMemoryCache = builder.mEncodedMemoryCache;
        this.mSerialExecutorServiceForAnimatedImages = builder.mSerialExecutorServiceForAnimatedImages;
        WebpBitmapFactory webpBitmapFactory = build.getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            setWebpBitmapFactory(webpBitmapFactory, build, new HoneycombBitmapCreator(getPoolFactory()));
        } else if (build.isWebpSupportEnabled() && WebpSupportStatus.sIsWebpSupportRequired && (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) != null) {
            setWebpBitmapFactory(loadWebpBitmapFactoryIfExists, build, new HoneycombBitmapCreator(getPoolFactory()));
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
        if (webpErrorLogger != null) {
            webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
        }
        if (bitmapCreator != null) {
            webpBitmapFactory.setBitmapCreator(bitmapCreator);
        }
    }

    private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return DiskCacheConfig.newBuilder(context).build();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mBitmapMemoryCacheParamsSupplier;
    }

    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mBitmapMemoryCacheTrimStrategy;
    }

    @Nullable
    public CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        return this.mBitmapMemoryCacheEntryStateObserver;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mFileCacheFactory;
    }

    public boolean isDownsampleEnabled() {
        return this.mDownsampleEnabled;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mEncodedMemoryCacheParamsSupplier;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mExecutorSupplier;
    }

    @Nullable
    public SerialExecutorService getExecutorServiceForAnimatedImages() {
        return this.mSerialExecutorServiceForAnimatedImages;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImageCacheStatsTracker;
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.mImageDecoder;
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImageTranscoderFactory;
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.mImageTranscoderType;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mIsPrefetchEnabledSupplier;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mMainDiskCacheConfig;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public int getMemoryChunkType() {
        return this.mMemoryChunkType;
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mNetworkFetcher;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    public PoolFactory getPoolFactory() {
        return this.mPoolFactory;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mProgressiveJpegConfig;
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mRequestListeners);
    }

    public Set<RequestListener2> getRequestListener2s() {
        return Collections.unmodifiableSet(this.mRequestListener2s);
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.mResizeAndRotateEnabledForNetwork;
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mSmallImageDiskCacheConfig;
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImageDecoderConfig;
    }

    @Nullable
    public CallerContextVerifier getCallerContextVerifier() {
        return this.mCallerContextVerifier;
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineExperiments;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.mCloseableReferenceLeakTracker;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    @Nullable
    private static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        if (builder.mImageTranscoderFactory != null && builder.mImageTranscoderType != null) {
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        } else if (builder.mImageTranscoderFactory != null) {
            return builder.mImageTranscoderFactory;
        } else {
            return null;
        }
    }

    private static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        if (builder.mMemoryChunkType != null) {
            return builder.mMemoryChunkType.intValue();
        }
        if (imagePipelineExperiments.getMemoryType() == 2 && Build.VERSION.SDK_INT >= 27) {
            return 2;
        }
        if (imagePipelineExperiments.getMemoryType() == 1) {
            return 1;
        }
        imagePipelineExperiments.getMemoryType();
        return 0;
    }

    @Nullable
    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        return this.mBitmapCache;
    }

    @Nullable
    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.mEncodedMemoryCache;
    }

    public BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
        return this.mBitmapMemoryCacheFactory;
    }

    public static class DefaultImageRequestConfig {
        private boolean mProgressiveRenderingEnabled;

        private DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.mProgressiveRenderingEnabled = z;
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public Bitmap.Config mBitmapConfig;
        /* access modifiers changed from: private */
        @Nullable
        public MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
        /* access modifiers changed from: private */
        @Nullable
        public CountingMemoryCache.EntryStateObserver<CacheKey> mBitmapMemoryCacheEntryStateObserver;
        /* access modifiers changed from: private */
        @Nullable
        public BitmapMemoryCacheFactory mBitmapMemoryCacheFactory;
        /* access modifiers changed from: private */
        @Nullable
        public Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        /* access modifiers changed from: private */
        @Nullable
        public MemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        /* access modifiers changed from: private */
        @Nullable
        public CacheKeyFactory mCacheKeyFactory;
        /* access modifiers changed from: private */
        @Nullable
        public CallerContextVerifier mCallerContextVerifier;
        /* access modifiers changed from: private */
        public CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
        /* access modifiers changed from: private */
        public final Context mContext;
        /* access modifiers changed from: private */
        public boolean mDiskCacheEnabled;
        /* access modifiers changed from: private */
        public boolean mDownsampleEnabled;
        /* access modifiers changed from: private */
        @Nullable
        public MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
        /* access modifiers changed from: private */
        @Nullable
        public Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        /* access modifiers changed from: private */
        @Nullable
        public ExecutorSupplier mExecutorSupplier;
        /* access modifiers changed from: private */
        public final ImagePipelineExperiments.Builder mExperimentsBuilder;
        /* access modifiers changed from: private */
        @Nullable
        public FileCacheFactory mFileCacheFactory;
        /* access modifiers changed from: private */
        public int mHttpConnectionTimeout;
        /* access modifiers changed from: private */
        @Nullable
        public ImageCacheStatsTracker mImageCacheStatsTracker;
        /* access modifiers changed from: private */
        @Nullable
        public ImageDecoder mImageDecoder;
        /* access modifiers changed from: private */
        @Nullable
        public ImageDecoderConfig mImageDecoderConfig;
        /* access modifiers changed from: private */
        @Nullable
        public ImageTranscoderFactory mImageTranscoderFactory;
        /* access modifiers changed from: private */
        @Nullable
        public Integer mImageTranscoderType;
        /* access modifiers changed from: private */
        @Nullable
        public Supplier<Boolean> mIsPrefetchEnabledSupplier;
        /* access modifiers changed from: private */
        @Nullable
        public DiskCacheConfig mMainDiskCacheConfig;
        /* access modifiers changed from: private */
        @Nullable
        public Integer mMemoryChunkType;
        /* access modifiers changed from: private */
        @Nullable
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        /* access modifiers changed from: private */
        @Nullable
        public NetworkFetcher mNetworkFetcher;
        /* access modifiers changed from: private */
        @Nullable
        public PlatformBitmapFactory mPlatformBitmapFactory;
        /* access modifiers changed from: private */
        @Nullable
        public PoolFactory mPoolFactory;
        /* access modifiers changed from: private */
        @Nullable
        public ProgressiveJpegConfig mProgressiveJpegConfig;
        /* access modifiers changed from: private */
        @Nullable
        public Set<RequestListener2> mRequestListener2s;
        /* access modifiers changed from: private */
        @Nullable
        public Set<RequestListener> mRequestListeners;
        /* access modifiers changed from: private */
        public boolean mResizeAndRotateEnabledForNetwork;
        /* access modifiers changed from: private */
        @Nullable
        public SerialExecutorService mSerialExecutorServiceForAnimatedImages;
        /* access modifiers changed from: private */
        @Nullable
        public DiskCacheConfig mSmallImageDiskCacheConfig;

        private Builder(Context context) {
            this.mDownsampleEnabled = false;
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mCloseableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            this.mContext = (Context) Preconditions.checkNotNull(context);
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
                com.facebook.common.internal.Supplier r1 = (com.facebook.common.internal.Supplier) r1
                r0.mBitmapMemoryCacheParamsSupplier = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineConfig.Builder.setBitmapMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier):com.facebook.imagepipeline.core.ImagePipelineConfig$Builder");
        }

        public Builder setBitmapMemoryCacheEntryStateObserver(CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
            this.mBitmapMemoryCacheEntryStateObserver = entryStateObserver;
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.mCacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i) {
            this.mHttpConnectionTimeout = i;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.mFileCacheFactory = fileCacheFactory;
            return this;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }

        public Builder setDownsampleEnabled(boolean z) {
            this.mDownsampleEnabled = z;
            return this;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEncodedMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
                com.facebook.common.internal.Supplier r1 = (com.facebook.common.internal.Supplier) r1
                r0.mEncodedMemoryCacheParamsSupplier = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineConfig.Builder.setEncodedMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier):com.facebook.imagepipeline.core.ImagePipelineConfig$Builder");
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.mExecutorSupplier = executorSupplier;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.mImageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.mImageDecoder = imageDecoder;
            return this;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        public Builder setImageTranscoderType(int i) {
            this.mImageTranscoderType = Integer.valueOf(i);
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.mImageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.mIsPrefetchEnabledSupplier = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mMainDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public Builder setMemoryChunkType(int i) {
            this.mMemoryChunkType = Integer.valueOf(i);
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.mNetworkFetcher = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.mPlatformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.mPoolFactory = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.mProgressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.mRequestListeners = set;
            return this;
        }

        public Builder setRequestListener2s(Set<RequestListener2> set) {
            this.mRequestListener2s = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            this.mResizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mSmallImageDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.mImageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.mCallerContextVerifier = callerContextVerifier;
            return this;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.mCloseableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public Builder setBitmapMemoryCache(@Nullable MemoryCache<CacheKey, CloseableImage> memoryCache) {
            this.mBitmapMemoryCache = memoryCache;
            return this;
        }

        public Builder setEncodedMemoryCache(@Nullable MemoryCache<CacheKey, PooledByteBuffer> memoryCache) {
            this.mEncodedMemoryCache = memoryCache;
            return this;
        }

        public Builder setExecutorServiceForAnimatedImages(@Nullable SerialExecutorService serialExecutorService) {
            this.mSerialExecutorServiceForAnimatedImages = serialExecutorService;
            return this;
        }

        public Builder setBitmapMemoryCacheFactory(@Nullable BitmapMemoryCacheFactory bitmapMemoryCacheFactory) {
            this.mBitmapMemoryCacheFactory = bitmapMemoryCacheFactory;
            return this;
        }

        @Nullable
        public BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
            return this.mBitmapMemoryCacheFactory;
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this);
        }
    }
}
