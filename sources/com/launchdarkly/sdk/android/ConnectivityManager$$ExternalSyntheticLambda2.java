package com.launchdarkly.sdk.android;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectivityManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LDStatusListener f$0;
    public final /* synthetic */ ConnectionInformation f$1;

    public /* synthetic */ ConnectivityManager$$ExternalSyntheticLambda2(LDStatusListener lDStatusListener, ConnectionInformation connectionInformation) {
        this.f$0 = lDStatusListener;
        this.f$1 = connectionInformation;
    }

    public final void run() {
        this.f$0.onConnectionModeChanged(this.f$1);
    }
}
