package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ DelegatingScheduledExecutorService f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ DelegatingScheduledFuture.Completer f$2;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda5(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.f$0 = delegatingScheduledExecutorService;
        this.f$1 = runnable;
        this.f$2 = completer;
    }

    public final void run() {
        this.f$0.m576lambda$scheduleAtFixedRate$7$comgooglefirebaseconcurrentDelegatingScheduledExecutorService(this.f$1, this.f$2);
    }
}
