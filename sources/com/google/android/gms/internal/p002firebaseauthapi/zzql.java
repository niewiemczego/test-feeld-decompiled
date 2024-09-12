package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzql  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzql extends zzna<zzuf, zzue> {
    private final /* synthetic */ zzqe zza;

    public final /* synthetic */ zzakk zza(zzakk zzakk) throws GeneralSecurityException {
        zzuf zzuf = (zzuf) zzakk;
        return (zzue) ((zzaja) zzue.zzb().zza(zzqe.zzh()).zza(zzuf.zzf()).zza(zzahm.zza(zzov.zza(zzuf.zza()))).zzf());
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzuf.zza(zzahm, zzaip.zza());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzql(zzqe zzqe, Class cls) {
        super(cls);
        this.zza = zzqe;
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzuf zzuf = (zzuf) zzakk;
        if (zzuf.zza() >= 16) {
            zzqe.zzb(zzuf.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
