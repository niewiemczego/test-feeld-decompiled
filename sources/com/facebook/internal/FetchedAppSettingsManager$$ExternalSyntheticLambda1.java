package com.facebook.internal;

import com.facebook.internal.FetchedAppSettingsManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FetchedAppSettingsManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ FetchedAppSettingsManager.FetchedAppSettingsCallback f$0;

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda1(FetchedAppSettingsManager.FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        this.f$0 = fetchedAppSettingsCallback;
    }

    public final void run() {
        FetchedAppSettingsManager.m333pollCallbacks$lambda1(this.f$0);
    }
}
