package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class SortedMultisets {
    private SortedMultisets() {
    }

    static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
        private final SortedMultiset<E> multiset;

        ElementSet(SortedMultiset<E> sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        /* access modifiers changed from: package-private */
        public final SortedMultiset<E> multiset() {
            return this.multiset;
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
            return multiset().subMultiset(e, BoundType.CLOSED, e2, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> headSet(@ParametricNullness E e) {
            return multiset().headMultiset(e, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> tailSet(@ParametricNullness E e) {
            return multiset().tailMultiset(e, BoundType.CLOSED).elementSet();
        }

        @ParametricNullness
        public E first() {
            return SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        @ParametricNullness
        public E last() {
            return SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }
    }

    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        NavigableElementSet(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @CheckForNull
        public E lower(@ParametricNullness E e) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(e, BoundType.OPEN).lastEntry());
        }

        @CheckForNull
        public E floor(@ParametricNullness E e) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(e, BoundType.CLOSED).lastEntry());
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(e, BoundType.CLOSED).firstEntry());
        }

        @CheckForNull
        public E higher(@ParametricNullness E e) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(e, BoundType.OPEN).firstEntry());
        }

        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @CheckForNull
        public E pollFirst() {
            return SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
        }

        @CheckForNull
        public E pollLast() {
            return SortedMultisets.getElementOrNull(multiset().pollLastEntry());
        }

        public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
            return new NavigableElementSet(multiset().subMultiset(e, BoundType.forBoolean(z), e2, BoundType.forBoolean(z2)));
        }

        public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
            return new NavigableElementSet(multiset().headMultiset(e, BoundType.forBoolean(z)));
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
            return new NavigableElementSet(multiset().tailMultiset(e, BoundType.forBoolean(z)));
        }
    }

    /* access modifiers changed from: private */
    public static <E> E getElementOrThrow(@CheckForNull Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static <E> E getElementOrNull(@CheckForNull Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }
}
