package com.facebook.imagepipeline.animated.factory;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

public class AnimatedFactoryProvider {
    @Nullable
    private static AnimatedFactory sImpl;
    private static boolean sImplLoaded;

    @Nullable
    public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z, @Nullable ExecutorService executorService) {
        if (!sImplLoaded) {
            try {
                sImpl = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE, SerialExecutorService.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z), executorService});
            } catch (Throwable unused) {
            }
            if (sImpl != null) {
                sImplLoaded = true;
            }
        }
        return sImpl;
    }
}
