package com.google.common.cache;

import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RemovalListeners$$ExternalSyntheticLambda1 implements RemovalListener {
    public final /* synthetic */ Executor f$0;
    public final /* synthetic */ RemovalListener f$1;

    public /* synthetic */ RemovalListeners$$ExternalSyntheticLambda1(Executor executor, RemovalListener removalListener) {
        this.f$0 = executor;
        this.f$1 = removalListener;
    }

    public final void onRemoval(RemovalNotification removalNotification) {
        this.f$0.execute(new RemovalListeners$$ExternalSyntheticLambda0(this.f$1, removalNotification));
    }
}
