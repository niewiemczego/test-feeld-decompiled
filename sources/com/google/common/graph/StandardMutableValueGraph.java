package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {
    private final ElementOrder<N> incidentEdgeOrder;

    StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.incidentEdgeOrder = abstractGraphBuilder.incidentEdgeOrder.cast();
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    public boolean addNode(N n2) {
        Preconditions.checkNotNull(n2, "node");
        if (containsNode(n2)) {
            return false;
        }
        addNodeInternal(n2);
        return true;
    }

    private GraphConnections<N, V> addNodeInternal(N n2) {
        GraphConnections<N, V> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n2, newConnections) == null);
        return newConnections;
    }

    @CheckForNull
    public V putEdgeValue(N n2, N n3, V v) {
        Preconditions.checkNotNull(n2, "nodeU");
        Preconditions.checkNotNull(n3, "nodeV");
        Preconditions.checkNotNull(v, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n2.equals(n3), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n2);
        }
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(n2);
        if (graphConnections == null) {
            graphConnections = addNodeInternal(n2);
        }
        V addSuccessor = graphConnections.addSuccessor(n3, v);
        GraphConnections graphConnections2 = (GraphConnections) this.nodeConnections.get(n3);
        if (graphConnections2 == null) {
            graphConnections2 = addNodeInternal(n3);
        }
        graphConnections2.addPredecessor(n2, v);
        if (addSuccessor == null) {
            long j = this.edgeCount + 1;
            this.edgeCount = j;
            Graphs.checkPositive(j);
        }
        return addSuccessor;
    }

    @CheckForNull
    public V putEdgeValue(EndpointPair<N> endpointPair, V v) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    public boolean removeNode(N n2) {
        Preconditions.checkNotNull(n2, "node");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(n2);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n2) != null) {
            graphConnections.removePredecessor(n2);
            this.edgeCount--;
        }
        for (Object withoutCaching : graphConnections.successors()) {
            ((GraphConnections) Objects.requireNonNull((GraphConnections) this.nodeConnections.getWithoutCaching(withoutCaching))).removePredecessor(n2);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (Object withoutCaching2 : graphConnections.predecessors()) {
                Preconditions.checkState(((GraphConnections) Objects.requireNonNull((GraphConnections) this.nodeConnections.getWithoutCaching(withoutCaching2))).removeSuccessor(n2) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n2);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @CheckForNull
    public V removeEdge(N n2, N n3) {
        Preconditions.checkNotNull(n2, "nodeU");
        Preconditions.checkNotNull(n3, "nodeV");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(n2);
        GraphConnections graphConnections2 = (GraphConnections) this.nodeConnections.get(n3);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V removeSuccessor = graphConnections.removeSuccessor(n3);
        if (removeSuccessor != null) {
            graphConnections2.removePredecessor(n2);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            Graphs.checkNonNegative(j);
        }
        return removeSuccessor;
    }

    @CheckForNull
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    private GraphConnections<N, V> newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of(this.incidentEdgeOrder);
        }
        return UndirectedGraphConnections.of(this.incidentEdgeOrder);
    }
}
