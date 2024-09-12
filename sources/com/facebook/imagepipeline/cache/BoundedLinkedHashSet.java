package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;

public class BoundedLinkedHashSet<E> {
    private LinkedHashSet<E> mLinkedHashSet;
    private int mMaxSize;

    public BoundedLinkedHashSet(int i) {
        this.mLinkedHashSet = new LinkedHashSet<>(i);
        this.mMaxSize = i;
    }

    public synchronized boolean contains(E e) {
        return this.mLinkedHashSet.contains(e);
    }

    public synchronized boolean add(E e) {
        if (this.mLinkedHashSet.size() == this.mMaxSize) {
            LinkedHashSet<E> linkedHashSet = this.mLinkedHashSet;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.mLinkedHashSet.remove(e);
        return this.mLinkedHashSet.add(e);
    }
}
