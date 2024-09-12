package com.adapty.utils;

import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001)B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u001f\u001a\u00020 2\u0018\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\"J\u0018\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0012H\u0016J\u0006\u0010&\u001a\u00020\u0018J\b\u0010'\u001a\u00020(H\u0016R;\u0010\u0007\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\n0\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006*"}, d2 = {"Lcom/adapty/utils/ImmutableMap;", "K", "V", "", "map", "", "(Ljava/util/Map;)V", "entries", "Lcom/adapty/utils/ImmutableCollection;", "Lcom/adapty/utils/ImmutableMap$Entry;", "", "entrySet", "()Lcom/adapty/utils/ImmutableCollection;", "keys", "keySet", "getMap$adapty_release", "()Ljava/util/Map;", "size", "", "()I", "values", "Lcom/adapty/utils/ImmutableList;", "()Lcom/adapty/utils/ImmutableList;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "forEach", "", "action", "Lcom/adapty/utils/Callback;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "isEmpty", "toString", "", "Entry", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImmutableCollections.kt */
public final class ImmutableMap<K, V> {
    private final Map<K, V> map;

    public ImmutableMap(Map<K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map2, AdaptyImmutableMapTypeAdapterFactory.MAP);
        this.map = map2;
    }

    public final /* synthetic */ Map getMap$adapty_release() {
        return this.map;
    }

    public final int size() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final boolean containsKey(K k) {
        return this.map.containsKey(k);
    }

    public final boolean containsValue(V v) {
        return this.map.containsValue(v);
    }

    public final V get(K k) {
        return this.map.get(k);
    }

    public final ImmutableCollection<K, Set<K>> keySet() {
        return new ImmutableCollection<>(this.map.keySet());
    }

    public final ImmutableList<V> values() {
        return new ImmutableList<>(CollectionsKt.toList(this.map.values()));
    }

    public final ImmutableCollection<Entry<K, V>, Set<Entry<K, V>>> entrySet() {
        Collection linkedHashSet = new LinkedHashSet();
        Entry.Companion companion = Entry.Companion;
        for (Map.Entry from : this.map.entrySet()) {
            linkedHashSet.add(companion.from(from));
        }
        return new ImmutableCollection<>(linkedHashSet);
    }

    public final void forEach(Callback<Entry<K, V>> callback) {
        Intrinsics.checkNotNullParameter(callback, "action");
        for (Map.Entry from : this.map.entrySet()) {
            callback.onResult(Entry.Companion.from(from));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.utils.ImmutableMap<*, *>");
        return Intrinsics.areEqual((Object) this.map, (Object) ((ImmutableMap) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u0013*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003:\u0001\u0013B\u001b\b\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00028\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00028\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/adapty/utils/ImmutableMap$Entry;", "K", "V", "", "mapEntry", "", "(Ljava/util/Map$Entry;)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ImmutableCollections.kt */
    public static final class Entry<K, V> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Map.Entry<K, V> mapEntry;

        public /* synthetic */ Entry(Map.Entry entry, DefaultConstructorMarker defaultConstructorMarker) {
            this(entry);
        }

        private Entry(Map.Entry<? extends K, ? extends V> entry) {
            this.mapEntry = entry;
        }

        public final K getKey() {
            return this.mapEntry.getKey();
        }

        public final V getValue() {
            return this.mapEntry.getValue();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.utils.ImmutableMap.Entry<*, *>");
            return Intrinsics.areEqual((Object) this.mapEntry, (Object) ((Entry) obj).mapEntry);
        }

        public int hashCode() {
            return this.mapEntry.hashCode();
        }

        public String toString() {
            return this.mapEntry.toString();
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\b¨\u0006\t"}, d2 = {"Lcom/adapty/utils/ImmutableMap$Entry$Companion;", "", "()V", "from", "Lcom/adapty/utils/ImmutableMap$Entry;", "K", "V", "mapEntry", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: ImmutableCollections.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Entry from(Map.Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "mapEntry");
                return new Entry(entry, (DefaultConstructorMarker) null);
            }
        }
    }
}
