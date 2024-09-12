package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextCreateDialog$$ExternalSyntheticLambda1 implements DaemonRequest.Callback {
    public final /* synthetic */ ContextCreateDialog f$0;

    public /* synthetic */ ContextCreateDialog$$ExternalSyntheticLambda1(ContextCreateDialog contextCreateDialog) {
        this.f$0 = contextCreateDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextCreateDialog.m314showForCloud$lambda2(this.f$0, graphResponse);
    }
}
