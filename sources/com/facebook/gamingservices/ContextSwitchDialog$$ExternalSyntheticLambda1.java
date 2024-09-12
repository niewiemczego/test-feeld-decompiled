package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextSwitchDialog$$ExternalSyntheticLambda1 implements DaemonRequest.Callback {
    public final /* synthetic */ ContextSwitchDialog f$0;

    public /* synthetic */ ContextSwitchDialog$$ExternalSyntheticLambda1(ContextSwitchDialog contextSwitchDialog) {
        this.f$0 = contextSwitchDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextSwitchDialog.m316showForCloud$lambda2(this.f$0, graphResponse);
    }
}
