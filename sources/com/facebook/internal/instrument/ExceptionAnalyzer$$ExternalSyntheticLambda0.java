package com.facebook.internal.instrument;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExceptionAnalyzer$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ InstrumentData f$0;

    public /* synthetic */ ExceptionAnalyzer$$ExternalSyntheticLambda0(InstrumentData instrumentData) {
        this.f$0 = instrumentData;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ExceptionAnalyzer.m355sendExceptionAnalysisReports$lambda1(this.f$0, graphResponse);
    }
}
