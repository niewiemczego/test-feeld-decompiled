package com.google.common.collect;

import java.util.Iterator;

@ElementTypesAreNonnullByDefault
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    protected UnmodifiableIterator() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
