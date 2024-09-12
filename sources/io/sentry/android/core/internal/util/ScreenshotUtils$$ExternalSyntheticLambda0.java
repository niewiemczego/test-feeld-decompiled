package io.sentry.android.core.internal.util;

import android.view.PixelCopy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScreenshotUtils$$ExternalSyntheticLambda0 implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ CountDownLatch f$1;

    public /* synthetic */ ScreenshotUtils$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        this.f$0 = atomicBoolean;
        this.f$1 = countDownLatch;
    }

    public final void onPixelCopyFinished(int i) {
        ScreenshotUtils.lambda$takeScreenshot$0(this.f$0, this.f$1, i);
    }
}
