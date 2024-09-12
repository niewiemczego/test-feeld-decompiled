package okio;

import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\r"}, d2 = {"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -Base64.kt */
public final class _Base64Kt {
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "<this>");
        int length = str.length();
        while (length > 0 && ((r6 = str2.charAt(length - 1)) == '=' || r6 == 10 || r6 == 13 || r6 == ' ' || r6 == 9)) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i3 < length) {
                char charAt = str2.charAt(i3);
                if ('A' <= charAt && charAt < '[') {
                    i = charAt - 'A';
                } else {
                    if ('a' <= charAt && charAt < '{') {
                        i = charAt - 'G';
                    } else {
                        if ('0' > charAt || charAt >= ':') {
                            z = false;
                        }
                        if (z) {
                            i = charAt + 4;
                        } else if (charAt == '+' || charAt == '-') {
                            i = 62;
                        } else if (charAt == '/' || charAt == '_') {
                            i = 63;
                        } else {
                            if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                                return null;
                            }
                            i3++;
                        }
                    }
                }
                i5 = (i5 << 6) | i;
                i4++;
                if (i4 % 4 == 0) {
                    int i7 = i6 + 1;
                    bArr[i6] = (byte) (i5 >> 16);
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (i5 >> 8);
                    bArr[i8] = (byte) i5;
                    i6 = i8 + 1;
                }
                i3++;
            } else {
                int i9 = i4 % 4;
                if (i9 == 1) {
                    return null;
                }
                if (i9 == 2) {
                    bArr[i6] = (byte) ((i5 << 12) >> 16);
                    i6++;
                } else if (i9 == 3) {
                    int i10 = i5 << 6;
                    int i11 = i6 + 1;
                    bArr[i6] = (byte) (i10 >> 16);
                    i6 = i11 + 1;
                    bArr[i11] = (byte) (i10 >> 8);
                }
                if (i6 == i2) {
                    return bArr;
                }
                byte[] copyOf = Arrays.copyOf(bArr, i6);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
        }
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr2, AdaptyImmutableMapTypeAdapterFactory.MAP);
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b = bArr[i];
            int i4 = i3 + 1;
            byte b2 = bArr[i3];
            int i5 = i4 + 1;
            byte b3 = bArr[i4];
            int i6 = i2 + 1;
            bArr3[i2] = bArr2[(b & 255) >> 2];
            int i7 = i6 + 1;
            bArr3[i6] = bArr2[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b2 & Ascii.SI) << 2) | ((b3 & 255) >> 6)];
            i2 = i8 + 1;
            bArr3[i8] = bArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(b4 & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr3[i10] = b5;
            bArr3[i10 + 1] = b5;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b6 = bArr[i];
            byte b7 = bArr[i11];
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(b6 & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr3[i13] = bArr2[(b7 & Ascii.SI) << 2];
            bArr3[i13 + 1] = (byte) 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr3);
    }
}
