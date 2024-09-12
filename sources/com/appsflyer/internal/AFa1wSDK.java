package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1zSDK;
import com.braze.Constants;

public final class AFa1wSDK implements AFc1zSDK {
    private static IntentFilter AFInAppEventType = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public final AFc1zSDK.AFa1vSDK AFInAppEventType(Context context) {
        String str = null;
        float f = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, AFInAppEventType);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : Constants.BRAZE_PUSH_ACCENT_KEY;
                } else {
                    str = SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO;
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("Device that failed to register receiver", th);
        }
        return new AFc1zSDK.AFa1vSDK(f, str);
    }
}
