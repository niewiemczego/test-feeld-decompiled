package com.facebook.appevents.ondeviceprocessing;

import com.facebook.appevents.AppEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnDeviceProcessingManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ AppEvent f$1;

    public /* synthetic */ OnDeviceProcessingManager$$ExternalSyntheticLambda1(String str, AppEvent appEvent) {
        this.f$0 = str;
        this.f$1 = appEvent;
    }

    public final void run() {
        OnDeviceProcessingManager.m286sendCustomEventAsync$lambda1(this.f$0, this.f$1);
    }
}
