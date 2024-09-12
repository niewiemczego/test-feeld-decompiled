package io.sentry.android.core.internal.util;

import android.graphics.Canvas;
import android.view.View;
import io.sentry.ILogger;
import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ScreenshotUtils$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ Canvas f$1;
    public final /* synthetic */ ILogger f$2;
    public final /* synthetic */ CountDownLatch f$3;

    public /* synthetic */ ScreenshotUtils$$ExternalSyntheticLambda1(View view, Canvas canvas, ILogger iLogger, CountDownLatch countDownLatch) {
        this.f$0 = view;
        this.f$1 = canvas;
        this.f$2 = iLogger;
        this.f$3 = countDownLatch;
    }

    public final void run() {
        ScreenshotUtils.lambda$takeScreenshot$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
