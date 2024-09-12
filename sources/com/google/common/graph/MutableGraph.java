package com.google.common.graph;

@ElementTypesAreNonnullByDefault
public interface MutableGraph<N> extends Graph<N> {
    boolean addNode(N n2);

    boolean putEdge(EndpointPair<N> endpointPair);

    boolean putEdge(N n2, N n3);

    boolean removeEdge(EndpointPair<N> endpointPair);

    boolean removeEdge(N n2, N n3);

    boolean removeNode(N n2);
}
