package com.google.android.gms.internal.play_billing;

import android.os.Build;
import android.util.Log;
import dalvik.system.VMStack;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzcb extends zzbw {
    /* access modifiers changed from: private */
    public static final boolean zza = zza.zza();
    /* access modifiers changed from: private */
    public static final boolean zzb;
    private static final zzbv zzc = new zzbv() {
        public zzaz zza(Class<?> cls, int i) {
            return zzaz.zza;
        }

        public String zzb(Class cls) {
            StackTraceElement zza;
            if (zzcb.zza) {
                try {
                    if (cls.equals(zzcb.zzp())) {
                        return VMStack.getStackClass2().getName();
                    }
                } catch (Throwable unused) {
                }
            }
            if (!zzcb.zzb || (zza = zzcz.zza(cls, 1)) == null) {
                return null;
            }
            return zza.getClassName();
        }
    };

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    final class zza {
        zza() {
        }

        static boolean zza() {
            return zzcb.zzt();
        }
    }

    static {
        boolean z = true;
        if (Build.FINGERPRINT != null && !"robolectric".equals(Build.FINGERPRINT)) {
            z = false;
        }
        zzb = z;
        Class<Log> cls = Log.class;
    }

    static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public zzbf zze(String str) {
        return zzce.zzb(str);
    }

    /* access modifiers changed from: protected */
    public zzbv zzh() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public zzcl zzj() {
        return zzcf.zzb();
    }

    /* access modifiers changed from: protected */
    public String zzm() {
        return "platform: Android";
    }
}
