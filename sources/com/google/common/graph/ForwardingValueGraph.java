package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    /* access modifiers changed from: package-private */
    public abstract ValueGraph<N, V> delegate();

    ForwardingValueGraph() {
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

    @CheckForNull
    public V edgeValueOrDefault(N n2, N n3, @CheckForNull V v) {
        return delegate().edgeValueOrDefault(n2, n3, v);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v) {
        return delegate().edgeValueOrDefault(endpointPair, v);
    }
}
