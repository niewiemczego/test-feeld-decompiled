package com.facebook.appevents;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ AccessTokenAppIdPair f$0;
    public final /* synthetic */ GraphRequest f$1;
    public final /* synthetic */ SessionEventsState f$2;
    public final /* synthetic */ FlushStatistics f$3;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda1(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        this.f$0 = accessTokenAppIdPair;
        this.f$1 = graphRequest;
        this.f$2 = sessionEventsState;
        this.f$3 = flushStatistics;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AppEventQueue.m226buildRequestForSession$lambda4(this.f$0, this.f$1, this.f$2, this.f$3, graphResponse);
    }
}
