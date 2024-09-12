package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use Iterators.peekingIterator")
public interface PeekingIterator<E> extends Iterator<E> {
    @ParametricNullness
    E next();

    @ParametricNullness
    E peek();

    void remove();
}
