package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzdn {
    public static zzdj zza(zzdj zzdj) {
        if ((zzdj instanceof zzdl) || (zzdj instanceof zzdk)) {
            return zzdj;
        }
        if (zzdj instanceof Serializable) {
            return new zzdk(zzdj);
        }
        return new zzdl(zzdj);
    }

    public static zzdj zzb(Object obj) {
        return new zzdm(obj);
    }
}
