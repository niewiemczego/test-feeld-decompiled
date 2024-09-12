package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaio  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaio {
    private final Object zza;
    private final int zzb;

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }

    zzaio(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaio)) {
            return false;
        }
        zzaio zzaio = (zzaio) obj;
        if (this.zza == zzaio.zza && this.zzb == zzaio.zzb) {
            return true;
        }
        return false;
    }
}
