package com.google.common.graph;

import com.google.common.base.Function;
import java.util.Objects;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImmutableValueGraph$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ ValueGraph f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ImmutableValueGraph$$ExternalSyntheticLambda0(ValueGraph valueGraph, Object obj) {
        this.f$0 = valueGraph;
        this.f$1 = obj;
    }

    public final Object apply(Object obj) {
        return Objects.requireNonNull(this.f$0.edgeValueOrDefault(this.f$1, obj, null));
    }
}
