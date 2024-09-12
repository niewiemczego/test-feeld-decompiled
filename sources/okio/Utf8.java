package okio;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utf8.kt */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        if (i >= 0 && i < 32) {
            return true;
        }
        return 127 <= i && i < 160;
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final long size(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, (Object) null);
    }

    public static final long size(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i, 0, 2, (Object) null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                        } else {
                            if (charAt < 2048) {
                                i3 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i3 = 3;
                            } else {
                                int i4 = i + 1;
                                if (i4 < i2) {
                                    c = str.charAt(i4);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || c < 56320 || c > 57343) {
                                    j++;
                                    i = i4;
                                } else {
                                    j += (long) 4;
                                    i += 2;
                                }
                            }
                            j += (long) i3;
                        }
                        i++;
                    }
                    return j;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> function1) {
        int i3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt));
                i++;
                while (i < i2 && Intrinsics.compare((int) str.charAt(i), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.compare((int) charAt, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    boolean z = false;
                    if (!(55296 <= charAt && charAt < 57344)) {
                        function1.invoke(Byte.valueOf((byte) ((charAt >> 12) | 224)));
                        function1.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                        function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                    } else {
                        if (Intrinsics.compare((int) charAt, 56319) <= 0 && i2 > (i3 = i + 1)) {
                            char charAt2 = str.charAt(i3);
                            if (56320 <= charAt2 && charAt2 < 57344) {
                                z = true;
                            }
                            if (z) {
                                int charAt3 = ((charAt << 10) + str.charAt(i3)) - 56613888;
                                function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | PsExtractor.VIDEO_STREAM_MASK)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i += 2;
                            }
                        }
                        function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
        if (r9 == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0107, code lost:
        if (r9 == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0013:
            if (r3 >= r1) goto L_0x0184
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0032
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0022:
            if (r3 >= r1) goto L_0x0013
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0013
            int r3 = r3 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0022
        L_0x0032:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 128(0x80, float:1.794E-43)
            r9 = 0
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x006b
            int r5 = r3 + 1
            if (r1 > r5) goto L_0x004b
        L_0x0042:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
        L_0x0049:
            r7 = r11
            goto L_0x0069
        L_0x004b:
            byte r5 = r0[r5]
            r6 = r5 & 192(0xc0, float:2.69E-43)
            if (r6 != r8) goto L_0x0052
            r9 = r11
        L_0x0052:
            if (r9 != 0) goto L_0x0055
            goto L_0x0042
        L_0x0055:
            r5 = r5 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r4 = r4 ^ r5
            if (r4 >= r8) goto L_0x0061
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            goto L_0x0065
        L_0x0061:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0065:
            r2.invoke(r4)
        L_0x0068:
            r7 = 2
        L_0x0069:
            int r3 = r3 + r7
            goto L_0x0013
        L_0x006b:
            int r5 = r4 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00dc
            int r5 = r3 + 2
            if (r1 > r5) goto L_0x008f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x0049
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x008c
            r9 = r11
        L_0x008c:
            if (r9 != 0) goto L_0x0068
            goto L_0x0049
        L_0x008f:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x0099
            r15 = r11
            goto L_0x009a
        L_0x0099:
            r15 = r9
        L_0x009a:
            if (r15 != 0) goto L_0x00a4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0049
        L_0x00a4:
            byte r5 = r0[r5]
            r15 = r5 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x00ac
            r8 = r11
            goto L_0x00ad
        L_0x00ac:
            r8 = r9
        L_0x00ad:
            if (r8 != 0) goto L_0x00b7
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0068
        L_0x00b7:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r5 = r5 ^ r7
            int r6 = r6 << 6
            r5 = r5 ^ r6
            int r4 = r4 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00cd
        L_0x00c5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x00c9:
            r2.invoke(r4)
            goto L_0x00da
        L_0x00cd:
            if (r13 > r4) goto L_0x00d2
            if (r4 >= r12) goto L_0x00d2
            r9 = r11
        L_0x00d2:
            if (r9 == 0) goto L_0x00d5
            goto L_0x00c5
        L_0x00d5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00c9
        L_0x00da:
            r7 = r14
            goto L_0x0069
        L_0x00dc:
            int r5 = r4 >> 3
            if (r5 != r6) goto L_0x0179
            int r5 = r3 + 3
            if (r1 > r5) goto L_0x010b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x0049
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x00f7
            r4 = r11
            goto L_0x00f8
        L_0x00f7:
            r4 = r9
        L_0x00f8:
            if (r4 != 0) goto L_0x00fc
            goto L_0x0049
        L_0x00fc:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x0068
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0107
            r9 = r11
        L_0x0107:
            if (r9 != 0) goto L_0x00da
            goto L_0x0068
        L_0x010b:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x0115
            r15 = r11
            goto L_0x0116
        L_0x0115:
            r15 = r9
        L_0x0116:
            if (r15 != 0) goto L_0x0121
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0049
        L_0x0121:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x012b
            r7 = r11
            goto L_0x012c
        L_0x012b:
            r7 = r9
        L_0x012c:
            if (r7 != 0) goto L_0x0137
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0068
        L_0x0137:
            byte r5 = r0[r5]
            r7 = r5 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x013f
            r7 = r11
            goto L_0x0140
        L_0x013f:
            r7 = r9
        L_0x0140:
            if (r7 != 0) goto L_0x014a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00da
        L_0x014a:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r5 = r5 ^ r7
            int r7 = r15 << 6
            r5 = r5 ^ r7
            int r6 = r6 << 12
            r5 = r5 ^ r6
            int r4 = r4 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0164
        L_0x015c:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x0160:
            r2.invoke(r4)
            goto L_0x0176
        L_0x0164:
            if (r13 > r4) goto L_0x0169
            if (r4 >= r12) goto L_0x0169
            r9 = r11
        L_0x0169:
            if (r9 == 0) goto L_0x016c
            goto L_0x015c
        L_0x016c:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0171
            goto L_0x015c
        L_0x0171:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0160
        L_0x0176:
            r7 = 4
            goto L_0x0069
        L_0x0179:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0184:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        if (r9 == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0109, code lost:
        if (r9 == false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0013:
            if (r3 >= r1) goto L_0x019f
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0034
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0023:
            if (r3 >= r1) goto L_0x0013
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0013
            int r3 = r3 + 1
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0023
        L_0x0034:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 128(0x80, float:1.794E-43)
            r9 = 0
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x006c
            int r5 = r3 + 1
            if (r1 > r5) goto L_0x004e
        L_0x0044:
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x004c:
            r7 = r11
            goto L_0x006a
        L_0x004e:
            byte r5 = r0[r5]
            r6 = r5 & 192(0xc0, float:2.69E-43)
            if (r6 != r8) goto L_0x0055
            r9 = r11
        L_0x0055:
            if (r9 != 0) goto L_0x0058
            goto L_0x0044
        L_0x0058:
            r5 = r5 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r4 = r4 ^ r5
            if (r4 >= r8) goto L_0x0061
            char r4 = (char) r10
            goto L_0x0062
        L_0x0061:
            char r4 = (char) r4
        L_0x0062:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x0069:
            r7 = 2
        L_0x006a:
            int r3 = r3 + r7
            goto L_0x0013
        L_0x006c:
            int r5 = r4 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00de
            int r5 = r3 + 2
            if (r1 > r5) goto L_0x0091
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x008e
            r9 = r11
        L_0x008e:
            if (r9 != 0) goto L_0x0069
            goto L_0x004c
        L_0x0091:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x009b
            r15 = r11
            goto L_0x009c
        L_0x009b:
            r15 = r9
        L_0x009c:
            if (r15 != 0) goto L_0x00a7
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x004c
        L_0x00a7:
            byte r5 = r0[r5]
            r15 = r5 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x00af
            r8 = r11
            goto L_0x00b0
        L_0x00af:
            r8 = r9
        L_0x00b0:
            if (r8 != 0) goto L_0x00bb
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0069
        L_0x00bb:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r5 = r5 ^ r7
            int r6 = r6 << 6
            r5 = r5 ^ r6
            int r4 = r4 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d2
        L_0x00c9:
            char r4 = (char) r10
        L_0x00ca:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x00dc
        L_0x00d2:
            if (r13 > r4) goto L_0x00d7
            if (r4 >= r12) goto L_0x00d7
            r9 = r11
        L_0x00d7:
            if (r9 == 0) goto L_0x00da
            goto L_0x00c9
        L_0x00da:
            char r4 = (char) r4
            goto L_0x00ca
        L_0x00dc:
            r7 = r14
            goto L_0x006a
        L_0x00de:
            int r5 = r4 >> 3
            if (r5 != r6) goto L_0x0194
            int r5 = r3 + 3
            if (r1 > r5) goto L_0x010d
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x00f9
            r4 = r11
            goto L_0x00fa
        L_0x00f9:
            r4 = r9
        L_0x00fa:
            if (r4 != 0) goto L_0x00fe
            goto L_0x004c
        L_0x00fe:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x0069
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0109
            r9 = r11
        L_0x0109:
            if (r9 != 0) goto L_0x00dc
            goto L_0x0069
        L_0x010d:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x0117
            r15 = r11
            goto L_0x0118
        L_0x0117:
            r15 = r9
        L_0x0118:
            if (r15 != 0) goto L_0x0123
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004c
        L_0x0123:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x012d
            r7 = r11
            goto L_0x012e
        L_0x012d:
            r7 = r9
        L_0x012e:
            if (r7 != 0) goto L_0x0139
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0069
        L_0x0139:
            byte r5 = r0[r5]
            r7 = r5 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x0141
            r7 = r11
            goto L_0x0142
        L_0x0141:
            r7 = r9
        L_0x0142:
            if (r7 != 0) goto L_0x014c
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00dc
        L_0x014c:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r5 = r5 ^ r7
            int r7 = r15 << 6
            r5 = r5 ^ r7
            int r6 = r6 << 12
            r5 = r5 ^ r6
            int r4 = r4 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0166
        L_0x015e:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0191
        L_0x0166:
            if (r13 > r4) goto L_0x016b
            if (r4 >= r12) goto L_0x016b
            r9 = r11
        L_0x016b:
            if (r9 == 0) goto L_0x016e
            goto L_0x015e
        L_0x016e:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0173
            goto L_0x015e
        L_0x0173:
            if (r4 == r10) goto L_0x015e
            int r5 = r4 >>> 10
            r6 = 55232(0xd7c0, float:7.7397E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r2.invoke(r5)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            r5 = 56320(0xdc00, float:7.8921E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x0191:
            r7 = 4
            goto L_0x006a
        L_0x0194:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0013
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = (b2 ^ 3968) ^ (b << 6);
        if (b3 < 128) {
            function1.invoke(valueOf);
            return 2;
        }
        function1.invoke(Integer.valueOf(b3));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 2;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i3];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b4 = ((b3 ^ -123008) ^ (b2 << 6)) ^ (b << Ascii.FF);
        if (b4 < 2048) {
            function1.invoke(valueOf);
            return 3;
        }
        if (55296 <= b4 && b4 < 57344) {
            z = true;
        }
        if (z) {
            function1.invoke(valueOf);
            return 3;
        }
        function1.invoke(Integer.valueOf(b4));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 3;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b4 = bArr[i3];
        if (!((b4 & 192) == 128)) {
            function1.invoke(valueOf);
            return 3;
        }
        byte b5 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << Ascii.FF)) ^ (b << Ascii.DC2);
        if (b5 > 1114111) {
            function1.invoke(valueOf);
            return 4;
        }
        if (55296 <= b5 && b5 < 57344) {
            z = true;
        }
        if (z) {
            function1.invoke(valueOf);
            return 4;
        } else if (b5 < 65536) {
            function1.invoke(valueOf);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(b5));
            return 4;
        }
    }
}
