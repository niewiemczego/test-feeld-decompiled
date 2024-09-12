package com.SeonSdkReactNativeWrapper;

import com.facebook.react.bridge.Promise;
import io.seon.androidsdk.service.SeonCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SeonSdkReactNativeWrapper$$ExternalSyntheticLambda0 implements SeonCallback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ SeonSdkReactNativeWrapper$$ExternalSyntheticLambda0(Promise promise) {
        this.f$0 = promise;
    }

    public final void onComplete(String str) {
        this.f$0.resolve(str);
    }
}
