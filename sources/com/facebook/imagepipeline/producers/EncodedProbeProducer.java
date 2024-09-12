package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import javax.annotation.Nullable;

public class EncodedProbeProducer implements Producer<EncodedImage> {
    public static final String PRODUCER_NAME = "EncodedProbeProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    private final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public EncodedProbeProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
        this.mDiskCacheHistory = boundedLinkedHashSet2;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedProbeProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            ProbeConsumer probeConsumer = new ProbeConsumer(consumer, producerContext, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
            producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, (Map<String, String>) null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(probeConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private static class ProbeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final CacheKeyFactory mCacheKeyFactory;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
        private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
        private final ProducerContext mProducerContext;
        private final BufferedDiskCache mSmallImageBufferedDiskCache;

        public ProbeConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
            this.mDiskCacheHistory = boundedLinkedHashSet2;
        }

        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedProbeProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && encodedImage != null && !statusHasAnyFlag(i, 10)) {
                    if (encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                        this.mEncodedMemoryCacheHistory.add(encodedCacheKey);
                        if ("memory_encoded".equals(this.mProducerContext.getExtra("origin"))) {
                            if (!this.mDiskCacheHistory.contains(encodedCacheKey)) {
                                (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache).addKeyForAsyncProbing(encodedCacheKey);
                                this.mDiskCacheHistory.add(encodedCacheKey);
                            }
                        } else if ("disk".equals(this.mProducerContext.getExtra("origin"))) {
                            this.mDiskCacheHistory.add(encodedCacheKey);
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
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }
}
