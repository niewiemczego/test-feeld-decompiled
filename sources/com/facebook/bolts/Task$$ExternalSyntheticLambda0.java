package com.facebook.bolts;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$$ExternalSyntheticLambda0 implements Continuation {
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ Continuation f$1;

    public /* synthetic */ Task$$ExternalSyntheticLambda0(CancellationToken cancellationToken, Continuation continuation) {
        this.f$0 = cancellationToken;
        this.f$1 = continuation;
    }

    public final Object then(Task task) {
        return Task.m296onSuccess$lambda13(this.f$0, this.f$1, task);
    }
}
