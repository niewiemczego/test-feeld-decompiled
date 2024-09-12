package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    /* access modifiers changed from: protected */
    public abstract SortedSet<E> delegate();

    protected ForwardingSortedSet() {
    }

    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(@ParametricNullness E e) {
        return delegate().headSet(e);
    }

    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return delegate().subSet(e, e2);
    }

    public SortedSet<E> tailSet(@ParametricNullness E e) {
        return delegate().tailSet(e);
    }

    /* access modifiers changed from: protected */
    public boolean standardContains(@CheckForNull Object obj) {
        try {
            if (ForwardingSortedMap.unsafeCompare(comparator(), tailSet(obj).first(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardRemove(@CheckForNull Object obj) {
        try {
            Iterator it = tailSet(obj).iterator();
            if (it.hasNext()) {
                if (ForwardingSortedMap.unsafeCompare(comparator(), it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardSubSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return tailSet(e).headSet(e2);
    }
}
