package com.google.common.cache;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RemovalListeners$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ RemovalListener f$0;
    public final /* synthetic */ RemovalNotification f$1;

    public /* synthetic */ RemovalListeners$$ExternalSyntheticLambda0(RemovalListener removalListener, RemovalNotification removalNotification) {
        this.f$0 = removalListener;
        this.f$1 = removalNotification;
    }

    public final void run() {
        this.f$0.onRemoval(this.f$1);
    }
}
