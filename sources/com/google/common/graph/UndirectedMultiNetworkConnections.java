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
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit
    private transient Reference<Multiset<N>> adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map<E, N> map) {
        super(map);
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> of() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.copyOf(map));
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    /* access modifiers changed from: private */
    public Multiset<N> adjacentNodesMultiset() {
        Multiset<N> multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.incidentEdgeMap.values());
        this.adjacentNodesReference = new SoftReference(create);
        return create;
    }

    public Set<E> edgesConnecting(final N n2) {
        return new MultiEdgesConnecting<E>(this.incidentEdgeMap, n2) {
            public int size() {
                return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(n2);
            }
        };
    }

    @CheckForNull
    public N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    public N removeOutEdge(E e) {
        N removeOutEdge = super.removeOutEdge(e);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(removeOutEdge));
        }
        return removeOutEdge;
    }

    public void addInEdge(E e, N n2, boolean z) {
        if (!z) {
            addOutEdge(e, n2);
        }
    }

    public void addOutEdge(E e, N n2) {
        super.addOutEdge(e, n2);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
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
