package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgf<T> implements zzgm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgc zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfq zzl;
    private final zzhd zzm;
    private final zzek zzn;
    private final zzgh zzo;
    private final zzfx zzp;

    private zzgf(int[] iArr, Object[] objArr, int i, int i2, zzgc zzgc, int i3, boolean z, int[] iArr2, int i4, int i5, zzgh zzgh, zzfq zzfq, zzhd zzhd, zzek zzek, zzfx zzfx) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzek != null && zzek.zzc(zzgc)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzgh;
        this.zzl = zzfq;
        this.zzm = zzhd;
        this.zzn = zzek;
        this.zzg = zzgc;
        this.zzp = zzfx;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzs = (long) (zzs(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgm zzv = zzv(i);
                if (!zzI(obj, i)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        Object zze2 = zzv.zze();
                        zzv.zzg(zze2, object);
                        unsafe.putObject(obj, zzs, zze2);
                    }
                    zzD(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    Object zze3 = zzv.zze();
                    zzv.zzg(zze3, object2);
                    unsafe.putObject(obj, zzs, zze3);
                    object2 = zze3;
                }
                zzv.zzg(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzs = (long) (zzs(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgm zzv = zzv(i);
                if (!zzM(obj, i2, i)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        Object zze2 = zzv.zze();
                        zzv.zzg(zze2, object);
                        unsafe.putObject(obj, zzs, zze2);
                    }
                    zzE(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    Object zze3 = zzv.zze();
                    zzv.zzg(zze3, object2);
                    unsafe.putObject(obj, zzs, zze3);
                    object2 = zze3;
                }
                zzv.zzg(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp2 = zzp(i);
        long j = (long) (1048575 & zzp2);
        if (j != 1048575) {
            zzhn.zzq(obj, j, (1 << (zzp2 >>> 20)) | zzhn.zzc(obj, j));
        }
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhn.zzq(obj, (long) (zzp(i2) & 1048575), i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzs(i) & 1048575), obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzs(i2) & 1048575), obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp2 = zzp(i);
        long j = (long) (zzp2 & 1048575);
        if (j == 1048575) {
            int zzs = zzs(i);
            long j2 = (long) (zzs & 1048575);
            switch (zzr(zzs)) {
                case 0:
                    return Double.doubleToRawLongBits(zzhn.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzhn.zzb(obj, j2)) != 0;
                case 2:
                    return zzhn.zzd(obj, j2) != 0;
                case 3:
                    return zzhn.zzd(obj, j2) != 0;
                case 4:
                    return zzhn.zzc(obj, j2) != 0;
                case 5:
                    return zzhn.zzd(obj, j2) != 0;
                case 6:
                    return zzhn.zzc(obj, j2) != 0;
                case 7:
                    return zzhn.zzw(obj, j2);
                case 8:
                    Object zzf2 = zzhn.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdw) {
                        return !zzdw.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhn.zzf(obj, j2) != null;
                case 10:
                    return !zzdw.zzb.equals(zzhn.zzf(obj, j2));
                case 11:
                    return zzhn.zzc(obj, j2) != 0;
                case 12:
                    return zzhn.zzc(obj, j2) != 0;
                case 13:
                    return zzhn.zzc(obj, j2) != 0;
                case 14:
                    return zzhn.zzd(obj, j2) != 0;
                case 15:
                    return zzhn.zzc(obj, j2) != 0;
                case 16:
                    return zzhn.zzd(obj, j2) != 0;
                case 17:
                    return zzhn.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzhn.zzc(obj, j) & (1 << (zzp2 >>> 20))) != 0;
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgm zzgm) {
        return zzgm.zzk(zzhn.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzex) {
            return ((zzex) obj).zzt();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzhn.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzhn.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhv zzhv) throws IOException {
        if (obj instanceof String) {
            zzhv.zzF(i, (String) obj);
        } else {
            zzhv.zzd(i, (zzdw) obj);
        }
    }

    static zzhe zzd(Object obj) {
        zzex zzex = (zzex) obj;
        zzhe zzhe = zzex.zzc;
        if (zzhe != zzhe.zzc()) {
            return zzhe;
        }
        zzhe zzf2 = zzhe.zzf();
        zzex.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.play_billing.zzgf zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzfz r34, com.google.android.gms.internal.play_billing.zzgh r35, com.google.android.gms.internal.play_billing.zzfq r36, com.google.android.gms.internal.play_billing.zzhd r37, com.google.android.gms.internal.play_billing.zzek r38, com.google.android.gms.internal.play_billing.zzfx r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.zzgl
            if (r1 == 0) goto L_0x0402
            com.google.android.gms.internal.play_billing.zzgl r0 = (com.google.android.gms.internal.play_billing.zzgl) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0057
            int[] r7 = zza
            r11 = r3
            r12 = r11
            r13 = r12
            r14 = r13
            r16 = r14
            r18 = r16
            r17 = r7
            r7 = r18
            goto L_0x0167
        L_0x0057:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0063:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0073
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0063
        L_0x0073:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0076:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0095
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0092
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0082
        L_0x0092:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0095:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a1
        L_0x00b1:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b4:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d3
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0167:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.play_billing.zzgc r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r20 = r3
            r21 = r20
            r22 = r18
            r23 = r19
        L_0x0187:
            if (r4 >= r2) goto L_0x03db
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01af
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0197:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a9
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0197
        L_0x01a9:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b1
        L_0x01af:
            r3 = r24
        L_0x01b1:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d7
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01bf:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d1
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01bf
        L_0x01d1:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d9
        L_0x01d7:
            r8 = r24
        L_0x01d9:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e3
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e3:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = r3 & 2048(0x800, float:2.87E-42)
            r26 = r2
            r2 = 51
            if (r6 < r2) goto L_0x029a
            int r2 = r8 + 1
            char r8 = r1.charAt(r8)
            r27 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0221
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
            r32 = r27
            r27 = r8
            r8 = r32
        L_0x0204:
            int r31 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r2) goto L_0x021a
            r2 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r30
            r27 = r27 | r2
            int r30 = r30 + 13
            r8 = r31
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0204
        L_0x021a:
            int r2 = r8 << r30
            r8 = r27 | r2
            r2 = r31
            goto L_0x0223
        L_0x0221:
            r2 = r27
        L_0x0223:
            r27 = r2
            int r2 = r6 + -51
            r30 = r14
            r14 = 9
            if (r2 == r14) goto L_0x024f
            r14 = 17
            if (r2 != r14) goto L_0x0232
            goto L_0x024f
        L_0x0232:
            r14 = 12
            if (r2 != r14) goto L_0x025e
            int r2 = r0.zzc()
            r14 = 1
            if (r2 == r14) goto L_0x0242
            if (r5 == 0) goto L_0x0240
            goto L_0x0242
        L_0x0240:
            r5 = 0
            goto L_0x025e
        L_0x0242:
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r16 = r10[r16]
            r12[r24] = r16
            goto L_0x025c
        L_0x024f:
            r14 = 1
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r28 = r24 + 1
            r14 = r10[r16]
            r12[r28] = r14
        L_0x025c:
            r16 = r2
        L_0x025e:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r14 = r2 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0268
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0270
        L_0x0268:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzz(r15, r2)
            r10[r8] = r2
        L_0x0270:
            r31 = r13
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0282
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x028a
        L_0x0282:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzz(r15, r13)
            r10[r8] = r13
        L_0x028a:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r29 = r1
            r24 = r8
            r25 = r27
            r8 = 0
            r27 = r0
            goto L_0x039d
        L_0x029a:
            r31 = r13
            r30 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzz(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x0320
            r14 = 17
            if (r6 != r14) goto L_0x02b2
            goto L_0x0320
        L_0x02b2:
            r14 = 27
            if (r6 == r14) goto L_0x030f
            r14 = 49
            if (r6 != r14) goto L_0x02c0
            int r14 = r2 + 1
            r27 = r0
            r0 = 1
            goto L_0x0314
        L_0x02c0:
            r14 = 12
            if (r6 == r14) goto L_0x02f4
            r14 = 30
            if (r6 == r14) goto L_0x02f4
            r14 = 44
            if (r6 != r14) goto L_0x02cd
            goto L_0x02f4
        L_0x02cd:
            r14 = 50
            if (r6 != r14) goto L_0x02f0
            int r14 = r2 + 1
            int r27 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            if (r5 == 0) goto L_0x02ec
            int r22 = r22 + 1
            int r2 = r14 + 1
            r14 = r10[r14]
            r12[r22] = r14
            r22 = r27
            goto L_0x02f0
        L_0x02ec:
            r2 = r14
            r22 = r27
            r5 = 0
        L_0x02f0:
            r27 = r0
            r0 = 1
            goto L_0x032d
        L_0x02f4:
            int r14 = r0.zzc()
            r27 = r0
            r0 = 1
            if (r14 == r0) goto L_0x0302
            if (r5 == 0) goto L_0x0300
            goto L_0x0302
        L_0x0300:
            r5 = 0
            goto L_0x032d
        L_0x0302:
            int r14 = r2 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r2 = r10[r2]
            r12[r24] = r2
            goto L_0x031e
        L_0x030f:
            r27 = r0
            r0 = 1
            int r14 = r2 + 1
        L_0x0314:
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r2 = r10[r2]
            r12[r24] = r2
        L_0x031e:
            r2 = r14
            goto L_0x032d
        L_0x0320:
            r27 = r0
            r0 = 1
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r0
            java.lang.Class r24 = r13.getType()
            r12[r14] = r24
        L_0x032d:
            long r13 = r9.objectFieldOffset(r13)
            int r13 = (int) r13
            r14 = r3 & 4096(0x1000, float:5.74E-42)
            r24 = 1048575(0xfffff, float:1.469367E-39)
            if (r14 == 0) goto L_0x0387
            r14 = 17
            if (r6 > r14) goto L_0x0387
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r0) goto L_0x0362
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x034c:
            int r25 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r0) goto L_0x035e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r24
            r8 = r8 | r14
            int r24 = r24 + 13
            r14 = r25
            goto L_0x034c
        L_0x035e:
            int r14 = r14 << r24
            r8 = r8 | r14
            goto L_0x0364
        L_0x0362:
            r25 = r14
        L_0x0364:
            int r14 = r7 + r7
            int r24 = r8 / 32
            int r14 = r14 + r24
            r0 = r10[r14]
            r29 = r1
            boolean r1 = r0 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0375
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x037d
        L_0x0375:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zzz(r15, r0)
            r10[r14] = r0
        L_0x037d:
            long r0 = r9.objectFieldOffset(r0)
            int r0 = (int) r0
            int r8 = r8 % 32
            r24 = r0
            goto L_0x038c
        L_0x0387:
            r29 = r1
            r25 = r8
            r8 = 0
        L_0x038c:
            r0 = 18
            if (r6 < r0) goto L_0x039a
            r0 = 49
            if (r6 > r0) goto L_0x039a
            int r0 = r23 + 1
            r17[r23] = r13
            r23 = r0
        L_0x039a:
            r16 = r2
            r2 = r13
        L_0x039d:
            int r0 = r21 + 1
            r11[r21] = r4
            int r1 = r0 + 1
            r4 = r3 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x03aa
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03ab
        L_0x03aa:
            r4 = 0
        L_0x03ab:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03b2
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b3
        L_0x03b2:
            r3 = 0
        L_0x03b3:
            if (r5 == 0) goto L_0x03b8
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b9
        L_0x03b8:
            r5 = 0
        L_0x03b9:
            int r6 = r6 << 20
            r3 = r3 | r4
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r0] = r2
            int r21 = r1 + 1
            int r0 = r8 << 20
            r0 = r0 | r24
            r11[r1] = r0
            r4 = r25
            r2 = r26
            r0 = r27
            r1 = r29
            r14 = r30
            r13 = r31
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0187
        L_0x03db:
            r27 = r0
            r31 = r13
            r30 = r14
            com.google.android.gms.internal.play_billing.zzgf r0 = new com.google.android.gms.internal.play_billing.zzgf
            com.google.android.gms.internal.play_billing.zzgc r14 = r27.zza()
            int r15 = r27.zzc()
            r16 = 0
            r9 = r0
            r10 = r11
            r11 = r12
            r12 = r31
            r13 = r30
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r24 = r39
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        L_0x0402:
            com.google.android.gms.internal.play_billing.zzha r0 = (com.google.android.gms.internal.play_billing.zzha) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzfz, com.google.android.gms.internal.play_billing.zzgh, com.google.android.gms.internal.play_billing.zzfq, com.google.android.gms.internal.play_billing.zzhd, com.google.android.gms.internal.play_billing.zzek, com.google.android.gms.internal.play_billing.zzfx):com.google.android.gms.internal.play_billing.zzgf");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzhn.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzhn.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzhn.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzhn.zzf(obj, j)).longValue();
    }

    private final zzfb zzu(int i) {
        int i2 = i / 3;
        return (zzfb) this.zzd[i2 + i2 + 1];
    }

    private final zzgm zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgm zzgm = (zzgm) objArr[i3];
        if (zzgm != null) {
            return zzgm;
        }
        zzgm zzb2 = zzgk.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgm zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, (long) zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze2 = zzv.zze();
        if (object != null) {
            zzv.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgm zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzs(i2) & 1048575));
        if (zzL(object)) {
            return object;
        }
        Object zze2 = zzv.zze();
        if (object != null) {
            zzv.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037c, code lost:
        r1 = (r1 + r2) + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x037e, code lost:
        r12 = r12 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x039c, code lost:
        r1 = r1 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0551, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0563, code lost:
        r12 = r12 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x066d, code lost:
        r0 = r0 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x06d5, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0759, code lost:
        r0 = r0 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x076f, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0786, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x078a, code lost:
        r11 = r11 + 3;
        r0 = r13;
        r1 = r15;
        r9 = 1048575;
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            sun.misc.Unsafe r8 = zzb
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            r0 = r9
            r1 = r10
            r11 = r1
            r12 = r11
        L_0x000e:
            int[] r2 = r6.zzc
            int r2 = r2.length
            r3 = 0
            if (r11 >= r2) goto L_0x0794
            int r2 = r6.zzs(r11)
            int r4 = zzr(r2)
            int[] r5 = r6.zzc
            int r13 = r11 + 2
            r14 = r5[r11]
            r5 = r5[r13]
            r13 = r5 & r9
            r15 = 17
            r16 = 1
            if (r4 > r15) goto L_0x0040
            if (r13 == r0) goto L_0x0039
            if (r13 != r9) goto L_0x0032
            r0 = r10
            goto L_0x0037
        L_0x0032:
            long r0 = (long) r13
            int r0 = r8.getInt(r7, r0)
        L_0x0037:
            r1 = r0
            r0 = r13
        L_0x0039:
            int r5 = r5 >>> 20
            int r5 = r16 << r5
            r13 = r0
            r15 = r1
            goto L_0x0043
        L_0x0040:
            r13 = r0
            r15 = r1
            r5 = r10
        L_0x0043:
            r0 = r2 & r9
            com.google.android.gms.internal.play_billing.zzep r1 = com.google.android.gms.internal.play_billing.zzep.DOUBLE_LIST_PACKED
            int r1 = r1.zza()
            if (r4 < r1) goto L_0x0052
            com.google.android.gms.internal.play_billing.zzep r1 = com.google.android.gms.internal.play_billing.zzep.SINT64_LIST_PACKED
            r1.zza()
        L_0x0052:
            long r1 = (long) r0
            r17 = 63
            switch(r4) {
                case 0: goto L_0x0773;
                case 1: goto L_0x075c;
                case 2: goto L_0x073d;
                case 3: goto L_0x0720;
                case 4: goto L_0x0703;
                case 5: goto L_0x06ee;
                case 6: goto L_0x06d9;
                case 7: goto L_0x06c2;
                case 8: goto L_0x068c;
                case 9: goto L_0x0670;
                case 10: goto L_0x0648;
                case 11: goto L_0x062a;
                case 12: goto L_0x060c;
                case 13: goto L_0x05f7;
                case 14: goto L_0x05e2;
                case 15: goto L_0x05bf;
                case 16: goto L_0x059c;
                case 17: goto L_0x057e;
                case 18: goto L_0x0571;
                case 19: goto L_0x0566;
                case 20: goto L_0x0543;
                case 21: goto L_0x0527;
                case 22: goto L_0x050b;
                case 23: goto L_0x04ff;
                case 24: goto L_0x04f3;
                case 25: goto L_0x04d8;
                case 26: goto L_0x0477;
                case 27: goto L_0x0437;
                case 28: goto L_0x0405;
                case 29: goto L_0x03eb;
                case 30: goto L_0x03d1;
                case 31: goto L_0x03c5;
                case 32: goto L_0x03b9;
                case 33: goto L_0x039f;
                case 34: goto L_0x0381;
                case 35: goto L_0x0366;
                case 36: goto L_0x034f;
                case 37: goto L_0x0338;
                case 38: goto L_0x0321;
                case 39: goto L_0x030a;
                case 40: goto L_0x02f2;
                case 41: goto L_0x02da;
                case 42: goto L_0x02c0;
                case 43: goto L_0x02a8;
                case 44: goto L_0x0290;
                case 45: goto L_0x0278;
                case 46: goto L_0x0260;
                case 47: goto L_0x0248;
                case 48: goto L_0x0230;
                case 49: goto L_0x0207;
                case 50: goto L_0x01d8;
                case 51: goto L_0x01ca;
                case 52: goto L_0x01bc;
                case 53: goto L_0x01a6;
                case 54: goto L_0x0190;
                case 55: goto L_0x017a;
                case 56: goto L_0x016c;
                case 57: goto L_0x015e;
                case 58: goto L_0x0150;
                case 59: goto L_0x0121;
                case 60: goto L_0x010d;
                case 61: goto L_0x00ee;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00c2;
                case 64: goto L_0x00b4;
                case 65: goto L_0x00a6;
                case 66: goto L_0x008b;
                case 67: goto L_0x0070;
                case 68: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x078a
        L_0x005a:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzgc r0 = (com.google.android.gms.internal.play_billing.zzgc) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r0, r1)
            goto L_0x057b
        L_0x0070:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            goto L_0x0759
        L_0x008b:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x0759
        L_0x00a6:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0786
        L_0x00b4:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x076f
        L_0x00c2:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x00d8:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x00ee:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x066d
        L_0x010d:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzh(r14, r0, r1)
            goto L_0x057b
        L_0x0121:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r2 == 0) goto L_0x0144
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x066d
        L_0x0144:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzw(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x0150:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x06d5
        L_0x015e:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x076f
        L_0x016c:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0786
        L_0x017a:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzo(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x0190:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x01a6:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzt(r7, r1)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x01bc:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x076f
        L_0x01ca:
            boolean r0 = r6.zzM(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0786
        L_0x01d8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.lang.Object r1 = r6.zzw(r11)
            com.google.android.gms.internal.play_billing.zzfw r0 = (com.google.android.gms.internal.play_billing.zzfw) r0
            com.google.android.gms.internal.play_billing.zzfv r1 = (com.google.android.gms.internal.play_billing.zzfv) r1
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x078a
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x01fa
            goto L_0x078a
        L_0x01fa:
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r0.getKey()
            r0.getValue()
            throw r3
        L_0x0207:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x021b
            r4 = r10
            goto L_0x022d
        L_0x021b:
            r3 = r10
            r4 = r3
        L_0x021d:
            if (r3 >= r2) goto L_0x022d
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.play_billing.zzgc r5 = (com.google.android.gms.internal.play_billing.zzgc) r5
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r5, r1)
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x021d
        L_0x022d:
            int r12 = r12 + r4
            goto L_0x078a
        L_0x0230:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzj(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0248:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzi(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0260:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0278:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0290:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zza(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x02a8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzk(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x02c0:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x02da:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x02f2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x030a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzf(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0321:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzl(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0338:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzg(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x034f:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x037c
        L_0x0366:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
        L_0x037c:
            int r1 = r1 + r2
            int r1 = r1 + r0
        L_0x037e:
            int r12 = r12 + r1
            goto L_0x078a
        L_0x0381:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0392
        L_0x038f:
            r0 = r10
            goto L_0x057b
        L_0x0392:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzj(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
        L_0x039c:
            int r1 = r1 * r2
            goto L_0x0759
        L_0x039f:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03ae
            goto L_0x038f
        L_0x03ae:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzi(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039c
        L_0x03b9:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r10)
            goto L_0x057b
        L_0x03c5:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x03d1:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03e0
            goto L_0x038f
        L_0x03e0:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zza(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039c
        L_0x03eb:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03fa
            goto L_0x038f
        L_0x03fa:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzk(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039c
        L_0x0405:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0416
            r1 = r10
            goto L_0x037e
        L_0x0416:
            int r2 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            int r1 = r1 * r2
            r2 = r10
        L_0x041e:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x037e
            java.lang.Object r3 = r0.get(r2)
            com.google.android.gms.internal.play_billing.zzdw r3 = (com.google.android.gms.internal.play_billing.zzdw) r3
            int r3 = r3.zzd()
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzx(r3)
            int r4 = r4 + r3
            int r1 = r1 + r4
            int r2 = r2 + 1
            goto L_0x041e
        L_0x0437:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x044b
            r3 = r10
            goto L_0x0474
        L_0x044b:
            int r3 = r14 << 3
            int r3 = com.google.android.gms.internal.play_billing.zzee.zzx(r3)
            int r3 = r3 * r2
            r4 = r10
        L_0x0453:
            if (r4 >= r2) goto L_0x0474
            java.lang.Object r5 = r0.get(r4)
            boolean r14 = r5 instanceof com.google.android.gms.internal.play_billing.zzfi
            if (r14 == 0) goto L_0x046a
            com.google.android.gms.internal.play_billing.zzfi r5 = (com.google.android.gms.internal.play_billing.zzfi) r5
            int r5 = r5.zza()
            int r14 = com.google.android.gms.internal.play_billing.zzee.zzx(r5)
            int r14 = r14 + r5
            int r3 = r3 + r14
            goto L_0x0471
        L_0x046a:
            com.google.android.gms.internal.play_billing.zzgc r5 = (com.google.android.gms.internal.play_billing.zzgc) r5
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzv(r5, r1)
            int r3 = r3 + r5
        L_0x0471:
            int r4 = r4 + 1
            goto L_0x0453
        L_0x0474:
            int r12 = r12 + r3
            goto L_0x078a
        L_0x0477:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0487
            goto L_0x0551
        L_0x0487:
            int r2 = r14 << 3
            boolean r3 = r0 instanceof com.google.android.gms.internal.play_billing.zzfk
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            int r2 = r2 * r1
            if (r3 == 0) goto L_0x04b6
            com.google.android.gms.internal.play_billing.zzfk r0 = (com.google.android.gms.internal.play_billing.zzfk) r0
            r3 = r10
        L_0x0495:
            if (r3 >= r1) goto L_0x0563
            java.lang.Object r4 = r0.zzf(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r5 == 0) goto L_0x04ac
            com.google.android.gms.internal.play_billing.zzdw r4 = (com.google.android.gms.internal.play_billing.zzdw) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzx(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04b3
        L_0x04ac:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzw(r4)
            int r2 = r2 + r4
        L_0x04b3:
            int r3 = r3 + 1
            goto L_0x0495
        L_0x04b6:
            r3 = r10
        L_0x04b7:
            if (r3 >= r1) goto L_0x0563
            java.lang.Object r4 = r0.get(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r5 == 0) goto L_0x04ce
            com.google.android.gms.internal.play_billing.zzdw r4 = (com.google.android.gms.internal.play_billing.zzdw) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.play_billing.zzee.zzx(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04d5
        L_0x04ce:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.play_billing.zzee.zzw(r4)
            int r2 = r2 + r4
        L_0x04d5:
            int r3 = r3 + 1
            goto L_0x04b7
        L_0x04d8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r0 = r0.size()
            if (r0 != 0) goto L_0x04e8
            goto L_0x038f
        L_0x04e8:
            int r1 = r14 << 3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r1 = r1 + 1
            int r0 = r0 * r1
            goto L_0x057b
        L_0x04f3:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x04ff:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r10)
            goto L_0x057b
        L_0x050b:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x051b
            goto L_0x038f
        L_0x051b:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzf(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039c
        L_0x0527:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0537
            goto L_0x038f
        L_0x0537:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzl(r0)
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r2)
            goto L_0x039c
        L_0x0543:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.play_billing.zzgo.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0553
        L_0x0551:
            r2 = r10
            goto L_0x0563
        L_0x0553:
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.play_billing.zzgo.zzg(r0)
            int r0 = r0.size()
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = r0 * r1
            int r2 = r2 + r0
        L_0x0563:
            int r12 = r12 + r2
            goto L_0x078a
        L_0x0566:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x0571:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzd(r14, r0, r10)
        L_0x057b:
            int r12 = r12 + r0
            goto L_0x078a
        L_0x057e:
            r0 = r18
            r3 = r1
            r1 = r19
            r2 = r11
            r9 = r3
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzgc r0 = (com.google.android.gms.internal.play_billing.zzgc) r0
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzt(r14, r0, r1)
            goto L_0x057b
        L_0x059c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            goto L_0x0759
        L_0x05bf:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            goto L_0x0759
        L_0x05e2:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0786
        L_0x05f7:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x076f
        L_0x060c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x062a:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x0648:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x066d:
            int r0 = r0 + r2
            goto L_0x057b
        L_0x0670:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.play_billing.zzgm r1 = r6.zzv(r11)
            int r0 = com.google.android.gms.internal.play_billing.zzgo.zzh(r14, r0, r1)
            goto L_0x057b
        L_0x068c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            boolean r2 = r1 instanceof com.google.android.gms.internal.play_billing.zzdw
            if (r2 == 0) goto L_0x06b6
            com.google.android.gms.internal.play_billing.zzdw r1 = (com.google.android.gms.internal.play_billing.zzdw) r1
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzb
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.play_billing.zzee.zzx(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x066d
        L_0x06b6:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzw(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x06c2:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x06d5:
            int r0 = r0 + 1
            goto L_0x057b
        L_0x06d9:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x076f
        L_0x06ee:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0786
        L_0x0703:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzu(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x0720:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
            goto L_0x0759
        L_0x073d:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.play_billing.zzee.zzy(r1)
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x0759:
            int r0 = r0 + r1
            goto L_0x057b
        L_0x075c:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x076f:
            int r0 = r0 + 4
            goto L_0x057b
        L_0x0773:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzJ(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.play_billing.zzee.zzx(r0)
        L_0x0786:
            int r0 = r0 + 8
            goto L_0x057b
        L_0x078a:
            int r11 = r11 + 3
            r0 = r13
            r1 = r15
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            goto L_0x000e
        L_0x0794:
            com.google.android.gms.internal.play_billing.zzhd r0 = r6.zzm
            java.lang.Object r1 = r0.zzd(r7)
            int r0 = r0.zza(r1)
            int r12 = r12 + r0
            boolean r0 = r6.zzh
            if (r0 != 0) goto L_0x07a4
            return r12
        L_0x07a4:
            com.google.android.gms.internal.play_billing.zzek r0 = r6.zzn
            r0.zza(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b8, code lost:
        r1 = r1 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0212, code lost:
        r2 = (int) (r2 ^ (r2 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0216, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0217, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int[] r2 = r8.zzc
            int r2 = r2.length
            if (r0 >= r2) goto L_0x021b
            int r2 = r8.zzs(r0)
            int[] r3 = r8.zzc
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r2
            int r2 = zzr(r2)
            r3 = r3[r0]
            long r4 = (long) r4
            r6 = 37
            r7 = 32
            switch(r2) {
                case 0: goto L_0x0206;
                case 1: goto L_0x01fb;
                case 2: goto L_0x01f2;
                case 3: goto L_0x01e9;
                case 4: goto L_0x01e2;
                case 5: goto L_0x01d9;
                case 6: goto L_0x01d2;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01ba;
                case 9: goto L_0x01ac;
                case 10: goto L_0x01a0;
                case 11: goto L_0x0198;
                case 12: goto L_0x0190;
                case 13: goto L_0x0188;
                case 14: goto L_0x017e;
                case 15: goto L_0x0176;
                case 16: goto L_0x016c;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0217
        L_0x0021:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0033:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0043:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x0051:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0061:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x006f:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x007d:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x008b:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x009d:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00af:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00c3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            boolean r2 = zzN(r9, r4)
            int r2 = com.google.android.gms.internal.play_billing.zzfd.zza(r2)
            goto L_0x0216
        L_0x00d5:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x00e3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x00f3:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzo(r9, r4)
            goto L_0x0216
        L_0x0101:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0111:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzt(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0121:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            float r2 = zzn(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0133:
            boolean r2 = r8.zzM(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            double r2 = zzm(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0147:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0153:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x015f:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
            goto L_0x01b8
        L_0x016c:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0176:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x017e:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x0188:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x0190:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x0198:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x01a0:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01ac:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
        L_0x01b8:
            int r1 = r1 + r6
            goto L_0x0217
        L_0x01ba:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzhn.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01c7:
            int r1 = r1 * 53
            boolean r2 = com.google.android.gms.internal.play_billing.zzhn.zzw(r9, r4)
            int r2 = com.google.android.gms.internal.play_billing.zzfd.zza(r2)
            goto L_0x0216
        L_0x01d2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x01d9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x01e2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.play_billing.zzhn.zzc(r9, r4)
            goto L_0x0216
        L_0x01e9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x01f2:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.play_billing.zzhn.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
            goto L_0x0212
        L_0x01fb:
            int r1 = r1 * 53
            float r2 = com.google.android.gms.internal.play_billing.zzhn.zzb(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0206:
            int r1 = r1 * 53
            double r2 = com.google.android.gms.internal.play_billing.zzhn.zza(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.play_billing.zzfd.zzd
        L_0x0212:
            long r4 = r2 >>> r7
            long r2 = r2 ^ r4
            int r2 = (int) r2
        L_0x0216:
            int r1 = r1 + r2
        L_0x0217:
            int r0 = r0 + 3
            goto L_0x0002
        L_0x021b:
            int r1 = r1 * 53
            com.google.android.gms.internal.play_billing.zzhd r0 = r8.zzm
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x022d
            return r1
        L_0x022d:
            com.google.android.gms.internal.play_billing.zzek r0 = r8.zzn
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0300, code lost:
        r3 = r8;
        r19 = r9;
        r6 = r11;
        r1 = r12;
        r17 = 0;
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0389, code lost:
        r14 = r39;
        r13 = r40;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03c6, code lost:
        r14 = r39;
        r13 = r40;
        r3 = r8;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03cc, code lost:
        r8 = r19;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03d4, code lost:
        r3 = r8;
        r6 = r11;
        r1 = r12;
        r17 = r19;
        r8 = r5;
        r19 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03df, code lost:
        r5 = r39;
        r5 = r1;
        r11 = r3;
        r3 = r4;
        r33 = r6;
        r20 = r8;
        r12 = r19;
        r10 = r21;
        r8 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0572, code lost:
        r9 = r1;
        r1 = r2;
        r8 = r11;
        r7 = r14;
        r11 = r30;
        r33 = r31;
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0625, code lost:
        r14 = r8;
        r8 = r11;
        r11 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0637, code lost:
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x06d5, code lost:
        r0 = r35;
        r7 = r14;
        r14 = r8;
        r8 = r11;
        r11 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x07a5, code lost:
        r8 = r1;
        r9 = r3;
        r10 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x08c2, code lost:
        r8 = r1;
        r1 = r2;
        r9 = r3;
        r10 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x0a02, code lost:
        if (r1 == r8) goto L_0x0a16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:441:0x0a04, code lost:
        r13 = r40;
        r4 = r7;
        r3 = r11;
        r2 = r12;
        r8 = 0;
        r5 = r20;
        r6 = r25;
        r11 = r33;
        r7 = r36;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x0a16, code lost:
        r8 = r40;
        r3 = r1;
        r5 = r9;
        r10 = r12;
        r12 = r7;
        r7 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x0a7b, code lost:
        r30 = r3;
        r10 = r12;
        r4 = r21;
        r12 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:477:0x0b21, code lost:
        r12 = r1;
        r1 = r2;
        r30 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0b4e, code lost:
        r12 = r1;
        r30 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:0x0c5c, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:522:0x0c5d, code lost:
        if (r1 == r4) goto L_0x0c72;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:523:0x0c5f, code lost:
        r14 = r39;
        r13 = r40;
        r2 = r10;
        r4 = r12;
        r8 = 0;
        r6 = r25;
        r3 = r30;
        r11 = r33;
        r12 = r5;
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:524:0x0c72, code lost:
        r8 = r40;
        r3 = r1;
        r11 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x019c, code lost:
        r14 = r39;
        r13 = r40;
        r3 = r8;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01ca, code lost:
        r2 = r21;
        r6 = r25;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d1, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0718  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0768  */
    /* JADX WARNING: Removed duplicated region for block: B:532:0x0c8c  */
    /* JADX WARNING: Removed duplicated region for block: B:537:0x0cac  */
    /* JADX WARNING: Removed duplicated region for block: B:622:0x0694 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:626:0x08c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:630:0x08c2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.play_billing.zzdj r41) throws java.io.IOException {
        /*
            r35 = this;
            r0 = r35
            r7 = r36
            r15 = r37
            r14 = r39
            r13 = r40
            r12 = r41
            zzA(r36)
            sun.misc.Unsafe r11 = zzb
            r8 = 0
            r1 = r38
            r3 = r8
            r4 = r3
            r5 = r4
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001b:
            r16 = 0
            if (r1 >= r14) goto L_0x0cd0
            int r4 = r1 + 1
            byte r1 = r15[r1]
            if (r1 >= 0) goto L_0x002c
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzi(r1, r15, r4, r12)
            int r4 = r12.zza
            goto L_0x0031
        L_0x002c:
            r34 = r4
            r4 = r1
            r1 = r34
        L_0x0031:
            int r9 = r4 >>> 3
            r10 = 3
            if (r9 <= r2) goto L_0x0046
            int r3 = r3 / r10
            int r2 = r0.zze
            if (r9 < r2) goto L_0x0044
            int r2 = r0.zzf
            if (r9 > r2) goto L_0x0044
            int r2 = r0.zzq(r9, r3)
            goto L_0x0052
        L_0x0044:
            r2 = -1
            goto L_0x0052
        L_0x0046:
            int r2 = r0.zze
            if (r9 < r2) goto L_0x0055
            int r2 = r0.zzf
            if (r9 > r2) goto L_0x0055
            int r2 = r0.zzq(r9, r8)
        L_0x0052:
            r3 = r2
            r2 = -1
            goto L_0x0057
        L_0x0055:
            r2 = -1
            r3 = -1
        L_0x0057:
            if (r3 != r2) goto L_0x006c
            r3 = r1
            r18 = r2
            r20 = r5
            r25 = r6
            r17 = r8
            r10 = r9
            r33 = r11
            r5 = r12
            r12 = r4
            r11 = r17
            r8 = r13
            goto L_0x0c77
        L_0x006c:
            r2 = r4 & 7
            int[] r10 = r0.zzc
            int r19 = r3 + 1
            r8 = r10[r19]
            r19 = r4
            int r4 = zzr(r8)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r8 & r17
            long r13 = (long) r13
            r21 = r9
            r22 = 536870912(0x20000000, float:1.0842022E-19)
            r23 = 0
            java.lang.String r9 = ""
            r27 = r9
            r9 = 17
            if (r4 > r9) goto L_0x03f0
            int r9 = r3 + 2
            r9 = r10[r9]
            int r10 = r9 >>> 20
            r25 = 1
            int r10 = r25 << r10
            r30 = r8
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            if (r9 == r6) goto L_0x00bc
            if (r6 == r8) goto L_0x00ae
            r25 = r9
            long r8 = (long) r6
            r11.putInt(r7, r8, r5)
            r5 = r25
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x00af
        L_0x00ae:
            r5 = r9
        L_0x00af:
            if (r5 != r8) goto L_0x00b3
            r6 = 0
            goto L_0x00b8
        L_0x00b3:
            long r8 = (long) r5
            int r6 = r11.getInt(r7, r8)
        L_0x00b8:
            r25 = r5
            r5 = r6
            goto L_0x00be
        L_0x00bc:
            r25 = r6
        L_0x00be:
            switch(r4) {
                case 0: goto L_0x03ad;
                case 1: goto L_0x0393;
                case 2: goto L_0x0371;
                case 3: goto L_0x0371;
                case 4: goto L_0x035c;
                case 5: goto L_0x0342;
                case 6: goto L_0x032b;
                case 7: goto L_0x030d;
                case 8: goto L_0x01d4;
                case 9: goto L_0x01a3;
                case 10: goto L_0x018a;
                case 11: goto L_0x035c;
                case 12: goto L_0x0158;
                case 13: goto L_0x032b;
                case 14: goto L_0x0342;
                case 15: goto L_0x0142;
                case 16: goto L_0x010e;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 3
            r18 = -1
            r19 = 0
            if (r2 != r1) goto L_0x03d4
            r5 = r5 | r10
            java.lang.Object r1 = r0.zzx(r7, r8)
            int r2 = r21 << 3
            r13 = r2 | 4
            com.google.android.gms.internal.play_billing.zzgm r2 = r0.zzv(r8)
            r3 = r8
            r17 = r19
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r1
            r10 = r6
            r14 = r9
            r6 = r21
            r9 = r2
            r2 = r10
            r10 = r37
            r6 = r11
            r11 = r4
            r4 = r12
            r12 = r39
            r38 = r5
            r19 = r14
            r5 = r39
            r14 = r41
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzl(r8, r9, r10, r11, r12, r13, r14)
            r0.zzF(r7, r3, r1)
            r13 = r40
            r12 = r4
            r14 = r5
            r11 = r6
            r1 = r8
            r8 = r17
            r4 = r19
            r2 = r21
            r6 = r25
            r5 = r38
            goto L_0x001b
        L_0x010e:
            if (r2 != 0) goto L_0x0135
            r8 = r5 | r10
            int r9 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r1, r12)
            long r1 = r12.zzb
            long r5 = com.google.android.gms.internal.play_billing.zzea.zzc(r1)
            r1 = r11
            r18 = -1
            r2 = r36
            r10 = r3
            r38 = r9
            r9 = r19
            r3 = r13
            r1.putLong(r2, r3, r5)
            r1 = r38
            r14 = r39
            r13 = r40
            r5 = r8
            r4 = r9
            r3 = r10
            goto L_0x01ca
        L_0x0135:
            r18 = -1
            r4 = r1
            r8 = r5
            r6 = r11
            r1 = r12
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r17 = 0
            goto L_0x03df
        L_0x0142:
            r8 = r3
            r9 = r19
            r18 = -1
            if (r2 != 0) goto L_0x01d1
            r5 = r5 | r10
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r12)
            int r2 = r12.zza
            int r2 = com.google.android.gms.internal.play_billing.zzea.zzb(r2)
            r11.putInt(r7, r13, r2)
            goto L_0x019c
        L_0x0158:
            r8 = r3
            r9 = r19
            r18 = -1
            if (r2 != 0) goto L_0x01d1
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r12)
            int r2 = r12.zza
            com.google.android.gms.internal.play_billing.zzfb r3 = r0.zzu(r8)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r30 & r4
            if (r4 == 0) goto L_0x0185
            if (r3 == 0) goto L_0x0185
            boolean r3 = r3.zza(r2)
            if (r3 == 0) goto L_0x0178
            goto L_0x0185
        L_0x0178:
            com.google.android.gms.internal.play_billing.zzhe r3 = zzd(r36)
            long r13 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r13)
            r3.zzj(r9, r2)
            goto L_0x019c
        L_0x0185:
            r5 = r5 | r10
            r11.putInt(r7, r13, r2)
            goto L_0x019c
        L_0x018a:
            r8 = r3
            r9 = r19
            r3 = 2
            r18 = -1
            if (r2 != r3) goto L_0x01d1
            r5 = r5 | r10
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zza(r15, r1, r12)
            java.lang.Object r2 = r12.zzc
            r11.putObject(r7, r13, r2)
        L_0x019c:
            r14 = r39
            r13 = r40
            r3 = r8
            r4 = r9
            goto L_0x01ca
        L_0x01a3:
            r8 = r3
            r9 = r19
            r3 = 2
            r18 = -1
            if (r2 != r3) goto L_0x01d1
            r10 = r10 | r5
            java.lang.Object r13 = r0.zzx(r7, r8)
            com.google.android.gms.internal.play_billing.zzgm r2 = r0.zzv(r8)
            r4 = r1
            r1 = r13
            r3 = r37
            r5 = r39
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzF(r7, r8, r13)
            r14 = r39
            r13 = r40
            r3 = r8
            r4 = r9
            r5 = r10
        L_0x01ca:
            r2 = r21
            r6 = r25
            r8 = 0
            goto L_0x001b
        L_0x01d1:
            r4 = r1
            goto L_0x0300
        L_0x01d4:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 2
            r18 = -1
            if (r2 != r1) goto L_0x0300
            r1 = r30 & r22
            if (r1 == 0) goto L_0x02d6
            r1 = r5 | r10
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r12)
            int r3 = r12.zza
            if (r3 < 0) goto L_0x02d1
            if (r3 != 0) goto L_0x01f6
            r6 = r27
            r12.zzc = r6
            r22 = r1
            r6 = 0
            goto L_0x02a7
        L_0x01f6:
            int r4 = com.google.android.gms.internal.play_billing.zzhs.zza
            int r4 = r15.length
            int r5 = r4 - r2
            r6 = r2 | r3
            int r5 = r5 - r3
            r5 = r5 | r6
            if (r5 < 0) goto L_0x02ad
            int r4 = r2 + r3
            char[] r3 = new char[r3]
            r5 = 0
        L_0x0206:
            if (r2 >= r4) goto L_0x0219
            byte r6 = r15[r2]
            boolean r10 = com.google.android.gms.internal.play_billing.zzho.zzd(r6)
            if (r10 == 0) goto L_0x0219
            int r2 = r2 + 1
            int r10 = r5 + 1
            char r6 = (char) r6
            r3[r5] = r6
            r5 = r10
            goto L_0x0206
        L_0x0219:
            if (r2 >= r4) goto L_0x029c
            int r6 = r2 + 1
            byte r2 = r15[r2]
            boolean r10 = com.google.android.gms.internal.play_billing.zzho.zzd(r2)
            if (r10 == 0) goto L_0x023e
            int r10 = r5 + 1
            char r2 = (char) r2
            r3[r5] = r2
            r2 = r6
        L_0x022b:
            r5 = r10
            if (r2 >= r4) goto L_0x0219
            byte r6 = r15[r2]
            boolean r10 = com.google.android.gms.internal.play_billing.zzho.zzd(r6)
            if (r10 == 0) goto L_0x0219
            int r2 = r2 + 1
            int r10 = r5 + 1
            char r6 = (char) r6
            r3[r5] = r6
            goto L_0x022b
        L_0x023e:
            r10 = -32
            if (r2 >= r10) goto L_0x0256
            if (r6 >= r4) goto L_0x0251
            int r10 = r5 + 1
            int r16 = r6 + 1
            byte r6 = r15[r6]
            com.google.android.gms.internal.play_billing.zzho.zzc(r2, r6, r3, r5)
            r5 = r10
            r2 = r16
            goto L_0x0219
        L_0x0251:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0256:
            r10 = -16
            if (r2 >= r10) goto L_0x0276
            int r10 = r4 + -1
            if (r6 >= r10) goto L_0x0271
            int r10 = r5 + 1
            int r16 = r6 + 1
            byte r6 = r15[r6]
            int r19 = r16 + 1
            r22 = r1
            byte r1 = r15[r16]
            com.google.android.gms.internal.play_billing.zzho.zzb(r2, r6, r1, r3, r5)
            r5 = r10
            r2 = r19
            goto L_0x0294
        L_0x0271:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0276:
            r22 = r1
            int r1 = r4 + -2
            if (r6 >= r1) goto L_0x0297
            int r1 = r6 + 1
            byte r27 = r15[r6]
            int r6 = r1 + 1
            byte r28 = r15[r1]
            int r1 = r6 + 1
            byte r29 = r15[r6]
            r26 = r2
            r30 = r3
            r31 = r5
            com.google.android.gms.internal.play_billing.zzho.zza(r26, r27, r28, r29, r30, r31)
            int r5 = r5 + 2
            r2 = r1
        L_0x0294:
            r1 = r22
            goto L_0x0219
        L_0x0297:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x029c:
            r22 = r1
            java.lang.String r1 = new java.lang.String
            r6 = 0
            r1.<init>(r3, r6, r5)
            r12.zzc = r1
            r2 = r4
        L_0x02a7:
            r1 = r2
            r19 = r6
            r5 = r22
            goto L_0x02f4
        L_0x02ad:
            r6 = 0
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5[r6] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4 = 1
            r5[r4] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r3 = 2
            r5[r3] = r2
            java.lang.String r2 = "buffer length=%d, index=%d, size=%d"
            java.lang.String r2 = java.lang.String.format(r2, r5)
            r1.<init>(r2)
            throw r1
        L_0x02d1:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x02d6:
            r6 = r27
            r19 = 0
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r12)
            int r2 = r12.zza
            if (r2 < 0) goto L_0x02fb
            r3 = r5 | r10
            if (r2 != 0) goto L_0x02e9
            r12.zzc = r6
            goto L_0x02f3
        L_0x02e9:
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r5 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r4.<init>(r15, r1, r2, r5)
            r12.zzc = r4
            int r1 = r1 + r2
        L_0x02f3:
            r5 = r3
        L_0x02f4:
            java.lang.Object r2 = r12.zzc
            r11.putObject(r7, r13, r2)
            goto L_0x03c6
        L_0x02fb:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x0300:
            r3 = r8
            r19 = r9
            r6 = r11
            r1 = r12
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r17 = 0
            r8 = r5
            goto L_0x03df
        L_0x030d:
            r4 = r1
            r8 = r3
            r9 = r19
            r18 = -1
            r19 = 0
            if (r2 != 0) goto L_0x03d4
            r5 = r5 | r10
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r4, r12)
            long r2 = r12.zzb
            int r2 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x0324
            r2 = 1
            goto L_0x0326
        L_0x0324:
            r2 = r19
        L_0x0326:
            com.google.android.gms.internal.play_billing.zzhn.zzm(r7, r13, r2)
            goto L_0x03c6
        L_0x032b:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 5
            r18 = -1
            r19 = 0
            if (r2 != r1) goto L_0x03d4
            int r1 = r4 + 4
            r5 = r5 | r10
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r4)
            r11.putInt(r7, r13, r2)
            goto L_0x03c6
        L_0x0342:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 1
            r18 = -1
            r19 = 0
            if (r2 != r1) goto L_0x03d4
            int r16 = r4 + 8
            r10 = r10 | r5
            long r5 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r4)
            r1 = r11
            r2 = r36
            r3 = r13
            r1.putLong(r2, r3, r5)
            goto L_0x0389
        L_0x035c:
            r4 = r1
            r8 = r3
            r9 = r19
            r18 = -1
            r19 = 0
            if (r2 != 0) goto L_0x03d4
            r5 = r5 | r10
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r12)
            int r2 = r12.zza
            r11.putInt(r7, r13, r2)
            goto L_0x03c6
        L_0x0371:
            r4 = r1
            r8 = r3
            r9 = r19
            r18 = -1
            r19 = 0
            if (r2 != 0) goto L_0x03d4
            r10 = r10 | r5
            int r16 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r4, r12)
            long r5 = r12.zzb
            r1 = r11
            r2 = r36
            r3 = r13
            r1.putLong(r2, r3, r5)
        L_0x0389:
            r14 = r39
            r13 = r40
            r3 = r8
            r4 = r9
            r5 = r10
            r1 = r16
            goto L_0x03cc
        L_0x0393:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 5
            r18 = -1
            r19 = 0
            if (r2 != r1) goto L_0x03d4
            int r1 = r4 + 4
            r5 = r5 | r10
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r4)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            com.google.android.gms.internal.play_billing.zzhn.zzp(r7, r13, r2)
            goto L_0x03c6
        L_0x03ad:
            r4 = r1
            r8 = r3
            r9 = r19
            r1 = 1
            r18 = -1
            r19 = 0
            if (r2 != r1) goto L_0x03d4
            int r1 = r4 + 8
            r5 = r5 | r10
            long r2 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r4)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            com.google.android.gms.internal.play_billing.zzhn.zzo(r7, r13, r2)
        L_0x03c6:
            r14 = r39
            r13 = r40
            r3 = r8
            r4 = r9
        L_0x03cc:
            r8 = r19
            r2 = r21
        L_0x03d0:
            r6 = r25
            goto L_0x001b
        L_0x03d4:
            r3 = r8
            r6 = r11
            r1 = r12
            r17 = r19
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r5
            r19 = r9
        L_0x03df:
            r5 = r39
            r5 = r1
            r11 = r3
            r3 = r4
            r33 = r6
            r20 = r8
            r12 = r19
            r10 = r21
            r8 = r40
            goto L_0x0c77
        L_0x03f0:
            r20 = r5
            r25 = r6
            r30 = r8
            r6 = r11
            r8 = r27
            r17 = 0
            r18 = -1
            r5 = r39
            r11 = r1
            r1 = r12
            r12 = r21
            r9 = 27
            r27 = 10
            if (r4 != r9) goto L_0x0456
            r9 = 2
            if (r2 != r9) goto L_0x044d
            java.lang.Object r2 = r6.getObject(r7, r13)
            com.google.android.gms.internal.play_billing.zzfc r2 = (com.google.android.gms.internal.play_billing.zzfc) r2
            boolean r4 = r2.zzc()
            if (r4 != 0) goto L_0x042a
            int r4 = r2.size()
            if (r4 != 0) goto L_0x041f
            goto L_0x0421
        L_0x041f:
            int r27 = r4 + r4
        L_0x0421:
            r4 = r27
            com.google.android.gms.internal.play_billing.zzfc r2 = r2.zzd(r4)
            r6.putObject(r7, r13, r2)
        L_0x042a:
            r13 = r2
            com.google.android.gms.internal.play_billing.zzgm r8 = r0.zzv(r3)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r19
            r10 = r37
            r4 = r12
            r12 = r39
            r14 = r41
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zze(r8, r9, r10, r11, r12, r13, r14)
            r13 = r40
            r12 = r1
            r2 = r4
            r14 = r5
            r11 = r6
            r1 = r8
            r8 = r17
            r4 = r19
            r5 = r20
            goto L_0x03d0
        L_0x044d:
            r33 = r6
            r8 = r11
            r6 = r5
            r5 = r1
            r1 = r19
            goto L_0x0a5d
        L_0x0456:
            r9 = 49
            if (r4 > r9) goto L_0x0a20
            r9 = r30
            long r9 = (long) r9
            r30 = r3
            sun.misc.Unsafe r3 = zzb
            java.lang.Object r22 = r3.getObject(r7, r13)
            r31 = r6
            r6 = r22
            com.google.android.gms.internal.play_billing.zzfc r6 = (com.google.android.gms.internal.play_billing.zzfc) r6
            boolean r22 = r6.zzc()
            if (r22 != 0) goto L_0x0486
            int r22 = r6.size()
            if (r22 != 0) goto L_0x0478
            goto L_0x047a
        L_0x0478:
            int r27 = r22 + r22
        L_0x047a:
            r32 = r8
            r8 = r27
            com.google.android.gms.internal.play_billing.zzfc r6 = r6.zzd(r8)
            r3.putObject(r7, r13, r6)
            goto L_0x0488
        L_0x0486:
            r32 = r8
        L_0x0488:
            r13 = r6
            switch(r4) {
                case 18: goto L_0x0989;
                case 19: goto L_0x092e;
                case 20: goto L_0x08e0;
                case 21: goto L_0x08e0;
                case 22: goto L_0x08af;
                case 23: goto L_0x0861;
                case 24: goto L_0x0812;
                case 25: goto L_0x07ac;
                case 26: goto L_0x06e1;
                case 27: goto L_0x06a3;
                case 28: goto L_0x063d;
                case 29: goto L_0x08af;
                case 30: goto L_0x0589;
                case 31: goto L_0x0812;
                case 32: goto L_0x0861;
                case 33: goto L_0x0523;
                case 34: goto L_0x04b9;
                case 35: goto L_0x0989;
                case 36: goto L_0x092e;
                case 37: goto L_0x08e0;
                case 38: goto L_0x08e0;
                case 39: goto L_0x08af;
                case 40: goto L_0x0861;
                case 41: goto L_0x0812;
                case 42: goto L_0x07ac;
                case 43: goto L_0x08af;
                case 44: goto L_0x0589;
                case 45: goto L_0x0812;
                case 46: goto L_0x0861;
                case 47: goto L_0x0523;
                case 48: goto L_0x04b9;
                default: goto L_0x048c;
            }
        L_0x048c:
            r9 = r1
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            r1 = 3
            r10 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r1) goto L_0x0a01
            r1 = r7 & -8
            r19 = r1 | 4
            com.google.android.gms.internal.play_billing.zzgm r21 = r0.zzv(r11)
            r1 = r21
            r2 = r37
            r3 = r8
            r4 = r39
            r5 = r19
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r9.zzc
            r13.add(r2)
            goto L_0x09e3
        L_0x04b9:
            r3 = 2
            if (r2 != r3) goto L_0x04e8
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r11, r1)
            int r3 = r1.zza
            int r3 = r3 + r2
        L_0x04c5:
            if (r2 >= r3) goto L_0x04d5
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r1)
            long r8 = r1.zzb
            long r8 = com.google.android.gms.internal.play_billing.zzea.zzc(r8)
            r13.zzf(r8)
            goto L_0x04c5
        L_0x04d5:
            if (r2 != r3) goto L_0x04e3
            r9 = r1
            r1 = r2
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            goto L_0x0629
        L_0x04e3:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x04e8:
            if (r2 != 0) goto L_0x0518
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r11, r1)
            long r3 = r1.zzb
            long r3 = com.google.android.gms.internal.play_billing.zzea.zzc(r3)
            r13.zzf(r3)
        L_0x04f9:
            if (r2 >= r5) goto L_0x0515
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            r14 = r19
            if (r14 != r4) goto L_0x0572
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r3, r1)
            long r3 = r1.zzb
            long r3 = com.google.android.gms.internal.play_billing.zzea.zzc(r3)
            r13.zzf(r3)
            r19 = r14
            goto L_0x04f9
        L_0x0515:
            r14 = r19
            goto L_0x0572
        L_0x0518:
            r9 = r1
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            goto L_0x06dc
        L_0x0523:
            r14 = r19
            r3 = 2
            if (r2 != r3) goto L_0x0549
            com.google.android.gms.internal.play_billing.zzey r13 = (com.google.android.gms.internal.play_billing.zzey) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r11, r1)
            int r3 = r1.zza
            int r3 = r3 + r2
        L_0x0531:
            if (r2 >= r3) goto L_0x0541
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            int r4 = com.google.android.gms.internal.play_billing.zzea.zzb(r4)
            r13.zzf(r4)
            goto L_0x0531
        L_0x0541:
            if (r2 != r3) goto L_0x0544
            goto L_0x0572
        L_0x0544:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x0549:
            if (r2 != 0) goto L_0x0580
            com.google.android.gms.internal.play_billing.zzey r13 = (com.google.android.gms.internal.play_billing.zzey) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r11, r1)
            int r3 = r1.zza
            int r3 = com.google.android.gms.internal.play_billing.zzea.zzb(r3)
            r13.zzf(r3)
        L_0x055a:
            if (r2 >= r5) goto L_0x0572
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r1)
            int r4 = r1.zza
            if (r14 != r4) goto L_0x0572
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r3, r1)
            int r3 = r1.zza
            int r3 = com.google.android.gms.internal.play_billing.zzea.zzb(r3)
            r13.zzf(r3)
            goto L_0x055a
        L_0x0572:
            r9 = r1
            r1 = r2
            r8 = r11
            r7 = r14
            r11 = r30
            r33 = r31
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r14 = r5
            goto L_0x0a02
        L_0x0580:
            r9 = r1
            r8 = r11
            r7 = r14
            r11 = r30
            r33 = r31
            goto L_0x0637
        L_0x0589:
            r14 = r19
            r3 = 2
            if (r2 != r3) goto L_0x0599
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzf(r15, r11, r13, r1)
            r10 = r1
            r8 = r5
            r9 = r30
            r33 = r31
            goto L_0x05ae
        L_0x0599:
            if (r2 != 0) goto L_0x062e
            r10 = r1
            r1 = r14
            r2 = r37
            r9 = r30
            r3 = r11
            r4 = r39
            r8 = r5
            r5 = r13
            r33 = r31
            r6 = r41
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzj(r1, r2, r3, r4, r5, r6)
        L_0x05ae:
            com.google.android.gms.internal.play_billing.zzfb r1 = r0.zzu(r9)
            com.google.android.gms.internal.play_billing.zzhd r3 = r0.zzm
            int r4 = com.google.android.gms.internal.play_billing.zzgo.zza
            if (r1 == 0) goto L_0x061e
            boolean r4 = r13 instanceof java.util.RandomAccess
            if (r4 == 0) goto L_0x05f8
            int r4 = r13.size()
            r38 = r2
            r2 = r16
            r5 = r17
            r6 = r5
        L_0x05c7:
            if (r5 >= r4) goto L_0x05ee
            java.lang.Object r19 = r13.get(r5)
            java.lang.Integer r19 = (java.lang.Integer) r19
            int r0 = r19.intValue()
            boolean r19 = r1.zza(r0)
            if (r19 == 0) goto L_0x05e5
            if (r5 == r6) goto L_0x05e2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r13.set(r6, r0)
        L_0x05e2:
            int r6 = r6 + 1
            goto L_0x05e9
        L_0x05e5:
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzgo.zzo(r7, r12, r0, r2, r3)
        L_0x05e9:
            int r5 = r5 + 1
            r0 = r35
            goto L_0x05c7
        L_0x05ee:
            if (r6 == r4) goto L_0x0620
            java.util.List r0 = r13.subList(r6, r4)
            r0.clear()
            goto L_0x0620
        L_0x05f8:
            r38 = r2
            java.util.Iterator r0 = r13.iterator()
            r2 = r16
        L_0x0600:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0620
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r5 = r1.zza(r4)
            if (r5 != 0) goto L_0x0600
            java.lang.Object r2 = com.google.android.gms.internal.play_billing.zzgo.zzo(r7, r12, r4, r2, r3)
            r0.remove()
            goto L_0x0600
        L_0x061e:
            r38 = r2
        L_0x0620:
            r0 = r35
            r1 = r38
            r7 = r14
        L_0x0625:
            r14 = r8
            r8 = r11
            r11 = r9
            r9 = r10
        L_0x0629:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0a02
        L_0x062e:
            r33 = r31
            r0 = r35
            r9 = r1
            r8 = r11
            r7 = r14
            r11 = r30
        L_0x0637:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r14 = r5
            goto L_0x0a01
        L_0x063d:
            r10 = r1
            r8 = r5
            r14 = r19
            r9 = r30
            r33 = r31
            r0 = 2
            if (r2 != r0) goto L_0x06d5
            int r0 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r11, r10)
            int r1 = r10.zza
            if (r1 < 0) goto L_0x069e
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x0699
            if (r1 != 0) goto L_0x065c
            com.google.android.gms.internal.play_billing.zzdw r1 = com.google.android.gms.internal.play_billing.zzdw.zzb
            r13.add(r1)
            goto L_0x0664
        L_0x065c:
            com.google.android.gms.internal.play_billing.zzdw r2 = com.google.android.gms.internal.play_billing.zzdw.zzl(r15, r0, r1)
            r13.add(r2)
        L_0x0663:
            int r0 = r0 + r1
        L_0x0664:
            if (r0 >= r8) goto L_0x0694
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r0, r10)
            int r2 = r10.zza
            if (r14 != r2) goto L_0x0694
            int r0 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r10)
            int r1 = r10.zza
            if (r1 < 0) goto L_0x068f
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x068a
            if (r1 != 0) goto L_0x0682
            com.google.android.gms.internal.play_billing.zzdw r1 = com.google.android.gms.internal.play_billing.zzdw.zzb
            r13.add(r1)
            goto L_0x0664
        L_0x0682:
            com.google.android.gms.internal.play_billing.zzdw r2 = com.google.android.gms.internal.play_billing.zzdw.zzl(r15, r0, r1)
            r13.add(r2)
            goto L_0x0663
        L_0x068a:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r0
        L_0x068f:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r0
        L_0x0694:
            r1 = r0
            r7 = r14
            r0 = r35
            goto L_0x0625
        L_0x0699:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r0
        L_0x069e:
            com.google.android.gms.internal.play_billing.zzff r0 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r0
        L_0x06a3:
            r10 = r1
            r8 = r5
            r14 = r19
            r9 = r30
            r33 = r31
            r0 = 2
            if (r2 != r0) goto L_0x06d5
            r0 = r35
            com.google.android.gms.internal.play_billing.zzgm r1 = r0.zzv(r9)
            r6 = r8
            r8 = r1
            r5 = r9
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r14
            r3 = r10
            r10 = r37
            r1 = r11
            r2 = r12
            r12 = r39
            r7 = r14
            r14 = r41
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zze(r8, r9, r10, r11, r12, r13, r14)
            r12 = r2
            r9 = r3
            r10 = r4
            r11 = r5
            r14 = r6
            r34 = r8
            r8 = r1
            r1 = r34
            goto L_0x0a02
        L_0x06d5:
            r0 = r35
            r7 = r14
            r14 = r8
            r8 = r11
            r11 = r9
            r9 = r10
        L_0x06dc:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0a01
        L_0x06e1:
            r3 = r1
            r6 = r5
            r1 = r11
            r7 = r19
            r5 = r30
            r33 = r31
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 2
            if (r2 != r8) goto L_0x07a5
            r21 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r9 & r21
            int r2 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r2 != 0) goto L_0x0743
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r3)
            int r8 = r3.zza
            if (r8 < 0) goto L_0x073e
            if (r8 != 0) goto L_0x0709
            r11 = r32
            r13.add(r11)
            goto L_0x0716
        L_0x0709:
            r11 = r32
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r9.<init>(r15, r2, r8, r10)
            r13.add(r9)
        L_0x0715:
            int r2 = r2 + r8
        L_0x0716:
            if (r2 >= r6) goto L_0x08c2
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r3)
            int r9 = r3.zza
            if (r7 != r9) goto L_0x08c2
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r8, r3)
            int r8 = r3.zza
            if (r8 < 0) goto L_0x0739
            if (r8 != 0) goto L_0x072e
            r13.add(r11)
            goto L_0x0716
        L_0x072e:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r9.<init>(r15, r2, r8, r10)
            r13.add(r9)
            goto L_0x0715
        L_0x0739:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x073e:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x0743:
            r11 = r32
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r3)
            int r8 = r3.zza
            if (r8 < 0) goto L_0x07a0
            if (r8 != 0) goto L_0x0753
            r13.add(r11)
            goto L_0x0766
        L_0x0753:
            int r9 = r2 + r8
            boolean r10 = com.google.android.gms.internal.play_billing.zzhs.zze(r15, r2, r9)
            if (r10 == 0) goto L_0x079b
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r10.<init>(r15, r2, r8, r14)
            r13.add(r10)
        L_0x0765:
            r2 = r9
        L_0x0766:
            if (r2 >= r6) goto L_0x08c2
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r3)
            int r9 = r3.zza
            if (r7 != r9) goto L_0x08c2
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r8, r3)
            int r8 = r3.zza
            if (r8 < 0) goto L_0x0796
            if (r8 != 0) goto L_0x077e
            r13.add(r11)
            goto L_0x0766
        L_0x077e:
            int r9 = r2 + r8
            boolean r10 = com.google.android.gms.internal.play_billing.zzhs.zze(r15, r2, r9)
            if (r10 == 0) goto L_0x0791
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r10.<init>(r15, r2, r8, r14)
            r13.add(r10)
            goto L_0x0765
        L_0x0791:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0796:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x079b:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x07a0:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzd()
            throw r1
        L_0x07a5:
            r8 = r1
            r9 = r3
            r10 = r4
            r11 = r5
            r14 = r6
            goto L_0x0a01
        L_0x07ac:
            r3 = r1
            r6 = r5
            r1 = r11
            r7 = r19
            r5 = r30
            r33 = r31
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 2
            if (r2 != r8) goto L_0x07e1
            com.google.android.gms.internal.play_billing.zzdl r13 = (com.google.android.gms.internal.play_billing.zzdl) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r3)
            int r8 = r3.zza
            int r8 = r8 + r2
        L_0x07c4:
            if (r2 >= r8) goto L_0x07d8
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r3)
            long r9 = r3.zzb
            int r9 = (r9 > r23 ? 1 : (r9 == r23 ? 0 : -1))
            if (r9 == 0) goto L_0x07d2
            r9 = 1
            goto L_0x07d4
        L_0x07d2:
            r9 = r17
        L_0x07d4:
            r13.zze(r9)
            goto L_0x07c4
        L_0x07d8:
            if (r2 != r8) goto L_0x07dc
            goto L_0x08c2
        L_0x07dc:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x07e1:
            if (r2 != 0) goto L_0x07a5
            com.google.android.gms.internal.play_billing.zzdl r13 = (com.google.android.gms.internal.play_billing.zzdl) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r1, r3)
            long r8 = r3.zzb
            int r8 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x07f1
            r8 = 1
            goto L_0x07f3
        L_0x07f1:
            r8 = r17
        L_0x07f3:
            r13.zze(r8)
        L_0x07f6:
            if (r2 >= r6) goto L_0x08c2
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r3)
            int r9 = r3.zza
            if (r7 != r9) goto L_0x08c2
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r8, r3)
            long r8 = r3.zzb
            int r8 = (r8 > r23 ? 1 : (r8 == r23 ? 0 : -1))
            if (r8 == 0) goto L_0x080c
            r8 = 1
            goto L_0x080e
        L_0x080c:
            r8 = r17
        L_0x080e:
            r13.zze(r8)
            goto L_0x07f6
        L_0x0812:
            r3 = r1
            r6 = r5
            r1 = r11
            r7 = r19
            r5 = r30
            r33 = r31
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 2
            if (r2 != r8) goto L_0x083f
            com.google.android.gms.internal.play_billing.zzey r13 = (com.google.android.gms.internal.play_billing.zzey) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r3)
            int r8 = r3.zza
            int r8 = r8 + r2
        L_0x082a:
            if (r2 >= r8) goto L_0x0836
            int r9 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r2)
            r13.zzf(r9)
            int r2 = r2 + 4
            goto L_0x082a
        L_0x0836:
            if (r2 != r8) goto L_0x083a
            goto L_0x08c2
        L_0x083a:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x083f:
            r8 = 5
            if (r2 != r8) goto L_0x07a5
            int r2 = r1 + 4
            com.google.android.gms.internal.play_billing.zzey r13 = (com.google.android.gms.internal.play_billing.zzey) r13
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r1)
            r13.zzf(r8)
        L_0x084d:
            if (r2 >= r6) goto L_0x08c2
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r3)
            int r9 = r3.zza
            if (r7 != r9) goto L_0x08c2
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r8)
            r13.zzf(r2)
            int r2 = r8 + 4
            goto L_0x084d
        L_0x0861:
            r3 = r1
            r6 = r5
            r1 = r11
            r7 = r19
            r5 = r30
            r33 = r31
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 2
            if (r2 != r8) goto L_0x088d
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r3)
            int r8 = r3.zza
            int r8 = r8 + r2
        L_0x0879:
            if (r2 >= r8) goto L_0x0885
            long r9 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r2)
            r13.zzf(r9)
            int r2 = r2 + 8
            goto L_0x0879
        L_0x0885:
            if (r2 != r8) goto L_0x0888
            goto L_0x08c2
        L_0x0888:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x088d:
            r8 = 1
            if (r2 != r8) goto L_0x07a5
            int r2 = r1 + 8
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            long r8 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r1)
            r13.zzf(r8)
        L_0x089b:
            if (r2 >= r6) goto L_0x08c2
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r2, r3)
            int r9 = r3.zza
            if (r7 != r9) goto L_0x08c2
            long r9 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r8)
            r13.zzf(r9)
            int r2 = r8 + 8
            goto L_0x089b
        L_0x08af:
            r3 = r1
            r6 = r5
            r1 = r11
            r7 = r19
            r5 = r30
            r33 = r31
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 2
            if (r2 != r8) goto L_0x08ca
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzf(r15, r1, r13, r3)
        L_0x08c2:
            r8 = r1
            r1 = r2
            r9 = r3
            r10 = r4
            r11 = r5
            r14 = r6
            goto L_0x0a02
        L_0x08ca:
            if (r2 != 0) goto L_0x07a5
            r8 = r1
            r1 = r7
            r2 = r37
            r9 = r3
            r3 = r8
            r10 = r4
            r4 = r39
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzj(r1, r2, r3, r4, r5, r6)
            goto L_0x0a02
        L_0x08e0:
            r9 = r1
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            r1 = 2
            r10 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r1) goto L_0x090d
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r8, r9)
            int r2 = r9.zza
            int r2 = r2 + r1
        L_0x08f8:
            if (r1 >= r2) goto L_0x0904
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r1, r9)
            long r3 = r9.zzb
            r13.zzf(r3)
            goto L_0x08f8
        L_0x0904:
            if (r1 != r2) goto L_0x0908
            goto L_0x0a02
        L_0x0908:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x090d:
            if (r2 != 0) goto L_0x0a01
            com.google.android.gms.internal.play_billing.zzfr r13 = (com.google.android.gms.internal.play_billing.zzfr) r13
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r8, r9)
            long r2 = r9.zzb
            r13.zzf(r2)
        L_0x091a:
            if (r1 >= r14) goto L_0x0a02
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r9)
            int r3 = r9.zza
            if (r7 != r3) goto L_0x0a02
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r2, r9)
            long r2 = r9.zzb
            r13.zzf(r2)
            goto L_0x091a
        L_0x092e:
            r9 = r1
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            r1 = 2
            r10 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r1) goto L_0x095f
            com.google.android.gms.internal.play_billing.zzeq r13 = (com.google.android.gms.internal.play_billing.zzeq) r13
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r8, r9)
            int r2 = r9.zza
            int r2 = r2 + r1
        L_0x0946:
            if (r1 >= r2) goto L_0x0956
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r1)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            r13.zze(r3)
            int r1 = r1 + 4
            goto L_0x0946
        L_0x0956:
            if (r1 != r2) goto L_0x095a
            goto L_0x0a02
        L_0x095a:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x095f:
            r1 = 5
            if (r2 != r1) goto L_0x0a01
            int r1 = r8 + 4
            com.google.android.gms.internal.play_billing.zzeq r13 = (com.google.android.gms.internal.play_billing.zzeq) r13
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r8)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r13.zze(r2)
        L_0x0971:
            if (r1 >= r14) goto L_0x0a02
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r9)
            int r3 = r9.zza
            if (r7 != r3) goto L_0x0a02
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r2)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
            int r1 = r2 + 4
            goto L_0x0971
        L_0x0989:
            r9 = r1
            r14 = r5
            r8 = r11
            r7 = r19
            r11 = r30
            r33 = r31
            r1 = 2
            r10 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r1) goto L_0x09b9
            com.google.android.gms.internal.play_billing.zzeg r13 = (com.google.android.gms.internal.play_billing.zzeg) r13
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r8, r9)
            int r2 = r9.zza
            int r2 = r2 + r1
        L_0x09a1:
            if (r1 >= r2) goto L_0x09b1
            long r3 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r1)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            r13.zze(r3)
            int r1 = r1 + 8
            goto L_0x09a1
        L_0x09b1:
            if (r1 != r2) goto L_0x09b4
            goto L_0x0a02
        L_0x09b4:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r1
        L_0x09b9:
            r1 = 1
            if (r2 != r1) goto L_0x0a01
            int r1 = r8 + 8
            com.google.android.gms.internal.play_billing.zzeg r13 = (com.google.android.gms.internal.play_billing.zzeg) r13
            long r2 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r8)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            r13.zze(r2)
        L_0x09cb:
            if (r1 >= r14) goto L_0x0a02
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r9)
            int r3 = r9.zza
            if (r7 != r3) goto L_0x0a02
            long r3 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r2)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            r13.zze(r3)
            int r1 = r2 + 8
            goto L_0x09cb
        L_0x09e3:
            if (r1 >= r14) goto L_0x0a02
            int r3 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r1, r9)
            int r2 = r9.zza
            if (r7 != r2) goto L_0x0a02
            r1 = r21
            r2 = r37
            r4 = r39
            r5 = r19
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r9.zzc
            r13.add(r2)
            goto L_0x09e3
        L_0x0a01:
            r1 = r8
        L_0x0a02:
            if (r1 == r8) goto L_0x0a16
            r13 = r40
            r4 = r7
            r3 = r11
            r2 = r12
            r8 = r17
            r5 = r20
            r6 = r25
            r11 = r33
            r7 = r36
            r12 = r9
            goto L_0x001b
        L_0x0a16:
            r8 = r40
            r3 = r1
            r5 = r9
            r10 = r12
            r12 = r7
            r7 = r36
            goto L_0x0c77
        L_0x0a20:
            r33 = r6
            r7 = r19
            r9 = r30
            r6 = r5
            r5 = r1
            r34 = r11
            r11 = r8
            r8 = r34
            r1 = 50
            if (r4 != r1) goto L_0x0a65
            r1 = 2
            if (r2 != r1) goto L_0x0a5a
            sun.misc.Unsafe r1 = zzb
            java.lang.Object r2 = r0.zzw(r3)
            r7 = r36
            java.lang.Object r3 = r1.getObject(r7, r13)
            r4 = r3
            com.google.android.gms.internal.play_billing.zzfw r4 = (com.google.android.gms.internal.play_billing.zzfw) r4
            boolean r4 = r4.zze()
            if (r4 != 0) goto L_0x0a57
            com.google.android.gms.internal.play_billing.zzfw r4 = com.google.android.gms.internal.play_billing.zzfw.zza()
            com.google.android.gms.internal.play_billing.zzfw r4 = r4.zzb()
            com.google.android.gms.internal.play_billing.zzfx.zza(r4, r3)
            r1.putObject(r7, r13, r4)
        L_0x0a57:
            com.google.android.gms.internal.play_billing.zzfv r2 = (com.google.android.gms.internal.play_billing.zzfv) r2
            throw r16
        L_0x0a5a:
            r1 = r7
            r7 = r36
        L_0x0a5d:
            r11 = r3
            r3 = r8
            r10 = r12
            r8 = r40
            r12 = r1
            goto L_0x0c77
        L_0x0a65:
            r1 = r7
            r7 = r36
            int r19 = r3 + 2
            sun.misc.Unsafe r6 = zzb
            r10 = r10[r19]
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r19
            r21 = r8
            r30 = r9
            long r8 = (long) r10
            switch(r4) {
                case 51: goto L_0x0c3e;
                case 52: goto L_0x0c20;
                case 53: goto L_0x0c07;
                case 54: goto L_0x0c07;
                case 55: goto L_0x0bee;
                case 56: goto L_0x0bd3;
                case 57: goto L_0x0bb8;
                case 58: goto L_0x0b95;
                case 59: goto L_0x0b53;
                case 60: goto L_0x0b27;
                case 61: goto L_0x0b0f;
                case 62: goto L_0x0bee;
                case 63: goto L_0x0adf;
                case 64: goto L_0x0bb8;
                case 65: goto L_0x0bd3;
                case 66: goto L_0x0ac5;
                case 67: goto L_0x0aab;
                case 68: goto L_0x0a83;
                default: goto L_0x0a7b;
            }
        L_0x0a7b:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            goto L_0x0c5c
        L_0x0a83:
            r4 = 3
            if (r2 != r4) goto L_0x0a7b
            r2 = r1 & -8
            r13 = r2 | 4
            java.lang.Object r2 = r0.zzy(r7, r12, r3)
            com.google.android.gms.internal.play_billing.zzgm r9 = r0.zzv(r3)
            r4 = r21
            r8 = r2
            r10 = r37
            r11 = r4
            r6 = r12
            r12 = r39
            r14 = r41
            int r8 = com.google.android.gms.internal.play_billing.zzdk.zzl(r8, r9, r10, r11, r12, r13, r14)
            r0.zzG(r7, r6, r3, r2)
            r12 = r1
            r30 = r3
            r10 = r6
            r1 = r8
            goto L_0x0c5d
        L_0x0aab:
            r10 = r12
            r4 = r21
            if (r2 != 0) goto L_0x0b4e
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r4, r5)
            long r11 = r5.zzb
            long r11 = com.google.android.gms.internal.play_billing.zzea.zzc(r11)
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r6.putObject(r7, r13, r11)
            r6.putInt(r7, r8, r10)
            goto L_0x0b21
        L_0x0ac5:
            r10 = r12
            r4 = r21
            if (r2 != 0) goto L_0x0b4e
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r5)
            int r11 = r5.zza
            int r11 = com.google.android.gms.internal.play_billing.zzea.zzb(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r6.putObject(r7, r13, r11)
            r6.putInt(r7, r8, r10)
            goto L_0x0b21
        L_0x0adf:
            r10 = r12
            r4 = r21
            if (r2 != 0) goto L_0x0b4e
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r5)
            int r11 = r5.zza
            com.google.android.gms.internal.play_billing.zzfb r12 = r0.zzu(r3)
            if (r12 == 0) goto L_0x0b04
            boolean r12 = r12.zza(r11)
            if (r12 == 0) goto L_0x0af7
            goto L_0x0b04
        L_0x0af7:
            com.google.android.gms.internal.play_billing.zzhe r6 = zzd(r36)
            long r8 = (long) r11
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r6.zzj(r1, r8)
            goto L_0x0b21
        L_0x0b04:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r6.putObject(r7, r13, r11)
            r6.putInt(r7, r8, r10)
            goto L_0x0b21
        L_0x0b0f:
            r10 = r12
            r4 = r21
            r11 = 2
            if (r2 != r11) goto L_0x0b4e
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zza(r15, r4, r5)
            java.lang.Object r11 = r5.zzc
            r6.putObject(r7, r13, r11)
            r6.putInt(r7, r8, r10)
        L_0x0b21:
            r12 = r1
            r1 = r2
            r30 = r3
            goto L_0x0c5d
        L_0x0b27:
            r10 = r12
            r4 = r21
            r11 = 2
            if (r2 != r11) goto L_0x0b4e
            java.lang.Object r8 = r0.zzy(r7, r10, r3)
            com.google.android.gms.internal.play_billing.zzgm r2 = r0.zzv(r3)
            r12 = r1
            r9 = r19
            r1 = r8
            r11 = r3
            r3 = r37
            r13 = r4
            r14 = r5
            r5 = r39
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzm(r1, r2, r3, r4, r5, r6)
            r0.zzG(r7, r10, r11, r8)
            r30 = r11
            r5 = r14
            goto L_0x0c5d
        L_0x0b4e:
            r12 = r1
            r30 = r3
            goto L_0x0c5c
        L_0x0b53:
            r10 = r12
            r4 = r21
            r12 = r1
            r1 = r3
            r3 = 2
            if (r2 != r3) goto L_0x0b91
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r5)
            int r3 = r5.zza
            if (r3 != 0) goto L_0x0b69
            r6.putObject(r7, r13, r11)
            r30 = r1
            goto L_0x0b8b
        L_0x0b69:
            r11 = r30 & r22
            r30 = r1
            int r1 = r2 + r3
            if (r11 == 0) goto L_0x0b7d
            boolean r11 = com.google.android.gms.internal.play_billing.zzhs.zze(r15, r2, r1)
            if (r11 == 0) goto L_0x0b78
            goto L_0x0b7d
        L_0x0b78:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zzc()
            throw r1
        L_0x0b7d:
            java.lang.String r11 = new java.lang.String
            r38 = r1
            java.nio.charset.Charset r1 = com.google.android.gms.internal.play_billing.zzfd.zzb
            r11.<init>(r15, r2, r3, r1)
            r6.putObject(r7, r13, r11)
            r2 = r38
        L_0x0b8b:
            r6.putInt(r7, r8, r10)
            r1 = r2
            goto L_0x0c5d
        L_0x0b91:
            r30 = r1
            goto L_0x0c5c
        L_0x0b95:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            if (r2 != 0) goto L_0x0c5c
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r4, r5)
            long r2 = r5.zzb
            int r2 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r2 == 0) goto L_0x0baa
            r29 = 1
            goto L_0x0bac
        L_0x0baa:
            r29 = r17
        L_0x0bac:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r29)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0bb8:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            r1 = 5
            if (r2 != r1) goto L_0x0c5c
            int r1 = r4 + 4
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0bd3:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            r1 = 1
            if (r2 != r1) goto L_0x0c5c
            int r1 = r4 + 8
            long r2 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r4)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0bee:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            if (r2 != 0) goto L_0x0c5c
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzh(r15, r4, r5)
            int r2 = r5.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0c07:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            if (r2 != 0) goto L_0x0c5c
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzk(r15, r4, r5)
            long r2 = r5.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0c20:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            r1 = 5
            if (r2 != r1) goto L_0x0c5c
            int r1 = r4 + 4
            int r2 = com.google.android.gms.internal.play_billing.zzdk.zzb(r15, r4)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0c3e:
            r30 = r3
            r10 = r12
            r4 = r21
            r12 = r1
            r1 = 1
            if (r2 != r1) goto L_0x0c5c
            int r1 = r4 + 8
            long r2 = com.google.android.gms.internal.play_billing.zzdk.zzn(r15, r4)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r6.putObject(r7, r13, r2)
            r6.putInt(r7, r8, r10)
            goto L_0x0c5d
        L_0x0c5c:
            r1 = r4
        L_0x0c5d:
            if (r1 == r4) goto L_0x0c72
            r14 = r39
            r13 = r40
            r2 = r10
            r4 = r12
            r8 = r17
            r6 = r25
            r3 = r30
            r11 = r33
            r12 = r5
            r5 = r20
            goto L_0x001b
        L_0x0c72:
            r8 = r40
            r3 = r1
            r11 = r30
        L_0x0c77:
            if (r12 != r8) goto L_0x0c82
            if (r8 == 0) goto L_0x0c82
            r1 = r3
            r4 = r12
            r5 = r20
            r6 = r25
            goto L_0x0cd7
        L_0x0c82:
            boolean r1 = r0.zzh
            if (r1 == 0) goto L_0x0cac
            com.google.android.gms.internal.play_billing.zzej r1 = r5.zzd
            com.google.android.gms.internal.play_billing.zzej r2 = com.google.android.gms.internal.play_billing.zzej.zza
            if (r1 == r2) goto L_0x0cac
            com.google.android.gms.internal.play_billing.zzgc r2 = r0.zzg
            com.google.android.gms.internal.play_billing.zzev r1 = r1.zzb(r2, r10)
            if (r1 != 0) goto L_0x0ca8
            com.google.android.gms.internal.play_billing.zzhe r6 = zzd(r36)
            r1 = r12
            r2 = r37
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r39
            r5 = r6
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzg(r1, r2, r3, r4, r5, r6)
            goto L_0x0cbe
        L_0x0ca8:
            r1 = r7
            com.google.android.gms.internal.play_billing.zzeu r1 = (com.google.android.gms.internal.play_billing.zzeu) r1
            throw r16
        L_0x0cac:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            com.google.android.gms.internal.play_billing.zzhe r5 = zzd(r36)
            r1 = r12
            r2 = r37
            r4 = r39
            r6 = r41
            int r1 = com.google.android.gms.internal.play_billing.zzdk.zzg(r1, r2, r3, r4, r5, r6)
        L_0x0cbe:
            r14 = r39
            r13 = r8
            r2 = r10
            r3 = r11
            r4 = r12
            r8 = r17
            r5 = r20
            r6 = r25
            r11 = r33
            r12 = r41
            goto L_0x001b
        L_0x0cd0:
            r20 = r5
            r25 = r6
            r33 = r11
            r8 = r13
        L_0x0cd7:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r9) goto L_0x0ce2
            long r2 = (long) r6
            r6 = r33
            r6.putInt(r7, r2, r5)
        L_0x0ce2:
            int r2 = r0.zzj
        L_0x0ce4:
            int r3 = r0.zzk
            if (r2 >= r3) goto L_0x0d0f
            int[] r3 = r0.zzi
            int[] r5 = r0.zzc
            r3 = r3[r2]
            r5 = r5[r3]
            int r5 = r0.zzs(r3)
            r5 = r5 & r9
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.play_billing.zzhn.zzf(r7, r5)
            if (r5 != 0) goto L_0x0cfd
            goto L_0x0d03
        L_0x0cfd:
            com.google.android.gms.internal.play_billing.zzfb r6 = r0.zzu(r3)
            if (r6 != 0) goto L_0x0d06
        L_0x0d03:
            int r2 = r2 + 1
            goto L_0x0ce4
        L_0x0d06:
            com.google.android.gms.internal.play_billing.zzfw r5 = (com.google.android.gms.internal.play_billing.zzfw) r5
            java.lang.Object r1 = r0.zzw(r3)
            com.google.android.gms.internal.play_billing.zzfv r1 = (com.google.android.gms.internal.play_billing.zzfv) r1
            throw r16
        L_0x0d0f:
            if (r8 != 0) goto L_0x0d1b
            r2 = r39
            if (r1 != r2) goto L_0x0d16
            goto L_0x0d21
        L_0x0d16:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zze()
            throw r1
        L_0x0d1b:
            r2 = r39
            if (r1 > r2) goto L_0x0d22
            if (r4 != r8) goto L_0x0d22
        L_0x0d21:
            return r1
        L_0x0d22:
            com.google.android.gms.internal.play_billing.zzff r1 = com.google.android.gms.internal.play_billing.zzff.zze()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    public final Object zze() {
        return ((zzex) this.zzg).zzi();
    }

    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzex) {
                zzex zzex = (zzex) obj;
                zzex.zzq(Integer.MAX_VALUE);
                zzex.zza = 0;
                zzex.zzo();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = (long) i2;
                if (zzr != 9) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, this.zzc[i], i)) {
                            zzv(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzr) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzl.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfw) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            int i2 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i3 = iArr[i];
            long j = (long) i2;
            switch (zzr) {
                case 0:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzo(obj, j, zzhn.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 1:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzp(obj, j, zzhn.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 2:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 3:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 4:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 5:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 6:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 7:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzm(obj, j, zzhn.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 8:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 11:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 12:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 13:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 14:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 15:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzq(obj, j, zzhn.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 16:
                    if (!zzI(obj2, i)) {
                        break;
                    } else {
                        zzhn.zzr(obj, j, zzhn.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzgo.zza;
                    zzhn.zzs(obj, j, zzfx.zza(zzhn.zzf(obj, j), zzhn.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzM(obj2, i3, i)) {
                        break;
                    } else {
                        zzhn.zzs(obj, j, zzhn.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgo.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdj zzdj) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdj);
    }

    public final void zzi(Object obj, zzhv zzhv) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        Object obj2 = obj;
        zzhv zzhv2 = zzhv;
        if (!this.zzh) {
            int[] iArr = this.zzc;
            Unsafe unsafe = zzb;
            int i5 = 1048575;
            int i6 = 1048575;
            int i7 = 0;
            int i8 = 0;
            while (i8 < iArr.length) {
                int zzs = zzs(i8);
                int[] iArr2 = this.zzc;
                int zzr = zzr(zzs);
                int i9 = iArr2[i8];
                if (zzr <= 17) {
                    int i10 = iArr2[i8 + 2];
                    int i11 = i10 & i5;
                    if (i11 != i6) {
                        if (i11 == i5) {
                            i4 = 0;
                        } else {
                            i4 = unsafe.getInt(obj2, (long) i11);
                        }
                        i7 = i4;
                        i6 = i11;
                    }
                    i2 = i6;
                    i = i7;
                    i3 = 1 << (i10 >>> 20);
                } else {
                    i2 = i6;
                    i = i7;
                    i3 = 0;
                }
                long j = (long) (zzs & i5);
                switch (zzr) {
                    case 0:
                        long j2 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzf(i9, zzhn.zza(obj2, j2));
                            break;
                        }
                    case 1:
                        long j3 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzo(i9, zzhn.zzb(obj2, j3));
                            break;
                        }
                    case 2:
                        long j4 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzt(i9, unsafe.getLong(obj2, j4));
                            break;
                        }
                    case 3:
                        long j5 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzJ(i9, unsafe.getLong(obj2, j5));
                            break;
                        }
                    case 4:
                        long j6 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzr(i9, unsafe.getInt(obj2, j6));
                            break;
                        }
                    case 5:
                        long j7 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzm(i9, unsafe.getLong(obj2, j7));
                            break;
                        }
                    case 6:
                        long j8 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzk(i9, unsafe.getInt(obj2, j8));
                            break;
                        }
                    case 7:
                        long j9 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzb(i9, zzhn.zzw(obj2, j9));
                            break;
                        }
                    case 8:
                        long j10 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzO(i9, unsafe.getObject(obj2, j10), zzhv2);
                            break;
                        }
                    case 9:
                        long j11 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzv(i9, unsafe.getObject(obj2, j11), zzv(i8));
                            break;
                        }
                    case 10:
                        long j12 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzd(i9, (zzdw) unsafe.getObject(obj2, j12));
                            break;
                        }
                    case 11:
                        long j13 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzH(i9, unsafe.getInt(obj2, j13));
                            break;
                        }
                    case 12:
                        long j14 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzi(i9, unsafe.getInt(obj2, j14));
                            break;
                        }
                    case 13:
                        long j15 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzw(i9, unsafe.getInt(obj2, j15));
                            break;
                        }
                    case 14:
                        long j16 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzy(i9, unsafe.getLong(obj2, j16));
                            break;
                        }
                    case 15:
                        long j17 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzA(i9, unsafe.getInt(obj2, j17));
                            break;
                        }
                    case 16:
                        long j18 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzC(i9, unsafe.getLong(obj2, j18));
                            break;
                        }
                    case 17:
                        long j19 = j;
                        if (!zzJ(obj, i8, i2, i, i3)) {
                            break;
                        } else {
                            zzhv2.zzq(i9, unsafe.getObject(obj2, j19), zzv(i8));
                            break;
                        }
                    case 18:
                        zzgo.zzs(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 19:
                        zzgo.zzw(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 20:
                        zzgo.zzy(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 21:
                        zzgo.zzE(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 22:
                        zzgo.zzx(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 23:
                        zzgo.zzv(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 24:
                        zzgo.zzu(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 25:
                        zzgo.zzr(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 26:
                        int i12 = this.zzc[i8];
                        List list = (List) unsafe.getObject(obj2, j);
                        int i13 = zzgo.zza;
                        if (list != null && !list.isEmpty()) {
                            zzhv2.zzG(i12, list);
                            break;
                        }
                    case 27:
                        int i14 = this.zzc[i8];
                        List list2 = (List) unsafe.getObject(obj2, j);
                        zzgm zzv = zzv(i8);
                        int i15 = zzgo.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i16 = 0; i16 < list2.size(); i16++) {
                                ((zzef) zzhv2).zzv(i14, list2.get(i16), zzv);
                            }
                            break;
                        }
                    case 28:
                        int i17 = this.zzc[i8];
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i18 = zzgo.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzhv2.zze(i17, list3);
                            break;
                        }
                    case 29:
                        zzgo.zzD(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 30:
                        zzgo.zzt(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 31:
                        zzgo.zzz(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 32:
                        zzgo.zzA(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 33:
                        zzgo.zzB(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 34:
                        zzgo.zzC(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, false);
                        break;
                    case 35:
                        zzgo.zzs(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 36:
                        zzgo.zzw(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 37:
                        zzgo.zzy(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 38:
                        zzgo.zzE(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 39:
                        zzgo.zzx(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 40:
                        zzgo.zzv(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 41:
                        zzgo.zzu(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 42:
                        zzgo.zzr(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 43:
                        zzgo.zzD(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 44:
                        zzgo.zzt(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 45:
                        zzgo.zzz(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 46:
                        zzgo.zzA(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 47:
                        zzgo.zzB(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 48:
                        zzgo.zzC(this.zzc[i8], (List) unsafe.getObject(obj2, j), zzhv2, true);
                        break;
                    case 49:
                        int i19 = this.zzc[i8];
                        List list4 = (List) unsafe.getObject(obj2, j);
                        zzgm zzv2 = zzv(i8);
                        int i20 = zzgo.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i21 = 0; i21 < list4.size(); i21++) {
                                ((zzef) zzhv2).zzq(i19, list4.get(i21), zzv2);
                            }
                            break;
                        }
                    case 50:
                        if (unsafe.getObject(obj2, j) == null) {
                            break;
                        } else {
                            zzfv zzfv = (zzfv) zzw(i8);
                            throw null;
                        }
                    case 51:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzf(i9, zzm(obj2, j));
                            break;
                        }
                    case 52:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzo(i9, zzn(obj2, j));
                            break;
                        }
                    case 53:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzt(i9, zzt(obj2, j));
                            break;
                        }
                    case 54:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzJ(i9, zzt(obj2, j));
                            break;
                        }
                    case 55:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzr(i9, zzo(obj2, j));
                            break;
                        }
                    case 56:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzm(i9, zzt(obj2, j));
                            break;
                        }
                    case 57:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzk(i9, zzo(obj2, j));
                            break;
                        }
                    case 58:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzb(i9, zzN(obj2, j));
                            break;
                        }
                    case 59:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzO(i9, unsafe.getObject(obj2, j), zzhv2);
                            break;
                        }
                    case 60:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzv(i9, unsafe.getObject(obj2, j), zzv(i8));
                            break;
                        }
                    case 61:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzd(i9, (zzdw) unsafe.getObject(obj2, j));
                            break;
                        }
                    case 62:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzH(i9, zzo(obj2, j));
                            break;
                        }
                    case 63:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzi(i9, zzo(obj2, j));
                            break;
                        }
                    case 64:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzw(i9, zzo(obj2, j));
                            break;
                        }
                    case 65:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzy(i9, zzt(obj2, j));
                            break;
                        }
                    case 66:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzA(i9, zzo(obj2, j));
                            break;
                        }
                    case 67:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzC(i9, zzt(obj2, j));
                            break;
                        }
                    case 68:
                        if (!zzM(obj2, i9, i8)) {
                            break;
                        } else {
                            zzhv2.zzq(i9, unsafe.getObject(obj2, j), zzv(i8));
                            break;
                        }
                }
                i8 += 3;
                i6 = i2;
                i7 = i;
                i5 = 1048575;
            }
            zzhd zzhd = this.zzm;
            zzhd.zzi(zzhd.zzd(obj2), zzhv2);
            return;
        }
        this.zzn.zza(obj2);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = (long) (zzs & 1048575);
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzhn.zza(obj, j)) == Double.doubleToLongBits(zzhn.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzhn.zzb(obj, j)) == Float.floatToIntBits(zzhn.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzH(obj, obj2, i) && zzhn.zzw(obj, j) == zzhn.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzH(obj, obj2, i) && zzhn.zzc(obj, j) == zzhn.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzH(obj, obj2, i) && zzhn.zzd(obj, j) == zzhn.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzH(obj, obj2, i) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j));
                    break;
                case 50:
                    z = zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzp2 = (long) (zzp(i) & 1048575);
                    if (zzhn.zzc(obj, zzp2) == zzhn.zzc(obj2, zzp2) && zzgo.zzF(zzhn.zzf(obj, j), zzhn.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i5];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj2, i7, i6) && !zzK(obj2, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzfw) zzhn.zzf(obj2, (long) (zzs & 1048575))).isEmpty()) {
                            zzfv zzfv = (zzfv) zzw(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhn.zzf(obj2, (long) (zzs & 1048575));
                if (!list.isEmpty()) {
                    zzgm zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzJ(obj, i6, i2, i, i10) && !zzK(obj2, zzs, zzv(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj2);
        throw null;
    }
}
