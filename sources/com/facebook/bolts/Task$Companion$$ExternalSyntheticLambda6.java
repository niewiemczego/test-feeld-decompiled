package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda6 implements Continuation {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ TaskCompletionSource f$1;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda6(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
        this.f$0 = atomicBoolean;
        this.f$1 = taskCompletionSource;
    }

    public final Object then(Task task) {
        return Task.Companion.m306whenAny$lambda4(this.f$0, this.f$1, task);
    }
}
