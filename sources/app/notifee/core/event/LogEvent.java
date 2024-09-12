package app.notifee.core.event;

public class LogEvent {
    public static final String LEVEL_DEBUG = "debug";
    public static final String LEVEL_ERROR = "error";
    public static final String LEVEL_INFO = "info";
    public static final String LEVEL_VERBOSE = "verbose";
    public static final String LEVEL_WARN = "warn";
    public final String a;
    public final String b;
    public final String c;
    public final Throwable d;

    public LogEvent(String str, String str2, String str3) {
        this.a = str2;
        this.b = str;
        this.c = str3;
        this.d = null;
    }

    public String getLevel() {
        return this.b;
    }

    public String getMessage() {
        return this.c;
    }

    public String getTag() {
        return this.a;
    }

    public Throwable getThrowable() {
        return this.d;
    }

    public LogEvent(String str, String str2, String str3, Throwable th) {
        this.a = str2;
        this.b = str;
        this.c = str3;
        this.d = th;
    }
}
