package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ TaskCompletionSource f$1;
    public final /* synthetic */ Callable f$2;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda1(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
        this.f$0 = cancellationToken;
        this.f$1 = taskCompletionSource;
        this.f$2 = callable;
    }

    public final void run() {
        Task.Companion.m300call$lambda2(this.f$0, this.f$1, this.f$2);
    }
}
