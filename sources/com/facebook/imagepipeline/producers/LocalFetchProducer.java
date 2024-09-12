package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    /* access modifiers changed from: protected */
    @Nullable
    public abstract EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException;

    /* access modifiers changed from: protected */
    public abstract String getProducerName();

    protected LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, "fetch");
        final ProducerContext producerContext2 = producerContext;
        final AnonymousClass1 r0 = new StatefulProducerRunnable<EncodedImage>(consumer, producerListener, producerContext, getProducerName()) {
            /* access modifiers changed from: protected */
            @Nullable
            public EncodedImage getResult() throws Exception {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    producerListener.onUltimateProducerReached(producerContext2, LocalFetchProducer.this.getProducerName(), false);
                    producerContext2.putOriginExtra(ImagesContract.LOCAL);
                    return null;
                }
                encodedImage.parseMetaData();
                producerListener.onUltimateProducerReached(producerContext2, LocalFetchProducer.this.getProducerName(), true);
                producerContext2.putOriginExtra(ImagesContract.LOCAL);
                return encodedImage;
            }

            /* access modifiers changed from: protected */
            public void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                r0.cancel();
            }
        });
        this.mExecutor.execute(r0);
    }

    /* access modifiers changed from: protected */
    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReference;
        if (i <= 0) {
            try {
                closeableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } catch (Throwable th) {
                Closeables.closeQuietly(inputStream);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        } else {
            closeableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i));
        }
        CloseableReference closeableReference2 = closeableReference;
        EncodedImage encodedImage = new EncodedImage((CloseableReference<PooledByteBuffer>) closeableReference2);
        Closeables.closeQuietly(inputStream);
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        return encodedImage;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public EncodedImage getEncodedImage(InputStream inputStream, int i) throws IOException {
        return getByteBufferBackedEncodedImage(inputStream, i);
    }
}
