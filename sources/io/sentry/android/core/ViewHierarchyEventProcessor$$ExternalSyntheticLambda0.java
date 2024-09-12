package io.sentry.android.core;

import android.view.View;
import io.sentry.ILogger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewHierarchyEventProcessor$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AtomicReference f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ CountDownLatch f$3;
    public final /* synthetic */ ILogger f$4;

    public /* synthetic */ ViewHierarchyEventProcessor$$ExternalSyntheticLambda0(AtomicReference atomicReference, View view, List list, CountDownLatch countDownLatch, ILogger iLogger) {
        this.f$0 = atomicReference;
        this.f$1 = view;
        this.f$2 = list;
        this.f$3 = countDownLatch;
        this.f$4 = iLogger;
    }

    public final void run() {
        ViewHierarchyEventProcessor.lambda$snapshotViewHierarchy$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
