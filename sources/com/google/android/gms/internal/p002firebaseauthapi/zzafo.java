package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzafo {
    public static long zza(String str) {
        zzafn zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzafn zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zza = zzac.zza('.').zza((CharSequence) str);
        if (zza.size() >= 2) {
            try {
                return zzafn.zza(new String(Base64Utils.decodeUrlSafeNoPadding(zza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unable to decode token", e);
            }
        } else {
            throw new RuntimeException("Invalid idToken " + str);
        }
    }
}
