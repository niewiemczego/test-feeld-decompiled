package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzhi {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc = zzdr.zza();
    private static final boolean zzd;
    private static final zzhh zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x014e  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzg()
            zzb = r5
            java.lang.Class r6 = com.google.android.gms.internal.auth.zzdr.zza()
            zzc = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzs(r6)
            zzd = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzs(r7)
            r8 = 0
            if (r5 != 0) goto L_0x0028
            goto L_0x0037
        L_0x0028:
            if (r6 == 0) goto L_0x0030
            com.google.android.gms.internal.auth.zzhg r8 = new com.google.android.gms.internal.auth.zzhg
            r8.<init>(r5)
            goto L_0x0037
        L_0x0030:
            if (r7 == 0) goto L_0x0037
            com.google.android.gms.internal.auth.zzhf r8 = new com.google.android.gms.internal.auth.zzhf
            r8.<init>(r5)
        L_0x0037:
            zze = r8
            java.lang.String r5 = "getLong"
            java.lang.String r6 = "objectFieldOffset"
            r7 = 2
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0044
        L_0x0042:
            r8 = r10
            goto L_0x006e
        L_0x0044:
            sun.misc.Unsafe r8 = r8.zza
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x0069 }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0069 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0069 }
            r11[r9] = r12     // Catch:{ all -> 0x0069 }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x0069 }
            java.lang.reflect.Field r8 = zzy()     // Catch:{ all -> 0x0069 }
            if (r8 != 0) goto L_0x0067
            goto L_0x0042
        L_0x0067:
            r8 = r9
            goto L_0x006e
        L_0x0069:
            r8 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r8.toString()))
            goto L_0x0042
        L_0x006e:
            zzf = r8
            com.google.android.gms.internal.auth.zzhh r8 = zze
            if (r8 != 0) goto L_0x0077
        L_0x0074:
            r5 = r10
            goto L_0x0109
        L_0x0077:
            sun.misc.Unsafe r8 = r8.zza
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r6[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "getInt"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            r6 = 3
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r11[r9] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0103 }
            r11[r7] = r12     // Catch:{ all -> 0x0103 }
            java.lang.String r12 = "putInt"
            r8.getMethod(r12, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r11[r9] = r12     // Catch:{ all -> 0x0103 }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r7] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "putLong"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "getObject"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r10] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r7] = r6     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r5)     // Catch:{ all -> 0x0103 }
            r5 = r9
            goto L_0x0109
        L_0x0103:
            r5 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r5.toString()))
            goto L_0x0074
        L_0x0109:
            zzg = r5
            java.lang.Class<byte[]> r5 = byte[].class
            zzw(r5)
            zzw(r4)
            zzx(r4)
            zzw(r3)
            zzx(r3)
            zzw(r2)
            zzx(r2)
            zzw(r1)
            zzx(r1)
            zzw(r0)
            zzx(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzw(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x0145
            com.google.android.gms.internal.auth.zzhh r1 = zze
            if (r1 == 0) goto L_0x0145
            r1.zzk(r0)
        L_0x0145:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x014e
            goto L_0x014f
        L_0x014e:
            r9 = r10
        L_0x014f:
            zza = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhi.<clinit>():void");
    }

    private zzhi() {
    }

    static double zza(Object obj, long j) {
        return zze.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zze.zzb(obj, j);
    }

    static int zzc(Object obj, long j) {
        return zze.zzi(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zze.zzj(obj, j);
    }

    static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzf(Object obj, long j) {
        return zze.zzl(obj, j);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhe());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzhh.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j2);
        int i = (((int) j) & 3) << 3;
        zzhh.zzm(obj, j2, ((z ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    static void zzk(Object obj, long j, boolean z) {
        zze.zzc(obj, j, z);
    }

    static void zzl(Object obj, long j, double d) {
        zze.zzd(obj, j, d);
    }

    static void zzm(Object obj, long j, float f) {
        zze.zze(obj, j, f);
    }

    static void zzn(Object obj, long j, int i) {
        zze.zzm(obj, j, i);
    }

    static void zzo(Object obj, long j, long j2) {
        zze.zzn(obj, j, j2);
    }

    static void zzp(Object obj, long j, Object obj2) {
        zze.zzo(obj, j, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zze.zzi(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zze.zzi(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zzs(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzdr.zza;
        try {
            Class cls3 = zzc;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzt(Object obj, long j) {
        return zze.zzf(obj, j);
    }

    static boolean zzu() {
        return zzg;
    }

    static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdr.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(Buffer.class, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
