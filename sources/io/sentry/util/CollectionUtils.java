package io.sentry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CollectionUtils {

    public interface Mapper<T, R> {
        R map(T t);
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    private CollectionUtils() {
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i = 0;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    public static <K, V> Map<K, V> newConcurrentHashMap(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                concurrentHashMap.put(next.getKey(), next.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static <K, V> Map<K, V> newHashMap(Map<K, V> map) {
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    public static <T> List<T> newArrayList(List<T> list) {
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    public static <K, V> Map<K, V> filterMapEntries(Map<K, V> map, Predicate<Map.Entry<K, V>> predicate) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (predicate.test(next)) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return hashMap;
    }

    public static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        ArrayList arrayList = new ArrayList(list.size());
        for (T map : list) {
            arrayList.add(mapper.map(map));
        }
        return arrayList;
    }

    public static <T> List<T> filterListEntries(List<T> list, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList(list.size());
        for (T next : list) {
            if (predicate.test(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        for (T equals : tArr) {
            if (t.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
