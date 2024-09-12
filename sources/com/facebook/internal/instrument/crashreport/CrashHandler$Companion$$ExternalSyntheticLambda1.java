package com.facebook.internal.instrument.crashreport;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CrashHandler$Companion$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ List f$0;

    public /* synthetic */ CrashHandler$Companion$$ExternalSyntheticLambda1(List list) {
        this.f$0 = list;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        CrashHandler.Companion.m369sendExceptionReports$lambda5(this.f$0, graphResponse);
    }
}
