package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;

final class SpannedData<V> {
    private int memoizedReadIndex;
    private final Consumer<V> removeCallback;
    private final SparseArray<V> spans;

    static /* synthetic */ void lambda$new$0(Object obj) {
    }

    public SpannedData() {
        this(new SpannedData$$ExternalSyntheticLambda0());
    }

    public SpannedData(Consumer<V> consumer) {
        this.spans = new SparseArray<>();
        this.removeCallback = consumer;
        this.memoizedReadIndex = -1;
    }

    public V get(int i) {
        if (this.memoizedReadIndex == -1) {
            this.memoizedReadIndex = 0;
        }
        while (true) {
            int i2 = this.memoizedReadIndex;
            if (i2 > 0 && i < this.spans.keyAt(i2)) {
                this.memoizedReadIndex--;
            }
        }
        while (this.memoizedReadIndex < this.spans.size() - 1 && i >= this.spans.keyAt(this.memoizedReadIndex + 1)) {
            this.memoizedReadIndex++;
        }
        return this.spans.valueAt(this.memoizedReadIndex);
    }

    public void appendSpan(int i, V v) {
        boolean z = false;
        if (this.memoizedReadIndex == -1) {
            Assertions.checkState(this.spans.size() == 0);
            this.memoizedReadIndex = 0;
        }
        if (this.spans.size() > 0) {
            SparseArray<V> sparseArray = this.spans;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i >= keyAt) {
                z = true;
            }
            Assertions.checkArgument(z);
            if (keyAt == i) {
                Consumer<V> consumer = this.removeCallback;
                SparseArray<V> sparseArray2 = this.spans;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.spans.append(i, v);
    }

    public V getEndValue() {
        SparseArray<V> sparseArray = this.spans;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public void discardTo(int i) {
        int i2 = 0;
        while (i2 < this.spans.size() - 1) {
            int i3 = i2 + 1;
            if (i >= this.spans.keyAt(i3)) {
                this.removeCallback.accept(this.spans.valueAt(i2));
                this.spans.removeAt(i2);
                int i4 = this.memoizedReadIndex;
                if (i4 > 0) {
                    this.memoizedReadIndex = i4 - 1;
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public void discardFrom(int i) {
        int size = this.spans.size() - 1;
        while (size >= 0 && i < this.spans.keyAt(size)) {
            this.removeCallback.accept(this.spans.valueAt(size));
            this.spans.removeAt(size);
            size--;
        }
        this.memoizedReadIndex = this.spans.size() > 0 ? Math.min(this.memoizedReadIndex, this.spans.size() - 1) : -1;
    }

    public void clear() {
        for (int i = 0; i < this.spans.size(); i++) {
            this.removeCallback.accept(this.spans.valueAt(i));
        }
        this.memoizedReadIndex = -1;
        this.spans.clear();
    }

    public boolean isEmpty() {
        return this.spans.size() == 0;
    }
}
