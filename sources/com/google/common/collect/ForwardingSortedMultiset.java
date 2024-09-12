package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
    /* access modifiers changed from: protected */
    public abstract SortedMultiset<E> delegate();

    protected ForwardingSortedMultiset() {
    }

    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }

    protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet(ForwardingSortedMultiset forwardingSortedMultiset) {
            super(forwardingSortedMultiset);
        }
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        /* access modifiers changed from: package-private */
        public SortedMultiset<E> forwardMultiset() {
            return ForwardingSortedMultiset.this;
        }
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardFirstEntry() {
        Iterator it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardLastEntry() {
        Iterator it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it.remove();
        return immutableEntry;
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it.remove();
        return immutableEntry;
    }

    public SortedMultiset<E> headMultiset(@ParametricNullness E e, BoundType boundType) {
        return delegate().headMultiset(e, boundType);
    }

    public SortedMultiset<E> subMultiset(@ParametricNullness E e, BoundType boundType, @ParametricNullness E e2, BoundType boundType2) {
        return delegate().subMultiset(e, boundType, e2, boundType2);
    }

    /* access modifiers changed from: protected */
    public SortedMultiset<E> standardSubMultiset(@ParametricNullness E e, BoundType boundType, @ParametricNullness E e2, BoundType boundType2) {
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    public SortedMultiset<E> tailMultiset(@ParametricNullness E e, BoundType boundType) {
        return delegate().tailMultiset(e, boundType);
    }
}
