package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzadw implements Runnable {
    private /* synthetic */ zzadt zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzadw(zzadt zzadt, String str) {
        this.zza = zzadt;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
