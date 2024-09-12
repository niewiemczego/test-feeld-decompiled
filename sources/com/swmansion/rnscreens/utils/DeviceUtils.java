package com.swmansion.rnscreens.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/utils/DeviceUtils;", "", "()V", "isPlatformAndroidTV", "", "context", "Landroid/content/Context;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceUtils.kt */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    private DeviceUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r4 = r4.getPackageManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPlatformAndroidTV(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0013
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            if (r4 == 0) goto L_0x0013
            java.lang.String r2 = "android.software.leanback"
            boolean r4 = r4.hasSystemFeature(r2)
            if (r4 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.utils.DeviceUtils.isPlatformAndroidTV(android.content.Context):boolean");
    }
}
