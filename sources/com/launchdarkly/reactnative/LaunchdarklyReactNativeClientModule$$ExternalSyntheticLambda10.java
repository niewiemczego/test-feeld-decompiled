package com.launchdarkly.reactnative;

import com.launchdarkly.reactnative.LaunchdarklyReactNativeClientModule;
import com.launchdarkly.sdk.EvaluationDetail;
import com.launchdarkly.sdk.android.LDClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda10 implements LaunchdarklyReactNativeClientModule.EvalDetailCall {
    public final EvaluationDetail call(LDClient lDClient, String str, Object obj) {
        return lDClient.stringVariationDetail(str, (String) obj);
    }
}
