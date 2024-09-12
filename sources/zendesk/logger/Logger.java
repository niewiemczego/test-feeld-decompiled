package zendesk.logger;

import android.os.Build;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Logger {
    private static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final List<LogReceiver> USER_DEFINED_RECEIVERS = new ArrayList();
    /* access modifiers changed from: private */
    public static final TimeZone UTC_TIMEZONE = TimeZone.getTimeZone("UTC");
    private static boolean loggable = false;
    private static LogReceiver platformLogger;

    public interface LogReceiver {
        void log(Priority priority, String str, String str2, Throwable th);
    }

    static {
        platformLogger = new Java();
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                platformLogger = new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    public enum Priority {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        /* access modifiers changed from: private */
        public final int priority;

        private Priority(int i) {
            this.priority = i;
        }
    }

    private Logger() {
    }

    public static boolean isLoggable() {
        return loggable;
    }

    public static void setLoggable(boolean z) {
        loggable = z;
    }

    public static void addLogReceiver(LogReceiver logReceiver) {
        if (logReceiver != null) {
            USER_DEFINED_RECEIVERS.add(logReceiver);
        }
    }

    public static void removeAllLogReceiver() {
        USER_DEFINED_RECEIVERS.clear();
    }

    public static void w(String str, String str2, Object... objArr) {
        logInternal(Priority.WARN, str, str2, (Throwable) null, objArr);
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        logInternal(Priority.WARN, str, str2, th, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        logInternal(Priority.ERROR, str, str2, (Throwable) null, objArr);
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        logInternal(Priority.ERROR, str, str2, th, objArr);
    }

    public static void v(String str, String str2, Object... objArr) {
        logInternal(Priority.VERBOSE, str, str2, (Throwable) null, objArr);
    }

    public static void v(String str, String str2, Throwable th, Object... objArr) {
        logInternal(Priority.VERBOSE, str, str2, th, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        logInternal(Priority.INFO, str, str2, (Throwable) null, objArr);
    }

    public static void i(String str, String str2, Throwable th, Object... objArr) {
        logInternal(Priority.INFO, str, str2, th, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        logInternal(Priority.DEBUG, str, str2, (Throwable) null, objArr);
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        logInternal(Priority.DEBUG, str, str2, th, objArr);
    }

    private static void logInternal(Priority priority, String str, String str2, Throwable th, Object... objArr) {
        if (loggable) {
            if (str2 == null) {
                str2 = "";
            }
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(Locale.US, str2, objArr);
            }
            platformLogger.log(priority, str, str2, th);
            for (LogReceiver log : USER_DEFINED_RECEIVERS) {
                log.log(priority, str, str2, th);
            }
        }
    }

    static class Java implements LogReceiver {
        Java() {
        }

        public void log(Priority priority, String str, String str2, Throwable th) {
            char c;
            StringBuilder sb = new StringBuilder(100);
            StringBuilder append = sb.append("[").append(new SimpleDateFormat(Logger.ISO_8601_FORMAT, Locale.US).format(new Date())).append("]").append(" ");
            if (priority == null) {
                c = LoggerHelper.getLevelFromPriority(Priority.INFO.priority);
            } else {
                c = LoggerHelper.getLevelFromPriority(priority.priority);
            }
            StringBuilder append2 = append.append(c).append("/");
            if (!StringUtils.hasLength(str)) {
                str = "UNKNOWN";
            }
            append2.append(str).append(": ").append(str2);
            System.out.println(sb.toString());
            if (th != null) {
                th.printStackTrace(System.out);
            }
        }
    }

    static class Android implements LogReceiver {
        private static final int MAX_LINE_LENGTH = 4000;

        Android() {
        }

        public void log(Priority priority, String str, String str2, Throwable th) {
            String androidTag = LoggerHelper.getAndroidTag(str);
            StringBuilder sb = new StringBuilder(str2.length());
            if (Priority.ERROR == priority) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Logger.ISO_8601_FORMAT, Locale.US);
                simpleDateFormat.setTimeZone(Logger.UTC_TIMEZONE);
                sb.append("[UTC ").append(simpleDateFormat.format(new Date())).append("] ");
            }
            sb.append(str2);
            if (th != null) {
                sb.append(StringUtils.LINE_SEPARATOR).append(Log.getStackTraceString(th));
            }
            for (String println : LoggerHelper.splitLogMessage(sb.toString(), MAX_LINE_LENGTH)) {
                Log.println(priority == null ? Priority.INFO.priority : priority.priority, androidTag, println);
            }
        }
    }
}
