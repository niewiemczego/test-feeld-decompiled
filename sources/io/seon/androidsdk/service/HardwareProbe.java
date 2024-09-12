package io.seon.androidsdk.service;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.input.InputManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.SystemClock;
import android.view.InputDevice;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.security.CertificateUtil;
import io.sentry.protocol.Device;
import io.sentry.protocol.Gpu;
import io.seon.androidsdk.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class HardwareProbe extends AbstractSeonProbe {
    static final String[] f = {"battery_charging", "battery_health", Device.JsonKeys.BATTERY_LEVEL, Device.JsonKeys.BATTERY_TEMPERATURE, "battery_voltage", "battery_total_capacity", "cpu_type", "cpu_count", "cpu_speed", "cpu_hash", "last_boot_time", "physical_memory", "system_uptime", "is_nfc_available", "is_nfc_enabled"};
    private static final Logger g = Logger.withClass(HardwareProbe.class);
    static final String[] h = {"cpu_model", "Processor", Gpu.JsonKeys.VENDOR_ID, "Hardware"};
    private final String a = "com.android.internal.os.PowerProfile";
    private final String b = "getBatteryCapacity";
    private Map c;
    private NfcAdapter d;
    private Context e;

    class InputDeviceData {
        public String a;
        public String b;

        InputDeviceData() {
        }
    }

    HardwareProbe() {
    }

    private int a(String str) {
        Intent registerReceiver = this.e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra(str, -1);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public String b() {
        Intent registerReceiver = this.e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("plugged", -1) : 0;
        return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? intExtra != 8 ? "NO DATA" : "DOCK" : "WIRELESS" : "USB" : "AC";
    }

    /* access modifiers changed from: private */
    public Double c() {
        Intent registerReceiver = this.e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = 0;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("temperature", 0);
        }
        return Double.valueOf(((double) i) / 10.0d);
    }

    /* access modifiers changed from: private */
    public int e() {
        int a2 = a("voltage");
        return Integer.toString(a2).length() <= 2 ? a2 * 1000 : a2;
    }

    private Map h() {
        HashMap hashMap = new HashMap();
        byte[] bArr = new byte[1024];
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            while (inputStream.read(bArr) != -1) {
                for (String split : new String(bArr).split("\n")) {
                    String[] split2 = split.split(CertificateUtil.DELIMITER);
                    if (split2.length > 1) {
                        String replace = split2[0].trim().replace(" ", "_");
                        if (!hashMap.containsKey(replace)) {
                            if (replace.equals("model_name")) {
                                replace = "cpu_model";
                            }
                            String trim = split2[1].trim();
                            if (replace.equals("cpu_model")) {
                                trim = trim.replaceAll("\\s+", " ");
                            }
                            hashMap.put(replace, trim);
                        }
                    }
                }
            }
            inputStream.close();
        } catch (IOException unused) {
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public long i() {
        RandomAccessFile randomAccessFile;
        if (!new File("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").exists()) {
            return j();
        }
        long j = -1;
        try {
            randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    break;
                }
                j = Long.parseLong(readLine) / 1000;
            }
            randomAccessFile.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return j;
        throw th;
    }

    /* access modifiers changed from: private */
    public String k() {
        String str = "cpu_model";
        if (!this.c.containsKey(str)) {
            str = "Processor";
            if (!this.c.containsKey(str)) {
                str = "Hardware";
                if (!this.c.containsKey(str)) {
                    return Build.CPU_ABI;
                }
            }
        }
        return (String) this.c.get(str);
    }

    /* access modifiers changed from: private */
    public String l() {
        try {
            return ((ActivityManager) this.e.getSystemService("activity")).getDeviceConfigurationInfo().getGlEsVersion();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String m() {
        StringBuilder sb = new StringBuilder();
        InputManager inputManager = (InputManager) this.e.getSystemService("input");
        for (int inputDevice : inputManager.getInputDeviceIds()) {
            InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
            InputDeviceData inputDeviceData = new InputDeviceData();
            inputDeviceData.a = inputDevice2.getName();
            inputDeviceData.b = String.valueOf(inputDevice2.getVendorId());
            sb.append(inputDeviceData.a).append(";").append(inputDeviceData.b);
            if (sb.length() >= 256) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public long n() {
        return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
    }

    private NfcAdapter o() {
        if (this.d == null) {
            this.d = NfcAdapter.getDefaultAdapter(this.e);
        }
        return this.d;
    }

    /* access modifiers changed from: private */
    public long q() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    /* access modifiers changed from: private */
    public boolean s() {
        Intent registerReceiver = this.e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("plugged", -1);
        }
        boolean z = false;
        boolean z2 = i == 1 || i == 2 || i == 4;
        if (Build.VERSION.SDK_INT < 33) {
            return z2;
        }
        if (i == 8) {
            z = true;
        }
        return z2 | z;
    }

    private boolean u() {
        if (Build.VERSION.SDK_INT < 29 || o() == null || o() == null) {
            return false;
        }
        return o().isSecureNfcEnabled();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer w() {
        return Integer.valueOf(a("level"));
    }

    public void bootstrap(Context context) {
        this.e = context;
        this.c = h();
    }

    public double d() {
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.e}), new Object[0])).doubleValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* access modifiers changed from: package-private */
    public Object g() {
        StringBuilder sb = new StringBuilder();
        if (this.c.containsKey("cpu_model") || this.c.containsKey("Processor") || this.c.containsKey("Hardware")) {
            sb.append(Build.CPU_ABI);
        }
        for (String str : h) {
            if (this.c.containsKey(str)) {
                sb.append((String) this.c.get(str));
            }
        }
        try {
            return SeonUtil.b(sb.toString());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            g.withCause(e2, 6);
            return null;
        }
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("power_source", safeGet(new HardwareProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("input_device_data", safeGet(new HardwareProbe$$ExternalSyntheticLambda9(this)));
        hashMap.put("is_secure_nfc_available", Boolean.valueOf(v()));
        hashMap.put("is_secure_nfc_enabled", Boolean.valueOf(u()));
        hashMap.put("gles_version", safeGet(new HardwareProbe$$ExternalSyntheticLambda10(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public long j() {
        long j = -1;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", "r");
            long j2 = -1;
            while (true) {
                try {
                    String readLine = randomAccessFile.readLine();
                    if (readLine == null) {
                        return j2;
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length != 2) {
                        return -1;
                    }
                    if (Integer.parseInt(split[1]) > 0) {
                        long parseLong = Long.parseLong(split[0].replace("\"", "")) / 1000;
                        if (parseLong > j2) {
                            j2 = parseLong;
                        }
                    }
                } catch (IOException unused) {
                    j = j2;
                    return j;
                }
            }
        } catch (IOException unused2) {
            return j;
        }
    }

    public String p() {
        return Arrays.toString(Build.SUPPORTED_ABIS);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[SYNTHETIC, Splitter:B:24:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Double r() {
        /*
            r7 = this;
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "/proc/meminfo"
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "(\\d+)"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ all -> 0x0041 }
            java.util.regex.Matcher r2 = r3.matcher(r2)     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = ""
        L_0x001a:
            boolean r4 = r2.find()     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0026
            r3 = 1
            java.lang.String r3 = r2.group(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x001a
        L_0x0026:
            r1.close()     // Catch:{ all -> 0x0041 }
            if (r3 != 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r0
        L_0x002f:
            double r2 = java.lang.Double.parseDouble(r3)     // Catch:{ all -> 0x0041 }
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 * r4
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0041 }
            r1.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            return r0
        L_0x0041:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0047
        L_0x0046:
            r1 = move-exception
        L_0x0047:
            if (r0 == 0) goto L_0x004c
            r0.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.HardwareProbe.r():java.lang.Double");
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("battery_charging", safeGet(new HardwareProbe$$ExternalSyntheticLambda11(this)));
        hashMap.put("battery_health", safeGet(new HardwareProbe$$ExternalSyntheticLambda17(this)));
        hashMap.put(Device.JsonKeys.BATTERY_LEVEL, safeGet(new HardwareProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put(Device.JsonKeys.BATTERY_TEMPERATURE, safeGet(new HardwareProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("battery_voltage", safeGet(new HardwareProbe$$ExternalSyntheticLambda3(this)));
        hashMap.put("battery_total_capacity", safeGet(new HardwareProbe$$ExternalSyntheticLambda4(this)));
        hashMap.put("cpu_type", safeGet(new HardwareProbe$$ExternalSyntheticLambda5(this)));
        hashMap.put("cpu_count", safeGet(new HardwareProbe$$ExternalSyntheticLambda6(this)));
        hashMap.put("cpu_speed", safeGet(new HardwareProbe$$ExternalSyntheticLambda7(this)));
        hashMap.put("cpu_hash", safeGet(new HardwareProbe$$ExternalSyntheticLambda8(this)));
        hashMap.put("last_boot_time", safeGet(new HardwareProbe$$ExternalSyntheticLambda12(this)));
        hashMap.put("physical_memory", safeGet(new HardwareProbe$$ExternalSyntheticLambda13(this)));
        hashMap.put("system_uptime", safeGet(new HardwareProbe$$ExternalSyntheticLambda14(this)));
        hashMap.put("is_nfc_available", safeGet(new HardwareProbe$$ExternalSyntheticLambda15(this)));
        hashMap.put("is_nfc_enabled", safeGet(new HardwareProbe$$ExternalSyntheticLambda16(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return o() != null;
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        if (Build.VERSION.SDK_INT < 29 || o() == null) {
            return false;
        }
        return o().isSecureNfcSupported();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        if (o() != null) {
            return o().isEnabled();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String a() {
        Intent registerReceiver = this.e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = 0;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0);
        }
        if (i == 7) {
            return "COLD";
        }
        if (i == 4) {
            return "DEAD";
        }
        if (i == 2) {
            return "GOOD";
        }
        if (i == 3) {
            return "OVER HEAT";
        }
        if (i == 5) {
            return "OVER VOLTAGE";
        }
        if (i == 1) {
            return "UNKNOWN";
        }
        if (i == 6) {
            return "UNSPECIFIED FAILURE";
        }
        return null;
    }
}
