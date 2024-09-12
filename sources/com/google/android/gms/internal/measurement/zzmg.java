package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzmg {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class<?> zzc = zzhj.zza();
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzc zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt = ((long) zzb(Object[].class));
    private static final long zzu = ((long) zzc(Object[].class));
    private static final long zzv;
    private static final int zzw;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
    private static final class zza extends zzc {
        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzmg.zza) {
                zzmg.zzc(obj, j, r3 ? (byte) 1 : 0);
            } else {
                zzmg.zzd(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzmg.zza) {
                zzmg.zzc(obj, j, b);
            } else {
                zzmg.zzd(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final boolean zzc(Object obj, long j) {
            if (zzmg.zza) {
                return zzmg.zzf(obj, j);
            }
            return zzmg.zzg(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
    private static final class zzb extends zzc {
        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzmg.zza) {
                zzmg.zzc(obj, j, r3 ? (byte) 1 : 0);
            } else {
                zzmg.zzd(obj, j, r3 ? (byte) 1 : 0);
            }
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzmg.zza) {
                zzmg.zzc(obj, j, b);
            } else {
                zzmg.zzd(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final boolean zzc(Object obj, long j) {
            if (zzmg.zza) {
                return zzmg.zzf(obj, j);
            }
            return zzmg.zzg(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
    private static abstract class zzc {
        Unsafe zza;

        public abstract double zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract float zzb(Object obj, long j);

        public abstract boolean zzc(Object obj, long j);

        public final int zzd(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zze(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }

        public final boolean zza() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("arrayIndexScale", new Class[]{Class.class});
                cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
                cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
                return true;
            } catch (Throwable th) {
                Logger.getLogger(zzmg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
                return false;
            }
        }

        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (zzmg.zze() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                Logger.getLogger(zzmg.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
                return false;
            }
        }
    }

    static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzc(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    static <T> T zza(Class<T> cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zze(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static Field zze() {
        Field zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmf());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzb()
            zzb = r5
            java.lang.Class r6 = com.google.android.gms.internal.measurement.zzhj.zza()
            zzc = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzd(r6)
            zzd = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzd(r7)
            zze = r7
            if (r5 == 0) goto L_0x0038
            if (r6 == 0) goto L_0x0030
            com.google.android.gms.internal.measurement.zzmg$zza r6 = new com.google.android.gms.internal.measurement.zzmg$zza
            r6.<init>(r5)
            goto L_0x0039
        L_0x0030:
            if (r7 == 0) goto L_0x0038
            com.google.android.gms.internal.measurement.zzmg$zzb r6 = new com.google.android.gms.internal.measurement.zzmg$zzb
            r6.<init>(r5)
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            zzf = r6
            r5 = 0
            if (r6 != 0) goto L_0x0040
            r7 = r5
            goto L_0x0044
        L_0x0040:
            boolean r7 = r6.zzb()
        L_0x0044:
            zzg = r7
            if (r6 != 0) goto L_0x004a
            r7 = r5
            goto L_0x004e
        L_0x004a:
            boolean r7 = r6.zza()
        L_0x004e:
            zzh = r7
            java.lang.Class<byte[]> r7 = byte[].class
            int r7 = zzb(r7)
            long r7 = (long) r7
            zzi = r7
            int r9 = zzb(r4)
            long r9 = (long) r9
            zzj = r9
            int r4 = zzc(r4)
            long r9 = (long) r4
            zzk = r9
            int r4 = zzb(r3)
            long r9 = (long) r4
            zzl = r9
            int r3 = zzc(r3)
            long r3 = (long) r3
            zzm = r3
            int r3 = zzb(r2)
            long r3 = (long) r3
            zzn = r3
            int r2 = zzc(r2)
            long r2 = (long) r2
            zzo = r2
            int r2 = zzb(r1)
            long r2 = (long) r2
            zzp = r2
            int r1 = zzc(r1)
            long r1 = (long) r1
            zzq = r1
            int r1 = zzb(r0)
            long r1 = (long) r1
            zzr = r1
            int r0 = zzc(r0)
            long r0 = (long) r0
            zzs = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzb(r0)
            long r0 = (long) r0
            zzt = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzc(r0)
            long r0 = (long) r0
            zzu = r0
            java.lang.reflect.Field r0 = zze()
            if (r0 == 0) goto L_0x00c1
            if (r6 != 0) goto L_0x00ba
            goto L_0x00c1
        L_0x00ba:
            sun.misc.Unsafe r1 = r6.zza
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00c3
        L_0x00c1:
            r0 = -1
        L_0x00c3:
            zzv = r0
            r0 = 7
            long r0 = r0 & r7
            int r0 = (int) r0
            zzw = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00d4
            r5 = 1
        L_0x00d4:
            zza = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmg.<clinit>():void");
    }

    private zzmg() {
    }

    static void zzc(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzf.zza((Object) bArr, zzi + j, b);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzc2 = zzc(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc2 & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc(obj, j2) & (~(255 << i))));
    }

    static void zza(Object obj, long j, double d) {
        zzf.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzf.zza(obj, j, f);
    }

    static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    static /* synthetic */ boolean zzf(Object obj, long j) {
        return ((byte) (zzc(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)))) != 0;
    }

    static /* synthetic */ boolean zzg(Object obj, long j) {
        return ((byte) (zzc(obj, -4 & j) >>> ((int) ((j & 3) << 3)))) != 0;
    }

    private static boolean zzd(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        try {
            Class<?> cls3 = zzc;
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

    static boolean zzh(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    static boolean zzc() {
        return zzh;
    }

    static boolean zzd() {
        return zzg;
    }
}
