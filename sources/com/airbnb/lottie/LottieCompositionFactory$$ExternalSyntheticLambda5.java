package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda5 implements LottieListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ AtomicBoolean f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda5(String str, AtomicBoolean atomicBoolean) {
        this.f$0 = str;
        this.f$1 = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$9(this.f$0, this.f$1, (LottieComposition) obj);
    }
}
