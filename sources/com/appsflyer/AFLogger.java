package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.internal.AFb1fSDK;
import com.appsflyer.internal.AFb1xSDK;
import com.facebook.internal.AnalyticsEvents;

public class AFLogger {
    private static final long AFKeystoreWrapper = System.currentTimeMillis();

    public static void afInfoLog(String str, boolean z) {
        if (AFInAppEventType(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.10.3", valueOf(str, false));
        }
        if (z) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values("I", valueOf(str, true));
        }
    }

    private static String valueOf(String str, boolean z) {
        if (str == null) {
            str = "null";
        }
        if (z || LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return new StringBuilder("(").append(System.currentTimeMillis() - AFKeystoreWrapper).append(") [").append(Thread.currentThread().getName()).append("] ").append(str).toString();
        }
        return str;
    }

    public static void afErrorLog(String str, Throwable th, boolean z, boolean z2, boolean z3) {
        long j;
        if (str == null) {
            str = new StringBuilder().append(th.getClass().getSimpleName()).append(" at ").append(th.getStackTrace()[0].toString()).toString();
        }
        if (AFInAppEventType(LogLevel.ERROR)) {
            String valueOf = valueOf(str, false);
            if (z2) {
                Log.e("AppsFlyer_6.10.3", valueOf, th);
            } else if (z) {
                Log.d("AppsFlyer_6.10.3", valueOf);
            }
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values(th);
        if (AFb1fSDK.values != null) {
            SharedPreferences.Editor edit = AFb1xSDK.valueOf((Context) AFb1fSDK.values).edit();
            if (AFb1fSDK.values == null) {
                j = -1;
            } else {
                j = AFb1xSDK.valueOf((Context) AFb1fSDK.values).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j + 1).apply();
        }
        if (z3) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onDeepLinkingNative().values(th, str);
        }
    }

    public static void valueOf(String str) {
        if (AFInAppEventType(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.10.3", valueOf(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values(ExifInterface.LONGITUDE_WEST, valueOf(str, true));
    }

    public static void afRDLog(String str) {
        if (AFInAppEventType(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.10.3", valueOf(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, valueOf(str, true));
    }

    private static boolean AFInAppEventType(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void AFInAppEventType(String str) {
        if (!AFInAppEventParameterName()) {
            Log.d("AppsFlyer_6.10.3", valueOf(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values("F", str);
    }

    private static boolean AFInAppEventParameterName() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        afErrorLog(str, th, true, false, true);
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th) {
        afErrorLogForExcManagerOnly(str, th, false);
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th, boolean z) {
        afErrorLog(str, th, false, false, !z);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        afErrorLog(str, th, true, z, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z, boolean z2) {
        afErrorLog(str, th, true, z, z2);
    }

    @Deprecated
    public static void afErrorLog(Throwable th) {
        afErrorLogForExcManagerOnly(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, th);
    }

    public static void afWarnLog(String str) {
        valueOf(str);
    }

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int AFInAppEventType;

        private LogLevel(int i) {
            this.AFInAppEventType = i;
        }

        public final int getLevel() {
            return this.AFInAppEventType;
        }
    }

    public static void afDebugLog(String str) {
        if (AFInAppEventType(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.10.3", valueOf(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().AFVersionDeclaration().values("D", valueOf(str, true));
    }
}
