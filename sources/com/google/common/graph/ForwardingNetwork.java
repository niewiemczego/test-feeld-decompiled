package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    /* access modifiers changed from: package-private */
    public abstract Network<N, E> delegate();

    ForwardingNetwork() {
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public Set<E> edges() {
        return delegate().edges();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    public Set<N> adjacentNodes(N n2) {
        return delegate().adjacentNodes(n2);
    }

    public Set<N> predecessors(N n2) {
        return delegate().predecessors((Object) n2);
    }

    public Set<N> successors(N n2) {
        return delegate().successors((Object) n2);
    }

    public Set<E> incidentEdges(N n2) {
        return delegate().incidentEdges(n2);
    }

    public Set<E> inEdges(N n2) {
        return delegate().inEdges(n2);
    }

    public Set<E> outEdges(N n2) {
        return delegate().outEdges(n2);
    }

    public EndpointPair<N> incidentNodes(E e) {
        return delegate().incidentNodes(e);
    }

    public Set<E> adjacentEdges(E e) {
        return delegate().adjacentEdges(e);
    }

    public int degree(N n2) {
        return delegate().degree(n2);
    }

    public int inDegree(N n2) {
        return delegate().inDegree(n2);
    }

    public int outDegree(N n2) {
        return delegate().outDegree(n2);
    }

    public Set<E> edgesConnecting(N n2, N n3) {
        return delegate().edgesConnecting(n2, n3);
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return delegate().edgesConnecting(endpointPair);
    }

    @CheckForNull
    public E edgeConnectingOrNull(N n2, N n3) {
        return delegate().edgeConnectingOrNull(n2, n3);
    }

    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return delegate().edgeConnectingOrNull(endpointPair);
    }

    public boolean hasEdgeConnecting(N n2, N n3) {
        return delegate().hasEdgeConnecting(n2, n3);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }
}
