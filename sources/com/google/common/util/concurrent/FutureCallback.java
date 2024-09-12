package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@ParametricNullness V v);
}
