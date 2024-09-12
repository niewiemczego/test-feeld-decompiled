package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    AbstractBaseGraph() {
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        long j = 0;
        for (Object degree : nodes()) {
            j += (long) degree(degree);
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }
        };
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    public Set<EndpointPair<N>> incidentEdges(N n2) {
        Preconditions.checkNotNull(n2);
        Preconditions.checkArgument(nodes().contains(n2), "Node %s is not an element of this graph.", (Object) n2);
        return new IncidentEdgeSet<N>(this, this, n2) {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                if (this.graph.isDirected()) {
                    return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda0(this)), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.of(this.node)).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda1(this))));
                }
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new AbstractBaseGraph$2$$ExternalSyntheticLambda2(this)));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$0$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m438lambda$iterator$0$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
                return EndpointPair.ordered(obj, this.node);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$1$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m439lambda$iterator$1$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
                return EndpointPair.ordered(this.node, obj);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$iterator$2$com-google-common-graph-AbstractBaseGraph$2  reason: not valid java name */
            public /* synthetic */ EndpointPair m440lambda$iterator$2$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
                return EndpointPair.unordered(this.node, obj);
            }
        };
    }

    public int degree(N n2) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n2).size(), successors((Object) n2).size());
        }
        Set adjacentNodes = adjacentNodes(n2);
        return IntMath.saturatedAdd(adjacentNodes.size(), (!allowsSelfLoops() || !adjacentNodes.contains(n2)) ? 0 : 1);
    }

    public int inDegree(N n2) {
        return isDirected() ? predecessors((Object) n2).size() : degree(n2);
    }

    public int outDegree(N n2) {
        return isDirected() ? successors((Object) n2).size() : degree(n2);
    }

    public boolean hasEdgeConnecting(N n2, N n3) {
        Preconditions.checkNotNull(n2);
        Preconditions.checkNotNull(n3);
        return nodes().contains(n2) && successors((Object) n2).contains(n3);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors((Object) nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    /* access modifiers changed from: protected */
    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }
}
