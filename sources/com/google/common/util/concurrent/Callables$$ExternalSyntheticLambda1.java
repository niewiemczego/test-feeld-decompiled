package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Supplier f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ Callables$$ExternalSyntheticLambda1(Supplier supplier, Runnable runnable) {
        this.f$0 = supplier;
        this.f$1 = runnable;
    }

    public final void run() {
        Callables.lambda$threadRenaming$3(this.f$0, this.f$1);
    }
}
