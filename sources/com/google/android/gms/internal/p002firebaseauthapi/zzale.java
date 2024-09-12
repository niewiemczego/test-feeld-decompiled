package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzale  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzale {
    private static final Class<?> zza = zzd();
    private static final zzamb<?, ?> zzb = zzc();
    private static final zzamb<?, ?> zzc = new zzamd();

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zza(i, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzahm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = size * zzaii.zzg(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzg += zzaii.zza(list.get(i2));
        }
        return zzg;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzaii.zzg(i));
    }

    static int zzb(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajd = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zza(zzajd.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zza(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zzb(i, 0);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaii.zza(i, 0);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzakk> list, zzalc zzalc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzaii.zza(i, list.get(i3), zzalc);
        }
        return i2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzaii.zzg(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajd = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zzc(zzajd.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zzc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzaii.zzg(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajz = (zzajz) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zzb(zzajz.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zzb(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, Object obj, zzalc zzalc) {
        if (obj instanceof zzajo) {
            return zzaii.zzb(i, (zzajo) obj);
        }
        return zzaii.zzb(i, (zzakk) obj, zzalc);
    }

    static int zzb(int i, List<?> list, zzalc zzalc) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = zzaii.zzg(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzajo) {
                i2 = zzaii.zza((zzajo) obj);
            } else {
                i2 = zzaii.zza((zzakk) obj, zzalc);
            }
            zzg += i2;
        }
        return zzg;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaii.zzg(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajd = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zzf(zzajd.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaii.zzg(i));
    }

    static int zzh(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajz = (zzajz) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zzd(zzajz.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzg = zzaii.zzg(i) * size;
        if (list instanceof zzajq) {
            zzajq zzajq = (zzajq) list;
            while (i4 < size) {
                Object zzb2 = zzajq.zzb(i4);
                if (zzb2 instanceof zzahm) {
                    i3 = zzaii.zza((zzahm) zzb2);
                } else {
                    i3 = zzaii.zza((String) zzb2);
                }
                zzg += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzahm) {
                    i2 = zzaii.zza((zzahm) obj);
                } else {
                    i2 = zzaii.zza((String) obj);
                }
                zzg += i2;
                i4++;
            }
        }
        return zzg;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaii.zzg(i));
    }

    static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajd) {
            zzajd zzajd = (zzajd) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zzh(zzajd.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaii.zzg(i));
    }

    static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzajz) {
            zzajz zzajz = (zzajz) list;
            i = 0;
            while (i2 < size) {
                i += zzaii.zze(zzajz.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaii.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    private static zzamb<?, ?> zzc() {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzamb) zze.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static zzamb<?, ?> zza() {
        return zzb;
    }

    public static zzamb<?, ?> zzb() {
        return zzc;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzajh zzajh, UB ub, zzamb<UT, UB> zzamb) {
        if (zzajh == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzajh.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(obj, i, intValue, ub, zzamb);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzajh.zza(intValue2)) {
                    ub = zza(obj, i, intValue2, ub, zzamb);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzamb<UT, UB> zzamb) {
        if (ub == null) {
            ub = zzamb.zzc(obj);
        }
        zzamb.zzb(ub, i, (long) i2);
        return ub;
    }

    static <T, FT extends zzaiu<FT>> void zza(zzair<FT> zzair, T t, T t2) {
        zzais<FT> zza2 = zzair.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzair.zzb(t).zza(zza2);
        }
    }

    static <T> void zza(zzakh zzakh, T t, T t2, long j) {
        zzamh.zza((Object) t, j, zzakh.zza(zzamh.zze(t, j), zzamh.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzamb<UT, UB> zzamb, T t, T t2) {
        zzamb.zzc(t, zzamb.zza(zzamb.zzd(t), zzamb.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzaja.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Boolean> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zza(i, list, z);
        }
    }

    public static void zza(int i, List<zzahm> list, zzanb zzanb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zza(i, list);
        }
    }

    public static void zzb(int i, List<Double> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzb(i, list, z);
        }
    }

    public static void zzc(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zze(i, list, z);
        }
    }

    public static void zzf(int i, List<Float> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzf(i, list, z);
        }
    }

    public static void zza(int i, List<?> list, zzanb zzanb, zzalc zzalc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zza(i, list, zzalc);
        }
    }

    public static void zzg(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzg(i, list, z);
        }
    }

    public static void zzh(int i, List<Long> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzh(i, list, z);
        }
    }

    public static void zzb(int i, List<?> list, zzanb zzanb, zzalc zzalc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzb(i, list, zzalc);
        }
    }

    public static void zzi(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzi(i, list, z);
        }
    }

    public static void zzj(int i, List<Long> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzj(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzk(i, list, z);
        }
    }

    public static void zzl(int i, List<Long> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzl(i, list, z);
        }
    }

    public static void zzb(int i, List<String> list, zzanb zzanb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzb(i, list);
        }
    }

    public static void zzm(int i, List<Integer> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzm(i, list, z);
        }
    }

    public static void zzn(int i, List<Long> list, zzanb zzanb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzanb.zzn(i, list, z);
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
