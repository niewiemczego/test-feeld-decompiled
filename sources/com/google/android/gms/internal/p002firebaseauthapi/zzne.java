package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzne  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzne extends zzci {
    private final zzos zza;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza.zza(), this.zza.zzb()});
    }

    public final zzos zzb() {
        return this.zza;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zza().zzf();
        int i = zznh.zza[this.zza.zza().zzd().ordinal()];
        objArr[1] = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public zzne(zzos zzos) {
        this.zza = zzos;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzne)) {
            return false;
        }
        zzos zzos = ((zzne) obj).zza;
        if (!this.zza.zza().zzd().equals(zzos.zza().zzd()) || !this.zza.zza().zzf().equals(zzos.zza().zzf()) || !this.zza.zza().zze().equals(zzos.zza().zze())) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zza.zza().zzd() != zzvt.RAW;
    }
}
