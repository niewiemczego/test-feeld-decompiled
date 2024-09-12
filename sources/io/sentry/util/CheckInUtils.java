package io.sentry.util;

import io.sentry.MonitorConfig;
import java.util.List;
import java.util.concurrent.Callable;

public final class CheckInUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r4 = new io.sentry.CheckIn(r6, r5, io.sentry.CheckInStatus.ERROR);
        r4.setDuration(java.lang.Double.valueOf(io.sentry.DateUtils.millisToSeconds((double) (java.lang.System.currentTimeMillis() - r1))));
        r0.captureCheckIn(r4);
        r0.popScope();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0062, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <U> U withCheckIn(java.lang.String r5, io.sentry.MonitorConfig r6, java.util.concurrent.Callable<U> r7) throws java.lang.Exception {
        /*
            io.sentry.IHub r0 = io.sentry.Sentry.getCurrentHub()
            long r1 = java.lang.System.currentTimeMillis()
            r0.pushScope()
            io.sentry.util.TracingUtils.startNewTrace(r0)
            io.sentry.CheckIn r3 = new io.sentry.CheckIn
            io.sentry.CheckInStatus r4 = io.sentry.CheckInStatus.IN_PROGRESS
            r3.<init>(r5, r4)
            if (r6 == 0) goto L_0x001a
            r3.setMonitorConfig(r6)
        L_0x001a:
            io.sentry.protocol.SentryId r6 = r0.captureCheckIn(r3)
            java.lang.Object r7 = r7.call()     // Catch:{ all -> 0x0041 }
            io.sentry.CheckInStatus r3 = io.sentry.CheckInStatus.OK
            io.sentry.CheckIn r4 = new io.sentry.CheckIn
            r4.<init>((io.sentry.protocol.SentryId) r6, (java.lang.String) r5, (io.sentry.CheckInStatus) r3)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            double r5 = (double) r5
            double r5 = io.sentry.DateUtils.millisToSeconds(r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r4.setDuration(r5)
            r0.captureCheckIn(r4)
            r0.popScope()
            return r7
        L_0x0041:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r7 = move-exception
            io.sentry.CheckInStatus r3 = io.sentry.CheckInStatus.ERROR
            io.sentry.CheckIn r4 = new io.sentry.CheckIn
            r4.<init>((io.sentry.protocol.SentryId) r6, (java.lang.String) r5, (io.sentry.CheckInStatus) r3)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            double r5 = (double) r5
            double r5 = io.sentry.DateUtils.millisToSeconds(r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r4.setDuration(r5)
            r0.captureCheckIn(r4)
            r0.popScope()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.util.CheckInUtils.withCheckIn(java.lang.String, io.sentry.MonitorConfig, java.util.concurrent.Callable):java.lang.Object");
    }

    public static <U> U withCheckIn(String str, Callable<U> callable) throws Exception {
        return withCheckIn(str, (MonitorConfig) null, callable);
    }

    public static boolean isIgnored(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (String next : list) {
                if (next.equalsIgnoreCase(str)) {
                    return true;
                }
                try {
                    if (str.matches(next)) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }
}
