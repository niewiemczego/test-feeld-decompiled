package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ JsonReader f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda0(JsonReader jsonReader, String str) {
        this.f$0 = jsonReader;
        this.f$1 = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonReaderSync(this.f$0, this.f$1);
    }
}
