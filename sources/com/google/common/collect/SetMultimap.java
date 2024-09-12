package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface SetMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object obj);

    Set<V> get(@ParametricNullness K k);

    Set<V> removeAll(@CheckForNull Object obj);

    Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);
}
