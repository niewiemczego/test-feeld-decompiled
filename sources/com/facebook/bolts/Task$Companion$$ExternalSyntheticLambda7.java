package com.facebook.bolts;

import com.facebook.bolts.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda7 implements Continuation {
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ TaskCompletionSource f$1;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda7(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource) {
        this.f$0 = cancellationToken;
        this.f$1 = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m302completeAfterTask$lambda7$lambda6(this.f$0, this.f$1, task);
    }
}
