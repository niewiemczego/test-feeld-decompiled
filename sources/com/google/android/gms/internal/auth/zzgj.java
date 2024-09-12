package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzgj {
    private static final Class zza;
    private static final zzgy zzb = zzj(false);
    private static final zzgy zzc = zzj(true);
    private static final zzgy zzd = new zzha();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgy zza() {
        return zzb;
    }

    public static zzgy zzb() {
        return zzc;
    }

    public static zzgy zzc() {
        return zzd;
    }

    static Object zzd(int i, List list, zzex zzex, Object obj, zzgy zzgy) {
        if (zzex == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzex.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj = zze(i, intValue, obj, zzgy);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzex.zza()) {
                    obj = zze(i, intValue2, obj, zzgy);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zze(int i, int i2, Object obj, zzgy zzgy) {
        if (obj == null) {
            obj = zzgy.zzc();
        }
        zzgy.zzd(obj, i, (long) i2);
        return obj;
    }

    static void zzf(zzgy zzgy, Object obj, Object obj2) {
        zzgy.zzf(obj, zzgy.zzb(zzgy.zza(obj), zzgy.zza(obj2)));
    }

    public static void zzg(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static void zzi(zzfr zzfr, Object obj, Object obj2, long j) {
        zzhi.zzp(obj, j, zzfr.zza(zzhi.zzf(obj, j), zzhi.zzf(obj2, j)));
    }

    private static zzgy zzj(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgy) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
