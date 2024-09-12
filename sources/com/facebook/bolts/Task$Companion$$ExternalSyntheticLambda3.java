package com.facebook.bolts;

import com.facebook.bolts.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ TaskCompletionSource f$1;
    public final /* synthetic */ Continuation f$2;
    public final /* synthetic */ Task f$3;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda3(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
        this.f$0 = cancellationToken;
        this.f$1 = taskCompletionSource;
        this.f$2 = continuation;
        this.f$3 = task;
    }

    public final void run() {
        Task.Companion.m301completeAfterTask$lambda7(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
