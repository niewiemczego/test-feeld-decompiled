package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory {
    private final boolean mAllowDelay;
    Producer<EncodedImage> mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
    Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
    Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences = new HashMap();
    Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences = new HashMap();
    private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
    private final ContentResolver mContentResolver;
    Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
    private final boolean mDiskCacheEnabled;
    private final boolean mDownsampleEnabled;
    private final ImageTranscoderFactory mImageTranscoderFactory;
    private final boolean mIsDiskCacheProbingEnabled;
    private final boolean mIsEncodedMemoryCacheProbingEnabled;
    Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mLocalContentUriEncodedImageProducerSequence;
    Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
    Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
    Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
    Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
    private final NetworkFetcher mNetworkFetcher;
    private final boolean mPartialImageCachingEnabled;
    Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences = new HashMap();
    private final ProducerFactory mProducerFactory;
    Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
    private final boolean mResizeAndRotateEnabledForNetwork;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    private final boolean mUseBitmapPrepareToDraw;
    private final boolean mUseCombinedNetworkAndCacheProducer;
    private final boolean mWebpSupportEnabled;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, boolean z2, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z3, boolean z4, boolean z5, boolean z6, ImageTranscoderFactory imageTranscoderFactory, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.mContentResolver = contentResolver;
        this.mProducerFactory = producerFactory;
        this.mNetworkFetcher = networkFetcher;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mWebpSupportEnabled = z2;
        this.mUseCombinedNetworkAndCacheProducer = z9;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mDownsampleEnabled = z3;
        this.mUseBitmapPrepareToDraw = z4;
        this.mPartialImageCachingEnabled = z5;
        this.mDiskCacheEnabled = z6;
        this.mImageTranscoderFactory = imageTranscoderFactory;
        this.mIsEncodedMemoryCacheProbingEnabled = z7;
        this.mIsDiskCacheProbingEnabled = z8;
        this.mAllowDelay = z10;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
            }
            validateEncodedImageRequest(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 2 || sourceUriType == 3) {
                Producer<CloseableReference<PooledByteBuffer>> localFileFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return localFileFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            } else {
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
            }
            if (this.mNetworkEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
                }
                this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mNetworkEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
            }
            if (this.mLocalFileEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
                }
                this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalFileEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
            }
            if (this.mLocalContentUriEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
                }
                this.mLocalContentUriEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalContentUriFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalContentUriEncodedImageProducerSequence;
    }

    public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(imageRequest.getSourceUri()));
    }

    private static void validateEncodedImageRequest(ImageRequest imageRequest) {
        Preconditions.checkNotNull(imageRequest);
        Preconditions.checkArgument(Boolean.valueOf(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()));
    }

    public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (imageRequest.getPostprocessor() != null) {
            basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
        }
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        if (this.mAllowDelay && imageRequest.getDelayMs() > 0) {
            basicDecodedImageSequence = getDelaySequence(basicDecodedImageSequence);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return basicDecodedImageSequence;
    }

    public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce A[FINALLY_INSNS] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getBasicDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest r4) {
        /*
            r3 = this;
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "ProducerSequenceFactory#getBasicDecodedImageSequence"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)     // Catch:{ all -> 0x00c7 }
        L_0x000b:
            com.facebook.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x00c7 }
            android.net.Uri r0 = r4.getSourceUri()     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = "Uri is null."
            com.facebook.common.internal.Preconditions.checkNotNull(r0, r1)     // Catch:{ all -> 0x00c7 }
            int r4 = r4.getSourceUriType()     // Catch:{ all -> 0x00c7 }
            if (r4 == 0) goto L_0x00b9
            switch(r4) {
                case 2: goto L_0x00ab;
                case 3: goto L_0x009d;
                case 4: goto L_0x0075;
                case 5: goto L_0x0067;
                case 6: goto L_0x0059;
                case 7: goto L_0x004b;
                case 8: goto L_0x003d;
                default: goto L_0x0020;
            }     // Catch:{ all -> 0x00c7 }
        L_0x0020:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r1.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "Unsupported uri scheme! Uri is: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = getShortenedUriString(r0)     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c7 }
            r4.<init>(r0)     // Catch:{ all -> 0x00c7 }
            throw r4     // Catch:{ all -> 0x00c7 }
        L_0x003d:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getQualifiedResourceFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x004a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x004a:
            return r4
        L_0x004b:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getDataFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0058
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0058:
            return r4
        L_0x0059:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalResourceFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0066
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0066:
            return r4
        L_0x0067:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalAssetFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0074
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0074:
            return r4
        L_0x0075:
            android.content.ContentResolver r4 = r3.mContentResolver     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = r4.getType(r0)     // Catch:{ all -> 0x00c7 }
            boolean r4 = com.facebook.common.media.MediaUtils.isVideo(r4)     // Catch:{ all -> 0x00c7 }
            if (r4 == 0) goto L_0x008f
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalVideoFileFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x008e
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x008e:
            return r4
        L_0x008f:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalContentUriFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x009c
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x009c:
            return r4
        L_0x009d:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalImageFileFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00aa
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00aa:
            return r4
        L_0x00ab:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getLocalVideoFileFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00b8
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00b8:
            return r4
        L_0x00b9:
            com.facebook.imagepipeline.producers.Producer r4 = r3.getNetworkFetchSequence()     // Catch:{ all -> 0x00c7 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00c6
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00c6:
            return r4
        L_0x00c7:
            r4 = move-exception
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00d1
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00d1:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory.getBasicDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest):com.facebook.imagepipeline.producers.Producer");
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.mNetworkFetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchSequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundNetworkFetchToEncodedMemorySequence;
    }

    private synchronized Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mNetworkFetchToEncodedMemoryPrefetchSequence = this.mProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        Object obj;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.mCommonNetworkFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            if (this.mUseCombinedNetworkAndCacheProducer) {
                obj = this.mProducerFactory.newCombinedNetworkAndCacheProducer(this.mNetworkFetcher);
            } else {
                obj = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher));
            }
            AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer((Producer) Preconditions.checkNotNull(obj));
            this.mCommonNetworkFetchToEncodedMemorySequence = newAddImageTransformMetaDataProducer;
            this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled, this.mImageTranscoderFactory);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mCommonNetworkFetchToEncodedMemorySequence;
    }

    private synchronized Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mLocalFileFetchToEncodedMemoryPrefetchSequence = this.mProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalFileFetchToEncodedMemorySequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalContentUriFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalContentUriFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalContentUriFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        if (this.mLocalImageFileFetchSequence == null) {
            this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
        }
        return this.mLocalImageFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        if (this.mLocalVideoFileFetchSequence == null) {
            this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
        }
        return this.mLocalVideoFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        if (this.mLocalContentUriFetchSequence == null) {
            this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer()});
        }
        return this.mLocalContentUriFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        if (this.mQualifiedResourceFetchSequence == null) {
            this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
        }
        return this.mQualifiedResourceFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        if (this.mLocalResourceFetchSequence == null) {
            this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
        }
        return this.mLocalResourceFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        if (this.mLocalAssetFetchSequence == null) {
            this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
        }
        return this.mLocalAssetFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        if (this.mDataFetchSequence == null) {
            Producer newDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
            if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
                newDataFetchProducer = this.mProducerFactory.newWebpTranscodeProducer(newDataFetchProducer);
            }
            this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(newDataFetchProducer), true, this.mImageTranscoderFactory));
        }
        return this.mDataFetchSequence;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer) {
        return newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalExifThumbnailProducer()});
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> producer) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(producer));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newBitmapCacheGetToBitmapCacheSequence;
    }

    private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> producer) {
        if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
            producer = this.mProducerFactory.newWebpTranscodeProducer(producer);
        }
        if (this.mDiskCacheEnabled) {
            producer = newDiskCacheSequence(producer);
        }
        EncodedMemoryCacheProducer newEncodedMemoryCacheProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(producer);
        if (!this.mIsDiskCacheProbingEnabled) {
            return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(newEncodedMemoryCacheProducer);
        }
        return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(this.mProducerFactory.newEncodedProbeProducer(newEncodedMemoryCacheProducer));
    }

    private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> producer) {
        DiskCacheWriteProducer diskCacheWriteProducer;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        }
        if (this.mPartialImageCachingEnabled) {
            diskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(this.mProducerFactory.newPartialDiskCacheProducer(producer));
        } else {
            diskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(producer);
        }
        DiskCacheReadProducer newDiskCacheReadProducer = this.mProducerFactory.newDiskCacheReadProducer(diskCacheWriteProducer);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newDiskCacheReadProducer;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer newBackgroundThreadHandoffProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.mProducerFactory.newBitmapMemoryCacheProducer(producer)), this.mThreadHandoffProducerQueue);
        if (!this.mIsEncodedMemoryCacheProbingEnabled && !this.mIsDiskCacheProbingEnabled) {
            return this.mProducerFactory.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer);
        }
        return this.mProducerFactory.newBitmapProbeProducer(this.mProducerFactory.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer));
    }

    private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory)));
    }

    private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return this.mProducerFactory.newResizeAndRotateProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producer2;
        producer2 = this.mPostprocessorSequences.get(producer);
        if (producer2 == null) {
            producer2 = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(this.mProducerFactory.newPostprocessorProducer(producer));
            this.mPostprocessorSequences.put(producer, producer2);
        }
        return producer2;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.facebook.imagepipeline.producers.Producer, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.facebook.imagepipeline.producers.Producer<java.lang.Void> getDecodedImagePrefetchSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<java.lang.Void>> r0 = r2.mCloseableImagePrefetchSequences     // Catch:{ all -> 0x0018 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0018 }
            com.facebook.imagepipeline.producers.Producer r0 = (com.facebook.imagepipeline.producers.Producer) r0     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0016
            com.facebook.imagepipeline.core.ProducerFactory r0 = r2.mProducerFactory     // Catch:{ all -> 0x0018 }
            com.facebook.imagepipeline.producers.SwallowResultProducer r0 = r0.newSwallowResultProducer(r3)     // Catch:{ all -> 0x0018 }
            java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<java.lang.Void>> r1 = r2.mCloseableImagePrefetchSequences     // Catch:{ all -> 0x0018 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r2)
            return r0
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ProducerSequenceFactory.getDecodedImagePrefetchSequence(com.facebook.imagepipeline.producers.Producer):com.facebook.imagepipeline.producers.Producer");
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producer2;
        producer2 = this.mBitmapPrepareSequences.get(producer);
        if (producer2 == null) {
            producer2 = this.mProducerFactory.newBitmapPrepareProducer(producer);
            this.mBitmapPrepareSequences.put(producer, producer2);
        }
        return producer2;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDelaySequence(Producer<CloseableReference<CloseableImage>> producer) {
        return this.mProducerFactory.newDelayProducer(producer);
    }

    private static String getShortenedUriString(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }
}
