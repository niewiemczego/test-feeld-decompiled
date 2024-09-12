package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N"})
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n2, N n3) {
        this.nodeU = Preconditions.checkNotNull(n2);
        this.nodeV = Preconditions.checkNotNull(n3);
    }

    public static <N> EndpointPair<N> ordered(N n2, N n3) {
        return new Ordered(n2, n3);
    }

    public static <N> EndpointPair<N> unordered(N n2, N n3) {
        return new Unordered(n3, n2);
    }

    static <N> EndpointPair<N> of(Graph<?> graph, N n2, N n3) {
        return graph.isDirected() ? ordered(n2, n3) : unordered(n2, n3);
    }

    static <N> EndpointPair<N> of(Network<?, ?> network, N n2, N n3) {
        return network.isDirected() ? ordered(n2, n3) : unordered(n2, n3);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public final N adjacentNode(N n2) {
        if (n2.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n2.equals(this.nodeV)) {
            return this.nodeU;
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(n2);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length()).append("EndpointPair ").append(valueOf).append(" does not contain node ").append(valueOf2).toString());
    }

    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    private static final class Ordered<N> extends EndpointPair<N> {
        public boolean isOrdered() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Ordered(N n2, N n3) {
            super(n2, n3);
        }

        public N source() {
            return nodeU();
        }

        public N target() {
            return nodeV();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (!source().equals(endpointPair.source()) || !target().equals(endpointPair.target())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public String toString() {
            String valueOf = String.valueOf(source());
            String valueOf2 = String.valueOf(target());
            return new StringBuilder(String.valueOf(valueOf).length() + 6 + String.valueOf(valueOf2).length()).append("<").append(valueOf).append(" -> ").append(valueOf2).append(">").toString();
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        public boolean isOrdered() {
            return false;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Unordered(N n2, N n3) {
            super(n2, n3);
        }

        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            if (!nodeU().equals(endpointPair.nodeV()) || !nodeV().equals(endpointPair.nodeU())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(nodeU());
            String valueOf2 = String.valueOf(nodeV());
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length()).append("[").append(valueOf).append(", ").append(valueOf2).append("]").toString();
        }
    }
}
