package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N", "V"})
public final class ImmutableValueGraph<N, V> extends StandardValueGraph<N, V> {
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, @CheckForNull Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, @CheckForNull Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
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

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.from(valueGraph), getNodeConnections(valueGraph), (long) valueGraph.edges().size());
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        if (valueGraph instanceof ImmutableValueGraph) {
            return (ImmutableValueGraph) valueGraph;
        }
        return new ImmutableValueGraph<>(valueGraph);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.stable();
    }

    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : valueGraph.nodes()) {
            builder.put(next, connectionsOf(valueGraph, next));
        }
        return builder.buildOrThrow();
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(ValueGraph<N, V> valueGraph, N n2) {
        ImmutableValueGraph$$ExternalSyntheticLambda0 immutableValueGraph$$ExternalSyntheticLambda0 = new ImmutableValueGraph$$ExternalSyntheticLambda0(valueGraph, n2);
        if (valueGraph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(n2, valueGraph.incidentEdges(n2), immutableValueGraph$$ExternalSyntheticLambda0);
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(valueGraph.adjacentNodes(n2), immutableValueGraph$$ExternalSyntheticLambda0));
    }

    public static class Builder<N, V> {
        private final MutableValueGraph<N, V> mutableValueGraph;

        Builder(ValueGraphBuilder<N, V> valueGraphBuilder) {
            this.mutableValueGraph = valueGraphBuilder.copy().incidentEdgeOrder(ElementOrder.stable()).build();
        }

        public Builder<N, V> addNode(N n2) {
            this.mutableValueGraph.addNode(n2);
            return this;
        }

        public Builder<N, V> putEdgeValue(N n2, N n3, V v) {
            this.mutableValueGraph.putEdgeValue(n2, n3, v);
            return this;
        }

        public Builder<N, V> putEdgeValue(EndpointPair<N> endpointPair, V v) {
            this.mutableValueGraph.putEdgeValue(endpointPair, v);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.mutableValueGraph);
        }
    }
}
