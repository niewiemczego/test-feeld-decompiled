package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzmj {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i2 = 2; i2 < 20; i2 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i4 = 2; i4 < 50; i4 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i5 = 2; i5 < 100; i5 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r44v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zzb(long[] r44, long[] r45, long[] r46) {
        /*
            r0 = 0
            r1 = r45[r0]
            r3 = r46[r0]
            long r1 = r1 * r3
            r44[r0] = r1
            r1 = r45[r0]
            r3 = 1
            r4 = r46[r3]
            long r4 = r4 * r1
            r6 = r45[r3]
            r8 = r46[r0]
            long r6 = r6 * r8
            long r4 = r4 + r6
            r44[r3] = r4
            r4 = r45[r3]
            r6 = 2
            long r10 = r4 * r6
            r12 = r46[r3]
            long r10 = r10 * r12
            r0 = 2
            r14 = r46[r0]
            long r14 = r14 * r1
            long r10 = r10 + r14
            r14 = r45[r0]
            long r14 = r14 * r8
            long r10 = r10 + r14
            r44[r0] = r10
            r10 = r46[r0]
            long r14 = r4 * r10
            r16 = r45[r0]
            long r18 = r16 * r12
            long r14 = r14 + r18
            r0 = 3
            r18 = r46[r0]
            long r18 = r18 * r1
            long r14 = r14 + r18
            r18 = r45[r0]
            long r18 = r18 * r8
            long r14 = r14 + r18
            r44[r0] = r14
            long r14 = r16 * r10
            r18 = r46[r0]
            long r20 = r4 * r18
            r22 = r45[r0]
            long r24 = r22 * r12
            long r20 = r20 + r24
            long r20 = r20 * r6
            long r14 = r14 + r20
            r0 = 4
            r20 = r46[r0]
            long r20 = r20 * r1
            long r14 = r14 + r20
            r20 = r45[r0]
            long r20 = r20 * r8
            long r14 = r14 + r20
            r44[r0] = r14
            long r14 = r16 * r18
            long r20 = r22 * r10
            long r14 = r14 + r20
            r20 = r46[r0]
            long r24 = r4 * r20
            long r14 = r14 + r24
            r24 = r45[r0]
            long r26 = r24 * r12
            long r14 = r14 + r26
            r0 = 5
            r26 = r46[r0]
            long r26 = r26 * r1
            long r14 = r14 + r26
            r26 = r45[r0]
            long r26 = r26 * r8
            long r14 = r14 + r26
            r44[r0] = r14
            long r14 = r22 * r18
            r26 = r46[r0]
            long r28 = r4 * r26
            long r14 = r14 + r28
            r28 = r45[r0]
            long r30 = r28 * r12
            long r14 = r14 + r30
            long r14 = r14 * r6
            long r30 = r16 * r20
            long r14 = r14 + r30
            long r30 = r24 * r10
            long r14 = r14 + r30
            r0 = 6
            r30 = r46[r0]
            long r30 = r30 * r1
            long r14 = r14 + r30
            r30 = r45[r0]
            long r30 = r30 * r8
            long r14 = r14 + r30
            r44[r0] = r14
            long r14 = r22 * r20
            long r30 = r24 * r18
            long r14 = r14 + r30
            long r30 = r16 * r26
            long r14 = r14 + r30
            long r30 = r28 * r10
            long r14 = r14 + r30
            r30 = r46[r0]
            long r32 = r4 * r30
            long r14 = r14 + r32
            r32 = r45[r0]
            long r34 = r32 * r12
            long r14 = r14 + r34
            r0 = 7
            r34 = r46[r0]
            long r34 = r34 * r1
            long r14 = r14 + r34
            r34 = r45[r0]
            long r34 = r34 * r8
            long r14 = r14 + r34
            r44[r0] = r14
            long r14 = r24 * r20
            long r34 = r22 * r26
            long r36 = r28 * r18
            long r34 = r34 + r36
            r36 = r46[r0]
            long r38 = r4 * r36
            long r34 = r34 + r38
            r38 = r45[r0]
            long r40 = r38 * r12
            long r34 = r34 + r40
            long r34 = r34 * r6
            long r14 = r14 + r34
            long r34 = r16 * r30
            long r14 = r14 + r34
            long r34 = r32 * r10
            long r14 = r14 + r34
            r0 = 8
            r34 = r46[r0]
            long r34 = r34 * r1
            long r14 = r14 + r34
            r34 = r45[r0]
            long r34 = r34 * r8
            long r14 = r14 + r34
            r44[r0] = r14
            long r14 = r24 * r26
            long r34 = r28 * r20
            long r14 = r14 + r34
            long r34 = r22 * r30
            long r14 = r14 + r34
            long r34 = r32 * r18
            long r14 = r14 + r34
            long r34 = r16 * r36
            long r14 = r14 + r34
            long r34 = r38 * r10
            long r14 = r14 + r34
            r34 = r46[r0]
            long r40 = r4 * r34
            long r14 = r14 + r40
            r40 = r45[r0]
            long r42 = r40 * r12
            long r14 = r14 + r42
            r0 = 9
            r42 = r46[r0]
            long r1 = r1 * r42
            long r14 = r14 + r1
            r1 = r45[r0]
            long r1 = r1 * r8
            long r14 = r14 + r1
            r44[r0] = r14
            long r1 = r28 * r26
            long r8 = r22 * r36
            long r1 = r1 + r8
            long r8 = r38 * r18
            long r1 = r1 + r8
            r8 = r46[r0]
            long r4 = r4 * r8
            long r1 = r1 + r4
            r3 = r45[r0]
            long r12 = r12 * r3
            long r1 = r1 + r12
            long r1 = r1 * r6
            long r12 = r24 * r30
            long r1 = r1 + r12
            long r12 = r32 * r20
            long r1 = r1 + r12
            long r12 = r16 * r34
            long r1 = r1 + r12
            long r12 = r40 * r10
            long r1 = r1 + r12
            r0 = 10
            r44[r0] = r1
            long r0 = r28 * r30
            long r12 = r32 * r26
            long r0 = r0 + r12
            long r12 = r24 * r36
            long r0 = r0 + r12
            long r12 = r38 * r20
            long r0 = r0 + r12
            long r12 = r22 * r34
            long r0 = r0 + r12
            long r12 = r40 * r18
            long r0 = r0 + r12
            long r16 = r16 * r8
            long r0 = r0 + r16
            long r10 = r10 * r3
            long r0 = r0 + r10
            r2 = 11
            r44[r2] = r0
            long r0 = r32 * r30
            long r10 = r28 * r36
            long r12 = r38 * r26
            long r10 = r10 + r12
            long r22 = r22 * r8
            long r10 = r10 + r22
            long r18 = r18 * r3
            long r10 = r10 + r18
            long r10 = r10 * r6
            long r0 = r0 + r10
            long r10 = r24 * r34
            long r0 = r0 + r10
            long r10 = r40 * r20
            long r0 = r0 + r10
            r2 = 12
            r44[r2] = r0
            long r0 = r32 * r36
            long r10 = r38 * r30
            long r0 = r0 + r10
            long r10 = r28 * r34
            long r0 = r0 + r10
            long r10 = r40 * r26
            long r0 = r0 + r10
            long r24 = r24 * r8
            long r0 = r0 + r24
            long r20 = r20 * r3
            long r0 = r0 + r20
            r2 = 13
            r44[r2] = r0
            long r0 = r38 * r36
            long r28 = r28 * r8
            long r0 = r0 + r28
            long r26 = r26 * r3
            long r0 = r0 + r26
            long r0 = r0 * r6
            long r10 = r32 * r34
            long r0 = r0 + r10
            long r10 = r40 * r30
            long r0 = r0 + r10
            r2 = 14
            r44[r2] = r0
            long r0 = r38 * r34
            long r10 = r40 * r36
            long r0 = r0 + r10
            long r32 = r32 * r8
            long r0 = r0 + r32
            long r30 = r30 * r3
            long r0 = r0 + r30
            r2 = 15
            r44[r2] = r0
            long r0 = r40 * r34
            long r38 = r38 * r8
            long r36 = r36 * r3
            long r38 = r38 + r36
            long r38 = r38 * r6
            long r0 = r0 + r38
            r2 = 16
            r44[r2] = r0
            long r40 = r40 * r8
            long r34 = r34 * r3
            long r40 = r40 + r34
            r0 = 17
            r44[r0] = r40
            long r3 = r3 * r6
            long r3 = r3 * r8
            r0 = 18
            r44[r0] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzmj.zzb(long[], long[], long[]):void");
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void zza(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i];
            long j2 = j / 67108864;
            jArr[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = jArr[i2] + j2;
            jArr[i2] = j3;
            long j4 = j3 / 33554432;
            jArr[i2] = j3 - (j4 << 25);
            i += 2;
            jArr[i] = jArr[i] + j4;
        }
        long j5 = jArr[0];
        long j6 = jArr[10];
        long j7 = j5 + (j6 << 4);
        jArr[0] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[0] = j8;
        long j9 = j8 + j6;
        jArr[0] = j9;
        jArr[10] = 0;
        long j10 = j9 / 67108864;
        jArr[0] = j9 - (j10 << 26);
        jArr[1] = jArr[1] + j10;
    }

    static void zzb(long[] jArr) {
        long j = jArr[8];
        long j2 = jArr[18];
        long j3 = j + (j2 << 4);
        jArr[8] = j3;
        long j4 = j3 + (j2 << 1);
        jArr[8] = j4;
        jArr[8] = j4 + j2;
        long j5 = jArr[7];
        long j6 = jArr[17];
        long j7 = j5 + (j6 << 4);
        jArr[7] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[7] = j8;
        jArr[7] = j8 + j6;
        long j9 = jArr[6];
        long j10 = jArr[16];
        long j11 = j9 + (j10 << 4);
        jArr[6] = j11;
        long j12 = j11 + (j10 << 1);
        jArr[6] = j12;
        jArr[6] = j12 + j10;
        long j13 = jArr[5];
        long j14 = jArr[15];
        long j15 = j13 + (j14 << 4);
        jArr[5] = j15;
        long j16 = j15 + (j14 << 1);
        jArr[5] = j16;
        jArr[5] = j16 + j14;
        long j17 = jArr[4];
        long j18 = jArr[14];
        long j19 = j17 + (j18 << 4);
        jArr[4] = j19;
        long j20 = j19 + (j18 << 1);
        jArr[4] = j20;
        jArr[4] = j20 + j18;
        long j21 = jArr[3];
        long j22 = jArr[13];
        long j23 = j21 + (j22 << 4);
        jArr[3] = j23;
        long j24 = j23 + (j22 << 1);
        jArr[3] = j24;
        jArr[3] = j24 + j22;
        long j25 = jArr[2];
        long j26 = jArr[12];
        long j27 = j25 + (j26 << 4);
        jArr[2] = j27;
        long j28 = j27 + (j26 << 1);
        jArr[2] = j28;
        jArr[2] = j28 + j26;
        long j29 = jArr[1];
        long j30 = jArr[11];
        long j31 = j29 + (j30 << 4);
        jArr[1] = j31;
        long j32 = j31 + (j30 << 1);
        jArr[1] = j32;
        jArr[1] = j32 + j30;
        long j33 = jArr[0];
        long j34 = jArr[10];
        long j35 = j33 + (j34 << 4);
        jArr[0] = j35;
        long j36 = j35 + (j34 << 1);
        jArr[0] = j36;
        jArr[0] = j36 + j34;
    }

    static void zza(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    static void zzb(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j2 = jArr2[0];
        long j3 = jArr2[1];
        long j4 = jArr2[2];
        long j5 = jArr2[3];
        long j6 = jArr2[4];
        long j7 = jArr2[5];
        long j8 = jArr2[6];
        long j9 = (j4 * j8) + (jArr2[8] * j2);
        long j10 = jArr2[7];
        long j11 = jArr2[8];
        long j12 = jArr2[9];
        zze(new long[]{j * j, j2 * 2 * jArr2[1], ((j3 * j3) + (jArr2[2] * j2)) * 2, ((j3 * j4) + (jArr2[3] * j2)) * 2, (j4 * j4) + (j3 * 4 * j5) + (j2 * 2 * jArr2[4]), ((j4 * j5) + (j3 * j6) + (jArr2[5] * j2)) * 2, ((j5 * j5) + (j4 * j6) + (jArr2[6] * j2) + (j3 * 2 * j7)) * 2, ((j5 * j6) + (j4 * j7) + (j3 * j8) + (jArr2[7] * j2)) * 2, (j6 * j6) + ((j9 + (((j3 * j10) + (j5 * j7)) * 2)) * 2), ((j6 * j7) + (j5 * j8) + (j4 * j10) + (j3 * j11) + (j2 * jArr2[9])) * 2, ((j7 * j7) + (j6 * j8) + (j4 * j11) + (((j5 * j10) + (j3 * j12)) * 2)) * 2, ((j7 * j8) + (j6 * j10) + (j5 * j11) + (j4 * j12)) * 2, (j8 * j8) + (((j6 * j11) + (((j7 * j10) + (j5 * j12)) * 2)) * 2), ((j8 * j10) + (j7 * j11) + (j6 * j12)) * 2, ((j10 * j10) + (j8 * j11) + (j7 * 2 * j12)) * 2, ((j10 * j11) + (j8 * j12)) * 2, (j11 * j11) + (j10 * 4 * j12), j11 * 2 * j12, 2 * j12 * j12}, jArr);
    }

    static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static byte[] zzc(long[] jArr) {
        int i;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                break;
            }
            int i3 = 0;
            while (i3 < 9) {
                long j = copyOf[i3];
                int i4 = zzd[i3 & 1];
                int i5 = -((int) (((j >> 31) & j) >> i4));
                copyOf[i3] = j + ((long) (i5 << i4));
                i3++;
                copyOf[i3] = copyOf[i3] - ((long) i5);
            }
            long j2 = copyOf[9];
            int i6 = -((int) (((j2 >> 31) & j2) >> 25));
            copyOf[9] = j2 + ((long) (i6 << 25));
            copyOf[0] = copyOf[0] - (((long) i6) * 19);
            i2++;
        }
        long j3 = copyOf[0];
        int i7 = -((int) (((j3 >> 31) & j3) >> 26));
        copyOf[0] = j3 + ((long) (i7 << 26));
        copyOf[1] = copyOf[1] - ((long) i7);
        int i8 = 0;
        for (i = 2; i8 < i; i = 2) {
            int i9 = 0;
            while (i9 < 9) {
                long j4 = copyOf[i9];
                int i10 = i9 & 1;
                copyOf[i9] = j4 & ((long) zzc[i10]);
                i9++;
                copyOf[i9] = copyOf[i9] + ((long) ((int) (j4 >> zzd[i10])));
            }
            i8++;
        }
        long j5 = copyOf[9];
        copyOf[9] = j5 & 33554431;
        long j6 = copyOf[0] + (((long) ((int) (j5 >> 25))) * 19);
        copyOf[0] = j6;
        int i11 = ~((((int) j6) - 67108845) >> 31);
        for (int i12 = 1; i12 < 10; i12++) {
            int i13 = ~(((int) copyOf[i12]) ^ zzc[i12 & 1]);
            int i14 = i13 & (i13 << 16);
            int i15 = i14 & (i14 << 8);
            int i16 = i15 & (i15 << 4);
            int i17 = i16 & (i16 << 2);
            i11 &= (i17 & (i17 << 1)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i11));
        long j7 = (long) (33554431 & i11);
        copyOf[1] = copyOf[1] - j7;
        for (int i18 = 2; i18 < 10; i18 += 2) {
            copyOf[i18] = copyOf[i18] - ((long) (67108863 & i11));
            int i19 = i18 + 1;
            copyOf[i19] = copyOf[i19] - j7;
        }
        for (int i20 = 0; i20 < 10; i20++) {
            copyOf[i20] = copyOf[i20] << zzb[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = 0; i21 < 10; i21++) {
            int i22 = zza[i21];
            long j8 = copyOf[i21];
            bArr[i22] = (byte) ((int) (((long) bArr[i22]) | (j8 & 255)));
            int i23 = i22 + 1;
            bArr[i23] = (byte) ((int) (((long) bArr[i23]) | ((j8 >> 8) & 255)));
            int i24 = i22 + 2;
            bArr[i24] = (byte) ((int) (((long) bArr[i24]) | ((j8 >> 16) & 255)));
            int i25 = i22 + 3;
            bArr[i25] = (byte) ((int) (((long) bArr[i25]) | ((j8 >> 24) & 255)));
        }
        return bArr;
    }

    static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = zza[i];
            jArr[i] = ((((((long) (bArr[i2] & 255)) | (((long) (bArr[i2 + 1] & 255)) << 8)) | (((long) (bArr[i2 + 2] & 255)) << 16)) | (((long) (bArr[i2 + 3] & 255)) << 24)) >> zzb[i]) & ((long) zzc[i & 1]);
        }
        return jArr;
    }
}
