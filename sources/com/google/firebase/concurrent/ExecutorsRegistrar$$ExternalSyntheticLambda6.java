package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda6 implements Provider {
    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
    }
}
