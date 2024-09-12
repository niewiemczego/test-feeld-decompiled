package com.facebook.bolts;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$$ExternalSyntheticLambda4 implements Continuation {
    public final /* synthetic */ CancellationToken f$0;
    public final /* synthetic */ Continuation f$1;

    public /* synthetic */ Task$$ExternalSyntheticLambda4(CancellationToken cancellationToken, Continuation continuation) {
        this.f$0 = cancellationToken;
        this.f$1 = continuation;
    }

    public final Object then(Task task) {
        return Task.m297onSuccessTask$lambda14(this.f$0, this.f$1, task);
    }
}
