package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class AFg1wSDK extends FilterInputStream {
    private static final short AFInAppEventParameterName = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));
    private byte[] AFInAppEventType = new byte[8];
    private byte[] AFKeystoreWrapper = new byte[8];
    private int AFLogger;
    private int afDebugLog;
    private int afErrorLog = 8;
    private int afErrorLogForExcManagerOnly;
    private int afInfoLog = Integer.MAX_VALUE;
    private int afRDLog;
    private int afWarnLog;
    private int getLevel;
    private int valueOf = 8;
    private byte[] values = new byte[8];

    public final boolean markSupported() {
        return false;
    }

    public AFg1wSDK(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.afRDLog = Math.min(Math.max(i2, 5), 16);
        this.AFLogger = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.AFKeystoreWrapper, 0, 8);
        }
        long j = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i == 0) {
            this.afDebugLog = (int) j;
            long j2 = j >> 3;
            short s = AFInAppEventParameterName;
            this.getLevel = (int) ((((long) s) * j2) >> 32);
            this.afErrorLogForExcManagerOnly = (int) (j >> 32);
            this.afWarnLog = (int) (j2 + ((long) s));
            return;
        }
        int i4 = (int) j;
        this.afDebugLog = i4;
        this.getLevel = i4 * i;
        this.afErrorLogForExcManagerOnly = i4 ^ i;
        this.afWarnLog = (int) (j >> 32);
    }

    public final int read() throws IOException {
        AFInAppEventType();
        int i = this.valueOf;
        if (i >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.values;
        this.valueOf = i + 1;
        return bArr[i] & 255;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            AFInAppEventType();
            int i5 = this.valueOf;
            if (i5 < this.afErrorLog) {
                byte[] bArr2 = this.values;
                this.valueOf = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int available() throws IOException {
        AFInAppEventType();
        return this.afErrorLog - this.valueOf;
    }

    private void AFInAppEventParameterName() {
        if (this.AFLogger == 3) {
            byte[] bArr = this.values;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.values;
        int i = ((bArr2[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i2 = (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.afRDLog;
            if (i3 >= i4) {
                break;
            }
            short s = AFInAppEventParameterName;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.afErrorLogForExcManagerOnly)) ^ ((i >>> 5) + this.afWarnLog);
            i -= (((i2 << 4) + this.afDebugLog) ^ ((s * (i4 - i3)) + i2)) ^ ((i2 >>> 5) + this.getLevel);
            i3++;
        }
        byte[] bArr3 = this.values;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.AFLogger == 3) {
            for (int i5 = 0; i5 < 8; i5++) {
                byte[] bArr4 = this.values;
                bArr4[i5] = (byte) (bArr4[i5] ^ this.AFKeystoreWrapper[i5]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.AFKeystoreWrapper, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int AFInAppEventType() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.afInfoLog
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afInfoLog = r0
        L_0x000f:
            int r0 = r7.valueOf
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.values
            int r2 = r7.afInfoLog
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.values
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.AFInAppEventParameterName()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.afInfoLog = r0
            r7.valueOf = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.values
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.afErrorLog = r1
            goto L_0x0059
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0059:
            int r0 = r7.afErrorLog
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1wSDK.AFInAppEventType():int");
    }
}
