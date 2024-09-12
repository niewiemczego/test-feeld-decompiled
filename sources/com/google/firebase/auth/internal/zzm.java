package com.google.firebase.auth.internal;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzm extends zzi {
    private String zza;
    private String zzb;
    private String zzc;

    public final zzi zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzi zzb(String str) {
        this.zzc = str;
        return this;
    }

    public final zzi zzc(String str) {
        this.zza = str;
        return this;
    }

    public final zzj zza() {
        return new zzn(this.zza, this.zzb, this.zzc);
    }

    zzm() {
    }
}
