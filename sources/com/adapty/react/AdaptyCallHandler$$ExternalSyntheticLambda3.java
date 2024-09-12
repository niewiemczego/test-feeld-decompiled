package com.adapty.react;

import com.adapty.errors.AdaptyError;
import com.adapty.utils.ErrorCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdaptyCallHandler$$ExternalSyntheticLambda3 implements ErrorCallback {
    public final /* synthetic */ AdaptyContext f$0;

    public /* synthetic */ AdaptyCallHandler$$ExternalSyntheticLambda3(AdaptyContext adaptyContext) {
        this.f$0 = adaptyContext;
    }

    public final void onResult(AdaptyError adaptyError) {
        AdaptyCallHandler.m117handleSetFallbackPaywalls$lambda9(this.f$0, adaptyError);
    }
}
