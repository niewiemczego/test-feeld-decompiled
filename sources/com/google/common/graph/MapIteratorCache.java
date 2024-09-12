package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {
    /* access modifiers changed from: private */
    public final Map<K, V> backingMap;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile transient Map.Entry<K, V> cacheEntry;

    MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        clearCache();
        return this.backingMap.put(k, v);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V remove(Object obj) {
        Preconditions.checkNotNull(obj);
        clearCache();
        return this.backingMap.remove(obj);
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        clearCache();
        this.backingMap.clear();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V get(Object obj) {
        Preconditions.checkNotNull(obj);
        V ifCached = getIfCached(obj);
        return ifCached == null ? getWithoutCaching(obj) : ifCached;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V getWithoutCaching(Object obj) {
        Preconditions.checkNotNull(obj);
        return this.backingMap.get(obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean containsKey(@CheckForNull Object obj) {
        return getIfCached(obj) != null || this.backingMap.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            public UnmodifiableIterator<K> iterator() {
                final Iterator it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        Map.Entry unused = MapIteratorCache.this.cacheEntry = entry;
                        return entry.getKey();
                    }
                };
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public boolean contains(@CheckForNull Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }
        };
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V getIfCached(@CheckForNull Object obj) {
        Map.Entry<K, V> entry = this.cacheEntry;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.cacheEntry = null;
    }
}
