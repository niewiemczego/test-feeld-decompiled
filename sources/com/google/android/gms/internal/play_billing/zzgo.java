package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhd zzc;
    private static final zzhd zzd = new zzhf();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhd zzhd = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhd = (zzhd) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhd;
    }

    public static void zzA(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzz(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzB(i, list, z);
        }
    }

    public static void zzC(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzD(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzI(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzK(i, list, z);
        }
    }

    static boolean zzF(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzey = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(zzey.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzey = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzu(zzey.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfr = (zzfr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(zzfr.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzh(int i, Object obj, zzgm zzgm) {
        int i2 = i << 3;
        if (obj instanceof zzfi) {
            int i3 = zzee.zzb;
            int zza2 = ((zzfi) obj).zza();
            return zzee.zzx(i2) + zzee.zzx(zza2) + zza2;
        }
        return zzee.zzx(i2) + zzee.zzv((zzgc) obj, zzgm);
    }

    static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzey = (zzey) list;
            i = 0;
            while (i2 < size) {
                int zze = zzey.zze(i2);
                i += zzee.zzx((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzee.zzx((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfr = (zzfr) list;
            i = 0;
            while (i2 < size) {
                long zze = zzfr.zze(i2);
                i += zzee.zzy((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzee.zzy((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzey = (zzey) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzx(zzey.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfr = (zzfr) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzy(zzfr.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzhd zzm() {
        return zzc;
    }

    public static zzhd zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzhd zzhd) {
        if (obj2 == null) {
            obj2 = zzhd.zzc(obj);
        }
        zzhd.zzf(obj2, i, (long) i2);
        return obj2;
    }

    static void zzp(zzhd zzhd, Object obj, Object obj2) {
        zzhd.zzh(obj, zzhd.zze(zzhd.zzd(obj), zzhd.zzd(obj2)));
    }

    public static void zzq(Class cls) {
        Class cls2;
        if (!zzex.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzc(i, list, z);
        }
    }

    public static void zzs(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzg(i, list, z);
        }
    }

    public static void zzt(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzj(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzl(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzn(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzp(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzs(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzu(i, list, z);
        }
    }

    public static void zzz(int i, List list, zzhv zzhv, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzhv.zzx(i, list, z);
        }
    }
}
