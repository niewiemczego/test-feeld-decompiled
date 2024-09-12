package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    /* access modifiers changed from: private */
    public final Map<N, Object> adjacentNodeValues;
    /* access modifiers changed from: private */
    @CheckForNull
    public final List<NodeConnection<N>> orderedNodeConnections;
    /* access modifiers changed from: private */
    public int predecessorCount;
    /* access modifiers changed from: private */
    public int successorCount;

    private static final class PredAndSucc {
        /* access modifiers changed from: private */
        public final Object successorValue;

        PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    private static abstract class NodeConnection<N> {
        final N node;

        NodeConnection(N n2) {
            this.node = Preconditions.checkNotNull(n2);
        }

        static final class Pred<N> extends NodeConnection<N> {
            Pred(N n2) {
                super(n2);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Pred) {
                    return this.node.equals(((Pred) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.node.hashCode();
            }
        }

        static final class Succ<N> extends NodeConnection<N> {
            Succ(N n2) {
                super(n2);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Succ) {
                    return this.node.equals(((Succ) obj).node);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.node.hashCode();
            }
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, @CheckForNull List<NodeConnection<N>> list, int i, int i2) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.orderedNodeConnections = list;
        this.predecessorCount = Graphs.checkNonNegative(i);
        this.successorCount = Graphs.checkNonNegative(i2);
        Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    /* renamed from: com.google.common.graph.DirectedGraphConnections$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.graph.ElementOrder$Type[] r0 = com.google.common.graph.ElementOrder.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$common$graph$ElementOrder$Type = r0
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.UNORDERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$common$graph$ElementOrder$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.graph.ElementOrder$Type r1 = com.google.common.graph.ElementOrder.Type.STABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass5.<clinit>():void");
        }
    }

    static <N, V> DirectedGraphConnections<N, V> of(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i = AnonymousClass5.$SwitchMap$com$google$common$graph$ElementOrder$Type[elementOrder.type().ordinal()];
        if (i == 1) {
            arrayList = null;
        } else if (i == 2) {
            arrayList = new ArrayList();
        } else {
            throw new AssertionError(elementOrder.type());
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    static <N, V> DirectedGraphConnections<N, V> ofImmutable(N n2, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        Preconditions.checkNotNull(n2);
        Preconditions.checkNotNull(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i = 0;
        int i2 = 0;
        for (EndpointPair next : iterable) {
            if (next.nodeU().equals(n2) && next.nodeV().equals(n2)) {
                hashMap.put(n2, new PredAndSucc(function.apply(n2)));
                builder.add((Object) new NodeConnection.Pred(n2));
                builder.add((Object) new NodeConnection.Succ(n2));
                i++;
            } else if (next.nodeV().equals(n2)) {
                Object nodeU = next.nodeU();
                Object put = hashMap.put(nodeU, PRED);
                if (put != null) {
                    hashMap.put(nodeU, new PredAndSucc(put));
                }
                builder.add((Object) new NodeConnection.Pred(nodeU));
                i++;
            } else {
                Preconditions.checkArgument(next.nodeU().equals(n2));
                Object nodeV = next.nodeV();
                V apply = function.apply(nodeV);
                Object put2 = hashMap.put(nodeV, apply);
                if (put2 != null) {
                    Preconditions.checkArgument(put2 == PRED);
                    hashMap.put(nodeV, new PredAndSucc(apply));
                }
                builder.add((Object) new NodeConnection.Succ(nodeV));
            }
            i2++;
        }
        return new DirectedGraphConnections<>(hashMap, builder.build(), i, i2);
    }

    public Set<N> adjacentNodes() {
        if (this.orderedNodeConnections == null) {
            return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
        }
        return new AbstractSet<N>() {
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N computeNext() {
                        while (it.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it.next();
                            if (hashSet.add(nodeConnection.node)) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.adjacentNodeValues.size();
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.this.adjacentNodeValues.containsKey(obj);
            }
        };
    }

    public Set<N> predecessors() {
        return new AbstractSet<N>() {
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>(this) {
                        /* access modifiers changed from: protected */
                        @CheckForNull
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }
        };
    }

    public Set<N> successors() {
        return new AbstractSet<N>() {
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.orderedNodeConnections == null) {
                    final Iterator it = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                    return new AbstractIterator<N>(this) {
                        /* access modifiers changed from: protected */
                        @CheckForNull
                        public N computeNext() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                    return entry.getKey();
                                }
                            }
                            return endOfData();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.orderedNodeConnections.iterator();
                return new AbstractIterator<N>(this) {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public N computeNext() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.node;
                            }
                        }
                        return endOfData();
                    }
                };
            }

            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }

            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }
        };
    }

    public Iterator<EndpointPair<N>> incidentEdgeIterator(N n2) {
        final Iterator<T> it;
        Preconditions.checkNotNull(n2);
        List<NodeConnection<N>> list = this.orderedNodeConnections;
        if (list == null) {
            it = Iterators.concat(Iterators.transform(predecessors().iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda0(n2)), Iterators.transform(successors().iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda1(n2)));
        } else {
            it = Iterators.transform(list.iterator(), new DirectedGraphConnections$$ExternalSyntheticLambda2(n2));
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>(this) {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
            @javax.annotation.CheckForNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.common.graph.EndpointPair<N> computeNext() {
                /*
                    r3 = this;
                L_0x0000:
                    java.util.Iterator r0 = r4
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0028
                    java.util.Iterator r0 = r4
                    java.lang.Object r0 = r0.next()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    java.lang.Object r1 = r0.nodeU()
                    java.lang.Object r2 = r0.nodeV()
                    boolean r1 = r1.equals(r2)
                    if (r1 == 0) goto L_0x0027
                    java.util.concurrent.atomic.AtomicBoolean r1 = r0
                    r2 = 1
                    boolean r1 = r1.getAndSet(r2)
                    if (r1 != 0) goto L_0x0000
                L_0x0027:
                    return r0
                L_0x0028:
                    java.lang.Object r0 = r3.endOfData()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass4.computeNext():com.google.common.graph.EndpointPair");
            }
        };
    }

    static /* synthetic */ EndpointPair lambda$incidentEdgeIterator$2(Object obj, NodeConnection nodeConnection) {
        if (nodeConnection instanceof NodeConnection.Succ) {
            return EndpointPair.ordered(obj, nodeConnection.node);
        }
        return EndpointPair.ordered(nodeConnection.node, obj);
    }

    @CheckForNull
    public V value(N n2) {
        Preconditions.checkNotNull(n2);
        V v = this.adjacentNodeValues.get(n2);
        if (v == PRED) {
            return null;
        }
        return v instanceof PredAndSucc ? ((PredAndSucc) v).successorValue : v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removePredecessor(N r4) {
        /*
            r3 = this;
            com.google.common.base.Preconditions.checkNotNull(r4)
            java.util.Map<N, java.lang.Object> r0 = r3.adjacentNodeValues
            java.lang.Object r0 = r0.get(r4)
            java.lang.Object r1 = PRED
            r2 = 1
            if (r0 != r1) goto L_0x0015
            java.util.Map<N, java.lang.Object> r0 = r3.adjacentNodeValues
            r0.remove(r4)
        L_0x0013:
            r0 = r2
            goto L_0x0026
        L_0x0015:
            boolean r1 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r1 == 0) goto L_0x0025
            java.util.Map<N, java.lang.Object> r1 = r3.adjacentNodeValues
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = r0.successorValue
            r1.put(r4, r0)
            goto L_0x0013
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x003c
            int r0 = r3.predecessorCount
            int r0 = r0 - r2
            r3.predecessorCount = r0
            com.google.common.graph.Graphs.checkNonNegative((int) r0)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r0 = r3.orderedNodeConnections
            if (r0 == 0) goto L_0x003c
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r1 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r1.<init>(r4)
            r0.remove(r1)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.removePredecessor(java.lang.Object):void");
    }

    @CheckForNull
    public V removeSuccessor(Object obj) {
        V v;
        Preconditions.checkNotNull(obj);
        V v2 = this.adjacentNodeValues.get(obj);
        if (v2 == null || v2 == (v = PRED)) {
            v2 = null;
        } else if (v2 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, v);
            v2 = ((PredAndSucc) v2).successorValue;
        } else {
            this.adjacentNodeValues.remove(obj);
        }
        if (v2 != null) {
            int i = this.successorCount - 1;
            this.successorCount = i;
            Graphs.checkNonNegative(i);
            List<NodeConnection<N>> list = this.orderedNodeConnections;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addPredecessor(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r6 = r4.adjacentNodeValues
            java.lang.Object r0 = PRED
            java.lang.Object r6 = r6.put(r5, r0)
            r1 = 0
            r2 = 1
            if (r6 != 0) goto L_0x000e
        L_0x000c:
            r1 = r2
            goto L_0x0025
        L_0x000e:
            boolean r3 = r6 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r3 == 0) goto L_0x0018
            java.util.Map<N, java.lang.Object> r0 = r4.adjacentNodeValues
            r0.put(r5, r6)
            goto L_0x0025
        L_0x0018:
            if (r6 == r0) goto L_0x0025
            java.util.Map<N, java.lang.Object> r0 = r4.adjacentNodeValues
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r1 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r1.<init>(r6)
            r0.put(r5, r1)
            goto L_0x000c
        L_0x0025:
            if (r1 == 0) goto L_0x003b
            int r6 = r4.predecessorCount
            int r6 = r6 + r2
            r4.predecessorCount = r6
            com.google.common.graph.Graphs.checkPositive((int) r6)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r6 = r4.orderedNodeConnections
            if (r6 == 0) goto L_0x003b
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r0 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r0.<init>(r5)
            r6.add(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.addPredecessor(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V addSuccessor(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r0 = r4.adjacentNodeValues
            java.lang.Object r0 = r0.put(r5, r6)
            r1 = 0
            if (r0 != 0) goto L_0x000b
        L_0x0009:
            r0 = r1
            goto L_0x002f
        L_0x000b:
            boolean r2 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r2 == 0) goto L_0x0020
            java.util.Map<N, java.lang.Object> r2 = r4.adjacentNodeValues
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r3 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3.<init>(r6)
            r2.put(r5, r3)
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = r0.successorValue
            goto L_0x002f
        L_0x0020:
            java.lang.Object r2 = PRED
            if (r0 != r2) goto L_0x002f
            java.util.Map<N, java.lang.Object> r0 = r4.adjacentNodeValues
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r2.<init>(r6)
            r0.put(r5, r2)
            goto L_0x0009
        L_0x002f:
            if (r0 != 0) goto L_0x0046
            int r6 = r4.successorCount
            int r6 = r6 + 1
            r4.successorCount = r6
            com.google.common.graph.Graphs.checkPositive((int) r6)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r6 = r4.orderedNodeConnections
            if (r6 == 0) goto L_0x0046
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ r2 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ
            r2.<init>(r5)
            r6.add(r2)
        L_0x0046:
            if (r0 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = r0
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.addSuccessor(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static boolean isPredecessor(@CheckForNull Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* access modifiers changed from: private */
    public static boolean isSuccessor(@CheckForNull Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }
}
