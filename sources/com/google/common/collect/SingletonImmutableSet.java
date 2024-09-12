package com.google.common.collect;

import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    SingletonImmutableSet(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.element.equals(obj);
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public ImmutableList<E> asList() {
        return ImmutableList.of(this.element);
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        String obj = this.element.toString();
        return new StringBuilder(String.valueOf(obj).length() + 2).append('[').append(obj).append(']').toString();
    }
}
