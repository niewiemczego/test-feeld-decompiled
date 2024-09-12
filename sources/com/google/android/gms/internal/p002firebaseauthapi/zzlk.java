package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlk extends zzoq<zzut, zzuw> {
    public final zzic.zza zza() {
        return zzic.zza.ALGORITHM_NOT_FIPS;
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final zzna<zzuo, zzut> zzb() {
        return new zzlm(this, zzuo.class);
    }

    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzakk zza(zzakk zzakk) throws GeneralSecurityException {
        return ((zzut) zzakk).zzd();
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzut.zza(zzahm, zzaip.zza());
    }

    public zzlk() {
        super(zzut.class, zzuw.class, new zzlj(zzbp.class));
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzut zzut = (zzut) zzakk;
        if (zzut.zze().zze()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (zzut.zzf()) {
            zzxq.zza(zzut.zza(), 0);
            zzlq.zza(zzut.zzd().zzb());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }
}
