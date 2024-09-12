package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    public boolean addNode(N n2) {
        Preconditions.checkNotNull(n2, "node");
        if (containsNode(n2)) {
            return false;
        }
        addNodeInternal(n2);
        return true;
    }

    private NetworkConnections<N, E> addNodeInternal(N n2) {
        NetworkConnections<N, E> newConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n2, newConnections) == null);
        return newConnections;
    }

    public boolean addEdge(N n2, N n3, E e) {
        Preconditions.checkNotNull(n2, "nodeU");
        Preconditions.checkNotNull(n3, "nodeV");
        Preconditions.checkNotNull(e, "edge");
        boolean z = false;
        if (containsEdge(e)) {
            EndpointPair incidentNodes = incidentNodes(e);
            EndpointPair of = EndpointPair.of((Network<?, ?>) this, n2, n3);
            Preconditions.checkArgument(incidentNodes.equals(of), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e, incidentNodes, of);
            return false;
        }
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(n2);
        if (!allowsParallelEdges()) {
            if (networkConnections == null || !networkConnections.successors().contains(n3)) {
                z = true;
            }
            Preconditions.checkArgument(z, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", (Object) n2, (Object) n3);
        }
        boolean equals = n2.equals(n3);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", (Object) n2);
        }
        if (networkConnections == null) {
            networkConnections = addNodeInternal(n2);
        }
        networkConnections.addOutEdge(e, n3);
        NetworkConnections networkConnections2 = (NetworkConnections) this.nodeConnections.get(n3);
        if (networkConnections2 == null) {
            networkConnections2 = addNodeInternal(n3);
        }
        networkConnections2.addInEdge(e, n2, equals);
        this.edgeToReferenceNode.put(e, n2);
        return true;
    }

    public boolean addEdge(EndpointPair<N> endpointPair, E e) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e);
    }

    public boolean removeNode(N n2) {
        Preconditions.checkNotNull(n2, "node");
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(n2);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf(networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(n2);
        return true;
    }

    public boolean removeEdge(E e) {
        Preconditions.checkNotNull(e, "edge");
        Object obj = this.edgeToReferenceNode.get(e);
        boolean z = false;
        if (obj == null) {
            return false;
        }
        NetworkConnections networkConnections = (NetworkConnections) Objects.requireNonNull((NetworkConnections) this.nodeConnections.get(obj));
        Object adjacentNode = networkConnections.adjacentNode(e);
        NetworkConnections networkConnections2 = (NetworkConnections) Objects.requireNonNull((NetworkConnections) this.nodeConnections.get(adjacentNode));
        networkConnections.removeOutEdge(e);
        if (allowsSelfLoops() && obj.equals(adjacentNode)) {
            z = true;
        }
        networkConnections2.removeInEdge(e, z);
        this.edgeToReferenceNode.remove(e);
        return true;
    }

    private NetworkConnections<N, E> newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        } else {
            return UndirectedNetworkConnections.of();
        }
    }
}
