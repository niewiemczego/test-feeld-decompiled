package com.google.common.collect;

import WrappedCollection.WrappedIterator;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* access modifiers changed from: package-private */
    public abstract Collection<V> createCollection();

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i + 1;
        return i;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i - 1;
        return i;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.totalSize + i;
        abstractMapBasedMultimap.totalSize = i2;
        return i2;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.totalSize - i;
        abstractMapBasedMultimap.totalSize = i2;
        return i2;
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map2) {
        Preconditions.checkArgument(map2.isEmpty());
        this.map = map2;
    }

    /* access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map2) {
        this.map = map2;
        this.totalSize = 0;
        for (Collection next : map2.values()) {
            Preconditions.checkArgument(!next.isEmpty());
            this.totalSize += next.size();
        }
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass(createCollection());
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createCollection(@ParametricNullness K k) {
        return createCollection();
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    public int size() {
        return this.totalSize;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
        Collection collection = this.map.get(k);
        if (collection == null) {
            Collection createCollection = createCollection(k);
            if (createCollection.add(v)) {
                this.totalSize++;
                this.map.put(k, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.totalSize++;
            return true;
        }
    }

    private Collection<V> getOrCreateCollection(@ParametricNullness K k) {
        Collection<V> collection = this.map.get(k);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k);
        this.map.put(k, createCollection);
        return createCollection;
    }

    public Collection<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection orCreateCollection = getOrCreateCollection(k);
        Collection createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return unmodifiableCollectionSubclass(createCollection);
    }

    public Collection<V> removeAll(@CheckForNull Object obj) {
        Collection remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return unmodifiableCollectionSubclass(createCollection);
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    public void clear() {
        for (Collection<V> clear : this.map.values()) {
            clear.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    public Collection<V> get(@ParametricNullness K k) {
        Collection collection = this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return wrapCollection(k, collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(@ParametricNullness K k, Collection<V> collection) {
        return new WrappedCollection(k, collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    public final List<V> wrapList(@ParametricNullness K k, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
        if (list instanceof RandomAccess) {
            return new RandomAccessWrappedList(this, k, list, wrappedCollection);
        }
        return new WrappedList(k, list, wrappedCollection);
    }

    class WrappedCollection extends AbstractCollection<V> {
        @CheckForNull
        final AbstractMapBasedMultimap<K, V>.WrappedCollection ancestor;
        @CheckForNull
        final Collection<V> ancestorDelegate;
        Collection<V> delegate;
        @ParametricNullness
        final K key;

        WrappedCollection(@ParametricNullness K k, Collection<V> collection, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            Collection<V> collection2;
            this.key = k;
            this.delegate = collection;
            this.ancestor = wrappedCollection;
            if (wrappedCollection == null) {
                collection2 = null;
            } else {
                collection2 = wrappedCollection.getDelegate();
            }
            this.ancestorDelegate = collection2;
        }

        /* access modifiers changed from: package-private */
        public void refreshIfEmpty() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.refreshIfEmpty();
                if (this.ancestor.getDelegate() != this.ancestorDelegate) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.delegate.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.key)) != null) {
                this.delegate = collection;
            }
        }

        /* access modifiers changed from: package-private */
        public void removeIfEmpty() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.removeIfEmpty();
            } else if (this.delegate.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        /* access modifiers changed from: package-private */
        public void addToMap() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.ancestor;
            if (wrappedCollection != null) {
                wrappedCollection.addToMap();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
            }
        }

        public int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            refreshIfEmpty();
            return this.delegate.equals(obj);
        }

        public int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        public String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }

        /* access modifiers changed from: package-private */
        public Collection<V> getDelegate() {
            return this.delegate;
        }

        public Iterator<V> iterator() {
            refreshIfEmpty();
            return new WrappedIterator();
        }

        class WrappedIterator implements Iterator<V> {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;

            WrappedIterator() {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = AbstractMapBasedMultimap.iteratorOrListIterator(WrappedCollection.this.delegate);
            }

            WrappedIterator(Iterator<V> it) {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = it;
            }

            /* access modifiers changed from: package-private */
            public void validateIterator() {
                WrappedCollection.this.refreshIfEmpty();
                if (WrappedCollection.this.delegate != this.originalDelegate) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                validateIterator();
                return this.delegateIterator.hasNext();
            }

            @ParametricNullness
            public V next() {
                validateIterator();
                return this.delegateIterator.next();
            }

            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                WrappedCollection.this.removeIfEmpty();
            }

            /* access modifiers changed from: package-private */
            public Iterator<V> getDelegateIterator() {
                validateIterator();
                return this.delegateIterator;
            }
        }

        public boolean add(@ParametricNullness V v) {
            refreshIfEmpty();
            boolean isEmpty = this.delegate.isEmpty();
            boolean add = this.delegate.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    addToMap();
                }
            }
            return add;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AbstractMapBasedMultimap<K, V>.WrappedCollection getAncestor() {
            return this.ancestor;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.delegate.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                if (size == 0) {
                    addToMap();
                }
            }
            return addAll;
        }

        public boolean contains(@CheckForNull Object obj) {
            refreshIfEmpty();
            return this.delegate.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            refreshIfEmpty();
            return this.delegate.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.delegate.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
                removeIfEmpty();
            }
        }

        public boolean remove(@CheckForNull Object obj) {
            refreshIfEmpty();
            boolean remove = this.delegate.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                removeIfEmpty();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.delegate.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                removeIfEmpty();
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.delegate.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                removeIfEmpty();
            }
            return retainAll;
        }
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        WrappedSet(@ParametricNullness K k, Set<V> set) {
            super(k, set, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAllImpl = Sets.removeAllImpl((Set<?>) (Set) this.delegate, collection);
            if (removeAllImpl) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                removeIfEmpty();
            }
            return removeAllImpl;
        }
    }

    class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        WrappedSortedSet(@ParametricNullness K k, SortedSet<V> sortedSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, sortedSet, wrappedCollection);
        }

        /* access modifiers changed from: package-private */
        public SortedSet<V> getSortedSetDelegate() {
            return (SortedSet) getDelegate();
        }

        @CheckForNull
        public Comparator<? super V> comparator() {
            return getSortedSetDelegate().comparator();
        }

        @ParametricNullness
        public V first() {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        @ParametricNullness
        public V last() {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        public SortedSet<V> headSet(@ParametricNullness V v) {
            refreshIfEmpty();
            return new WrappedSortedSet(getKey(), getSortedSetDelegate().headSet(v), getAncestor() == null ? this : getAncestor());
        }

        public SortedSet<V> subSet(@ParametricNullness V v, @ParametricNullness V v2) {
            refreshIfEmpty();
            return new WrappedSortedSet(getKey(), getSortedSetDelegate().subSet(v, v2), getAncestor() == null ? this : getAncestor());
        }

        public SortedSet<V> tailSet(@ParametricNullness V v) {
            refreshIfEmpty();
            return new WrappedSortedSet(getKey(), getSortedSetDelegate().tailSet(v), getAncestor() == null ? this : getAncestor());
        }
    }

    class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        WrappedNavigableSet(@ParametricNullness K k, NavigableSet<V> navigableSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, navigableSet, wrappedCollection);
        }

        /* access modifiers changed from: package-private */
        public NavigableSet<V> getSortedSetDelegate() {
            return (NavigableSet) super.getSortedSetDelegate();
        }

        @CheckForNull
        public V lower(@ParametricNullness V v) {
            return getSortedSetDelegate().lower(v);
        }

        @CheckForNull
        public V floor(@ParametricNullness V v) {
            return getSortedSetDelegate().floor(v);
        }

        @CheckForNull
        public V ceiling(@ParametricNullness V v) {
            return getSortedSetDelegate().ceiling(v);
        }

        @CheckForNull
        public V higher(@ParametricNullness V v) {
            return getSortedSetDelegate().higher(v);
        }

        @CheckForNull
        public V pollFirst() {
            return Iterators.pollNext(iterator());
        }

        @CheckForNull
        public V pollLast() {
            return Iterators.pollNext(descendingIterator());
        }

        private NavigableSet<V> wrap(NavigableSet<V> navigableSet) {
            return new WrappedNavigableSet(this.key, navigableSet, getAncestor() == null ? this : getAncestor());
        }

        public NavigableSet<V> descendingSet() {
            return wrap(getSortedSetDelegate().descendingSet());
        }

        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(getSortedSetDelegate().descendingIterator());
        }

        public NavigableSet<V> subSet(@ParametricNullness V v, boolean z, @ParametricNullness V v2, boolean z2) {
            return wrap(getSortedSetDelegate().subSet(v, z, v2, z2));
        }

        public NavigableSet<V> headSet(@ParametricNullness V v, boolean z) {
            return wrap(getSortedSetDelegate().headSet(v, z));
        }

        public NavigableSet<V> tailSet(@ParametricNullness V v, boolean z) {
            return wrap(getSortedSetDelegate().tailSet(v, z));
        }
    }

    class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {
        WrappedList(@ParametricNullness K k, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }

        /* access modifiers changed from: package-private */
        public List<V> getListDelegate() {
            return (List) getDelegate();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = getListDelegate().addAll(i, collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, getDelegate().size() - size);
                if (size == 0) {
                    addToMap();
                }
            }
            return addAll;
        }

        @ParametricNullness
        public V get(int i) {
            refreshIfEmpty();
            return getListDelegate().get(i);
        }

        @ParametricNullness
        public V set(int i, @ParametricNullness V v) {
            refreshIfEmpty();
            return getListDelegate().set(i, v);
        }

        public void add(int i, @ParametricNullness V v) {
            refreshIfEmpty();
            boolean isEmpty = getDelegate().isEmpty();
            getListDelegate().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                addToMap();
            }
        }

        @ParametricNullness
        public V remove(int i) {
            refreshIfEmpty();
            V remove = getListDelegate().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            removeIfEmpty();
            return remove;
        }

        public int indexOf(@CheckForNull Object obj) {
            refreshIfEmpty();
            return getListDelegate().indexOf(obj);
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator();
        }

        public ListIterator<V> listIterator(int i) {
            refreshIfEmpty();
            return new WrappedListIterator(i);
        }

        public List<V> subList(int i, int i2) {
            refreshIfEmpty();
            return AbstractMapBasedMultimap.this.wrapList(getKey(), getListDelegate().subList(i, i2), getAncestor() == null ? this : getAncestor());
        }

        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            public WrappedListIterator(int i) {
                super(WrappedList.this.getListDelegate().listIterator(i));
            }

            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator) getDelegateIterator();
            }

            public boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            @ParametricNullness
            public V previous() {
                return getDelegateListIterator().previous();
            }

            public int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            public int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            public void set(@ParametricNullness V v) {
                getDelegateListIterator().set(v);
            }

            public void add(@ParametricNullness V v) {
                boolean isEmpty = WrappedList.this.isEmpty();
                getDelegateListIterator().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    WrappedList.this.addToMap();
                }
            }
        }
    }

    private class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(@ParametricNullness AbstractMapBasedMultimap abstractMapBasedMultimap, K k, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new KeySet(this.map);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 instanceof NavigableMap) {
            return new NavigableKeySet((NavigableMap) this.map);
        }
        if (map2 instanceof SortedMap) {
            return new SortedKeySet((SortedMap) this.map);
        }
        return new KeySet(this.map);
    }

    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = map().entrySet().iterator();
            return new Iterator<K>() {
                @CheckForNull
                Map.Entry<K, Collection<V>> entry;

                public boolean hasNext() {
                    return it.hasNext();
                }

                @ParametricNullness
                public K next() {
                    Map.Entry<K, Collection<V>> entry2 = (Map.Entry) it.next();
                    this.entry = entry2;
                    return entry2.getKey();
                }

                public void remove() {
                    Preconditions.checkState(this.entry != null, "no calls to next() since the last call to remove()");
                    Collection value = this.entry.getValue();
                    it.remove();
                    AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, value.size());
                    value.clear();
                    this.entry = null;
                }
            };
        }

        public boolean remove(@CheckForNull Object obj) {
            int i;
            Collection collection = (Collection) map().remove(obj);
            if (collection != null) {
                i = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i);
            } else {
                i = 0;
            }
            if (i > 0) {
                return true;
            }
            return false;
        }

        public void clear() {
            Iterators.clear(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return map().keySet().containsAll(collection);
        }

        public boolean equals(@CheckForNull Object obj) {
            return this == obj || map().keySet().equals(obj);
        }

        public int hashCode() {
            return map().keySet().hashCode();
        }
    }

    private class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) super.map();
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @ParametricNullness
        public K first() {
            return sortedMap().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K k) {
            return new SortedKeySet(sortedMap().headMap(k));
        }

        @ParametricNullness
        public K last() {
            return sortedMap().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return new SortedKeySet(sortedMap().subMap(k, k2));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return new SortedKeySet(sortedMap().tailMap(k));
        }
    }

    class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @CheckForNull
        public K lower(@ParametricNullness K k) {
            return sortedMap().lowerKey(k);
        }

        @CheckForNull
        public K floor(@ParametricNullness K k) {
            return sortedMap().floorKey(k);
        }

        @CheckForNull
        public K ceiling(@ParametricNullness K k) {
            return sortedMap().ceilingKey(k);
        }

        @CheckForNull
        public K higher(@ParametricNullness K k) {
            return sortedMap().higherKey(k);
        }

        @CheckForNull
        public K pollFirst() {
            return Iterators.pollNext(iterator());
        }

        @CheckForNull
        public K pollLast() {
            return Iterators.pollNext(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(sortedMap().descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> headSet(@ParametricNullness K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> headSet(@ParametricNullness K k, boolean z) {
            return new NavigableKeySet(sortedMap().headMap(k, z));
        }

        public NavigableSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> subSet(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return new NavigableKeySet(sortedMap().subMap(k, z, k2, z2));
        }

        public NavigableSet<K> tailSet(@ParametricNullness K k) {
            return tailSet(k, true);
        }

        public NavigableSet<K> tailSet(@ParametricNullness K k, boolean z) {
            return new NavigableKeySet(sortedMap().tailMap(k, z));
        }
    }

    /* access modifiers changed from: private */
    public void removeValuesForKey(@CheckForNull Object obj) {
        Collection collection = (Collection) Maps.safeRemove(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        @CheckForNull
        Collection<V> collection = null;
        @CheckForNull
        K key = null;
        final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
        Iterator<V> valueIterator = Iterators.emptyModifiableIterator();

        /* access modifiers changed from: package-private */
        public abstract T output(@ParametricNullness K k, @ParametricNullness V v);

        Itr() {
            this.keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }

        public T next() {
            if (!this.valueIterator.hasNext()) {
                Map.Entry next = this.keyIterator.next();
                this.key = next.getKey();
                Collection<V> collection2 = (Collection) next.getValue();
                this.collection = collection2;
                this.valueIterator = collection2.iterator();
            }
            return output(NullnessCasts.uncheckedCastNullableTToT(this.key), this.valueIterator.next());
        }

        public void remove() {
            this.valueIterator.remove();
            if (((Collection) Objects.requireNonNull(this.collection)).isEmpty()) {
                this.keyIterator.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new AbstractMultimap.Values();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valueIterator() {
        return new AbstractMapBasedMultimap<K, V>.Itr<V>(this) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public V output(@ParametricNullness K k, @ParametricNullness V v) {
                return v;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof SetMultimap) {
            return new AbstractMultimap.EntrySet(this);
        }
        return new AbstractMultimap.Entries();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>(this) {
            /* access modifiers changed from: package-private */
            public Map.Entry<K, V> output(@ParametricNullness K k, @ParametricNullness V v) {
                return Maps.immutableEntry(k, v);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        return new AsMap(this.map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 instanceof NavigableMap) {
            return new NavigableAsMap((NavigableMap) this.map);
        }
        if (map2 instanceof SortedMap) {
            return new SortedAsMap((SortedMap) this.map);
        }
        return new AsMap(this.map);
    }

    private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> submap;

        AsMap(Map<K, Collection<V>> map) {
            this.submap = map;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new AsMapEntries();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return Maps.safeContainsKey(this.submap, obj);
        }

        @CheckForNull
        public Collection<V> get(@CheckForNull Object obj) {
            Collection collection = (Collection) Maps.safeGet(this.submap, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.submap.size();
        }

        @CheckForNull
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection remove = this.submap.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return createCollection;
        }

        public boolean equals(@CheckForNull Object obj) {
            return this == obj || this.submap.equals(obj);
        }

        public int hashCode() {
            return this.submap.hashCode();
        }

        public String toString() {
            return this.submap.toString();
        }

        public void clear() {
            if (this.submap == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.clear(new AsMapIterator());
            }
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.immutableEntry(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            public boolean contains(@CheckForNull Object obj) {
                return Collections2.safeContains(AsMap.this.submap.entrySet(), obj);
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) Objects.requireNonNull((Map.Entry) obj)).getKey());
                return true;
            }
        }

        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
            @CheckForNull
            Collection<V> collection;
            final Iterator<Map.Entry<K, Collection<V>>> delegateIterator;

            AsMapIterator() {
                this.delegateIterator = AsMap.this.submap.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            public Map.Entry<K, Collection<V>> next() {
                Map.Entry next = this.delegateIterator.next();
                this.collection = (Collection) next.getValue();
                return AsMap.this.wrapEntry(next);
            }

            public void remove() {
                Preconditions.checkState(this.collection != null, "no calls to next() since the last call to remove()");
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
                this.collection.clear();
                this.collection = null;
            }
        }
    }

    private class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {
        @CheckForNull
        SortedSet<K> sortedKeySet;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.submap;
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return sortedMap().firstKey();
        }

        @ParametricNullness
        public K lastKey() {
            return sortedMap().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K k) {
            return new SortedAsMap(sortedMap().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return new SortedAsMap(sortedMap().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K k) {
            return new SortedAsMap(sortedMap().tailMap(k));
        }

        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.sortedKeySet;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> createKeySet = createKeySet();
            this.sortedKeySet = createKeySet;
            return createKeySet;
        }

        /* access modifiers changed from: package-private */
        public SortedSet<K> createKeySet() {
            return new SortedKeySet(sortedMap());
        }
    }

    class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, Collection<V>> sortedMap() {
            return (NavigableMap) super.sortedMap();
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K k) {
            Map.Entry lowerEntry = sortedMap().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return wrapEntry(lowerEntry);
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return sortedMap().lowerKey(k);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K k) {
            Map.Entry floorEntry = sortedMap().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return wrapEntry(floorEntry);
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return sortedMap().floorKey(k);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K k) {
            Map.Entry ceilingEntry = sortedMap().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return wrapEntry(ceilingEntry);
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return sortedMap().ceilingKey(k);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K k) {
            Map.Entry higherEntry = sortedMap().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return wrapEntry(higherEntry);
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return sortedMap().higherKey(k);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry firstEntry = sortedMap().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return wrapEntry(firstEntry);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry lastEntry = sortedMap().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return wrapEntry(lastEntry);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return pollAsMapEntry(entrySet().iterator());
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return pollAsMapEntry(descendingMap().entrySet().iterator());
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry next = it.next();
            Collection createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll((Collection) next.getValue());
            it.remove();
            return Maps.immutableEntry(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(sortedMap().descendingMap());
        }

        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        /* access modifiers changed from: package-private */
        public NavigableSet<K> createKeySet() {
            return new NavigableKeySet(sortedMap());
        }

        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return new NavigableAsMap(sortedMap().subMap(k, z, k2, z2));
        }

        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k, boolean z) {
            return new NavigableAsMap(sortedMap().headMap(k, z));
        }

        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k, boolean z) {
            return new NavigableAsMap(sortedMap().tailMap(k, z));
        }
    }
}
