package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    NullsFirstOrdering(Ordering<? super T> ordering2) {
        this.ordering = ordering2;
    }

    public int compare(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.ordering.compare(t, t2);
    }

    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        return new StringBuilder(String.valueOf(valueOf).length() + 13).append(valueOf).append(".nullsFirst()").toString();
    }
}
