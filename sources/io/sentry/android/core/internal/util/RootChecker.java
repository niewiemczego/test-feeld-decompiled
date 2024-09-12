package io.sentry.android.core.internal.util;

import android.content.Context;
import android.content.pm.PackageManager;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.Objects;
import java.io.File;
import java.nio.charset.Charset;

public final class RootChecker {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final BuildInfoProvider buildInfoProvider;
    private final Context context;
    private final ILogger logger;
    private final String[] rootFiles;
    private final String[] rootPackages;
    private final Runtime runtime;

    public RootChecker(Context context2, BuildInfoProvider buildInfoProvider2, ILogger iLogger) {
        this(context2, buildInfoProvider2, iLogger, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    RootChecker(Context context2, BuildInfoProvider buildInfoProvider2, ILogger iLogger, String[] strArr, String[] strArr2, Runtime runtime2) {
        this.context = (Context) Objects.requireNonNull(context2, "The application context is required.");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "The BuildInfoProvider is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "The Logger is required.");
        this.rootFiles = (String[]) Objects.requireNonNull(strArr, "The root Files are required.");
        this.rootPackages = (String[]) Objects.requireNonNull(strArr2, "The root packages are required.");
        this.runtime = (Runtime) Objects.requireNonNull(runtime2, "The Runtime is required.");
    }

    public boolean isDeviceRooted() {
        return checkTestKeys() || checkRootFiles() || checkSUExist() || checkRootPackages(this.logger);
    }

    private boolean checkTestKeys() {
        String buildTags = this.buildInfoProvider.getBuildTags();
        return buildTags != null && buildTags.contains("test-keys");
    }

    private boolean checkRootFiles() {
        String[] strArr = this.rootFiles;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                if (new File(str).exists()) {
                    return true;
                }
                i++;
            } catch (RuntimeException e) {
                this.logger.log(SentryLevel.ERROR, e, "Error when trying to check if root file %s exists.", str);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
        if (r2 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkSUExist() {
        /*
            r6 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r6.runtime     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.lang.Process r2 = r3.exec(r0)     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.nio.charset.Charset r5 = UTF_8     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            r0.<init>(r3)     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = r1
        L_0x0029:
            r0.close()     // Catch:{ IOException -> 0x004c, all -> 0x003c }
            if (r2 == 0) goto L_0x0031
            r2.destroy()
        L_0x0031:
            return r3
        L_0x0032:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ IOException -> 0x004c, all -> 0x003c }
        L_0x003b:
            throw r3     // Catch:{ IOException -> 0x004c, all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            io.sentry.ILogger r3 = r6.logger     // Catch:{ all -> 0x005b }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x005b }
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.log((io.sentry.SentryLevel) r4, (java.lang.String) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x005a
        L_0x0048:
            r2.destroy()
            goto L_0x005a
        L_0x004c:
            io.sentry.ILogger r0 = r6.logger     // Catch:{ all -> 0x005b }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x005b }
            r0.log((io.sentry.SentryLevel) r3, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x005a
            goto L_0x0048
        L_0x005a:
            return r1
        L_0x005b:
            r0 = move-exception
            if (r2 == 0) goto L_0x0061
            r2.destroy()
        L_0x0061:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.RootChecker.checkSUExist():boolean");
    }

    private boolean checkRootPackages(ILogger iLogger) {
        BuildInfoProvider buildInfoProvider2 = new BuildInfoProvider(iLogger);
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager != null) {
            String[] strArr = this.rootPackages;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                try {
                    if (buildInfoProvider2.getSdkInfoVersion() >= 33) {
                        packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0));
                        return true;
                    }
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                    i++;
                }
            }
        }
        return false;
    }
}
