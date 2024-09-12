package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda7 implements Provider {
    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.factory("Firebase Scheduler", 0));
    }
}
