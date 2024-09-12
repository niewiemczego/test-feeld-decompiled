package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzru  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzru {
    private final zzbw zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    public final int zza() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    private zzru(zzbw zzbw, int i, String str, String str2) {
        this.zza = zzbw;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzru)) {
            return false;
        }
        zzru zzru = (zzru) obj;
        if (this.zza != zzru.zza || this.zzb != zzru.zzb || !this.zzc.equals(zzru.zzc) || !this.zzd.equals(zzru.zzd)) {
            return false;
        }
        return true;
    }
}
