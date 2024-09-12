package com.google.common.graph;

@ElementTypesAreNonnullByDefault
public interface MutableNetwork<N, E> extends Network<N, E> {
    boolean addEdge(EndpointPair<N> endpointPair, E e);

    boolean addEdge(N n2, N n3, E e);

    boolean addNode(N n2);

    boolean removeEdge(E e);

    boolean removeNode(N n2);
}
