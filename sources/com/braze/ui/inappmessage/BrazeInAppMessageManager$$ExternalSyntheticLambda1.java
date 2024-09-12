package com.braze.ui.inappmessage;

import android.app.Activity;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeInAppMessageManager$$ExternalSyntheticLambda1 implements IWebViewClientStateListener {
    public final /* synthetic */ IInAppMessageViewWrapper f$0;
    public final /* synthetic */ BrazeInAppMessageManager f$1;
    public final /* synthetic */ Activity f$2;

    public /* synthetic */ BrazeInAppMessageManager$$ExternalSyntheticLambda1(IInAppMessageViewWrapper iInAppMessageViewWrapper, BrazeInAppMessageManager brazeInAppMessageManager, Activity activity) {
        this.f$0 = iInAppMessageViewWrapper;
        this.f$1 = brazeInAppMessageManager;
        this.f$2 = activity;
    }

    public final void onPageFinished() {
        BrazeInAppMessageManager.displayInAppMessage$lambda$7(this.f$0, this.f$1, this.f$2);
    }
}
