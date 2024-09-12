package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
    protected UnmodifiableListIterator() {
    }

    @Deprecated
    public final void add(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }
}
