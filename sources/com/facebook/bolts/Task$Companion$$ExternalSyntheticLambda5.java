package com.facebook.bolts;

import com.facebook.bolts.Task;
import java.util.concurrent.ScheduledFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Task$Companion$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ ScheduledFuture f$0;
    public final /* synthetic */ TaskCompletionSource f$1;

    public /* synthetic */ Task$Companion$$ExternalSyntheticLambda5(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
        this.f$0 = scheduledFuture;
        this.f$1 = taskCompletionSource;
    }

    public final void run() {
        Task.Companion.m305delay$lambda1(this.f$0, this.f$1);
    }
}
