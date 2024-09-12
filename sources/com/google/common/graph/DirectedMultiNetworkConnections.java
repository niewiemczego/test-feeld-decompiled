package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit
    private transient Reference<Multiset<N>> predecessorsReference;
    @CheckForNull
    @LazyInit
    private transient Reference<Multiset<N>> successorsReference;

    private DirectedMultiNetworkConnections(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> of() {
        return new DirectedMultiNetworkConnections<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i) {
        return new DirectedMultiNetworkConnections<>(ImmutableMap.copyOf(map), ImmutableMap.copyOf(map2), i);
    }

    public Set<N> predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    private Multiset<N> predecessorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(create);
        return create;
    }

    public Set<N> successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }

    /* access modifiers changed from: private */
    public Multiset<N> successorsMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(create);
        return create;
    }

    public Set<E> edgesConnecting(final N n2) {
        return new MultiEdgesConnecting<E>(this.outEdgeMap, n2) {
            public int size() {
                return DirectedMultiNetworkConnections.this.successorsMultiset().count(n2);
            }
        };
    }

    public N removeInEdge(E e, boolean z) {
        N removeInEdge = super.removeInEdge(e, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeInEdge));
        }
        return removeInEdge;
    }

    public N removeOutEdge(E e) {
        N removeOutEdge = super.removeOutEdge(e);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeOutEdge));
        }
        return removeOutEdge;
    }

    public void addInEdge(E e, N n2, boolean z) {
        super.addInEdge(e, n2, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n2));
        }
    }

    public void addOutEdge(E e, N n2) {
        super.addOutEdge(e, n2);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n2));
        }
    }

    @CheckForNull
    private static <T> T getReference(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
