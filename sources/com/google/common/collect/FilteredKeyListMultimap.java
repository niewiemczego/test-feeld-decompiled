package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap) super.unfiltered();
    }

    public List<V> get(@ParametricNullness K k) {
        return (List) super.get(k);
    }

    public List<V> removeAll(@CheckForNull Object obj) {
        return (List) super.removeAll(obj);
    }

    public List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues(k, iterable);
    }
}
