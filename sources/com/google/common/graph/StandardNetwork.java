package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

@ElementTypesAreNonnullByDefault
class StandardNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(((Integer) networkBuilder.expectedNodeCount.or(10)).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or(20).intValue()));
    }

    StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        MapIteratorCache<N, NetworkConnections<N, E>> mapIteratorCache;
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = networkBuilder.nodeOrder.cast();
        this.edgeOrder = networkBuilder.edgeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }

    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    public Set<E> incidentEdges(N n2) {
        return checkedConnections(n2).incidentEdges();
    }

    public EndpointPair<N> incidentNodes(E e) {
        Object checkedReferenceNode = checkedReferenceNode(e);
        return EndpointPair.of((Network<?, ?>) this, checkedReferenceNode, ((NetworkConnections) Objects.requireNonNull(this.nodeConnections.get(checkedReferenceNode))).adjacentNode(e));
    }

    public Set<N> adjacentNodes(N n2) {
        return checkedConnections(n2).adjacentNodes();
    }

    public Set<E> edgesConnecting(N n2, N n3) {
        NetworkConnections checkedConnections = checkedConnections(n2);
        if (!this.allowsSelfLoops && n2 == n3) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n3), "Node %s is not an element of this graph.", (Object) n3);
        return checkedConnections.edgesConnecting(n3);
    }

    public Set<E> inEdges(N n2) {
        return checkedConnections(n2).inEdges();
    }

    public Set<E> outEdges(N n2) {
        return checkedConnections(n2).outEdges();
    }

    public Set<N> predecessors(N n2) {
        return checkedConnections(n2).predecessors();
    }

    public Set<N> successors(N n2) {
        return checkedConnections(n2).successors();
    }

    /* access modifiers changed from: package-private */
    public final NetworkConnections<N, E> checkedConnections(N n2) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n2);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n2);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[]{n2}));
    }

    /* access modifiers changed from: package-private */
    public final N checkedReferenceNode(E e) {
        N n2 = this.edgeToReferenceNode.get(e);
        if (n2 != null) {
            return n2;
        }
        Preconditions.checkNotNull(e);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", new Object[]{e}));
    }

    /* access modifiers changed from: package-private */
    public final boolean containsNode(N n2) {
        return this.nodeConnections.containsKey(n2);
    }

    /* access modifiers changed from: package-private */
    public final boolean containsEdge(E e) {
        return this.edgeToReferenceNode.containsKey(e);
    }
}
