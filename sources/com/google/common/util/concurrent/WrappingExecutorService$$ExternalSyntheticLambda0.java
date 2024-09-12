package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WrappingExecutorService$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Callable f$0;

    public /* synthetic */ WrappingExecutorService$$ExternalSyntheticLambda0(Callable callable) {
        this.f$0 = callable;
    }

    public final void run() {
        WrappingExecutorService.lambda$wrapTask$0(this.f$0);
    }
}
