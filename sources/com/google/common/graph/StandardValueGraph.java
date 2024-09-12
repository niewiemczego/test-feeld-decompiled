package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0);
    }

    StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j) {
        MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeCount = Graphs.checkNonNegative(j);
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public Set<N> adjacentNodes(N n2) {
        return checkedConnections(n2).adjacentNodes();
    }

    public Set<N> predecessors(N n2) {
        return checkedConnections(n2).predecessors();
    }

    public Set<N> successors(N n2) {
        return checkedConnections(n2).successors();
    }

    public Set<EndpointPair<N>> incidentEdges(N n2) {
        final GraphConnections checkedConnections = checkedConnections(n2);
        return new IncidentEdgeSet<N>(this, this, n2) {
            public Iterator<EndpointPair<N>> iterator() {
                return checkedConnections.incidentEdgeIterator(this.node);
            }
        };
    }

    public boolean hasEdgeConnecting(N n2, N n3) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(n2), Preconditions.checkNotNull(n3));
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnectingInternal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @CheckForNull
    public V edgeValueOrDefault(N n2, N n3, @CheckForNull V v) {
        return edgeValueOrDefaultInternal(Preconditions.checkNotNull(n2), Preconditions.checkNotNull(n3), v);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefaultInternal(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return this.edgeCount;
    }

    private final GraphConnections<N, V> checkedConnections(N n2) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n2);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n2);
        String valueOf = String.valueOf(n2);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Node ").append(valueOf).append(" is not an element of this graph.").toString());
    }

    /* access modifiers changed from: package-private */
    public final boolean containsNode(@CheckForNull N n2) {
        return this.nodeConnections.containsKey(n2);
    }

    private final boolean hasEdgeConnectingInternal(N n2, N n3) {
        GraphConnections graphConnections = this.nodeConnections.get(n2);
        return graphConnections != null && graphConnections.successors().contains(n3);
    }

    @CheckForNull
    private final V edgeValueOrDefaultInternal(N n2, N n3, @CheckForNull V v) {
        V v2;
        GraphConnections graphConnections = this.nodeConnections.get(n2);
        if (graphConnections == null) {
            v2 = null;
        } else {
            v2 = graphConnections.value(n3);
        }
        return v2 == null ? v : v2;
    }
}
