package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class ContextUtils {

    static class SideLoadedInfo {
        private final String installerStore;
        private final boolean isSideLoaded;

        public SideLoadedInfo(boolean z, String str) {
            this.isSideLoaded = z;
            this.installerStore = str;
        }

        public boolean isSideLoaded() {
            return this.isSideLoaded;
        }

        public String getInstallerStore() {
            return this.installerStore;
        }

        public Map<String, String> asTags() {
            HashMap hashMap = new HashMap();
            hashMap.put("isSideLoaded", String.valueOf(this.isSideLoaded));
            String str = this.installerStore;
            if (str != null) {
                hashMap.put("installerStore", str);
            }
            return hashMap;
        }
    }

    private ContextUtils() {
    }

    static PackageInfo getPackageInfo(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        return getPackageInfo(context, 0, iLogger, buildInfoProvider);
    }

    static PackageInfo getPackageInfo(Context context, int i, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        try {
            if (buildInfoProvider.getSdkInfoVersion() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of((long) i));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    static ApplicationInfo getApplicationInfo(Context context, long j, BuildInfoProvider buildInfoProvider) throws PackageManager.NameNotFoundException {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(j));
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
    }

    static String getVersionCode(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return getVersionCodeDep(packageInfo);
    }

    static String getVersionName(PackageInfo packageInfo) {
        return packageInfo.versionName;
    }

    private static String getVersionCodeDep(PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }

    public static boolean isForegroundImportance() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    static String getKernelVersion(ILogger iLogger) {
        BufferedReader bufferedReader;
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (IOException e) {
            iLogger.log(SentryLevel.ERROR, "Exception while attempting to read kernel information", (Throwable) e);
            return property;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static SideLoadedInfo retrieveSideLoadedInfo(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        String str;
        try {
            PackageInfo packageInfo = getPackageInfo(context, iLogger, buildInfoProvider);
            PackageManager packageManager = context.getPackageManager();
            if (!(packageInfo == null || packageManager == null)) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    return new SideLoadedInfo(installerPackageName == null, installerPackageName);
                } catch (IllegalArgumentException unused) {
                    iLogger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
            iLogger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
            return null;
        }
        return null;
    }

    static String getApplicationName(Context context, ILogger iLogger) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i != 0) {
                return context.getString(i);
            }
            if (applicationInfo.nonLocalizedLabel != null) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting application name.", th);
            return null;
        }
    }

    static DisplayMetrics getDisplayMetrics(Context context, ILogger iLogger) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", th);
            return null;
        }
    }

    static String getFamily(ILogger iLogger) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    static String getDeviceName(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "device_name");
    }

    static String[] getArchitectures(BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    static ActivityManager.MemoryInfo getMemInfo(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            iLogger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    static Intent registerReceiver(Context context, SentryOptions sentryOptions, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return registerReceiver(context, new BuildInfoProvider(sentryOptions.getLogger()), broadcastReceiver, intentFilter);
    }

    static Intent registerReceiver(Context context, BuildInfoProvider buildInfoProvider, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (buildInfoProvider.getSdkInfoVersion() >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }

    static void setAppPackageInfo(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider, App app2) {
        app2.setAppIdentifier(packageInfo.packageName);
        app2.setAppVersion(packageInfo.versionName);
        app2.setAppBuild(getVersionCode(packageInfo, buildInfoProvider));
        HashMap hashMap = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                boolean z = true;
                String substring = str.substring(str.lastIndexOf(46) + 1);
                if ((iArr[i] & 2) != 2) {
                    z = false;
                }
                hashMap.put(substring, z ? PermissionsResponse.GRANTED_KEY : "not_granted");
            }
        }
        app2.setPermissions(hashMap);
    }
}
