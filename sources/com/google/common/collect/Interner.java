package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use Interners.new*Interner")
public interface Interner<E> {
    E intern(E e);
}
