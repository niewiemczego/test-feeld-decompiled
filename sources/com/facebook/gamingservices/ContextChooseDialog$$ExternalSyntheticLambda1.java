package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextChooseDialog$$ExternalSyntheticLambda1 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ ContextChooseDialog f$0;
    public final /* synthetic */ ContextChooseDialog$registerCallbackImpl$resultProcessor$1 f$1;

    public /* synthetic */ ContextChooseDialog$$ExternalSyntheticLambda1(ContextChooseDialog contextChooseDialog, ContextChooseDialog$registerCallbackImpl$resultProcessor$1 contextChooseDialog$registerCallbackImpl$resultProcessor$1) {
        this.f$0 = contextChooseDialog;
        this.f$1 = contextChooseDialog$registerCallbackImpl$resultProcessor$1;
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return ContextChooseDialog.m310registerCallbackImpl$lambda4(this.f$0, this.f$1, i, intent);
    }
}
