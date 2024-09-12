package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AFb1xSDK$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AFb1xSDK f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Intent f$2;

    public /* synthetic */ AFb1xSDK$$ExternalSyntheticLambda0(AFb1xSDK aFb1xSDK, Context context, Intent intent) {
        this.f$0 = aFb1xSDK;
        this.f$1 = context;
        this.f$2 = intent;
    }

    public final void run() {
        this.f$0.AFInAppEventParameterName(this.f$1, this.f$2);
    }
}
