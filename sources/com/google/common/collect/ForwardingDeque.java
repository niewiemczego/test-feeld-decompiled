package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    /* access modifiers changed from: protected */
    public abstract Deque<E> delegate();

    protected ForwardingDeque() {
    }

    public void addFirst(@ParametricNullness E e) {
        delegate().addFirst(e);
    }

    public void addLast(@ParametricNullness E e) {
        delegate().addLast(e);
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @ParametricNullness
    public E getFirst() {
        return delegate().getFirst();
    }

    @ParametricNullness
    public E getLast() {
        return delegate().getLast();
    }

    public boolean offerFirst(@ParametricNullness E e) {
        return delegate().offerFirst(e);
    }

    public boolean offerLast(@ParametricNullness E e) {
        return delegate().offerLast(e);
    }

    @CheckForNull
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @CheckForNull
    public E peekLast() {
        return delegate().peekLast();
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @ParametricNullness
    public E pop() {
        return delegate().pop();
    }

    public void push(@ParametricNullness E e) {
        delegate().push(e);
    }

    @ParametricNullness
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @ParametricNullness
    public E removeLast() {
        return delegate().removeLast();
    }

    public boolean removeFirstOccurrence(@CheckForNull Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    public boolean removeLastOccurrence(@CheckForNull Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
