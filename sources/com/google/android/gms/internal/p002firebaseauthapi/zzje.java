package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzje  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzje extends zzoq<zzts, zztt> {
    public final zzic.zza zza() {
        return zzic.zza.ALGORITHM_NOT_FIPS;
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzna<zzto, zzts> zzb() {
        return new zzjg(this, zzto.class);
    }

    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PRIVATE;
    }

    public final /* synthetic */ zzakk zza(zzakk zzakk) throws GeneralSecurityException {
        return ((zzts) zzakk).zzd();
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzts.zza(zzahm, zzaip.zza());
    }

    zzje() {
        super(zzts.class, zztt.class, new zzjh(zzbp.class));
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzts zzts = (zzts) zzakk;
        if (!zzts.zze().zze()) {
            zzxq.zza(zzts.zza(), 0);
            zzku.zza(zzts.zzd().zzb());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }
}
