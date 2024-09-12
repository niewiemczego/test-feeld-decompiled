package com.facebook.bolts;

import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$$ExternalSyntheticLambda2 implements Continuation {
    public final /* synthetic */ TaskCompletionSource f$0;
    public final /* synthetic */ Continuation f$1;
    public final /* synthetic */ Executor f$2;
    public final /* synthetic */ CancellationToken f$3;

    public /* synthetic */ Task$$ExternalSyntheticLambda2(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
        this.f$0 = taskCompletionSource;
        this.f$1 = continuation;
        this.f$2 = executor;
        this.f$3 = cancellationToken;
    }

    public final Object then(Task task) {
        return Task.m294continueWithTask$lambda12$lambda11(this.f$0, this.f$1, this.f$2, this.f$3, task);
    }
}
