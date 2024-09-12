package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DirectedGraphConnections$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DirectedGraphConnections$$ExternalSyntheticLambda1(Object obj) {
        this.f$0 = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.ordered(this.f$0, obj);
    }
}
