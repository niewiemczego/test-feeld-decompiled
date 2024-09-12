package com.facebook.internal;

import com.facebook.internal.WorkQueue;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WorkQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WorkQueue.WorkNode f$0;
    public final /* synthetic */ WorkQueue f$1;

    public /* synthetic */ WorkQueue$$ExternalSyntheticLambda0(WorkQueue.WorkNode workNode, WorkQueue workQueue) {
        this.f$0 = workNode;
        this.f$1 = workQueue;
    }

    public final void run() {
        WorkQueue.m352execute$lambda2(this.f$0, this.f$1);
    }
}
