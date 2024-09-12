package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* access modifiers changed from: protected */
    public abstract List<E> delegate();

    protected ForwardingList() {
    }

    public void add(int i, @ParametricNullness E e) {
        delegate().add(i, e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        return delegate().addAll(i, collection);
    }

    @ParametricNullness
    public E get(int i) {
        return delegate().get(i);
    }

    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return delegate().listIterator(i);
    }

    @ParametricNullness
    public E remove(int i) {
        return delegate().remove(i);
    }

    @ParametricNullness
    public E set(int i, @ParametricNullness E e) {
        return delegate().set(i, e);
    }

    public List<E> subList(int i, int i2) {
        return delegate().subList(i, i2);
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardAdd(@ParametricNullness E e) {
        add(size(), e);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean standardAddAll(int i, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i, iterable);
    }

    /* access modifiers changed from: protected */
    public int standardIndexOf(@CheckForNull Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardLastIndexOf(@CheckForNull Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public Iterator<E> standardIterator() {
        return listIterator();
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> standardListIterator(int i) {
        return Lists.listIteratorImpl(this, i);
    }

    /* access modifiers changed from: protected */
    public List<E> standardSubList(int i, int i2) {
        return Lists.subListImpl(this, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}
