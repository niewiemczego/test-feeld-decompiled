package com.facebook;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ FacebookSdk.InitializeCallback f$0;

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda7(FacebookSdk.InitializeCallback initializeCallback) {
        this.f$0 = initializeCallback;
    }

    public final Object call() {
        return FacebookSdk.m208sdkInitialize$lambda9(this.f$0);
    }
}
