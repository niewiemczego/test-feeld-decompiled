package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.utils.futures.SettableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WorkerUpdater$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SettableFuture f$0;
    public final /* synthetic */ WorkManagerImpl f$1;
    public final /* synthetic */ WorkRequest f$2;

    public /* synthetic */ WorkerUpdater$$ExternalSyntheticLambda1(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        this.f$0 = settableFuture;
        this.f$1 = workManagerImpl;
        this.f$2 = workRequest;
    }

    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$2(this.f$0, this.f$1, this.f$2);
    }
}
