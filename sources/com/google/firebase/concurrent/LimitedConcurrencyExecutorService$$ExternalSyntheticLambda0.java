package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LimitedConcurrencyExecutorService$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ LimitedConcurrencyExecutorService$$ExternalSyntheticLambda0(Runnable runnable, Object obj) {
        this.f$0 = runnable;
        this.f$1 = obj;
    }

    public final Object call() {
        return this.f$0.run();
    }
}
