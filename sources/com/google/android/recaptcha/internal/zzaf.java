package com.google.android.recaptcha.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzaf {
    public static final zzaf zza = new zzaf();
    private static final String zzb = String.valueOf(Build.VERSION.SDK_INT);
    private static final GoogleApiAvailabilityLight zzc = GoogleApiAvailabilityLight.getInstance();

    private zzaf() {
    }

    public static final String zza(Context context) {
        int isGooglePlayServicesAvailable = zzc.isGooglePlayServicesAvailable(context);
        return (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 3 || isGooglePlayServicesAvailable == 9) ? "ANDROID_OFFPLAY" : "ANDROID_ONPLAY";
    }
}
