package com.facebook.internal.instrument.anrreport;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ANRHandler$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ List f$0;

    public /* synthetic */ ANRHandler$$ExternalSyntheticLambda1(List list) {
        this.f$0 = list;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ANRHandler.m367sendANRReports$lambda5(this.f$0, graphResponse);
    }
}
