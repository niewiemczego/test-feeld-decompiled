package com.launchdarkly.sdk.android;

import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextDataManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ ContextDataManager$$ExternalSyntheticLambda1(Map map) {
        this.f$0 = map;
    }

    public final void run() {
        ContextDataManager.lambda$notifyFlagListeners$0(this.f$0);
    }
}
