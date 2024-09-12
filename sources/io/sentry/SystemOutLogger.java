package io.sentry;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class SystemOutLogger implements ILogger {
    public boolean isEnabled(SentryLevel sentryLevel) {
        return true;
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        System.out.println(String.format("%s: %s", new Object[]{sentryLevel, String.format(str, objArr)}));
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        if (th == null) {
            log(sentryLevel, str, new Object[0]);
            return;
        }
        System.out.println(String.format("%s: %s\n%s", new Object[]{sentryLevel, String.format(str, new Object[]{th.toString()}), captureStackTrace(th)}));
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        if (th == null) {
            log(sentryLevel, str, objArr);
            return;
        }
        System.out.println(String.format("%s: %s \n %s\n%s", new Object[]{sentryLevel, String.format(str, objArr), th.toString(), captureStackTrace(th)}));
    }

    private String captureStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
