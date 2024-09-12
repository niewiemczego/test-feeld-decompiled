package com.google.common.collect;

import java.util.SortedSet;

@ElementTypesAreNonnullByDefault
interface SortedMultisetBridge<E> extends Multiset<E> {
    SortedSet<E> elementSet();
}
