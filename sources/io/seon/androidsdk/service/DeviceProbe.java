package io.seon.androidsdk.service;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.sentry.protocol.Device;
import io.seon.androidsdk.R;
import io.seon.androidsdk.logger.Logger;
import jaredrummler.android.device.DeviceName;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DeviceProbe extends AbstractSeonProbe {
    static final String[] h = {"android_id", "build_device", "build_model", "device_name", "device_orientation", Device.JsonKeys.FREE_STORAGE, "has_proximity_sensor", "pasteboard_hash", "screen_height", "screen_width", "screen_scale", "screen_brightness", "sensor_hash", "total_storage", "gsf_id", "is_tablet"};
    private static final Logger i = Logger.withClass(DeviceProbe.class);
    private ClipboardManager a;
    private Context b;
    private SensorManager c;
    private List d;
    private int[] e;
    private DisplayMetrics f;
    private WindowManager g;

    DeviceProbe() {
    }

    /* access modifiers changed from: private */
    public String a() {
        return Settings.Secure.getString(this.b.getContentResolver(), "android_id");
    }

    /* access modifiers changed from: private */
    public String e() {
        DeviceName.b(this.b);
        String b2 = DeviceName.b();
        String str = Build.MANUFACTURER;
        return b2.startsWith(str) ? SeonUtil.a(b2) : SeonUtil.a(str) + " " + b2;
    }

    /* access modifiers changed from: private */
    public String f() {
        Activity activity;
        try {
            if (!SeonUtil.b(this.b)) {
                activity = SeonUtil.b();
                if (activity == null) {
                    return "NO ACCESS";
                }
            } else if (!SeonUtil.a(this.b)) {
                return "NO ACCESS";
            } else {
                activity = (Activity) this.b;
            }
            WindowManager windowManager = activity.getWindowManager();
            if (windowManager == null) {
                return "NOT FOUND";
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (v()) {
                int rotation = defaultDisplay.getRotation();
                if (rotation == 0) {
                    return "Landscape Left";
                }
                if (rotation == 1) {
                    return "Portrait Upside Down";
                }
                if (rotation == 2) {
                    return "Landscape Right";
                }
                if (rotation == 3) {
                    return "Portrait";
                }
            } else {
                int rotation2 = defaultDisplay.getRotation();
                return rotation2 != 0 ? rotation2 != 1 ? rotation2 != 2 ? rotation2 != 3 ? "NOT FOUND" : "Landscape Left" : "Portrait Upside Down" : "Landscape Right" : "Portrait";
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public long g() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }

    private String i() {
        if (Build.VERSION.SDK_INT < 31) {
            ClipboardManager clipboardManager = this.a;
            ClipData.Item item = null;
            ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                item = primaryClip.getItemAt(0);
            }
            return item != null ? item.getText().toString() : "";
        }
        ClipboardManager clipboardManager2 = this.a;
        return (clipboardManager2 == null || clipboardManager2.getPrimaryClipDescription() == null) ? "" : this.a.getPrimaryClipDescription().toString();
    }

    /* access modifiers changed from: private */
    public String j() {
        try {
            return SeonUtil.b(i());
        } catch (UnsupportedEncodingException | Exception | NoSuchAlgorithmException e2) {
            i.withCause(e2, 6);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int k() {
        try {
            BrightnessProcessor brightnessProcessor = new BrightnessProcessor();
            float maxScreenBrightness = brightnessProcessor.getMaxScreenBrightness(this.b, i);
            float f2 = Settings.System.getFloat(this.b.getContentResolver(), "screen_brightness", -1.0f);
            return Build.VERSION.SDK_INT <= 28 ? Double.valueOf((double) (((f2 - 1.0f) / (maxScreenBrightness - 1.0f)) * 100.0f)).intValue() : Double.valueOf(brightnessProcessor.convertBrightnessValue(f2, 1.0f, maxScreenBrightness) * 100.0d).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public float l() {
        return this.b.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    public int m() {
        if (s() == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return s().getMaximumWindowMetrics().getBounds().height();
        }
        s().getDefaultDisplay().getRealMetrics(this.f);
        return this.f.heightPixels;
    }

    /* access modifiers changed from: private */
    public int n() {
        if (s() == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return s().getMaximumWindowMetrics().getBounds().width();
        }
        s().getDefaultDisplay().getRealMetrics(this.f);
        return this.f.widthPixels;
    }

    /* access modifiers changed from: private */
    public String o() {
        List<Sensor> p = p();
        if (p == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Sensor name : p) {
            sb.append(name.getName());
        }
        try {
            return SeonUtil.b(sb.toString());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            i.withCause(e2, 6);
            return null;
        }
    }

    private List p() {
        if (this.d == null) {
            this.d = this.c.getSensorList(-1);
        }
        if (this.d.size() != 0) {
            return this.d;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public long r() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getBlockCountLong();
        } else {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getBlockCount();
        }
        return j2 * j;
    }

    private WindowManager s() {
        try {
            if (!SeonUtil.b(this.b) || this.g != null) {
                Activity b2 = SeonUtil.b();
                return b2 != null ? b2.getWindowManager() : this.g;
            }
            WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
            this.g = windowManager;
            return windowManager;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean t() {
        return this.b.getPackageManager().hasSystemFeature("android.hardware.sensor.proximity") || this.c.getDefaultSensor(8) != null;
    }

    /* access modifiers changed from: private */
    public boolean u() {
        try {
            return ((TelephonyManager) this.b.getSystemService("phone")).getPhoneType() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean v() {
        return this.b.getResources().getBoolean(R.bool.isTablet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w() {
        try {
            this.a = (ClipboardManager) this.b.getSystemService("clipboard");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer x() {
        return Integer.valueOf(a(this.c, this.e));
    }

    /* access modifiers changed from: package-private */
    public String b() {
        try {
            return Build.DEVICE;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bootstrap(android.content.Context r2) {
        /*
            r1 = this;
            r1.b = r2     // Catch:{ Exception -> 0x0027 }
            r2 = 0
            r1.a = r2     // Catch:{ Exception -> 0x0027 }
            io.seon.androidsdk.service.DeviceProbe$$ExternalSyntheticLambda0 r2 = new io.seon.androidsdk.service.DeviceProbe$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x000d }
            r2.<init>(r1)     // Catch:{ Exception -> 0x000d }
            io.seon.androidsdk.service.SeonUtil.b((java.lang.Runnable) r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            android.content.Context r2 = r1.b     // Catch:{ Exception -> 0x0027 }
            java.lang.String r0 = "sensor"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x0027 }
            android.hardware.SensorManager r2 = (android.hardware.SensorManager) r2     // Catch:{ Exception -> 0x0027 }
            r1.c = r2     // Catch:{ Exception -> 0x0027 }
            int[] r2 = r1.q()     // Catch:{ Exception -> 0x0027 }
            r1.e = r2     // Catch:{ Exception -> 0x0027 }
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0027 }
            r2.<init>()     // Catch:{ Exception -> 0x0027 }
            r1.f = r2     // Catch:{ Exception -> 0x0027 }
            goto L_0x002d
        L_0x0027:
            r2 = move-exception
            io.seon.androidsdk.logger.Logger r0 = i
            r0.withCause(r2)
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.DeviceProbe.bootstrap(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public String c() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList d() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(e());
            arrayList.add(DeviceName.a(this.b).c);
            arrayList.add(DeviceName.a(this.b).b);
            arrayList.add(DeviceName.a(this.b).d);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("sensors_bitmask", safeGet(new DeviceProbe$$ExternalSyntheticLambda9(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h() {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "content://com.google.android.gsf.gservices"
            android.net.Uri r3 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "android_id"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0044 }
            android.content.Context r1 = r8.b     // Catch:{ Exception -> 0x0044 }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x0044 }
            r4 = 0
            r5 = 0
            r7 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x001d
            return r0
        L_0x001d:
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0044 }
            if (r2 == 0) goto L_0x0040
            int r2 = r1.getColumnCount()     // Catch:{ Exception -> 0x0044 }
            r3 = 2
            if (r2 >= r3) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ NumberFormatException -> 0x003c }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x003c }
            java.lang.String r2 = java.lang.Long.toHexString(r2)     // Catch:{ NumberFormatException -> 0x003c }
            r1.close()     // Catch:{ NumberFormatException -> 0x003c }
            return r2
        L_0x003c:
            r1.close()     // Catch:{ Exception -> 0x0044 }
            return r0
        L_0x0040:
            r1.close()     // Catch:{ Exception -> 0x0044 }
            return r0
        L_0x0044:
            r1 = move-exception
            io.seon.androidsdk.logger.Logger r2 = i
            r3 = 5
            r2.withCause(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.DeviceProbe.h():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public int[] q() {
        int[] iArr = new int[27];
        iArr[0] = 1;
        iArr[1] = 2;
        iArr[2] = 4;
        iArr[3] = 5;
        iArr[4] = 6;
        iArr[5] = 8;
        iArr[6] = 9;
        iArr[7] = 10;
        iArr[8] = 11;
        iArr[9] = 12;
        iArr[10] = 13;
        iArr[11] = 14;
        iArr[12] = 15;
        iArr[13] = 16;
        iArr[14] = 17;
        iArr[15] = 18;
        iArr[16] = 19;
        iArr[17] = 20;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            iArr[18] = 21;
        }
        if (i2 >= 24) {
            iArr[19] = 28;
            iArr[20] = 29;
            iArr[21] = 30;
            iArr[22] = 31;
            iArr[23] = 65536;
        }
        if (i2 >= 26) {
            iArr[24] = 34;
            iArr[25] = 35;
        }
        if (i2 >= 30) {
            iArr[26] = 36;
        }
        return iArr;
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("android_id", safeGet(new DeviceProbe$$ExternalSyntheticLambda10(this)));
        hashMap.put("build_device", safeGet(new DeviceProbe$$ExternalSyntheticLambda17(this)));
        hashMap.put("build_model", safeGet(new DeviceProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("device_name", safeGet(new DeviceProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("device_orientation", safeGet(new DeviceProbe$$ExternalSyntheticLambda3(this)));
        hashMap.put(Device.JsonKeys.FREE_STORAGE, safeGet(new DeviceProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("has_proximity_sensor", safeGet(new DeviceProbe$$ExternalSyntheticLambda5(this)));
        hashMap.put("pasteboard_hash", safeGet(new DeviceProbe$$ExternalSyntheticLambda6(this)));
        hashMap.put("screen_height", safeGet(new DeviceProbe$$ExternalSyntheticLambda7(this)));
        hashMap.put("screen_width", safeGet(new DeviceProbe$$ExternalSyntheticLambda8(this)));
        hashMap.put("screen_scale", safeGet(new DeviceProbe$$ExternalSyntheticLambda11(this)));
        hashMap.put("screen_brightness", safeGet(new DeviceProbe$$ExternalSyntheticLambda12(this)));
        hashMap.put("sensor_hash", safeGet(new DeviceProbe$$ExternalSyntheticLambda13(this)));
        hashMap.put("total_storage", safeGet(new DeviceProbe$$ExternalSyntheticLambda14(this)));
        hashMap.put("gsf_id", safeGet(new DeviceProbe$$ExternalSyntheticLambda15(this)));
        hashMap.put("is_tablet", safeGet(new DeviceProbe$$ExternalSyntheticLambda16(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public int a(SensorManager sensorManager, int[] iArr) {
        if (sensorManager == null || iArr == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (sensorManager.getDefaultSensor(iArr[i3]) != null) {
                i2 |= 1 << i3;
            }
        }
        return i2;
    }
}
