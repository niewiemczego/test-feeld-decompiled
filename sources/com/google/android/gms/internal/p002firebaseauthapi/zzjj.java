package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzjj extends zznb<zztt> {
    public final zzic.zza zza() {
        return zzic.zza.ALGORITHM_NOT_FIPS;
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzux.zzb zzc() {
        return zzux.zzb.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zztt.zza(zzahm, zzaip.zza());
    }

    public zzjj() {
        super(zztt.class, new zzji(zzbs.class));
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zztt zztt = (zztt) zzakk;
        zzxq.zza(zztt.zza(), 0);
        zzku.zza(zztt.zzb());
    }
}
