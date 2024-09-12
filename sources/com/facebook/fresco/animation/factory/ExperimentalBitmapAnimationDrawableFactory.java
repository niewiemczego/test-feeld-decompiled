package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
    private final Supplier<Boolean> mUseDeepEqualsForCacheKey;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2, Supplier<Boolean> supplier3) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
        this.mUseDeepEqualsForCacheKey = supplier3;
    }

    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    public AnimatedDrawable2 createDrawable(CloseableImage closeableImage) {
        CloseableAnimatedImage closeableAnimatedImage = (CloseableAnimatedImage) closeableImage;
        AnimatedImage image = closeableAnimatedImage.getImage();
        return new AnimatedDrawable2(createAnimationBackend((AnimatedImageResult) Preconditions.checkNotNull(closeableAnimatedImage.getImageResult()), image != null ? image.getAnimatedBitmapConfig() : null));
    }

    private AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult, @Nullable Bitmap.Config config) {
        BitmapFramePreparer bitmapFramePreparer;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(createBitmapFrameCache, createAnimatedDrawableBackend);
        int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (intValue > 0) {
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(intValue);
            bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, config);
            fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
        } else {
            fixedNumberBitmapFramePreparationStrategy = null;
            bitmapFramePreparer = null;
        }
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(new BitmapAnimationBackend(this.mPlatformBitmapFactory, createBitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer, @Nullable Bitmap.Config config) {
        PlatformBitmapFactory platformBitmapFactory = this.mPlatformBitmapFactory;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return new DefaultBitmapFramePreparer(platformBitmapFactory, bitmapFrameRenderer, config, this.mExecutorServiceForFramePreparing);
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        int intValue = this.mCachingStrategySupplier.get().intValue();
        if (intValue == 1) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        if (intValue == 2) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        if (intValue != 3) {
            return new NoOpCache();
        }
        return new KeepLastFrameCache();
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode(), this.mUseDeepEqualsForCacheKey.get().booleanValue()), this.mBackingCache);
    }
}
