package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super K> keyPredicate;
    final Multimap<K, V> unfiltered;

    FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.keyPredicate = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    public int size() {
        int i = 0;
        for (Collection size : asMap().values()) {
            i += size.size();
        }
        return i;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (this.unfiltered.containsKey(obj)) {
            return this.keyPredicate.apply(obj);
        }
        return false;
    }

    public Collection<V> removeAll(@CheckForNull Object obj) {
        return containsKey(obj) ? this.unfiltered.removeAll(obj) : unmodifiableEmptyCollection();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }

    public void clear() {
        keySet().clear();
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    public Collection<V> get(@ParametricNullness K k) {
        if (this.keyPredicate.apply(k)) {
            return this.unfiltered.get(k);
        }
        if (this.unfiltered instanceof SetMultimap) {
            return new AddRejectingSet(k);
        }
        return new AddRejectingList(k);
    }

    static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        @ParametricNullness
        final K key;

        AddRejectingSet(@ParametricNullness K k) {
            this.key = k;
        }

        public boolean add(@ParametricNullness V v) {
            String valueOf = String.valueOf(this.key);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Key does not satisfy predicate: ").append(valueOf).toString());
        }

        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            String valueOf = String.valueOf(this.key);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Key does not satisfy predicate: ").append(valueOf).toString());
        }

        /* access modifiers changed from: protected */
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }

    static class AddRejectingList<K, V> extends ForwardingList<V> {
        @ParametricNullness
        final K key;

        AddRejectingList(@ParametricNullness K k) {
            this.key = k;
        }

        public boolean add(@ParametricNullness V v) {
            add(0, v);
            return true;
        }

        public void add(int i, @ParametricNullness V v) {
            Preconditions.checkPositionIndex(i, 0);
            String valueOf = String.valueOf(this.key);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Key does not satisfy predicate: ").append(valueOf).toString());
        }

        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i, 0);
            String valueOf = String.valueOf(this.key);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Key does not satisfy predicate: ").append(valueOf).toString());
        }

        /* access modifiers changed from: protected */
        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> createEntries() {
        return new Entries();
    }

    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        Entries() {
        }

        /* access modifiers changed from: protected */
        public Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(FilteredKeyMultimap.this.unfiltered.entries(), FilteredKeyMultimap.this.entryPredicate());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!FilteredKeyMultimap.this.unfiltered.containsKey(entry.getKey()) || !FilteredKeyMultimap.this.keyPredicate.apply(entry.getKey())) {
                return false;
            }
            return FilteredKeyMultimap.this.unfiltered.remove(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }
}
