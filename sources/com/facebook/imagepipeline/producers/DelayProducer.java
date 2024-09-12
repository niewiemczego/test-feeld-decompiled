package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class DelayProducer implements Producer<CloseableReference<CloseableImage>> {
    @Nullable
    private final ScheduledExecutorService mBackgroundTasksExecutor;
    /* access modifiers changed from: private */
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;

    public DelayProducer(Producer<CloseableReference<CloseableImage>> producer, @Nullable ScheduledExecutorService scheduledExecutorService) {
        this.mInputProducer = producer;
        this.mBackgroundTasksExecutor = scheduledExecutorService;
    }

    public void produceResults(final Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        ScheduledExecutorService scheduledExecutorService = this.mBackgroundTasksExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new Runnable() {
                public void run() {
                    DelayProducer.this.mInputProducer.produceResults(consumer, producerContext);
                }
            }, (long) imageRequest.getDelayMs(), TimeUnit.MILLISECONDS);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }
}
