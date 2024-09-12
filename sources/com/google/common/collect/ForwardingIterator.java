package com.google.common.collect;

import java.util.Iterator;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    /* access modifiers changed from: protected */
    public abstract Iterator<T> delegate();

    protected ForwardingIterator() {
    }

    public boolean hasNext() {
        return delegate().hasNext();
    }

    @ParametricNullness
    public T next() {
        return delegate().next();
    }

    public void remove() {
        delegate().remove();
    }
}
