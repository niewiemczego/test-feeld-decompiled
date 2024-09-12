package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextCreateDialog$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ ContextCreateDialog f$0;
    public final /* synthetic */ ResultProcessor f$1;

    public /* synthetic */ ContextCreateDialog$$ExternalSyntheticLambda0(ContextCreateDialog contextCreateDialog, ResultProcessor resultProcessor) {
        this.f$0 = contextCreateDialog;
        this.f$1 = resultProcessor;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return ContextCreateDialog.m313registerCallbackImpl$lambda3(this.f$0, this.f$1, i, intent);
    }
}
