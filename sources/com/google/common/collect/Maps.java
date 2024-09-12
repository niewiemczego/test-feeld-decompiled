package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Maps {

    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @CheckForNull
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@ParametricNullness K k, @ParametricNullness V1 v1);
    }

    private Maps() {
    }

    static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> it) {
        return new TransformedIterator<Map.Entry<K, V>, K>(it) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public K transform(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> it) {
        return new TransformedIterator<Map.Entry<K, V>, V>(it) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public V transform(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry next = it.next();
        Enum enumR = (Enum) next.getKey();
        Object value = next.getValue();
        CollectPreconditions.checkEntryNotNull(enumR, value);
        EnumMap enumMap = new EnumMap(enumR.getDeclaringClass());
        enumMap.put(enumR, value);
        while (it.hasNext()) {
            Map.Entry next2 = it.next();
            Enum enumR2 = (Enum) next2.getKey();
            Object value2 = next2.getValue();
            CollectPreconditions.checkEntryNotNull(enumR2, value2);
            enumMap.put(enumR2, value2);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }

    static int capacity(int i) {
        if (i < 3) {
            CollectPreconditions.checkNonnegative(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(capacity(i));
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>(sortedMap);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        if (map instanceof SortedMap) {
            return difference((SortedMap) map, map2);
        }
        return difference(map, map2, Equivalence.equals());
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap newLinkedHashMap2 = newLinkedHashMap();
        LinkedHashMap newLinkedHashMap3 = newLinkedHashMap();
        doDifference(map, map2, equivalence, newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
        return new MapDifferenceImpl(newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator<? super E> orNaturalOrder = orNaturalOrder(sortedMap.comparator());
        TreeMap<K, V> newTreeMap = newTreeMap(orNaturalOrder);
        TreeMap<K, V> newTreeMap2 = newTreeMap(orNaturalOrder);
        newTreeMap2.putAll(map);
        TreeMap<K, V> newTreeMap3 = newTreeMap(orNaturalOrder);
        TreeMap<K, V> newTreeMap4 = newTreeMap(orNaturalOrder);
        doDifference(sortedMap, map, Equivalence.equals(), newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
        return new SortedMapDifferenceImpl(newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
    }

    private static <K, V> void doDifference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (map2.containsKey(key)) {
                Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(map4.remove(key));
                if (equivalence.equivalent(value, uncheckedCastNullableTToT)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, ValueDifferenceImpl.create(value, uncheckedCastNullableTToT));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, MapDifference.ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        MapDifferenceImpl(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, MapDifference.ValueDifference<V>> map4) {
            this.onlyOnLeft = Maps.unmodifiableMap(map);
            this.onlyOnRight = Maps.unmodifiableMap(map2);
            this.onBoth = Maps.unmodifiableMap(map3);
            this.differences = Maps.unmodifiableMap(map4);
        }

        public boolean areEqual() {
            return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
        }

        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            MapDifference mapDifference = (MapDifference) obj;
            if (!entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) || !entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) || !entriesInCommon().equals(mapDifference.entriesInCommon()) || !entriesDiffering().equals(mapDifference.entriesDiffering())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (areEqual()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                sb.append(": only on left=").append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                sb.append(": only on right=").append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                sb.append(": value differences=").append(this.differences);
            }
            return sb.toString();
        }
    }

    static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        @ParametricNullness
        private final V left;
        @ParametricNullness
        private final V right;

        static <V> MapDifference.ValueDifference<V> create(@ParametricNullness V v, @ParametricNullness V v2) {
            return new ValueDifferenceImpl(v, v2);
        }

        private ValueDifferenceImpl(@ParametricNullness V v, @ParametricNullness V v2) {
            this.left = v;
            this.right = v2;
        }

        @ParametricNullness
        public V leftValue() {
            return this.left;
        }

        @ParametricNullness
        public V rightValue() {
            return this.right;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
            if (!Objects.equal(this.left, valueDifference.leftValue()) || !Objects.equal(this.right, valueDifference.rightValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            String valueOf = String.valueOf(this.left);
            String valueOf2 = String.valueOf(this.right);
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length()).append("(").append(valueOf).append(", ").append(valueOf2).append(")").toString();
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    static <E> Comparator<? super E> orNaturalOrder(@CheckForNull Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new AsMapView(set, function);
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new SortedAsMapView(sortedSet, function);
    }

    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new NavigableAsMapView(navigableSet, function);
    }

    private static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
        final Function<? super K, V> function;
        private final Set<K> set;

        /* access modifiers changed from: package-private */
        public Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> set2, Function<? super K, V> function2) {
            this.set = (Set) Preconditions.checkNotNull(set2);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public Set<K> createKeySet() {
            return Maps.removeOnlySet(backingSet());
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        public int size() {
            return backingSet().size();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return backingSet().contains(obj);
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (Collections2.safeContains(backingSet(), obj)) {
                return this.function.apply(obj);
            }
            return null;
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (backingSet().remove(obj)) {
                return this.function.apply(obj);
            }
            return null;
        }

        public void clear() {
            backingSet().clear();
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return AsMapView.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return Maps.asMapEntryIterator(AsMapView.this.backingSet(), AsMapView.this.function);
                }
            };
        }
    }

    static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Map.Entry<K, V>>(set.iterator()) {
            /* access modifiers changed from: package-private */
            public Map.Entry<K, V> transform(@ParametricNullness K k) {
                return Maps.immutableEntry(k, function.apply(k));
            }
        };
    }

    private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> sortedSet, Function<? super K, V> function) {
            super(sortedSet, function);
        }

        /* access modifiers changed from: package-private */
        public SortedSet<K> backingSet() {
            return (SortedSet) super.backingSet();
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        public Set<K> keySet() {
            return Maps.removeOnlySortedSet(backingSet());
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return Maps.asMap(backingSet().subSet(k, k2), this.function);
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return Maps.asMap(backingSet().headSet(k), this.function);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return Maps.asMap(backingSet().tailSet(k), this.function);
        }

        @ParametricNullness
        public K firstKey() {
            return backingSet().first();
        }

        @ParametricNullness
        public K lastKey() {
            return backingSet().last();
        }
    }

    private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final Function<? super K, V> function;
        private final NavigableSet<K> set;

        NavigableAsMapView(NavigableSet<K> navigableSet, Function<? super K, V> function2) {
            this.set = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.asMap(this.set.subSet(k, z, k2, z2), this.function);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.asMap(this.set.headSet(k, z), this.function);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.asMap(this.set.tailSet(k, z), this.function);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (Collections2.safeContains(this.set, obj)) {
                return this.function.apply(obj);
            }
            return null;
        }

        public void clear() {
            this.set.clear();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asMapEntryIterator(this.set, this.function);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return descendingMap().entrySet().iterator();
        }

        public NavigableSet<K> navigableKeySet() {
            return Maps.removeOnlyNavigableSet(this.set);
        }

        public int size() {
            return this.set.size();
        }

        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap(this.set.descendingSet(), this.function);
        }
    }

    /* access modifiers changed from: private */
    public static <E> Set<E> removeOnlySet(final Set<E> set) {
        return new ForwardingSet<E>() {
            /* access modifiers changed from: protected */
            public Set<E> delegate() {
                return set;
            }

            public boolean add(@ParametricNullness E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* access modifiers changed from: private */
    public static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> sortedSet) {
        return new ForwardingSortedSet<E>() {
            /* access modifiers changed from: protected */
            public SortedSet<E> delegate() {
                return sortedSet;
            }

            public boolean add(@ParametricNullness E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public SortedSet<E> headSet(@ParametricNullness E e) {
                return Maps.removeOnlySortedSet(super.headSet(e));
            }

            public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
                return Maps.removeOnlySortedSet(super.subSet(e, e2));
            }

            public SortedSet<E> tailSet(@ParametricNullness E e) {
                return Maps.removeOnlySortedSet(super.tailSet(e));
            }
        };
    }

    /* access modifiers changed from: private */
    public static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> navigableSet) {
        return new ForwardingNavigableSet<E>() {
            /* access modifiers changed from: protected */
            public NavigableSet<E> delegate() {
                return navigableSet;
            }

            public boolean add(@ParametricNullness E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public SortedSet<E> headSet(@ParametricNullness E e) {
                return Maps.removeOnlySortedSet(super.headSet(e));
            }

            public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
                return Maps.removeOnlyNavigableSet(super.headSet(e, z));
            }

            public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
                return Maps.removeOnlySortedSet(super.subSet(e, e2));
            }

            public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
                return Maps.removeOnlyNavigableSet(super.subSet(e, z, e2, z2));
            }

            public SortedSet<E> tailSet(@ParametricNullness E e) {
                return Maps.removeOnlySortedSet(super.tailSet(e));
            }

            public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
                return Maps.removeOnlyNavigableSet(super.tailSet(e, z));
            }

            public NavigableSet<E> descendingSet() {
                return Maps.removeOnlyNavigableSet(super.descendingSet());
            }
        };
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> iterable, Function<? super K, V> function) {
        return toMap(iterable.iterator(), function);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> it, Function<? super K, V> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            K next = it.next();
            builder.put(next, function.apply(next));
        }
        return builder.buildKeepingLast();
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> iterable, Function<? super V, K> function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.buildOrThrow();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.valueOf(e.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) java.util.Objects.requireNonNull(propertyNames.nextElement());
            builder.put(str, (String) java.util.Objects.requireNonNull(properties.getProperty(str)));
        }
        return builder.buildOrThrow();
    }

    public static <K, V> Map.Entry<K, V> immutableEntry(@ParametricNullness K k, @ParametricNullness V v) {
        return new ImmutableEntry(k, v);
    }

    static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(set));
    }

    static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V>() {
            @ParametricNullness
            public K getKey() {
                return entry.getKey();
            }

            @ParametricNullness
            public V getValue() {
                return entry.getValue();
            }
        };
    }

    static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(final Iterator<Map.Entry<K, V>> it) {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public Map.Entry<K, V> next() {
                return Maps.unmodifiableEntry((Map.Entry) it.next());
            }
        };
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        UnmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
            this.entries = collection;
        }

        /* access modifiers changed from: protected */
        public Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.unmodifiableEntryIterator(this.entries.iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> biMap) {
        return new BiMapConverter(biMap);
    }

    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> biMap) {
            this.bimap = (BiMap) Preconditions.checkNotNull(biMap);
        }

        /* access modifiers changed from: protected */
        public B doForward(A a) {
            return convert(this.bimap, a);
        }

        /* access modifiers changed from: protected */
        public A doBackward(B b) {
            return convert(this.bimap.inverse(), b);
        }

        private static <X, Y> Y convert(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            Preconditions.checkArgument(y != null, "No non-null mapping present for input: %s", (Object) x);
            return y;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.bimap);
            return new StringBuilder(String.valueOf(valueOf).length() + 18).append("Maps.asConverter(").append(valueOf).append(")").toString();
        }
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> biMap) {
        return Synchronized.biMap(biMap, (Object) null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> biMap) {
        return new UnmodifiableBiMap(biMap, (BiMap) null);
    }

    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        @CheckForNull
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        @CheckForNull
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, @CheckForNull BiMap<V, K> biMap2) {
            this.unmodifiableMap = Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        /* access modifiers changed from: protected */
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @CheckForNull
        public V forcePut(@ParametricNullness K k, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> map, Function<? super V1, V2> function) {
        return transformEntries(map, asEntryTransformer(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return transformEntries(sortedMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        return transformEntries(navigableMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesMap(map, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }

    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new EntryTransformer<K, V1, V2>() {
            @ParametricNullness
            public V2 transformEntry(@ParametricNullness K k, @ParametricNullness V1 v1) {
                return Function.this.apply(v1);
            }
        };
    }

    static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> entryTransformer, @ParametricNullness final K k) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<V1, V2>() {
            @ParametricNullness
            public V2 apply(@ParametricNullness V1 v1) {
                return EntryTransformer.this.transformEntry(k, v1);
            }
        };
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<Map.Entry<K, V1>, V2>() {
            @ParametricNullness
            public V2 apply(Map.Entry<K, V1> entry) {
                return EntryTransformer.this.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> entryTransformer, final Map.Entry<K, V1> entry) {
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V2>() {
            @ParametricNullness
            public K getKey() {
                return entry.getKey();
            }

            @ParametricNullness
            public V2 getValue() {
                return entryTransformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>() {
            public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
                return Maps.transformEntry(EntryTransformer.this, entry);
            }
        };
    }

    static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMap(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.fromMap = (Map) Preconditions.checkNotNull(map);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        public int size() {
            return this.fromMap.size();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.fromMap.containsKey(obj);
        }

        @CheckForNull
        public V2 get(@CheckForNull Object obj) {
            V1 v1 = this.fromMap.get(obj);
            if (v1 != null || this.fromMap.containsKey(obj)) {
                return this.transformer.transformEntry(obj, NullnessCasts.uncheckedCastNullableTToT(v1));
            }
            return null;
        }

        @CheckForNull
        public V2 remove(@CheckForNull Object obj) {
            if (this.fromMap.containsKey(obj)) {
                return this.transformer.transformEntry(obj, NullnessCasts.uncheckedCastNullableTToT(this.fromMap.remove(obj)));
            }
            return null;
        }

        public void clear() {
            this.fromMap.clear();
        }

        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        public Collection<V2> values() {
            return new Values(this);
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        /* access modifiers changed from: protected */
        public SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V2> headMap(@ParametricNullness K k) {
            return Maps.transformEntries(fromMap().headMap(k), this.transformer);
        }

        @ParametricNullness
        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return Maps.transformEntries(fromMap().subMap(k, k2), this.transformer);
        }

        public SortedMap<K, V2> tailMap(@ParametricNullness K k) {
            return Maps.transformEntries(fromMap().tailMap(k), this.transformer);
        }
    }

    private static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @CheckForNull
        public Map.Entry<K, V2> ceilingEntry(@ParametricNullness K k) {
            return transformEntry(fromMap().ceilingEntry(k));
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return fromMap().ceilingKey(k);
        }

        public NavigableSet<K> descendingKeySet() {
            return fromMap().descendingKeySet();
        }

        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries(fromMap().descendingMap(), this.transformer);
        }

        @CheckForNull
        public Map.Entry<K, V2> firstEntry() {
            return transformEntry(fromMap().firstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> floorEntry(@ParametricNullness K k) {
            return transformEntry(fromMap().floorEntry(k));
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return fromMap().floorKey(k);
        }

        public NavigableMap<K, V2> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V2> headMap(@ParametricNullness K k, boolean z) {
            return Maps.transformEntries(fromMap().headMap(k, z), this.transformer);
        }

        @CheckForNull
        public Map.Entry<K, V2> higherEntry(@ParametricNullness K k) {
            return transformEntry(fromMap().higherEntry(k));
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return fromMap().higherKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V2> lastEntry() {
            return transformEntry(fromMap().lastEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> lowerEntry(@ParametricNullness K k) {
            return transformEntry(fromMap().lowerEntry(k));
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return fromMap().lowerKey(k);
        }

        public NavigableSet<K> navigableKeySet() {
            return fromMap().navigableKeySet();
        }

        @CheckForNull
        public Map.Entry<K, V2> pollFirstEntry() {
            return transformEntry(fromMap().pollFirstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> pollLastEntry() {
            return transformEntry(fromMap().pollLastEntry());
        }

        public NavigableMap<K, V2> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.transformEntries(fromMap().subMap(k, z, k2, z2), this.transformer);
        }

        public NavigableMap<K, V2> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V2> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, V2> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.transformEntries(fromMap().tailMap(k, z), this.transformer);
        }

        @CheckForNull
        private Map.Entry<K, V2> transformEntry(@CheckForNull Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.transformEntry(this.transformer, entry);
        }

        /* access modifiers changed from: protected */
        public NavigableMap<K, V1> fromMap() {
            return (NavigableMap) super.fromMap();
        }
    }

    static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> predicate) {
        return Predicates.compose(predicate, keyFunction());
    }

    static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> predicate) {
        return Predicates.compose(predicate, valueFunction());
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate<Map.Entry<K, ?>> keyPredicateOnEntries = keyPredicateOnEntries(predicate);
        if (map instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) map, keyPredicateOnEntries);
        }
        return new FilteredKeyMap((Map) Preconditions.checkNotNull(map), predicate, keyPredicateOnEntries);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return filterEntries(sortedMap, keyPredicateOnEntries(predicate));
    }

    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return filterEntries(navigableMap, keyPredicateOnEntries(predicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries(biMap, keyPredicateOnEntries(predicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> map, Predicate<? super V> predicate) {
        return filterEntries(map, valuePredicateOnEntries(predicate));
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return filterEntries(sortedMap, valuePredicateOnEntries(predicate));
    }

    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return filterEntries(navigableMap, valuePredicateOnEntries(predicate));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return filterEntries(biMap, valuePredicateOnEntries(predicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (map instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) map, predicate);
        }
        return new FilteredEntryMap((Map) Preconditions.checkNotNull(map), predicate);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (sortedMap instanceof FilteredEntrySortedMap) {
            return filterFiltered((FilteredEntrySortedMap) sortedMap, predicate);
        }
        return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
    }

    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (navigableMap instanceof FilteredEntryNavigableMap) {
            return filterFiltered((FilteredEntryNavigableMap) navigableMap, predicate);
        }
        return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (biMap instanceof FilteredEntryBiMap) {
            return filterFiltered((FilteredEntryBiMap) biMap, predicate);
        }
        return new FilteredEntryBiMap(biMap, predicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> abstractFilteredMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMap(abstractFilteredMap.unfiltered, Predicates.and(abstractFilteredMap.predicate, predicate));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> filteredEntrySortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySortedMap(filteredEntrySortedMap.sortedMap(), Predicates.and(filteredEntrySortedMap.predicate, predicate));
    }

    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> filteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.unfiltered, Predicates.and(filteredEntryNavigableMap.entryPredicate, predicate));
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> filteredEntryBiMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryBiMap(filteredEntryBiMap.unfiltered(), Predicates.and(filteredEntryBiMap.predicate, predicate));
    }

    private static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        AbstractFilteredMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate2) {
            this.unfiltered = map;
            this.predicate = predicate2;
        }

        /* access modifiers changed from: package-private */
        public boolean apply(@CheckForNull Object obj, @ParametricNullness V v) {
            return this.predicate.apply(Maps.immutableEntry(obj, v));
        }

        @CheckForNull
        public V put(@ParametricNullness K k, @ParametricNullness V v) {
            Preconditions.checkArgument(apply(k, v));
            return this.unfiltered.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry next : map.entrySet()) {
                Preconditions.checkArgument(apply(next.getKey(), next.getValue()));
            }
            this.unfiltered.putAll(map);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.unfiltered.containsKey(obj) && apply(obj, this.unfiltered.get(obj));
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v = this.unfiltered.get(obj);
            if (v == null || !apply(obj, v)) {
                return null;
            }
            return v;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.unfiltered.remove(obj);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }
    }

    private static final class FilteredMapValues<K, V> extends Values<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        FilteredMapValues(Map<K, V> map, Map<K, V> map2, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map);
            this.unfiltered = map2;
            this.predicate = predicate2;
        }

        public boolean remove(@CheckForNull Object obj) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && Objects.equal(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        final Predicate<? super K> keyPredicate;

        FilteredKeyMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.keyPredicate = predicate;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.unfiltered.containsKey(obj) && this.keyPredicate.apply(obj);
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;

        FilteredEntryMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.filteredEntrySet = Sets.filter(map.entrySet(), this.predicate);
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet();
        }

        private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            /* access modifiers changed from: protected */
            public Set<Map.Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(FilteredEntryMap.this.filteredEntrySet.iterator()) {
                    /* access modifiers changed from: package-private */
                    public Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
                        return new ForwardingMapEntry<K, V>() {
                            /* access modifiers changed from: protected */
                            public Map.Entry<K, V> delegate() {
                                return entry;
                            }

                            @ParametricNullness
                            public V setValue(@ParametricNullness V v) {
                                Preconditions.checkArgument(FilteredEntryMap.this.apply(getKey(), v));
                                return super.setValue(v);
                            }
                        };
                    }
                };
            }
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return new KeySet();
        }

        static <K, V> boolean removeAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        static <K, V> boolean retainAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!FilteredEntryMap.this.containsKey(obj)) {
                    return false;
                }
                FilteredEntryMap.this.unfiltered.remove(obj);
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                return FilteredEntryMap.removeAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            public boolean retainAll(Collection<?> collection) {
                return FilteredEntryMap.retainAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            public <T> T[] toArray(T[] tArr) {
                return Lists.newArrayList(iterator()).toArray(tArr);
            }
        }
    }

    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
        FilteredEntrySortedMap(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        /* access modifiers changed from: package-private */
        public SortedSet<K> createKeySet() {
            return new SortedKeySet();
        }

        class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            @CheckForNull
            public Comparator<? super K> comparator() {
                return FilteredEntrySortedMap.this.sortedMap().comparator();
            }

            public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(k, k2).keySet();
            }

            public SortedSet<K> headSet(@ParametricNullness K k) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(k).keySet();
            }

            public SortedSet<K> tailSet(@ParametricNullness K k) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(k).keySet();
            }

            @ParametricNullness
            public K first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            @ParametricNullness
            public K last() {
                return FilteredEntrySortedMap.this.lastKey();
            }
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return keySet().iterator().next();
        }

        @ParametricNullness
        public K lastKey() {
            SortedMap sortedMap = sortedMap();
            while (true) {
                K lastKey = sortedMap.lastKey();
                if (apply(lastKey, NullnessCasts.uncheckedCastNullableTToT(this.unfiltered.get(lastKey)))) {
                    return lastKey;
                }
                sortedMap = sortedMap().headMap(lastKey);
            }
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return new FilteredEntrySortedMap(sortedMap().headMap(k), this.predicate);
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return new FilteredEntrySortedMap(sortedMap().subMap(k, k2), this.predicate);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(k), this.predicate);
        }
    }

    private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        /* access modifiers changed from: private */
        public final Predicate<? super Map.Entry<K, V>> entryPredicate;
        private final Map<K, V> filteredDelegate;
        /* access modifiers changed from: private */
        public final NavigableMap<K, V> unfiltered;

        FilteredEntryNavigableMap(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
            this.unfiltered = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.entryPredicate = predicate;
            this.filteredDelegate = new FilteredEntryMap(navigableMap, predicate);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.unfiltered.comparator();
        }

        public NavigableSet<K> navigableKeySet() {
            return new NavigableKeySet<K, V>(this) {
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMap.removeAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMap.retainAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }
            };
        }

        public Collection<V> values() {
            return new FilteredMapValues(this, this.unfiltered, this.entryPredicate);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
        }

        public int size() {
            return this.filteredDelegate.size();
        }

        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return this.filteredDelegate.get(obj);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.filteredDelegate.containsKey(obj);
        }

        @CheckForNull
        public V put(@ParametricNullness K k, @ParametricNullness V v) {
            return this.filteredDelegate.put(k, v);
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return this.filteredDelegate.remove(obj);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.filteredDelegate.putAll(map);
        }

        public void clear() {
            this.filteredDelegate.clear();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return this.filteredDelegate.entrySet();
        }

        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
        }

        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.filterEntries(this.unfiltered.subMap(k, z, k2, z2), this.entryPredicate);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.filterEntries(this.unfiltered.headMap(k, z), this.entryPredicate);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.filterEntries(this.unfiltered.tailMap(k, z), this.entryPredicate);
        }
    }

    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        private final BiMap<V, K> inverse;

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> predicate) {
            return new Predicate<Map.Entry<V, K>>() {
                public boolean apply(Map.Entry<V, K> entry) {
                    return Predicate.this.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
                }
            };
        }

        FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(biMap, predicate);
            this.inverse = new FilteredEntryBiMap(biMap.inverse(), inversePredicate(predicate), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> biMap2) {
            super(biMap, predicate);
            this.inverse = biMap2;
        }

        /* access modifiers changed from: package-private */
        public BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        @CheckForNull
        public V forcePut(@ParametricNullness K k, @ParametricNullness V v) {
            Preconditions.checkArgument(apply(k, v));
            return unfiltered().forcePut(k, v);
        }

        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        public Set<V> values() {
            return this.inverse.keySet();
        }
    }

    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (navigableMap instanceof UnmodifiableNavigableMap) {
            return navigableMap;
        }
        return new UnmodifiableNavigableMap(navigableMap);
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static <K, V> Map.Entry<K, V> unmodifiableOrNull(@CheckForNull Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return unmodifiableEntry(entry);
    }

    static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;
        @CheckForNull
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        /* access modifiers changed from: protected */
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
            return Maps.unmodifiableOrNull(this.delegate.lowerEntry(k));
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return this.delegate.lowerKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
            return Maps.unmodifiableOrNull(this.delegate.floorEntry(k));
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return this.delegate.floorKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
            return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(k));
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return this.delegate.ceilingKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
            return Maps.unmodifiableOrNull(this.delegate.higherEntry(k));
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return this.delegate.higherKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return Maps.unmodifiableOrNull(this.delegate.firstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return Maps.unmodifiableOrNull(this.delegate.lastEntry());
        }

        @CheckForNull
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(k, z, k2, z2));
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(k, z));
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(k, z));
        }
    }

    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        @CheckForNull
        private transient Set<Map.Entry<K, V>> entrySet;
        @CheckForNull
        private transient Set<K> keySet;
        @CheckForNull
        private transient Collection<V> values;

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> createEntrySet();

        ViewCachingAbstractMap() {
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return new Values(this);
        }
    }

    static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        public abstract int size();

        IteratorBasedAbstractMap() {
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return IteratorBasedAbstractMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedAbstractMap.this.entryIterator();
                }
            };
        }

        public void clear() {
            Iterators.clear(entryIterator());
        }
    }

    @CheckForNull
    static <V> V safeGet(Map<?, V> map, @CheckForNull Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean safeContainsKey(Map<?, ?> map, @CheckForNull Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @CheckForNull
    static <V> V safeRemove(Map<?, V> map, @CheckForNull Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean containsKeyImpl(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), obj);
    }

    static boolean containsValueImpl(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), obj);
    }

    static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(unmodifiableEntry((Map.Entry) obj));
    }

    static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.remove(unmodifiableEntry((Map.Entry) obj));
    }

    static boolean equalsImpl(Map<?, ?> map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static String toStringImpl(Map<?, ?> map) {
        StringBuilder append = Collections2.newStringBuilderForCollection(map.size()).append('{');
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z) {
                append.append(", ");
            }
            z = false;
            append.append(next.getKey()).append('=').append(next.getValue());
        }
        return append.append('}').toString();
    }

    static <K, V> void putAllImpl(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            map.put(next.getKey(), next.getValue());
        }
    }

    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        final Map<K, V> map;

        KeySet(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> map() {
            return this.map;
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(@CheckForNull Object obj) {
            return map().containsKey(obj);
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            map().remove(obj);
            return true;
        }

        public void clear() {
            map().clear();
        }
    }

    @CheckForNull
    static <K> K keyOrNull(@CheckForNull Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    @CheckForNull
    static <V> V valueOrNull(@CheckForNull Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        SortedKeySet(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> map() {
            return (SortedMap) super.map();
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return new SortedKeySet(map().subMap(k, k2));
        }

        public SortedSet<K> headSet(@ParametricNullness K k) {
            return new SortedKeySet(map().headMap(k));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return new SortedKeySet(map().tailMap(k));
        }

        @ParametricNullness
        public K first() {
            return map().firstKey();
        }

        @ParametricNullness
        public K last() {
            return map().lastKey();
        }
    }

    static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> map() {
            return (NavigableMap) this.map;
        }

        @CheckForNull
        public K lower(@ParametricNullness K k) {
            return map().lowerKey(k);
        }

        @CheckForNull
        public K floor(@ParametricNullness K k) {
            return map().floorKey(k);
        }

        @CheckForNull
        public K ceiling(@ParametricNullness K k) {
            return map().ceilingKey(k);
        }

        @CheckForNull
        public K higher(@ParametricNullness K k) {
            return map().higherKey(k);
        }

        @CheckForNull
        public K pollFirst() {
            return Maps.keyOrNull(map().pollFirstEntry());
        }

        @CheckForNull
        public K pollLast() {
            return Maps.keyOrNull(map().pollLastEntry());
        }

        public NavigableSet<K> descendingSet() {
            return map().descendingKeySet();
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> subSet(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return map().subMap(k, z, k2, z2).navigableKeySet();
        }

        public SortedSet<K> subSet(@ParametricNullness K k, @ParametricNullness K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> headSet(@ParametricNullness K k, boolean z) {
            return map().headMap(k, z).navigableKeySet();
        }

        public SortedSet<K> headSet(@ParametricNullness K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> tailSet(@ParametricNullness K k, boolean z) {
            return map().tailMap(k, z).navigableKeySet();
        }

        public SortedSet<K> tailSet(@ParametricNullness K k) {
            return tailSet(k, true);
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        final Map<K, V> map;

        Values(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> map() {
            return this.map;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : map().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(newHashSet);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(newHashSet);
            }
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(@CheckForNull Object obj) {
            return map().containsValue(obj);
        }

        public void clear() {
            map().clear();
        }
    }

    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object safeGet = Maps.safeGet(map(), key);
            if (!Objects.equal(safeGet, entry.getValue())) {
                return false;
            }
            if (safeGet != null || map().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            return map().keySet().remove(((Map.Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.removeAllImpl((Set<?>) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
                for (Object next : collection) {
                    if (contains(next) && (next instanceof Map.Entry)) {
                        newHashSetWithExpectedSize.add(((Map.Entry) next).getKey());
                    }
                }
                return map().keySet().retainAll(newHashSetWithExpectedSize);
            }
        }
    }

    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        @CheckForNull
        private transient Comparator<? super K> comparator;
        @CheckForNull
        private transient Set<Map.Entry<K, V>> entrySet;
        @CheckForNull
        private transient NavigableSet<K> navigableKeySet;

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        /* access modifiers changed from: package-private */
        public abstract NavigableMap<K, V> forward();

        DescendingMap() {
        }

        /* access modifiers changed from: protected */
        public final Map<K, V> delegate() {
            return forward();
        }

        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator2 = this.comparator;
            if (comparator2 != null) {
                return comparator2;
            }
            Comparator comparator3 = forward().comparator();
            if (comparator3 == null) {
                comparator3 = Ordering.natural();
            }
            Ordering reverse = reverse(comparator3);
            this.comparator = reverse;
            return reverse;
        }

        private static <T> Ordering<T> reverse(Comparator<T> comparator2) {
            return Ordering.from(comparator2).reverse();
        }

        @ParametricNullness
        public K firstKey() {
            return forward().lastKey();
        }

        @ParametricNullness
        public K lastKey() {
            return forward().firstKey();
        }

        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
            return forward().higherEntry(k);
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k) {
            return forward().higherKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
            return forward().ceilingEntry(k);
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k) {
            return forward().ceilingKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
            return forward().floorEntry(k);
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k) {
            return forward().floorKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
            return forward().lowerEntry(k);
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k) {
            return forward().lowerKey(k);
        }

        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return forward().lastEntry();
        }

        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return forward().firstEntry();
        }

        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return forward().pollLastEntry();
        }

        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return forward().pollFirstEntry();
        }

        public NavigableMap<K, V> descendingMap() {
            return forward();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return DescendingMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return DescendingMap.this.entryIterator();
                }
            };
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.navigableKeySet;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableKeySet navigableKeySet2 = new NavigableKeySet(this);
            this.navigableKeySet = navigableKeySet2;
            return navigableKeySet2;
        }

        public NavigableSet<K> descendingKeySet() {
            return forward().navigableKeySet();
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
            return forward().subMap(k2, z2, k, z).descendingMap();
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
            return forward().tailMap(k, z).descendingMap();
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
            return forward().headMap(k, z).descendingMap();
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k) {
            return tailMap(k, true);
        }

        public Collection<V> values() {
            return new Values(this);
        }

        public String toString() {
            return standardToString();
        }
    }

    static <E> ImmutableMap<E, Integer> indexMap(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i = 0;
        for (E put : collection) {
            builder.put(put, Integer.valueOf(i));
            i++;
        }
        return builder.buildOrThrow();
    }

    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> navigableMap, Range<K> range) {
        boolean z = true;
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            boolean z2 = range.lowerBoundType() == BoundType.CLOSED;
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.subMap(lowerEndpoint, z2, upperEndpoint, z);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.tailMap(lowerEndpoint2, z);
        } else if (!range.hasUpperBound()) {
            return (NavigableMap) Preconditions.checkNotNull(navigableMap);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.headMap(upperEndpoint2, z);
        }
    }
}
