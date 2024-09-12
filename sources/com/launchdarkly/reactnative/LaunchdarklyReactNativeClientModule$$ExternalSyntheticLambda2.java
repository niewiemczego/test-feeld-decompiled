package com.launchdarkly.reactnative;

import com.launchdarkly.reactnative.LaunchdarklyReactNativeClientModule;
import com.launchdarkly.sdk.android.LDClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda2 implements LaunchdarklyReactNativeClientModule.EvalCall {
    public final Object call(LDClient lDClient, String str, Object obj) {
        return Boolean.valueOf(lDClient.boolVariation(str, ((Boolean) obj).booleanValue()));
    }
}
