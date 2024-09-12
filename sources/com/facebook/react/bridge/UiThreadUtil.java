package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;

public class UiThreadUtil {
    private static Handler sMainHandler;

    public static void assertNotOnUiThread() {
    }

    public static void assertOnUiThread() {
    }

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        synchronized (UiThreadUtil.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.postDelayed(runnable, j);
    }
}
