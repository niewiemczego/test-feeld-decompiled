package com.google.common.collect;

import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract ListMultimap<K, V> delegate();

    protected ForwardingListMultimap() {
    }

    public List<V> get(@ParametricNullness K k) {
        return delegate().get((Object) k);
    }

    public List<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    public List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }
}
