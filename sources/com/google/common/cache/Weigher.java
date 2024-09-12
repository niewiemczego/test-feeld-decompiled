package com.google.common.cache;

@ElementTypesAreNonnullByDefault
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
