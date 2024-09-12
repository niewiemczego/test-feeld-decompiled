package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T nextOrNull;

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract T computeNext(T t);

    protected AbstractSequentialIterator(@CheckForNull T t) {
        this.nextOrNull = t;
    }

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        T t = this.nextOrNull;
        if (t != null) {
            this.nextOrNull = computeNext(t);
            return t;
        }
        throw new NoSuchElementException();
    }
}
