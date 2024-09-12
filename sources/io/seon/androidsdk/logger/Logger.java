package io.seon.androidsdk.logger;

import android.util.Log;

public class Logger {
    public static Boolean LOGGING_ENABLED = Boolean.FALSE;
    private final String TAG;
    private final int priority = 3;

    private Logger(String str) {
        this.TAG = str;
    }

    public static <T> Logger withClass(Class<T> cls) {
        return new Logger(cls.getName());
    }

    public static Logger withTag(String str) {
        return new Logger(str);
    }

    public Logger log(String str) {
        return log(str, this.priority);
    }

    public void withCause(Exception exc) {
        withCause(exc, this.priority);
    }

    public Logger log(String str, int i) {
        if (LOGGING_ENABLED.booleanValue()) {
            Log.println(i, this.TAG, str);
        }
        return this;
    }

    public void withCause(Exception exc, int i) {
        if (LOGGING_ENABLED.booleanValue()) {
            Log.println(i, this.TAG, Log.getStackTraceString(exc));
        }
    }
}
