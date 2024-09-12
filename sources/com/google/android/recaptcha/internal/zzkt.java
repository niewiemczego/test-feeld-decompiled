package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzkt {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzll zzc;
    private static final zzll zzd = new zzln();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzll zzll = null;
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
                zzll = (zzll) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzll;
    }

    public static void zzA(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzu(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzy(i, list, z);
        }
    }

    public static void zzC(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzA(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzC(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzE(i, list, z);
        }
    }

    public static void zzF(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzJ(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzL(i, list, z);
        }
    }

    static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzu(zziu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzu(((Integer) list.get(i2)).intValue());
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
        return size * (zzhh.zzy(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhh.zzy(i << 3) + 8);
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
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzu(zziu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzu(((Integer) list.get(i2)).intValue());
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
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzz(zzjt.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzh(int i, Object obj, zzkr zzkr) {
        int i2 = i << 3;
        if (obj instanceof zzjk) {
            int i3 = zzhh.zzb;
            int zza2 = ((zzjk) obj).zza();
            return zzhh.zzy(i2) + zzhh.zzy(zza2) + zza2;
        }
        return zzhh.zzy(i2) + zzhh.zzw((zzke) obj, zzkr);
    }

    static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                int zze = zziu.zze(i2);
                i += zzhh.zzy((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzhh.zzy((intValue >> 31) ^ (intValue + intValue));
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
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i = 0;
            while (i2 < size) {
                long zze = zzjt.zze(i2);
                i += zzhh.zzz((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzhh.zzz((longValue >> 63) ^ (longValue + longValue));
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
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzy(zziu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzy(((Integer) list.get(i2)).intValue());
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
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzz(zzjt.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzll zzm() {
        return zzc;
    }

    public static zzll zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, List list, zzix zzix, Object obj2, zzll zzll) {
        if (zzix == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzix.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzp(obj, i, intValue, obj2, zzll);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzix.zza(intValue2)) {
                    obj2 = zzp(obj, i, intValue2, obj2, zzll);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzp(Object obj, int i, int i2, Object obj2, zzll zzll) {
        if (obj2 == null) {
            obj2 = zzll.zzc(obj);
        }
        zzll.zzl(obj2, i, (long) i2);
        return obj2;
    }

    static void zzq(zzif zzif, Object obj, Object obj2) {
        zzij zzb2 = zzif.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzif.zzc(obj).zzh(zzb2);
        }
    }

    static void zzr(zzll zzll, Object obj, Object obj2) {
        zzll.zzo(obj, zzll.zze(zzll.zzd(obj), zzll.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzit.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzt(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzc(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzg(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzj(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzl(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzn(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzp(i, list, z);
        }
    }

    public static void zzz(int i, List list, zzmd zzmd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzs(i, list, z);
        }
    }
}
