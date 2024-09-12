package com.appsflyer.internal;

public final class AFg1sSDK {
    public static int AFInAppEventParameterName;
    public static int AFInAppEventType;
    public static final Object AFKeystoreWrapper = new Object();

    public static char[] AFInAppEventParameterName(long j, char[] cArr, int i) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i2 = 4;
        int i3 = 0;
        for (int i4 = 0; i4 < cArr.length; i4++) {
            if ((((j >>> i4) & 1) != ((long) i) || i3 >= 4) && i2 < length) {
                cArr2[i2] = cArr[i4];
                i2++;
            } else {
                cArr2[i3] = cArr[i4];
                i3++;
            }
        }
        return cArr2;
    }
}
