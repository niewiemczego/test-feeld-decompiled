package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.amplitude.reactnative.AndroidContextProvider;
import io.sentry.DateUtils;
import io.sentry.SentryLevel;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.internal.util.CpuInfoUtils;
import io.sentry.android.core.internal.util.DeviceOrientations;
import io.sentry.android.core.internal.util.RootChecker;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class DeviceInfoUtil {
    private static volatile DeviceInfoUtil instance;
    private final BuildInfoProvider buildInfoProvider;
    private final Context context;
    private final Boolean isEmulator;
    private final SentryAndroidOptions options;
    private final OperatingSystem os = retrieveOperatingSystemInformation();
    private final ContextUtils.SideLoadedInfo sideLoadedInfo;
    private final Long totalMem;

    public DeviceInfoUtil(Context context2, SentryAndroidOptions sentryAndroidOptions) {
        this.context = context2;
        this.options = sentryAndroidOptions;
        BuildInfoProvider buildInfoProvider2 = new BuildInfoProvider(sentryAndroidOptions.getLogger());
        this.buildInfoProvider = buildInfoProvider2;
        CpuInfoUtils.getInstance().readMaxFrequencies();
        this.isEmulator = buildInfoProvider2.isEmulator();
        this.sideLoadedInfo = ContextUtils.retrieveSideLoadedInfo(context2, sentryAndroidOptions.getLogger(), buildInfoProvider2);
        ActivityManager.MemoryInfo memInfo = ContextUtils.getMemInfo(context2, sentryAndroidOptions.getLogger());
        if (memInfo != null) {
            this.totalMem = Long.valueOf(memInfo.totalMem);
        } else {
            this.totalMem = null;
        }
    }

    public static DeviceInfoUtil getInstance(Context context2, SentryAndroidOptions sentryAndroidOptions) {
        if (instance == null) {
            synchronized (DeviceInfoUtil.class) {
                if (instance == null) {
                    instance = new DeviceInfoUtil(context2.getApplicationContext(), sentryAndroidOptions);
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    public Device collectDeviceInformation(boolean z, boolean z2) {
        Device device = new Device();
        if (this.options.isSendDefaultPii()) {
            device.setName(ContextUtils.getDeviceName(this.context));
        }
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(ContextUtils.getFamily(this.options.getLogger()));
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        device.setArchs(ContextUtils.getArchitectures(this.buildInfoProvider));
        device.setOrientation(getOrientation());
        Boolean bool = this.isEmulator;
        if (bool != null) {
            device.setSimulator(bool);
        }
        DisplayMetrics displayMetrics = ContextUtils.getDisplayMetrics(this.context, this.options.getLogger());
        if (displayMetrics != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetrics.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetrics.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetrics.density));
            device.setScreenDpi(Integer.valueOf(displayMetrics.densityDpi));
        }
        device.setBootTime(getBootTime());
        device.setTimezone(getTimeZone());
        if (device.getId() == null) {
            device.setId(getDeviceId());
        }
        Locale locale = Locale.getDefault();
        if (device.getLanguage() == null) {
            device.setLanguage(locale.getLanguage());
        }
        if (device.getLocale() == null) {
            device.setLocale(locale.toString());
        }
        List<Integer> readMaxFrequencies = CpuInfoUtils.getInstance().readMaxFrequencies();
        if (!readMaxFrequencies.isEmpty()) {
            device.setProcessorFrequency(Double.valueOf(((Integer) Collections.max(readMaxFrequencies)).doubleValue()));
            device.setProcessorCount(Integer.valueOf(readMaxFrequencies.size()));
        }
        device.setMemorySize(this.totalMem);
        if (z && this.options.isCollectAdditionalContext()) {
            setDeviceIO(device, z2);
        }
        return device;
    }

    public OperatingSystem getOperatingSystem() {
        return this.os;
    }

    /* access modifiers changed from: protected */
    public OperatingSystem retrieveOperatingSystemInformation() {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setName(AndroidContextProvider.PLATFORM);
        operatingSystem.setVersion(Build.VERSION.RELEASE);
        operatingSystem.setBuild(Build.DISPLAY);
        String kernelVersion = ContextUtils.getKernelVersion(this.options.getLogger());
        if (kernelVersion != null) {
            operatingSystem.setKernelVersion(kernelVersion);
        }
        if (this.options.isEnableRootCheck()) {
            operatingSystem.setRooted(Boolean.valueOf(new RootChecker(this.context, this.buildInfoProvider, this.options.getLogger()).isDeviceRooted()));
        }
        return operatingSystem;
    }

    public ContextUtils.SideLoadedInfo getSideLoadedInfo() {
        return this.sideLoadedInfo;
    }

    private void setDeviceIO(Device device, boolean z) {
        boolean z2;
        Intent batteryIntent = getBatteryIntent();
        if (batteryIntent != null) {
            device.setBatteryLevel(getBatteryLevel(batteryIntent));
            device.setCharging(isCharging(batteryIntent));
            device.setBatteryTemperature(getBatteryTemperature(batteryIntent));
        }
        int i = AnonymousClass1.$SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus[this.options.getConnectionStatusProvider().getConnectionStatus().ordinal()];
        if (i == 1) {
            z2 = false;
        } else if (i != 2) {
            z2 = null;
        } else {
            z2 = true;
        }
        device.setOnline(z2);
        ActivityManager.MemoryInfo memInfo = ContextUtils.getMemInfo(this.context, this.options.getLogger());
        if (memInfo != null && z) {
            device.setFreeMemory(Long.valueOf(memInfo.availMem));
            device.setLowMemory(Boolean.valueOf(memInfo.lowMemory));
        }
        File externalFilesDir = this.context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.setStorageSize(getTotalInternalStorage(statFs));
            device.setFreeStorage(getUnusedInternalStorage(statFs));
        }
        StatFs externalStorageStat = getExternalStorageStat(externalFilesDir);
        if (externalStorageStat != null) {
            device.setExternalStorageSize(getTotalExternalStorage(externalStorageStat));
            device.setExternalFreeStorage(getUnusedExternalStorage(externalStorageStat));
        }
        if (device.getConnectionType() == null) {
            device.setConnectionType(this.options.getConnectionStatusProvider().getConnectionType());
        }
    }

    /* renamed from: io.sentry.android.core.DeviceInfoUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.sentry.IConnectionStatusProvider$ConnectionStatus[] r0 = io.sentry.IConnectionStatusProvider.ConnectionStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus = r0
                io.sentry.IConnectionStatusProvider$ConnectionStatus r1 = io.sentry.IConnectionStatusProvider.ConnectionStatus.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$IConnectionStatusProvider$ConnectionStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.IConnectionStatusProvider$ConnectionStatus r1 = io.sentry.IConnectionStatusProvider.ConnectionStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DeviceInfoUtil.AnonymousClass1.<clinit>():void");
        }
    }

    private TimeZone getTimeZone() {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 24) {
            LocaleList locales = this.context.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Date getBootTime() {
        try {
            return DateUtils.getDateTime(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e) {
            this.options.getLogger().log(SentryLevel.ERROR, e, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private Intent getBatteryIntent() {
        return ContextUtils.registerReceiver(this.context, this.buildInfoProvider, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private Float getBatteryLevel(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1) {
                if (intExtra2 != -1) {
                    return Float.valueOf((((float) intExtra) / ((float) intExtra2)) * 100.0f);
                }
            }
            return null;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    private Boolean isCharging(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1) {
                if (intExtra != 2) {
                    z = false;
                }
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    private Float getBatteryTemperature(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(((float) intExtra) / 10.0f);
            }
            return null;
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting battery temperature.", th);
            return null;
        }
    }

    private Device.DeviceOrientation getOrientation() {
        Device.DeviceOrientation deviceOrientation;
        Throwable th;
        try {
            deviceOrientation = DeviceOrientations.getOrientation(this.context.getResources().getConfiguration().orientation);
            if (deviceOrientation == null) {
                try {
                    this.options.getLogger().log(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    this.options.getLogger().log(SentryLevel.ERROR, "Error getting device orientation.", th);
                    return deviceOrientation;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            deviceOrientation = null;
            th = th4;
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting device orientation.", th);
            return deviceOrientation;
        }
        return deviceOrientation;
    }

    private Long getTotalInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting total internal storage amount.", th);
            return null;
        }
    }

    private Long getUnusedInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting unused internal storage amount.", th);
            return null;
        }
    }

    private StatFs getExternalStorageStat(File file) {
        if (!isExternalStorageMounted()) {
            File externalStorageDep = getExternalStorageDep(file);
            if (externalStorageDep != null) {
                return new StatFs(externalStorageDep.getPath());
            }
            this.options.getLogger().log(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
        this.options.getLogger().log(SentryLevel.INFO, "External storage is not mounted or emulated.", new Object[0]);
        return null;
    }

    private File getExternalStorageDep(File file) {
        File[] externalFilesDirs = this.context.getExternalFilesDirs((String) null);
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.options.getLogger().log(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private Long getTotalExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting total external storage amount.", th);
            return null;
        }
    }

    private boolean isExternalStorageMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    private Long getUnusedExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting unused external storage amount.", th);
            return null;
        }
    }

    private String getDeviceId() {
        try {
            return Installation.id(this.context);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting installationId.", th);
            return null;
        }
    }
}
