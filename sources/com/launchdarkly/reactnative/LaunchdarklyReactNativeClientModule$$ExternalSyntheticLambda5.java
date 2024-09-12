package com.launchdarkly.reactnative;

import com.launchdarkly.reactnative.LaunchdarklyReactNativeClientModule;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.android.LDClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda5 implements LaunchdarklyReactNativeClientModule.EvalCall {
    public final Object call(LDClient lDClient, String str, Object obj) {
        return lDClient.jsonValueVariation(str, (LDValue) obj);
    }
}
