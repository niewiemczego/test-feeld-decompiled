package com.facebook.appevents;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ AccessTokenAppIdPair f$0;
    public final /* synthetic */ AppEvent f$1;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda4(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.f$0 = accessTokenAppIdPair;
        this.f$1 = appEvent;
    }

    public final void run() {
        AppEventQueue.m225add$lambda3(this.f$0, this.f$1);
    }
}
