package com.google.common.collect;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @ParametricNullness
    final K key;
    @ParametricNullness
    final V value;

    ImmutableEntry(@ParametricNullness K k, @ParametricNullness V v) {
        this.key = k;
        this.value = v;
    }

    @ParametricNullness
    public final K getKey() {
        return this.key;
    }

    @ParametricNullness
    public final V getValue() {
        return this.value;
    }

    @ParametricNullness
    public final V setValue(@ParametricNullness V v) {
        throw new UnsupportedOperationException();
    }
}
