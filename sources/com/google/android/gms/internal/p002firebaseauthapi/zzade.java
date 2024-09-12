package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzade  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzade implements Runnable {
    private final /* synthetic */ zzadd zza;
    private final /* synthetic */ zzacy zzb;

    zzade(zzacy zzacy, zzadd zzadd) {
        this.zza = zzadd;
        this.zzb = zzacy;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
