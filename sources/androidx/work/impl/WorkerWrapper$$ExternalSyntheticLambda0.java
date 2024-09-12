package androidx.work.impl;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WorkerWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WorkerWrapper f$0;
    public final /* synthetic */ ListenableFuture f$1;

    public /* synthetic */ WorkerWrapper$$ExternalSyntheticLambda0(WorkerWrapper workerWrapper, ListenableFuture listenableFuture) {
        this.f$0 = workerWrapper;
        this.f$1 = listenableFuture;
    }

    public final void run() {
        this.f$0.m61lambda$runWorker$0$androidxworkimplWorkerWrapper(this.f$1);
    }
}
