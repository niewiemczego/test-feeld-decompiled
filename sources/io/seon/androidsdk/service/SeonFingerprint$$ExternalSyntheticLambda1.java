package io.seon.androidsdk.service;

import java.util.concurrent.ExecutorService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SeonFingerprint$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SeonFingerprint f$0;
    public final /* synthetic */ SeonCallback f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ ExecutorService f$3;

    public /* synthetic */ SeonFingerprint$$ExternalSyntheticLambda1(SeonFingerprint seonFingerprint, SeonCallback seonCallback, String str, ExecutorService executorService) {
        this.f$0 = seonFingerprint;
        this.f$1 = seonCallback;
        this.f$2 = str;
        this.f$3 = executorService;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
