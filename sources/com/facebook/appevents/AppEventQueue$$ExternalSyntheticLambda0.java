package com.facebook.appevents;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AccessTokenAppIdPair f$0;
    public final /* synthetic */ SessionEventsState f$1;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda0(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        this.f$0 = accessTokenAppIdPair;
        this.f$1 = sessionEventsState;
    }

    public final void run() {
        AppEventQueue.m229handleResponse$lambda5(this.f$0, this.f$1);
    }
}
