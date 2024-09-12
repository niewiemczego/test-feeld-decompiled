package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            public Set<N> nodes() {
                return AbstractNetwork.this.nodes();
            }

            public Set<EndpointPair<N>> edges() {
                if (AbstractNetwork.this.allowsParallelEdges()) {
                    return super.edges();
                }
                return new AbstractSet<EndpointPair<N>>() {
                    public Iterator<EndpointPair<N>> iterator() {
                        return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function<E, EndpointPair<N>>() {
                            public EndpointPair<N> apply(E e) {
                                return AbstractNetwork.this.incidentNodes(e);
                            }
                        });
                    }

                    public int size() {
                        return AbstractNetwork.this.edges().size();
                    }

                    public boolean contains(@CheckForNull Object obj) {
                        if (!(obj instanceof EndpointPair)) {
                            return false;
                        }
                        EndpointPair endpointPair = (EndpointPair) obj;
                        if (!AnonymousClass1.this.isOrderingCompatible(endpointPair) || !AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) || !AnonymousClass1.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                            return false;
                        }
                        return true;
                    }
                };
            }

            public ElementOrder<N> nodeOrder() {
                return AbstractNetwork.this.nodeOrder();
            }

            public ElementOrder<N> incidentEdgeOrder() {
                return ElementOrder.unordered();
            }

            public boolean isDirected() {
                return AbstractNetwork.this.isDirected();
            }

            public boolean allowsSelfLoops() {
                return AbstractNetwork.this.allowsSelfLoops();
            }

            public Set<N> adjacentNodes(N n2) {
                return AbstractNetwork.this.adjacentNodes(n2);
            }

            public Set<N> predecessors(N n2) {
                return AbstractNetwork.this.predecessors((Object) n2);
            }

            public Set<N> successors(N n2) {
                return AbstractNetwork.this.successors((Object) n2);
            }
        };
    }

    public int degree(N n2) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n2).size(), outEdges(n2).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n2).size(), edgesConnecting(n2, n2).size());
    }

    public int inDegree(N n2) {
        return isDirected() ? inEdges(n2).size() : degree(n2);
    }

    public int outDegree(N n2) {
        return isDirected() ? outEdges(n2).size() : degree(n2);
    }

    public Set<E> adjacentEdges(E e) {
        EndpointPair incidentNodes = incidentNodes(e);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of(e));
    }

    public Set<E> edgesConnecting(N n2, N n3) {
        Set outEdges = outEdges(n2);
        Set inEdges = inEdges(n3);
        if (outEdges.size() <= inEdges.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdges, connectedPredicate(n2, n3)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdges, connectedPredicate(n3, n2)));
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }

    private Predicate<E> connectedPredicate(final N n2, final N n3) {
        return new Predicate<E>() {
            public boolean apply(E e) {
                return AbstractNetwork.this.incidentNodes(e).adjacentNode(n2).equals(n3);
            }
        };
    }

    @CheckForNull
    public E edgeConnectingOrNull(N n2, N n3) {
        Set edgesConnecting = edgesConnecting(n2, n3);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[]{n2, n3}));
    }

    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
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
        return hasEdgeConnecting(endpointPair.nodeU(), endpointPair.nodeV());
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

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        if (isDirected() != network.isDirected() || !nodes().equals(network.nodes()) || !edgeIncidentNodesMap(this).equals(edgeIncidentNodesMap(network))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return edgeIncidentNodesMap(this).hashCode();
    }

    public String toString() {
        boolean isDirected = isDirected();
        boolean allowsParallelEdges = allowsParallelEdges();
        boolean allowsSelfLoops = allowsSelfLoops();
        String valueOf = String.valueOf(nodes());
        String valueOf2 = String.valueOf(edgeIncidentNodesMap(this));
        return new StringBuilder(String.valueOf(valueOf).length() + 87 + String.valueOf(valueOf2).length()).append("isDirected: ").append(isDirected).append(", allowsParallelEdges: ").append(allowsParallelEdges).append(", allowsSelfLoops: ").append(allowsSelfLoops).append(", nodes: ").append(valueOf).append(", edges: ").append(valueOf2).toString();
    }

    private static <N, E> Map<E, EndpointPair<N>> edgeIncidentNodesMap(final Network<N, E> network) {
        return Maps.asMap(network.edges(), new Function<E, EndpointPair<N>>() {
            public EndpointPair<N> apply(E e) {
                return Network.this.incidentNodes(e);
            }
        });
    }
}
