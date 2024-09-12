package com.braze.reactbridge;

import com.braze.events.IValueCallback;
import com.facebook.react.bridge.Callback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda0 implements IValueCallback {
    public final /* synthetic */ Callback f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda0(Callback callback) {
        this.f$0 = callback;
    }

    public final void onSuccess(Object obj) {
        BrazeReactBridgeImpl.m156getDeviceId$lambda27(this.f$0, (String) obj);
    }
}
