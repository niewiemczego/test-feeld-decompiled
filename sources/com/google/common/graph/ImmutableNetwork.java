package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N", "E"})
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        if (network instanceof ImmutableNetwork) {
            return (ImmutableNetwork) network;
        }
        return new ImmutableNetwork<>(network);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : network.nodes()) {
            builder.put(next, connectionsOf(network, next));
        }
        return builder.buildOrThrow();
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E next : network.edges()) {
            builder.put(next, network.incidentNodes(next).nodeU());
        }
        return builder.buildOrThrow();
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n2) {
        if (network.isDirected()) {
            Map<K, V> asMap = Maps.asMap(network.inEdges(n2), sourceNodeFn(network));
            Map<K, V> asMap2 = Maps.asMap(network.outEdges(n2), targetNodeFn(network));
            int size = network.edgesConnecting(n2, n2).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map<K, V> asMap3 = Maps.asMap(network.incidentEdges(n2), adjacentNodeFn(network, n2));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    private static <N, E> Function<E, N> sourceNodeFn(Network<N, E> network) {
        return new ImmutableNetwork$$ExternalSyntheticLambda0(network);
    }

    private static <N, E> Function<E, N> targetNodeFn(Network<N, E> network) {
        return new ImmutableNetwork$$ExternalSyntheticLambda1(network);
    }

    private static <N, E> Function<E, N> adjacentNodeFn(Network<N, E> network, N n2) {
        return new ImmutableNetwork$$ExternalSyntheticLambda2(network, n2);
    }

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        Builder(NetworkBuilder<N, E> networkBuilder) {
            this.mutableNetwork = networkBuilder.build();
        }

        public Builder<N, E> addNode(N n2) {
            this.mutableNetwork.addNode(n2);
            return this;
        }

        public Builder<N, E> addEdge(N n2, N n3, E e) {
            this.mutableNetwork.addEdge(n2, n3, e);
            return this;
        }

        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e) {
            this.mutableNetwork.addEdge(endpointPair, e);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }
    }
}
