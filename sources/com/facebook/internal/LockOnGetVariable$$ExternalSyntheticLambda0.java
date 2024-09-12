package com.facebook.internal;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LockOnGetVariable$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ LockOnGetVariable f$0;
    public final /* synthetic */ Callable f$1;

    public /* synthetic */ LockOnGetVariable$$ExternalSyntheticLambda0(LockOnGetVariable lockOnGetVariable, Callable callable) {
        this.f$0 = lockOnGetVariable;
        this.f$1 = callable;
    }

    public final Object call() {
        return LockOnGetVariable.m342_init_$lambda0(this.f$0, this.f$1);
    }
}
