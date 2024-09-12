package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ComponentRuntime$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LazySet f$0;
    public final /* synthetic */ Provider f$1;

    public /* synthetic */ ComponentRuntime$$ExternalSyntheticLambda2(LazySet lazySet, Provider provider) {
        this.f$0 = lazySet;
        this.f$1 = provider;
    }

    public final void run() {
        this.f$0.add(this.f$1);
    }
}
