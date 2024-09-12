package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextChooseDialog$$ExternalSyntheticLambda0 implements DaemonRequest.Callback {
    public final /* synthetic */ ContextChooseDialog f$0;

    public /* synthetic */ ContextChooseDialog$$ExternalSyntheticLambda0(ContextChooseDialog contextChooseDialog) {
        this.f$0 = contextChooseDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextChooseDialog.m311showForCloud$lambda2(this.f$0, graphResponse);
    }
}
