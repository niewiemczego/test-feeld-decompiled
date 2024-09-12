package com.facebook.appevents.codeless;

import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.internal.FetchedAppSettings;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CodelessManager$$ExternalSyntheticLambda1 implements ViewIndexingTrigger.OnShakeListener {
    public final /* synthetic */ FetchedAppSettings f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ CodelessManager$$ExternalSyntheticLambda1(FetchedAppSettings fetchedAppSettings, String str) {
        this.f$0 = fetchedAppSettings;
        this.f$1 = str;
    }

    public final void onShake() {
        CodelessManager.m255onActivityResumed$lambda0(this.f$0, this.f$1);
    }
}
