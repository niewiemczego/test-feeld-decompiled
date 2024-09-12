package com.braze.reactbridge;

import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda7 implements IValueCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda7(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        BrazeReactBridgeImpl.m158runOnUser$lambda28(this.f$0, (BrazeUser) obj);
    }
}
