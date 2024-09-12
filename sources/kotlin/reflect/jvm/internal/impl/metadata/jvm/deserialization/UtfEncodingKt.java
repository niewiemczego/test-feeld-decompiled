package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: utfEncoding.kt */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "strings");
        int i = 0;
        for (String length : strArr) {
            i += length.length();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (String str : strArr) {
            int length2 = str.length();
            int i3 = 0;
            while (i3 < length2) {
                bArr[i2] = (byte) str.charAt(i3);
                i3++;
                i2++;
            }
        }
        return bArr;
    }
}
