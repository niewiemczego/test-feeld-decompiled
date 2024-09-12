package com.google.common.graph;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
interface GraphConnections<N, V> {
    void addPredecessor(N n2, V v);

    @CheckForNull
    V addSuccessor(N n2, V v);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n2);

    Set<N> predecessors();

    void removePredecessor(N n2);

    @CheckForNull
    V removeSuccessor(N n2);

    Set<N> successors();

    @CheckForNull
    V value(N n2);
}
