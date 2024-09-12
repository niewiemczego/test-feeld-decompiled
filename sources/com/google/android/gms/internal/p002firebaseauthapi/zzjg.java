package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzjg extends zzna<zzto, zzts> {
    private final /* synthetic */ zzje zza;

    public final /* synthetic */ zzakk zza(zzakk zzakk) throws GeneralSecurityException {
        zzto zzto = (zzto) zzakk;
        ECParameterSpec zza2 = zzwn.zza(zzku.zza(zzto.zzc().zzf().zzd()));
        KeyPairGenerator zza3 = zzwr.zzd.zza("EC");
        zza3.initialize(zza2);
        KeyPair generateKeyPair = zza3.generateKeyPair();
        ECPoint w = ((ECPublicKey) generateKeyPair.getPublic()).getW();
        return (zzts) ((zzaja) zzts.zzb().zza(0).zza((zztt) ((zzaja) zztt.zzc().zza(0).zza(zzto.zzc()).zza(zzahm.zza(w.getAffineX().toByteArray())).zzb(zzahm.zza(w.getAffineY().toByteArray())).zzf())).zza(zzahm.zza(((ECPrivateKey) generateKeyPair.getPrivate()).getS().toByteArray())).zzf());
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzto.zza(zzahm, zzaip.zza());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjg(zzje zzje, Class cls) {
        super(cls);
        this.zza = zzje;
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzku.zza(((zzto) zzakk).zzc());
    }
}
