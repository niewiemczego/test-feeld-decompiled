package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PausableExecutorServiceImpl$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ PausableExecutorServiceImpl$$ExternalSyntheticLambda1(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final Object call() {
        return this.f$0.run();
    }
}
