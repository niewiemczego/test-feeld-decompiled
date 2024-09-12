package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return trustedGet(TypeToken.of(cls));
    }

    @CheckForNull
    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        return trustedGet(typeToken.rejectTypeVariables());
    }

    @CheckForNull
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return trustedPut(TypeToken.of(cls), t);
    }

    @CheckForNull
    public <T extends B> T putInstance(TypeToken<T> typeToken, T t) {
        return trustedPut(typeToken.rejectTypeVariables(), t);
    }

    @CheckForNull
    @Deprecated
    public B put(TypeToken<? extends B> typeToken, B b) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    /* access modifiers changed from: protected */
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @CheckForNull
    private <T extends B> T trustedPut(TypeToken<T> typeToken, T t) {
        return this.backingMap.put(typeToken, t);
    }

    @CheckForNull
    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.backingMap.get(typeToken);
    }

    private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        public static /* synthetic */ UnmodifiableEntry $r8$lambda$12WO2KxIwAy1IhqjHhPWXgv0Osg(Map.Entry entry) {
            return new UnmodifiableEntry(entry);
        }

        static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> set) {
            return new ForwardingSet<Map.Entry<K, V>>() {
                /* access modifiers changed from: protected */
                public Set<Map.Entry<K, V>> delegate() {
                    return set;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.transformEntries(super.iterator());
                }

                public Object[] toArray() {
                    return standardToArray();
                }

                public <T> T[] toArray(T[] tArr) {
                    return standardToArray(tArr);
                }
            };
        }

        /* access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> it) {
            return Iterators.transform(it, new MutableTypeToInstanceMap$UnmodifiableEntry$$ExternalSyntheticLambda0());
        }

        private UnmodifiableEntry(Map.Entry<K, V> entry) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(entry);
        }

        /* access modifiers changed from: protected */
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }
}
