package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {
    /* access modifiers changed from: protected */
    public abstract NavigableMap<K, V> delegate();

    protected ForwardingNavigableMap() {
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
        return delegate().lowerEntry(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardLowerEntry(@ParametricNullness K k) {
        return headMap(k, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K k) {
        return delegate().lowerKey(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardLowerKey(@ParametricNullness K k) {
        return Maps.keyOrNull(lowerEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
        return delegate().floorEntry(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardFloorEntry(@ParametricNullness K k) {
        return headMap(k, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K k) {
        return delegate().floorKey(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardFloorKey(@ParametricNullness K k) {
        return Maps.keyOrNull(floorEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
        return delegate().ceilingEntry(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardCeilingEntry(@ParametricNullness K k) {
        return tailMap(k, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K k) {
        return delegate().ceilingKey(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardCeilingKey(@ParametricNullness K k) {
        return Maps.keyOrNull(ceilingEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
        return delegate().higherEntry(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardHigherEntry(@ParametricNullness K k) {
        return tailMap(k, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K k) {
        return delegate().higherKey(k);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardHigherKey(@ParametricNullness K k) {
        return Maps.keyOrNull(higherEntry(k));
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K standardFirstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K standardLastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }

        /* access modifiers changed from: protected */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() {
                @CheckForNull
                private Map.Entry<K, V> nextOrNull;
                @CheckForNull
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.nextOrNull;
                    if (entry != null) {
                        this.toRemove = entry;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        return entry;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    if (this.toRemove != null) {
                        StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                        this.toRemove = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
            };
        }
    }

    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    /* access modifiers changed from: protected */
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardSubMap(@ParametricNullness K k, @ParametricNullness K k2) {
        return subMap(k, true, k2, false);
    }

    public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
        return delegate().subMap(k, z, k2, z2);
    }

    public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
        return delegate().headMap(k, z);
    }

    public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
        return delegate().tailMap(k, z);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardHeadMap(@ParametricNullness K k) {
        return headMap(k, false);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardTailMap(@ParametricNullness K k) {
        return tailMap(k, true);
    }
}
