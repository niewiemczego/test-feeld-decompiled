package coil.request;

import coil.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003\u001f !B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u001b\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001b\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u001f\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\""}, d2 = {"Lcoil/request/Parameters;", "", "Lkotlin/Pair;", "", "Lcoil/request/Parameters$Entry;", "()V", "entries", "", "(Ljava/util/Map;)V", "size", "", "()I", "entry", "key", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "memoryCacheKey", "memoryCacheKeys", "newBuilder", "Lcoil/request/Parameters$Builder;", "toString", "value", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "values", "Builder", "Companion", "Entry", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Parameters.kt */
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Parameters EMPTY = new Parameters();
    /* access modifiers changed from: private */
    public final Map<String, Entry> entries;

    public /* synthetic */ Parameters(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Parameters(Map<String, Entry> map) {
        this.entries = map;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }

    public final int size() {
        return this.entries.size();
    }

    public final <T> T value(String str) {
        Entry entry = this.entries.get(str);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public final String memoryCacheKey(String str) {
        Entry entry = this.entries.get(str);
        if (entry != null) {
            return entry.getMemoryCacheKey();
        }
        return null;
    }

    public final Entry entry(String str) {
        return this.entries.get(str);
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public final Map<String, Object> values() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<String, Entry> map = this.entries;
        Map<String, Object> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((Entry) entry.getValue()).getValue());
        }
        return linkedHashMap;
    }

    public final Map<String, String> memoryCacheKeys() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<String, Entry> map = this.entries;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            String memoryCacheKey = ((Entry) next.getValue()).getMemoryCacheKey();
            if (memoryCacheKey != null) {
                linkedHashMap.put(next.getKey(), memoryCacheKey);
            }
        }
        return linkedHashMap;
    }

    public Iterator<Pair<String, Entry>> iterator() {
        Map<String, Entry> map = this.entries;
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(TuplesKt.to((String) next.getKey(), (Entry) next.getValue()));
        }
        return ((List) arrayList).iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Parameters) && Intrinsics.areEqual((Object) this.entries, (Object) ((Parameters) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcoil/request/Parameters$Entry;", "", "value", "memoryCacheKey", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getMemoryCacheKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Parameters.kt */
    public static final class Entry {
        private final String memoryCacheKey;
        private final Object value;

        public Entry(Object obj, String str) {
            this.value = obj;
            this.memoryCacheKey = str;
        }

        public final Object getValue() {
            return this.value;
        }

        public final String getMemoryCacheKey() {
            return this.memoryCacheKey;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                if (!Intrinsics.areEqual(this.value, entry.value) || !Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) entry.memoryCacheKey)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.value;
            int i = 0;
            int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
            String str = this.memoryCacheKey;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Entry(value=" + this.value + ", memoryCacheKey=" + this.memoryCacheKey + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ&\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil/request/Parameters$Builder;", "", "()V", "parameters", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)V", "entries", "", "", "Lcoil/request/Parameters$Entry;", "build", "remove", "key", "set", "value", "memoryCacheKey", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Parameters.kt */
    public static final class Builder {
        private final Map<String, Entry> entries;

        public final Builder set(String str, Object obj) {
            return set$default(this, str, obj, (String) null, 4, (Object) null);
        }

        public Builder() {
            this.entries = new LinkedHashMap();
        }

        public Builder(Parameters parameters) {
            this.entries = MapsKt.toMutableMap(parameters.entries);
        }

        public static /* synthetic */ Builder set$default(Builder builder, String str, Object obj, String str2, int i, Object obj2) {
            if ((i & 4) != 0) {
                str2 = obj != null ? obj.toString() : null;
            }
            return builder.set(str, obj, str2);
        }

        public final Builder set(String str, Object obj, String str2) {
            Builder builder = this;
            this.entries.put(str, new Entry(obj, str2));
            return this;
        }

        public final Builder remove(String str) {
            Builder builder = this;
            this.entries.remove(str);
            return this;
        }

        public final Parameters build() {
            return new Parameters(Collections.toImmutableMap(this.entries), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/request/Parameters$Companion;", "", "()V", "EMPTY", "Lcoil/request/Parameters;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Parameters.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
