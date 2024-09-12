package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda3 implements AsyncCallable {
    public final /* synthetic */ ListeningExecutorService f$0;
    public final /* synthetic */ Callable f$1;

    public /* synthetic */ Callables$$ExternalSyntheticLambda3(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f$0 = listeningExecutorService;
        this.f$1 = callable;
    }

    public final ListenableFuture call() {
        return this.f$0.submit(this.f$1);
    }
}
