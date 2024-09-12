package io.sentry.react;

import android.app.Activity;
import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ byte[][] f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ CountDownLatch f$2;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda6(byte[][] bArr, Activity activity, CountDownLatch countDownLatch) {
        this.f$0 = bArr;
        this.f$1 = activity;
        this.f$2 = countDownLatch;
    }

    public final void run() {
        RNSentryModuleImpl.lambda$takeScreenshotOnUiThread$3(this.f$0, this.f$1, this.f$2);
    }
}
