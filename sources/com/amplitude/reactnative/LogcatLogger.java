package com.amplitude.reactnative;

import android.util.Log;
import com.amplitude.reactnative.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/amplitude/reactnative/LogcatLogger;", "Lcom/amplitude/reactnative/Logger;", "()V", "logMode", "Lcom/amplitude/reactnative/Logger$LogMode;", "getLogMode", "()Lcom/amplitude/reactnative/Logger$LogMode;", "setLogMode", "(Lcom/amplitude/reactnative/Logger$LogMode;)V", "tag", "", "debug", "", "message", "error", "info", "warn", "Companion", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidLogger.kt */
public final class LogcatLogger implements Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final LogcatLogger logger = new LogcatLogger();
    private Logger.LogMode logMode = Logger.LogMode.INFO;
    private final String tag = "Amplitude";

    public Logger.LogMode getLogMode() {
        return this.logMode;
    }

    public void setLogMode(Logger.LogMode logMode2) {
        Intrinsics.checkNotNullParameter(logMode2, "<set-?>");
        this.logMode = logMode2;
    }

    public void debug(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (getLogMode().compareTo(Logger.LogMode.DEBUG) <= 0) {
            Log.d(this.tag, str);
        }
    }

    public void error(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (getLogMode().compareTo(Logger.LogMode.ERROR) <= 0) {
            Log.e(this.tag, str);
        }
    }

    public void info(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (getLogMode().compareTo(Logger.LogMode.INFO) <= 0) {
            Log.i(this.tag, str);
        }
    }

    public void warn(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (getLogMode().compareTo(Logger.LogMode.WARN) <= 0) {
            Log.w(this.tag, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/amplitude/reactnative/LogcatLogger$Companion;", "", "()V", "logger", "Lcom/amplitude/reactnative/LogcatLogger;", "getLogger", "()Lcom/amplitude/reactnative/LogcatLogger;", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AndroidLogger.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogcatLogger getLogger() {
            return LogcatLogger.logger;
        }
    }
}
