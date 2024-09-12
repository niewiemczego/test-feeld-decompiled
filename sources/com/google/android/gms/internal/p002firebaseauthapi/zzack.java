package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzack {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            zza = Boolean.valueOf(isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2);
        }
        return zza.booleanValue();
    }
}
