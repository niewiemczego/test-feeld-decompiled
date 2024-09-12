package com.appsflyer.internal;

import android.hardware.SensorEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AFa1jSDK$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AFa1jSDK f$0;
    public final /* synthetic */ SensorEvent f$1;

    public /* synthetic */ AFa1jSDK$$ExternalSyntheticLambda0(AFa1jSDK aFa1jSDK, SensorEvent sensorEvent) {
        this.f$0 = aFa1jSDK;
        this.f$1 = sensorEvent;
    }

    public final void run() {
        this.f$0.AFInAppEventType(this.f$1);
    }
}
