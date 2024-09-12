package com.airbnb.lottie;

import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda9 implements Callable {
    public final /* synthetic */ ZipInputStream f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda9(ZipInputStream zipInputStream, String str) {
        this.f$0 = zipInputStream;
        this.f$1 = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromZipStreamSync(this.f$0, this.f$1);
    }
}
