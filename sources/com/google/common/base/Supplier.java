package com.google.common.base;

@ElementTypesAreNonnullByDefault
public interface Supplier<T> {
    @ParametricNullness
    T get();
}
