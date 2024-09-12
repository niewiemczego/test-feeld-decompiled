package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

public class AnimatedFactoryV2Impl implements AnimatedFactory {
    private static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;
    @Nullable
    private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    @Nullable
    private DrawableFactory mAnimatedDrawableFactory;
    @Nullable
    private AnimatedDrawableUtil mAnimatedDrawableUtil;
    @Nullable
    private AnimatedImageFactory mAnimatedImageFactory;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    /* access modifiers changed from: private */
    public final boolean mDownscaleFrameToDrawableDimensions;
    private final ExecutorSupplier mExecutorSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    @Nullable
    private SerialExecutorService mSerialExecutorService;

    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z, SerialExecutorService serialExecutorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mSerialExecutorService = serialExecutorService;
    }

    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(@Nullable Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            this.mAnimatedDrawableFactory = createDrawableFactory();
        }
        return this.mAnimatedDrawableFactory;
    }

    public ImageDecoder getGifDecoder() {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, imageDecodeOptions.animatedBitmapConfig);
            }
        };
    }

    public ImageDecoder getWebPDecoder() {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, imageDecodeOptions.animatedBitmapConfig);
            }
        };
    }

    private ExperimentalBitmapAnimationDrawableFactory createDrawableFactory() {
        AnonymousClass3 r7 = new Supplier<Integer>() {
            public Integer get() {
                return 2;
            }
        };
        ExecutorService executorService = this.mSerialExecutorService;
        if (executorService == null) {
            executorService = new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode());
        }
        AnonymousClass4 r8 = new Supplier<Integer>() {
            public Integer get() {
                return 3;
            }
        };
        Supplier<Boolean> supplier = Suppliers.BOOLEAN_FALSE;
        return new ExperimentalBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), executorService, RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, r7, r8, supplier);
    }

    /* access modifiers changed from: private */
    public AnimatedDrawableUtil getAnimatedDrawableUtil() {
        if (this.mAnimatedDrawableUtil == null) {
            this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
        }
        return this.mAnimatedDrawableUtil;
    }

    /* access modifiers changed from: private */
    public AnimatedImageFactory getAnimatedImageFactory() {
        if (this.mAnimatedImageFactory == null) {
            this.mAnimatedImageFactory = buildAnimatedImageFactory();
        }
        return this.mAnimatedImageFactory;
    }

    private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.mAnimatedDrawableBackendProvider == null) {
            this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() {
                public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, @Nullable Rect rect) {
                    return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect, AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
                }
            };
        }
        return this.mAnimatedDrawableBackendProvider;
    }

    private AnimatedImageFactory buildAnimatedImageFactory() {
        return new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider() {
            public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, @Nullable Rect rect) {
                return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect, AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
            }
        }, this.mPlatformBitmapFactory);
    }
}
