package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    private Logging() {
    }

    private static String getTag(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return concatTag(LOG_PREFIX, str);
        }
        return LOG_PREFIX + str;
    }

    private static String concatTag(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    public static void d(String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, str2);
        }
    }

    public static void d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, new Object[]{obj}));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, new Object[]{obj, obj2}));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format(str2, new Object[]{obj}));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, th);
        }
    }

    public static void w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            Log.w(tag, String.format(str2, new Object[]{obj}));
        }
    }
}
