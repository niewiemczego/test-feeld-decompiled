package com.appsflyer.internal;

public final class AFg1qSDK {
    public static int AFInAppEventType;
    public static int AFKeystoreWrapper;
    public static final Object valueOf = new Object();
    public static int values;

    public static void valueOf(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int AFInAppEventParameterName(int i) {
        AFf1eSDK aFf1eSDK = AFf1eSDK.AFInAppEventType;
        return ((aFf1eSDK.AFInAppEventParameterName[0][i >>> 24] + aFf1eSDK.AFInAppEventParameterName[1][(i >>> 16) & 255]) ^ aFf1eSDK.AFInAppEventParameterName[2][(i >>> 8) & 255]) + aFf1eSDK.AFInAppEventParameterName[3][i & 255];
    }
}
