package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImmutableNetwork$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Network f$0;

    public /* synthetic */ ImmutableNetwork$$ExternalSyntheticLambda0(Network network) {
        this.f$0 = network;
    }

    public final Object apply(Object obj) {
        return this.f$0.incidentNodes(obj).source();
    }
}
