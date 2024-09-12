package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {
    /* access modifiers changed from: protected */
    public abstract NavigableSet<E> delegate();

    protected ForwardingNavigableSet() {
    }

    @CheckForNull
    public E lower(@ParametricNullness E e) {
        return delegate().lower(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardLower(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    @CheckForNull
    public E floor(@ParametricNullness E e) {
        return delegate().floor(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardFloor(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e) {
        return delegate().ceiling(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardCeiling(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e) {
        return delegate().higher(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardHigher(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
        return delegate().subSet(e, z, e2, z2);
    }

    /* access modifiers changed from: protected */
    public NavigableSet<E> standardSubSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
        return tailSet(e, z).headSet(e2, z2);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardSubSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return subSet(e, true, e2, false);
    }

    public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
        return delegate().headSet(e, z);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardHeadSet(@ParametricNullness E e) {
        return headSet(e, false);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
        return delegate().tailSet(e, z);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardTailSet(@ParametricNullness E e) {
        return tailSet(e, true);
    }
}
