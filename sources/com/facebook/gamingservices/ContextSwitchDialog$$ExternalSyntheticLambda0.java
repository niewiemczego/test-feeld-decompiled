package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextSwitchDialog$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ ContextSwitchDialog f$0;
    public final /* synthetic */ ResultProcessor f$1;

    public /* synthetic */ ContextSwitchDialog$$ExternalSyntheticLambda0(ContextSwitchDialog contextSwitchDialog, ResultProcessor resultProcessor) {
        this.f$0 = contextSwitchDialog;
        this.f$1 = resultProcessor;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return ContextSwitchDialog.m315registerCallbackImpl$lambda3(this.f$0, this.f$1, i, intent);
    }
}
