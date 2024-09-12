package com.appsflyer.internal;

import android.app.Activity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AFb1cSDK$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ AFb1cSDK f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ AFb1cSDK$$ExternalSyntheticLambda2(AFb1cSDK aFb1cSDK, Activity activity) {
        this.f$0 = aFb1cSDK;
        this.f$1 = activity;
    }

    public final void run() {
        AFb1cSDK.AFInAppEventType(this.f$0, this.f$1);
    }
}
