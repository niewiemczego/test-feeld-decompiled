package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.react.R;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getInspectorProxyHost(Context context) {
        return getServerIpAddress(getInspectorProxyPort(context).intValue());
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static Integer getInspectorProxyPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static String getServerIpAddress(int i) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = GENYMOTION_LOCALHOST;
            } else {
                metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
            }
        }
        return String.format(Locale.US, "%s:%d", new Object[]{metroHostPropValue2, Integer.valueOf(i)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1 = metroHostPropValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065 A[SYNTHETIC, Splitter:B:36:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0072 A[SYNTHETIC, Splitter:B:46:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0077 A[SYNTHETIC, Splitter:B:50:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String getMetroHostPropValue() {
        /*
            java.lang.Class<com.facebook.react.modules.systeminfo.AndroidInfoHelpers> r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.class
            monitor-enter(r0)
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            java.lang.String r3 = "/system/bin/getprop"
            java.lang.String r4 = "metro.host"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.lang.String r1 = ""
        L_0x0030:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x0043 }
            if (r4 == 0) goto L_0x0038
            r1 = r4
            goto L_0x0030
        L_0x0038:
            metroHostPropValue = r1     // Catch:{ Exception -> 0x0043 }
            r3.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            if (r2 == 0) goto L_0x006b
        L_0x003f:
            r2.destroy()     // Catch:{ all -> 0x007b }
            goto L_0x006b
        L_0x0043:
            r1 = move-exception
            goto L_0x0058
        L_0x0045:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0070
        L_0x004a:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0058
        L_0x004f:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x0070
        L_0x0054:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L_0x0058:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.w((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = ""
            metroHostPropValue = r1     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x0068
            r3.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            if (r2 == 0) goto L_0x006b
            goto L_0x003f
        L_0x006b:
            java.lang.String r1 = metroHostPropValue     // Catch:{ all -> 0x007b }
            monitor-exit(r0)
            return r1
        L_0x006f:
            r1 = move-exception
        L_0x0070:
            if (r3 == 0) goto L_0x0075
            r3.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.destroy()     // Catch:{ all -> 0x007b }
        L_0x007a:
            throw r1     // Catch:{ all -> 0x007b }
        L_0x007b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoHelpers.getMetroHostPropValue():java.lang.String");
    }
}
