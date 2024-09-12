package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.Priority;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PriorityStarvingThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    private final Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private int mNumCurrentRequests = 0;
    /* access modifiers changed from: private */
    public final Queue<Item<T>> mPendingRequests = new PriorityQueue(11, new PriorityComparator());

    static /* synthetic */ int access$210(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer) {
        int i = priorityStarvingThrottlingProducer.mNumCurrentRequests;
        priorityStarvingThrottlingProducer.mNumCurrentRequests = i - 1;
        return i;
    }

    public PriorityStarvingThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        long nanoTime = System.nanoTime();
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i = this.mNumCurrentRequests;
            z = true;
            if (i >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(new Item(consumer, producerContext, nanoTime));
            } else {
                this.mNumCurrentRequests = i + 1;
                z = false;
            }
        }
        if (!z) {
            produceResultsInternal(new Item(consumer, producerContext, nanoTime));
        }
    }

    /* access modifiers changed from: private */
    public void produceResultsInternal(Item<T> item) {
        item.producerContext.getProducerListener().onProducerFinishWithSuccess(item.producerContext, PRODUCER_NAME, (Map<String, String>) null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(item.consumer), item.producerContext);
    }

    static class Item<T> {
        final Consumer<T> consumer;
        final ProducerContext producerContext;
        final long time;

        Item(Consumer<T> consumer2, ProducerContext producerContext2, long j) {
            this.consumer = consumer2;
            this.producerContext = producerContext2;
            this.time = j;
        }
    }

    static class PriorityComparator<T> implements Comparator<Item<T>> {
        PriorityComparator() {
        }

        public int compare(Item<T> item, Item<T> item2) {
            Priority priority = item.producerContext.getPriority();
            Priority priority2 = item2.producerContext.getPriority();
            if (priority == priority2) {
                return Double.compare((double) item.time, (double) item2.time);
            }
            return priority.ordinal() > priority2.ordinal() ? -1 : 1;
        }
    }

    private class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        private ThrottlerConsumer(Consumer<T> consumer) {
            super(consumer);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(@Nullable T t, int i) {
            getConsumer().onNewResult(t, i);
            if (isLast(i)) {
                onRequestFinished();
            }
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        /* access modifiers changed from: protected */
        public void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        private void onRequestFinished() {
            final Item item;
            synchronized (PriorityStarvingThrottlingProducer.this) {
                item = (Item) PriorityStarvingThrottlingProducer.this.mPendingRequests.poll();
                if (item == null) {
                    PriorityStarvingThrottlingProducer.access$210(PriorityStarvingThrottlingProducer.this);
                }
            }
            if (item != null) {
                PriorityStarvingThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    public void run() {
                        PriorityStarvingThrottlingProducer.this.produceResultsInternal(item);
                    }
                });
            }
        }
    }
}
