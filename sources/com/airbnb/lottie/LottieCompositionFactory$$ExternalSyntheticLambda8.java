package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda8 implements Callable {
    public final /* synthetic */ InputStream f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda8(InputStream inputStream, String str) {
        this.f$0 = inputStream;
        this.f$1 = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f$0, this.f$1);
    }
}
