package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

public final class AndroidLogger implements ILogger {
    private final String tag;

    public boolean isEnabled(SentryLevel sentryLevel) {
        return true;
    }

    public AndroidLogger() {
        this("Sentry");
    }

    public AndroidLogger(String str) {
        this.tag = str;
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        Log.println(toLogcatLevel(sentryLevel), this.tag, String.format(str, objArr));
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        log(sentryLevel, String.format(str, objArr), th);
    }

    /* renamed from: io.sentry.android.core.AndroidLogger$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$SentryLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.sentry.SentryLevel[] r0 = io.sentry.SentryLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$SentryLevel = r0
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.FATAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$sentry$SentryLevel     // Catch:{ NoSuchFieldError -> 0x003e }
                io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.AndroidLogger.AnonymousClass1.<clinit>():void");
        }
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$SentryLevel[sentryLevel.ordinal()];
        if (i == 1) {
            Log.i(this.tag, str, th);
        } else if (i == 2) {
            Log.w(this.tag, str, th);
        } else if (i == 3) {
            Log.e(this.tag, str, th);
        } else if (i != 4) {
            Log.d(this.tag, str, th);
        } else {
            Log.wtf(this.tag, str, th);
        }
    }

    private int toLogcatLevel(SentryLevel sentryLevel) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$SentryLevel[sentryLevel.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return i != 4 ? 3 : 7;
        }
        return 5;
    }
}
