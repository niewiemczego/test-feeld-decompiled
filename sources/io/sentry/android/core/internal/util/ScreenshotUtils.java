package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.thread.IMainThreadChecker;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ScreenshotUtils {
    private static final long CAPTURE_TIMEOUT_MS = 1000;

    public static byte[] takeScreenshot(Activity activity, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        return takeScreenshot(activity, AndroidMainThreadChecker.getInstance(), iLogger, buildInfoProvider);
    }

    public static byte[] takeScreenshot(Activity activity, IMainThreadChecker iMainThreadChecker, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        if (!isActivityValid(activity)) {
            iLogger.log(SentryLevel.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.log(SentryLevel.DEBUG, "Activity window is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            iLogger.log(SentryLevel.DEBUG, "DecorView is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View rootView = peekDecorView.getRootView();
        if (rootView == null) {
            iLogger.log(SentryLevel.DEBUG, "Root view is null, not taking screenshot.", new Object[0]);
            return null;
        } else if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            iLogger.log(SentryLevel.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
                boolean z = true;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (buildInfoProvider.getSdkInfoVersion() >= 26) {
                    HandlerThread handlerThread = new HandlerThread("SentryScreenshot");
                    handlerThread.start();
                    try {
                        Handler handler = new Handler(handlerThread.getLooper());
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        PixelCopy.request(window, createBitmap, new ScreenshotUtils$$ExternalSyntheticLambda0(atomicBoolean, countDownLatch), handler);
                        if (!countDownLatch.await(1000, TimeUnit.MILLISECONDS) || !atomicBoolean.get()) {
                            z = false;
                        }
                        handlerThread.quit();
                    } catch (Throwable th) {
                        byteArrayOutputStream.close();
                        throw th;
                    }
                    if (!z) {
                        byteArrayOutputStream.close();
                        return null;
                    }
                } else {
                    Canvas canvas = new Canvas(createBitmap);
                    if (iMainThreadChecker.isMainThread()) {
                        rootView.draw(canvas);
                        countDownLatch.countDown();
                    } else {
                        activity.runOnUiThread(new ScreenshotUtils$$ExternalSyntheticLambda1(rootView, canvas, iLogger, countDownLatch));
                    }
                    if (!countDownLatch.await(1000, TimeUnit.MILLISECONDS)) {
                        byteArrayOutputStream.close();
                        return null;
                    }
                }
                createBitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                if (byteArrayOutputStream.size() <= 0) {
                    iLogger.log(SentryLevel.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                    byteArrayOutputStream.close();
                    return null;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                iLogger.log(SentryLevel.ERROR, "Taking screenshot failed.", th2);
                return null;
            }
        }
    }

    static /* synthetic */ void lambda$takeScreenshot$0(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i) {
        atomicBoolean.set(i == 0);
        countDownLatch.countDown();
    }

    static /* synthetic */ void lambda$takeScreenshot$1(View view, Canvas canvas, ILogger iLogger, CountDownLatch countDownLatch) {
        try {
            view.draw(canvas);
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private static boolean isActivityValid(Activity activity) {
        return !activity.isFinishing() && !activity.isDestroyed();
    }
}
