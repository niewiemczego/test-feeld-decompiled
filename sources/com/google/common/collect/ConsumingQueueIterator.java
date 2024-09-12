package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> queue;

    ConsumingQueueIterator(Queue<T> queue2) {
        this.queue = (Queue) Preconditions.checkNotNull(queue2);
    }

    @CheckForNull
    public T computeNext() {
        if (this.queue.isEmpty()) {
            return endOfData();
        }
        return this.queue.remove();
    }
}
