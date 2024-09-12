package com.adapty.react;

import com.adapty.errors.AdaptyError;
import com.adapty.utils.ErrorCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AdaptyCallHandler$$ExternalSyntheticLambda2 implements ErrorCallback {
    public final /* synthetic */ AdaptyContext f$0;

    public /* synthetic */ AdaptyCallHandler$$ExternalSyntheticLambda2(AdaptyContext adaptyContext) {
        this.f$0 = adaptyContext;
    }

    public final void onResult(AdaptyError adaptyError) {
        AdaptyCallHandler.m113handleLogShowPaywall$lambda8(this.f$0, adaptyError);
    }
}
