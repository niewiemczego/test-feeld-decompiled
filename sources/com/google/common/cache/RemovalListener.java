package com.google.common.cache;

@ElementTypesAreNonnullByDefault
public interface RemovalListener<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
