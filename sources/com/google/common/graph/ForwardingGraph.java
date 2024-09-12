package com.google.common.graph;

import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    /* access modifiers changed from: package-private */
    public abstract BaseGraph<N> delegate();

    ForwardingGraph() {
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return delegate().incidentEdgeOrder();
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

    public Set<EndpointPair<N>> incidentEdges(N n2) {
        return delegate().incidentEdges(n2);
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

    public boolean hasEdgeConnecting(N n2, N n3) {
        return delegate().hasEdgeConnecting(n2, n3);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }
}
