package coil.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000H\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0005H\b¢\u0006\u0002\u0010\u0006\u001aF\u0010\u0007\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\b\u001a\u0002H\u00022\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\nH\b¢\u0006\u0002\u0010\u000b\u001a3\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\nH\b\u001a-\u0010\u0010\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005H\b\u001a]\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010\u0002*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u00122 \u0010\u0004\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0005H\b\u001a-\u0010\u0017\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u001a0\u0005H\b\u001a\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0000\u001a0\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0012H\u0000¨\u0006\u001d"}, d2 = {"firstNotNullOfOrNullIndices", "T", "R", "", "transform", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "foldIndices", "initial", "operation", "Lkotlin/Function2;", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "forEachIndexedIndices", "", "action", "", "forEachIndices", "mapNotNullValues", "", "K", "V", "", "", "removeIfIndices", "", "predicate", "", "toImmutableList", "toImmutableMap", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-Collections  reason: invalid class name */
/* compiled from: Collections.kt */
public final class Collections {
    public static final <T> void forEachIndices(List<? extends T> list, Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final <T> void forEachIndexedIndices(List<? extends T> list, Function2<? super Integer, ? super T, Unit> function2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(i), list.get(i));
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> R foldIndices(java.util.List<? extends T> r3, R r4, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r5) {
        /*
            int r0 = r3.size()
            r1 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0012
            java.lang.Object r2 = r3.get(r1)
            java.lang.Object r4 = r5.invoke(r4, r2)
            int r1 = r1 + 1
            goto L_0x0005
        L_0x0012:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Collections.foldIndices(java.util.List, java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final <R, T> T firstNotNullOfOrNullIndices(List<? extends R> list, Function1<? super R, ? extends T> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T invoke = function1.invoke(list.get(i));
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    public static final <T> void removeIfIndices(List<T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 - i;
            if (function1.invoke(list.get(i3)).booleanValue()) {
                list.remove(i3);
                i++;
            }
        }
    }

    public static final <K, V, R> Map<K, R> mapNotNullValues(Map<K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Map<K, R> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            Object invoke = function1.invoke(next);
            if (invoke != null) {
                linkedHashMap.put(next.getKey(), invoke);
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return MapsKt.emptyMap();
        }
        if (size != 1) {
            return java.util.Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.first(map.entrySet());
        return java.util.Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        int size = list.size();
        if (size == 0) {
            return CollectionsKt.emptyList();
        }
        if (size != 1) {
            return java.util.Collections.unmodifiableList(new ArrayList(list));
        }
        return java.util.Collections.singletonList(CollectionsKt.first(list));
    }
}
