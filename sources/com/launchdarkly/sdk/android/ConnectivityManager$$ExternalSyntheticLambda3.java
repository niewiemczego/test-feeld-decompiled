package com.launchdarkly.sdk.android;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectivityManager$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ LDStatusListener f$0;
    public final /* synthetic */ LDFailure f$1;

    public /* synthetic */ ConnectivityManager$$ExternalSyntheticLambda3(LDStatusListener lDStatusListener, LDFailure lDFailure) {
        this.f$0 = lDStatusListener;
        this.f$1 = lDFailure;
    }

    public final void run() {
        this.f$0.onInternalFailure(this.f$1);
    }
}
