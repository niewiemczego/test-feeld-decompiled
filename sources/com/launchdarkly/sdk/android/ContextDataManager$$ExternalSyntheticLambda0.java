package com.launchdarkly.sdk.android;

import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContextDataManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ContextDataManager f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ ContextDataManager$$ExternalSyntheticLambda0(ContextDataManager contextDataManager, List list) {
        this.f$0 = contextDataManager;
        this.f$1 = list;
    }

    public final void run() {
        this.f$0.m450lambda$notifyAllFlagsListeners$1$comlaunchdarklysdkandroidContextDataManager(this.f$1);
    }
}
