package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient Map<K, V> delegate;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySet;
    transient AbstractBiMap<V, K> inverse;
    @CheckForNull
    private transient Set<K> keySet;
    @CheckForNull
    private transient Set<V> valueSet;

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public K checkKey(@ParametricNullness K k) {
        return k;
    }

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public V checkValue(@ParametricNullness V v) {
        return v;
    }

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    /* access modifiers changed from: protected */
    public Map<K, V> delegate() {
        return this.delegate;
    }

    /* access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    /* access modifiers changed from: package-private */
    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    /* access modifiers changed from: package-private */
    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return this.inverse.containsKey(obj);
    }

    @CheckForNull
    public V put(@ParametricNullness K k, @ParametricNullness V v) {
        return putInBothMaps(k, v, false);
    }

    @CheckForNull
    public V forcePut(@ParametricNullness K k, @ParametricNullness V v) {
        return putInBothMaps(k, v, true);
    }

    @CheckForNull
    private V putInBothMaps(@ParametricNullness K k, @ParametricNullness V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            Preconditions.checkArgument(!containsValue(v), "value already present: %s", (Object) v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* access modifiers changed from: private */
    public void updateInverseMap(@ParametricNullness K k, boolean z, @CheckForNull V v, @ParametricNullness V v2) {
        if (z) {
            removeFromInverseMap(NullnessCasts.uncheckedCastNullableTToT(v));
        }
        this.inverse.delegate.put(v2, k);
    }

    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    /* access modifiers changed from: private */
    @ParametricNullness
    public V removeFromBothMaps(@CheckForNull Object obj) {
        V uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.delegate.remove(obj));
        removeFromInverseMap(uncheckedCastNullableTToT);
        return uncheckedCastNullableTToT;
    }

    /* access modifiers changed from: private */
    public void removeFromInverseMap(@ParametricNullness V v) {
        this.inverse.delegate.remove(v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    private class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        /* access modifiers changed from: protected */
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Object unused = AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    private class ValueSet extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        /* access modifiers changed from: protected */
        public Set<V> delegate() {
            return this.valuesDelegate;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public String toString() {
            return standardToString();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        BiMapEntry(Map.Entry<K, V> entry) {
            this.delegate = entry;
        }

        /* access modifiers changed from: protected */
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v, getValue())) {
                return v;
            }
            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v), "value already present: %s", (Object) v);
            V value = this.delegate.setValue(v);
            Preconditions.checkState(Objects.equal(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>() {
            @CheckForNull
            Map.Entry<K, V> entry;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Map.Entry<K, V> next() {
                this.entry = (Map.Entry) it.next();
                return new BiMapEntry(this.entry);
            }

            public void remove() {
                Map.Entry<K, V> entry2 = this.entry;
                if (entry2 != null) {
                    V value = entry2.getValue();
                    it.remove();
                    AbstractBiMap.this.removeFromInverseMap(value);
                    this.entry = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
        };
    }

    private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!this.esDelegate.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public boolean contains(@CheckForNull Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public K checkKey(@ParametricNullness K k) {
            return this.inverse.checkValue(k);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V checkValue(@ParametricNullness V v) {
            return this.inverse.checkKey(v);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return inverse().inverse();
        }
    }
}
