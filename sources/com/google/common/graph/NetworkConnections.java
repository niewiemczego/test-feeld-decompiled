package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface NetworkConnections<N, E> {
    void addInEdge(E e, N n2, boolean z);

    void addOutEdge(E e, N n2);

    N adjacentNode(E e);

    Set<N> adjacentNodes();

    Set<E> edgesConnecting(N n2);

    Set<E> inEdges();

    Set<E> incidentEdges();

    Set<E> outEdges();

    Set<N> predecessors();

    @CheckForNull
    N removeInEdge(E e, boolean z);

    N removeOutEdge(E e);

    Set<N> successors();
}
