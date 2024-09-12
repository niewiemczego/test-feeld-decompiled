package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imageutils.BitmapUtil;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_BYTES = "byteCount";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    private static final int MAX_BITMAP_SIZE = 104857600;
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    private final ByteArrayPool mByteArrayPool;
    /* access modifiers changed from: private */
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    private final boolean mDecodeCancellationEnabled;
    /* access modifiers changed from: private */
    public final boolean mDownsampleEnabled;
    /* access modifiers changed from: private */
    public final boolean mDownsampleEnabledForNetwork;
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    /* access modifiers changed from: private */
    public final ImageDecoder mImageDecoder;
    private final Producer<EncodedImage> mInputProducer;
    private final int mMaxBitmapSize;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    /* access modifiers changed from: private */
    @Nullable
    public final Runnable mReclaimMemoryRunnable;
    /* access modifiers changed from: private */
    public final Supplier<Boolean> mRecoverFromDecoderOOM;

    /* JADX WARNING: type inference failed for: r8v0, types: [com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DecodeProducer(com.facebook.common.memory.ByteArrayPool r1, java.util.concurrent.Executor r2, com.facebook.imagepipeline.decoder.ImageDecoder r3, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r4, boolean r5, boolean r6, boolean r7, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> r8, int r9, com.facebook.imagepipeline.core.CloseableReferenceFactory r10, @javax.annotation.Nullable java.lang.Runnable r11, com.facebook.common.internal.Supplier<java.lang.Boolean> r12) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            com.facebook.common.memory.ByteArrayPool r1 = (com.facebook.common.memory.ByteArrayPool) r1
            r0.mByteArrayPool = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            r0.mExecutor = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.imagepipeline.decoder.ImageDecoder r1 = (com.facebook.imagepipeline.decoder.ImageDecoder) r1
            r0.mImageDecoder = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r4)
            com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r1 = (com.facebook.imagepipeline.decoder.ProgressiveJpegConfig) r1
            r0.mProgressiveJpegConfig = r1
            r0.mDownsampleEnabled = r5
            r0.mDownsampleEnabledForNetwork = r6
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r8)
            com.facebook.imagepipeline.producers.Producer r1 = (com.facebook.imagepipeline.producers.Producer) r1
            r0.mInputProducer = r1
            r0.mDecodeCancellationEnabled = r7
            r0.mMaxBitmapSize = r9
            r0.mCloseableReferenceFactory = r10
            r0.mReclaimMemoryRunnable = r11
            r0.mRecoverFromDecoderOOM = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.<init>(com.facebook.common.memory.ByteArrayPool, java.util.concurrent.Executor, com.facebook.imagepipeline.decoder.ImageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig, boolean, boolean, boolean, com.facebook.imagepipeline.producers.Producer, int, com.facebook.imagepipeline.core.CloseableReferenceFactory, java.lang.Runnable, com.facebook.common.internal.Supplier):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.facebook.imagepipeline.producers.DecodeProducer$NetworkImagesProgressiveDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r10, com.facebook.imagepipeline.producers.ProducerContext r11) {
        /*
            r9 = this;
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "DecodeProducer#produceResults"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)     // Catch:{ all -> 0x004d }
        L_0x000b:
            com.facebook.imagepipeline.request.ImageRequest r0 = r11.getImageRequest()     // Catch:{ all -> 0x004d }
            android.net.Uri r0 = r0.getSourceUri()     // Catch:{ all -> 0x004d }
            boolean r0 = com.facebook.common.util.UriUtil.isNetworkUri(r0)     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0027
            com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder r0 = new com.facebook.imagepipeline.producers.DecodeProducer$LocalImagesProgressiveDecoder     // Catch:{ all -> 0x004d }
            boolean r5 = r9.mDecodeCancellationEnabled     // Catch:{ all -> 0x004d }
            int r6 = r9.mMaxBitmapSize     // Catch:{ all -> 0x004d }
            r1 = r0
            r2 = r9
            r3 = r10
            r4 = r11
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x004d }
            goto L_0x003e
        L_0x0027:
            com.facebook.imagepipeline.decoder.ProgressiveJpegParser r4 = new com.facebook.imagepipeline.decoder.ProgressiveJpegParser     // Catch:{ all -> 0x004d }
            com.facebook.common.memory.ByteArrayPool r0 = r9.mByteArrayPool     // Catch:{ all -> 0x004d }
            r4.<init>(r0)     // Catch:{ all -> 0x004d }
            com.facebook.imagepipeline.producers.DecodeProducer$NetworkImagesProgressiveDecoder r8 = new com.facebook.imagepipeline.producers.DecodeProducer$NetworkImagesProgressiveDecoder     // Catch:{ all -> 0x004d }
            com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r5 = r9.mProgressiveJpegConfig     // Catch:{ all -> 0x004d }
            boolean r6 = r9.mDecodeCancellationEnabled     // Catch:{ all -> 0x004d }
            int r7 = r9.mMaxBitmapSize     // Catch:{ all -> 0x004d }
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r0.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004d }
            r0 = r8
        L_0x003e:
            com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> r10 = r9.mInputProducer     // Catch:{ all -> 0x004d }
            r10.produceResults(r0, r11)     // Catch:{ all -> 0x004d }
            boolean r10 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r10 == 0) goto L_0x004c
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x004c:
            return
        L_0x004d:
            r10 = move-exception
            boolean r11 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r11 == 0) goto L_0x0057
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0057:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.produceResults(com.facebook.imagepipeline.producers.Consumer, com.facebook.imagepipeline.producers.ProducerContext):void");
    }

    private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        private final String TAG = "ProgressiveDecoder";
        private final ImageDecodeOptions mImageDecodeOptions;
        private boolean mIsFinished;
        /* access modifiers changed from: private */
        public final JobScheduler mJobScheduler;
        /* access modifiers changed from: private */
        public final ProducerContext mProducerContext;
        private final ProducerListener2 mProducerListener;

        /* access modifiers changed from: protected */
        public abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        /* access modifiers changed from: protected */
        public abstract QualityInfo getQualityInfo();

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z, final int i) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getProducerListener();
            ImageDecodeOptions imageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mImageDecodeOptions = imageDecodeOptions;
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobScheduler.JobRunnable(DecodeProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    if (encodedImage != null) {
                        ProgressiveDecoder.this.mProducerContext.setExtra(ProducerContext.ExtraKeys.IMAGE_FORMAT, encodedImage.getImageFormat().getName());
                        if (DecodeProducer.this.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i, 16)) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), encodedImage, i));
                            }
                        }
                        if (producerContext.getImagePipelineConfig().getExperiments().shouldDownsampleIfLargeBitmap()) {
                            ProgressiveDecoder.this.maybeIncreaseSampleSize(encodedImage);
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i);
                    }
                }
            }, imageDecodeOptions.minDecodeIntervalMs);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this) {
                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void maybeIncreaseSampleSize(EncodedImage encodedImage) {
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                encodedImage.setSampleSize(DownsampleUtil.determineSampleSizeJPEG(encodedImage, BitmapUtil.getPixelSizeForBitmapConfig(this.mImageDecodeOptions.bitmapConfig), DecodeProducer.MAX_BITMAP_SIZE));
            }
        }

        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            boolean isTracing;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
                }
                boolean isLast = isLast(i);
                if (isLast) {
                    if (encodedImage == null) {
                        handleError(new ExceptionWithNoStacktrace("Encoded image is null."));
                        if (!isTracing) {
                            return;
                        }
                        return;
                    } else if (!encodedImage.isValid()) {
                        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                }
                if (updateDecodeJob(encodedImage, i)) {
                    boolean statusHasFlag = statusHasFlag(i, 4);
                    if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } else if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdateImpl(float f) {
            super.onProgressUpdateImpl(f * 0.99f);
        }

        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        public void onCancellationImpl() {
            handleCancellation();
        }

        /* access modifiers changed from: protected */
        public boolean updateDecodeJob(@Nullable EncodedImage encodedImage, int i) {
            return this.mJobScheduler.updateJob(encodedImage, i);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf A[Catch:{ all -> 0x0143 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doDecode(com.facebook.imagepipeline.image.EncodedImage r21, int r22) {
            /*
                r20 = this;
                r11 = r20
                r12 = r21
                r0 = r22
                java.lang.String r13 = "DecodeProducer"
                com.facebook.imageformat.ImageFormat r1 = r21.getImageFormat()
                com.facebook.imageformat.ImageFormat r2 = com.facebook.imageformat.DefaultImageFormats.JPEG
                if (r1 == r2) goto L_0x0017
                boolean r1 = isNotLast(r22)
                if (r1 == 0) goto L_0x0017
                return
            L_0x0017:
                boolean r1 = r20.isFinished()
                if (r1 != 0) goto L_0x0148
                boolean r1 = com.facebook.imagepipeline.image.EncodedImage.isValid(r21)
                if (r1 != 0) goto L_0x0025
                goto L_0x0148
            L_0x0025:
                com.facebook.imageformat.ImageFormat r1 = r21.getImageFormat()
                java.lang.String r2 = "unknown"
                if (r1 == 0) goto L_0x0033
                java.lang.String r1 = r1.getName()
                r7 = r1
                goto L_0x0034
            L_0x0033:
                r7 = r2
            L_0x0034:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r3 = r21.getWidth()
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.String r3 = "x"
                java.lang.StringBuilder r1 = r1.append(r3)
                int r4 = r21.getHeight()
                java.lang.StringBuilder r1 = r1.append(r4)
                java.lang.String r8 = r1.toString()
                int r1 = r21.getSampleSize()
                java.lang.String r10 = java.lang.String.valueOf(r1)
                boolean r6 = isLast(r22)
                r4 = 1
                if (r6 == 0) goto L_0x006d
                r5 = 8
                boolean r5 = statusHasFlag(r0, r5)
                if (r5 != 0) goto L_0x006d
                r5 = r4
                goto L_0x006e
            L_0x006d:
                r5 = 0
            L_0x006e:
                r9 = 4
                boolean r14 = statusHasFlag(r0, r9)
                com.facebook.imagepipeline.producers.ProducerContext r15 = r11.mProducerContext
                com.facebook.imagepipeline.request.ImageRequest r15 = r15.getImageRequest()
                com.facebook.imagepipeline.common.ResizeOptions r15 = r15.getResizeOptions()
                if (r15 == 0) goto L_0x009a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                int r1 = r15.width
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.StringBuilder r1 = r1.append(r3)
                int r2 = r15.height
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r15 = r1
                goto L_0x009b
            L_0x009a:
                r15 = r2
            L_0x009b:
                com.facebook.imagepipeline.producers.JobScheduler r1 = r11.mJobScheduler     // Catch:{ all -> 0x0143 }
                long r17 = r1.getQueuedTime()     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerContext r1 = r11.mProducerContext     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.request.ImageRequest r1 = r1.getImageRequest()     // Catch:{ all -> 0x0143 }
                android.net.Uri r1 = r1.getSourceUri()     // Catch:{ all -> 0x0143 }
                java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0143 }
                if (r5 != 0) goto L_0x00b9
                if (r14 == 0) goto L_0x00b4
                goto L_0x00b9
            L_0x00b4:
                int r2 = r20.getIntermediateImageEndOffset(r21)     // Catch:{ all -> 0x0143 }
                goto L_0x00bd
            L_0x00b9:
                int r2 = r21.getSize()     // Catch:{ all -> 0x0143 }
            L_0x00bd:
                if (r5 != 0) goto L_0x00c7
                if (r14 == 0) goto L_0x00c2
                goto L_0x00c7
            L_0x00c2:
                com.facebook.imagepipeline.image.QualityInfo r3 = r20.getQualityInfo()     // Catch:{ all -> 0x0143 }
                goto L_0x00c9
            L_0x00c7:
                com.facebook.imagepipeline.image.QualityInfo r3 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY     // Catch:{ all -> 0x0143 }
            L_0x00c9:
                r5 = r3
                com.facebook.imagepipeline.producers.ProducerListener2 r3 = r11.mProducerListener     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerContext r14 = r11.mProducerContext     // Catch:{ all -> 0x0143 }
                r3.onProducerStart(r14, r13)     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.image.CloseableImage r14 = r11.internalDecode(r12, r2, r5)     // Catch:{ DecodeException -> 0x00fe }
                int r1 = r21.getSampleSize()     // Catch:{ Exception -> 0x00f8 }
                if (r1 == r4) goto L_0x00dd
                r0 = r0 | 16
            L_0x00dd:
                r1 = r20
                r2 = r14
                r3 = r17
                r9 = r15
                java.util.Map r1 = r1.getExtraMap(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerListener2 r2 = r11.mProducerListener     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerContext r3 = r11.mProducerContext     // Catch:{ all -> 0x0143 }
                r2.onProducerFinishWithSuccess(r3, r13, r1)     // Catch:{ all -> 0x0143 }
                r11.setImageExtras(r12, r14)     // Catch:{ all -> 0x0143 }
                r11.handleResult(r14, r0)     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r21)
                return
            L_0x00f8:
                r0 = move-exception
                r2 = r14
                goto L_0x012c
            L_0x00fb:
                r0 = move-exception
                r2 = 0
                goto L_0x012c
            L_0x00fe:
                r0 = move-exception
                r2 = r0
                com.facebook.imagepipeline.image.EncodedImage r0 = r2.getEncodedImage()     // Catch:{ Exception -> 0x00fb }
                java.lang.String r14 = "ProgressiveDecoder"
                java.lang.String r3 = "%s, {uri: %s, firstEncodedBytes: %s, length: %d}"
                java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00fb }
                java.lang.String r19 = r2.getMessage()     // Catch:{ Exception -> 0x00fb }
                r16 = 0
                r9[r16] = r19     // Catch:{ Exception -> 0x00fb }
                r9[r4] = r1     // Catch:{ Exception -> 0x00fb }
                r1 = 2
                r4 = 10
                java.lang.String r4 = r0.getFirstBytesAsHexString(r4)     // Catch:{ Exception -> 0x00fb }
                r9[r1] = r4     // Catch:{ Exception -> 0x00fb }
                r1 = 3
                int r0 = r0.getSize()     // Catch:{ Exception -> 0x00fb }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00fb }
                r9[r1] = r0     // Catch:{ Exception -> 0x00fb }
                com.facebook.common.logging.FLog.w((java.lang.String) r14, (java.lang.String) r3, (java.lang.Object[]) r9)     // Catch:{ Exception -> 0x00fb }
                throw r2     // Catch:{ Exception -> 0x00fb }
            L_0x012c:
                r1 = r20
                r3 = r17
                r9 = r15
                java.util.Map r1 = r1.getExtraMap(r2, r3, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerListener2 r2 = r11.mProducerListener     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.producers.ProducerContext r3 = r11.mProducerContext     // Catch:{ all -> 0x0143 }
                r2.onProducerFinishWithFailure(r3, r13, r0, r1)     // Catch:{ all -> 0x0143 }
                r11.handleError(r0)     // Catch:{ all -> 0x0143 }
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r21)
                return
            L_0x0143:
                r0 = move-exception
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(r21)
                throw r0
            L_0x0148:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.doDecode(com.facebook.imagepipeline.image.EncodedImage, int):void");
        }

        private CloseableImage internalDecode(EncodedImage encodedImage, int i, QualityInfo qualityInfo) {
            boolean z = DecodeProducer.this.mReclaimMemoryRunnable != null && ((Boolean) DecodeProducer.this.mRecoverFromDecoderOOM.get()).booleanValue();
            try {
                return DecodeProducer.this.mImageDecoder.decode(encodedImage, i, qualityInfo, this.mImageDecodeOptions);
            } catch (OutOfMemoryError e) {
                if (z) {
                    DecodeProducer.this.mReclaimMemoryRunnable.run();
                    System.gc();
                    return DecodeProducer.this.mImageDecoder.decode(encodedImage, i, qualityInfo, this.mImageDecodeOptions);
                }
                throw e;
            }
        }

        private void setImageExtras(EncodedImage encodedImage, CloseableImage closeableImage) {
            Bitmap.Config config;
            this.mProducerContext.setExtra(ProducerContext.ExtraKeys.ENCODED_WIDTH, Integer.valueOf(encodedImage.getWidth()));
            this.mProducerContext.setExtra(ProducerContext.ExtraKeys.ENCODED_HEIGHT, Integer.valueOf(encodedImage.getHeight()));
            this.mProducerContext.setExtra(ProducerContext.ExtraKeys.ENCODED_SIZE, Integer.valueOf(encodedImage.getSize()));
            if (closeableImage instanceof CloseableBitmap) {
                Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                if (underlyingBitmap == null) {
                    config = null;
                } else {
                    config = underlyingBitmap.getConfig();
                }
                this.mProducerContext.setExtra("bitmap_config", String.valueOf(config));
            }
            if (closeableImage != null) {
                closeableImage.setImageExtras(this.mProducerContext.getExtras());
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            CloseableImage closeableImage2 = closeableImage;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext, DecodeProducer.PRODUCER_NAME)) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            String valueOf3 = String.valueOf(z);
            if (closeableImage2 instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap();
                Preconditions.checkNotNull(underlyingBitmap);
                Bitmap bitmap = underlyingBitmap;
                HashMap hashMap = new HashMap(8);
                hashMap.put(DecodeProducer.EXTRA_BITMAP_SIZE, underlyingBitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + underlyingBitmap.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
                hashMap.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
                hashMap.put("encodedImageSize", str6);
                hashMap.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str5);
                hashMap.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str7);
                hashMap.put(DecodeProducer.SAMPLE_SIZE, str4);
                if (Build.VERSION.SDK_INT >= 12) {
                    hashMap.put(DecodeProducer.EXTRA_BITMAP_BYTES, bitmap.getByteCount() + "");
                }
                return ImmutableMap.copyOf(hashMap);
            }
            String str9 = str8;
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
            hashMap2.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
            hashMap2.put("encodedImageSize", str6);
            hashMap2.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str5);
            hashMap2.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str7);
            hashMap2.put(DecodeProducer.SAMPLE_SIZE, str9);
            return ImmutableMap.copyOf(hashMap2);
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                    }
                }
            }
        }

        private void handleResult(CloseableImage closeableImage, int i) {
            CloseableReference create = DecodeProducer.this.mCloseableReferenceFactory.create(closeableImage);
            try {
                maybeFinish(isLast(i));
                getConsumer().onNewResult(create, i);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) create);
            }
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        /* access modifiers changed from: private */
        public void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }
    }

    private class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer, producerContext, z, i);
        }

        /* access modifiers changed from: protected */
        public synchronized boolean updateDecodeJob(@Nullable EncodedImage encodedImage, int i) {
            if (isNotLast(i)) {
                return false;
            }
            return super.updateDecodeJob(encodedImage, i);
        }

        /* access modifiers changed from: protected */
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        /* access modifiers changed from: protected */
        public QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.of(0, false, false);
        }
    }

    private class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        private int mLastScheduledScanNumber = 0;
        private final ProgressiveJpegConfig mProgressiveJpegConfig;
        private final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i) {
            super(consumer, producerContext, z, i);
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0054, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean updateDecodeJob(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage r4, int r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = super.updateDecodeJob(r4, r5)     // Catch:{ all -> 0x0055 }
                boolean r1 = isNotLast(r5)     // Catch:{ all -> 0x0055 }
                if (r1 != 0) goto L_0x0013
                r1 = 8
                boolean r1 = statusHasFlag(r5, r1)     // Catch:{ all -> 0x0055 }
                if (r1 == 0) goto L_0x0053
            L_0x0013:
                r1 = 4
                boolean r5 = statusHasFlag(r5, r1)     // Catch:{ all -> 0x0055 }
                if (r5 != 0) goto L_0x0053
                boolean r5 = com.facebook.imagepipeline.image.EncodedImage.isValid(r4)     // Catch:{ all -> 0x0055 }
                if (r5 == 0) goto L_0x0053
                com.facebook.imageformat.ImageFormat r5 = r4.getImageFormat()     // Catch:{ all -> 0x0055 }
                com.facebook.imageformat.ImageFormat r1 = com.facebook.imageformat.DefaultImageFormats.JPEG     // Catch:{ all -> 0x0055 }
                if (r5 != r1) goto L_0x0053
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r5 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0055 }
                boolean r4 = r5.parseMoreData(r4)     // Catch:{ all -> 0x0055 }
                r5 = 0
                if (r4 != 0) goto L_0x0033
                monitor-exit(r3)
                return r5
            L_0x0033:
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r4 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0055 }
                int r4 = r4.getBestScanNumber()     // Catch:{ all -> 0x0055 }
                int r1 = r3.mLastScheduledScanNumber     // Catch:{ all -> 0x0055 }
                if (r4 > r1) goto L_0x003f
                monitor-exit(r3)
                return r5
            L_0x003f:
                com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r2 = r3.mProgressiveJpegConfig     // Catch:{ all -> 0x0055 }
                int r1 = r2.getNextScanNumberToDecode(r1)     // Catch:{ all -> 0x0055 }
                if (r4 >= r1) goto L_0x0051
                com.facebook.imagepipeline.decoder.ProgressiveJpegParser r1 = r3.mProgressiveJpegParser     // Catch:{ all -> 0x0055 }
                boolean r1 = r1.isEndMarkerRead()     // Catch:{ all -> 0x0055 }
                if (r1 != 0) goto L_0x0051
                monitor-exit(r3)
                return r5
            L_0x0051:
                r3.mLastScheduledScanNumber = r4     // Catch:{ all -> 0x0055 }
            L_0x0053:
                monitor-exit(r3)
                return r0
            L_0x0055:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.NetworkImagesProgressiveDecoder.updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage, int):boolean");
        }

        /* access modifiers changed from: protected */
        public int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.getBestScanEndOffset();
        }

        /* access modifiers changed from: protected */
        public QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }
    }
}
