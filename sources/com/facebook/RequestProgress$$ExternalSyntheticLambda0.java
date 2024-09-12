package com.facebook;

import com.facebook.GraphRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RequestProgress$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ GraphRequest.Callback f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ RequestProgress$$ExternalSyntheticLambda0(GraphRequest.Callback callback, long j, long j2) {
        this.f$0 = callback;
        this.f$1 = j;
        this.f$2 = j2;
    }

    public final void run() {
        RequestProgress.m215reportProgress$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
