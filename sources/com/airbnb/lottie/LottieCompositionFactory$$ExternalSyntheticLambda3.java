package com.airbnb.lottie;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ JSONObject f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda3(JSONObject jSONObject, String str) {
        this.f$0 = jSONObject;
        this.f$1 = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonSync(this.f$0, this.f$1);
    }
}
