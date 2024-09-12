package com.framgia.android.emulator;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import io.seon.androidsdk.logger.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public final class EmulatorDetector {
    static PackageManager g;
    private static final String[] h = {"cpu_type", "kernel_arch", "battery_voltage", Device.JsonKeys.BATTERY_TEMPERATURE, OperatingSystem.JsonKeys.KERNEL_VERSION, "wifi_ssid", "is_tablet"};
    private static final Logger i = Logger.withClass(EmulatorDetector.class);
    private final Context a;
    private EmulatorDetectorConfig b;
    private boolean c = false;
    private String d;
    private ArrayList e;
    private Map f;

    public interface OnEmulatorDetectorListener {
        void a(boolean z, ArrayList arrayList, String str);
    }

    private EmulatorDetector(Context context, Map map) {
        this.a = context;
        this.f = map;
        this.b = new EmulatorDetectorConfigurator().a();
    }

    private boolean b() {
        try {
            String str = (String) a("cpu_type");
            if (str == null) {
                return false;
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.b.v;
                if (i2 >= strArr.length) {
                    break;
                }
                String str2 = strArr[i2];
                Locale locale = Locale.ENGLISH;
                String lowerCase = str2.toLowerCase(locale);
                if (str.toLowerCase(locale).contains(lowerCase.toLowerCase(locale))) {
                    c("CPU type: " + str + " Filter: " + lowerCase);
                    return true;
                }
                i2++;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private boolean c() {
        String[] strArr;
        EmulatorDetectorConfig emulatorDetectorConfig = this.b;
        if (!(!emulatorDetectorConfig.B || (strArr = emulatorDetectorConfig.f) == null || strArr.length == 0)) {
            for (ApplicationInfo next : Build.VERSION.SDK_INT >= 33 ? g.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128)) : g.getInstalledApplications(128)) {
                String[] strArr2 = this.b.f;
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (next.packageName.startsWith(strArr2[i2])) {
                            c("Package name: " + next.packageName);
                            return true;
                        }
                        i2++;
                    }
                }
            }
        }
        return false;
    }

    private boolean d() {
        try {
            String str = (String) a("kernel_arch");
            String str2 = (String) a(OperatingSystem.JsonKeys.KERNEL_VERSION);
            for (String str3 : this.b.w) {
                Locale locale = Locale.ENGLISH;
                if (str.toLowerCase(locale).contains(str3.toLowerCase(locale))) {
                    c("Kernel arch: " + str + " filter: " + str3);
                    return true;
                }
            }
            for (String str4 : this.b.x) {
                Locale locale2 = Locale.ENGLISH;
                if (str2.toLowerCase(locale2).contains(str4.toLowerCase(locale2))) {
                    c("Kernel version: " + str2 + " filter: " + str4);
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean e() {
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader;
        Throwable th3;
        File[] listFiles = new File("/proc").listFiles();
        if (listFiles == null) {
            return false;
        }
        int length = listFiles.length;
        int i2 = 0;
        while (i2 < length) {
            File file = listFiles[i2];
            try {
                b("dir absolute path: " + file.getAbsolutePath());
                int parseInt = Integer.parseInt(file.getAbsolutePath().replace("/proc/", ""));
                b("process id: " + parseInt);
                FileInputStream fileInputStream = new FileInputStream(new File("/proc/" + parseInt + "/status"));
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        String readLine = bufferedReader.readLine();
                        for (String str : this.b.a) {
                            Locale locale = Locale.ENGLISH;
                            if (readLine.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                                c("Process: " + readLine + " Filter: " + str + " Procid: " + parseInt);
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return true;
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        i2++;
                    } catch (Throwable th4) {
                        th2 = th4;
                        inputStreamReader.close();
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream.close();
                    throw th;
                }
            } catch (Exception unused) {
            } catch (Throwable th6) {
                th.addSuppressed(th6);
            }
        }
        return false;
        throw th3;
    }

    private boolean f() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i2 = 0; i2 < 2; i2++) {
            File file = fileArr[i2];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                String str = new String(bArr);
                for (String str2 : this.b.c) {
                    if (str.contains(str2)) {
                        c("Driver: " + str + " filter: " + str2);
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private boolean g() {
        int i2 = 0;
        for (Map.Entry entry : this.b.d.entrySet()) {
            String a2 = a(this.a, (String) entry.getKey());
            if (entry.getValue() != null && a2.contains((CharSequence) entry.getValue())) {
                i2++;
            }
        }
        if (i2 < this.b.z) {
            return false;
        }
        c("Qemu props count: " + i2);
        return true;
    }

    private boolean h() {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT >= 26 || (activityManager = (ActivityManager) this.a.getSystemService("activity")) == null) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo next : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            String[] strArr = this.b.f;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str = strArr[i2];
                    String className = next.service.getClassName();
                    Locale locale = Locale.ENGLISH;
                    if (className.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                        c("Service: " + next.service.getClassName() + " Filter: " + str);
                        return true;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    private boolean i() {
        try {
            if (this.f.containsKey("wifi_ssid")) {
                String str = (String) this.f.get("wifi_ssid");
                for (String equalsIgnoreCase : this.b.h) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        c("SSID: " + str);
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean j() {
        SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
        if (sensorManager == null) {
            return false;
        }
        for (Sensor next : sensorManager.getSensorList(-1)) {
            String str = next.getVendor() + " " + next.getName();
            String[] strArr = this.b.y;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    String str2 = strArr[i2];
                    Locale locale = Locale.ENGLISH;
                    if (str.toLowerCase(locale).contains(str2.toLowerCase(locale))) {
                        c("Sensor name: " + str + " filter: " + str2);
                        return true;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    private boolean k() {
        boolean p = p() | q();
        l();
        return p;
    }

    private void l() {
        String[] strArr = {"BlueStacks", "Genymotion", "Droid4X", "Windroy", "LDPlayer", "Andy", "MEMU", "MUMU", "QEMU", "Titan_Engine", "NOX"};
        try {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                int i2 = 0;
                while (true) {
                    if (i2 < 11) {
                        String str2 = strArr[i2];
                        if (str.toLowerCase().contains(str2.toLowerCase())) {
                            d(str2);
                            return;
                        }
                        i2++;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String m() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\nBuild.MANUFACTURER: " + Build.MANUFACTURER + "\nBuild.BRAND: " + Build.BRAND + "\nBuild.DEVICE: " + Build.DEVICE + "\nBuild.DISPLAY: " + Build.DISPLAY + "\nBuild.MODEL: " + Build.MODEL + "\nBuild.HARDWARE: " + Build.HARDWARE + "\nBuild.BOARD: " + Build.BOARD + "\nBuild.SERIAL: " + Build.SERIAL + "\nBuild.HOST: " + Build.HOST + "\nBuild.BOOTLOADER: " + Build.BOOTLOADER + "\nBuild.RADIO_VERSION: " + Build.getRadioVersion() + "\nBuild.FINGERPRINT: " + Build.FINGERPRINT + "\n";
    }

    private String n() {
        return this.d;
    }

    private boolean o() {
        try {
            if (this.f.containsKey("is_tablet")) {
                return ((Boolean) this.f.get("is_tablet")).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean p() {
        boolean a2 = a() | j();
        if (!o()) {
            a2 |= a(Build.getRadioVersion(), this.b.s);
        }
        return a2 | b() | d() | i() | g();
    }

    private boolean q() {
        return a(this.b.b) | c() | f() | h() | e();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        boolean a2 = a(a(this.a, "ro.build.flavor"), this.b.u) | a(Build.FINGERPRINT, this.b.i) | a(Build.MODEL, this.b.j) | a(Build.DEVICE, this.b.k) | a(Build.MANUFACTURER, this.b.l) | a(Build.DISPLAY, this.b.m);
        String str = Build.HARDWARE;
        boolean a3 = a2 | a(str, this.b.f24n);
        String str2 = Build.PRODUCT;
        return a3 | a(str2, this.b.o) | a(Build.BOARD, this.b.p) | a(str, this.b.f24n) | a(str2, this.b.o) | a(Build.HOST, this.b.r) | a(Build.BRAND, this.b.t);
    }

    private boolean a(String str, String[] strArr) {
        String str2;
        if (!(strArr == null || strArr.length == 0)) {
            int i2 = 0;
            while (i2 < strArr.length) {
                String str3 = strArr[i2];
                if (str3 == null && str == null) {
                    str2 = "Build prop: null filter: null";
                } else {
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (!str3.isEmpty()) {
                        Locale locale = Locale.ENGLISH;
                        if (str.toLowerCase(locale).contains(str3.toLowerCase(locale))) {
                            str2 = "Build prop: " + str + " filter: " + str3;
                        }
                    } else if (str.equalsIgnoreCase(str3)) {
                        str2 = "Build prop: empty filter: empty";
                    }
                    i2++;
                }
                c(str2);
                return true;
            }
        }
        return false;
    }

    private void b(String str) {
        if (this.c) {
            i.log("emulator log " + str);
        }
    }

    private void c(String str) {
        this.e.add(str);
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        this.d = str;
    }

    private boolean a(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            try {
                File file = new File(str);
                String str2 = (String) hashMap.get(str);
                if (file.exists()) {
                    c("File: " + str + " Engine: " + str2);
                    if (Objects.equals(str2, "UNKNOWN")) {
                        return true;
                    }
                    d(str2);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void a(OnEmulatorDetectorListener onEmulatorDetectorListener) {
        b(m());
        this.e = new ArrayList();
        boolean k = k();
        if (onEmulatorDetectorListener != null) {
            onEmulatorDetectorListener.a(k, this.e, n());
        }
    }

    private Object a(String str) {
        Map map = this.f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    private String a(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    public static EmulatorDetector a(Context context, JSONObject jSONObject) {
        if (context != null) {
            try {
                g = context.getPackageManager();
                HashMap hashMap = new HashMap();
                for (String str : h) {
                    if (jSONObject.has(str) && !hashMap.containsKey(str)) {
                        hashMap.put(str, jSONObject.get(str));
                    }
                }
                return new EmulatorDetector(context.getApplicationContext(), hashMap);
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("Context must not be null.");
        }
    }
}
