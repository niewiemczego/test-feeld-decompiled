package okio.internal;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -Utf8.kt */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0092, code lost:
        if (((r0[r5] & 192) == 128) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x010d, code lost:
        if (((r0[r5] & 192) == 128) == false) goto L_0x0112;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            if (r1 < 0) goto L_0x01a9
            int r3 = r0.length
            if (r2 > r3) goto L_0x01a9
            if (r1 > r2) goto L_0x01a9
            int r3 = r2 - r1
            char[] r3 = new char[r3]
            r4 = 0
            r5 = r4
        L_0x0018:
            if (r1 >= r2) goto L_0x01a4
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0034
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            int r1 = r1 + 1
        L_0x0025:
            r5 = r7
            if (r1 >= r2) goto L_0x0018
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0018
            int r1 = r1 + 1
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0025
        L_0x0034:
            int r7 = r6 >> 5
            r8 = -2
            r10 = 128(0x80, float:1.794E-43)
            r11 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r8) goto L_0x0071
            int r7 = r1 + 1
            if (r2 > r7) goto L_0x004a
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0047:
            r5 = r7
        L_0x0048:
            r9 = 1
            goto L_0x006f
        L_0x004a:
            byte r7 = r0[r7]
            r8 = r7 & 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x0052
            r8 = 1
            goto L_0x0053
        L_0x0052:
            r8 = r4
        L_0x0053:
            if (r8 != 0) goto L_0x005b
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0047
        L_0x005b:
            r7 = r7 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r7
            if (r6 >= r10) goto L_0x0068
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x006d
        L_0x0068:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x006d:
            r5 = r7
        L_0x006e:
            r9 = 2
        L_0x006f:
            int r1 = r1 + r9
            goto L_0x0018
        L_0x0071:
            int r7 = r6 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            r15 = 3
            if (r7 != r8) goto L_0x00e4
            int r7 = r1 + 2
            if (r2 > r7) goto L_0x0095
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0047
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0091
            r5 = 1
            goto L_0x0092
        L_0x0091:
            r5 = r4
        L_0x0092:
            if (r5 != 0) goto L_0x006d
            goto L_0x0047
        L_0x0095:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x009f
            r9 = 1
            goto L_0x00a0
        L_0x009f:
            r9 = r4
        L_0x00a0:
            if (r9 != 0) goto L_0x00a8
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0047
        L_0x00a8:
            byte r7 = r0[r7]
            r9 = r7 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00b0
            r9 = 1
            goto L_0x00b1
        L_0x00b0:
            r9 = r4
        L_0x00b1:
            if (r9 != 0) goto L_0x00b9
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x006d
        L_0x00b9:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r7 = r7 ^ r9
            int r8 = r8 << 6
            r7 = r7 ^ r8
            int r6 = r6 << 12
            r6 = r6 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 >= r7) goto L_0x00cd
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00e1
        L_0x00cd:
            if (r14 > r6) goto L_0x00d3
            if (r6 >= r13) goto L_0x00d3
            r12 = 1
            goto L_0x00d4
        L_0x00d3:
            r12 = r4
        L_0x00d4:
            if (r12 == 0) goto L_0x00dc
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00e1
        L_0x00dc:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x00e1:
            r5 = r7
        L_0x00e2:
            r9 = r15
            goto L_0x006f
        L_0x00e4:
            int r7 = r6 >> 3
            if (r7 != r8) goto L_0x019b
            int r7 = r1 + 3
            if (r2 > r7) goto L_0x0118
            int r6 = r5 + 1
            r3[r5] = r11
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0115
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x00fc
            r5 = 1
            goto L_0x00fd
        L_0x00fc:
            r5 = r4
        L_0x00fd:
            if (r5 != 0) goto L_0x0100
            goto L_0x0115
        L_0x0100:
            int r5 = r1 + 2
            if (r2 <= r5) goto L_0x0112
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x010c
            r12 = 1
            goto L_0x010d
        L_0x010c:
            r12 = r4
        L_0x010d:
            if (r12 != 0) goto L_0x0110
            goto L_0x0112
        L_0x0110:
            r5 = r6
            goto L_0x00e2
        L_0x0112:
            r5 = r6
            goto L_0x006e
        L_0x0115:
            r5 = r6
            goto L_0x0048
        L_0x0118:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x0122
            r9 = 1
            goto L_0x0123
        L_0x0122:
            r9 = r4
        L_0x0123:
            if (r9 != 0) goto L_0x012a
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0115
        L_0x012a:
            int r9 = r1 + 2
            byte r9 = r0[r9]
            r12 = r9 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0134
            r12 = 1
            goto L_0x0135
        L_0x0134:
            r12 = r4
        L_0x0135:
            if (r12 != 0) goto L_0x013c
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0112
        L_0x013c:
            byte r7 = r0[r7]
            r12 = r7 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0144
            r10 = 1
            goto L_0x0145
        L_0x0144:
            r10 = r4
        L_0x0145:
            if (r10 != 0) goto L_0x014c
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0110
        L_0x014c:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r7 = r7 ^ r10
            int r9 = r9 << 6
            r7 = r7 ^ r9
            int r8 = r8 << 12
            r7 = r7 ^ r8
            int r6 = r6 << 18
            r6 = r6 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r7) goto L_0x0163
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0197
        L_0x0163:
            if (r14 > r6) goto L_0x0169
            if (r6 >= r13) goto L_0x0169
            r12 = 1
            goto L_0x016a
        L_0x0169:
            r12 = r4
        L_0x016a:
            if (r12 == 0) goto L_0x0171
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0197
        L_0x0171:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x017a
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0197
        L_0x017a:
            if (r6 == r11) goto L_0x0193
            int r7 = r6 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r7 = r7 + r8
            char r7 = (char) r7
            int r8 = r5 + 1
            r3[r5] = r7
            r5 = r6 & 1023(0x3ff, float:1.434E-42)
            r6 = 56320(0xdc00, float:7.8921E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            int r6 = r8 + 1
            r3[r8] = r5
            goto L_0x0197
        L_0x0193:
            int r6 = r5 + 1
            r3[r5] = r11
        L_0x0197:
            r9 = 4
            r5 = r6
            goto L_0x006f
        L_0x019b:
            int r6 = r5 + 1
            r3[r5] = r11
            int r1 = r1 + 1
            r5 = r6
            goto L_0x0018
        L_0x01a4:
            java.lang.String r0 = kotlin.text.StringsKt.concatToString(r3, r4, r5)
            return r0
        L_0x01a9:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "size="
            java.lang.StringBuilder r4 = r4.append(r5)
            int r0 = r0.length
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r4 = " beginIndex="
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " endIndex="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i5 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 128) >= 0) {
                int length2 = str.length();
                int i6 = i;
                while (i < length2) {
                    char charAt2 = str.charAt(i);
                    if (Intrinsics.compare((int) charAt2, 128) < 0) {
                        int i7 = i6 + 1;
                        bArr[i6] = (byte) charAt2;
                        i++;
                        while (true) {
                            i6 = i7;
                            if (i >= length2 || Intrinsics.compare((int) str.charAt(i), 128) >= 0) {
                                break;
                            }
                            i7 = i6 + 1;
                            bArr[i6] = (byte) str.charAt(i);
                            i++;
                        }
                    } else {
                        if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                            int i8 = i6 + 1;
                            bArr[i6] = (byte) ((charAt2 >> 6) | 192);
                            i2 = i8 + 1;
                            bArr[i8] = (byte) ((charAt2 & '?') | 128);
                        } else {
                            boolean z = true;
                            if (!(55296 <= charAt2 && charAt2 < 57344)) {
                                int i9 = i6 + 1;
                                bArr[i6] = (byte) ((charAt2 >> 12) | 224);
                                int i10 = i9 + 1;
                                bArr[i9] = (byte) (((charAt2 >> 6) & 63) | 128);
                                i2 = i10 + 1;
                                bArr[i10] = (byte) ((charAt2 & '?') | 128);
                            } else {
                                if (Intrinsics.compare((int) charAt2, 56319) <= 0 && length2 > (i3 = i + 1)) {
                                    char charAt3 = str.charAt(i3);
                                    if (56320 > charAt3 || charAt3 >= 57344) {
                                        z = false;
                                    }
                                    if (z) {
                                        int charAt4 = ((charAt2 << 10) + str.charAt(i3)) - 56613888;
                                        int i11 = i6 + 1;
                                        bArr[i6] = (byte) ((charAt4 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        int i12 = i11 + 1;
                                        bArr[i11] = (byte) (((charAt4 >> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        bArr[i12] = (byte) (((charAt4 >> 6) & 63) | 128);
                                        i2 = i13 + 1;
                                        bArr[i13] = (byte) ((charAt4 & 63) | 128);
                                        i4 = i + 2;
                                        i6 = i2;
                                    }
                                }
                                i2 = i6 + 1;
                                bArr[i6] = Utf8.REPLACEMENT_BYTE;
                            }
                        }
                        i4 = i + 1;
                        i6 = i2;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i6);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i] = (byte) charAt;
            i5 = i + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }
}
