package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzcc {
    public static final int zza;
    private static final int zzb = (Build.VERSION.SDK_INT >= 23 ? 67108864 : 0);

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }

    static {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            i = 33554432;
        }
        zza = i;
    }
}
