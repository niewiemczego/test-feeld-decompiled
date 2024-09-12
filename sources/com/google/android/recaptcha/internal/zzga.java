package com.google.android.recaptcha.internal;

import java.math.RoundingMode;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzga {
    public static int zzb(int i, RoundingMode roundingMode) {
        if (i > 0) {
            switch (zzfz.zza[roundingMode.ordinal()]) {
                case 1:
                    zzgc.zzb(((i + -1) & i) == 0);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                    return (31 - numberOfLeadingZeros) + (((-1257966797 >>> numberOfLeadingZeros) - i) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i);
        }
        throw new IllegalArgumentException("x (0) must be > 0");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN ? 1 : 0) & (r0 & 1)) != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r1 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r5 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r5 < 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r3 != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(int r5, int r6, java.math.RoundingMode r7) {
        /*
            r7.getClass()
            if (r6 == 0) goto L_0x0054
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto L_0x000e
            goto L_0x0053
        L_0x000e:
            r5 = r5 ^ r6
            int[] r2 = com.google.android.recaptcha.internal.zzfz.zza
            int r3 = r7.ordinal()
            r2 = r2[r3]
            int r5 = r5 >> 31
            r3 = 1
            r5 = r5 | r3
            r4 = 0
            switch(r2) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0053;
                case 3: goto L_0x0048;
                case 4: goto L_0x004e;
                case 5: goto L_0x0045;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x0042
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L_0x004c
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L_0x003b
            r6 = r3
            goto L_0x003c
        L_0x003b:
            r6 = r4
        L_0x003c:
            r7 = r0 & 1
            r6 = r6 & r7
            if (r6 == 0) goto L_0x004b
            goto L_0x004c
        L_0x0042:
            if (r1 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0045:
            if (r5 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0048:
            if (r5 >= 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r4
        L_0x004c:
            if (r3 == 0) goto L_0x0053
        L_0x004e:
            int r0 = r0 + r5
            return r0
        L_0x0050:
            com.google.android.recaptcha.internal.zzgc.zzb(r4)
        L_0x0053:
            return r0
        L_0x0054:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzga.zza(int, int, java.math.RoundingMode):int");
    }
}
