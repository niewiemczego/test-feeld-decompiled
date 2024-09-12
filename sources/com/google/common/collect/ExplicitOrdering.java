package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(List<T> list) {
        this(Maps.indexMap(list));
    }

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    public int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    private int rank(T t) {
        Integer num = this.rankMap.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.rankMap.keySet());
        return new StringBuilder(String.valueOf(valueOf).length() + 19).append("Ordering.explicit(").append(valueOf).append(")").toString();
    }
}
