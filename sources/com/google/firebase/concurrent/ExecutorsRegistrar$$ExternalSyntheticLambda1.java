package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda1 implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
    }
}
