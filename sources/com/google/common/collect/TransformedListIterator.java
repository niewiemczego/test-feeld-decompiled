package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    @ParametricNullness
    public final T previous() {
        return transform(backingIterator().previous());
    }

    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    public final int previousIndex() {
        return backingIterator().previousIndex();
    }

    public void set(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }

    public void add(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }
}
