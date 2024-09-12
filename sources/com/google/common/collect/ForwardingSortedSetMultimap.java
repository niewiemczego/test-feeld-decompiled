package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract SortedSetMultimap<K, V> delegate();

    protected ForwardingSortedSetMultimap() {
    }

    public SortedSet<V> get(@ParametricNullness K k) {
        return delegate().get((Object) k);
    }

    public SortedSet<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    public SortedSet<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }

    @CheckForNull
    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }
}
