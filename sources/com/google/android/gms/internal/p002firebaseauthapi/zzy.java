package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzy {
    private static final zzv zza = new zzx();

    static zzs zza(String str) {
        zzz.zza(str);
        return zza.zza(str);
    }

    static String zzc(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    @CheckForNull
    static String zzb(@CheckForNull String str) {
        if (zzd(str)) {
            return null;
        }
        return str;
    }

    static boolean zzd(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
