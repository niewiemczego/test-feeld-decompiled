package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzji  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzji extends zzoi<zzbs, zztt> {
    public final /* synthetic */ Object zza(zzakk zzakk) throws GeneralSecurityException {
        zztt zztt = (zztt) zzakk;
        zztp zzb = zztt.zzb();
        zztw zzf = zzb.zzf();
        zzwq zza = zzku.zza(zzf.zzd());
        byte[] zzg = zztt.zzf().zzg();
        byte[] zzg2 = zztt.zzg().zzg();
        ECParameterSpec zza2 = zzwn.zza(zza);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzg), new BigInteger(1, zzg2));
        zzmd.zza(eCPoint, zza2.getCurve());
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zza2);
        return new zzwm((ECPublicKey) zzwr.zze.zza("EC").generatePublic(eCPublicKeySpec), zzf.zzf().zzg(), zzku.zza(zzf.zze()), zzku.zza(zzb.zza()), new zzkw(zzb.zzb().zzd()));
    }

    zzji(Class cls) {
        super(cls);
    }
}
