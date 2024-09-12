package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Striped$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ int f$0;

    public /* synthetic */ Striped$$ExternalSyntheticLambda1(int i) {
        this.f$0 = i;
    }

    public final Object get() {
        return Striped.lambda$lazyWeakSemaphore$2(this.f$0);
    }
}
