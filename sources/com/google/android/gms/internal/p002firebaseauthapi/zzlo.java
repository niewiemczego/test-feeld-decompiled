package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlo extends zznb<zzuw> {
    public final zzic.zza zza() {
        return zzic.zza.ALGORITHM_NOT_FIPS;
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzuw.zza(zzahm, zzaip.zza());
    }

    public zzlo() {
        super(zzuw.class, new zzln(zzbs.class));
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzuw zzuw = (zzuw) zzakk;
        zzxq.zza(zzuw.zza(), 0);
        if (zzuw.zzg()) {
            zzlq.zza(zzuw.zzb());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }
}
