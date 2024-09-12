package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {
    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> descendingEntryIterator();

    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    AbstractNavigableMap() {
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.getNext(entryIterator(), null);
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.getNext(descendingEntryIterator(), null);
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entryIterator());
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingEntryIterator());
    }

    @ParametricNullness
    public K firstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public K lastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
        return headMap(k, false).lastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
        return headMap(k, true).lastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
        return tailMap(k, true).firstEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
        return tailMap(k, false).firstEntry();
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K k) {
        return Maps.keyOrNull(lowerEntry(k));
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K k) {
        return Maps.keyOrNull(floorEntry(k));
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K k) {
        return Maps.keyOrNull(ceilingEntry(k));
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K k) {
        return Maps.keyOrNull(higherEntry(k));
    }

    public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> headMap(@ParametricNullness K k) {
        return headMap(k, false);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K k) {
        return tailMap(k, true);
    }

    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    public Set<K> keySet() {
        return navigableKeySet();
    }

    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap();
    }

    private final class DescendingMap extends Maps.DescendingMap<K, V> {
        private DescendingMap() {
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> forward() {
            return AbstractNavigableMap.this;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return AbstractNavigableMap.this.descendingEntryIterator();
        }
    }
}
