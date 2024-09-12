package com.braze.ui.inappmessage.jsinterface;

import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InAppMessageUserJavascriptInterface$Companion$$ExternalSyntheticLambda0 implements IValueCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ InAppMessageUserJavascriptInterface$Companion$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        InAppMessageUserJavascriptInterface.Companion.runOnUser$lambda$0(this.f$0, (BrazeUser) obj);
    }
}
