package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.Intrinsics;

public final class AFf1fSDK implements AFf1bSDK {
    public final String AFInAppEventType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String format = String.format(str, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()});
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
