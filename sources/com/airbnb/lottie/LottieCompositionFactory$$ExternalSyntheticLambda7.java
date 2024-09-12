package com.airbnb.lottie;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda7(String str, String str2) {
        this.f$0 = str;
        this.f$1 = str2;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonStringSync(this.f$0, this.f$1);
    }
}
