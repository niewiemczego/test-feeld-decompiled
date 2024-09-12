package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.hermes.intl.Constants;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import javax.annotation.Nullable;

public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        EncodedImage encodedImage;
        Consumer<EncodedImage> consumer2 = consumer;
        ProducerContext producerContext2 = producerContext;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext2, PRODUCER_NAME);
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<PooledByteBuffer> closeableReference = this.mMemoryCache.get(encodedCacheKey);
            Map map = null;
            if (closeableReference != null) {
                try {
                    encodedImage = new EncodedImage(closeableReference);
                    if (producerListener.requiresExtraMap(producerContext2, PRODUCER_NAME)) {
                        map = ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    }
                    producerListener.onProducerFinishWithSuccess(producerContext2, PRODUCER_NAME, map);
                    producerListener.onUltimateProducerReached(producerContext2, PRODUCER_NAME, true);
                    producerContext2.putOriginExtra("memory_encoded");
                    consumer2.onProgressUpdate(1.0f);
                    consumer2.onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                    throw th;
                }
            } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext2, PRODUCER_NAME, producerListener.requiresExtraMap(producerContext2, PRODUCER_NAME) ? ImmutableMap.of("cached_value_found", Constants.CASEFIRST_FALSE) : null);
                producerListener.onUltimateProducerReached(producerContext2, PRODUCER_NAME, false);
                producerContext2.putOriginExtra("memory_encoded", "nil-result");
                consumer2.onNewResult(null, 1);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } else {
                EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled(), producerContext.getImagePipelineConfig().getExperiments().isEncodedCacheEnabled());
                if (producerListener.requiresExtraMap(producerContext2, PRODUCER_NAME)) {
                    map = ImmutableMap.of("cached_value_found", Constants.CASEFIRST_FALSE);
                }
                producerListener.onProducerFinishWithSuccess(producerContext2, PRODUCER_NAME, map);
                this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext2);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean mEncodedCacheEnabled;
        private final boolean mIsMemoryCacheEnabled;
        private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        private final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z, boolean z2) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
            this.mEncodedCacheEnabled = z2;
        }

        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            CloseableReference<PooledByteBuffer> byteBufferRef;
            CloseableReference<PooledByteBuffer> closeableReference;
            EncodedImage encodedImage2;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && encodedImage != null && !statusHasAnyFlag(i, 10)) {
                    if (encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        byteBufferRef = encodedImage.getByteBufferRef();
                        if (byteBufferRef != null) {
                            closeableReference = null;
                            if (this.mEncodedCacheEnabled && this.mIsMemoryCacheEnabled) {
                                closeableReference = this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef);
                            }
                            CloseableReference.closeSafely((CloseableReference<?>) byteBufferRef);
                            if (closeableReference != null) {
                                encodedImage2 = new EncodedImage(closeableReference);
                                encodedImage2.copyMetaDataFrom(encodedImage);
                                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                                getConsumer().onProgressUpdate(1.0f);
                                getConsumer().onNewResult(encodedImage2, i);
                                EncodedImage.closeSafely(encodedImage2);
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                    return;
                                }
                                return;
                            }
                        }
                        getConsumer().onNewResult(encodedImage, i);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                }
                getConsumer().onNewResult(encodedImage, i);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Throwable th) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                throw th;
            }
        }
    }
}
