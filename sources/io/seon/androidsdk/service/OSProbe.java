package io.seon.androidsdk.service;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.scottyab.rootbeer.RootBeer;
import io.sentry.protocol.OperatingSystem;
import io.seon.androidsdk.logger.Logger;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class OSProbe extends AbstractSeonProbe {
    static final String[] i = {"android_version", "is_rooted", "kernel_arch", "kernel_name", OperatingSystem.JsonKeys.KERNEL_VERSION, "usb_cable_state", "usb_debugging_state", "bootloader_state", "developer_options_state"};
    private static Logger j = Logger.withClass(OSProbe.class);
    SharedPreferences a;
    final String b = "/proc/self/mounts";
    final String c = "/proc/self/mountinfo";
    final String d = "/proc/self/mountstats";
    final String e = "android.hardware.usb.action.USB_STATE";
    private Context f;
    String g;
    boolean h = false;

    enum OSEnum {
        UNKNOWN,
        BOOTLOADER_STATE_UNLOCKED,
        BOOTLOADER_STATE_LOCKED,
        DEV_OPTIONS_ENABLED,
        DEV_OPTIONS_DISABLED,
        USB_CONNECTED,
        USB_DISCONNECTED,
        USB_DEBUGGING_ENABLED,
        USB_DEBUGGING_DISABLED
    }

    OSProbe() {
    }

    /* access modifiers changed from: private */
    public String b() {
        return Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String g() {
        /*
            r6 = this;
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r1 = "uname"
            java.lang.Process r0 = r0.exec(r1)     // Catch:{ Exception -> 0x0040 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0040 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0040 }
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ Exception -> 0x0040 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0040 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0040 }
            r2 = 4096(0x1000, float:5.74E-42)
            char[] r2 = new char[r2]     // Catch:{ Exception -> 0x0040 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0040 }
            r3.<init>()     // Catch:{ Exception -> 0x0040 }
        L_0x0022:
            int r4 = r1.read(r2)     // Catch:{ Exception -> 0x0040 }
            if (r4 <= 0) goto L_0x002d
            r5 = 0
            r3.append(r2, r5, r4)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0022
        L_0x002d:
            r1.close()     // Catch:{ Exception -> 0x0040 }
            r0.waitFor()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r1 = "\n"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x0040 }
            return r0
        L_0x0040:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.OSProbe.g():java.lang.String");
    }

    /* access modifiers changed from: private */
    public String h() {
        String str;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("uname -r").getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            str = sb.toString();
        } catch (Exception unused) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (str != null && str != AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN) {
            return str;
        }
        try {
            return System.getProperty("os.version");
        } catch (Exception unused2) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    /* access modifiers changed from: private */
    public String j() {
        return System.getProperty("os.arch");
    }

    /* access modifiers changed from: private */
    public boolean x() {
        return y() || t() || u();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            if (!Objects.equals(i(), "1")) {
                SharedPreferences.Editor edit = this.a.edit();
                edit.putString("nativeUnsafe", "1");
                edit.commit();
                NativeDetector.loadLibrary(this.f);
                String lDPreloadString = NativeDetector.getLDPreloadString();
                edit.putString("nativeUnsafe", "0");
                edit.apply();
                b(lDPreloadString);
            } else if (SeonUtil.c() > 1) {
                b("PARALLEL_RUN_DETECTED");
            } else {
                b("NATIVE_CRASH_BIT_SET");
            }
        } catch (Exception unused) {
        }
    }

    public void bootstrap(Context context) {
        this.f = context;
        try {
            this.a = context.getSharedPreferences("seonLocalPreferences", 0);
        } catch (Exception unused) {
        }
    }

    public Pair c() {
        String str;
        Integer num = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ls /system/fonts/").getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
                num = Integer.valueOf(num.intValue() + 1);
            }
            str = SeonUtil.b(sb.toString());
        } catch (Exception unused) {
            str = "";
        }
        return new Pair(str, num);
    }

    /* access modifiers changed from: package-private */
    public OSEnum d() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("ro.boot.vbmeta.device_state", new String[]{"unlocked"});
            hashMap.put("vendor.boot.vbmeta.device_state", new String[]{"unlocked"});
            hashMap.put("ro.boot.verifiedbootstate", new String[]{"orange", "yellow"});
            hashMap.put("ro.boot.flash.locked", new String[]{"0"});
            hashMap.put("ro.vendor.boot.warranty_bit", new String[]{"1"});
            hashMap.put("ro.boot.warranty_bit", new String[]{"1"});
            hashMap.put("ro.warranty_bit", new String[]{"1"});
            hashMap.put("ro.vendor.warranty_bit", new String[]{"1"});
            hashMap.put("ro.boot.veritymode", new String[]{"disabled"});
            for (String str : hashMap.keySet()) {
                String[] strArr = (String[]) Objects.requireNonNull((String[]) hashMap.get(str));
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = strArr[i2];
                    String a2 = a(str);
                    if (a2 == null) {
                        break;
                    } else if (a2.trim().equalsIgnoreCase(str2)) {
                        return OSEnum.BOOTLOADER_STATE_UNLOCKED;
                    } else {
                        i2++;
                    }
                }
            }
            return OSEnum.BOOTLOADER_STATE_LOCKED;
        } catch (Exception unused) {
            return OSEnum.UNKNOWN;
        }
    }

    /* access modifiers changed from: package-private */
    public OSEnum e() {
        try {
            return Settings.Global.getInt(this.f.getContentResolver(), "development_settings_enabled", 0) == 1 ? OSEnum.DEV_OPTIONS_ENABLED : OSEnum.DEV_OPTIONS_DISABLED;
        } catch (Exception unused) {
            return OSEnum.UNKNOWN;
        }
    }

    /* access modifiers changed from: package-private */
    public String f() {
        try {
            return this.f.getPackageName();
        } catch (Exception unused) {
            return null;
        }
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("is_safetynetfix_loaded", safeGet(new OSProbe$$ExternalSyntheticLambda23(this)));
        hashMap.put("is_location_mocking_enabled", safeGet(new OSProbe$$ExternalSyntheticLambda6(this)));
        hashMap.put("is_oem_unlock_allowed", safeGet(new OSProbe$$ExternalSyntheticLambda7(this)));
        hashMap.put("ld_preload_string", safeGet(new OSProbe$$ExternalSyntheticLambda8(this)));
        String str = (String) safeGet(new OSProbe$$ExternalSyntheticLambda9(this));
        if (Objects.equals(str, "1")) {
            hashMap.put("native_crash_bit", str);
        }
        hashMap.put("ringtone_hash", safeGet(new OSProbe$$ExternalSyntheticLambda10(this)));
        hashMap.put("vbmeta_digest", safeGet(new OSProbe$$ExternalSyntheticLambda12(this)));
        hashMap.put("host_app_package", safeGet(new OSProbe$$ExternalSyntheticLambda13(this)));
        hashMap.put("is_debugger_connected", safeGet(new OSProbe$$ExternalSyntheticLambda14(this)));
        hashMap.put("is_magisk_by_mount", safeGet(new OSProbe$$ExternalSyntheticLambda15(this)));
        hashMap.put("time_since_mount_change", safeGet(new OSProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("is_mountfile_too_old", safeGet(new OSProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("running_fingerprints", safeGet(new OSProbe$$ExternalSyntheticLambda3()));
        hashMap.put("is_rooted_rootbeer", safeGet(new OSProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("is_rooted_native", safeGet(new OSProbe$$ExternalSyntheticLambda5(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        try {
            return this.a.getString("nativeUnsafe", "");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String k() {
        if (!this.h) {
            a();
        }
        return this.g;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r1 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r1 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        r4.deactivate();
        r0 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A[Catch:{ Exception -> 0x004c, all -> 0x0041, all -> 0x004a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String l() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r1 = 0
            android.app.Activity r2 = io.seon.androidsdk.service.SeonUtil.b()     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            r3 = 1
            if (r2 == 0) goto L_0x0010
            android.media.RingtoneManager r4 = new android.media.RingtoneManager     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            goto L_0x0018
        L_0x0010:
            android.media.RingtoneManager r4 = new android.media.RingtoneManager     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            android.content.Context r2 = r6.f     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            r1 = r3
        L_0x0018:
            r2 = 7
            r4.setType(r2)     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            r2.<init>()     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
            android.database.Cursor r4 = r4.getCursor()     // Catch:{ Exception -> 0x004c, all -> 0x0041 }
        L_0x0025:
            boolean r5 = r4.moveToNext()     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = r4.getString(r3)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            r2.append(r5)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            goto L_0x0025
        L_0x0033:
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            java.lang.String r0 = io.seon.androidsdk.service.SeonUtil.b((java.lang.String) r2)     // Catch:{ Exception -> 0x004d, all -> 0x003e }
            if (r1 == 0) goto L_0x0057
            goto L_0x0051
        L_0x003e:
            r2 = move-exception
            r0 = r4
            goto L_0x0042
        L_0x0041:
            r2 = move-exception
        L_0x0042:
            if (r0 == 0) goto L_0x0049
            if (r1 == 0) goto L_0x0049
            r0.deactivate()     // Catch:{ all -> 0x004a }
        L_0x0049:
            throw r2     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            goto L_0x0055
        L_0x004c:
            r4 = r0
        L_0x004d:
            if (r4 == 0) goto L_0x0057
            if (r1 == 0) goto L_0x0057
        L_0x0051:
            r4.deactivate()     // Catch:{ all -> 0x004a }
            goto L_0x0057
        L_0x0055:
            monitor-exit(r6)
            throw r0
        L_0x0057:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.OSProbe.l():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public long m() {
        try {
            return System.currentTimeMillis() - new File("/proc/self/mounts").lastModified();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public OSEnum n() {
        try {
            return this.f.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.hardware.usb.action.USB_STATE")).getExtras().getBoolean("connected") ? OSEnum.USB_CONNECTED : OSEnum.USB_DISCONNECTED;
        } catch (Exception unused) {
            return OSEnum.UNKNOWN;
        }
    }

    /* access modifiers changed from: package-private */
    public OSEnum o() {
        try {
            return Settings.Global.getInt(this.f.getContentResolver(), "adb_enabled", 0) == 1 ? OSEnum.USB_DEBUGGING_ENABLED : OSEnum.USB_DEBUGGING_DISABLED;
        } catch (Exception unused) {
            return OSEnum.UNKNOWN;
        }
    }

    /* access modifiers changed from: package-private */
    public String p() {
        return SeonUtil.a("ro.boot.vbmeta.digest", this.f);
    }

    public String q() {
        byte[] bArr;
        String str = null;
        if (Build.VERSION.SDK_INT > 27 || !SeonUtil.a(this.f, "android.permission.READ_EXTERNAL_STORAGE")) {
            List<Integer> a2 = a(1);
            List<Integer> a3 = a(2);
            try {
                ByteBuffer allocate = ByteBuffer.allocate(24);
                for (Integer intValue : a2) {
                    allocate.putInt(intValue.intValue());
                }
                for (Integer intValue2 : a3) {
                    allocate.putInt(intValue2.intValue());
                }
                bArr = allocate.array();
            } catch (BufferOverflowException e2) {
                j.withCause(e2);
                bArr = null;
            }
            if (bArr == null) {
                return null;
            }
            try {
                return SeonUtil.a(bArr);
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException e3) {
                e = e3;
                j.withCause(e);
                return str;
            }
        } else {
            try {
                Bitmap bitmap = ((BitmapDrawable) WallpaperManager.getInstance(this.f).getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
                str = SeonUtil.a(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                return str;
            } catch (Exception e4) {
                e = e4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean r() {
        try {
            return Boolean.valueOf(Debug.isDebuggerConnected());
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean s() {
        return Boolean.valueOf(Objects.equals(a("ro.allow.mock.location"), "1"));
    }

    public Map scan() {
        this.h = false;
        HashMap hashMap = new HashMap();
        hashMap.put("android_version", safeGet(new OSProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("is_rooted", safeGet(new OSProbe$$ExternalSyntheticLambda11(this)));
        hashMap.put("kernel_arch", safeGet(new OSProbe$$ExternalSyntheticLambda16(this)));
        hashMap.put("kernel_name", safeGet(new OSProbe$$ExternalSyntheticLambda17(this)));
        hashMap.put(OperatingSystem.JsonKeys.KERNEL_VERSION, safeGet(new OSProbe$$ExternalSyntheticLambda18(this)));
        hashMap.put("usb_cable_state", safeGet(new OSProbe$$ExternalSyntheticLambda19(this)));
        hashMap.put("usb_debugging_state", safeGet(new OSProbe$$ExternalSyntheticLambda20(this)));
        hashMap.put("bootloader_state", safeGet(new OSProbe$$ExternalSyntheticLambda21(this)));
        hashMap.put("developer_options_state", safeGet(new OSProbe$$ExternalSyntheticLambda22(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        try {
            File file = new File("/proc/self/mounts");
            return (file.lastModified() == new File("/proc/self/mountinfo").lastModified() && file.lastModified() == new File("/proc/self/mountstats").lastModified()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        try {
            String k = k();
            if (k == null || k.isEmpty()) {
                return false;
            }
            return k.contains("/system/bin/appwidget") || k.contains("magisk") || k.contains("zygisk");
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return m() > 300000;
    }

    /* access modifiers changed from: package-private */
    public Boolean w() {
        return Boolean.valueOf(Objects.equals(a("sys.oem_unlock_allowed"), "1"));
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        RootBeer rootBeer = new RootBeer(this.f);
        rootBeer.setLogging(false);
        return rootBeer.isRooted();
    }

    /* access modifiers changed from: package-private */
    public Boolean z() {
        String[] strArr = {"ro.is_ever_orange", "ro.boot.warranty_bit"};
        for (int i2 = 0; i2 < 2; i2++) {
            String a2 = a(strArr[i2]);
            if (a2 == null || a2.length() == 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        return SeonUtil.a(str, this.f);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.g = str;
        this.h = true;
    }

    private List a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 27) {
            return arrayList;
        }
        try {
            ArrayList arrayList2 = new ArrayList();
            if (i2 == 1 || i2 == 2) {
                Context context = this.f;
                if (!SeonUtil.b(context)) {
                    context = SeonUtil.b();
                }
                WallpaperColors wallpaperColors = WallpaperManager.getInstance(context).getWallpaperColors(i2);
                if (wallpaperColors != null) {
                    arrayList2.add(Integer.valueOf(wallpaperColors.getPrimaryColor().toArgb()));
                    arrayList2.add(Integer.valueOf(wallpaperColors.getSecondaryColor().toArgb()));
                    arrayList2.add(Integer.valueOf(wallpaperColors.getTertiaryColor().toArgb()));
                }
            } else {
                try {
                    throw new IllegalArgumentException("Wallpaper type can only be FLAG_LOCK (2) or FLAG_SYSTEM (1)");
                } catch (Exception unused) {
                }
            }
            return arrayList2;
        } catch (Exception unused2) {
            return arrayList;
        }
    }
}
