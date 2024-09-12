package com.google.common.graph;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N n2);

    @CheckForNull
    V putEdgeValue(EndpointPair<N> endpointPair, V v);

    @CheckForNull
    V putEdgeValue(N n2, N n3, V v);

    @CheckForNull
    V removeEdge(EndpointPair<N> endpointPair);

    @CheckForNull
    V removeEdge(N n2, N n3);

    boolean removeNode(N n2);
}
