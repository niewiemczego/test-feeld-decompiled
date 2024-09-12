package com.reactnativecommunity.netinfo;

import android.content.Context;
import androidx.core.content.ContextCompat;

public class NetInfoUtils {
    public static void reverseByteArray(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - i) - 1];
            bArr[(bArr.length - i) - 1] = b;
        }
    }

    public static boolean isAccessWifiStatePermissionGranted(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_WIFI_STATE") == 0;
    }
}
