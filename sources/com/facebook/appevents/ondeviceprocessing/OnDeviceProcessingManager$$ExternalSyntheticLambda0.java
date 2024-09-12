package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnDeviceProcessingManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ OnDeviceProcessingManager$$ExternalSyntheticLambda0(Context context, String str, String str2) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = str2;
    }

    public final void run() {
        OnDeviceProcessingManager.m287sendInstallEventAsync$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
