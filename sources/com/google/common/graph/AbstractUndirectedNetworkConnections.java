package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public Set<N> successors() {
        return adjacentNodes();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public N adjacentNode(E e) {
        return Objects.requireNonNull(this.incidentEdgeMap.get(e));
    }

    @CheckForNull
    public N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    public N removeOutEdge(E e) {
        return Objects.requireNonNull(this.incidentEdgeMap.remove(e));
    }

    public void addInEdge(E e, N n2, boolean z) {
        if (!z) {
            addOutEdge(e, n2);
        }
    }

    public void addOutEdge(E e, N n2) {
        Preconditions.checkState(this.incidentEdgeMap.put(e, n2) == null);
    }
}
