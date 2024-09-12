package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>> {
    private final CacheKeyFactory mCacheKeyFactory;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer, "BitmapMemoryCacheKeyMultiplexProducer", ProducerContext.ExtraKeys.MULTIPLEX_BITMAP_COUNT);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* access modifiers changed from: protected */
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    @Nullable
    public CloseableReference<CloseableImage> cloneOrNull(@Nullable CloseableReference<CloseableImage> closeableReference) {
        return CloseableReference.cloneOrNull(closeableReference);
    }
}
