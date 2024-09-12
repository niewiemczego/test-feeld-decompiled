package com.facebook.react.fabric;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* compiled from: DevToolsReactPerfLogger */
class LongStreamingStats {
    private int len = 0;
    private long max = 0;
    private Queue<Long> maxHeap = new PriorityQueue(Comparator.reverseOrder());
    private Queue<Long> minHeap = new PriorityQueue(Comparator.naturalOrder());
    private double streamingAverage = 0.0d;

    LongStreamingStats() {
    }

    public void add(long j) {
        if (j != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(j));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(j));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i = this.len + 1;
        this.len = i;
        if (i == 1) {
            this.streamingAverage = (double) j;
        } else {
            this.streamingAverage = (this.streamingAverage / ((double) (i / (i - 1)))) + ((double) (j / ((long) i)));
        }
        long j2 = this.max;
        if (j <= j2) {
            j = j2;
        }
        this.max = j;
    }

    public double getMedian() {
        long j;
        if (this.minHeap.size() == 0 && this.maxHeap.size() == 0) {
            return 0.0d;
        }
        if (this.minHeap.size() > this.maxHeap.size()) {
            j = this.minHeap.peek().longValue();
        } else {
            j = (this.minHeap.peek().longValue() + this.maxHeap.peek().longValue()) / 2;
        }
        return (double) j;
    }

    public double getAverage() {
        return this.streamingAverage;
    }

    public long getMax() {
        return this.max;
    }
}
