package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UndirectedGraphConnections$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ UndirectedGraphConnections$$ExternalSyntheticLambda0(Object obj) {
        this.f$0 = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.unordered(this.f$0, obj);
    }
}
