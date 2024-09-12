package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImmutableNetwork$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ Network f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ImmutableNetwork$$ExternalSyntheticLambda2(Network network, Object obj) {
        this.f$0 = network;
        this.f$1 = obj;
    }

    public final Object apply(Object obj) {
        return this.f$0.incidentNodes(obj).adjacentNode(this.f$1);
    }
}
