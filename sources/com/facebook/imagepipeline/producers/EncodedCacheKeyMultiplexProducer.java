package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage> {
    private final CacheKeyFactory mCacheKeyFactory;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z, Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", ProducerContext.ExtraKeys.MULTIPLEX_ENCODED_COUNT, z);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* access modifiers changed from: protected */
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    @Nullable
    public EncodedImage cloneOrNull(@Nullable EncodedImage encodedImage) {
        return EncodedImage.cloneOrNull(encodedImage);
    }
}
