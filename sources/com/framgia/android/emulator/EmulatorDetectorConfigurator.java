package com.framgia.android.emulator;

import io.sentry.protocol.Device;
import java.util.HashMap;

public class EmulatorDetectorConfigurator {
    EmulatorDetectorConfig a = null;

    enum Engine {
        MUMU,
        MOMO,
        BLUESTACKS,
        GENYMOTION,
        TITAN_ENGINE,
        QEMU,
        ANDY,
        NOX,
        DROID4X,
        LDPLAYER,
        WINDROY,
        X86,
        VIRTUAL_BOX,
        UNKNOWN
    }

    private EmulatorDetectorConfig b() {
        EmulatorDetectorConfig emulatorDetectorConfig = new EmulatorDetectorConfig();
        emulatorDetectorConfig.z = 3;
        emulatorDetectorConfig.A = false;
        emulatorDetectorConfig.B = true;
        emulatorDetectorConfig.a = new String[]{"noxd"};
        emulatorDetectorConfig.y = new String[]{"goldfish", "Genymotion"};
        emulatorDetectorConfig.c = new String[]{"goldfish"};
        HashMap hashMap = new HashMap();
        emulatorDetectorConfig.b = hashMap;
        Engine engine = Engine.LDPLAYER;
        hashMap.put("/system/priv-app/ldAppStore", String.valueOf(engine));
        emulatorDetectorConfig.b.put("/system/bin/ldinit", String.valueOf(engine));
        emulatorDetectorConfig.b.put("/system/etc/mumu-configs/device-prop-configs/mumu.config", String.valueOf(Engine.MUMU));
        HashMap hashMap2 = emulatorDetectorConfig.b;
        Engine engine2 = Engine.NOX;
        hashMap2.put("fstab.nox", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("init.nox.rc", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("ueventd.nox.rc", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("noxd", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("/system/lib/libnoxspeedup.so", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("/system/bin/nox-prop", String.valueOf(engine2));
        emulatorDetectorConfig.b.put("fstab.titan", String.valueOf(Engine.TITAN_ENGINE));
        emulatorDetectorConfig.b.put("/system/bin/windroyed", String.valueOf(Engine.WINDROY));
        emulatorDetectorConfig.b.put("/data/.bluestacks.prop", String.valueOf(Engine.BLUESTACKS));
        HashMap hashMap3 = emulatorDetectorConfig.b;
        Engine engine3 = Engine.ANDY;
        hashMap3.put("fstab.andy", String.valueOf(engine3));
        emulatorDetectorConfig.b.put("ueventd.andy.rc", String.valueOf(engine3));
        HashMap hashMap4 = emulatorDetectorConfig.b;
        Engine engine4 = Engine.GENYMOTION;
        hashMap4.put("/dev/socket/genyd", String.valueOf(engine4));
        emulatorDetectorConfig.b.put("/dev/socket/baseband_genyd", String.valueOf(engine4));
        HashMap hashMap5 = emulatorDetectorConfig.b;
        Engine engine5 = Engine.QEMU;
        hashMap5.put("/dev/socket/qemud", String.valueOf(engine5));
        emulatorDetectorConfig.b.put("/dev/qemu_pipe", String.valueOf(engine5));
        emulatorDetectorConfig.b.put("/system/lib/libc_malloc_debug_qemu.so", String.valueOf(engine5));
        emulatorDetectorConfig.b.put("/system/bin/droid4x-prop", String.valueOf(Engine.DROID4X));
        HashMap hashMap6 = emulatorDetectorConfig.b;
        Engine engine6 = Engine.VIRTUAL_BOX;
        hashMap6.put("ueventd.vbox86.rc", String.valueOf(engine6));
        emulatorDetectorConfig.b.put("fstab.vbox86", String.valueOf(engine6));
        emulatorDetectorConfig.b.put("init.vbox86.rc", String.valueOf(engine6));
        HashMap hashMap7 = emulatorDetectorConfig.b;
        Engine engine7 = Engine.X86;
        hashMap7.put("x86.prop", String.valueOf(engine7));
        emulatorDetectorConfig.b.put("init.ttVM_x86.rc", String.valueOf(engine7));
        emulatorDetectorConfig.b.put("fstab.ttVM_x86", String.valueOf(engine7));
        emulatorDetectorConfig.b.put("ueventd.android_x86.rc", String.valueOf(engine7));
        emulatorDetectorConfig.b.put("ueventd.ttVM_x86.rc", String.valueOf(engine7));
        HashMap hashMap8 = emulatorDetectorConfig.b;
        Engine engine8 = Engine.UNKNOWN;
        hashMap8.put("vmos.prop", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/bin/androVM-prop", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/etc/xxzs_prop.sh", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/bin/ttVM-prop", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/bin/microvirt-prop", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/app/AntStore", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/bin/duosconfig", String.valueOf(engine8));
        emulatorDetectorConfig.b.put("/system/lib/libdroid4x.so", String.valueOf(engine8));
        HashMap hashMap9 = new HashMap();
        emulatorDetectorConfig.d = hashMap9;
        hashMap9.put("ro.bootloader", "unknown");
        emulatorDetectorConfig.d.put("ro.bootmode", "unknown");
        emulatorDetectorConfig.d.put("ro.hardware", "goldfish");
        emulatorDetectorConfig.d.put("ro.kernel.qemu", "1");
        emulatorDetectorConfig.d.put("qemu.gles", "1");
        emulatorDetectorConfig.d.put("ro.product.device", "generic");
        emulatorDetectorConfig.d.put("ro.product.model", "sdk");
        emulatorDetectorConfig.d.put("ro.product.name", "sdk");
        emulatorDetectorConfig.e = new HashMap();
        emulatorDetectorConfig.g = new String[]{"10.0.2.15"};
        emulatorDetectorConfig.f = new String[]{"com.bluestacks.", "com.android.emulator.radio.config", "com.google.android.overlay.emulatorgmsconfig", "com.bignox.", "com.kop.", "com.nox.", "cn.itools.", "com.kaopu.", "me.haima.", "com.vphone.", "com.genymotion.", "com.google.android.launcher.layouts.genymotion"};
        emulatorDetectorConfig.i = new String[]{"generic", "unknown"};
        emulatorDetectorConfig.j = new String[]{"google_sdk", "droid4x", "Emulator", "Android SDK built for x86", "sdk_gphone64_arm64", "windroy", "tiantian", "genymotion", "amiduos", "duos"};
        emulatorDetectorConfig.k = new String[]{"vbox", "vbox86p", "vbox86tp", "appplayer", "droid4x", "generic", "generic_x86", "emu64a", "virtual"};
        emulatorDetectorConfig.l = new String[]{"Genymotion", "Genymobile", "Andy"};
        emulatorDetectorConfig.m = new String[]{"vbox86", "sdk_gphone"};
        emulatorDetectorConfig.o = new String[]{"sdk", "google_sdk", "sdk_google", "sdk_gphone64_arm64", "sdk_x86", "vbox86p", Device.JsonKeys.SIMULATOR, "emulator", "andy", "iToolsAVM", "vbox86tp", "genymotion", "bluestacks", "droid4x", "ttvm_hdragon", "duos_native", "vbox", "android_x86"};
        emulatorDetectorConfig.p = new String[]{"goldfish_arm64"};
        emulatorDetectorConfig.q = new String[]{"bignox"};
        emulatorDetectorConfig.f24n = new String[]{"ranchu"};
        emulatorDetectorConfig.r = new String[]{"Build2", "bliss-os"};
        emulatorDetectorConfig.s = new String[]{null, "", "1.0.0.0"};
        emulatorDetectorConfig.t = new String[]{"generic"};
        emulatorDetectorConfig.u = new String[]{"vbox", "sdk_gphone"};
        emulatorDetectorConfig.h = new String[]{"bluestacks"};
        emulatorDetectorConfig.v = new String[]{"intel", "amd", "x86"};
        emulatorDetectorConfig.w = new String[]{"i686", "x86_64", "x86"};
        emulatorDetectorConfig.x = new String[]{"genymotion"};
        return emulatorDetectorConfig;
    }

    public EmulatorDetectorConfig a() {
        if (this.a == null) {
            c();
        }
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.a = b();
    }
}
